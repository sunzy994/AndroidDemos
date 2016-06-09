package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.net.Uri;

public class wn
{
  private static final String a = "Swipe." + wn.class.getSimpleName();
  private static final Uri b = xg.a;

  public static void a(Context paramContext, ResolveInfo paramResolveInfo, ComponentName paramComponentName)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("label", paramResolveInfo.loadLabel(paramContext.getPackageManager()).toString());
    try
    {
      localContentResolver.update(xg.a, localContentValues, "intent=?", new String[] { paramComponentName.flattenToString() });
      return;
    }
    catch (Throwable paramContext)
    {
      asp.b(a, "Error updating package " + paramComponentName + ": " + paramContext.getMessage());
    }
  }

  // ERROR //
  public static void a(Context paramContext, wk paramwk)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 49	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_0
    //   7: new 51	android/content/ContentValues
    //   10: dup
    //   11: invokespecial 106	android/content/ContentValues:<init>	()V
    //   14: astore_3
    //   15: aload_1
    //   16: aload_3
    //   17: invokevirtual 111	wk:a	(Landroid/content/ContentValues;)V
    //   20: aload_0
    //   21: getstatic 38	wn:b	Landroid/net/Uri;
    //   24: aload_3
    //   25: invokevirtual 115	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +13 -> 45
    //   35: aload_1
    //   36: aload 4
    //   38: invokestatic 121	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   41: putfield 124	wk:a	J
    //   44: return
    //   45: aload_3
    //   46: ldc 126
    //   48: invokevirtual 130	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 4
    //   53: iconst_1
    //   54: anewarray 77	java/lang/String
    //   57: astore 5
    //   59: aload 5
    //   61: iconst_0
    //   62: aload 4
    //   64: aastore
    //   65: aload_3
    //   66: ldc 126
    //   68: invokevirtual 134	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   71: aload_3
    //   72: ldc 136
    //   74: invokevirtual 134	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   77: iconst_m1
    //   78: aload_1
    //   79: getfield 140	wk:f	I
    //   82: if_icmpeq +9 -> 91
    //   85: aload_3
    //   86: ldc 142
    //   88: invokevirtual 134	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   91: aload_3
    //   92: ldc 144
    //   94: iconst_0
    //   95: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: invokevirtual 153	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   101: aload_0
    //   102: getstatic 38	wn:b	Landroid/net/Uri;
    //   105: aload_3
    //   106: ldc 75
    //   108: aload 5
    //   110: invokevirtual 88	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   113: pop
    //   114: aload_0
    //   115: getstatic 38	wn:b	Landroid/net/Uri;
    //   118: aconst_null
    //   119: ldc 75
    //   121: aload 5
    //   123: aconst_null
    //   124: invokevirtual 157	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   127: astore_0
    //   128: new 159	xh
    //   131: dup
    //   132: aload_0
    //   133: invokespecial 162	xh:<init>	(Landroid/database/Cursor;)V
    //   136: astore_2
    //   137: aload_0
    //   138: invokeinterface 168 1 0
    //   143: ifeq +9 -> 152
    //   146: aload_1
    //   147: aload_0
    //   148: aload_2
    //   149: invokevirtual 171	wk:a	(Landroid/database/Cursor;Lxh;)V
    //   152: aload_0
    //   153: ifnull +87 -> 240
    //   156: aload_0
    //   157: invokeinterface 174 1 0
    //   162: return
    //   163: astore_3
    //   164: getstatic 32	wn:a	Ljava/lang/String;
    //   167: new 12	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   174: ldc 176
    //   176: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 4
    //   181: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc 95
    //   186: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_3
    //   190: invokevirtual 98	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   193: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 102	asp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: goto -88 -> 114
    //   205: aload_0
    //   206: ifnull +34 -> 240
    //   209: aload_0
    //   210: invokeinterface 174 1 0
    //   215: return
    //   216: aload_1
    //   217: ifnull +9 -> 226
    //   220: aload_1
    //   221: invokeinterface 174 1 0
    //   226: aload_0
    //   227: athrow
    //   228: astore_2
    //   229: aload_0
    //   230: astore_1
    //   231: aload_2
    //   232: astore_0
    //   233: goto -17 -> 216
    //   236: astore_1
    //   237: goto -32 -> 205
    //   240: return
    //   241: astore_0
    //   242: return
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_0
    //   246: goto -41 -> 205
    //   249: astore_0
    //   250: aload_2
    //   251: astore_1
    //   252: goto -36 -> 216
    //
    // Exception table:
    //   from	to	target	type
    //   101	114	163	java/lang/Throwable
    //   128	152	228	finally
    //   128	152	236	java/lang/Exception
    //   20	30	241	java/lang/Throwable
    //   35	44	241	java/lang/Throwable
    //   45	59	241	java/lang/Throwable
    //   65	91	241	java/lang/Throwable
    //   91	101	241	java/lang/Throwable
    //   156	162	241	java/lang/Throwable
    //   164	202	241	java/lang/Throwable
    //   209	215	241	java/lang/Throwable
    //   220	226	241	java/lang/Throwable
    //   226	228	241	java/lang/Throwable
    //   114	128	243	java/lang/Exception
    //   114	128	249	finally
  }

  public static void b(Context paramContext, wk paramwk)
  {
    if (paramwk.a < 0L)
    {
      asp.b(a, "Delete item with invalid id " + paramwk.a);
      return;
    }
    paramContext = paramContext.getContentResolver();
    Uri localUri = ContentUris.withAppendedId(b, paramwk.a);
    ContentValues localContentValues = new ContentValues(1);
    if (paramwk.k == 1)
      localContentValues.put("on_sdcard", Integer.valueOf(-1));
    while (true)
    {
      try
      {
        paramContext.update(localUri, localContentValues, null, null);
        return;
      }
      catch (Throwable paramContext)
      {
        asp.b(a, "Error deleting " + paramwk.a + ": " + paramContext.getMessage());
        return;
      }
      localContentValues.put("uninstalled", Integer.valueOf(1));
    }
  }

  public static void c(Context paramContext, wk paramwk)
  {
    if (paramwk.a < 0L)
    {
      asp.b(a, "Update item with invalid id " + paramwk.a);
      return;
    }
    paramContext = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("label", paramwk.b.toString());
    Uri localUri = ContentUris.withAppendedId(b, paramwk.a);
    try
    {
      paramContext.update(localUri, localContentValues, null, null);
      return;
    }
    catch (Throwable paramContext)
    {
      asp.b(a, "Error updating package " + paramwk.i + ": " + paramContext.getMessage());
    }
  }

  public static void d(Context paramContext, wk paramwk)
  {
    if (paramwk.a < 0L)
    {
      asp.b(a, "Update item with invalid id " + paramwk.a);
      return;
    }
    paramContext = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues();
    paramwk.a(localContentValues);
    Uri localUri = ContentUris.withAppendedId(b, paramwk.a);
    try
    {
      paramContext.update(localUri, localContentValues, null, null);
      return;
    }
    catch (Throwable paramContext)
    {
      asp.b(a, "Error updating package " + paramwk.i + ": " + paramContext.getMessage());
    }
  }

  public static void e(Context paramContext, wk paramwk)
  {
    if (paramwk.a < 0L)
    {
      a(paramContext, paramwk);
      return;
    }
    d(paramContext, paramwk);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wn
 * JD-Core Version:    0.6.2
 */