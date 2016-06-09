package cmcm.com.myapplication.com.qq.e.comm.services;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClient.Priority;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.net.rr.S2SSRequest;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final a a = new a();
  private volatile Boolean b = Boolean.valueOf(false);

  public static a a()
  {
    return a;
  }

  private static String a(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      RunningAppProcessInfo localRunningAppProcessInfo = (RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i)
        return localRunningAppProcessInfo.processName;
    }
    return null;
  }

  // ERROR //
  private static String a(SM paramSM, PM paramPM, DeviceStatus paramDeviceStatus, APPStatus paramAPPStatus, Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: new 80	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 81	org/json/JSONObject:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: invokestatic 86	com/qq/e/comm/a:a	(Lcom/qq/e/comm/managers/setting/SM;)Lorg/json/JSONObject;
    //   13: astore 8
    //   15: aload 8
    //   17: astore 7
    //   19: new 80	org/json/JSONObject
    //   22: dup
    //   23: invokespecial 81	org/json/JSONObject:<init>	()V
    //   26: astore 8
    //   28: aload_0
    //   29: ifnull +27 -> 56
    //   32: aload 8
    //   34: ldc 88
    //   36: aload_0
    //   37: invokevirtual 94	com/qq/e/comm/managers/setting/SM:getDevCloudSettingSig	()Ljava/lang/String;
    //   40: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload 8
    //   46: ldc 100
    //   48: aload_0
    //   49: invokevirtual 103	com/qq/e/comm/managers/setting/SM:getSdkCloudSettingSig	()Ljava/lang/String;
    //   52: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload_1
    //   57: ifnull +30 -> 87
    //   60: aload 8
    //   62: ldc 105
    //   64: aload_1
    //   65: invokevirtual 110	com/qq/e/comm/managers/plugin/PM:getLocalSig	()Ljava/lang/String;
    //   68: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   71: pop
    //   72: aload 8
    //   74: ldc 112
    //   76: aload_1
    //   77: invokevirtual 115	com/qq/e/comm/managers/plugin/PM:getPluginVersion	()I
    //   80: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload 7
    //   89: ldc 122
    //   91: aload 8
    //   93: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   96: pop
    //   97: new 80	org/json/JSONObject
    //   100: dup
    //   101: invokespecial 81	org/json/JSONObject:<init>	()V
    //   104: astore_0
    //   105: aload_2
    //   106: ifnull +112 -> 218
    //   109: aload_0
    //   110: ldc 127
    //   112: aload_2
    //   113: invokevirtual 132	com/qq/e/comm/managers/status/DeviceStatus:getDid	()Ljava/lang/String;
    //   116: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   119: pop
    //   120: aload_0
    //   121: ldc 134
    //   123: aload_2
    //   124: getfield 137	com/qq/e/comm/managers/status/DeviceStatus:model	Ljava/lang/String;
    //   127: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload_0
    //   132: ldc 139
    //   134: aload_2
    //   135: invokevirtual 142	com/qq/e/comm/managers/status/DeviceStatus:getLanguage	()Ljava/lang/String;
    //   138: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   141: pop
    //   142: aload_0
    //   143: ldc 144
    //   145: aload_2
    //   146: invokevirtual 147	com/qq/e/comm/managers/status/DeviceStatus:getDeviceWidth	()I
    //   149: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   155: pop
    //   156: aload_0
    //   157: ldc 149
    //   159: aload_2
    //   160: invokevirtual 152	com/qq/e/comm/managers/status/DeviceStatus:getDeviceHeight	()I
    //   163: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   169: pop
    //   170: aload_0
    //   171: ldc 154
    //   173: aload_2
    //   174: invokevirtual 157	com/qq/e/comm/managers/status/DeviceStatus:getDeviceDensity	()I
    //   177: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   183: pop
    //   184: aload_0
    //   185: ldc 159
    //   187: aload_2
    //   188: invokevirtual 162	com/qq/e/comm/managers/status/DeviceStatus:getVersion	()I
    //   191: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   197: pop
    //   198: aload_0
    //   199: ldc 164
    //   201: ldc 166
    //   203: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   206: pop
    //   207: aload_0
    //   208: ldc 168
    //   210: aload_2
    //   211: invokevirtual 171	com/qq/e/comm/managers/status/DeviceStatus:getOperator	()Ljava/lang/String;
    //   214: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: aload 7
    //   220: ldc 173
    //   222: aload_0
    //   223: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload 7
    //   229: ldc 88
    //   231: aload_3
    //   232: invokestatic 176	com/qq/e/comm/a:a	(Lcom/qq/e/comm/managers/status/APPStatus;)Lorg/json/JSONObject;
    //   235: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   238: pop
    //   239: aload_2
    //   240: invokestatic 179	com/qq/e/comm/a:a	(Lcom/qq/e/comm/managers/status/DeviceStatus;)Lorg/json/JSONObject;
    //   243: astore_0
    //   244: aload_0
    //   245: ldc 181
    //   247: aload 4
    //   249: invokestatic 183	com/qq/e/comm/services/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   252: invokevirtual 98	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload 7
    //   258: ldc 185
    //   260: aload_0
    //   261: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   264: pop
    //   265: aload 7
    //   267: ldc 100
    //   269: aload_1
    //   270: invokestatic 188	com/qq/e/comm/a:a	(Lcom/qq/e/comm/managers/plugin/PM;)Lorg/json/JSONObject;
    //   273: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   276: pop
    //   277: new 80	org/json/JSONObject
    //   280: dup
    //   281: invokespecial 81	org/json/JSONObject:<init>	()V
    //   284: astore_0
    //   285: new 80	org/json/JSONObject
    //   288: dup
    //   289: invokespecial 81	org/json/JSONObject:<init>	()V
    //   292: astore_1
    //   293: aload_1
    //   294: ldc 190
    //   296: invokestatic 196	java/lang/System:nanoTime	()J
    //   299: lload 5
    //   301: lsub
    //   302: ldc2_w 197
    //   305: ldiv
    //   306: invokevirtual 201	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload_0
    //   311: ldc 203
    //   313: aload_1
    //   314: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   317: pop
    //   318: aload 7
    //   320: ldc 205
    //   322: aload_0
    //   323: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   326: pop
    //   327: aload 7
    //   329: invokevirtual 208	org/json/JSONObject:toString	()Ljava/lang/String;
    //   332: areturn
    //   333: astore_0
    //   334: ldc 210
    //   336: aload_0
    //   337: invokestatic 216	com/qq/e/comm/util/GDTLogger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: goto -13 -> 327
    //   343: astore_0
    //   344: goto -10 -> 334
    //
    // Exception table:
    //   from	to	target	type
    //   9	15	333	org/json/JSONException
    //   19	28	343	org/json/JSONException
    //   32	56	343	org/json/JSONException
    //   60	87	343	org/json/JSONException
    //   87	105	343	org/json/JSONException
    //   109	218	343	org/json/JSONException
    //   218	327	343	org/json/JSONException
  }

  public static void a(String paramString, Throwable paramThrowable)
  {
    if ((GDTADManager.getInstance() != null) && (GDTADManager.getInstance().isInitialized()))
      try
      {
        JSONObject localJSONObject = com.qq.e.comm.a.a(GDTADManager.getInstance().getSM());
        localJSONObject.put("c", com.qq.e.comm.a.a(GDTADManager.getInstance().getDeviceStatus()));
        localJSONObject.put("app", com.qq.e.comm.a.a(GDTADManager.getInstance().getAppStatus()));
        HashMap localHashMap = new HashMap();
        localJSONObject.put("biz", localHashMap);
        if (paramThrowable != null)
        {
          localHashMap.put("extype", paramThrowable.getClass().getName());
          localHashMap.put("ext", paramString + "\r" + paramThrowable.getMessage() + "\r" + Arrays.toString(paramThrowable.getStackTrace()));
        }
        while (true)
        {
          paramString = new S2SSRequest("http://sdk.e.qq.com/err", localJSONObject.toString().getBytes());
          NetworkClientImpl.getInstance().submit(paramString);
          return;
          localHashMap.put("extype", "");
          localHashMap.put("ex", paramString);
        }
      }
      catch (Throwable paramString)
      {
        GDTLogger.w("Exception While build s2ss error report req", paramString);
        return;
      }
    GDTLogger.w("Report Not Work while  ADManager  not Inited");
  }

  public final void a(Context paramContext, final SM paramSM, final PM paramPM, DeviceStatus paramDeviceStatus, APPStatus paramAPPStatus, long paramLong)
  {
    if (this.b.booleanValue())
      return;
    synchronized (this.b)
    {
      if (this.b.booleanValue())
        return;
    }
    paramDeviceStatus = a(paramSM, paramPM, paramDeviceStatus, paramAPPStatus, paramContext, paramLong);
    if (!StringUtil.isEmpty(paramSM.getSuid()));
    for (paramContext = "http://sdk.e.qq.com/launch"; ; paramContext = "http://sdk.e.qq.com/activate")
    {
      paramSM = new NetworkCallBack()
      {
        public final void onException(Exception paramAnonymousException)
        {
          GDTLogger.e("ActivateError", paramAnonymousException);
          RetCodeService.getInstance().send(new RetCodeService.RetCodeInfo("sdk.e.qq.com", "launch", "", -1, (int)(System.currentTimeMillis() - this.c), 0, 0, 1));
        }

        public final void onResponse(Request paramAnonymousRequest, Response paramAnonymousResponse)
        {
          try
          {
            if (paramAnonymousResponse.getStatusCode() == 200)
            {
              paramAnonymousRequest = paramAnonymousResponse.getStringContent();
              GDTLogger.d("ACTIVERESPONSE:" + paramAnonymousRequest);
              if (StringUtil.isEmpty(paramAnonymousRequest))
              {
                GDTLogger.report("SDK Server response empty string,maybe zip or tea format error");
                return;
              }
              Object localObject = new JSONObject(paramAnonymousRequest);
              int i = -1;
              if (((JSONObject)localObject).has("ret"))
                i = ((JSONObject)localObject).getInt("ret");
              if (i != 0)
                GDTLogger.e("Response Error,retCode=" + i);
              while (true)
              {
                return;
                if (((JSONObject)localObject).has("suid"))
                {
                  paramAnonymousRequest = ((JSONObject)localObject).getString("suid");
                  if (!StringUtil.isEmpty(paramAnonymousRequest))
                    paramSM.updateSUID(paramAnonymousRequest);
                }
                if (((JSONObject)localObject).has("sid"))
                {
                  paramAnonymousRequest = ((JSONObject)localObject).getString("sid");
                  if (!StringUtil.isEmpty(paramAnonymousRequest))
                    paramSM.updateSID(paramAnonymousRequest);
                }
                if (((JSONObject)localObject).has("sig"))
                {
                  paramAnonymousRequest = ((JSONObject)localObject).getJSONObject("sig");
                  if (((JSONObject)localObject).has("setting"))
                  {
                    localObject = ((JSONObject)localObject).getJSONObject("setting");
                    String str1;
                    String str2;
                    if ((((JSONObject)localObject).has("app")) && (paramAnonymousRequest.has("app")))
                    {
                      str1 = ((JSONObject)localObject).getString("app");
                      str2 = paramAnonymousRequest.getString("app");
                      paramSM.updateDEVCloudSetting(str2, str1);
                    }
                    if ((((JSONObject)localObject).has("sdk")) && (paramAnonymousRequest.has("sdk")))
                    {
                      str1 = ((JSONObject)localObject).getString("sdk");
                      str2 = paramAnonymousRequest.getString("sdk");
                      paramSM.updateSDKCloudSetting(str2, str1);
                    }
                    if (!((JSONObject)localObject).has("c"))
                      break;
                    localObject = ((JSONObject)localObject).getString("c");
                    paramSM.updateContextSetting((String)localObject);
                  }
                  if ((paramAnonymousRequest.has("jar")) && (paramAnonymousRequest.has("url")))
                  {
                    localObject = paramAnonymousRequest.getString("jar");
                    paramAnonymousRequest = paramAnonymousRequest.getString("url");
                    paramPM.update((String)localObject, paramAnonymousRequest);
                  }
                }
              }
            }
          }
          catch (IOException paramAnonymousRequest)
          {
            while (true)
            {
              GDTLogger.e("ActivateError", paramAnonymousRequest);
              return;
              paramSM.updateContextSetting(null);
            }
          }
          catch (JSONException paramAnonymousRequest)
          {
            while (true)
            {
              GDTLogger.e("Parse Active or launch response exception", paramAnonymousRequest);
              return;
              GDTLogger.e("SDK server response code error while launch or activate,code:" + paramAnonymousResponse.getStatusCode());
            }
          }
          finally
          {
            RetCodeService.getInstance().send(new RetCodeService.RetCodeInfo("sdk.e.qq.com", "launch", "", paramAnonymousResponse.getStatusCode(), (int)(System.currentTimeMillis() - this.c), 0, 0, 1));
          }
          throw paramAnonymousRequest;
        }
      };
      paramContext = new S2SSRequest(paramContext, paramDeviceStatus.getBytes());
      NetworkClientImpl.getInstance().submit(paramContext, NetworkClient.Priority.High, paramSM);
      this.b = Boolean.valueOf(true);
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.services.a
 * JD-Core Version:    0.6.2
 */