package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class uh
{
  private static long a = 0L;
  private static Handler b = new Handler(Looper.getMainLooper());

  // ERROR //
  private static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 36	java/io/FileInputStream
    //   3: dup
    //   4: new 38	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: aload_1
    //   10: invokestatic 40	uh:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   13: invokespecial 43	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 49	uh:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   24: astore_1
    //   25: aload_0
    //   26: invokestatic 52	uh:a	(Ljava/io/Closeable;)V
    //   29: aload_1
    //   30: areturn
    //   31: astore_0
    //   32: aconst_null
    //   33: astore_0
    //   34: aload_0
    //   35: invokestatic 52	uh:a	(Ljava/io/Closeable;)V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: aconst_null
    //   42: astore_2
    //   43: aload_0
    //   44: astore_1
    //   45: aload_2
    //   46: invokestatic 52	uh:a	(Ljava/io/Closeable;)V
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: aload_0
    //   53: astore_2
    //   54: goto -9 -> 45
    //   57: astore_1
    //   58: goto -24 -> 34
    //
    // Exception table:
    //   from	to	target	type
    //   0	20	31	java/lang/Exception
    //   0	20	40	finally
    //   20	25	51	finally
    //   20	25	57	java/lang/Exception
  }

  private static String a(InputStream paramInputStream)
  {
    StringWriter localStringWriter = new StringWriter();
    paramInputStream = new InputStreamReader(paramInputStream);
    char[] arrayOfChar = new char[4096];
    while (true)
    {
      int i = paramInputStream.read(arrayOfChar);
      if (-1 == i)
        break;
      localStringWriter.write(arrayOfChar, 0, i);
    }
    return localStringWriter.toString();
  }

  public static void a(Context paramContext)
  {
    c(paramContext);
  }

  public static void a(Context paramContext, final ui paramui, int paramInt)
  {
    if (paramui == null);
    final long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    }
    while ((paramui.a(paramInt)) || ((l - a < 2000L) && (l > a)));
    a = l;
    new Thread()
    {
      public void run()
      {
        uh.a(uh.this, paramui, l, this.d);
      }
    }
    .start();
  }

  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
    }
  }

  private static boolean a(Context paramContext, long paramLong)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localObject1 = localObject3;
      localObject2 = localObject4;
      localJSONObject.put("v", 1);
      if (paramLong >= 0L)
      {
        localObject1 = localObject3;
        localObject2 = localObject4;
        localJSONObject.put("s", paramLong);
      }
      localObject1 = localObject3;
      localObject2 = localObject4;
      paramContext = paramContext.openFileOutput("pl.dat", 1);
      localObject1 = paramContext;
      localObject2 = paramContext;
      paramContext.write(localJSONObject.toString().getBytes());
      a(paramContext);
      return true;
    }
    catch (Exception paramContext)
    {
      return false;
    }
    finally
    {
      a((Closeable)localObject2);
    }
    throw paramContext;
  }

  // ERROR //
  private static boolean a(Context paramContext, List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 152 1 0
    //   10: ifne +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: invokevirtual 155	android/content/Context:getPackageName	()Ljava/lang/String;
    //   19: aload_1
    //   20: iconst_0
    //   21: invokeinterface 159 2 0
    //   26: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +5 -> 34
    //   32: iconst_1
    //   33: ireturn
    //   34: aload_1
    //   35: aload_0
    //   36: invokevirtual 155	android/content/Context:getPackageName	()Ljava/lang/String;
    //   39: invokeinterface 167 2 0
    //   44: istore 4
    //   46: iload 4
    //   48: ifle +135 -> 183
    //   51: iload 4
    //   53: sipush 150
    //   56: imul
    //   57: i2l
    //   58: lstore 6
    //   60: lload 6
    //   62: invokestatic 173	java/lang/Thread:sleep	(J)V
    //   65: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   68: lstore 6
    //   70: iconst_0
    //   71: istore_3
    //   72: iload_3
    //   73: iload 4
    //   75: if_icmpge +98 -> 173
    //   78: aload_0
    //   79: aload_1
    //   80: iload_3
    //   81: invokeinterface 159 2 0
    //   86: checkcast 132	java/lang/String
    //   89: invokestatic 175	uh:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_2
    //   93: aload_2
    //   94: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: istore 10
    //   99: iload 10
    //   101: ifeq +10 -> 111
    //   104: iload_3
    //   105: iconst_1
    //   106: iadd
    //   107: istore_3
    //   108: goto -36 -> 72
    //   111: new 109	org/json/JSONObject
    //   114: dup
    //   115: aload_2
    //   116: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   119: astore_2
    //   120: aload_2
    //   121: ldc 112
    //   123: iconst_1
    //   124: invokevirtual 186	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   127: istore 5
    //   129: iload 5
    //   131: iconst_1
    //   132: if_icmple +5 -> 137
    //   135: iconst_0
    //   136: ireturn
    //   137: iload 5
    //   139: iconst_1
    //   140: if_icmplt -36 -> 104
    //   143: aload_2
    //   144: ldc 118
    //   146: invokevirtual 190	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   149: lstore 8
    //   151: lload 6
    //   153: lload 8
    //   155: lcmp
    //   156: ifle -52 -> 104
    //   159: lload 6
    //   161: lload 8
    //   163: lsub
    //   164: ldc2_w 90
    //   167: lcmp
    //   168: ifge -64 -> 104
    //   171: iconst_0
    //   172: ireturn
    //   173: aload_0
    //   174: lload 6
    //   176: invokestatic 192	uh:a	(Landroid/content/Context;J)Z
    //   179: pop
    //   180: iconst_1
    //   181: ireturn
    //   182: astore_0
    //   183: iconst_0
    //   184: ireturn
    //   185: astore_2
    //   186: goto -82 -> 104
    //
    // Exception table:
    //   from	to	target	type
    //   60	70	182	java/lang/InterruptedException
    //   78	99	182	java/lang/InterruptedException
    //   111	129	182	java/lang/InterruptedException
    //   143	151	182	java/lang/InterruptedException
    //   173	180	182	java/lang/InterruptedException
    //   111	129	185	org/json/JSONException
    //   143	151	185	org/json/JSONException
  }

  public static int b(Context paramContext)
  {
    return ((Integer) up.b(paramContext, "charge_by", Integer.valueOf(0))).intValue();
  }

  private static String b(Context paramContext, String paramString)
  {
    return "/data/data/" + paramString + "/files/" + "pl.dat";
  }

  private static void b(Context paramContext, final ui paramui, long paramLong, final int paramInt)
  {
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2 = new Intent("com.holaverse.common.POWER_CONNECTED");
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((PackageManager)localObject1).queryBroadcastReceivers((Intent)localObject2, 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ResolveInfo)((Iterator)localObject1).next();
      if (((ResolveInfo)localObject2).activityInfo != null)
        localArrayList.add(((ResolveInfo)localObject2).activityInfo.packageName);
    }
    if (a(paramContext, localArrayList))
    {
      a(paramContext, paramLong);
      b.post(new Runnable()
      {
        public void run()
        {
          up.a(uh.this, "charge_by", Integer.valueOf(paramInt));
          paramui.a();
        }
      });
    }
  }

  private static void c(Context paramContext)
  {
    try
    {
      new File(b(paramContext, paramContext.getPackageName())).delete();
      return;
    }
    catch (Exception paramContext)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     uh
 * JD-Core Version:    0.6.2
 */