package cmcm.com.myapplication.com.lazyswipe.features.theme.preview;

import ahv;
import aji;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import aqx;
import aro;
import arv;
import arw;
import arx;
import asa;
import asb;
import asd;
import asq;
import atw;
import com.lazyswipe.ui.BaseFragment;
import com.lazyswipe.widget.GridGallery;
import java.io.File;
import java.util.List;
import vy;

public abstract class BaseThemeDetailFragment<T extends ahv> extends BaseFragment
  implements asb
{
  private static final String f = "Swipe." + BaseThemeDetailFragment.class.getSimpleName();
  private static int g = 0;
  protected T a;
  private File h;
  private GridGallery i;
  private TextView j;
  private aji k = new aji()
  {
    protected void a(Context paramAnonymousContext)
    {
      BaseThemeDetailFragment.c(BaseThemeDetailFragment.this).setText(BaseThemeDetailFragment.this.b());
    }
  };

  private void a(String paramString)
  {
    arv.a(getActivity(), paramString, 2131230950, new asd()
    {
      public String a(Context paramAnonymousContext, String paramAnonymousString)
      {
        return paramAnonymousContext.getString(2131231090);
      }

      public String a(Context paramAnonymousContext, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        return paramAnonymousContext.getString(2131231089);
      }
    }
    , null, this, false, new asa[0]);
  }

  private void m()
  {
    if (this.a == null)
      return;
    final LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
    this.i.setAdapter(new ArrayAdapter(getActivity(), 0, this.a.M())
    {
      public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        if (paramAnonymousView == null);
        for (paramAnonymousView = (ThemePreviewItem)localLayoutInflater.inflate(2130968750, BaseThemeDetailFragment.b(BaseThemeDetailFragment.this), false); ; paramAnonymousView = (ThemePreviewItem)paramAnonymousView)
        {
          paramAnonymousViewGroup = getItem(paramAnonymousInt);
          BaseThemeDetailFragment.this.a(paramAnonymousInt, paramAnonymousViewGroup, paramAnonymousView);
          return paramAnonymousView;
        }
      }
    });
  }

  protected int a()
  {
    return 2130968647;
  }

  protected abstract void a(int paramInt, Object paramObject, ThemePreviewItem paramThemePreviewItem);

  public void a(T paramT)
  {
    if (paramT == null)
      return;
    this.a = paramT;
    this.j.setAllCaps(true);
    this.j.setText(b());
    this.j.setBackgroundDrawable(asq.b(this.a.i()));
    this.j.setOnClickListener(this);
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        BaseThemeDetailFragment.this.c(BaseThemeDetailFragment.a(BaseThemeDetailFragment.this));
      }
    }
    , 500L);
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    this.i = ((GridGallery)a(paramView, 2131755267));
    this.j = ((TextView)a(paramView, 2131755269));
  }

  protected abstract String b();

  protected void b(View paramView)
  {
    if (paramView == this.j)
    {
      Log.i(f, "apply Theme: " + this.a.N());
      d();
      vy.a(getActivity(), "B25", this.a.N());
      return;
    }
    super.b(paramView);
  }

  protected void c(View paramView)
  {
    Object localObject = new arw(getActivity(), null, "android.intent.action.SEND", "image/*", new asa[0]);
    final arx localarx = (arx)((arw)localObject).a(0);
    if (localarx != null)
    {
      ((ImageView)paramView.findViewById(2131755512)).setImageDrawable(localarx.d);
      ((TextView)paramView.findViewById(2131755513)).setText(localarx.c);
      ((ImageView)paramView.findViewById(2131755512)).setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BaseThemeDetailFragment.a(BaseThemeDetailFragment.this, localarx.a.getPackageName());
        }
      });
      localObject = (arx)((arw)localObject).a(1);
      if (localObject == null)
        break label233;
      ((ImageView)paramView.findViewById(2131755514)).setImageDrawable(((arx)localObject).d);
      ((TextView)paramView.findViewById(2131755515)).setText(((arx)localObject).c);
      ((ImageView)paramView.findViewById(2131755514)).setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BaseThemeDetailFragment.a(BaseThemeDetailFragment.this, this.a.a.getPackageName());
        }
      });
    }
    while (true)
    {
      ((ImageView)paramView.findViewById(2131755516)).setImageResource(2130837807);
      ((TextView)paramView.findViewById(2131755517)).setText(2131230944);
      ((ImageView)paramView.findViewById(2131755516)).setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BaseThemeDetailFragment.a(BaseThemeDetailFragment.this, null);
        }
      });
      return;
      ((ImageView)paramView.findViewById(2131755512)).setVisibility(8);
      ((TextView)paramView.findViewById(2131755513)).setVisibility(8);
      break;
      label233: ((ImageView)paramView.findViewById(2131755514)).setVisibility(8);
      ((TextView)paramView.findViewById(2131755515)).setVisibility(8);
    }
  }

  protected boolean c()
  {
    return false;
  }

  protected abstract void d();

  public File e()
  {
    Bitmap localBitmap1 = f();
    if (!atw.b(localBitmap1))
      return null;
    if (this.h != null)
      aqx.e(this.h);
    String str = "theme_share_capture_" + g + ".jpg";
    g += 1;
    g %= 10;
    Bitmap localBitmap2 = atw.a(getActivity().getApplicationContext(), localBitmap1);
    atw.a(localBitmap2, str, CompressFormat.JPEG);
    this.h = new File(aro.d(), "files/" + str);
    if (localBitmap1 != localBitmap2)
      atw.a(localBitmap2);
    return this.h;
  }

  protected abstract Bitmap f();

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.k.c(getActivity());
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.i != null)
      this.i.setAdapter(null);
    this.k.d(getActivity());
  }

  public void onResume()
  {
    super.onResume();
    m();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.theme.preview.BaseThemeDetailFragment
 * JD-Core Version:    0.6.2
 */