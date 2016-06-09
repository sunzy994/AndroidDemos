package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.hola.channel.sdk.game.manager.DownloadService;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

public class sn
{
  private static sn b;
  private static DownloadService c;
  private static Map<String, so> d = new LinkedHashMap();
  Handler a = new Handler(Looper.getMainLooper());
  private sp e = new sp()
  {
    public void a(final TextView paramAnonymousTextView, final CharSequence paramAnonymousCharSequence)
    {
      sn.this.a.post(new Runnable()
      {
        public void run()
        {
          paramAnonymousTextView.setText(paramAnonymousCharSequence);
        }
      });
    }
  };

  private sn(Context paramContext)
  {
    paramContext.startService(new Intent(paramContext, DownloadService.class));
  }

  public static sn a(Context paramContext)
  {
    if (b == null)
      b = new sn(paramContext);
    return b;
  }

  private void a(Context paramContext, pe parampe, View paramView)
  {
    so localso = b(parampe);
    if (localso == null)
    {
      paramContext = new so(paramContext, parampe, paramView, c, this.e);
      d.put(parampe.d, paramContext);
      paramContext.b();
      return;
    }
    localso.a(parampe.d);
    localso.a(paramView);
  }

  private so b(String paramString)
  {
    return (so)d.get(paramString);
  }

  private so b(pe parampe)
  {
    return b(parampe.d);
  }

  public void a(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    rn.a(paramContext).a(paramContext, paramSQLiteDatabase);
  }

  public void a(Context paramContext, String paramString, int paramInt)
  {
    so localso = b(paramString);
    if (localso != null)
    {
      paramContext = rn.a(paramContext);
      if (localso.a() != null)
        break label51;
    }
    label51: for (boolean bool = true; ; bool = false)
    {
      paramContext.a(paramString, 3, 0, -1, bool);
      localso.a(paramInt);
      a(paramString);
      return;
    }
  }

  public void a(Context paramContext, pe parampe)
  {
    rn.a(paramContext).a(parampe.d, 2, 0, 1, true);
    a(paramContext, parampe, null);
  }

  public void a(DownloadService paramDownloadService)
  {
    c = paramDownloadService;
  }

  public void a(String paramString)
  {
    try
    {
      d.remove(paramString);
      return;
    }
    catch (NullPointerException paramString)
    {
      paramString.printStackTrace();
    }
  }

  public void a(String paramString, View paramView)
  {
    paramString = b(paramString);
    if (paramString != null)
      paramString.a(paramView);
  }

  public boolean a(Context paramContext, String paramString, View paramView)
  {
    paramString = rn.a(paramContext).e(paramString);
    boolean bool = a(paramString);
    if (!bool)
    {
      rn.a(paramContext).a(paramContext, paramString, false);
      a(paramContext, paramString, paramView);
    }
    while (!bool)
    {
      return true;
      rn.a(paramContext).a(paramContext, paramString, true);
    }
    return false;
  }

  public boolean a(pe parampe)
  {
    boolean bool2 = false;
    File localFile = pe.a(parampe.d);
    boolean bool1 = bool2;
    try
    {
      if (localFile.exists())
      {
        boolean bool3 = parampe.m.equals(qn.b(localFile));
        bool1 = bool2;
        if (bool3)
          bool1 = true;
      }
      return bool1;
    }
    catch (NoSuchAlgorithmException parampe)
    {
      parampe.printStackTrace();
      return false;
    }
    catch (IOException parampe)
    {
      parampe.printStackTrace();
    }
    return false;
  }

  public void b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, DownloadService.class);
    localIntent.setAction("action_down_next_hide_game");
    paramContext.startService(localIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sn
 * JD-Core Version:    0.6.2
 */