package cmcm.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public abstract class ady extends adp
  implements OnClickListener
{
  private final ImageView h;
  private View i;

  public ady(Context paramContext)
  {
    super(paramContext);
    this.h = new ImageView(paramContext);
    this.h.setAdjustViewBounds(true);
    this.h.setBackgroundColor(-2236963);
    this.h.setScaleType(ScaleType.FIT_XY);
    addView(this.h, new FrameLayout.LayoutParams(b, c));
    this.i = LayoutInflater.from(paramContext).inflate(2130968598, null);
    addView(this.i, new FrameLayout.LayoutParams(b, c));
    this.i.setVisibility(8);
    this.i.setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ady.this.e != null)
          ady.this.a(ady.this.e);
      }
    });
    setOnClickListener(this);
  }

  public void a(Object paramObject)
  {
    super.a(paramObject);
    this.i.setVisibility(8);
  }

  public void b()
  {
  }

  public void f()
  {
    super.f();
    this.i.setVisibility(0);
  }

  public int getBitmapReqHeight()
  {
    return c;
  }

  public int getBitmapReqWidth()
  {
    return b;
  }

  public ImageView getBitmapView()
  {
    return this.h;
  }

  public adt getCardHolder()
  {
    return new adz(this);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.h.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ady
 * JD-Core Version:    0.6.2
 */