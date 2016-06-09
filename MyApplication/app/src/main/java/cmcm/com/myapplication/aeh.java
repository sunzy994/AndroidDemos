package cmcm.com.myapplication;

import android.content.Context;
import android.view.View;
import com.lazyswipe.SwipeApplication;

public class aeh extends ady
{
  public aeh(Context paramContext)
  {
    super(paramContext);
  }

  public String getBitmapUrl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://res.lazyswipe.cn/").append("card/");
    localStringBuilder.append(aqs.b(SwipeApplication.c(), 720)).append('/').append("slotmachine.jpg");
    return localStringBuilder.toString();
  }

  public void onClick(View paramView)
  {
    yb.getInstance().s();
    vy.b(getContext(), "B38");
    vw.a(getContext(), "B38", "type", 2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aeh
 * JD-Core Version:    0.6.2
 */