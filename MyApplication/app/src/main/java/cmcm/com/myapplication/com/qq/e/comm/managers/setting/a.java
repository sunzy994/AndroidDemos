package cmcm.com.myapplication.com.qq.e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private JSONObject a = new JSONObject();

  public a()
  {
  }

  public a(String paramString)
  {
    this();
    GDTLogger.d("Initialize GDTAPPSetting,Json=" + paramString);
    if (!StringUtil.isEmpty(paramString));
    try
    {
      this.a = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      GDTLogger.e("JsonException While build GDTAPPSetting Instance from JSON", paramString);
    }
  }

  private static Pair<String, String> a(Context paramContext, String paramString)
  {
    File localFile = paramContext.getDir("e_qq_com_setting", 0);
    if (localFile.exists())
    {
      paramContext = new File(localFile, paramString + ".sig");
      paramString = new File(localFile, paramString + ".cfg");
      if ((!paramContext.exists()) || (!paramString.exists()))
        return null;
      try
      {
        paramContext = new Pair(StringUtil.readAll(paramContext), StringUtil.readAll(paramString));
        return paramContext;
      }
      catch (IOException paramContext)
      {
        return null;
      }
    }
    return null;
  }

  public static com.qq.e.comm.a a(Context paramContext)
  {
    paramContext = a(paramContext, "devCloudSetting");
    if (paramContext == null)
      return null;
    try
    {
      if (com.qq.e.comm.util.a.a().a((String)paramContext.first, (String)paramContext.second))
        return new com.qq.e.comm.a((String)paramContext.first, new a(new String(Base64.decode((String)paramContext.second, 0), "UTF-8")));
      GDTLogger.e("verify local dev cloud setting fail");
      return null;
    }
    catch (Throwable paramContext)
    {
      GDTLogger.e("exception while loading local dev cloud setting", paramContext);
    }
    return null;
  }

  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, "sdkCloudSetting", paramString1, paramString2);
  }

  private static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((!StringUtil.isEmpty(paramString2)) && (!StringUtil.isEmpty(paramString3)))
    {
      if (com.qq.e.comm.util.a.a().a(paramString2, paramString3))
        return b(paramContext, paramString1, paramString2, paramString3);
      GDTLogger.e(String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", new Object[] { paramString1, paramString2, paramString3 }));
      return false;
    }
    GDTLogger.e(String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", new Object[] { paramString1, paramString2, paramString3 }));
    return false;
  }

  public static d b(Context paramContext)
  {
    paramContext = a(paramContext, "sdkCloudSetting");
    if (paramContext == null)
      return null;
    try
    {
      if (com.qq.e.comm.util.a.a().a((String)paramContext.first, (String)paramContext.second))
        return new d((String)paramContext.first, new c(new String(Base64.decode((String)paramContext.second, 0), "UTF-8")), (byte)0);
      GDTLogger.e("verify local sdk cloud setting fail");
      return null;
    }
    catch (Throwable paramContext)
    {
      GDTLogger.e("exception while loading local sdk cloud setting", paramContext);
    }
    return null;
  }

  public static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, "devCloudSetting", paramString1, paramString2);
  }

  // ERROR //
  private static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: iconst_0
    //   7: istore 8
    //   9: aload_0
    //   10: ldc 57
    //   12: iconst_0
    //   13: invokevirtual 63	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   16: astore_0
    //   17: aload_0
    //   18: invokevirtual 69	java/io/File:exists	()Z
    //   21: ifne +8 -> 29
    //   24: aload_0
    //   25: invokevirtual 170	java/io/File:mkdirs	()Z
    //   28: pop
    //   29: new 65	java/io/File
    //   32: dup
    //   33: aload_0
    //   34: new 22	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   41: aload_1
    //   42: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 77
    //   47: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   56: astore 6
    //   58: new 65	java/io/File
    //   61: dup
    //   62: aload_0
    //   63: new 22	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   70: aload_1
    //   71: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 72
    //   76: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: astore 7
    //   87: new 172	java/io/FileWriter
    //   90: dup
    //   91: aload 6
    //   93: invokespecial 175	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   96: astore_1
    //   97: aload_1
    //   98: aload_3
    //   99: invokevirtual 178	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   102: new 172	java/io/FileWriter
    //   105: dup
    //   106: aload 7
    //   108: invokespecial 175	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   111: astore_0
    //   112: aload_0
    //   113: aload_2
    //   114: invokevirtual 178	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   117: aload_1
    //   118: invokevirtual 181	java/io/FileWriter:close	()V
    //   121: aload_0
    //   122: invokevirtual 181	java/io/FileWriter:close	()V
    //   125: iconst_1
    //   126: istore 8
    //   128: iload 8
    //   130: ireturn
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_0
    //   134: aload 5
    //   136: astore_1
    //   137: aload 6
    //   139: invokevirtual 184	java/io/File:delete	()Z
    //   142: pop
    //   143: aload 7
    //   145: invokevirtual 184	java/io/File:delete	()Z
    //   148: pop
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 181	java/io/FileWriter:close	()V
    //   157: aload_0
    //   158: ifnull -30 -> 128
    //   161: aload_0
    //   162: invokevirtual 181	java/io/FileWriter:close	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_0
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_1
    //   173: aload 4
    //   175: astore_2
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 181	java/io/FileWriter:close	()V
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 181	java/io/FileWriter:close	()V
    //   192: aload_0
    //   193: athrow
    //   194: astore_1
    //   195: goto -3 -> 192
    //   198: astore_0
    //   199: aload 4
    //   201: astore_2
    //   202: goto -26 -> 176
    //   205: astore_3
    //   206: aload_0
    //   207: astore_2
    //   208: aload_3
    //   209: astore_0
    //   210: goto -34 -> 176
    //   213: astore_3
    //   214: aload_0
    //   215: astore_2
    //   216: aload_3
    //   217: astore_0
    //   218: goto -42 -> 176
    //   221: astore_0
    //   222: aconst_null
    //   223: astore_0
    //   224: goto -87 -> 137
    //   227: astore_2
    //   228: goto -91 -> 137
    //   231: astore_0
    //   232: goto -107 -> 125
    //
    // Exception table:
    //   from	to	target	type
    //   87	97	131	java/lang/Exception
    //   153	157	167	java/lang/Exception
    //   161	165	167	java/lang/Exception
    //   87	97	170	finally
    //   180	184	194	java/lang/Exception
    //   188	192	194	java/lang/Exception
    //   97	112	198	finally
    //   112	117	205	finally
    //   137	149	213	finally
    //   97	112	221	java/lang/Exception
    //   112	117	227	java/lang/Exception
    //   117	125	231	java/lang/Exception
  }

  final Object a(String paramString)
  {
    return this.a.opt(paramString);
  }

  final Object a(String paramString1, String paramString2)
  {
    Object localObject = null;
    JSONObject localJSONObject = this.a.optJSONObject("ps");
    if (localJSONObject != null);
    for (paramString2 = localJSONObject.optJSONObject(paramString2); ; paramString2 = null)
    {
      if (paramString2 != null)
        localObject = paramString2.opt(paramString1);
      return localObject;
    }
  }

  final void a(String paramString, Object paramObject)
  {
    try
    {
      this.a.putOpt(paramString, paramObject);
      return;
    }
    catch (JSONException paramString)
    {
      GDTLogger.e("Exception while update setting", paramString);
    }
  }

  final void a(String paramString1, Object paramObject, String paramString2)
  {
    while (true)
    {
      try
      {
        JSONObject localJSONObject2 = this.a.optJSONObject("ps");
        if (localJSONObject2 == null)
        {
          localJSONObject2 = new JSONObject();
          this.a.putOpt("ps", localJSONObject2);
          if (localJSONObject2 == null)
            break label109;
          localJSONObject1 = localJSONObject2.optJSONObject(paramString2);
          JSONObject localJSONObject3 = localJSONObject1;
          if (localJSONObject1 == null)
          {
            localJSONObject3 = new JSONObject();
            localJSONObject2.putOpt(paramString2, localJSONObject3);
          }
          if (paramObject == null)
          {
            localJSONObject3.remove(paramString1);
            return;
          }
          localJSONObject3.putOpt(paramString1, paramObject);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        GDTLogger.e("Exception while update setting", paramString1);
        return;
      }
      continue;
      label109: JSONObject localJSONObject1 = null;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.managers.setting.a
 * JD-Core Version:    0.6.2
 */