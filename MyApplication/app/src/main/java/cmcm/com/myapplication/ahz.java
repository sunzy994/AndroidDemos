package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ahz extends ahr
  implements atm
{
  private static final String n = "Swipe." + ahz.class.getSimpleName();
  private tj o;
  private String p;
  private atk q = new atk(this, true)
  {
    public String a()
    {
      return aro.d() + "/files/" + ahz.this.x() + ".zip";
    }

    public String b()
    {
      return ahz.a(ahz.this);
    }

    public String c()
    {
      return ahz.b(ahz.this);
    }
  };

  public ahz(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, paramString2, "");
  }

  public ahz(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, paramString1, paramString2);
    this.p = paramString3;
  }

  private static String P()
  {
    return Environment.getExternalStorageDirectory().getAbsolutePath() + "/holalauncher/theme/custom/";
  }

  private String Q()
  {
    return P() + this.g;
  }

  private static ahz a(Context paramContext, File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory()));
    while (true)
    {
      return null;
      if (paramFile.getName().startsWith("zip_com.hola.launcher.theme."))
        try
        {
          ait localait = new ait(paramContext, paramFile.getAbsolutePath());
          paramFile = paramFile.getName();
          String str = localait.f().a;
          if ((!TextUtils.isEmpty(paramFile)) && (!TextUtils.isEmpty(str)) && (localait.h()))
          {
            paramContext = new ahz(paramContext, paramFile, str);
            return paramContext;
          }
        }
        catch (Exception paramContext)
        {
        }
    }
    return null;
  }

  public static ahz a(Context paramContext, String paramString)
  {
    return a(paramContext, new File(P(), paramString));
  }

  private Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new File(Q(), "preview/" + paramString + ".jpg");
    if (((File)localObject).exists())
    {
      localObject = atw.a(((File) localObject).getAbsolutePath(), paramInt1, paramInt2, false);
      if (atw.b((Bitmap) localObject))
        paramString = (String)localObject;
    }
    do
    {
      return paramString;
      paramString = new File(Q(), "preview/" + paramString + ".png");
      if (!paramString.exists())
        break;
      localObject = atw.a(paramString.getAbsolutePath(), paramInt1, paramInt2, false);
      paramString = (String)localObject;
    }
    while (atw.b((Bitmap) localObject));
    return null;
  }

  public static List<ahw> a(Context paramContext)
  {
    int i = 0;
    Object localObject = new File(P());
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()))
    {
      localObject = new ArrayList(0);
      return localObject;
    }
    File[] arrayOfFile = ((File)localObject).listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
      return new ArrayList(0);
    ArrayList localArrayList = new ArrayList(arrayOfFile.length);
    int j = arrayOfFile.length;
    while (true)
    {
      localObject = localArrayList;
      if (i >= j)
        break;
      localObject = a(paramContext, arrayOfFile[i]);
      if (localObject != null)
        localArrayList.add(localObject);
      i += 1;
    }
  }

  public void a(File paramFile)
  {
    Log.e(n, "theme onResFilePrepared()");
    paramFile = new File(Q(), "omniswipe.zip");
    aqx.e(new File(E()));
    if (!paramFile.exists())
    {
      Log.e(n, "Local ZipFile not found " + paramFile);
      return;
    }
    try
    {
      asu.a(paramFile.getAbsolutePath(), E());
      File localFile = new File(E(), "info.json");
      JSONObject localJSONObject = new JSONObject(arf.a(new FileInputStream(localFile)));
      localJSONObject.put("code", this.g);
      arf.a(localJSONObject.toString(), new FileOutputStream(localFile));
      return;
    }
    catch (Exception localException)
    {
      Log.e(n, "UnzipFolder error", localException);
      aqx.e(paramFile);
    }
  }

  public Bitmap c()
  {
    Bitmap localBitmap = super.c();
    if (atw.b(localBitmap))
      return localBitmap;
    return a("preview1_omni", j, k);
  }

  public List<Bitmap> d()
  {
    ArrayList localArrayList = new ArrayList();
    Bitmap localBitmap = a("preview1_omni", l, m);
    if (atw.b(localBitmap))
      localArrayList.add(localBitmap);
    localBitmap = a("preview1", l, m);
    if (atw.b(localBitmap))
      localArrayList.add(localBitmap);
    localBitmap = a("preview2", l, m);
    if (atw.b(localBitmap))
      localArrayList.add(localBitmap);
    localBitmap = a("preview3", l, m);
    if (atw.b(localBitmap))
      localArrayList.add(localBitmap);
    return localArrayList;
  }

  public boolean e()
  {
    return new File(Q()).exists();
  }

  public long f()
  {
    return new File(Q()).lastModified();
  }

  public boolean g()
  {
    return true;
  }

  protected void j_()
  {
    this.q.d();
  }

  protected boolean k_()
  {
    return this.q.f();
  }

  public boolean m_()
  {
    return z();
  }

  public void n_()
  {
    A();
  }

  public void o_()
  {
    B();
    aso.a(this.a, 2131230761);
  }

  public void p_()
  {
    if (!this.b)
      this.o = new avz(this.a).a(this.a.getResources().getDrawable(2130837771)).a(null).g(2131230736).h(-285212673).b();
  }

  public void q_()
  {
    aqt.a(this.o);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahz
 * JD-Core Version:    0.6.2
 */