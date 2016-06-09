package com.oppo.launcher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabWidget;

public class FocusOnlyTabWidget extends TabWidget
{
  public FocusOnlyTabWidget(Context paramContext)
  {
    super(paramContext);
  }

  public FocusOnlyTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public FocusOnlyTabWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public int getChildTabIndex(View paramView)
  {
    int j = getTabCount();
    int i = 0;
    while (i < j)
    {
      if (getChildTabViewAt(i) == paramView)
        return i;
      i += 1;
    }
    return -1;
  }

  public View getSelectedTab()
  {
    int j = getTabCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildTabViewAt(i);
      if (localView.isSelected())
        return localView;
      i += 1;
    }
    return null;
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramView == this) && (paramBoolean) && (getTabCount() > 0))
      getSelectedTab().requestFocus();
  }

  public void setCurrentTabToFocusedTab()
  {
    Object localObject2 = null;
    int k = -1;
    int m = getTabCount();
    int i = 0;
    while (true)
    {
      int j = k;
      Object localObject1 = localObject2;
      if (i < m)
      {
        localObject1 = getChildTabViewAt(i);
        if (((View)localObject1).hasFocus())
          j = i;
      }
      else
      {
        if (j > -1)
        {
          super.setCurrentTab(j);
          super.onFocusChange((View)localObject1, true);
        }
        return;
      }
      i += 1;
    }
  }

  public void superOnFocusChange(View paramView, boolean paramBoolean)
  {
    super.onFocusChange(paramView, paramBoolean);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.FocusOnlyTabWidget
 * JD-Core Version:    0.6.2
 */