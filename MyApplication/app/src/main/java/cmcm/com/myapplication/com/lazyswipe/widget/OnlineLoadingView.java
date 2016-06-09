package cmcm.com.myapplication.com.lazyswipe.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import avr;
import avv;

public class OnlineLoadingView extends FrameLayout
{
  private View a;
  private View b;
  private View c;
  private TextView d;
  private TextView e;
  private TextView f;
  private ProgressBar g;
  private avv h;
  private OnClickListener i = new OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (OnlineLoadingView.a(OnlineLoadingView.this) == null);
      while (paramAnonymousView.getId() != 2131755508)
        return;
      OnlineLoadingView.a(OnlineLoadingView.this).a();
    }
  };

  public OnlineLoadingView(Context paramContext)
  {
    this(paramContext, null);
  }

  public OnlineLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public OnlineLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a()
  {
    this.a = findViewById(2131755151);
    this.b = findViewById(2131755149);
    this.c = findViewById(2131755505);
    this.d = ((TextView)findViewById(2131755506));
    this.e = ((TextView)findViewById(2131755507));
    this.f = ((TextView)findViewById(2131755508));
    this.g = ((ProgressBar)findViewById(2131755509));
    this.f.setOnClickListener(this.i);
    this.g.setIndeterminateDrawable(new avr(getContext()));
  }

  public void b()
  {
    setVisibility(0);
    if (this.b != null)
      this.b.setVisibility(0);
    if (this.a != null)
      this.a.setVisibility(8);
  }

  public boolean c()
  {
    return (getVisibility() == 0) && (this.a != null) && (this.a.getVisibility() == 0);
  }

  public void d()
  {
    setVisibility(0);
    if (this.b != null)
      this.b.setVisibility(8);
    if (this.a != null)
      this.a.setVisibility(0);
  }

  public void e()
  {
    setVisibility(8);
  }

  public String getErrorTitle()
  {
    return this.d.getText().toString();
  }

  public void setButtonClickListener(avv paramavv)
  {
    this.h = paramavv;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.OnlineLoadingView
 * JD-Core Version:    0.6.2
 */