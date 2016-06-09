package cmcm.com.myapplication;

import android.view.View;

public class yl
{
  public int a;
  public int b;

  public yl(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public yl(int paramInt1, int paramInt2, View paramView, boolean paramBoolean)
  {
    this(paramInt1, paramInt2);
    if (paramView != null)
    {
      this.b = (paramView.getHeight() - paramInt2);
      if (!paramBoolean)
        this.a = (paramInt1 - paramView.getWidth());
    }
  }

  public float a()
  {
    return (float)Math.sqrt(this.a * this.a + this.b * this.b);
  }

  public String toString()
  {
    return String.format("(%d, %d)", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yl
 * JD-Core Version:    0.6.2
 */