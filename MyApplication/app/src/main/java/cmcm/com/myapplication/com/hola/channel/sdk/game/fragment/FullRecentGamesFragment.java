package cmcm.com.myapplication.com.hola.channel.sdk.game.fragment;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Space;
import com.hola.channel.sdk.game.app.CursorLoaderFragment;
import com.hola.channel.sdk.game.widget.HorizontalGameItem;
import qs;
import rd;
import re;
import tf;

public class FullRecentGamesFragment extends CursorLoaderFragment
  implements re
{
  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return HorizontalGameItem.a(paramContext, paramViewGroup);
  }

  protected rd a(int paramInt, Bundle paramBundle)
  {
    return new rd(getActivity(), "game_log", "SELECT B._id, name, icon, brief, B.key, players, status, C.md5, CASE WHEN (B.md5)=(C.md5) THEN 1 ELSE 0 END AS md5_match FROM v_game_log A LEFT JOIN game B ON A.key=B.key LEFT JOIN game_status C ON B.key=C.key WHERE B._id IS NOT NULL ORDER BY start_time DESC", null, this);
  }

  public void a()
  {
  }

  protected void a(Cursor paramCursor)
  {
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = new FrameLayout(getActivity());
    paramView.addView(new Space(getActivity()), 1, qs.a(getActivity(), 13.3F));
    this.d.addHeaderView(paramView);
  }

  public void a(View paramView, Context paramContext, Cursor paramCursor)
  {
    ((HorizontalGameItem)paramView).a(paramCursor);
  }

  public void a_()
  {
  }

  protected int b()
  {
    return tf.hola_game_list;
  }

  protected int b(Cursor paramCursor)
  {
    return 0;
  }

  protected int c(Cursor paramCursor)
  {
    return 0;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.fragment.FullRecentGamesFragment
 * JD-Core Version:    0.6.2
 */