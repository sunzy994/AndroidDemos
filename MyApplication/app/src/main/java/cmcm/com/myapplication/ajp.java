package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lazyswipe.fan.notification.NotificationView;
import com.lazyswipe.features.upgrade.UpgradeTipBody;
import com.lazyswipe.ui.MainActivity;

public class ajp extends BaseAdapter
  implements OnClickListener, atd, zz
{
  private final ajo a;
  private final ajl b;
  private final NotificationView c;
  private final Context d;

  public ajp(ajo paramajo, NotificationView paramNotificationView)
  {
    this.a = paramajo;
    this.b = paramajo.s();
    this.c = paramNotificationView;
    this.d = paramNotificationView.getContext();
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ajo.a(this.a, paramBoolean1);
      this.c.c = paramBoolean2;
      this.c.c();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private View c()
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.d).inflate(2130968715, null);
    ((TextView)localViewGroup.findViewById(2131755387)).setText(this.b.d());
    localViewGroup.findViewById(2131755389).setOnClickListener(this);
    return localViewGroup;
  }

  private View d()
  {
    UpgradeTipBody localUpgradeTipBody = (UpgradeTipBody)LayoutInflater.from(this.d).inflate(2130968716, null);
    localUpgradeTipBody.a(this.b, this);
    return localUpgradeTipBody;
  }

  public void a()
  {
  }

  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 4:
    case 6:
    default:
      Log.e(ajo.t(), "Error no is :" + paramInt);
      paramInt = 2131230917;
    case 2:
    case 3:
    case 1:
    case 5:
    case 7:
    }
    while (true)
    {
      aso.a(this.d, paramInt);
      return;
      paramInt = 2131230918;
      continue;
      paramInt = 2131230921;
      continue;
      paramInt = 2131230922;
    }
  }

  public void a_(int paramInt)
  {
  }

  public void b()
  {
    asq.a(this.d, this.b.b());
    a(false, true);
  }

  public int getCount()
  {
    if (this.b == null)
      return 0;
    return 1;
  }

  public Object getItem(int paramInt)
  {
    return this.a;
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.b == null)
      return null;
    if (atw.a(this.b.i()))
      return d();
    return c();
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131755390:
    case 2131755392:
    case 2131755393:
    default:
      return;
    case 2131755389:
      if (!vs.H(this.d))
        MainActivity.a(3, false);
      a(false, false);
      paramView = ajm.a(this.d, MainActivity.class);
      ajm.a(this.d, this.b, paramView, this, null);
      return;
    case 2131755394:
      a(false, false);
      return;
    case 2131755391:
    }
    a(true, false);
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
  }

  public void r_()
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajp
 * JD-Core Version:    0.6.2
 */