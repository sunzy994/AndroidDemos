package cmcm.com.myapplication;

import java.util.LinkedHashMap;

public class cv<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;

  public cv(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("maxSize <= 0");
    this.c = paramInt;
    this.a = new LinkedHashMap(0, 0.75F, true);
  }

  private int c(K paramK, V paramV)
  {
    int i = b(paramK, paramV);
    if (i < 0)
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    return i;
  }

  public final V a(K paramK)
  {
    if (paramK == null)
      throw new NullPointerException("key == null");
    Object localObject1;
    try
    {
      localObject1 = this.a.get(paramK);
      if (localObject1 != null)
      {
        this.g += 1;
        return localObject1;
      }
      this.h += 1;
      localObject1 = b(paramK);
      if (localObject1 == null)
        return null;
    }
    finally
    {
    }
    try
    {
      this.e += 1;
      Object localObject2 = this.a.put(paramK, localObject1);
      if (localObject2 != null)
        this.a.put(paramK, localObject2);
      while (true)
      {
        if (localObject2 == null)
          break;
        a(false, paramK, localObject1, localObject2);
        return localObject2;
        this.b += c(paramK, localObject1);
      }
    }
    finally
    {
    }
    a(this.c);
    return localObject1;
  }

  public final V a(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null))
      throw new NullPointerException("key == null || value == null");
    try
    {
      this.d += 1;
      this.b += c(paramK, paramV);
      Object localObject = this.a.put(paramK, paramV);
      if (localObject != null)
        this.b -= c(paramK, localObject);
      if (localObject != null)
        a(false, paramK, localObject, paramV);
      a(this.c);
      return localObject;
    }
    finally
    {
    }
    throw paramK;
  }

  public final void a()
  {
    a(-1);
  }

  // ERROR //
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	cv:b	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 38	cv:a	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 105	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 91	cv:b	I
    //   23: ifeq +41 -> 64
    //   26: new 44	java/lang/IllegalStateException
    //   29: dup
    //   30: new 46	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 109	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 114	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 116
    //   49: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 63	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 91	cv:b	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 38	cv:a	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 105	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 38	cv:a	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 120	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 126 1 0
    //   97: invokeinterface 132 1 0
    //   102: checkcast 134	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 137 1 0
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface 140 1 0
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 38	cv:a	Ljava/util/LinkedHashMap;
    //   124: aload_2
    //   125: invokevirtual 143	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 91	cv:b	I
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokespecial 93	cv:c	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: isub
    //   141: putfield 91	cv:b	I
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 145	cv:f	I
    //   149: iconst_1
    //   150: iadd
    //   151: putfield 145	cv:f	I
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_0
    //   157: iconst_1
    //   158: aload_2
    //   159: aload_3
    //   160: aconst_null
    //   161: invokevirtual 89	cv:a	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   164: goto -164 -> 0
    //
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   60	62	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   85	156	59	finally
  }

  public void a(boolean paramBoolean, K paramK, V paramV1, V paramV2)
  {
  }

  public int b(K paramK, V paramV)
  {
    return 1;
  }

  protected V b(K paramK)
  {
    return null;
  }

  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.g + this.h;
      if (j != 0)
        i = this.g * 100 / j;
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i) });
      return str;
    }
    finally
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     cv
 * JD-Core Version:    0.6.2
 */