package cmcm.com.myapplication;

import android.os.Handler;
import android.os.Message;
import android.view.View;

public class atv extends atr
{
  private final String a;
  private final View b;
  private final Handler c;
  private final int d;
  private String h = null;

  public atv(View paramView, String paramString, Handler paramHandler, int paramInt)
  {
    this.a = paramString;
    this.b = paramView;
    this.c = paramHandler;
    this.d = paramInt;
  }

  public atv(View paramView, String paramString1, Handler paramHandler, int paramInt, String paramString2)
  {
    this.a = paramString1;
    this.b = paramView;
    this.c = paramHandler;
    this.d = paramInt;
    this.h = paramString2;
  }

  public String a()
  {
    return this.a;
  }

  public void b()
  {
    Message.obtain(this.c, this.d, this).sendToTarget();
  }

  public String c()
  {
    return this.h;
  }

  public View f()
  {
    return this.b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     atv
 * JD-Core Version:    0.6.2
 */