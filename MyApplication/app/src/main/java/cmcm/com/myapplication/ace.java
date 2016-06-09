package cmcm.com.myapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import com.lazyswipe.features.allapps.AppsContentView;
import java.util.List;

public class ace extends AsyncTask<String, String, List<ach>>
{
  private boolean b;

  private ace(AppsContentView paramAppsContentView)
  {
  }

  private List<ach> a(String paramString)
  {
    paramString = AppsContentView.a(this.a);
    AppsContentView.b(this.a);
    return paramString;
  }

  protected List<ach> a(String[] paramArrayOfString)
  {
    return a(paramArrayOfString[0].toLowerCase());
  }

  public void a()
  {
    cancel(true);
    this.b = true;
  }

  protected void a(List<ach> paramList)
  {
    if (AppsContentView.c(this.a) != null)
    {
      aqt.a(AppsContentView.c(this.a), this.a.getContext());
      AppsContentView.a(this.a, null);
    }
    AppsContentView.d(this.a).setVisibility(0);
    if (((this.a.getContext() instanceof Activity)) && (((Activity)this.a.getContext()).isFinishing()));
    while (this.b)
      return;
    AppsContentView.a(this.a, paramList);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ace
 * JD-Core Version:    0.6.2
 */