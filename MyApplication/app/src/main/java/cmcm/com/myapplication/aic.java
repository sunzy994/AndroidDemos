package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.AssetManager;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class aic
{
  private static final String a = "Swipe." + aic.class.getSimpleName();

  private static File a(String paramString, boolean paramBoolean)
  {
    return new File(new File(aro.c(), "themes"), arh.a(b(paramString, paramBoolean)));
  }

  public static String a(ahw paramahw)
  {
    return b(paramahw.g, false);
  }

  private static String a(Context paramContext)
  {
    switch (vs.a(paramContext, "key_theme", 0))
    {
    case 3:
    case 4:
    case 13:
    case 14:
    default:
      return "purple";
    case 0:
      return "purple";
    case 1:
      return "white";
    case 2:
      return "yellow";
    case 5:
      return "red";
    case 6:
      return "blue";
    case 7:
      return "green";
    case 8:
      return "technical";
    case 9:
      return "iwatch";
    case 10:
      return "black";
    case 11:
      return "purple";
    case 12:
      return "starwar";
    case 15:
      return "xmas2015";
    case 16:
      return "xmas2015_2";
    case 17:
      return "valentine_2016_1";
    case 18:
    }
    return "valentine_2016_2";
  }

  public static String a(String paramString)
  {
    String str;
    if ("halloween2015".equals(paramString))
      str = "halloween";
    do
    {
      return str;
      if ("xmas2015".equals(paramString))
        return "xmas";
      str = paramString;
    }
    while (!"xmas2015_2".equals(paramString));
    return "xmas_2";
  }

  public static void a()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        aic.c("starwar");
        aic.c("xmas2015");
        aic.c("xmas2015_2");
        aic.d("halloween2015");
        Iterator localIterator = ahq.a(SwipeApplication.c()).iterator();
        while (localIterator.hasNext())
          aic.e(((ahw)localIterator.next()).g);
        aic.b();
      }
    }).start();
  }

  // ERROR //
  private static void a(String paramString1, String paramString2, AssetManager paramAssetManager, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_2
    //   4: new 12	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   11: ldc 127
    //   13: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokestatic 128	aic:a	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 130
    //   25: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_3
    //   29: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokevirtual 136	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore_0
    //   39: aload_0
    //   40: astore 4
    //   42: new 37	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: aload_3
    //   48: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: astore_1
    //   52: aload_0
    //   53: astore 4
    //   55: aload_1
    //   56: invokevirtual 143	java/io/File:exists	()Z
    //   59: ifeq +11 -> 70
    //   62: aload_0
    //   63: astore 4
    //   65: aload_1
    //   66: invokestatic 149	aqx:e	(Ljava/io/File;)Z
    //   69: pop
    //   70: aload_0
    //   71: astore 4
    //   73: aload_0
    //   74: aload_1
    //   75: invokestatic 152	aqx:a	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   78: pop
    //   79: aload_0
    //   80: invokestatic 157	arf:a	(Ljava/io/Closeable;)V
    //   83: return
    //   84: astore_0
    //   85: aload 4
    //   87: invokestatic 157	arf:a	(Ljava/io/Closeable;)V
    //   90: return
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_2
    //   94: aload_0
    //   95: astore_1
    //   96: aload_2
    //   97: invokestatic 157	arf:a	(Ljava/io/Closeable;)V
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: aload_0
    //   104: astore_2
    //   105: goto -9 -> 96
    //
    // Exception table:
    //   from	to	target	type
    //   3	39	84	java/lang/Exception
    //   42	52	84	java/lang/Exception
    //   55	62	84	java/lang/Exception
    //   65	70	84	java/lang/Exception
    //   73	79	84	java/lang/Exception
    //   3	39	91	finally
    //   42	52	102	finally
    //   55	62	102	finally
    //   65	70	102	finally
    //   73	79	102	finally
  }

  public static long b(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 1469661021:
    case 113101865:
    case -734239628:
    case 112785:
    case 3027034:
    case 98619139:
    case -1176003066:
    case 93818879:
    case -976943172:
    }
    while (true)
      switch (i)
      {
      default:
        return 0L;
        if (paramString.equals("technical"))
        {
          i = 0;
          continue;
          if (paramString.equals("white"))
          {
            i = 1;
            continue;
            if (paramString.equals("yellow"))
            {
              i = 2;
              continue;
              if (paramString.equals("red"))
              {
                i = 3;
                continue;
                if (paramString.equals("blue"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("green"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("iwatch"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("black"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("purple"))
                          i = 8;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      }
    return 9L;
    return 2L;
    return 6L;
    return 7L;
    return 3L;
    return 5L;
    return 8L;
    return 4L;
    return System.currentTimeMillis();
  }

  private static String b(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("http://res.lazyswipe.cn/themes/").append(aqs.b(SwipeApplication.c(), 720)).append('/').append(j(paramString));
    if (paramBoolean);
    for (paramString = ".png"; ; paramString = ".jpg")
      return paramString;
  }

  public static void b()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    ahx.a(localSwipeApplication, a(localSwipeApplication)).y();
  }

  private static void f(String paramString)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (vs.c(localSwipeApplication, "migrate_theme_" + paramString, false))
      return;
    Object localObject2 = aro.d() + "/files/" + a(paramString) + ".zip";
    Object localObject1 = aro.d() + "/files/themes/" + a(paramString);
    localObject2 = new File((String)localObject2);
    File localFile = new File((String)localObject1);
    if (((File)localObject2).exists())
      aqx.e((File) localObject2);
    if (localFile.exists())
    {
      localObject2 = localSwipeApplication.getAssets();
      a(paramString, (String)localObject1, (AssetManager)localObject2, "color.json");
      a(paramString, (String)localObject1, (AssetManager)localObject2, "info.json");
    }
    localObject2 = i(paramString);
    if (((File)localObject2).exists())
    {
      localObject1 = new File((String)localObject1, "preview.jpg");
      if (!((File)localObject1).exists())
        aqx.c((File) localObject2, (File) localObject1);
    }
    vs.b(localSwipeApplication, "migrate_theme_" + paramString, true);
  }

  private static void g(String paramString)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (vs.c(localSwipeApplication, "migrate_theme_" + paramString, false))
      return;
    Object localObject2 = aro.d() + "/files/" + a(paramString) + ".zip";
    Object localObject1 = aro.d() + "/files/themes/" + a(paramString);
    localObject2 = new File((String)localObject2);
    localObject1 = new File((String)localObject1);
    if (((File)localObject2).exists())
      aqx.e((File) localObject2);
    if (((File)localObject1).exists())
      aqx.e((File) localObject1);
    vs.b(localSwipeApplication, "migrate_theme_" + paramString, true);
  }

  private static void h(String paramString)
  {
    File localFile = i(paramString);
    paramString = new File(aro.d() + "/files/themes/builtin", "preview_" + paramString + ".jpg");
    if ((localFile.exists()) && (!paramString.exists()))
    {
      if (!paramString.getParentFile().exists())
        paramString.getParentFile().mkdirs();
      aqx.c(localFile, paramString);
    }
  }

  private static File i(String paramString)
  {
    File localFile = a(paramString, false);
    if (localFile.exists())
      return localFile;
    return a(paramString, true);
  }

  private static String j(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 1469661021:
    case 113101865:
    case -734239628:
    case 112785:
    case 3027034:
    case 98619139:
    case -1176003066:
    case 93818879:
    case -976943172:
    case -1897182378:
    case -477734071:
    case 459061436:
    }
    while (true)
      switch (i)
      {
      default:
        return "";
        if (paramString.equals("technical"))
        {
          i = 0;
          continue;
          if (paramString.equals("white"))
          {
            i = 1;
            continue;
            if (paramString.equals("yellow"))
            {
              i = 2;
              continue;
              if (paramString.equals("red"))
              {
                i = 3;
                continue;
                if (paramString.equals("blue"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("green"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("iwatch"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("black"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("purple"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("starwar"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("xmas2015"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("xmas2015_2"))
                                i = 11;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
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
      }
    return "technical";
    return "white";
    return "yellow";
    return "red";
    return "blue";
    return "green";
    return "iwatch";
    return "black";
    return "purple";
    return "starwar";
    return "xmas2015";
    return "xmas2015_2";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aic
 * JD-Core Version:    0.6.2
 */