package cmcm.com.myapplication;

import android.content.Context;
import java.util.concurrent.ExecutorService;

class jo
  implements Runnable
{
  private Context a;
  private String b;
  private String c;
  private String d;
  private String e;
  private ExecutorService f;

  private jo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ExecutorService paramExecutorService)
  {
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramExecutorService;
  }

  public void run()
  {
    jl.a(this.a, this.b, this.c, this.d, this.e);
    this.f.shutdown();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jo
 * JD-Core Version:    0.6.2
 */