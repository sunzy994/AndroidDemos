package cmcm.com.myapplication.com.lazyswipe.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import awg;
import awi;
import awp;
import awq;

public class Toolbar extends LinearLayout
  implements OnClickListener, awq
{
  private View a;
  private TextView b;
  private ImageView c;
  private TextView d;
  private OverflowImageView e;
  private awi f;
  private awg g;

  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }

  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  private void a(Drawable paramDrawable)
  {
    if ((paramDrawable != null) && (this.c.getVisibility() != 0))
      this.c.setVisibility(0);
    e();
  }

  private void e()
  {
    if ((this.c.getVisibility() == 0) || (this.b.getVisibility() == 0))
      this.a.setOnClickListener(this);
  }

  public void a()
  {
    if (this.f != null)
      this.f.c();
  }

  public void a(Drawable paramDrawable, CharSequence paramCharSequence)
  {
    int j = 1;
    int i;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.d.setText(paramCharSequence);
      i = j;
      if (paramDrawable != null)
      {
        this.d.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramDrawable);
        i = j;
      }
    }
    while (true)
    {
      if ((i != 0) && (this.d.getVisibility() != 0))
        this.d.setVisibility(0);
      return;
      if (paramDrawable != null)
      {
        this.d.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
        i = j;
      }
      else
      {
        i = 0;
      }
    }
  }

  public boolean a(awp paramawp)
  {
    return (this.g != null) && (this.g.a(paramawp));
  }

  public void b()
  {
    if (this.f != null)
      this.f.d();
  }

  public void c()
  {
    this.e.setUnread(true);
  }

  public void d()
  {
    this.e.setUnread(false);
  }

  public TextView getActionView()
  {
    return this.d;
  }

  public awi getPopupMenu()
  {
    return this.f;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131755217:
    case 2131755063:
      do
      {
        do
          return;
        while (this.g == null);
        this.g.onActionClick(paramView);
        return;
      }
      while (this.g == null);
      this.g.onTitleClick(paramView);
      return;
    case 2131755518:
    }
    a();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((TextView)findViewById(2131755217));
    this.b = ((TextView)findViewById(2131755050));
    this.c = ((ImageView)findViewById(2131755064));
    this.e = ((OverflowImageView)findViewById(2131755518));
    this.a = findViewById(2131755063);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }

  public void setActionDrawable(int paramInt)
  {
    setActionDrawable(getResources().getDrawable(paramInt));
  }

  public void setActionDrawable(Drawable paramDrawable)
  {
    a(paramDrawable, null);
  }

  public void setActionTitle(int paramInt)
  {
    setActionTitle(getResources().getText(paramInt));
  }

  public void setActionTitle(CharSequence paramCharSequence)
  {
    a(null, paramCharSequence);
  }

  public void setButtonBackground(int paramInt)
  {
    this.a.setBackgroundResource(paramInt);
    this.d.setBackgroundResource(paramInt);
    this.e.setBackgroundResource(paramInt);
  }

  public void setCallback(awg paramawg)
  {
    this.g = paramawg;
  }

  public void setIcon(int paramInt)
  {
    if (paramInt > 0);
    for (Drawable localDrawable = getResources().getDrawable(paramInt); ; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }

  public void setIcon(Bitmap paramBitmap)
  {
    this.c.setImageBitmap(paramBitmap);
    a(this.c.getDrawable());
  }

  public void setIcon(Drawable paramDrawable)
  {
    this.c.setImageDrawable(paramDrawable);
    a(paramDrawable);
  }

  public void setMenu(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.e.getVisibility() != 0)
        this.e.setVisibility(0);
      if (this.f == null)
      {
        this.f = new awi(getContext(), new Handler(), this.e);
        this.f.a(paramInt);
        this.f.a(this);
      }
    }
  }

  public void setTitle(int paramInt)
  {
    setTitle(getResources().getText(paramInt));
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.b.getVisibility() != 0))
    {
      this.b.setVisibility(0);
      e();
    }
  }

  public void setTitleColor(int paramInt)
  {
    this.b.setTextColor(paramInt);
  }

  public void setTitleColor(String paramString)
  {
    setTitleColor(Color.parseColor(paramString));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.Toolbar
 * JD-Core Version:    0.6.2
 */