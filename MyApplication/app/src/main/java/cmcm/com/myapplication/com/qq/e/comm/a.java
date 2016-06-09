package cmcm.com.myapplication.com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import com.qq.e.comm.constants.Constants.PLUGIN;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class a
{
  private String a;
  private com.qq.e.comm.managers.setting.a b;

  public a(String paramString, com.qq.e.comm.managers.setting.a parama)
  {
    this.a = paramString;
    this.b = parama;
  }

  public static JSONObject a(PM paramPM)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
    localJSONObject.putOpt("pv", Integer.valueOf(paramPM.getPluginVersion()));
    return localJSONObject;
  }

  public static JSONObject a(SM paramSM)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramSM != null)
    {
      localJSONObject.putOpt("suid", paramSM.getSuid());
      localJSONObject.putOpt("sid", paramSM.getSid());
    }
    return localJSONObject;
  }

  public static JSONObject a(APPStatus paramAPPStatus)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAPPStatus != null)
    {
      localJSONObject.putOpt("an", paramAPPStatus.getAPPName());
      localJSONObject.putOpt("appkey", paramAPPStatus.getAPPID());
      localJSONObject.putOpt("appv", paramAPPStatus.getAPPVersion());
    }
    return localJSONObject;
  }

  public static JSONObject a(DeviceStatus paramDeviceStatus)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramDeviceStatus != null)
    {
      localJSONObject.putOpt("so", paramDeviceStatus.getScreenOrientation());
      localJSONObject.putOpt("dn", paramDeviceStatus.getDataNet());
      localJSONObject.putOpt("lat", paramDeviceStatus.getLat());
      localJSONObject.putOpt("lng", paramDeviceStatus.getLng());
      paramDeviceStatus = paramDeviceStatus.getLacAndCeilId().entrySet().iterator();
      while (paramDeviceStatus.hasNext())
      {
        Entry localEntry = (Entry)paramDeviceStatus.next();
        localJSONObject.putOpt((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    return localJSONObject;
  }

  public static boolean a(Context paramContext)
  {
    try
    {
      if (b(paramContext))
        if (a(paramContext, new Class[] { Class.forName(CustomPkgConstants.getADActivityName()) }))
        {
          boolean bool = b(paramContext, new Class[] { Class.forName(CustomPkgConstants.getDownLoadServiceName()) });
          if (bool)
            return true;
        }
      return false;
    }
    catch (Throwable paramContext)
    {
      GDTLogger.e("Exception While check SDK Env", paramContext);
    }
    return false;
  }

  public static boolean a(Context paramContext, File paramFile1, File paramFile2)
  {
    AssetManager localAssetManager = paramContext.getAssets();
    label259: 
    while (true)
    {
      Object localObject;
      int n;
      int j;
      int i;
      int i1;
      int k;
      try
      {
        if (Arrays.binarySearch(localAssetManager.list(CustomPkgConstants.getAssetPluginDir()), CustomPkgConstants.getAssetPluginName()) < 0)
          break label199;
        String str = CustomPkgConstants.getAssetPluginDir() + File.separator + CustomPkgConstants.getAssetPluginName();
        localObject = Constants.PLUGIN.ASSET_PLUGIN_SIG;
        paramContext = (Context)localObject;
        if (localObject == null)
          paramContext = "";
        StringUtil.writeTo("509#####" + paramContext, paramFile2);
        if (StringUtil.isEmpty(CustomPkgConstants.getAssetPluginXorKey()))
          return FileUtil.copyTo(localAssetManager.open(str), paramFile1);
        paramContext = localAssetManager.open(str);
        paramFile1 = new FileOutputStream(paramFile1);
        paramFile2 = CustomPkgConstants.getAssetPluginXorKey().getBytes();
        localObject = new byte[1024];
        n = paramFile2.length;
        j = 0;
        i = 0;
        i1 = paramContext.read((byte[])localObject);
        if (i1 > 0)
        {
          k = 0;
          break label201;
          paramFile1.write((byte[])localObject, 0, i1);
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        GDTLogger.report("Exception while init default plugin manager", paramContext);
        return false;
      }
      paramContext.close();
      paramFile1.close();
      return true;
      break label246;
      label199: return false;
      while (true)
      {
        label201: if (k >= i1)
          break label259;
        if (j < 64)
          break;
        int i2 = localObject[k];
        int m = i + 1;
        localObject[k] = ((byte)(paramFile2[(i % n)] ^ i2));
        i = m;
        label246: k += 1;
        j += 1;
      }
    }
  }

  private static boolean a(Context paramContext, Class<?>[] paramArrayOfClass)
  {
    int i = 0;
    try
    {
      while (i < paramArrayOfClass.length)
      {
        Intent localIntent = new Intent();
        localIntent.setClass(paramContext, paramArrayOfClass[i]);
        if (paramContext.getPackageManager().resolveActivity(localIntent, 65536) == null)
        {
          GDTLogger.e(String.format("Activity[%s] is required in AndroidManifest.xml", new Object[] { paramArrayOfClass[i].getName() }));
          return false;
        }
        i += 1;
      }
    }
    catch (Throwable paramContext)
    {
      GDTLogger.e("Exception while checking required activities", paramContext);
      return false;
    }
    return true;
  }

  // ERROR //
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aload_0
    //   10: areturn
    //   11: new 313	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 314	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore 4
    //   20: new 316	java/util/zip/GZIPOutputStream
    //   23: dup
    //   24: aload 4
    //   26: invokespecial 319	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: aload_0
    //   34: invokevirtual 322	java/util/zip/GZIPOutputStream:write	([B)V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 325	java/util/zip/GZIPOutputStream:finish	()V
    //   43: aload_2
    //   44: astore_1
    //   45: aload 4
    //   47: invokevirtual 328	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   50: astore_0
    //   51: aload_2
    //   52: invokevirtual 329	java/util/zip/GZIPOutputStream:close	()V
    //   55: aload 4
    //   57: invokevirtual 330	java/io/ByteArrayOutputStream:close	()V
    //   60: aload_0
    //   61: areturn
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   67: aload_0
    //   68: areturn
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_0
    //   72: aload_0
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 329	java/util/zip/GZIPOutputStream:close	()V
    //   86: aload 4
    //   88: invokevirtual 330	java/io/ByteArrayOutputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 329	java/util/zip/GZIPOutputStream:close	()V
    //   111: aload 4
    //   113: invokevirtual 330	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore_0
    //   127: goto -24 -> 103
    //   130: astore_3
    //   131: aload_2
    //   132: astore_0
    //   133: goto -61 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   51	60	62	java/lang/Exception
    //   20	30	69	java/lang/Exception
    //   82	86	93	java/lang/Exception
    //   86	91	93	java/lang/Exception
    //   20	30	100	finally
    //   107	111	118	java/lang/Exception
    //   111	116	118	java/lang/Exception
    //   32	37	126	finally
    //   39	43	126	finally
    //   45	51	126	finally
    //   74	78	126	finally
    //   32	37	130	java/lang/Exception
    //   39	43	130	java/lang/Exception
    //   45	51	130	java/lang/Exception
  }

  private static boolean b(Context paramContext)
  {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "android.permission.INTERNET";
    arrayOfString[1] = "android.permission.ACCESS_NETWORK_STATE";
    arrayOfString[2] = "android.permission.ACCESS_WIFI_STATE";
    arrayOfString[3] = "android.permission.READ_PHONE_STATE";
    arrayOfString[4] = "android.permission.WRITE_EXTERNAL_STORAGE";
    try
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (paramContext.checkCallingOrSelfPermission(str) == -1)
        {
          GDTLogger.e(String.format("Permission %s is required in AndroidManifest.xml", new Object[] { str }));
          return false;
        }
        i += 1;
      }
    }
    catch (Throwable paramContext)
    {
      GDTLogger.e("Check required Permissions error", paramContext);
      return false;
    }
    return true;
  }

  private static boolean b(Context paramContext, Class<?>[] paramArrayOfClass)
  {
    try
    {
      int j = paramArrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        Class<?> localClass = paramArrayOfClass[i];
        Intent localIntent = new Intent();
        localIntent.setClass(paramContext, localClass);
        if (paramContext.getPackageManager().resolveService(localIntent, 65536) == null)
        {
          GDTLogger.e(String.format("Service[%s] is required in AndroidManifest.xml", new Object[] { localClass.getName() }));
          return false;
        }
        i += 1;
      }
    }
    catch (Throwable paramContext)
    {
      GDTLogger.e("Exception while checking required services", paramContext);
      return false;
    }
    return true;
  }

  // ERROR //
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aload_0
    //   10: areturn
    //   11: new 360	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 362	java/io/ByteArrayInputStream:<init>	([B)V
    //   19: astore_3
    //   20: new 313	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 314	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore 4
    //   29: sipush 1024
    //   32: newarray byte
    //   34: astore_2
    //   35: new 364	java/util/zip/GZIPInputStream
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 367	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_1
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 368	java/util/zip/GZIPInputStream:read	([B)I
    //   51: istore 5
    //   53: iload 5
    //   55: iconst_m1
    //   56: if_icmpeq +50 -> 106
    //   59: aload_1
    //   60: astore_0
    //   61: aload 4
    //   63: aload_2
    //   64: iconst_0
    //   65: iload 5
    //   67: invokevirtual 369	java/io/ByteArrayOutputStream:write	([BII)V
    //   70: goto -26 -> 44
    //   73: astore_2
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   80: aload_1
    //   81: ifnull +7 -> 88
    //   84: aload_1
    //   85: invokevirtual 370	java/util/zip/GZIPInputStream:close	()V
    //   88: aload_3
    //   89: invokevirtual 371	java/io/ByteArrayInputStream:close	()V
    //   92: aload 4
    //   94: invokevirtual 330	java/io/ByteArrayOutputStream:close	()V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   104: aconst_null
    //   105: areturn
    //   106: aload_1
    //   107: astore_0
    //   108: aload 4
    //   110: invokevirtual 374	java/io/ByteArrayOutputStream:flush	()V
    //   113: aload_1
    //   114: astore_0
    //   115: aload 4
    //   117: invokevirtual 328	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   120: astore_2
    //   121: aload_1
    //   122: invokevirtual 370	java/util/zip/GZIPInputStream:close	()V
    //   125: aload_3
    //   126: invokevirtual 371	java/io/ByteArrayInputStream:close	()V
    //   129: aload 4
    //   131: invokevirtual 330	java/io/ByteArrayOutputStream:close	()V
    //   134: aload_2
    //   135: areturn
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   141: aload_2
    //   142: areturn
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 370	java/util/zip/GZIPInputStream:close	()V
    //   154: aload_3
    //   155: invokevirtual 371	java/io/ByteArrayInputStream:close	()V
    //   158: aload 4
    //   160: invokevirtual 330	java/io/ByteArrayOutputStream:close	()V
    //   163: aload_1
    //   164: athrow
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   170: goto -7 -> 163
    //   173: astore_1
    //   174: goto -28 -> 146
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_1
    //   180: goto -106 -> 74
    //
    // Exception table:
    //   from	to	target	type
    //   46	53	73	java/lang/Exception
    //   61	70	73	java/lang/Exception
    //   108	113	73	java/lang/Exception
    //   115	121	73	java/lang/Exception
    //   84	88	99	java/lang/Exception
    //   88	97	99	java/lang/Exception
    //   121	134	136	java/lang/Exception
    //   35	44	143	finally
    //   150	154	165	java/lang/Exception
    //   154	163	165	java/lang/Exception
    //   46	53	173	finally
    //   61	70	173	finally
    //   76	80	173	finally
    //   108	113	173	finally
    //   115	121	173	finally
    //   35	44	177	java/lang/Exception
  }

  public String a()
  {
    return this.a;
  }

  public com.qq.e.comm.managers.setting.a b()
  {
    return this.b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.a
 * JD-Core Version:    0.6.2
 */