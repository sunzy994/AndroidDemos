package cmcm.com.myapplication.com.lazyswipe.features.allapps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AppsListItem extends LinearLayout
{
  public View a;
  public TextView b;
  public LinearLayout c;
  public AppsListAppIcon[] d;
  private boolean e;

  public AppsListItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a(int paramInt)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    AppsListAppIcon[] arrayOfAppsListAppIcon = new AppsListAppIcon[paramInt];
    if (paramInt < this.d.length)
    {
      System.arraycopy(this.d, 0, arrayOfAppsListAppIcon, 0, paramInt);
      while (paramInt < this.d.length)
      {
        this.c.removeView(this.d[paramInt]);
        paramInt += 1;
      }
    }
    System.arraycopy(this.d, 0, arrayOfAppsListAppIcon, 0, this.d.length);
    int i = this.d.length;
    while (i < paramInt)
    {
      AppsListAppIcon localAppsListAppIcon = (AppsListAppIcon)localLayoutInflater.inflate(2130968593, this.c, false);
      this.c.addView(localAppsListAppIcon);
      arrayOfAppsListAppIcon[i] = localAppsListAppIcon;
      i += 1;
    }
    this.d = arrayOfAppsListAppIcon;
  }

  public void a(boolean paramBoolean, String paramString)
  {
    if (paramString != null)
    {
      this.b.setText(paramString);
      this.b.setVisibility(0);
      this.a.setVisibility(0);
      this.e = true;
      return;
    }
    this.b.setText("");
    this.b.setVisibility(4);
    this.a.setVisibility(8);
    this.e = false;
  }

  public boolean a()
  {
    return this.e;
  }

  public void b()
  {
    this.b.setVisibility(4);
  }

  public void c()
  {
    if (this.e)
      this.b.setVisibility(0);
  }

  public View getBodyView()
  {
    return this.c;
  }

  public AppsListAppIcon[] getBodyViews()
  {
    return this.d;
  }

  public int getRealTop()
  {
    return getTop();
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(2131755085);
    this.c = ((LinearLayout)findViewById(2131755086));
    int j = this.c.getChildCount();
    this.d = new AppsListAppIcon[j];
    int i = 0;
    while (i < j)
    {
      this.d[i] = ((AppsListAppIcon)this.c.getChildAt(i));
      i += 1;
    }
    FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(getContext()).inflate(2130968591, this.c, false);
    this.c.addView(localFrameLayout);
    this.b = ((TextView)localFrameLayout.findViewById(2131755084));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.allapps.AppsListItem
 * JD-Core Version:    0.6.2
 */