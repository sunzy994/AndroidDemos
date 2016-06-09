package com.oppo.launcher;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.oppo.shared_prefs.LauncherSharedPrefs;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class LauncherAssetManager
{
  private static boolean DEBUG = false;
  public static final String EXTRA_APP_CATEGORY_NAME = "extra_app_category";
  private static final String EXTRA_APP_CATEGORY_VERSION = "extra_app_category_version";
  private static final String TAG = "LauncherAssetManager";
  private static final String US_ASCII_FORMAT = "US-ASCII";
  private static final int UTF8_FILE_HEAD_LENGTH = 3;
  private static final String UTF8_FORMAT = "UTF-8";
  private static HashMap<String, Integer> mDefaultShortcutWhiteListMap = new HashMap();
  private static LauncherAssetManager mLauncherAssetManager = null;
  private Runnable mAppCategoryLoader = new Runnable()
  {
    public void run()
    {
      LauncherAssetManager.this.loadMainCategoryData();
      LauncherAssetManager.this.loadExtraCategoryData();
      LauncherAssetManager.this.loadDefaultShortcutWhiteListData();
    }
  };
  private Context mContext = null;
  private HashMap<String, Integer> mExtraCategoryMap = new HashMap();
  private Object mLock = new Object();
  private HashMap<String, Integer> mMainCategoryMap = new HashMap();

  private LauncherAssetManager(Context paramContext)
  {
    this.mContext = paramContext;
    new Thread(this.mAppCategoryLoader).start();
  }

  public static byte[] getAssetBytes(String paramString, Context paramContext)
  {
    if ((paramContext == null) || (paramString == null))
    {
      Log.e("LauncherAssetManager", "getAssetBytes dataName = " + paramString + ", context = " + paramContext);
      paramString = null;
    }
    Object localObject2;
    while (true)
    {
      return paramString;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject3 = paramContext.getAssets();
      localObject2 = null;
      Object localObject1 = null;
      paramContext = localObject4;
      try
      {
        localObject3 = ((AssetManager)localObject3).open(paramString);
        paramContext = localObject5;
        if (localObject3 != null)
        {
          paramContext = localObject4;
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramString = new byte[((InputStream)localObject3).available()];
          paramContext = paramString;
          localObject1 = localObject3;
          localObject2 = localObject3;
          ((InputStream)localObject3).read(paramString);
          paramContext = paramString;
        }
        paramString = paramContext;
        if (localObject3 != null)
          try
          {
            ((InputStream)localObject3).close();
            return paramContext;
          }
          catch (Exception paramString)
          {
            Log.d("LauncherAssetManager", "getAssetBytes inputStream e = " + paramString);
            return paramContext;
          }
      }
      catch (Exception paramString)
      {
        localObject2 = localObject1;
        Log.d("LauncherAssetManager", "getAssetBytes e = " + paramString);
        paramString = paramContext;
        if (localObject1 != null)
          try
          {
            localObject1.close();
            return paramContext;
          }
          catch (Exception paramString)
          {
            Log.d("LauncherAssetManager", "getAssetBytes inputStream e = " + paramString);
            return paramContext;
          }
      }
      finally
      {
        if (localObject2 == null);
      }
    }
    try
    {
      localObject2.close();
      throw paramString;
    }
    catch (Exception paramContext)
    {
      while (true)
        Log.d("LauncherAssetManager", "getAssetBytes inputStream e = " + paramContext);
    }
  }

  private byte[] getExtraData()
  {
    byte[] arrayOfByte = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = arrayOfByte;
    try
    {
      FileInputStream localFileInputStream = this.mContext.openFileInput("extra_app_category");
      localObject1 = localObject5;
      if (localFileInputStream != null)
      {
        localObject1 = arrayOfByte;
        localObject3 = localFileInputStream;
        localObject4 = localFileInputStream;
        arrayOfByte = new byte[localFileInputStream.available()];
        localObject1 = arrayOfByte;
        localObject3 = localFileInputStream;
        localObject4 = localFileInputStream;
        localFileInputStream.read(arrayOfByte);
        localObject1 = arrayOfByte;
      }
      localObject4 = localObject1;
      if (localFileInputStream != null);
      try
      {
        localFileInputStream.close();
        localObject4 = localObject1;
        return localObject4;
      }
      catch (Exception localException1)
      {
        Log.d("LauncherAssetManager", "getExtraData " + localException1);
        return localObject1;
      }
    }
    catch (Exception localException4)
    {
      do
      {
        localObject4 = localException1;
        Log.d("LauncherAssetManager", "getExtraData e = " + localException4);
        localObject4 = localObject1;
      }
      while (localException1 == null);
      try
      {
        localException1.close();
        return localObject1;
      }
      catch (Exception localException2)
      {
        Log.d("LauncherAssetManager", "getExtraData " + localException2);
        return localObject1;
      }
    }
    finally
    {
      if (localObject4 == null);
    }
    try
    {
      localObject4.close();
      throw localObject2;
    }
    catch (Exception localException3)
    {
      while (true)
        Log.d("LauncherAssetManager", "getExtraData " + localException3);
    }
  }

  public static LauncherAssetManager getInstance(Context paramContext)
  {
    try
    {
      if (mLauncherAssetManager == null)
        mLauncherAssetManager = new LauncherAssetManager(paramContext);
      paramContext = mLauncherAssetManager;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  private int getRecommendFolderNameId(String paramString)
  {
    int j = -1;
    int i = j;
    if (this.mMainCategoryMap != null)
    {
      Integer localInteger = (Integer)this.mMainCategoryMap.get(paramString);
      i = j;
      if (localInteger != null)
        i = localInteger.intValue();
    }
    j = i;
    if (-1 == i)
    {
      j = i;
      if (this.mExtraCategoryMap != null)
      {
        paramString = (Integer)this.mExtraCategoryMap.get(paramString);
        j = i;
        if (paramString != null)
          j = paramString.intValue();
      }
    }
    return j;
  }

  private int getRecommendFolderNameId(String paramString1, String paramString2)
  {
    int j = getRecommendFolderNameId(paramString1);
    int i = j;
    if (-1 == j)
      i = getRecommendFolderNameId(paramString2);
    return i;
  }

  private boolean isFileValid(String paramString)
  {
    paramString = new File(this.mContext.getFilesDir().getAbsolutePath() + "/" + paramString);
    return (paramString.exists()) && (0L != paramString.length());
  }

  public static boolean isInDefaultShortcutWhiteList(String paramString, int paramInt)
  {
    if ((mDefaultShortcutWhiteListMap != null) && (paramString != null))
    {
      paramString = (Integer)mDefaultShortcutWhiteListMap.get(paramString);
      if ((paramString != null) && (paramString.intValue() == paramInt))
        return true;
    }
    return false;
  }

  private void loadData(byte[] paramArrayOfByte, HashMap<String, Integer> paramHashMap, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return;
    String str = null;
    if (paramString == "UTF-8");
    try
    {
      if (paramArrayOfByte.length > 3)
        str = new String(paramArrayOfByte, 3, paramArrayOfByte.length - 3, "UTF-8");
      while (str != null)
      {
        paramArrayOfByte = str.split(" ");
        if (paramArrayOfByte == null)
          break;
        int i = 0;
        while (i < paramArrayOfByte.length - 1)
        {
          paramHashMap.put(paramArrayOfByte[i], Integer.valueOf(paramArrayOfByte[(i + 1)]));
          i += 2;
        }
        if (paramString == "US-ASCII")
          str = new String(paramArrayOfByte, paramString);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      Log.d("LauncherAssetManager", "loadData e = " + paramArrayOfByte);
      return;
    }
    finally
    {
    }
    throw paramArrayOfByte;
  }

  private void loadDefaultShortcutWhiteListData()
  {
    loadData(getAssetBytes("shortcut_whitelist", this.mContext), mDefaultShortcutWhiteListMap, "UTF-8");
  }

  private void loadExtraCategoryData()
  {
    if (isFileValid("extra_app_category"))
      synchronized (this.mLock)
      {
        loadData(getExtraData(), this.mExtraCategoryMap, "US-ASCII");
        return;
      }
    updateExtraAppCategoryFromDatabase();
  }

  private void loadMainCategoryData()
  {
    loadData(getAssetBytes("app_category", this.mContext), this.mMainCategoryMap, "US-ASCII");
  }

  // ERROR //
  private boolean string2File(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 4
    //   14: aconst_null
    //   15: astore 6
    //   17: new 260	java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_1
    //   22: ldc 22
    //   24: invokevirtual 264	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   27: invokespecial 267	java/io/ByteArrayInputStream:<init>	([B)V
    //   30: astore 5
    //   32: aload 9
    //   34: astore_1
    //   35: aload 8
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 68	com/oppo/launcher/LauncherAssetManager:mContext	Landroid/content/Context;
    //   42: aload_2
    //   43: iconst_3
    //   44: invokevirtual 271	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   47: astore_2
    //   48: aload_2
    //   49: astore_1
    //   50: aload_2
    //   51: astore_3
    //   52: ldc_w 272
    //   55: newarray byte
    //   57: astore 4
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: astore_3
    //   63: aload 5
    //   65: aload 4
    //   67: invokevirtual 145	java/io/InputStream:read	([B)I
    //   70: istore 10
    //   72: iload 10
    //   74: ifle +76 -> 150
    //   77: aload_2
    //   78: astore_1
    //   79: aload_2
    //   80: astore_3
    //   81: aload_2
    //   82: aload 4
    //   84: iconst_0
    //   85: iload 10
    //   87: invokevirtual 278	java/io/FileOutputStream:write	([BII)V
    //   90: goto -31 -> 59
    //   93: astore_3
    //   94: aload 5
    //   96: astore_2
    //   97: aload_3
    //   98: astore 5
    //   100: aload_1
    //   101: astore_3
    //   102: aload_2
    //   103: astore 4
    //   105: ldc 19
    //   107: new 101	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 280
    //   117: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 5
    //   122: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 153	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 148	java/io/InputStream:close	()V
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 281	java/io/FileOutputStream:close	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: aload 5
    //   152: ifnull +8 -> 160
    //   155: aload 5
    //   157: invokevirtual 148	java/io/InputStream:close	()V
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 281	java/io/FileOutputStream:close	()V
    //   168: iconst_1
    //   169: ireturn
    //   170: astore_1
    //   171: ldc 19
    //   173: new 101	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 283
    //   183: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 153	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   196: pop
    //   197: goto -37 -> 160
    //   200: astore_1
    //   201: ldc 19
    //   203: new 101	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 285
    //   213: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_1
    //   217: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 153	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   226: pop
    //   227: iconst_1
    //   228: ireturn
    //   229: astore_2
    //   230: ldc 19
    //   232: new 101	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   239: ldc_w 283
    //   242: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_2
    //   246: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 153	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   255: pop
    //   256: goto -116 -> 140
    //   259: astore_1
    //   260: ldc 19
    //   262: new 101	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 285
    //   272: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 153	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   285: pop
    //   286: iconst_0
    //   287: ireturn
    //   288: astore_1
    //   289: aload 4
    //   291: ifnull +8 -> 299
    //   294: aload 4
    //   296: invokevirtual 148	java/io/InputStream:close	()V
    //   299: aload_3
    //   300: ifnull +7 -> 307
    //   303: aload_3
    //   304: invokevirtual 281	java/io/FileOutputStream:close	()V
    //   307: aload_1
    //   308: athrow
    //   309: astore_2
    //   310: ldc 19
    //   312: new 101	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 283
    //   322: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_2
    //   326: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 153	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   335: pop
    //   336: goto -37 -> 299
    //   339: astore_2
    //   340: ldc 19
    //   342: new 101	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 285
    //   352: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_2
    //   356: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 153	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   365: pop
    //   366: goto -59 -> 307
    //   369: astore_1
    //   370: aload 5
    //   372: astore 4
    //   374: goto -85 -> 289
    //   377: astore 5
    //   379: aload 7
    //   381: astore_1
    //   382: aload 6
    //   384: astore_2
    //   385: goto -285 -> 100
    //
    // Exception table:
    //   from	to	target	type
    //   38	48	93	java/lang/Exception
    //   52	59	93	java/lang/Exception
    //   63	72	93	java/lang/Exception
    //   81	90	93	java/lang/Exception
    //   155	160	170	java/lang/Exception
    //   164	168	200	java/lang/Exception
    //   136	140	229	java/lang/Exception
    //   144	148	259	java/lang/Exception
    //   17	32	288	finally
    //   105	132	288	finally
    //   294	299	309	java/lang/Exception
    //   303	307	339	java/lang/Exception
    //   38	48	369	finally
    //   52	59	369	finally
    //   63	72	369	finally
    //   81	90	369	finally
    //   17	32	377	java/lang/Exception
  }

  public String getRecommendFolderName(String paramString1, String paramString2)
  {
    int i = getRecommendFolderNameId(paramString1, paramString2);
    paramString1 = LauncherUtil.getRecommendFolder(this.mContext);
    if ((i >= 0) && (i < paramString1.length))
      return paramString1[i];
    if (DEBUG)
      Log.d("LauncherAssetManager", "getRecommendFolderName folderNameId = " + i);
    return null;
  }

  public void recycle()
  {
    this.mMainCategoryMap.clear();
    this.mExtraCategoryMap.clear();
    mDefaultShortcutWhiteListMap.clear();
  }

  public void updateExtraAppCategoryFromDatabase()
  {
    ??? = LauncherSharedPrefs.getLauncherPrefs(this.mContext);
    int i = ((SharedPreferences)???).getInt("extra_app_category_version", 0);
    Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://com.nearme.romupdate.provider.db/update_list"), new String[] { "version", "xml" }, "filtername=\"extra_app_category\"", null, null);
    if (localCursor != null);
    try
    {
      if (localCursor.moveToFirst())
      {
        int j = localCursor.getInt(localCursor.getColumnIndex("version"));
        if (DEBUG)
          Log.d("LauncherAssetManager", "updateExtraAppCategoryFromDatabase oldVersion = " + i + " newVersion = " + j);
        if ((i < j) && (string2File(localCursor.getString(localCursor.getColumnIndex("xml")), "extra_app_category")))
        {
          ??? = ((SharedPreferences)???).edit();
          ((SharedPreferences.Editor)???).putInt("extra_app_category_version", j);
          ((SharedPreferences.Editor)???).commit();
        }
      }
      synchronized (this.mLock)
      {
        this.mExtraCategoryMap.clear();
        loadData(getExtraData(), this.mExtraCategoryMap, "US-ASCII");
        if (DEBUG)
          Log.d("LauncherAssetManager", "updateExtraAppCategoryFromDatabase success");
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("LauncherAssetManager", "updateExtraAppCategoryFromDatabase fail e = " + localException);
      return;
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.LauncherAssetManager
 * JD-Core Version:    0.6.2
 */