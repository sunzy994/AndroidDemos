package cmcm.com.myapplication;

import android.content.Context;
import android.view.View;
import com.lazyswipe.SwipeApplication;

public class adw extends ady
{
  public adw(Context paramContext)
  {
    super(paramContext);
  }

  public String getBitmapUrl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://res.lazyswipe.cn/").append("card/");
    localStringBuilder.append(aqs.b(SwipeApplication.c(), 720)).append('/').append("dice.jpg");
    return localStringBuilder.toString();
  }

  public void onClick(View paramView)
  {
    yb.getInstance().t();
    vy.b(getContext(), "B38");
    vw.a(getContext(), "B38", "type", 1);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adw
 * JD-Core Version:    0.6.2
 */