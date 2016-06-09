package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.features.ad.AdCoverView;

public class abg
{
  protected static final String a = "Swipe." + abg.class.getSimpleName();
  public View b;
  public ImageView c;
  public ImageView d;
  public ImageView e;
  public TextView f;
  public TextView g;
  public TextView h;

  private void a(ImageView paramImageView)
  {
    if (paramImageView == null);
    while (true)
    {
      return;
      Drawable localDrawable = paramImageView.getDrawable();
      paramImageView.setImageDrawable(null);
      if ((localDrawable instanceof BitmapDrawable))
      {
        paramImageView = ((BitmapDrawable)localDrawable).getBitmap();
        try
        {
          if (!paramImageView.isRecycled())
          {
            paramImageView.recycle();
            return;
          }
        }
        catch (Throwable paramImageView)
        {
        }
      }
    }
  }

  public void a()
  {
    a(this.c);
    if (this.d != null);
  }

  public void a(abq paramabq)
  {
    b(paramabq);
    c(paramabq);
  }

  protected void a(abt paramabt)
  {
  }

  public void a(View paramView)
  {
    this.b = paramView.findViewById(2131755118);
    this.e = ((ImageView) asr.a(paramView, 2131755122));
    this.c = ((ImageView) asr.a(paramView, 2131755098));
    this.d = ((ImageView) asr.a(paramView, 2131755119));
    this.f = ((TextView) asr.a(paramView, 2131755097));
    this.g = ((TextView) asr.a(paramView, 2131755102));
    this.h = ((TextView) asr.a(paramView, 2131755096));
  }

  protected void b(abq paramabq)
  {
    this.f.setText(paramabq.d());
    this.h.setText(paramabq.c());
    if (this.g != null)
      this.g.setText(paramabq.e());
  }

  protected void c(abq paramabq)
  {
    this.c.setScaleType(ScaleType.CENTER_CROP);
    if (1 == paramabq.a())
    {
      d(paramabq);
      return;
    }
    int i = aqs.ac();
    String str = paramabq.h();
    int[] arrayOfInt = atw.a(str);
    int j = arrayOfInt[0];
    if (j > i)
    {
      int k = arrayOfInt[1];
      float f1 = j * 1.0F / k;
      j = (int)(i / f1);
    }
    while (true)
    {
      FanItem.g.a(this.c.getResources(), this.c, str, "null", 0, i, j, null);
      if ((this.d == null) || (TextUtils.isEmpty(paramabq.g())))
        break;
      FanItem.g.a(SwipeApplication.c(), this.d, paramabq.f(), "null", 0, 0, null);
      return;
      j = 0;
      i = 0;
    }
  }

  protected void d(abq paramabq)
  {
    if ((this.c instanceof AdCoverView))
      ((AdCoverView)this.c).setAdCoverSizeFix(true);
    this.c.setImageDrawable(paramabq.j());
    if (this.d != null)
      this.d.setImageDrawable(paramabq.k());
    a((abt)paramabq);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abg
 * JD-Core Version:    0.6.2
 */