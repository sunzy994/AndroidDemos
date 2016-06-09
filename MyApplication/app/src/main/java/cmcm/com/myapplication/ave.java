package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ave extends RelativeLayout
  implements OnSeekBarChangeListener
{
  private static final String b = "Swipe." + ave.class.getSimpleName();
  public int a;
  private boolean c;
  private OnSeekBarChangeListener d;
  private SeekBar e;
  private int f;
  private int g;

  public ave(Context paramContext)
  {
    this(paramContext, null);
  }

  public ave(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ave(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt, 0);
  }

  @TargetApi(21)
  public ave(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt > this.a)
      i = this.a;
    paramInt = i;
    if (i < this.g)
      paramInt = this.g;
    if (paramInt != this.f)
    {
      this.f = paramInt;
      this.e.setProgress(this.f - this.g);
      if (this.d != null)
        this.d.onProgressChanged(this.e, paramInt, true);
    }
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    a();
  }

  private void a(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    int j = getFragmentCount() - 1;
    int i = paramInt;
    if (j > 1)
    {
      i = (int)((int)(paramInt * 1.0F / this.a * j + 0.5F) * 1.0F * this.a / j + 0.5F);
      paramSeekBar.setProgress(i);
    }
    if (i != this.f)
      a(i, false);
  }

  public void a()
  {
    this.a = 100;
    this.g = 0;
    this.f = 0;
  }

  public void a(View paramView)
  {
    addView(paramView, 0);
    this.e.bringToFront();
  }

  public int getFragmentCount()
  {
    return 0;
  }

  public int getProgress()
  {
    return this.f;
  }

  public SeekBar getSeekBar()
  {
    return this.e;
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.e = ((SeekBar)findViewById(2131755520));
    this.e.setOnSeekBarChangeListener(this);
    this.e.setMax(this.a - this.g);
    this.e.setProgress(this.f - this.g);
  }

  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.c))
      a(paramSeekBar, paramInt, paramBoolean);
  }

  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.c = true;
    if (this.d != null)
      this.d.onStartTrackingTouch(paramSeekBar);
  }

  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.c = false;
    if (paramSeekBar.getProgress() != this.f - this.g)
      a(paramSeekBar, paramSeekBar.getProgress(), true);
    if (this.d != null)
      this.d.onStopTrackingTouch(paramSeekBar);
  }

  public void setOnSeekBarChangeListener(OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.d = paramOnSeekBarChangeListener;
  }

  public void setProgress(int paramInt)
  {
    a(paramInt, true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ave
 * JD-Core Version:    0.6.2
 */