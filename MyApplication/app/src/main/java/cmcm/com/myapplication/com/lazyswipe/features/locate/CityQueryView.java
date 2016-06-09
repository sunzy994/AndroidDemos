package cmcm.com.myapplication.com.lazyswipe.features.locate;

import afj;
import afk;
import afl;
import ajw;
import ajy;
import ajz;
import ake;
import aks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff.Mode;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqs;
import arl;
import asr;
import ast;
import avx;
import ci;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.features.weather.bean.WeatherForecast;
import com.lazyswipe.features.weather.detail.WeatherPopupView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import tk;
import vv;
import yb;

public class CityQueryView extends RelativeLayout
  implements ajw, ajz, View.OnClickListener
{
  private static final Set<String> a = new HashSet();
  private BroadcastReceiver A = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent == null) || (paramAnonymousIntent.getAction() == null));
      while (!"BROADCAST_ACTION_HOME_KEY".equals(paramAnonymousIntent.getAction()))
        return;
      CityQueryView.l(CityQueryView.this);
    }
  };
  private ListView b;
  private GridView c;
  private EditText d;
  private ImageButton e;
  private ImageView f;
  private InputMethodManager g = null;
  private afk h;
  private afj i;
  private TextView j;
  private final List<Runnable> k = new ArrayList();
  private View l;
  private City m;
  private ajy n = null;
  private View o;
  private TextView p;
  private ImageView q;
  private ListView r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private ake w;
  private final Object x = new Object();
  private final TextWatcher y = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      CityQueryView localCityQueryView = CityQueryView.this;
      if (paramAnonymousEditable.length() > 0);
      for (boolean bool = true; ; bool = false)
      {
        CityQueryView.c(localCityQueryView, bool);
        CityQueryView.k(CityQueryView.this);
        return;
      }
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }
  };
  private final Handler z = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 4)
        CityQueryView.o(CityQueryView.this).a(CityQueryView.a(CityQueryView.this).getText().toString().toLowerCase(), 1);
      while (paramAnonymousMessage.what != 5)
        return;
      CityQueryView.o(CityQueryView.this).a(CityQueryView.a(CityQueryView.this).getText().toString().toLowerCase(), CityQueryView.c(CityQueryView.this).a() + 1);
    }
  };

  static
  {
    a.add("101010100");
    a.add("101020100");
    a.add("101030100");
    a.add("101040100");
  }

  public CityQueryView(Context paramContext)
  {
    super(paramContext);
    c();
  }

  public CityQueryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }

  public static void a(Context paramContext)
  {
    CityQueryView localCityQueryView = (CityQueryView)asr.a(paramContext, 2130968731);
    localCityQueryView.setPadding(0, aqs.ak(), 0, 0);
    yb localyb = yb.getInstance();
    if (localyb != null)
    {
      localCityQueryView.v = false;
      localyb.addView(localCityQueryView, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    localCityQueryView.v = true;
    ast.a(paramContext, localCityQueryView, ast.a(paramContext));
  }

  private void a(Collection<City> paramCollection, boolean paramBoolean, int paramInt)
  {
    if (this.h == null)
      this.h = new afk(this, getContext(), 2130968615, this.b, this.t, false);
    if (paramInt <= 1)
    {
      if (this.b.getFooterViewsCount() == 0)
        this.b.addFooterView(afk.a(this.h));
      this.b.setAdapter(this.h);
    }
    this.h.a(paramCollection, paramBoolean, paramInt);
    this.b.setVisibility(0);
    this.c.setVisibility(8);
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      if ((this.t) && (!arl.h(getContext())))
        this.j.setText(2131230814);
      while (true)
      {
        this.j.setVisibility(0);
        this.b.setVisibility(8);
        return;
        this.j.setText(2131230815);
      }
    }
    this.j.setVisibility(8);
    this.b.setVisibility(0);
  }

  private void a(List<City> paramList)
  {
    if (!this.u)
      return;
    this.i.a(paramList);
    this.c.setAdapter(null);
    this.c.setAdapter(this.i);
  }

  private void a(boolean paramBoolean)
  {
    if (this.m != null)
    {
      this.w.i();
      if (paramBoolean)
      {
        final List localList = this.w.a(this.m);
        this.k.add(new Runnable()
        {
          public void run()
          {
            CityQueryView.a(CityQueryView.this, localList);
          }
        });
      }
    }
    try
    {
      if (WeatherPopupView.getInstance() != null)
        WeatherPopupView.getInstance().b();
      k();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
  }

  private void c()
  {
    this.t = false;
    this.u = false;
    this.w = new ake(getContext(), this);
    this.w.c(false);
    this.w.b(true);
  }

  private void d()
  {
    this.d = ((EditText)findViewById(2131755423));
    this.e = ((ImageButton)findViewById(2131755422));
    this.f = ((ImageView)findViewById(2131755421));
    this.b = ((ListView)findViewById(2131755424));
    this.j = ((TextView)findViewById(2131755425));
    this.c = ((GridView)findViewById(2131755427));
    this.l = findViewById(2131755428);
    ((TextView)findViewById(2131755419)).setText(17039360);
    this.f.setImageResource(2130837782);
    this.f.setColorFilter(-10066330, PorterDuff.Mode.SRC_IN);
    this.e.setImageResource(2130837579);
    this.e.setColorFilter(-8026747, PorterDuff.Mode.SRC_IN);
    this.o = findViewById(2131755429);
    this.r = ((ListView)findViewById(2131755432));
    this.p = ((TextView)findViewById(2131755430));
    this.q = ((ImageView)findViewById(2131755431));
    this.q.setColorFilter(-8553091, PorterDuff.Mode.SRC_IN);
    e();
    f();
    h();
    Context localContext = getContext();
    this.g = ((InputMethodManager)localContext.getSystemService("input_method"));
    boolean bool;
    if (this.d.getText().length() > 0)
    {
      bool = true;
      b(bool);
      if (this.n == null)
        this.n = new ajy(localContext, localContext.getPackageName());
      if (!this.t)
        break label361;
      this.n.a(this);
    }
    while (true)
    {
      this.d.removeTextChangedListener(this.y);
      this.d.addTextChangedListener(this.y);
      findViewById(2131755419).setOnClickListener(this);
      this.f.setOnClickListener(this);
      return;
      bool = false;
      break;
      label361: n();
    }
  }

  private void e()
  {
    this.e.setOnClickListener(this);
    if (this.m != null)
    {
      this.d.setText(this.m.a());
      this.d.selectAll();
    }
    this.d.clearFocus();
    this.d.setOnClickListener(this);
  }

  private void f()
  {
    this.b.setOnItemClickListener(new OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (paramAnonymousView == afk.a(CityQueryView.c(CityQueryView.this)))
        {
          if (afk.b(CityQueryView.c(CityQueryView.this)))
            return;
          afk.a(CityQueryView.c(CityQueryView.this), true);
          CityQueryView.c(CityQueryView.this).b();
          CityQueryView.a(CityQueryView.this, true);
          CityQueryView.d(CityQueryView.this).removeMessages(5);
          CityQueryView.d(CityQueryView.this).removeMessages(4);
          CityQueryView.d(CityQueryView.this).sendEmptyMessage(5);
          return;
        }
        paramAnonymousAdapterView = (City)((TextView)paramAnonymousView.findViewById(2131755190)).getTag();
        CityQueryView.a(CityQueryView.this, true);
        CityQueryView.a(CityQueryView.this, paramAnonymousAdapterView);
        CityQueryView.a(CityQueryView.this).removeTextChangedListener(CityQueryView.e(CityQueryView.this));
        CityQueryView.a(CityQueryView.this).setText(CityQueryView.f(CityQueryView.this).a());
        CityQueryView.a(CityQueryView.this).selectAll();
        CityQueryView.a(CityQueryView.this).addTextChangedListener(CityQueryView.e(CityQueryView.this));
        CityQueryView.g(CityQueryView.this);
      }
    });
    this.b.setScrollbarFadingEnabled(true);
  }

  private void g()
  {
    this.g.hideSoftInputFromWindow(this.d.getWindowToken(), 0);
    this.k.add(new Runnable()
    {
      public void run()
      {
        CityQueryView.h(CityQueryView.this);
      }
    });
    a(true);
    vv.a().a("B13");
  }

  private String getLocaleLanguage()
  {
    Locale localLocale = Locale.getDefault();
    return String.format("%s-%s", new Object[] { localLocale.getLanguage(), localLocale.getCountry() });
  }

  private void h()
  {
    if (!this.u)
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setNumColumns(4);
    this.c.setOnItemClickListener(new OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (paramAnonymousView.getTag() == CityQueryView.i(CityQueryView.this))
        {
          CityQueryView.j(CityQueryView.this).h();
          return;
        }
        CityQueryView.a(CityQueryView.this, true);
        CityQueryView.a(CityQueryView.this, (City)paramAnonymousView.getTag());
        CityQueryView.b(CityQueryView.this, true);
      }
    });
  }

  private void i()
  {
    if (this.u)
    {
      this.o.setVisibility(8);
      return;
    }
    this.p.setText(2131230791);
    this.q.setImageResource(2130837780);
    this.q.setOnClickListener(this);
    afk localafk = new afk(this, getContext(), 2130968615, this.r, this.t, true);
    List localList = this.w.j();
    ArrayList localArrayList = new ArrayList();
    int i2 = localList.size();
    int i1 = 0;
    i2 -= 1;
    if (i2 >= 0)
    {
      if ((this.t) && ((TextUtils.isEmpty(((City)localList.get(i2)).a)) || ("null".equals(((City)localList.get(i2)).a))))
      {
        localList.remove(i2);
        i1 = 1;
      }
      while (true)
      {
        i2 -= 1;
        break;
        localArrayList.add(localList.get(i2));
      }
    }
    if (i1 != 0);
    localafk.a(localArrayList, false, 1);
    this.r.setAdapter(localafk);
    l();
    this.r.setOnItemClickListener(new OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        CityQueryView.a(CityQueryView.this, true);
        if ((paramAnonymousView.getTag() instanceof City))
          CityQueryView.a(CityQueryView.this, (City)paramAnonymousView.getTag());
        while (true)
        {
          CityQueryView.b(CityQueryView.this, true);
          return;
          if ((paramAnonymousView.getTag() instanceof afl))
          {
            paramAnonymousAdapterView = (afl)paramAnonymousView.getTag();
            if (afl.a(paramAnonymousAdapterView))
            {
              CityQueryView.j(CityQueryView.this).h();
              return;
            }
            CityQueryView.a(CityQueryView.this, paramAnonymousAdapterView.d);
          }
        }
      }
    });
  }

  private void j()
  {
    a(false);
  }

  private void k()
  {
    if (this.v)
    {
      ast.a(getContext(), this);
      return;
    }
    ((ViewGroup)getParent()).removeView(this);
  }

  private void l()
  {
    if (this.r.getAdapter().getCount() > 0)
      this.o.setVisibility(0);
    if (this.r.getAdapter().getCount() > 1)
    {
      this.q.setVisibility(0);
      this.p.setVisibility(0);
      return;
    }
    this.q.setVisibility(8);
    this.p.setVisibility(8);
  }

  private void m()
  {
    this.d.setText("");
    this.b.setVisibility(8);
    if (this.u)
      this.c.setVisibility(0);
  }

  private void n()
  {
    if (!this.u);
    do
    {
      do
        return;
      while ((this.i != null) && (!this.i.isEmpty()));
      this.i = new afj(this, getContext(), 2130968614);
      this.c.setAdapter(this.i);
    }
    while ((this.d.getText() != null) && (!TextUtils.isEmpty(this.d.getText())));
    this.b.setVisibility(8);
    this.j.setVisibility(8);
    this.c.setVisibility(0);
    this.g.hideSoftInputFromWindow(this.d.getWindowToken(), 0);
  }

  private void o()
  {
    if (this.n == null)
      return;
    Object localObject = this.d.getText().toString().toLowerCase();
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      this.b.setVisibility(8);
      if (!this.u)
      {
        localObject = this.r.getAdapter();
        if ((localObject != null) && (((Adapter)localObject).getCount() > 0))
          this.o.setVisibility(0);
      }
      while (true)
      {
        this.j.setVisibility(8);
        this.l.setVisibility(8);
        return;
        this.c.setVisibility(0);
      }
    }
    if (!this.t);
    for (localObject = this.n.a((String)localObject, getLocaleLanguage()); ; localObject = null)
    {
      this.o.setVisibility(8);
      if (!this.t)
      {
        a((Collection)localObject, false, 1);
        return;
      }
      if (arl.h(getContext()))
      {
        this.z.removeMessages(4);
        this.z.removeMessages(5);
        this.z.sendEmptyMessageDelayed(4, 500L);
        setQueryLoading(true);
        this.b.setVisibility(8);
        this.j.setVisibility(8);
        return;
      }
      a(null, false, 1);
      return;
    }
  }

  private void setQueryLoading(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l.setVisibility(0);
      return;
    }
    this.l.setVisibility(8);
  }

  public void a()
  {
    i();
  }

  public void a(aks paramaks, WeatherForecast paramWeatherForecast)
  {
  }

  public void a(Time paramTime)
  {
  }

  public void a(City paramCity)
  {
    if ((paramCity != null) && (!paramCity.equals(this.m)))
    {
      this.m = paramCity;
      j();
    }
  }

  public void a(String paramString, List<City> paramList, boolean paramBoolean, int paramInt)
  {
    String str = this.d.getText().toString().toLowerCase();
    if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString)))
    {
      a(paramList, paramBoolean, paramInt);
      setQueryLoading(false);
    }
  }

  public void b()
  {
    a(null, false, 1);
    setQueryLoading(false);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i1 = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() != 1)
      return super.dispatchKeyEvent(paramKeyEvent);
    if (i1 == 84)
    {
      this.d.setFocusable(true);
      this.d.requestFocus();
      return true;
    }
    if (i1 == 4)
    {
      if (this.c.getVisibility() == 0)
      {
        if (((afj)this.c.getAdapter()).a())
          return true;
        try
        {
          k();
          return true;
        }
        catch (Throwable localThrowable)
        {
        }
      }
      if (this.v)
      {
        k();
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.w.c();
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("BROADCAST_ACTION_HOME_KEY");
      ci.a(getContext()).a(this.A, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onClick(View paramView)
  {
    if ((paramView == this.d) || (paramView == this.f))
      if (paramView == this.f)
        this.d.requestFocus();
    try
    {
      this.g.showSoftInput(this.d, 1);
      return;
      if ((paramView == this.b) || (paramView == this.c) || (paramView.getId() == 2131755419) || ((this.t) && (paramView == this)))
      {
        postDelayed(new Runnable()
        {
          public void run()
          {
            try
            {
              CityQueryView.l(CityQueryView.this);
              return;
            }
            catch (Throwable localThrowable)
            {
            }
          }
        }
        , 80L);
        return;
      }
      if (paramView == this.q)
      {
        new avx(getContext()).c(2131230951).g(2131230792).a(17039370, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            CityQueryView.j(CityQueryView.this).k();
            afk localafk = (afk)CityQueryView.m(CityQueryView.this).getAdapter();
            localafk.a(new ArrayList(), false, 1);
            localafk.notifyDataSetChanged();
            CityQueryView.n(CityQueryView.this);
            paramAnonymousDialogInterface.dismiss();
          }
        }).e(17039360).f(-1).b();
        return;
      }
      m();
      this.g.hideSoftInputFromWindow(this.d.getWindowToken(), 0);
      return;
    }
    catch (Exception paramView)
    {
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.w.d();
    if (this.n != null)
      this.n.b();
    try
    {
      ci.a(getContext()).a(this.A);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    d();
  }

  public void setInitShowing(boolean paramBoolean)
  {
    if ((!this.t) || (!paramBoolean))
      this.g.hideSoftInputFromWindow(this.d.getWindowToken(), 0);
    while ((this.r != null) && (this.r.getCount() > 0))
      return;
    this.d.requestFocus();
    post(new Runnable()
    {
      public void run()
      {
        try
        {
          CityQueryView.b(CityQueryView.this).showSoftInput(CityQueryView.a(CityQueryView.this), 1);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.locate.CityQueryView
 * JD-Core Version:    0.6.2
 */