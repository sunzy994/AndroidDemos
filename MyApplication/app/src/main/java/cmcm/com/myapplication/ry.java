package cmcm.com.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

public class ry
{
  public static sa a(Activity paramActivity)
  {
    if (!(paramActivity instanceof rz))
      throw new IllegalArgumentException("Activity must implement ImageFetcherHolder!");
    return new sa(((rz)paramActivity).d());
  }

  public static sa a(Fragment paramFragment)
  {
    return a(paramFragment.getActivity());
  }

  public static sa a(Context paramContext)
  {
    if (!(paramContext instanceof rz))
      throw new IllegalArgumentException("Context must implement ImageFetcherHolder!");
    return new sa(((rz)paramContext).d());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ry
 * JD-Core Version:    0.6.2
 */