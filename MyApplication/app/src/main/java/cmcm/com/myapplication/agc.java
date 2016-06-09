package cmcm.com.myapplication;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.TextView;

class agc
  implements OnScrollListener
{
  private agc(afy paramafy)
  {
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = 0.0F;
    float f2 = afy.a(this.a, paramAbsListView) * 1.0F / afy.l(this.a);
    if (f2 > 1.0F)
      f1 = 1.0F;
    while (true)
    {
      afy.b(this.a).setTranslationY(-(asq.a(56.669998F) + afy.b(this.a).getMeasuredHeight() / 2) * f1);
      afy.b(this.a).setTranslationX(-(afy.b(this.a).getLeft() - afy.m(this.a).getLeft() - asq.a(20.0F)) * f1);
      afy.m(this.a).setTranslationX(-asq.a(20.0F) * f1);
      afy.m(this.a).setAlpha(1.0F - f1);
      afy.b(this.a).setTextSize(36.0F - 16.0F * f1);
      afy.c(this.a).setAlpha(1.0F - f1);
      afy.g(this.a).setTranslationY(-afy.a(this.a, paramAbsListView));
      return;
      if (f2 >= 0.0F)
        f1 = f2;
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agc
 * JD-Core Version:    0.6.2
 */