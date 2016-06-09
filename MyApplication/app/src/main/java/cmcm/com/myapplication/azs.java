package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class azs extends FrameLayout
  implements azy
{
  protected TextView a;
  protected View b;
  protected ProgressBar c;
  protected TextView d;
  private int e = 150;
  private RotateAnimation f;
  private RotateAnimation g;
  private azt h;
  private azt i;

  public azs(Context paramContext)
  {
    super(paramContext);
    a(null);
  }

  private void a()
  {
    this.f = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.f.setInterpolator(new LinearInterpolator());
    this.f.setDuration(this.e);
    this.f.setFillAfter(true);
    this.g = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.g.setInterpolator(new LinearInterpolator());
    this.g.setDuration(this.e);
    this.g.setFillAfter(true);
  }

  private void b()
  {
    c();
    this.c.setVisibility(4);
  }

  private void c()
  {
    this.b.clearAnimation();
    this.b.setVisibility(4);
  }

  private void e(azu paramazu)
  {
    if (!paramazu.h())
    {
      this.a.setVisibility(0);
      if ((this.h == null) || (TextUtils.isEmpty(this.h.a(2))))
        break label80;
      this.a.setText(this.h.a(2));
    }
    while (true)
    {
      if (this.i != null)
        this.d.setText(this.i.a(2));
      return;
      label80: this.a.setText(bae.global_release_to_refresh);
    }
  }

  private void f(azu paramazu)
  {
    this.a.setVisibility(0);
    if ((this.h != null) && (!TextUtils.isEmpty(this.h.a(1))))
      this.a.setText(this.h.a(1));
    while (true)
    {
      if (this.i != null)
        this.d.setText(this.i.a(1));
      return;
      if (paramazu.h())
        this.a.setText(getResources().getString(bae.global_pull_to_refresh));
      else
        this.a.setText(getResources().getString(bae.global_pull_down));
    }
  }

  protected void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, baf.PtrClassicHeader, 0, 0);
    if (paramAttributeSet != null)
      this.e = paramAttributeSet.getInt(baf.PtrClassicHeader_ptr_rotate_ani_time, this.e);
    a();
    paramAttributeSet = LayoutInflater.from(getContext()).inflate(bad.cube_ptr_classic_default_header, this);
    this.b = paramAttributeSet.findViewById(bac.ptr_classic_header_rotate_view);
    this.a = ((TextView)paramAttributeSet.findViewById(bac.ptr_classic_header_rotate_view_header_title));
    this.d = ((TextView)paramAttributeSet.findViewById(bac.ptr_classic_header_rotate_view_header_msg));
    this.c = ((ProgressBar)paramAttributeSet.findViewById(bac.ptr_classic_header_rotate_view_progressbar));
    b();
  }

  public void a(azt paramazt1, azt paramazt2)
  {
    this.h = paramazt1;
    this.i = paramazt2;
  }

  public void a(azu paramazu)
  {
    b();
  }

  public void a(azu paramazu, boolean paramBoolean, byte paramByte, bag parambag)
  {
    int j = paramazu.getOffsetToRefresh();
    int k = parambag.k();
    int m = parambag.j();
    if ((k < j) && (m >= j))
      if ((paramBoolean) && (paramByte == 2))
      {
        f(paramazu);
        if (this.b != null)
        {
          this.b.clearAnimation();
          this.b.startAnimation(this.g);
        }
      }
    do
    {
      do
        return;
      while ((k <= j) || (m > j) || (!paramBoolean) || (paramByte != 2));
      e(paramazu);
    }
    while (this.b == null);
    this.b.clearAnimation();
    this.b.startAnimation(this.f);
  }

  public void b(azu paramazu)
  {
    this.c.setVisibility(4);
    this.b.setVisibility(0);
    this.a.setVisibility(0);
    if ((this.h != null) && (!TextUtils.isEmpty(this.h.a(0))))
      this.a.setText(this.h.a(0));
    while ((this.i != null) && (!TextUtils.isEmpty(this.i.a(0))))
    {
      this.d.setText(this.i.a(0));
      return;
      if (paramazu.h())
        this.a.setText(getResources().getString(bae.global_pull_to_refresh));
      else
        this.a.setText(getResources().getString(bae.global_pull_down));
    }
    this.d.setVisibility(8);
  }

  public void c(azu paramazu)
  {
    c();
    this.c.setVisibility(0);
    this.a.setVisibility(0);
    if ((this.h != null) && (!TextUtils.isEmpty(this.h.a(3))))
      this.a.setText(this.h.a(3));
    while (true)
    {
      if (this.i != null)
        this.d.setText(this.i.a(3));
      return;
      this.a.setText(bae.clockweather_widget_data_error_text_updating);
    }
  }

  public void d(azu paramazu)
  {
    c();
    this.c.setVisibility(4);
    this.a.setVisibility(0);
    if ((this.h != null) && (!TextUtils.isEmpty(this.h.a(4))))
      this.a.setText(this.h.a(4));
    while (true)
    {
      if (this.i != null)
        this.d.setText(this.i.a(4));
      return;
      this.a.setText(getResources().getString(bae.global_done));
    }
  }

  public ProgressBar getLoadingProgressBar()
  {
    return this.c;
  }

  public void setRotateAniTime(int paramInt)
  {
    if ((paramInt == this.e) || (paramInt == 0))
      return;
    this.e = paramInt;
    a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azs
 * JD-Core Version:    0.6.2
 */