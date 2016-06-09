package cmcm.com.myapplication.com.facebook.ads.internal.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.facebook.ads.internal.view.e;

public class k extends AsyncTask<String, Void, Bitmap[]>
{
  private static final String a = k.class.getSimpleName();
  private final Context b;
  private final ImageView c;
  private final e d;
  private l e;

  public k(Context paramContext)
  {
    this.b = paramContext;
    this.d = null;
    this.c = null;
  }

  public k(ImageView paramImageView)
  {
    this.b = paramImageView.getContext();
    this.d = null;
    this.c = paramImageView;
  }

  public k(e parame)
  {
    this.b = parame.getContext();
    this.d = parame;
    this.c = null;
  }

  public k a(l paraml)
  {
    this.e = paraml;
    return this;
  }

  protected void a(Bitmap[] paramArrayOfBitmap)
  {
    if (this.c != null)
      this.c.setImageBitmap(paramArrayOfBitmap[0]);
    if (this.d != null)
      this.d.a(paramArrayOfBitmap[0], paramArrayOfBitmap[1]);
    if (this.e != null)
      this.e.a();
  }

  // ERROR //
  protected Bitmap[] a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: iconst_0
    //   5: aaload
    //   6: astore 5
    //   8: aload_0
    //   9: getfield 32	com/facebook/ads/internal/util/k:b	Landroid/content/Context;
    //   12: aload 5
    //   14: invokestatic 70	com/facebook/ads/internal/util/m:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   17: astore_1
    //   18: aload_1
    //   19: astore_2
    //   20: aload_1
    //   21: ifnonnull +50 -> 71
    //   24: aload_1
    //   25: astore_2
    //   26: new 72	com/facebook/ads/internal/thirdparty/http/a
    //   29: dup
    //   30: aload_0
    //   31: getfield 32	com/facebook/ads/internal/util/k:b	Landroid/content/Context;
    //   34: invokespecial 74	com/facebook/ads/internal/thirdparty/http/a:<init>	(Landroid/content/Context;)V
    //   37: aload 5
    //   39: aconst_null
    //   40: invokevirtual 77	com/facebook/ads/internal/thirdparty/http/a:a	(Ljava/lang/String;Lcom/facebook/ads/internal/thirdparty/http/o;)Lcom/facebook/ads/internal/thirdparty/http/n;
    //   43: invokevirtual 82	com/facebook/ads/internal/thirdparty/http/n:d	()[B
    //   46: astore_3
    //   47: aload_1
    //   48: astore_2
    //   49: aload_3
    //   50: iconst_0
    //   51: aload_3
    //   52: arraylength
    //   53: invokestatic 88	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   56: astore_1
    //   57: aload_1
    //   58: astore_2
    //   59: aload_0
    //   60: getfield 32	com/facebook/ads/internal/util/k:b	Landroid/content/Context;
    //   63: aload 5
    //   65: aload_1
    //   66: invokestatic 91	com/facebook/ads/internal/util/m:a	(Landroid/content/Context;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   69: aload_1
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 34	com/facebook/ads/internal/util/k:d	Lcom/facebook/ads/internal/view/e;
    //   77: astore 6
    //   79: aload 4
    //   81: astore_2
    //   82: aload_1
    //   83: astore_3
    //   84: aload 6
    //   86: ifnull +44 -> 130
    //   89: aload 4
    //   91: astore_2
    //   92: aload_1
    //   93: astore_3
    //   94: aload_1
    //   95: ifnull +35 -> 130
    //   98: new 93	com/facebook/ads/internal/util/q
    //   101: dup
    //   102: aload_1
    //   103: invokespecial 95	com/facebook/ads/internal/util/q:<init>	(Landroid/graphics/Bitmap;)V
    //   106: astore_2
    //   107: aload_2
    //   108: aload_1
    //   109: invokevirtual 101	android/graphics/Bitmap:getWidth	()I
    //   112: i2f
    //   113: ldc 102
    //   115: fdiv
    //   116: invokestatic 108	java/lang/Math:round	(F)I
    //   119: invokevirtual 111	com/facebook/ads/internal/util/q:a	(I)Landroid/graphics/Bitmap;
    //   122: pop
    //   123: aload_2
    //   124: invokevirtual 114	com/facebook/ads/internal/util/q:a	()Landroid/graphics/Bitmap;
    //   127: astore_2
    //   128: aload_1
    //   129: astore_3
    //   130: iconst_2
    //   131: anewarray 97	android/graphics/Bitmap
    //   134: dup
    //   135: iconst_0
    //   136: aload_3
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload_2
    //   141: aastore
    //   142: areturn
    //   143: astore_3
    //   144: aconst_null
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_1
    //   148: getstatic 25	com/facebook/ads/internal/util/k:a	Ljava/lang/String;
    //   151: new 116	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   158: ldc 119
    //   160: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 5
    //   165: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aload_3
    //   172: invokestatic 131	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   175: pop
    //   176: aload_3
    //   177: aconst_null
    //   178: invokestatic 136	com/facebook/ads/internal/util/b:a	(Ljava/lang/Throwable;Ljava/lang/String;)Lcom/facebook/ads/internal/util/b;
    //   181: invokestatic 141	com/facebook/ads/internal/util/c:a	(Lcom/facebook/ads/internal/util/b;)V
    //   184: aload_2
    //   185: astore_3
    //   186: aload_1
    //   187: astore_2
    //   188: goto -58 -> 130
    //   191: astore_3
    //   192: aconst_null
    //   193: astore_1
    //   194: goto -46 -> 148
    //   197: astore_3
    //   198: aload_1
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_1
    //   202: goto -54 -> 148
    //   205: astore_3
    //   206: aload_1
    //   207: astore_2
    //   208: goto -60 -> 148
    //
    // Exception table:
    //   from	to	target	type
    //   8	18	143	java/lang/Throwable
    //   26	47	191	java/lang/Throwable
    //   49	57	191	java/lang/Throwable
    //   59	69	191	java/lang/Throwable
    //   73	79	197	java/lang/Throwable
    //   98	128	205	java/lang/Throwable
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.util.k
 * JD-Core Version:    0.6.2
 */