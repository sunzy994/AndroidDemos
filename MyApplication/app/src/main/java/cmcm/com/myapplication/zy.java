package cmcm.com.myapplication;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lazyswipe.SwipeService;
import com.lazyswipe.fan.notification.NotificationView;
import com.lazyswipe.notification.NotificationData;
import com.lazyswipe.notification.NotificationDataExtended;
import java.util.ArrayList;
import java.util.List;

public abstract class zy extends BaseAdapter
  implements OnClickListener, zz
{
  List<NotificationData> d = new ArrayList(0);
  protected final NotificationView e;
  protected final ali f;

  public zy(NotificationView paramNotificationView, ali paramali)
  {
    this.e = paramNotificationView;
    this.f = paramali;
    new aaf(this).start();
  }

  public void a()
  {
    this.d.clear();
    int i = 1;
    while (true)
    {
      Cursor localCursor;
      if (i <= 4)
      {
        localCursor = b();
        if (localCursor == null);
      }
      try
      {
        if (localCursor.moveToFirst())
          a(localCursor);
        if (localCursor != null)
          localCursor.close();
        if (this.d.size() > 0)
        {
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              if (zy.this.d.size() > 0)
              {
                zy.this.notifyDataSetChanged();
                zy.this.e.e();
                return;
              }
              zy.this.e.a(true);
              SwipeService.k();
            }
          });
          return;
        }
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
      try
      {
        Thread.sleep(300L);
        label103: i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label103;
      }
    }
  }

  abstract void a(aad paramaad, NotificationData paramNotificationData, int paramInt);

  abstract void a(Cursor paramCursor);

  public void a_(int paramInt)
  {
    Object localObject = (NotificationData)this.d.remove(paramInt);
    if (localObject != null)
      if (getCount() <= 0)
      {
        this.e.c();
        return;
      }
    try
    {
      paramInt = c();
      if (paramInt >= 0)
      {
        localObject = new NotificationDataExtended((NotificationData)localObject);
        ((NotificationDataExtended)localObject).r = paramInt;
        this.f.a((NotificationData)localObject);
      }
      while (true)
      {
        label66: notifyDataSetChanged();
        return;
        this.f.a((NotificationData)localObject);
      }
    }
    catch (Throwable localThrowable)
    {
      break label66;
    }
  }

  abstract Cursor b();

  protected int c()
  {
    return -1;
  }

  public int getCount()
  {
    return this.d.size();
  }

  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.e.getContext()).inflate(2130968709, null, false);
      paramViewGroup = new aad();
      paramViewGroup.a(paramView, this);
    }
    try
    {
      while (true)
      {
        NotificationData localNotificationData = (NotificationData)getItem(paramInt);
        this.e.a(paramViewGroup, localNotificationData, paramInt, this);
        a(paramViewGroup, localNotificationData, paramInt);
        return paramView;
        paramViewGroup = (aad)paramView.getTag();
      }
    }
    catch (Throwable paramViewGroup)
    {
      asp.a("Swipe.NotificationView", "Bind data failed", paramViewGroup);
    }
    return paramView;
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131755383)
      this.e.a((NotificationData)paramView.getTag());
    while (!(paramView instanceof TextView))
      return;
    this.e.a(paramView);
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.f.a(this.e.getContext(), (NotificationData)getItem(paramInt));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zy
 * JD-Core Version:    0.6.2
 */