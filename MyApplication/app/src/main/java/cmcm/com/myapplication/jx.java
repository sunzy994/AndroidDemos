package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class jx
{
  private static jx a = new jx();

  public static jx a()
  {
    return a;
  }

  private jy a(File paramFile)
  {
    try
    {
      FileReader localFileReader = new FileReader(paramFile);
      Object localObject = new char[(int)paramFile.length()];
      localFileReader.read((char[])localObject);
      localObject = new jy((char[])localObject);
      ((jy)localObject).a(paramFile.getName());
      localFileReader.close();
      return localObject;
    }
    catch (Exception paramFile)
    {
    }
    return null;
  }

  private File c(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "AFRequestCache");
  }

  public void a(Context paramContext)
  {
    try
    {
      if (!c(paramContext).exists())
        c(paramContext).mkdir();
      return;
    }
    catch (Exception paramContext)
    {
      Log.i("AppsFlyer_1.13", "Could not create cache directory");
    }
  }

  public void a(String paramString, Context paramContext)
  {
    paramContext = new File(c(paramContext), paramString);
    Log.i("AppsFlyer_1.13", "Deleting " + paramString + " from cache");
    if (paramContext.exists());
    try
    {
      paramContext.delete();
      return;
    }
    catch (Exception paramContext)
    {
      Log.i("AppsFlyer_1.13", "Could not delete " + paramString + " from cache", paramContext);
    }
  }

  public void a(jy paramjy, Context paramContext)
  {
    try
    {
      File localFile = c(paramContext);
      if (!localFile.exists())
      {
        localFile.mkdir();
        return;
      }
      if (localFile.listFiles().length > 20)
      {
        Log.i("AppsFlyer_1.13", "reached cache limit, not caching request");
        return;
      }
    }
    catch (Exception paramjy)
    {
      Log.i("AppsFlyer_1.13", "Could not cache request");
      return;
    }
    Log.i("AppsFlyer_1.13", "caching request...");
    paramContext = new File(c(paramContext), Long.toString(System.currentTimeMillis()));
    paramContext.createNewFile();
    paramContext = new OutputStreamWriter(new FileOutputStream(paramContext.getPath(), true));
    paramContext.write("version=");
    paramContext.write(paramjy.a());
    paramContext.write(10);
    paramContext.write("url=");
    paramContext.write(paramjy.c());
    paramContext.write(10);
    paramContext.write("data=");
    paramContext.write(paramjy.b());
    paramContext.write(10);
    paramContext.flush();
    paramContext.close();
  }

  public List<jy> b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramContext = c(paramContext);
      if (!paramContext.exists())
      {
        paramContext.mkdir();
        return localArrayList;
      }
      paramContext = paramContext.listFiles();
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        File localFile = paramContext[i];
        Log.i("AppsFlyer_1.13", "Found cached request" + localFile.getName());
        localArrayList.add(a(localFile));
        i += 1;
      }
    }
    catch (Exception paramContext)
    {
      Log.i("AppsFlyer_1.13", "Could not cache request");
    }
    return localArrayList;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jx
 * JD-Core Version:    0.6.2
 */