package cmcm.com.myapplication.com.lazyswipe.features.splash;

import ahl;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashView extends RelativeLayout
  implements OnClickListener
{
  private ImageView a;
  private ImageView b;
  private TextView c;
  private CountDownTimer d;
  private Integer e;
  private Activity f;

  public SplashView(Context paramContext)
  {
    super(paramContext);
  }

  public SplashView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a()
  {
    ahl.a(this.f, this, this.e);
  }

  public void a(long paramLong, Activity paramActivity, Integer paramInteger)
  {
    this.e = paramInteger;
    this.f = paramActivity;
    this.d = new CountDownTimer(paramLong - 50L, 1000L)
    {
      public void onFinish()
      {
        String str = "0 " + SplashView.this.getResources().getString(2131231224);
        SplashView.a(SplashView.this).setText(str);
      }

      public void onTick(long paramAnonymousLong)
      {
        int i = (int)(paramAnonymousLong / 1000L);
        String str = i + " " + SplashView.this.getResources().getString(2131231224);
        SplashView.a(SplashView.this).setText(str);
      }
    };
    this.d.start();
    this.c.setOnClickListener(this);
  }

  public void onClick(View paramView)
  {
    if (paramView == this.c)
      a();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.d != null)
      this.d.cancel();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(2131755075));
    this.b = ((ImageView)findViewById(2131755357));
    this.c = ((TextView)findViewById(2131755499));
    this.b.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
    {
      onClick(this.c);
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  public void setImage(Bitmap paramBitmap)
  {
    this.a.setImageBitmap(paramBitmap);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.splash.SplashView
 * JD-Core Version:    0.6.2
 */