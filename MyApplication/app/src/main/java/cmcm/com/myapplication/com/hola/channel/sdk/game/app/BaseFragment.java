package cmcm.com.myapplication.com.hola.channel.sdk.game.app;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment
{
  private static final String c = "GameSDK." + BaseFragment.class.getSimpleName();
  protected int a;
  protected boolean b;
  private boolean d;

  public void a(Bundle paramBundle, int paramInt)
  {
    if ((paramBundle != null) && (this.a == 0))
      this.a = paramBundle.getInt("layoutResId");
  }

  public void a(View paramView)
  {
  }

  public void a(boolean paramBoolean)
  {
  }

  public abstract int b();

  protected View c()
  {
    return null;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (paramBundle != null)
      a(paramBundle, 3);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.b = true;
      a(paramBundle, 1);
      return;
    }
    this.b = false;
    a(getArguments(), 1);
  }

  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramViewGroup == null);
    while (getActivity().isFinishing())
      return null;
    if (paramBundle != null)
      a(paramBundle, 2);
    if (this.a <= 0)
      this.a = b();
    if (this.a > 0);
    for (paramLayoutInflater = paramLayoutInflater.inflate(this.a, paramViewGroup, false); ; paramLayoutInflater = c())
    {
      a(paramLayoutInflater);
      return paramLayoutInflater;
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

  public void onDestroyView()
  {
    super.onDestroyView();
  }

  public void onDetach()
  {
    super.onDetach();
  }

  public void onPause()
  {
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    if (this.d);
    try
    {
      a(true);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("layoutResId", this.a);
  }

  public void onStart()
  {
    super.onStart();
  }

  public void onStop()
  {
    super.onStop();
  }

  public void setMenuVisibility(boolean paramBoolean)
  {
    super.setMenuVisibility(paramBoolean);
    this.d = false;
    if ((!paramBoolean) || (isResumed()));
    try
    {
      a(true);
      return;
      this.d = true;
      return;
      try
      {
        a(false);
        return;
      }
      catch (Throwable localThrowable1)
      {
      }
    }
    catch (Throwable localThrowable2)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.app.BaseFragment
 * JD-Core Version:    0.6.2
 */