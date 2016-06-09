package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import java.util.Locale;

public class xf
  implements BaseColumns
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/default_favorites");
  public static final String b = "'" + Locale.CHINA.getLanguage() + "'";
  public static final String c = "'" + Locale.CHINA.getCountry() + "'";

  static String a(Locale paramLocale, int paramInt)
  {
    String str = "'" + paramLocale.getLanguage() + "'";
    paramLocale = "'" + paramLocale.getCountry() + "'";
    return " (language IS NULL  OR  (include=1 AND  ( (match_country=1 AND language=" + str + " AND " + "country" + "=" + paramLocale + ")" + " OR " + " (" + "match_country" + "=0" + " AND " + "language" + "=" + str + ")" + ")" + ")" + " OR " + " (" + "include" + "=0" + " AND " + " (" + " (" + "match_country" + "=1" + " AND " + "language" + "<>" + str + " AND " + "country" + "<>" + paramLocale + ")" + " OR " + " (" + "match_country" + "=0" + " AND " + "language" + "<>" + str + ")" + ")" + ")" + ")" + " AND " + " (" + "app_type" + "=" + paramInt + ")";
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS default_favorites (_id INTEGER PRIMARY KEY, package TEXT NOT NULL, language TEXT , country TEXT , include INTEGER DEFAULT 1, match_country INTEGER DEFAULT 1, app_type INTEGER )");
    paramSQLiteDatabase.execSQL("CREATE INDEX index_default_favorites_package ON default_favorites (package)");
    c(paramSQLiteDatabase);
  }

  private static void a(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO default_favorites (package, app_type) VALUES  ('" + paramString + "'" + ", " + paramInt + ")");
  }

  private static void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, int paramInt)
  {
    paramString2 = "'" + paramString2 + "'";
    paramSQLiteDatabase.execSQL("INSERT INTO default_favorites (package, include, language, match_country, app_type) VALUES  ('" + paramString1 + "'" + ", " + ash.a + ", " + paramString2 + ", " + ash.b + ", " + paramInt + ")");
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE default_favorites ADD COLUMN app_type INTEGER ");
      label6: c(paramSQLiteDatabase);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label6;
    }
  }

  private static void b(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO default_favorites (package, include, language, country, app_type) VALUES  ('" + paramString + "'" + ", " + ash.b + ", " + b + ", " + c + ", " + paramInt + ")");
  }

  private static void c(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(" DELETE FROM default_favorites");
    b(paramSQLiteDatabase, "com.facebook.katana", 0);
    b(paramSQLiteDatabase, "jp.naver.line.android", 0);
    b(paramSQLiteDatabase, "com.instagram.android", 0);
    b(paramSQLiteDatabase, "com.twitter.android", 0);
    b(paramSQLiteDatabase, "com.sgiggle.production", 0);
    a(paramSQLiteDatabase, "com.sina.weibo", 0);
    a(paramSQLiteDatabase, "com.skout.android", 0);
    a(paramSQLiteDatabase, "com.linkedin.android", 0);
    b(paramSQLiteDatabase, "com.snapchat.android", 0);
    b(paramSQLiteDatabase, "com.google.android.apps.plus", 0);
    a(paramSQLiteDatabase, "com.immomo.momo", 0);
    a(paramSQLiteDatabase, "com.tencent.mobileqq", 0);
    a(paramSQLiteDatabase, "com.nice.main", 0);
    a(paramSQLiteDatabase, "com.whatsapp", 0);
    a(paramSQLiteDatabase, "co.vine.android", 0);
    a(paramSQLiteDatabase, "com.minus.android", 0);
    a(paramSQLiteDatabase, "com.duowan.mobile", 0);
    b(paramSQLiteDatabase, "com.banjo.android", 0);
    a(paramSQLiteDatabase, "com.tencent.mm", 0);
    b(paramSQLiteDatabase, "com.facebook.orca", 0);
    a(paramSQLiteDatabase, "com.wSkype", 0);
    b(paramSQLiteDatabase, "com.google.android.apps.messaging", 0);
    a(paramSQLiteDatabase, "com.vkontakte.android", "ru", 0);
    b(paramSQLiteDatabase, "com.google.android.gm", 0);
    a(paramSQLiteDatabase, "com.whatsappkh", 0);
    a(paramSQLiteDatabase, "com.viber.voip", 0);
    a(paramSQLiteDatabase, "com.kakao.talk", 0);
    a(paramSQLiteDatabase, "com.yahoo.mobile.client.android.im", 0);
    a(paramSQLiteDatabase, "org.telegram.messenger", 0);
    b(paramSQLiteDatabase, "com.google.android.youtube", 1);
    a(paramSQLiteDatabase, "com.qiyi.video", 1);
    a(paramSQLiteDatabase, "com.letv.android.client", 1);
    a(paramSQLiteDatabase, "com.sohu.sohuvideo", 1);
    a(paramSQLiteDatabase, "com.pplive.androidphone", 1);
    a(paramSQLiteDatabase, "tv.pps.mobile", 1);
    a(paramSQLiteDatabase, "com.tudou.android", 1);
    b(paramSQLiteDatabase, "com.android.vending", 2);
    c(paramSQLiteDatabase, "com.qihoo.appstore", 2);
    c(paramSQLiteDatabase, "com.wandoujia.phoenix2", 2);
    c(paramSQLiteDatabase, "com.tencent.android.qqdownloader", 2);
    c(paramSQLiteDatabase, "com.xiaomi.shop", 2);
    c(paramSQLiteDatabase, "com.baidu.appsearch", 2);
    a(paramSQLiteDatabase, "com.android.chrome", 3);
    a(paramSQLiteDatabase, "org.mozilla.firefox", 3);
    a(paramSQLiteDatabase, "com.UCMobile.intl", 3);
    a(paramSQLiteDatabase, "com.opera.mini.android", 3);
    b(paramSQLiteDatabase, "com.ebay.mobile", 4);
    a(paramSQLiteDatabase, "com.taobao.taobao", 4);
    a(paramSQLiteDatabase, "com.tmall.wireless", 4);
    a(paramSQLiteDatabase, "com.jingdong.app.mall", 4);
  }

  private static void c(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO default_favorites (package, include, language, country, app_type) VALUES  ('" + paramString + "'" + ", " + ash.a + ", " + b + ", " + c + ", " + paramInt + ")");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xf
 * JD-Core Version:    0.6.2
 */