package cmcm.com.myapplication.com.lazyswipe.ui;

import android.os.Bundle;
import com.lazyswipe.SwipeService;
import com.lazyswipe.preference.MyListPreference;

public class WeatherSettingsFragment extends BasePreferenceFragment
{
  public static boolean a;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099655);
    paramBundle = (MyListPreference)findPreference("temperatur_unit");
    if (paramBundle != null)
    {
      paramBundle.setOnPreferenceChangeListener(this);
      paramBundle.setSummary(paramBundle.getEntry());
    }
  }

  public void onStop()
  {
    if (a)
      SwipeService.b(getActivity());
    super.onStop();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.WeatherSettingsFragment
 * JD-Core Version:    0.6.2
 */