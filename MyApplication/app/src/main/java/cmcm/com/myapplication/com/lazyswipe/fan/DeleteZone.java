package cmcm.com.myapplication.com.lazyswipe.fan;

import ahw;
import ahx;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LevelListDrawable;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.lazyswipe.SwipeApplication;
import xw;
import yb;
import yl;
import yn;

public class DeleteZone extends FrameLayout
{
  private ImageView a;
  private LevelListDrawable b;
  private ImageView c;
  private boolean d;
  private boolean e;
  private int f;
  private int g;
  private yl h;
  private int i;
  private int j;
  private final Runnable k = new Runnable()
  {
    public void run()
    {
      if (DeleteZone.b(DeleteZone.this))
        if ((DeleteZone.c(DeleteZone.this) >= 0) && (DeleteZone.c(DeleteZone.this) < 3))
        {
          DeleteZone.d(DeleteZone.this).setLevel(DeleteZone.c(DeleteZone.this));
          if (DeleteZone.c(DeleteZone.this) < 2)
            DeleteZone.e(DeleteZone.this);
        }
      do
      {
        DeleteZone.this.postDelayed(this, 50L);
        do
          return;
        while ((DeleteZone.c(DeleteZone.this) < 0) || (DeleteZone.c(DeleteZone.this) >= 3));
        DeleteZone.d(DeleteZone.this).setLevel(DeleteZone.c(DeleteZone.this));
      }
      while (DeleteZone.c(DeleteZone.this) <= 0);
      DeleteZone.f(DeleteZone.this);
      DeleteZone.this.postDelayed(this, 50L);
    }
  };

  public DeleteZone(Context paramContext)
  {
    super(paramContext);
  }

  public DeleteZone(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static DeleteZone a(yb paramyb)
  {
    DeleteZone localDeleteZone = (DeleteZone)LayoutInflater.from(SwipeApplication.c()).inflate(2130968624, null);
    localDeleteZone.c(paramyb);
    if ((paramyb.getTabSectorBg() instanceof TabSectorBg))
      ((TabSectorBg)paramyb.getTabSectorBg()).setTripleFanDrawableVisible(false);
    return localDeleteZone;
  }

  private void c(yb paramyb)
  {
    this.e = paramyb.n();
    this.j = yb.getInstance().getCenterOffset();
    this.f = paramyb.getTabSectorOuterSize();
    this.g = View.MeasureSpec.makeMeasureSpec(this.f, 1073741824);
    this.h = paramyb.getStartPosition();
    Object localObject = new LayoutParams(-2, -2);
    int m;
    if (this.e)
      m = 3;
    while (true)
    {
      ((LayoutParams)localObject).gravity = (m | 0x50);
      m = getResources().getDimensionPixelSize(2131296343);
      int n = getResources().getDimensionPixelSize(2131296342);
      ((LayoutParams)localObject).topMargin = 0;
      ((LayoutParams)localObject).bottomMargin = n;
      if (this.e)
        ((LayoutParams)localObject).leftMargin = m;
      try
      {
        label124: paramyb.addView(this, (ViewGroup.LayoutParams)localObject);
        this.c.setImageDrawable(new yn(0, this.f, yb.getInstance().getCenterOffset(), -1881526, this.e, null));
        localObject = this.c;
        if (this.e);
        for (float f1 = 0.0F; ; f1 = m)
        {
          ((ImageView)localObject).setPivotX(f1);
          this.c.setPivotY(this.f);
          this.c.setScaleX(0.0F);
          this.c.setScaleY(0.0F);
          this.a.setScaleX(0.0F);
          this.a.setScaleY(0.0F);
          if ((paramyb.getTabSector() instanceof TabSector))
            ((TabSector)paramyb.getTabSector()).b(new AnimatorListenerAdapter()
            {
              public void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                DeleteZone.a(DeleteZone.this).animate().scaleX(1.0F).scaleY(1.0F).setDuration(75L).start();
              }
            });
          return;
          m = 5;
          break;
          ((LayoutParams)localObject).rightMargin = m;
          break label124;
          m = this.f;
        }
      }
      catch (Exception paramyb)
      {
      }
    }
  }

  public void a()
  {
    if (!this.d)
    {
      this.d = true;
      post(this.k);
      this.c.animate().scaleX(1.0F).scaleY(1.0F).setDuration(80L).start();
    }
  }

  public void a(DragEvent paramDragEvent, xw paramxw)
  {
    if ((paramDragEvent == null) || (!(getParent() instanceof yb)))
      return;
    if (paramxw != null)
      paramxw.a();
    postDelayed(new Runnable()
    {
      public void run()
      {
        DeleteZone.this.b();
      }
    }
    , 150L);
    postDelayed(new Runnable()
    {
      public void run()
      {
        DeleteZone.this.b((yb)DeleteZone.this.getParent());
      }
    }
    , 300L);
  }

  public void b()
  {
    if (this.d)
    {
      this.d = false;
      post(this.k);
      this.c.animate().scaleX(0.0F).scaleY(0.0F).setDuration(80L).start();
    }
  }

  public void b(final yb paramyb)
  {
    try
    {
      this.a.animate().scaleX(0.0F).scaleY(0.0F).setDuration(75L).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (paramyb == null)
            return;
          if ((paramyb.getTabSector() instanceof TabSector))
            ((TabSector)paramyb.getTabSector()).a(null);
          if ((paramyb.getTabSectorBg() instanceof TabSectorBg))
            ((TabSectorBg)paramyb.getTabSectorBg()).setTripleFanDrawableVisible(true);
          DeleteZone.this.post(new Runnable()
          {
            public void run()
            {
              DeleteZone.2.this.a.removeView(DeleteZone.this);
            }
          });
        }
      }).start();
      return;
    }
    catch (Exception paramyb)
    {
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = false;
    this.a = ((ImageView)findViewById(2131755214));
    this.b = ((LevelListDrawable)getResources().getDrawable(2130837600));
    this.a.setColorFilter(ahx.b(getContext()).m(), PorterDuff.Mode.SRC_IN);
    this.a.setImageDrawable(this.b);
    this.c = ((ImageView)findViewById(2131755213));
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.h.b - this.a.getMeasuredHeight() / 2 + 1;
    if (this.e)
    {
      paramInt2 = this.h.a - this.a.getMeasuredWidth() / 2 - 3;
      this.a.layout(paramInt2, getMeasuredHeight() - this.a.getMeasuredHeight() - paramInt1, this.a.getMeasuredWidth() + paramInt2, getMeasuredHeight() - paramInt1);
      return;
    }
    paramInt2 = -this.h.a - this.a.getMeasuredWidth() / 2 - 3;
    this.a.layout(getMeasuredWidth() - paramInt2 - this.a.getMeasuredWidth(), getMeasuredHeight() - this.a.getMeasuredHeight() - paramInt1, getMeasuredWidth() - paramInt2, getMeasuredHeight() - paramInt1);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.f > 0)
    {
      setMeasuredDimension(this.f, this.f);
      this.c.measure(this.g, this.g);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.DeleteZone
 * JD-Core Version:    0.6.2
 */