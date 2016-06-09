package cmcm.com.myapplication;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public final class avb extends aux
  implements Callback
{
  private avc a;
  private final Handler b;
  private final vu c;
  private ValueAnimator d;

  public avb(Context paramContext, vu paramvu)
  {
    super(paramContext);
    this.c = paramvu;
    this.b = new Handler(this);
  }

  private void f(int paramInt1, int paramInt2)
  {
    if (this.d == null)
    {
      this.d = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
      this.d.setDuration(400L);
      this.d.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          avb.a(avb.this).setAlpha(i);
        }
      });
    }
    while (paramInt1 != paramInt2)
    {
      this.d.start();
      return;
      if (this.d.isRunning())
        this.d.end();
      this.d.setIntValues(new int[] { paramInt1, paramInt2 });
    }
    this.a.setAlpha(paramInt1);
  }

  protected View a()
  {
    this.a = avc.a(getContext());
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageDrawable(this.a);
    return localImageView;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    this.c.c(this.a.a());
    return true;
  }

  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    g(false);
  }

  public void c()
  {
    this.b.removeMessages(3);
    this.a.a(true);
    int i = this.a.getAlpha();
    this.b.obtainMessage(3, i, 204).sendToTarget();
    this.b.sendMessageDelayed(Message.obtain(this.b, 3, 204, 102), 4000L);
  }

  protected boolean c(int paramInt1, int paramInt2)
  {
    this.b.sendMessageDelayed(Message.obtain(this.b, 3, 204, 102), 4000L);
    return super.c(paramInt1, paramInt2);
  }

  public boolean c(MotionEvent paramMotionEvent)
  {
    this.b.removeMessages(3);
    int i = this.a.getAlpha();
    if (i < 204)
      f(i, 204);
    return super.c(paramMotionEvent);
  }

  public void d(MotionEvent paramMotionEvent)
  {
    super.d(paramMotionEvent);
    this.b.sendMessageDelayed(Message.obtain(this.b, 3, 204, 102), 4000L);
  }

  public void f(MotionEvent paramMotionEvent)
  {
    super.f(paramMotionEvent);
  }

  public void g()
  {
  }

  public void g(final boolean paramBoolean)
  {
    if (asq.n())
    {
      this.a.a(false, paramBoolean);
      return;
    }
    this.j.post(new Runnable()
    {
      public void run()
      {
        avb.a(avb.this).a(false, paramBoolean);
      }
    });
  }

  public boolean g(MotionEvent paramMotionEvent)
  {
    asq.f(getContext());
    return true;
  }

  protected int getDefaultPosition()
  {
    return -60;
  }

  protected int getPaddingX()
  {
    return asq.a(1.0F);
  }

  protected String getPositionKey()
  {
    return "key_persistent_toucher_pos";
  }

  protected int getWindowHeight()
  {
    return this.a.getIntrinsicHeight();
  }

  protected int getWindowWidth()
  {
    return this.a.getIntrinsicWidth();
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return false;
    case 3:
    }
    f(paramMessage.arg1, paramMessage.arg2);
    return true;
  }

  public void p()
  {
    boolean bool = this.a.a();
    super.p();
    if (bool)
      this.a.a(true, true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avb
 * JD-Core Version:    0.6.2
 */