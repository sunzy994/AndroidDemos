package cmcm.com.myapplication.com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.a;
import java.io.File;

class c
{
  private final File a;
  private final File b;
  private String c;
  private int d;

  public c(File paramFile1, File paramFile2)
  {
    this.a = paramFile1;
    this.b = paramFile2;
  }

  static File a(Context paramContext)
  {
    return new File(paramContext.getDir("e_qq_com_plugin", 0), "gdt_plugin.jar");
  }

  static File b(Context paramContext)
  {
    return new File(paramContext.getDir("e_qq_com_plugin", 0), "gdt_plugin.next");
  }

  static File c(Context paramContext)
  {
    return new File(paramContext.getDir("e_qq_com_plugin", 0), "gdt_plugin.jar.sig");
  }

  static File d(Context paramContext)
  {
    return new File(paramContext.getDir("e_qq_com_plugin", 0), "gdt_plugin.next.sig");
  }

  final boolean a()
  {
    while (true)
    {
      try
      {
        if ((this.b.exists()) && (this.a.exists()))
        {
          Object localObject = StringUtil.readAll(this.b).split("#####");
          if (localObject.length == 2)
          {
            String str = localObject[1];
            int i = StringUtil.parseInteger(localObject[0], 0);
            localObject = a.a();
            File localFile = this.a;
            if (localFile != null)
            {
              if (!localFile.exists())
              {
                break label122;
                if (bool)
                {
                  this.c = str;
                  this.d = i;
                  return true;
                }
              }
              else
              {
                bool = ((a)localObject).b(str, Md5Util.encode(localFile));
                continue;
              }
              return false;
            }
          }
          else
          {
            return false;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        GDTLogger.report("Exception while checking plugin", localThrowable);
        return false;
      }
      label122: boolean bool = false;
    }
  }

  final boolean a(File paramFile1, File paramFile2)
  {
    if ((paramFile1 == null) || (paramFile2 == null));
    while (((!paramFile1.equals(this.a)) && (!FileUtil.renameTo(this.a, paramFile1))) || ((!paramFile2.equals(this.b)) && (!FileUtil.renameTo(this.b, paramFile2))))
      return false;
    return true;
  }

  final int b()
  {
    return this.d;
  }

  final String c()
  {
    return this.c;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.managers.plugin.c
 * JD-Core Version:    0.6.2
 */