package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import java.io.Serializable;

public class up
{
  private SharedPreferences a;

  private up(Context paramContext, String paramString)
  {
    this.a = paramContext.getSharedPreferences(paramString, 5);
  }

  // ERROR //
  public static Object a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 25	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 28	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_1
    //   9: new 30	java/io/ObjectInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 33	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 37	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   22: astore_0
    //   23: aload_1
    //   24: invokevirtual 40	java/io/ByteArrayInputStream:close	()V
    //   27: aload_2
    //   28: invokevirtual 41	java/io/ObjectInputStream:close	()V
    //   31: aload_0
    //   32: areturn
    //   33: astore_1
    //   34: aconst_null
    //   35: astore_0
    //   36: getstatic 47	java/lang/System:out	Ljava/io/PrintStream;
    //   39: new 49	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   46: ldc 52
    //   48: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 60	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   55: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokevirtual 69	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   64: aload_1
    //   65: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   68: aload_0
    //   69: areturn
    //   70: astore_1
    //   71: goto -35 -> 36
    //
    // Exception table:
    //   from	to	target	type
    //   0	23	33	java/lang/Exception
    //   23	31	70	java/lang/Exception
  }

  public static up a(Context paramContext, String paramString)
  {
    return new up(paramContext, paramString);
  }

  public static <T extends Serializable> boolean a(Context paramContext, String paramString, T paramT)
  {
    if ((paramString != null) && (paramString.length() > 0))
      return a(paramContext.getSharedPreferences("battery.d", 5), paramString, paramT);
    return false;
  }

  public static <T extends Serializable> boolean a(SharedPreferences paramSharedPreferences, String paramString, T paramT)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      if (paramT == null)
      {
        paramSharedPreferences.remove(paramString);
        paramSharedPreferences.commit();
        return true;
      }
      paramT = a(paramT);
      if (paramT != null)
      {
        paramSharedPreferences.putString(paramString, new String(Base64.encode(paramT, 0)));
        paramSharedPreferences.commit();
        return true;
      }
    }
    return false;
  }

  // ERROR //
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: new 122	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 123	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 125	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 128	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 132	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   22: aload_1
    //   23: invokevirtual 136	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 137	java/io/ByteArrayOutputStream:close	()V
    //   31: aload_2
    //   32: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   35: aload_0
    //   36: areturn
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_0
    //   40: getstatic 47	java/lang/System:out	Ljava/io/PrintStream;
    //   43: new 49	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   50: ldc 52
    //   52: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 60	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   59: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokevirtual 69	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   68: aload_1
    //   69: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   72: aload_0
    //   73: areturn
    //   74: astore_1
    //   75: goto -35 -> 40
    //
    // Exception table:
    //   from	to	target	type
    //   0	27	37	java/lang/Exception
    //   27	35	74	java/lang/Exception
  }

  public static <T extends Serializable> T b(Context paramContext, String paramString, T paramT)
  {
    Object localObject = paramT;
    if (paramString != null)
    {
      localObject = paramT;
      if (paramString.length() > 0)
        localObject = b(paramContext.getSharedPreferences("battery.d", 5), paramString, paramT);
    }
    return localObject;
  }

  public static <T extends Serializable> T b(SharedPreferences paramSharedPreferences, String paramString, T paramT)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramSharedPreferences = paramSharedPreferences.getString(paramString, null);
      if ((paramSharedPreferences != null) && (paramSharedPreferences.length() > 0))
        return (Serializable)a(Base64.decode(paramSharedPreferences, 0));
    }
    return paramT;
  }

  public <T extends Serializable> boolean a(String paramString, T paramT)
  {
    if ((paramString != null) && (paramString.length() > 0))
      return a(this.a, paramString, paramT);
    return false;
  }

  public <T extends Serializable> T b(String paramString, T paramT)
  {
    Object localObject = paramT;
    if (paramString != null)
    {
      localObject = paramT;
      if (paramString.length() > 0)
        localObject = b(this.a, paramString, paramT);
    }
    return localObject;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     up
 * JD-Core Version:    0.6.2
 */