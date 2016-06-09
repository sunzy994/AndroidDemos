package cmcm.com.myapplication;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public class cl
{
  public static <T> Parcelable.Creator<T> a(cn<T> paramcn)
  {
    if (Build.VERSION.SDK_INT >= 13)
      return cp.a(paramcn);
    return new cm(paramcn);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     cl
 * JD-Core Version:    0.6.2
 */