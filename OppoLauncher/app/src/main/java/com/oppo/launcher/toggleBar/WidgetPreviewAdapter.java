package com.oppo.launcher.toggleBar;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.oppo.launcher.Launcher;
import com.oppo.launcher.LauncherAppWidgetInfo;
import com.oppo.launcher.LauncherUtil;
import com.oppo.launcher.OppoPendingAddWidgetInfo;
import com.oppo.launcher.PendingAddWidgetInfo;
import com.oppo.launcher.Utilities;
import com.oppo.launcher.Workspace;
import com.oppo.launcher.expdev.ExpRegionHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WidgetPreviewAdapter extends ToggleBarPreviewAdapter
{
  protected static final int FIRST_LOAD_DELAY = 800;
  private static final String VENDING = "com.android.vending";
  protected int ONCE_FRESH_COUNT = 6;
  Handler mDelayHandle = new Handler();
  Runnable mDelayRunnable = new Runnable()
  {
    public void run()
    {
      try
      {
        WidgetPreviewAdapter.access$002(WidgetPreviewAdapter.this, (WidgetPreviewLoader)new WidgetPreviewLoader(WidgetPreviewAdapter.this).execute(new Void[0]));
        return;
      }
      catch (Exception localException)
      {
      }
    }
  };
  public boolean mIsFirst = false;
  private boolean mIsWidgetRemoved = false;
  private List<WidgetItem> mWidgetItems = new ArrayList();
  private WidgetPreviewLoader mWidgetPreviewLoader = null;
  private List<AppWidgetProviderInfo> providers = new ArrayList();

  public WidgetPreviewAdapter(Launcher paramLauncher)
  {
    super(paramLauncher);
    this.ONCE_FRESH_COUNT = 6;
    loadProviders();
    generateWidgetItems(this.providers, true);
    loadFourPreview();
    if (this.mWidgetPreviewLoader == null)
      this.mDelayHandle.postDelayed(this.mDelayRunnable, 800L);
  }

  public WidgetPreviewAdapter(Launcher paramLauncher, boolean paramBoolean)
  {
    super(paramLauncher);
    this.mIsFirst = paramBoolean;
    this.ONCE_FRESH_COUNT = 10;
    loadProviders();
    generateWidgetItems(this.providers, true);
    loadFourPreview();
    if (this.mWidgetPreviewLoader == null);
    try
    {
      this.mWidgetPreviewLoader = ((WidgetPreviewLoader)new WidgetPreviewLoader().execute(new Void[0]));
      return;
    }
    catch (Exception paramLauncher)
    {
    }
  }

  public WidgetPreviewAdapter(ArrayList<AppWidgetProviderInfo> paramArrayList, Launcher paramLauncher)
  {
    super(paramLauncher);
    generateWidgetItems(paramArrayList, false);
    loadFourPreview();
    if ((paramArrayList.size() > 4) && (this.mWidgetPreviewLoader == null))
      this.mDelayHandle.postDelayed(this.mDelayRunnable, 800L);
  }

  private void checkDuplicateWidget(int paramInt)
  {
    int j = this.providers.size();
    PackageManager localPackageManager = this.mLauncher.getPackageManager();
    int i = paramInt;
    if (i < j)
    {
      AppWidgetProviderInfo localAppWidgetProviderInfo = (AppWidgetProviderInfo)this.providers.get(i);
      int k;
      if (localAppWidgetProviderInfo.icon == 0)
      {
        this.providers.remove(i);
        paramInt = j - 1;
        k = i - 1;
      }
      while (true)
      {
        i = k + 1;
        j = paramInt;
        break;
        String str1 = localAppWidgetProviderInfo.provider.getPackageName();
        String str2 = ((AppWidgetProviderInfo)this.providers.get(i)).label;
        paramInt = i + 1;
        while (paramInt < j)
        {
          String str3 = ((AppWidgetProviderInfo)this.providers.get(paramInt)).provider.getPackageName();
          String str4 = ((AppWidgetProviderInfo)this.providers.get(paramInt)).label;
          k = j;
          int m = paramInt;
          if (str1.equals(str3))
          {
            k = j;
            m = paramInt;
            if (str2.equals(str4))
            {
              this.providers.remove(paramInt);
              k = j - 1;
              m = paramInt - 1;
            }
          }
          paramInt = m + 1;
          j = k;
        }
        paramInt = j;
        k = i;
        try
        {
          if ((localPackageManager.getApplicationInfo(str1, 0).flags & 0x40000) != 0)
          {
            if (this.DEBUG)
              Log.d(this.TAG, "widget " + str2 + " has been moved to sdcard!");
            unistallWidgetInSdcard(localAppWidgetProviderInfo, str2);
            this.providers.remove(i);
            paramInt = j - 1;
            k = i - 1;
          }
        }
        catch (NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
          paramInt = j;
          k = i;
        }
      }
    }
  }

  private void generateWidgetItems(List<AppWidgetProviderInfo> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.d(this.TAG, "generateWidgetItems -- The number of widgets is 0");
      return;
    }
    Object localObject1 = new WidgetItem();
    ((WidgetItem)localObject1).addProvider((AppWidgetProviderInfo)paramList.get(0));
    this.mWidgetItems.add(localObject1);
    int j = paramList.size();
    int i = 1;
    label69: Object localObject2;
    if (i < j)
    {
      localObject1 = (AppWidgetProviderInfo)paramList.get(i);
      localObject2 = (AppWidgetProviderInfo)paramList.get(i - 1);
      if ((!paramBoolean) || (!((AppWidgetProviderInfo)localObject1).provider.getPackageName().equals(((AppWidgetProviderInfo)localObject2).provider.getPackageName())))
        break label164;
      ((WidgetItem)this.mWidgetItems.get(this.mWidgetItems.size() - 1)).addProvider((AppWidgetProviderInfo)localObject1);
    }
    while (true)
    {
      i += 1;
      break label69;
      break;
      label164: localObject2 = new WidgetItem();
      ((WidgetItem)localObject2).addProvider((AppWidgetProviderInfo)localObject1);
      this.mWidgetItems.add(localObject2);
    }
  }

  private void loadFourPreview()
  {
    int j = this.mWidgetItems.size();
    if (j == 0)
    {
      Log.d(this.TAG, "loadFourPreview -- The number of widget is 0");
      return;
    }
    int i = j;
    if (j > 4)
      i = 4;
    j = 0;
    label41: Object localObject1;
    if (j < i)
    {
      localObject1 = (WidgetItem)this.mWidgetItems.get(j);
      if (((WidgetItem)localObject1).providerInfo.size() <= 1)
        break label108;
      if (this.mToggleBarPreviewList != null)
        this.mToggleBarPreviewList.add(ToggleBarPreviewUtils.createWidgetItemFromAppWidgetInfo(((WidgetItem)localObject1).providerInfo, this.mLauncher));
    }
    while (true)
    {
      j += 1;
      break label41;
      break;
      label108: Object localObject2 = (AppWidgetProviderInfo)((WidgetItem)localObject1).providerInfo.get(0);
      localObject1 = new OppoPendingAddWidgetInfo((AppWidgetProviderInfo)localObject2);
      ((OppoPendingAddWidgetInfo)localObject1).title = ((AppWidgetProviderInfo)localObject2).label;
      int k = ((AppWidgetProviderInfo)localObject2).icon;
      if (k != 0)
      {
        ((OppoPendingAddWidgetInfo)localObject1).icon = k;
        ((OppoPendingAddWidgetInfo)localObject1).minWidth = ((AppWidgetProviderInfo)localObject2).minWidth;
        ((OppoPendingAddWidgetInfo)localObject1).minHeight = ((AppWidgetProviderInfo)localObject2).minHeight;
        if (this.DEBUG)
          Log.d(this.TAG, "loadFourPreview provider.minWidth= " + ((AppWidgetProviderInfo)localObject2).minWidth + ", provider.minHeight= " + ((AppWidgetProviderInfo)localObject2).minHeight + "\n");
        ((OppoPendingAddWidgetInfo)localObject1).componentName = ((AppWidgetProviderInfo)localObject2).provider;
        ((OppoPendingAddWidgetInfo)localObject1).itemType = 5;
        ((OppoPendingAddWidgetInfo)localObject1).container = -100L;
        localObject2 = this.mLauncher.getSpanForWidget((PendingAddWidgetInfo)localObject1, null);
        ((OppoPendingAddWidgetInfo)localObject1).spanX = localObject2[0];
        ((OppoPendingAddWidgetInfo)localObject1).spanY = localObject2[1];
        localObject2 = this.mLauncher.getMinSpanForWidget((PendingAddWidgetInfo)localObject1, null);
        ((OppoPendingAddWidgetInfo)localObject1).minSpanX = localObject2[0];
        ((OppoPendingAddWidgetInfo)localObject1).minSpanY = localObject2[1];
        if (this.DEBUG)
          Log.d(this.TAG, "loadFourPreview spanX = " + ((OppoPendingAddWidgetInfo)localObject1).spanX + ", spanY = " + ((OppoPendingAddWidgetInfo)localObject1).spanY + "\n");
        if (this.mToggleBarPreviewList != null)
          this.mToggleBarPreviewList.add(ToggleBarPreviewUtils.createWidgetItemFromAppWidgetInfo((OppoPendingAddWidgetInfo)localObject1, this.mLauncher));
      }
    }
  }

  private void loadProviders()
  {
    Object localObject = AppWidgetManager.getInstance(this.mLauncher.getApplicationContext());
    localObject = Utilities.getAllAppWidgetsProviders(this.mLauncher.getApplicationContext(), (AppWidgetManager)localObject);
    int i = ((List)localObject).size();
    String[] arrayOfString = this.mLauncher.getResources().getStringArray(2131099648);
    int k = 0;
    if (k < arrayOfString.length)
    {
      int m = 0;
      while (true)
      {
        int j = i;
        String str;
        if (m < i)
        {
          j = i;
          if (m >= ((List)localObject).size())
            break label195;
          AppWidgetProviderInfo localAppWidgetProviderInfo = (AppWidgetProviderInfo)((List)localObject).get(m);
          str = localAppWidgetProviderInfo.provider.getPackageName();
          if (str.equals(arrayOfString[k]))
          {
            this.providers.add(localAppWidgetProviderInfo);
            ((List)localObject).remove(m);
            j = i - 1;
          }
        }
        else
        {
          k += 1;
          i = j;
          break;
        }
        j = i;
        if (!ExpRegionHandler.isExportRegion())
        {
          j = i;
          if ("com.android.vending".equals(str))
          {
            ((List)localObject).remove(m);
            j = i - 1;
          }
        }
        label195: m += 1;
        i = j;
      }
    }
    this.providers.addAll((Collection)localObject);
    checkDuplicateWidget(arrayOfString.length);
    this.mIsWidgetRemoved = false;
  }

  private void unistallWidgetInSdcard(final AppWidgetProviderInfo paramAppWidgetProviderInfo, final String paramString)
  {
    paramAppWidgetProviderInfo = LauncherUtil.getAppWidgetInfo(this.mLauncher, paramAppWidgetProviderInfo.provider);
    if (paramAppWidgetProviderInfo != null)
    {
      this.mLauncher.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Workspace localWorkspace = WidgetPreviewAdapter.this.mLauncher.getWorkspace();
          if (localWorkspace != null)
          {
            boolean bool = localWorkspace.removeAppWidgetInPage(paramAppWidgetProviderInfo);
            if (bool)
              WidgetPreviewAdapter.access$102(WidgetPreviewAdapter.this, bool);
          }
          if (WidgetPreviewAdapter.this.DEBUG)
            Log.d(WidgetPreviewAdapter.this.TAG, "widget " + paramString + " has been uninstalled!");
        }
      });
      this.mLauncher.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Workspace localWorkspace = WidgetPreviewAdapter.this.mLauncher.getWorkspace();
          if ((WidgetPreviewAdapter.this.mIsWidgetRemoved) && (localWorkspace != null))
            localWorkspace.postDelayRemoveNullScreen(1000);
        }
      });
    }
  }

  public int getItemViewType(int paramInt)
  {
    return 0;
  }

  public ToggleBarPreviewAdapter.ViewHolder getViewHolder(Context paramContext, int paramInt)
  {
    ToggleBarPreviewAdapter.ViewHolder localViewHolder = super.getViewHolder(paramContext, paramInt);
    if (localViewHolder == null)
    {
      paramContext = null;
      return paramContext;
    }
    paramInt = 0;
    while (true)
    {
      paramContext = localViewHolder;
      if (paramInt >= 4)
        break;
      paramContext = localViewHolder.getHolderLayout(paramInt);
      if (paramContext != null)
      {
        paramContext.thumbnail.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        paramContext.thumbnail.setPadding(this.mWidgetLeftPadding, this.mWidgetTopPadding, this.mWidgetRightPadding, this.mWidgetBottomPadding);
      }
      paramInt += 1;
    }
  }

  public ToggleBarPreviewAdapter.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = getViewHolder(this.mLauncher, 2130968591);
    if (paramViewGroup != null)
      paramViewGroup.setPos(-1);
    return paramViewGroup;
  }

  public void recycle()
  {
    if ((this.mWidgetPreviewLoader != null) && (!this.mWidgetPreviewLoader.isCancelled()))
    {
      this.mWidgetPreviewLoader.cancel(true);
      this.mWidgetPreviewLoader = null;
    }
    this.mDelayHandle.removeCallbacks(this.mDelayRunnable);
    super.recycle();
  }

  public void setThumbnail(ToggleBarPreviewItem paramToggleBarPreviewItem, ToggleBarPreviewAdapter.HolderLayout paramHolderLayout)
  {
    Drawable localDrawable = paramToggleBarPreviewItem.getThumbnail();
    if (localDrawable != null)
    {
      paramHolderLayout.thumbnail.setImageDrawable(localDrawable);
      if (paramToggleBarPreviewItem.mIsCanLongClick)
        paramHolderLayout.thumbnail.setTag(paramToggleBarPreviewItem.getTag());
      return;
    }
    Log.w(this.TAG, "setThumbnail getThumbnail = null");
  }

  private class WidgetItem
  {
    public ArrayList<AppWidgetProviderInfo> providerInfo = new ArrayList();

    public WidgetItem()
    {
    }

    public void addProvider(AppWidgetProviderInfo paramAppWidgetProviderInfo)
    {
      this.providerInfo.add(paramAppWidgetProviderInfo);
    }
  }

  class WidgetPreviewLoader extends AsyncTask<Void, Void, Void>
  {
    WidgetPreviewLoader()
    {
    }

    private boolean filterWidgetOut(OppoPendingAddWidgetInfo paramOppoPendingAddWidgetInfo, int paramInt1, int paramInt2)
    {
      return (paramOppoPendingAddWidgetInfo.minSpanX >= paramInt1) || (paramOppoPendingAddWidgetInfo.minSpanY >= paramInt2);
    }

    protected Void doInBackground(Void[] paramArrayOfVoid)
    {
      if ((isCancelled()) || (WidgetPreviewAdapter.this.mToggleBarPreviewList == null))
        return null;
      int j = WidgetPreviewAdapter.this.mWidgetItems.size();
      if (j <= 4)
        return null;
      int i = 4;
      if (i < j)
      {
        if ((isCancelled()) && (i > 3))
          return null;
        paramArrayOfVoid = (WidgetItem)WidgetPreviewAdapter.this.mWidgetItems.get(i);
        if (paramArrayOfVoid.providerInfo.size() > 1)
          if (WidgetPreviewAdapter.this.mToggleBarPreviewList != null)
            WidgetPreviewAdapter.this.mToggleBarPreviewList.add(ToggleBarPreviewUtils.createWidgetItemFromAppWidgetInfo(paramArrayOfVoid.providerInfo, WidgetPreviewAdapter.this.mLauncher));
        while (true)
        {
          if ((((i + 1) % WidgetPreviewAdapter.this.ONCE_FRESH_COUNT == 0) && ((WidgetPreviewAdapter.this.isCurrentTogState(ToggleBarManager.ToggleType.WIDGET_ALL)) || (WidgetPreviewAdapter.this.isCurrentTogState(ToggleBarManager.ToggleType.WIDGET_SPECIFIC)))) || (3 == i))
            publishProgress(new Void[0]);
          int k;
          while (true)
          {
            i += 1;
            break;
            localObject = (AppWidgetProviderInfo)paramArrayOfVoid.providerInfo.get(0);
            paramArrayOfVoid = new OppoPendingAddWidgetInfo((AppWidgetProviderInfo)localObject);
            paramArrayOfVoid.title = ((AppWidgetProviderInfo)localObject).label;
            k = ((AppWidgetProviderInfo)localObject).icon;
            if (k != 0)
              break label287;
            if (WidgetPreviewAdapter.this.DEBUG)
              Log.d(WidgetPreviewAdapter.this.TAG, "Can't load icon drawable 0x" + Integer.toHexString(((AppWidgetProviderInfo)localObject).icon) + "for provider:" + ((AppWidgetProviderInfo)localObject).provider);
          }
          label287: paramArrayOfVoid.icon = k;
          paramArrayOfVoid.minWidth = ((AppWidgetProviderInfo)localObject).minWidth;
          paramArrayOfVoid.minHeight = ((AppWidgetProviderInfo)localObject).minHeight;
          if (WidgetPreviewAdapter.this.DEBUG)
            Log.d(WidgetPreviewAdapter.this.TAG, "doInBackground provider.minWidth= " + ((AppWidgetProviderInfo)localObject).minWidth + ", provider.minHeight= " + ((AppWidgetProviderInfo)localObject).minHeight + "\n");
          paramArrayOfVoid.componentName = ((AppWidgetProviderInfo)localObject).provider;
          paramArrayOfVoid.itemType = 5;
          paramArrayOfVoid.container = -100L;
          Object localObject = WidgetPreviewAdapter.this.mLauncher.getSpanForWidget(paramArrayOfVoid, null);
          paramArrayOfVoid.spanX = localObject[0];
          paramArrayOfVoid.spanY = localObject[1];
          localObject = WidgetPreviewAdapter.this.mLauncher.getMinSpanForWidget(paramArrayOfVoid, null);
          paramArrayOfVoid.minSpanX = localObject[0];
          paramArrayOfVoid.minSpanY = localObject[1];
          if (WidgetPreviewAdapter.this.DEBUG)
            Log.d(WidgetPreviewAdapter.this.TAG, "doInBackground spanX = " + paramArrayOfVoid.spanX + ", spanY = " + paramArrayOfVoid.spanY + "\n");
          if ((!filterWidgetOut(paramArrayOfVoid, 5, 6)) && (!isCancelled()) && (WidgetPreviewAdapter.this.mToggleBarPreviewList != null))
            WidgetPreviewAdapter.this.mToggleBarPreviewList.add(ToggleBarPreviewUtils.createWidgetItemFromAppWidgetInfo(paramArrayOfVoid, WidgetPreviewAdapter.this.mLauncher));
        }
      }
      return null;
    }

    protected void onCancelled(Void paramVoid)
    {
      if (WidgetPreviewAdapter.this.mToggleBarPreviewList != null)
        WidgetPreviewAdapter.this.recycle();
      super.onCancelled(paramVoid);
    }

    protected void onPostExecute(Void paramVoid)
    {
      if ((WidgetPreviewAdapter.this.isCurrentTogState(ToggleBarManager.ToggleType.WIDGET_ALL)) || (WidgetPreviewAdapter.this.isCurrentTogState(ToggleBarManager.ToggleType.WIDGET_SPECIFIC)))
        WidgetPreviewAdapter.this.notifyDataSetChanged();
      super.onPostExecute(paramVoid);
    }

    protected void onProgressUpdate(Void[] paramArrayOfVoid)
    {
      WidgetPreviewAdapter.this.notifyDataSetChanged();
      super.onProgressUpdate(paramArrayOfVoid);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.WidgetPreviewAdapter
 * JD-Core Version:    0.6.2
 */