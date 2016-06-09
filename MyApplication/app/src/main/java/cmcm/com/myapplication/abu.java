package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.lazyswipe.SwipeApplication;

public class abu extends abg
  implements aut
{
  private Handler i;
  private aup j;
  private Context k;

  public abu(Context paramContext)
  {
    this.k = paramContext;
    this.i = new Handler(Looper.getMainLooper());
    this.j = new aup();
    this.j.b(this.k, this);
  }

  private void a(ImageView paramImageView, final String paramString)
  {
    Bitmap localBitmap = this.j.a(paramString, true);
    if (atw.b(localBitmap))
    {
      paramImageView.setImageBitmap(localBitmap);
      return;
    }
    paramImageView.setTag(paramString);
    paramString = new tn(SwipeApplication.c());
    asv.a(paramImageView, ScaleType.CENTER_INSIDE, paramString, 0);
    this.i.postDelayed(new Runnable()
    {
      public void run()
      {
        paramString.start();
      }
    }
    , 50L);
  }

  public void a()
  {
    super.a();
    this.j.b();
    this.j.a();
  }

  protected void a(abt paramabt)
  {
    ImageView localImageView;
    if (2 == paramabt.x())
    {
      localImageView = paramabt.w();
      if (localImageView == null);
    }
    try
    {
      if (atw.b(paramabt.j()))
      {
        paramabt = (MarginLayoutParams)((ViewGroup)localImageView.getParent()).getLayoutParams();
        paramabt.rightMargin += asq.a(5.0F);
      }
      return;
    }
    catch (Throwable paramabt)
    {
    }
  }

  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (asq.a(paramString1, this.c.getTag()))
      if (atw.b(paramBitmap))
        asv.a(this.c, ScaleType.CENTER_CROP, paramBitmap);
    while ((this.d == null) || (!asq.a(this.d.getTag(), paramString1)) || (!atw.b(paramBitmap)))
      return;
    asv.a(this.d, ScaleType.CENTER_CROP, paramBitmap);
  }

  public void b()
  {
    this.j.b(this.k, this);
  }

  public void c(abq paramabq)
  {
    this.c.setScaleType(ScaleType.CENTER_CROP);
    if (1 == paramabq.a())
      d(paramabq);
    do
    {
      return;
      a(this.c, paramabq.i());
    }
    while (this.d == null);
    a(this.d, paramabq.g());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abu
 * JD-Core Version:    0.6.2
 */