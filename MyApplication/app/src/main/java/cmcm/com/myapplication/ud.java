package cmcm.com.myapplication;

import android.os.Bundle;
import com.holaverse.charging.model.Battery;

public abstract class ud extends ub
  implements uj
{
  private ue a;

  public void a()
  {
  }

  public void a(Battery paramBattery)
  {
  }

  public void b()
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public void onDestroy()
  {
    this.a.b();
    this.a.b(this);
    uh.a(this);
    super.onDestroy();
  }

  public void onResume()
  {
    super.onResume();
    if (this.a == null)
    {
      this.a = new ue();
      this.a.a(this);
      this.a.a(this);
      return;
    }
    a(this.a.a());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ud
 * JD-Core Version:    0.6.2
 */