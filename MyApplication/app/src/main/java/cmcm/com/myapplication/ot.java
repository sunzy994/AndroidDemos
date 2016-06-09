package cmcm.com.myapplication;

import android.util.Log;

public class ot
{
  public void a(Object paramObject)
  {
    Log.i("Callback.onSuccess", paramObject.toString());
  }

  public void a(Throwable paramThrowable)
  {
    ow.a(null, "Callback.onError", paramThrowable);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ot
 * JD-Core Version:    0.6.2
 */