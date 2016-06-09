package cmcm.com.myapplication;

import android.net.Uri;
import android.text.TextUtils;
import com.lazyswipe.SwipeApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class asi
{
  public static char a(int paramInt)
  {
    return (char)(paramInt + 97);
  }

  public static char a(int paramInt, boolean paramBoolean)
  {
    try
    {
      String str2 = SwipeApplication.c().getPackageName();
      String str1 = str2;
      if (paramBoolean)
        str1 = str2.toUpperCase();
      char c = str1.charAt(paramInt);
      return c;
    }
    catch (Exception localException)
    {
    }
    return 'a';
  }

  public static float a(String paramString, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString))
      return paramFloat;
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (NumberFormatException paramString)
    {
    }
    return paramFloat;
  }

  public static int a(String paramString, int paramInt)
  {
    if (paramString == null)
      return paramInt;
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
    }
    return paramInt;
  }

  public static long a(String paramString, long paramLong)
  {
    if (paramString == null)
      return paramLong;
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
    }
    return paramLong;
  }

  public static String a(String paramString)
  {
    if (paramString == null)
      return null;
    int i = 0;
    while (true)
    {
      if ((i >= paramString.length()) || ((!Character.isWhitespace(paramString.charAt(i))) && (!Character.isSpaceChar(paramString.charAt(i))) && (paramString.charAt(i) != '　')))
      {
        if (i != paramString.length())
          break;
        return "";
      }
      i += 1;
    }
    int j = paramString.length() - 1;
    while (true)
    {
      if ((j < 0) || ((!Character.isWhitespace(paramString.charAt(j))) && (!Character.isSpaceChar(paramString.charAt(j))) && (paramString.charAt(j) != '　')))
        return paramString.substring(i, j + 1);
      j -= 1;
    }
  }

  public static String a(Collection<? extends Object> paramCollection, char paramChar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    paramCollection = paramCollection.iterator();
    if (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if (i == 0)
        localStringBuilder.append(paramChar);
      while (true)
      {
        a(localStringBuilder, localObject, paramChar);
        break;
        i = 0;
      }
    }
    return localStringBuilder.toString();
  }

  public static String a(Collection<? extends Object> paramCollection, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    Iterator localIterator = paramCollection.iterator();
    if (localIterator.hasNext())
    {
      paramCollection = localIterator.next();
      if (i == 0)
      {
        localStringBuilder.append(paramString);
        label45: if (paramCollection != null)
          break label67;
      }
      label67: for (paramCollection = ""; ; paramCollection = paramCollection.toString())
      {
        localStringBuilder.append(paramCollection);
        break;
        i = 0;
        break label45;
      }
    }
    return localStringBuilder.toString();
  }

  public static String a(Object[] paramArrayOfObject, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    int k = paramArrayOfObject.length;
    int j = 0;
    if (j < k)
    {
      Object localObject = paramArrayOfObject[j];
      if (i == 0)
      {
        localStringBuilder.append(paramString);
        label41: if (localObject != null)
          break label69;
      }
      label69: for (localObject = ""; ; localObject = localObject.toString())
      {
        localStringBuilder.append((String)localObject);
        j += 1;
        break;
        i = 0;
        break label41;
      }
    }
    return localStringBuilder.toString();
  }

  public static void a(StringBuilder paramStringBuilder, Object paramObject, char paramChar)
  {
    int i;
    if (paramObject == null)
    {
      paramObject = "";
      paramObject = Uri.encode(paramObject);
      i = 0;
      label14: if (i >= paramObject.length())
        return;
      if (paramObject.charAt(i) != paramChar)
        break label63;
      paramStringBuilder.append('\\');
    }
    while (true)
    {
      paramStringBuilder.append(paramObject.charAt(i));
      i += 1;
      break label14;
      paramObject = paramObject.toString();
      break;
      label63: if (paramObject.charAt(i) == '\\')
        paramStringBuilder.append('\\');
    }
  }

  public static boolean a(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }

  public static boolean a(Object paramObject1, Object paramObject2)
  {
    try
    {
      paramObject1 = (String)paramObject1;
      paramObject2 = (String)paramObject2;
      if (paramObject1 == null)
      {
        if (paramObject2 == null)
          return true;
      }
      else
      {
        boolean bool = paramObject1.equals(paramObject2);
        return bool;
      }
    }
    catch (Throwable paramObject1)
    {
    }
    return false;
  }

  public static String[] a(String paramString, char paramChar)
  {
    if (paramString.length() == 0)
      return new String[0];
    Object localObject = paramString + paramChar;
    paramString = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < ((String)localObject).length())
    {
      int j = i;
      if (((String)localObject).charAt(i) == '\\')
      {
        j = i;
        if (i + 1 < ((String)localObject).length())
          j = i + 1;
      }
      if (((String)localObject).charAt(j) == paramChar)
      {
        paramString.add(Uri.decode(localStringBuilder.toString()));
        localStringBuilder.delete(0, localStringBuilder.length());
      }
      while (true)
      {
        i = j + 1;
        break;
        localStringBuilder.append(((String)localObject).charAt(j));
      }
    }
    localObject = (String[])paramString.toArray(new String[paramString.size()]);
    paramString.clear();
    return localObject;
  }

  public static String b(String paramString)
  {
    if (paramString == null)
      return "";
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return paramString;
  }

  public static float c(String paramString)
  {
    return a(paramString, 0.0F);
  }

  public static long d(String paramString)
  {
    return a(paramString, 0L);
  }

  public static int e(String paramString)
  {
    return a(paramString, 0);
  }

  public static boolean f(String paramString)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramString != null)
    {
      j = paramString.length();
      if (j != 0);
    }
    else
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    while (true)
    {
      if (i >= j)
        break label48;
      bool1 = bool2;
      if (!Character.isWhitespace(paramString.charAt(i)))
        break;
      i += 1;
    }
    label48: return true;
  }

  public static boolean g(String paramString)
  {
    if (f(paramString))
      return false;
    int i = 0;
    while (true)
    {
      if (i >= paramString.length())
        break label46;
      char c = paramString.charAt(i);
      if ((!a(c)) && (!Character.isWhitespace(c)))
        break;
      i += 1;
    }
    label46: return true;
  }

  // ERROR //
  public static String h(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 188	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 189	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_1
    //   14: new 191	java/util/zip/GZIPOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 194	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_2
    //   23: aload_2
    //   24: aload_0
    //   25: invokevirtual 198	java/lang/String:getBytes	()[B
    //   28: invokevirtual 204	java/io/OutputStream:write	([B)V
    //   31: aload_2
    //   32: invokevirtual 207	java/io/OutputStream:close	()V
    //   35: aload_1
    //   36: invokevirtual 210	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   39: invokestatic 215	aqh:b	([B)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_1
    //   44: invokestatic 220	arf:a	(Ljava/io/Closeable;)V
    //   47: aload_0
    //   48: areturn
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: invokestatic 220	arf:a	(Ljava/io/Closeable;)V
    //   56: ldc 73
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: invokestatic 220	arf:a	(Ljava/io/Closeable;)V
    //   66: aload_0
    //   67: athrow
    //   68: astore_0
    //   69: goto -7 -> 62
    //   72: astore_0
    //   73: goto -21 -> 52
    //
    // Exception table:
    //   from	to	target	type
    //   6	14	49	java/lang/Exception
    //   6	14	59	finally
    //   14	43	68	finally
    //   14	43	72	java/lang/Exception
  }

  public static boolean i(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0) && (!"null".equalsIgnoreCase(paramString));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asi
 * JD-Core Version:    0.6.2
 */