package cmcm.com.myapplication;

import android.view.View;

public class ald extends alc
{
  private final View f;

  public ald(View paramView)
  {
    this.f = paramView;
  }

  protected long d()
  {
    return this.f.getDrawingTime();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ald
 * JD-Core Version:    0.6.2
 */