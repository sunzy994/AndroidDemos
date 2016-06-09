package cmcm.com.myapplication.com.lazyswipe.features.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import aph;
import asq;
import vj;
import vy;

public class SearchWebActivity extends aph
  implements PopupWindow.OnDismissListener
{
  private SearchPopupView i;

  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
      vy.a(paramContext, "CJ", String.valueOf(paramInt));
    Intent localIntent = new Intent(paramContext, SearchWebActivity.class);
    localIntent.putExtra("from", paramInt);
    localIntent.putExtra("query", paramString);
    if (paramInt == 3)
      localIntent.addFlags(67108864);
    asq.d(paramContext, localIntent);
  }

  private static SearchPopupView b(Activity paramActivity, FrameLayout paramFrameLayout, int paramInt, String paramString)
  {
    if ((paramActivity != null) && (paramActivity.isFinishing()))
      return null;
    paramActivity = (SearchPopupView)LayoutInflater.from(paramFrameLayout.getContext()).inflate(2130968738, null);
    paramActivity.a();
    paramFrameLayout.addView(paramActivity, new FrameLayout.LayoutParams(-1, -1, 80));
    if (TextUtils.isEmpty(paramString))
    {
      paramActivity.a(paramInt, null, true);
      return paramActivity;
    }
    paramActivity.a(paramInt, paramString, true);
    return paramActivity;
  }

  public void onBackPressed()
  {
    if ((this.i != null) && (this.i.b()))
      return;
    super.onBackPressed();
  }

  protected void onCreate(final Bundle paramBundle)
  {
    asq.a(this);
    super.onCreate(paramBundle);
    final int j = getIntent().getIntExtra("from", 7);
    paramBundle = getIntent().getStringExtra("query");
    final FrameLayout localFrameLayout = new FrameLayout(this);
    localFrameLayout.setBackgroundColor(-16777216);
    setContentView(localFrameLayout, new ViewGroup.LayoutParams(-1, -1));
    new Handler().post(new Runnable()
    {
      public void run()
      {
        SearchWebActivity.a(SearchWebActivity.this, SearchWebActivity.a(SearchWebActivity.this, localFrameLayout, j, paramBundle));
        if (SearchWebActivity.a(SearchWebActivity.this) != null)
          SearchWebActivity.a(SearchWebActivity.this).setPadding(0, 0, 0, vj.m);
      }
    });
    asq.b(this);
  }

  public void onDismiss()
  {
    onBackPressed();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.search.SearchWebActivity
 * JD-Core Version:    0.6.2
 */