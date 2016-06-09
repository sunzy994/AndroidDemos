package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.util.concurrent.Callable;

final class aus
  implements Callable<Bitmap>
{
  public final String a;
  public final String b;
  public final boolean c;
  public final int d;
  public final int e;
  private final Context f;

  aus(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a = paramString2;
    this.b = paramString1;
    this.c = paramBoolean;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramContext;
  }

  private Bitmap b()
  {
    try
    {
      if ((this.d > 0) && (this.e > 0))
        return atw.a(this.a, this.d, this.e, false);
      Bitmap localBitmap = atw.b(this.a);
      return localBitmap;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public Bitmap a()
  {
    Object localObject2 = null;
    File localFile1 = new File(this.a);
    File localFile2 = new File(this.a + "_temp");
    Object localObject1 = localObject2;
    if (new arb(this.f).a(this.b, null, localFile2))
    {
      if (localFile2.exists())
        localFile2.renameTo(localFile1);
      localObject1 = localObject2;
      if (this.c)
        localObject1 = b();
    }
    return localObject1;
  }

  public boolean a(File paramFile, Bitmap[] paramArrayOfBitmap)
  {
    if (paramFile.exists())
    {
      if (this.c);
      for (paramFile = b(); ; paramFile = null)
      {
        paramArrayOfBitmap[0] = paramFile;
        return true;
      }
    }
    return false;
  }

  public boolean a(Bitmap[] paramArrayOfBitmap)
  {
    return a(new File(this.a), paramArrayOfBitmap);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aus
 * JD-Core Version:    0.6.2
 */