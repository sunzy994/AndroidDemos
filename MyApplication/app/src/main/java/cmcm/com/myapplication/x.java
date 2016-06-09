package cmcm.com.myapplication;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class x extends es
{
  private final s a;
  private y b = null;
  private k c = null;

  public x(s params)
  {
    this.a = params;
  }

  private static String a(int paramInt, long paramLong)
  {
    return "android:switcher:" + paramInt + ":" + paramLong;
  }

  public abstract k a(int paramInt);

  public long b(int paramInt)
  {
    return paramInt;
  }

  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.b == null)
      this.b = this.a.a();
    this.b.a((k)paramObject);
  }

  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.b != null)
    {
      this.b.a();
      this.b = null;
      this.a.b();
    }
  }

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.b == null)
      this.b = this.a.a();
    long l = b(paramInt);
    Object localObject = a(paramViewGroup.getId(), l);
    localObject = this.a.a((String)localObject);
    if (localObject != null)
      this.b.b((k)localObject);
    for (paramViewGroup = (ViewGroup)localObject; ; paramViewGroup = (ViewGroup)localObject)
    {
      if (paramViewGroup != this.c)
      {
        paramViewGroup.b(false);
        paramViewGroup.c(false);
      }
      return paramViewGroup;
      localObject = a(paramInt);
      this.b.a(paramViewGroup.getId(), (k)localObject, a(paramViewGroup.getId(), l));
    }
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((k)paramObject).i() == paramView;
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
    paramViewGroup = (k)paramObject;
    if (paramViewGroup != this.c)
    {
      if (this.c != null)
      {
        this.c.b(false);
        this.c.c(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.b(true);
        paramViewGroup.c(true);
      }
      this.c = paramViewGroup;
    }
  }

  public void startUpdate(ViewGroup paramViewGroup)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     x
 * JD-Core Version:    0.6.2
 */