package cmcm.com.myapplication.com.lazyswipe.fan.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import asq;

public class ContactChoosePanel$ExtraScrollOffsetListView extends ListView
{
  public ContactChoosePanel$ExtraScrollOffsetListView(Context paramContext)
  {
    super(paramContext);
  }

  public ContactChoosePanel$ExtraScrollOffsetListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected int computeVerticalScrollOffset()
  {
    if (getHeight() == 0);
    for (int i = 0; ; i = (int)(asq.a(18.0F) * 1.0F * super.computeVerticalScrollRange() / getHeight()))
      return i + super.computeVerticalScrollOffset();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.friend.ContactChoosePanel.ExtraScrollOffsetListView
 * JD-Core Version:    0.6.2
 */