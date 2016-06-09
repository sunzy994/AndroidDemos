package cmcm.com.myapplication;

import android.os.Process;
import android.text.TextUtils;
import com.lazyswipe.util.PsProcess;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class ase
{
  public static asf a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(new String[] { paramString }, paramBoolean1, paramBoolean2);
  }

  // ERROR //
  public static asf a(String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 14
    //   3: aload_0
    //   4: ifnull +8 -> 12
    //   7: aload_0
    //   8: arraylength
    //   9: ifne +14 -> 23
    //   12: new 16	asf
    //   15: dup
    //   16: iconst_m1
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokespecial 20	asf:<init>	(ILjava/util/List;Ljava/util/List;)V
    //   22: areturn
    //   23: new 22	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 25	java/util/ArrayList:<init>	()V
    //   30: astore 12
    //   32: invokestatic 31	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   35: astore 4
    //   37: iload_1
    //   38: ifeq +120 -> 158
    //   41: ldc 33
    //   43: astore_3
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 37	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   50: astore 6
    //   52: new 39	asg
    //   55: dup
    //   56: aload 6
    //   58: invokevirtual 45	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   61: ldc 47
    //   63: invokespecial 50	asg:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   66: astore 7
    //   68: new 39	asg
    //   71: dup
    //   72: aload 6
    //   74: invokevirtual 53	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   77: ldc 55
    //   79: aload 12
    //   81: invokespecial 58	asg:<init>	(Ljava/io/InputStream;Ljava/lang/String;Ljava/util/List;)V
    //   84: astore 5
    //   86: aload 7
    //   88: invokevirtual 61	asg:start	()V
    //   91: aload 5
    //   93: invokevirtual 61	asg:start	()V
    //   96: new 63	java/io/DataOutputStream
    //   99: dup
    //   100: aload 6
    //   102: invokevirtual 67	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   105: invokespecial 70	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   108: astore_3
    //   109: aload 5
    //   111: astore 11
    //   113: aload 7
    //   115: astore 10
    //   117: aload_3
    //   118: astore 9
    //   120: aload 6
    //   122: astore 8
    //   124: aload_0
    //   125: arraylength
    //   126: istore 15
    //   128: iconst_0
    //   129: istore 13
    //   131: iload 13
    //   133: iload 15
    //   135: if_icmpge +211 -> 346
    //   138: aload_0
    //   139: iload 13
    //   141: aaload
    //   142: astore 4
    //   144: aload 4
    //   146: ifnonnull +18 -> 164
    //   149: iload 13
    //   151: iconst_1
    //   152: iadd
    //   153: istore 13
    //   155: goto -24 -> 131
    //   158: ldc 72
    //   160: astore_3
    //   161: goto -117 -> 44
    //   164: aload 5
    //   166: astore 11
    //   168: aload 7
    //   170: astore 10
    //   172: aload_3
    //   173: astore 9
    //   175: aload 6
    //   177: astore 8
    //   179: aload_3
    //   180: aload 4
    //   182: ldc 74
    //   184: invokevirtual 78	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   187: invokevirtual 82	java/io/DataOutputStream:write	([B)V
    //   190: aload 5
    //   192: astore 11
    //   194: aload 7
    //   196: astore 10
    //   198: aload_3
    //   199: astore 9
    //   201: aload 6
    //   203: astore 8
    //   205: aload_3
    //   206: ldc 84
    //   208: ldc 74
    //   210: invokevirtual 78	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   213: invokevirtual 82	java/io/DataOutputStream:write	([B)V
    //   216: aload 5
    //   218: astore 11
    //   220: aload 7
    //   222: astore 10
    //   224: aload_3
    //   225: astore 9
    //   227: aload 6
    //   229: astore 8
    //   231: aload_3
    //   232: invokevirtual 87	java/io/DataOutputStream:flush	()V
    //   235: goto -86 -> 149
    //   238: astore 4
    //   240: aload 5
    //   242: astore 11
    //   244: aload 7
    //   246: astore 10
    //   248: aload_3
    //   249: astore 9
    //   251: aload 6
    //   253: astore 8
    //   255: ldc 89
    //   257: new 91	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   264: ldc 94
    //   266: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_0
    //   270: ldc 100
    //   272: invokestatic 105	asi:a	([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   275: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: aload 4
    //   283: invokestatic 115	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   286: pop
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 118	java/io/DataOutputStream:close	()V
    //   295: aload 7
    //   297: ifnull +8 -> 305
    //   300: aload 7
    //   302: invokevirtual 121	asg:join	()V
    //   305: aload 5
    //   307: ifnull +8 -> 315
    //   310: aload 5
    //   312: invokevirtual 121	asg:join	()V
    //   315: iload 14
    //   317: istore 13
    //   319: aload 6
    //   321: ifnull +12 -> 333
    //   324: aload 6
    //   326: invokevirtual 124	java/lang/Process:destroy	()V
    //   329: iload 14
    //   331: istore 13
    //   333: new 16	asf
    //   336: dup
    //   337: iload 13
    //   339: aload 12
    //   341: aconst_null
    //   342: invokespecial 20	asf:<init>	(ILjava/util/List;Ljava/util/List;)V
    //   345: areturn
    //   346: aload 5
    //   348: astore 11
    //   350: aload 7
    //   352: astore 10
    //   354: aload_3
    //   355: astore 9
    //   357: aload 6
    //   359: astore 8
    //   361: aload_3
    //   362: ldc 126
    //   364: ldc 74
    //   366: invokevirtual 78	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   369: invokevirtual 82	java/io/DataOutputStream:write	([B)V
    //   372: aload 5
    //   374: astore 11
    //   376: aload 7
    //   378: astore 10
    //   380: aload_3
    //   381: astore 9
    //   383: aload 6
    //   385: astore 8
    //   387: aload_3
    //   388: invokevirtual 87	java/io/DataOutputStream:flush	()V
    //   391: aload 5
    //   393: astore 11
    //   395: aload 7
    //   397: astore 10
    //   399: aload_3
    //   400: astore 9
    //   402: aload 6
    //   404: astore 8
    //   406: aload 6
    //   408: invokevirtual 130	java/lang/Process:waitFor	()I
    //   411: istore 13
    //   413: iload 13
    //   415: istore 14
    //   417: aload_3
    //   418: ifnull +7 -> 425
    //   421: aload_3
    //   422: invokevirtual 118	java/io/DataOutputStream:close	()V
    //   425: aload 7
    //   427: ifnull +8 -> 435
    //   430: aload 7
    //   432: invokevirtual 121	asg:join	()V
    //   435: aload 5
    //   437: ifnull +8 -> 445
    //   440: aload 5
    //   442: invokevirtual 121	asg:join	()V
    //   445: iload 14
    //   447: istore 13
    //   449: aload 6
    //   451: ifnull -118 -> 333
    //   454: aload 6
    //   456: invokevirtual 124	java/lang/Process:destroy	()V
    //   459: iload 14
    //   461: istore 13
    //   463: goto -130 -> 333
    //   466: astore_0
    //   467: aconst_null
    //   468: astore_3
    //   469: aconst_null
    //   470: astore 5
    //   472: aconst_null
    //   473: astore 4
    //   475: aconst_null
    //   476: astore 6
    //   478: aload 4
    //   480: ifnull +8 -> 488
    //   483: aload 4
    //   485: invokevirtual 118	java/io/DataOutputStream:close	()V
    //   488: aload 5
    //   490: ifnull +8 -> 498
    //   493: aload 5
    //   495: invokevirtual 121	asg:join	()V
    //   498: aload_3
    //   499: ifnull +7 -> 506
    //   502: aload_3
    //   503: invokevirtual 121	asg:join	()V
    //   506: aload 6
    //   508: ifnull +8 -> 516
    //   511: aload 6
    //   513: invokevirtual 124	java/lang/Process:destroy	()V
    //   516: aload_0
    //   517: athrow
    //   518: astore_3
    //   519: goto -13 -> 506
    //   522: astore_0
    //   523: aconst_null
    //   524: astore_3
    //   525: aconst_null
    //   526: astore 5
    //   528: aconst_null
    //   529: astore 4
    //   531: goto -53 -> 478
    //   534: astore_0
    //   535: aconst_null
    //   536: astore_3
    //   537: aconst_null
    //   538: astore 4
    //   540: aload 7
    //   542: astore 5
    //   544: goto -66 -> 478
    //   547: astore_0
    //   548: aconst_null
    //   549: astore 4
    //   551: aload 5
    //   553: astore_3
    //   554: aload 7
    //   556: astore 5
    //   558: goto -80 -> 478
    //   561: astore_0
    //   562: aload 11
    //   564: astore_3
    //   565: aload 10
    //   567: astore 5
    //   569: aload 9
    //   571: astore 4
    //   573: aload 8
    //   575: astore 6
    //   577: goto -99 -> 478
    //   580: astore_0
    //   581: goto -266 -> 315
    //   584: astore 4
    //   586: aconst_null
    //   587: astore 5
    //   589: aconst_null
    //   590: astore 7
    //   592: aconst_null
    //   593: astore_3
    //   594: aconst_null
    //   595: astore 6
    //   597: goto -357 -> 240
    //   600: astore 4
    //   602: aconst_null
    //   603: astore 5
    //   605: aconst_null
    //   606: astore 7
    //   608: aconst_null
    //   609: astore_3
    //   610: goto -370 -> 240
    //   613: astore 4
    //   615: aconst_null
    //   616: astore 5
    //   618: aconst_null
    //   619: astore_3
    //   620: goto -380 -> 240
    //   623: astore 4
    //   625: aconst_null
    //   626: astore_3
    //   627: goto -387 -> 240
    //   630: astore_0
    //   631: goto -186 -> 445
    //
    // Exception table:
    //   from	to	target	type
    //   124	128	238	java/lang/Throwable
    //   179	190	238	java/lang/Throwable
    //   205	216	238	java/lang/Throwable
    //   231	235	238	java/lang/Throwable
    //   361	372	238	java/lang/Throwable
    //   387	391	238	java/lang/Throwable
    //   406	413	238	java/lang/Throwable
    //   32	37	466	finally
    //   44	52	466	finally
    //   483	488	518	java/lang/Throwable
    //   493	498	518	java/lang/Throwable
    //   502	506	518	java/lang/Throwable
    //   52	68	522	finally
    //   68	86	534	finally
    //   86	109	547	finally
    //   124	128	561	finally
    //   179	190	561	finally
    //   205	216	561	finally
    //   231	235	561	finally
    //   255	287	561	finally
    //   361	372	561	finally
    //   387	391	561	finally
    //   406	413	561	finally
    //   291	295	580	java/lang/Throwable
    //   300	305	580	java/lang/Throwable
    //   310	315	580	java/lang/Throwable
    //   32	37	584	java/lang/Throwable
    //   44	52	584	java/lang/Throwable
    //   52	68	600	java/lang/Throwable
    //   68	86	613	java/lang/Throwable
    //   86	109	623	java/lang/Throwable
    //   421	425	630	java/lang/Throwable
    //   430	435	630	java/lang/Throwable
    //   440	445	630	java/lang/Throwable
  }

  public static String a(boolean paramBoolean)
  {
    return a(f(), paramBoolean);
  }

  private static String a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = 2147483647;
    int j = paramArrayOfInt.length - 1;
    Object localObject1 = null;
    if (j >= 0)
    {
      int k = paramArrayOfInt[j];
      Object localObject2 = aqx.c(String.format("/proc/%d/cgroup", new Object[] { Integer.valueOf(k) }));
      if (TextUtils.isEmpty((CharSequence)localObject2));
      while (true)
      {
        j -= 1;
        break;
        localObject2 = ((String)localObject2).split("\n");
        if (localObject2.length == 2)
        {
          Object localObject3 = localObject2[0];
          if ((localObject2[1].endsWith(Integer.toString(k))) && (!localObject3.endsWith("bg_non_interactive")))
          {
            localObject2 = new File(String.format("/proc/%d/oom_score_adj", new Object[] { Integer.valueOf(k) }));
            if ((!((File)localObject2).canRead()) || (Integer.parseInt(aqx.d(((File)localObject2).getAbsolutePath())) == 0))
            {
              localObject2 = aqx.d(String.format("/proc/%d/cmdline", new Object[] { Integer.valueOf(k) }));
              if (!((String)localObject2).contains("com.android.systemui"))
                if ((!paramBoolean) || (!((String)localObject2).contains(":")))
                {
                  k = Integer.parseInt(aqx.d(String.format("/proc/%d/oom_score", new Object[] { Integer.valueOf(k) })));
                  if (k < i)
                  {
                    if (k == 0)
                      return localObject2;
                    localObject1 = localObject2;
                    i = k;
                  }
                }
            }
          }
        }
      }
    }
    return localObject1;
  }

  public static void a(int paramInt)
  {
    a(String.format(Locale.US, "input keyevent %d", new Object[] { Integer.valueOf(paramInt) }), true, false);
  }

  public static boolean a()
  {
    return a("echo root", true, false).a == 0;
  }

  public static void b()
  {
    c();
  }

  public static void c()
  {
    a(26);
  }

  public static void d()
  {
    a(4);
  }

  public static List<PsProcess> e()
  {
    asf localasf = a("toolbox ps -p -P -x -c", false, true);
    int j;
    if (localasf.b != null)
    {
      j = localasf.b.size() - 1;
      if (j > 0);
    }
    else
    {
      return new ArrayList(0);
    }
    ArrayList localArrayList = new ArrayList(j);
    int k = Process.myPid();
    int i = 1;
    while (true)
    {
      if (i <= j)
      {
        Object localObject = (String)localasf.b.get(i);
        try
        {
          localObject = new PsProcess((String)localObject);
          if ((!((PsProcess)localObject).a.matches("u\\d+_a\\d+")) || (((PsProcess)localObject).d == k) || (((PsProcess)localObject).p.equals("toolbox")))
            break label143;
          localArrayList.add(localObject);
        }
        catch (Exception localException)
        {
        }
      }
      else
      {
        return localArrayList;
      }
      label143: i += 1;
    }
  }

  public static int[] f()
  {
    asf localasf = a("toolbox ps -p -P -x -c", false, true);
    int k;
    if (localasf.b != null)
    {
      k = localasf.b.size() - 1;
      if (k > 0);
    }
    else
    {
      return new int[0];
    }
    int[] arrayOfInt = new int[k];
    int j = 0;
    int i = 1;
    while (true)
    {
      String str;
      if (i <= k)
        str = (String)localasf.b.get(i);
      try
      {
        arrayOfInt[j] = PsProcess.a(str);
        label75: j += 1;
        i += 1;
        continue;
        Arrays.sort(arrayOfInt);
        return arrayOfInt;
      }
      catch (Exception localException)
      {
        break label75;
      }
    }
  }

  public static String g()
  {
    return a(true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ase
 * JD-Core Version:    0.6.2
 */