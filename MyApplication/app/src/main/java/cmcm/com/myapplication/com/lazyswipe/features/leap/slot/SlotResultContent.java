package cmcm.com.myapplication.com.lazyswipe.features.leap.slot;

import abd;
import abg;
import abp;
import abq;
import abt;
import aen;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ari;
import atw;
import vs;
import vy;

public class SlotResultContent extends FrameLayout
  implements abp
{
  private static final int[] l = { 2131231063, 2131231064, 2131231065, 2131231066, 2131231067 };
  private View a;
  private View b;
  private ViewGroup c;
  private TextView d;
  private TextView e;
  private abg f;
  private SlotResultArea g;
  private SlotMachine h;
  private boolean i;
  private abq j;
  private final Handler k = new Handler();
  private final long m = 3000L;
  private long n;

  static
  {
    Log.i("Swipe.Slot", "Strings count: " + l.length);
  }

  public SlotResultContent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private String a(String paramString)
  {
    int i1 = ari.c(1, 6);
    String str = "slot_machine_no_content" + i1;
    i1 = getResources().getIdentifier(str, "string", getContext().getPackageName());
    if (i1 == 0)
      return getResources().getString(2131231063, new Object[] { paramString });
    return getResources().getString(i1, new Object[] { paramString });
  }

  private void a(int paramInt, String paramString)
  {
    ((ImageView)findViewById(paramInt)).setImageBitmap(this.h.a(paramString));
  }

  private boolean b(abq paramabq, boolean paramBoolean)
  {
    return (1 == paramabq.a()) || (!paramBoolean);
  }

  private boolean d(abq paramabq)
  {
    if ((paramabq == null) || (paramabq.j() == null));
    while (atw.b(paramabq.j()))
      return false;
    return true;
  }

  private void g()
  {
    b();
    this.i = false;
    this.g.b(false);
    this.c.setVisibility(0);
    this.d.setVisibility(8);
    int i1 = SlotMachine.a(getContext());
    this.e.setText(a(String.valueOf(i1)));
  }

  private long getDelay()
  {
    return Math.max(3000L - (System.currentTimeMillis() - this.n), 0L);
  }

  void a()
  {
    a(2131755498, "slot_paper_middle");
    a(2131755493, "slot_label_line");
    a(2131755494, "slot_label_line");
  }

  void a(int paramInt)
  {
    b();
    this.i = false;
    int i1 = SlotMachine.a(getContext());
    this.c.setVisibility(0);
    this.d.setVisibility(0);
    this.d.setText("+" + paramInt);
    this.e.setText(getResources().getString(2131231068, new Object[] { String.valueOf(i1) }));
  }

  public void a(abq paramabq)
  {
    this.h.h();
  }

  public void a(final abq paramabq, boolean paramBoolean)
  {
    if (b(paramabq, paramBoolean))
      this.k.postDelayed(new Runnable()
      {
        public void run()
        {
          SlotResultContent.a(SlotResultContent.this, true);
          SlotResultContent.a(SlotResultContent.this, paramabq);
          ((abt)paramabq).p();
          SlotResultContent.b(SlotResultContent.this).b(true);
          vs.a(7);
        }
      }
      , getDelay());
  }

  public void a(abq paramabq, boolean paramBoolean, int paramInt, String paramString)
  {
    this.k.postDelayed(new Runnable()
    {
      public void run()
      {
        SlotResultContent.a(SlotResultContent.this);
      }
    }
    , getDelay());
  }

  protected void a(SlotMachine paramSlotMachine, SlotResultArea paramSlotResultArea)
  {
    this.g = paramSlotResultArea;
    this.h = paramSlotMachine;
  }

  void a(boolean paramBoolean)
  {
    b();
    if (vs.a(7, true))
    {
      Context localContext = getContext();
      if (paramBoolean);
      for (String str = "CW"; ; str = "CV")
      {
        vy.b(localContext, str);
        this.n = System.currentTimeMillis();
        abd.i.a(this, 7);
        return;
      }
    }
    this.k.postDelayed(new Runnable()
    {
      public void run()
      {
        SlotResultContent.a(SlotResultContent.this);
      }
    }
    , 4000L);
  }

  public View b(abq paramabq)
  {
    if (this.f == null)
      this.f = new abg();
    if (d(paramabq))
    {
      this.a.setVisibility(8);
      this.b.setVisibility(0);
      this.f.a(this.b);
      return this.b;
    }
    this.b.setVisibility(8);
    this.a.setVisibility(0);
    this.f.a(this.a);
    return this.a;
  }

  void b()
  {
    this.i = false;
    this.a.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
  }

  public void c(abq paramabq)
  {
  }

  void d()
  {
    b();
    this.i = false;
    this.c.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setText(2131231062);
  }

  void e()
  {
    b();
    if (this.j != null);
    try
    {
      this.j.b();
      this.j = null;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  boolean f()
  {
    return this.i;
  }

  public abg getAdViewHolder()
  {
    return this.f;
  }

  public boolean i_()
  {
    return true;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(2131755490);
    this.b = findViewById(2131755491);
    this.c = ((ViewGroup)findViewById(2131755492));
    this.d = ((TextView)findViewById(2131755496));
    this.e = ((TextView)findViewById(2131755497));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.leap.slot.SlotResultContent
 * JD-Core Version:    0.6.2
 */