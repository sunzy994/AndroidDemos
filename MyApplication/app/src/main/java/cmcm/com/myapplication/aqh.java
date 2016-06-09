package cmcm.com.myapplication;

import java.io.UnsupportedEncodingException;

public class aqh
{
  static final byte[] a = { 13, 10 };
  private static final byte[] b = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] c = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
  private final byte[] e;
  private final int f;
  private final byte[] g;
  private final int h;
  private final int i;
  private byte[] j;
  private int k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private int p;

  public aqh()
  {
    this(false);
  }

  public aqh(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null)
    {
      arrayOfByte = a;
      paramInt = 0;
    }
    int i1;
    if (paramInt > 0)
    {
      i1 = paramInt / 4 * 4;
      this.f = i1;
      this.g = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.g, 0, arrayOfByte.length);
      if (paramInt <= 0)
        break label133;
    }
    label133: for (this.i = (arrayOfByte.length + 4); ; this.i = 4)
    {
      this.h = (this.i - 1);
      if (!f(arrayOfByte))
        break label141;
      paramArrayOfByte = g(arrayOfByte);
      throw new IllegalArgumentException("lineSeperator must not contain base64 characters: [" + paramArrayOfByte + "]");
      i1 = 0;
      break;
    }
    label141: if (paramBoolean);
    for (paramArrayOfByte = c; ; paramArrayOfByte = b)
    {
      this.e = paramArrayOfByte;
      return;
    }
  }

  public aqh(boolean paramBoolean)
  {
    this(76, a, paramBoolean);
  }

  private static long a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    int i1 = paramInt / 4 * 4;
    long l2 = paramArrayOfByte1.length * 4 / 3;
    long l3 = l2 % 4L;
    long l1 = l2;
    if (l3 != 0L)
      l1 = l2 + (4L - l3);
    l2 = l1;
    if (i1 > 0)
    {
      if (l1 % i1 == 0L);
      for (paramInt = 1; ; paramInt = 0)
      {
        l1 += l1 / i1 * paramArrayOfByte2.length;
        l2 = l1;
        if (paramInt != 0)
          break;
        return paramArrayOfByte2.length + l1;
      }
    }
    return l2;
  }

  public static boolean a(byte paramByte)
  {
    return (paramByte == 61) || ((paramByte >= 0) && (paramByte < d.length) && (d[paramByte] != -1));
  }

  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, false);
  }

  public static byte[] a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return a(paramArrayOfByte, paramBoolean, false);
  }

  public static byte[] a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramArrayOfByte, paramBoolean1, paramBoolean2, 2147483647);
  }

  public static byte[] a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return paramArrayOfByte;
    long l1 = a(paramArrayOfByte, 76, a);
    if (l1 > paramInt)
      throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l1 + ") than the specified maxium size of " + paramInt);
    if (paramBoolean1);
    for (aqh localaqh = new aqh(paramBoolean2); ; localaqh = new aqh(0, a, paramBoolean2))
      return localaqh.e(paramArrayOfByte);
  }

  public static String b(byte[] paramArrayOfByte)
  {
    return g(a(paramArrayOfByte, true));
  }

  private void c()
  {
    if (this.j == null)
    {
      this.j = new byte[8192];
      this.k = 0;
      this.l = 0;
      return;
    }
    byte[] arrayOfByte = new byte[this.j.length * 2];
    System.arraycopy(this.j, 0, arrayOfByte, 0, this.j.length);
    this.j = arrayOfByte;
  }

  private void d()
  {
    this.j = null;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = 0;
    this.o = false;
  }

  public static byte[] d(byte[] paramArrayOfByte)
  {
    return new aqh().c(paramArrayOfByte);
  }

  private static boolean f(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    int i2 = paramArrayOfByte.length;
    int i1 = 0;
    while (true)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (a(paramArrayOfByte[i1]))
          bool1 = true;
      }
      else
        return bool1;
      i1 += 1;
    }
  }

  private static String g(byte[] paramArrayOfByte)
  {
    try
    {
      String str = new String(paramArrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return new String(paramArrayOfByte);
  }

  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.j != null)
    {
      paramInt2 = Math.min(b(), paramInt2);
      if (this.j != paramArrayOfByte)
      {
        System.arraycopy(this.j, this.l, paramArrayOfByte, paramInt1, paramInt2);
        this.l += paramInt2;
        if (this.l >= this.k)
          this.j = null;
        return paramInt2;
      }
      this.j = null;
      return paramInt2;
    }
    if (this.o)
      return -1;
    return 0;
  }

  public boolean a()
  {
    return this.e == c;
  }

  int b()
  {
    if (this.j != null)
      return this.k - this.l;
    return 0;
  }

  void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == paramInt2))
    {
      this.j = paramArrayOfByte;
      this.k = paramInt1;
      this.l = paramInt1;
    }
  }

  void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.o);
    while (true)
    {
      return;
      if (paramInt2 < 0)
      {
        this.o = true;
        if ((this.j == null) || (this.j.length - this.k < this.i))
          c();
        switch (this.n)
        {
        default:
        case 1:
        case 2:
        }
        while ((this.f > 0) && (this.k > 0))
        {
          System.arraycopy(this.g, 0, this.j, this.k, this.g.length);
          this.k += this.g.length;
          return;
          paramArrayOfByte = this.j;
          paramInt1 = this.k;
          this.k = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = this.e[(this.p >> 2 & 0x3F)];
          paramArrayOfByte = this.j;
          paramInt1 = this.k;
          this.k = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = this.e[(this.p << 4 & 0x3F)];
          if (this.e == b)
          {
            paramArrayOfByte = this.j;
            paramInt1 = this.k;
            this.k = (paramInt1 + 1);
            paramArrayOfByte[paramInt1] = 61;
            paramArrayOfByte = this.j;
            paramInt1 = this.k;
            this.k = (paramInt1 + 1);
            paramArrayOfByte[paramInt1] = 61;
            continue;
            paramArrayOfByte = this.j;
            paramInt1 = this.k;
            this.k = (paramInt1 + 1);
            paramArrayOfByte[paramInt1] = this.e[(this.p >> 10 & 0x3F)];
            paramArrayOfByte = this.j;
            paramInt1 = this.k;
            this.k = (paramInt1 + 1);
            paramArrayOfByte[paramInt1] = this.e[(this.p >> 4 & 0x3F)];
            paramArrayOfByte = this.j;
            paramInt1 = this.k;
            this.k = (paramInt1 + 1);
            paramArrayOfByte[paramInt1] = this.e[(this.p << 2 & 0x3F)];
            if (this.e == b)
            {
              paramArrayOfByte = this.j;
              paramInt1 = this.k;
              this.k = (paramInt1 + 1);
              paramArrayOfByte[paramInt1] = 61;
            }
          }
        }
      }
      else
      {
        int i1 = 0;
        while (i1 < paramInt2)
        {
          if ((this.j == null) || (this.j.length - this.k < this.i))
            c();
          int i2 = this.n + 1;
          this.n = i2;
          this.n = (i2 % 3);
          int i3 = paramArrayOfByte[paramInt1];
          i2 = i3;
          if (i3 < 0)
            i2 = i3 + 256;
          this.p = (i2 + (this.p << 8));
          if (this.n == 0)
          {
            byte[] arrayOfByte = this.j;
            i2 = this.k;
            this.k = (i2 + 1);
            arrayOfByte[i2] = this.e[(this.p >> 18 & 0x3F)];
            arrayOfByte = this.j;
            i2 = this.k;
            this.k = (i2 + 1);
            arrayOfByte[i2] = this.e[(this.p >> 12 & 0x3F)];
            arrayOfByte = this.j;
            i2 = this.k;
            this.k = (i2 + 1);
            arrayOfByte[i2] = this.e[(this.p >> 6 & 0x3F)];
            arrayOfByte = this.j;
            i2 = this.k;
            this.k = (i2 + 1);
            arrayOfByte[i2] = this.e[(this.p & 0x3F)];
            this.m += 4;
            if ((this.f > 0) && (this.f <= this.m))
            {
              System.arraycopy(this.g, 0, this.j, this.k, this.g.length);
              this.k += this.g.length;
              this.m = 0;
            }
          }
          i1 += 1;
          paramInt1 += 1;
        }
      }
    }
  }

  public byte[] c(byte[] paramArrayOfByte)
  {
    d();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return paramArrayOfByte;
    byte[] arrayOfByte = new byte[(int)(paramArrayOfByte.length * 3 / 4)];
    b(arrayOfByte, 0, arrayOfByte.length);
    d(paramArrayOfByte, 0, paramArrayOfByte.length);
    d(paramArrayOfByte, 0, -1);
    paramArrayOfByte = new byte[this.k];
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
    return paramArrayOfByte;
  }

  void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.o)
      return;
    if (paramInt2 < 0)
      this.o = true;
    int i1 = 0;
    while (true)
    {
      int i2;
      if (i1 < paramInt2)
      {
        if ((this.j == null) || (this.j.length - this.k < this.h))
          c();
        i2 = paramArrayOfByte[paramInt1];
        if (i2 == 61)
          this.o = true;
      }
      else
      {
        if ((!this.o) || (this.n == 0))
          break;
        this.p <<= 6;
      }
      switch (this.n)
      {
      default:
        return;
      case 2:
        this.p <<= 6;
        paramArrayOfByte = this.j;
        paramInt1 = this.k;
        this.k = (paramInt1 + 1);
        paramArrayOfByte[paramInt1] = ((byte)(this.p >> 16 & 0xFF));
        return;
        if ((i2 >= 0) && (i2 < d.length))
        {
          i2 = d[i2];
          if (i2 >= 0)
          {
            int i3 = this.n + 1;
            this.n = i3;
            this.n = (i3 % 4);
            this.p = (i2 + (this.p << 6));
            if (this.n == 0)
            {
              byte[] arrayOfByte = this.j;
              i2 = this.k;
              this.k = (i2 + 1);
              arrayOfByte[i2] = ((byte)(this.p >> 16 & 0xFF));
              arrayOfByte = this.j;
              i2 = this.k;
              this.k = (i2 + 1);
              arrayOfByte[i2] = ((byte)(this.p >> 8 & 0xFF));
              arrayOfByte = this.j;
              i2 = this.k;
              this.k = (i2 + 1);
              arrayOfByte[i2] = ((byte)(this.p & 0xFF));
            }
          }
        }
        i1 += 1;
        paramInt1 += 1;
      case 3:
      }
    }
    paramArrayOfByte = this.j;
    paramInt1 = this.k;
    this.k = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(this.p >> 16 & 0xFF));
    paramArrayOfByte = this.j;
    paramInt1 = this.k;
    this.k = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(this.p >> 8 & 0xFF));
  }

  public byte[] e(byte[] paramArrayOfByte)
  {
    d();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return paramArrayOfByte;
    byte[] arrayOfByte = new byte[(int)a(paramArrayOfByte, this.f, this.g)];
    b(arrayOfByte, 0, arrayOfByte.length);
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
    c(paramArrayOfByte, 0, -1);
    if (this.j != arrayOfByte)
      a(arrayOfByte, 0, arrayOfByte.length);
    if ((a()) && (this.k < arrayOfByte.length))
    {
      paramArrayOfByte = new byte[this.k];
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, this.k);
      return paramArrayOfByte;
    }
    return arrayOfByte;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqh
 * JD-Core Version:    0.6.2
 */