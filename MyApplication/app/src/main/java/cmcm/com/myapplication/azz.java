package cmcm.com.myapplication;

class azz
  implements azy
{
  private azy a;
  private azz b;

  public static void a(azz paramazz, azy paramazy)
  {
    if (paramazy == null)
      break label4;
    label4: 
    while (paramazz == null)
      return;
    azz localazz = paramazz;
    if (paramazz.a == null)
    {
      paramazz.a = paramazy;
      return;
    }
    do
    {
      localazz = localazz.b;
      if (localazz.a(paramazy))
        break;
    }
    while (localazz.b != null);
    paramazz = new azz();
    paramazz.a = paramazy;
    localazz.b = paramazz;
  }

  private boolean a(azy paramazy)
  {
    return (this.a != null) && (this.a == paramazy);
  }

  public static azz b()
  {
    return new azz();
  }

  private azy c()
  {
    return this.a;
  }

  public void a(azu paramazu)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((azz)localObject1).c();
      if (localObject2 != null)
        ((azy)localObject2).a(paramazu);
      localObject2 = ((azz)localObject1).b;
      localObject1 = localObject2;
    }
    while (localObject2 != null);
  }

  public void a(azu paramazu, boolean paramBoolean, byte paramByte, bag parambag)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((azz)localObject1).c();
      if (localObject2 != null)
        ((azy)localObject2).a(paramazu, paramBoolean, paramByte, parambag);
      localObject2 = ((azz)localObject1).b;
      localObject1 = localObject2;
    }
    while (localObject2 != null);
  }

  public boolean a()
  {
    return this.a != null;
  }

  public void b(azu paramazu)
  {
    Object localObject1 = this;
    if (!a())
      return;
    Object localObject2;
    do
    {
      localObject2 = ((azz)localObject1).c();
      if (localObject2 != null)
        ((azy)localObject2).b(paramazu);
      localObject2 = ((azz)localObject1).b;
      localObject1 = localObject2;
    }
    while (localObject2 != null);
  }

  public void c(azu paramazu)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((azz)localObject1).c();
      if (localObject2 != null)
        ((azy)localObject2).c(paramazu);
      localObject2 = ((azz)localObject1).b;
      localObject1 = localObject2;
    }
    while (localObject2 != null);
  }

  public void d(azu paramazu)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((azz)localObject1).c();
      if (localObject2 != null)
        ((azy)localObject2).d(paramazu);
      localObject2 = ((azz)localObject1).b;
      localObject1 = localObject2;
    }
    while (localObject2 != null);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azz
 * JD-Core Version:    0.6.2
 */