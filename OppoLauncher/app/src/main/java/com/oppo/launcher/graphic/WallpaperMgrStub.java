package com.oppo.launcher.graphic;

import android.app.IWallpaperManagerCallback.Stub;

public class WallpaperMgrStub extends IWallpaperManagerCallback.Stub
{
  private static final String TAG = "WallpaperMgrStub";

  // ERROR //
  public android.graphics.Bitmap getCurrentWallpaperLocked(android.content.Context paramContext, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 31	android/os/ServiceManager:getService	(Ljava/lang/String;)Landroid/os/IBinder;
    //   5: invokestatic 37	android/app/IWallpaperManager$Stub:asInterface	(Landroid/os/IBinder;)Landroid/app/IWallpaperManager;
    //   8: astore_3
    //   9: aload_3
    //   10: aload_0
    //   11: new 39	android/os/Bundle
    //   14: dup
    //   15: invokespecial 40	android/os/Bundle:<init>	()V
    //   18: invokeinterface 46 3 0
    //   23: astore 5
    //   25: aload_3
    //   26: invokeinterface 50 1 0
    //   31: aload_2
    //   32: getfield 56	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   35: idiv
    //   36: istore 6
    //   38: aload_3
    //   39: invokeinterface 59 1 0
    //   44: aload_2
    //   45: getfield 56	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   48: idiv
    //   49: istore 7
    //   51: aload 5
    //   53: ifnull +108 -> 161
    //   56: aload 5
    //   58: invokevirtual 65	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   61: aconst_null
    //   62: aload_2
    //   63: invokestatic 71	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_3
    //   71: aload 4
    //   73: ifnonnull +17 -> 90
    //   76: ldc 8
    //   78: ldc 73
    //   80: invokestatic 79	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   83: pop
    //   84: aload_1
    //   85: aload_2
    //   86: invokestatic 84	com/oppo/launcher/LauncherUtil:getDefaultWallpaper	(Landroid/content/Context;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   89: astore_3
    //   90: aload_1
    //   91: aload_3
    //   92: iload 6
    //   94: iload 7
    //   96: invokestatic 88	com/oppo/launcher/LauncherUtil:generateBitmap	(Landroid/content/Context;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   99: astore_1
    //   100: aload 5
    //   102: invokevirtual 91	android/os/ParcelFileDescriptor:close	()V
    //   105: aload_1
    //   106: areturn
    //   107: astore_1
    //   108: ldc 8
    //   110: ldc 93
    //   112: aload_1
    //   113: invokestatic 96	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   116: pop
    //   117: aload 5
    //   119: invokevirtual 91	android/os/ParcelFileDescriptor:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aload 5
    //   127: invokevirtual 91	android/os/ParcelFileDescriptor:close	()V
    //   130: aload_1
    //   131: athrow
    //   132: astore_1
    //   133: ldc 8
    //   135: new 98	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   142: ldc 101
    //   144: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_1
    //   148: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 115	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: goto -36 -> 122
    //   161: ldc 8
    //   163: ldc 117
    //   165: invokestatic 79	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   168: pop
    //   169: aload_1
    //   170: aload_1
    //   171: aload_2
    //   172: invokestatic 84	com/oppo/launcher/LauncherUtil:getDefaultWallpaper	(Landroid/content/Context;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   175: iload 6
    //   177: iload 7
    //   179: invokestatic 88	com/oppo/launcher/LauncherUtil:generateBitmap	(Landroid/content/Context;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   182: astore_1
    //   183: aload_1
    //   184: areturn
    //   185: astore_1
    //   186: ldc 8
    //   188: new 98	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   195: ldc 119
    //   197: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 79	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   210: pop
    //   211: goto -89 -> 122
    //   214: astore_2
    //   215: aload_1
    //   216: areturn
    //   217: astore_1
    //   218: goto -96 -> 122
    //   221: astore_2
    //   222: goto -92 -> 130
    //
    // Exception table:
    //   from	to	target	type
    //   56	68	107	java/lang/OutOfMemoryError
    //   76	90	107	java/lang/OutOfMemoryError
    //   90	100	107	java/lang/OutOfMemoryError
    //   56	68	124	finally
    //   76	90	124	finally
    //   90	100	124	finally
    //   108	117	124	finally
    //   9	51	132	android/os/RemoteException
    //   100	105	132	android/os/RemoteException
    //   117	122	132	android/os/RemoteException
    //   125	130	132	android/os/RemoteException
    //   130	132	132	android/os/RemoteException
    //   161	183	132	android/os/RemoteException
    //   9	51	185	java/lang/Exception
    //   100	105	185	java/lang/Exception
    //   117	122	185	java/lang/Exception
    //   125	130	185	java/lang/Exception
    //   130	132	185	java/lang/Exception
    //   161	183	185	java/lang/Exception
    //   100	105	214	java/io/IOException
    //   117	122	217	java/io/IOException
    //   125	130	221	java/io/IOException
  }

  public void onWallpaperChanged()
  {
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.graphic.WallpaperMgrStub
 * JD-Core Version:    0.6.2
 */