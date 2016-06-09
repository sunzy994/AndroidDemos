package cmcm.com.myapplication.com.hola.channel.sdk.game.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.hola.channel.sdk.game.fragment.FullRecentGamesFragment;
import com.hola.channel.sdk.game.fragment.GameListFragment;
import qf;
import qx;
import te;
import tf;
import tg;

public class GameListActivity extends BaseGameActivity
{
  protected int a()
  {
    return tf.hola_game_activity_game_list;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    TextView localTextView = (TextView)qx.a(this, te.hg_title);
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("extra.TYPE", 1);
    if (3 != i)
      qf.a(this, "GC5", i);
    int j = paramBundle.getIntExtra("extra.CODE", 0);
    if (4 == i);
    for (Object localObject = new FullRecentGamesFragment(); ; localObject = GameListFragment.a(i, j))
      switch (i)
      {
      default:
        finish();
        return;
      case 1:
      case 2:
      case 3:
      case 4:
      }
    paramBundle = getString(tg.hola_game_recommended_hot);
    while (true)
    {
      setTitle(paramBundle);
      localTextView.setText(paramBundle);
      getFragmentManager().beginTransaction().add(te.hg_fragment_container, (Fragment)localObject).commitAllowingStateLoss();
      return;
      paramBundle = getString(tg.hola_game_recommended_new);
      continue;
      paramBundle = paramBundle.getStringExtra("extra.NAME");
      qf.a(this, "GC6", j);
      continue;
      paramBundle = getString(tg.hola_game_recommended_recents);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.activity.GameListActivity
 * JD-Core Version:    0.6.2
 */