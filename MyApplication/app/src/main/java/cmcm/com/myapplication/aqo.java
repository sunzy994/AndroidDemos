package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import com.lazyswipe.SwipeApplication;

public class aqo extends aui
{
  static final int[] a = { 2131689493, 2131689494, 2131689495, 2131689496, 2131689497, 2131689498, 2131689499 };
  private final int c;

  private aqo(String paramString, int paramInt)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    String str = a(paramString);
    if (str.length() == 2);
    for (float f = 18.0F; ; f = 20.0F)
    {
      int i = asq.a(f);
      int j = Math.abs(paramString.hashCode());
      int k = a.length;
      this.c = localSwipeApplication.getResources().getColor(a[(j % k)]);
      a(str, a(this.c), paramInt, i);
      return;
    }
  }

  private ShapeDrawable a(int paramInt)
  {
    return atw.a(paramInt, SwipeApplication.c().getResources().getDimensionPixelSize(2131296395));
  }

  private String a(String paramString)
  {
    if (!asi.g(paramString))
      return paramString.substring(0, 1).toUpperCase();
    Object localObject = paramString;
    while (true)
    {
      int i;
      int j;
      int k;
      try
      {
        String str1 = paramString.trim();
        localObject = str1;
        char c2 = str1.charAt(0);
        i = 0;
        j = 0;
        localObject = str1;
        if (i < str1.length())
        {
          localObject = str1;
          c1 = str1.charAt(i);
          localObject = str1;
          if (!Character.isWhitespace(c1))
            break label186;
          k = 1;
          break label173;
          localObject = str1;
          String str2 = "" + c2;
          paramString = str2;
          if (c1 != ' ')
          {
            localObject = str1;
            paramString = str2 + c1;
          }
          localObject = str1;
          paramString = paramString.toUpperCase();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return ((String)localObject).substring(0, 1).toUpperCase();
      }
      char c1 = ' ';
      continue;
      label173: label186: 
      do
      {
        i += 1;
        j = k;
        break;
        k = j;
      }
      while (j == 0);
    }
  }

  protected int a()
  {
    return asq.a(1.5F);
  }

  public int b()
  {
    return this.c;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if ((this.b instanceof ShapeDrawable))
    {
      ((ShapeDrawable)this.b).setIntrinsicWidth(paramRect.width());
      ((ShapeDrawable)this.b).setIntrinsicHeight(paramRect.height());
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqo
 * JD-Core Version:    0.6.2
 */