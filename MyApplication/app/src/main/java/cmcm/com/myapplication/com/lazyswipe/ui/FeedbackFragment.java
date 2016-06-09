package cmcm.com.myapplication.com.lazyswipe.ui;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import arl;
import aso;
import asp;
import ci;
import com.lazyswipe.SwipeServicePhantom;
import com.lazyswipe.widget.webview.SimpleWebViewActivity;
import java.util.Locale;
import vs;
import wd;

public class FeedbackFragment extends BaseFragment
{
  private static final String g = "Swipe." + FeedbackFragment.class.getSimpleName();
  View a;
  EditText f;
  private BroadcastReceiver h;
  private EditText i;

  public static void a(Context paramContext)
  {
    SimpleWebViewActivity.a("http://www.lazyswipe.com/help.html?lang=" + Locale.getDefault().getLanguage(), paramContext.getString(2131231246));
  }

  private void b()
  {
    if (!arl.h(getActivity()))
    {
      aso.a(getActivity(), 2131230908);
      return;
    }
    if (TextUtils.isEmpty(this.i.getText()))
    {
      aso.a(getActivity(), 2131230930);
      return;
    }
    if (TextUtils.isEmpty(this.f.getText()))
    {
      aso.a(getActivity(), 2131230928);
      return;
    }
    this.h = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        FeedbackFragment.this.a.setEnabled(true);
        FeedbackFragment.this.f.setText(null);
        ci.a(paramAnonymousContext).a(this);
        FeedbackFragment.a(FeedbackFragment.this, null);
        aso.a(paramAnonymousContext, 2131230934);
      }
    };
    ci.a(getActivity()).a(this.h, new IntentFilter("Swipe..intent.action.FEEDBACK_SENT"));
    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f.getWindowToken(), 0);
    this.a.setEnabled(false);
    aso.a(getActivity(), 2131230933);
    wd.a(getActivity().getApplicationContext(), null, this.f.getText().toString(), this.i.getText().toString());
  }

  private void d()
  {
    try
    {
      Account[] arrayOfAccount = AccountManager.get(getActivity()).getAccountsByType("com.google");
      if (arrayOfAccount.length > 0)
        this.i.setText(arrayOfAccount[0].name);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected int a()
  {
    return 2130968640;
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    this.f = ((EditText)a(paramView, 2131755255));
    this.i = ((EditText)a(paramView, 2131755256));
    TextView localTextView = (TextView)a(paramView, 2131755257);
    localTextView.setText(Html.fromHtml(getString(2131230931)));
    localTextView.setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FeedbackFragment.a(FeedbackFragment.this.getActivity());
      }
    });
    this.a = a(paramView, 2131755258);
    this.a.setOnClickListener(this);
    d();
  }

  protected void b(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131755258:
    }
    b();
  }

  protected CharSequence i()
  {
    return getText(2131230780);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    asp.c();
    if (vs.H(getActivity()))
      getActivity().startService(new Intent(getActivity(), SwipeServicePhantom.class).setAction("com.lazyswipe.action.FLUSH_TRACE"));
  }

  // ERROR //
  public void onDestroyView()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 262	com/lazyswipe/ui/BaseFragment:onDestroyView	()V
    //   4: aload_0
    //   5: getfield 46	com/lazyswipe/ui/FeedbackFragment:h	Landroid/content/BroadcastReceiver;
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: invokevirtual 75	com/lazyswipe/ui/FeedbackFragment:getActivity	()Landroid/app/Activity;
    //   15: invokestatic 112	ci:a	(Landroid/content/Context;)Lci;
    //   18: aload_0
    //   19: getfield 46	com/lazyswipe/ui/FeedbackFragment:h	Landroid/content/BroadcastReceiver;
    //   22: invokevirtual 265	ci:a	(Landroid/content/BroadcastReceiver;)V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 46	com/lazyswipe/ui/FeedbackFragment:h	Landroid/content/BroadcastReceiver;
    //   30: return
    //   31: astore_1
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 46	com/lazyswipe/ui/FeedbackFragment:h	Landroid/content/BroadcastReceiver;
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 46	com/lazyswipe/ui/FeedbackFragment:h	Landroid/content/BroadcastReceiver;
    //   44: aload_1
    //   45: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   11	25	31	java/lang/Exception
    //   11	25	38	finally
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.FeedbackFragment
 * JD-Core Version:    0.6.2
 */