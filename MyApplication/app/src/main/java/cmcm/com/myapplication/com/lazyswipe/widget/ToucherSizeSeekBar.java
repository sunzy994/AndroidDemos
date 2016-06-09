package cmcm.com.myapplication.com.lazyswipe.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import asq;
import ave;
import awh;

public class ToucherSizeSeekBar extends ave
{
  public ToucherSizeSeekBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public ToucherSizeSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ToucherSizeSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public ToucherSizeSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  private void b()
  {
    awh localawh = new awh(getContext(), getFragmentCount(), getFragmentCount() / 2, -6645094, -12500671);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, asq.a(10.0F));
    localLayoutParams.addRule(15, 1);
    localawh.setLayoutParams(localLayoutParams);
    a(localawh);
  }

  protected void a()
  {
    super.a();
    this.a = 96;
  }

  protected int getFragmentCount()
  {
    return 7;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.ToucherSizeSeekBar
 * JD-Core Version:    0.6.2
 */