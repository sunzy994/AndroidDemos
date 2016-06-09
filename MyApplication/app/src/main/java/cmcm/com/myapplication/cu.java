package cmcm.com.myapplication;

public class cu<E>
  implements Cloneable
{
  private static final Object a = new Object();
  private boolean b = false;
  private long[] c;
  private Object[] d;
  private int e;

  public cu()
  {
    this(10);
  }

  public cu(int paramInt)
  {
    if (paramInt == 0)
      this.c = cr.b;
    for (this.d = cr.c; ; this.d = new Object[paramInt])
    {
      this.e = 0;
      return;
      paramInt = cr.b(paramInt);
      this.c = new long[paramInt];
    }
  }

  private void d()
  {
    int m = this.e;
    long[] arrayOfLong = this.c;
    Object[] arrayOfObject = this.d;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != a)
      {
        if (i != j)
        {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.b = false;
    this.e = j;
  }

  // ERROR //
  public cu<E> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 52	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	cu
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 36	cu:c	[J
    //   13: invokevirtual 54	[J:clone	()Ljava/lang/Object;
    //   16: checkcast 53	[J
    //   19: putfield 36	cu:c	[J
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 40	cu:d	[Ljava/lang/Object;
    //   27: invokevirtual 56	[Ljava/lang/Object;:clone	()Ljava/lang/Object;
    //   30: checkcast 55	[Ljava/lang/Object;
    //   33: putfield 40	cu:d	[Ljava/lang/Object;
    //   36: aload_1
    //   37: areturn
    //   38: astore_1
    //   39: aconst_null
    //   40: areturn
    //   41: astore_2
    //   42: aload_1
    //   43: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	38	java/lang/CloneNotSupportedException
    //   8	36	41	java/lang/CloneNotSupportedException
  }

  public E a(long paramLong)
  {
    return a(paramLong, null);
  }

  public E a(long paramLong, E paramE)
  {
    int i = cr.a(this.c, this.e, paramLong);
    if ((i < 0) || (this.d[i] == a))
      return paramE;
    return this.d[i];
  }

  public void a(int paramInt)
  {
    if (this.d[paramInt] != a)
    {
      this.d[paramInt] = a;
      this.b = true;
    }
  }

  public int b()
  {
    if (this.b)
      d();
    return this.e;
  }

  public long b(int paramInt)
  {
    if (this.b)
      d();
    return this.c[paramInt];
  }

  public void b(long paramLong)
  {
    int i = cr.a(this.c, this.e, paramLong);
    if ((i >= 0) && (this.d[i] != a))
    {
      this.d[i] = a;
      this.b = true;
    }
  }

  public void b(long paramLong, E paramE)
  {
    int i = cr.a(this.c, this.e, paramLong);
    if (i >= 0)
    {
      this.d[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.e) && (this.d[j] == a))
    {
      this.c[j] = paramLong;
      this.d[j] = paramE;
      return;
    }
    i = j;
    if (this.b)
    {
      i = j;
      if (this.e >= this.c.length)
      {
        d();
        i = cr.a(this.c, this.e, paramLong) ^ 0xFFFFFFFF;
      }
    }
    if (this.e >= this.c.length)
    {
      j = cr.b(this.e + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.c, 0, arrayOfLong, 0, this.c.length);
      System.arraycopy(this.d, 0, arrayOfObject, 0, this.d.length);
      this.c = arrayOfLong;
      this.d = arrayOfObject;
    }
    if (this.e - i != 0)
    {
      System.arraycopy(this.c, i, this.c, i + 1, this.e - i);
      System.arraycopy(this.d, i, this.d, i + 1, this.e - i);
    }
    this.c[i] = paramLong;
    this.d[i] = paramE;
    this.e += 1;
  }

  public E c(int paramInt)
  {
    if (this.b)
      d();
    return this.d[paramInt];
  }

  public void c()
  {
    int j = this.e;
    Object[] arrayOfObject = this.d;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.e = 0;
    this.b = false;
  }

  public void c(long paramLong)
  {
    b(paramLong);
  }

  public void c(long paramLong, E paramE)
  {
    if ((this.e != 0) && (paramLong <= this.c[(this.e - 1)]))
    {
      b(paramLong, paramE);
      return;
    }
    if ((this.b) && (this.e >= this.c.length))
      d();
    int i = this.e;
    if (i >= this.c.length)
    {
      int j = cr.b(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.c, 0, arrayOfLong, 0, this.c.length);
      System.arraycopy(this.d, 0, arrayOfObject, 0, this.d.length);
      this.c = arrayOfLong;
      this.d = arrayOfObject;
    }
    this.c[i] = paramLong;
    this.d[i] = paramE;
    this.e = (i + 1);
  }

  public String toString()
  {
    if (b() <= 0)
      return "{}";
    StringBuilder localStringBuilder = new StringBuilder(this.e * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.e)
    {
      if (i > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(b(i));
      localStringBuilder.append('=');
      Object localObject = c(i);
      if (localObject != this)
        localStringBuilder.append(localObject);
      while (true)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     cu
 * JD-Core Version:    0.6.2
 */