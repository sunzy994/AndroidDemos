package cmcm.com.myapplication.com.lazyswipe.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import aou;
import aso;
import ave;
import com.lazyswipe.SwipeService;
import vs;

public class ToucherPositionSettingFragment extends BaseFragment
  implements OnSeekBarChangeListener
{
  private static final String a = "Swipe." + ToucherPositionSettingFragment.class.getSimpleName();
  private ListView f;
  private boolean[] g;
  private int h;

  private void b()
  {
    Bundle localBundle = new Bundle(2);
    localBundle.putInt("operation", 7);
    localBundle.putBoolean("param_1", true);
    SwipeService.a(getActivity(), localBundle);
  }

  private void d()
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putInt("operation", 7);
    try
    {
      SwipeService.a(getActivity().getApplicationContext(), localBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void e()
  {
    if (this.g == null)
      this.g = new boolean[vs.a.length];
    int i = 0;
    if (i < vs.a.length)
    {
      boolean[] arrayOfBoolean = this.g;
      if (vs.a[i] == (this.h & vs.a[i]));
      for (int j = 1; ; j = 0)
      {
        arrayOfBoolean[i] = j;
        i += 1;
        break;
      }
    }
  }

  protected int a()
  {
    return 2130968648;
  }

  protected boolean c()
  {
    return false;
  }

  public boolean l()
  {
    d();
    return super.l();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.h = vs.A(getActivity());
    e();
  }

  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    vs.b(getActivity(), paramInt);
    paramSeekBar = new Bundle(2);
    paramSeekBar.putInt("operation", 8);
    paramSeekBar.putInt("param_1", paramInt);
    SwipeService.a(getActivity(), paramSeekBar);
  }

  public void onStart()
  {
    super.onStart();
    b();
  }

  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
  }

  public void onStop()
  {
    super.onStop();
    d();
  }

  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = (ave)a(paramView, 2131755519);
    paramBundle.setProgress(vs.p(getActivity()));
    paramBundle.setOnSeekBarChangeListener(this);
    this.f = ((ListView)a(paramView, 2131755046));
    paramBundle = getResources().getTextArray(2131623950);
    paramBundle = new ArrayAdapter(getActivity(), 2130968760, 16908308, paramBundle)
    {
      public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
        if (ToucherPositionSettingFragment.a(ToucherPositionSettingFragment.this) != null)
        {
          int i = ToucherPositionSettingFragment.a(ToucherPositionSettingFragment.this)[paramAnonymousInt];
          ToucherPositionSettingFragment.b(ToucherPositionSettingFragment.this).setItemChecked(paramAnonymousInt, i);
        }
        return paramAnonymousView;
      }
    };
    this.f.setOnItemClickListener(new OnItemClickListener()
    {
      public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        boolean bool2 = true;
        boolean bool3;
        if ((paramAnonymousLong >= 0L) && (ToucherPositionSettingFragment.a(ToucherPositionSettingFragment.this) != null))
        {
          int m = ToucherPositionSettingFragment.a(ToucherPositionSettingFragment.this).length;
          if (paramAnonymousLong < m)
          {
            int n = (int)paramAnonymousLong;
            bool3 = ToucherPositionSettingFragment.b(ToucherPositionSettingFragment.this).isItemChecked(paramAnonymousInt);
            ToucherPositionSettingFragment.a(ToucherPositionSettingFragment.this)[n] = bool3;
            int i = 0;
            int k;
            for (int j = 0; i < m; j = k)
            {
              k = j;
              if (ToucherPositionSettingFragment.a(ToucherPositionSettingFragment.this)[i] == 0)
                k = j + 1;
              i += 1;
            }
            if ((m <= 1) || (j < m))
              break label202;
            paramAnonymousAdapterView = ToucherPositionSettingFragment.a(ToucherPositionSettingFragment.this);
            if (bool3)
              break label190;
            bool1 = true;
            paramAnonymousAdapterView[n] = bool1;
            paramAnonymousAdapterView = ToucherPositionSettingFragment.b(ToucherPositionSettingFragment.this);
            if (bool3)
              break label196;
          }
        }
        label190: label196: for (boolean bool1 = bool2; ; bool1 = false)
        {
          paramAnonymousAdapterView.setItemChecked(paramAnonymousInt, bool1);
          aso.a(ToucherPositionSettingFragment.this.getActivity(), 2131230985);
          return;
          bool1 = false;
          break;
        }
        label202: if (bool3)
          ToucherPositionSettingFragment.a(ToucherPositionSettingFragment.this, ToucherPositionSettingFragment.c(ToucherPositionSettingFragment.this) | vs.a[paramAnonymousInt]);
        while (true)
        {
          vs.d(ToucherPositionSettingFragment.this.getActivity(), ToucherPositionSettingFragment.c(ToucherPositionSettingFragment.this));
          paramAnonymousAdapterView = new Bundle(3);
          paramAnonymousAdapterView.putInt("operation", 6);
          paramAnonymousAdapterView.putInt("param_1", ToucherPositionSettingFragment.c(ToucherPositionSettingFragment.this));
          paramAnonymousAdapterView.putBoolean("param_2", true);
          SwipeService.a(ToucherPositionSettingFragment.this.getActivity(), paramAnonymousAdapterView);
          return;
          ToucherPositionSettingFragment.a(ToucherPositionSettingFragment.this, ToucherPositionSettingFragment.c(ToucherPositionSettingFragment.this) & (vs.a[paramAnonymousInt] ^ 0xFFFFFFFF));
        }
      }
    });
    this.f.setChoiceMode(2);
    this.f.setAdapter(paramBundle);
    paramView.setBackgroundDrawable(aou.a());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.ToucherPositionSettingFragment
 * JD-Core Version:    0.6.2
 */