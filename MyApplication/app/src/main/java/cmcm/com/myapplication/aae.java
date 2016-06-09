package cmcm.com.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lazyswipe.SwipeService;
import com.lazyswipe.fan.notification.NotificationView;
import com.lazyswipe.notification.NotificationData;

public class aae extends CursorAdapter
  implements OnClickListener, zz
{
  final String a;
  long b;
  private final NotificationView c;
  private final ali d;
  private final boolean e;

  public aae(NotificationView paramNotificationView, yx paramyx, String paramString)
  {
    super(paramNotificationView.getContext(), null);
    this.c = paramNotificationView;
    this.d = paramyx;
    this.a = paramString;
    if (("com.tencent.qqlite".equals(this.a)) || ("com.tencent.mobileqq".equals(this.a)));
    for (boolean bool = true; ; bool = false)
    {
      this.e = bool;
      new aaf(this).start();
      return;
    }
  }

  public void a()
  {
    Object localObject1 = null;
    int i = 1;
    while (true)
    {
      Object localObject2 = localObject1;
      if (i <= 4);
      try
      {
        localObject2 = alo.c(this.c.getContext(), this.a);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((Cursor)localObject2).moveToLast())
          {
            localObject1 = localObject2;
            this.b = ((Cursor)localObject2).getLong(4);
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public void run()
              {
                if (this.a != null)
                {
                  aae.this.changeCursor(this.a);
                  aae.a(aae.this).e();
                  return;
                }
                aae.a(aae.this).a(true);
                SwipeService.k();
              }
            });
            return;
          }
        }
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          ((Cursor)localObject2).close();
        }
        localObject1 = localObject2;
        Thread.sleep(300L);
        localObject1 = localObject2;
        label100: i += 1;
      }
      catch (Throwable localThrowable)
      {
        break label100;
      }
    }
  }

  public void a_(int paramInt)
  {
    Cursor localCursor = (Cursor)getItem(paramInt);
    if (localCursor != null)
    {
      if (localCursor.getCount() == 1)
        this.d.a(null);
    }
    else
      return;
    alo.a(this.c.getContext(), localCursor.getLong(4));
  }

  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    aad localaad = (aad)paramView.getTag();
    paramCursor = new NotificationData(paramCursor);
    if (this.e)
      paramCursor.e = this.b;
    localaad.d.setText(asq.b(paramContext, paramCursor.f));
    localaad.b.setText(paramCursor.g);
    paramContext = localaad.c;
    if ((this.e) && (paramCursor.i != null))
    {
      paramView = paramCursor.i;
      paramContext.setText(paramView);
      if (paramCursor.k == null)
        break label131;
      localaad.e.setImageBitmap(paramCursor.k);
    }
    while (true)
    {
      this.c.a(localaad, paramCursor, -1, this);
      return;
      paramView = paramCursor.b();
      break;
      label131: localaad.e.setImageResource(2130903040);
    }
  }

  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130968707, null, false);
    new aad().a(paramContext, this);
    return paramContext;
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131755383)
      this.c.a((NotificationData)paramView.getTag());
    while (!(paramView instanceof TextView))
      return;
    this.c.a(paramView);
  }

  protected void onContentChanged()
  {
    super.onContentChanged();
    Cursor localCursor = getCursor();
    if ((localCursor != null) && (localCursor.moveToLast()))
    {
      this.b = localCursor.getLong(4);
      return;
    }
    this.c.a();
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.c.getContext();
    paramView = (Cursor)getItem(paramInt);
    if (paramView != null)
    {
      paramView = new NotificationData(paramView);
      if (this.e)
        paramView.e = this.b;
      this.d.a(paramAdapterView, paramView);
    }
    asq.t(paramAdapterView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aae
 * JD-Core Version:    0.6.2
 */