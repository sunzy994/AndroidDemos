package com.oppo.launcher;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ColorRectTips extends PopupWindow
{
  BalloonView mBalloonView;
  private View mParent;

  public ColorRectTips(Context paramContext, View paramView)
  {
    super(paramContext);
    this.mParent = paramView;
    setTouchable(false);
    setBackgroundDrawable(new ColorDrawable(0));
    this.mBalloonView = new BalloonView(paramContext);
    this.mBalloonView.setLayerType(1, null);
    this.mBalloonView.setClickable(false);
    this.mBalloonView.setText(" " + (String)this.mBalloonView.getResources().getText(2131427378) + " ");
    setWidth(-2);
    setHeight(-2);
    setContentView(this.mBalloonView);
  }

  public int getHeightMost()
  {
    return (int)this.mBalloonView.getPreHeight();
  }

  public int getWidthMost()
  {
    return (int)this.mBalloonView.getPreWidth();
  }

  public void show(int[] paramArrayOfInt, int paramInt)
  {
    this.mBalloonView.updateBackGroud(paramInt);
    showAtLocation(this.mParent, 51, paramArrayOfInt[0], paramArrayOfInt[1]);
  }

  private class BalloonView extends TextView
  {
    private int mLabeColor = -16777216;
    private float mRelMeasuredWidth = 0.0F;
    private float mRelMeasuredheight = 0.0F;
    private String mTips;

    public BalloonView(Context arg2)
    {
      super();
      setGravity(17);
      setTextColor(this.mLabeColor);
      setBackgroundResource(2130837507);
      this$1 = getResources();
      this.mRelMeasuredheight = ColorRectTips.this.getDimensionPixelSize(2131361902);
      setTextSize(0, ColorRectTips.this.getDimensionPixelSize(2131361905));
      setHeight((int)this.mRelMeasuredheight);
    }

    public float getPreHeight()
    {
      return this.mRelMeasuredheight;
    }

    public float getPreWidth()
    {
      this.mRelMeasuredWidth = (getPaint().measureText(this.mTips) + getPaddingLeft() + getPaddingRight());
      return this.mRelMeasuredWidth;
    }

    public void setText(String paramString)
    {
      this.mTips = paramString;
      super.setText(paramString);
    }

    public void updateBackGroud(int paramInt)
    {
      if (paramInt == 3)
      {
        setBackgroundResource(2130837506);
        return;
      }
      if (paramInt == 5)
      {
        setBackgroundResource(2130837508);
        return;
      }
      setBackgroundResource(2130837507);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ColorRectTips
 * JD-Core Version:    0.6.2
 */