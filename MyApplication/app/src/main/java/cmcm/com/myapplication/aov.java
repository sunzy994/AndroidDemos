package cmcm.com.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

@SuppressLint({"Registered"})
public class aov extends m
{
  public final <T extends View> T b(int paramInt)
  {
    return findViewById(paramInt);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vv.a().a(this);
  }

  public void onDestroy()
  {
    super.onDestroy();
    vv.a().b(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aov
 * JD-Core Version:    0.6.2
 */