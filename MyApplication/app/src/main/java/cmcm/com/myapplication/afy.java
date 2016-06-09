package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class afy
  implements att
{
  final Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
      case 0:
      case 1:
      case 2:
      }
      while (true)
      {
        super.handleMessage(paramAnonymousMessage);
        return;
        afy.a(afy.this).h();
        afy.b(afy.this).setVisibility(0);
        afy.c(afy.this).setVisibility(0);
        Object localObject1 = (agg)paramAnonymousMessage.obj;
        afy.d(afy.this).clear();
        afy.d(afy.this).addAll(((agg)localObject1).b);
        afy.a(afy.this, new agd[afy.d(afy.this).size()]);
        afy.e(afy.this).notifyDataSetChanged();
        localObject1 = afy.f(afy.this).a(new aga(afy.this, -1, ((agg)localObject1).a));
        if (localObject1 != null)
        {
          afy.g(afy.this).setImageBitmap(((atr)localObject1).e);
          afy.g(afy.this).setScaleType(ScaleType.CENTER_CROP);
        }
        else
        {
          afy.g(afy.this).setImageDrawable(new ColorDrawable(-14307871));
          afy.g(afy.this).setScaleType(ScaleType.CENTER_INSIDE);
          continue;
          localObject1 = (aga)paramAnonymousMessage.obj;
          if (atw.b(((aga) localObject1).e))
            if (aga.a((aga) localObject1) == -1)
            {
              afy.g(afy.this).setImageBitmap(((aga)localObject1).e);
              afy.g(afy.this).setScaleType(ScaleType.CENTER_CROP);
            }
            else
            {
              Object localObject2 = afy.h(afy.this).findViewById(aga.a((aga) localObject1));
              if (localObject2 != null)
              {
                localObject2 = (age)((View)localObject2).getTag();
                ((age)localObject2).a.setImageBitmap(((aga)localObject1).e);
                ((age)localObject2).a.setScaleType(ScaleType.CENTER_CROP);
              }
              afy.i(afy.this)[aga.a(localObject1)].b = ((aga)localObject1).e;
              afy.i(afy.this)[aga.a(localObject1)].a = aga.a((aga) localObject1);
              continue;
              afy.a(afy.this).i();
            }
        }
      }
    }
  };
  private final atq b;
  private Bitmap c;
  private agb d;
  private final Context e;
  private final afz f;
  private final List<agh> g = new ArrayList();
  private final ListView h;
  private final ImageView i;
  private final TextView j;
  private final TextView k;
  private final TextView l;
  private final int m;
  private agd[] n = null;

  public afy(Context paramContext, View paramView)
  {
    this.e = paramContext;
    this.b = atq.a(paramContext, agf.a, this);
    this.h = ((ListView)paramView.findViewById(2131755305));
    this.i = ((ImageView)paramView.findViewById(2131755300));
    this.j = ((TextView)paramView.findViewById(2131755304));
    this.k = ((TextView)paramView.findViewById(2131755301));
    this.l = ((TextView)paramView.findViewById(2131755302));
    paramContext = new LinearLayout(this.e);
    this.m = asq.a(146.33F);
    paramView = new LayoutParams(-1, this.m);
    paramContext.setBackgroundColor(0);
    paramContext.setVisibility(4);
    paramContext.setLayoutParams(paramView);
    this.h.addHeaderView(paramContext);
    this.f = new afz(this, null);
    this.h.setAdapter(this.f);
    this.h.setOnScrollListener(new agc(this, null));
  }

  private int a(AbsListView paramAbsListView)
  {
    View localView = paramAbsListView.getChildAt(0);
    if (localView == null)
      return 0;
    int i1 = paramAbsListView.getFirstVisiblePosition();
    int i2 = localView.getTop();
    if (i1 < 1)
      return -i2;
    return this.m;
  }

  private Bitmap a(Context paramContext)
  {
    if (this.c == null)
      this.c = atw.b(paramContext, asq.a(63.0F));
    return this.c;
  }

  private void a(int paramInt, View paramView)
  {
    if ((paramInt < 0) || (paramInt > this.g.size()))
      return;
    Object localObject = new aga(this, paramInt, ((agh)this.g.get(paramInt)).f);
    localObject = this.b.a((atr)localObject);
    paramView = (age)paramView.getTag();
    if (localObject != null)
    {
      this.n[paramInt].a = paramInt;
      this.n[paramInt].b = ((atr)localObject).e;
      paramView.a.setImageBitmap(((atr)localObject).e);
      paramView.a.setScaleType(ScaleType.CENTER_CROP);
      return;
    }
    paramView.a.setImageBitmap(a(this.e));
    paramView.a.setScaleType(ScaleType.CENTER_INSIDE);
  }

  private void d()
  {
    agg localagg = agg.a(this.e);
    if ((localagg == null) || (localagg.b.size() <= 0))
    {
      this.a.sendEmptyMessage(2);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = localagg;
    this.a.sendMessage(localMessage);
  }

  public void a()
  {
    this.d.g();
    if (!arl.i(this.e))
    {
      d();
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        agg localagg = agg.b(afy.j(afy.this));
        if ((localagg == null) || (localagg.b.size() <= 0))
        {
          afy.k(afy.this);
          return;
        }
        Message localMessage = new Message();
        localMessage.what = 0;
        localMessage.obj = localagg;
        afy.this.a.sendMessage(localMessage);
        agg.a(afy.j(afy.this), localagg);
      }
    }).start();
  }

  public void a(agb paramagb)
  {
    this.d = paramagb;
  }

  public void a(atr paramatr)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = paramatr;
    this.a.sendMessage(localMessage);
  }

  public void b()
  {
    if (this.b != null)
      atq.a(this.b);
    atw.a(this.c);
    this.c = null;
  }

  public void b(atr paramatr)
  {
  }

  public void c()
  {
    this.f.notifyDataSetChanged();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afy
 * JD-Core Version:    0.6.2
 */