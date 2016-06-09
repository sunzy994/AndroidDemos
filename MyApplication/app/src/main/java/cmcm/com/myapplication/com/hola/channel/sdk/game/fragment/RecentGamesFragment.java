package cmcm.com.myapplication.com.hola.channel.sdk.game.fragment;

import rq;
import tg;

public class RecentGamesFragment extends rq
{
  int c(int paramInt)
  {
    return 0;
  }

  protected int h()
  {
    return 1000;
  }

  int n()
  {
    return 1;
  }

  protected String s()
  {
    return "game_log";
  }

  protected String t()
  {
    return "SELECT B._id, name, icon, brief, B.key, players, status, C.md5, CASE WHEN (B.md5)=(C.md5) THEN 1 ELSE 0 END AS md5_match FROM v_game_log A LEFT JOIN game B ON A.key=B.key LEFT JOIN game_status C ON B.key=C.key WHERE B._id IS NOT NULL ORDER BY start_time DESC LIMIT ?";
  }

  protected String[] u()
  {
    return new String[] { q() };
  }

  protected int v()
  {
    return tg.hola_game_recommended_recents;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.fragment.RecentGamesFragment
 * JD-Core Version:    0.6.2
 */