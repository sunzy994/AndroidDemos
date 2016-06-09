package com.oppo.unreaderloader;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.CallLog.Calls;
import android.provider.Settings.System;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import com.android.BadgeProvider.BadgeItems;
import com.android.internal.util.XmlUtils;
import com.oppo.launcher.ApplicationInfo;
import com.oppo.launcher.LauncherUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class OPPOUnreadLoader
{
  private static final String BADGE_USER = "badge_user";
  private static final String BROWSER_READER_APPNAME = "BrowserReader";
  private static final boolean DEBUG_NORMAL = false;
  private static final boolean DEBUG_PERFORMANCE = false;
  private static final boolean DEBUG_UNREAD = LauncherUtil.LAUNCHER_QE_ASSERT_DEBUG;
  private static final String DOCUMENT_UNREADSHORTCUTS = "unreadshortcuts";
  private static final String EMAIL_APPNAME = "email";
  private static final String MARKET_APPNAME = "market";
  private static final String MMS_APPNAME = "mms";
  private static final String NOTIFICATION_USER = "notification_user";
  private static final String OPPO_COMMUNITY_APPNAME = "OppoCommunity";
  private static final String OPPO_MISSED_CALL_SETTING = "oppo.missed.calls.number";
  private static final String OPPO_MISSED_SMS_SETTING = "oppo.unread.mms.number";
  private static final String OPPO_READER_APPNAME = "OppoReader";
  private static final String PACKAGE_NAME = "pkg";
  private static final String PHONE_APPNAME = "phone";
  private static final Uri POWERS_URI;
  private static final String SECURESAFE_APPNAME = "securesafe";
  private static final String SETTINGS_APPNAME = "SettingsApplication";
  private static final int SWITCH_ON = 1;
  private static final String TAG = "OPPOUnreadLoader";
  private static final String TAG_UNREADSHORTCUTS = "shortcut";
  private static final String TAG_UNREADSHORTCUTS_APPNAME = "appName";
  private static final String TAG_UNREADSHORTCUTS_CLASSNAME = "unreadClassName";
  private static final String TAG_UNREADSHORTCUTS_NOTIFYFORDESCENDENTS = "notifyForDescendents";
  private static final String TAG_UNREADSHORTCUTS_PACKAGENAME = "unreadPackageName";
  private static final String TAG_UNREADSHORTCUTS_URI = "uri";
  private static final int TYPE_INCOMING_REJECTED = 10;
  private static final String UBEAUTY_APPNAME = "Ubeauty";
  private static final String USER_CENTER_APPNAME = "UserCenter";
  private static final String WPS_EMAIL_APPNAME = "WPSEmail";
  private static OPPOUnreadLoader mInstance;
  private static final Object mLogLock;
  private static final SpannableStringBuilder sExceedString = new SpannableStringBuilder("99+");
  private static final ArrayList<UnreadSupportShortcut> sUnreadSupportShortcuts = new ArrayList();
  private final String VERSION_CODE = "00006";
  private Object mBadgeProviderObject = new Object();
  private BaseContentObserver mBadgeProviderObserver;
  private Object mBadgeSwitchUpdateObject = new Object();
  private WeakReference<UnreadCallbacks> mCallbacks;
  private ContentResolver mContentResolver;
  private Context mContext;
  private final ContentObserver mUnReadAppSwitchObserver = new ContentObserver(new Handler())
  {
    public boolean deliverSelfNotifications()
    {
      return true;
    }

    public void onChange(boolean paramAnonymousBoolean)
    {
      if (OPPOUnreadLoader.this.sWorker == null)
        return;
      OPPOUnreadLoader.this.sWorker.removeCallbacksAndMessages(OPPOUnreadLoader.this.mBadgeSwitchUpdateObject);
      Message localMessage = Message.obtain(OPPOUnreadLoader.this.sWorker, new Runnable()
      {
        public void run()
        {
          OPPOUnreadLoader.this.updateUnreadNumberSwitch(true);
        }
      });
      localMessage.obj = OPPOUnreadLoader.this.mBadgeSwitchUpdateObject;
      OPPOUnreadLoader.this.sWorker.sendMessageDelayed(localMessage, 800L);
    }
  };
  private Handler sWorker = null;
  private HandlerThread sWorkerThread;

  static
  {
    mLogLock = new Object();
    POWERS_URI = Uri.parse("content://com.oppo.notification_center/powers");
    mInstance = null;
    sExceedString.setSpan(new SuperscriptSpan(), 2, 3, 33);
    sExceedString.setSpan(new AbsoluteSizeSpan(10), 2, 3, 33);
  }

  private OPPOUnreadLoader(Context paramContext)
  {
    this.mContext = paramContext;
    this.sWorkerThread = new HandlerThread("launcher-unreader-loader");
    this.sWorkerThread.start();
    this.sWorker = new Handler(this.sWorkerThread.getLooper());
    this.mContentResolver = this.mContext.getContentResolver();
    if (DEBUG_UNREAD)
      Log.i("OPPOUnreadLoader", "version code : 00006");
  }

  public static void clearUnreadNumForApplicationInfo(Context paramContext, ArrayList<ApplicationInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramContext == null))
      label8: return;
    else
      paramArrayList = paramArrayList.iterator();
    while (true)
    {
      if (!paramArrayList.hasNext())
        break label8;
      Object localObject = ((ApplicationInfo)paramArrayList.next()).packageName;
      if (localObject == null)
        break;
      localObject = getAllSupportUnreadComponentsForPackage((String)localObject).iterator();
      while (((Iterator)localObject).hasNext())
        clearUnreadNumForComponentName(paramContext, (ComponentName)((Iterator)localObject).next());
    }
  }

  public static void clearUnreadNumForComponentName(Context paramContext, ComponentName paramComponentName)
  {
    Object localObject1 = sUnreadSupportShortcuts.iterator();
    UnreadSupportShortcut localUnreadSupportShortcut;
    while (((Iterator)localObject1).hasNext())
    {
      localUnreadSupportShortcut = (UnreadSupportShortcut)((Iterator)localObject1).next();
      if ((localUnreadSupportShortcut.mComponent != null) && (localUnreadSupportShortcut.mComponent.equals(paramComponentName)))
        localUnreadSupportShortcut.mUnreadNum = 0;
    }
    if (paramContext == null);
    while (true)
    {
      return;
      localUnreadSupportShortcut = null;
      Object localObject2 = null;
      Object localObject3 = null;
      String str1 = paramComponentName.getPackageName();
      localObject1 = localUnreadSupportShortcut;
      paramComponentName = localObject2;
      try
      {
        String str2 = paramContext.getDatabasePath("badge.db").getPath();
        paramContext = localObject3;
        if (str2 != null)
        {
          localObject1 = localUnreadSupportShortcut;
          paramComponentName = localObject2;
          paramContext = SQLiteDatabase.openDatabase(str2, null, 0);
          localObject1 = paramContext;
          paramComponentName = paramContext;
          paramContext.beginTransaction();
          localObject1 = paramContext;
          paramComponentName = paramContext;
          paramContext.delete("badge", "app_package_name = ?", new String[] { str1 });
          localObject1 = paramContext;
          paramComponentName = paramContext;
          paramContext.setTransactionSuccessful();
        }
        return;
      }
      catch (Exception paramContext)
      {
        paramComponentName = (ComponentName)localObject1;
        Log.e("OPPOUnreadLoader", "clearUnreadNumForComponentName --- e = " + paramContext);
        if (localObject1 != null)
        {
          ((SQLiteDatabase)localObject1).endTransaction();
          ((SQLiteDatabase)localObject1).close();
          return;
        }
      }
      finally
      {
        if (paramComponentName != null)
        {
          paramComponentName.endTransaction();
          paramComponentName.close();
        }
      }
    }
    throw paramContext;
  }

  private void closeCursor(Cursor paramCursor)
  {
    if (paramCursor != null);
    try
    {
      paramCursor.close();
      return;
    }
    catch (IllegalStateException paramCursor)
    {
    }
    catch (Exception paramCursor)
    {
    }
  }

  private void closeInputStream(InputStream paramInputStream)
  {
    if (paramInputStream != null);
    try
    {
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream)
    {
    }
  }

  public static ArrayList<ComponentName> getAllSupportUnreadComponentsForPackage(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = sUnreadSupportShortcuts.iterator();
    while (localIterator.hasNext())
    {
      UnreadSupportShortcut localUnreadSupportShortcut = (UnreadSupportShortcut)localIterator.next();
      if ((localUnreadSupportShortcut.mComponent != null) && (localUnreadSupportShortcut.mComponent.getPackageName().equals(paramString)))
        localArrayList.add(localUnreadSupportShortcut.mComponent);
    }
    return localArrayList;
  }

  // ERROR //
  private int getBadgeUnreadCount(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 216	com/oppo/unreaderloader/OPPOUnreadLoader:mContext	Landroid/content/Context;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +11 -> 19
    //   11: iconst_0
    //   12: istore 6
    //   14: aload_0
    //   15: monitorexit
    //   16: iload 6
    //   18: ireturn
    //   19: iconst_0
    //   20: istore 8
    //   22: iconst_0
    //   23: istore 7
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore_2
    //   30: aconst_null
    //   31: astore_3
    //   32: aload_0
    //   33: getfield 216	com/oppo/unreaderloader/OPPOUnreadLoader:mContext	Landroid/content/Context;
    //   36: invokevirtual 241	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   39: getstatic 429	com/android/BadgeProvider$BadgeItems:CONTENT_URI	Landroid/net/Uri;
    //   42: iconst_1
    //   43: anewarray 370	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: ldc_w 431
    //   51: aastore
    //   52: ldc_w 368
    //   55: iconst_1
    //   56: anewarray 370	java/lang/String
    //   59: dup
    //   60: iconst_0
    //   61: aload_1
    //   62: aastore
    //   63: aconst_null
    //   64: invokevirtual 437	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_1
    //   68: iload 8
    //   70: istore 6
    //   72: aload_1
    //   73: ifnull +113 -> 186
    //   76: iload 8
    //   78: istore 6
    //   80: aload_1
    //   81: astore_3
    //   82: aload_1
    //   83: astore 4
    //   85: aload_1
    //   86: astore_2
    //   87: aload_1
    //   88: invokeinterface 441 1 0
    //   93: ifle +93 -> 186
    //   96: aload_1
    //   97: astore_3
    //   98: aload_1
    //   99: astore 4
    //   101: aload_1
    //   102: astore_2
    //   103: aload_0
    //   104: getfield 255	com/oppo/unreaderloader/OPPOUnreadLoader:mCallbacks	Ljava/lang/ref/WeakReference;
    //   107: invokevirtual 446	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   110: checkcast 17	com/oppo/unreaderloader/OPPOUnreadLoader$UnreadCallbacks
    //   113: astore 5
    //   115: aload 5
    //   117: ifnonnull +14 -> 131
    //   120: aload_0
    //   121: aload_1
    //   122: invokespecial 448	com/oppo/unreaderloader/OPPOUnreadLoader:closeCursor	(Landroid/database/Cursor;)V
    //   125: iconst_0
    //   126: istore 6
    //   128: goto -114 -> 14
    //   131: aload_1
    //   132: astore_3
    //   133: aload_1
    //   134: astore 4
    //   136: aload_1
    //   137: astore_2
    //   138: aload_1
    //   139: ldc_w 431
    //   142: invokeinterface 451 2 0
    //   147: istore 9
    //   149: iload 8
    //   151: istore 6
    //   153: aload_1
    //   154: astore_3
    //   155: aload_1
    //   156: astore 4
    //   158: aload_1
    //   159: astore_2
    //   160: aload_1
    //   161: invokeinterface 454 1 0
    //   166: ifeq +20 -> 186
    //   169: aload_1
    //   170: astore_3
    //   171: aload_1
    //   172: astore 4
    //   174: aload_1
    //   175: astore_2
    //   176: aload_1
    //   177: iload 9
    //   179: invokeinterface 458 2 0
    //   184: istore 6
    //   186: aload_0
    //   187: aload_1
    //   188: invokespecial 448	com/oppo/unreaderloader/OPPOUnreadLoader:closeCursor	(Landroid/database/Cursor;)V
    //   191: goto -177 -> 14
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: aload_3
    //   201: astore_2
    //   202: ldc 86
    //   204: ldc_w 460
    //   207: invokestatic 463	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   210: pop
    //   211: aload_0
    //   212: aload_3
    //   213: invokespecial 448	com/oppo/unreaderloader/OPPOUnreadLoader:closeCursor	(Landroid/database/Cursor;)V
    //   216: iload 7
    //   218: istore 6
    //   220: goto -206 -> 14
    //   223: astore_1
    //   224: aload 4
    //   226: astore_2
    //   227: ldc 86
    //   229: new 385	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 465
    //   239: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_1
    //   243: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 398	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 401	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   252: pop
    //   253: aload_0
    //   254: aload 4
    //   256: invokespecial 448	com/oppo/unreaderloader/OPPOUnreadLoader:closeCursor	(Landroid/database/Cursor;)V
    //   259: iload 7
    //   261: istore 6
    //   263: goto -249 -> 14
    //   266: astore_1
    //   267: aload_0
    //   268: aload_2
    //   269: invokespecial 448	com/oppo/unreaderloader/OPPOUnreadLoader:closeCursor	(Landroid/database/Cursor;)V
    //   272: aload_1
    //   273: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	194	finally
    //   120	125	194	finally
    //   186	191	194	finally
    //   211	216	194	finally
    //   253	259	194	finally
    //   267	274	194	finally
    //   32	68	199	android/database/CursorIndexOutOfBoundsException
    //   87	96	199	android/database/CursorIndexOutOfBoundsException
    //   103	115	199	android/database/CursorIndexOutOfBoundsException
    //   138	149	199	android/database/CursorIndexOutOfBoundsException
    //   160	169	199	android/database/CursorIndexOutOfBoundsException
    //   176	186	199	android/database/CursorIndexOutOfBoundsException
    //   32	68	223	java/lang/SecurityException
    //   87	96	223	java/lang/SecurityException
    //   103	115	223	java/lang/SecurityException
    //   138	149	223	java/lang/SecurityException
    //   160	169	223	java/lang/SecurityException
    //   176	186	223	java/lang/SecurityException
    //   32	68	266	finally
    //   87	96	266	finally
    //   103	115	266	finally
    //   138	149	266	finally
    //   160	169	266	finally
    //   176	186	266	finally
    //   202	211	266	finally
    //   227	253	266	finally
  }

  private int getBrowserReaderUpdateCount()
  {
    int i = 0;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://com.oppo.browser.book/t_book_newest"), null, null, null, null);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        i = localCursor.getCount();
      }
      return i;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      Log.w("OPPOUnreadLoader", "Got Exception while getBrowserReaderUpdateCount, e = " + localException);
      return 0;
    }
    finally
    {
      closeCursor(localObject3);
    }
  }

  public static CharSequence getExceedText()
  {
    return sExceedString;
  }

  public static OPPOUnreadLoader getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null)
        mInstance = new OPPOUnreadLoader(paramContext);
      paramContext = mInstance;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  public static Object getMessageObj(ComponentName paramComponentName)
  {
    if (paramComponentName == null)
      return null;
    int i = 0;
    int j = sUnreadSupportShortcuts.size();
    while (i < j)
    {
      if (((UnreadSupportShortcut)sUnreadSupportShortcuts.get(i)).mComponent.equals(paramComponentName))
        return ((UnreadSupportShortcut)sUnreadSupportShortcuts.get(i)).mObject;
      i += 1;
    }
    return null;
  }

  private int getUbeautyUnreadCount()
  {
    int j = 0;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://com.oppo.ubeauty.provider.data/beauty_new_message"), null, null, null, null);
      int i = j;
      if (localCursor != null)
      {
        i = j;
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          i = localCursor.getInt(localCursor.getColumnIndexOrThrow("message_count"));
        }
      }
      return i;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      Log.w("OPPOUnreadLoader", "Got Exception while getUbeautyUnreadCount, e = " + localException);
      return 0;
    }
    finally
    {
      closeCursor(localObject3);
    }
  }

  private int getUnreadNum(UnreadSupportShortcut paramUnreadSupportShortcut)
  {
    int i;
    if (paramUnreadSupportShortcut == null)
    {
      Log.w("OPPOUnreadLoader", "getUnreadNum shortcut == null ");
      i = 0;
    }
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                int k;
                                do
                                {
                                  return i;
                                  k = 0;
                                  j = 0;
                                  if (!paramUnreadSupportShortcut.mHasBadgeProviderUri)
                                    break;
                                  i = j;
                                }
                                while (paramUnreadSupportShortcut.mComponent == null);
                                paramUnreadSupportShortcut = paramUnreadSupportShortcut.mComponent.getPackageName();
                                j = k;
                                if (paramUnreadSupportShortcut != null)
                                  j = getBadgeUnreadCount(paramUnreadSupportShortcut);
                                i = j;
                              }
                              while (!DEBUG_UNREAD);
                              Log.d("OPPOUnreadLoader", "getUnreadNum packageName = " + paramUnreadSupportShortcut + ", count = " + j);
                              return j;
                              i = j;
                            }
                            while (paramUnreadSupportShortcut.mAppName == null);
                            if (!paramUnreadSupportShortcut.mAppName.equals("mms"))
                              break;
                            j = getNewSmsCount() + getNewMmsCount();
                            i = j;
                          }
                          while (!DEBUG_UNREAD);
                          Log.d("OPPOUnreadLoader", "getUnreadNum MMScount = " + j);
                          return j;
                          if (!paramUnreadSupportShortcut.mAppName.equals("phone"))
                            break;
                          j = getMissedCallCount();
                          i = j;
                        }
                        while (!DEBUG_UNREAD);
                        Log.d("OPPOUnreadLoader", "getUnreadNum misscallcount = " + j);
                        return j;
                        if (!paramUnreadSupportShortcut.mAppName.equals("email"))
                          break;
                        j = getNewEmailCount();
                        i = j;
                      }
                      while (!DEBUG_UNREAD);
                      Log.d("OPPOUnreadLoader", "getUnreadNum newemailcount = " + j);
                      return j;
                      if (!paramUnreadSupportShortcut.mAppName.equals("market"))
                        break;
                      j = getNewUpdateCount();
                      i = j;
                    }
                    while (!DEBUG_UNREAD);
                    Log.d("OPPOUnreadLoader", "getUnreadNum updatecount = " + j);
                    return j;
                    if (!paramUnreadSupportShortcut.mAppName.equals("OppoCommunity"))
                      break;
                    j = getOppoCommunityCount();
                    i = j;
                  }
                  while (!DEBUG_UNREAD);
                  Log.d("OPPOUnreadLoader", "getUnreadNum OppoCommunitycount = " + j);
                  return j;
                  if (!paramUnreadSupportShortcut.mAppName.equals("OppoReader"))
                    break;
                  j = getUpdateBookCount();
                  i = j;
                }
                while (!DEBUG_UNREAD);
                Log.d("OPPOUnreadLoader", "getUnreadNum OppoReaderCount = " + j);
                return j;
                if (!paramUnreadSupportShortcut.mAppName.equals("SettingsApplication"))
                  break;
                j = getOTACount();
                i = j;
              }
              while (!DEBUG_UNREAD);
              Log.d("OPPOUnreadLoader", "getUnreadNum getOTACount = " + j);
              return j;
              if (!paramUnreadSupportShortcut.mAppName.equals("BrowserReader"))
                break;
              j = getBrowserReaderUpdateCount();
              i = j;
            }
            while (!DEBUG_UNREAD);
            Log.d("OPPOUnreadLoader", "getUnreadNum getBrowserReaderUpdateCount = " + j);
            return j;
            if (!paramUnreadSupportShortcut.mAppName.equals("WPSEmail"))
              break;
            j = getNewWPSEmailCount();
            i = j;
          }
          while (!DEBUG_UNREAD);
          Log.d("OPPOUnreadLoader", "getUnreadNum getNewWPSEmailCount = " + j);
          return j;
          if (!paramUnreadSupportShortcut.mAppName.equals("UserCenter"))
            break;
          j = getUserCenterUnreadCount();
          i = j;
        }
        while (!DEBUG_UNREAD);
        Log.d("OPPOUnreadLoader", "getUnreadNum getUserCenterUnreadCount = " + j);
        return j;
        i = j;
      }
      while (!paramUnreadSupportShortcut.mAppName.equals("Ubeauty"));
      j = getUbeautyUnreadCount();
      i = j;
    }
    while (!DEBUG_UNREAD);
    Log.d("OPPOUnreadLoader", "getUnreadNum getUbeautyUnreadCount = " + j);
    return j;
  }

  public static int getUnreadNumberAt(int paramInt)
  {
    if (paramInt >= 0);
    try
    {
      int i = sUnreadSupportShortcuts.size();
      if (paramInt >= i);
      for (paramInt = 0; ; paramInt = ((UnreadSupportShortcut)sUnreadSupportShortcuts.get(paramInt)).mUnreadNum)
      {
        return paramInt;
        if (DEBUG_UNREAD)
          Log.d("OPPOUnreadLoader", "getUnreadNumberAt: index = " + paramInt + getUnreadSupportShortcutInfo());
      }
    }
    finally
    {
    }
  }

  public static int getUnreadNumberOfComponent(ComponentName paramComponentName)
  {
    return getUnreadNumberAt(supportUnreadFeature(paramComponentName));
  }

  private static UnreadSupportShortcut getUnreadSupportShortcut(ComponentName paramComponentName)
  {
    Object localObject;
    if (paramComponentName == null)
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    int j = sUnreadSupportShortcuts.size();
    while (true)
    {
      if (i >= j)
        break label59;
      UnreadSupportShortcut localUnreadSupportShortcut = (UnreadSupportShortcut)sUnreadSupportShortcuts.get(i);
      if (localUnreadSupportShortcut != null)
      {
        localObject = localUnreadSupportShortcut;
        if (paramComponentName.equals(localUnreadSupportShortcut.mComponent))
          break;
      }
      i += 1;
    }
    label59: return null;
  }

  private static UnreadSupportShortcut getUnreadSupportShortcut(String paramString)
  {
    Object localObject;
    if ((sUnreadSupportShortcuts == null) || (paramString == null))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    int j = sUnreadSupportShortcuts.size();
    while (true)
    {
      if (i >= j)
        break label75;
      UnreadSupportShortcut localUnreadSupportShortcut = (UnreadSupportShortcut)sUnreadSupportShortcuts.get(i);
      if ((localUnreadSupportShortcut != null) && (localUnreadSupportShortcut.mComponent != null))
      {
        localObject = localUnreadSupportShortcut;
        if (paramString.equals(localUnreadSupportShortcut.mComponent.getPackageName()))
          break;
      }
      i += 1;
    }
    label75: return null;
  }

  private static String getUnreadSupportShortcutInfo()
  {
    synchronized (mLogLock)
    {
      String str = " Unread support shortcuts are " + sUnreadSupportShortcuts.toString();
      return str;
    }
  }

  private int getUserCenterUnreadCount()
  {
    int i3 = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    Object localObject3 = null;
    Object localObject1 = null;
    int m = i1;
    int j = i3;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://com.oppo.usercenter.provider.open/DBRemindEntity"), null, null, null, null);
      i = i2;
      int k = n;
      if (localCursor != null)
      {
        i = i2;
        k = n;
        m = i1;
        localObject1 = localCursor;
        j = i3;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          m = i1;
          localObject1 = localCursor;
          j = i3;
          localObject3 = localCursor;
          n = localCursor.getInt(localCursor.getColumnIndexOrThrow("showLauncherRemind"));
          m = i1;
          localObject1 = localCursor;
          j = n;
          localObject3 = localCursor;
          i1 = localCursor.getInt(localCursor.getColumnIndexOrThrow("remindCount"));
          i = i1;
          k = n;
          m = i1;
          localObject1 = localCursor;
          j = n;
          localObject3 = localCursor;
          if (DEBUG_UNREAD)
          {
            m = i1;
            localObject1 = localCursor;
            j = n;
            localObject3 = localCursor;
            Log.v("OPPOUnreadLoader", "getUserCenterUnreadCount --- switchValue = " + n + ", countValue = " + i1);
            k = n;
            i = i1;
          }
        }
      }
      closeCursor(localCursor);
      j = k;
      if (j == 0)
        i = 0;
      return i;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localObject3 = localObject1;
        Log.w("OPPOUnreadLoader", "Got Exception while getUserCenterUnreadCount, e = " + localException);
        closeCursor(localObject1);
        int i = m;
      }
    }
    finally
    {
      closeCursor(localObject3);
    }
  }

  private void initUnreadNumberContentObserver()
  {
    if ((this.mContext == null) || (this.mContentResolver == null))
    {
      Log.w("OPPOUnreadLoader", "initUnreadNumberContentObserver mContext = " + this.mContext);
      Log.w("OPPOUnreadLoader", "initUnreadNumberContentObserver mContentResolver = " + this.mContentResolver);
    }
    do
    {
      return;
      int i = 0;
      int j = sUnreadSupportShortcuts.size();
      while (i < j)
      {
        UnreadSupportShortcut localUnreadSupportShortcut = (UnreadSupportShortcut)sUnreadSupportShortcuts.get(i);
        if ((localUnreadSupportShortcut != null) && (localUnreadSupportShortcut.mUnreadNumSwitch))
          localUnreadSupportShortcut.registerObserver(this.mContext, this.mContentResolver);
        i += 1;
      }
      this.mContentResolver.registerContentObserver(POWERS_URI, true, this.mUnReadAppSwitchObserver);
    }
    while (!isBadgeProviderShortcutExistAndSwitchOpen());
    this.mBadgeProviderObserver = new BaseContentObserver(null, new Handler(this.mContext.getMainLooper()), true);
    this.mContentResolver.registerContentObserver(BadgeProvider.BadgeItems.CONTENT_URI, true, this.mBadgeProviderObserver);
  }

  private boolean isBadgeProviderShortcutExistAndSwitchOpen()
  {
    int i = 0;
    int j = sUnreadSupportShortcuts.size();
    while (i < j)
    {
      UnreadSupportShortcut localUnreadSupportShortcut = (UnreadSupportShortcut)sUnreadSupportShortcuts.get(i);
      if ((localUnreadSupportShortcut != null) && (localUnreadSupportShortcut.mHasBadgeProviderUri) && (localUnreadSupportShortcut.mUnreadNumSwitch))
        return true;
      i += 1;
    }
    return false;
  }

  private void loadUnreadSupportShortcuts(String paramString)
  {
    System.currentTimeMillis();
    if (DEBUG_UNREAD)
      Log.d("OPPOUnreadLoader", "loadUnreadSupportShortcuts fileName = " + paramString);
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    String str2 = null;
    String str1 = str2;
    Object localObject2 = localObject6;
    Object localObject3 = localObject7;
    Object localObject1 = localObject8;
    while (true)
    {
      int i;
      Object localObject9;
      String str3;
      boolean bool3;
      boolean bool4;
      try
      {
        localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        str1 = str2;
        localObject2 = localObject6;
        localObject3 = localObject7;
        localObject1 = localObject8;
        paramString = this.mContext.getResources().getAssets().open(paramString);
        str1 = paramString;
        localObject2 = paramString;
        localObject3 = paramString;
        localObject1 = paramString;
        localXmlPullParser.setInput(paramString, "UTF-8");
        str1 = paramString;
        localObject2 = paramString;
        localObject3 = paramString;
        localObject1 = paramString;
        XmlUtils.beginDocument(localXmlPullParser, "unreadshortcuts");
        str1 = paramString;
        localObject2 = paramString;
        localObject3 = paramString;
        localObject1 = paramString;
        int j = localXmlPullParser.getDepth();
        str1 = paramString;
        localObject2 = paramString;
        localObject3 = paramString;
        localObject1 = paramString;
        i = localXmlPullParser.next();
        if (i == 3)
        {
          str1 = paramString;
          localObject2 = paramString;
          localObject3 = paramString;
          localObject1 = paramString;
          if (localXmlPullParser.getDepth() <= j);
        }
        else if (i != 1)
        {
          if (i != 2)
            continue;
          str1 = paramString;
          localObject2 = paramString;
          localObject3 = paramString;
          localObject1 = paramString;
          if (!"shortcut".equals(localXmlPullParser.getName()))
            continue;
          str1 = paramString;
          localObject2 = paramString;
          localObject3 = paramString;
          localObject1 = paramString;
          int k = localXmlPullParser.getAttributeCount();
          localObject7 = "";
          localObject6 = "";
          str2 = "";
          str1 = paramString;
          localObject2 = paramString;
          localObject3 = paramString;
          localObject1 = paramString;
          localArrayList = new ArrayList();
          bool2 = false;
          bool1 = false;
          i = 0;
          if (i < k)
          {
            str1 = paramString;
            localObject2 = paramString;
            localObject3 = paramString;
            localObject1 = paramString;
            str4 = localXmlPullParser.getAttributeName(i);
            str1 = paramString;
            localObject2 = paramString;
            localObject3 = paramString;
            localObject1 = paramString;
            if (str4.equals("appName"))
            {
              str1 = paramString;
              localObject2 = paramString;
              localObject3 = paramString;
              localObject1 = paramString;
              localObject8 = localXmlPullParser.getAttributeValue(i);
              localObject9 = localObject6;
              str3 = str2;
              bool3 = bool2;
              bool4 = bool1;
            }
            else
            {
              str1 = paramString;
              localObject2 = paramString;
              localObject3 = paramString;
              localObject1 = paramString;
              if (str4.equals("unreadPackageName"))
              {
                str1 = paramString;
                localObject2 = paramString;
                localObject3 = paramString;
                localObject1 = paramString;
                localObject9 = localXmlPullParser.getAttributeValue(i);
                localObject8 = localObject7;
                str3 = str2;
                bool3 = bool2;
                bool4 = bool1;
              }
              else
              {
                str1 = paramString;
                localObject2 = paramString;
                localObject3 = paramString;
                localObject1 = paramString;
                if (str4.equals("unreadClassName"))
                {
                  str1 = paramString;
                  localObject2 = paramString;
                  localObject3 = paramString;
                  localObject1 = paramString;
                  str3 = localXmlPullParser.getAttributeValue(i);
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  bool3 = bool2;
                  bool4 = bool1;
                }
                else
                {
                  str1 = paramString;
                  localObject2 = paramString;
                  localObject3 = paramString;
                  localObject1 = paramString;
                  if (str4.startsWith("uri"))
                  {
                    str1 = paramString;
                    localObject2 = paramString;
                    localObject3 = paramString;
                    localObject1 = paramString;
                    localObject8 = localXmlPullParser.getAttributeValue(i);
                    str1 = paramString;
                    localObject2 = paramString;
                    localObject3 = paramString;
                    localObject1 = paramString;
                    if (BadgeProvider.BadgeItems.CONTENT_URI.toString().equals(localObject8))
                      bool1 = true;
                    str1 = paramString;
                    localObject2 = paramString;
                    localObject3 = paramString;
                    localObject1 = paramString;
                    localArrayList.add(new UriObserverEntry((String)localObject8, null));
                    localObject8 = localObject7;
                    localObject9 = localObject6;
                    str3 = str2;
                    bool3 = bool2;
                    bool4 = bool1;
                  }
                }
              }
            }
          }
        }
      }
      catch (XmlPullParserException paramString)
      {
        XmlPullParser localXmlPullParser;
        ArrayList localArrayList;
        String str4;
        localObject1 = str1;
        Log.w("OPPOUnreadLoader", "Got XmlPullParserException while parsing unread shortcuts.");
        closeInputStream(str1);
        return;
        str1 = paramString;
        localObject2 = paramString;
        localObject3 = paramString;
        localObject1 = paramString;
        localObject8 = localObject7;
        localObject9 = localObject6;
        str3 = str2;
        bool3 = bool2;
        bool4 = bool1;
        if (str4.startsWith("notifyForDescendents"))
        {
          str1 = paramString;
          localObject2 = paramString;
          localObject3 = paramString;
          localObject1 = paramString;
          localObject8 = localObject7;
          localObject9 = localObject6;
          str3 = str2;
          bool3 = bool2;
          bool4 = bool1;
          if (localXmlPullParser.getAttributeValue(i).equals("true"))
          {
            bool3 = true;
            localObject8 = localObject7;
            localObject9 = localObject6;
            str3 = str2;
            bool4 = bool1;
            break label889;
            str1 = paramString;
            localObject2 = paramString;
            localObject3 = paramString;
            localObject1 = paramString;
            localObject8 = mLogLock;
            str1 = paramString;
            localObject2 = paramString;
            localObject3 = paramString;
            localObject1 = paramString;
            try
            {
              sUnreadSupportShortcuts.add(new UnreadSupportShortcut((String)localObject7, (String)localObject6, str2, localArrayList, bool2, bool1));
              continue;
            }
            finally
            {
              str1 = paramString;
              localObject2 = paramString;
              localObject3 = paramString;
              localObject1 = paramString;
            }
          }
        }
      }
      catch (IOException paramString)
      {
        localObject1 = localObject2;
        Log.w("OPPOUnreadLoader", "Got IOException while parsing unread shortcuts.");
        return;
        closeInputStream(paramString);
        return;
      }
      catch (RuntimeException paramString)
      {
        localObject1 = localObject3;
        Log.w("OPPOUnreadLoader", "Got RuntimeException while parsing unread shortcuts.");
        return;
      }
      finally
      {
        closeInputStream((InputStream)localObject1);
      }
      label889: i += 1;
      localObject7 = localObject8;
      localObject6 = localObject9;
      Object localObject5 = str3;
      boolean bool2 = bool3;
      boolean bool1 = bool4;
    }
  }

  public static void setUnreadNumberAt(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0);
    try
    {
      if (paramInt1 < sUnreadSupportShortcuts.size())
      {
        if (DEBUG_UNREAD)
          Log.d("OPPOUnreadLoader", "setUnreadNumberAt: index = " + paramInt1 + ",unreadNum = " + paramInt2 + getUnreadSupportShortcutInfo());
        if (!((UnreadSupportShortcut)sUnreadSupportShortcuts.get(paramInt1)).mUnreadNumSwitch)
          break label99;
      }
      label99: for (((UnreadSupportShortcut)sUnreadSupportShortcuts.get(paramInt1)).mUnreadNum = paramInt2; ; ((UnreadSupportShortcut)sUnreadSupportShortcuts.get(paramInt1)).mUnreadNum = 0)
        return;
    }
    finally
    {
    }
  }

  private static int supportUnreadFeature(ComponentName paramComponentName)
  {
    int j;
    if (paramComponentName == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    int k = sUnreadSupportShortcuts.size();
    while (true)
    {
      if (i >= k)
        break label51;
      j = i;
      if (((UnreadSupportShortcut)sUnreadSupportShortcuts.get(i)).mComponent.equals(paramComponentName))
        break;
      i += 1;
    }
    label51: return -1;
  }

  private void updateUnreadShortcut(ComponentName paramComponentName)
  {
    if (paramComponentName == null);
    int m;
    do
    {
      return;
      m = supportUnreadFeature(paramComponentName);
      paramComponentName = getUnreadSupportShortcut(paramComponentName);
    }
    while (paramComponentName == null);
    int j;
    if (((UnreadSupportShortcut)sUnreadSupportShortcuts.get(m)).mUnreadNumSwitch)
    {
      j = getUnreadNum(paramComponentName);
      i = j;
      if (j <= 100);
    }
    for (int i = 100; ; i = 0)
    {
      int k = getUnreadNumberAt(m);
      j = k;
      if (k > 100)
        j = 100;
      if (j == i)
        break;
      setUnreadNumberAt(m, i);
      paramComponentName = (UnreadCallbacks)this.mCallbacks.get();
      if (paramComponentName == null)
        break;
      paramComponentName.bindComponentUnreadChanged(((UnreadSupportShortcut)sUnreadSupportShortcuts.get(m)).mComponent, i);
      return;
    }
  }

  public int getMissedCallCount()
  {
    return Settings.System.getInt(this.mContext.getContentResolver(), "oppo.missed.calls.number", 0);
  }

  public int getNewEmailCount()
  {
    int n = 0;
    int m = 0;
    int i1 = 0;
    int i = 0;
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    int j = n;
    int k = i1;
    try
    {
      localCursor = this.mContext.getContentResolver().query(Uri.parse("content://com.android.email.provider/mailbox"), new String[] { "unreadCount" }, "type = 0", null, null);
      if (localCursor != null)
      {
        localObject3 = localCursor;
        j = n;
        localObject5 = localCursor;
        k = i1;
        localObject1 = localCursor;
        localCursor.moveToFirst();
        while (true)
        {
          localObject3 = localCursor;
          j = i;
          m = i;
          localObject5 = localCursor;
          k = i;
          localObject1 = localCursor;
          if (localCursor.isAfterLast())
            break;
          localObject3 = localCursor;
          j = i;
          localObject5 = localCursor;
          k = i;
          localObject1 = localCursor;
          i += localCursor.getInt(0);
          localObject3 = localCursor;
          j = i;
          localObject5 = localCursor;
          k = i;
          localObject1 = localCursor;
          localCursor.moveToNext();
        }
      }
    }
    catch (CursorIndexOutOfBoundsException localCursorIndexOutOfBoundsException)
    {
      Cursor localCursor;
      localObject2 = localObject3;
      Log.w("OPPOUnreadLoader", "Got CursorIndexOutOfBoundsException while getNewEmailCount.");
      return j;
      return m;
    }
    catch (SecurityException localSecurityException)
    {
      localObject2 = localObject5;
      Log.e("OPPOUnreadLoader", "getNewEmailCount --- e = " + localSecurityException);
      return k;
    }
    finally
    {
      Object localObject2;
      closeCursor(localObject2);
    }
  }

  public int getNewMmsCount()
  {
    return 0;
  }

  public int getNewSmsCount()
  {
    return Settings.System.getInt(this.mContext.getContentResolver(), "oppo.unread.mms.number", 0);
  }

  public int getNewUpdateCount()
  {
    int i = 0;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://com.oppo.market/upgrade"), null, null, null, null);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        i = localCursor.getCount();
      }
      return i;
    }
    catch (Exception localException)
    {
      localObject4 = localObject1;
      Log.w("OPPOUnreadLoader", "Got Exception while getNewUpdateCount.");
      return 0;
    }
    finally
    {
      Object localObject4;
      closeCursor(localObject4);
    }
  }

  public int getNewWPSEmailCount()
  {
    int i = 0;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://com.android.email.provider/uifolder/1152921504606846976"), null, "_id = ?", new String[] { "1152921504606846976" + "" }, null);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        localCursor.moveToFirst();
        localObject1 = localCursor;
        localObject3 = localCursor;
        i = localCursor.getInt(localCursor.getColumnIndex("unreadCount"));
      }
      return i;
    }
    catch (Exception localException)
    {
      localObject4 = localObject1;
      Log.w("OPPOUnreadLoader", "Got Exception while getNewWPSEmailCount.");
      return 0;
    }
    finally
    {
      Object localObject4;
      closeCursor(localObject4);
    }
  }

  public int getOTACount()
  {
    int j = 0;
    int i = 0;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://com.oppo.ota/patch"), null, null, null, null);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        i = localCursor.getCount();
      }
      closeCursor(localCursor);
      if (i > 0)
        return 1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localObject4 = localObject1;
        Log.w("OPPOUnreadLoader", "Got Exception while getOTACount.");
        closeCursor(localObject1);
        i = j;
      }
    }
    finally
    {
      Object localObject4;
      closeCursor(localObject4);
    }
    return 0;
  }

  public int getOppoCommunityCount()
  {
    int j = 0;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://com.oppo.community.provider.forum2/last_user_signin"), null, "show_notices = 1", null, null);
      int i = j;
      if (localCursor != null)
      {
        i = j;
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          i = localCursor.getInt(localCursor.getColumnIndex("new_notices"));
        }
      }
      return i;
    }
    catch (Exception localException)
    {
      localObject4 = localObject1;
      Log.w("OPPOUnreadLoader", "Got Exception while getOppoCommunityCount.");
      return 0;
    }
    finally
    {
      Object localObject4;
      closeCursor(localObject4);
    }
  }

  public int getPricacyNewSmsCount()
  {
    int i = 0;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://sms"), null, "type = 1 and read = 0 and thread_id in (select _id from threads where is_secret = 1)", null, null);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        i = localCursor.getCount();
      }
      return i;
    }
    catch (Exception localException)
    {
      localObject4 = localObject1;
      Log.w("OPPOUnreadLoader", "Got Exception while getPricacyNewSmsCount.");
      return 0;
    }
    finally
    {
      Object localObject4;
      closeCursor(localObject4);
    }
  }

  public int getPrivacyMissedCallCount()
  {
    int i = 0;
    int j = 0;
    Object localObject = null;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[] { "number", "type", "new" }, "private_type=?", new String[] { "1" }, "date DESC");
      localObject = localCursor;
      if (localObject != null)
      {
        i = j;
        while (localObject.moveToNext())
          switch (localObject.getInt(localObject.getColumnIndex("type")))
          {
          default:
            break;
          case 3:
            if (localObject.getInt(localObject.getColumnIndex("new")) == 1)
              i += 1;
            break;
          }
      }
    }
    catch (Exception localException)
    {
      while (true)
        Log.e("OPPOUnreadLoader", "getPrivacyMissedCallCount --- e = " + localException);
      closeCursor(localObject);
    }
    return i;
  }

  public int getPrivacyNewMmsCount()
  {
    int i = 0;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://mms/inbox"), null, "read = 0 AND (m_type=132 or m_type=130) and thread_id in (select _id from threads where is_secret = 1)", null, null);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        i = localCursor.getCount();
      }
      return i;
    }
    catch (Exception localException)
    {
      localObject4 = localObject1;
      Log.w("OPPOUnreadLoader", "Got Exception while getPrivacyNewMmsCount.");
      return 0;
    }
    finally
    {
      Object localObject4;
      closeCursor(localObject4);
    }
  }

  public int getUpdateBookCount()
  {
    try
    {
      int i = this.mContext.getContentResolver().call(Uri.parse("content://com.zhangyue.iReader.provider.bookcount/"), "getnewchapter", null, null).getInt("bookscounthasnewchapter");
      return i;
    }
    catch (Exception localException)
    {
      Log.w("OPPOUnreadLoader", "Got Exception while getUpdateBookCount.");
    }
    return 0;
  }

  public void initialize(UnreadCallbacks paramUnreadCallbacks)
  {
    this.mCallbacks = new WeakReference(paramUnreadCallbacks);
    if (DEBUG_UNREAD)
      Log.d("OPPOUnreadLoader", "initialize: callbacks = " + paramUnreadCallbacks + ",mCallbacks = " + this.mCallbacks);
  }

  public void loadAndInitUnreadShortcuts(String paramString)
  {
    loadUnreadSupportShortcuts(paramString);
    updateUnreadNumberSwitch(false);
    initUnreadNumberContentObserver();
    updateAllUnreadShortcuts();
  }

  public void openAllAppsSwitch()
  {
    if (this.sWorker == null)
      return;
    this.sWorker.removeCallbacksAndMessages(this.mBadgeSwitchUpdateObject);
    Message localMessage = Message.obtain(this.sWorker, new Runnable()
    {
      public void run()
      {
        int i = 0;
        int j = OPPOUnreadLoader.sUnreadSupportShortcuts.size();
        while (i < j)
        {
          UnreadSupportShortcut localUnreadSupportShortcut = (UnreadSupportShortcut)OPPOUnreadLoader.sUnreadSupportShortcuts.get(i);
          if ((localUnreadSupportShortcut != null) && (!localUnreadSupportShortcut.mUnreadNumSwitch))
          {
            localUnreadSupportShortcut.registerObserver(OPPOUnreadLoader.this.mContext, OPPOUnreadLoader.this.mContentResolver);
            localUnreadSupportShortcut.mUnreadNumSwitch = true;
            localUnreadSupportShortcut.mUnreadNum = OPPOUnreadLoader.this.getUnreadNum(localUnreadSupportShortcut);
            OPPOUnreadLoader.this.postBindComponentUnreadChanged(localUnreadSupportShortcut);
          }
          i += 1;
        }
        if ((OPPOUnreadLoader.this.isBadgeProviderShortcutExistAndSwitchOpen()) && (OPPOUnreadLoader.this.mBadgeProviderObserver == null))
        {
          OPPOUnreadLoader.access$602(OPPOUnreadLoader.this, new BaseContentObserver(OPPOUnreadLoader.this, null, new Handler(OPPOUnreadLoader.this.mContext.getMainLooper()), true));
          OPPOUnreadLoader.this.mContentResolver.registerContentObserver(BadgeProvider.BadgeItems.CONTENT_URI, true, OPPOUnreadLoader.this.mBadgeProviderObserver);
        }
      }
    });
    localMessage.obj = this.mBadgeSwitchUpdateObject;
    this.sWorker.sendMessageDelayed(localMessage, 800L);
  }

  public void postBindComponentUnreadChanged(final UnreadSupportShortcut paramUnreadSupportShortcut)
  {
    if ((paramUnreadSupportShortcut == null) || (this.sWorker == null))
      return;
    this.sWorker.post(new Runnable()
    {
      public void run()
      {
        if (OPPOUnreadLoader.this.mCallbacks != null)
        {
          UnreadCallbacks localUnreadCallbacks = (UnreadCallbacks)OPPOUnreadLoader.this.mCallbacks.get();
          if (localUnreadCallbacks != null)
            localUnreadCallbacks.bindComponentUnreadChanged(paramUnreadSupportShortcut.mComponent, paramUnreadSupportShortcut.mUnreadNum);
        }
      }
    });
  }

  public void recycle()
  {
    if (this.sWorkerThread != null)
    {
      this.sWorkerThread.quitSafely();
      this.sWorker = null;
    }
    mInstance = null;
  }

  public void unRegisterUnreadNumberContentObserver()
  {
    if (this.mContentResolver == null)
      Log.w("OPPOUnreadLoader", "unRegisterUnreadNumberContentObserver mContentResolver == null");
    do
    {
      return;
      int i = 0;
      int j = sUnreadSupportShortcuts.size();
      while (i < j)
      {
        UnreadSupportShortcut localUnreadSupportShortcut = (UnreadSupportShortcut)sUnreadSupportShortcuts.get(i);
        if ((localUnreadSupportShortcut != null) && (localUnreadSupportShortcut.mUnreadNumSwitch))
          localUnreadSupportShortcut.unRegisterObserver(this.mContentResolver);
        i += 1;
      }
      this.mContentResolver.unregisterContentObserver(this.mUnReadAppSwitchObserver);
    }
    while (this.mBadgeProviderObserver == null);
    this.mContentResolver.unregisterContentObserver(this.mBadgeProviderObserver);
    this.mBadgeProviderObserver = null;
  }

  public void updateAllUnreadShortcuts()
  {
    int i = 0;
    int j = sUnreadSupportShortcuts.size();
    if (i < j)
    {
      UnreadSupportShortcut localUnreadSupportShortcut = (UnreadSupportShortcut)sUnreadSupportShortcuts.get(i);
      if (localUnreadSupportShortcut.mUnreadNumSwitch);
      for (localUnreadSupportShortcut.mUnreadNum = getUnreadNum(localUnreadSupportShortcut); ; localUnreadSupportShortcut.mUnreadNum = 0)
      {
        postBindComponentUnreadChanged(localUnreadSupportShortcut);
        i += 1;
        break;
      }
    }
  }

  public void updateUnreadNumberSwitch(boolean paramBoolean)
  {
    label516: label654: 
    while (true)
    {
      Object localObject6;
      try
      {
        if ((this.mContext == null) || (this.mContentResolver == null))
        {
          Log.w("OPPOUnreadLoader", "updateUnreadNumberSwitch mContext = " + this.mContext);
          Log.w("OPPOUnreadLoader", "updateUnreadNumberSwitch mContentResolver = " + this.mContentResolver);
          return;
        }
        localObject5 = null;
        Object localObject1 = null;
        try
        {
          Cursor localCursor = this.mContext.getContentResolver().query(POWERS_URI, new String[] { "pkg", "notification_user", "badge_user" }, null, null, null);
          if (localCursor == null)
            break label597;
          localObject1 = localCursor;
          localObject5 = localCursor;
          if (localCursor.getCount() <= 0)
            break label597;
          localObject1 = localCursor;
          localObject5 = localCursor;
          int i = localCursor.getColumnIndexOrThrow("pkg");
          localObject1 = localCursor;
          localObject5 = localCursor;
          int j = localCursor.getColumnIndexOrThrow("notification_user");
          localObject1 = localCursor;
          localObject5 = localCursor;
          int k = localCursor.getColumnIndexOrThrow("badge_user");
          localObject1 = localCursor;
          localObject5 = localCursor;
          if (!localCursor.moveToNext())
            break label516;
          localObject1 = localCursor;
          localObject5 = localCursor;
          localObject6 = localCursor.getString(i);
          if (localObject6 == null)
            continue;
          localObject1 = localCursor;
          localObject5 = localCursor;
          localObject6 = getUnreadSupportShortcut((String)localObject6);
          if (localObject6 == null)
            continue;
          localObject1 = localCursor;
          localObject5 = localCursor;
          boolean bool = ((UnreadSupportShortcut)localObject6).mUnreadNumSwitch;
          localObject1 = localCursor;
          localObject5 = localCursor;
          if (localCursor.getInt(j) == 1)
          {
            localObject1 = localCursor;
            localObject5 = localCursor;
            if (localCursor.getInt(k) != 1)
            {
              localObject1 = localCursor;
              localObject5 = localCursor;
              ((UnreadSupportShortcut)localObject6).mUnreadNumSwitch = false;
              if (!paramBoolean)
                continue;
              localObject1 = localCursor;
              localObject5 = localCursor;
              if (bool == ((UnreadSupportShortcut)localObject6).mUnreadNumSwitch)
                continue;
              localObject1 = localCursor;
              localObject5 = localCursor;
              if (!((UnreadSupportShortcut)localObject6).mUnreadNumSwitch)
                break label486;
              localObject1 = localCursor;
              localObject5 = localCursor;
              ((UnreadSupportShortcut)localObject6).registerObserver(this.mContext, this.mContentResolver);
              localObject1 = localCursor;
              localObject5 = localCursor;
              ((UnreadSupportShortcut)localObject6).mUnreadNum = getUnreadNum((UnreadSupportShortcut)localObject6);
              localObject1 = localCursor;
              localObject5 = localCursor;
              postBindComponentUnreadChanged((UnreadSupportShortcut)localObject6);
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          localObject5 = localObject1;
          Log.e("OPPOUnreadLoader", "updateUnreadNumberSwitch fail e = " + localException);
          if (localObject1 == null)
            continue;
          localObject1.close();
          continue;
          localObject1 = localException;
          localObject5 = localException;
          ((UnreadSupportShortcut)localObject6).mUnreadNumSwitch = true;
          continue;
        }
        finally
        {
          if (localObject5 != null)
            localObject5.close();
        }
      }
      finally
      {
      }
      Object localObject4 = localException;
      Object localObject5 = localException;
      ((UnreadSupportShortcut)localObject6).mUnreadNumSwitch = false;
      continue;
      label486: localObject4 = localException;
      localObject5 = localException;
      ((UnreadSupportShortcut)localObject6).unRegisterObserver(this.mContentResolver);
      localObject4 = localException;
      localObject5 = localException;
      ((UnreadSupportShortcut)localObject6).mUnreadNum = 0;
      continue;
      localObject4 = localException;
      localObject5 = localException;
      if (isBadgeProviderShortcutExistAndSwitchOpen())
      {
        localObject4 = localException;
        localObject5 = localException;
        if (this.mBadgeProviderObserver == null)
        {
          localObject4 = localException;
          localObject5 = localException;
          this.mBadgeProviderObserver = new BaseContentObserver(null, new Handler(this.mContext.getMainLooper()), true);
          localObject4 = localException;
          localObject5 = localException;
          this.mContentResolver.registerContentObserver(BadgeProvider.BadgeItems.CONTENT_URI, true, this.mBadgeProviderObserver);
        }
      }
      while (true)
      {
        label597: if (localException == null)
          break label654;
        localException.close();
        break;
        localObject4 = localException;
        localObject5 = localException;
        if (this.mBadgeProviderObserver != null)
        {
          localObject4 = localException;
          localObject5 = localException;
          this.mContentResolver.unregisterContentObserver(this.mBadgeProviderObserver);
          localObject4 = localException;
          localObject5 = localException;
          this.mBadgeProviderObserver = null;
        }
      }
    }
  }

  class BaseContentObserver extends ContentObserver
  {
    ComponentName mComponentName;
    boolean mIsBadgeProviderObserver = false;

    public BaseContentObserver(ComponentName paramHandler, Handler paramBoolean, boolean arg4)
    {
      super();
      this.mComponentName = paramHandler;
      boolean bool;
      this.mIsBadgeProviderObserver = bool;
    }

    public void onChange(boolean paramBoolean, Uri paramUri)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      Object localObject4 = null;
      if (this.mIsBadgeProviderObserver)
      {
        Object localObject3 = localObject2;
        localObject1 = localObject4;
        if (paramUri != null)
        {
          String str = paramUri.getQueryParameter("packageName");
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (str != null)
          {
            localObject4 = OPPOUnreadLoader.getUnreadSupportShortcut(str);
            localObject3 = localObject2;
            localObject1 = localObject4;
            if (localObject4 != null)
            {
              localObject3 = OPPOUnreadLoader.getMessageObj(((UnreadSupportShortcut)localObject4).mComponent);
              localObject1 = localObject4;
            }
          }
        }
        localObject2 = localObject3;
        localObject4 = localObject1;
        if (localObject3 == null)
          localObject2 = OPPOUnreadLoader.this.mBadgeProviderObject;
      }
      for (localObject4 = localObject1; localObject2 == null; localObject4 = localObject1)
      {
        Log.w("OPPOUnreadLoader", "onChange obj == null, uri = " + paramUri);
        return;
        localObject2 = OPPOUnreadLoader.getMessageObj(this.mComponentName);
      }
      OPPOUnreadLoader.this.sWorker.removeCallbacksAndMessages(localObject2);
      if (this.mIsBadgeProviderObserver)
        if (localObject4 != null)
          paramUri = Message.obtain(OPPOUnreadLoader.this.sWorker, new WorkRunnable(OPPOUnreadLoader.this, ((UnreadSupportShortcut)localObject4).mComponent, false));
      while (true)
      {
        paramUri.obj = localObject2;
        OPPOUnreadLoader.this.sWorker.sendMessageDelayed(paramUri, 800L);
        return;
        paramUri = Message.obtain(OPPOUnreadLoader.this.sWorker, new WorkRunnable(OPPOUnreadLoader.this, null, true));
        continue;
        paramUri = Message.obtain(OPPOUnreadLoader.this.sWorker, new WorkRunnable(OPPOUnreadLoader.this, this.mComponentName, false));
      }
    }
  }

  public static abstract interface UnreadCallbacks
  {
    public abstract void bindComponentUnreadChanged(ComponentName paramComponentName, int paramInt);
  }

  class UnreadSupportShortcut
  {
    String mAppName;
    ComponentName mComponent;
    boolean mHasBadgeProviderUri;
    boolean mNotifyForDescendents;
    Object mObject;
    int mUnreadNum;
    boolean mUnreadNumSwitch;
    ArrayList<UriObserverEntry> mUriObserverEntryList = new ArrayList();

    public UnreadSupportShortcut(String paramString1, String paramArrayList, ArrayList<UriObserverEntry> paramBoolean1, boolean paramBoolean2, boolean arg6)
    {
      this.mAppName = paramString1;
      this.mComponent = new ComponentName(paramArrayList, paramBoolean1);
      this.mUnreadNum = 0;
      this.mUnreadNumSwitch = true;
      this.mUriObserverEntryList = paramBoolean2;
      boolean bool1;
      this.mNotifyForDescendents = bool1;
      boolean bool2;
      this.mHasBadgeProviderUri = bool2;
      this.mObject = new Object();
    }

    public void registerObserver(Context paramContext, ContentResolver paramContentResolver)
    {
      if ((this.mUriObserverEntryList == null) || (paramContentResolver == null) || (paramContext == null));
      while (true)
      {
        return;
        int i = 0;
        while (i < this.mUriObserverEntryList.size())
        {
          UriObserverEntry localUriObserverEntry = (UriObserverEntry)this.mUriObserverEntryList.get(i);
          if ((localUriObserverEntry != null) && (localUriObserverEntry.mObserver == null) && (localUriObserverEntry.mUriString != null) && (!BadgeProvider.BadgeItems.CONTENT_URI.toString().equals(localUriObserverEntry.mUriString)))
          {
            localUriObserverEntry.mObserver = new BaseContentObserver(OPPOUnreadLoader.this, this.mComponent, new Handler(paramContext.getMainLooper()), false);
            paramContentResolver.registerContentObserver(Uri.parse(localUriObserverEntry.mUriString), this.mNotifyForDescendents, localUriObserverEntry.mObserver);
          }
          i += 1;
        }
      }
    }

    public String toString()
    {
      return "{UnreadSupportShortcut[" + this.mComponent + "] " + ",mUnreadNum = " + this.mUnreadNum + ",mUnreadNumSwitch = " + this.mUnreadNumSwitch + "}";
    }

    public void unRegisterObserver(ContentResolver paramContentResolver)
    {
      if ((this.mUriObserverEntryList == null) || (paramContentResolver == null));
      while (true)
      {
        return;
        int i = 0;
        while (i < this.mUriObserverEntryList.size())
        {
          UriObserverEntry localUriObserverEntry = (UriObserverEntry)this.mUriObserverEntryList.get(i);
          if ((localUriObserverEntry != null) && (localUriObserverEntry.mObserver != null))
          {
            paramContentResolver.unregisterContentObserver(localUriObserverEntry.mObserver);
            localUriObserverEntry.mObserver = null;
          }
          i += 1;
        }
      }
    }
  }

  class UriObserverEntry
  {
    public BaseContentObserver mObserver;
    public String mUriString;

    public UriObserverEntry(String paramBaseContentObserver, BaseContentObserver arg3)
    {
      this.mUriString = paramBaseContentObserver;
      Object localObject;
      this.mObserver = localObject;
    }
  }

  class WorkRunnable
    implements Runnable
  {
    ComponentName mComponentName;
    boolean mIsUpdateAllBadgeProviderShortcut = false;

    public WorkRunnable(ComponentName paramBoolean, boolean arg3)
    {
      this.mComponentName = paramBoolean;
      boolean bool;
      this.mIsUpdateAllBadgeProviderShortcut = bool;
    }

    public void run()
    {
      if (this.mIsUpdateAllBadgeProviderShortcut)
      {
        int i = 0;
        int j = OPPOUnreadLoader.sUnreadSupportShortcuts.size();
        while (i < j)
        {
          UnreadSupportShortcut localUnreadSupportShortcut = (UnreadSupportShortcut)OPPOUnreadLoader.sUnreadSupportShortcuts.get(i);
          if ((localUnreadSupportShortcut != null) && (localUnreadSupportShortcut.mHasBadgeProviderUri))
            OPPOUnreadLoader.this.updateUnreadShortcut(localUnreadSupportShortcut.mComponent);
          i += 1;
        }
      }
      OPPOUnreadLoader.this.updateUnreadShortcut(this.mComponentName);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.unreaderloader.OPPOUnreadLoader
 * JD-Core Version:    0.6.2
 */