package cmcm.com.myapplication.com.lazyswipe.ui.chooser;

import aaj;
import aal;
import aao;
import afs;
import aft;
import aly;
import amu;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import anu;
import apd;
import apl;
import apm;
import app;
import apr;
import aso;
import asp;
import asq;
import ci;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.features.allapps.AllAppsActivity;
import com.lazyswipe.ui.RateView;
import com.lazyswipe.widget.HorizontalGridList;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vs;
import vv;
import wk;
import wm;
import wn;
import xg;
import xo;
import xq;
import yb;

public class MultiAppsChooserPanel extends app
{
  private List<? extends Object> l;
  private boolean m;
  private int n;
  private List<? extends Object> o = Collections.emptyList();
  private final List<String> p = new ArrayList();
  private Map<String, CharSequence> q;
  private final Handler r = new Handler();
  private xq s;
  private boolean t;
  private final Comparator<wk> u = new Comparator()
  {
    public int a(wk paramAnonymouswk1, wk paramAnonymouswk2)
    {
      int i = -1;
      boolean bool = MultiAppsChooserPanel.b(MultiAppsChooserPanel.this).contains(paramAnonymouswk1.i);
      if (bool == MultiAppsChooserPanel.b(MultiAppsChooserPanel.this).contains(paramAnonymouswk2.i))
        if (bool)
          i = asq.a.compare(paramAnonymouswk1.b, paramAnonymouswk2.b);
      while (bool)
      {
        do
        {
          return i;
          bool = paramAnonymouswk1.l;
          if (bool == paramAnonymouswk2.l)
          {
            if (bool)
              return paramAnonymouswk1.m - paramAnonymouswk2.m;
            return asq.a.compare(paramAnonymouswk1.b, paramAnonymouswk2.b);
          }
        }
        while (bool);
        return 1;
      }
      return 1;
    }
  };

  public MultiAppsChooserPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(List<? extends Object> paramList)
  {
    List localList = this.l;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localList.remove((String)localIterator.next());
    localList = this.o;
    if (!this.o.isEmpty())
    {
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localList.remove(str))
          this.p.add(str);
      }
    }
    paramList.clear();
  }

  private void a(List<wk> paramList, String paramString)
  {
    Object localObject = new ArrayList();
    paramString = new ArrayList();
    int i = 0;
    if (i < this.a)
    {
      wk localwk = (wk)paramList.get(i);
      if ((this.b[i] == 0) && (this.c[i] != 0))
        paramString.add(localwk);
      while (true)
      {
        i += 1;
        break;
        if ((this.b[i] != 0) && (this.c[i] == 0))
          ((List)localObject).add(localwk);
      }
    }
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext())
    {
      localObject = (wk)paramList.next();
      try
      {
        ((wk)localObject).o = 10;
        wn.e(getContext(), (wk)localObject);
      }
      catch (Throwable localThrowable)
      {
      }
    }
    paramList = paramString.iterator();
    while (paramList.hasNext())
    {
      paramString = (wk)paramList.next();
      try
      {
        paramString.o = 0;
        wn.e(getContext(), paramString);
      }
      catch (Throwable paramString)
      {
      }
    }
    vs.b(getContext(), "ever_change_custom_tab", true);
  }

  private void a(wm paramwm)
  {
    switch (this.n)
    {
    default:
      this.l = paramwm.a();
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return;
      this.l = paramwm.c();
      return;
      this.l = paramwm.b();
      paramwm = getContext().getPackageManager();
      this.q = new HashMap(this.l.size());
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          ApplicationInfo localApplicationInfo = paramwm.getApplicationInfo(str, 0);
          this.q.put(str, localApplicationInfo.loadLabel(paramwm));
        }
        catch (NameNotFoundException localNameNotFoundException)
        {
        }
      }
    }
  }

  private void a(wm paramwm, List<ComponentName> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      wk localwk = paramwm.a((ComponentName)localIterator.next());
      if (localwk != null)
        this.l.remove(localwk);
    }
    paramList.clear();
  }

  private void b(List<? extends Object> paramList)
  {
    List localList = this.l;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localList.remove((String)localIterator.next());
    paramList.clear();
  }

  private void b(wm paramwm)
  {
    Object localObject2 = getIntent();
    this.j = ((PendingIntent)((Intent)localObject2).getParcelableExtra("extra.ok_action"));
    this.k = ((PendingIntent)((Intent)localObject2).getParcelableExtra("extra.cancel_action"));
    Object localObject1 = this.l;
    if (this.n == 0)
    {
      this.d = -1;
      paramwm = vs.d();
      if ((paramwm != null) && (paramwm.size() > 0))
      {
        localObject2 = paramwm.iterator();
        while (((Iterator)localObject2).hasNext())
          wk.a((Iterable)localObject1, (String)((Iterator)localObject2).next());
        paramwm.clear();
      }
      paramwm = vs.e();
      if ((paramwm != null) && (paramwm.size() > 0))
      {
        localObject2 = paramwm.iterator();
        while (((Iterator)localObject2).hasNext())
          wk.a((Iterable)localObject1, (String)((Iterator)localObject2).next());
        paramwm.clear();
      }
    }
    do
    {
      return;
      if ((3 != this.n) && (4 != this.n))
        break;
      this.d = -1;
      paramwm = asq.e(getContext());
      paramwm.add("com.lazyswipe");
      paramwm.add("com.lazyswipe.pro2");
    }
    while (paramwm == null);
    this.l.removeAll(paramwm);
    return;
    this.d = ((Intent)localObject2).getIntExtra("extra.request_max_count", -1);
    this.m = ((Intent)localObject2).getBooleanExtra("extra.request_exclude_existings", false);
    if (2 == this.n)
    {
      localObject1 = ((Intent)localObject2).getStringArrayExtra("extra.request_existing_list");
      if ((localObject1 != null) && (localObject1.length > 0))
        this.o = new ArrayList(Arrays.asList((Object[])localObject1));
      if (this.o == null)
        break label486;
      if (this.m)
      {
        this.d -= this.o.size();
        a(paramwm, this.o);
      }
    }
    while (true)
    {
      if (2 == this.n)
      {
        paramwm = ((Intent)localObject2).getStringArrayListExtra("extra.request_exclude_list");
        if (paramwm != null)
          b(paramwm);
        paramwm = ((Intent)localObject2).getStringArrayListExtra("extra.request_invisible_list");
        if (paramwm != null)
          a(paramwm);
      }
      if ((1 == this.n) && (anu.e(getContext())))
      {
        paramwm = amu.f(getContext());
        if (paramwm != null)
        {
          paramwm = paramwm.getComponent();
          if (paramwm != null)
          {
            paramwm = paramwm.getPackageName();
            localObject1 = this.l.iterator();
            while (((Iterator)localObject1).hasNext())
              if (paramwm.equals(((wk)((Iterator)localObject1).next()).i.getPackageName()))
                ((Iterator)localObject1).remove();
          }
        }
      }
      this.e = this.o.size();
      return;
      this.o = ((Intent)localObject2).getParcelableArrayListExtra("extra.request_existing_list");
      break;
      label486: this.o = Collections.emptyList();
    }
  }

  private void c(List<wk> paramList)
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < this.a)
    {
      wk localwk = (wk)paramList.get(i);
      if ((this.b[i] == 0) && (this.c[i] != 0))
      {
        localwk.f = 0;
        localArrayList.add(localwk);
        if (localStringBuilder.length() > 0)
          localStringBuilder.append(",");
        localStringBuilder.append(localwk.a);
      }
      while (true)
      {
        i += 1;
        break;
        if ((this.b[i] != 0) && (!localwk.a()))
        {
          localwk.f = 2147483547;
          ((List)localObject1).add(localwk);
          if (((StringBuilder)localObject2).length() > 0)
            ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(localwk.a);
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      ((StringBuilder)localObject2).insert(0, "(");
      ((StringBuilder)localObject2).append(")");
    }
    if (localArrayList.size() > 0)
    {
      localStringBuilder.insert(0, "(");
      localStringBuilder.append(")");
    }
    if (((StringBuilder)localObject2).length() > 0)
    {
      paramList = new ContentValues(1);
      paramList.put("called_num", Integer.valueOf(2147483547));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    try
    {
      getContext().getContentResolver().update(xg.a, paramList, "_id IN " + (String)localObject2, null);
      paramList = ((List)localObject1).iterator();
      while (paramList.hasNext())
      {
        localObject1 = (wk)paramList.next();
        if (AllAppsActivity.class.getName().equals(((wk)localObject1).i.getClassName()))
          vv.a().a("AllApps added");
      }
      if (localStringBuilder.length() > 0)
      {
        paramList = new ContentValues(1);
        paramList.put("called_num", Integer.valueOf(0));
      }
    }
    catch (Throwable paramList)
    {
      try
      {
        getContext().getContentResolver().update(xg.a, paramList, "_id IN " + localStringBuilder.toString(), null);
        label444: afs.a();
        return;
        paramList = paramList;
        asp.a("Swipe.MultiChooserPanel", "Failed to update called count for apps " + (String)localObject2, paramList);
      }
      catch (Throwable paramList)
      {
        break label444;
      }
    }
  }

  private void m()
  {
    if (this.h != null)
      this.h.i();
  }

  public void a()
  {
    super.a();
    wm localwm = SwipeApplication.c().a();
    if (!localwm.b)
      m();
    do
    {
      return;
      this.n = getIntent().getIntExtra("extra.request_type", -1);
      a(localwm);
      if ((this.l == null) || (this.l.size() <= 0))
      {
        m();
        return;
      }
      b(localwm);
      this.a = this.l.size();
    }
    while (this.a > 0);
    m();
  }

  protected void a(final FanItem paramFanItem, int paramInt)
  {
    if (paramInt >= this.l.size())
      return;
    Object localObject2;
    Object localObject1;
    if ((2 != this.n) && (3 != this.n) && (4 != this.n))
    {
      localObject2 = (wk)this.l.get(paramInt);
      localObject1 = ((wk)localObject2).i;
      paramFanItem.setText(((wk)localObject2).b);
      if (this.s != null)
      {
        localObject1 = this.s.a(new xo()
        {
          public void a()
          {
            if (this.a != null)
              MultiAppsChooserPanel.a(MultiAppsChooserPanel.this).post(new Runnable()
              {
                public void run()
                {
                  MultiAppsChooserPanel.1.this.b.setIcon(MultiAppsChooserPanel.1.this.a);
                }
              });
          }

          public ComponentName b()
          {
            return this.c;
          }
        });
        if (localObject1 == null)
          break label158;
        paramFanItem.setIcon(((xo)localObject1).a);
      }
    }
    while (true)
    {
      super.a(paramFanItem, paramInt);
      return;
      localObject2 = (String)this.l.get(paramInt);
      localObject1 = asq.h(getContext(), (String)localObject2);
      paramFanItem.setText((CharSequence)this.q.get(localObject2));
      break;
      label158: paramFanItem.setIcon(new apd(this.s.e()));
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean != this.t)
    {
      this.t = paramBoolean;
      if (!paramBoolean)
        break label51;
      if (this.s != null)
      {
        paramBoolean = this.s.c();
        this.s.b();
        if (paramBoolean)
          this.g.a();
      }
    }
    label51: 
    while (this.s == null)
      return;
    this.s.a();
  }

  public void b()
  {
    try
    {
      super.b();
      if (this.l != null)
        this.l.clear();
      if (this.q != null)
        this.q.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        Log.w("Swipe.MultiChooserPanel", "onDestroy failed: " + localThrowable.getMessage());
    }
  }

  protected void c()
  {
    super.c();
    this.e = 0;
    List localList = this.l;
    Object localObject;
    if (this.n == 0)
    {
      localObject = vs.O(getContext());
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        Collections.sort(localList, new apl((List)localObject));
        i = Math.min(((List)localObject).size(), localList.size()) - 1;
        if (i >= 0)
        {
          if (!((List)localObject).contains(((wk)localList.get(i)).i.getPackageName()))
            break label142;
          this.e = (i + 1);
        }
      }
    }
    label142: label287: 
    while (true)
    {
      if (this.e > 0)
      {
        Arrays.fill(this.b, 0, this.e, true);
        Arrays.fill(this.c, 0, this.e, true);
      }
      return;
      i -= 1;
      break;
      if ((3 != this.n) && (4 != this.n))
        break label289;
      if (3 == this.n)
      {
        localObject = aft.a();
        label177: localObject = new ArrayList((Collection)localObject);
        Collections.sort(this.l, new apm((List)localObject, this.q));
        if ((localObject != null) && (((List)localObject).size() > 0))
          i = Math.min(((List)localObject).size(), localList.size()) - 1;
      }
      else
      {
        while (true)
        {
          if (i < 0)
            break label287;
          if (((List)localObject).contains(this.l.get(i)))
          {
            this.e = (i + 1);
            break;
            localObject = aly.a("key_memory_tip_black_list").a();
            break label177;
          }
          i -= 1;
        }
      }
    }
    label289: if (2 == this.n)
    {
      Collections.sort(this.l, new apm(this.o, this.q));
      label319: if ((this.m) || (this.o == null))
        break label419;
      if (this.n == 2)
        break label428;
      i = Math.min(this.o.size(), localList.size()) - 1;
    }
    while (true)
    {
      if (i >= 0)
      {
        if (this.o.contains(((wk)localList.get(i)).i))
          this.e = (i + 1);
      }
      else
      {
        this.o.clear();
        break;
        Collections.sort(localList, this.u);
        break label319;
        label419: break;
      }
      i -= 1;
    }
    label428: int i = Math.min(this.o.size(), localList.size()) - 1;
    while (true)
    {
      if (i >= 0)
      {
        if (this.o.contains(this.l.get(i)))
          this.e = (i + 1);
      }
      else
      {
        this.o = null;
        break;
      }
      i -= 1;
    }
  }

  protected void d()
  {
    super.d();
    if (2 == this.n)
      a(2131231107);
    while (true)
    {
      if (this.d > 0)
        l();
      return;
      if (3 == this.n)
        a(2131231008);
      else if (4 == this.n)
        a(2131230966);
    }
  }

  protected boolean e()
  {
    int i = 0;
    int j = 0;
    Object localObject1 = this.l;
    Object localObject2;
    if (this.n == 0)
    {
      localObject2 = new StringBuilder();
      i = 0;
      if (j < this.a)
      {
        if (this.b[j] == 0)
          break label489;
        i += 1;
        ((StringBuilder)localObject2).append(((wk)((List)localObject1).get(j)).i.getPackageName()).append(',');
      }
    }
    label482: label489: 
    while (true)
    {
      j += 1;
      break;
      localObject1 = ((StringBuilder)localObject2).toString();
      vs.i(getContext(), (String)localObject1);
      aso.a(getContext(), 2131231061);
      while (true)
      {
        return super.e();
        if (1 != this.n)
          break;
        RateView.g();
        if (yb.getInstance() != null)
        {
          localObject2 = yb.getInstance().getCurrentTab();
          if ((localObject2 instanceof aal))
            c((List)localObject1);
          else if ((localObject2 instanceof aaj))
            a((List)localObject1, ((aao)localObject2).b());
        }
      }
      int k;
      if (2 == this.n)
      {
        if (this.e <= 0)
          break label482;
        localObject1 = new StringBuilder();
        localObject2 = this.p.iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(',');
          i += 1;
        }
        k = 0;
        j = i;
        i = k;
        while (i < this.a)
        {
          k = j;
          if (this.b[i] != 0)
          {
            ((StringBuilder)localObject1).append(this.l.get(i)).append(',');
            k = j + 1;
          }
          i += 1;
          j = k;
        }
        i = ((StringBuilder)localObject1).length();
        if (i <= 0)
          break label482;
      }
      for (localObject1 = ((StringBuilder)localObject1).substring(0, i - 1); ; localObject1 = "")
      {
        vs.d(getContext(), (String)localObject1);
        aso.a(getContext(), 2131231061);
        break;
        if ((3 != this.n) && (4 != this.n))
          break;
        localObject1 = new ArrayList();
        for (j = 0; i < this.a; j = k)
        {
          k = j;
          if (this.b[i] != 0)
          {
            ((List)localObject1).add((String)this.l.get(i));
            k = j + 1;
          }
          i += 1;
        }
        if (3 == this.n)
          aft.a((Collection)localObject1);
        while (true)
        {
          ci.a(getContext()).a(new Intent("ACTION_CHOOSE_POP_BLACK_LIST"));
          break;
          aly.a("key_memory_tip_black_list").a((Collection)localObject1);
        }
      }
    }
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.s = xq.a(getContext());
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    xq.a(this.s);
    this.s = null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.chooser.MultiAppsChooserPanel
 * JD-Core Version:    0.6.2
 */