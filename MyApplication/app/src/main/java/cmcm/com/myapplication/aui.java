package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class aui extends Drawable
{
  private CharSequence a;
  protected Drawable b;
  private Paint c;
  private int d;
  private int e;
  private int f;
  private float g;
  private float h;

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect();
    this.c.getTextBounds(this.a.toString(), 0, this.f, localRect);
    this.g = ((paramInt3 - paramInt1 - localRect.width() >> 1) + paramInt1 - c());
    this.h = (paramInt4 - (paramInt4 - paramInt2 - localRect.height() >> 1) - a());
  }

  private void b()
  {
    a(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
  }

  protected int a()
  {
    return 0;
  }

  protected void a(CharSequence paramCharSequence, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.a = paramCharSequence;
    this.b = paramDrawable;
    this.e = paramInt1;
    this.d = paramInt2;
    this.c = new Paint(7);
    this.c.setTextSize(this.d);
    this.c.setColor(this.e);
    this.f = paramCharSequence.length();
    b();
  }

  @TargetApi(21)
  public void applyTheme(Theme paramTheme)
  {
    this.b.applyTheme(paramTheme);
  }

  protected int c()
  {
    return asq.a(1.0F);
  }

  @TargetApi(21)
  public boolean canApplyTheme()
  {
    return this.b.canApplyTheme();
  }

  public void clearColorFilter()
  {
    this.b.clearColorFilter();
  }

  public void draw(Canvas paramCanvas)
  {
    this.b.draw(paramCanvas);
    paramCanvas.drawText(this.a, 0, this.f, this.g, this.h, this.c);
  }

  @TargetApi(19)
  public int getAlpha()
  {
    return this.b.getAlpha();
  }

  public Callback getCallback()
  {
    return this.b.getCallback();
  }

  public int getChangingConfigurations()
  {
    return this.b.getChangingConfigurations();
  }

  @TargetApi(21)
  public ColorFilter getColorFilter()
  {
    return this.b.getColorFilter();
  }

  public ConstantState getConstantState()
  {
    return this.b.getConstantState();
  }

  public Drawable getCurrent()
  {
    return this.b.getCurrent();
  }

  @TargetApi(21)
  public Rect getDirtyBounds()
  {
    return this.b.getDirtyBounds();
  }

  public int getIntrinsicHeight()
  {
    return this.b.getIntrinsicHeight();
  }

  public int getIntrinsicWidth()
  {
    return this.b.getIntrinsicWidth();
  }

  public int getMinimumHeight()
  {
    return this.b.getMinimumHeight();
  }

  public int getMinimumWidth()
  {
    return this.b.getMinimumWidth();
  }

  public int getOpacity()
  {
    return this.b.getOpacity();
  }

  @TargetApi(21)
  public void getOutline(Outline paramOutline)
  {
    this.b.getOutline(paramOutline);
  }

  public boolean getPadding(Rect paramRect)
  {
    return this.b.getPadding(paramRect);
  }

  public int[] getState()
  {
    return this.b.getState();
  }

  public Region getTransparentRegion()
  {
    return this.b.getTransparentRegion();
  }

  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    this.b.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }

  @TargetApi(21)
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Theme paramTheme)
  {
    this.b.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }

  public void invalidateSelf()
  {
    this.b.invalidateSelf();
  }

  @TargetApi(19)
  public boolean isAutoMirrored()
  {
    return this.b.isAutoMirrored();
  }

  public boolean isStateful()
  {
    return this.b.isStateful();
  }

  public void jumpToCurrentState()
  {
    this.b.jumpToCurrentState();
  }

  public Drawable mutate()
  {
    try
    {
      Drawable localDrawable = this.b.mutate();
      return localDrawable;
    }
    catch (Exception localException)
    {
    }
    return this;
  }

  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    this.b.scheduleSelf(paramRunnable, paramLong);
  }

  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
  }

  @TargetApi(19)
  public void setAutoMirrored(boolean paramBoolean)
  {
    this.b.setAutoMirrored(paramBoolean);
  }

  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setBounds(Rect paramRect)
  {
    super.setBounds(paramRect);
    this.b.setBounds(paramRect);
  }

  public void setChangingConfigurations(int paramInt)
  {
    this.b.setChangingConfigurations(paramInt);
  }

  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    this.b.setColorFilter(paramInt, paramMode);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }

  public void setDither(boolean paramBoolean)
  {
    this.b.setDither(paramBoolean);
  }

  public void setFilterBitmap(boolean paramBoolean)
  {
    this.b.setFilterBitmap(paramBoolean);
  }

  @TargetApi(21)
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    this.b.setHotspot(paramFloat1, paramFloat2);
  }

  @TargetApi(21)
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public boolean setState(int[] paramArrayOfInt)
  {
    return this.b.setState(paramArrayOfInt);
  }

  @TargetApi(21)
  public void setTint(int paramInt)
  {
    this.b.setTint(paramInt);
  }

  @TargetApi(21)
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.b.setTintList(paramColorStateList);
  }

  @TargetApi(21)
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.b.setTintMode(paramMode);
  }

  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.b.setVisible(paramBoolean1, paramBoolean2);
  }

  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.b.unscheduleSelf(paramRunnable);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aui
 * JD-Core Version:    0.6.2
 */