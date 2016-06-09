package cmcm.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.os.Bundle;

public abstract class apc extends Activity
{
  public abstract Intent a();

  public abstract int b();

  public abstract int c();

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getAction().equals("android.intent.action.CREATE_SHORTCUT"))
    {
      paramBundle = new Intent();
      paramBundle.putExtra("android.intent.extra.shortcut.NAME", getString(b()));
      paramBundle.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(this, c()));
      paramBundle.putExtra("android.intent.extra.shortcut.INTENT", a().putExtra("extra.SHORTCUT_LAUNCH", true));
      setResult(-1, paramBundle);
    }
    finish();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apc
 * JD-Core Version:    0.6.2
 */