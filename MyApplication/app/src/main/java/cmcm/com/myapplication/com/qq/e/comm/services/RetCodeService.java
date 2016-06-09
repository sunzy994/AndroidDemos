package cmcm.com.myapplication.com.qq.e.comm.services;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class RetCodeService
{
  private final Random a = new Random(System.currentTimeMillis());

  private static String a(String paramString)
  {
    try
    {
      paramString = InetAddress.getByName(paramString).getHostAddress();
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
    }
    return "0.0.0.0";
  }

  private boolean a(int paramInt)
  {
    return this.a.nextDouble() < 1.0D / paramInt;
  }

  public static RetCodeService getInstance()
  {
    return RetCodeService.Holder.a;
  }

  public void send(RetCodeService.RetCodeInfo paramRetCodeInfo)
  {
    new Thread(new RetCodeService.SendTask(this, paramRetCodeInfo, 100)).start();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.services.RetCodeService
 * JD-Core Version:    0.6.2
 */