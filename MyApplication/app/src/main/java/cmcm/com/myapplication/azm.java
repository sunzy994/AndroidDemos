package cmcm.com.myapplication;

import android.view.View;

public class azm
{
  public static int a(azi paramazi, ayo paramayo, View paramView1, View paramView2, ayy paramayy, boolean paramBoolean)
  {
    if ((paramayy.k() == 0) || (paramazi.e() == 0) || (paramView1 == null) || (paramView2 == null))
      return 0;
    if (!paramBoolean)
      return Math.abs(paramayy.d(paramView1) - paramayy.d(paramView2)) + 1;
    int i = paramayo.b(paramView2);
    int j = paramayo.a(paramView1);
    return Math.min(paramayo.f(), i - j);
  }

  public static int a(azi paramazi, ayo paramayo, View paramView1, View paramView2, ayy paramayy, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int j = i;
    if (paramayy.k() != 0)
    {
      j = i;
      if (paramazi.e() != 0)
      {
        j = i;
        if (paramView1 != null)
        {
          if (paramView2 != null)
            break label45;
          j = i;
        }
      }
    }
    return j;
    label45: i = Math.min(paramayy.d(paramView1), paramayy.d(paramView2));
    j = Math.max(paramayy.d(paramView1), paramayy.d(paramView2));
    if (paramBoolean2);
    for (i = Math.max(0, paramazi.e() - j - 1); ; i = Math.max(0, i - 1))
    {
      j = i;
      if (!paramBoolean1)
        break;
      j = Math.abs(paramayo.b(paramView2) - paramayo.a(paramView1));
      int k = Math.abs(paramayy.d(paramView1) - paramayy.d(paramView2));
      float f = j / (k + 1);
      return Math.round(i * f + (paramayo.c() - paramayo.a(paramView1)));
    }
  }

  public static int b(azi paramazi, ayo paramayo, View paramView1, View paramView2, ayy paramayy, boolean paramBoolean)
  {
    if ((paramayy.k() == 0) || (paramazi.e() == 0) || (paramView1 == null) || (paramView2 == null))
      return 0;
    if (!paramBoolean)
      return paramazi.e();
    int i = paramayo.b(paramView2);
    int j = paramayo.a(paramView1);
    int k = Math.abs(paramayy.d(paramView1) - paramayy.d(paramView2));
    return (int)((i - j) / (k + 1) * paramazi.e());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azm
 * JD-Core Version:    0.6.2
 */