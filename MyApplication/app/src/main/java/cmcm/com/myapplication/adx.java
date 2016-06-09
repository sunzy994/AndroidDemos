package cmcm.com.myapplication;

import android.content.Context;
import android.view.View;
import com.lazyswipe.SwipeApplication;

public class adx extends ady
{
  public adx(Context paramContext)
  {
    super(paramContext);
  }

  public static boolean h()
  {
    return true;
  }

  public String getBitmapUrl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://res.lazyswipe.cn/").append("card/");
    localStringBuilder.append(aqs.b(SwipeApplication.c(), 720)).append('/').append("game.jpg");
    return localStringBuilder.toString();
  }

  public void onClick(View paramView)
  {
    yb.p();
    add.a(getContext(), 2);
    vy.a(getContext(), "D4", 2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adx
 * JD-Core Version:    0.6.2
 */