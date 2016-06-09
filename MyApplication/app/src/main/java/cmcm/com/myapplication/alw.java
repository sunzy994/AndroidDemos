package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.lazyswipe.SwipeApplication;
import java.util.HashMap;
import java.util.List;

public class alw
{
  public static final alw a = new alw(Uri.parse("INVALID_CONTACT_URI"));
  public static List<alw> j;
  private static final String k = "Swipe." + alw.class.getSimpleName();
  private static final String[] l = { "uri", "name", "thumb", "_id", "_order", "image", "prefer_number", "shortcut" };
  public long b;
  public Uri c;
  public String d;
  public Uri e;
  public int f;
  public String g;
  public String h;
  public final HashMap<String, alv> i = new HashMap(0);
  private Bitmap m;

  public alw(Cursor paramCursor)
  {
    if (paramCursor.isNull(0))
    {
      localObject1 = null;
      this.c = ((Uri)localObject1);
      this.d = paramCursor.getString(1);
      localObject1 = paramCursor.getString(2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
        break label144;
    }
    label144: for (Object localObject1 = localObject2; ; localObject1 = Uri.parse((String)localObject1))
    {
      this.e = ((Uri)localObject1);
      this.m = atw.a(paramCursor.getBlob(5));
      this.b = paramCursor.getInt(3);
      this.f = paramCursor.getInt(4);
      this.g = paramCursor.getString(6);
      this.h = paramCursor.getString(7);
      return;
      localObject1 = Uri.parse(paramCursor.getString(0));
      break;
    }
  }

  public alw(Uri paramUri)
  {
    this.c = paramUri;
    this.d = null;
    this.e = null;
  }

  public alw(Uri paramUri1, String paramString, Uri paramUri2, Bitmap paramBitmap)
  {
    this.c = paramUri1;
    this.d = paramString;
    this.e = paramUri2;
    this.m = paramBitmap;
  }

  public static List<alw> a(Context paramContext)
  {
    try
    {
      paramContext = a(paramContext, false);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
    }
    throw paramContext;
  }

  public static List<alw> a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if ((j == null) || (paramBoolean))
        c(paramContext);
      paramContext = j;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  public static void a(alw paramalw)
  {
    try
    {
      if (j != null)
      {
        j.remove(paramalw);
        arj.a(new Runnable() {
          public void run() {
            alw.a(alw.this);
          }
        });
      }
      return;
    }
    finally
    {
      paramalw = finally;
    }
    throw paramalw;
  }

  public static int b(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext != null)
    {
      int n = paramContext.size();
      if (n > 0)
        return ((alw)paramContext.get(n - 1)).f + 1;
    }
    return 0;
  }

  private static void b(String[] paramArrayOfString)
  {
    ContentResolver localContentResolver = SwipeApplication.c().getContentResolver();
    try
    {
      localContentResolver.delete(xc.a, "_id=?", paramArrayOfString);
      localContentResolver.delete(xd.a, "contact_id=?", paramArrayOfString);
      localContentResolver.delete(xe.a, "contact_id=?", paramArrayOfString);
      ContentValues localContentValues = new ContentValues(1);
      localContentValues.put("contact_id", Integer.valueOf(0));
      if (localContentResolver.update(xj.a, localContentValues, "package_name=? AND contact_id=?", new String[] { "0", paramArrayOfString[0] }) <= 0)
        localContentResolver.notifyChange(xj.a, null);
      return;
    }
    catch (Throwable paramArrayOfString)
    {
    }
  }

  // ERROR //
  private static void c(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic 151	alw:j	Ljava/util/List;
    //   5: ifnull +224 -> 229
    //   8: getstatic 151	alw:j	Ljava/util/List;
    //   11: invokeinterface 252 1 0
    //   16: aload_0
    //   17: invokevirtual 255	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore_2
    //   21: aload_2
    //   22: getstatic 202	xc:a	Landroid/net/Uri;
    //   25: getstatic 87	alw:l	[Ljava/lang/String;
    //   28: aconst_null
    //   29: aconst_null
    //   30: ldc 79
    //   32: invokevirtual 259	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore_0
    //   36: aload_0
    //   37: invokeinterface 263 1 0
    //   42: ifeq +202 -> 244
    //   45: getstatic 151	alw:j	Ljava/util/List;
    //   48: new 2	alw
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 265	alw:<init>	(Landroid/database/Cursor;)V
    //   56: invokeinterface 268 2 0
    //   61: pop
    //   62: goto -26 -> 36
    //   65: astore_3
    //   66: aload_0
    //   67: invokestatic 272	arf:a	(Landroid/database/Cursor;)V
    //   70: getstatic 151	alw:j	Ljava/util/List;
    //   73: invokeinterface 276 1 0
    //   78: astore_3
    //   79: aload_3
    //   80: invokeinterface 281 1 0
    //   85: ifeq +189 -> 274
    //   88: aload_3
    //   89: invokeinterface 285 1 0
    //   94: checkcast 2	alw
    //   97: astore 4
    //   99: getstatic 213	xd:a	Landroid/net/Uri;
    //   102: astore_0
    //   103: aload 4
    //   105: getfield 136	alw:b	J
    //   108: lstore 5
    //   110: aload_2
    //   111: aload_0
    //   112: iconst_5
    //   113: anewarray 69	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: ldc_w 287
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: ldc_w 289
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: ldc_w 291
    //   133: aastore
    //   134: dup
    //   135: iconst_3
    //   136: ldc_w 293
    //   139: aastore
    //   140: dup
    //   141: iconst_4
    //   142: ldc_w 295
    //   145: aastore
    //   146: ldc_w 297
    //   149: iconst_1
    //   150: anewarray 69	java/lang/String
    //   153: dup
    //   154: iconst_0
    //   155: lload 5
    //   157: invokestatic 166	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   160: aastore
    //   161: ldc_w 287
    //   164: invokevirtual 259	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   167: astore_0
    //   168: aload_0
    //   169: invokeinterface 263 1 0
    //   174: ifeq +86 -> 260
    //   177: aload 4
    //   179: aload_0
    //   180: iconst_0
    //   181: invokeinterface 109 2 0
    //   186: aload_0
    //   187: iconst_1
    //   188: invokeinterface 109 2 0
    //   193: aload_0
    //   194: iconst_2
    //   195: invokeinterface 109 2 0
    //   200: aload_0
    //   201: iconst_3
    //   202: invokeinterface 109 2 0
    //   207: aload_0
    //   208: iconst_4
    //   209: invokeinterface 109 2 0
    //   214: invokevirtual 300	alw:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   217: goto -49 -> 168
    //   220: astore 4
    //   222: aload_0
    //   223: invokestatic 272	arf:a	(Landroid/database/Cursor;)V
    //   226: goto -147 -> 79
    //   229: new 302	java/util/ArrayList
    //   232: dup
    //   233: bipush 13
    //   235: invokespecial 303	java/util/ArrayList:<init>	(I)V
    //   238: putstatic 151	alw:j	Ljava/util/List;
    //   241: goto -225 -> 16
    //   244: aload_0
    //   245: invokestatic 272	arf:a	(Landroid/database/Cursor;)V
    //   248: goto -178 -> 70
    //   251: astore_1
    //   252: aconst_null
    //   253: astore_0
    //   254: aload_0
    //   255: invokestatic 272	arf:a	(Landroid/database/Cursor;)V
    //   258: aload_1
    //   259: athrow
    //   260: aload_0
    //   261: invokestatic 272	arf:a	(Landroid/database/Cursor;)V
    //   264: goto -185 -> 79
    //   267: astore_0
    //   268: aload_1
    //   269: invokestatic 272	arf:a	(Landroid/database/Cursor;)V
    //   272: aload_0
    //   273: athrow
    //   274: return
    //   275: astore_2
    //   276: aload_0
    //   277: astore_1
    //   278: aload_2
    //   279: astore_0
    //   280: goto -12 -> 268
    //   283: astore_0
    //   284: aconst_null
    //   285: astore_0
    //   286: goto -64 -> 222
    //   289: astore_1
    //   290: goto -36 -> 254
    //   293: astore_0
    //   294: aconst_null
    //   295: astore_0
    //   296: goto -230 -> 66
    //
    // Exception table:
    //   from	to	target	type
    //   36	62	65	java/lang/Exception
    //   168	217	220	java/lang/Throwable
    //   21	36	251	finally
    //   99	168	267	finally
    //   168	217	275	finally
    //   99	168	283	java/lang/Throwable
    //   36	62	289	finally
    //   21	36	293	java/lang/Exception
  }

  // ERROR //
  public void a(ContentResolver paramContentResolver)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 220	android/content/ContentValues
    //   5: dup
    //   6: invokespecial 305	android/content/ContentValues:<init>	()V
    //   9: astore 4
    //   11: aload_2
    //   12: astore_3
    //   13: getstatic 310	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   16: astore 5
    //   18: aload_2
    //   19: astore_3
    //   20: aload_0
    //   21: getfield 105	alw:c	Landroid/net/Uri;
    //   24: invokevirtual 313	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   27: astore 6
    //   29: aload_2
    //   30: astore_3
    //   31: aload_1
    //   32: aload 5
    //   34: iconst_2
    //   35: anewarray 69	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: ldc 77
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: ldc_w 315
    //   48: aastore
    //   49: ldc 204
    //   51: iconst_1
    //   52: anewarray 69	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: aload 6
    //   59: aastore
    //   60: aconst_null
    //   61: invokevirtual 259	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_2
    //   65: aload_2
    //   66: astore_3
    //   67: aload_2
    //   68: invokeinterface 318 1 0
    //   73: ifne +32 -> 105
    //   76: aload_2
    //   77: astore_3
    //   78: aload_0
    //   79: ldc_w 320
    //   82: invokevirtual 323	alw:a	(Ljava/lang/String;)V
    //   85: aload_2
    //   86: astore_3
    //   87: aload_0
    //   88: ldc_w 325
    //   91: invokevirtual 323	alw:a	(Ljava/lang/String;)V
    //   94: aload_2
    //   95: ifnull +9 -> 104
    //   98: aload_2
    //   99: invokeinterface 328 1 0
    //   104: return
    //   105: aload_2
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 136	alw:b	J
    //   111: invokestatic 166	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   114: astore 5
    //   116: aload_2
    //   117: astore_3
    //   118: aload_2
    //   119: invokeinterface 263 1 0
    //   124: ifeq +88 -> 212
    //   127: aload_2
    //   128: astore_3
    //   129: aload_2
    //   130: iconst_1
    //   131: invokeinterface 109 2 0
    //   136: astore 6
    //   138: aload_2
    //   139: astore_3
    //   140: aload 6
    //   142: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne -29 -> 116
    //   148: aload_2
    //   149: astore_3
    //   150: aload_0
    //   151: aload 6
    //   153: putfield 111	alw:d	Ljava/lang/String;
    //   156: aload_2
    //   157: astore_3
    //   158: aload 4
    //   160: invokevirtual 329	android/content/ContentValues:clear	()V
    //   163: aload_2
    //   164: astore_3
    //   165: aload 4
    //   167: ldc 73
    //   169: aload 6
    //   171: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_2
    //   175: astore_3
    //   176: aload_1
    //   177: getstatic 202	xc:a	Landroid/net/Uri;
    //   180: aload 4
    //   182: ldc 204
    //   184: iconst_1
    //   185: anewarray 69	java/lang/String
    //   188: dup
    //   189: iconst_0
    //   190: aload 5
    //   192: aastore
    //   193: invokevirtual 243	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   196: pop
    //   197: goto -81 -> 116
    //   200: astore_1
    //   201: aload_2
    //   202: ifnull -98 -> 104
    //   205: aload_2
    //   206: invokeinterface 328 1 0
    //   211: return
    //   212: aload_2
    //   213: astore_3
    //   214: aload 4
    //   216: invokevirtual 329	android/content/ContentValues:clear	()V
    //   219: aload_2
    //   220: astore_3
    //   221: aload 4
    //   223: ldc 223
    //   225: aload_0
    //   226: getfield 136	alw:b	J
    //   229: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   232: invokevirtual 340	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   235: aload_2
    //   236: astore_3
    //   237: aload 4
    //   239: ldc_w 287
    //   242: ldc_w 325
    //   245: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload_2
    //   249: astore_3
    //   250: aload_0
    //   251: getfield 105	alw:c	Landroid/net/Uri;
    //   254: invokestatic 194	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   257: invokestatic 345	aqn:c	(Landroid/net/Uri;Landroid/content/Context;)Landroid/util/Pair;
    //   260: astore 6
    //   262: aload_2
    //   263: astore_3
    //   264: aload 4
    //   266: ldc_w 289
    //   269: aload 6
    //   271: getfield 351	android/util/Pair:second	Ljava/lang/Object;
    //   274: checkcast 69	java/lang/String
    //   277: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_2
    //   281: astore_3
    //   282: aload 4
    //   284: ldc_w 291
    //   287: aload 6
    //   289: getfield 354	android/util/Pair:first	Ljava/lang/Object;
    //   292: checkcast 69	java/lang/String
    //   295: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_2
    //   299: astore_3
    //   300: aload_1
    //   301: getstatic 213	xd:a	Landroid/net/Uri;
    //   304: aload 4
    //   306: ldc_w 356
    //   309: iconst_2
    //   310: anewarray 69	java/lang/String
    //   313: dup
    //   314: iconst_0
    //   315: aload 5
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: ldc_w 325
    //   323: aastore
    //   324: invokevirtual 243	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   327: ifne +750 -> 1077
    //   330: aload_2
    //   331: astore_3
    //   332: aload_1
    //   333: getstatic 213	xd:a	Landroid/net/Uri;
    //   336: aload 4
    //   338: invokevirtual 360	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   341: pop
    //   342: aload_2
    //   343: astore_3
    //   344: aload_0
    //   345: ldc_w 325
    //   348: aload 6
    //   350: getfield 351	android/util/Pair:second	Ljava/lang/Object;
    //   353: checkcast 69	java/lang/String
    //   356: aload 6
    //   358: getfield 354	android/util/Pair:first	Ljava/lang/Object;
    //   361: checkcast 69	java/lang/String
    //   364: aconst_null
    //   365: aconst_null
    //   366: invokevirtual 300	alw:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload_2
    //   370: astore_3
    //   371: aload 4
    //   373: invokevirtual 329	android/content/ContentValues:clear	()V
    //   376: aload_2
    //   377: astore_3
    //   378: aload 4
    //   380: ldc 223
    //   382: aload_0
    //   383: getfield 136	alw:b	J
    //   386: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   389: invokevirtual 340	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   392: aload_2
    //   393: astore_3
    //   394: aload 4
    //   396: ldc_w 287
    //   399: ldc_w 362
    //   402: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: aload_2
    //   406: astore_3
    //   407: aload_0
    //   408: getfield 105	alw:c	Landroid/net/Uri;
    //   411: invokestatic 194	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   414: invokestatic 365	aqn:b	(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;
    //   417: astore 6
    //   419: aload_2
    //   420: astore_3
    //   421: aload 4
    //   423: ldc_w 289
    //   426: aload 6
    //   428: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_2
    //   432: astore_3
    //   433: aload_1
    //   434: getstatic 213	xd:a	Landroid/net/Uri;
    //   437: aload 4
    //   439: ldc_w 356
    //   442: iconst_2
    //   443: anewarray 69	java/lang/String
    //   446: dup
    //   447: iconst_0
    //   448: aload 5
    //   450: aastore
    //   451: dup
    //   452: iconst_1
    //   453: ldc_w 362
    //   456: aastore
    //   457: invokevirtual 243	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   460: ifne +660 -> 1120
    //   463: aload_2
    //   464: astore_3
    //   465: aload_1
    //   466: getstatic 213	xd:a	Landroid/net/Uri;
    //   469: aload 4
    //   471: invokevirtual 360	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   474: pop
    //   475: aload_2
    //   476: astore_3
    //   477: aload_0
    //   478: ldc_w 362
    //   481: aload 6
    //   483: aconst_null
    //   484: aconst_null
    //   485: aconst_null
    //   486: invokevirtual 300	alw:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload_2
    //   490: astore_3
    //   491: aload 4
    //   493: invokevirtual 329	android/content/ContentValues:clear	()V
    //   496: aload_2
    //   497: astore_3
    //   498: aload 4
    //   500: ldc 223
    //   502: aload_0
    //   503: getfield 136	alw:b	J
    //   506: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: invokevirtual 340	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   512: aload_2
    //   513: astore_3
    //   514: aload 4
    //   516: ldc_w 287
    //   519: ldc_w 320
    //   522: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload_2
    //   526: astore_3
    //   527: aload_0
    //   528: getfield 105	alw:c	Landroid/net/Uri;
    //   531: invokestatic 194	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   534: invokestatic 367	aqn:d	(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;
    //   537: astore 6
    //   539: aload_2
    //   540: astore_3
    //   541: aload 4
    //   543: ldc_w 289
    //   546: aload 6
    //   548: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload_2
    //   552: astore_3
    //   553: aload_1
    //   554: getstatic 213	xd:a	Landroid/net/Uri;
    //   557: aload 4
    //   559: ldc_w 356
    //   562: iconst_2
    //   563: anewarray 69	java/lang/String
    //   566: dup
    //   567: iconst_0
    //   568: aload 5
    //   570: aastore
    //   571: dup
    //   572: iconst_1
    //   573: ldc_w 320
    //   576: aastore
    //   577: invokevirtual 243	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   580: ifne +557 -> 1137
    //   583: aload_2
    //   584: astore_3
    //   585: aload_1
    //   586: getstatic 213	xd:a	Landroid/net/Uri;
    //   589: aload 4
    //   591: invokevirtual 360	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   594: pop
    //   595: aload_2
    //   596: astore_3
    //   597: aload_0
    //   598: ldc_w 320
    //   601: aload 6
    //   603: aconst_null
    //   604: aconst_null
    //   605: aconst_null
    //   606: invokevirtual 300	alw:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   609: aload_2
    //   610: astore_3
    //   611: aload 4
    //   613: invokevirtual 329	android/content/ContentValues:clear	()V
    //   616: aload_2
    //   617: astore_3
    //   618: aload 4
    //   620: ldc 223
    //   622: aload_0
    //   623: getfield 136	alw:b	J
    //   626: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   629: invokevirtual 340	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   632: aload_2
    //   633: astore_3
    //   634: aload 4
    //   636: ldc_w 287
    //   639: ldc_w 369
    //   642: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   645: aload_2
    //   646: astore_3
    //   647: aload_0
    //   648: getfield 105	alw:c	Landroid/net/Uri;
    //   651: invokestatic 194	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   654: invokestatic 371	aqn:a	(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;
    //   657: astore 6
    //   659: aload_2
    //   660: astore_3
    //   661: aload 4
    //   663: ldc_w 289
    //   666: aload 6
    //   668: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   671: aload_2
    //   672: astore_3
    //   673: aload_1
    //   674: getstatic 213	xd:a	Landroid/net/Uri;
    //   677: aload 4
    //   679: ldc_w 356
    //   682: iconst_2
    //   683: anewarray 69	java/lang/String
    //   686: dup
    //   687: iconst_0
    //   688: aload 5
    //   690: aastore
    //   691: dup
    //   692: iconst_1
    //   693: ldc_w 369
    //   696: aastore
    //   697: invokevirtual 243	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   700: ifne +454 -> 1154
    //   703: aload_2
    //   704: astore_3
    //   705: aload_1
    //   706: getstatic 213	xd:a	Landroid/net/Uri;
    //   709: aload 4
    //   711: invokevirtual 360	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   714: pop
    //   715: aload_2
    //   716: astore_3
    //   717: aload_0
    //   718: ldc_w 369
    //   721: aload 6
    //   723: aconst_null
    //   724: aconst_null
    //   725: aconst_null
    //   726: invokevirtual 300	alw:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   729: aload_2
    //   730: astore_3
    //   731: aload 4
    //   733: invokevirtual 329	android/content/ContentValues:clear	()V
    //   736: aload_2
    //   737: astore_3
    //   738: aload 4
    //   740: ldc 223
    //   742: aload 5
    //   744: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: aload_2
    //   748: astore_3
    //   749: aload 4
    //   751: ldc_w 287
    //   754: ldc_w 373
    //   757: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload_2
    //   761: astore_3
    //   762: aload_0
    //   763: getfield 105	alw:c	Landroid/net/Uri;
    //   766: invokevirtual 313	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   769: invokestatic 194	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   772: invokestatic 376	aqn:a	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   775: astore 6
    //   777: aload_2
    //   778: astore_3
    //   779: aload 4
    //   781: ldc_w 289
    //   784: aload 6
    //   786: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   789: aload_2
    //   790: astore_3
    //   791: aload_1
    //   792: getstatic 213	xd:a	Landroid/net/Uri;
    //   795: aload 4
    //   797: ldc_w 356
    //   800: iconst_2
    //   801: anewarray 69	java/lang/String
    //   804: dup
    //   805: iconst_0
    //   806: aload 5
    //   808: aastore
    //   809: dup
    //   810: iconst_1
    //   811: ldc_w 373
    //   814: aastore
    //   815: invokevirtual 243	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   818: ifne +353 -> 1171
    //   821: aload_2
    //   822: astore_3
    //   823: aload_1
    //   824: getstatic 213	xd:a	Landroid/net/Uri;
    //   827: aload 4
    //   829: invokevirtual 360	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   832: pop
    //   833: aload_2
    //   834: astore_3
    //   835: aload_0
    //   836: ldc_w 373
    //   839: aload 6
    //   841: aconst_null
    //   842: aconst_null
    //   843: aconst_null
    //   844: invokevirtual 300	alw:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   847: aload_2
    //   848: astore_3
    //   849: aload 4
    //   851: invokevirtual 329	android/content/ContentValues:clear	()V
    //   854: aload_2
    //   855: astore_3
    //   856: aload 4
    //   858: ldc 223
    //   860: aload 5
    //   862: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   865: aload_2
    //   866: astore_3
    //   867: aload 4
    //   869: ldc_w 287
    //   872: ldc_w 378
    //   875: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   878: aload_2
    //   879: astore_3
    //   880: aload_0
    //   881: getfield 105	alw:c	Landroid/net/Uri;
    //   884: invokevirtual 313	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   887: invokestatic 194	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   890: invokestatic 380	aqn:b	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   893: astore 6
    //   895: aload_2
    //   896: astore_3
    //   897: aload 4
    //   899: ldc_w 289
    //   902: aload 6
    //   904: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   907: aload_2
    //   908: astore_3
    //   909: aload_1
    //   910: getstatic 213	xd:a	Landroid/net/Uri;
    //   913: aload 4
    //   915: ldc_w 356
    //   918: iconst_2
    //   919: anewarray 69	java/lang/String
    //   922: dup
    //   923: iconst_0
    //   924: aload 5
    //   926: aastore
    //   927: dup
    //   928: iconst_1
    //   929: ldc_w 378
    //   932: aastore
    //   933: invokevirtual 243	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   936: ifne +252 -> 1188
    //   939: aload_2
    //   940: astore_3
    //   941: aload_1
    //   942: getstatic 213	xd:a	Landroid/net/Uri;
    //   945: aload 4
    //   947: invokevirtual 360	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   950: pop
    //   951: aload_2
    //   952: astore_3
    //   953: aload_0
    //   954: ldc_w 378
    //   957: aload 6
    //   959: aconst_null
    //   960: aconst_null
    //   961: aconst_null
    //   962: invokevirtual 300	alw:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   965: aload_2
    //   966: astore_3
    //   967: aload 4
    //   969: invokevirtual 329	android/content/ContentValues:clear	()V
    //   972: aload_2
    //   973: astore_3
    //   974: aload 4
    //   976: ldc 223
    //   978: aload 5
    //   980: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   983: aload_2
    //   984: astore_3
    //   985: aload 4
    //   987: ldc_w 287
    //   990: ldc_w 382
    //   993: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   996: aload_2
    //   997: astore_3
    //   998: aload 4
    //   1000: ldc_w 289
    //   1003: aload 6
    //   1005: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1008: aload_2
    //   1009: astore_3
    //   1010: aload_1
    //   1011: getstatic 213	xd:a	Landroid/net/Uri;
    //   1014: aload 4
    //   1016: ldc_w 356
    //   1019: iconst_2
    //   1020: anewarray 69	java/lang/String
    //   1023: dup
    //   1024: iconst_0
    //   1025: aload 5
    //   1027: aastore
    //   1028: dup
    //   1029: iconst_1
    //   1030: ldc_w 382
    //   1033: aastore
    //   1034: invokevirtual 243	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1037: ifne +168 -> 1205
    //   1040: aload_2
    //   1041: astore_3
    //   1042: aload_1
    //   1043: getstatic 213	xd:a	Landroid/net/Uri;
    //   1046: aload 4
    //   1048: invokevirtual 360	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   1051: pop
    //   1052: aload_2
    //   1053: astore_3
    //   1054: aload_0
    //   1055: ldc_w 382
    //   1058: aload 6
    //   1060: aconst_null
    //   1061: aconst_null
    //   1062: aconst_null
    //   1063: invokevirtual 300	alw:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1066: aload_2
    //   1067: ifnull -963 -> 104
    //   1070: aload_2
    //   1071: invokeinterface 328 1 0
    //   1076: return
    //   1077: aload_2
    //   1078: astore_3
    //   1079: aload_0
    //   1080: ldc_w 325
    //   1083: aload 6
    //   1085: getfield 351	android/util/Pair:second	Ljava/lang/Object;
    //   1088: checkcast 69	java/lang/String
    //   1091: aload 6
    //   1093: getfield 354	android/util/Pair:first	Ljava/lang/Object;
    //   1096: checkcast 69	java/lang/String
    //   1099: aconst_null
    //   1100: aconst_null
    //   1101: invokevirtual 384	alw:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1104: goto -735 -> 369
    //   1107: astore_1
    //   1108: aload_3
    //   1109: ifnull +9 -> 1118
    //   1112: aload_3
    //   1113: invokeinterface 328 1 0
    //   1118: aload_1
    //   1119: athrow
    //   1120: aload_2
    //   1121: astore_3
    //   1122: aload_0
    //   1123: ldc_w 362
    //   1126: aload 6
    //   1128: aconst_null
    //   1129: aconst_null
    //   1130: aconst_null
    //   1131: invokevirtual 384	alw:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1134: goto -645 -> 489
    //   1137: aload_2
    //   1138: astore_3
    //   1139: aload_0
    //   1140: ldc_w 320
    //   1143: aload 6
    //   1145: aconst_null
    //   1146: aconst_null
    //   1147: aconst_null
    //   1148: invokevirtual 384	alw:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1151: goto -542 -> 609
    //   1154: aload_2
    //   1155: astore_3
    //   1156: aload_0
    //   1157: ldc_w 369
    //   1160: aload 6
    //   1162: aconst_null
    //   1163: aconst_null
    //   1164: aconst_null
    //   1165: invokevirtual 384	alw:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1168: goto -439 -> 729
    //   1171: aload_2
    //   1172: astore_3
    //   1173: aload_0
    //   1174: ldc_w 373
    //   1177: aload 6
    //   1179: aconst_null
    //   1180: aconst_null
    //   1181: aconst_null
    //   1182: invokevirtual 384	alw:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1185: goto -338 -> 847
    //   1188: aload_2
    //   1189: astore_3
    //   1190: aload_0
    //   1191: ldc_w 378
    //   1194: aload 6
    //   1196: aconst_null
    //   1197: aconst_null
    //   1198: aconst_null
    //   1199: invokevirtual 384	alw:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1202: goto -237 -> 965
    //   1205: aload_2
    //   1206: astore_3
    //   1207: aload_0
    //   1208: ldc_w 382
    //   1211: aload 6
    //   1213: aconst_null
    //   1214: aconst_null
    //   1215: aconst_null
    //   1216: invokevirtual 384	alw:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1219: goto -153 -> 1066
    //   1222: astore_1
    //   1223: aconst_null
    //   1224: astore_2
    //   1225: goto -1024 -> 201
    //
    // Exception table:
    //   from	to	target	type
    //   67	76	200	java/lang/Exception
    //   78	85	200	java/lang/Exception
    //   87	94	200	java/lang/Exception
    //   107	116	200	java/lang/Exception
    //   118	127	200	java/lang/Exception
    //   129	138	200	java/lang/Exception
    //   140	148	200	java/lang/Exception
    //   150	156	200	java/lang/Exception
    //   158	163	200	java/lang/Exception
    //   165	174	200	java/lang/Exception
    //   176	197	200	java/lang/Exception
    //   214	219	200	java/lang/Exception
    //   221	235	200	java/lang/Exception
    //   237	248	200	java/lang/Exception
    //   250	262	200	java/lang/Exception
    //   264	280	200	java/lang/Exception
    //   282	298	200	java/lang/Exception
    //   300	330	200	java/lang/Exception
    //   332	342	200	java/lang/Exception
    //   344	369	200	java/lang/Exception
    //   371	376	200	java/lang/Exception
    //   378	392	200	java/lang/Exception
    //   394	405	200	java/lang/Exception
    //   407	419	200	java/lang/Exception
    //   421	431	200	java/lang/Exception
    //   433	463	200	java/lang/Exception
    //   465	475	200	java/lang/Exception
    //   477	489	200	java/lang/Exception
    //   491	496	200	java/lang/Exception
    //   498	512	200	java/lang/Exception
    //   514	525	200	java/lang/Exception
    //   527	539	200	java/lang/Exception
    //   541	551	200	java/lang/Exception
    //   553	583	200	java/lang/Exception
    //   585	595	200	java/lang/Exception
    //   597	609	200	java/lang/Exception
    //   611	616	200	java/lang/Exception
    //   618	632	200	java/lang/Exception
    //   634	645	200	java/lang/Exception
    //   647	659	200	java/lang/Exception
    //   661	671	200	java/lang/Exception
    //   673	703	200	java/lang/Exception
    //   705	715	200	java/lang/Exception
    //   717	729	200	java/lang/Exception
    //   731	736	200	java/lang/Exception
    //   738	747	200	java/lang/Exception
    //   749	760	200	java/lang/Exception
    //   762	777	200	java/lang/Exception
    //   779	789	200	java/lang/Exception
    //   791	821	200	java/lang/Exception
    //   823	833	200	java/lang/Exception
    //   835	847	200	java/lang/Exception
    //   849	854	200	java/lang/Exception
    //   856	865	200	java/lang/Exception
    //   867	878	200	java/lang/Exception
    //   880	895	200	java/lang/Exception
    //   897	907	200	java/lang/Exception
    //   909	939	200	java/lang/Exception
    //   941	951	200	java/lang/Exception
    //   953	965	200	java/lang/Exception
    //   967	972	200	java/lang/Exception
    //   974	983	200	java/lang/Exception
    //   985	996	200	java/lang/Exception
    //   998	1008	200	java/lang/Exception
    //   1010	1040	200	java/lang/Exception
    //   1042	1052	200	java/lang/Exception
    //   1054	1066	200	java/lang/Exception
    //   1079	1104	200	java/lang/Exception
    //   1122	1134	200	java/lang/Exception
    //   1139	1151	200	java/lang/Exception
    //   1156	1168	200	java/lang/Exception
    //   1173	1185	200	java/lang/Exception
    //   1190	1202	200	java/lang/Exception
    //   1207	1219	200	java/lang/Exception
    //   13	18	1107	finally
    //   20	29	1107	finally
    //   31	65	1107	finally
    //   67	76	1107	finally
    //   78	85	1107	finally
    //   87	94	1107	finally
    //   107	116	1107	finally
    //   118	127	1107	finally
    //   129	138	1107	finally
    //   140	148	1107	finally
    //   150	156	1107	finally
    //   158	163	1107	finally
    //   165	174	1107	finally
    //   176	197	1107	finally
    //   214	219	1107	finally
    //   221	235	1107	finally
    //   237	248	1107	finally
    //   250	262	1107	finally
    //   264	280	1107	finally
    //   282	298	1107	finally
    //   300	330	1107	finally
    //   332	342	1107	finally
    //   344	369	1107	finally
    //   371	376	1107	finally
    //   378	392	1107	finally
    //   394	405	1107	finally
    //   407	419	1107	finally
    //   421	431	1107	finally
    //   433	463	1107	finally
    //   465	475	1107	finally
    //   477	489	1107	finally
    //   491	496	1107	finally
    //   498	512	1107	finally
    //   514	525	1107	finally
    //   527	539	1107	finally
    //   541	551	1107	finally
    //   553	583	1107	finally
    //   585	595	1107	finally
    //   597	609	1107	finally
    //   611	616	1107	finally
    //   618	632	1107	finally
    //   634	645	1107	finally
    //   647	659	1107	finally
    //   661	671	1107	finally
    //   673	703	1107	finally
    //   705	715	1107	finally
    //   717	729	1107	finally
    //   731	736	1107	finally
    //   738	747	1107	finally
    //   749	760	1107	finally
    //   762	777	1107	finally
    //   779	789	1107	finally
    //   791	821	1107	finally
    //   823	833	1107	finally
    //   835	847	1107	finally
    //   849	854	1107	finally
    //   856	865	1107	finally
    //   867	878	1107	finally
    //   880	895	1107	finally
    //   897	907	1107	finally
    //   909	939	1107	finally
    //   941	951	1107	finally
    //   953	965	1107	finally
    //   967	972	1107	finally
    //   974	983	1107	finally
    //   985	996	1107	finally
    //   998	1008	1107	finally
    //   1010	1040	1107	finally
    //   1042	1052	1107	finally
    //   1054	1066	1107	finally
    //   1079	1104	1107	finally
    //   1122	1134	1107	finally
    //   1139	1151	1107	finally
    //   1156	1168	1107	finally
    //   1173	1185	1107	finally
    //   1190	1202	1107	finally
    //   1207	1219	1107	finally
    //   13	18	1222	java/lang/Exception
    //   20	29	1222	java/lang/Exception
    //   31	65	1222	java/lang/Exception
  }

  public void a(ContentResolver paramContentResolver, alw paramalw)
  {
    long l1 = 0L;
    ContentValues localContentValues = new ContentValues();
    if (this.c != null)
      localContentValues.put("uri", this.c.toString());
    if (!TextUtils.isEmpty(this.d))
      localContentValues.put("name", this.d);
    if (this.e != null)
      localContentValues.put("thumb", this.e.toString());
    if (this.m != null)
      localContentValues.put("image", atw.d(this.m));
    localContentValues.put("shortcut", this.h);
    localContentValues.put("_order", Integer.valueOf(this.f));
    localContentValues.put("prefer_number", this.g);
    if (this.c == null)
    {
      paramContentResolver = paramContentResolver.insert(xc.a, localContentValues);
      if (paramContentResolver != null)
        l1 = (int)ContentUris.parseId(paramContentResolver);
      paramalw.b = l1;
      return;
    }
    while (true)
    {
      try
      {
        if (paramContentResolver.update(xc.a, localContentValues, "uri=?", new String[] { this.c.toString() }) != 0)
          break;
        Object localObject = paramContentResolver.insert(xc.a, localContentValues);
        if (localObject != null)
        {
          l1 = (int)ContentUris.parseId((Uri)localObject);
          paramalw.b = l1;
          if (paramalw.b <= 0L)
            break;
          localContentValues.clear();
          localContentValues.put("contact_id", Long.valueOf(paramalw.b));
          if (paramContentResolver.update(xj.a, localContentValues, "package_name=? AND contact_uri=?", new String[] { "0", paramalw.c.toString() }) <= 0)
            paramContentResolver.notifyChange(xj.a, null);
          localContentValues.clear();
          localContentValues.put("contact_id", Long.valueOf(paramalw.b));
          localContentValues.put("app", "org.telegram.messenger");
          localObject = aqn.c(this.c, SwipeApplication.c());
          localContentValues.put("key", (String)((Pair)localObject).second);
          localContentValues.put("data_1", (String)((Pair)localObject).first);
          if (TextUtils.isEmpty((CharSequence)((Pair)localObject).second))
            break label982;
          n = 1;
          localContentValues.put("is_enable", Integer.valueOf(n));
          paramContentResolver.insert(xd.a, localContentValues);
          a("org.telegram.messenger", (String)((Pair)localObject).second, (String)((Pair)localObject).first, null, null);
          localContentValues.clear();
          localContentValues.put("contact_id", Long.valueOf(paramalw.b));
          localContentValues.put("app", "com.viber.voip");
          localObject = aqn.b(this.c, SwipeApplication.c());
          localContentValues.put("key", (String)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject))
            break label988;
          n = 1;
          localContentValues.put("is_enable", Integer.valueOf(n));
          paramContentResolver.insert(xd.a, localContentValues);
          a("com.viber.voip", (String)localObject, null, null, null);
          localContentValues.clear();
          localContentValues.put("contact_id", Long.valueOf(paramalw.b));
          localContentValues.put("app", "com.tencent.mm");
          localObject = aqn.d(this.c, SwipeApplication.c());
          localContentValues.put("key", (String)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject))
            break label994;
          n = 1;
          localContentValues.put("is_enable", Integer.valueOf(n));
          paramContentResolver.insert(xd.a, localContentValues);
          a("com.tencent.mm", (String)localObject, null, null, null);
          localContentValues.clear();
          localContentValues.put("contact_id", Long.valueOf(paramalw.b));
          localContentValues.put("app", "com.whatsapp");
          localObject = aqn.a(this.c, SwipeApplication.c());
          localContentValues.put("key", (String)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject))
            break label1000;
          n = 1;
          localContentValues.put("is_enable", Integer.valueOf(n));
          paramContentResolver.insert(xd.a, localContentValues);
          a("com.whatsapp", (String)localObject, null, null, null);
          localContentValues.clear();
          localContentValues.put("contact_id", Long.valueOf(paramalw.b));
          localContentValues.put("app", "email");
          localObject = aqn.a(this.c.getLastPathSegment(), SwipeApplication.c());
          localContentValues.put("key", (String)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject))
            break label1006;
          n = 1;
          localContentValues.put("is_enable", Integer.valueOf(n));
          paramContentResolver.insert(xd.a, localContentValues);
          a("email", (String)localObject, null, null, null);
          localContentValues.clear();
          localContentValues.put("contact_id", Long.valueOf(paramalw.b));
          localContentValues.put("app", "phone");
          localObject = aqn.b(this.c.getLastPathSegment(), SwipeApplication.c());
          localContentValues.put("key", (String)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject))
            break label1012;
          n = 1;
          localContentValues.put("is_enable", Integer.valueOf(n));
          paramContentResolver.insert(xd.a, localContentValues);
          a("phone", (String)localObject, null, null, null);
          localContentValues.clear();
          localContentValues.put("contact_id", Long.valueOf(paramalw.b));
          localContentValues.put("app", "sms");
          localContentValues.put("key", (String)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject))
            break label1018;
          n = 1;
          localContentValues.put("is_enable", Integer.valueOf(n));
          paramContentResolver.insert(xd.a, localContentValues);
          a("sms", (String)localObject, null, null, null);
          return;
        }
      }
      catch (Exception paramContentResolver)
      {
        Log.e(k, "Failed to insert the contact", paramContentResolver);
        return;
      }
      l1 = 0L;
      continue;
      label982: int n = 0;
      continue;
      label988: n = 0;
      continue;
      label994: n = 0;
      continue;
      label1000: n = 0;
      continue;
      label1006: n = 0;
      continue;
      label1012: n = 0;
      continue;
      label1018: n = 0;
    }
  }

  public void a(Context paramContext, alw paramalw)
  {
    a(paramContext.getContentResolver(), paramalw);
  }

  public void a(String paramString)
  {
    this.i.remove(paramString);
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      this.i.remove(paramString1);
      return;
    }
    this.i.put(paramString1, new alv(paramString1, paramString2, paramString3, paramString4, paramString5));
  }

  public boolean a()
  {
    return this.h != null;
  }

  public Bitmap b()
  {
    return this.m;
  }

  public void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.i.containsKey(paramString1))
      a(paramString1, paramString2, paramString3, paramString4, paramString5);
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof alw)) && (asq.a(this.c, ((alw) paramObject).c));
  }

  public int hashCode()
  {
    return this.c.hashCode();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Contact:{name=").append(this.d).append(",order=").append(this.f).append(",uri=").append(this.c).append(",mPreferNumber=").append(this.g).append(",contactAppSize=").append(this.i.size()).append(",shortcut=").append(this.h);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     alw
 * JD-Core Version:    0.6.2
 */