package cmcm.com.myapplication.com.lazyswipe.ui.chooser;

import aao;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import anu;
import anv;
import app;
import aps;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.ui.RateView;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zf;

public class MultiSwitchersChooserPanel extends app
{
  private static Drawable p;
  List<aps> l;
  Collator m;
  Comparator<aps> n;
  private List<String> o;

  public MultiSwitchersChooserPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static Drawable a(Context paramContext)
  {
    if (p == null)
      p = zf.a(paramContext, SwipeApplication.c().getResources().getColor(2131689505));
    return p;
  }

  public void a()
  {
    super.a();
    this.m = Collator.getInstance();
    this.m.setDecomposition(1);
    this.m.setStrength(0);
    this.n = new Comparator()
    {
      public int a(aps paramAnonymousaps1, aps paramAnonymousaps2)
      {
        boolean bool = MultiSwitchersChooserPanel.a(MultiSwitchersChooserPanel.this).contains(paramAnonymousaps1.a.a());
        if (bool == MultiSwitchersChooserPanel.a(MultiSwitchersChooserPanel.this).contains(paramAnonymousaps2.a.a()))
          return MultiSwitchersChooserPanel.this.m.compare(paramAnonymousaps1.b, paramAnonymousaps2.b);
        if (bool)
          return -1;
        return 1;
      }
    };
    Object localObject = anu.a(getContext());
    this.l = new ArrayList(((Map)localObject).size());
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      anv localanv = (anv)((Iterator)localObject).next();
      this.l.add(new aps(localanv, localanv.b().toString()));
    }
    this.a = this.l.size();
    this.o = anu.a(getContext(), false);
    this.d = aao.b(getContext());
    this.e = Math.min(this.d, this.o.size());
    Collections.sort(this.l, this.n);
  }

  protected void a(FanItem paramFanItem)
  {
    super.a(paramFanItem);
    paramFanItem.setIconBackground(a(SwipeApplication.c()));
  }

  protected void a(FanItem paramFanItem, int paramInt)
  {
    aps localaps = (aps)this.l.get(paramInt);
    paramFanItem.setIcon(localaps.a.c());
    paramFanItem.setText(localaps.b);
    super.a(paramFanItem, paramInt);
  }

  protected void c()
  {
    super.c();
    int i = 0;
    while (i < this.e)
    {
      this.b[i] = true;
      this.c[i] = true;
      i += 1;
    }
  }

  protected boolean e()
  {
    boolean bool2 = true;
    boolean bool3 = anu.e(getContext());
    if (this.e <= 0)
    {
      anu.b(getContext(), "");
      bool1 = false;
      if (bool1 == bool3)
        break label325;
    }
    label325: for (boolean bool1 = bool2; ; bool1 = false)
    {
      RateView.g();
      anu.a();
      SwipeService.k();
      return bool1;
      Object localObject1 = anu.a(getContext(), false);
      Object localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      Object localObject3;
      if (i < this.a)
      {
        localObject3 = (aps)this.l.get(i);
        if ((this.b[i] == 0) && (this.c[i] != 0))
          localArrayList.add(((aps)localObject3).a.a());
        while (true)
        {
          i += 1;
          break;
          if ((this.b[i] != 0) && (this.c[i] == 0))
            ((List)localObject2).add(((aps)localObject3).a.a());
        }
      }
      if (((List)localObject2).contains("Calculator"))
        bool1 = true;
      while (true)
      {
        localObject3 = ((List)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
          if (localArrayList.contains((String)((Iterator)localObject3).next()))
            ((Iterator)localObject3).remove();
        if (localArrayList.contains("Calculator"))
          bool1 = false;
        else
          bool1 = bool3;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
        ((List)localObject1).add((String)((Iterator)localObject2).next());
      localObject1 = anu.a((List)localObject1);
      anu.b(getContext(), (String)localObject1);
      break;
    }
  }

  protected void l()
  {
    this.f.setText(getContext().getString(2131231109, new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.d) }));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.chooser.MultiSwitchersChooserPanel
 * JD-Core Version:    0.6.2
 */