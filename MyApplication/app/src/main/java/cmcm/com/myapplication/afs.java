package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class afs
{
  public static final List<ComponentName> a = new ArrayList();
  public static final List<String> b = new ArrayList();
  private static final String c = "Swipe." + afs.class.getSimpleName();
  private static final Runnable d = new Runnable()
  {
    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: getstatic 20	afs:a	Ljava/util/List;
      //   3: invokeinterface 25 1 0
      //   8: getstatic 28	afs:b	Ljava/util/List;
      //   11: invokeinterface 25 1 0
      //   16: invokestatic 34	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
      //   19: invokevirtual 40	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   22: astore_1
      //   23: getstatic 45	xg:a	Landroid/net/Uri;
      //   26: astore_2
      //   27: getstatic 50	ash:b	Ljava/lang/String;
      //   30: astore_3
      //   31: new 52	java/lang/StringBuilder
      //   34: dup
      //   35: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   38: ldc 55
      //   40: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   43: bipush 18
      //   45: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   48: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   51: astore 4
      //   53: aload_1
      //   54: aload_2
      //   55: aconst_null
      //   56: ldc 68
      //   58: iconst_2
      //   59: anewarray 70	java/lang/String
      //   62: dup
      //   63: iconst_0
      //   64: aload_3
      //   65: aastore
      //   66: dup
      //   67: iconst_1
      //   68: ldc 71
      //   70: invokestatic 75	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   73: aastore
      //   74: aload 4
      //   76: invokevirtual 81	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   79: astore_2
      //   80: aload_2
      //   81: astore_1
      //   82: new 83	xh
      //   85: dup
      //   86: aload_2
      //   87: invokespecial 86	xh:<init>	(Landroid/database/Cursor;)V
      //   90: astore_3
      //   91: aload_2
      //   92: astore_1
      //   93: invokestatic 34	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
      //   96: invokevirtual 89	com/lazyswipe/SwipeApplication:a	()Lwm;
      //   99: getfield 94	wm:a	Lwj;
      //   102: astore 4
      //   104: aload_2
      //   105: astore_1
      //   106: aload_2
      //   107: invokeinterface 100 1 0
      //   112: ifeq +18 -> 130
      //   115: aload_2
      //   116: astore_1
      //   117: getstatic 20	afs:a	Ljava/util/List;
      //   120: invokeinterface 104 1 0
      //   125: bipush 9
      //   127: if_icmplt +41 -> 168
      //   130: aload_2
      //   131: astore_1
      //   132: invokestatic 106	afs:b	()Ljava/lang/String;
      //   135: new 52	java/lang/StringBuilder
      //   138: dup
      //   139: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   142: ldc 108
      //   144: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   147: getstatic 20	afs:a	Ljava/util/List;
      //   150: invokestatic 113	asq:b	(Ljava/util/Collection;)Ljava/lang/String;
      //   153: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   156: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   159: invokestatic 119	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   162: pop
      //   163: aload_2
      //   164: invokestatic 123	arf:a	(Landroid/database/Cursor;)V
      //   167: return
      //   168: aload_2
      //   169: astore_1
      //   170: new 125	wk
      //   173: dup
      //   174: aload_2
      //   175: aload_3
      //   176: invokespecial 128	wk:<init>	(Landroid/database/Cursor;Lxh;)V
      //   179: astore 5
      //   181: aload_2
      //   182: astore_1
      //   183: aload 4
      //   185: aload 5
      //   187: getfield 131	wk:i	Landroid/content/ComponentName;
      //   190: iconst_0
      //   191: anewarray 70	java/lang/String
      //   194: invokevirtual 136	wj:a	(Landroid/content/ComponentName;[Ljava/lang/String;)Z
      //   197: ifeq -93 -> 104
      //   200: aload_2
      //   201: astore_1
      //   202: getstatic 20	afs:a	Ljava/util/List;
      //   205: aload 5
      //   207: getfield 131	wk:i	Landroid/content/ComponentName;
      //   210: invokeinterface 140 2 0
      //   215: pop
      //   216: aload_2
      //   217: astore_1
      //   218: getstatic 28	afs:b	Ljava/util/List;
      //   221: aload 5
      //   223: getfield 131	wk:i	Landroid/content/ComponentName;
      //   226: invokevirtual 145	android/content/ComponentName:getPackageName	()Ljava/lang/String;
      //   229: invokeinterface 140 2 0
      //   234: pop
      //   235: goto -131 -> 104
      //   238: astore_3
      //   239: aload_2
      //   240: astore_1
      //   241: invokestatic 106	afs:b	()Ljava/lang/String;
      //   244: ldc 147
      //   246: aload_3
      //   247: invokestatic 151	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   250: pop
      //   251: aload_2
      //   252: invokestatic 123	arf:a	(Landroid/database/Cursor;)V
      //   255: return
      //   256: astore_2
      //   257: aconst_null
      //   258: astore_1
      //   259: aload_1
      //   260: invokestatic 123	arf:a	(Landroid/database/Cursor;)V
      //   263: aload_2
      //   264: athrow
      //   265: astore_2
      //   266: goto -7 -> 259
      //   269: astore_3
      //   270: aconst_null
      //   271: astore_2
      //   272: goto -33 -> 239
      //
      // Exception table:
      //   from	to	target	type
      //   82	91	238	java/lang/Exception
      //   93	104	238	java/lang/Exception
      //   106	115	238	java/lang/Exception
      //   117	130	238	java/lang/Exception
      //   132	163	238	java/lang/Exception
      //   170	181	238	java/lang/Exception
      //   183	200	238	java/lang/Exception
      //   202	216	238	java/lang/Exception
      //   218	235	238	java/lang/Exception
      //   0	80	256	finally
      //   82	91	265	finally
      //   93	104	265	finally
      //   106	115	265	finally
      //   117	130	265	finally
      //   132	163	265	finally
      //   170	181	265	finally
      //   183	200	265	finally
      //   202	216	265	finally
      //   218	235	265	finally
      //   241	251	265	finally
      //   0	80	269	java/lang/Exception
    }
  };
  private static ComponentName e;

  private static Drawable a(Context paramContext, wk paramwk)
  {
    try
    {
      paramContext = paramwk.a(paramContext.getPackageManager());
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
    }
    return null;
  }

  private static SpannableString a(String paramString, String[] paramArrayOfString)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      int k = paramString.indexOf(str);
      int m = str.length();
      localSpannableString.setSpan(new ForegroundColorSpan(-14441234), k, m + k, 33);
      i += 1;
    }
    return localSpannableString;
  }

  public static void a()
  {
    arj.b(d);
    arj.a(d);
  }

  // ERROR //
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 113	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_1
    //   5: getstatic 118	xg:a	Landroid/net/Uri;
    //   8: astore_2
    //   9: getstatic 122	ash:b	Ljava/lang/String;
    //   12: astore_3
    //   13: getstatic 122	ash:b	Ljava/lang/String;
    //   16: astore 4
    //   18: new 27	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   25: ldc 124
    //   27: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: bipush 18
    //   32: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 5
    //   40: aload_1
    //   41: aload_2
    //   42: aconst_null
    //   43: ldc 129
    //   45: iconst_2
    //   46: anewarray 81	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload_3
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: aload 4
    //   57: aastore
    //   58: aload 5
    //   60: invokevirtual 135	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore_1
    //   64: new 137	xh
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 140	xh:<init>	(Landroid/database/Cursor;)V
    //   72: astore_3
    //   73: new 49	java/util/ArrayList
    //   76: dup
    //   77: aload_1
    //   78: invokeinterface 145 1 0
    //   83: invokespecial 146	java/util/ArrayList:<init>	(I)V
    //   86: astore_2
    //   87: invokestatic 151	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   90: invokevirtual 154	com/lazyswipe/SwipeApplication:a	()Lwm;
    //   93: getfield 159	wm:a	Lwj;
    //   96: astore 4
    //   98: iconst_0
    //   99: istore 6
    //   101: aload_1
    //   102: invokeinterface 163 1 0
    //   107: ifeq +10 -> 117
    //   110: iload 6
    //   112: bipush 9
    //   114: if_icmple +55 -> 169
    //   117: new 49	java/util/ArrayList
    //   120: dup
    //   121: invokespecial 50	java/util/ArrayList:<init>	()V
    //   124: astore_3
    //   125: aload_2
    //   126: invokeinterface 169 1 0
    //   131: astore_2
    //   132: iconst_0
    //   133: istore 6
    //   135: aload_2
    //   136: invokeinterface 174 1 0
    //   141: ifeq +92 -> 233
    //   144: aload_2
    //   145: invokeinterface 178 1 0
    //   150: checkcast 70	wk
    //   153: astore 4
    //   155: aload 4
    //   157: invokevirtual 180	wk:b	()Z
    //   160: ifeq +55 -> 215
    //   163: iconst_1
    //   164: istore 6
    //   166: goto +273 -> 439
    //   169: new 70	wk
    //   172: dup
    //   173: aload_1
    //   174: aload_3
    //   175: invokespecial 183	wk:<init>	(Landroid/database/Cursor;Lxh;)V
    //   178: astore 5
    //   180: aload 4
    //   182: aload 5
    //   184: getfield 186	wk:i	Landroid/content/ComponentName;
    //   187: iconst_0
    //   188: anewarray 81	java/lang/String
    //   191: invokevirtual 191	wj:a	(Landroid/content/ComponentName;[Ljava/lang/String;)Z
    //   194: ifeq -93 -> 101
    //   197: aload_2
    //   198: aload 5
    //   200: invokeinterface 195 2 0
    //   205: pop
    //   206: iload 6
    //   208: iconst_1
    //   209: iadd
    //   210: istore 6
    //   212: goto -111 -> 101
    //   215: aload_3
    //   216: aload 4
    //   218: getfield 198	wk:a	J
    //   221: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   224: invokeinterface 195 2 0
    //   229: pop
    //   230: goto +209 -> 439
    //   233: iload 6
    //   235: ifeq +198 -> 433
    //   238: new 206	android/content/ContentValues
    //   241: dup
    //   242: invokespecial 207	android/content/ContentValues:<init>	()V
    //   245: astore_2
    //   246: aload_2
    //   247: ldc 209
    //   249: ldc 210
    //   251: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   257: new 27	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   264: ldc 221
    //   266: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_3
    //   270: ldc 223
    //   272: invokestatic 228	asi:a	(Ljava/util/Collection;Ljava/lang/String;)Ljava/lang/String;
    //   275: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 230
    //   280: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: astore_3
    //   287: aload_0
    //   288: invokevirtual 113	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   291: getstatic 118	xg:a	Landroid/net/Uri;
    //   294: aload_2
    //   295: aload_3
    //   296: aconst_null
    //   297: invokevirtual 234	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   300: istore 6
    //   302: aload_1
    //   303: invokestatic 238	arf:a	(Landroid/database/Cursor;)V
    //   306: getstatic 47	afs:c	Ljava/lang/String;
    //   309: new 27	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   316: ldc 240
    //   318: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: iload 6
    //   323: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 245	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   332: pop
    //   333: return
    //   334: astore_1
    //   335: aconst_null
    //   336: astore_0
    //   337: getstatic 47	afs:c	Ljava/lang/String;
    //   340: ldc 247
    //   342: aload_1
    //   343: invokestatic 250	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   346: pop
    //   347: aload_0
    //   348: invokestatic 238	arf:a	(Landroid/database/Cursor;)V
    //   351: getstatic 47	afs:c	Ljava/lang/String;
    //   354: new 27	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   361: ldc 240
    //   363: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: iconst_0
    //   367: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 245	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   376: pop
    //   377: return
    //   378: astore_0
    //   379: aconst_null
    //   380: astore_1
    //   381: aload_1
    //   382: invokestatic 238	arf:a	(Landroid/database/Cursor;)V
    //   385: getstatic 47	afs:c	Ljava/lang/String;
    //   388: new 27	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   395: ldc 240
    //   397: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: iconst_0
    //   401: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   404: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 245	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   410: pop
    //   411: aload_0
    //   412: athrow
    //   413: astore_0
    //   414: goto -33 -> 381
    //   417: astore_2
    //   418: aload_0
    //   419: astore_1
    //   420: aload_2
    //   421: astore_0
    //   422: goto -41 -> 381
    //   425: astore_2
    //   426: aload_1
    //   427: astore_0
    //   428: aload_2
    //   429: astore_1
    //   430: goto -93 -> 337
    //   433: iconst_0
    //   434: istore 6
    //   436: goto -134 -> 302
    //   439: goto -304 -> 135
    //
    // Exception table:
    //   from	to	target	type
    //   0	64	334	java/lang/Exception
    //   0	64	378	finally
    //   64	98	413	finally
    //   101	110	413	finally
    //   117	132	413	finally
    //   135	163	413	finally
    //   169	206	413	finally
    //   215	230	413	finally
    //   238	302	413	finally
    //   337	347	417	finally
    //   64	98	425	java/lang/Exception
    //   101	110	425	java/lang/Exception
    //   117	132	425	java/lang/Exception
    //   135	163	425	java/lang/Exception
    //   169	206	425	java/lang/Exception
    //   215	230	425	java/lang/Exception
    //   238	302	425	java/lang/Exception
  }

  public static void a(Context paramContext, String paramString)
  {
    vs.b(paramContext, "PREF_KEY_APP_ENTER_TIME" + paramString.replace(".", "_"), System.currentTimeMillis());
  }

  public static boolean a(Context paramContext, ComponentName paramComponentName)
  {
    e = null;
    paramComponentName.getPackageName();
    return false;
  }

  private static String b(String paramString)
  {
    if (paramString == null)
      return "M_U_GD_SHOW_";
    return "M_U_GD_SHOW_" + paramString.replace(".", "_");
  }

  public static void b(Context paramContext, String paramString)
  {
    c(paramContext, paramString);
    Object localObject1 = (SwipeApplication)paramContext.getApplicationContext();
    Object localObject2 = ((SwipeApplication)localObject1).a().a(paramString);
    Object localObject3 = ((SwipeApplication)localObject1).a().a(e);
    Log.i(c, "showTip(), newInfo = " + paramString + ", oldInfo = " + e);
    if (localObject2 == null)
      return;
    localObject1 = ((wk)localObject2).b.toString();
    Object localObject4 = a(paramContext, (wk)localObject2);
    localObject2 = (ViewGroup)LayoutInflater.from(paramContext).inflate(2130968700, null);
    View localView = ((ViewGroup)localObject2).findViewById(2131755359);
    ImageView localImageView = (ImageView)((ViewGroup)localObject2).findViewById(2131755360);
    ((ImageView)((ViewGroup)localObject2).findViewById(2131755362)).setImageDrawable((Drawable)localObject4);
    Resources localResources = paramContext.getResources();
    localObject4 = localResources.getString(2131231232, new Object[] { localObject1 });
    if (localObject3 != null)
    {
      String str = ((wk)localObject3).b.toString();
      localImageView.setImageDrawable(a(paramContext, (wk)localObject3));
      localView.setVisibility(0);
      localObject3 = localResources.getString(2131231233, new Object[] { str });
      localObject1 = a((String)localObject4 + (String)localObject3 + "?", new String[] { localObject1, str });
    }
    while (true)
    {
      new auy(paramContext).a((Drawable)null).a((CharSequence)localObject1).a((View)localObject2).a(paramContext.getString(17039370), new OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          afs.a(afs.this);
        }
      }).b(paramContext.getString(17039360), new OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          afs.b(afs.this);
        }
      }).a(new OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          afs.b(afs.this);
        }
      }).b();
      return;
      localObject1 = a((String)localObject4 + "?", new String[] { localObject1 });
      localView.setVisibility(8);
    }
  }

  private static void c(Context paramContext)
  {
    int i = d(paramContext);
    if (i > 0)
    {
      aru.b(paramContext, "MOST_USED_GUIDE_TIMES", i + 1);
      return;
    }
    aru.b(paramContext, "MOST_USED_GUIDE_DATE", Calendar.getInstance().get(6));
    aru.b(paramContext, "MOST_USED_GUIDE_TIMES", 1);
  }

  private static void c(Context paramContext, String paramString)
  {
    aru.a(paramContext, b(paramString), true);
  }

  private static void c(String paramString)
  {
    Object localObject = SwipeApplication.c();
    paramString = ((SwipeApplication)localObject).a().a(paramString);
    wk localwk = ((SwipeApplication)localObject).a().a(e);
    localObject = ((SwipeApplication)localObject).a();
    if (localwk == null)
    {
      paramString.f = 2147483547;
      ((wm)localObject).c(paramString);
    }
    while (true)
    {
      paramString.n = true;
      SwipeService.b("mostUsed");
      a();
      return;
      int i = localwk.f;
      int j = paramString.f;
      paramString.f = i;
      localwk.f = j;
      ((wm)localObject).c(paramString);
      ((wm)localObject).c(localwk);
    }
  }

  private static int d(Context paramContext)
  {
    int i = aru.a(paramContext, "MOST_USED_GUIDE_DATE", -1);
    int j = aru.a(paramContext, "MOST_USED_GUIDE_TIMES", -1);
    if (Calendar.getInstance().get(6) == i)
      return j;
    return 0;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afs
 * JD-Core Version:    0.6.2
 */