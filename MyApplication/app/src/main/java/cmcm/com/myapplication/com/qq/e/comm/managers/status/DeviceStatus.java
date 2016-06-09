package cmcm.com.myapplication.com.qq.e.comm.managers.status;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DeviceStatus
{
  private String a;
  private String b;
  private int c;
  private int d;
  private int e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private volatile String k;
  private volatile String l;
  private volatile float m;
  public final String model = Build.MODEL;
  private Context n;

  public DeviceStatus(Context paramContext)
  {
    this.n = paramContext;
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (getVersion() > 3)
    {
      i1 = paramContext.densityDpi;
      this.e = i1;
      if (getVersion() <= 3)
        break label105;
      i1 = a(paramContext.density, paramContext.widthPixels);
      label63: this.c = i1;
      if (getVersion() <= 3)
        break label113;
    }
    label105: label113: for (int i1 = a(paramContext.density, paramContext.heightPixels); ; i1 = paramContext.heightPixels)
    {
      this.d = i1;
      a();
      return;
      i1 = 120;
      break;
      i1 = paramContext.widthPixels;
      break label63;
    }
  }

  private int a(float paramFloat, int paramInt)
  {
    int i1 = paramInt;
    if ((this.n.getApplicationInfo().flags & 0x2000) != 0)
      i1 = (int)(paramInt / paramFloat);
    return i1;
  }

  // ERROR //
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/qq/e/comm/managers/status/DeviceStatus:n	Landroid/content/Context;
    //   4: ldc 97
    //   6: invokevirtual 101	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   9: checkcast 103	android/location/LocationManager
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: new 105	android/location/Criteria
    //   21: dup
    //   22: invokespecial 106	android/location/Criteria:<init>	()V
    //   25: astore_2
    //   26: aload_2
    //   27: iconst_2
    //   28: invokevirtual 110	android/location/Criteria:setAccuracy	(I)V
    //   31: aload_2
    //   32: iconst_0
    //   33: invokevirtual 114	android/location/Criteria:setAltitudeRequired	(Z)V
    //   36: aload_2
    //   37: iconst_0
    //   38: invokevirtual 117	android/location/Criteria:setBearingRequired	(Z)V
    //   41: aload_2
    //   42: iconst_1
    //   43: invokevirtual 120	android/location/Criteria:setCostAllowed	(Z)V
    //   46: aload_2
    //   47: iconst_1
    //   48: invokevirtual 123	android/location/Criteria:setPowerRequirement	(I)V
    //   51: aload_1
    //   52: aload_2
    //   53: iconst_1
    //   54: invokevirtual 127	android/location/LocationManager:getBestProvider	(Landroid/location/Criteria;Z)Ljava/lang/String;
    //   57: astore_2
    //   58: aload_1
    //   59: aload_2
    //   60: invokevirtual 131	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
    //   63: astore_3
    //   64: aload_3
    //   65: ifnull +54 -> 119
    //   68: aload_0
    //   69: new 133	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   76: aload_3
    //   77: invokevirtual 140	android/location/Location:getLatitude	()D
    //   80: invokevirtual 144	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   83: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: putfield 93	com/qq/e/comm/managers/status/DeviceStatus:k	Ljava/lang/String;
    //   89: aload_0
    //   90: new 133	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   97: aload_3
    //   98: invokevirtual 151	android/location/Location:getLongitude	()D
    //   101: invokevirtual 144	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   104: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: putfield 153	com/qq/e/comm/managers/status/DeviceStatus:l	Ljava/lang/String;
    //   110: aload_0
    //   111: aload_3
    //   112: invokevirtual 157	android/location/Location:getAccuracy	()F
    //   115: putfield 159	com/qq/e/comm/managers/status/DeviceStatus:m	F
    //   118: return
    //   119: new 6	com/qq/e/comm/managers/status/DeviceStatus$1
    //   122: dup
    //   123: aload_0
    //   124: aload_1
    //   125: invokespecial 162	com/qq/e/comm/managers/status/DeviceStatus$1:<init>	(Lcom/qq/e/comm/managers/status/DeviceStatus;Landroid/location/LocationManager;)V
    //   128: astore_3
    //   129: aload_1
    //   130: aload_2
    //   131: ldc2_w 163
    //   134: ldc 165
    //   136: aload_3
    //   137: invokevirtual 169	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   140: return
    //   141: astore_1
    //   142: return
    //   143: astore_1
    //   144: return
    //   145: astore_1
    //   146: return
    //
    // Exception table:
    //   from	to	target	type
    //   129	140	141	java/lang/Throwable
    //   0	13	143	java/lang/Throwable
    //   18	51	143	java/lang/Throwable
    //   51	64	145	java/lang/Throwable
    //   68	118	145	java/lang/Throwable
    //   119	129	145	java/lang/Throwable
  }

  public Carrier getCarrier()
  {
    String str = getOperator();
    if (str != null)
    {
      if ((str.equals("46000")) || (str.equals("46002")) || (str.equals("46007")) || (str.equals("46020")))
        return Carrier.CMCC;
      if ((str.equals("46001")) || (str.equals("46006")))
        return Carrier.UNICOM;
      if ((str.equals("46003")) || (str.equals("46005")))
        return Carrier.TELECOM;
    }
    return Carrier.UNKNOWN;
  }

  public String getDataNet()
  {
    String str;
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.n.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null)
        return null;
    }
    catch (Exception localException)
    {
      while (true)
        str = null;
      switch (str.getType())
      {
      default:
        str = "unknow";
      case 0:
      case 1:
      }
    }
    while (true)
    {
      this.i = str;
      return this.i;
      str = "ed";
      continue;
      str = "wi";
    }
  }

  public int getDeviceDensity()
  {
    return this.e;
  }

  public int getDeviceHeight()
  {
    return this.d;
  }

  public int getDeviceWidth()
  {
    return this.c;
  }

  public String getDid()
  {
    if (this.j == null);
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)this.n.getSystemService("phone");
      if (StringUtil.isEmpty(localTelephonyManager.getDeviceId()));
      for (this.j = ""; ; this.j = Md5Util.encode(localTelephonyManager.getDeviceId().toLowerCase(Locale.US)).toLowerCase(Locale.US))
        label37: return this.j;
    }
    catch (Exception localException)
    {
      break label37;
    }
  }

  public Map<String, String> getLacAndCeilId()
  {
    int i2 = 0;
    Object localObject = getOperator();
    HashMap localHashMap = new HashMap();
    if ((!StringUtil.isEmpty((String)localObject)) && (!"null".equalsIgnoreCase((String)localObject)))
      while (true)
      {
        try
        {
          i1 = Integer.parseInt(((String)localObject).substring(0, 3));
          int i3 = Integer.parseInt(((String)localObject).substring(3));
          if (i1 != 460)
            break;
          localObject = (TelephonyManager)this.n.getSystemService("phone");
          if ((i3 == 3) || (i3 == 5))
          {
            localObject = (CdmaCellLocation)((TelephonyManager)localObject).getCellLocation();
            i2 = ((CdmaCellLocation)localObject).getNetworkId();
            i1 = ((CdmaCellLocation)localObject).getBaseStationId();
            localHashMap.put("lac", i2);
            localHashMap.put("cellid", i1);
            return localHashMap;
          }
          localObject = (GsmCellLocation)((TelephonyManager)localObject).getCellLocation();
          if (localObject != null)
          {
            i2 = ((GsmCellLocation)localObject).getLac();
            i1 = ((GsmCellLocation)localObject).getCid();
            continue;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          return localHashMap;
        }
        int i1 = 0;
      }
    return localHashMap;
  }

  public String getLanguage()
  {
    if (this.b == null)
    {
      this.b = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
      if (this.b.length() == 0)
        this.b = "en";
    }
    return this.b;
  }

  public String getLat()
  {
    return this.k;
  }

  public String getLng()
  {
    return this.l;
  }

  public float getLocationAccuracy()
  {
    return this.m;
  }

  public NetworkType getNetworkType()
  {
    String str = getDataNet();
    try
    {
      i1 = Integer.parseInt(getPhoneNet());
      if ((str != null) && (str.equals("wi")))
        return NetworkType.WIFI;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i1;
      while (true)
        i1 = 0;
      switch (i1)
      {
      default:
        return NetworkType.UNKNOWN;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 14:
      case 13:
      case 15:
      }
    }
    return NetworkType.NET_2G;
    return NetworkType.NET_3G;
    return NetworkType.NET_4G;
  }

  public String getOperator()
  {
    try
    {
      this.g = ((TelephonyManager)this.n.getSystemService("phone")).getNetworkOperator();
      label19: return this.g;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }

  public String getPhoneNet()
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)this.n.getSystemService("phone");
      this.h = localTelephonyManager.getNetworkType();
      label34: return this.h;
    }
    catch (Exception localException)
    {
      break label34;
    }
  }

  public String getScreenOrientation()
  {
    if (this.n.getResources().getConfiguration().orientation == 2)
      this.f = "l";
    while (true)
    {
      return this.f;
      if (this.n.getResources().getConfiguration().orientation == 1)
        this.f = "p";
    }
  }

  public String getUid()
  {
    if (this.a == null)
    {
      str = Settings.Secure.getString(this.n.getContentResolver(), "android_id");
      if (str != null)
        break label42;
    }
    label42: for (String str = Md5Util.encode("emulator"); ; str = Md5Util.encode(str))
    {
      this.a = str;
      return this.a;
    }
  }

  public int getVersion()
  {
    try
    {
      int i1 = VERSION.SDK_INT;
      return i1;
    }
    catch (Exception localException)
    {
    }
    return 3;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.managers.status.DeviceStatus
 * JD-Core Version:    0.6.2
 */