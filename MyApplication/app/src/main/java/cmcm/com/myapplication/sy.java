package cmcm.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.widget.RelativeLayout;
import com.hola.channel.pub.RuntimeActivity;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class sy
{
  private static String a;
  private static ClassLoader b;
  private static Class c;

  public static Object a(Context paramContext, int paramInt, String paramString)
  {
    try
    {
      Class localClass = Integer.TYPE;
      paramContext = a(paramContext, "dispatchTextEditEvent", new Object[] { Integer.valueOf(paramInt), paramString }, new Class[] { localClass, String.class });
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      qq.a(paramContext);
    }
    return null;
  }

  public static Object a(Context paramContext, Configuration paramConfiguration)
  {
    return a(paramContext, "onConfigurationChanged", new Object[] { paramConfiguration }, new Class[] { Configuration.class });
  }

  public static Object a(Context paramContext, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    a(paramContext);
    return ox.a(c, paramString, paramArrayOfObject, paramArrayOfClass);
  }

  public static Object a(Context paramContext, boolean paramBoolean)
  {
    Class localClass = Boolean.TYPE;
    return a(paramContext, "onActivityDestroy", new Object[] { Boolean.valueOf(paramBoolean) }, new Class[] { localClass });
  }

  public static Object a(final RuntimeActivity paramRuntimeActivity, Intent paramIntent, boolean paramBoolean, String paramString, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, RelativeLayout paramRelativeLayout3)
  {
    Class localClass = Boolean.TYPE;
    paramString = a(paramRuntimeActivity, "onActivityCreate", new Object[] { paramRuntimeActivity, paramIntent, Boolean.valueOf(paramBoolean), paramString }, new Class[] { Activity.class, Intent.class, localClass, String.class });
    if (paramString != null)
    {
      pn.a(new pr()
      {
        public void a(String paramAnonymousString)
        {
          String str;
          if (paramAnonymousString == null)
            str = "null";
          try
          {
            while (true)
            {
              qq.a("::notifyAdJs", str);
              sy.a(sy.this, "notifyAdJs", new Object[] { paramAnonymousString }, new Class[] { String.class });
              return;
              str = paramAnonymousString;
            }
          }
          catch (Throwable paramAnonymousString)
          {
            qq.a(sy.this, "JavaInterface:notifyAdJs", paramAnonymousString);
          }
        }
      });
      pn.a(new pt()
      {
        public void a(String paramAnonymousString1, String paramAnonymousString2)
        {
          qf.a(sy.this, paramAnonymousString1, paramAnonymousString2);
        }
      });
      pn.a(new pq()
      {
        public String a()
        {
          return qf.b(sy.this);
        }

        public String b()
        {
          return "400113";
        }

        public String c()
        {
          return qu.b(sy.this);
        }

        public String d()
        {
          return qu.c(sy.this);
        }
      });
      pn.a(paramRuntimeActivity, paramIntent.getStringExtra("game_key"), paramRelativeLayout1, paramRelativeLayout2, paramRelativeLayout3);
      paramIntent = ps.a();
      paramRuntimeActivity = ox.a(b, ox.a(b, "com.tangide.ui.LoadInterface"), new InvocationHandler()
      {
        public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        {
          paramAnonymousObject = paramAnonymousMethod.getName();
          qq.a("LoadInterface", paramAnonymousObject);
          if (paramAnonymousObject.equals("notifyAdSdk"))
          {
            paramAnonymousObject = (String)paramAnonymousArrayOfObject[0];
            Log.d("::notifyAdSdk", paramAnonymousObject);
            return sy.this.a(paramAnonymousObject);
          }
          int i;
          if (paramAnonymousObject.equals("notifyGameOver"))
          {
            i = ((Integer)paramAnonymousArrayOfObject[0]).intValue();
            int j = ((Integer)paramAnonymousArrayOfObject[1]).intValue();
            int k = ((Integer)paramAnonymousArrayOfObject[2]).intValue();
            int m = ((Integer)paramAnonymousArrayOfObject[3]).intValue();
            Log.d("LoadI.notifyGameOver", "score=" + i + ", level=" + j + ", duration=" + k + ", callType=" + m);
            return null;
          }
          String str1;
          if (paramAnonymousObject.equals("notifySystemShare"))
          {
            paramAnonymousObject = (String)paramAnonymousArrayOfObject[0];
            paramAnonymousMethod = (String)paramAnonymousArrayOfObject[1];
            str1 = (String)paramAnonymousArrayOfObject[2];
            String str2 = (String)paramAnonymousArrayOfObject[3];
            String str3 = (String)paramAnonymousArrayOfObject[4];
            paramAnonymousArrayOfObject = (String)paramAnonymousArrayOfObject[5];
            Log.d("LoadI.notifySystemShare", "s=" + paramAnonymousObject + ", s1=" + paramAnonymousMethod + ", s2=" + str1 + ", s3=" + str2 + ", s4=" + str3 + ", s5=" + paramAnonymousArrayOfObject);
            return null;
          }
          if (paramAnonymousObject.equals("notifyQiigameAgentGameKeeptime"))
            ((Long)paramAnonymousArrayOfObject[0]).longValue();
          while (true)
          {
            return null;
            if (paramAnonymousObject.equals("notifyQiigameAgentGameAvgFps"))
              ((Integer)paramAnonymousArrayOfObject[0]).intValue();
            else if (!paramAnonymousObject.equals("notifyGameExit"))
              if (paramAnonymousObject.equals("showEditViewAt"))
              {
                paramAnonymousObject = (String)paramAnonymousArrayOfObject[0];
                paramAnonymousMethod = (String)paramAnonymousArrayOfObject[1];
                str1 = (String)paramAnonymousArrayOfObject[2];
                boolean bool = ((Boolean)paramAnonymousArrayOfObject[3]).booleanValue();
                i = ((Integer)paramAnonymousArrayOfObject[4]).intValue();
                float f1 = ((Float)paramAnonymousArrayOfObject[5]).floatValue();
                float f2 = ((Float)paramAnonymousArrayOfObject[6]).floatValue();
                float f3 = ((Float)paramAnonymousArrayOfObject[7]).floatValue();
                float f4 = ((Float)paramAnonymousArrayOfObject[8]).floatValue();
                float f5 = ((Float)paramAnonymousArrayOfObject[9]).floatValue();
                paramRuntimeActivity.a(paramAnonymousObject, paramAnonymousMethod, str1, bool, i, f1, f2, f3, f4, f5);
              }
              else if (paramAnonymousObject.equals("hideEditView"))
              {
                paramRuntimeActivity.a();
              }
          }
        }
      });
      ox.a(c, "setLoadInterface", new Object[] { paramRuntimeActivity }, new Class[] { Object.class });
    }
    return paramString;
  }

  public static void a(Context paramContext)
  {
    if (a == null)
      a = oy.b(paramContext, "rtgamerunjar.jar").getAbsolutePath();
    if (b == null)
    {
      b = ox.a(paramContext, a);
      c = ox.a(b, "com.tangide.ui.LoadHelper");
    }
  }

  public static Object b(Context paramContext)
  {
    return a(paramContext, "onActivityResume", new Object[0], new Class[0]);
  }

  public static Object c(Context paramContext)
  {
    return a(paramContext, "onActivityPause", new Object[0], new Class[0]);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sy
 * JD-Core Version:    0.6.2
 */