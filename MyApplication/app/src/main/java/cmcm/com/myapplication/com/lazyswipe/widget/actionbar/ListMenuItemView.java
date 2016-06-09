package cmcm.com.myapplication.com.lazyswipe.widget.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import awr;
import awx;

public class ListMenuItemView extends LinearLayout
  implements awx
{
  private awr a;
  private ImageView b;
  private TextView c;
  private ImageView d;
  private Drawable e;
  private final int f = -1;

  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a(awr paramawr)
  {
    this.a = paramawr;
    if (paramawr.i());
    for (int i = 0; ; i = 8)
    {
      setVisibility(i);
      a(paramawr.a(this), paramawr.k());
      setIcon(paramawr.h());
      setEnabled(paramawr.d());
      setIndicator(paramawr.g());
      return;
    }
  }

  public void a(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence != null)
    {
      this.c.setText(paramCharSequence);
      if (this.c.getVisibility() != 0)
        this.c.setVisibility(0);
    }
    while (this.c.getVisibility() == 8)
      return;
    this.c.setVisibility(8);
  }

  public boolean a()
  {
    return false;
  }

  public awr getItemData()
  {
    return this.a;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setBackgroundDrawable(this.e);
    this.c = ((TextView)findViewById(2131755050));
    this.b = ((ImageView)findViewById(2131755064));
    this.d = ((ImageView)findViewById(2131755057));
  }

  public void setIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.b.setImageDrawable(paramDrawable);
      if (this.b.getVisibility() != 0)
        this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }

  public void setIndicator(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.d.setImageDrawable(paramDrawable);
      if (this.d.getVisibility() != 0)
        this.d.setVisibility(0);
      return;
    }
    this.d.setVisibility(8);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.actionbar.ListMenuItemView
 * JD-Core Version:    0.6.2
 */