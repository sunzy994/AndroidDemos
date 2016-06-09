package cmcm.com.myapplication;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.json.JSONException;

public class aii extends aij
{
  private final String e;

  public aii(Context paramContext, String paramString)
  {
    super(paramContext.createPackageContext(paramString, 0));
    this.e = paramString;
  }

  private InputStream a(String paramString, aio paramaio)
  {
    try
    {
      InputStream localInputStream = this.b.getAssets().open(paramString);
      if (localInputStream == null)
        return null;
      if (paramaio == aio.a)
        return localInputStream;
      paramaio = aiq.a(localInputStream);
      return paramaio;
    }
    catch (IOException paramaio)
    {
      Log.w(a, "Read asset [" + paramString + "] to string failed.", paramaio);
      return null;
    }
    catch (FileNotFoundException paramString)
    {
    }
    return null;
  }

  private boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool1;
    if (paramBoolean)
    {
      str = ".png";
      boolean bool2 = c(a() + "launcher/" + paramString + str);
      bool1 = bool2;
      if (!bool2)
        if (!paramBoolean)
          break label104;
    }
    label104: for (String str = ".jpg"; ; str = ".png")
    {
      bool1 = c(a() + "launcher/" + paramString + str);
      return bool1;
      str = ".jpg";
      break;
    }
  }

  // ERROR //
  private boolean c(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 30	aii:b	Landroid/content/Context;
    //   6: invokevirtual 34	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   9: aload_1
    //   10: invokevirtual 40	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +5 -> 20
    //   18: iconst_1
    //   19: istore_2
    //   20: aload_1
    //   21: invokestatic 93	arf:a	(Ljava/io/Closeable;)V
    //   24: iload_2
    //   25: ireturn
    //   26: astore_1
    //   27: aconst_null
    //   28: invokestatic 93	arf:a	(Ljava/io/Closeable;)V
    //   31: iconst_0
    //   32: ireturn
    //   33: astore_1
    //   34: aconst_null
    //   35: invokestatic 93	arf:a	(Ljava/io/Closeable;)V
    //   38: aload_1
    //   39: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	14	26	java/io/IOException
    //   2	14	33	finally
  }

  public InputStream a(String paramString)
  {
    if (!g())
      return null;
    return a(paramString, b(paramString));
  }

  protected String a()
  {
    return "";
  }

  public boolean b()
  {
    if (!g());
    while ((!a("icon_bg", true)) && (!a("icon_fg", true)))
      return false;
    return true;
  }

  public aim c()
  {
    return a(a(a() + "manifest.xml", aio.a));
  }

  public ais d()
  {
    int j = 1;
    ais localais = new ais();
    try
    {
      localais.d = this.b.getApplicationInfo().sourceDir;
      localais.e = new File(this.b.getApplicationInfo().sourceDir).lastModified();
      String str1 = this.b.getResources().getConfiguration().locale.toString();
      String str2 = asq.d(this.b, this.e, a() + "info.json" + "-" + str1);
      if (str2 != null)
        try
        {
          a(localais, str2);
          i = 1;
          if ((i == 0) && (str1.indexOf('_') > 0))
          {
            str1 = asq.d(this.b, this.e, a() + "info.json" + "-" + str1.substring(0, str1.indexOf('_')));
            if (str1 == null);
          }
        }
        catch (Exception localJSONException)
        {
          try
          {
            a(localais, str1);
            i = j;
            if (i == 0)
            {
              str1 = asq.d(this.b, this.e, a() + "info.json");
              if (str1 == null);
            }
          }
          catch (JSONException localJSONException)
          {
            try
            {
              while (true)
              {
                a(localais, str1);
                return localais;
                localException3 = localException3;
                i = 0;
              }
              localJSONException = localJSONException;
            }
            catch (Exception localException1)
            {
              return localais;
            }
          }
        }
    }
    catch (Exception localException2)
    {
      while (true)
      {
        continue;
        continue;
        int i = 0;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aii
 * JD-Core Version:    0.6.2
 */