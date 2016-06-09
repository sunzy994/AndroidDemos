package cmcm.com.myapplication;

public class aff
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;

  public aff(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("country:").append(this.a).append(";");
    localStringBuilder.append("province:").append(this.b).append(";");
    localStringBuilder.append("city:").append(this.c).append(";");
    localStringBuilder.append("subcity:").append(this.d).append(";");
    return localStringBuilder.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aff
 * JD-Core Version:    0.6.2
 */