package com.oppo.launcher;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class IconKeyEventListener
  implements OnKeyListener
{
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    return FocusHelper.handleIconKeyEvent(paramView, paramInt, paramKeyEvent);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.IconKeyEventListener
 * JD-Core Version:    0.6.2
 */