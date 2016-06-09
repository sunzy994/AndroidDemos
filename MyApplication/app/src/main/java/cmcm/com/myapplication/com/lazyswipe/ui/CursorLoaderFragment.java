package cmcm.com.myapplication.com.lazyswipe.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;

public abstract class CursorLoaderFragment extends LoaderFragment<Cursor>
{
  private static final String g = "Swipe." + CursorLoaderFragment.class.getSimpleName();
  private CursorAdapter h;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public void onDestroy()
  {
    if (this.h != null)
    {
      this.h.swapCursor(null);
      this.h = null;
    }
    super.onDestroy();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.CursorLoaderFragment
 * JD-Core Version:    0.6.2
 */