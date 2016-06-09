package cmcm.com.myapplication.com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.IOException;

final class a$a
  implements NetworkCallBack
{
  private final String a;
  private final int b;

  public a$a(a parama, String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }

  // ERROR //
  private static String a(Response paramResponse, File paramFile)
  {
    // Byte code:
    //   0: ldc 31
    //   2: invokestatic 37	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore 4
    //   7: aload_0
    //   8: invokeinterface 43 1 0
    //   13: astore_0
    //   14: new 45	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: astore_3
    //   23: aload_3
    //   24: astore_2
    //   25: aload_0
    //   26: astore_1
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore 5
    //   34: aload_3
    //   35: astore_2
    //   36: aload_0
    //   37: astore_1
    //   38: aload_0
    //   39: aload 5
    //   41: invokevirtual 54	java/io/InputStream:read	([B)I
    //   44: istore 6
    //   46: iload 6
    //   48: ifle +56 -> 104
    //   51: aload_3
    //   52: astore_2
    //   53: aload_0
    //   54: astore_1
    //   55: aload 4
    //   57: aload 5
    //   59: iconst_0
    //   60: iload 6
    //   62: invokevirtual 58	java/security/MessageDigest:update	([BII)V
    //   65: aload_3
    //   66: astore_2
    //   67: aload_0
    //   68: astore_1
    //   69: aload_3
    //   70: aload 5
    //   72: iconst_0
    //   73: iload 6
    //   75: invokevirtual 61	java/io/FileOutputStream:write	([BII)V
    //   78: goto -44 -> 34
    //   81: astore 4
    //   83: aload_3
    //   84: astore_2
    //   85: aload_0
    //   86: astore_1
    //   87: ldc 63
    //   89: aload 4
    //   91: invokestatic 69	com/qq/e/comm/util/GDTLogger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload_0
    //   95: invokestatic 75	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/InputStream;)V
    //   98: aload_3
    //   99: invokestatic 78	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/OutputStream;)V
    //   102: aconst_null
    //   103: areturn
    //   104: aload_3
    //   105: astore_2
    //   106: aload_0
    //   107: astore_1
    //   108: aload_0
    //   109: invokestatic 75	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/InputStream;)V
    //   112: aload_3
    //   113: astore_2
    //   114: aload_0
    //   115: astore_1
    //   116: aload_3
    //   117: invokestatic 78	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/OutputStream;)V
    //   120: aload_3
    //   121: astore_2
    //   122: aload_0
    //   123: astore_1
    //   124: aload 4
    //   126: invokevirtual 82	java/security/MessageDigest:digest	()[B
    //   129: invokestatic 88	com/qq/e/comm/util/Md5Util:byteArrayToHexString	([B)Ljava/lang/String;
    //   132: astore 4
    //   134: aload_0
    //   135: invokestatic 75	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/InputStream;)V
    //   138: aload_3
    //   139: invokestatic 78	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/OutputStream;)V
    //   142: aload 4
    //   144: areturn
    //   145: astore 4
    //   147: aconst_null
    //   148: astore_3
    //   149: aconst_null
    //   150: astore_0
    //   151: aload_3
    //   152: astore_2
    //   153: aload_0
    //   154: astore_1
    //   155: ldc 90
    //   157: aload 4
    //   159: invokestatic 69	com/qq/e/comm/util/GDTLogger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   162: aload_0
    //   163: invokestatic 75	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/InputStream;)V
    //   166: aload_3
    //   167: invokestatic 78	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/OutputStream;)V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_3
    //   173: aconst_null
    //   174: astore_2
    //   175: aconst_null
    //   176: astore_0
    //   177: aload_0
    //   178: invokestatic 75	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/InputStream;)V
    //   181: aload_2
    //   182: invokestatic 78	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/OutputStream;)V
    //   185: aload_3
    //   186: athrow
    //   187: astore_3
    //   188: aconst_null
    //   189: astore_2
    //   190: goto -13 -> 177
    //   193: astore_3
    //   194: aload_1
    //   195: astore_0
    //   196: goto -19 -> 177
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_3
    //   203: goto -52 -> 151
    //   206: astore 4
    //   208: goto -57 -> 151
    //   211: astore 4
    //   213: aconst_null
    //   214: astore_3
    //   215: aconst_null
    //   216: astore_0
    //   217: goto -134 -> 83
    //   220: astore 4
    //   222: aconst_null
    //   223: astore_3
    //   224: goto -141 -> 83
    //
    // Exception table:
    //   from	to	target	type
    //   27	34	81	java/io/IOException
    //   38	46	81	java/io/IOException
    //   55	65	81	java/io/IOException
    //   69	78	81	java/io/IOException
    //   108	112	81	java/io/IOException
    //   116	120	81	java/io/IOException
    //   124	134	81	java/io/IOException
    //   0	14	145	java/security/NoSuchAlgorithmException
    //   0	14	172	finally
    //   14	23	187	finally
    //   27	34	193	finally
    //   38	46	193	finally
    //   55	65	193	finally
    //   69	78	193	finally
    //   87	94	193	finally
    //   108	112	193	finally
    //   116	120	193	finally
    //   124	134	193	finally
    //   155	162	193	finally
    //   14	23	199	java/security/NoSuchAlgorithmException
    //   27	34	206	java/security/NoSuchAlgorithmException
    //   38	46	206	java/security/NoSuchAlgorithmException
    //   55	65	206	java/security/NoSuchAlgorithmException
    //   69	78	206	java/security/NoSuchAlgorithmException
    //   108	112	206	java/security/NoSuchAlgorithmException
    //   116	120	206	java/security/NoSuchAlgorithmException
    //   124	134	206	java/security/NoSuchAlgorithmException
    //   0	14	211	java/io/IOException
    //   14	23	220	java/io/IOException
  }

  private boolean a(File paramFile)
  {
    String str = this.b + "#####" + this.a;
    try
    {
      StringUtil.writeTo(str, paramFile);
      return true;
    }
    catch (IOException paramFile)
    {
      GDTLogger.e("IOException While Update Plugin", paramFile);
    }
    return false;
  }

  public final void onException(Exception paramException)
  {
    GDTLogger.w("Exception While Update Plugin", paramException);
  }

  public final void onResponse(Request paramRequest, Response paramResponse)
  {
    if (paramResponse.getStatusCode() == 200)
      try
      {
        paramRequest = new File(a.a(this.c).getDir("e_qq_com_plugin", 0), "gdt_plugin.tmp");
        File localFile = new File(a.a(this.c).getDir("e_qq_com_plugin", 0), "gdt_plugin.tmp.sig");
        paramResponse = a(paramResponse, paramRequest);
        if (com.qq.e.comm.util.a.a().b(this.a, paramResponse))
          if ((a(localFile)) && (FileUtil.renameTo(paramRequest, c.b(a.a(this.c)))))
          {
            boolean bool = FileUtil.renameTo(localFile, c.d(a.a(this.c)));
            if (!bool);
          }
        while (true)
        {
          return;
          paramRequest.delete();
          GDTLogger.report(String.format("Fail to update plugin while verifying,sig=%s,md5=%s", new Object[] { this.a, paramResponse }));
        }
      }
      catch (Throwable paramRequest)
      {
        GDTLogger.e("UnknownException While Update Plugin", paramRequest);
        return;
      }
      finally
      {
        GDTLogger.d("TIMESTAMP_AFTER_DOWNPLUGIN:" + System.nanoTime() + ";sig=" + this.a);
      }
    GDTLogger.report("DownLoad Plugin Jar Status error,response status code=" + paramResponse.getStatusCode());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.managers.plugin.a.a
 * JD-Core Version:    0.6.2
 */