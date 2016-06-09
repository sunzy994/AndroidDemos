package cmcm.com.myapplication;

import java.io.InputStream;
import java.util.List;

public class asg extends Thread
{
  final InputStream a;
  final String b;
  final List<String> c;

  asg(InputStream paramInputStream, String paramString)
  {
    this(paramInputStream, paramString, null);
  }

  asg(InputStream paramInputStream, String paramString, List<String> paramList)
  {
    this.a = paramInputStream;
    this.b = paramString;
    this.c = paramList;
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 33	java/io/BufferedReader
    //   5: dup
    //   6: new 35	java/io/InputStreamReader
    //   9: dup
    //   10: aload_0
    //   11: getfield 22	asg:a	Ljava/io/InputStream;
    //   14: invokespecial 38	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   17: invokespecial 41	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 45	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +34 -> 61
    //   30: aload_0
    //   31: getfield 26	asg:c	Ljava/util/List;
    //   34: ifnull -13 -> 21
    //   37: aload_0
    //   38: getfield 26	asg:c	Ljava/util/List;
    //   41: aload_2
    //   42: invokeinterface 51 2 0
    //   47: pop
    //   48: goto -27 -> 21
    //   51: astore_2
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokestatic 56	arf:a	(Ljava/io/Closeable;)V
    //   60: return
    //   61: aload_1
    //   62: ifnull -2 -> 60
    //   65: aload_1
    //   66: invokestatic 56	arf:a	(Ljava/io/Closeable;)V
    //   69: return
    //   70: astore_3
    //   71: aload_2
    //   72: astore_1
    //   73: aload_3
    //   74: astore_2
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokestatic 56	arf:a	(Ljava/io/Closeable;)V
    //   83: aload_2
    //   84: athrow
    //   85: astore_2
    //   86: goto -11 -> 75
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_1
    //   92: goto -40 -> 52
    //
    // Exception table:
    //   from	to	target	type
    //   21	26	51	java/io/IOException
    //   30	48	51	java/io/IOException
    //   2	21	70	finally
    //   21	26	85	finally
    //   30	48	85	finally
    //   2	21	89	java/io/IOException
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asg
 * JD-Core Version:    0.6.2
 */