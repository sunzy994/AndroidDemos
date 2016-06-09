package cmcm.com.myapplication;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.lazyswipe.widget.listview.DragSortListView;

public class axb extends BaseAdapter
  implements axx
{
  private ListAdapter a;
  private axm c;

  public axb(final DragSortListView paramDragSortListView, ListAdapter paramListAdapter)
  {
    this.a = paramListAdapter;
    this.a.registerDataSetObserver(new DataSetObserver()
    {
      public void onChanged()
      {
        axb.this.notifyDataSetChanged();
      }

      public void onInvalidated()
      {
        axb.this.notifyDataSetInvalidated();
      }
    });
  }

  public ListAdapter a()
  {
    return this.a;
  }

  public void a(axs paramaxs)
  {
  }

  public void a(axw paramaxw, axs paramaxs, int paramInt)
  {
    if (this.c != null)
      this.c.a(paramaxw.getPosition(), paramaxs, paramInt);
  }

  public boolean areAllItemsEnabled()
  {
    return this.a.areAllItemsEnabled();
  }

  public int getCount()
  {
    return this.a.getCount();
  }

  public Object getItem(int paramInt)
  {
    return this.a.getItem(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return this.a.getItemId(paramInt);
  }

  public int getItemViewType(int paramInt)
  {
    return this.a.getItemViewType(paramInt);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      paramView = (awz)paramView;
      paramViewGroup = (axv)paramView.getChildAt(0);
      localView = paramViewGroup.getChildAt(0);
      localObject = this.a.getView(paramInt, localView, this.b);
      if (localObject != localView)
      {
        if (localView != null)
          paramViewGroup.removeViewAt(0);
        paramViewGroup.addView((View)localObject);
      }
      paramViewGroup.d();
      paramViewGroup.setPosition(paramInt);
      DragSortListView.a(this.b, this.b.getHeaderViewsCount() + paramInt, paramView, true);
      return paramView;
    }
    View localView = this.a.getView(paramInt, null, this.b);
    if ((localView instanceof Checkable));
    for (paramView = new axa(this.b.getContext()); ; paramView = new awz(this.b.getContext()))
    {
      localObject = new axs(this.b.getContext());
      ((axs)localObject).a(this.a.getItemViewType(paramInt));
      a((axs)localObject);
      localObject = new axw((axs)localObject);
      ((axw)localObject).setOnSwipeItemClickListener(this);
      paramViewGroup = (DragSortListView)paramViewGroup;
      paramViewGroup = new axv(localView, (axw)localObject, paramViewGroup.getCloseInterpolator(), paramViewGroup.getOpenInterpolator());
      paramViewGroup.setPosition(paramInt);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.addView(paramViewGroup);
      break;
    }
  }

  public int getViewTypeCount()
  {
    return this.a.getViewTypeCount();
  }

  public boolean hasStableIds()
  {
    return this.a.hasStableIds();
  }

  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }

  public boolean isEnabled(int paramInt)
  {
    return this.a.isEnabled(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axb
 * JD-Core Version:    0.6.2
 */