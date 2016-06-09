package cmcm.com.myapplication;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;

public class axa extends awz
  implements Checkable
{
  public axa(Context paramContext)
  {
    super(paramContext);
  }

  public boolean isChecked()
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable))
      return ((Checkable)localView).isChecked();
    return false;
  }

  public void setChecked(boolean paramBoolean)
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable))
      ((Checkable)localView).setChecked(paramBoolean);
  }

  public void toggle()
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable))
      ((Checkable)localView).toggle();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axa
 * JD-Core Version:    0.6.2
 */