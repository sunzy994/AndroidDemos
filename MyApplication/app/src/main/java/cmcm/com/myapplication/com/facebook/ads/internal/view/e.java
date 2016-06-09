package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class e extends LinearLayout
{
  private Bitmap a;
  private Bitmap b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private Bitmap f;
  private int g;
  private int h;

  public e(Context paramContext)
  {
    super(paramContext);
    b();
  }

  private void a()
  {
    if (getHeight() > 0)
    {
      this.h = c();
      this.g = ((int)Math.ceil((getHeight() - this.h) / 2.0F));
      Object localObject = new Matrix();
      ((Matrix)localObject).preScale(1.0F, -1.0F);
      int i = (int)Math.floor((getHeight() - this.h) / 2.0F);
      float f1 = this.a.getHeight() / this.h;
      int j = Math.round(this.g * f1);
      if (j > 0)
      {
        this.f = Bitmap.createBitmap(this.b, 0, 0, this.b.getWidth(), j, (Matrix)localObject, true);
        this.c.setImageBitmap(this.f);
      }
      i = Math.round(i * f1);
      if (i > 0)
      {
        localObject = Bitmap.createBitmap(this.b, 0, this.b.getHeight() - i, this.b.getWidth(), i, (Matrix)localObject, true);
        this.e.setImageBitmap((Bitmap)localObject);
      }
    }
  }

  private void b()
  {
    getContext().getResources().getDisplayMetrics();
    setOrientation(1);
    this.c = new ImageView(getContext());
    this.c.setScaleType(ScaleType.FIT_XY);
    addView(this.c);
    this.d = new ImageView(getContext());
    this.d.setLayoutParams(new LayoutParams(-1, -1));
    this.d.setScaleType(ScaleType.FIT_CENTER);
    addView(this.d);
    this.e = new ImageView(getContext());
    this.e.setScaleType(ScaleType.FIT_XY);
    addView(this.e);
  }

  private int c()
  {
    return (int)Math.round(getWidth() / 1.91D);
  }

  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap1 == null)
    {
      this.d.setImageDrawable(null);
      return;
    }
    this.d.setImageBitmap(Bitmap.createBitmap(paramBitmap1));
    this.a = paramBitmap1;
    this.b = paramBitmap2;
    float f1 = paramBitmap1.getHeight() / paramBitmap1.getWidth();
    a();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a == null) || (this.b == null))
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i = c();
    if ((this.f == null) || (this.h != i))
      a();
    this.c.layout(paramInt1, paramInt2, paramInt3, this.g);
    this.d.layout(paramInt1, this.g + paramInt2, paramInt3, this.g + this.h);
    this.e.layout(paramInt1, this.g + paramInt2 + this.h, paramInt3, paramInt4);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.e
 * JD-Core Version:    0.6.2
 */