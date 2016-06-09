package cmcm.com.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.lang.ref.WeakReference;

public class aex extends aeo
  implements atm
{
  public static final int b = asq.a(72.0F);
  private static final String c = "Swipe." + aex.class.getSimpleName();
  private Bitmap d;
  private Bitmap e;
  private final SparseArray<Bitmap> f = new SparseArray(6);
  private boolean g;
  private final aey h = new aey(this);
  private WeakReference<tj> i;

  public aex(Context paramContext)
  {
    super(paramContext);
  }

  // ERROR //
  private Bitmap a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 81	java/io/FileInputStream
    //   5: dup
    //   6: new 83	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: aload_2
    //   12: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: astore_1
    //   19: aload_1
    //   20: iconst_0
    //   21: sipush 480
    //   24: invokestatic 94	atw:a	(Ljava/io/InputStream;ZI)Landroid/graphics/Bitmap;
    //   27: astore_2
    //   28: aload_2
    //   29: invokestatic 97	atw:b	(Landroid/graphics/Bitmap;)Z
    //   32: istore 4
    //   34: iload 4
    //   36: ifeq +9 -> 45
    //   39: aload_1
    //   40: invokestatic 102	arf:a	(Ljava/io/Closeable;)V
    //   43: aload_2
    //   44: areturn
    //   45: aconst_null
    //   46: astore_2
    //   47: goto -8 -> 39
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: invokestatic 102	arf:a	(Ljava/io/Closeable;)V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_1
    //   60: aload_3
    //   61: astore_2
    //   62: aload_2
    //   63: invokestatic 102	arf:a	(Ljava/io/Closeable;)V
    //   66: aload_1
    //   67: athrow
    //   68: astore_3
    //   69: aload_1
    //   70: astore_2
    //   71: aload_3
    //   72: astore_1
    //   73: goto -11 -> 62
    //   76: astore_2
    //   77: goto -24 -> 53
    //
    // Exception table:
    //   from	to	target	type
    //   2	19	50	java/lang/Exception
    //   2	19	59	finally
    //   19	34	68	finally
    //   19	34	76	java/lang/Exception
  }

  private void n()
  {
    this.a = false;
    invalidateSelf();
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    this.i = new WeakReference(new avz(localSwipeApplication).a(localSwipeApplication.getResources().getDrawable(2130837771)).g(2131230736).h(-285212673).a(null).a(new OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        aex.this.a = true;
        aex.this.invalidateSelf();
      }
    }).b());
  }

  private void o()
  {
    try
    {
      if ((this.i != null) && (this.i.get() != null) && (((tj)this.i.get()).isShowing()))
      {
        ((tj)this.i.get()).dismiss();
        this.i.clear();
        this.i = null;
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public Bitmap a(int paramInt)
  {
    try
    {
      Bitmap localBitmap = (Bitmap)this.f.get(paramInt);
      return localBitmap;
    }
    catch (Exception localException)
    {
    }
    return m();
  }

  public void a(File paramFile)
  {
    this.d = a(paramFile, "dice_blur");
    this.e = a(paramFile, "dice_clear");
    int j = 1;
    while (j <= 6)
    {
      String str = "dice0" + j;
      this.f.put(j, a(paramFile, str));
      j += 1;
    }
  }

  public void i()
  {
    Log.i(c, "start().");
    this.g = false;
    this.h.d();
  }

  public void j()
  {
    super.j();
    this.g = true;
  }

  public void k()
  {
    Log.i(c, "recycle()");
    super.k();
    atw.a(this.d);
    atw.a(this.e);
    int j = 1;
    while (j <= 6)
    {
      atw.a((Bitmap) this.f.get(j));
      j += 1;
    }
    o();
  }

  public Bitmap l()
  {
    return this.d;
  }

  public Bitmap m()
  {
    return this.e;
  }

  public boolean m_()
  {
    if (!atw.b(this.d))
      return false;
    if (!atw.b(this.e))
      return false;
    int j = 1;
    while (j <= 6)
    {
      if (!atw.b((Bitmap) this.f.get(j)))
        return false;
      j += 1;
    }
    return true;
  }

  public void n_()
  {
    vs.b(SwipeApplication.c(), "dice_res_loaded", true);
    if (!this.g)
      super.i();
  }

  public void o_()
  {
  }

  public void p_()
  {
    n();
  }

  public void q_()
  {
    o();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aex
 * JD-Core Version:    0.6.2
 */