package cmcm.com.myapplication;

public enum akv
{
  final int d;
  final int e;

  private akv(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }

  public static akv a(int paramInt)
  {
    akv[] arrayOfakv = values();
    int j = arrayOfakv.length;
    int i = 0;
    while (i < j)
    {
      akv localakv = arrayOfakv[i];
      if (localakv.b(paramInt))
        return localakv;
      i += 1;
    }
    return null;
  }

  public boolean b(int paramInt)
  {
    boolean bool = true;
    if ((paramInt >= 24) || (paramInt < 0))
      bool = false;
    do
    {
      return bool;
      if (this.d >= this.e)
        break;
    }
    while ((this.d <= paramInt) && (this.e >= paramInt));
    do
    {
      return false;
      if (this.d <= paramInt)
        break;
    }
    while (this.e < paramInt);
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akv
 * JD-Core Version:    0.6.2
 */