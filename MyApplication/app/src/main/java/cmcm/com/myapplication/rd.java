package cmcm.com.myapplication;

import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.Loader.ForceLoadContentObserver;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Field;

public class rd extends CursorLoader
{
  private static final String a = "GameSDK." + rd.class.getSimpleName();
  private ForceLoadContentObserver b;
  private Field c;
  private re d;
  private String e;
  private String f;
  private String[] g;

  public rd(Context paramContext, String paramString1, String paramString2, String[] paramArrayOfString, re paramre)
  {
    super(paramContext);
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramArrayOfString;
    this.d = paramre;
    if (Build.VERSION.SDK_INT >= 16);
    try
    {
      this.c = rd.class.getSuperclass().getDeclaredField("mCancellationSignal");
      this.c.setAccessible(true);
    }
    catch (Throwable paramContext)
    {
      try
      {
        while (true)
        {
          paramContext = rd.class.getSuperclass().getDeclaredField("mObserver");
          paramContext.setAccessible(true);
          this.b = ((ForceLoadContentObserver)paramContext.get(this));
          return;
          paramContext = paramContext;
          Log.w(a, "Could not get the mCancellationSignal field", paramContext);
        }
      }
      catch (Throwable paramContext)
      {
        Log.w(a, "Could not get the mObserver field", paramContext);
      }
    }
  }

  // ERROR //
  public Cursor loadInBackground()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 62	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 16
    //   7: if_icmplt +47 -> 54
    //   10: aload_0
    //   11: invokevirtual 108	rd:isLoadInBackgroundCanceled	()Z
    //   14: ifeq +16 -> 30
    //   17: new 110	android/os/OperationCanceledException
    //   20: dup
    //   21: invokespecial 111	android/os/OperationCanceledException:<init>	()V
    //   24: athrow
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    //   30: aload_0
    //   31: getfield 74	rd:c	Ljava/lang/reflect/Field;
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +18 -> 54
    //   39: aload_0
    //   40: getfield 74	rd:c	Ljava/lang/reflect/Field;
    //   43: aload_0
    //   44: new 113	android/os/CancellationSignal
    //   47: dup
    //   48: invokespecial 114	android/os/CancellationSignal:<init>	()V
    //   51: invokevirtual 118	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_0
    //   57: invokevirtual 122	rd:getContext	()Landroid/content/Context;
    //   60: invokestatic 127	rn:a	(Landroid/content/Context;)Lrn;
    //   63: astore_2
    //   64: aload_0
    //   65: getfield 50	rd:e	Ljava/lang/String;
    //   68: astore_3
    //   69: aload_0
    //   70: getfield 52	rd:f	Ljava/lang/String;
    //   73: astore 4
    //   75: aload_0
    //   76: getfield 54	rd:g	[Ljava/lang/String;
    //   79: astore 5
    //   81: aload_0
    //   82: getfield 74	rd:c	Ljava/lang/reflect/Field;
    //   85: ifnull +71 -> 156
    //   88: aload_0
    //   89: getfield 74	rd:c	Ljava/lang/reflect/Field;
    //   92: aload_0
    //   93: invokevirtual 86	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: checkcast 113	android/os/CancellationSignal
    //   99: astore_1
    //   100: aload_2
    //   101: aload_3
    //   102: aload 4
    //   104: aload 5
    //   106: aload_1
    //   107: invokevirtual 130	rn:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +20 -> 132
    //   115: aload_1
    //   116: invokeinterface 136 1 0
    //   121: pop
    //   122: aload_1
    //   123: aload_0
    //   124: getfield 90	rd:b	Landroid/content/Loader$ForceLoadContentObserver;
    //   127: invokeinterface 140 2 0
    //   132: aload_0
    //   133: monitorenter
    //   134: aload_0
    //   135: getfield 74	rd:c	Ljava/lang/reflect/Field;
    //   138: astore_2
    //   139: aload_2
    //   140: ifnull +12 -> 152
    //   143: aload_0
    //   144: getfield 74	rd:c	Ljava/lang/reflect/Field;
    //   147: aload_0
    //   148: aconst_null
    //   149: invokevirtual 118	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_1
    //   155: areturn
    //   156: aconst_null
    //   157: astore_1
    //   158: goto -58 -> 100
    //   161: astore_2
    //   162: aload_1
    //   163: invokeinterface 143 1 0
    //   168: aload_2
    //   169: athrow
    //   170: astore_1
    //   171: getstatic 62	android/os/Build$VERSION:SDK_INT	I
    //   174: bipush 16
    //   176: if_icmplt +48 -> 224
    //   179: aload_1
    //   180: instanceof 110
    //   183: ifeq +41 -> 224
    //   186: getstatic 41	rd:a	Ljava/lang/String;
    //   189: ldc 145
    //   191: invokestatic 148	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   194: pop
    //   195: aload_0
    //   196: monitorenter
    //   197: aload_0
    //   198: getfield 74	rd:c	Ljava/lang/reflect/Field;
    //   201: astore_1
    //   202: aload_1
    //   203: ifnull +12 -> 215
    //   206: aload_0
    //   207: getfield 74	rd:c	Ljava/lang/reflect/Field;
    //   210: aload_0
    //   211: aconst_null
    //   212: invokevirtual 118	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   215: aload_0
    //   216: monitorexit
    //   217: aconst_null
    //   218: areturn
    //   219: astore_1
    //   220: aload_0
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    //   224: getstatic 41	rd:a	Ljava/lang/String;
    //   227: ldc 150
    //   229: aload_1
    //   230: invokestatic 98	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   233: pop
    //   234: goto -39 -> 195
    //   237: astore_1
    //   238: aload_0
    //   239: monitorenter
    //   240: aload_0
    //   241: getfield 74	rd:c	Ljava/lang/reflect/Field;
    //   244: astore_2
    //   245: aload_2
    //   246: ifnull +12 -> 258
    //   249: aload_0
    //   250: getfield 74	rd:c	Ljava/lang/reflect/Field;
    //   253: aload_0
    //   254: aconst_null
    //   255: invokevirtual 118	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   258: aload_0
    //   259: monitorexit
    //   260: aload_1
    //   261: athrow
    //   262: astore_1
    //   263: aload_0
    //   264: monitorexit
    //   265: aload_1
    //   266: athrow
    //   267: astore_1
    //   268: aload_0
    //   269: monitorexit
    //   270: aload_1
    //   271: athrow
    //   272: astore_2
    //   273: goto -15 -> 258
    //   276: astore_1
    //   277: goto -62 -> 215
    //   280: astore_2
    //   281: goto -129 -> 152
    //   284: astore_1
    //   285: goto -231 -> 54
    //
    // Exception table:
    //   from	to	target	type
    //   2	25	25	finally
    //   26	28	25	finally
    //   30	35	25	finally
    //   39	54	25	finally
    //   54	56	25	finally
    //   115	132	161	java/lang/RuntimeException
    //   56	100	170	java/lang/Throwable
    //   100	111	170	java/lang/Throwable
    //   115	132	170	java/lang/Throwable
    //   162	170	170	java/lang/Throwable
    //   134	139	219	finally
    //   143	152	219	finally
    //   152	154	219	finally
    //   220	222	219	finally
    //   56	100	237	finally
    //   100	111	237	finally
    //   115	132	237	finally
    //   162	170	237	finally
    //   171	195	237	finally
    //   224	234	237	finally
    //   197	202	262	finally
    //   206	215	262	finally
    //   215	217	262	finally
    //   263	265	262	finally
    //   240	245	267	finally
    //   249	258	267	finally
    //   258	260	267	finally
    //   268	270	267	finally
    //   249	258	272	java/lang/Throwable
    //   206	215	276	java/lang/Throwable
    //   143	152	280	java/lang/Throwable
    //   39	54	284	java/lang/Throwable
  }

  protected void onForceLoad()
  {
    try
    {
      super.onForceLoad();
      if (this.d == null);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.d.a_();
        return;
        localThrowable1 = localThrowable1;
      }
      catch (Throwable localThrowable2)
      {
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rd
 * JD-Core Version:    0.6.2
 */