package cmcm.com.myapplication.com.lazyswipe.features.theme.preview;

import aix;
import android.content.Context;
import android.content.Intent;

public class OnlineThemeDetailActivity extends aix<OnlineThemeEntity, OnlineThemeDetailFragment>
{
  public static void a(Context paramContext, OnlineThemeEntity paramOnlineThemeEntity)
  {
    Intent localIntent = new Intent(paramContext, OnlineThemeDetailActivity.class);
    localIntent.putExtra("bundle_theme", paramOnlineThemeEntity);
    paramContext.startActivity(localIntent);
  }

  protected OnlineThemeEntity i()
  {
    return (OnlineThemeEntity)getIntent().getParcelableExtra("bundle_theme");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.theme.preview.OnlineThemeDetailActivity
 * JD-Core Version:    0.6.2
 */