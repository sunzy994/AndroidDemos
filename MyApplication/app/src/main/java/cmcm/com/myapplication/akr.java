package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;

public abstract class akr extends View
{
  protected Context g = getContext();
  protected final int h = 6000;
  protected int i;
  Handler j;
  Runnable k = null;

  public akr(Context paramContext)
  {
    super(paramContext);
  }

  public static View a(Context paramContext, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    return a(paramContext, paramInt1, paramBoolean, paramInt2, paramInt3, asq.a(30.0F), asq.a(46.0F), vs.Q(paramContext), false);
  }

  public static View a(Context paramContext, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    paramInt1 = akc.a(paramContext, paramInt1, paramBoolean1).intValue();
    Object localObject1;
    switch (paramInt1)
    {
    case 2130837569:
    default:
      localObject1 = new ImageView(paramContext);
      paramContext = new LinearLayout.LayoutParams(0, paramInt4, 1.0F);
      ((ImageView)localObject1).setScaleType(ScaleType.CENTER_INSIDE);
      ((ImageView)localObject1).setLayoutParams(paramContext);
      ((ImageView)localObject1).setImageResource(paramInt1);
      paramContext = (Context)localObject3;
    case 2130837566:
    case 2130837570:
    case 2130837568:
    case 2130837571:
    case 2130837572:
    case 2130837574:
    case 2130837567:
    case 2130837573:
    }
    while (paramContext != null)
    {
      paramContext.setAnimationOn(paramBoolean2);
      paramContext.e();
      paramContext.setLayoutParams(new LinearLayout.LayoutParams(0, paramInt5, 1.0F));
      return paramContext;
      localObject3 = new akq(paramContext);
      if (!paramBoolean3)
        ((akr)localObject3).d();
      paramContext = (Context)localObject3;
      localObject1 = localObject2;
      if (paramInt3 != 0)
      {
        ((akr)localObject3).a((paramInt2 / paramInt3 - ((akr)localObject3).getViewWidth()) / 2.0F, 0.0F);
        paramContext = (Context)localObject3;
        localObject1 = localObject2;
        continue;
        localObject3 = new akm(paramContext);
        if (!paramBoolean3)
          ((akr)localObject3).d();
        paramContext = (Context)localObject3;
        localObject1 = localObject2;
        if (paramInt3 != 0)
        {
          ((akr)localObject3).a((paramInt2 / paramInt3 - ((akr)localObject3).getViewWidth()) / 2.0F, asq.a(6.0F));
          paramContext = (Context)localObject3;
          localObject1 = localObject2;
          continue;
          localObject3 = new akl(paramContext);
          if (!paramBoolean3)
            ((akr)localObject3).d();
          paramContext = (Context)localObject3;
          localObject1 = localObject2;
          if (paramInt3 != 0)
          {
            ((akr)localObject3).a((paramInt2 / paramInt3 - ((akr)localObject3).getViewWidth()) / 2.0F, asq.a(6.0F));
            paramContext = (Context)localObject3;
            localObject1 = localObject2;
            continue;
            localObject3 = new akj(paramContext);
            if (!paramBoolean3)
              ((akr)localObject3).d();
            paramContext = (Context)localObject3;
            localObject1 = localObject2;
            if (paramInt3 != 0)
            {
              ((akr)localObject3).a((paramInt2 / paramInt3 - ((akr)localObject3).getViewWidth()) / 2.0F, asq.a(3.0F));
              paramContext = (Context)localObject3;
              localObject1 = localObject2;
              continue;
              localObject3 = new akk(paramContext);
              if (!paramBoolean3)
                ((akr)localObject3).d();
              paramContext = (Context)localObject3;
              localObject1 = localObject2;
              if (paramInt3 != 0)
              {
                ((akr)localObject3).a((paramInt2 / paramInt3 - ((akr)localObject3).getViewWidth()) / 2.0F, asq.a(3.0F));
                paramContext = (Context)localObject3;
                localObject1 = localObject2;
                continue;
                localObject3 = new ako(paramContext);
                if (!paramBoolean3)
                  ((akr)localObject3).d();
                paramContext = (Context)localObject3;
                localObject1 = localObject2;
                if (paramInt3 != 0)
                {
                  ((akr)localObject3).a((paramInt2 / paramInt3 - ((akr)localObject3).getViewWidth()) / 2.0F, asq.a(6.0F));
                  paramContext = (Context)localObject3;
                  localObject1 = localObject2;
                  continue;
                  localObject3 = new akp(paramContext);
                  if (!paramBoolean3)
                    ((akr)localObject3).d();
                  paramContext = (Context)localObject3;
                  localObject1 = localObject2;
                  if (paramInt3 != 0)
                  {
                    ((akr)localObject3).a((paramInt2 / paramInt3 - ((akr)localObject3).getViewWidth()) / 2.0F, asq.a(6.0F));
                    paramContext = (Context)localObject3;
                    localObject1 = localObject2;
                    continue;
                    localObject3 = new akn(paramContext);
                    if (!paramBoolean3)
                      ((akr)localObject3).d();
                    paramContext = (Context)localObject3;
                    localObject1 = localObject2;
                    if (paramInt3 != 0)
                    {
                      ((akr)localObject3).a((paramInt2 / paramInt3 - ((akr)localObject3).getViewWidth()) / 2.0F, asq.a(7.0F));
                      paramContext = (Context)localObject3;
                      localObject1 = localObject2;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return localObject1;
  }

  public abstract void a(float paramFloat1, float paramFloat2);

  public abstract boolean b();

  public abstract void d();

  public abstract void e();

  public abstract float getViewWidth();

  public void setAnimationOn(boolean paramBoolean)
  {
    if (!paramBoolean)
      e();
  }

  public void setCallback(Runnable paramRunnable)
  {
    this.k = paramRunnable;
    this.j.sendEmptyMessageDelayed(2, 6000L);
  }

  public void setStartDelay(int paramInt)
  {
    e();
    this.j.sendEmptyMessageDelayed(0, paramInt);
  }

  public void setStartInterval(int paramInt)
  {
    this.i = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akr
 * JD-Core Version:    0.6.2
 */