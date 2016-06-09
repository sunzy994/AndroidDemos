package cmcm.com.myapplication.com.lazyswipe.ui;

import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import aou;
import asr;
import atw;
import awg;
import awp;
import com.lazyswipe.preference.MyListPreference;
import com.lazyswipe.widget.Toolbar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class BasePreferenceFragment extends PreferenceFragment
  implements OnPreferenceChangeListener, OnPreferenceClickListener, OnClickListener, awg
{
  protected Toolbar b;
  protected TextView c;
  protected SimpleDateFormat d;

  public final <T extends View> T a(View paramView, int paramInt)
  {
    return asr.a(paramView, paramInt);
  }

  protected <T> T a(CharSequence paramCharSequence)
  {
    return findPreference(paramCharSequence);
  }

  protected void a(View paramView)
  {
  }

  public boolean a(Preference paramPreference, String paramString)
  {
    return false;
  }

  public boolean a(Preference paramPreference, String paramString, Object paramObject)
  {
    if ((paramPreference instanceof MyListPreference))
    {
      paramPreference = (MyListPreference)paramPreference;
      paramPreference.setSummary(paramPreference.getEntries()[paramPreference.findIndexOfValue((String)paramObject)]);
      return true;
    }
    return false;
  }

  public boolean a(awp paramawp)
  {
    return false;
  }

  protected void b()
  {
    this.b.setCallback(this);
    d();
    this.b.setTitle(e());
    this.b.setMenu(f());
    this.b.setButtonBackground(2130837745);
    this.b.setTitleColor(-1);
  }

  protected void b(View paramView)
  {
  }

  protected boolean c()
  {
    return true;
  }

  protected void d()
  {
    this.b.setIcon(atw.a(getActivity(), 2130837512));
  }

  protected CharSequence e()
  {
    return getActivity().getTitle();
  }

  protected int f()
  {
    return 0;
  }

  public void onActionClick(View paramView)
  {
    a(paramView);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      a(paramView);
      return;
    case 2131755063:
    case 2131755064:
    }
    getActivity().finish();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramViewGroup == null)
      return null;
    paramLayoutInflater = paramLayoutInflater.inflate(2130968725, paramViewGroup, false);
    this.b = ((Toolbar)a(paramLayoutInflater, 2131755045));
    if (c())
      b();
    while (true)
    {
      this.d = new SimpleDateFormat("HH:mm", Locale.US);
      this.c = ((TextView)a(paramLayoutInflater, 2131755047));
      this.c.setText(this.d.format(new Date()));
      b(paramLayoutInflater);
      paramLayoutInflater.setBackgroundDrawable(aou.a());
      return paramLayoutInflater;
      this.b.setVisibility(8);
      this.b = null;
    }
  }

  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if (paramPreference == null);
    String str;
    do
    {
      return false;
      str = paramPreference.getKey();
    }
    while ((TextUtils.isEmpty(str)) || (!a(paramPreference, str, paramObject)));
    return true;
  }

  public boolean onPreferenceClick(Preference paramPreference)
  {
    if (paramPreference == null);
    String str;
    do
    {
      return false;
      str = paramPreference.getKey();
    }
    while ((TextUtils.isEmpty(str)) || (!a(paramPreference, str)));
    return true;
  }

  public void onResume()
  {
    super.onResume();
    if (this.c != null)
      this.c.setText(this.d.format(new Date()));
  }

  public void onStop()
  {
    super.onStop();
    this.b.b();
  }

  public void onTitleClick(View paramView)
  {
    onClick(paramView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.BasePreferenceFragment
 * JD-Core Version:    0.6.2
 */