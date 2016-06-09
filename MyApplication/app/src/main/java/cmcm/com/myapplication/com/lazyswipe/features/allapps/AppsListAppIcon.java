package cmcm.com.myapplication.com.lazyswipe.features.allapps;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AppsListAppIcon extends LinearLayout
{
  private ImageView a;
  private TextView b;
  private boolean c;

  public AppsListAppIcon(Context paramContext)
  {
    this(paramContext, null);
  }

  public AppsListAppIcon(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    this.a.setImageDrawable(paramDrawable);
    if ((paramDrawable != null) && (this.c) && (!paramBoolean))
      this.a.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
    this.c = paramBoolean;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(2131755064));
    this.b = ((TextView)findViewById(2131755084));
  }

  public void setText(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.allapps.AppsListAppIcon
 * JD-Core Version:    0.6.2
 */