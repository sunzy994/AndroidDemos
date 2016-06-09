package cmcm.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class asr
{
  public static int a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
    paramFloat2 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
    if (Math.abs(paramFloat1) >= Math.abs(paramFloat2))
    {
      if (paramFloat1 > 0.0F)
        return 2;
      return 1;
    }
    if (paramFloat2 > 0.0F)
      return 8;
    return 4;
  }

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
 * Qualified Name:     asr
 * JD-Core Version:    0.6.2
 */