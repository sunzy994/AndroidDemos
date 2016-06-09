package cmcm.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ub extends Activity
{
  public void a(Intent paramIntent)
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(getIntent());
  }

  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ub
 * JD-Core Version:    0.6.2
 */