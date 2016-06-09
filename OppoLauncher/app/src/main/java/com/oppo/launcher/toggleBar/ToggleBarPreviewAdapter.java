package com.oppo.launcher.toggleBar;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.oppo.launcher.Launcher;
import java.util.ArrayList;
import java.util.List;

public class ToggleBarPreviewAdapter extends RecyclerView.Adapter<ViewHolder>
{
  protected boolean DEBUG = false;
  protected String TAG = "ToggleBarPreviewAdapter";
  protected int mGroupHeight;
  protected int mGroupWidth;
  private long mLastClickTime = 0L;
  protected Launcher mLauncher;
  private long mRealClickTime = 0L;
  protected int mToBeShowingPosition = 0;
  protected ArrayList<ToggleBarPreviewItem> mToggleBarPreviewList;
  protected int mWidgetBottomPadding;
  protected int mWidgetLeftPadding;
  protected int mWidgetRightPadding;
  protected int mWidgetTopPadding;

  public ToggleBarPreviewAdapter(Launcher paramLauncher)
  {
    this.mToggleBarPreviewList = new ArrayList();
    this.mLauncher = paramLauncher;
    initParams();
  }

  public ToggleBarPreviewAdapter(ArrayList<ToggleBarPreviewItem> paramArrayList, Launcher paramLauncher)
  {
    this.mToggleBarPreviewList = paramArrayList;
    this.mLauncher = paramLauncher;
    initParams();
  }

  private void initParams()
  {
    if (this.mLauncher != null)
    {
      Resources localResources = this.mLauncher.getResources();
      if (localResources != null)
      {
        this.mGroupWidth = ((int)localResources.getDimension(2131361794));
        this.mGroupHeight = ((int)localResources.getDimension(2131361795));
        this.mWidgetTopPadding = ((int)localResources.getDimension(2131361803));
        this.mWidgetBottomPadding = ((int)localResources.getDimension(2131361804));
        this.mWidgetLeftPadding = ((int)localResources.getDimension(2131361805));
        this.mWidgetRightPadding = ((int)localResources.getDimension(2131361806));
      }
    }
  }

  private void setViewGroupGravity(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131492896);
    if (this.mToggleBarPreviewList != null)
    {
      if (this.mToggleBarPreviewList.size() < 4)
        paramView.setGravity(17);
    }
    else
      return;
    paramView.setGravity(3);
  }

  public void add(ToggleBarPreviewItem paramToggleBarPreviewItem)
  {
    this.mToggleBarPreviewList.add(paramToggleBarPreviewItem);
  }

  public void clear()
  {
    recycle();
  }

  public int getGroupSize(int paramInt)
  {
    if (paramInt < 0)
      paramInt = 0;
    int i;
    do
    {
      return paramInt;
      if (this.mToggleBarPreviewList == null)
        return 0;
      i = this.mToggleBarPreviewList.size() - paramInt * 4;
      if (i < 1)
        return 0;
      paramInt = i;
    }
    while (i <= 4);
    return 4;
  }

  public int getItemCount()
  {
    if (this.mToggleBarPreviewList != null)
    {
      int j = this.mToggleBarPreviewList.size() / 4;
      int i = j;
      if (this.mToggleBarPreviewList.size() % 4 != 0)
        i = j + 1;
      return i;
    }
    return 0;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    return 0;
  }

  public View getNewViewForAnimation(int paramInt)
  {
    return getNewViewForAnimation(paramInt, 2130968591);
  }

  public View getNewViewForAnimation(int paramInt1, int paramInt2)
  {
    int i = getGroupSize(paramInt1);
    if (i == 0);
    ViewHolder localViewHolder;
    do
    {
      return null;
      localViewHolder = getViewHolder(this.mLauncher, paramInt2);
    }
    while (localViewHolder == null);
    paramInt2 = 0;
    while (true)
    {
      if (paramInt2 >= i)
        break label73;
      ToggleBarPreviewItem localToggleBarPreviewItem = (ToggleBarPreviewItem)this.mToggleBarPreviewList.get(paramInt1 * 4 + paramInt2);
      if (localToggleBarPreviewItem == null)
        break;
      initViewHolder(localViewHolder, paramInt2, localToggleBarPreviewItem);
      paramInt2 += 1;
    }
    label73: if ((i < 4) && (i > 0))
    {
      paramInt1 = i;
      while (paramInt1 < 4)
      {
        initViewHolder(localViewHolder, paramInt1, null);
        paramInt1 += 1;
      }
    }
    return localViewHolder.getView();
  }

  public ViewHolder getViewHolder(Context paramContext, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramContext != null)
    {
      paramContext = View.inflate(paramContext, paramInt, null);
      localObject1 = localObject2;
      if (paramContext != null)
      {
        paramContext.getLayoutParams();
        paramContext.setLayoutParams(new LayoutParams(this.mGroupWidth, this.mGroupHeight));
        localObject1 = new ViewHolder(paramContext);
        ((ViewHolder)localObject1).findChildView(paramContext);
        setViewGroupGravity(paramContext);
      }
    }
    paramInt = 0;
    while (paramInt < 4)
    {
      paramContext = ((ViewHolder)localObject1).getHolderLayout(paramInt);
      if (paramContext != null)
        paramContext.thumbnail.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramInt += 1;
    }
    return localObject1;
  }

  public View inflateView(Context paramContext, int paramInt)
  {
    Context localContext = null;
    if (paramContext != null)
    {
      paramContext = View.inflate(paramContext, paramInt, null);
      localContext = paramContext;
      if (paramContext != null)
      {
        paramContext.getLayoutParams();
        paramContext.setLayoutParams(new LayoutParams(this.mGroupWidth, this.mGroupHeight));
        localContext = paramContext;
      }
    }
    return localContext;
  }

  public void initViewHolder(ViewHolder paramViewHolder, int paramInt, ToggleBarPreviewItem paramToggleBarPreviewItem)
  {
    if (paramViewHolder == null);
    do
    {
      do
      {
        return;
        paramViewHolder = paramViewHolder.getHolderLayout(paramInt);
      }
      while (paramViewHolder == null);
      if (paramToggleBarPreviewItem == null)
        break;
      paramViewHolder.layout.setVisibility(0);
      paramViewHolder.title.setText(paramToggleBarPreviewItem.mTitle);
      setThumbnail(paramToggleBarPreviewItem, paramViewHolder);
      paramViewHolder.thumbnail.setInUsing(paramToggleBarPreviewItem.getInUsing());
      PreviewOnClickListener localPreviewOnClickListener = new PreviewOnClickListener(paramToggleBarPreviewItem);
      paramViewHolder.thumbnail.setOnClickListener(localPreviewOnClickListener);
    }
    while (!paramToggleBarPreviewItem.mIsCanLongClick);
    paramViewHolder.thumbnail.setOnLongClickListener(this.mLauncher);
    paramViewHolder.thumbnail.setTag(paramToggleBarPreviewItem.getTag());
    return;
    paramViewHolder.layout.setVisibility(8);
  }

  public boolean isCurrentTogState(ToggleBarManager.ToggleType paramToggleType)
  {
    return (this.mLauncher.getToggleBarManager() != null) && (this.mLauncher.getToggleBarManager().isCurrentToggleState(paramToggleType));
  }

  public List<ToggleBarPreviewItem> loadPreview()
  {
    return null;
  }

  public void onBindViewHolder(ViewHolder paramViewHolder, int paramInt)
  {
    int j = getGroupSize(paramInt);
    if (j == 0);
    while (true)
    {
      return;
      paramViewHolder.setPos(paramInt);
      int i = 0;
      while (true)
      {
        if (i >= j)
          break label76;
        ToggleBarPreviewItem localToggleBarPreviewItem = (ToggleBarPreviewItem)this.mToggleBarPreviewList.get(paramInt * 4 + i);
        if (localToggleBarPreviewItem == null)
          break;
        localToggleBarPreviewItem.mId = (paramInt * 4 + i);
        initViewHolder(paramViewHolder, i, localToggleBarPreviewItem);
        i += 1;
      }
      label76: if ((j < 4) && (j > 0))
      {
        paramInt = j;
        while (paramInt < 4)
        {
          initViewHolder(paramViewHolder, paramInt, null);
          paramInt += 1;
        }
      }
    }
  }

  public ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return getViewHolder(this.mLauncher, 2130968591);
  }

  public void recycle()
  {
    if ((this.mToggleBarPreviewList == null) || (this.mToggleBarPreviewList.size() == 0))
      return;
    int i = 0;
    while (i < this.mToggleBarPreviewList.size())
    {
      ToggleBarPreviewItem localToggleBarPreviewItem = (ToggleBarPreviewItem)this.mToggleBarPreviewList.get(i);
      if (localToggleBarPreviewItem != null)
        localToggleBarPreviewItem.recycle();
      i += 1;
    }
    this.mToggleBarPreviewList.clear();
    this.mToggleBarPreviewList = null;
    refresh();
  }

  public void refresh()
  {
    notifyDataSetChanged();
  }

  public void refreshUsingSign(ToggleBarPreviewItem paramToggleBarPreviewItem)
  {
    if (paramToggleBarPreviewItem != null)
      paramToggleBarPreviewItem.mInUsing = true;
  }

  public void setLauncer(Launcher paramLauncher)
  {
    this.mLauncher = paramLauncher;
  }

  public void setThumbnail(ToggleBarPreviewItem paramToggleBarPreviewItem, HolderLayout paramHolderLayout)
  {
    paramToggleBarPreviewItem = paramToggleBarPreviewItem.getThumbnail();
    if (paramToggleBarPreviewItem != null)
      paramHolderLayout.thumbnail.setImageDrawable(paramToggleBarPreviewItem);
  }

  public void setToBeShowingPosition(int paramInt)
  {
    this.mToBeShowingPosition = paramInt;
  }

  public class HolderLayout
  {
    public LinearLayout layout;
    public ToggleBarPreviewImage thumbnail;
    public TextView title;

    public HolderLayout()
    {
    }
  }

  class PreviewOnClickListener
    implements OnClickListener
  {
    private ToggleBarPreviewItem mPreviewItem;

    public PreviewOnClickListener(ToggleBarPreviewItem arg2)
    {
      Object localObject;
      this.mPreviewItem = localObject;
    }

    public void onClick(View paramView)
    {
      ToggleBarPreviewAdapter.access$002(ToggleBarPreviewAdapter.this, System.currentTimeMillis());
      if ((this.mPreviewItem.getInUsing()) && (!this.mPreviewItem.mCanRepeatedlySet))
        this.mPreviewItem.dealWithWhenAdded();
      while ((this.mPreviewItem == null) || (ToggleBarPreviewAdapter.this.mToggleBarPreviewList == null))
        return;
      if (this.mPreviewItem.mIsNeedShowLabel)
      {
        ToggleBarPreviewAdapter.this.refreshUsingSign(this.mPreviewItem);
        paramView.post(new Runnable()
        {
          public void run()
          {
            ToggleBarPreviewAdapter.this.refresh();
          }
        });
      }
      ToggleBarPreviewAdapter.access$102(ToggleBarPreviewAdapter.this, System.currentTimeMillis());
      this.mPreviewItem.handleOnClick();
    }
  }

  public class ViewHolder extends RecyclerView.ViewHolder
  {
    HolderLayout holderLayout1 = new HolderLayout(ToggleBarPreviewAdapter.this);
    HolderLayout holderLayout2 = new HolderLayout(ToggleBarPreviewAdapter.this);
    HolderLayout holderLayout3 = new HolderLayout(ToggleBarPreviewAdapter.this);
    HolderLayout holderLayout4 = new HolderLayout(ToggleBarPreviewAdapter.this);
    public View itemView;
    public int pos = -1;

    public ViewHolder(View arg2)
    {
      super();
      this.itemView = localView;
    }

    public void findChildView(View paramView)
    {
      this.holderLayout1.layout = ((LinearLayout)paramView.findViewById(2131492897));
      this.holderLayout1.title = ((TextView)this.holderLayout1.layout.findViewById(2131492903));
      this.holderLayout1.thumbnail = ((ToggleBarPreviewImage)this.holderLayout1.layout.findViewById(2131492902));
      this.holderLayout2.layout = ((LinearLayout)paramView.findViewById(2131492898));
      this.holderLayout2.title = ((TextView)this.holderLayout2.layout.findViewById(2131492903));
      this.holderLayout2.thumbnail = ((ToggleBarPreviewImage)this.holderLayout2.layout.findViewById(2131492902));
      this.holderLayout3.layout = ((LinearLayout)paramView.findViewById(2131492899));
      this.holderLayout3.title = ((TextView)this.holderLayout3.layout.findViewById(2131492903));
      this.holderLayout3.thumbnail = ((ToggleBarPreviewImage)this.holderLayout3.layout.findViewById(2131492902));
      this.holderLayout4.layout = ((LinearLayout)paramView.findViewById(2131492900));
      this.holderLayout4.title = ((TextView)this.holderLayout4.layout.findViewById(2131492903));
      this.holderLayout4.thumbnail = ((ToggleBarPreviewImage)this.holderLayout4.layout.findViewById(2131492902));
    }

    public HolderLayout getHolderLayout(int paramInt)
    {
      if (paramInt == 0)
        return this.holderLayout1;
      if (paramInt == 1)
        return this.holderLayout2;
      if (paramInt == 2)
        return this.holderLayout3;
      if (paramInt == 3)
        return this.holderLayout4;
      return null;
    }

    public int getPos()
    {
      return this.pos;
    }

    public View getView()
    {
      return this.itemView;
    }

    public void setPos(int paramInt)
    {
      this.pos = paramInt;
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.ToggleBarPreviewAdapter
 * JD-Core Version:    0.6.2
 */