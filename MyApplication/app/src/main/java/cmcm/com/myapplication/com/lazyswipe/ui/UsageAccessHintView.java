package cmcm.com.myapplication.com.lazyswipe.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import wu;

public class UsageAccessHintView extends LinearLayout
  implements OnClickListener
{
  public UsageAccessHintView(Context paramContext)
  {
    this(paramContext, null);
  }

  public UsageAccessHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public UsageAccessHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public UsageAccessHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public void onClick(View paramView)
  {
    wu.a(getContext());
    FullscreenTipActivity.a(getContext(), 2131230979);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(2131755217).setOnClickListener(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.UsageAccessHintView
 * JD-Core Version:    0.6.2
 */