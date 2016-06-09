package cmcm.com.myapplication.com.lazyswipe.app;

import aap;
import abf;
import acq;
import afs;
import aib;
import aic;
import aiw;
import alk;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import anu;
import apz;
import arl;
import aro;
import asp;
import asq;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.ui.FloatWindowHintView;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import vs;
import wd;
import wo;
import wz;
import xa;
import xb;
import xc;
import xd;
import xe;
import xf;
import xg;
import xi;
import xj;
import xk;
import xl;

public final class DatabaseHelper extends SQLiteOpenHelper
{
  private final Context a;
  private SQLiteDatabase b;

  public DatabaseHelper(Context paramContext)
  {
    super(paramContext, "data.db", null, 36);
    this.a = paramContext;
  }

  private void a()
  {
    a(this.a.getString(2131231208));
  }

  private void a(Context paramContext)
  {
    List localList = anu.b(paramContext);
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      int j;
      for (int i = 0; localIterator.hasNext(); i = j)
      {
        String str = (String)localIterator.next();
        if (!str.equals("GPS"))
        {
          j = i;
          if (!str.equals("Sync"));
        }
        else
        {
          localIterator.remove();
          j = i;
          if (i == 0)
            j = 1;
          Log.i("Swipe.Provider", "Removed tile " + str + " which is no longer available");
        }
      }
      if (i != 0)
        anu.b(paramContext, anu.a(localList));
    }
  }

  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    this.b = SQLiteDatabase.create(null);
    paramSQLiteDatabase.execSQL("ATTACH DATABASE ':memory:' AS memory_db");
    xj.a(paramSQLiteDatabase);
    Log.i("Swipe.Provider", "Notification table attached in memory");
  }

  private void a(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    alk.a(paramBoolean);
    xc.b(paramSQLiteDatabase);
  }

  private void a(String paramString)
  {
    SharedPreferences localSharedPreferences = vs.a(this.a);
    StringBuilder localStringBuilder;
    PackageManager localPackageManager;
    int j;
    int i;
    if (!localSharedPreferences.contains("key_notification_apps_selected"))
    {
      paramString = paramString.split(",");
      localStringBuilder = new StringBuilder();
      localPackageManager = this.a.getPackageManager();
      j = paramString.length;
      i = 0;
    }
    while (true)
    {
      String str;
      if (i < j)
        str = paramString[i];
      try
      {
        localPackageManager.getPackageInfo(str, 0);
        localStringBuilder.append(str).append(',');
        label84: i += 1;
        continue;
        i = localStringBuilder.length();
        if (i > 0);
        for (paramString = localStringBuilder.substring(0, i - 1); ; paramString = "")
        {
          localSharedPreferences.edit().putString("key_notification_apps_selected", paramString).apply();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        break label84;
      }
    }
  }

  private void b()
  {
    SharedPreferences localSharedPreferences = vs.a(this.a);
    Object localObject2 = localSharedPreferences.getString("key_notification_apps_selected", null);
    Object localObject1 = new StringBuilder();
    HashSet localHashSet = new HashSet(0);
    if (localObject2 != null)
    {
      localObject3 = ((String)localObject2).split(",");
      if (localObject3.length > 0)
      {
        localHashSet.addAll(Arrays.asList((Object[])localObject3));
        ((StringBuilder)localObject1).append((String)localObject2).append(',');
      }
    }
    localObject2 = this.a.getString(2131231209).split(",");
    Object localObject3 = this.a.getPackageManager();
    int j = localObject2.length;
    int i = 0;
    while (true)
    {
      String str;
      if (i < j)
        str = localObject2[i];
      try
      {
        ((PackageManager)localObject3).getPackageInfo(str, 0);
        if (!localHashSet.contains(str))
          ((StringBuilder)localObject1).append(str).append(',');
        label159: i += 1;
        continue;
        i = ((StringBuilder)localObject1).length();
        if (i > 0);
        for (localObject1 = ((StringBuilder)localObject1).substring(0, i - 1); ; localObject1 = "")
        {
          localSharedPreferences.edit().putString("key_notification_apps_selected", (String)localObject1).apply();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        break label159;
      }
    }
  }

  // ERROR //
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 210
    //   3: iconst_2
    //   4: anewarray 58	java/lang/String
    //   7: dup
    //   8: iconst_0
    //   9: ldc 212
    //   11: aastore
    //   12: dup
    //   13: iconst_1
    //   14: ldc 214
    //   16: aastore
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 218	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_2
    //   26: new 220	android/content/ContentValues
    //   29: dup
    //   30: bipush 6
    //   32: invokespecial 221	android/content/ContentValues:<init>	(I)V
    //   35: astore_3
    //   36: aload_2
    //   37: invokeinterface 226 1 0
    //   42: ifeq +219 -> 261
    //   45: aload_2
    //   46: iconst_0
    //   47: invokeinterface 230 2 0
    //   52: lstore 7
    //   54: aload_2
    //   55: iconst_1
    //   56: invokeinterface 231 2 0
    //   61: invokestatic 237	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   64: astore 4
    //   66: aload_3
    //   67: ldc 239
    //   69: lload 7
    //   71: invokestatic 245	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   74: invokevirtual 249	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   77: aload_3
    //   78: ldc 251
    //   80: ldc 253
    //   82: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload 4
    //   87: aload_0
    //   88: getfield 19	com/lazyswipe/app/DatabaseHelper:a	Landroid/content/Context;
    //   91: invokestatic 262	aqn:c	(Landroid/net/Uri;Landroid/content/Context;)Landroid/util/Pair;
    //   94: astore 5
    //   96: aload_3
    //   97: ldc_w 264
    //   100: aload 5
    //   102: getfield 270	android/util/Pair:second	Ljava/lang/Object;
    //   105: checkcast 58	java/lang/String
    //   108: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_3
    //   112: ldc_w 272
    //   115: aload 5
    //   117: getfield 275	android/util/Pair:first	Ljava/lang/Object;
    //   120: checkcast 58	java/lang/String
    //   123: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 5
    //   128: getfield 270	android/util/Pair:second	Ljava/lang/Object;
    //   131: checkcast 277	java/lang/CharSequence
    //   134: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifeq +112 -> 249
    //   140: iconst_0
    //   141: istore 6
    //   143: aload_3
    //   144: ldc_w 285
    //   147: iload 6
    //   149: invokestatic 290	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   155: aload_1
    //   156: ldc_w 295
    //   159: aconst_null
    //   160: aload_3
    //   161: invokevirtual 299	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   164: pop2
    //   165: aload_3
    //   166: ldc_w 272
    //   169: invokevirtual 301	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   172: aload_3
    //   173: ldc 251
    //   175: ldc_w 303
    //   178: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload 4
    //   183: aload_0
    //   184: getfield 19	com/lazyswipe/app/DatabaseHelper:a	Landroid/content/Context;
    //   187: invokestatic 306	aqn:b	(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;
    //   190: astore 4
    //   192: aload_3
    //   193: ldc_w 264
    //   196: aload 4
    //   198: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 4
    //   203: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   206: ifeq +49 -> 255
    //   209: iconst_0
    //   210: istore 6
    //   212: aload_3
    //   213: ldc_w 285
    //   216: iload 6
    //   218: invokestatic 290	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   224: aload_1
    //   225: ldc_w 295
    //   228: aconst_null
    //   229: aload_3
    //   230: invokevirtual 299	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   233: pop2
    //   234: goto -198 -> 36
    //   237: astore_1
    //   238: aload_2
    //   239: ifnull +9 -> 248
    //   242: aload_2
    //   243: invokeinterface 309 1 0
    //   248: return
    //   249: iconst_1
    //   250: istore 6
    //   252: goto -109 -> 143
    //   255: iconst_1
    //   256: istore 6
    //   258: goto -46 -> 212
    //   261: aload_2
    //   262: ifnull -14 -> 248
    //   265: aload_2
    //   266: invokeinterface 309 1 0
    //   271: return
    //   272: astore_1
    //   273: aconst_null
    //   274: astore_2
    //   275: aload_2
    //   276: ifnull +9 -> 285
    //   279: aload_2
    //   280: invokeinterface 309 1 0
    //   285: aload_1
    //   286: athrow
    //   287: astore_1
    //   288: goto -13 -> 275
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_2
    //   294: goto -56 -> 238
    //
    // Exception table:
    //   from	to	target	type
    //   26	36	237	java/lang/Throwable
    //   36	140	237	java/lang/Throwable
    //   143	209	237	java/lang/Throwable
    //   212	234	237	java/lang/Throwable
    //   0	26	272	finally
    //   26	36	287	finally
    //   36	140	287	finally
    //   143	209	287	finally
    //   212	234	287	finally
    //   0	26	291	java/lang/Throwable
  }

  private void b(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
  }

  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    wz.a(paramSQLiteDatabase);
  }

  private void c(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (vs.f());
    for (int i = 1; ; i = 2)
    {
      paramBoolean = FloatWindowHintView.a(this.a);
      vs.a(this.a).edit().putBoolean("float_window_enabled", paramBoolean).putString("temperatur_unit", String.valueOf(i)).apply();
      acq.a().b();
      return;
    }
  }

  private void d(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  private void d(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    aiw.a(this.a, true);
  }

  private void e(SQLiteDatabase paramSQLiteDatabase)
  {
    xe.a(paramSQLiteDatabase);
    xc.c(paramSQLiteDatabase);
  }

  private void e(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (!paramBoolean)
      paramSQLiteDatabase.execSQL("DROP TABLE  IF EXISTS topic");
    xi.a(paramSQLiteDatabase);
    if (!paramBoolean)
    {
      SharedPreferences localSharedPreferences = vs.a(this.a);
      Object localObject = localSharedPreferences.getString("key_cached_news", null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
        abf.a(paramSQLiteDatabase, (String)localObject);
      long l = localSharedPreferences.getLong("key_last_news_fetch_time", 0L);
      if ((l > 0L) && (System.currentTimeMillis() - l < 86400000L))
      {
        localObject = new ContentValues(2);
        ((ContentValues)localObject).put("code", Long.valueOf(104L));
        ((ContentValues)localObject).put("last_op", Long.valueOf(l));
        paramSQLiteDatabase.replace("op_log", null, (ContentValues)localObject);
      }
      localSharedPreferences.edit().remove("key_cached_news").remove("key_last_news_fetch_time").apply();
    }
  }

  private void f(SQLiteDatabase paramSQLiteDatabase)
  {
    xk.a(paramSQLiteDatabase);
  }

  private void f(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE application ADD COLUMN custom_tab_pos INTEGER DEFAULT 0");
    aap.a(SwipeApplication.c());
  }

  private void g(SQLiteDatabase paramSQLiteDatabase)
  {
    abf.d(this.a);
  }

  private void g(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    paramSQLiteDatabase = SwipeApplication.c();
    if (!paramBoolean)
    {
      aic.a();
      aib.b(paramSQLiteDatabase);
      if (!asq.c(paramSQLiteDatabase, "com.lazyswipe.pro2"))
        apz.c(paramSQLiteDatabase);
      new File(aro.d(), "files").setExecutable(true, false);
    }
  }

  private void h(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  private void i(SQLiteDatabase paramSQLiteDatabase)
  {
    xa.a(paramSQLiteDatabase);
    xl.a(paramSQLiteDatabase);
  }

  private void j(SQLiteDatabase paramSQLiteDatabase)
  {
    xf.a(paramSQLiteDatabase);
  }

  private void k(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  private void l(SQLiteDatabase paramSQLiteDatabase)
  {
    xb.a(paramSQLiteDatabase);
  }

  private void m(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  private void n(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  private void o(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  private void p(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  private void q(SQLiteDatabase paramSQLiteDatabase)
  {
    xc.a(paramSQLiteDatabase);
    xd.a(paramSQLiteDatabase);
  }

  public void close()
  {
    if (this.b != null)
    {
      if (this.b.isOpen())
        this.b.close();
      this.b = null;
    }
    super.close();
  }

  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase1 = super.getWritableDatabase();
      if (this.b == null)
        a(localSQLiteDatabase1);
      return localSQLiteDatabase1;
    }
    catch (wo localwo)
    {
      while (true)
      {
        asp.a("Swipe.Provider", "Delete the database file for downgrade");
        this.a.deleteDatabase("data.db");
        SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
      }
    }
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    asp.a("Swipe.Provider", "Database create: 36");
    vs.c();
    a();
    xg.a(paramSQLiteDatabase);
    i(paramSQLiteDatabase);
    j(paramSQLiteDatabase);
    k(paramSQLiteDatabase);
    l(paramSQLiteDatabase);
    m(paramSQLiteDatabase);
    n(paramSQLiteDatabase);
    o(paramSQLiteDatabase);
    p(paramSQLiteDatabase);
    q(paramSQLiteDatabase);
    c(paramSQLiteDatabase);
    a(paramSQLiteDatabase, true);
    d(paramSQLiteDatabase);
    b(paramSQLiteDatabase, true);
    e(paramSQLiteDatabase);
    f(paramSQLiteDatabase);
    g(paramSQLiteDatabase);
    h(paramSQLiteDatabase);
    c(paramSQLiteDatabase, true);
    d(paramSQLiteDatabase, true);
    e(paramSQLiteDatabase, true);
    f(paramSQLiteDatabase, true);
    g(paramSQLiteDatabase, true);
  }

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    asp.a("Swipe.Provider", "Database downgrade: " + paramInt1 + " -> " + paramInt2);
    throw new wo(null);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 1;
    asp.a("Swipe.Provider", "Database upgrade: " + paramInt1 + " -> " + paramInt2);
    vs.c();
    if (paramInt1 < 2)
      xg.b(paramSQLiteDatabase);
    if (paramInt1 < 3)
      xg.a(paramSQLiteDatabase, this);
    if (paramInt1 < 4)
      i(paramSQLiteDatabase);
    for (paramInt2 = 0; ; paramInt2 = 1)
    {
      if (paramInt1 < 5)
        xg.b(paramSQLiteDatabase, this);
      if (paramInt1 < 6)
      {
        j(paramSQLiteDatabase);
        xg.c(paramSQLiteDatabase);
        vs.a(this.a, "", false);
        if (arl.h(this.a))
          wd.a(this.a);
        vs.f(this.a, false);
        vs.a(this.a).edit().remove("key_settings_launch_count").apply();
      }
      if (paramInt1 < 7)
        k(paramSQLiteDatabase);
      if ((paramInt1 < 8) && (paramInt2 != 0))
        xa.b(paramSQLiteDatabase);
      if (paramInt1 < 9)
      {
        xf.b(paramSQLiteDatabase);
        paramSQLiteDatabase.execSQL("DROP TABLE  IF EXISTS app_group");
        l(paramSQLiteDatabase);
        vs.a(this.a).edit().putInt("key_tutorial_step", 98).apply();
      }
      if (paramInt1 < 10)
        vs.g(this.a);
      if (paramInt1 < 11)
        m(paramSQLiteDatabase);
      if (paramInt1 < 12)
        n(paramSQLiteDatabase);
      if (paramInt1 < 13)
      {
        vs.g(this.a);
        o(paramSQLiteDatabase);
      }
      if (paramInt1 < 14)
      {
        p(paramSQLiteDatabase);
        xa.c(paramSQLiteDatabase);
      }
      SharedPreferences localSharedPreferences;
      Editor localEditor;
      if (paramInt1 < 15)
      {
        a(this.a);
        localSharedPreferences = vs.a(this.a);
        localEditor = localSharedPreferences.edit();
        if (!localSharedPreferences.contains("key_toucher_size_scale"))
          localEditor.putInt("key_toucher_size_scale", 48);
        localEditor.remove("key_hint_edit_switcher").remove("key_hint_edit_favorites").apply();
      }
      if (paramInt1 < 16)
      {
        com.lazyswipe.features.guide.UpgradeGuideActivity.i = true;
        q(paramSQLiteDatabase);
        vs.a(this.a).edit().remove("key_recent_contacts").remove("key_notification_details").remove("key_hint_dismiss_notifications").remove("key_last_accessibility_action_tip_shown").apply();
      }
      if (paramInt1 < 18)
      {
        c(paramSQLiteDatabase);
        b(paramSQLiteDatabase);
      }
      if (paramInt1 < 19)
        a(paramSQLiteDatabase, false);
      if (paramInt1 < 20)
      {
        b();
        localSharedPreferences = vs.a(this.a);
        if (localSharedPreferences.contains("key_device_setup_completed"))
          localSharedPreferences.edit().remove("key_device_setup_completed").apply();
      }
      if (paramInt1 < 21)
        d(paramSQLiteDatabase);
      if (paramInt1 < 22)
      {
        b(paramSQLiteDatabase, false);
        paramSQLiteDatabase.execSQL("DROP VIEW  IF EXISTS lucky_app_sorted");
        paramSQLiteDatabase.execSQL("DROP VIEW  IF EXISTS notify_app_sorted");
        paramSQLiteDatabase.execSQL("DROP VIEW  IF EXISTS boost_app_sorted");
        paramSQLiteDatabase.execSQL("DROP TABLE  IF EXISTS touch_fix");
        paramSQLiteDatabase.execSQL("DROP TABLE  IF EXISTS app_click");
      }
      if (paramInt1 < 23)
        e(paramSQLiteDatabase);
      if (paramInt1 < 24)
        f(paramSQLiteDatabase);
      if (paramInt1 < 25)
        g(paramSQLiteDatabase);
      if (paramInt1 < 26)
        afs.a(this.a);
      if (paramInt1 < 27)
        h(paramSQLiteDatabase);
      if (paramInt1 < 29)
        vs.b(this.a, "key_contacts_inited", true);
      if (paramInt1 < 30)
      {
        localSharedPreferences = vs.a(this.a);
        localEditor = localSharedPreferences.edit().putBoolean("key_add_clicked_in_favorites", true);
        if (!localSharedPreferences.contains("key_notification_style"))
          localEditor.putString("key_notification_style", String.valueOf(1));
        localEditor.apply();
      }
      if (paramInt1 < 31)
      {
        localSharedPreferences = vs.a(this.a);
        localEditor = localSharedPreferences.edit();
        if (!localSharedPreferences.contains("temperatur_unit"))
          break label892;
        boolean bool = localSharedPreferences.getBoolean("temperatur_unit", false);
        localEditor.remove("temperatur_unit").apply();
        if (!bool)
          break label887;
      }
      label887: for (paramInt2 = i; ; paramInt2 = 2)
      {
        localEditor.putString("temperatur_unit", String.valueOf(paramInt2)).apply();
        acq.a().b();
        if (paramInt1 < 32)
          d(paramSQLiteDatabase, false);
        if (paramInt1 < 33)
          e(paramSQLiteDatabase, false);
        if (paramInt1 < 34)
          paramSQLiteDatabase.execSQL("DROP TABLE  IF EXISTS promotion_app");
        if (paramInt1 < 35)
          f(paramSQLiteDatabase, false);
        if (paramInt1 < 36)
          g(paramSQLiteDatabase, false);
        return;
      }
      label892: if (vs.f());
      for (paramInt2 = j; ; paramInt2 = 2)
      {
        localEditor.putString("temperatur_unit", String.valueOf(paramInt2)).apply();
        break;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.app.DatabaseHelper
 * JD-Core Version:    0.6.2
 */