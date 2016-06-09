package cmcm.com.myapplication.com.lazyswipe.features.theme.preview;

import ahw;
import ahx;
import aix;
import android.content.Context;
import android.content.Intent;

public class LocalThemeDetailActivity extends aix<ahw, LocalThemeDetailFragment>
{
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, LocalThemeDetailActivity.class);
    localIntent.putExtra("bundle_theme", paramString);
    paramContext.startActivity(localIntent);
  }

  protected ahw i()
  {
    return ahx.a(this, getIntent().getStringExtra("bundle_theme"), null);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.theme.preview.LocalThemeDetailActivity
 * JD-Core Version:    0.6.2
 */