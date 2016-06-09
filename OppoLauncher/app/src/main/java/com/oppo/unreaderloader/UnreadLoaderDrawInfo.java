package com.oppo.unreaderloader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import com.oppo.launcher.LauncherUtil;
import com.oppo.launcher.Utilities;
import com.oppo.launcher.screenGrid.ScreenGridUtils;

public class UnreadLoaderDrawInfo
{
  private static final boolean DEBUG_UNREAD = LauncherUtil.LAUNCHER_QE_ASSERT_DEBUG;
  public static final int MAX_NUM = 99;
  private static final String TAG = "UnreadLoaderDrawInfo";
  protected static final int UNSETTLEEVENT_BG_RIGHT_PADDING_TO_RIGHTSIDE = 8;
  protected float mNumx;
  protected float mNumy;
  private int mUnsettleEventBgHeight;
  protected int mUnsettleEventBgRightPadding;
  protected int mUnsettleEventBgTopPadding;
  private int mUnsettleEventBgWidth;
  protected Drawable mUnsettleEventNumBg = null;
  private int mUnsettleEventNumPadding;
  protected TextPaint mUnsettleEventNumPaint = null;
  protected int mUnsettleEventNumTextColor;
  protected int mUnsettleEventNumTextSize;

  public UnreadLoaderDrawInfo(Context paramContext, View paramView)
  {
    paramContext = paramContext.getResources();
    this.mUnsettleEventBgRightPadding = paramContext.getDimensionPixelSize(2131361911);
    this.mUnsettleEventBgTopPadding = ScreenGridUtils.getUnsettledEventPaddingTop(paramContext, ScreenGridUtils.isOnDockBar(paramView));
    this.mUnsettleEventNumTextSize = paramContext.getDimensionPixelOffset(2131361910);
    this.mUnsettleEventNumTextColor = paramContext.getColor(2131165188);
    this.mUnsettleEventBgWidth = paramContext.getDimensionPixelOffset(2131361885);
    this.mUnsettleEventBgHeight = paramContext.getDimensionPixelOffset(2131361886);
    this.mUnsettleEventNumBg = Utilities.getUnsettleEventBackground(paramContext);
    initUnsettleEventTextPaint();
  }

  private void initUnsettleEventRect(int paramInt1, int paramInt2)
  {
    Object localObject;
    float f1;
    int k;
    if ((this.mUnsettleEventNumPaint != null) && (paramInt1 > 0))
    {
      TextPaint localTextPaint = this.mUnsettleEventNumPaint;
      if (paramInt1 <= 99)
        break label345;
      localObject = String.valueOf(100);
      f1 = localTextPaint.measureText((String)localObject);
      if (DEBUG_UNREAD)
        Log.d("UnreadLoaderDrawInfo", "initUnsettleEventRect --- numWidth = " + f1);
      k = this.mUnsettleEventBgHeight;
      if (f1 <= this.mUnsettleEventBgWidth - this.mUnsettleEventNumPadding * 2)
        break label354;
    }
    label345: label354: for (paramInt1 = (int)(this.mUnsettleEventNumPadding * 2 + f1); ; paramInt1 = k)
    {
      if (DEBUG_UNREAD)
        Log.d("UnreadLoaderDrawInfo", "initUnsettleEventRect --- bgWidth 2 = " + paramInt1);
      int j = paramInt2 - (paramInt2 - Utilities.getIconWidth()) / 2 - paramInt1 - this.mUnsettleEventBgRightPadding;
      int n = this.mUnsettleEventBgTopPadding;
      int m = j + paramInt1;
      int i = m;
      if (m >= paramInt2 - 8)
      {
        i = paramInt2 - 8;
        j = i - paramInt1;
      }
      this.mUnsettleEventNumBg.setBounds(j, n, i, n + k);
      localObject = this.mUnsettleEventNumPaint.getFontMetrics();
      float f2 = ((FontMetrics)localObject).bottom;
      float f3 = ((FontMetrics)localObject).top;
      f1 = k;
      f2 = (k - (f2 - f3)) / 2.0F;
      f3 = ((FontMetrics)localObject).bottom;
      this.mNumx = ((paramInt1 >> 1) + j);
      this.mNumy = (n + (f1 - f2 - f3) - 1.0F);
      if (DEBUG_UNREAD)
      {
        Log.d("UnreadLoaderDrawInfo", "initUnsettleEventRect --- mNumx = " + this.mNumx);
        Log.d("UnreadLoaderDrawInfo", "initUnsettleEventRect --- mNumy = " + this.mNumy);
      }
      return;
      localObject = String.valueOf(paramInt1);
      break;
    }
  }

  private void initUnsettleEventTextPaint()
  {
    if (this.mUnsettleEventNumPaint == null)
      this.mUnsettleEventNumPaint = new TextPaint();
    this.mUnsettleEventNumPaint.setAntiAlias(true);
    this.mUnsettleEventNumPaint.setTextAlign(Align.CENTER);
    this.mUnsettleEventNumPaint.setFakeBoldText(true);
    this.mUnsettleEventNumPaint.setTextSize(this.mUnsettleEventNumTextSize);
    this.mUnsettleEventNumPadding = ((int)(this.mUnsettleEventBgWidth - this.mUnsettleEventNumPaint.measureText("0")) / 2);
  }

  public void drawNum(Canvas paramCanvas, int paramInt, View paramView)
  {
    if (paramInt > 0)
    {
      if (DEBUG_UNREAD)
        Log.d("UnreadLoaderDrawInfo", "drawNum --- unreadNum = " + paramInt);
      initUnsettleEventRect(paramInt, paramView.getWidth());
      paramCanvas.save();
      paramCanvas.translate(paramView.getScrollX(), paramView.getScrollY());
      this.mUnsettleEventNumBg.draw(paramCanvas);
      this.mUnsettleEventNumPaint.setColor(this.mUnsettleEventNumTextColor);
      if (paramInt <= 99)
        break label148;
      paramCanvas.drawText(String.valueOf(99) + "+", this.mNumx, this.mNumy, this.mUnsettleEventNumPaint);
    }
    while (true)
    {
      paramCanvas.translate(-paramView.getScrollX(), -paramView.getScrollY());
      paramCanvas.restore();
      return;
      label148: paramCanvas.drawText(String.valueOf(paramInt), this.mNumx, this.mNumy, this.mUnsettleEventNumPaint);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.unreaderloader.UnreadLoaderDrawInfo
 * JD-Core Version:    0.6.2
 */