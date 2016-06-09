package cmcm.com.myapplication;

final class kt
{
  private static final byte[] a;
  private static final char[] b;

  static
  {
    int k = 0;
    a = new byte[''];
    b = new char[64];
    int i = 0;
    while (i < 128)
    {
      a[i] = -1;
      i += 1;
    }
    i = 90;
    while (i >= 65)
    {
      a[i] = ((byte)(i - 65));
      i -= 1;
    }
    i = 122;
    while (i >= 97)
    {
      a[i] = ((byte)(i - 97 + 26));
      i -= 1;
    }
    i = 57;
    while (i >= 48)
    {
      a[i] = ((byte)(i - 48 + 52));
      i -= 1;
    }
    a[43] = 62;
    a[47] = 63;
    i = 0;
    while (i <= 25)
    {
      b[i] = ((char)(i + 65));
      i += 1;
    }
    int j = 26;
    i = 0;
    while (j <= 51)
    {
      b[j] = ((char)(i + 97));
      j += 1;
      i += 1;
    }
    j = 52;
    i = k;
    while (j <= 61)
    {
      b[j] = ((char)(i + 48));
      j += 1;
      i += 1;
    }
    b[62] = '+';
    b[63] = '/';
  }

  private static int a(char[] paramArrayOfChar)
  {
    int i = 0;
    int k = 0;
    if (paramArrayOfChar == null);
    int m;
    int j;
    do
    {
      return k;
      m = paramArrayOfChar.length;
      j = 0;
      k = i;
    }
    while (j >= m);
    if (!a(paramArrayOfChar[j]))
    {
      k = i + 1;
      paramArrayOfChar[i] = paramArrayOfChar[j];
      i = k;
    }
    while (true)
    {
      j += 1;
      break;
    }
  }

  public static String a(byte[] paramArrayOfByte)
  {
    int k = 0;
    if (paramArrayOfByte == null)
      return null;
    int i = paramArrayOfByte.length * 8;
    if (i == 0)
      return "";
    int i2 = i % 24;
    int i1 = i / 24;
    char[] arrayOfChar;
    label54: int i3;
    int i4;
    int i5;
    int i6;
    if (i2 != 0)
    {
      i = i1 + 1;
      arrayOfChar = new char[i * 4];
      j = 0;
      i = 0;
      if (j >= i1)
        break label284;
      m = k + 1;
      k = paramArrayOfByte[k];
      i3 = m + 1;
      m = paramArrayOfByte[m];
      i4 = paramArrayOfByte[i3];
      i5 = (byte)(m & 0xF);
      i6 = (byte)(k & 0x3);
      if ((k & 0xFFFFFF80) != 0)
        break label241;
      k = (byte)(k >> 2);
      label120: if ((m & 0xFFFFFF80) != 0)
        break label255;
      m = (byte)(m >> 4);
      label135: if ((i4 & 0xFFFFFF80) != 0)
        break label269;
    }
    label269: for (int n = (byte)(i4 >> 6); ; n = (byte)(i4 >> 6 ^ 0xFC))
    {
      int i7 = i + 1;
      arrayOfChar[i] = b[k];
      i = i7 + 1;
      arrayOfChar[i7] = b[(m | i6 << 4)];
      k = i + 1;
      arrayOfChar[i] = b[(n | i5 << 2)];
      arrayOfChar[k] = b[(i4 & 0x3F)];
      j += 1;
      i = k + 1;
      k = i3 + 1;
      break label54;
      i = i1;
      break;
      label241: k = (byte)(k >> 2 ^ 0xC0);
      break label120;
      label255: m = (byte)(m >> 4 ^ 0xF0);
      break label135;
    }
    label284: if (i2 == 8)
    {
      j = paramArrayOfByte[k];
      k = (byte)(j & 0x3);
      if ((j & 0xFFFFFF80) == 0)
      {
        j = (byte)(j >> 2);
        m = i + 1;
        arrayOfChar[i] = b[j];
        i = m + 1;
        arrayOfChar[m] = b[(k << 4)];
        j = i + 1;
        arrayOfChar[i] = '=';
        arrayOfChar[j] = '=';
      }
    }
    while (i2 != 16)
      while (true)
      {
        return new String(arrayOfChar);
        j = (byte)(j >> 2 ^ 0xC0);
      }
    int j = paramArrayOfByte[k];
    k = paramArrayOfByte[(k + 1)];
    int m = (byte)(k & 0xF);
    n = (byte)(j & 0x3);
    if ((j & 0xFFFFFF80) == 0)
    {
      j = (byte)(j >> 2);
      label425: if ((k & 0xFFFFFF80) != 0)
        break label508;
    }
    label508: for (k = (byte)(k >> 4); ; k = (byte)(k >> 4 ^ 0xF0))
    {
      i1 = i + 1;
      arrayOfChar[i] = b[j];
      i = i1 + 1;
      arrayOfChar[i1] = b[(k | n << 4)];
      j = i + 1;
      arrayOfChar[i] = b[(m << 2)];
      arrayOfChar[j] = '=';
      break;
      j = (byte)(j >> 2 ^ 0xC0);
      break label425;
    }
  }

  private static boolean a(char paramChar)
  {
    return (paramChar == ' ') || (paramChar == '\r') || (paramChar == '\n') || (paramChar == '\t');
  }

  public static byte[] a(String paramString)
  {
    if (paramString == null);
    int m;
    int k;
    char c1;
    char c2;
    label247: 
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return null;
                localObject = paramString.toCharArray();
                i = a((char[])localObject);
              }
              while (i % 4 != 0);
              m = i / 4;
              if (m == 0)
                return new byte[0];
              paramString = new byte[m * 3];
              k = 0;
              i = 0;
              j = 0;
              while (true)
              {
                if (j >= m - 1)
                  break label247;
                n = k + 1;
                c1 = localObject[k];
                if (!c(c1))
                  break;
                k = n + 1;
                c2 = localObject[n];
                if (!c(c2))
                  break;
                n = k + 1;
                char c3 = localObject[k];
                if (!c(c3))
                  break;
                k = n + 1;
                char c4 = localObject[n];
                if (!c(c4))
                  break;
                int i4 = a[c1];
                int i2 = a[c2];
                n = a[c3];
                i1 = a[c4];
                int i3 = i + 1;
                paramString[i] = ((byte)(i4 << 2 | i2 >> 4));
                i4 = i3 + 1;
                paramString[i3] = ((byte)((i2 & 0xF) << 4 | n >> 2 & 0xF));
                i = i4 + 1;
                paramString[i4] = ((byte)(n << 6 | i1));
                j += 1;
              }
              m = k + 1;
              c1 = localObject[k];
            }
            while (!c(c1));
            n = m + 1;
            c2 = localObject[m];
          }
          while (!c(c2));
          m = a[c1];
          k = a[c2];
          i1 = n + 1;
          c1 = localObject[n];
          c2 = localObject[i1];
          if ((c(c1)) && (c(c2)))
            break label484;
          if ((!b(c1)) || (!b(c2)))
            break;
        }
        while ((k & 0xF) != 0);
        localObject = new byte[j * 3 + 1];
        System.arraycopy(paramString, 0, localObject, 0, j * 3);
        localObject[i] = ((byte)(m << 2 | k >> 4));
        return localObject;
      }
      while ((b(c1)) || (!b(c2)));
      n = a[c1];
    }
    while ((n & 0x3) != 0);
    Object localObject = new byte[j * 3 + 2];
    System.arraycopy(paramString, 0, localObject, 0, j * 3);
    localObject[i] = ((byte)(m << 2 | k >> 4));
    localObject[(i + 1)] = ((byte)((k & 0xF) << 4 | n >> 2 & 0xF));
    return localObject;
    label484: int j = a[c1];
    int n = a[c2];
    int i1 = i + 1;
    paramString[i] = ((byte)(m << 2 | k >> 4));
    int i = i1 + 1;
    paramString[i1] = ((byte)((k & 0xF) << 4 | j >> 2 & 0xF));
    paramString[i] = ((byte)(j << 6 | n));
    return paramString;
  }

  private static boolean b(char paramChar)
  {
    return paramChar == '=';
  }

  private static boolean c(char paramChar)
  {
    return (paramChar < '') && (a[paramChar] != -1);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     kt
 * JD-Core Version:    0.6.2
 */