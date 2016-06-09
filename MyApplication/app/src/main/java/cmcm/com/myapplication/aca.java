package cmcm.com.myapplication;

import android.content.Context;
import java.io.File;

public class aca extends aqv
{
  public boolean a(Context paramContext)
  {
    return false;
  }

  public String b(Context paramContext)
  {
    return "mobvista";
  }

  public String c(Context paramContext)
  {
    return "http://d.lazyswipe.com/sdk/" + h(paramContext) + ".json";
  }

  public void d(Context paramContext)
  {
    super.d(paramContext);
    File[] arrayOfFile = e(paramContext).getParentFile().listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      if ((localFile.exists()) && (localFile.getName().startsWith("mobvista")) && (!localFile.getName().startsWith(h(paramContext))))
        aqx.e(localFile);
      i += 1;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aca
 * JD-Core Version:    0.6.2
 */