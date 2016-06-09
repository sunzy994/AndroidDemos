package cmcm.com.myapplication;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.lazyswipe.SwipeService;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

public class aib
{
  private static final String a = "Swipe." + aib.class.getSimpleName();
  private static WeakReference<tj> b;
  private static boolean c;

  public static void a(Context paramContext)
  {
    String str = vs.a(paramContext, "recommend_all_in_one_theme", "");
    if (TextUtils.isEmpty(str));
    final ahw localahw;
    do
    {
      do
      {
        do
          return;
        while (f(paramContext, str));
        if (d(paramContext, str) == null)
        {
          vs.b(paramContext, "recommend_all_in_one_theme", "");
          return;
        }
        localahw = ahx.b(paramContext);
        if ((localahw.g()) && (str.equals(localahw.g)))
        {
          vs.b(paramContext, "recommend_all_in_one_theme", "");
          return;
        }
      }
      while (!b().exists());
      localahw = d(paramContext, str);
    }
    while (localahw == null);
    a(paramContext, str, paramContext.getString(2131230781, new Object[] { "Omni" }), paramContext.getString(2131231088), new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        yb.e(true);
        SwipeService.a(aib.this, localahw.g, true);
        vs.b(aib.this, "recommend_all_in_one_theme", "");
        vy.b(aib.this, "B57", 2);
      }
    });
  }

  public static void a(Context paramContext, String paramString)
  {
    vs.b(paramContext, "recommend_all_in_one_theme", paramString);
  }

  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, OnClickListener paramOnClickListener)
  {
    Bitmap localBitmap = atw.b(b().getAbsolutePath());
    if (!atw.b(localBitmap))
      return;
    g(paramContext, paramString1);
    paramString1 = (ViewGroup)LayoutInflater.from(paramContext).inflate(2130968625, null);
    ((TextView)paramString1.findViewById(2131755216)).setText(paramString2);
    ((TextView)paramString1.findViewById(2131755217)).setText(paramString3);
    ((ImageView)paramString1.findViewById(2131755215)).setImageBitmap(localBitmap);
    paramString1.findViewById(2131755122).setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((aib.a() != null) && (aib.a().get() != null))
          aqt.a((Dialog) aib.a().get());
      }
    });
    paramString1.findViewById(2131755217).setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (aib.this != null)
          aib.this.onClick(paramAnonymousView);
        if ((aib.a() != null) && (aib.a().get() != null))
          aqt.a((Dialog) aib.a().get());
      }
    });
    b = new WeakReference(new avx(paramContext).a(paramString1).b());
  }

  private static File b()
  {
    return new File(aro.d() + "/files/themes/all_in_one.jpg");
  }

  public static void b(Context paramContext)
  {
    if (!asq.c(paramContext, "com.hola.launcher"));
    while (true)
    {
      return;
      Pair localPair1 = e(paramContext);
      Pair localPair2 = c(paramContext);
      Object localObject = null;
      if ((localPair1 != null) && (localPair2 == null))
        paramContext = (ahw)localPair1.first;
      while (paramContext != null)
      {
        paramContext.y();
        return;
        if ((localPair1 == null) && (localPair2 != null))
        {
          paramContext = (ahw)localPair2.first;
        }
        else
        {
          paramContext = localObject;
          if (localPair1 != null)
          {
            paramContext = localObject;
            if (localPair2 != null)
              if (((Long)localPair1.second).longValue() > ((Long)localPair2.second).longValue())
                paramContext = (ahw)localPair1.first;
              else
                paramContext = (ahw)localPair2.first;
          }
        }
      }
    }
  }

  public static void b(Context paramContext, final String paramString)
  {
    if (f(paramContext, paramString))
      return;
    if (f(paramContext))
    {
      a(paramContext, paramString, paramContext.getString(2131230781, new Object[] { "Hola" }), paramContext.getString(2131231088), new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          yb.p();
          aib.c(aib.this, paramString);
          vy.b(aib.this, "B57", 0);
        }
      });
      return;
    }
    a(paramContext, paramString, paramContext.getString(2131230781, new Object[] { "Hola" }), paramContext.getString(2131230905), new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        vy.b(aib.this, "B57", 1);
        yb.p();
        asq.j(aib.this);
      }
    });
  }

  public static Pair<ahw, Long> c(Context paramContext)
  {
    Object localObject = new File(Environment.getExternalStorageDirectory(), "holalauncher/export/omni_theme.dat");
    if (!((File)localObject).exists())
      return null;
    try
    {
      localObject = aqx.m((File) localObject);
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = ((String)((List)localObject).get(0)).split("-");
        if (localObject.length != 2)
          return null;
        String str = localObject[0];
        long l1 = Long.parseLong(localObject[1]);
        long l2 = System.currentTimeMillis() - l1;
        if ((l2 < 0L) || (l2 > 300000L))
          break label148;
        paramContext = ahx.a(paramContext, str);
        if (paramContext == null)
          return null;
        if (!paramContext.l_())
          return null;
        paramContext = new Pair(paramContext, Long.valueOf(l1));
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      return null;
    }
    return null;
    label148: return null;
  }

  private static ahw d(Context paramContext, String paramString)
  {
    if (paramString.startsWith("com.hola.launcher.theme."))
      return aho.a(paramContext, paramString);
    if (paramString.startsWith("zip_com.hola.launcher.theme."))
      return ahz.a(paramContext, paramString);
    return null;
  }

  public static void d(final Context paramContext)
  {
    if (c);
    File localFile;
    do
    {
      do
        return;
      while ((!vs.c(paramContext, "need_preload_all_in_one_pic", true)) || (!vj.j));
      localFile = b();
    }
    while ((localFile.exists()) || (!arl.h(paramContext)));
    new Thread(new Runnable()
    {
      public void run()
      {
        Process.setThreadPriority(10);
        aib.a(true);
        if (!aib.this.getParentFile().exists())
          aib.this.getParentFile().mkdirs();
        if (ard.a(paramContext, "http://res.lazyswipe.cn/themes/all_in_one.jpg", aib.this.getAbsolutePath(), 30000, 30000))
          vs.b(paramContext, "need_preload_all_in_one_pic", false);
        aib.a(false);
      }
    }).start();
  }

  private static Pair<ahw, Long> e(Context paramContext)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(arf.a(new FileInputStream(new File("/data/data/com.hola.launcher/files/glth.dat"))));
      String str = localJSONObject.optString("theme");
      long l = localJSONObject.optLong("time", -1L);
      if (TextUtils.isEmpty(str))
        return null;
      if (System.currentTimeMillis() - l <= 600000L)
      {
        paramContext = d(paramContext, str);
        if (paramContext != null)
        {
          paramContext = new Pair(paramContext, Long.valueOf(l));
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
    }
    return null;
  }

  private static boolean e(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      Uri localUri = Uri.parse("content://com.hola.launcher.external/globaltheme");
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("code", paramString);
      int i = paramContext.getContentResolver().update(localUri, localContentValues, null, null);
      if (i > 0)
        bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
    }
    return false;
  }

  // ERROR //
  private static boolean f(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 390
    //   3: invokestatic 396	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   6: astore_1
    //   7: aload_0
    //   8: invokevirtual 409	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   11: aload_1
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 419	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_0
    //   20: aload_0
    //   21: ifnull +32 -> 53
    //   24: aload_0
    //   25: invokeinterface 424 1 0
    //   30: ifeq +23 -> 53
    //   33: ldc_w 426
    //   36: aload_0
    //   37: iconst_0
    //   38: invokeinterface 427 2 0
    //   43: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: istore_2
    //   47: aload_0
    //   48: invokestatic 430	arf:a	(Landroid/database/Cursor;)V
    //   51: iload_2
    //   52: ireturn
    //   53: aload_0
    //   54: invokestatic 430	arf:a	(Landroid/database/Cursor;)V
    //   57: iconst_0
    //   58: ireturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_0
    //   62: aload_0
    //   63: invokestatic 430	arf:a	(Landroid/database/Cursor;)V
    //   66: iconst_0
    //   67: ireturn
    //   68: astore_1
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: invokestatic 430	arf:a	(Landroid/database/Cursor;)V
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: goto -7 -> 71
    //   81: astore_1
    //   82: goto -20 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   0	20	59	java/lang/Exception
    //   0	20	68	finally
    //   24	47	77	finally
    //   24	47	81	java/lang/Exception
  }

  private static boolean f(Context paramContext, String paramString)
  {
    return aru.b(paramContext, "all_in_one_suggested_" + paramString.replace(".", "_"), false);
  }

  private static void g(Context paramContext, String paramString)
  {
    aru.a(paramContext, "all_in_one_suggested_" + paramString.replace(".", "_"), true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aib
 * JD-Core Version:    0.6.2
 */