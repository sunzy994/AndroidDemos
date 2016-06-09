package cmcm.com.myapplication.com.lazyswipe.features.allapps;

import acb;
import acc;
import acd;
import ace;
import acf;
import acg;
import ach;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqt;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.search.SearchWebActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vv;
import wk;
import wm;
import xq;

public class AppsContentView extends RelativeLayout
  implements OnClickListener, OnScrollListener
{
  private View a;
  private ListView b;
  private ListScrollDecoratorView c;
  private LinearLayout d;
  private View e;
  private TextView f;
  private ImageView g;
  private acf h;
  private acb i;
  private ArrayList<ach> j = null;
  private ArrayList<ach> k = null;
  private final ArrayList<ach> l = new ArrayList();
  private boolean m;
  private ace n = new ace(this, null);
  private ProgressDialog o;
  private final Handler p = new Handler();
  private xq q;
  private acd r;
  private boolean s;
  private int t = 0;
  private int u = -1;
  private int v = -1;
  private int w = -2147483648;
  private int x = 2147483647;

  public AppsContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setSoundEffectsEnabled(false);
  }

  private void a(int paramInt)
  {
    int i2 = 1;
    if (this.b.getChildCount() < 1);
    View localView1;
    do
    {
      return;
      localView1 = this.b.getChildAt(0);
      localObject = this.b.getChildAt(1);
    }
    while (!(localObject instanceof AppsListItem));
    int i1 = i2;
    if ((localView1 instanceof AppsListItem))
    {
      ((AppsListItem)localView1).b();
      i1 = i2;
    }
    while (i1 < paramInt)
    {
      View localView2 = this.b.getChildAt(i1);
      if ((localView2 instanceof AppsListItem))
        ((AppsListItem)localView2).c();
      i1 += 1;
    }
    Object localObject = (AppsListItem)localObject;
    if (!((AppsListItem)localObject).a())
    {
      b(0);
      return;
    }
    b(((AppsListItem)localObject).getRealTop() - localView1.getMeasuredHeight());
  }

  private void a(String paramString)
  {
    if (this.o != null)
    {
      aqt.a(this.o, getContext());
      this.o = null;
    }
    if (!SwipeApplication.c().a().b)
      this.o = aqt.a(getContext(), getContext().getString(2131230736), true, false);
    if ((ace.a(this.n)) || (this.n.getStatus() == Status.FINISHED))
    {
      this.n = new ace(this, null);
      this.n.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] { paramString, null, null });
      return;
    }
    if (this.n.getStatus() == Status.PENDING)
    {
      this.n.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] { paramString, null, null });
      return;
    }
    if (this.n.getStatus() == Status.RUNNING)
    {
      this.n.a();
      this.n = new ace(this, null);
      this.n.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] { paramString, null, null });
      return;
    }
    this.n = new ace(this, null);
    this.n.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] { paramString, null, null });
  }

  private void a(List<ach> paramList)
  {
    this.l.clear();
    if (paramList == getCachedResult())
      this.l.addAll(getCachedHistory());
    getCachedResult();
    this.l.addAll(paramList);
    this.h.a();
    this.c.a();
    this.i.a();
    paramList = this.d;
    if (this.l.isEmpty());
    for (int i1 = 8; ; i1 = 0)
    {
      paramList.setVisibility(i1);
      this.u = -1;
      this.v = -1;
      this.w = -2147483648;
      this.x = 2147483647;
      return;
    }
  }

  private boolean a(ComponentName paramComponentName)
  {
    return ("com.lazyswipe".equals(paramComponentName.getPackageName())) && (AllAppsActivity.class.getName().equals(paramComponentName.getClassName()));
  }

  private acg b()
  {
    return new acc(this, getContext(), this.l);
  }

  private void b(int paramInt)
  {
    if (this.d.getTop() != paramInt)
      this.d.layout(0, paramInt, this.d.getMeasuredWidth(), this.d.getMeasuredHeight() + paramInt);
  }

  private void c()
  {
    if ((this.w >= 0) && (this.w < this.h.b().length))
    {
      if (this.w == 0)
      {
        this.f.setVisibility(4);
        this.g.setImageDrawable(getContext().getResources().getDrawable(2130837507));
        this.g.setVisibility(0);
        return;
      }
      this.f.setText(this.h.b()[this.w]);
      this.f.setVisibility(0);
      this.g.setVisibility(4);
      return;
    }
    this.f.setText("");
  }

  private List<ach> getCachedHistory()
  {
    if (this.k != null)
      return this.k;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = SwipeApplication.c().a().b(8).iterator();
    while (localIterator.hasNext())
    {
      wk localwk = (wk)localIterator.next();
      if ((localwk != null) && (!a(localwk.i)))
        localArrayList.add(new ach(localwk, localwk.b, true));
    }
    this.k = localArrayList;
    return this.k;
  }

  private List<ach> getCachedResult()
  {
    if (this.j != null)
      return this.j;
    this.j = new ArrayList();
    Object localObject1 = SwipeApplication.c().a();
    int i1;
    if (!((wm)localObject1).b)
      i1 = 0;
    while (true)
    {
      Object localObject2;
      if ((i1 >= 60) || (((wm)localObject1).b))
      {
        localObject1 = ((wm)localObject1).a();
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
          if (a(((wk)((Iterator)localObject2).next()).i))
            ((Iterator)localObject2).remove();
      }
      try
      {
        Thread.sleep(500L);
        label105: i1 += 1;
        continue;
        Collections.sort((List)localObject1, wk.p);
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (wk)((Iterator)localObject1).next();
          this.j.add(new ach((wk)localObject2, ((wk)localObject2).b, false));
        }
        return this.j;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label105;
      }
    }
  }

  public void a()
  {
    if (!this.m)
    {
      this.m = true;
      a("");
    }
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.q = xq.a(getContext());
  }

  public void onClick(View paramView)
  {
    if (paramView == this.e)
      SearchWebActivity.a(getContext(), "", 4);
    do
    {
      do
        return;
      while (paramView == this.a);
      paramView = (ach)paramView.getTag();
      if (paramView != null)
        break;
    }
    while (this.r == null);
    this.r.a();
    return;
    HashMap localHashMap;
    if (paramView.a.a(getContext()) != null)
    {
      localHashMap = new HashMap(2);
      if (!this.s)
        break label141;
    }
    label141: for (paramView = "1"; ; paramView = "0")
    {
      localHashMap.put("shortcut", paramView);
      vv.a().a("AllApps App click", localHashMap);
      this.k = null;
      if (this.r != null)
        this.r.b();
      a("");
      return;
    }
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    xq.a(this.q);
    this.q = null;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(2131755062);
    this.b = ((ListView)findViewById(2131755092));
    this.c = ((ListScrollDecoratorView)findViewById(2131755089));
    this.h = new acf(getContext(), b());
    this.c.a(this.b, this.h);
    this.i = new acb(this, null);
    this.b.setAdapter(this.i);
    this.b.setOnScrollListener(this);
    this.d = ((LinearLayout)findViewById(2131755088));
    this.f = ((TextView)this.d.findViewById(2131755091));
    this.g = ((ImageView)this.d.findViewById(2131755090));
    this.a.setOnClickListener(this);
    this.e = findViewById(2131755087);
    this.e.setOnClickListener(this);
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0);
    do
    {
      return;
      a(paramInt2);
      paramInt3 = paramInt1 + paramInt2 - 1;
      if ((this.w == -2147483648) || (this.x == 2147483647))
      {
        this.u = paramInt1;
        this.v = paramInt3;
        paramInt2 = this.h.b(paramInt1);
        paramInt3 = this.h.b(paramInt3);
        paramInt1 = paramInt2;
        while (paramInt1 <= paramInt3)
        {
          this.c.a(paramInt1);
          paramInt1 += 1;
        }
        this.w = paramInt2;
        this.x = paramInt3;
        c();
        return;
      }
      if (paramInt1 != this.u)
      {
        this.u = paramInt1;
        paramInt2 = this.h.b(paramInt1);
        if (paramInt2 < this.w)
        {
          paramInt1 = paramInt2;
          while (paramInt1 < this.w)
          {
            this.c.a(paramInt1);
            paramInt1 += 1;
          }
        }
        if (paramInt2 > this.w)
        {
          paramInt1 = this.w;
          while (paramInt1 < paramInt2)
          {
            this.c.b(paramInt1);
            paramInt1 += 1;
          }
        }
        if (paramInt2 != this.w)
        {
          this.w = paramInt2;
          c();
        }
      }
    }
    while (paramInt3 == this.v);
    this.v = paramInt3;
    paramInt2 = this.h.b(paramInt3);
    if (paramInt2 > this.x)
    {
      paramInt1 = Math.max(this.x + 1, this.w);
      while (paramInt1 <= paramInt2)
      {
        this.c.a(paramInt1);
        paramInt1 += 1;
      }
    }
    if (paramInt2 < this.x)
    {
      paramInt1 = paramInt2 + 1;
      while (paramInt1 <= this.x)
      {
        this.c.b(paramInt1);
        paramInt1 += 1;
      }
    }
    this.x = paramInt2;
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != this.t)
    {
      this.t = paramInt;
      if (paramInt != 2)
        break label33;
      if (this.q != null)
        this.q.a();
    }
    label33: boolean bool;
    do
    {
      do
        return;
      while ((paramInt != 0) || (this.q == null));
      bool = this.q.c();
      this.q.b();
    }
    while (!bool);
    this.i.notifyDataSetChanged();
  }

  public void setCallback(acd paramacd)
  {
    this.r = paramacd;
  }

  public void setLaunchedFromShortcut(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.allapps.AppsContentView
 * JD-Core Version:    0.6.2
 */