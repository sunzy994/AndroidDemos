package cmcm.com.myapplication;

class os
{
  public long a;
  public long b;
  public long c;
  public long d;
  public String e;

  public os(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramLong4;
    this.e = paramString;
  }

  public String toString()
  {
    return "PieceInfo [threadId=" + this.a + ", startPos=" + this.b + ", endPos=" + this.c + ", completeSize=" + this.d + "]";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     os
 * JD-Core Version:    0.6.2
 */