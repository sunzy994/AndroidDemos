package cmcm.com.myapplication;

import android.view.LayoutInflater;
import android.view.View;

public abstract class acv extends aaq
{
  protected View a(LayoutInflater paramLayoutInflater)
  {
    abt localabt = this.b.l();
    if (localabt.j() != null)
    {
      if (!atw.b(localabt.j()))
        return paramLayoutInflater.inflate(i(), null);
      return paramLayoutInflater.inflate(j(), null);
    }
    return super.a(paramLayoutInflater);
  }

  protected int g()
  {
    return 2130968605;
  }

  protected int i()
  {
    return 2130968606;
  }

  protected int j()
  {
    return 2130968605;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acv
 * JD-Core Version:    0.6.2
 */