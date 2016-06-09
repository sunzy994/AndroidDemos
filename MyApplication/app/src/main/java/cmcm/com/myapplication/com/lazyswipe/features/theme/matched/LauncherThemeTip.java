package cmcm.com.myapplication.com.lazyswipe.features.theme.matched;

import ahw;
import ahx;
import aie;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import asq;
import vy;
import yb;

public class LauncherThemeTip extends LinearLayout
  implements OnClickListener
{
  public LauncherThemeTip(Context paramContext)
  {
    super(paramContext);
  }

  public LauncherThemeTip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a()
  {
    yb.getInstance().removeView(this);
  }

  public void onClick(View paramView)
  {
    paramView = ahx.b(getContext()).O();
    if ((!TextUtils.isEmpty(paramView)) && (!asq.c(getContext(), paramView)))
    {
      yb.p();
      aie.a(paramView, getContext());
      asq.g(getContext(), paramView);
      vy.a(getContext(), "B05");
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    TextView localTextView = (TextView)findViewById(2131755096);
    localTextView.setBackgroundDrawable(asq.u(getContext()));
    localTextView.setTextColor(-1);
    localTextView.setOnClickListener(this);
    setOnClickListener(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.theme.matched.LauncherThemeTip
 * JD-Core Version:    0.6.2
 */