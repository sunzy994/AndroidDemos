package cmcm.com.myapplication.com.lazyswipe.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import avl;
import avp;
import vl;

public class HorizontalGridList extends RelativeLayout
  implements avl
{
  private static final String b = "Swipe." + HorizontalGridList.class.getSimpleName();
  protected ScrollIndicator a;
  private GridGallery c;
  private View.OnClickListener d;
  private int e;
  private int f;

  public HorizontalGridList(Context paramContext)
  {
    this(paramContext, null);
  }

  public HorizontalGridList(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public HorizontalGridList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    int i = getResources().getInteger(2131361793);
    int j = getResources().getInteger(2131361792);
    Context localContext = null;
    try
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, vl.HorizontalGridList, paramInt, 0);
      localContext = paramContext;
      this.e = paramContext.getInt(0, i);
      localContext = paramContext;
      this.f = paramContext.getInt(1, j);
      if (paramContext != null)
        paramContext.recycle();
      if (this.e < 1)
        this.e = i;
      if (this.f < 1)
        this.f = j;
      return;
    }
    finally
    {
      if (localContext != null)
        localContext.recycle();
    }
    throw paramContext;
  }

  private int getCountPerPage()
  {
    return this.e * this.f;
  }

  public void a()
  {
    this.c.getAdapter().notifyDataSetChanged();
  }

  public void a(int paramInt)
  {
  }

  public void a(avp paramavp, int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    setAdapter(paramavp);
  }

  public void b(int paramInt)
  {
    this.a.setSelected(paramInt);
  }

  public GridGallery getGridGallery()
  {
    return this.c;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((GridGallery)findViewById(2131755367));
    this.a = ((ScrollIndicator)findViewById(2131755368));
    this.a.a(0);
    this.a.setSelected(0);
    this.c.setOnScreenSwitchedListener(this);
  }

  public void setAdapter(avp paramavp)
  {
    this.c.setAdapter(paramavp);
    this.a.a(paramavp.b());
    this.a.setSelected(0);
  }

  public void setOnItemClickListener(View.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.HorizontalGridList
 * JD-Core Version:    0.6.2
 */