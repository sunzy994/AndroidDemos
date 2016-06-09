package cmcm.com.myapplication.com.lazyswipe.features.leap.card;

import aas;
import aav;
import aba;
import abd;
import abe;
import abq;
import abt;
import abu;
import adp;
import adt;
import amk;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.TextView;
import arl;
import asq;
import asr;
import atw;
import vs;
import yb;

public class AdCard extends adp
{
  private static final String h = "Swipe." + AdCard.class.getSimpleName();
  private static final int[] i = { -10827526, -147409, -157913, -53931, -16745729, -11740828 };
  private static int k = -1;
  private abu j;

  public AdCard(Context paramContext)
  {
    super(paramContext);
  }

  public AdCard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public AdCard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public static AdCard a(Context paramContext)
  {
    return (AdCard)asr.a(paramContext, 2130968597);
  }

  private void a(abt paramabt)
  {
    paramabt.a(this, true, new Runnable()
    {
      public void run()
      {
        abe.a();
        yb.p();
      }
    });
  }

  public static boolean a(Context paramContext, int paramInt)
  {
    if (arl.f(paramContext));
    long l1;
    long l2;
    do
    {
      return false;
      l1 = vs.a(paramContext, "key_card_ad_last_request_time", 0L);
      l2 = aas.a(paramInt);
    }
    while ((l2 <= 0L) || (System.currentTimeMillis() - l1 >= l2));
    return true;
  }

  public static abt b(Context paramContext)
  {
    if ((!abd.l) || (amk.b(paramContext)));
    label141: 
    do
    {
      long l;
      do
      {
        int m;
        do
        {
          return null;
          if (k >= 0)
            break;
          m = aav.a(paramContext);
        }
        while (-1 == m);
        k = m;
        l = aas.a(paramContext, k);
      }
      while ((l > 0L) && (System.currentTimeMillis() - vs.b() < l));
      if (abd.h == null)
        abd.h = new aba(paramContext, k);
      abt localabt;
      while (true)
      {
        localabt = abd.h.l();
        if (localabt == null)
          break label141;
        if (1 == localabt.a())
          break;
        return localabt;
        if (abd.h.k() != k)
        {
          abd.h.f();
          abd.h = new aba(paramContext, k);
        }
      }
      localabt.n();
    }
    while (a(paramContext, k));
    if (asq.n())
      abd.h.b();
    while (true)
    {
      setRequestTime(paramContext);
      return null;
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          abd.h.b();
        }
      });
    }
  }

  public static void setRequestTime(Context paramContext)
  {
    vs.b(paramContext, "key_card_ad_last_request_time", System.currentTimeMillis());
  }

  public void a()
  {
    super.a();
    if (this.j == null)
    {
      this.j = new abu(getContext());
      this.j.a(this);
    }
    while (true)
    {
      this.j.a((abq)this.e);
      int m = i[((int)(System.currentTimeMillis() % i.length))];
      this.j.h.setBackgroundDrawable(atw.a(asq.a(2.0F), m));
      a((abt)this.e);
      return;
      this.j.b();
    }
  }

  public void a(Object paramObject)
  {
    super.a(paramObject);
    setTag(this.j);
  }

  public void b()
  {
    if (this.j != null)
      this.j.a();
  }

  public void c()
  {
    super.c();
    Context localContext = getContext();
    aba localaba = abd.h;
    abt localabt = localaba.l();
    if (localabt != null)
      localabt.p();
    if (!a(localContext, localaba.k()))
    {
      localaba.a(true, false);
      setRequestTime(localContext);
    }
  }

  public adt getCardHolder()
  {
    return new adt(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.leap.card.AdCard
 * JD-Core Version:    0.6.2
 */