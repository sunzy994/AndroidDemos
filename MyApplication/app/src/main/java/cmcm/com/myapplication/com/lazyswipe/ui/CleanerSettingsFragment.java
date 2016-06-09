package cmcm.com.myapplication.com.lazyswipe.ui;

import acw;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.view.LayoutInflater;
import aso;
import com.lazyswipe.preference.BlackListLayout;
import com.lazyswipe.preference.MyCheckboxPreference;
import com.lazyswipe.ui.chooser.MultiChooserActivity;
import tk;
import vs;
import vy;

public class CleanerSettingsFragment extends BasePreferenceFragment
{
  private MyCheckboxPreference a;
  private Preference e;
  private Preference f;
  private Dialog g;

  private void a()
  {
    BlackListLayout localBlackListLayout = (BlackListLayout)LayoutInflater.from(getActivity()).inflate(2130968722, null, false);
    localBlackListLayout.setRequestType(4);
    final Activity localActivity = getActivity();
    final Resources localResources = getResources();
    final int i = g();
    h();
    this.g = new tk(localActivity).c(2131231040).a(2131623936, i, new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        boolean bool = true;
        try
        {
          if (i != paramAnonymousInt)
            if (paramAnonymousInt != 1)
              break label64;
          while (true)
          {
            acw.a(localActivity, bool);
            String str = localResources.getStringArray(2131623936)[paramAnonymousInt];
            CleanerSettingsFragment.a(CleanerSettingsFragment.this).setSummary(str);
            aso.a(localActivity, 2131231061);
            return;
            label64: bool = false;
          }
        }
        catch (Exception localException)
        {
        }
        finally
        {
          paramAnonymousDialogInterface.dismiss();
        }
      }
    }).i(0).c(true).b(localBlackListLayout).b();
  }

  private int g()
  {
    if (acw.a(getActivity()))
      return 1;
    return 0;
  }

  private void h()
  {
    if ((this.g != null) && (this.g.isShowing()))
      this.g.cancel();
    this.g = null;
  }

  private boolean i()
  {
    final Activity localActivity = getActivity();
    if (!acw.b(localActivity))
    {
      acw.b(localActivity, true);
      return true;
    }
    if (acw.a(localActivity))
    {
      acw.b(localActivity, false);
      return true;
    }
    h();
    this.g = new tk(localActivity).c(2131230968).g(2131230967).a(17039370, new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        acw.a(localActivity, true);
        CleanerSettingsFragment.a(CleanerSettingsFragment.this).setSummary(CleanerSettingsFragment.this.getResources().getStringArray(2131623936)[1]);
        paramAnonymousDialogInterface.dismiss();
      }
    }).b(2131231016, new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        acw.b(localActivity, false);
        CleanerSettingsFragment.b(CleanerSettingsFragment.this).setChecked(false);
        paramAnonymousDialogInterface.dismiss();
      }
    }).a(new OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
      }
    }).f(-1).c(true).b();
    return false;
  }

  public boolean a(Preference paramPreference, String paramString)
  {
    boolean bool = true;
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 1956652244:
    case -1641663667:
    case -866195318:
    }
    while (true)
      switch (i)
      {
      default:
        bool = false;
      case 2:
        return bool;
        if (paramString.equals("key_white_list"))
        {
          i = 0;
          continue;
          if (paramString.equals("key_memory_tip_show_time"))
          {
            i = 1;
            continue;
            if (paramString.equals("key_pop_weather_detail"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      }
    vy.a(getActivity(), "BK");
    paramPreference = MultiChooserActivity.c(true);
    paramPreference.putExtra("extra.request_type", 0);
    startActivityForResult(paramPreference, 1);
    return true;
    a();
    return true;
  }

  public boolean a(Preference paramPreference, String paramString, Object paramObject)
  {
    getActivity();
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1191577147:
    }
    while (true)
      switch (i)
      {
      default:
        return false;
        if (paramString.equals("key_memory_tip_enable"))
          i = 0;
        break;
      case 0:
      }
    return i();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (-1 != paramInt2)
      return;
    switch (paramInt1)
    {
    default:
      return;
    case 1:
    }
    paramInt1 = paramIntent.getIntExtra("extra.result_chosen_count", 0);
    this.e.setSummary(getString(2131231011, new Object[] { Integer.valueOf(paramInt1) }));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    addPreferencesFromResource(2131099651);
    this.a = ((MyCheckboxPreference)findPreference("key_memory_tip_enable"));
    this.a.setOnPreferenceChangeListener(this);
    this.e = findPreference("key_white_list");
    this.e.setOnPreferenceClickListener(this);
    int i = vs.N(paramBundle);
    this.e.setSummary(getString(2131231011, new Object[] { Integer.valueOf(i) }));
    this.f = findPreference("key_memory_tip_show_time");
    this.f.setOnPreferenceClickListener(this);
    this.f.setSummary(getResources().getStringArray(2131623936)[g()]);
  }

  public void onResume()
  {
    super.onResume();
    acw.a(getActivity(), false, true);
  }

  public void onStop()
  {
    super.onStop();
    acw.d(getActivity(), false);
    h();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.CleanerSettingsFragment
 * JD-Core Version:    0.6.2
 */