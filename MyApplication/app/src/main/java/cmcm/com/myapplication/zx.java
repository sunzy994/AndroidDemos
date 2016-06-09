package cmcm.com.myapplication;

import android.database.Cursor;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lazyswipe.fan.notification.NotificationView;
import com.lazyswipe.notification.NotificationData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zx extends zy
{
  final int a;
  final boolean b;
  final boolean c;

  public zx(NotificationView paramNotificationView, ali paramali, int paramInt)
  {
    this(paramNotificationView, paramali, paramInt, false, false);
  }

  public zx(NotificationView paramNotificationView, ali paramali, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramNotificationView, paramali);
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }

  void a(aad paramaad, NotificationData paramNotificationData, int paramInt)
  {
    paramaad.d.setText(asq.b(this.e.getContext(), paramNotificationData.f));
    paramaad.b.setText(paramNotificationData.g);
    paramaad.c.setText(paramNotificationData.b());
    if (paramNotificationData.k != null)
      paramaad.e.setImageBitmap(paramNotificationData.k);
    while (true)
    {
      this.e.a(paramaad, paramNotificationData, paramInt, this);
      if ((this.c) && ((paramaad.g.getVisibility() == 0) || (paramaad.g.getChildCount() > 1)))
      {
        paramaad.a();
        paramaad.g.setVisibility(8);
      }
      return;
      paramaad.e.setImageResource(2130903040);
    }
  }

  void a(Cursor paramCursor)
  {
    Object localObject3 = null;
    this.d = new ArrayList();
    Object localObject2 = null;
    String str = paramCursor.getString(this.a);
    if (!asq.a(localObject2, str))
    {
      localObject2 = new NotificationData(paramCursor);
      this.d.add(localObject2);
      localObject3 = ((NotificationData)localObject2).b();
      if (localObject3 == null)
      {
        localObject1 = "";
        label71: ((NotificationData)localObject2).h = ((String)localObject1);
        if (((NotificationData)localObject2).j == null)
          break label140;
        ((NotificationData)localObject2).j.clear();
      }
      while (true)
      {
        if (localObject3 != null)
          ((NotificationData)localObject2).j.add(localObject3);
        localObject1 = localObject2;
        localObject2 = str;
        localObject3 = localObject1;
        if (paramCursor.moveToNext())
          break;
        Collections.reverse(this.d);
        return;
        localObject1 = localObject3;
        break label71;
        label140: ((NotificationData)localObject2).j = new ArrayList(15);
      }
    }
    str = paramCursor.getString(1);
    Object localObject1 = str;
    if (str == null)
    {
      str = paramCursor.getString(2);
      localObject1 = str;
      if (str == null)
        localObject1 = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((NotificationData)localObject3).h = ((String)localObject1 + "\n\n" + ((NotificationData)localObject3).h);
      ((NotificationData)localObject3).j.add(0, localObject1);
    }
    if (this.b);
    for (long l = Math.max(((NotificationData)localObject3).e, paramCursor.getLong(4)); ; l = Math.min(((NotificationData)localObject3).e, paramCursor.getLong(4)))
    {
      ((NotificationData)localObject3).e = l;
      localObject1 = localObject3;
      break;
    }
  }

  Cursor b()
  {
    return alo.a(this.e.getContext(), this.f.f(), false, true);
  }

  protected int c()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zx
 * JD-Core Version:    0.6.2
 */