package cmcm.com.myapplication;

import android.view.View;
import java.util.Comparator;

public class gl
  implements Comparator<View>
{
  public int a(View paramView1, View paramView2)
  {
    paramView1 = (gf)paramView1.getLayoutParams();
    paramView2 = (gf)paramView2.getLayoutParams();
    if (paramView1.a != paramView2.a)
    {
      if (paramView1.a)
        return 1;
      return -1;
    }
    return paramView1.e - paramView2.e;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     gl
 * JD-Core Version:    0.6.2
 */