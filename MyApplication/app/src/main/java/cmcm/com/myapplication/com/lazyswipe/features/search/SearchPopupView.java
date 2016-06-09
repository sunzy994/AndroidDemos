package cmcm.com.myapplication.com.lazyswipe.features.search;

import abd;
import agj;
import ago;
import agp;
import agq;
import agu;
import agv;
import agx;
import agz;
import aha;
import ahc;
import ahe;
import ahf;
import ahk;
import ahw;
import ahx;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PorterDuff.Mode;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import aqs;
import arl;
import aso;
import asq;
import asv;
import atq;
import atr;
import att;
import atw;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vj;
import vy;
import xq;
import yb;

public class SearchPopupView extends RelativeLayout
  implements OnClickListener, OnKeyListener, att
{
  public static final int[] a = new int[2];
  private View A;
  private View B;
  private ImageView C;
  private View D;
  private agu E;
  private boolean F;
  private int G = 0;
  private SearchWebView H;
  private boolean I = false;
  private String J;
  private int K;
  private boolean L;
  private NativeSearchWebView M;
  private final int N;
  private View O;
  private boolean P = false;
  private boolean Q = false;
  public final Handler b = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.what;
    }
  };
  private atq c;
  private xq d;
  private boolean e;
  private EditText f;
  private ImageView g;
  private ImageView h;
  private View i;
  private agp j;
  private agp k;
  private ScrollView l;
  private ScrollView m;
  private int n;
  private int o;
  private ago p;
  private final List<agj<? extends ahk>> q = new ArrayList();
  private final List<agj<? extends ahk>> r = new ArrayList();
  private final int[] s = new int[2];
  private final int[] t = new int[2];
  private final int u;
  private View v;
  private View w;
  private View x;
  private View y;
  private View z;

  public SearchPopupView(Context paramContext)
  {
    this(paramContext, null);
  }

  public SearchPopupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnKeyListener(this);
    this.u = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.N = asq.a(30.0F);
    this.E = ahe.e(getContext().getApplicationContext());
    paramContext = getContext().getApplicationContext();
    if (this.E == null)
      bool = true;
    ahe.a(paramContext, bool, new Runnable()
    {
      public void run()
      {
        List localList = ahe.f(SearchPopupView.this.getContext().getApplicationContext());
        if ((localList != null) && (localList.size() > 0) && (SearchPopupView.a(SearchPopupView.this) == null))
          SearchPopupView.a(SearchPopupView.this, ahe.e(SearchPopupView.this.getContext().getApplicationContext()));
      }
    });
  }

  private void a(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.q.iterator();
      while (((Iterator)localObject).hasNext())
        ((agj)((Iterator)localObject).next()).a(this.f.getText().toString());
      if (this.m.getVisibility() == 0)
        return;
      e();
      this.m.setVisibility(0);
      this.l.setVisibility(8);
    }
    for (Object localObject = this.m; ; localObject = this.l)
    {
      ((View)localObject).setAlpha(0.0F);
      ((View)localObject).animate().alpha(1.0F).setDuration(300L).start();
      return;
      if (this.l.getVisibility() == 0)
        break;
      this.m.setVisibility(8);
      this.l.setVisibility(0);
    }
  }

  private void b(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }

  private void c()
  {
    if (!this.P)
      this.P = true;
    while (true)
    {
      return;
      if (this.O != null)
        this.O.setVisibility(0);
      this.O.bringToFront();
      this.O.setAlpha(0.0F);
      asv.b(this.O.animate().alpha(1.0F).setDuration(200L), new Runnable()
      {
        public void run()
        {
          asv.b(SearchPopupView.e(SearchPopupView.this).animate(), null);
          SearchPopupView.g(SearchPopupView.this).a();
        }
      });
      postDelayed(new Runnable()
      {
        public void run()
        {
          SearchPopupView.i(SearchPopupView.this).getLocationOnScreen(SearchPopupView.h(SearchPopupView.this));
          SearchPopupView.k(SearchPopupView.this).getLocationOnScreen(SearchPopupView.j(SearchPopupView.this));
          int i = SearchPopupView.l(SearchPopupView.this).getMeasuredHeight();
          int k = i;
          View localView;
          if (i <= SearchPopupView.m(SearchPopupView.this).getMeasuredHeight())
          {
            int j = 0;
            for (i = 0; ; i = k)
            {
              k = i;
              if (j >= SearchPopupView.l(SearchPopupView.this).getChildCount())
                break;
              localView = SearchPopupView.l(SearchPopupView.this).getChildAt(j);
              k = i;
              if (localView.getVisibility() != 8)
              {
                k = localView.getMeasuredHeight();
                int m = ((ViewGroup.MarginLayoutParams)localView.getLayoutParams()).bottomMargin;
                k = i + (((ViewGroup.MarginLayoutParams)localView.getLayoutParams()).topMargin + (k + m));
              }
              j += 1;
            }
          }
          if (k - SearchPopupView.n(SearchPopupView.this) < SearchPopupView.m(SearchPopupView.this).getMeasuredHeight())
          {
            localView = new View(SearchPopupView.this.getContext());
            SearchPopupView.l(SearchPopupView.this).addView(localView, new LayoutParams(-1, SearchPopupView.m(SearchPopupView.this).getMeasuredHeight() - (k - SearchPopupView.n(SearchPopupView.this))));
            SearchPopupView.this.postDelayed(new Runnable()
            {
              public void run()
              {
                SearchPopupView.m(SearchPopupView.this).scrollTo(0, SearchPopupView.o(SearchPopupView.this));
              }
            }
            , 10L);
            return;
          }
          SearchPopupView.m(SearchPopupView.this).scrollTo(0, SearchPopupView.o(SearchPopupView.this));
        }
      }
      , 10L);
      if (this.L)
      {
        postDelayed(new Runnable()
        {
          public void run()
          {
            SearchPopupView.this.onClick(SearchPopupView.b(SearchPopupView.this));
          }
        }
        , 50L);
        return;
      }
      if ((this.E == null) || (TextUtils.isEmpty(this.E.c())))
      {
        Iterator localIterator = this.r.iterator();
        do
          if (!localIterator.hasNext())
            break;
        while (((agj)localIterator.next()).getVisibility() != 0);
        for (int i1 = 1; i1 == 0; i1 = 0)
        {
          this.f.postDelayed(new Runnable()
          {
            public void run()
            {
              SearchPopupView.p(SearchPopupView.this).requestFocus();
              SearchPopupView.q(SearchPopupView.this);
            }
          }
          , 100L);
          return;
        }
      }
    }
  }

  private void c(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }

  private void c(String paramString)
  {
    if (this.E == null)
      this.E = ahe.e(getContext().getApplicationContext());
    if ((this.E == null) && (arl.i(getContext())))
    {
      this.f.clearFocus();
      aso.a(getContext(), 2131230736);
      if (!this.I);
    }
    while ((d(paramString)) || (this.m.getVisibility() == 0))
    {
      return;
      this.I = true;
      new Thread()
      {
        public void run()
        {
          ahe.d(SearchPopupView.this.getContext().getApplicationContext());
          List localList = ahe.f(SearchPopupView.this.getContext().getApplicationContext());
          if ((localList != null) && (localList.size() > 0))
            SearchPopupView.a(SearchPopupView.this, ahe.e(SearchPopupView.this.getContext().getApplicationContext()));
          SearchPopupView.e(SearchPopupView.this, false);
        }
      }
      .start();
    }
    a(true);
  }

  private void d()
  {
    this.c = atq.a(getContext(), ahe.a, this);
    this.d = xq.a(getContext());
    this.g = ((ImageView)findViewById(2131755460));
    this.h = ((ImageView)findViewById(2131755391));
    this.i = findViewById(2131755462);
    this.v = findViewById(2131755463);
    this.w = findViewById(2131755464);
    this.x = findViewById(2131755466);
    this.y = findViewById(2131755465);
    this.z = findViewById(2131755467);
    this.A = findViewById(2131755197);
    this.A.setOnClickListener(this);
    this.B = findViewById(2131755050);
    this.B.setOnClickListener(this);
    this.C = ((ImageView)findViewById(2131755458));
    this.D = findViewById(2131755459);
    this.i.setOnClickListener(this);
    ((ImageView)findViewById(2131755087)).setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
    this.h.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
    this.f = ((EditText)findViewById(2131755461));
    this.f.setOnClickListener(this);
    this.f.setOnFocusChangeListener(new OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        int i = 4;
        ImageView localImageView;
        if (paramAnonymousBoolean)
        {
          if (SearchPopupView.r(SearchPopupView.this).getVisibility() == 0)
          {
            SearchPopupView.r(SearchPopupView.this).setVisibility(8);
            SearchPopupView.m(SearchPopupView.this).setVisibility(0);
          }
          SearchPopupView.a(SearchPopupView.this, null);
          if (!paramAnonymousBoolean)
            break label124;
          paramAnonymousView = SearchPopupView.p(SearchPopupView.this).getText().toString().trim();
          localImageView = SearchPopupView.t(SearchPopupView.this);
          if (paramAnonymousView.length() != 0)
            break label118;
        }
        while (true)
        {
          localImageView.setVisibility(i);
          return;
          if (SearchPopupView.s(SearchPopupView.this).getVisibility() != 0)
            break;
          SearchPopupView.b(SearchPopupView.this, false);
          break;
          label118: i = 0;
        }
        label124: SearchPopupView.t(SearchPopupView.this).setVisibility(4);
      }
    });
    this.f.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = 4;
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().trim();
        if (SearchPopupView.p(SearchPopupView.this).hasFocus())
        {
          Object localObject = SearchPopupView.t(SearchPopupView.this);
          if (paramAnonymousCharSequence.length() == 0);
          while (true)
          {
            ((ImageView)localObject).setVisibility(paramAnonymousInt1);
            SearchPopupView.r(SearchPopupView.this).c();
            localObject = SearchPopupView.u(SearchPopupView.this).iterator();
            while (((Iterator)localObject).hasNext())
              ((agj)((Iterator)localObject).next()).a(paramAnonymousCharSequence);
            paramAnonymousInt1 = 0;
          }
        }
        SearchPopupView.t(SearchPopupView.this).setVisibility(4);
      }
    });
    if (!TextUtils.isEmpty(this.J))
      this.f.setHint(this.J);
    this.l = ((ScrollView)findViewById(2131755451));
    this.j = new agp(getContext());
    this.j.setOrientation(1);
    this.l.addView(this.j);
    try
    {
      Object localObject = ScrollView.class.getDeclaredField("mOverscrollDistance");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(this.l, Integer.valueOf(this.N));
      try
      {
        localObject = ScrollView.class.getDeclaredField("mOverflingDistance");
        ((Field)localObject).setAccessible(true);
        ((Field)localObject).set(this.l, Integer.valueOf(this.N));
        label402: this.m = ((ScrollView)findViewById(2131755452));
        this.k = new agp(getContext());
        this.k.setOrientation(1);
        this.m.addView(this.k);
        this.q.add(new agz(getContext(), null, this.d));
        this.q.add(new aha(getContext(), null));
        if ((this.E != null) && (this.E.e()))
          this.r.add(new agx(getContext(), getContext().getString(2131231223), this.c));
        if (abd.a())
          this.r.add(new ahc(getContext(), this.c));
        localObject = new agv(getContext(), getContext().getString(2131231222), this.c);
        this.r.add(localObject);
        localObject = this.q.iterator();
        while (((Iterator)localObject).hasNext())
          ((agj)((Iterator)localObject).next()).setCallback(this);
        localObject = this.r.iterator();
        while (((Iterator)localObject).hasNext())
          ((agj)((Iterator)localObject).next()).setCallback(this);
        this.D.setBackgroundColor(ahx.b(getContext()).i());
        if (!aqs.B())
          this.e = false;
        agj localagj;
        while (true)
        {
          localObject = this.r.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localagj = (agj)((Iterator)localObject).next();
            this.j.addView(localagj, localagj.getLayoutParams());
            localagj.a("");
          }
          localObject = ahe.g(getContext());
          if ((localObject != null) && (atw.b(((ahf)localObject).b)))
          {
            this.C.setImageBitmap(((ahf)localObject).b);
            this.D.setBackgroundColor(((ahf)localObject).c);
            localObject = new View(getContext());
            this.j.addView((View)localObject, new LayoutParams(-1, asq.a(206.0F)));
            this.e = true;
          }
          else
          {
            this.e = false;
          }
        }
        localObject = this.q.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localagj = (agj)((Iterator)localObject).next();
          this.k.addView(localagj, localagj.getLayoutParams());
        }
        localObject = this.r.iterator();
        do
          if (!((Iterator)localObject).hasNext())
            break;
        while (((agj)((Iterator)localObject).next()).getVisibility() != 0);
        i1 = 1;
        if (i1 == 0)
          this.e = false;
        this.f.setOnKeyListener(this);
        this.h.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        localObject = new agq()
        {
          private float b;
          private float c;

          public void a(MotionEvent paramAnonymousMotionEvent)
          {
            int j = 0;
            switch (paramAnonymousMotionEvent.getAction())
            {
            case 1:
            default:
              SearchPopupView.a(SearchPopupView.this, 0);
            case 0:
            case 2:
            }
            do
            {
              return;
              SearchPopupView.a(SearchPopupView.this, 0);
              this.b = paramAnonymousMotionEvent.getX();
              this.c = paramAnonymousMotionEvent.getY();
              SearchPopupView.a[0] = ((int)this.b + SearchPopupView.m(SearchPopupView.this).getLeft());
              SearchPopupView.a[1] = ((int)this.c + SearchPopupView.m(SearchPopupView.this).getTop());
              SearchPopupView.c(SearchPopupView.this, false);
              SearchPopupView.v(SearchPopupView.this);
              return;
            }
            while (SearchPopupView.w(SearchPopupView.this) != 0);
            float f1 = Math.abs(paramAnonymousMotionEvent.getX() - this.b);
            float f2 = Math.abs(paramAnonymousMotionEvent.getY() - this.c);
            int i;
            if (f1 > SearchPopupView.x(SearchPopupView.this))
            {
              i = 1;
              label178: if (f2 > SearchPopupView.x(SearchPopupView.this))
                j = 1;
              if ((i != 0) || (j != 0))
              {
                if (f1 <= f2)
                  break label256;
                SearchPopupView.a(SearchPopupView.this, 1);
              }
            }
            label256: label311: label321: 
            while (true)
            {
              label219: if ((SearchPopupView.w(SearchPopupView.this) != 0) && (SearchPopupView.w(SearchPopupView.this) != 2))
              {
                SearchPopupView.c(SearchPopupView.this, true);
                return;
                i = 0;
                break label178;
                if (i == 0)
                {
                  if (paramAnonymousMotionEvent.getY() - this.c <= 0.0F)
                    break label311;
                  SearchPopupView.a(SearchPopupView.this, 3);
                }
              }
              while (true)
              {
                if ((SearchPopupView.w(SearchPopupView.this) != 0) || (i == 0))
                  break label321;
                SearchPopupView.a(SearchPopupView.this, 1);
                break label219;
                break;
                SearchPopupView.a(SearchPopupView.this, 2);
              }
            }
          }
        };
        this.j.setOnTouchCallback((agq)localObject);
        this.k.setOnTouchCallback((agq)localObject);
        this.M = ((NativeSearchWebView)findViewById(2131755453));
        this.M.setOnClickListener(this);
        this.M.getGlobalSearchBtn().setOnClickListener(new OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            SearchPopupView.p(SearchPopupView.this).setSelection(0, SearchPopupView.p(SearchPopupView.this).length());
            SearchPopupView.p(SearchPopupView.this).requestFocus();
            SearchPopupView.q(SearchPopupView.this);
          }
        });
        findViewById(2131755450).setOnClickListener(this);
        if (this.e)
          this.n = asq.a(114.0F);
        for (this.o = asq.a(206.0F); ; this.o = 0)
        {
          localObject = new Runnable()
          {
            public void run()
            {
              if (!SearchPopupView.y(SearchPopupView.this))
              {
                if ((SearchPopupView.m(SearchPopupView.this).getScrollY() <= SearchPopupView.o(SearchPopupView.this)) || (SearchPopupView.m(SearchPopupView.this).getScrollY() >= SearchPopupView.n(SearchPopupView.this)))
                  break label129;
                if (SearchPopupView.m(SearchPopupView.this).getScrollY() <= (SearchPopupView.o(SearchPopupView.this) + SearchPopupView.n(SearchPopupView.this)) / 2)
                  break label105;
                i = 1;
                if (i == 0)
                  break label110;
                SearchPopupView.m(SearchPopupView.this).smoothScrollTo(0, SearchPopupView.n(SearchPopupView.this));
              }
              label105: label110: 
              while (SearchPopupView.m(SearchPopupView.this).getScrollY() >= 0)
              {
                while (true)
                {
                  return;
                  int i = 0;
                }
                SearchPopupView.m(SearchPopupView.this).smoothScrollTo(0, SearchPopupView.o(SearchPopupView.this));
                return;
              }
              label129: SearchPopupView.m(SearchPopupView.this).smoothScrollTo(0, 0);
            }
          };
          this.l.getViewTreeObserver().addOnScrollChangedListener(new OnScrollChangedListener()
          {
            public void onScrollChanged()
            {
              if (!SearchPopupView.z(SearchPopupView.this))
                return;
              SearchPopupView.A(SearchPopupView.this);
              SearchPopupView.this.b.removeCallbacks(this.a);
              SearchPopupView.this.b.postDelayed(this.a, 100L);
            }
          });
          this.l.setOnTouchListener(new OnTouchListener()
          {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              if (!SearchPopupView.z(SearchPopupView.this));
              do
              {
                do
                  return false;
                while (paramAnonymousMotionEvent == null);
                if ((paramAnonymousMotionEvent.getAction() == 0) || (paramAnonymousMotionEvent.getAction() == 2))
                {
                  SearchPopupView.d(SearchPopupView.this, true);
                  return false;
                }
              }
              while ((paramAnonymousMotionEvent.getAction() != 1) && (paramAnonymousMotionEvent.getAction() != 3));
              SearchPopupView.d(SearchPopupView.this, false);
              SearchPopupView.this.b.removeCallbacks(this.a);
              SearchPopupView.this.b.postDelayed(this.a, 100L);
              return false;
            }
          });
          if (aqs.ak() != 0)
          {
            ((ViewGroup.MarginLayoutParams)findViewById(2131755450).getLayoutParams()).topMargin = aqs.ak();
            ((ViewGroup.MarginLayoutParams)this.B.getLayoutParams()).topMargin = aqs.ak();
            this.A.getLayoutParams().height = (asq.a(270.0F) + aqs.ak());
          }
          if (!this.e)
          {
            this.A.getLayoutParams().height = (asq.a(64.0F) + aqs.ak());
            this.v.setVisibility(8);
          }
          return;
          this.n = 0;
        }
      }
      catch (Exception localException1)
      {
        break label402;
      }
    }
    catch (Exception localException2)
    {
      while (true)
      {
        continue;
        int i1 = 0;
      }
    }
  }

  private void d(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }

  private boolean d(String paramString)
  {
    if ((this.E != null) && (!TextUtils.isEmpty(this.E.c())))
    {
      this.f.clearFocus();
      if (!TextUtils.isEmpty(paramString))
      {
        String str = this.E.b(paramString);
        ahe.a(getContext(), paramString);
        vy.a(getContext(), "CK", String.valueOf(this.K));
        e(str);
      }
      while (true)
      {
        return true;
        if (!arl.i(getContext()))
          e("file:///android_asset/html/omni_search.html");
        else
          e(this.E.c());
      }
    }
    return false;
  }

  private void e()
  {
    if (this.l.getScrollY() < this.o)
      this.l.scrollTo(0, this.o);
  }

  private void e(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }

  private void e(String paramString)
  {
    if (this.H == null)
    {
      this.H = ((SearchWebView)LayoutInflater.from(getContext()).inflate(2130968740, null));
      if (aqs.ak() != 0)
      {
        this.H.setPadding(0, aqs.ak(), 0, 0);
        this.H.setBackgroundColor(-16777216);
      }
    }
    if (indexOfChild(this.H) < 0)
      addView(this.H, new ViewGroup.LayoutParams(-1, -1));
    this.H.a(this.E, paramString, this.J, this.K);
  }

  private void f()
  {
    int i1 = asq.a(206.0F);
    if (this.l.getScrollY() > i1)
    {
      i1 = -i1;
      if (aqs.B())
        break label624;
      int i2 = ((ViewGroup.MarginLayoutParams)this.A.getLayoutParams()).topMargin;
      int i3 = Math.min(0, i1);
      if (i2 != i3)
      {
        ((ViewGroup.MarginLayoutParams)this.A.getLayoutParams()).topMargin = i3;
        this.A.requestLayout();
      }
      label83: i3 = asq.a(aqs.ak() + 270);
      i2 = i1;
      if (i1 < 0)
        i2 = 0;
      f1 = (i2 + i3) * 1.0F / i3;
      if (this.C.getScaleX() != f1)
      {
        f(this.C, this.C.getWidth() / 2);
        g(this.C, 0.0F);
        d(this.C, f1);
        e(this.C, f1);
        this.A.layout(this.A.getLeft(), this.A.getTop(), this.A.getRight(), i2 + (this.A.getTop() + this.A.getMeasuredHeight()));
        f(this.v, (this.C.getWidth() / 2 + this.v.getWidth() / 2) / 2);
        g(this.v, 0.0F);
        d(this.v, f1);
        e(this.v, f1);
      }
      i1 = asq.a(114.0F);
      if (this.l.getScrollY() > i1)
        break label679;
    }
    label679: for (float f1 = Math.max(0.0F, this.l.getScrollY() * 1.0F / i1); ; f1 = 1.0F)
    {
      c(this.v, f1 * asq.a(42.0F));
      if (this.l.getScrollY() > i1);
      for (f1 = Math.max(0.0F, 1.0F - (this.l.getScrollY() - i1) * 1.0F / asq.a(156.0F)); ; f1 = 1.0F)
      {
        a(this.C, f1);
        a(this.g, 0.0F);
        if (this.l.getScrollY() > i1);
        for (f1 = Math.max(0.0F, 1.0F - (this.l.getScrollY() - i1) * 1.0F / asq.a(92.0F)); ; f1 = 1.0F)
        {
          a(this.z, f1);
          a(this.D, 1.0F - f1);
          b(this.f, -f1 * asq.a(32.700001F));
          i1 = asq.a(206.0F);
          float f2;
          if (this.l.getScrollY() >= i1)
            f2 = f1;
          while (true)
          {
            a(this.y, 1.0F - f2);
            a(this.x, f2);
            View localView = this.w;
            f1 = -(1.0F - f2);
            b(localView, (this.s[0] - this.t[0]) * f1);
            c(this.w, -(1.0F - f2) * (this.s[1] - this.t[1] + asq.a(42.0F)));
            if (this.l.getScrollY() >= i1)
            {
              a(this.g, 1.0F);
              a(this.y, 0.0F);
            }
            return;
            i1 = -this.l.getScrollY();
            break;
            label624: c(this.A, Math.min(0, i1));
            break label83;
            f2 = f1;
            if (this.s[0] == 0)
            {
              f2 = f1;
              if (this.s[1] == 0)
                f2 = 1.0F;
            }
          }
        }
      }
    }
  }

  private void f(View paramView, float paramFloat)
  {
    paramView.setPivotX(paramFloat);
  }

  private void g()
  {
    try
    {
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.f, 1);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void g(View paramView, float paramFloat)
  {
    paramView.setPivotY(paramFloat);
  }

  private void h()
  {
    try
    {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a()
  {
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext())
      ((agj)localIterator.next()).setCallback(this);
    localIterator = this.r.iterator();
    while (localIterator.hasNext())
      ((agj)localIterator.next()).setCallback(this);
  }

  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.K = paramInt;
    this.J = paramString;
    if (this.f != null)
      this.f.setHint(this.J);
    if (paramBoolean)
    {
      if (this.i != null)
        postDelayed(new Runnable()
        {
          public void run()
          {
            SearchPopupView.this.onClick(SearchPopupView.b(SearchPopupView.this));
          }
        }
        , 50L);
    }
    else
      return;
    this.L = paramBoolean;
  }

  public void a(atr paramatr)
  {
  }

  public void a(String paramString)
  {
    vy.a(getContext(), "CN", String.valueOf(this.K));
    yb.p();
    asq.i(getContext(), paramString);
  }

  public void a(String paramString, int paramInt)
  {
    if (this.E == null)
      this.E = ahe.e(getContext().getApplicationContext());
    if (this.E == null)
    {
      this.f.clearFocus();
      aso.a(getContext(), 2131230908);
      if (this.I)
        return;
      this.I = true;
      new Thread()
      {
        public void run()
        {
          ahe.d(SearchPopupView.this.getContext().getApplicationContext());
          List localList = ahe.f(SearchPopupView.this.getContext().getApplicationContext());
          if ((localList != null) && (localList.size() > 0))
            SearchPopupView.a(SearchPopupView.this, ahe.e(SearchPopupView.this.getContext().getApplicationContext()));
          SearchPopupView.e(SearchPopupView.this, false);
        }
      }
      .start();
      return;
    }
    String str1 = null;
    if (paramInt == 2)
      str1 = this.E.d(paramString);
    while (true)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
        str2 = this.E.b(paramString);
      ahe.a(getContext(), paramString);
      vy.a(getContext(), "CK", String.valueOf(this.K));
      h();
      e();
      if (this.M.getVisibility() != 0)
        this.M.setVisibility(0);
      this.M.a(this.E, str2);
      this.f.clearFocus();
      this.f.setText(paramString);
      if (this.m.getVisibility() == 0)
        a(false);
      this.l.setVisibility(8);
      return;
      if (paramInt == 1)
        str1 = this.E.e(paramString);
    }
  }

  public void b(atr paramatr)
  {
  }

  public void b(String paramString)
  {
    vy.a(getContext(), "CO", String.valueOf(this.K));
    if ((this.E != null) && (!TextUtils.isEmpty(this.E.c())))
    {
      this.f.clearFocus();
      String str2 = this.E.d(paramString);
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = this.E.b(paramString);
      ahe.a(getContext(), paramString);
      e(str1);
      return;
    }
    a(paramString, 2);
  }

  public boolean b()
  {
    if ((this.M != null) && (this.M.getVisibility() == 0))
      if (this.M.e())
        this.M.e();
    do
    {
      do
      {
        return true;
        this.M.setVisibility(8);
        this.l.setVisibility(0);
        return true;
      }
      while ((this.H != null) && (this.H.d()));
      if (this.H == null)
        break;
    }
    while (this.H == null);
    removeView(this.H);
    this.H = null;
    return true;
    if ((this.m != null) && (this.m.getVisibility() == 0))
    {
      this.f.clearFocus();
      a(false);
      return true;
    }
    return false;
  }

  public void onClick(View paramView)
  {
    if (paramView == this.f)
      c(null);
    while (true)
    {
      return;
      if (paramView == this.h)
      {
        this.f.setText("");
        g();
        return;
      }
      if (paramView != this.g)
        if (paramView == this.i)
        {
          String str = this.f.getText().toString();
          if ((TextUtils.isEmpty(this.J)) || ((!TextUtils.isEmpty(str)) && (!this.J.equals(str))))
            if (!TextUtils.isEmpty(str))
              break label163;
          label163: for (paramView = this.J; !d(paramView); paramView = str)
          {
            if (!TextUtils.isEmpty(str))
              break label188;
            if (TextUtils.isEmpty(this.J))
              break label168;
            this.f.clearFocus();
            this.f.setText(this.J);
            a(this.f.getText().toString(), 1);
            return;
          }
          continue;
          label168: this.f.postDelayed(new Runnable()
          {
            public void run()
            {
              SearchPopupView.p(SearchPopupView.this).requestFocus();
              SearchPopupView.q(SearchPopupView.this);
            }
          }
          , 100L);
          return;
          label188: if (str.equals(this.J))
          {
            a(str, 1);
            return;
          }
          a(str, 0);
        }
        else if (((paramView == this.k) || (paramView == this.j)) && (!this.F))
        {
          try
          {
            paramView = (InputMethodManager)getContext().getSystemService("input_method");
            if (paramView.isAcceptingText())
            {
              paramView.hideSoftInputFromWindow(getWindowToken(), 0);
              this.f.clearFocus();
              return;
            }
          }
          catch (Exception paramView)
          {
          }
        }
    }
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.s != null)
    {
      if (!vj.g)
      {
        paramConfiguration = this.s;
        paramConfiguration[0] -= (aqs.af() - aqs.ae()) / 2;
      }
    }
    else
      return;
    paramConfiguration = this.s;
    paramConfiguration[0] += (aqs.af() - aqs.ae()) / 2;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    h();
    if (this.c != null)
    {
      atq.a(this.c);
      this.c = null;
    }
    if (this.d != null)
    {
      xq.a(this.d);
      this.d = null;
    }
    if (aqs.B())
      ahe.h(getContext());
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.p = new ago(getContext());
    this.p.setNeedAlpha(false);
    addView(this.p, -1, -1);
    this.p.a(a, new Runnable()
    {
      public void run()
      {
        SearchPopupView.this.b.post(new Runnable()
        {
          public void run()
          {
            if (!SearchPopupView.c(SearchPopupView.this))
            {
              SearchPopupView.a(SearchPopupView.this, true);
              return;
            }
            SearchPopupView.d(SearchPopupView.this);
          }
        });
      }
    });
    this.b.postDelayed(new Runnable()
    {
      public void run()
      {
        SearchPopupView.a(SearchPopupView.this, ((ViewStub)SearchPopupView.this.findViewById(2131755468)).inflate());
        SearchPopupView.e(SearchPopupView.this).setVisibility(8);
        SearchPopupView.f(SearchPopupView.this);
        SearchPopupView.d(SearchPopupView.this);
      }
    }
    , 0L);
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (paramKeyEvent.getAction() == 1))
    {
      a[0] = -1;
      a[1] = -1;
      a(this.f.getText().toString().trim(), 0);
    }
    while ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (b()))
      return true;
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.search.SearchPopupView
 * JD-Core Version:    0.6.2
 */