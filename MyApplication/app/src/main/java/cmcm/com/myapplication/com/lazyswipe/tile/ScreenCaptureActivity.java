package cmcm.com.myapplication.com.lazyswipe.tile;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import aph;
import vj;

@TargetApi(21)
public class ScreenCaptureActivity extends aph
  implements OnImageAvailableListener
{
  private MediaProjectionManager i;
  private MediaProjection j;
  private int k;
  private int l;
  private boolean m;

  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, ScreenCaptureActivity.class).addFlags(268435456));
  }

  private void a(String paramString)
  {
    Intent localIntent = new Intent("com.lazyswipe.action.SCREEN_CAPTURE_FINISHED").setPackage("com.lazyswipe");
    if (paramString != null)
      localIntent.putExtra("com.lazyswipe.extra.CAPTURE_FILE_PATH", paramString);
    sendBroadcast(localIntent);
  }

  private void g()
  {
    a(null);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1)
      {
        g();
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        finish();
        return;
      }
      this.j = this.i.getMediaProjection(paramInt2, paramIntent);
      if (this.j == null)
        break label151;
      Object localObject = getWindowManager().getDefaultDisplay();
      Point localPoint = new Point();
      ((Display)localObject).getRealSize(localPoint);
      this.k = localPoint.x;
      this.l = localPoint.y;
      localObject = ImageReader.newInstance(this.k, this.l, 1, 1);
      this.j.createVirtualDisplay("screen_capture", this.k, this.l, vj.d, 16, ((ImageReader)localObject).getSurface(), null, null);
      ((ImageReader)localObject).setOnImageAvailableListener(this, null);
    }
    while (true)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label151: g();
      finish();
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.m = false;
    this.i = ((MediaProjectionManager)getSystemService("media_projection"));
    try
    {
      startActivityForResult(this.i.createScreenCaptureIntent(), 1);
      return;
    }
    catch (ActivityNotFoundException paramBundle)
    {
      g();
      finish();
    }
  }

  // ERROR //
  public void onImageAvailable(ImageReader paramImageReader)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 147	com/lazyswipe/tile/ScreenCaptureActivity:m	Z
    //   10: ifeq +16 -> 26
    //   13: ldc 167
    //   15: ldc 169
    //   17: invokestatic 175	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   20: pop
    //   21: aload_0
    //   22: invokevirtual 73	com/lazyswipe/tile/ScreenCaptureActivity:finish	()V
    //   25: return
    //   26: aload_1
    //   27: invokevirtual 179	android/media/ImageReader:acquireLatestImage	()Landroid/media/Image;
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 185	android/media/Image:getPlanes	()[Landroid/media/Image$Plane;
    //   35: iconst_0
    //   36: aaload
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 191	android/media/Image$Plane:getPixelStride	()I
    //   42: istore 10
    //   44: aload_2
    //   45: invokevirtual 194	android/media/Image$Plane:getRowStride	()I
    //   48: istore 11
    //   50: aload_0
    //   51: getfield 107	com/lazyswipe/tile/ScreenCaptureActivity:k	I
    //   54: istore 12
    //   56: aload_2
    //   57: invokevirtual 198	android/media/Image$Plane:getBuffer	()Ljava/nio/ByteBuffer;
    //   60: astore_2
    //   61: aload_2
    //   62: invokevirtual 204	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   65: pop
    //   66: aload_0
    //   67: getfield 107	com/lazyswipe/tile/ScreenCaptureActivity:k	I
    //   70: aload_0
    //   71: getfield 112	com/lazyswipe/tile/ScreenCaptureActivity:l	I
    //   74: getstatic 210	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   77: invokestatic 216	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   80: astore_3
    //   81: iconst_0
    //   82: istore 8
    //   84: iconst_0
    //   85: istore 7
    //   87: iload 8
    //   89: aload_0
    //   90: getfield 112	com/lazyswipe/tile/ScreenCaptureActivity:l	I
    //   93: if_icmpge +99 -> 192
    //   96: iconst_0
    //   97: istore 9
    //   99: iload 9
    //   101: aload_0
    //   102: getfield 107	com/lazyswipe/tile/ScreenCaptureActivity:k	I
    //   105: if_icmpge +318 -> 423
    //   108: aload_3
    //   109: iload 9
    //   111: iload 8
    //   113: aload_2
    //   114: iload 7
    //   116: invokevirtual 220	java/nio/ByteBuffer:get	(I)B
    //   119: sipush 255
    //   122: iand
    //   123: bipush 16
    //   125: ishl
    //   126: iconst_0
    //   127: ior
    //   128: aload_2
    //   129: iload 7
    //   131: iconst_1
    //   132: iadd
    //   133: invokevirtual 220	java/nio/ByteBuffer:get	(I)B
    //   136: sipush 255
    //   139: iand
    //   140: bipush 8
    //   142: ishl
    //   143: ior
    //   144: aload_2
    //   145: iload 7
    //   147: iconst_2
    //   148: iadd
    //   149: invokevirtual 220	java/nio/ByteBuffer:get	(I)B
    //   152: sipush 255
    //   155: iand
    //   156: ior
    //   157: aload_2
    //   158: iload 7
    //   160: iconst_3
    //   161: iadd
    //   162: invokevirtual 220	java/nio/ByteBuffer:get	(I)B
    //   165: sipush 255
    //   168: iand
    //   169: bipush 24
    //   171: ishl
    //   172: ior
    //   173: invokevirtual 224	android/graphics/Bitmap:setPixel	(III)V
    //   176: iload 7
    //   178: iload 10
    //   180: iadd
    //   181: istore 7
    //   183: iload 9
    //   185: iconst_1
    //   186: iadd
    //   187: istore 9
    //   189: goto -90 -> 99
    //   192: invokestatic 230	anj:r	()Ljava/lang/String;
    //   195: astore 6
    //   197: new 232	java/io/FileOutputStream
    //   200: dup
    //   201: aload 6
    //   203: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   206: astore_2
    //   207: aload_3
    //   208: getstatic 239	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   211: bipush 100
    //   213: aload_2
    //   214: invokevirtual 243	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   217: pop
    //   218: aload_0
    //   219: iconst_1
    //   220: putfield 147	com/lazyswipe/tile/ScreenCaptureActivity:m	Z
    //   223: aload_0
    //   224: aload 6
    //   226: invokespecial 64	com/lazyswipe/tile/ScreenCaptureActivity:a	(Ljava/lang/String;)V
    //   229: aload_2
    //   230: ifnull +7 -> 237
    //   233: aload_2
    //   234: invokestatic 248	arf:a	(Ljava/io/Closeable;)V
    //   237: aload_3
    //   238: ifnull +7 -> 245
    //   241: aload_3
    //   242: invokevirtual 251	android/graphics/Bitmap:recycle	()V
    //   245: aload_1
    //   246: ifnull +7 -> 253
    //   249: aload_1
    //   250: invokevirtual 254	android/media/Image:close	()V
    //   253: aload_0
    //   254: getfield 83	com/lazyswipe/tile/ScreenCaptureActivity:j	Landroid/media/projection/MediaProjection;
    //   257: invokevirtual 257	android/media/projection/MediaProjection:stop	()V
    //   260: aload_0
    //   261: invokevirtual 73	com/lazyswipe/tile/ScreenCaptureActivity:finish	()V
    //   264: return
    //   265: astore_2
    //   266: aconst_null
    //   267: astore_3
    //   268: aconst_null
    //   269: astore_1
    //   270: ldc 167
    //   272: ldc_w 259
    //   275: aload_2
    //   276: invokestatic 264	asp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: aload_0
    //   280: invokespecial 68	com/lazyswipe/tile/ScreenCaptureActivity:g	()V
    //   283: aload 4
    //   285: ifnull +8 -> 293
    //   288: aload 4
    //   290: invokestatic 248	arf:a	(Ljava/io/Closeable;)V
    //   293: aload_3
    //   294: ifnull +7 -> 301
    //   297: aload_3
    //   298: invokevirtual 251	android/graphics/Bitmap:recycle	()V
    //   301: aload_1
    //   302: ifnull +7 -> 309
    //   305: aload_1
    //   306: invokevirtual 254	android/media/Image:close	()V
    //   309: aload_0
    //   310: getfield 83	com/lazyswipe/tile/ScreenCaptureActivity:j	Landroid/media/projection/MediaProjection;
    //   313: invokevirtual 257	android/media/projection/MediaProjection:stop	()V
    //   316: aload_0
    //   317: invokevirtual 73	com/lazyswipe/tile/ScreenCaptureActivity:finish	()V
    //   320: return
    //   321: astore_2
    //   322: aconst_null
    //   323: astore_3
    //   324: aconst_null
    //   325: astore_1
    //   326: aload 5
    //   328: astore 4
    //   330: aload 4
    //   332: ifnull +8 -> 340
    //   335: aload 4
    //   337: invokestatic 248	arf:a	(Ljava/io/Closeable;)V
    //   340: aload_3
    //   341: ifnull +7 -> 348
    //   344: aload_3
    //   345: invokevirtual 251	android/graphics/Bitmap:recycle	()V
    //   348: aload_1
    //   349: ifnull +7 -> 356
    //   352: aload_1
    //   353: invokevirtual 254	android/media/Image:close	()V
    //   356: aload_0
    //   357: getfield 83	com/lazyswipe/tile/ScreenCaptureActivity:j	Landroid/media/projection/MediaProjection;
    //   360: invokevirtual 257	android/media/projection/MediaProjection:stop	()V
    //   363: aload_0
    //   364: invokevirtual 73	com/lazyswipe/tile/ScreenCaptureActivity:finish	()V
    //   367: aload_2
    //   368: athrow
    //   369: astore_2
    //   370: aconst_null
    //   371: astore_3
    //   372: aload 5
    //   374: astore 4
    //   376: goto -46 -> 330
    //   379: astore_2
    //   380: aload 5
    //   382: astore 4
    //   384: goto -54 -> 330
    //   387: astore 5
    //   389: aload_2
    //   390: astore 4
    //   392: aload 5
    //   394: astore_2
    //   395: goto -65 -> 330
    //   398: astore_2
    //   399: goto -69 -> 330
    //   402: astore_2
    //   403: aconst_null
    //   404: astore_3
    //   405: goto -135 -> 270
    //   408: astore_2
    //   409: goto -139 -> 270
    //   412: astore 5
    //   414: aload_2
    //   415: astore 4
    //   417: aload 5
    //   419: astore_2
    //   420: goto -150 -> 270
    //   423: iload 8
    //   425: iconst_1
    //   426: iadd
    //   427: istore 8
    //   429: iload 7
    //   431: iload 11
    //   433: iload 12
    //   435: iload 10
    //   437: imul
    //   438: isub
    //   439: iadd
    //   440: istore 7
    //   442: goto -355 -> 87
    //
    // Exception table:
    //   from	to	target	type
    //   26	31	265	java/lang/Exception
    //   26	31	321	finally
    //   31	81	369	finally
    //   87	96	379	finally
    //   99	176	379	finally
    //   192	207	379	finally
    //   207	229	387	finally
    //   270	283	398	finally
    //   31	81	402	java/lang/Exception
    //   87	96	408	java/lang/Exception
    //   99	176	408	java/lang/Exception
    //   192	207	408	java/lang/Exception
    //   207	229	412	java/lang/Exception
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    finish();
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.tile.ScreenCaptureActivity
 * JD-Core Version:    0.6.2
 */