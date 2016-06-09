package cmcm.com.myapplication;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class hs
{
  private static final ht a = new hw();
  private final Object b;

  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new hv();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new hu();
      return;
    }
  }

  public hs()
  {
    this.b = a.a(this);
  }

  public hs(Object paramObject)
  {
    this.b = paramObject;
  }

  public hg a(int paramInt)
  {
    return null;
  }

  public Object a()
  {
    return this.b;
  }

  public List<hg> a(String paramString, int paramInt)
  {
    return null;
  }

  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }

  public hg b(int paramInt)
  {
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     hs
 * JD-Core Version:    0.6.2
 */