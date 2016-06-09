package cmcm.com.myapplication.com.hola.channel.sdk.game.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.Locale;
import qu;
import qy;
import rc;
import rq;
import tg;

public class HotGamesFragment extends rq
{
  protected void a(Bundle paramBundle, int paramInt)
  {
    super.a(paramBundle, paramInt);
    if (1 != paramInt);
    long l;
    do
    {
      return;
      l = qy.a(getActivity()).getLong(String.format(Locale.US, "key_list_updated_%1$d", new Object[] { Integer.valueOf(1) }), 0L);
    }
    while (System.currentTimeMillis() - l <= 86400000L);
    rc.b(getActivity());
  }

  protected int h()
  {
    return 1001;
  }

  protected String s()
  {
    return "game_list/hot";
  }

  protected String t()
  {
    if (qu.a(getActivity()))
      return "SELECT B._id, name, icon, brief, B.key, players, status, C.md5, CASE WHEN (B.md5)=(C.md5) THEN 1 ELSE 0 END AS md5_match , game_hide_down FROM game_list A LEFT JOIN game B ON A.key=B.key LEFT JOIN game_status C ON B.key=C.key WHERE A.list_type=? AND B.key NOT IN (SELECT key FROM v_game_log ORDER BY start_time DESC LIMIT ?) LIMIT ?";
    return "SELECT B._id, name, icon, brief, B.key, players, status, C.md5, CASE WHEN (B.md5)=(C.md5) THEN 1 ELSE 0 END AS md5_match , game_hide_down FROM game_list A LEFT JOIN game B ON A.key=B.key LEFT JOIN game_status C ON B.key=C.key WHERE A.list_type=? AND B.key NOT IN (SELECT key FROM v_game_log ORDER BY start_time DESC LIMIT ?) ORDER BY B.size ASC  LIMIT ?";
  }

  protected String[] u()
  {
    return new String[] { String.valueOf(1), String.valueOf(3), q() };
  }

  protected int v()
  {
    return tg.hola_game_recommended_hot;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.fragment.HotGamesFragment
 * JD-Core Version:    0.6.2
 */