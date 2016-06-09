package com.oppo.launcher;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class PointIndicatorView extends ImageView
{
  private static final boolean DEBUG_NORMAL = Launcher.DEBUG_NORMAL;
  private static final int ORIENTATION_HORIZONTAL = 1;
  private static final String TAG = "Launcher.PointIndicatorView";
  private int mBitmapHeight;
  private int mBitmapWidth;
  private int mCurrentPage;
  private Bitmap mFocusedPointBitmap;
  private int mInternalSpace;
  private Drawable mNavigate;
  private Bitmap mNormalPointBitmap;
  private int mOrientation;
  private Paint mPaint;
  private int mTotalPage;

  public PointIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  // ERROR //
  public PointIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 44	android/widget/ImageView:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 46	android/graphics/Paint
    //   11: dup
    //   12: invokespecial 48	android/graphics/Paint:<init>	()V
    //   15: putfield 50	com/oppo/launcher/PointIndicatorView:mPaint	Landroid/graphics/Paint;
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 52	com/oppo/launcher/PointIndicatorView:mTotalPage	I
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 54	com/oppo/launcher/PointIndicatorView:mCurrentPage	I
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 56	com/oppo/launcher/PointIndicatorView:mNormalPointBitmap	Landroid/graphics/Bitmap;
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 58	com/oppo/launcher/PointIndicatorView:mFocusedPointBitmap	Landroid/graphics/Bitmap;
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 60	com/oppo/launcher/PointIndicatorView:mBitmapWidth	I
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 62	com/oppo/launcher/PointIndicatorView:mBitmapHeight	I
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 64	com/oppo/launcher/PointIndicatorView:mInternalSpace	I
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 66	com/oppo/launcher/PointIndicatorView:mNavigate	Landroid/graphics/drawable/Drawable;
    //   58: aload_0
    //   59: iconst_1
    //   60: putfield 68	com/oppo/launcher/PointIndicatorView:mOrientation	I
    //   63: aload_1
    //   64: aload_2
    //   65: getstatic 74	com/oppo/launcher/R$styleable:PagePointView	[I
    //   68: iload_3
    //   69: iconst_0
    //   70: invokevirtual 80	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   73: astore_1
    //   74: aload_0
    //   75: aload_1
    //   76: iconst_0
    //   77: iconst_1
    //   78: invokevirtual 86	android/content/res/TypedArray:getInt	(II)I
    //   81: putfield 68	com/oppo/launcher/PointIndicatorView:mOrientation	I
    //   84: aload_0
    //   85: aload_1
    //   86: iconst_1
    //   87: iconst_0
    //   88: invokevirtual 89	android/content/res/TypedArray:getDimensionPixelOffset	(II)I
    //   91: putfield 64	com/oppo/launcher/PointIndicatorView:mInternalSpace	I
    //   94: aload_1
    //   95: invokevirtual 92	android/content/res/TypedArray:recycle	()V
    //   98: aload_0
    //   99: getfield 68	com/oppo/launcher/PointIndicatorView:mOrientation	I
    //   102: iconst_1
    //   103: if_icmpne +250 -> 353
    //   106: aload_0
    //   107: invokevirtual 96	com/oppo/launcher/PointIndicatorView:getResources	()Landroid/content/res/Resources;
    //   110: astore_1
    //   111: aload_1
    //   112: ldc 97
    //   114: invokevirtual 103	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   117: astore_2
    //   118: aload_0
    //   119: aload_2
    //   120: invokestatic 109	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   123: putfield 56	com/oppo/launcher/PointIndicatorView:mNormalPointBitmap	Landroid/graphics/Bitmap;
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 114	java/io/InputStream:close	()V
    //   134: aload_1
    //   135: ldc 115
    //   137: invokevirtual 103	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   140: astore_1
    //   141: aload_0
    //   142: aload_1
    //   143: invokestatic 109	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   146: putfield 58	com/oppo/launcher/PointIndicatorView:mFocusedPointBitmap	Landroid/graphics/Bitmap;
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 114	java/io/InputStream:close	()V
    //   157: getstatic 33	com/oppo/launcher/PointIndicatorView:DEBUG_NORMAL	Z
    //   160: ifeq +171 -> 331
    //   163: ldc 13
    //   165: new 117	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   172: ldc 120
    //   174: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 56	com/oppo/launcher/PointIndicatorView:mNormalPointBitmap	Landroid/graphics/Bitmap;
    //   181: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 137	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   190: pop
    //   191: ldc 13
    //   193: new 117	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   200: ldc 139
    //   202: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: getfield 58	com/oppo/launcher/PointIndicatorView:mFocusedPointBitmap	Landroid/graphics/Bitmap;
    //   209: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 137	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   218: pop
    //   219: ldc 13
    //   221: new 117	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   228: ldc 141
    //   230: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_0
    //   234: getfield 52	com/oppo/launcher/PointIndicatorView:mTotalPage	I
    //   237: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 137	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   246: pop
    //   247: ldc 13
    //   249: new 117	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   256: ldc 146
    //   258: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_0
    //   262: getfield 54	com/oppo/launcher/PointIndicatorView:mCurrentPage	I
    //   265: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 137	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   274: pop
    //   275: ldc 13
    //   277: new 117	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   284: ldc 148
    //   286: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_0
    //   290: getfield 68	com/oppo/launcher/PointIndicatorView:mOrientation	I
    //   293: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 137	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   302: pop
    //   303: ldc 13
    //   305: new 117	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   312: ldc 150
    //   314: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: getfield 64	com/oppo/launcher/PointIndicatorView:mInternalSpace	I
    //   321: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 137	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   330: pop
    //   331: aload_0
    //   332: aload_0
    //   333: getfield 56	com/oppo/launcher/PointIndicatorView:mNormalPointBitmap	Landroid/graphics/Bitmap;
    //   336: invokevirtual 156	android/graphics/Bitmap:getWidth	()I
    //   339: putfield 60	com/oppo/launcher/PointIndicatorView:mBitmapWidth	I
    //   342: aload_0
    //   343: aload_0
    //   344: getfield 56	com/oppo/launcher/PointIndicatorView:mNormalPointBitmap	Landroid/graphics/Bitmap;
    //   347: invokevirtual 159	android/graphics/Bitmap:getHeight	()I
    //   350: putfield 62	com/oppo/launcher/PointIndicatorView:mBitmapHeight	I
    //   353: return
    //   354: astore_2
    //   355: ldc 13
    //   357: ldc 161
    //   359: invokestatic 164	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   362: pop
    //   363: goto -229 -> 134
    //   366: astore 4
    //   368: ldc 13
    //   370: ldc 166
    //   372: invokestatic 164	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   375: pop
    //   376: aload_2
    //   377: ifnull -243 -> 134
    //   380: aload_2
    //   381: invokevirtual 114	java/io/InputStream:close	()V
    //   384: goto -250 -> 134
    //   387: astore_2
    //   388: ldc 13
    //   390: ldc 161
    //   392: invokestatic 164	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   395: pop
    //   396: goto -262 -> 134
    //   399: astore_1
    //   400: aload_2
    //   401: ifnull +7 -> 408
    //   404: aload_2
    //   405: invokevirtual 114	java/io/InputStream:close	()V
    //   408: aload_1
    //   409: athrow
    //   410: astore_2
    //   411: ldc 13
    //   413: ldc 161
    //   415: invokestatic 164	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   418: pop
    //   419: goto -11 -> 408
    //   422: astore_1
    //   423: ldc 13
    //   425: ldc 161
    //   427: invokestatic 164	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   430: pop
    //   431: goto -274 -> 157
    //   434: astore_2
    //   435: ldc 13
    //   437: ldc 166
    //   439: invokestatic 164	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   442: pop
    //   443: aload_1
    //   444: ifnull -287 -> 157
    //   447: aload_1
    //   448: invokevirtual 114	java/io/InputStream:close	()V
    //   451: goto -294 -> 157
    //   454: astore_1
    //   455: ldc 13
    //   457: ldc 161
    //   459: invokestatic 164	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   462: pop
    //   463: goto -306 -> 157
    //   466: astore_2
    //   467: aload_1
    //   468: ifnull +7 -> 475
    //   471: aload_1
    //   472: invokevirtual 114	java/io/InputStream:close	()V
    //   475: aload_2
    //   476: athrow
    //   477: astore_1
    //   478: ldc 13
    //   480: ldc 161
    //   482: invokestatic 164	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   485: pop
    //   486: goto -11 -> 475
    //
    // Exception table:
    //   from	to	target	type
    //   130	134	354	java/io/IOException
    //   118	126	366	java/lang/Exception
    //   380	384	387	java/io/IOException
    //   118	126	399	finally
    //   368	376	399	finally
    //   404	408	410	java/io/IOException
    //   153	157	422	java/io/IOException
    //   141	149	434	java/lang/Exception
    //   447	451	454	java/io/IOException
    //   141	149	466	finally
    //   435	443	466	finally
    //   471	475	477	java/io/IOException
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mOrientation == 1)
    {
      if (DEBUG_NORMAL)
      {
        Log.d("Launcher.PointIndicatorView", "PointIndicatorView --- onDraw  -- drawbitmap");
        Log.d("Launcher.PointIndicatorView", "PointIndicatorView --- onDraw  -- mTotalPage = " + this.mTotalPage);
        Log.d("Launcher.PointIndicatorView", "PointIndicatorView --- onDraw  -- mCurrentPage = " + this.mCurrentPage);
      }
      int k = this.mTotalPage;
      int m = this.mCurrentPage;
      int j = getWidth();
      int n = getHeight();
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i;
      if (k > 0)
      {
        i = k - 1;
        j = i1 + (j - (i1 + i2 + this.mBitmapWidth * k + this.mInternalSpace * i)) / 2;
        n = (n - this.mBitmapHeight) / 2;
        i = 0;
        label164: if (i >= k)
          return;
        if (i != m)
          break label217;
        paramCanvas.drawBitmap(this.mFocusedPointBitmap, j, n, this.mPaint);
      }
      while (true)
      {
        j += this.mBitmapWidth + this.mInternalSpace;
        i += 1;
        break label164;
        i = 0;
        break;
        label217: paramCanvas.drawBitmap(this.mNormalPointBitmap, j, n, this.mPaint);
      }
    }
    else
    {
      if (DEBUG_NORMAL)
        Log.d("Launcher.PointIndicatorView", "PointIndicatorView --- onDraw  -- super.onDraw");
      super.onDraw(paramCanvas);
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (this.mOrientation == 1)
    {
      setImageDrawable(null);
      return;
    }
    this.mNavigate = getDrawable();
  }

  public void updateIndicators(int paramInt1, int paramInt2)
  {
    if (DEBUG_NORMAL)
    {
      Log.d("Launcher.PointIndicatorView", "updateIndicators -- total = " + paramInt1);
      Log.d("Launcher.PointIndicatorView", "updateIndicators -- level = " + paramInt2);
      Log.d("Launcher.PointIndicatorView", "updateIndicators -- mTotalPage = " + this.mTotalPage);
      Log.d("Launcher.PointIndicatorView", "updateIndicators -- mCurrentPage = " + this.mCurrentPage);
    }
    if (paramInt2 > paramInt1);
    do
    {
      int i;
      do
      {
        return;
        if (this.mOrientation != 1)
          break;
        int k = 0;
        int j = 0;
        i = k;
        if (paramInt2 >= 0)
        {
          i = k;
          if (paramInt2 < paramInt1)
          {
            if (paramInt2 != this.mCurrentPage)
            {
              this.mCurrentPage = paramInt2;
              j = 1;
            }
            i = j;
            if (paramInt1 != this.mTotalPage)
            {
              i = j;
              if (paramInt1 >= 1)
              {
                this.mTotalPage = paramInt1;
                i = 1;
              }
            }
          }
        }
      }
      while (i == 0);
      invalidate();
      return;
    }
    while (this.mNavigate == null);
    this.mNavigate.setLevel(paramInt2);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.PointIndicatorView
 * JD-Core Version:    0.6.2
 */