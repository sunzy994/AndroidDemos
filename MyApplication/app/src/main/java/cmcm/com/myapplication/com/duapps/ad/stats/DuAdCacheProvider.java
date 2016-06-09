package cmcm.com.myapplication.com.duapps.ad.stats;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import mv;
import of;

public final class DuAdCacheProvider extends ContentProvider
{
  private static Uri b;
  private static Uri c;
  private static Uri d;
  private static Uri e;
  private static Uri f;
  private static Uri g;
  private static final Object h = new Object();
  private static final Object j = new Object();
  private static final Object l = new Object();
  private static UriMatcher n;
  private String a = DuAdCacheProvider.class.getSimpleName();
  private of i;
  private q k;
  private n m;
  private Context o;

  private int a(Uri paramUri)
  {
    if ((paramUri == null) || (Uri.EMPTY == paramUri))
      return -1;
    int i1 = n.match(paramUri);
    mv.c(this.a, "match code = " + i1);
    return i1;
  }

  public static Uri a(Context paramContext, int paramInt)
  {
    Uri localUri = Uri.EMPTY;
    if (b == null)
    {
      paramContext = paramContext.getPackageName() + ".DuAdCacheProvider";
      b = Uri.parse("content://" + paramContext);
    }
    if (c == null)
      c = Uri.withAppendedPath(b, "parse");
    if (d == null)
      d = Uri.withAppendedPath(b, "click");
    if (e == null)
      e = Uri.withAppendedPath(b, "cache");
    if (f == null)
      f = Uri.withAppendedPath(b, "record");
    if (g == null)
      g = Uri.withAppendedPath(b, "preparse");
    switch (paramInt)
    {
    default:
      return localUri;
    case 1:
      return c;
    case 3:
      return e;
    case 2:
      return d;
    case 5:
      return g;
    case 4:
    }
    return f;
  }

  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return "ad_parse";
    case 3:
      return "cache";
    case 2:
      return "tbvc";
    case 5:
      return "appcache";
    case 4:
    }
    return "srecord";
  }

  private SQLiteDatabase b(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      if (this.k == null)
        this.k = new q(paramContext);
      return this.k.getWritableDatabase();
    case 2:
    case 3:
    case 5:
      if (this.i == null)
        this.i = new of(paramContext);
      return this.i.getWritableDatabase();
    case 4:
    }
    if (this.m == null)
      this.m = new n(paramContext);
    return this.m.getWritableDatabase();
  }

  private static Object b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return j;
    case 2:
    case 3:
    case 5:
      return h;
    case 4:
    }
    return l;
  }

  public final int delete(Uri arg1, String paramString, String[] paramArrayOfString)
  {
    String str2 = this.a;
    if ("del selcetion  = " + paramString + " , selectionArgs = " + paramString != null);
    int i1;
    for (String str1 = paramString.toString(); ; str1 = null)
    {
      mv.c(str2, str1);
      i1 = a(???);
      if ((i1 > 0) && (i1 <= 5))
        break;
      return -1;
    }
    synchronized (b(i1))
    {
      i1 = b(getContext(), i1).delete(a(i1), paramString, paramArrayOfString);
      return i1;
    }
  }

  public final String getType(Uri paramUri)
  {
    switch (n.match(paramUri))
    {
    default:
      return "vnd.android.cursor.dir/unkown";
    case 1:
      return "vnd.android.cursor.dir/parse";
    case 2:
      return "vnd.android.cursor.dir/click";
    case 3:
      return "vnd.android.cursor.dir/cache";
    case 5:
      return "vnd.android.cursor.dir/preparse";
    case 4:
    }
    return "vnd.android.cursor.dir/record";
  }

  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    int i1 = a(paramUri);
    if ((i1 <= 0) || (i1 > 5))
      return null;
    synchronized (b(i1))
    {
      b(getContext(), i1).insert(a(i1), null, paramContentValues);
      return paramUri;
    }
  }

  public final boolean onCreate()
  {
    this.o = getContext();
    Object localObject1 = this.o;
    localObject1 = ((Context)localObject1).getPackageName() + ".DuAdCacheProvider";
    Object localObject2 = Uri.parse("content://" + (String)localObject1);
    b = (Uri)localObject2;
    c = Uri.withAppendedPath((Uri)localObject2, "parse");
    d = Uri.withAppendedPath(b, "click");
    e = Uri.withAppendedPath(b, "cache");
    f = Uri.withAppendedPath(b, "record");
    g = Uri.withAppendedPath(b, "preparse");
    localObject2 = new UriMatcher(-1);
    ((UriMatcher)localObject2).addURI((String)localObject1, "parse", 1);
    ((UriMatcher)localObject2).addURI((String)localObject1, "click", 2);
    ((UriMatcher)localObject2).addURI((String)localObject1, "cache", 3);
    ((UriMatcher)localObject2).addURI((String)localObject1, "record", 4);
    ((UriMatcher)localObject2).addURI((String)localObject1, "preparse", 5);
    n = (UriMatcher)localObject2;
    return true;
  }

  public final Cursor query(Uri arg1, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i1 = a(???);
    if ((i1 <= 0) || (i1 > 5))
      return null;
    synchronized (b(i1))
    {
      paramArrayOfString1 = b(getContext(), i1).query(a(i1), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      return paramArrayOfString1;
    }
  }

  public final int update(Uri arg1, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int i1 = a(???);
    if ((i1 <= 0) || (i1 > 5))
      return -1;
    synchronized (b(i1))
    {
      i1 = b(getContext(), i1).update(a(i1), paramContentValues, paramString, paramArrayOfString);
      return i1;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.duapps.ad.stats.DuAdCacheProvider
 * JD-Core Version:    0.6.2
 */