package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import java.util.List;

public class ajc extends ImageView
{
  private int b;
  private int c;
  private int d;

  public ajc(ajb paramajb, Context paramContext)
  {
    super(paramContext);
    this.b = ari.c(ajb.b(paramajb), ajb.c(paramajb));
    this.c = ari.c(ajb.d(paramajb), ajb.e(paramajb));
    this.d = ari.c(ajb.f(paramajb), ajb.g(paramajb));
    setX(this.b);
    setY(this.c);
    setImageDrawable((Drawable)ajb.h(paramajb).get(ari.c(0, ajb.h(paramajb).size())));
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    animate().y(vj.f + asq.a(50.0F)).setDuration(this.d);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajc
 * JD-Core Version:    0.6.2
 */