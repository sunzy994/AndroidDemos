package cmcm.com.myapplication;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class qk
{
  private static JSONObject a;

  private static JSONObject a(File paramFile)
  {
    if (!paramFile.exists())
      throw new IOException("file not exists");
    return new JSONObject(qg.b(qn.a(paramFile)));
  }

  // ERROR //
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 43	qk:a	Lorg/json/JSONObject;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnull +47 -> 52
    //   8: getstatic 43	qk:a	Lorg/json/JSONObject;
    //   11: invokestatic 46	qk:a	(Lorg/json/JSONObject;)V
    //   14: ldc 48
    //   16: ldc 50
    //   18: invokestatic 55	qq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: return
    //   22: astore_1
    //   23: new 57	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   30: ldc 62
    //   32: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 70	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   39: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 75	qq:b	(Ljava/lang/String;)V
    //   48: aconst_null
    //   49: putstatic 43	qk:a	Lorg/json/JSONObject;
    //   52: aload_0
    //   53: ldc 77
    //   55: invokestatic 82	oy:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   58: invokestatic 84	qk:a	(Ljava/io/File;)Lorg/json/JSONObject;
    //   61: putstatic 43	qk:a	Lorg/json/JSONObject;
    //   64: getstatic 43	qk:a	Lorg/json/JSONObject;
    //   67: invokestatic 46	qk:a	(Lorg/json/JSONObject;)V
    //   70: ldc 48
    //   72: ldc 86
    //   74: invokestatic 55	qq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: return
    //   78: astore_1
    //   79: new 57	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   86: ldc 88
    //   88: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 70	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   95: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 75	qq:b	(Ljava/lang/String;)V
    //   104: aconst_null
    //   105: putstatic 43	qk:a	Lorg/json/JSONObject;
    //   108: aload_0
    //   109: invokevirtual 94	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   112: sipush 128
    //   115: invokevirtual 100	android/content/pm/PackageManager:getInstalledApplications	(I)Ljava/util/List;
    //   118: astore_1
    //   119: lconst_0
    //   120: lstore_3
    //   121: aload_1
    //   122: invokeinterface 106 1 0
    //   127: astore_1
    //   128: aload_1
    //   129: invokeinterface 111 1 0
    //   134: ifeq +103 -> 237
    //   137: aload_1
    //   138: invokeinterface 115 1 0
    //   143: checkcast 117	android/content/pm/ApplicationInfo
    //   146: astore_2
    //   147: aload_0
    //   148: aload_2
    //   149: getfield 121	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   152: ldc 77
    //   154: invokestatic 124	oy:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   157: invokestatic 84	qk:a	(Ljava/io/File;)Lorg/json/JSONObject;
    //   160: astore_2
    //   161: aload_2
    //   162: ifnull -34 -> 128
    //   165: aload_2
    //   166: ldc 126
    //   168: invokevirtual 130	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   171: bipush 22
    //   173: if_icmpne -45 -> 128
    //   176: aload_2
    //   177: ldc 132
    //   179: invokevirtual 136	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   182: lstore 5
    //   184: lload 5
    //   186: lload_3
    //   187: lcmp
    //   188: ifle +194 -> 382
    //   191: aload_2
    //   192: putstatic 43	qk:a	Lorg/json/JSONObject;
    //   195: lload 5
    //   197: lstore_3
    //   198: goto -70 -> 128
    //   201: astore_2
    //   202: new 57	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   209: ldc 138
    //   211: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_2
    //   215: invokevirtual 70	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   218: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 75	qq:b	(Ljava/lang/String;)V
    //   227: goto -99 -> 128
    //   230: astore_0
    //   231: aconst_null
    //   232: putstatic 43	qk:a	Lorg/json/JSONObject;
    //   235: aload_0
    //   236: athrow
    //   237: getstatic 43	qk:a	Lorg/json/JSONObject;
    //   240: astore_1
    //   241: aload_1
    //   242: ifnull +47 -> 289
    //   245: getstatic 43	qk:a	Lorg/json/JSONObject;
    //   248: invokestatic 46	qk:a	(Lorg/json/JSONObject;)V
    //   251: ldc 48
    //   253: ldc 140
    //   255: invokestatic 55	qq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: return
    //   259: astore_1
    //   260: new 57	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   267: ldc 142
    //   269: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_1
    //   273: invokevirtual 143	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   276: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 75	qq:b	(Ljava/lang/String;)V
    //   285: aconst_null
    //   286: putstatic 43	qk:a	Lorg/json/JSONObject;
    //   289: new 57	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   296: ldc 145
    //   298: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_0
    //   302: invokestatic 150	ql:a	(Landroid/content/Context;)[Ljava/lang/String;
    //   305: iconst_0
    //   306: aaload
    //   307: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: astore_1
    //   314: ldc 152
    //   316: aload_1
    //   317: invokestatic 55	qq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: new 23	org/json/JSONObject
    //   323: dup
    //   324: aload_1
    //   325: invokestatic 156	qo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   328: invokespecial 35	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   331: putstatic 43	qk:a	Lorg/json/JSONObject;
    //   334: getstatic 43	qk:a	Lorg/json/JSONObject;
    //   337: ldc 132
    //   339: invokestatic 162	java/lang/System:currentTimeMillis	()J
    //   342: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   345: pop
    //   346: getstatic 43	qk:a	Lorg/json/JSONObject;
    //   349: ldc 126
    //   351: bipush 22
    //   353: invokevirtual 169	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   356: pop
    //   357: getstatic 43	qk:a	Lorg/json/JSONObject;
    //   360: invokestatic 46	qk:a	(Lorg/json/JSONObject;)V
    //   363: aload_0
    //   364: getstatic 43	qk:a	Lorg/json/JSONObject;
    //   367: invokestatic 172	qk:a	(Landroid/content/Context;Lorg/json/JSONObject;)V
    //   370: ldc 48
    //   372: ldc 174
    //   374: invokestatic 55	qq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: return
    //   378: astore_2
    //   379: goto -251 -> 128
    //   382: goto -184 -> 198
    //
    // Exception table:
    //   from	to	target	type
    //   8	21	22	java/lang/Throwable
    //   52	77	78	java/lang/Throwable
    //   147	161	201	java/lang/Throwable
    //   165	184	201	java/lang/Throwable
    //   191	195	201	java/lang/Throwable
    //   0	4	230	java/lang/Throwable
    //   23	52	230	java/lang/Throwable
    //   79	119	230	java/lang/Throwable
    //   121	128	230	java/lang/Throwable
    //   128	147	230	java/lang/Throwable
    //   202	227	230	java/lang/Throwable
    //   237	241	230	java/lang/Throwable
    //   245	258	230	java/lang/Throwable
    //   260	289	230	java/lang/Throwable
    //   289	377	230	java/lang/Throwable
    //   245	258	259	org/json/JSONException
    //   147	161	378	java/io/IOException
    //   165	184	378	java/io/IOException
    //   191	195	378	java/io/IOException
  }

  private static void a(Context paramContext, JSONObject paramJSONObject)
  {
    paramContext = oy.a(paramContext, "hola_channel_conf.json");
    qn.a(paramContext, qg.a(paramJSONObject.toString()));
    qn.b(paramContext, "644");
  }

  private static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
      qq.a("conf_json", paramJSONObject.toString());
    if (paramJSONObject.getInt("sdk_ver") != 22)
      throw new JSONException("Config version is lower than sdk");
    if (paramJSONObject.getLong("up_time") < System.currentTimeMillis() - qj.b)
      throw new JSONException("Config is expire");
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.equals("CONFIG_UPDATE_INTERVAL"))
        qj.b = paramJSONObject.getInt("CONFIG_UPDATE_INTERVAL");
      else if (str.equals("LOADER_URL"))
        oy.a = paramJSONObject.getString("LOADER_URL");
      else if (str.equals("LOADER_MD5"))
        oy.b = paramJSONObject.getString("LOADER_MD5");
      else if (str.equals("ANALYSIS_URL"))
        oy.c = paramJSONObject.getString("ANALYSIS_URL");
      else if (str.equals("ANALYSIS_MD5"))
        oy.d = paramJSONObject.getString("ANALYSIS_MD5");
    }
    qq.a("conf_json", "OK");
    if (new File("/sdcard/hola_debug").exists())
    {
      qj.a = true;
      qq.b("FORCE-DEBUG", String.valueOf(qj.a));
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qk
 * JD-Core Version:    0.6.2
 */