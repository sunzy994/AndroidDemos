package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class gf extends ViewGroup.LayoutParams
{
  public boolean a;
  public int b;
  public float c = 0.0F;
  public boolean d;
  public int e;
  public int f;

  public gf()
  {
    super(-1, -1);
  }

  public gf(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.access$400());
    this.b = paramContext.getInteger(0, 48);
    paramContext.recycle();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     gf
 * JD-Core Version:    0.6.2
 */