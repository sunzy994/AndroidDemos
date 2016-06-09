package cmcm.com.myapplication.com.lazyswipe.features.theme.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import atw;

public class ThemePreviewItem extends LinearLayout
{
  private ThemePreviewImage a;
  private View b;

  public ThemePreviewItem(Context paramContext)
  {
    super(paramContext);
  }

  public ThemePreviewItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a(int paramInt, Object paramObject)
  {
    setTag(paramObject);
  }

  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (atw.b(paramBitmap))
    {
      this.a.setImageBitmap(paramBitmap);
      this.a.setClipRoundRect(paramBoolean);
      this.b.setVisibility(8);
    }
    do
    {
      return;
      this.b.setVisibility(0);
    }
    while (paramBitmap != null);
    this.a.setImageBitmap(null);
  }

  public ImageView getImage()
  {
    return this.a;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ThemePreviewImage)findViewById(2131755075));
    this.b = findViewById(2131755099);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.theme.preview.ThemePreviewItem
 * JD-Core Version:    0.6.2
 */