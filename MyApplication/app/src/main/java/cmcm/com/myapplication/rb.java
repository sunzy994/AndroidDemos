package cmcm.com.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class rb extends es
{
  private static final String a = "GameSDK." + rb.class.getSimpleName();
  private final FragmentManager b;
  private FragmentTransaction c = null;
  private Fragment d = null;

  public rb(FragmentManager paramFragmentManager)
  {
    this.b = paramFragmentManager;
  }

  private static String a(int paramInt, long paramLong)
  {
    return "android:switcher:" + paramInt + ":" + paramLong;
  }

  public abstract Fragment a(int paramInt);

  public long b(int paramInt)
  {
    return paramInt;
  }

  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.c == null)
      this.c = this.b.beginTransaction();
    this.c.detach((Fragment)paramObject);
  }

  public void finishUpdate(ViewGroup paramViewGroup)
  {
    try
    {
      if (this.c != null)
      {
        this.c.commitAllowingStateLoss();
        this.c = null;
        this.b.executePendingTransactions();
      }
      return;
    }
    catch (Throwable paramViewGroup)
    {
      Log.w(a, "Exception in finishUpdate", paramViewGroup);
    }
  }

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.c == null)
      this.c = this.b.beginTransaction();
    long l = b(paramInt);
    Object localObject = a(paramViewGroup.getId(), l);
    localObject = this.b.findFragmentByTag((String)localObject);
    if (localObject != null)
      this.c.attach((Fragment)localObject);
    for (paramViewGroup = (ViewGroup)localObject; ; paramViewGroup = (ViewGroup)localObject)
    {
      if (paramViewGroup != this.d)
      {
        paramViewGroup.setMenuVisibility(false);
        if (Build.VERSION.SDK_INT >= 15)
          paramViewGroup.setUserVisibleHint(false);
      }
      return paramViewGroup;
      localObject = a(paramInt);
      this.c.add(paramViewGroup.getId(), (Fragment)localObject, a(paramViewGroup.getId(), l));
    }
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }

  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
  }

  public Parcelable saveState()
  {
    return null;
  }

  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != this.d)
    {
      if (this.d != null)
      {
        this.d.setMenuVisibility(false);
        if (Build.VERSION.SDK_INT >= 15)
          this.d.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        if (Build.VERSION.SDK_INT >= 15)
          paramViewGroup.setUserVisibleHint(true);
      }
      this.d = paramViewGroup;
    }
  }

  public void startUpdate(ViewGroup paramViewGroup)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rb
 * JD-Core Version:    0.6.2
 */