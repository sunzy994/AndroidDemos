package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ait extends aij
{
  private final String e;

  public ait(Context paramContext, String paramString)
  {
    super(paramContext);
    this.e = paramString;
  }

  private InputStream a(String paramString, aio paramaio)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(this.e, paramString));
      if (paramaio == aio.a)
        return localFileInputStream;
      paramaio = aiq.a(localFileInputStream);
      return paramaio;
    }
    catch (FileNotFoundException paramString)
    {
      return null;
    }
    catch (IOException paramaio)
    {
      Log.w(a, "Read file [" + paramString + "] failed.", paramaio);
    }
    return null;
  }

  public aim c()
  {
    return a(a("manifest.xml", aio.a));
  }

  // ERROR //
  public ais d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: new 80	ais
    //   6: dup
    //   7: invokespecial 81	ais:<init>	()V
    //   10: astore_1
    //   11: new 24	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: getfield 13	ait:e	Ljava/lang/String;
    //   19: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 87	java/io/File:getPath	()Ljava/lang/String;
    //   28: putfield 89	ais:d	Ljava/lang/String;
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 93	java/io/File:lastModified	()J
    //   36: putfield 96	ais:e	J
    //   39: invokestatic 101	asq:j	()Ljava/lang/String;
    //   42: astore_3
    //   43: aload_0
    //   44: new 44	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   51: ldc 103
    //   53: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_3
    //   57: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: getstatic 35	aio:a	Laio;
    //   66: invokespecial 71	ait:a	(Ljava/lang/String;Laio;)Ljava/io/InputStream;
    //   69: astore_2
    //   70: aload_2
    //   71: ifnull +180 -> 251
    //   74: aload_0
    //   75: aload_1
    //   76: aload_2
    //   77: invokestatic 108	arf:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   80: invokevirtual 111	ait:a	(Lais;Ljava/lang/String;)V
    //   83: aload_2
    //   84: invokestatic 114	arf:a	(Ljava/io/Closeable;)V
    //   87: iconst_1
    //   88: istore 5
    //   90: iload 5
    //   92: ifne +156 -> 248
    //   95: aload_3
    //   96: bipush 95
    //   98: invokevirtual 120	java/lang/String:indexOf	(I)I
    //   101: ifle +147 -> 248
    //   104: aload_0
    //   105: new 44	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   112: ldc 103
    //   114: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_3
    //   118: iconst_0
    //   119: aload_3
    //   120: bipush 95
    //   122: invokevirtual 120	java/lang/String:indexOf	(I)I
    //   125: invokevirtual 124	java/lang/String:substring	(II)Ljava/lang/String;
    //   128: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: getstatic 35	aio:a	Laio;
    //   137: invokespecial 71	ait:a	(Ljava/lang/String;Laio;)Ljava/io/InputStream;
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +106 -> 248
    //   145: aload_0
    //   146: aload_1
    //   147: aload_2
    //   148: invokestatic 108	arf:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   151: invokevirtual 111	ait:a	(Lais;Ljava/lang/String;)V
    //   154: aload_2
    //   155: invokestatic 114	arf:a	(Ljava/io/Closeable;)V
    //   158: iload 6
    //   160: istore 5
    //   162: iload 5
    //   164: ifne +30 -> 194
    //   167: aload_0
    //   168: ldc 126
    //   170: getstatic 35	aio:a	Laio;
    //   173: invokespecial 71	ait:a	(Ljava/lang/String;Laio;)Ljava/io/InputStream;
    //   176: astore_2
    //   177: aload_2
    //   178: ifnull +16 -> 194
    //   181: aload_0
    //   182: aload_1
    //   183: aload_2
    //   184: invokestatic 108	arf:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   187: invokevirtual 111	ait:a	(Lais;Ljava/lang/String;)V
    //   190: aload_2
    //   191: invokestatic 114	arf:a	(Ljava/io/Closeable;)V
    //   194: aload_1
    //   195: areturn
    //   196: astore 4
    //   198: aload_2
    //   199: invokestatic 114	arf:a	(Ljava/io/Closeable;)V
    //   202: iconst_0
    //   203: istore 5
    //   205: goto -115 -> 90
    //   208: astore_1
    //   209: aload_2
    //   210: invokestatic 114	arf:a	(Ljava/io/Closeable;)V
    //   213: aload_1
    //   214: athrow
    //   215: astore_3
    //   216: aload_2
    //   217: invokestatic 114	arf:a	(Ljava/io/Closeable;)V
    //   220: goto -58 -> 162
    //   223: astore_1
    //   224: aload_2
    //   225: invokestatic 114	arf:a	(Ljava/io/Closeable;)V
    //   228: aload_1
    //   229: athrow
    //   230: astore_3
    //   231: aload_2
    //   232: invokestatic 114	arf:a	(Ljava/io/Closeable;)V
    //   235: aload_1
    //   236: areturn
    //   237: astore_1
    //   238: aload_2
    //   239: invokestatic 114	arf:a	(Ljava/io/Closeable;)V
    //   242: aload_1
    //   243: athrow
    //   244: astore_2
    //   245: goto -206 -> 39
    //   248: goto -86 -> 162
    //   251: iconst_0
    //   252: istore 5
    //   254: goto -164 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   74	83	196	java/lang/Exception
    //   74	83	208	finally
    //   145	154	215	java/lang/Exception
    //   145	154	223	finally
    //   181	190	230	java/lang/Exception
    //   181	190	237	finally
    //   11	39	244	java/lang/Exception
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ait
 * JD-Core Version:    0.6.2
 */