package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.List;

public class aaj extends aao
{
  public static String a()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    return vs.a(localSwipeApplication, "custom_tab_name", localSwipeApplication.getString(2131231010));
  }

  public static void a(Context paramContext, String paramString)
  {
    vs.b(paramContext, "custom_tab_name", paramString);
  }

  public String a(Context paramContext)
  {
    return a();
  }

  public void a(SwipeApplication paramSwipeApplication)
  {
    if (this.b != null);
    while (true)
    {
      return;
      wm localwm = paramSwipeApplication.a();
      int i = b(paramSwipeApplication);
      this.b = new ArrayList(i);
      try
      {
        Object localObject2 = paramSwipeApplication.getContentResolver();
        Object localObject3 = xg.a;
        String str1 = ash.b;
        String str2 = ash.c;
        StringBuilder localStringBuilder = new StringBuilder().append("custom_tab_pos, label");
        if (i > 0)
        {
          localObject1 = " LIMIT " + i;
          label93: localObject1 = (String)localObject1;
          localObject1 = ((ContentResolver)localObject2).query((Uri)localObject3, null, "uninstalled=? AND custom_tab_pos>?", new String[] { str1, str2 }, (String)localObject1);
        }
        try
        {
          localObject2 = new xh((Cursor)localObject1);
          while (true)
          {
            if ((localObject1 != null) && (((Cursor)localObject1).moveToNext()))
            {
              int j = this.b.size();
              if (j < i);
            }
            else
            {
              arf.a((Cursor) localObject1);
              if ((!this.b.isEmpty()) || (ahy.d(paramSwipeApplication)))
                break;
              return;
              localObject1 = "";
              break label93;
            }
            localObject3 = localwm.a(ComponentName.unflattenFromString(((Cursor)localObject1).getString(((xh)localObject2).b)));
            if (localObject3 != null)
              this.b.add(new yt((wk)localObject3));
          }
        }
        finally
        {
        }
        arf.a((Cursor) localObject1);
        throw paramSwipeApplication;
      }
      finally
      {
        while (true)
          Object localObject1 = null;
      }
    }
  }

  public void a(List<yw> paramList, int paramInt1, int paramInt2, xy paramxy)
  {
    super.a(paramList, paramInt1, paramInt2, paramxy);
    if (asq.a(paramList));
    do
    {
      return;
      paramInt1 = 0;
      if (paramInt1 < paramList.size())
      {
        Object localObject = (yw)paramList.get(paramInt1);
        if (localObject == null);
        while (true)
        {
          paramInt1 += 1;
          break;
          localObject = ((yw)localObject).e();
          if (localObject != null)
          {
            ((wk)localObject).o = (paramInt1 + 1);
            arj.a(new Runnable() {
              public void run() {
                try {
                  wn.d(SwipeApplication.c(), this.a);
                  return;
                } catch (Throwable localThrowable) {
                }
              }
            });
          }
        }
      }
    }
    while (paramxy == null);
    paramxy.a(this.b);
  }

  public String b()
  {
    return "custom";
  }

  public boolean d()
  {
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aaj
 * JD-Core Version:    0.6.2
 */