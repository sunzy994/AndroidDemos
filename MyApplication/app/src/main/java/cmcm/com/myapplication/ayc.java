package cmcm.com.myapplication;

class ayc
{
  long a = 0L;
  ayc b;

  private void b()
  {
    if (this.b == null)
      this.b = new ayc();
  }

  void a()
  {
    this.a = 0L;
    if (this.b != null)
      this.b.a();
  }

  void a(int paramInt)
  {
    if (paramInt >= 64)
    {
      b();
      this.b.a(paramInt - 64);
      return;
    }
    this.a |= 1L << paramInt;
  }

  void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 64)
    {
      b();
      this.b.a(paramInt - 64, paramBoolean);
    }
    label114: label120: 
    while (true)
    {
      return;
      boolean bool;
      if ((this.a & 0x0) != 0L)
      {
        bool = true;
        long l1 = (1L << paramInt) - 1L;
        long l2 = this.a;
        this.a = (((l1 ^ 0xFFFFFFFF) & this.a) << 1 | l2 & l1);
        if (!paramBoolean)
          break label114;
        a(paramInt);
      }
      while (true)
      {
        if ((!bool) && (this.b == null))
          break label120;
        b();
        this.b.a(0, bool);
        return;
        bool = false;
        break;
        b(paramInt);
      }
    }
  }

  void b(int paramInt)
  {
    if (paramInt >= 64)
    {
      if (this.b != null)
        this.b.b(paramInt - 64);
      return;
    }
    this.a &= (1L << paramInt ^ 0xFFFFFFFF);
  }

  boolean c(int paramInt)
  {
    if (paramInt >= 64)
    {
      b();
      return this.b.c(paramInt - 64);
    }
    return (this.a & 1L << paramInt) != 0L;
  }

  boolean d(int paramInt)
  {
    boolean bool2;
    if (paramInt >= 64)
    {
      b();
      bool2 = this.b.d(paramInt - 64);
      return bool2;
    }
    long l1 = 1L << paramInt;
    if ((this.a & l1) != 0L);
    for (boolean bool1 = true; ; bool1 = false)
    {
      this.a &= (l1 ^ 0xFFFFFFFF);
      l1 -= 1L;
      long l2 = this.a;
      this.a = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & this.a, 1) | l2 & l1);
      bool2 = bool1;
      if (this.b == null)
        break;
      if (this.b.c(0))
        a(63);
      this.b.d(0);
      return bool1;
    }
  }

  int e(int paramInt)
  {
    if (this.b == null)
    {
      if (paramInt >= 64)
        return Long.bitCount(this.a);
      return Long.bitCount(this.a & (1L << paramInt) - 1L);
    }
    if (paramInt < 64)
      return Long.bitCount(this.a & (1L << paramInt) - 1L);
    return this.b.e(paramInt - 64) + Long.bitCount(this.a);
  }

  public String toString()
  {
    if (this.b == null)
      return Long.toBinaryString(this.a);
    return this.b.toString() + "xx" + Long.toBinaryString(this.a);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ayc
 * JD-Core Version:    0.6.2
 */