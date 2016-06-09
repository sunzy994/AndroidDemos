package cmcm.com.myapplication;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

final class me extends Handler
{
  me(md parammd, Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      int i = 1;
      while (i <= 3)
      {
        paramMessage = new mi(md.a(this.a));
        paramMessage.b = (i - 1);
        md.b(this.a).add(paramMessage);
        i += 1;
      }
      if (md.c(this.a))
        md.a(this.a, (mi)md.b(this.a).get(0));
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     me
 * JD-Core Version:    0.6.2
 */