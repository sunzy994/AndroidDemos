package cmcm.com.myapplication.com.lazyswipe.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import aqs;
import asr;

public class FloatWindowHintView extends LinearLayout
  implements OnClickListener
{
  private int a;

  public FloatWindowHintView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FloatWindowHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FloatWindowHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public FloatWindowHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public static boolean a(Context paramContext)
  {
    if ((Build.VERSION.SDK_INT >= 19) || ((aqs.p()) && (aqs.F())))
      return aqs.b(paramContext);
    return true;
  }

  public void onClick(View paramView)
  {
    int i;
    switch (this.a)
    {
    case 4:
    default:
      i = 2131230981;
      aqs.j(getContext());
    case 2:
    case 3:
    case 5:
    }
    while (true)
    {
      TutorialService.a(getContext());
      FullscreenTipActivity.a(getContext(), i);
      if (aqs.D())
        System.exit(99);
      return;
      i = 2131230977;
      aqs.h(getContext());
      continue;
      i = 2131230976;
      aqs.d(getContext());
      continue;
      i = 2131230978;
      aqs.c(getContext());
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    asr.a(this, 2131755217).setOnClickListener(this);
    if ((aqs.a()) && (Build.VERSION.SDK_INT >= 21))
    {
      this.a = 5;
      return;
    }
    if (aqs.p())
    {
      this.a = 1;
      return;
    }
    if ((aqs.K()) && (aqs.k(getContext())))
    {
      this.a = 2;
      return;
    }
    if (aqs.E())
    {
      this.a = 3;
      return;
    }
    this.a = 4;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.FloatWindowHintView
 * JD-Core Version:    0.6.2
 */