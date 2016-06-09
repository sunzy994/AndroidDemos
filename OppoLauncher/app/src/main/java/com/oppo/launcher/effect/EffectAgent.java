package com.oppo.launcher.effect;

import android.view.View;
import com.oppo.launcher.PagedView;

public abstract class EffectAgent
{
  private static final boolean DEBUG = false;
  private static final String TAG = "EffectAgent";
  protected TransformationInfo mChildDefaultParams = null;
  protected boolean mHasBackup = false;
  protected PagedView mPagedView;
  protected int[] mTempVisiblePagesRange = new int[2];

  public boolean applyDrawChild(View paramView)
  {
    return true;
  }

  public void applyEffect(int paramInt)
  {
    if (this.mPagedView == null)
      return;
    if (!this.mHasBackup)
      this.mHasBackup = backUpParameters();
    applyWorkspaceEffect(paramInt);
  }

  public abstract void applyWorkspaceEffect(int paramInt);

  protected boolean backUpParameters()
  {
    return false;
  }

  public String getEffectClassName()
  {
    return getClass().getName();
  }

  public boolean isAnimating()
  {
    return false;
  }

  public void recycle()
  {
    if (this.mHasBackup)
    {
      restoreParameters();
      this.mHasBackup = false;
    }
    this.mPagedView = null;
  }

  protected void restoreParameters()
  {
  }

  public void setPagedView(PagedView paramPagedView)
  {
    this.mPagedView = paramPagedView;
  }

  public static class TransformationInfo
  {
    float mAlpha;
    float mPivotX;
    float mPivotY;
    float mRotation;
    float mRotationX;
    float mRotationY;
    float mScaleX;
    float mScaleY;
    float mTranslationX;
    float mTranslationY;
    View mView;

    public float getAlpha()
    {
      return this.mAlpha;
    }

    public float getPivotX()
    {
      return this.mPivotX;
    }

    public float getPivotY()
    {
      return this.mPivotY;
    }

    public float getRotation()
    {
      return this.mRotation;
    }

    public float getRotationX()
    {
      return this.mRotationX;
    }

    public float getRotationY()
    {
      return this.mRotationY;
    }

    public float getScaleX()
    {
      return this.mScaleX;
    }

    public float getScaleY()
    {
      return this.mScaleY;
    }

    public float getTranslationX()
    {
      return this.mTranslationX;
    }

    public float getTranslationY()
    {
      return this.mTranslationY;
    }

    public View getView()
    {
      return this.mView;
    }

    public void setAlpha(float paramFloat)
    {
      this.mAlpha = paramFloat;
    }

    public void setPivotX(float paramFloat)
    {
      this.mPivotX = paramFloat;
    }

    public void setPivotY(float paramFloat)
    {
      this.mPivotY = paramFloat;
    }

    public void setRotation(float paramFloat)
    {
      this.mRotation = paramFloat;
    }

    public void setRotationX(float paramFloat)
    {
      this.mRotationX = paramFloat;
    }

    public void setRotationY(float paramFloat)
    {
      this.mRotationY = paramFloat;
    }

    public void setScaleX(float paramFloat)
    {
      this.mScaleX = paramFloat;
    }

    public void setScaleY(float paramFloat)
    {
      this.mScaleY = paramFloat;
    }

    public void setTranslationX(float paramFloat)
    {
      this.mTranslationX = paramFloat;
    }

    public void setTranslationY(float paramFloat)
    {
      this.mTranslationY = paramFloat;
    }

    public void setView(View paramView)
    {
      this.mView = paramView;
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.effect.EffectAgent
 * JD-Core Version:    0.6.2
 */