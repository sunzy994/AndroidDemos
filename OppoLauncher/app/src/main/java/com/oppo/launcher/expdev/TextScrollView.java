package com.oppo.launcher.expdev;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class TextScrollView extends TextView
{
  public TextScrollView(Context paramContext)
  {
    super(paramContext);
  }

  public TextScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public TextScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isFocused())
      requestFocus();
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setEnabled(boolean paramBoolean)
  {
    if (!paramBoolean)
      requestFocus();
    super.setEnabled(paramBoolean);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.expdev.TextScrollView
 * JD-Core Version:    0.6.2
 */