package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.text.TextUtils;
import com.lazyswipe.SwipeApplication;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aqn
{
  // ERROR //
  public static alw a(ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: getstatic 16	android/provider/ContactsContract$PhoneLookup:CONTENT_FILTER_URI	Landroid/net/Uri;
    //   3: aload_1
    //   4: invokestatic 22	android/net/Uri:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   7: invokestatic 26	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   10: astore_1
    //   11: aload_0
    //   12: aload_1
    //   13: iconst_4
    //   14: anewarray 28	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc 30
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: ldc 32
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: ldc 34
    //   31: aastore
    //   32: dup
    //   33: iconst_3
    //   34: ldc 36
    //   36: aastore
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_0
    //   44: aload_0
    //   45: astore_1
    //   46: aload_0
    //   47: invokeinterface 48 1 0
    //   52: ifeq +87 -> 139
    //   55: aload_0
    //   56: astore_1
    //   57: getstatic 53	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   60: aload_0
    //   61: iconst_0
    //   62: invokeinterface 57 2 0
    //   67: invokestatic 63	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   70: astore_3
    //   71: aload_0
    //   72: astore_1
    //   73: aload_0
    //   74: iconst_2
    //   75: invokeinterface 67 2 0
    //   80: astore 4
    //   82: aload_0
    //   83: astore_1
    //   84: aload_0
    //   85: iconst_3
    //   86: invokeinterface 71 2 0
    //   91: ifeq +32 -> 123
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_0
    //   97: astore_1
    //   98: new 73	alw
    //   101: dup
    //   102: aload_3
    //   103: aload 4
    //   105: aload_2
    //   106: aconst_null
    //   107: invokespecial 77	alw:<init>	(Landroid/net/Uri;Ljava/lang/String;Landroid/net/Uri;Landroid/graphics/Bitmap;)V
    //   110: astore_2
    //   111: aload_0
    //   112: ifnull +9 -> 121
    //   115: aload_0
    //   116: invokeinterface 81 1 0
    //   121: aload_2
    //   122: areturn
    //   123: aload_0
    //   124: astore_1
    //   125: aload_0
    //   126: iconst_3
    //   127: invokeinterface 67 2 0
    //   132: invokestatic 85	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   135: astore_2
    //   136: goto -40 -> 96
    //   139: aload_0
    //   140: ifnull +9 -> 149
    //   143: aload_0
    //   144: invokeinterface 81 1 0
    //   149: aconst_null
    //   150: areturn
    //   151: astore_2
    //   152: aconst_null
    //   153: astore_0
    //   154: aload_0
    //   155: astore_1
    //   156: ldc 87
    //   158: ldc 89
    //   160: aload_2
    //   161: invokestatic 95	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   164: pop
    //   165: aload_0
    //   166: ifnull -17 -> 149
    //   169: aload_0
    //   170: invokeinterface 81 1 0
    //   175: goto -26 -> 149
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_1
    //   181: aload_1
    //   182: ifnull +9 -> 191
    //   185: aload_1
    //   186: invokeinterface 81 1 0
    //   191: aload_0
    //   192: athrow
    //   193: astore_0
    //   194: goto -13 -> 181
    //   197: astore_2
    //   198: goto -44 -> 154
    //
    // Exception table:
    //   from	to	target	type
    //   11	44	151	java/lang/Exception
    //   11	44	178	finally
    //   46	55	193	finally
    //   57	71	193	finally
    //   73	82	193	finally
    //   84	94	193	finally
    //   98	111	193	finally
    //   125	136	193	finally
    //   156	165	193	finally
    //   46	55	197	java/lang/Exception
    //   57	71	197	java/lang/Exception
    //   73	82	197	java/lang/Exception
    //   84	94	197	java/lang/Exception
    //   98	111	197	java/lang/Exception
    //   125	136	197	java/lang/Exception
  }

  public static Bitmap a(Context paramContext, alw paramalw)
  {
    paramContext = paramalw.b();
    if (atw.b(paramContext))
      return paramContext;
    return null;
  }

  public static Bitmap a(Context paramContext, alw paramalw, String paramString, Uri paramUri)
  {
    paramalw = a(paramContext, paramalw);
    if (atw.b(paramalw));
    do
    {
      return paramalw;
      if (paramUri == null)
        break;
      paramUri = c(paramContext, paramUri);
      paramalw = paramUri;
    }
    while (atw.b(paramUri));
    try
    {
      int i = paramContext.getResources().getColor(2131689547);
      int j = paramContext.getResources().getDimensionPixelSize(2131296395);
      paramContext = new aqo(paramString, i, null);
      paramContext.setBounds(0, 0, j, j);
      paramalw = Bitmap.createBitmap(paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight(), Config.ARGB_8888);
      paramContext.draw(new Canvas(paramalw));
      return paramalw;
    }
    catch (Throwable paramContext)
    {
    }
    return null;
  }

  private static Bitmap a(Context paramContext, InputStream paramInputStream)
  {
    paramInputStream = atw.a(paramContext, paramInputStream);
    paramContext = a(paramInputStream, paramContext);
    Bitmap localBitmap = a(paramContext);
    atw.a(paramContext);
    atw.a(paramInputStream);
    return localBitmap;
  }

  public static Bitmap a(Bitmap paramBitmap)
  {
    return atw.a(paramBitmap, asq.a(1.0F), 2147483647);
  }

  public static Bitmap a(Bitmap paramBitmap, Context paramContext)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = paramContext.getResources().getDimensionPixelSize(2131296395);
    int m = paramContext.getResources().getDimensionPixelSize(2131296395);
    float f1 = k / i;
    float f2 = m / j;
    paramContext = new Matrix();
    if ((i != j) && (f1 < 1.0F) && (f2 < 1.0F))
    {
      f1 = Math.max(f1, f2);
      paramContext.postScale(f1, f1);
    }
    while (true)
    {
      return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, paramContext, true);
      paramContext.postScale(f1, f2);
    }
  }

  public static Drawable a(Resources paramResources, int paramInt)
  {
    paramInt = Math.abs(paramInt);
    int i = aqo.a.length;
    return new ColorDrawable(paramResources.getColor(aqo.a[(paramInt % i)]));
  }

  // ERROR //
  public static String a(Uri paramUri, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 229	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   9: astore_3
    //   10: aload_1
    //   11: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   14: astore_1
    //   15: aload_1
    //   16: aload_0
    //   17: ldc 236
    //   19: invokestatic 26	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   22: iconst_1
    //   23: anewarray 28	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: ldc 238
    //   30: aastore
    //   31: ldc 240
    //   33: iconst_1
    //   34: anewarray 28	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc 242
    //   41: aastore
    //   42: aconst_null
    //   43: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_0
    //   47: new 244	java/util/HashSet
    //   50: dup
    //   51: invokespecial 245	java/util/HashSet:<init>	()V
    //   54: astore_1
    //   55: aload_0
    //   56: invokeinterface 248 1 0
    //   61: ifeq +69 -> 130
    //   64: aload_0
    //   65: iconst_0
    //   66: invokeinterface 67 2 0
    //   71: astore_2
    //   72: aload_1
    //   73: aload_2
    //   74: invokeinterface 254 2 0
    //   79: ifne -24 -> 55
    //   82: aload_1
    //   83: aload_2
    //   84: invokeinterface 257 2 0
    //   89: pop
    //   90: aload_3
    //   91: invokevirtual 260	java/lang/StringBuilder:length	()I
    //   94: ifeq +11 -> 105
    //   97: aload_3
    //   98: ldc_w 262
    //   101: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_3
    //   106: aload_2
    //   107: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: goto -56 -> 55
    //   114: astore_1
    //   115: aload_0
    //   116: ifnull +9 -> 125
    //   119: aload_0
    //   120: invokeinterface 81 1 0
    //   125: aload_3
    //   126: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: areturn
    //   130: aload_0
    //   131: ifnull -6 -> 125
    //   134: aload_0
    //   135: invokeinterface 81 1 0
    //   140: goto -15 -> 125
    //   143: astore_1
    //   144: aload_2
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +9 -> 156
    //   150: aload_0
    //   151: invokeinterface 81 1 0
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: goto -13 -> 146
    //   162: astore_0
    //   163: aconst_null
    //   164: astore_0
    //   165: goto -50 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   47	55	114	java/lang/Exception
    //   55	105	114	java/lang/Exception
    //   105	111	114	java/lang/Exception
    //   15	47	143	finally
    //   47	55	158	finally
    //   55	105	158	finally
    //   105	111	158	finally
    //   15	47	162	java/lang/Exception
  }

  public static String a(String paramString, Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramString = paramContext.getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[] { "data1" }, "contact_id=?", new String[] { paramString }, null);
      try
      {
        paramContext = new HashSet();
        while (paramString.moveToNext())
        {
          String str = paramString.getString(paramString.getColumnIndex("data1"));
          if (!paramContext.contains(str))
          {
            paramContext.add(str);
            if (localStringBuilder.length() != 0)
              localStringBuilder.append(",");
            localStringBuilder.append(str);
          }
        }
      }
      finally
      {
        paramContext = paramString;
        paramString = localObject;
      }
      if (paramContext != null)
        paramContext.close();
      throw paramString;
      if (paramString != null)
        paramString.close();
      return localObject.toString();
    }
    finally
    {
      while (true)
        paramContext = null;
    }
  }

  private static String a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (localStringBuilder.length() != 0)
        localStringBuilder.append(",");
      localStringBuilder.append("'").append(str).append("'");
      i += 1;
    }
    return localStringBuilder.toString();
  }

  // ERROR //
  public static String a(String[] paramArrayOfString, int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 8
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: invokestatic 290	java/lang/System:currentTimeMillis	()J
    //   11: pop2
    //   12: invokestatic 295	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   15: astore 6
    //   17: ldc_w 297
    //   20: astore_2
    //   21: iload_1
    //   22: ifle +63 -> 85
    //   25: new 229	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 299
    //   35: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_1
    //   39: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: ldc_w 304
    //   45: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_2
    //   52: new 229	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 297
    //   62: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 306
    //   68: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 308
    //   78: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_2
    //   85: new 229	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   92: aload_2
    //   93: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc_w 310
    //   99: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: invokestatic 312	aqn:a	([Ljava/lang/String;)Ljava/lang/String;
    //   106: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 314
    //   112: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore_2
    //   119: aload 6
    //   121: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   124: getstatic 317	android/provider/CallLog$Calls:CONTENT_URI	Landroid/net/Uri;
    //   127: iconst_2
    //   128: anewarray 28	java/lang/String
    //   131: dup
    //   132: iconst_0
    //   133: ldc_w 319
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: ldc_w 321
    //   142: aastore
    //   143: aload_2
    //   144: aconst_null
    //   145: ldc_w 323
    //   148: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   151: astore_2
    //   152: aload_2
    //   153: invokeinterface 248 1 0
    //   158: ifeq +395 -> 553
    //   161: aload_2
    //   162: iconst_0
    //   163: invokeinterface 67 2 0
    //   168: astore_3
    //   169: aload_2
    //   170: iconst_1
    //   171: invokeinterface 326 2 0
    //   176: istore 7
    //   178: aload_2
    //   179: invokestatic 331	arf:a	(Landroid/database/Cursor;)V
    //   182: aload_3
    //   183: astore_2
    //   184: ldc_w 333
    //   187: astore 4
    //   189: ldc_w 335
    //   192: astore_3
    //   193: iload_1
    //   194: ifle +63 -> 257
    //   197: new 229	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 299
    //   207: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: iload_1
    //   211: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: ldc_w 304
    //   217: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: astore_3
    //   224: new 229	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 335
    //   234: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc_w 306
    //   240: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_3
    //   244: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 308
    //   250: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: astore_3
    //   257: new 229	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   264: aload_3
    //   265: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 337
    //   271: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_0
    //   275: invokestatic 312	aqn:a	([Ljava/lang/String;)Ljava/lang/String;
    //   278: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 314
    //   284: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: astore_0
    //   291: aload 6
    //   293: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   296: getstatic 341	com/lazyswipe/notification/NotificationData:a	Landroid/net/Uri;
    //   299: iconst_2
    //   300: anewarray 28	java/lang/String
    //   303: dup
    //   304: iconst_0
    //   305: ldc_w 343
    //   308: aastore
    //   309: dup
    //   310: iconst_1
    //   311: ldc_w 321
    //   314: aastore
    //   315: aload_0
    //   316: aconst_null
    //   317: ldc_w 323
    //   320: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   323: astore_0
    //   324: aload_0
    //   325: invokeinterface 248 1 0
    //   330: ifeq +213 -> 543
    //   333: aload_0
    //   334: iconst_0
    //   335: invokeinterface 67 2 0
    //   340: astore_3
    //   341: aload_0
    //   342: iconst_1
    //   343: invokeinterface 326 2 0
    //   348: istore_1
    //   349: aload_0
    //   350: invokestatic 331	arf:a	(Landroid/database/Cursor;)V
    //   353: iload 7
    //   355: ifle +95 -> 450
    //   358: aload_2
    //   359: invokestatic 349	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   362: ifne +88 -> 450
    //   365: iconst_1
    //   366: istore 8
    //   368: iload_1
    //   369: ifle +87 -> 456
    //   372: aload_3
    //   373: invokestatic 349	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   376: ifne +80 -> 456
    //   379: iconst_1
    //   380: istore 9
    //   382: iload 8
    //   384: ifne +78 -> 462
    //   387: iload 9
    //   389: ifne +73 -> 462
    //   392: aconst_null
    //   393: astore_0
    //   394: aload_0
    //   395: areturn
    //   396: astore_2
    //   397: aconst_null
    //   398: astore 4
    //   400: ldc_w 333
    //   403: astore_2
    //   404: aload 4
    //   406: invokestatic 331	arf:a	(Landroid/database/Cursor;)V
    //   409: iconst_m1
    //   410: istore 7
    //   412: goto -228 -> 184
    //   415: astore_0
    //   416: aload_3
    //   417: astore_2
    //   418: aload_2
    //   419: invokestatic 331	arf:a	(Landroid/database/Cursor;)V
    //   422: aload_0
    //   423: athrow
    //   424: astore_0
    //   425: aconst_null
    //   426: astore_0
    //   427: aload 4
    //   429: astore_3
    //   430: aload_0
    //   431: invokestatic 331	arf:a	(Landroid/database/Cursor;)V
    //   434: iload 8
    //   436: istore_1
    //   437: goto -84 -> 353
    //   440: astore_0
    //   441: aload 5
    //   443: astore_2
    //   444: aload_2
    //   445: invokestatic 331	arf:a	(Landroid/database/Cursor;)V
    //   448: aload_0
    //   449: athrow
    //   450: iconst_0
    //   451: istore 8
    //   453: goto -85 -> 368
    //   456: iconst_0
    //   457: istore 9
    //   459: goto -77 -> 382
    //   462: iload 8
    //   464: ifeq +10 -> 474
    //   467: aload_2
    //   468: astore_0
    //   469: iload 9
    //   471: ifeq -77 -> 394
    //   474: iload 8
    //   476: ifne +10 -> 486
    //   479: iload 9
    //   481: ifeq +5 -> 486
    //   484: aload_3
    //   485: areturn
    //   486: aload_2
    //   487: astore_0
    //   488: iload 7
    //   490: iload_1
    //   491: if_icmpgt -97 -> 394
    //   494: aload_3
    //   495: areturn
    //   496: astore_3
    //   497: aload_0
    //   498: astore_2
    //   499: aload_3
    //   500: astore_0
    //   501: goto -57 -> 444
    //   504: astore_3
    //   505: aload 4
    //   507: astore_3
    //   508: goto -78 -> 430
    //   511: astore 4
    //   513: goto -83 -> 430
    //   516: astore_0
    //   517: goto -99 -> 418
    //   520: astore_3
    //   521: ldc_w 333
    //   524: astore_3
    //   525: aload_2
    //   526: astore 4
    //   528: aload_3
    //   529: astore_2
    //   530: goto -126 -> 404
    //   533: astore 4
    //   535: aload_2
    //   536: astore 4
    //   538: aload_3
    //   539: astore_2
    //   540: goto -136 -> 404
    //   543: ldc_w 333
    //   546: astore_3
    //   547: iload 8
    //   549: istore_1
    //   550: goto -201 -> 349
    //   553: iconst_m1
    //   554: istore 7
    //   556: ldc_w 333
    //   559: astore_3
    //   560: goto -382 -> 178
    //
    // Exception table:
    //   from	to	target	type
    //   25	85	396	java/lang/Exception
    //   85	152	396	java/lang/Exception
    //   25	85	415	finally
    //   85	152	415	finally
    //   197	257	424	java/lang/Exception
    //   257	324	424	java/lang/Exception
    //   197	257	440	finally
    //   257	324	440	finally
    //   324	341	496	finally
    //   341	349	496	finally
    //   324	341	504	java/lang/Exception
    //   341	349	511	java/lang/Exception
    //   152	169	516	finally
    //   169	178	516	finally
    //   152	169	520	java/lang/Exception
    //   169	178	533	java/lang/Exception
  }

  public static List<alw> a(int paramInt)
  {
    String str = "-" + paramInt + " days";
    return a(SwipeApplication.c(), 2147483647, str);
  }

  public static List<alw> a(Context paramContext, int paramInt, String paramString)
  {
    Object localObject1 = a(paramContext, paramString);
    paramString = b(paramContext, paramString);
    if ((((Map)localObject1).size() <= 0) && (paramString.size() <= 0))
      return Collections.EMPTY_LIST;
    paramContext = new ArrayList();
    while (true)
    {
      try
      {
        paramString = new HashMap(paramString);
        localObject1 = ((Map)localObject1).entrySet().iterator();
        Object localObject3;
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Entry)((Iterator)localObject1).next();
          localObject2 = (Integer)((Entry)localObject3).getValue();
          if (localObject2 == null)
            continue;
          localObject3 = (alw)((Entry)localObject3).getKey();
          Integer localInteger = (Integer)paramString.get(localObject3);
          if (localInteger == null)
            break label265;
          i = localInteger.intValue();
          paramString.put(localObject3, Integer.valueOf(((Integer)localObject2).intValue() + i));
          continue;
        }
        localObject1 = new LinkedList(paramString.entrySet());
        Collections.sort((List)localObject1, new Comparator()
        {
          public int a(Entry<alw, Integer> paramAnonymousEntry1, Entry<alw, Integer> paramAnonymousEntry2)
          {
            return ((Integer)paramAnonymousEntry2.getValue()).compareTo((Integer)paramAnonymousEntry1.getValue());
          }
        });
        Object localObject2 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Entry)((Iterator)localObject2).next();
          if (i < paramInt)
          {
            paramContext.add(((Entry)localObject3).getKey());
            i += 1;
            continue;
          }
        }
        paramString.clear();
        ((List)localObject1).clear();
      }
      catch (Throwable paramString)
      {
      }
      return paramContext;
      label265: int i = 0;
    }
  }

  // ERROR //
  public static Map<alw, Integer> a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_3
    //   5: new 376	java/util/HashMap
    //   8: dup
    //   9: invokespecial 441	java/util/HashMap:<init>	()V
    //   12: astore_2
    //   13: aload_1
    //   14: invokestatic 349	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +154 -> 171
    //   20: ldc_w 443
    //   23: astore_0
    //   24: aload_3
    //   25: getstatic 341	com/lazyswipe/notification/NotificationData:a	Landroid/net/Uri;
    //   28: iconst_2
    //   29: anewarray 28	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 343
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc_w 445
    //   43: aastore
    //   44: aload_0
    //   45: aconst_null
    //   46: ldc_w 447
    //   49: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_0
    //   53: aload_0
    //   54: invokeinterface 248 1 0
    //   59: ifeq +145 -> 204
    //   62: aload_0
    //   63: iconst_1
    //   64: invokeinterface 326 2 0
    //   69: istore 5
    //   71: aload_3
    //   72: aload_0
    //   73: iconst_0
    //   74: invokeinterface 67 2 0
    //   79: invokestatic 449	aqn:a	(Landroid/content/ContentResolver;Ljava/lang/String;)Lalw;
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull -31 -> 53
    //   87: aload_2
    //   88: aload_1
    //   89: invokeinterface 410 2 0
    //   94: checkcast 403	java/lang/Integer
    //   97: astore 4
    //   99: aload 4
    //   101: ifnull +100 -> 201
    //   104: aload 4
    //   106: invokevirtual 413	java/lang/Integer:intValue	()I
    //   109: iload 5
    //   111: iadd
    //   112: istore 5
    //   114: aload_2
    //   115: aload_1
    //   116: iload 5
    //   118: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: invokeinterface 421 3 0
    //   126: pop
    //   127: goto -74 -> 53
    //   130: astore_1
    //   131: ldc 87
    //   133: new 229	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 451
    //   143: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_1
    //   147: invokevirtual 454	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   150: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 459	asp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_0
    //   160: ifnull +9 -> 169
    //   163: aload_0
    //   164: invokeinterface 81 1 0
    //   169: aload_2
    //   170: areturn
    //   171: new 229	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 461
    //   181: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc_w 463
    //   191: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: astore_0
    //   198: goto -174 -> 24
    //   201: goto -87 -> 114
    //   204: aload_0
    //   205: ifnull -36 -> 169
    //   208: aload_0
    //   209: invokeinterface 81 1 0
    //   214: aload_2
    //   215: areturn
    //   216: astore_1
    //   217: aconst_null
    //   218: astore_0
    //   219: aload_0
    //   220: ifnull +9 -> 229
    //   223: aload_0
    //   224: invokeinterface 81 1 0
    //   229: aload_1
    //   230: athrow
    //   231: astore_1
    //   232: goto -13 -> 219
    //   235: astore_1
    //   236: goto -17 -> 219
    //   239: astore_1
    //   240: aconst_null
    //   241: astore_0
    //   242: goto -111 -> 131
    //
    // Exception table:
    //   from	to	target	type
    //   53	83	130	java/lang/Throwable
    //   87	99	130	java/lang/Throwable
    //   104	114	130	java/lang/Throwable
    //   114	127	130	java/lang/Throwable
    //   24	53	216	finally
    //   53	83	231	finally
    //   87	99	231	finally
    //   104	114	231	finally
    //   114	127	231	finally
    //   131	159	235	finally
    //   24	53	239	java/lang/Throwable
  }

  public static void a(alw paramalw, String paramString)
  {
    try
    {
      paramalw.g = paramString;
      paramalw.a(SwipeApplication.c(), paramalw);
      return;
    }
    catch (Exception paramalw)
    {
    }
  }

  public static byte[] a(Context paramContext, Uri paramUri)
  {
    paramContext = c(paramContext, paramUri);
    if (paramContext != null)
    {
      paramUri = atw.d(paramContext);
      atw.a(paramContext);
      return paramUri;
    }
    return null;
  }

  public static Drawable b(Context paramContext, alw paramalw)
  {
    Bitmap localBitmap = a(paramContext, paramalw);
    if (localBitmap != null)
      return new BitmapDrawable(paramContext.getResources(), localBitmap);
    return c(paramContext, paramalw.d);
  }

  public static Drawable b(Context paramContext, Uri paramUri)
  {
    paramContext = c(paramContext, paramUri);
    if (paramContext != null)
      return new BitmapDrawable(paramContext);
    return null;
  }

  // ERROR //
  public static String b(Uri paramUri, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 229	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   9: astore_3
    //   10: aload_1
    //   11: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   14: astore_1
    //   15: aload_1
    //   16: aload_0
    //   17: ldc 236
    //   19: invokestatic 26	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   22: iconst_1
    //   23: anewarray 28	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: ldc 238
    //   30: aastore
    //   31: ldc 240
    //   33: iconst_1
    //   34: anewarray 28	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc_w 492
    //   42: aastore
    //   43: aconst_null
    //   44: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_0
    //   48: new 244	java/util/HashSet
    //   51: dup
    //   52: invokespecial 245	java/util/HashSet:<init>	()V
    //   55: astore_1
    //   56: aload_0
    //   57: invokeinterface 248 1 0
    //   62: ifeq +69 -> 131
    //   65: aload_0
    //   66: iconst_0
    //   67: invokeinterface 67 2 0
    //   72: astore_2
    //   73: aload_1
    //   74: aload_2
    //   75: invokeinterface 254 2 0
    //   80: ifne -24 -> 56
    //   83: aload_1
    //   84: aload_2
    //   85: invokeinterface 257 2 0
    //   90: pop
    //   91: aload_3
    //   92: invokevirtual 260	java/lang/StringBuilder:length	()I
    //   95: ifeq +11 -> 106
    //   98: aload_3
    //   99: ldc_w 262
    //   102: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_3
    //   107: aload_2
    //   108: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: goto -56 -> 56
    //   115: astore_1
    //   116: aload_0
    //   117: ifnull +9 -> 126
    //   120: aload_0
    //   121: invokeinterface 81 1 0
    //   126: aload_3
    //   127: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: areturn
    //   131: aload_0
    //   132: ifnull -6 -> 126
    //   135: aload_0
    //   136: invokeinterface 81 1 0
    //   141: goto -15 -> 126
    //   144: astore_1
    //   145: aload_2
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +9 -> 157
    //   151: aload_0
    //   152: invokeinterface 81 1 0
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: goto -13 -> 147
    //   163: astore_0
    //   164: aconst_null
    //   165: astore_0
    //   166: goto -50 -> 116
    //
    // Exception table:
    //   from	to	target	type
    //   48	56	115	java/lang/Exception
    //   56	106	115	java/lang/Exception
    //   106	112	115	java/lang/Exception
    //   15	48	144	finally
    //   48	56	159	finally
    //   56	106	159	finally
    //   106	112	159	finally
    //   15	48	163	java/lang/Exception
  }

  // ERROR //
  public static String b(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_1
    //   6: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   9: astore 5
    //   11: new 229	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   18: astore 6
    //   20: aload 5
    //   22: getstatic 53	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   25: iconst_1
    //   26: anewarray 28	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc_w 494
    //   34: aastore
    //   35: ldc_w 496
    //   38: iconst_1
    //   39: anewarray 28	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: aastore
    //   46: aconst_null
    //   47: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore_3
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: invokeinterface 248 1 0
    //   59: ifeq +170 -> 229
    //   62: aload_3
    //   63: aload_3
    //   64: ldc_w 494
    //   67: invokeinterface 280 2 0
    //   72: invokeinterface 67 2 0
    //   77: invokestatic 499	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   80: ifle +142 -> 222
    //   83: aload 5
    //   85: getstatic 502	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   88: iconst_1
    //   89: anewarray 28	java/lang/String
    //   92: dup
    //   93: iconst_0
    //   94: ldc 238
    //   96: aastore
    //   97: ldc_w 504
    //   100: iconst_1
    //   101: anewarray 28	java/lang/String
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: aastore
    //   108: aconst_null
    //   109: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   112: astore_2
    //   113: aload_2
    //   114: astore_1
    //   115: new 244	java/util/HashSet
    //   118: dup
    //   119: invokespecial 245	java/util/HashSet:<init>	()V
    //   122: astore 4
    //   124: aload_1
    //   125: astore_2
    //   126: aload_1
    //   127: invokeinterface 248 1 0
    //   132: ifeq +92 -> 224
    //   135: aload_1
    //   136: aload_1
    //   137: ldc 238
    //   139: invokeinterface 280 2 0
    //   144: invokeinterface 67 2 0
    //   149: astore_2
    //   150: aload 4
    //   152: aload_2
    //   153: invokeinterface 254 2 0
    //   158: ifne -34 -> 124
    //   161: aload 4
    //   163: aload_2
    //   164: invokeinterface 257 2 0
    //   169: pop
    //   170: aload 6
    //   172: invokevirtual 260	java/lang/StringBuilder:length	()I
    //   175: ifeq +12 -> 187
    //   178: aload 6
    //   180: ldc_w 262
    //   183: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 6
    //   189: aload_2
    //   190: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: goto -70 -> 124
    //   197: astore_0
    //   198: aload_3
    //   199: astore_2
    //   200: aload_1
    //   201: ifnull +9 -> 210
    //   204: aload_1
    //   205: invokeinterface 81 1 0
    //   210: aload_2
    //   211: ifnull +9 -> 220
    //   214: aload_2
    //   215: invokeinterface 81 1 0
    //   220: aload_0
    //   221: athrow
    //   222: aload_1
    //   223: astore_2
    //   224: aload_2
    //   225: astore_1
    //   226: goto -173 -> 53
    //   229: aload_1
    //   230: ifnull +9 -> 239
    //   233: aload_1
    //   234: invokeinterface 81 1 0
    //   239: aload_3
    //   240: ifnull +9 -> 249
    //   243: aload_3
    //   244: invokeinterface 81 1 0
    //   249: aload 6
    //   251: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: areturn
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_2
    //   258: aload 4
    //   260: astore_1
    //   261: goto -61 -> 200
    //   264: astore_0
    //   265: aload_3
    //   266: astore_2
    //   267: goto -67 -> 200
    //
    // Exception table:
    //   from	to	target	type
    //   115	124	197	finally
    //   126	187	197	finally
    //   187	194	197	finally
    //   20	51	255	finally
    //   53	113	264	finally
  }

  // ERROR //
  public static Map<alw, Integer> b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 376	java/util/HashMap
    //   3: dup
    //   4: invokespecial 441	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: astore 4
    //   14: ldc_w 297
    //   17: astore_0
    //   18: aload_1
    //   19: invokestatic 349	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +36 -> 58
    //   25: new 229	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 297
    //   35: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 306
    //   41: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 308
    //   51: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_0
    //   58: aload 4
    //   60: getstatic 317	android/provider/CallLog$Calls:CONTENT_URI	Landroid/net/Uri;
    //   63: iconst_1
    //   64: anewarray 28	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: ldc_w 319
    //   72: aastore
    //   73: aload_0
    //   74: aconst_null
    //   75: ldc_w 319
    //   78: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore_0
    //   82: iconst_0
    //   83: istore 6
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_0
    //   88: invokeinterface 248 1 0
    //   93: ifeq +81 -> 174
    //   96: aload_0
    //   97: iconst_0
    //   98: invokeinterface 67 2 0
    //   103: astore_2
    //   104: aload_2
    //   105: aload_1
    //   106: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   109: ifne +203 -> 312
    //   112: aload_1
    //   113: ifnull +202 -> 315
    //   116: aload 4
    //   118: aload_1
    //   119: invokestatic 449	aqn:a	(Landroid/content/ContentResolver;Ljava/lang/String;)Lalw;
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +191 -> 315
    //   127: aload_3
    //   128: aload_1
    //   129: invokeinterface 410 2 0
    //   134: checkcast 403	java/lang/Integer
    //   137: astore 5
    //   139: iload 6
    //   141: istore 7
    //   143: aload 5
    //   145: ifnull +13 -> 158
    //   148: iload 6
    //   150: aload 5
    //   152: invokevirtual 413	java/lang/Integer:intValue	()I
    //   155: iadd
    //   156: istore 7
    //   158: aload_3
    //   159: aload_1
    //   160: iload 7
    //   162: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: invokeinterface 421 3 0
    //   170: pop
    //   171: goto +144 -> 315
    //   174: aload_1
    //   175: ifnull +55 -> 230
    //   178: aload 4
    //   180: aload_1
    //   181: invokestatic 449	aqn:a	(Landroid/content/ContentResolver;Ljava/lang/String;)Lalw;
    //   184: astore_1
    //   185: aload_1
    //   186: ifnull +44 -> 230
    //   189: aload_3
    //   190: aload_1
    //   191: invokeinterface 410 2 0
    //   196: checkcast 403	java/lang/Integer
    //   199: astore_2
    //   200: iload 6
    //   202: istore 7
    //   204: aload_2
    //   205: ifnull +12 -> 217
    //   208: iload 6
    //   210: aload_2
    //   211: invokevirtual 413	java/lang/Integer:intValue	()I
    //   214: iadd
    //   215: istore 7
    //   217: aload_3
    //   218: aload_1
    //   219: iload 7
    //   221: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   224: invokeinterface 421 3 0
    //   229: pop
    //   230: aload_0
    //   231: ifnull +9 -> 240
    //   234: aload_0
    //   235: invokeinterface 81 1 0
    //   240: aload_3
    //   241: areturn
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_0
    //   245: ldc 87
    //   247: new 229	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 509
    //   257: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 454	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   264: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 459	asp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload_0
    //   274: ifnull -34 -> 240
    //   277: aload_0
    //   278: invokeinterface 81 1 0
    //   283: aload_3
    //   284: areturn
    //   285: astore_1
    //   286: aconst_null
    //   287: astore_0
    //   288: aload_0
    //   289: ifnull +9 -> 298
    //   292: aload_0
    //   293: invokeinterface 81 1 0
    //   298: aload_1
    //   299: athrow
    //   300: astore_1
    //   301: goto -13 -> 288
    //   304: astore_1
    //   305: goto -17 -> 288
    //   308: astore_1
    //   309: goto -64 -> 245
    //   312: goto +8 -> 320
    //   315: iconst_0
    //   316: istore 6
    //   318: aload_2
    //   319: astore_1
    //   320: iload 6
    //   322: iconst_1
    //   323: iadd
    //   324: istore 6
    //   326: goto -239 -> 87
    //
    // Exception table:
    //   from	to	target	type
    //   58	82	242	java/lang/Throwable
    //   58	82	285	finally
    //   87	112	300	finally
    //   116	123	300	finally
    //   127	139	300	finally
    //   148	158	300	finally
    //   158	171	300	finally
    //   178	185	300	finally
    //   189	200	300	finally
    //   208	217	300	finally
    //   217	230	300	finally
    //   245	273	304	finally
    //   87	112	308	java/lang/Throwable
    //   116	123	308	java/lang/Throwable
    //   127	139	308	java/lang/Throwable
    //   148	158	308	java/lang/Throwable
    //   158	171	308	java/lang/Throwable
    //   178	185	308	java/lang/Throwable
    //   189	200	308	java/lang/Throwable
    //   208	217	308	java/lang/Throwable
    //   217	230	308	java/lang/Throwable
  }

  // ERROR //
  public static Bitmap c(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: invokestatic 513	android/provider/ContactsContract$Contacts:openContactPhotoInputStream	(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/io/InputStream;
    //   8: astore_3
    //   9: aload_3
    //   10: astore_2
    //   11: aload_0
    //   12: aload_3
    //   13: invokestatic 514	aqn:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   16: astore_0
    //   17: aload_3
    //   18: invokestatic 517	arf:a	(Ljava/io/Closeable;)V
    //   21: aload_0
    //   22: areturn
    //   23: astore_0
    //   24: aconst_null
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: ldc 87
    //   30: new 229	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 519
    //   40: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: aload_0
    //   51: invokestatic 95	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   54: pop
    //   55: aload_3
    //   56: invokestatic 517	arf:a	(Ljava/io/Closeable;)V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_2
    //   65: invokestatic 517	arf:a	(Ljava/io/Closeable;)V
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: goto -7 -> 64
    //   74: astore_0
    //   75: goto -49 -> 26
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	23	java/lang/Throwable
    //   0	9	61	finally
    //   11	17	70	finally
    //   28	55	70	finally
    //   11	17	74	java/lang/Throwable
  }

  public static Drawable c(Context paramContext, String paramString)
  {
    int i = paramContext.getResources().getColor(2131689547);
    try
    {
      if (TextUtils.isEmpty(paramString))
        return a(paramContext.getResources(), (int)System.currentTimeMillis());
      paramString = new aqo(paramString, i, null);
      return paramString;
    }
    catch (Throwable paramString)
    {
    }
    return a(paramContext.getResources(), (int)System.currentTimeMillis());
  }

  // ERROR //
  public static android.util.Pair<String, String> c(Uri paramUri, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_1
    //   7: aload_1
    //   8: aload_0
    //   9: ldc 236
    //   11: invokestatic 26	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   14: iconst_2
    //   15: anewarray 28	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 527
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: ldc 238
    //   28: aastore
    //   29: ldc 240
    //   31: iconst_1
    //   32: anewarray 28	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc_w 529
    //   40: aastore
    //   41: aconst_null
    //   42: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_0
    //   46: aload_0
    //   47: invokeinterface 248 1 0
    //   52: ifeq +37 -> 89
    //   55: new 531	android/util/Pair
    //   58: dup
    //   59: aload_0
    //   60: iconst_0
    //   61: invokeinterface 67 2 0
    //   66: aload_0
    //   67: iconst_1
    //   68: invokeinterface 67 2 0
    //   73: invokespecial 534	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   76: astore_1
    //   77: aload_0
    //   78: ifnull +9 -> 87
    //   81: aload_0
    //   82: invokeinterface 81 1 0
    //   87: aload_1
    //   88: areturn
    //   89: aload_0
    //   90: ifnull +9 -> 99
    //   93: aload_0
    //   94: invokeinterface 81 1 0
    //   99: new 531	android/util/Pair
    //   102: dup
    //   103: ldc_w 333
    //   106: ldc_w 333
    //   109: invokespecial 534	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   112: areturn
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull -18 -> 99
    //   120: aload_0
    //   121: invokeinterface 81 1 0
    //   126: goto -27 -> 99
    //   129: astore_0
    //   130: aload_2
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +9 -> 142
    //   136: aload_1
    //   137: invokeinterface 81 1 0
    //   142: aload_0
    //   143: athrow
    //   144: astore_2
    //   145: aload_0
    //   146: astore_1
    //   147: aload_2
    //   148: astore_0
    //   149: goto -17 -> 132
    //   152: astore_1
    //   153: goto -37 -> 116
    //
    // Exception table:
    //   from	to	target	type
    //   7	46	113	java/lang/Exception
    //   7	46	129	finally
    //   46	77	144	finally
    //   46	77	152	java/lang/Exception
  }

  // ERROR //
  public static Bitmap d(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: invokevirtual 539	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   8: astore_3
    //   9: aload_3
    //   10: astore_2
    //   11: aload_0
    //   12: aload_3
    //   13: invokestatic 514	aqn:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   16: astore_0
    //   17: aload_3
    //   18: invokestatic 517	arf:a	(Ljava/io/Closeable;)V
    //   21: aload_0
    //   22: areturn
    //   23: astore_0
    //   24: aconst_null
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: ldc 87
    //   30: new 229	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 541
    //   40: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: aload_0
    //   51: invokestatic 95	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   54: pop
    //   55: aload_3
    //   56: invokestatic 517	arf:a	(Ljava/io/Closeable;)V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_2
    //   65: invokestatic 517	arf:a	(Ljava/io/Closeable;)V
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: goto -7 -> 64
    //   74: astore_0
    //   75: goto -49 -> 26
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	23	java/lang/Throwable
    //   0	9	61	finally
    //   11	17	70	finally
    //   28	55	70	finally
    //   11	17	74	java/lang/Throwable
  }

  // ERROR //
  public static String d(Uri paramUri, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_1
    //   7: aload_1
    //   8: aload_0
    //   9: ldc 236
    //   11: invokestatic 26	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   14: iconst_1
    //   15: anewarray 28	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 527
    //   23: aastore
    //   24: ldc 240
    //   26: iconst_1
    //   27: anewarray 28	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc_w 543
    //   35: aastore
    //   36: aconst_null
    //   37: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_0
    //   41: aload_0
    //   42: invokeinterface 248 1 0
    //   47: ifeq +23 -> 70
    //   50: aload_0
    //   51: iconst_0
    //   52: invokeinterface 67 2 0
    //   57: astore_1
    //   58: aload_0
    //   59: ifnull +9 -> 68
    //   62: aload_0
    //   63: invokeinterface 81 1 0
    //   68: aload_1
    //   69: areturn
    //   70: aload_0
    //   71: ifnull +9 -> 80
    //   74: aload_0
    //   75: invokeinterface 81 1 0
    //   80: ldc_w 333
    //   83: areturn
    //   84: astore_0
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: ifnull -8 -> 80
    //   91: aload_0
    //   92: invokeinterface 81 1 0
    //   97: goto -17 -> 80
    //   100: astore_0
    //   101: aload_2
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +9 -> 113
    //   107: aload_1
    //   108: invokeinterface 81 1 0
    //   113: aload_0
    //   114: athrow
    //   115: astore_2
    //   116: aload_0
    //   117: astore_1
    //   118: aload_2
    //   119: astore_0
    //   120: goto -17 -> 103
    //   123: astore_1
    //   124: goto -37 -> 87
    //
    // Exception table:
    //   from	to	target	type
    //   7	41	84	java/lang/Exception
    //   7	41	100	finally
    //   41	58	115	finally
    //   41	58	123	java/lang/Exception
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqn
 * JD-Core Version:    0.6.2
 */