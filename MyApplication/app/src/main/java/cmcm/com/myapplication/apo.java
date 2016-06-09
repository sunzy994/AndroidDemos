package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;

public class apo extends avx
{
  private Intent o;

  public apo(Context paramContext)
  {
    super(paramContext);
  }

  public apo a(Intent paramIntent)
  {
    this.o = paramIntent;
    boolean bool = this.o.getBooleanExtra("EXTRA_CHOOSE_APP", true);
    a((app)LayoutInflater.from(this.a).inflate(app.c(bool), null));
    return this;
  }

  protected apn h()
  {
    return new apn(this.a, this.o);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apo
 * JD-Core Version:    0.6.2
 */