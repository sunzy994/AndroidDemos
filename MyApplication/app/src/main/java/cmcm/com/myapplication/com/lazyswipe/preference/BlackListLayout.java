package cmcm.com.myapplication.com.lazyswipe.preference;

import aft;
import afu;
import aly;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aso;
import ci;
import com.lazyswipe.ui.chooser.MultiChooserActivity;

public class BlackListLayout extends RelativeLayout
  implements OnClickListener
{
  private static final String a = "Swipe." + BlackListLayout.class.getSimpleName();
  private int b;
  private TextView c;
  private final BroadcastReceiver d = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent == null);
      while (!"ACTION_CHOOSE_POP_BLACK_LIST".equals(paramAnonymousIntent.getAction()))
        return;
      BlackListLayout.a(BlackListLayout.this);
      aso.a(paramAnonymousContext, 2131231061);
    }
  };

  public BlackListLayout(Context paramContext)
  {
    super(paramContext);
  }

  public BlackListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a()
  {
    Intent localIntent = MultiChooserActivity.c(true);
    localIntent.setFlags(268435456);
    localIntent.putExtra("extra.request_type", this.b);
    localIntent.putParcelableArrayListExtra("extra.request_existing_list", null);
    getContext().startActivity(localIntent);
    if (this.b == 3)
      afu.a();
  }

  private void b()
  {
    int i = getChooseSize();
    if (i == 0)
    {
      this.c.setText(2131231250);
      return;
    }
    String str = getResources().getQuantityString(2131558403, i, new Object[] { Integer.valueOf(i) });
    this.c.setText(str);
  }

  private int getChooseSize()
  {
    if (this.b == 3)
      return aft.f();
    return aly.a("key_memory_tip_black_list").b();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("ACTION_CHOOSE_POP_BLACK_LIST");
      ci.a(getContext()).a(this.d, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onClick(View paramView)
  {
    a();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    try
    {
      ci.a(getContext()).a(this.d);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((TextView)findViewById(2131755408));
    setOnClickListener(this);
  }

  public void setRequestType(int paramInt)
  {
    this.b = paramInt;
    b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.preference.BlackListLayout
 * JD-Core Version:    0.6.2
 */