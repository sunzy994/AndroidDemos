package cmcm.com.myapplication.com.lazyswipe.ui;

import abf;
import add;
import aft;
import afw;
import ahw;
import ahx;
import aji;
import ajj;
import ajm;
import ama;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import apa;
import ape;
import apf;
import apk;
import apz;
import aqt;
import asq;
import atw;
import awi;
import awo;
import awp;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.fan.tab.CustomTabSettingsActivity;
import com.lazyswipe.preference.MyCheckboxPreference;
import com.lazyswipe.preference.MyLogoPreference;
import com.lazyswipe.preference.MyPreference;
import com.lazyswipe.widget.Toolbar;
import com.lazyswipe.widget.webview.SimpleWebViewActivity;
import java.util.Iterator;
import java.util.List;
import tk;
import vg;
import vs;
import vv;
import vy;
import vz;
import wk;
import wm;

public class BaseSettingsFragment extends BasePreferenceFragment
{
  private apf a;
  private boolean e;
  private String f = "";
  private MyLogoPreference g;
  private MyPreference h;
  private MyPreference i;
  private MyPreference j;
  private MyPreference k;
  private MyCheckboxPreference l;
  private ape m;
  private ajj n;
  private int o;
  private Drawable p;
  private Dialog q;
  private BroadcastReceiver r = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      BaseSettingsFragment.c(BaseSettingsFragment.this);
    }
  };
  private aji s = new aji()
  {
    protected void a(Context paramAnonymousContext)
    {
      BaseSettingsFragment.a(BaseSettingsFragment.this, ahx.a(paramAnonymousContext));
      paramAnonymousContext = ahx.b(BaseSettingsFragment.this.getActivity());
      BaseSettingsFragment.d(BaseSettingsFragment.this).setSummary(BaseSettingsFragment.this.getString(2131231014, new Object[] { paramAnonymousContext.h }));
    }
  };

  private void a(boolean paramBoolean)
  {
    if (this.j == null)
      return;
    if (!paramBoolean)
    {
      getPreferenceScreen().removePreference(this.j);
      this.j = null;
      return;
    }
    if (this.i == null)
    {
      getPreferenceScreen().addPreference(this.j);
      abf.a(getActivity(), this.j);
      this.j = null;
      return;
    }
    getPreferenceScreen().removePreference(this.j);
  }

  private void g()
  {
    int i1;
    label96: Object localObject;
    if (ajm.b(getActivity()))
    {
      this.o |= 4;
      this.g.a(true);
      if ((this.o & 0x1) != 0)
        break label260;
      if (this.b.getPopupMenu() == null)
        break label235;
      if (this.p == null)
        this.p = atw.a(Color.parseColor("#ff5c26"), (int)(4.666667F * getResources().getDisplayMetrics().density));
      int i2 = this.b.getPopupMenu().a().b();
      i1 = 0;
      if (i1 >= i2)
        break label235;
      localObject = this.b.getPopupMenu().a().a(i1);
      if (((awp)localObject).a() != 2131755573)
        break label184;
      if ((this.o & 0x4) == 0)
        break label175;
      ((awp)localObject).a(this.p);
    }
    while (true)
    {
      i1 += 1;
      break label96;
      this.o &= -5;
      this.g.a(false);
      break;
      label175: ((awp)localObject).b();
      continue;
      label184: if (((awp)localObject).a() == 2131755570)
      {
        if ((this.o & 0x2) != 0)
          ((awp)localObject).a(this.p);
        else
          ((awp)localObject).b();
      }
      else
        ((awp)localObject).b();
    }
    label235: if (((this.o & 0x4) != 0) || ((this.o & 0x2) != 0))
      this.b.c();
    label260: 
    do
    {
      do
      {
        return;
        this.b.d();
      }
      while (vs.k(getActivity()));
      localObject = (MyPreference)a("pref_hola_recommended");
    }
    while (localObject == null);
    ((MyPreference)localObject).a().a(false, true);
  }

  private void h()
  {
    vy.g();
    this.a.a("主动", 2131230988, true);
  }

  private void i()
  {
    if ((this.o & 0x2) != 0)
    {
      this.o &= -3;
      vs.h(getActivity());
    }
    vy.h();
    asq.y(getActivity());
  }

  private void j()
  {
    if ((this.o & 0x1) != 0)
    {
      vs.f(getActivity());
      this.o &= -2;
    }
  }

  private boolean k()
  {
    int i1 = 1;
    final Activity localActivity = getActivity();
    if (!vs.H(localActivity))
    {
      MainActivity.a(localActivity, true, true);
      return true;
    }
    final List localList = afw.a(3);
    if (!asq.a(localList))
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(localActivity);
      LinearLayout localLinearLayout = new LinearLayout(localActivity);
      localLinearLayout.setOrientation(0);
      wm localwm = SwipeApplication.c().a();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localwm.a((String)localIterator.next());
        if (localObject != null)
        {
          FanItem localFanItem = (FanItem)LayoutInflater.from(localActivity).inflate(2130968629, null);
          localFanItem.setIcon((wk)localObject);
          localObject = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
          localLinearLayout.addView(localFanItem, (ViewGroup.LayoutParams)localObject);
        }
      }
      i1 = asq.a(7.0F);
      int i2 = asq.a(15.0F);
      localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), i1, localLinearLayout.getPaddingRight(), i2);
      localRelativeLayout.addView(localLinearLayout, new RelativeLayout.LayoutParams(-2, -2));
      this.q = new tk(localActivity).c(2131231019).g(2131231017).a(localRelativeLayout).a(2131231018, new OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
            aft.d((String)localIterator.next());
          paramAnonymousDialogInterface.dismiss();
        }
      }).b(2131231016, new OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          BaseSettingsFragment.b(BaseSettingsFragment.this);
          paramAnonymousDialogInterface.dismiss();
        }
      }).a(new OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
        }
      }).f(-1).b();
      return false;
    }
    if (vs.d(localActivity) == 1);
    while (i1 == 0)
    {
      this.q = new tk(localActivity).c(2131231019).g(2131231020).a(17039370, new OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          vs.b(localActivity, "white_dot_by_suggest", true);
          vs.a(localActivity, 1);
          paramAnonymousDialogInterface.dismiss();
        }
      }).b(2131231016, new OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          BaseSettingsFragment.b(BaseSettingsFragment.this);
          paramAnonymousDialogInterface.dismiss();
        }
      }).a(new OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
        }
      }).f(-1).b();
      return false;
      i1 = 0;
    }
    this.q = new tk(localActivity).c(2131230946).g(2131231015).a(17039370, new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        BaseSettingsFragment.b(BaseSettingsFragment.this);
        paramAnonymousDialogInterface.dismiss();
      }
    }).b(17039360, new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    }).a(new OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
      }
    }).b();
    return false;
  }

  private void l()
  {
    vs.i(getActivity(), false);
    this.l.setChecked(false);
    MainActivity.a(getActivity(), false, true);
  }

  private void m()
  {
    vs.j(getActivity());
    getPreferenceScreen().removePreference(this.i);
    this.i = null;
    n();
    if (asq.c(getActivity(), "com.hola.launcher"))
    {
      vz.a(1);
      asq.d(getActivity(), asq.b("com.hola.launcher"));
      return;
    }
    vz.a(0);
    asq.g(getActivity(), "com.hola.launcher&referrer=aq_tranid%3d0RWlnwbEN226OotMDF7l8IWSeoPaxvAeL%26pid%3dha_lazy_int%26c%3dlazyswipe_gp_setting");
  }

  private void n()
  {
    a(false);
  }

  private void o()
  {
    MyPreference localMyPreference2 = (MyPreference)a("pref_unlocker");
    MyPreference localMyPreference1 = (MyPreference)a("key_custom_tab");
    if (!vg.k)
    {
      if (localMyPreference2 != null)
        getPreferenceScreen().removePreference(localMyPreference2);
      if (localMyPreference1 != null)
        getPreferenceScreen().removePreference(localMyPreference1);
    }
    do
    {
      do
      {
        return;
        if (localMyPreference1 != null)
          localMyPreference1.setWidgetLayoutResource(2130968730);
        if (!apz.b())
          break;
        if (localMyPreference2 != null)
          getPreferenceScreen().removePreference(localMyPreference2);
      }
      while (localMyPreference1 == null);
      localMyPreference1.a(getResources().getColor(2131689569));
      return;
      if (localMyPreference2 == null)
      {
        localMyPreference2 = new MyPreference(getActivity());
        localMyPreference2.setKey("pref_unlocker");
        localMyPreference2.setTitle(2131231247);
        localMyPreference2.setSummary(2131231053);
        localMyPreference2.setOnPreferenceClickListener(this);
        localMyPreference2.a().a(2130837677);
        getPreferenceScreen().addPreference(localMyPreference2);
      }
    }
    while (localMyPreference1 == null);
    localMyPreference1.a(1560281087);
  }

  void a()
  {
    try
    {
      this.m.a(getActivity(), getView().getRootView());
      if (this.m.getParent() != null)
        return;
      this.a.showHintView(this.m);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public boolean a(Preference paramPreference, String paramString)
  {
    paramPreference = getActivity();
    int i1 = -1;
    switch (paramString.hashCode())
    {
    default:
    case -759271027:
    case 116961191:
    case -2120490508:
    case 199607245:
    case 514560440:
    case -51191454:
    case -506956055:
    }
    while (true)
      switch (i1)
      {
      default:
        return false;
        if (paramString.equals("pref_unlocker"))
        {
          i1 = 0;
          continue;
          if (paramString.equals("key_custom_tab"))
          {
            i1 = 1;
            continue;
            if (paramString.equals("pref_hola_recommended"))
            {
              i1 = 2;
              continue;
              if (paramString.equals("pref_theme_key"))
              {
                i1 = 3;
                continue;
                if (paramString.equals("key_hint_rate"))
                {
                  i1 = 4;
                  continue;
                  if (paramString.equals("pref_facebook"))
                  {
                    i1 = 5;
                    continue;
                    if (paramString.equals("pref_app_promotion"))
                      i1 = 6;
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
    this.q = apk.a(getActivity());
    return false;
    if (apz.b())
    {
      asq.d(paramPreference, new Intent(paramPreference, CustomTabSettingsActivity.class));
      vy.b(getActivity(), "B52", 1);
      return false;
    }
    this.q = apk.a(getActivity());
    vy.b(getActivity(), "B52", 0);
    return false;
    if (add.a(paramPreference, 1))
      vy.a(paramPreference, "D4", 3);
    vs.l(paramPreference);
    return true;
    this.e = vs.e(paramPreference, false);
    if (this.e)
      this.f = ahx.a(paramPreference);
    j();
    return false;
    h();
    return true;
    i();
    return true;
    m();
    return true;
  }

  public boolean a(Preference paramPreference, String paramString, Object paramObject)
  {
    paramPreference = getActivity();
    int i1 = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1959629169:
    }
    while (true)
      switch (i1)
      {
      default:
        return false;
        if (paramString.equals("key_enable_float_window"))
          i1 = 0;
        break;
      case 0:
      }
    try
    {
      boolean bool = k();
      return bool;
    }
    catch (Exception paramString)
    {
      Log.e("Swipe.Settings", "onPrefEnableClick failed.", paramString);
      MainActivity.a(paramPreference, ((Boolean)paramObject).booleanValue(), true);
    }
    return true;
  }

  public boolean a(awp paramawp)
  {
    boolean bool = true;
    switch (paramawp.a())
    {
    default:
      bool = false;
    case 2131755570:
    case 2131755572:
    case 2131755571:
    case 2131755573:
      do
      {
        return bool;
        i();
        return true;
        FeedbackFragment.a(getActivity());
        return true;
        startActivity(new Intent(getActivity(), FragmentContainer.FeedbackActivity.class));
        return true;
        this.o &= -5;
        vv.a().a("Upgrade点击");
      }
      while (this.n == null);
      this.n.a();
      return true;
    case 2131755574:
    }
    SimpleWebViewActivity.a("http://www.omniswipe.com/privacy/tos.html", getString(2131231242));
    return true;
  }

  protected void d()
  {
    this.b.setIcon((Drawable)null);
  }

  protected CharSequence e()
  {
    return null;
  }

  protected int f()
  {
    return 2131820544;
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.a = ((apf)paramActivity);
    if (!vs.H(paramActivity))
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          BaseSettingsFragment.a(BaseSettingsFragment.this).b();
        }
      }
      , 100L);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.o = 0;
    this.n = new ajj(getActivity());
    addPreferencesFromResource(2131099653);
    this.l = ((MyCheckboxPreference)a("key_enable_float_window"));
    this.l.setOnPreferenceChangeListener(this);
    findPreference("key_hint_rate").setOnPreferenceClickListener(this);
    this.g = ((MyLogoPreference)a("pref_logo"));
    this.g.a(getActivity());
    this.h = ((MyPreference)a("pref_theme_key"));
    this.h.setOnPreferenceClickListener(this);
    if (!vs.e(getActivity()))
    {
      this.o |= 1;
      this.h.a().a(false, false);
    }
    this.i = ((MyPreference)a("pref_app_promotion"));
    getPreferenceScreen().removePreference(this.i);
    this.i = null;
    this.j = ((MyPreference)a("pref_hola_recommended"));
    this.j.setOnPreferenceClickListener(this);
    a(false);
    this.k = ((MyPreference)a("key_custom_tab"));
    this.k.setOnPreferenceClickListener(this);
    try
    {
      bool = TextUtils.isEmpty(getText(2131231211));
      if (bool)
        getPreferenceScreen().removePreference(findPreference("pref_exclusively_launch"));
      if (InitialSettingsFragment.a(getActivity()))
        getPreferenceScreen().removePreference(findPreference("pref_initial_settings"));
      apa.a(this);
      this.s.c(getActivity());
      return;
    }
    catch (NotFoundException paramBundle)
    {
      while (true)
        boolean bool = true;
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.n != null)
      this.n.b();
    apa.b();
    aqt.a(this.q);
    this.s.d(getActivity());
  }

  // ERROR //
  public void onResume()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 714	com/lazyswipe/ui/BasePreferenceFragment:onResume	()V
    //   4: aload_0
    //   5: invokespecial 715	com/lazyswipe/ui/BaseSettingsFragment:g	()V
    //   8: getstatic 720	android/os/Build$VERSION:SDK_INT	I
    //   11: bipush 19
    //   13: if_icmpge +15 -> 28
    //   16: invokestatic 724	aqs:p	()Z
    //   19: ifeq +167 -> 186
    //   22: invokestatic 726	aqs:F	()Z
    //   25: ifeq +161 -> 186
    //   28: aload_0
    //   29: invokevirtual 102	com/lazyswipe/ui/BaseSettingsFragment:getActivity	()Landroid/app/Activity;
    //   32: invokestatic 727	aqs:b	(Landroid/content/Context;)Z
    //   35: istore 4
    //   37: aload_0
    //   38: invokevirtual 102	com/lazyswipe/ui/BaseSettingsFragment:getActivity	()Landroid/app/Activity;
    //   41: ldc_w 729
    //   44: iload 4
    //   46: invokestatic 732	vs:b	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   49: aload_0
    //   50: invokevirtual 102	com/lazyswipe/ui/BaseSettingsFragment:getActivity	()Landroid/app/Activity;
    //   53: iconst_0
    //   54: invokestatic 736	acw:c	(Landroid/content/Context;Z)V
    //   57: iload 4
    //   59: ifne +108 -> 167
    //   62: aload_0
    //   63: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   66: ifnonnull +14 -> 80
    //   69: aload_0
    //   70: aload_0
    //   71: invokevirtual 102	com/lazyswipe/ui/BaseSettingsFragment:getActivity	()Landroid/app/Activity;
    //   74: invokestatic 739	ape:a	(Landroid/content/Context;)Lape;
    //   77: putfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   80: aload_0
    //   81: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   84: aload_0
    //   85: invokevirtual 102	com/lazyswipe/ui/BaseSettingsFragment:getActivity	()Landroid/app/Activity;
    //   88: invokevirtual 741	ape:b	(Landroid/content/Context;)V
    //   91: iconst_1
    //   92: istore_2
    //   93: invokestatic 744	aqs:ai	()Z
    //   96: ifeq +107 -> 203
    //   99: aload_0
    //   100: invokevirtual 102	com/lazyswipe/ui/BaseSettingsFragment:getActivity	()Landroid/app/Activity;
    //   103: invokestatic 747	wu:b	(Landroid/content/Context;)Z
    //   106: ifne +97 -> 203
    //   109: aload_0
    //   110: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   113: ifnonnull +14 -> 127
    //   116: aload_0
    //   117: aload_0
    //   118: invokevirtual 102	com/lazyswipe/ui/BaseSettingsFragment:getActivity	()Landroid/app/Activity;
    //   121: invokestatic 739	ape:a	(Landroid/content/Context;)Lape;
    //   124: putfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   127: aload_0
    //   128: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   131: aload_0
    //   132: invokevirtual 102	com/lazyswipe/ui/BaseSettingsFragment:getActivity	()Landroid/app/Activity;
    //   135: invokevirtual 748	ape:c	(Landroid/content/Context;)V
    //   138: iconst_1
    //   139: istore_3
    //   140: iload_3
    //   141: ifeq +83 -> 224
    //   144: new 633	android/os/Handler
    //   147: dup
    //   148: invokespecial 634	android/os/Handler:<init>	()V
    //   151: new 24	com/lazyswipe/ui/BaseSettingsFragment$6
    //   154: dup
    //   155: aload_0
    //   156: invokespecial 749	com/lazyswipe/ui/BaseSettingsFragment$6:<init>	(Lcom/lazyswipe/ui/BaseSettingsFragment;)V
    //   159: ldc2_w 750
    //   162: invokevirtual 641	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   165: pop
    //   166: return
    //   167: aload_0
    //   168: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   171: ifnull +10 -> 181
    //   174: aload_0
    //   175: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   178: invokevirtual 752	ape:a	()V
    //   181: iconst_0
    //   182: istore_2
    //   183: goto -90 -> 93
    //   186: aload_0
    //   187: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   190: ifnull -9 -> 181
    //   193: aload_0
    //   194: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   197: invokevirtual 752	ape:a	()V
    //   200: goto -19 -> 181
    //   203: iload_2
    //   204: istore_3
    //   205: aload_0
    //   206: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   209: ifnull -69 -> 140
    //   212: aload_0
    //   213: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   216: invokevirtual 753	ape:b	()V
    //   219: iload_2
    //   220: istore_3
    //   221: goto -81 -> 140
    //   224: aload_0
    //   225: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   228: ifnull +25 -> 253
    //   231: aload_0
    //   232: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   235: invokevirtual 497	ape:getParent	()Landroid/view/ViewParent;
    //   238: checkcast 755	android/view/ViewGroup
    //   241: aload_0
    //   242: getfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   245: invokevirtual 758	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   248: aload_0
    //   249: aconst_null
    //   250: putfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   253: aload_0
    //   254: invokevirtual 102	com/lazyswipe/ui/BaseSettingsFragment:getActivity	()Landroid/app/Activity;
    //   257: invokestatic 761	ahx:b	(Landroid/content/Context;)Lahw;
    //   260: astore_1
    //   261: aload_0
    //   262: getfield 117	com/lazyswipe/ui/BaseSettingsFragment:h	Lcom/lazyswipe/preference/MyPreference;
    //   265: aload_0
    //   266: ldc_w 762
    //   269: iconst_1
    //   270: anewarray 764	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload_1
    //   276: getfield 768	ahw:h	Ljava/lang/String;
    //   279: aastore
    //   280: invokevirtual 771	com/lazyswipe/ui/BaseSettingsFragment:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   283: invokevirtual 774	com/lazyswipe/preference/MyPreference:setSummary	(Ljava/lang/CharSequence;)V
    //   286: aload_0
    //   287: getfield 550	com/lazyswipe/ui/BaseSettingsFragment:e	Z
    //   290: ifeq -124 -> 166
    //   293: aload_0
    //   294: iconst_0
    //   295: putfield 550	com/lazyswipe/ui/BaseSettingsFragment:e	Z
    //   298: aload_0
    //   299: getfield 67	com/lazyswipe/ui/BaseSettingsFragment:f	Ljava/lang/String;
    //   302: invokestatic 683	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne -139 -> 166
    //   308: aload_0
    //   309: getfield 67	com/lazyswipe/ui/BaseSettingsFragment:f	Ljava/lang/String;
    //   312: aload_1
    //   313: getfield 776	ahw:g	Ljava/lang/String;
    //   316: invokevirtual 509	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   319: ifne -153 -> 166
    //   322: aload_0
    //   323: invokevirtual 102	com/lazyswipe/ui/BaseSettingsFragment:getActivity	()Landroid/app/Activity;
    //   326: iconst_1
    //   327: invokestatic 778	vs:f	(Landroid/content/Context;Z)V
    //   330: aload_0
    //   331: getfield 224	com/lazyswipe/ui/BaseSettingsFragment:a	Lapf;
    //   334: ldc_w 780
    //   337: ldc_w 781
    //   340: iconst_0
    //   341: invokeinterface 232 4 0
    //   346: return
    //   347: astore_1
    //   348: aload_0
    //   349: aconst_null
    //   350: putfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   353: goto -100 -> 253
    //   356: astore_1
    //   357: aload_0
    //   358: aconst_null
    //   359: putfield 479	com/lazyswipe/ui/BaseSettingsFragment:m	Lape;
    //   362: aload_1
    //   363: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   231	248	347	java/lang/Throwable
    //   231	248	356	finally
  }

  public void onStart()
  {
    super.onStart();
    o();
    if (vg.k)
    {
      apz.a(getActivity());
      apz.a(getActivity(), this.r);
    }
  }

  public void onStop()
  {
    super.onStop();
    if (vg.k)
      apz.b(getActivity(), this.r);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.BaseSettingsFragment
 * JD-Core Version:    0.6.2
 */