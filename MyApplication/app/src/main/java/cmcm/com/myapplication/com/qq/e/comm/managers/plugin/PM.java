package cmcm.com.myapplication.com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.constants.Constants.PLUGIN;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

public class PM
{
  private static final Map<Class<?>, String> i = new HashMap()
  {
  };
  private final Context a;
  private String b;
  private File c;
  private int d;
  private DexClassLoader e;
  private RandomAccessFile f;
  private FileLock g;
  private boolean h;

  public PM(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.h = b();
    StringBuilder localStringBuilder;
    if (a())
    {
      localStringBuilder = new StringBuilder("PluginFile:\t");
      if (this.c != null)
        break label105;
      paramContext = "null";
    }
    while (true)
    {
      GDTLogger.d(paramContext);
      if (this.b != null)
        try
        {
          this.e = new DexClassLoader(this.c.getAbsolutePath(), this.a.getDir("e_qq_com_dex", 0).getAbsolutePath(), null, getClass().getClassLoader());
          return;
          label105: paramContext = this.c.getAbsolutePath();
        }
        catch (Throwable paramContext)
        {
          GDTLogger.e("exception while init plugin class loader", paramContext);
          return;
        }
    }
    this.e = null;
  }

  private boolean a()
  {
    boolean bool1 = false;
    while (true)
    {
      try
      {
        GDTLogger.d("TimeStap_BEFORE_PLUGIN_INIT:" + System.currentTimeMillis());
        boolean bool2;
        if (this.h)
        {
          localc = new c(c.b(this.a), c.d(this.a));
          if (localc.a())
          {
            bool2 = localc.a(c.a(this.a), c.c(this.a));
            GDTLogger.d("NextExist,Updated=" + bool2);
          }
        }
        c localc = new c(c.a(this.a), c.c(this.a));
        if (localc.a())
        {
          if (localc.b() < 509)
          {
            GDTLogger.d("last updated plugin version =" + this.d + ";asset plugin version=509");
            break label364;
            if (j == 0)
            {
              bool2 = this.h;
              if (bool2)
                continue;
              j = 0;
              if (j == 0);
            }
            else
            {
              bool1 = true;
            }
            return bool1;
          }
          else
          {
            this.b = localc.c();
            this.d = localc.b();
            this.c = c.a(this.a);
            j = 1;
            continue;
          }
          if (com.qq.e.comm.a.a(this.a, c.a(this.a), c.c(this.a)))
          {
            this.b = Constants.PLUGIN.ASSET_PLUGIN_SIG;
            this.c = c.a(this.a);
            this.d = 509;
            j = 1;
            continue;
          }
          GDTLogger.e("Fail to prepair Defult plugin ");
          j = 0;
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        GDTLogger.report("Exception while init plugin manager", localThrowable);
        return false;
      }
      finally
      {
        GDTLogger.d("TimeStap_AFTER_PLUGIN_INIT:" + System.currentTimeMillis());
      }
      label364: int j = 0;
    }
  }

  private boolean b()
  {
    try
    {
      File localFile = new File(this.a.getDir("e_qq_com_plugin", 0), "update_lc");
      if (!localFile.exists())
      {
        localFile.createNewFile();
        StringUtil.writeTo("lock", localFile);
      }
      if (!localFile.exists())
        return false;
      this.f = new RandomAccessFile(localFile, "rw");
      this.g = this.f.getChannel().tryLock();
      if (this.g != null)
      {
        this.f.writeByte(37);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public <T> T getFactory(Class<T> paramClass)
  {
    GDTLogger.d("GetFactoryInstaceforInterface:" + paramClass);
    if (Constants.PLUGIN.ASSET_PLUGIN_SIG == null);
    for (Object localObject1 = getClass().getClassLoader(); localObject1 == null; localObject1 = this.e)
      throw new b("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + paramClass);
    String str;
    try
    {
      str = (String)i.get(paramClass);
      if (StringUtil.isEmpty(str))
        throw new b("factory  implemention name is not specified for interface:" + paramClass.getName());
    }
    catch (Throwable localThrowable)
    {
      throw new b("Fail to getfactory implement instance for interface:" + paramClass.getName(), localThrowable);
    }
    Object localObject2 = localThrowable.loadClass(str);
    localObject2 = paramClass.cast(((Class)localObject2).getDeclaredMethod("getInstance", new Class[0]).invoke(localObject2, new Object[0]));
    return localObject2;
  }

  public String getLocalSig()
  {
    return this.b;
  }

  public POFactory getPOFactory()
  {
    return (POFactory)getFactory(POFactory.class);
  }

  public int getPluginVersion()
  {
    return this.d;
  }

  public void update(String paramString1, String paramString2)
  {
    if (this.h)
      new a(this.a).a(paramString1, paramString2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.managers.plugin.PM
 * JD-Core Version:    0.6.2
 */