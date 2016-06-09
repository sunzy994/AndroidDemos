package cmcm.com.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;

class ee extends ec
  implements LayoutInflater.Factory2
{
  ee(eg parameg)
  {
    super(parameg);
  }

  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.a.a(paramView, paramString, paramContext, paramAttributeSet);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ee
 * JD-Core Version:    0.6.2
 */