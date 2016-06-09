package cmcm.com.myapplication;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ko
{
  private static final String d = System.getProperty("line.separator");
  public HashMap<String, String> a = new HashMap();
  public String b;
  public boolean c;
  private List<Boolean> e = new ArrayList();
  private boolean f = false;

  public ko(String paramString)
  {
    try
    {
      this.c = false;
      this.b = paramString;
      this.c = a(paramString);
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      if (kn.a)
        Log.w("system.err", paramString);
      return;
    }
    finally
    {
      if (!this.c)
        this.a.clear();
    }
    throw paramString;
  }

  private boolean a(String paramString)
  {
    DataInputStream localDataInputStream;
    BufferedReader localBufferedReader;
    synchronized (this.a)
    {
      this.a.clear();
      paramString = new File(paramString);
      if (!paramString.exists())
        break label144;
      paramString = new FileInputStream(paramString);
      localDataInputStream = new DataInputStream(paramString);
      localBufferedReader = new BufferedReader(new InputStreamReader(localDataInputStream, "utf-8"));
      Object localObject;
      do
      {
        localObject = localBufferedReader.readLine();
        if (TextUtils.isEmpty((CharSequence)localObject))
          break;
        localObject = ((String)localObject).split("=");
      }
      while ((localObject == null) || (localObject.length != 2));
      this.a.put(localObject[0], localObject[1]);
    }
    localBufferedReader.close();
    localDataInputStream.close();
    paramString.close();
    return true;
    label144: return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ko
 * JD-Core Version:    0.6.2
 */