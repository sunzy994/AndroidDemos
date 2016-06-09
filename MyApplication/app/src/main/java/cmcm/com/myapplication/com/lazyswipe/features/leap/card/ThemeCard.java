package cmcm.com.myapplication.com.lazyswipe.features.leap.card;

import adp;
import adt;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import ard;
import arj;
import arl;
import arq;
import arr;
import aru;
import asq;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.theme.preview.LocalThemeDetailActivity;
import org.json.JSONArray;
import org.json.JSONObject;
import vs;
import vw;
import vy;
import wd;
import we;
import yb;

public class ThemeCard extends adp
  implements OnClickListener
{
  private static final String h = "Swipe." + ThemeCard.class.getSimpleName();
  private static String i = "";
  private static String j = "";
  private ImageView k;
  private View l;

  public ThemeCard(Context paramContext)
  {
    super(paramContext);
  }

  public ThemeCard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static void h()
  {
    final SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (!arl.h(localSwipeApplication));
    final long l1;
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      l2 = vs.b();
    }
    while (((l2 > 0L) && (Math.abs(l2 - l1) < 43200000L)) || (l1 - aru.a(localSwipeApplication, "THEME_CARDS_LAST_TIME", -1L) < 86400000L));
    arj.a(wd.a, new we(localSwipeApplication)
    {
      public void a()
      {
        while (true)
        {
          try
          {
            aru.b(localSwipeApplication, "THEME_CARDS_LAST_TIME", l1);
            Object localObject = asq.b(asq.v(localSwipeApplication));
            localObject = "http://a.lazyswipe.cn//theme/recommend?" + (String)localObject;
            localObject = ard.a(localSwipeApplication, (String)localObject);
            if (((arq)localObject).a != arr.a)
              return;
            localObject = new JSONObject(((arq)localObject).c);
            if ((localObject == null) || (((JSONObject)localObject).optInt("statusCode") != 200))
              break;
            localObject = ((JSONObject)localObject).optJSONArray("results");
            if (localObject == null)
              break;
            if (((JSONArray)localObject).length() > 0)
            {
              localObject = ((JSONArray)localObject).optJSONObject(0).toString();
              aru.b(localSwipeApplication, "THEME_CARD", (String)localObject);
              ThemeCard.i();
              return;
            }
          }
          catch (Exception localException)
          {
            Log.e(ThemeCard.j(), "failed in fetchCloudBlackList.", localException);
            return;
          }
          aru.b(localSwipeApplication, "THEME_CARD", "");
        }
      }
    });
  }

  public static void i()
  {
    String str = aru.a(SwipeApplication.c(), "THEME_CARD", "");
    if (TextUtils.isEmpty(str))
    {
      i = "";
      j = "";
      return;
    }
    try
    {
      Object localObject = new JSONObject(str);
      str = ((JSONObject)localObject).optString("code");
      localObject = ((JSONObject)localObject).optString("url");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        i = str;
        j = (String)localObject;
      }
      Log.i(h, "loadFromLocal, sThemeKey = " + i + ",sThemeUrl = " + j);
      return;
    }
    catch (Exception localException)
    {
      Log.i(h, "loadFromLocal failed", localException);
    }
  }

  public void a(Object paramObject)
  {
    super.a(paramObject);
    this.l.setVisibility(8);
  }

  public void b()
  {
  }

  public void f()
  {
    super.f();
    this.l.setVisibility(0);
  }

  public int getBitmapReqHeight()
  {
    return c;
  }

  public int getBitmapReqWidth()
  {
    return b;
  }

  public String getBitmapUrl()
  {
    return j;
  }

  public ImageView getBitmapView()
  {
    return this.k;
  }

  public adt getCardHolder()
  {
    return new adt(this);
  }

  public void onClick(View paramView)
  {
    yb.p();
    LocalThemeDetailActivity.a(getContext(), i);
    vy.b(getContext(), "B37");
    vw.a(getContext(), "B37");
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.k = ((ImageView)findViewById(2131755075));
    setOnClickListener(this);
    this.l = findViewById(2131755103);
    this.l.setVisibility(8);
    this.l.setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ThemeCard.this.e != null)
          ThemeCard.this.a(ThemeCard.this.e);
      }
    });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.leap.card.ThemeCard
 * JD-Core Version:    0.6.2
 */