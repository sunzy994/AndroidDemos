package cmcm.com.myapplication.com.lazyswipe.features.theme.preview;

import ahr;
import ahw;
import android.graphics.Bitmap;
import asq;
import com.lazyswipe.SwipeService;
import java.util.List;

public class LocalThemeDetailFragment extends BaseThemeDetailFragment<ahw>
{
  private static final String f = "Swipe." + LocalThemeDetailFragment.class.getSimpleName();

  protected void a(int paramInt, Object paramObject, ThemePreviewItem paramThemePreviewItem)
  {
    if ((paramObject instanceof Bitmap))
      paramThemePreviewItem.a((Bitmap)paramObject, true);
  }

  public void a(ahw paramahw)
  {
    super.a(paramahw);
    if ((this.a instanceof ahr))
      ((ahr)this.a).b(false);
  }

  protected String b()
  {
    if (((ahw)this.a).L());
    for (int i = 2131231087; ; i = 2131231088)
      return getString(i);
  }

  protected void d()
  {
    SwipeService.a(getActivity(), ((ahw)this.a).g, true);
  }

  protected Bitmap f()
  {
    List localList = ((ahw)this.a).d();
    if (asq.a(localList))
      return null;
    return (Bitmap)localList.get(0);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.theme.preview.LocalThemeDetailFragment
 * JD-Core Version:    0.6.2
 */