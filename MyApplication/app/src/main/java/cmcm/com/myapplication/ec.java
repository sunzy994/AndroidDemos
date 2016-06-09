package cmcm.com.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

class ec
  implements LayoutInflater.Factory
{
  final eg a;

  ec(eg parameg)
  {
    this.a = parameg;
  }

  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.a.a(null, paramString, paramContext, paramAttributeSet);
  }

  public String toString()
  {
    return getClass().getName() + "{" + this.a + "}";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ec
 * JD-Core Version:    0.6.2
 */