package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class ajb extends FrameLayout
{
  public static boolean a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private List<Drawable> h = new ArrayList();
  private yb i;

  public ajb(Context paramContext)
  {
    super(paramContext);
    int j = vj.e;
    this.b = ((int)(j * 0.08F));
    this.c = ((int)(j * 0.92F));
    this.d = ((int)(vj.f * -0.4F));
    this.e = 0;
    this.f = 1800;
    this.g = 3300;
  }

  public static boolean a(Context paramContext, yb paramyb)
  {
    if (!a);
    List localList;
    do
    {
      return false;
      a = false;
      localList = ahx.b(paramContext).I();
    }
    while (asq.a(localList));
    paramContext = new ajb(paramContext);
    paramContext.h = localList;
    paramContext.i = paramyb;
    paramyb.addView(paramContext, new LayoutParams(-1, -1));
    return true;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    int j = 0;
    while (j < 40)
    {
      addView(new ajc(this, getContext()), new LayoutParams(-2, -2));
      j += 1;
    }
    postDelayed(new Runnable()
    {
      public void run()
      {
        ajb.a(ajb.this).removeView(ajb.this);
      }
    }
    , this.g + 17);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajb
 * JD-Core Version:    0.6.2
 */