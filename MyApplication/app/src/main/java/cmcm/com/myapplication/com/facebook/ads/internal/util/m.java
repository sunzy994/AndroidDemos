package cmcm.com.myapplication.com.facebook.ads.internal.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

public class m
{
  static Bitmap a(Context paramContext, String paramString)
  {
    return BitmapFactory.decodeFile(new File(paramContext.getCacheDir(), String.format("%d.png", new Object[] { Integer.valueOf(paramString.hashCode()) })).getAbsolutePath());
  }

  static void a(Context paramContext, String paramString, Bitmap paramBitmap)
  {
    paramContext = new File(paramContext.getCacheDir(), String.format("%d.png", new Object[] { Integer.valueOf(paramString.hashCode()) }));
    try
    {
      paramContext = new FileOutputStream(paramContext);
      paramBitmap.compress(CompressFormat.PNG, 100, paramContext);
      paramContext.flush();
      paramContext.close();
      return;
    }
    catch (Exception paramContext)
    {
    }
  }

  public static void a(Context paramContext, List<String> paramList, final l paraml)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = paramList.size();
    if (arrayOfInt[0] == 0)
      if (paraml != null)
        paraml.a();
    while (true)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        new k(paramContext).a(new l()
        {
          public void a()
          {
            int[] arrayOfInt = m.this;
            arrayOfInt[0] -= 1;
            if ((m.this[0] == 0) && (paraml != null))
              paraml.a();
          }
        }).execute(new String[] { str });
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.util.m
 * JD-Core Version:    0.6.2
 */