package cmcm.com.myapplication.com.qq.e.comm.pi;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.qq.e.comm.adevent.ADListener;

public abstract class SPVI extends RelativeLayout
{
  public SPVI(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
  }

  public abstract void fetchAndShowIn(ViewGroup paramViewGroup);

  public abstract void setAdListener(ADListener paramADListener);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.pi.SPVI
 * JD-Core Version:    0.6.2
 */