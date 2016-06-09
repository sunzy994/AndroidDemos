package cmcm.com.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import com.hola.channel.sdk.game.app.CursorLoaderFragment;

public class ra extends CursorAdapter
{
  private boolean b;
  private int c;

  public ra(CursorLoaderFragment paramCursorLoaderFragment, Context paramContext, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
  }

  public ra(CursorLoaderFragment paramCursorLoaderFragment, Context paramContext, Cursor paramCursor, boolean paramBoolean, int paramInt)
  {
    super(paramContext, paramCursor);
    this.b = paramBoolean;
    this.c = paramInt;
  }

  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    this.a.a(paramView, paramContext, paramCursor);
  }

  public int getCount()
  {
    int j = super.getCount();
    int i = j;
    if (this.b)
    {
      i = j;
      if (j > this.c)
        i = j - 1;
    }
    return i;
  }

  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.a.a(paramContext, paramCursor, paramViewGroup);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ra
 * JD-Core Version:    0.6.2
 */