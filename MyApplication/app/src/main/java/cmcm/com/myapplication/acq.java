package cmcm.com.myapplication;

import android.graphics.Bitmap;
import com.lazyswipe.SwipeApplication;
import java.io.File;

public class acq
  implements atm
{
  private static acq a;
  private final acr b = new acr(this);
  private boolean c;

  public static acq a()
  {
    if (a == null)
      a = new acq();
    return a;
  }

  private boolean c(String paramString)
  {
    return b(paramString).exists();
  }

  public Bitmap a(String paramString)
  {
    return this.b.a(paramString);
  }

  public void a(File paramFile)
  {
  }

  public File b(String paramString)
  {
    return new File(this.b.b(), paramString + ".png");
  }

  public void b()
  {
    if (this.c)
      return;
    this.c = true;
    this.b.d();
  }

  public boolean m_()
  {
    return (c("float_cleaner_border")) && (c("float_cleaner_cap")) && (c("float_cleaner_fan_fast")) && (c("float_cleaner_shadow")) && (c("float_cleaner_leaf")) && (c("float_cleaner_mask")) && (c("float_cleaner_fan_slow"));
  }

  public void n_()
  {
    this.c = false;
    vs.b(SwipeApplication.c(), "clean_res_ok", true);
    acw.c(SwipeApplication.c(), false);
  }

  public void o_()
  {
    this.c = false;
  }

  public void p_()
  {
  }

  public void q_()
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acq
 * JD-Core Version:    0.6.2
 */