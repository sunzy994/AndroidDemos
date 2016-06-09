package cmcm.com.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import com.lazyswipe.SwipeApplication;
import java.lang.reflect.Field;

public class apj extends Dialog
{
  public apj(Context paramContext, View paramView)
  {
    super(paramContext);
    a(paramView, true);
  }

  private static Integer a()
  {
    Object localObject2 = null;
    String[] arrayOfString = SwipeApplication.c().getPackageManager().getSystemSharedLibraryNames();
    Object localObject3 = "SYSTEM_UI_FLAG_TRANSPARENT_BACKGROUND";
    int j = arrayOfString.length;
    int i = 0;
    while (true)
    {
      Object localObject1 = localObject3;
      if (i < j)
      {
        if (!arrayOfString[i].equals("com.sonyericsson.navigationbar"))
          break label86;
        localObject1 = "SYSTEM_UI_FLAG_TRANSPARENT";
      }
      try
      {
        localObject3 = View.class.getField((String)localObject1);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((Field)localObject3).getType() == Integer.TYPE)
          {
            i = ((Field)localObject3).getInt(null);
            localObject1 = Integer.valueOf(i);
          }
        }
        return localObject1;
        label86: i += 1;
      }
      catch (Exception localException)
      {
      }
    }
    return null;
  }

  private static void a(View paramView, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      Integer localInteger = a();
      if (localInteger == null)
        return;
      i = localInteger.intValue();
    }
    paramView.setSystemUiVisibility(i);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apj
 * JD-Core Version:    0.6.2
 */