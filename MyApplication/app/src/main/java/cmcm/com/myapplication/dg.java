package cmcm.com.myapplication;

public class dg<E>
  implements Cloneable
{
  private static final Object a = new Object();
  private boolean b = false;
  private int[] c;
  private Object[] d;
  private int e;

  public dg()
  {
    this(10);
  }

  public dg(int paramInt)
  {
    if (paramInt == 0)
      this.c = cr.a;
    for (this.d = cr.c; ; this.d = new Object[paramInt])
    {
      this.e = 0;
      return;
      paramInt = cr.a(paramInt);
      this.c = new int[paramInt];
    }
  }

  private void d()
  {
    int m = this.e;
    int[] arrayOfInt = this.c;
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
          arrayOfInt[j] = arrayOfInt[i];
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

  public int a(int paramInt)
  {
    if (this.b)
      d();
    return this.c[paramInt];
  }

  // ERROR //
  public dg<E> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 54	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	dg
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 36	dg:c	[I
    //   13: invokevirtual 56	[I:clone	()Ljava/lang/Object;
    //   16: checkcast 55	[I
    //   19: putfield 36	dg:c	[I
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 40	dg:d	[Ljava/lang/Object;
    //   27: invokevirtual 58	[Ljava/lang/Object;:clone	()Ljava/lang/Object;
    //   30: checkcast 57	[Ljava/lang/Object;
    //   33: putfield 40	dg:d	[Ljava/lang/Object;
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

  public int b()
  {
    if (this.b)
      d();
    return this.e;
  }

  public E b(int paramInt)
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
      localStringBuilder.append(a(i));
      localStringBuilder.append('=');
      Object localObject = b(i);
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
 * Qualified Name:     dg
 * JD-Core Version:    0.6.2
 */