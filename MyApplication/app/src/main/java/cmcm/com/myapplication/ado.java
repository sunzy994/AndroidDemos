package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.lazyswipe.features.leap.Curtain;
import com.lazyswipe.features.locate.CityQueryView;
import com.lazyswipe.features.weather.bean.AirQuality;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.features.weather.bean.WeatherForecast;
import com.lazyswipe.features.weather.detail.WeatherPopupView;
import java.io.File;
import java.util.Date;

public class ado extends FrameLayout
  implements ajw, OnClickListener, att
{
  private static final String a = "Swipe." + ado.class.getSimpleName();
  private static final int[] b = { -12813851, -12399875 };
  private static final SparseArray<int[]> c = new SparseArray(9);
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private ImageView i;
  private View j;
  private Curtain k;
  private boolean l;
  private aks m;
  private WeatherForecast n;
  private int o;
  private boolean p;
  private ake q;
  private atq r;

  static
  {
    c.put(0, new int[] { -12399875 });
    c.put(1, new int[] { -12399875 });
    c.put(1, new int[] { -12399875 });
    c.put(1001, new int[] { -11125336 });
    c.put(2, new int[] { -12600343, -12399875 });
    c.put(1002, new int[] { -14928800, -13678452 });
    c.put(3, new int[] { -13586724, -12399875 });
    c.put(5, new int[] { -6439718, -5060644 });
    c.put(12, new int[] { -8795661, -4200194 });
    c.put(16, new int[] { -3805195, -2229249 });
    c.put(17, new int[] { -145512, -5416 });
  }

  private void a(AirQuality paramAirQuality)
  {
    if (paramAirQuality == null)
    {
      this.g.setText("");
      this.g.setVisibility(8);
    }
    do
    {
      return;
      this.g.setVisibility(0);
      String str2 = paramAirQuality.a(getContext());
      String str1 = str2;
      if (!str2.contains(getResources().getString(2131231180)))
        str1 = getResources().getString(2131231179) + str2;
      this.g.setText(str1);
      this.g.setTextColor(-13421773);
    }
    while (this.g.getBackground() == null);
    if (!TextUtils.isEmpty(paramAirQuality.a()));
    while (true)
    {
      try
      {
        i1 = Integer.decode(paramAirQuality.a()).intValue();
        if (i1 != 0)
        {
          this.g.setTextColor(paramAirQuality.b());
          this.g.getBackground().setColorFilter(i1 | 0xFF000000, PorterDuff.Mode.SRC_IN);
          this.g.invalidate();
          return;
        }
      }
      catch (Exception localException)
      {
        i1 = 0;
        continue;
        this.g.getBackground().setColorFilter(null);
        continue;
      }
      int i1 = 0;
    }
  }

  private void setBottomBackground(int paramInt)
  {
    Object localObject = (int[])c.get(paramInt);
    if (localObject != null)
      if (1 != localObject.length)
        break label44;
    label44: for (localObject = new ColorDrawable(localObject[0]); ; localObject = new GradientDrawable(Orientation.TOP_BOTTOM, (int[])localObject))
    {
      asv.a(this.k.getMainArea(), (Drawable) localObject);
      return;
    }
  }

  private void setTopBackground(int paramInt)
  {
    if (paramInt == 0)
      asv.a(this.i, new GradientDrawable(Orientation.TOP_BOTTOM, b));
    Object localObject;
    do
    {
      return;
      localObject = "http://res.lazyswipe.cn/" + "weather/" + aqs.b(getContext(), 720) + '/' + "wb_" + paramInt + '_' + 1 + ".jpg";
      setTag(Integer.valueOf(paramInt));
      localObject = this.r.a(new atr()
      {
        public String a()
        {
          return this.a;
        }
      });
    }
    while (localObject == null);
    asv.a(this.i, ((atr) localObject).e);
  }

  public void a()
  {
    if (17 == yb.a.n)
      onClick(this);
  }

  public void a(aks paramaks, WeatherForecast paramWeatherForecast)
  {
    this.m = paramaks;
    this.n = paramWeatherForecast;
    Context localContext = getContext();
    TextView localTextView = this.f;
    if (vs.R(getContext()));
    int i2;
    for (int i1 = 2131231204; ; i1 = 2131231205)
    {
      localTextView.setText(i1);
      if (paramaks == null)
        break;
      this.e.setText(paramaks.b(localContext));
      i1 = akc.a(this.m.d);
      this.h.setText(this.m.a(getContext()));
      a(this.m.c());
      if (i1 == 0)
        this.j.setVisibility(0);
      if (this.j.getVisibility() == 0)
        this.j.setVisibility(8);
      i2 = i1;
      if (this.p)
        i2 = i1 + 1000;
      if (this.o != i2)
      {
        this.o = i2;
        setBottomBackground(i2);
        setTopBackground(i2);
      }
      if ((WeatherPopupView.getInstance() != null) && (this.q != null))
        WeatherPopupView.getInstance().a();
      return;
    }
    paramaks = akc.a(paramWeatherForecast, new Date(), 0);
    if ((paramaks != null) && (paramaks.a() != null))
    {
      this.e.setText(paramaks.e(localContext));
      i2 = paramaks.e();
      i1 = akc.a(i2);
      this.h.setText(akc.a(getContext(), i2));
    }
    while (true)
    {
      a(null);
      break;
      this.h.setText("");
      this.f.setText("");
      i1 = 0;
    }
  }

  public void a(Time paramTime)
  {
    boolean bool = this.p;
    this.p = akc.b(paramTime.hour);
    if (bool != this.p)
      a(this.m, this.n);
  }

  public void a(atr paramatr)
  {
    if ((paramatr != null) && (getTag() != null) && (((Integer)getTag()).intValue() == this.o))
      asv.a(this.i, paramatr.e);
  }

  public void a(Curtain paramCurtain)
  {
    this.k = paramCurtain;
    this.p = akc.a(new Date());
    setBottomBackground(0);
    setTopBackground(0);
  }

  public void a(City paramCity)
  {
    if (paramCity == null)
    {
      this.l = false;
      this.d.setText(2131230793);
      this.j.setVisibility(0);
      return;
    }
    this.l = true;
    this.d.setText(paramCity.a());
  }

  public void b(atr paramatr)
  {
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode())
    {
      this.q = new ake(getContext(), this);
      this.q.c();
      this.r = atq.a(getContext(), new File(aro.c(), "weather").getAbsolutePath(), this);
    }
  }

  public void onClick(View paramView)
  {
    if (paramView == this)
    {
      if ((this.l) || (17 == yb.a.n))
      {
        yb.a.n = 0;
        WeatherPopupView.a(getContext(), this.q, 2);
        this.k.setAlpha(1.0F);
        this.k.getLeapView().setAlpha(1.0F);
      }
      return;
    }
    getContext();
    switch (paramView.getId())
    {
    default:
      return;
    case 2131755104:
    case 2131755114:
    }
    CityQueryView.a(getContext());
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (!isInEditMode())
    {
      this.q.d();
      atq.a(this.r);
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((TextView) asr.a(this, 2131755114));
    this.j = asr.a(this, 2131755104);
    this.e = ((TextView) asr.a(this, 2131755108));
    this.h = ((TextView) asr.a(this, 2131755355));
    this.g = ((TextView) asr.a(this, 2131755354));
    this.i = ((ImageView) asr.a(this, 2131755352));
    this.f = ((TextView) asr.a(this, 2131755353));
    Typeface localTypeface = Typeface.createFromAsset(getContext().getAssets(), akc.a());
    if (localTypeface != null)
    {
      this.e.setTypeface(localTypeface);
      this.f.setTypeface(localTypeface);
    }
    this.d.setOnClickListener(this);
    this.j.setOnClickListener(this);
    setOnClickListener(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ado
 * JD-Core Version:    0.6.2
 */