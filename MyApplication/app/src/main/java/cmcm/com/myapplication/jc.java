package cmcm.com.myapplication;

import android.os.Build.VERSION;
import android.widget.TextView;

public class jc
{
  static final jh a = new jd();

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18)
    {
      a = new jf();
      return;
    }
    if (i >= 17)
    {
      a = new je();
      return;
    }
    if (i >= 16)
    {
      a = new jg();
      return;
    }
  }

  public static int a(TextView paramTextView)
  {
    return a.a(paramTextView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jc
 * JD-Core Version:    0.6.2
 */