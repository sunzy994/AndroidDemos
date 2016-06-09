package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class asv extends AnimationUtils
{
  private static TransitionDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Object localObject;
    if (paramDrawable1 == null)
      localObject = new ColorDrawable(0);
    while (true)
    {
      return new TransitionDrawable(new Drawable[] { localObject, paramDrawable2 });
      localObject = paramDrawable1;
      if ((paramDrawable1 instanceof TransitionDrawable))
        localObject = ((TransitionDrawable)paramDrawable1).getDrawable(1);
    }
  }

  public static void a(Animator paramAnimator)
  {
    if (paramAnimator != null)
      paramAnimator.cancel();
  }

  public static void a(View paramView, Drawable paramDrawable)
  {
    a(paramView, paramDrawable, 300);
  }

  public static void a(View paramView, Drawable paramDrawable, int paramInt)
  {
    if (paramInt > 0)
    {
      paramDrawable = a(paramView.getBackground(), paramDrawable);
      paramView.setBackgroundDrawable(paramDrawable);
      paramDrawable.startTransition(paramInt);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }

  public static void a(ViewPropertyAnimator paramViewPropertyAnimator, Runnable paramRunnable)
  {
    if ((paramViewPropertyAnimator == null) || (paramRunnable == null))
      return;
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramViewPropertyAnimator.withStartAction(new Runnable()
      {
        public void run()
        {
          asv.this.run();
        }
      });
      return;
    }
    paramViewPropertyAnimator.setListener(new asx()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        asv.this.run();
      }
    });
  }

  public static void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    a(paramImageView, null, paramBitmap);
  }

  public static void a(ImageView paramImageView, Drawable paramDrawable)
  {
    a(paramImageView, null, paramDrawable);
  }

  public static void a(ImageView paramImageView, ScaleType paramScaleType, Bitmap paramBitmap)
  {
    a(paramImageView, paramScaleType, new BitmapDrawable(paramBitmap), 300);
  }

  public static void a(ImageView paramImageView, ScaleType paramScaleType, Drawable paramDrawable)
  {
    a(paramImageView, paramScaleType, paramDrawable, 300);
  }

  public static void a(ImageView paramImageView, ScaleType paramScaleType, Drawable paramDrawable, int paramInt)
  {
    if ((paramScaleType != null) && (paramImageView.getScaleType() != paramScaleType))
      paramImageView.setScaleType(paramScaleType);
    if (paramInt > 0)
    {
      paramScaleType = a(paramImageView.getDrawable(), paramDrawable);
      paramImageView.setImageDrawable(paramScaleType);
      paramScaleType.startTransition(paramInt);
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
  }

  public static void b(ViewPropertyAnimator paramViewPropertyAnimator, Runnable paramRunnable)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramViewPropertyAnimator == null)
      return;
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (paramRunnable != null)
        localObject1 = new Runnable()
        {
          public void run()
          {
            asv.this.run();
          }
        };
      paramViewPropertyAnimator.withEndAction((Runnable)localObject1);
      return;
    }
    localObject1 = localObject2;
    if (paramRunnable != null)
      localObject1 = new asx()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          asv.this.run();
        }
      };
    paramViewPropertyAnimator.setListener((AnimatorListener)localObject1);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asv
 * JD-Core Version:    0.6.2
 */