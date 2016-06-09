package cmcm.com.myapplication.com.lazyswipe.ui;

import aai;
import aaj;
import aam;
import aap;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import apk;
import apz;
import arj;
import asi;
import aso;
import asq;
import com.lazyswipe.SwipeService;
import com.lazyswipe.notification.SwipeAccessibilityService;
import com.lazyswipe.preference.BlackListLayout;
import com.lazyswipe.preference.MyCheckboxPreference;
import com.lazyswipe.preference.MyListPreference;
import java.util.Arrays;
import tk;
import vg;
import vs;
import vy;
import xc;

public class AdvancedSettingsFragment extends BasePreferenceFragment
  implements OnMultiChoiceClickListener, OnSharedPreferenceChangeListener, OnSeekBarChangeListener
{
  private static final String e = "Swipe." + AdvancedSettingsFragment.class.getSimpleName();
  Preference a;
  private MyCheckboxPreference f;
  private MyCheckboxPreference g;
  private Preference h;
  private Preference i;
  private boolean[] j;
  private int k;
  private Dialog l;
  private MyListPreference m;
  private Boolean n;
  private BroadcastReceiver o = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      AdvancedSettingsFragment.a(AdvancedSettingsFragment.this);
    }
  };

  private static int a(Context paramContext)
  {
    paramContext = aap.b(paramContext);
    if ((paramContext instanceof aai))
      return 0;
    if ((paramContext instanceof aam))
      return 1;
    return 2;
  }

  private void g()
  {
    if ((this.l != null) && (this.l.isShowing()))
      this.l.cancel();
    this.l = null;
  }

  private void h()
  {
    vy.a(getActivity(), "BJ");
    Intent localIntent = new Intent(getActivity(), ToucherPositionSettingActivity.class);
    getActivity().startActivityForResult(localIntent, 100);
  }

  private void i()
  {
    Object localObject = null;
    int i1;
    if (1 == vs.d(getActivity()))
    {
      i1 = 1;
      if (i1 == 0)
        break label118;
    }
    while (true)
    {
      if (localObject != null)
        ((BlackListLayout)localObject).setRequestType(3);
      final Resources localResources = getResources();
      final String str = vs.I(getActivity());
      i1 = asq.a(localResources.getStringArray(2131623940), str);
      g();
      this.l = new tk(getActivity()).c(2131231054).a(2131623939, i1, new OnClickListener()
      {
        // ERROR //
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 23	com/lazyswipe/ui/AdvancedSettingsFragment$1:a	Landroid/content/res/Resources;
          //   4: ldc 33
          //   6: invokevirtual 39	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
          //   9: iload_2
          //   10: aaload
          //   11: astore_3
          //   12: aload_0
          //   13: getfield 25	com/lazyswipe/ui/AdvancedSettingsFragment$1:b	Ljava/lang/String;
          //   16: aload_3
          //   17: invokevirtual 45	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   20: ifne +110 -> 130
          //   23: aload_0
          //   24: getfield 21	com/lazyswipe/ui/AdvancedSettingsFragment$1:c	Lcom/lazyswipe/ui/AdvancedSettingsFragment;
          //   27: invokevirtual 49	com/lazyswipe/ui/AdvancedSettingsFragment:getActivity	()Landroid/app/Activity;
          //   30: aload_3
          //   31: invokestatic 55	vs:e	(Landroid/content/Context;Ljava/lang/String;)V
          //   34: aload_0
          //   35: getfield 23	com/lazyswipe/ui/AdvancedSettingsFragment$1:a	Landroid/content/res/Resources;
          //   38: ldc 56
          //   40: invokevirtual 39	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
          //   43: iload_2
          //   44: aaload
          //   45: astore 4
          //   47: aload_0
          //   48: getfield 21	com/lazyswipe/ui/AdvancedSettingsFragment$1:c	Lcom/lazyswipe/ui/AdvancedSettingsFragment;
          //   51: getfield 59	com/lazyswipe/ui/AdvancedSettingsFragment:a	Landroid/preference/Preference;
          //   54: aload 4
          //   56: invokevirtual 65	android/preference/Preference:setSummary	(Ljava/lang/CharSequence;)V
          //   59: new 67	android/os/Bundle
          //   62: dup
          //   63: iconst_3
          //   64: invokespecial 70	android/os/Bundle:<init>	(I)V
          //   67: astore 4
          //   69: aload 4
          //   71: ldc 72
          //   73: iconst_5
          //   74: invokevirtual 76	android/os/Bundle:putInt	(Ljava/lang/String;I)V
          //   77: aload 4
          //   79: ldc 78
          //   81: iconst_0
          //   82: invokevirtual 76	android/os/Bundle:putInt	(Ljava/lang/String;I)V
          //   85: aload 4
          //   87: ldc 80
          //   89: aload_3
          //   90: invokevirtual 84	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
          //   93: aload_0
          //   94: getfield 21	com/lazyswipe/ui/AdvancedSettingsFragment$1:c	Lcom/lazyswipe/ui/AdvancedSettingsFragment;
          //   97: invokevirtual 49	com/lazyswipe/ui/AdvancedSettingsFragment:getActivity	()Landroid/app/Activity;
          //   100: aload 4
          //   102: invokestatic 89	com/lazyswipe/SwipeService:a	(Landroid/content/Context;Landroid/os/Bundle;)V
          //   105: aload_0
          //   106: getfield 21	com/lazyswipe/ui/AdvancedSettingsFragment$1:c	Lcom/lazyswipe/ui/AdvancedSettingsFragment;
          //   109: invokevirtual 49	com/lazyswipe/ui/AdvancedSettingsFragment:getActivity	()Landroid/app/Activity;
          //   112: ldc 91
          //   114: aload_3
          //   115: invokestatic 96	vy:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
          //   118: aload_0
          //   119: getfield 21	com/lazyswipe/ui/AdvancedSettingsFragment$1:c	Lcom/lazyswipe/ui/AdvancedSettingsFragment;
          //   122: invokevirtual 49	com/lazyswipe/ui/AdvancedSettingsFragment:getActivity	()Landroid/app/Activity;
          //   125: ldc 97
          //   127: invokestatic 102	aso:a	(Landroid/content/Context;I)V
          //   130: aload_1
          //   131: invokeinterface 107 1 0
          //   136: return
          //   137: astore_3
          //   138: aload_1
          //   139: invokeinterface 107 1 0
          //   144: return
          //   145: astore_3
          //   146: aload_1
          //   147: invokeinterface 107 1 0
          //   152: aload_3
          //   153: athrow
          //
          // Exception table:
          //   from	to	target	type
          //   0	130	137	java/lang/Exception
          //   0	130	145	finally
        }
      }).i(0).c(true).b((View)localObject).b();
      return;
      i1 = 0;
      break;
      label118: localObject = (BlackListLayout)LayoutInflater.from(getActivity()).inflate(2130968722, null, false);
    }
  }

  private String[] j()
  {
    String[] arrayOfString = getResources().getStringArray(2131623946);
    arrayOfString[2] = aaj.a();
    return arrayOfString;
  }

  private void k()
  {
    final int i1 = a(getActivity());
    int[] arrayOfInt = getResources().getIntArray(2131623947);
    String[] arrayOfString4 = j();
    String[] arrayOfString3 = getResources().getStringArray(2131623945);
    String[] arrayOfString2 = arrayOfString4;
    String[] arrayOfString1 = arrayOfString3;
    Object localObject = arrayOfInt;
    if (!vs.c(getActivity(), "custom_tab_available", false))
    {
      localObject = Arrays.copyOf(arrayOfInt, 2);
      arrayOfString2 = (String[])Arrays.copyOf(arrayOfString4, 2);
      arrayOfString1 = (String[])Arrays.copyOf(arrayOfString3, 2);
    }
    int i2 = asq.a((int[])localObject, i1);
    localObject = new OnClickListener()
    {
      public void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        try
        {
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousInt = this.a[paramAnonymousInt];
          if (i1 != paramAnonymousInt)
          {
            paramAnonymousDialogInterface = AdvancedSettingsFragment.this.getActivity().getApplicationContext();
            if ((paramAnonymousInt == 0) && (!vs.c(paramAnonymousDialogInterface, "key_contacts_inited", false)))
              arj.a(new Runnable()
              {
                public void run()
                {
                  vs.b(paramAnonymousDialogInterface, "key_contacts_inited", true);
                  paramAnonymousDialogInterface.getContentResolver().call(xc.a, "initContacts", null, null);
                }
              });
            aap.a(AdvancedSettingsFragment.this.getActivity(), paramAnonymousInt);
            aso.a(AdvancedSettingsFragment.this.getActivity(), 2131231061);
          }
          return;
        }
        catch (Throwable paramAnonymousDialogInterface)
        {
        }
      }
    };
    g();
    this.l = new tk(getActivity()).c(2131231097).a(arrayOfString2, arrayOfString1, i2, (OnClickListener)localObject).b();
  }

  private void l()
  {
    if (this.j == null)
      this.j = new boolean[vs.a.length];
    int i1 = 0;
    if (i1 < vs.a.length)
    {
      boolean[] arrayOfBoolean = this.j;
      if (vs.a[i1] == (this.k & vs.a[i1]));
      for (int i2 = 1; ; i2 = 0)
      {
        arrayOfBoolean[i1] = i2;
        i1 += 1;
        break;
      }
    }
  }

  private void m()
  {
    if (apz.b())
    {
      Activity localActivity = getActivity();
      if (!this.g.isChecked());
      for (boolean bool = true; ; bool = false)
      {
        vs.b(localActivity, "pref_lucky_leap_never_show", bool);
        return;
      }
    }
    this.l = apk.a(getActivity());
  }

  private int n()
  {
    l();
    String[] arrayOfString = getResources().getStringArray(2131623950);
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    int i2 = 0;
    if (i1 < this.j.length)
    {
      if (this.j[i1] == 0);
      while (true)
      {
        i1 += 1;
        break;
        i2 += 1;
        localStringBuilder.append(arrayOfString[i1]).append(", ");
      }
    }
    if (i2 == 0)
      return i2;
    this.i.setSummary(localStringBuilder.subSequence(0, localStringBuilder.length() - 2));
    return i2;
  }

  private void o()
  {
    this.m.getEntries()[0] = this.h.getSummary();
    if (("recentlyUsed".equals(this.m.getValue())) || ("contact".equals(this.m.getValue())))
      this.m.setSummary(this.h.getSummary());
  }

  private void p()
  {
    this.g = ((MyCheckboxPreference)a("pref_leap_switch"));
    if (!vg.k)
      if (this.g != null)
        getPreferenceScreen().removePreference(this.g);
    do
    {
      do
      {
        return;
        if (apz.b())
          break;
      }
      while (this.g == null);
      this.g.setWidgetLayoutResource(2130968730);
      this.g.a(1560281087);
      return;
    }
    while (this.g == null);
    MyCheckboxPreference localMyCheckboxPreference = this.g;
    if (!vs.c(getActivity(), "pref_lucky_leap_never_show", false));
    for (boolean bool = true; ; bool = false)
    {
      localMyCheckboxPreference.setChecked(bool);
      this.g.setWidgetLayoutResource(2130968729);
      this.g.a(getResources().getColor(2131689569));
      return;
    }
  }

  public void a()
  {
    this.k = vs.A(getActivity());
    n();
  }

  public boolean a(Preference paramPreference, String paramString)
  {
    int i1 = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1072164622:
    case 1168227666:
    case 1227919804:
    case 998503917:
    case -243641393:
    }
    while (true)
      switch (i1)
      {
      default:
        return false;
        if (paramString.equals("pref_accessibility_touch"))
        {
          i1 = 0;
          continue;
          if (paramString.equals("key_when_to_pop"))
          {
            i1 = 1;
            continue;
            if (paramString.equals("key_toucher_position"))
            {
              i1 = 2;
              continue;
              if (paramString.equals("key_tab_mode"))
              {
                i1 = 3;
                continue;
                if (paramString.equals("pref_leap_switch"))
                  i1 = 4;
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
      }
    SwipeAccessibilityService.a(getActivity(), this.f.isChecked());
    return true;
    i();
    return true;
    h();
    return true;
    k();
    return true;
    m();
    return true;
  }

  public boolean a(Preference paramPreference, String paramString, Object paramObject)
  {
    if ((paramPreference instanceof MyListPreference))
    {
      paramPreference = (MyListPreference)paramPreference;
      paramPreference.setSummary(paramPreference.getEntries()[paramPreference.findIndexOfValue((String)paramObject)]);
      if ("key_toucher_type".equals(paramString))
      {
        paramPreference = this.i;
        if (1 == asi.e((String)paramObject))
          break label77;
      }
      label77: for (boolean bool = true; ; bool = false)
      {
        paramPreference.setEnabled(bool);
        vs.b(getActivity(), "white_dot_by_suggest", false);
        return true;
      }
    }
    if (paramPreference == this.h)
    {
      this.h.setSummary(getResources().getStringArray(2131623946)[((Integer)paramObject).intValue()]);
      o();
      return true;
    }
    return super.a(paramPreference, paramString, paramObject);
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean);
    for (this.k |= vs.a[paramInt]; ; this.k &= (vs.a[paramInt] ^ 0xFFFFFFFF))
    {
      vs.d(getActivity(), this.k);
      paramDialogInterface = new Bundle(3);
      paramDialogInterface.putInt("operation", 6);
      paramDialogInterface.putInt("param_1", this.k);
      paramDialogInterface.putBoolean("param_2", true);
      SwipeService.a(getActivity(), paramDialogInterface);
      return;
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    addPreferencesFromResource(2131099649);
    this.f = ((MyCheckboxPreference)findPreference("pref_accessibility_touch"));
    int i1;
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.f.setOnPreferenceClickListener(this);
      this.a = findPreference("key_when_to_pop");
      this.a.setOnPreferenceClickListener(this);
      i1 = asq.a(getResources().getStringArray(2131623940), vs.I(paramBundle));
      this.a.setSummary(getResources().getStringArray(2131623939)[i1]);
      this.k = vs.A(getActivity());
      this.i = findPreference("key_toucher_position");
      this.i.setOnPreferenceClickListener(this);
      n();
      paramBundle = (MyListPreference)findPreference("key_toucher_type");
      paramBundle.setOnPreferenceChangeListener(this);
      paramBundle.setSummary(paramBundle.getEntry());
      paramBundle = this.i;
      if (1 == vs.d(getActivity()))
        break label319;
    }
    label319: for (boolean bool = true; ; bool = false)
    {
      paramBundle.setEnabled(bool);
      this.h = findPreference("key_tab_mode");
      this.h.setOnPreferenceClickListener(this);
      i1 = a(getActivity());
      this.h.setSummary(j()[i1]);
      this.m = ((MyListPreference)findPreference("key_default_tab_selection"));
      this.m.setOnPreferenceChangeListener(this);
      this.m.setSummary(this.m.getEntry());
      this.g = ((MyCheckboxPreference)a("pref_leap_switch"));
      this.g.setOnPreferenceClickListener(this);
      o();
      vs.a(getActivity()).registerOnSharedPreferenceChangeListener(this);
      return;
      getPreferenceScreen().removePreference(this.f);
      this.f = null;
      break;
    }
  }

  public void onDestroy()
  {
    vs.a(getActivity()).unregisterOnSharedPreferenceChangeListener(this);
    super.onDestroy();
  }

  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    vs.b(getActivity(), paramInt);
    paramSeekBar = new Bundle(2);
    paramSeekBar.putInt("operation", 8);
    paramSeekBar.putInt("param_1", paramInt);
    SwipeService.a(getActivity(), paramSeekBar);
  }

  public void onResume()
  {
    super.onResume();
    Activity localActivity = getActivity();
    try
    {
      boolean bool = SwipeAccessibilityService.a(localActivity);
      if (this.f != null)
        this.f.setChecked(bool);
      if ((Boolean.FALSE.equals(this.n)) && (Boolean.TRUE.equals(Boolean.valueOf(bool))))
        aso.a(getActivity(), 2131231061);
      this.n = Boolean.valueOf(bool);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    boolean bool = false;
    if ("key_tab_mode".equals(paramString))
      onPreferenceChange(this.h, Integer.valueOf(paramSharedPreferences.getInt(paramString, 0)));
    while ((!"pref_lucky_leap_never_show".equals(paramString)) || (this.g == null))
      return;
    paramSharedPreferences = this.g;
    if (!vs.c(getActivity(), "pref_lucky_leap_never_show", false))
      bool = true;
    paramSharedPreferences.setChecked(bool);
  }

  public void onStart()
  {
    super.onStart();
    p();
    if (vg.k)
    {
      apz.a(getActivity());
      apz.a(getActivity(), this.o);
    }
  }

  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
  }

  public void onStop()
  {
    super.onStop();
    g();
    if (vg.k)
      apz.b(getActivity(), this.o);
  }

  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.AdvancedSettingsFragment
 * JD-Core Version:    0.6.2
 */