package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lazyswipe.fan.notification.NotificationView;

public class zb extends BaseAdapter
  implements abp, OnClickListener, zz
{
  private final za a;
  private final Context b;
  private int c;
  private ImageView d;
  private final NotificationView e;
  private View f;
  private final abu g;

  public zb(Context paramContext, za paramza, NotificationView paramNotificationView)
  {
    this.b = paramContext;
    this.a = paramza;
    this.c = 0;
    this.e = paramNotificationView;
    this.g = new abu(paramContext);
    this.f = f();
    abd.j.b(this);
  }

  private View a(abt paramabt)
  {
    if (paramabt == null)
      return null;
    paramabt = paramabt.j();
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.b);
    if (paramabt != null)
      if (!atw.b(paramabt))
        this.f = localLayoutInflater.inflate(2130968713, this.e, false);
    while (true)
    {
      if (this.f.getLayoutParams() == null)
        this.f.setLayoutParams(new LayoutParams(-1, -1));
      this.g.a(this.f);
      this.g.h.setBackgroundDrawable(auh.a(Color.parseColor("#2aa2f5"), asq.a(2.0F)));
      return this.f;
      this.f = localLayoutInflater.inflate(2130968712, this.e, false);
      continue;
      this.f = localLayoutInflater.inflate(2130968711, this.e, false);
    }
  }

  private View e()
  {
    if (this.d == null)
    {
      zc localzc = new zc(this.b);
      this.d = new ImageView(this.b);
      this.d.setImageDrawable(localzc);
    }
    while (true)
    {
      ((zc)this.d.getDrawable()).a();
      return this.d;
      if (this.d.getParent() != null)
        ((ViewGroup)this.d.getParent()).removeView(this.d);
    }
  }

  private View f()
  {
    if (this.f != null)
      return this.f;
    return a(abd.j.l());
  }

  private View g()
  {
    TextView localTextView = new TextView(this.b);
    localTextView.setGravity(17);
    localTextView.setTextColor(-2130706433);
    int i = asq.a(24.0F);
    localTextView.setPadding(i, i, i, i);
    localTextView.setText(2131231237);
    return localTextView;
  }

  public void a()
  {
  }

  public void a(abq paramabq)
  {
    this.e.c = true;
    this.e.setShrinkToIconPoint(false);
    this.e.c();
  }

  public void a(abq paramabq, boolean paramBoolean)
  {
    this.c = 1;
    notifyDataSetChanged();
  }

  public void a(abq paramabq, boolean paramBoolean, int paramInt, String paramString)
  {
    this.c = 2;
    notifyDataSetChanged();
  }

  public void a_(int paramInt)
  {
    this.e.c();
  }

  public View b(abq paramabq)
  {
    return f();
  }

  public boolean b()
  {
    return this.c == 0;
  }

  public void c(abq paramabq)
  {
    this.f.findViewById(2131755262).setOnClickListener(this);
  }

  public void d()
  {
    abd.j.a(null);
    abd.j.e();
    this.g.a();
  }

  public abg getAdViewHolder()
  {
    return this.g;
  }

  public int getCount()
  {
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
    switch (this.c)
    {
    default:
    case 0:
    case 1:
    }
    do
    {
      return g();
      return e();
      paramView = f();
    }
    while (paramView == null);
    return paramView;
  }

  public boolean i_()
  {
    return false;
  }

  public void onClick(View paramView)
  {
    this.c = 0;
    this.f = null;
    notifyDataSetChanged();
    abd.j.d();
    abd.a(this.b, false);
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zb
 * JD-Core Version:    0.6.2
 */