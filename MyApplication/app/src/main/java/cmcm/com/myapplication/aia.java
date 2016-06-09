package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class aia extends ahr
  implements atm
{
  private tj n;
  private String o;
  private atk p = new atk(this, true)
  {
    public String a()
    {
      return aro.d() + "/files/" + aia.this.x() + ".zip";
    }

    public String b()
    {
      return aia.this.E();
    }

    public String c()
    {
      return aia.a(aia.this);
    }
  };

  public aia(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, paramString2, "");
  }

  public aia(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, paramString1, paramString2);
    this.o = paramString3;
  }

  private static aia a(Context paramContext, File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory()));
    while (true)
    {
      return null;
      if (!paramFile.getName().contains("com.hola.launcher.theme."))
      {
        paramFile = new File(paramFile, "info.json");
        if (paramFile.exists())
          try
          {
            Object localObject = new JSONObject(aqx.i(paramFile));
            paramFile = ((JSONObject)localObject).optString("code");
            localObject = a((JSONObject)localObject);
            if ((!TextUtils.isEmpty(paramFile)) && (!TextUtils.isEmpty((CharSequence)localObject)))
            {
              paramContext = new aia(paramContext, paramFile, (String)localObject);
              boolean bool = paramContext.z();
              if (bool)
                return paramContext;
            }
          }
          catch (Exception paramContext)
          {
          }
      }
    }
    return null;
  }

  public static aia a(Context paramContext, String paramString)
  {
    return a(paramContext, new File(aro.d() + "/files/themes/" + aic.a(paramString)));
  }

  public static List<ahw> a(Context paramContext)
  {
    int i = 0;
    Object localObject = new File(aro.d() + "/files/themes");
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
  }

  public List<Bitmap> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new File(E(), "preview.jpg");
    if (((File)localObject).exists())
    {
      localObject = atw.a(((File) localObject).getAbsolutePath(), l, m, false);
      if (atw.b((Bitmap) localObject))
        localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public boolean e()
  {
    return z();
  }

  public long f()
  {
    return new File(E()).lastModified();
  }

  protected void j_()
  {
    this.p.d();
  }

  protected boolean k_()
  {
    return this.p.f();
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
      this.n = new avz(this.a).a(this.a.getResources().getDrawable(2130837771)).a(null).g(2131230736).h(-285212673).b();
  }

  public void q_()
  {
    aqt.a(this.n);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aia
 * JD-Core Version:    0.6.2
 */