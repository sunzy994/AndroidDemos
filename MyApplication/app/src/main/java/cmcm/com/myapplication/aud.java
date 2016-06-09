package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.lang.ref.WeakReference;

public class aud
  implements Runnable
{
  final WeakReference<auc> a;
  final WeakReference<View> b;
  final wk c;
  final Handler d;
  int e;
  int f;
  Drawable g;
  final String h;
  final String i;
  final String j;
  ScaleType k;
  boolean l;

  public aud(Handler paramHandler, View paramView, String paramString, auc paramauc)
  {
    this.d = paramHandler;
    this.b = new WeakReference(paramView);
    this.c = null;
    this.h = paramString;
    this.j = null;
    this.i = null;
    if (paramauc == null);
    for (paramHandler = localObject; ; paramHandler = new WeakReference(paramauc))
    {
      this.a = paramHandler;
      return;
    }
  }

  public aud(Handler paramHandler, View paramView, String paramString1, String paramString2, int paramInt1, int paramInt2, auc paramauc)
  {
    if ((Build.VERSION.SDK_INT >= 16) && ((paramView instanceof ImageView)))
    {
      this.k = ((ImageView)paramView).getScaleType();
      if (ScaleType.CENTER_INSIDE != this.k)
        ((ImageView)paramView).setScaleType(ScaleType.CENTER_INSIDE);
      this.l = ((ImageView)paramView).getAdjustViewBounds();
      if (this.l)
        ((ImageView)paramView).setAdjustViewBounds(false);
    }
    this.b = new WeakReference(paramView);
    this.d = paramHandler;
    this.c = null;
    this.h = null;
    this.i = paramString2;
    this.j = paramString1;
    if (paramauc == null);
    for (paramHandler = null; ; paramHandler = new WeakReference(paramauc))
    {
      this.a = paramHandler;
      this.e = paramInt1;
      this.f = paramInt2;
      return;
    }
  }

  public aud(Handler paramHandler, View paramView, wk paramwk, auc paramauc)
  {
    this.d = paramHandler;
    this.b = new WeakReference(paramView);
    this.c = paramwk;
    this.h = null;
    this.j = null;
    this.i = null;
    if (paramauc == null);
    for (paramHandler = localObject; ; paramHandler = new WeakReference(paramauc))
    {
      this.a = paramHandler;
      return;
    }
  }

  // ERROR //
  private void a(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: lload_1
    //   9: lconst_0
    //   10: lcmp
    //   11: ifle +105 -> 116
    //   14: aload_0
    //   15: getfield 42	aud:b	Ljava/lang/ref/WeakReference;
    //   18: invokevirtual 98	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   21: checkcast 100	android/view/View
    //   24: invokevirtual 104	android/view/View:getContext	()Landroid/content/Context;
    //   27: invokevirtual 110	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   30: astore 4
    //   32: getstatic 115	xc:a	Landroid/net/Uri;
    //   35: astore 7
    //   37: aload_0
    //   38: getfield 50	aud:i	Ljava/lang/String;
    //   41: astore 8
    //   43: aload 4
    //   45: aload 7
    //   47: iconst_1
    //   48: anewarray 117	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: ldc 119
    //   55: aastore
    //   56: ldc 121
    //   58: iconst_1
    //   59: anewarray 117	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: aload 8
    //   66: aastore
    //   67: aconst_null
    //   68: invokevirtual 127	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload_3
    //   77: invokeinterface 132 1 0
    //   82: ifeq +24 -> 106
    //   85: aload_0
    //   86: new 134	android/graphics/drawable/BitmapDrawable
    //   89: dup
    //   90: aload_3
    //   91: iconst_0
    //   92: invokeinterface 138 2 0
    //   97: invokestatic 143	atw:a	([B)Landroid/graphics/Bitmap;
    //   100: invokespecial 146	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   103: putfield 148	aud:g	Landroid/graphics/drawable/Drawable;
    //   106: aload_3
    //   107: ifnull +9 -> 116
    //   110: aload_3
    //   111: invokeinterface 151 1 0
    //   116: aload_0
    //   117: getfield 148	aud:g	Landroid/graphics/drawable/Drawable;
    //   120: ifnonnull +248 -> 368
    //   123: aload 5
    //   125: astore_3
    //   126: aload 6
    //   128: astore 4
    //   130: aload_0
    //   131: getfield 42	aud:b	Ljava/lang/ref/WeakReference;
    //   134: invokevirtual 98	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   137: checkcast 100	android/view/View
    //   140: invokevirtual 104	android/view/View:getContext	()Landroid/content/Context;
    //   143: invokevirtual 110	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   146: astore 7
    //   148: aload 5
    //   150: astore_3
    //   151: aload 6
    //   153: astore 4
    //   155: getstatic 154	xj:a	Landroid/net/Uri;
    //   158: astore 8
    //   160: aload 5
    //   162: astore_3
    //   163: aload 6
    //   165: astore 4
    //   167: aload_0
    //   168: getfield 50	aud:i	Ljava/lang/String;
    //   171: astore 9
    //   173: aload 5
    //   175: astore_3
    //   176: aload 6
    //   178: astore 4
    //   180: aload 7
    //   182: aload 8
    //   184: iconst_2
    //   185: anewarray 117	java/lang/String
    //   188: dup
    //   189: iconst_0
    //   190: ldc 156
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: ldc 158
    //   197: aastore
    //   198: ldc 160
    //   200: iconst_1
    //   201: anewarray 117	java/lang/String
    //   204: dup
    //   205: iconst_0
    //   206: aload 9
    //   208: aastore
    //   209: aconst_null
    //   210: invokevirtual 127	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   213: astore 5
    //   215: aload 5
    //   217: astore_3
    //   218: aload 5
    //   220: astore 4
    //   222: aload 5
    //   224: invokeinterface 132 1 0
    //   229: ifeq +127 -> 356
    //   232: aload 5
    //   234: astore_3
    //   235: aload 5
    //   237: astore 4
    //   239: aload 5
    //   241: iconst_0
    //   242: invokeinterface 164 2 0
    //   247: astore 6
    //   249: aload 5
    //   251: astore_3
    //   252: aload 5
    //   254: astore 4
    //   256: aload 5
    //   258: iconst_1
    //   259: invokeinterface 164 2 0
    //   264: astore 7
    //   266: aload 5
    //   268: astore_3
    //   269: aload 5
    //   271: astore 4
    //   273: aload 6
    //   275: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   278: ifne +35 -> 313
    //   281: aload 5
    //   283: astore_3
    //   284: aload 5
    //   286: astore 4
    //   288: aload_0
    //   289: aload_0
    //   290: getfield 42	aud:b	Ljava/lang/ref/WeakReference;
    //   293: invokevirtual 98	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   296: checkcast 100	android/view/View
    //   299: invokevirtual 104	android/view/View:getContext	()Landroid/content/Context;
    //   302: aload 6
    //   304: invokestatic 176	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   307: invokestatic 181	aqn:b	(Landroid/content/Context;Landroid/net/Uri;)Landroid/graphics/drawable/Drawable;
    //   310: putfield 148	aud:g	Landroid/graphics/drawable/Drawable;
    //   313: aload 5
    //   315: astore_3
    //   316: aload 5
    //   318: astore 4
    //   320: aload_0
    //   321: getfield 148	aud:g	Landroid/graphics/drawable/Drawable;
    //   324: ifnonnull +32 -> 356
    //   327: aload 5
    //   329: astore_3
    //   330: aload 5
    //   332: astore 4
    //   334: aload_0
    //   335: aload_0
    //   336: getfield 42	aud:b	Ljava/lang/ref/WeakReference;
    //   339: invokevirtual 98	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   342: checkcast 100	android/view/View
    //   345: invokevirtual 104	android/view/View:getContext	()Landroid/content/Context;
    //   348: aload 7
    //   350: invokestatic 184	aqn:c	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   353: putfield 148	aud:g	Landroid/graphics/drawable/Drawable;
    //   356: aload 5
    //   358: ifnull +10 -> 368
    //   361: aload 5
    //   363: invokeinterface 151 1 0
    //   368: return
    //   369: astore_3
    //   370: aconst_null
    //   371: astore_3
    //   372: aload_3
    //   373: ifnull -257 -> 116
    //   376: aload_3
    //   377: invokeinterface 151 1 0
    //   382: goto -266 -> 116
    //   385: astore 4
    //   387: aload_3
    //   388: ifnull +9 -> 397
    //   391: aload_3
    //   392: invokeinterface 151 1 0
    //   397: aload 4
    //   399: athrow
    //   400: astore 4
    //   402: aload_3
    //   403: ifnull -35 -> 368
    //   406: aload_3
    //   407: invokeinterface 151 1 0
    //   412: return
    //   413: astore_3
    //   414: aload 4
    //   416: ifnull +10 -> 426
    //   419: aload 4
    //   421: invokeinterface 151 1 0
    //   426: aload_3
    //   427: athrow
    //   428: astore 4
    //   430: goto -43 -> 387
    //   433: astore 4
    //   435: goto -63 -> 372
    //
    // Exception table:
    //   from	to	target	type
    //   14	73	369	java/lang/Throwable
    //   14	73	385	finally
    //   130	148	400	java/lang/Throwable
    //   155	160	400	java/lang/Throwable
    //   167	173	400	java/lang/Throwable
    //   180	215	400	java/lang/Throwable
    //   222	232	400	java/lang/Throwable
    //   239	249	400	java/lang/Throwable
    //   256	266	400	java/lang/Throwable
    //   273	281	400	java/lang/Throwable
    //   288	313	400	java/lang/Throwable
    //   320	327	400	java/lang/Throwable
    //   334	356	400	java/lang/Throwable
    //   130	148	413	finally
    //   155	160	413	finally
    //   167	173	413	finally
    //   180	215	413	finally
    //   222	232	413	finally
    //   239	249	413	finally
    //   256	266	413	finally
    //   273	281	413	finally
    //   288	313	413	finally
    //   320	327	413	finally
    //   334	356	413	finally
    //   76	106	428	finally
    //   76	106	433	java/lang/Throwable
  }

  private void a(Context paramContext)
  {
    paramContext = atx.a().a(this.c.i);
    this.g = paramContext;
    this.c.h = paramContext;
  }

  private boolean a()
  {
    if (!new File(this.j).exists())
      try
      {
        if ((TextUtils.isEmpty(this.i)) || (!ard.a(((View)this.b.get()).getContext(), this.i, this.j, 10000, 10000)))
        {
          this.d.obtainMessage(1, this).sendToTarget();
          return false;
        }
      }
      catch (Throwable localThrowable1)
      {
      }
    Bitmap localBitmap;
    if ((this.e <= 0) || (this.f <= 0))
      localBitmap = atw.a(this.j, false);
    try
    {
      while (true)
      {
        this.g = new BitmapDrawable(((View)this.b.get()).getContext().getResources(), localBitmap);
        label126: return true;
        localBitmap = atw.a(this.j, this.e, this.f, false);
      }
    }
    catch (Throwable localThrowable2)
    {
      break label126;
    }
  }

  // ERROR //
  private void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 42	aud:b	Ljava/lang/ref/WeakReference;
    //   6: invokevirtual 98	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   9: checkcast 100	android/view/View
    //   12: invokevirtual 104	android/view/View:getContext	()Landroid/content/Context;
    //   15: invokevirtual 110	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: astore_2
    //   19: getstatic 241	wz:a	Landroid/net/Uri;
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 50	aud:i	Ljava/lang/String;
    //   27: astore 4
    //   29: aload_0
    //   30: getfield 48	aud:j	Ljava/lang/String;
    //   33: astore 5
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_1
    //   38: anewarray 117	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: ldc 243
    //   45: aastore
    //   46: ldc 245
    //   48: iconst_2
    //   49: anewarray 117	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload 4
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: aload 5
    //   61: aastore
    //   62: aconst_null
    //   63: invokevirtual 127	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   66: astore_2
    //   67: aload_2
    //   68: astore_1
    //   69: aload_1
    //   70: invokeinterface 132 1 0
    //   75: ifeq +30 -> 105
    //   78: aload_1
    //   79: iconst_0
    //   80: invokeinterface 138 2 0
    //   85: invokestatic 143	atw:a	([B)Landroid/graphics/Bitmap;
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +15 -> 105
    //   93: aload_0
    //   94: new 134	android/graphics/drawable/BitmapDrawable
    //   97: dup
    //   98: aload_2
    //   99: invokespecial 146	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   102: putfield 148	aud:g	Landroid/graphics/drawable/Drawable;
    //   105: aload_1
    //   106: ifnull +9 -> 115
    //   109: aload_1
    //   110: invokeinterface 151 1 0
    //   115: aload_0
    //   116: getfield 148	aud:g	Landroid/graphics/drawable/Drawable;
    //   119: ifnonnull +27 -> 146
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 42	aud:b	Ljava/lang/ref/WeakReference;
    //   127: invokevirtual 98	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   130: checkcast 100	android/view/View
    //   133: invokevirtual 104	android/view/View:getContext	()Landroid/content/Context;
    //   136: aload_0
    //   137: getfield 48	aud:j	Ljava/lang/String;
    //   140: invokestatic 184	aqn:c	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   143: putfield 148	aud:g	Landroid/graphics/drawable/Drawable;
    //   146: return
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull -36 -> 115
    //   154: aload_1
    //   155: invokeinterface 151 1 0
    //   160: goto -45 -> 115
    //   163: astore_2
    //   164: aload_1
    //   165: ifnull +9 -> 174
    //   168: aload_1
    //   169: invokeinterface 151 1 0
    //   174: aload_2
    //   175: athrow
    //   176: astore_1
    //   177: return
    //   178: astore_2
    //   179: goto -15 -> 164
    //   182: astore_2
    //   183: goto -33 -> 150
    //
    // Exception table:
    //   from	to	target	type
    //   2	67	147	java/lang/Throwable
    //   2	67	163	finally
    //   122	146	176	java/lang/Throwable
    //   69	89	178	finally
    //   93	105	178	finally
    //   69	89	182	java/lang/Throwable
    //   93	105	182	java/lang/Throwable
  }

  public void run()
  {
    while (true)
    {
      try
      {
        if (this.b.get() == null)
          return;
        if (this.c != null)
        {
          a(SwipeApplication.c());
          this.d.obtainMessage(1, this).sendToTarget();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.w("Swipe.IconLoader", "Failed to load icon", localThrowable);
        return;
      }
      if (!TextUtils.isEmpty(this.i))
      {
        long l1 = asi.a(this.i, -1L);
        if (l1 > 0L)
          a(l1);
        else if ("com.whatsapp".equals(this.i))
          b();
        else if (a());
      }
      else
      {
        this.g = asq.a(((View)this.b.get()).getContext().getPackageManager(), this.h);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aud
 * JD-Core Version:    0.6.2
 */