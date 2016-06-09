package cmcm.com.myapplication;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bb
{
  private ArrayList<ak> a = new ArrayList();
  private int b = 1;
  private PendingIntent c;
  private ArrayList<Notification> d = new ArrayList();
  private Bitmap e;
  private int f;
  private int g = 8388613;
  private int h = -1;
  private int i = 0;
  private int j;
  private int k = 80;
  private int l;

  public bb()
  {
  }

  public bb(Notification paramNotification)
  {
    paramNotification = aj.a(paramNotification);
    if (paramNotification != null);
    for (paramNotification = paramNotification.getBundle("android.wearable.EXTENSIONS"); ; paramNotification = null)
    {
      if (paramNotification != null)
      {
        Object localObject = aj.a().a(paramNotification.getParcelableArrayList("actions"));
        if (localObject != null)
          Collections.addAll(this.a, (Object[])localObject);
        this.b = paramNotification.getInt("flags", 1);
        this.c = ((PendingIntent)paramNotification.getParcelable("displayIntent"));
        localObject = aj.a(paramNotification, "pages");
        if (localObject != null)
          Collections.addAll(this.d, (Object[])localObject);
        this.e = ((Bitmap)paramNotification.getParcelable("background"));
        this.f = paramNotification.getInt("contentIcon");
        this.g = paramNotification.getInt("contentIconGravity", 8388613);
        this.h = paramNotification.getInt("contentActionIndex", -1);
        this.i = paramNotification.getInt("customSizePreset", 0);
        this.j = paramNotification.getInt("customContentHeight");
        this.k = paramNotification.getInt("gravity", 80);
        this.l = paramNotification.getInt("hintScreenTimeout");
      }
      return;
    }
  }

  public bb a()
  {
    bb localbb = new bb();
    localbb.a = new ArrayList(this.a);
    localbb.b = this.b;
    localbb.c = this.c;
    localbb.d = new ArrayList(this.d);
    localbb.e = this.e;
    localbb.f = this.f;
    localbb.g = this.g;
    localbb.h = this.h;
    localbb.i = this.i;
    localbb.j = this.j;
    localbb.k = this.k;
    localbb.l = this.l;
    return localbb;
  }

  public bb a(ak paramak)
  {
    this.a.add(paramak);
    return this;
  }

  public bb b()
  {
    this.a.clear();
    return this;
  }

  public List<ak> c()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     bb
 * JD-Core Version:    0.6.2
 */