package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class avs extends PopupWindow
{
  private static final String a = "Swipe." + avs.class.getSimpleName();
  private Field b;
  private Field c;
  private Field d;
  private Field e;
  private Field f;
  private Field g;
  private Method h;
  private Method i;
  private Method j;
  private Method k;
  private Method l;

  public avs()
  {
    this(null, 0, 0);
  }

  public avs(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    a();
  }

  private void a()
  {
    try
    {
      this.b = PopupWindow.class.getDeclaredField("mIsShowing");
      this.b.setAccessible(true);
      this.c = PopupWindow.class.getDeclaredField("mIsDropdown");
      this.c.setAccessible(true);
      this.e = PopupWindow.class.getDeclaredField("mLastHeight");
      this.e.setAccessible(true);
      this.d = PopupWindow.class.getDeclaredField("mHeightMode");
      this.d.setAccessible(true);
      this.g = PopupWindow.class.getDeclaredField("mLastWidth");
      this.g.setAccessible(true);
      this.f = PopupWindow.class.getDeclaredField("mWidthMode");
      this.f.setAccessible(true);
      this.h = PopupWindow.class.getDeclaredMethod("unregisterForScrollChanged", new Class[0]);
      this.h.setAccessible(true);
      this.j = PopupWindow.class.getDeclaredMethod("computeAnimationResource", new Class[0]);
      this.j.setAccessible(true);
      this.k = PopupWindow.class.getDeclaredMethod("preparePopup", new Class[] { WindowManager.LayoutParams.class });
      this.k.setAccessible(true);
      this.l = PopupWindow.class.getDeclaredMethod("invokePopup", new Class[] { WindowManager.LayoutParams.class });
      this.l.setAccessible(true);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        while (true)
        {
          this.i = PopupWindow.class.getDeclaredMethod("createPopupLayout", new Class[] { IBinder.class });
          this.i.setAccessible(true);
          return;
          localThrowable1 = localThrowable1;
          asp.a(a, "Could not init fields", localThrowable1);
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          this.i = PopupWindow.class.getDeclaredMethod("createPopupLayoutParams", new Class[] { IBinder.class });
          this.i.setAccessible(true);
          return;
        }
        catch (Throwable localThrowable3)
        {
        }
      }
    }
  }

  @TargetApi(19)
  public void a(IBinder paramIBinder, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (!isShowing())
      {
        if (getContentView() == null)
          return;
        this.h.invoke(this, new Object[0]);
        this.b.set(this, Boolean.valueOf(true));
        this.c.set(this, Boolean.valueOf(false));
        paramIBinder = (WindowManager.LayoutParams)this.i.invoke(this, new Object[] { paramIBinder });
        paramIBinder.windowAnimations = ((Integer)this.j.invoke(this, new Object[0])).intValue();
        this.k.invoke(this, new Object[] { paramIBinder });
        int m = paramInt1;
        if (paramInt1 == 0)
          m = vj.a | 0x30;
        paramIBinder.gravity = m;
        paramIBinder.x = paramInt2;
        paramIBinder.y = paramInt3;
        paramInt1 = ((Integer)this.d.get(this)).intValue();
        if (paramInt1 < 0)
        {
          paramIBinder.height = paramInt1;
          this.e.set(this, Integer.valueOf(paramInt1));
        }
        paramInt1 = ((Integer)this.f.get(this)).intValue();
        if (paramInt1 < 0)
        {
          paramIBinder.width = paramInt1;
          this.g.set(this, Integer.valueOf(paramInt1));
        }
        paramIBinder.flags |= 201327360;
        this.l.invoke(this, new Object[] { paramIBinder });
        return;
      }
    }
    catch (Throwable paramIBinder)
    {
      asp.b(a, "Could not show MyPopupWindow", paramIBinder);
    }
  }

  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) || (Build.VERSION.SDK_INT <= 22))
      super.dismiss();
    avt localavt;
    do
    {
      return;
      localavt = (avt)getContentView();
    }
    while ((localavt != null) && (localavt.j()));
    super.dismiss();
  }

  public void dismiss()
  {
    a(false);
  }

  public void setContentView(View paramView)
  {
    if (!(paramView instanceof avt))
      throw new IllegalArgumentException("ContentView must implement IPopupWindowContent");
    super.setContentView(paramView);
  }

  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView.getWindowToken(), paramInt1, paramInt2, paramInt3);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avs
 * JD-Core Version:    0.6.2
 */