package cmcm.com.myapplication.com.lazyswipe.features.theme.preview;

import aho;
import ahr;
import ahw;
import ajf;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import aro;
import atq;
import atr;
import att;
import atu;
import atw;
import com.lazyswipe.SwipeService;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vy;

public class OnlineThemeDetailFragment extends BaseThemeDetailFragment<OnlineThemeEntity>
  implements att, atu
{
  private static final String f = "Swipe." + OnlineThemeDetailFragment.class.getSimpleName();
  private atq g;
  private Map<String, SoftReference<Bitmap>> h;
  private final Handler i = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((OnlineThemeDetailFragment.this.getActivity() == null) || (OnlineThemeDetailFragment.this.getActivity().isFinishing()));
      do
      {
        return;
        switch (paramAnonymousMessage.what)
        {
        default:
          return;
        case 1:
        }
      }
      while (!(paramAnonymousMessage.obj instanceof ajf));
      OnlineThemeDetailFragment.a(OnlineThemeDetailFragment.this, (ajf)paramAnonymousMessage.obj);
    }
  };

  private void a(ajf paramajf)
  {
    if ((atw.b(paramajf.e)) && (paramajf.b == paramajf.c.getTag()))
      paramajf.c.a(paramajf.e, true);
  }

  private String m()
  {
    return new File(aro.c(), "themes").getAbsolutePath();
  }

  private void n()
  {
    if (this.h != null)
    {
      Iterator localIterator = this.h.values().iterator();
      while (localIterator.hasNext())
        atw.a((Bitmap)((SoftReference)localIterator.next()).get());
      this.h.clear();
    }
  }

  public Bitmap a(String paramString)
  {
    if (this.h == null);
    for (paramString = null; paramString == null; paramString = (SoftReference)this.h.get(paramString))
      return null;
    return (Bitmap)paramString.get();
  }

  protected void a(int paramInt, Object paramObject, ThemePreviewItem paramThemePreviewItem)
  {
    if (!(paramObject instanceof String))
      return;
    paramObject = (String)paramObject;
    paramThemePreviewItem.a(paramInt, paramObject);
    paramObject = this.g.a(new ajf(paramInt, paramThemePreviewItem, paramObject));
    if (paramObject != null)
    {
      paramThemePreviewItem.a(paramObject.e, true);
      return;
    }
    paramThemePreviewItem.a(null, false);
  }

  public void a(atr paramatr)
  {
    this.i.obtainMessage(1, paramatr).sendToTarget();
  }

  public void a(OnlineThemeEntity paramOnlineThemeEntity)
  {
    super.a(paramOnlineThemeEntity);
    if ((((OnlineThemeEntity)this.a).a() instanceof ahr))
      ((ahr)((OnlineThemeEntity)this.a).a()).b(false);
  }

  protected String b()
  {
    ahw localahw = ((OnlineThemeEntity)this.a).a();
    int j = 2131231088;
    if (localahw.L())
      j = 2131231087;
    while (true)
    {
      return getString(j);
      if (!localahw.e())
        if ((localahw instanceof aho))
          j = 2131230942;
        else
          j = 2131230905;
    }
  }

  public void b(atr paramatr)
  {
  }

  public void c(atr paramatr)
  {
    if (this.h == null)
      this.h = new HashMap();
    this.h.put(paramatr.a(), new SoftReference(paramatr.e));
  }

  protected void d()
  {
    if (!((OnlineThemeEntity)this.a).a().e())
      vy.a(getActivity(), "B56", ((OnlineThemeEntity)this.a).N());
    SwipeService.a(getActivity(), ((OnlineThemeEntity)this.a).N(), true, ((OnlineThemeEntity)this.a).K(), ((OnlineThemeEntity)this.a).l, ((OnlineThemeEntity)this.a).g());
  }

  protected Bitmap f()
  {
    if ((this.h == null) || (this.h.isEmpty()));
    do
    {
      return null;
      localObject = ((OnlineThemeEntity)this.a).M();
    }
    while ((localObject == null) || (((List)localObject).size() < 1));
    Object localObject = (String)((List)localObject).get(0);
    localObject = (SoftReference)this.h.get(localObject);
    if (localObject == null);
    for (localObject = null; ; localObject = (Bitmap)((SoftReference)localObject).get())
      return localObject;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = atq.a(getActivity(), m(), this);
    this.g.a(this);
  }

  public void onDestroy()
  {
    super.onDestroy();
    n();
    atq.a(this.g);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.theme.preview.OnlineThemeDetailFragment
 * JD-Core Version:    0.6.2
 */