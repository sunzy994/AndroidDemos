package cmcm.com.myapplication.com.lazyswipe.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import arp;
import aua;
import java.lang.reflect.Field;

public class FixWidthHeightRatioImageView extends ImageView
{
  public float a = -1.0F;
  public int b;
  public int c;
  private Field d;
  private Field e;

  public FixWidthHeightRatioImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT < 16)
    {
      this.d = arp.c(ImageView.class, "mMaxWidth");
      this.e = arp.c(ImageView.class, "mMaxHeight");
    }
  }

  private void a(Drawable paramDrawable)
  {
    if ((paramDrawable != null) && (!(paramDrawable instanceof aua)))
    {
      Drawable localDrawable = paramDrawable;
      if ((paramDrawable instanceof TransitionDrawable))
        localDrawable = ((TransitionDrawable)paramDrawable).getDrawable(1);
      if (localDrawable.getIntrinsicHeight() > 0)
      {
        this.c = localDrawable.getIntrinsicHeight();
        this.b = localDrawable.getIntrinsicWidth();
        this.a = (this.c / this.b);
        return;
      }
      this.c = localDrawable.getBounds().height();
      this.b = localDrawable.getBounds().width();
      this.a = (this.c / this.b);
      return;
    }
    this.b = 0;
    this.c = 0;
    this.a = -1.0F;
  }

  private boolean a()
  {
    float f = getFixRatio();
    if (f > 0.0F);
    for (boolean bool = true; ; bool = false)
    {
      if ((bool) && (this.a <= 0.0F))
        this.a = f;
      return bool;
    }
  }

  public float getFixRatio()
  {
    return -1.0F;
  }

  public int getMaxHeight()
  {
    if (Build.VERSION.SDK_INT < 16)
      try
      {
        int i = ((Integer)arp.a(this, this.e)).intValue();
        return i;
      }
      catch (Throwable localThrowable)
      {
        return 2147483647;
      }
    return super.getMaxHeight();
  }

  public int getMaxWidth()
  {
    if (Build.VERSION.SDK_INT < 16)
      try
      {
        int i = ((Integer)arp.a(this, this.d)).intValue();
        return i;
      }
      catch (Throwable localThrowable)
      {
        return 2147483647;
      }
    return super.getMaxWidth();
  }

  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.a <= 0.0F)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt1), getMaxWidth());
    setMeasuredDimension(paramInt1, Math.min((int)(this.a * paramInt1), getMaxHeight()));
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    if (a())
      return;
    if (paramBitmap != null)
    {
      this.c = paramBitmap.getHeight();
      this.b = paramBitmap.getWidth();
      this.a = (this.c / this.b);
      return;
    }
    this.b = 0;
    this.c = 0;
    this.a = -1.0F;
  }

  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (a())
      return;
    a(paramDrawable);
  }

  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    if (a())
      return;
    a(getDrawable());
  }

  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (a())
      return;
    a(getDrawable());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.FixWidthHeightRatioImageView
 * JD-Core Version:    0.6.2
 */