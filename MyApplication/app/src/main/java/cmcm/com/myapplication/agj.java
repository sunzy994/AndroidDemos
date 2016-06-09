package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.lazyswipe.features.search.SearchPopupView;
import java.util.List;

public abstract class agj<T extends ahk> extends LinearLayout
{
  protected SearchPopupView a;
  protected List<T> b;
  protected int c;
  protected View d;
  protected TextView e;
  protected int f;
  private agj<T>.agl g;
  private final Handler h = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 1:
      }
      agj.this.b = ((List)paramAnonymousMessage.obj);
      agj.this.f();
    }
  };

  public agj(Context paramContext)
  {
    this(paramContext, (AttributeSet)null);
    b();
  }

  public agj(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }

  public agj(Context paramContext, String paramString)
  {
    this(paramContext);
    if ((this.d == null) && (!TextUtils.isEmpty(paramString)))
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setPadding(asq.a(16.0F), 0, asq.a(16.0F), 0);
      localLinearLayout.setOrientation(1);
      RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
      Object localObject = a(paramContext, 16.0F, null);
      ((TextView)localObject).setPadding(0, asq.a(10.0F), 0, asq.a(10.0F));
      ((TextView)localObject).setTextColor(-13881554);
      ((TextView)localObject).setText(paramString);
      paramString = new RelativeLayout.LayoutParams(-2, -2);
      paramString.addRule(9, 1);
      paramString.addRule(15, 1);
      ((TextView)localObject).setLayoutParams(paramString);
      localRelativeLayout.addView((View)localObject);
      paramString = getTitleActionView();
      if (paramString != null)
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = asq.a(11.0F);
        paramString.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localRelativeLayout.addView(paramString);
      }
      localLinearLayout.addView(localRelativeLayout, new LayoutParams(-1, -2));
      paramContext = new View(paramContext);
      paramContext.setBackgroundColor(-2565928);
      localLinearLayout.addView(paramContext, new LayoutParams(-1, 1));
      localLinearLayout.setLayoutParams(new LayoutParams(-1, -2));
      this.d = localLinearLayout;
    }
  }

  private void a(Context paramContext, LinearLayout paramLinearLayout, int paramInt)
  {
    paramContext = new View(paramContext);
    paramContext.setBackgroundColor(-2565928);
    paramLinearLayout.addView(paramContext, paramInt, new LayoutParams(-1, 1));
  }

  private void a(List<T> paramList)
  {
    Message.obtain(this.h, 1, paramList).sendToTarget();
  }

  protected abstract View a(int paramInt);

  protected TextView a(Context paramContext, float paramFloat, Drawable paramDrawable)
  {
    paramContext = new TextView(paramContext);
    paramContext.setGravity(19);
    paramContext.setPadding(this.f, 0, this.f, 0);
    paramContext.setBackgroundDrawable(paramDrawable);
    paramContext.setTextSize(2, paramFloat);
    return paramContext;
  }

  protected abstract List<T> a(String paramString, agk paramagk);

  public void a()
  {
    removeAllViews();
    if (this.d != null)
      addView(this.d, this.d.getLayoutParams());
  }

  protected void a(Context paramContext)
  {
    a(paramContext, this, getChildCount());
  }

  public void a(String paramString)
  {
    if (this.g != null)
      this.g.a(true);
    this.c = 0;
    if (!c())
    {
      paramString = a(paramString, new agk()
      {
        public boolean a()
        {
          return false;
        }
      });
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        this.b = paramString;
        f();
        return;
      }
      a(paramString);
      return;
    }
    this.g = new agl(this, paramString);
    this.g.start();
  }

  protected void b()
  {
    setBackgroundColor(-1);
    this.f = asq.a(24.0F);
    LayoutParams localLayoutParams = new LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, asq.a(8.0F), 0, 0);
    setLayoutParams(localLayoutParams);
    setOrientation(1);
  }

  protected boolean c()
  {
    return true;
  }

  protected boolean d()
  {
    return true;
  }

  protected boolean e()
  {
    return true;
  }

  protected void f()
  {
    if (getTotalItemCount() == 0)
      setVisibility(8);
    Object localObject;
    do
    {
      return;
      setVisibility(0);
      a();
      int j = getTotalItemCount();
      if (d());
      for (int i = getInitPageSize(); ; i = getTotalItemCount())
      {
        j = Math.min(j, i);
        i = 0;
        while (i < j)
        {
          if (this.c == 0)
          {
            localObject = getContentTopEdgeView();
            if (localObject != null)
              addView((View)localObject);
          }
          localObject = a(i);
          if (localObject == null)
            break;
          if ((e()) && (getChildCount() > 1))
            a(getContext());
          addView((View)localObject);
          this.c += 1;
          i += 1;
        }
      }
      if ((d()) && (getTotalItemCount() > this.c));
      localObject = getContentBottomEdgeView();
      if (localObject != null)
        addView((View)localObject);
    }
    while (TextUtils.isEmpty(getBottomText()));
    if (this.e == null)
    {
      localObject = a(getContext(), 10.0F, null);
      ((TextView)localObject).setTextColor(-13881554);
      LayoutParams localLayoutParams = new LayoutParams(-1, asq.a(20.0F));
      localLayoutParams.gravity = 16;
      ((TextView)localObject).setGravity(5);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      ((TextView)localObject).setText(getBottomText());
      this.e = ((TextView)localObject);
    }
    this.e.setText(getBottomText());
    addView(this.e);
  }

  protected String getBottomText()
  {
    return null;
  }

  protected View getContentBottomEdgeView()
  {
    return null;
  }

  protected View getContentTopEdgeView()
  {
    return null;
  }

  protected int getInitPageSize()
  {
    return 10;
  }

  protected int getNextPageSize()
  {
    return 10;
  }

  protected Drawable getNormalTransparentDrawable()
  {
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#32FFFFFF"));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localColorDrawable);
    return localStateListDrawable;
  }

  protected View getTitleActionView()
  {
    return null;
  }

  protected int getTotalItemCount()
  {
    if (this.b == null)
      return 0;
    return this.b.size();
  }

  public void setCallback(SearchPopupView paramSearchPopupView)
  {
    this.a = paramSearchPopupView;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agj
 * JD-Core Version:    0.6.2
 */