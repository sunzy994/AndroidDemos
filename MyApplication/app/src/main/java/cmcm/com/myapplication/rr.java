package cmcm.com.myapplication;

import android.content.Context;
import android.database.Cursor;
import com.hola.channel.sdk.game.fragment.GameListFragment;

public class rr extends ra
{
  public rr(GameListFragment paramGameListFragment, Context paramContext, Cursor paramCursor)
  {
    super(paramGameListFragment, paramContext, paramCursor);
  }

  public int getItemViewType(int paramInt)
  {
    int i = 2;
    if (GameListFragment.a(this.b) >= 1000)
    {
      int j = paramInt % 10;
      if (j > 2)
        paramInt = 0;
      do
      {
        return paramInt;
        if (paramInt / 10 >= this.b.s)
          break;
        paramInt = i;
      }
      while (j != 0);
      return 1;
      return 0;
    }
    return 0;
  }

  public int getViewTypeCount()
  {
    if (GameListFragment.a(this.b) >= 1000)
      return 3;
    return 1;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rr
 * JD-Core Version:    0.6.2
 */