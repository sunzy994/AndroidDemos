package cmcm.com.myapplication.com.lazyswipe.fan.notification;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import aqs;
import asq;
import java.util.ArrayList;
import java.util.List;
import vj;

public class NotificationAvatarList extends FrameLayout
{
  private NotificationView a;
  private int b;
  private List<ImageView> c = new ArrayList();
  private ImageView d;
  private int e = asq.a(10.0F);
  private int f = asq.a(56.0F);
  private int g = asq.a(22.700001F);
  private int h = asq.a(11.3F);
  private int i = aqs.ae() / (this.f + this.e);
  private float j = 0.0F;
  private Drawable k;

  public NotificationAvatarList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(float paramFloat)
  {
    if (this.d == null);
    while ((this.j == paramFloat) || (this.c.size() == 0))
      return;
    this.j = paramFloat;
    paramFloat = this.c.size() - 1 - paramFloat;
    if (paramFloat > this.i - 1)
    {
      b((paramFloat - (this.i - 1)) * (this.f + this.e));
      paramFloat = this.i - 1;
      if (!vj.g)
        break label164;
    }
    label164: for (int m = getMeasuredHeight(); ; m = getMeasuredWidth())
    {
      paramFloat = m - asq.a(6.0F) - (0.5F + paramFloat) * this.f - paramFloat * this.e;
      if (!vj.g)
        break label172;
      this.d.setY(-paramFloat - this.h / 2);
      return;
      b(0.0F);
      break;
    }
    label172: this.d.setX(paramFloat - this.g / 2);
  }

  private void b(float paramFloat)
  {
    int m = 0;
    if (m < this.c.size())
    {
      ImageView localImageView = (ImageView)this.c.get(m);
      if (vj.g)
        localImageView.setTranslationX(paramFloat);
      while (true)
      {
        m += 1;
        break;
        localImageView.setTranslationY(-paramFloat);
      }
    }
  }

  private void c()
  {
    this.c.clear();
    removeAllViews();
    this.j = -100.0F;
    this.d = new ImageView(getContext());
    Object localObject = new LayoutParams(this.g, this.h);
    int n;
    int m;
    label152: LayoutParams localLayoutParams;
    if (vj.g)
    {
      ((LayoutParams)localObject).gravity = 83;
      if (vj.g)
      {
        this.d.setPivotX(this.g / 2);
        this.d.setPivotY(this.h);
        this.d.setRotation(90.0F);
        ((LayoutParams)localObject).leftMargin = (-(this.g - this.h));
      }
      this.d.setImageResource(2130837687);
      addView(this.d, (ViewGroup.LayoutParams)localObject);
      this.d.setVisibility(4);
      n = asq.a(6.0F);
      m = 0;
      if (m < 0)
        break label395;
      localObject = new ImageView(getContext());
      ((ImageView)localObject).setImageDrawable(this.k);
      ((ImageView)localObject).setTag(Integer.valueOf(m));
      this.c.add(localObject);
      localLayoutParams = new LayoutParams(this.f, this.f);
      ((ImageView)localObject).setVisibility(0);
      if (!vj.g)
        break label327;
      localLayoutParams.gravity = 53;
      localLayoutParams.topMargin = n;
      label234: addView((View)localObject, localLayoutParams);
      if (!vj.g)
        break label342;
      ((ImageView)localObject).setTranslationY(-n - this.f);
      ((ImageView)localObject).setAlpha(0.0F);
      ((ImageView)localObject).animate().translationY(0.0F).alpha(1.0F).setDuration(222L).setInterpolator(new AccelerateInterpolator()).setListener(null);
    }
    while (true)
    {
      n += this.e + this.f;
      m -= 1;
      break label152;
      ((LayoutParams)localObject).gravity = 83;
      break;
      label327: localLayoutParams.gravity = 53;
      localLayoutParams.rightMargin = n;
      break label234;
      label342: ((ImageView)localObject).setTranslationX(this.f + n);
      ((ImageView)localObject).setAlpha(0.0F);
      ((ImageView)localObject).animate().translationX(0.0F).alpha(1.0F).setDuration(222L).setInterpolator(new AccelerateInterpolator()).setListener(null);
    }
    label395: this.d.setAlpha(1.0F);
    this.d.setVisibility(0);
    if (vj.g)
    {
      this.d.setTranslationX(-this.h);
      this.d.animate().translationX(0.0F).setDuration(200L).setListener(null);
    }
    while (true)
    {
      a(this.b);
      requestLayout();
      return;
      this.d.setTranslationY(this.h);
      this.d.animate().translationY(0.0F).setStartDelay(120L).setDuration(100L).setListener(null);
    }
  }

  public void a()
  {
    c();
  }

  public void a(final Runnable paramRunnable)
  {
    if (this.d == null)
      return;
    ViewPropertyAnimator localViewPropertyAnimator = this.d.animate();
    if (vj.g);
    for (long l = 65L; ; l = 190L)
    {
      localViewPropertyAnimator.setStartDelay(l).alpha(0.0F).setDuration(15L).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          int i = 0;
          while (i < NotificationAvatarList.a(NotificationAvatarList.this).size())
          {
            ((ImageView)NotificationAvatarList.a(NotificationAvatarList.this).get(i)).animate().x(NotificationAvatarList.this.getWidth() + NotificationAvatarList.b(NotificationAvatarList.this)).setDuration(60L).setListener(new AnimatorListenerAdapter()
            {
              public void onAnimationEnd(Animator paramAnonymous2Animator)
              {
                NotificationAvatarList.1.this.a.run();
              }
            });
            i += 1;
          }
        }
      });
      return;
    }
  }

  void b()
  {
    this.j = -100.0F;
    this.c.clear();
    removeAllViews();
    this.j = -100.0F;
  }

  public Drawable getAvatar()
  {
    return this.k;
  }

  public void setAvatar(Drawable paramDrawable)
  {
    this.k = paramDrawable;
  }

  public void setNotificationView(NotificationView paramNotificationView)
  {
    this.a = paramNotificationView;
    this.b = 0;
    a(this.b);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.notification.NotificationAvatarList
 * JD-Core Version:    0.6.2
 */