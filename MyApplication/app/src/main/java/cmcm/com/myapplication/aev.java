package cmcm.com.myapplication;

import android.app.WallpaperManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.File;

class aev
{
  private boolean b = false;
  private tj c;

  private aev(aeu paramaeu)
  {
  }

  private boolean a(Context paramContext, File paramFile)
  {
    if (!paramFile.exists())
      return false;
    vv.a().a("设置壁纸");
    WallpaperManager localWallpaperManager = WallpaperManager.getInstance(paramContext);
    try
    {
      localWallpaperManager.setStream(paramContext.getContentResolver().openInputStream(Uri.parse("file://" + paramFile.getAbsolutePath())));
      return true;
    }
    catch (Throwable paramContext)
    {
    }
    return false;
  }

  public void a()
  {
    this.b = true;
    if ((this.c != null) && (this.c.isShowing()))
      this.c.dismiss();
  }

  public void a(final Context paramContext, final afa paramafa)
  {
    new AsyncTask()
    {
      public Void a(Void[] paramAnonymousArrayOfVoid)
      {
        if (!this.b.exists())
          new arb(paramContext).a(paramafa.f, null, this.b);
        if (aev.b(aev.this));
        while (!aev.a(aev.this, paramContext, this.b))
          return null;
        arj.a(new Runnable() {
          public void run() {
            try {
              File localFile1 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Omni_Wallpapers");
              if (!localFile1.exists()) {
                File localFile2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Wallpapers");
                if (!localFile2.exists())
                  break label139;
                aqx.a(localFile2, localFile1);
                asq.c(aeu.b(aev.this.a).getApplicationContext(), localFile1);
              }
              while (true) {
                localFile1 = new File(localFile1, aqx.a(aev .1. this.c.d));
                if (!aqx.c(new File(aev .1. this.c.d),localFile1))
                break;
                asq.b(aeu.b(aev.this.a).getApplicationContext(), localFile1);
                return;
                label139:
                localFile1.mkdirs();
              }
            } catch (Throwable localThrowable) {
            }
          }
        });
        return null;
      }

      public void a(Void paramAnonymousVoid)
      {
        if (aev.a(aev.this) != null)
          aev.a(aev.this).dismiss();
        if (aev.b(aev.this))
          return;
        yb.p();
        asq.f(paramContext);
        asq.t(paramContext);
      }

      public void onPreExecute()
      {
        aev.a(aev.this, new avz(paramContext).g(2131230736).b(vs.n(paramContext)).a());
        aev.a(aev.this).setCancelable(true);
        aev.a(aev.this).setOnCancelListener(new OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            aev.this.a();
          }
        });
        aev.a(aev.this).setCanceledOnTouchOutside(false);
        aev.a(aev.this).setOnDismissListener(new OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymous2DialogInterface)
          {
            aeu.a(aev.this.a, null);
            aev.a(aev.this, null);
          }
        });
        aev.a(aev.this).show();
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aev
 * JD-Core Version:    0.6.2
 */