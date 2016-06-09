package cmcm.com.myapplication;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.concurrent.FutureTask;

final class aur extends FutureTask<Bitmap>
{
  private final WeakReference<aut> a;
  private aus b;

  public aur(aut paramaut, aus paramaus)
  {
    super(paramaus);
    this.a = new WeakReference(paramaut);
    this.b = paramaus;
  }

  public aus a()
  {
    return this.b;
  }

  // ERROR //
  protected void done()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	aur:a	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 36	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: ifnull +41 -> 48
    //   10: aload_0
    //   11: invokevirtual 37	aur:get	()Ljava/lang/Object;
    //   14: checkcast 39	android/graphics/Bitmap
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 22	aur:a	Ljava/lang/ref/WeakReference;
    //   22: invokevirtual 36	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   25: checkcast 41	aut
    //   28: aload_0
    //   29: getfield 24	aur:b	Laus;
    //   32: getfield 46	aus:b	Ljava/lang/String;
    //   35: aload_0
    //   36: getfield 24	aur:b	Laus;
    //   39: getfield 48	aus:a	Ljava/lang/String;
    //   42: aload_1
    //   43: invokeinterface 51 4 0
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 24	aur:b	Laus;
    //   53: return
    //   54: astore_1
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 24	aur:b	Laus;
    //   60: return
    //   61: astore_1
    //   62: invokestatic 57	auq:c	()Ljava/lang/String;
    //   65: ldc 59
    //   67: aload_1
    //   68: invokestatic 65	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   71: pop
    //   72: aconst_null
    //   73: astore_1
    //   74: goto -56 -> 18
    //   77: astore_1
    //   78: goto -30 -> 48
    //
    // Exception table:
    //   from	to	target	type
    //   10	18	54	java/util/concurrent/CancellationException
    //   10	18	61	java/lang/Throwable
    //   18	48	77	java/lang/Throwable
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aur
 * JD-Core Version:    0.6.2
 */