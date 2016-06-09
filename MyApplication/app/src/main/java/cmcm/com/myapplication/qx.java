package cmcm.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class qx
{
  public static <T extends View> T a(Activity paramActivity, int paramInt)
  {
    return paramActivity.findViewById(paramInt);
  }

  public static <T extends View> T a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, false);
  }

  public static <T extends View> T a(Context paramContext, int paramInt, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return a((LayoutInflater)paramContext.getSystemService("layout_inflater"), paramInt, paramViewGroup, paramBoolean);
  }

  public static <T extends View> T a(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return paramLayoutInflater.inflate(paramInt, paramViewGroup, paramBoolean);
  }

  public static <T extends View> T a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qx
 * JD-Core Version:    0.6.2
 */