package cmcm.com.myapplication.com.hola.channel.sdk.game.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import tb;
import tg;
import tk;
import tm;

public class BaseGameActivity$ProgressDialogFragment extends DialogFragment
{
  public static Dialog a(Activity paramActivity)
  {
    return new tm(paramActivity).j(tb.hola_game_main_color).g(tg.hola_game_loading_runtime).c(false).b(false).a();
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return a(getActivity());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.activity.BaseGameActivity.ProgressDialogFragment
 * JD-Core Version:    0.6.2
 */