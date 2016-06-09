package cmcm.com.myapplication.com.lazyswipe.ui;

import all;
import alo;
import alx;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import arm;
import asi;
import asq;
import avx;
import com.lazyswipe.preference.MyCheckboxPreference;
import com.lazyswipe.preference.MyListPreference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tk;
import vg;
import vs;
import vy;

public class NotificationSettingsFragment extends BasePreferenceFragment
{
  private Preference a;
  private boolean e;
  private OnSharedPreferenceChangeListener f;
  private HashSet<String> g = new HashSet();
  private List<MyCheckboxPreference> h = new ArrayList();
  private LayoutParams i;
  private WindowManager j;
  private View k;
  private boolean l = false;

  private void a()
  {
    vy.a(getActivity(), "BL");
    if (this.e)
    {
      NotificationSettingsActivity.a(getActivity(), (String[])this.g.toArray(new String[this.g.size()]));
      return;
    }
    this.l = true;
    com.lazyswipe.SwipeService.a = System.currentTimeMillis();
    alo.e(getActivity());
  }

  public static void a(final Context paramContext)
  {
    int m = vs.b(paramContext);
    CharSequence[] arrayOfCharSequence1 = paramContext.getResources().getTextArray(2131623937);
    CharSequence[] arrayOfCharSequence2 = paramContext.getResources().getTextArray(2131623938);
    m = asq.a(arrayOfCharSequence2, String.valueOf(m));
    new avx(paramContext).c(2131231042).a(arrayOfCharSequence1, m, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str = NotificationSettingsFragment.this[paramAnonymousInt].toString();
        vs.a(paramContext, str);
        NotificationSettingsFragment.a(paramContext, asi.e(str));
        paramAnonymousDialogInterface.dismiss();
      }
    }).c(true).b();
  }

  public static void a(Context paramContext, final int paramInt)
  {
    if (!vg.j)
      return;
    if (!asq.n())
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          NotificationSettingsFragment.a(NotificationSettingsFragment.this, paramInt);
        }
      });
      return;
    }
    switch (paramInt)
    {
    default:
      return;
    case 1:
    case 2:
      alx.a(paramContext, paramInt).f();
      return;
    case 3:
    }
    alx.c();
    all.b(true);
  }

  private void a(SharedPreferences paramSharedPreferences)
  {
    a(paramSharedPreferences.getString("key_notification_apps_selected", ""));
  }

  private void a(String paramString)
  {
    this.g.clear();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      this.g.addAll(Arrays.asList(paramString));
    }
  }

  private void a(String paramString1, String paramString2)
  {
    paramString1 = (MyCheckboxPreference)findPreference(paramString1);
    if ((!asq.c(getActivity(), paramString2)) || (!arm.b(paramString2)))
    {
      getPreferenceScreen().removePreference(paramString1);
      return;
    }
    paramString1.setOnPreferenceChangeListener(this);
    if ((alo.d(getActivity())) && (this.g.contains(paramString2)));
    for (boolean bool = true; ; bool = false)
    {
      paramString1.setChecked(bool);
      paramString1.a(paramString2);
      paramString1.setTitle(asq.e(getActivity(), paramString2));
      this.h.add(paramString1);
      return;
    }
  }

  private boolean a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      if (this.g.remove(paramString))
        vs.a(getActivity()).edit().putString("key_notification_apps_selected", TextUtils.join(",", this.g)).apply();
    do
    {
      return true;
      if (!this.e)
        break;
    }
    while (!this.g.add(paramString));
    vs.a(getActivity()).edit().putString("key_notification_apps_selected", TextUtils.join(",", this.g)).apply();
    return true;
    this.l = true;
    com.lazyswipe.SwipeService.a = System.currentTimeMillis();
    alo.e(getActivity());
    return false;
  }

  private void g()
  {
    this.i = new LayoutParams();
    this.i.height = -1;
    this.i.width = -1;
    this.i.format = -3;
    this.i.type = 2003;
    this.i.flags = 1032;
    this.j = ((WindowManager)getActivity().getApplicationContext().getSystemService("window"));
    this.k = getActivity().getLayoutInflater().inflate(2130968653, null);
    this.j.addView(this.k, this.i);
    this.k.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (NotificationSettingsFragment.c(NotificationSettingsFragment.this) != null);
        try
        {
          NotificationSettingsFragment.c(NotificationSettingsFragment.this).removeView(NotificationSettingsFragment.d(NotificationSettingsFragment.this));
          NotificationSettingsFragment.a(NotificationSettingsFragment.this, false);
          return;
        }
        catch (Exception paramAnonymousView)
        {
        }
      }
    });
  }

  public boolean a(Preference paramPreference, String paramString)
  {
    int m = -1;
    switch (paramString.hashCode())
    {
    default:
    case -74681516:
    }
    while (true)
      switch (m)
      {
      default:
        return false;
        if (paramString.equals("key_notification_apps_selected"))
          m = 0;
        break;
      case 0:
      }
    a();
    return true;
  }

  public boolean a(Preference paramPreference, String paramString, Object paramObject)
  {
    int m = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1486167235:
    case -2138514447:
    case 437675160:
    case 105479044:
    case -1310023988:
    case -663703159:
    case -1188670162:
    }
    while (true)
      switch (m)
      {
      default:
        return false;
        if (paramString.equals("key_notification_style"))
        {
          m = 0;
          continue;
          if (paramString.equals("key_sms_notification"))
          {
            m = 1;
            continue;
            if (paramString.equals("key_whatsapp_notification"))
            {
              m = 2;
              continue;
              if (paramString.equals("key_wechat_notification"))
              {
                m = 3;
                continue;
                if (paramString.equals("key_gmail_notification"))
                {
                  m = 4;
                  continue;
                  if (paramString.equals("key_telegram_notification"))
                  {
                    m = 5;
                    continue;
                    if (paramString.equals("key_viber_notification"))
                      m = 6;
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
    paramPreference = (MyListPreference)paramPreference;
    paramString = (String)paramObject;
    paramPreference.setSummary(paramPreference.getEntries()[paramPreference.findIndexOfValue(paramString)]);
    a(getActivity(), asi.e(paramString));
    return true;
    if (((Boolean)paramObject).booleanValue())
    {
      vy.c(true);
      return true;
    }
    vy.c(false);
    return true;
    return a("com.whatsapp", ((Boolean)paramObject).booleanValue());
    return a("com.tencent.mm", ((Boolean)paramObject).booleanValue());
    return a("com.google.android.gm", ((Boolean)paramObject).booleanValue());
    return a("org.telegram.messenger", ((Boolean)paramObject).booleanValue());
    return a("com.viber.voip", ((Boolean)paramObject).booleanValue());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099654);
    a(vs.a(getActivity()));
    findPreference("key_sms_notification").setOnPreferenceChangeListener(this);
    a("key_whatsapp_notification", "com.whatsapp");
    a("key_wechat_notification", "com.tencent.mm");
    a("key_gmail_notification", "com.google.android.gm");
    a("key_telegram_notification", "org.telegram.messenger");
    a("key_viber_notification", "com.viber.voip");
    this.a = findPreference("key_notification_apps_selected");
    this.a.setOnPreferenceClickListener(this);
    this.f = new OnSharedPreferenceChangeListener()
    {
      public void onSharedPreferenceChanged(SharedPreferences paramAnonymousSharedPreferences, String paramAnonymousString)
      {
        if ("key_notification_apps_selected".equals(paramAnonymousString))
        {
          paramAnonymousSharedPreferences = paramAnonymousSharedPreferences.getString("key_notification_apps_selected", "");
          NotificationSettingsFragment.a(NotificationSettingsFragment.this, paramAnonymousSharedPreferences);
          paramAnonymousSharedPreferences = NotificationSettingsFragment.a(NotificationSettingsFragment.this).iterator();
          if (paramAnonymousSharedPreferences.hasNext())
          {
            paramAnonymousString = (MyCheckboxPreference)paramAnonymousSharedPreferences.next();
            if ((alo.d(NotificationSettingsFragment.this.getActivity())) && (NotificationSettingsFragment.b(NotificationSettingsFragment.this).contains(paramAnonymousString.a())));
            for (boolean bool = true; ; bool = false)
            {
              paramAnonymousString.setChecked(bool);
              break;
            }
          }
        }
      }
    };
    vs.a(getActivity()).registerOnSharedPreferenceChangeListener(this.f);
    paramBundle = (MyListPreference)findPreference("key_notification_style");
    paramBundle.setOnPreferenceChangeListener(this);
    paramBundle.setSummary(paramBundle.getEntry());
  }

  public void onDestroy()
  {
    super.onDestroy();
    vs.a(getActivity()).unregisterOnSharedPreferenceChangeListener(this.f);
  }

  public void onPause()
  {
    super.onPause();
    if (this.l)
      g();
  }

  public void onResume()
  {
    super.onResume();
    this.l = false;
    if (this.j != null);
    try
    {
      this.j.removeView(this.k);
      Object localObject = getActivity();
      try
      {
        this.e = alo.d((Context)localObject);
        MyCheckboxPreference localMyCheckboxPreference;
        if (this.e)
        {
          int m = this.g.size();
          localObject = this.h.iterator();
          if (((Iterator)localObject).hasNext())
          {
            localMyCheckboxPreference = (MyCheckboxPreference)((Iterator)localObject).next();
            if (!this.g.contains(localMyCheckboxPreference.a()))
              break label236;
            m -= 1;
            break label236;
          }
          this.a.setSummary(getString(2131231011, new Object[] { Integer.valueOf(m) }));
        }
        while (true)
        {
          localObject = this.h.iterator();
          while (true)
          {
            if (!((Iterator)localObject).hasNext())
              break label231;
            localMyCheckboxPreference = (MyCheckboxPreference)((Iterator)localObject).next();
            if ((!alo.d(getActivity())) || (!this.g.contains(localMyCheckboxPreference.a())))
              break;
            bool = true;
            localMyCheckboxPreference.setChecked(bool);
          }
          this.a.setSummary(2131231012);
        }
      }
      catch (Exception localException1)
      {
        while (true)
        {
          asq.b(localException1, 5, "Swipe.NotifySettings", "onResume failed");
          continue;
          boolean bool = false;
        }
      }
      label231: return;
    }
    catch (Exception localException2)
    {
      label236: 
      while (true);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.NotificationSettingsFragment
 * JD-Core Version:    0.6.2
 */