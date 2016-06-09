package cmcm.com.myapplication.com.lazyswipe.fan.tab;

import aaj;
import aak;
import aal;
import aan;
import aao;
import aap;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import aqt;
import asi;
import aso;
import awy;
import axi;
import axn;
import com.lazyswipe.SwipeService;
import com.lazyswipe.ui.BasePreferenceLikeFragment;
import com.lazyswipe.widget.listview.DragSortListView;
import java.util.ArrayList;
import java.util.List;
import tj;
import tk;
import vs;

public class CustomTabSettingsFragment extends BasePreferenceLikeFragment
  implements View.OnClickListener
{
  private static final String d = "Swipe." + CustomTabSettingsFragment.class.getSimpleName();
  private DragSortListView e;
  private aak f;
  private List<aao> g = new ArrayList();
  private Handler h = new Handler();
  private tj i;
  private InputMethodManager j = null;

  private awy a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new awy(paramDragSortListView);
    paramDragSortListView.c(2131755212);
    paramDragSortListView.b(false);
    paramDragSortListView.a(true);
    paramDragSortListView.a(1);
    paramDragSortListView.e(2046162421);
    return paramDragSortListView;
  }

  private void a(final aaj paramaaj)
  {
    final EditText localEditText = (EditText)LayoutInflater.from(getActivity()).inflate(2130968662, null);
    localEditText.setText(paramaaj.a(getActivity()));
    localEditText.setGravity(19);
    localEditText.requestFocus();
    this.i = new tk(getActivity()).c(2131230890).a(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str = localEditText.getText().toString().trim();
        if (asi.f(str))
        {
          aso.a(CustomTabSettingsFragment.this.getActivity(), 2131230891);
          return;
        }
        aaj localaaj = paramaaj;
        aaj.a(CustomTabSettingsFragment.this.getActivity(), str);
        CustomTabSettingsFragment.b(CustomTabSettingsFragment.this).notifyDataSetChanged();
        paramAnonymousDialogInterface.dismiss();
      }
    }).b(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    }).f(-1).a(localEditText).b();
    localEditText.post(new Runnable()
    {
      public void run()
      {
        try
        {
          CustomTabSettingsFragment.d(CustomTabSettingsFragment.this).showSoftInput(localEditText, 1);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    });
  }

  protected int a()
  {
    return 2130968576;
  }

  protected void a(View paramView)
  {
    this.g = aap.d(getActivity());
    this.j = ((InputMethodManager)getActivity().getSystemService("input_method"));
    this.e = ((DragSortListView)paramView.findViewById(2131755046));
    paramView = LayoutInflater.from(getActivity());
    ViewGroup localViewGroup = (ViewGroup)paramView.inflate(2130968623, null);
    localViewGroup.findViewById(2131755212).setVisibility(4);
    ((TextView)localViewGroup.findViewById(2131755211)).setText(new aan().a(getActivity()));
    this.e.addHeaderView(localViewGroup);
    paramView = (ViewGroup)paramView.inflate(2130968623, null);
    paramView.findViewById(2131755212).setVisibility(4);
    ((TextView)paramView.findViewById(2131755211)).setText(new aal().a(getActivity()));
    this.e.addHeaderView(paramView);
    this.f = new aak(this, null);
    this.e.setAdapter(this.f);
    paramView = a(this.e);
    this.e.setFloatViewManager(paramView);
    this.e.setOnTouchListener(paramView);
    this.e.setDragEnabled(true);
    this.e.setOnSwipeListener(new axn()
    {
      public boolean a(int paramAnonymousInt)
      {
        return false;
      }

      public void b(int paramAnonymousInt)
      {
      }

      public void c(int paramAnonymousInt)
      {
      }
    });
    this.e.setDropListener(new axi()
    {
      public void a_(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        aao localaao = (aao)CustomTabSettingsFragment.a(CustomTabSettingsFragment.this).remove(paramAnonymousInt1);
        CustomTabSettingsFragment.a(CustomTabSettingsFragment.this).add(paramAnonymousInt2, localaao);
        aap.a(CustomTabSettingsFragment.this.getActivity(), CustomTabSettingsFragment.a(CustomTabSettingsFragment.this));
        CustomTabSettingsFragment.b(CustomTabSettingsFragment.this).notifyDataSetChanged();
        if ((aap.b(CustomTabSettingsFragment.this.getActivity()) instanceof aaj))
        {
          vs.b(CustomTabSettingsFragment.this.getActivity(), "custom_tab_available", true);
          if (!vs.c(CustomTabSettingsFragment.this.getActivity(), "ever_change_custom_tab", false))
            CustomTabSettingsFragment.c(CustomTabSettingsFragment.this).postDelayed(new Runnable()
            {
              public void run()
              {
                SwipeService.b("custom");
              }
            }
            , 200L);
        }
      }
    });
  }

  protected void b(View paramView)
  {
    if ((paramView.getTag() instanceof aaj))
      a((aaj)paramView.getTag());
  }

  public void onStop()
  {
    super.onStop();
    aqt.a(this.i);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.tab.CustomTabSettingsFragment
 * JD-Core Version:    0.6.2
 */