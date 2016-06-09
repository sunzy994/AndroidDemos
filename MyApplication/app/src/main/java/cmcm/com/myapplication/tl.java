package cmcm.com.myapplication;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Handler;
import android.os.Looper;

public class tl extends tj
{
  long c;
  private long d;

  public tl(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  public static tl a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    CharSequence localCharSequence1;
    if (paramInt1 > 0)
    {
      localCharSequence1 = paramContext.getText(paramInt1);
      if (paramInt2 <= 0)
        break label41;
    }
    label41: for (CharSequence localCharSequence2 = paramContext.getText(paramInt2); ; localCharSequence2 = null)
    {
      return a(paramContext, localCharSequence1, localCharSequence2, paramBoolean, null, paramInt3);
      localCharSequence1 = null;
      break;
    }
  }

  public static tl a(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener, int paramInt)
  {
    if (paramInt > 0);
    for (paramContext = new tm(paramContext, paramInt); ; paramContext = new tm(paramContext))
      return (tl)paramContext.b(paramCharSequence2).b(paramBoolean).a(paramCharSequence1).a(paramOnCancelListener).b();
  }

  public void cancel()
  {
    super.cancel();
    this.d = 0L;
  }

  public void dismiss()
  {
    long l = System.currentTimeMillis() - this.d;
    if (l >= this.c)
    {
      super.dismiss();
      return;
    }
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public void run()
      {
        tl.this.dismiss();
      }
    }
    , this.c - l + 20L);
  }

  public void show()
  {
    super.show();
    this.d = System.currentTimeMillis();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     tl
 * JD-Core Version:    0.6.2
 */