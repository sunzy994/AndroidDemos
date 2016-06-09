package cmcm.com.myapplication.com.qq.e.comm.services;

public class RetCodeService$RetCodeInfo
{
  final String a;
  final String b;
  final String c;
  final int d;
  final int e;
  final int f;
  final int g;
  final int h;

  public RetCodeService$RetCodeInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.h = paramInt5;
  }

  public String toString()
  {
    return "RetCodeInfo [host=" + this.a + ", commandid=" + this.b + ", releaseversion=" + this.c + ", resultcode=" + this.d + ", tmcost=" + this.e + ", reqsize=" + this.f + ", rspsize=" + this.g + "]";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.services.RetCodeService.RetCodeInfo
 * JD-Core Version:    0.6.2
 */