package cmcm.com.myapplication;

import android.database.Cursor;
import android.os.Environment;
import java.io.File;

public class pe
{
  public String c;
  public String d;
  public String e;
  public long f;
  public int g;
  public int h;
  public String i;
  public String j;
  public int k;
  public String l;
  public String m;
  public String n;

  public static File a(String paramString)
  {
    return new File(Environment.getExternalStorageDirectory(), "cantk-rt-v8/games/" + paramString + File.separator + "res.zip");
  }

  public static pe a(Cursor paramCursor)
  {
    try
    {
      pe localpe = new pe();
      localpe.c = paramCursor.getString(paramCursor.getColumnIndex("name"));
      localpe.d = paramCursor.getString(paramCursor.getColumnIndex("key"));
      localpe.e = paramCursor.getString(paramCursor.getColumnIndex("resUrl"));
      localpe.j = paramCursor.getString(paramCursor.getColumnIndex("icon"));
      localpe.k = paramCursor.getInt(paramCursor.getColumnIndex("version"));
      localpe.f = paramCursor.getLong(paramCursor.getColumnIndex("size"));
      localpe.l = paramCursor.getString(paramCursor.getColumnIndex("brief"));
      localpe.h = paramCursor.getInt(paramCursor.getColumnIndex("horizontal"));
      localpe.g = paramCursor.getInt(paramCursor.getColumnIndex("accelerate"));
      localpe.i = paramCursor.getString(paramCursor.getColumnIndex("init"));
      localpe.m = paramCursor.getString(paramCursor.getColumnIndex("md5"));
      localpe.n = b(localpe.d);
      return localpe;
    }
    catch (Throwable paramCursor)
    {
    }
    return null;
  }

  public static String b(String paramString)
  {
    return a(paramString).getAbsolutePath();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     pe
 * JD-Core Version:    0.6.2
 */