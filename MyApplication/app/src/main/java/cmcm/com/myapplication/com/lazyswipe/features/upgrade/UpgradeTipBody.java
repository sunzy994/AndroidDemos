package cmcm.com.myapplication.com.lazyswipe.features.upgrade;

import ajl;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import asq;
import atw;
import auh;
import java.io.File;

public class UpgradeTipBody extends RelativeLayout
{
  private View a;
  private View b;
  private ImageView c;

  public UpgradeTipBody(Context paramContext)
  {
    super(paramContext);
  }

  public UpgradeTipBody(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a(ajl paramajl, OnClickListener paramOnClickListener)
  {
    setBackgroundColor(paramajl.m);
    setOnClickListener(paramOnClickListener);
    ((ImageView)findViewById(2131755347)).setImageBitmap(atw.b(paramajl.i().getAbsolutePath()));
    ((TextView)findViewById(2131755393)).setTextColor(paramajl.n);
    TextView localTextView = (TextView)findViewById(2131755387);
    localTextView.setText(paramajl.d());
    localTextView.setTextColor(paramajl.n);
    int i = asq.a(4.0F);
    localTextView = (TextView)findViewById(2131755389);
    localTextView.setOnClickListener(paramOnClickListener);
    localTextView.setBackgroundDrawable(auh.a(paramajl.o, i));
    localTextView.setTextColor(paramajl.p);
    localTextView = (TextView)findViewById(2131755394);
    localTextView.setOnClickListener(paramOnClickListener);
    localTextView.setText(2131231095);
    localTextView.setBackgroundDrawable(auh.b(paramajl.n, i));
    localTextView.setTextColor(paramajl.n);
    this.c.setOnClickListener(paramOnClickListener);
    this.c.setColorFilter(paramajl.q, PorterDuff.Mode.SRC_IN);
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    requestLayout();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(2131755347);
    this.b = findViewById(2131755392);
    this.c = ((ImageView)findViewById(2131755391));
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.upgrade.UpgradeTipBody
 * JD-Core Version:    0.6.2
 */