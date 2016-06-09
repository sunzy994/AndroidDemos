package cmcm.com.myapplication;

import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.List;

public class acl
{
  public String a;
  public Drawable b;
  public String c;
  public long d;
  public boolean e;
  public boolean f;
  public final List<Integer> g = new ArrayList();

  public static String a(long paramLong)
  {
    String str = "" + paramLong + "K";
    if (paramLong > 1024L)
    {
      paramLong /= 1024L;
      str = "" + paramLong + "M";
    }
    return str;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acl
 * JD-Core Version:    0.6.2
 */