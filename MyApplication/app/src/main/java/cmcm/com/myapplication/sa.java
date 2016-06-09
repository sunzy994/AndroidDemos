package cmcm.com.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class sa
{
  private final sd a;
  private String b;
  private ScaleType c;
  private int d;
  private int e;

  public sa(sd paramsd)
  {
    this.a = paramsd;
  }

  public sa a()
  {
    return a(ScaleType.CENTER_CROP);
  }

  public sa a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    return this;
  }

  public sa a(ScaleType paramScaleType)
  {
    this.c = paramScaleType;
    return this;
  }

  public sa a(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public void a(ImageView paramImageView)
  {
    Bundle localBundle = new Bundle(3);
    if (this.d * this.e > 0)
    {
      localBundle.putInt("ow", this.d);
      localBundle.putInt("oh", this.e);
    }
    if (this.c != null)
      localBundle.putInt("ost", this.c.ordinal());
    this.a.a(this.b, paramImageView, localBundle);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sa
 * JD-Core Version:    0.6.2
 */