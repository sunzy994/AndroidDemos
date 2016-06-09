package cmcm.com.myapplication;

import android.view.View;

public abstract class ayo
{
  protected final ayy a;
  private int b = -2147483648;

  private ayo(ayy paramayy)
  {
    this.a = paramayy;
  }

  public static ayo a(ayy paramayy)
  {
    // Byte code:
    //   0: new 6	ayo$1
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 28	ayo$1:<init>	(Layy;)V
    //   8: areturn
  }

  public static ayo a(ayy paramayy, int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("invalid orientation");
    case 0:
      return a(paramayy);
    case 1:
    }
    return b(paramayy);
  }

  public static ayo b(ayy paramayy)
  {
    // Byte code:
    //   0: new 8	ayo$2
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 41	ayo$2:<init>	(Layy;)V
    //   8: areturn
  }

  public abstract int a(View paramView);

  public void a()
  {
    this.b = f();
  }

  public abstract void a(int paramInt);

  public int b()
  {
    if (-2147483648 == this.b)
      return 0;
    return f() - this.b;
  }

  public abstract int b(View paramView);

  public abstract int c();

  public abstract int c(View paramView);

  public abstract int d();

  public abstract int d(View paramView);

  public abstract int e();

  public abstract int f();

  public abstract int g();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ayo
 * JD-Core Version:    0.6.2
 */