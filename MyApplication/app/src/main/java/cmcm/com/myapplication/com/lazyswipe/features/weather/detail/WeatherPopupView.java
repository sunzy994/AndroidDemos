package cmcm.com.myapplication.com.lazyswipe.features.weather.detail;

import a;
import ajx;
import ake;
import aky;
import akz;
import alg;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import aou;
import aqs;
import aro;
import asq;
import ast;
import atq;
import atr;
import att;
import azt;
import azu;
import azx;
import ci;
import com.lazyswipe.features.locate.CityQueryView;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.ui.FragmentContainer.WeatherSettingsActivity;
import es;
import gi;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import vs;
import vy;
import yb;

public class WeatherPopupView extends LinearLayout
  implements ajx, OnClickListener, att
{
  private static final String a = "Swipe." + WeatherPopupView.class.getSimpleName();
  private static WeatherPopupView o;
  private TextView b;
  private ViewPager c;
  private View d;
  private View e;
  private final List<alg> f = new ArrayList();
  private PtrClassicFrameLayout g;
  private final Context h;
  private boolean i = false;
  private PopupWindow.OnDismissListener j;
  private final atq k;
  private int l;
  private int m = 0;
  private final int n = getResources().getConfiguration().orientation;
  private boolean p;
  private int q;
  private ake r;
  private boolean s;
  private boolean t;
  private final BroadcastReceiver u = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ("BROADCAST_ACTION_HOME_KEY".equals(paramAnonymousIntent.getAction()))
        WeatherPopupView.this.d();
    }
  };

  public WeatherPopupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public WeatherPopupView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnClickListener(this);
    this.h = paramContext;
    paramInt = Calendar.getInstance().get(11);
    if ((paramInt >= 9) && (paramInt < 18))
      paramInt = i1;
    while (true)
    {
      setBackgroundDrawable(aou.a(paramInt));
      setPadding(getPaddingLeft(), aqs.ak() + getPaddingTop(), getPaddingRight(), getPaddingBottom());
      if (aqs.d())
        setPadding(getPaddingLeft(), (int)(getPaddingTop() * 1.2F), getPaddingRight(), getPaddingBottom());
      this.k = atq.a(this.h, new File(aro.c(), "weather").getAbsolutePath(), this);
      return;
    }
  }

  private void a(int paramInt)
  {
  }

  public static void a(Context paramContext, ake paramake, int paramInt)
  {
    a(paramContext, paramake, null, paramInt);
  }

  public static void a(Context paramContext, ake paramake, WindowManager.LayoutParams paramLayoutParams, int paramInt)
  {
    a(paramContext, paramake, paramLayoutParams, paramInt, false);
  }

  public static void a(Context paramContext, ake paramake, WindowManager.LayoutParams paramLayoutParams, int paramInt, boolean paramBoolean)
  {
    WeatherPopupView localWeatherPopupView = (WeatherPopupView)LayoutInflater.from(paramContext).inflate(2130968763, null);
    localWeatherPopupView.setWeatherServiceClient(paramake);
    localWeatherPopupView.q = paramInt;
    localWeatherPopupView.p = paramBoolean;
    localWeatherPopupView.a(paramLayoutParams);
    vy.a(paramContext, "B09");
  }

  private void a(View paramView, int paramInt)
  {
    if (paramView.getScrollY() != paramInt)
      paramView.scrollTo(0, paramInt);
  }

  private void a(WindowManager.LayoutParams paramLayoutParams)
  {
    o = this;
    SharedPreferences localSharedPreferences = vs.a(getContext());
    int i1 = localSharedPreferences.getInt("key_weather_details_times", 0) + 1;
    if (i1 <= 2)
      localSharedPreferences.edit().putInt("key_weather_details_times", i1).apply();
    if (this.i);
    do
    {
      return;
      a();
      if (paramLayoutParams == null)
        break;
    }
    while (!ast.a(getContext(), this, paramLayoutParams));
    this.i = true;
    return;
    try
    {
      yb.getInstance().addView(this, new ViewGroup.LayoutParams(-1, -1));
      this.i = true;
      return;
    }
    catch (Exception paramLayoutParams)
    {
    }
  }

  private void a(String paramString, float paramFloat)
  {
    if (!TextUtils.isEmpty(paramString))
      this.b.setVisibility(0);
    this.b.setText(paramString);
  }

  private void f()
  {
    if (this.t)
      return;
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("BROADCAST_ACTION_HOME_KEY");
      ci.a(getContext()).a(this.u, localIntentFilter);
      this.t = true;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void g()
  {
    if (!this.t)
      return;
    try
    {
      ci.a(getContext()).a(this.u);
      this.t = false;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static WeatherPopupView getInstance()
  {
    return o;
  }

  private void setPagerViews(List<alg> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        ((alg)localIterator.next()).setWeatherPopupView(this);
    }
    this.f.clear();
    this.f.addAll(paramList);
    this.c.setAdapter(new es()
    {
      public void destroyItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt, Object paramAnonymousObject)
      {
      }

      public int getCount()
      {
        return WeatherPopupView.b(WeatherPopupView.this).size();
      }

      public Object instantiateItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        View localView = (View)WeatherPopupView.b(WeatherPopupView.this).get(paramAnonymousInt);
        if ((localView != null) && (localView.getParent() != null))
          ((ViewGroup)localView.getParent()).removeView(localView);
        paramAnonymousViewGroup.addView((View)WeatherPopupView.b(WeatherPopupView.this).get(paramAnonymousInt), 0);
        WeatherPopupView.a(WeatherPopupView.this, localView, WeatherPopupView.e(WeatherPopupView.this));
        return WeatherPopupView.b(WeatherPopupView.this).get(paramAnonymousInt);
      }

      public boolean isViewFromObject(View paramAnonymousView, Object paramAnonymousObject)
      {
        return paramAnonymousView == paramAnonymousObject;
      }
    });
  }

  public void a()
  {
    Object localObject = new ArrayList(1);
    ((List)localObject).add(this.r.g());
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      City localCity = (City)((Iterator)localObject).next();
      RecentWeatherView localRecentWeatherView = (RecentWeatherView)inflate(getContext(), 2130968766, null);
      localRecentWeatherView.setCity(localCity);
      localRecentWeatherView.setBitmapLoader(this.k);
      localRecentWeatherView.a(this.r.a(localCity.b()));
      localArrayList.add(localRecentWeatherView);
    }
    setPagerViews(localArrayList);
    if (this.f.size() > 0)
    {
      a(((alg)this.f.get(0)).getTitle(), 1.0F);
      this.m = 0;
      this.c.setCurrentItem(this.m);
      ((alg)this.f.get(this.m)).b();
    }
    c();
    this.c.getAdapter().notifyDataSetChanged();
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, View paramView)
  {
    akz localakz1 = null;
    int i1 = this.f.indexOf(paramView);
    akz localakz2;
    if ((i1 >= 0) && (i1 < this.f.size()))
    {
      localakz2 = ((alg)this.f.get(i1)).getChart();
      if (i1 - 1 < 0)
        break label137;
    }
    label137: for (paramView = ((alg)this.f.get(i1 - 1)).getChart(); ; paramView = null)
    {
      if (i1 + 1 <= this.f.size() - 1)
        localakz1 = ((alg)this.f.get(i1 + 1)).getChart();
      aky.a(localakz2, paramView, localakz1);
      return;
    }
  }

  public void a(int paramInt, View paramView)
  {
    this.l = paramInt;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      alg localalg = (alg)localIterator.next();
      if (localalg != paramView)
        a((View)localalg, paramInt);
    }
  }

  public void a(atr paramatr)
  {
  }

  public void b()
  {
    this.s = true;
    this.g.d();
  }

  public void b(atr paramatr)
  {
  }

  public void c()
  {
    this.s = false;
    this.g.c();
  }

  public void d()
  {
    if (!this.i)
      return;
    try
    {
      ((ViewGroup)getParent()).removeView(this);
      label19: o = null;
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      while (true)
        ast.a(getContext(), this);
    }
    catch (Exception localException)
    {
      break label19;
    }
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
    {
      d();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public void e()
  {
    this.g.c();
  }

  public ake getWeatherServiceClient()
  {
    return this.r;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    f();
  }

  public void onClick(View paramView)
  {
    boolean bool = true;
    if (this.e == paramView)
    {
      if (yb.getInstance() != null)
      {
        yb.e(true);
        if (this.q == 3)
          break label62;
      }
      while (true)
      {
        com.lazyswipe.ui.WeatherSettingsFragment.a = bool;
        asq.d(getContext(), new Intent(getContext(), FragmentContainer.WeatherSettingsActivity.class));
        return;
        d();
        break;
        label62: bool = false;
      }
    }
    if (paramView.getId() == 2131755539)
    {
      CityQueryView.a(getContext());
      return;
    }
    d();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.n != paramConfiguration.orientation)
      d();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.i = false;
    g();
    atq.a(this.k);
    if ((this.p) && (this.r != null))
      this.r.d();
    try
    {
      if (this.j != null)
        this.j.onDismiss();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((TextView)findViewById(2131755539));
    this.b.setOnClickListener(this);
    this.c = ((ViewPager)findViewById(2131755542));
    this.b.setLayerType(1, null);
    this.d = findViewById(2131755540);
    this.e = findViewById(2131755518);
    this.c.setOnPageChangeListener(new gi()
    {
      public void a(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        float f = Math.abs(paramAnonymousFloat);
        if (f < 0.5F)
          paramAnonymousFloat = 1.0F - f * 2.0F;
        while (true)
        {
          WeatherPopupView.a(WeatherPopupView.this, ((alg)WeatherPopupView.b(WeatherPopupView.this).get(paramAnonymousInt1)).getTitle(), paramAnonymousFloat);
          return;
          f = f * 2.0F - 1.0F;
          if (paramAnonymousFloat > 0.0F)
          {
            paramAnonymousInt1 += 1;
            paramAnonymousFloat = f;
          }
          else
          {
            paramAnonymousInt1 -= 1;
            paramAnonymousFloat = f;
          }
        }
      }

      public void b_(int paramAnonymousInt)
      {
        ((alg)WeatherPopupView.b(WeatherPopupView.this).get(WeatherPopupView.a(WeatherPopupView.this))).d();
        WeatherPopupView.a(WeatherPopupView.this, paramAnonymousInt);
        WeatherPopupView.b(WeatherPopupView.this, paramAnonymousInt);
        ((alg)WeatherPopupView.b(WeatherPopupView.this).get(paramAnonymousInt)).b();
      }

      public void c(int paramAnonymousInt)
      {
      }
    });
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.g = ((PtrClassicFrameLayout)findViewById(2131755541));
    this.g.a(true);
    this.g.setPtrHandler(new azx()
    {
      public void a(azu paramAnonymousazu)
      {
        if (WeatherPopupView.b(WeatherPopupView.this).size() <= WeatherPopupView.d(WeatherPopupView.this).getCurrentItem())
          return;
        ((alg)WeatherPopupView.b(WeatherPopupView.this).get(WeatherPopupView.d(WeatherPopupView.this).getCurrentItem())).a();
      }

      public boolean a(azu paramAnonymousazu, View paramAnonymousView1, View paramAnonymousView2)
      {
        return WeatherPopupView.c(WeatherPopupView.this);
      }
    });
    this.g.a(new azt()
    {
      public CharSequence a(int paramAnonymousInt)
      {
        if (WeatherPopupView.b(WeatherPopupView.this).size() <= WeatherPopupView.d(WeatherPopupView.this).getCurrentItem())
          return "";
        azt localazt = ((alg)WeatherPopupView.b(WeatherPopupView.this).get(WeatherPopupView.d(WeatherPopupView.this).getCurrentItem())).getPTRTextGetter();
        if (localazt == null)
          return null;
        return localazt.a(paramAnonymousInt);
      }
    }
    , null);
    Object localObject = this.g.getPrgoressBar();
    if (localObject != null)
    {
      Drawable localDrawable1 = getResources().getDrawable(2130837778);
      if ((localDrawable1 instanceof a))
      {
        Drawable localDrawable2 = ((a)localDrawable1).a();
        localDrawable2.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        localDrawable2.setBounds(0, 0, asq.a(5.0F), asq.a(5.0F));
      }
      ((ProgressBar)localObject).setIndeterminateDrawable(localDrawable1);
      localObject = ((ProgressBar)localObject).getLayoutParams();
      int i1 = asq.a(15.0F);
      ((ViewGroup.LayoutParams)localObject).height = i1;
      ((ViewGroup.LayoutParams)localObject).width = i1;
    }
  }

  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.j = paramOnDismissListener;
  }

  public void setWeatherServiceClient(ake paramake)
  {
    this.r = paramake;
  }

  public void update(Observable paramObservable, Object paramObject)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.weather.detail.WeatherPopupView
 * JD-Core Version:    0.6.2
 */