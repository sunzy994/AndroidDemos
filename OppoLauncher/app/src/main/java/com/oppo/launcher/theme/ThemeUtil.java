package com.oppo.launcher.theme;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.color.uiengine.AppsIconsHelper;
import com.oppo.launcher.LauncherUtil;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ThemeUtil
{
  public static final boolean DEBUG = LauncherUtil.LAUNCHER_QE_ASSERT_DEBUG;
  private static final String ENGINE_HELPER_CLASS_NAME = "com.color.uiengine.AppsIconsHelper";
  private static final String ENGINE_PACKAGE_NAME = "com.color.uiengine";
  public static final String ICONS = "icons";
  public static final String LAUNCHER = "com.oppo.launcher";
  private static final String PATH_FANCY_ICON_SUBFOLDER = "fancy_icons/";
  public static final String TAG = "ThemeUtil";
  private static boolean mHasApplicationChecked = false;
  private static int mNeedLoadUIEngineFlag = 0;
  private static Constructor<?> mUIEngineConstructor = null;
  private static int sDefaultThemeFlag = 0;

  public static void checkInitColorUIEngine(Context paramContext)
  {
    if (!mHasApplicationChecked)
    {
      mNeedLoadUIEngineFlag = 0;
      sDefaultThemeFlag = 0;
      if ((mUIEngineConstructor == null) && (needLoadUIEngine()));
      try
      {
        Field localField = ClassLoader.class.getDeclaredField("parent");
        localField.setAccessible(true);
        Context localContext = paramContext.createPackageContext("com.color.uiengine", 3);
        localField.set(paramContext.getClassLoader(), localContext.getClassLoader());
        mUIEngineConstructor = localContext.getClassLoader().loadClass("com.color.uiengine.AppsIconsHelper").getConstructor(new Class[0]);
        if (DEBUG)
          Log.d("ThemeUtil", "checkInitColorUIEngine(), load engine end.");
        return;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.e("ThemeUtil", "initEngineContext(), NameNotFoundException error.");
        return;
      }
      catch (NoSuchFieldException paramContext)
      {
        Log.e("ThemeUtil", "initEngineContext(), NoSuchFieldException error.");
        return;
      }
      catch (IllegalAccessException paramContext)
      {
        Log.e("ThemeUtil", "initEngineContext(), IllegalAccessException error.");
        return;
      }
      catch (NoSuchMethodException paramContext)
      {
        Log.e("ThemeUtil", "initEngineContext(),NoSuchMethodException error.");
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        Log.e("ThemeUtil", "initEngineContext(),ClassNotFoundException error.");
        return;
      }
    }
    mHasApplicationChecked = false;
  }

  public static AppsIconsHelper createAppsIconsHelper()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (needLoadUIEngine())
    {
      localObject1 = localObject2;
      if (mUIEngineConstructor == null);
    }
    try
    {
      localObject1 = (AppsIconsHelper)mUIEngineConstructor.newInstance(new Object[0]);
      return localObject1;
    }
    catch (InstantiationException localInstantiationException)
    {
      Log.e("ThemeUtil", "loadAppsIconsHelper(),InstantiationException error.");
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.e("ThemeUtil", "loadAppsIconsHelper(),IllegalAccessException error.");
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.e("ThemeUtil", "loadAppsIconsHelper(),InvocationTargetException error.");
    }
    return null;
  }

  public static boolean isDefaultTheme()
  {
    int i = -1;
    if (sDefaultThemeFlag == 0)
    {
      if (new File("/data/theme/icons").exists())
        break label81;
      if (!new File("/data/theme/com.oppo.launcher").exists())
        i = 1;
      sDefaultThemeFlag = i;
      myLog("isDefaultTheme  ICONS not exist ! ");
    }
    while (true)
    {
      myLog("isDefaultTheme  sDefaultThemeFlag = " + sDefaultThemeFlag);
      if (sDefaultThemeFlag <= 0)
        break;
      return true;
      label81: sDefaultThemeFlag = -1;
    }
    return false;
  }

  public static void myLog(String paramString)
  {
    if (DEBUG)
      Log.d("ThemeUtil", paramString);
  }

  // ERROR //
  private static boolean needLoadUIEngine()
  {
    // Byte code:
    //   0: getstatic 43	com/oppo/launcher/theme/ThemeUtil:mNeedLoadUIEngineFlag	I
    //   3: ifne +87 -> 90
    //   6: iconst_1
    //   7: putstatic 43	com/oppo/launcher/theme/ThemeUtil:mNeedLoadUIEngineFlag	I
    //   10: invokestatic 188	com/oppo/launcher/theme/ThemeUtil:isDefaultTheme	()Z
    //   13: ifne +44 -> 57
    //   16: aconst_null
    //   17: astore_3
    //   18: aconst_null
    //   19: astore_0
    //   20: aconst_null
    //   21: astore_2
    //   22: new 190	java/util/zip/ZipFile
    //   25: dup
    //   26: ldc 153
    //   28: invokespecial 191	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +12 -> 45
    //   36: aload_1
    //   37: ldc 22
    //   39: invokevirtual 195	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   42: ifnonnull +7 -> 49
    //   45: iconst_m1
    //   46: putstatic 43	com/oppo/launcher/theme/ThemeUtil:mNeedLoadUIEngineFlag	I
    //   49: aload_1
    //   50: ifnull +7 -> 57
    //   53: aload_1
    //   54: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   57: getstatic 41	com/oppo/launcher/theme/ThemeUtil:DEBUG	Z
    //   60: ifeq +30 -> 90
    //   63: ldc 25
    //   65: new 168	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   72: ldc 200
    //   74: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: getstatic 43	com/oppo/launcher/theme/ThemeUtil:mNeedLoadUIEngineFlag	I
    //   80: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 115	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   89: pop
    //   90: getstatic 43	com/oppo/launcher/theme/ThemeUtil:mNeedLoadUIEngineFlag	I
    //   93: ifle +124 -> 217
    //   96: iconst_1
    //   97: ireturn
    //   98: astore_0
    //   99: ldc 25
    //   101: ldc 202
    //   103: invokestatic 115	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   106: pop
    //   107: goto -50 -> 57
    //   110: astore_0
    //   111: aload_2
    //   112: astore_1
    //   113: aload_1
    //   114: astore_0
    //   115: ldc 25
    //   117: ldc 204
    //   119: invokestatic 115	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   122: pop
    //   123: aload_1
    //   124: astore_0
    //   125: iconst_m1
    //   126: putstatic 43	com/oppo/launcher/theme/ThemeUtil:mNeedLoadUIEngineFlag	I
    //   129: aload_1
    //   130: ifnull -73 -> 57
    //   133: aload_1
    //   134: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   137: goto -80 -> 57
    //   140: astore_0
    //   141: ldc 25
    //   143: ldc 202
    //   145: invokestatic 115	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   148: pop
    //   149: goto -92 -> 57
    //   152: astore_0
    //   153: aload_3
    //   154: astore_1
    //   155: aload_1
    //   156: astore_0
    //   157: ldc 25
    //   159: ldc 206
    //   161: invokestatic 115	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   164: pop
    //   165: aload_1
    //   166: astore_0
    //   167: iconst_m1
    //   168: putstatic 43	com/oppo/launcher/theme/ThemeUtil:mNeedLoadUIEngineFlag	I
    //   171: aload_1
    //   172: ifnull -115 -> 57
    //   175: aload_1
    //   176: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   179: goto -122 -> 57
    //   182: astore_0
    //   183: ldc 25
    //   185: ldc 202
    //   187: invokestatic 115	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   190: pop
    //   191: goto -134 -> 57
    //   194: astore_1
    //   195: aload_0
    //   196: ifnull +7 -> 203
    //   199: aload_0
    //   200: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   203: aload_1
    //   204: athrow
    //   205: astore_0
    //   206: ldc 25
    //   208: ldc 202
    //   210: invokestatic 115	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   213: pop
    //   214: goto -11 -> 203
    //   217: iconst_0
    //   218: ireturn
    //   219: astore_2
    //   220: aload_1
    //   221: astore_0
    //   222: aload_2
    //   223: astore_1
    //   224: goto -29 -> 195
    //   227: astore_0
    //   228: goto -73 -> 155
    //   231: astore_0
    //   232: goto -119 -> 113
    //
    // Exception table:
    //   from	to	target	type
    //   53	57	98	java/io/IOException
    //   22	32	110	java/io/FileNotFoundException
    //   133	137	140	java/io/IOException
    //   22	32	152	java/io/IOException
    //   175	179	182	java/io/IOException
    //   22	32	194	finally
    //   115	123	194	finally
    //   125	129	194	finally
    //   157	165	194	finally
    //   167	171	194	finally
    //   199	203	205	java/io/IOException
    //   36	45	219	finally
    //   45	49	219	finally
    //   36	45	227	java/io/IOException
    //   45	49	227	java/io/IOException
    //   36	45	231	java/io/FileNotFoundException
    //   45	49	231	java/io/FileNotFoundException
  }

  public static void setApplicationChecked()
  {
    mHasApplicationChecked = true;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.theme.ThemeUtil
 * JD-Core Version:    0.6.2
 */