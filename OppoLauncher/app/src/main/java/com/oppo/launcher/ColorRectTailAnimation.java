package com.oppo.launcher;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ColorRectTailAnimation
{
  static final int ANIMATION_DELAY_TIME = 1;
  static final int ANIMATION_DURATION = 4;
  static final int ANIMATION_FOLLOW_TIME = 5;
  static final boolean DEBUG = false;
  static final int DELTA_X = 2;
  static final int DELTA_Y = -2;
  static final int MSG_ANIMATION_END = 12288;
  static final int MSG_ANIMATION_RUN = 4096;
  static final int MSG_ANIMATION_STOP = 8192;
  static final int MSG_ANIMATION_VIEW_POS = 20480;
  final String TAG = ColorRectTailAnimation.class.getName();
  final boolean USE_SYSTEM_ANIMATION = false;
  final boolean USE_TAIL_ANIMATION = true;
  private boolean isAnimating = false;
  Handler mTailHandler = new Handler()
  {
    public void dispatchMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
      case 20480:
      case 4096:
        do
          while (true)
          {
            return;
            if ((ColorRectTailAnimation.this.isAnimating) && (ColorRectTailAnimation.this.mTailViewList != null))
            {
              int i = 0;
              paramAnonymousMessage = ColorRectTailAnimation.this.mTailViewList.listIterator(ColorRectTailAnimation.this.mTailViewList.size());
              paramAnonymousMessage.previous();
              while (paramAnonymousMessage.hasPrevious())
              {
                View localView = (View)paramAnonymousMessage.previous();
                Point localPoint = (Point)ColorRectTailAnimation.this.moveDateList.get(i);
                localView.setTranslationX(localPoint.x);
                localView.setTranslationY(localPoint.y);
                i += 1;
              }
            }
          }
        while (!ColorRectTailAnimation.this.isAnimating);
        ColorRectTailAnimation.this.dealTail();
        sendEmptyMessageDelayed(4096, 5L);
        return;
      case 8192:
        Log.e(ColorRectTailAnimation.this.TAG, "ColorRectTailAnimation mTailHandler MSG_ANIMATION_STOP ");
        removeMessages(4096);
        ColorRectTailAnimation.access$002(ColorRectTailAnimation.this, false);
        return;
      case 12288:
      }
      sendEmptyMessageDelayed(8192, (ColorRectTailAnimation.this.mTailViewList.size() + 2) * 10);
    }
  };
  private List<ColorRectDragView> mTailViewList = null;
  private List<Point> moveDateList = new ArrayList();

  private void Log(String paramString)
  {
  }

  public void animateView(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    paramView1.clearAnimation();
    paramView1 = new TailValueAnimator(paramView1, paramView2);
    paramView1.setFloatValues(new float[] { 0.0F, 1.0F });
    paramView1.setInterpolator(new AccelerateInterpolator());
    paramView1.setStartDelay(paramInt2);
    paramView1.setDuration(4L);
    paramView1.start();
  }

  void dealTail()
  {
    Log("dealTail");
    if (this.mTailViewList == null)
    {
      Log.e(this.TAG, "ColorRectTailAnimation dealTail " + this.isAnimating);
      endTail(true);
      return;
    }
    if (this.mTailViewList.size() < 1)
    {
      Log.e(this.TAG, "mTailViewList.size()<1");
      endTail(true);
      return;
    }
    this.moveDateList.clear();
    ListIterator localListIterator = this.mTailViewList.listIterator(this.mTailViewList.size());
    Object localObject = (View)localListIterator.previous();
    while (localListIterator.hasPrevious())
    {
      localListIterator.previousIndex();
      View localView = (View)localListIterator.previous();
      if (localView != null)
      {
        this.moveDateList.add(new Point((int)((View)localObject).getTranslationX(), (int)((View)localObject).getTranslationY()));
        localObject = localView;
      }
    }
    this.mTailHandler.sendEmptyMessageDelayed(20480, 5L);
  }

  public void endTail(boolean paramBoolean)
  {
    Log("endTail");
    if (!paramBoolean)
    {
      this.mTailHandler.removeMessages(12288);
      this.mTailHandler.sendEmptyMessage(12288);
      return;
    }
    this.isAnimating = false;
    this.mTailHandler.removeMessages(4096);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    case 0:
    case 2:
    default:
      return true;
    case 1:
    case 3:
    }
    endTail(true);
    return true;
  }

  public void setList(List<ColorRectDragView> paramList)
  {
    this.mTailViewList = paramList;
    Log("setList " + paramList.size());
  }

  public void startTail()
  {
    Log("startTail");
    this.isAnimating = true;
    this.mTailHandler.removeMessages(4096);
    this.mTailHandler.removeMessages(8192);
    this.mTailHandler.sendEmptyMessage(4096);
  }

  class TailValueAnimator extends ValueAnimator
  {
    float mFinalDeltaX = 0.0F;
    float mFinalDeltaY = 0.0F;
    float mInitDeltaX = 0.0F;
    float mInitDeltaY = 0.0F;

    public TailValueAnimator(final View paramView1, View arg3)
    {
      addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          float f2 = TailValueAnimator.this.mFinalDeltaX;
          float f3 = TailValueAnimator.this.mInitDeltaX;
          float f4 = TailValueAnimator.this.mFinalDeltaY;
          float f5 = TailValueAnimator.this.mInitDeltaY;
          paramView1.setTranslationX(f2 * f1 + (1.0F - f1) * f3);
          paramView1.setTranslationY(f4 * f1 + (1.0F - f1) * f5);
        }
      });
      final View localView;
      addListener(new AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramView1.setTranslationX(TailValueAnimator.this.mFinalDeltaX);
          paramView1.setTranslationY(TailValueAnimator.this.mFinalDeltaY);
        }

        public void onAnimationRepeat(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          TailValueAnimator.this.mInitDeltaX = paramView1.getTranslationX();
          TailValueAnimator.this.mInitDeltaY = paramView1.getTranslationY();
          TailValueAnimator.this.mFinalDeltaX = (localView.getTranslationX() + 2.0F);
          TailValueAnimator.this.mFinalDeltaY = (localView.getTranslationY() - 2.0F);
        }
      });
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ColorRectTailAnimation
 * JD-Core Version:    0.6.2
 */