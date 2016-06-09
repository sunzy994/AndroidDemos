package cmcm.com.myapplication.com.lazyswipe.features.leap.card;

import adp;
import adq;
import adr;
import ads;
import adu;
import adv;
import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.MotionEvent;
import aro;
import asq;
import atq;
import atr;
import att;
import atw;
import azb;
import com.lazyswipe.widget.recyclerview.LinearLayoutManager;
import com.lazyswipe.widget.recyclerview.RecyclerView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import vw;
import vy;

public class CardFlow extends RecyclerView
  implements att
{
  public static final String a = "Swipe." + CardFlow.class.getSimpleName();
  private List<Object> j = new ArrayList();
  private adq k;
  private LinearLayoutManager l;
  private atq m;
  private int n;
  private Runnable o = new Runnable()
  {
    public void run()
    {
      int j = CardFlow.this.getChildCount();
      int i = 0;
      while (i < j)
      {
        if ((CardFlow.this.getChildAt(i) instanceof adp))
          ((adp)CardFlow.this.getChildAt(i)).e();
        i += 1;
      }
    }
  };
  private int p;
  private int q;
  private azb r = new azb()
  {
    public void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      if (paramAnonymousInt != 0)
        CardFlow.this.removeCallbacks(CardFlow.d(CardFlow.this));
      while (CardFlow.e(CardFlow.this))
        return;
      CardFlow.this.postDelayed(CardFlow.d(CardFlow.this), 17L);
    }

    public void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
    }
  };

  public CardFlow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new File(aro.c(), "feed").getAbsolutePath();
    this.m = atq.a(getContext(), paramContext, this);
    this.k = new adq(this, null);
    setAdapter(this.k);
    setOverScrollMode(2);
    setItemViewCacheSize(1);
    this.l = new adu(getContext(), 0, false);
    setLayoutManager(this.l);
    a(new ads(this, null));
    setOnScrollListener(this.r);
  }

  private void u()
  {
    if (this.m != null)
    {
      atq.a(this.m);
      this.m = null;
    }
  }

  private boolean v()
  {
    int i = this.l.g();
    if ((i != this.j.size() - 1) || (this.q == i))
      return false;
    this.q = i;
    c();
    vy.b(getContext(), "B36", this.p);
    vw.a(getContext(), "B36", "value", this.p);
    return true;
  }

  public void a()
  {
    this.n = 0;
    a(0);
    this.j = adv.a().b(getContext());
    List localList = this.j;
    if (this.j.size() > 1);
    for (int i = 6; ; i = 7)
    {
      localList.add(Integer.valueOf(i));
      this.k.c();
      postDelayed(this.o, 17L);
      return;
    }
  }

  public void a(final atr paramatr)
  {
    if (!(paramatr instanceof adr));
    Object localObject;
    do
    {
      do
      {
        return;
        paramatr = (adr)paramatr;
      }
      while ((paramatr == null) || (adr.a(paramatr) == null));
      localObject = adr.a(paramatr).getTag(2131755008);
    }
    while ((localObject == null) || (!localObject.equals(paramatr.a())) || (!atw.b(paramatr.e)));
    if (asq.n())
    {
      adr.a(paramatr).a(paramatr.e);
      return;
    }
    post(new Runnable()
    {
      public void run()
      {
        CardFlow.this.a(paramatr);
      }
    });
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 2)
    {
      this.p = i;
      i = this.l.g();
      if (i >= 0)
        b(i + 1);
      return;
    }
  }

  public void b()
  {
    adv.a().a(getContext());
  }

  public void b(atr paramatr)
  {
    if ((paramatr instanceof adr))
      adr.a((adr)paramatr).f();
  }

  public void c()
  {
    this.n += 1;
    new AsyncTask()
    {
      protected List<Object> a(Void[] paramAnonymousArrayOfVoid)
      {
        return adv.a().a(this.a, CardFlow.a(CardFlow.this));
      }

      protected void a(List<Object> paramAnonymousList)
      {
        CardFlow.b(CardFlow.this).remove(Integer.valueOf(6));
        CardFlow.b(CardFlow.this).remove(Integer.valueOf(7));
        CardFlow.b(CardFlow.this).addAll(paramAnonymousList);
        if (adv.a(paramAnonymousList))
          CardFlow.b(CardFlow.this).add(Integer.valueOf(6));
        while (true)
        {
          CardFlow.c(CardFlow.this).c();
          CardFlow.this.postDelayed(CardFlow.d(CardFlow.this), 17L);
          return;
          vy.b(CardFlow.this.getContext(), "B39");
          vw.a(CardFlow.this.getContext(), "B39");
        }
      }
    }
    .execute(new Void[0]);
  }

  public void d()
  {
    u();
  }

  public atq getBitmapLoader()
  {
    return this.m;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.p = 3;
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.leap.card.CardFlow
 * JD-Core Version:    0.6.2
 */