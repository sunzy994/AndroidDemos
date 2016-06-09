package cmcm.com.myapplication.com.lazyswipe.ui;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import aqs;

public class InitialSettingsFragment extends BasePreferenceFragment
{
  private int a;

  private void a()
  {
    switch (this.a)
    {
    default:
      return;
    case 1:
      FullscreenTipActivity.a(getActivity());
      return;
    case 2:
      FullscreenTipActivity.d(getActivity());
      return;
    case 3:
    }
    FullscreenTipActivity.c(getActivity());
  }

  private void a(Preference paramPreference1, Preference paramPreference2)
  {
    this.a = b(getActivity());
    PreferenceScreen localPreferenceScreen = getPreferenceScreen();
    switch (this.a)
    {
    default:
      localPreferenceScreen.removePreference(paramPreference1);
      localPreferenceScreen.removePreference(paramPreference2);
      return;
    case 1:
      localPreferenceScreen.removePreference(paramPreference2);
      paramPreference1.setTitle(2131231045);
      paramPreference1.setSummary(2131231030);
      paramPreference1.setOnPreferenceClickListener(this);
      return;
    case 2:
      localPreferenceScreen.removePreference(paramPreference2);
      paramPreference1.setTitle(2131231046);
      paramPreference1.setSummary(2131231030);
      paramPreference1.setOnPreferenceClickListener(this);
      return;
    case 3:
    }
    paramPreference1.setTitle(2131231045);
    paramPreference1.setSummary(2131231030);
    paramPreference2.setTitle(2131231044);
    paramPreference2.setSummary(2131231029);
    paramPreference1.setOnPreferenceClickListener(this);
    paramPreference2.setOnPreferenceClickListener(this);
  }

  public static boolean a(Context paramContext)
  {
    return b(paramContext) == 0;
  }

  public static int b(Context paramContext)
  {
    if (aqs.E())
      return 1;
    if ((aqs.D()) || (aqs.p()))
      return 2;
    if ((aqs.K()) && (aqs.k(paramContext)))
      return 3;
    return 0;
  }

  private void g()
  {
    switch (this.a)
    {
    default:
      return;
    case 3:
    }
    FullscreenTipActivity.b(getActivity());
  }

  public boolean a(Preference paramPreference, String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 1705792230:
    case 1705792231:
    }
    while (true)
      switch (i)
      {
      default:
        return false;
        if (paramString.equals("pref_setting_1"))
        {
          i = 0;
          continue;
          if (paramString.equals("pref_setting_2"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    a();
    return true;
    g();
    return true;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099652);
    a(findPreference("pref_setting_1"), findPreference("pref_setting_2"));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.InitialSettingsFragment
 * JD-Core Version:    0.6.2
 */