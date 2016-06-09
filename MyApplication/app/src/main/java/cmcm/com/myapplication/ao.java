package cmcm.com.myapplication;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class ao
{
  Notification A;
  public Notification B = new Notification();
  public ArrayList<String> C;
  public Context a;
  public CharSequence b;
  public CharSequence c;
  PendingIntent d;
  PendingIntent e;
  RemoteViews f;
  public Bitmap g;
  public CharSequence h;
  public int i;
  int j;
  boolean k = true;
  public boolean l;
  public ba m;
  public CharSequence n;
  int o;
  int p;
  boolean q;
  String r;
  boolean s;
  String t;
  public ArrayList<ak> u = new ArrayList();
  boolean v = false;
  String w;
  Bundle x;
  int y = 0;
  int z = 0;

  public ao(Context paramContext)
  {
    this.a = paramContext;
    this.B.when = System.currentTimeMillis();
    this.B.audioStreamType = -1;
    this.j = 0;
    this.C = new ArrayList();
  }

  protected static CharSequence e(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null);
    while (paramCharSequence.length() <= 5120)
      return paramCharSequence;
    return paramCharSequence.subSequence(0, 5120);
  }

  public Notification a()
  {
    return aj.a().a(this, b());
  }

  public ao a(int paramInt)
  {
    this.B.icon = paramInt;
    return this;
  }

  public ao a(ba paramba)
  {
    if (this.m != paramba)
    {
      this.m = paramba;
      if (this.m != null)
        this.m.a(this);
    }
    return this;
  }

  public ao a(CharSequence paramCharSequence)
  {
    this.b = e(paramCharSequence);
    return this;
  }

  public ao b(CharSequence paramCharSequence)
  {
    this.c = e(paramCharSequence);
    return this;
  }

  protected ap b()
  {
    return new ap();
  }

  public ao c(CharSequence paramCharSequence)
  {
    this.n = e(paramCharSequence);
    return this;
  }

  public ao d(CharSequence paramCharSequence)
  {
    this.h = e(paramCharSequence);
    return this;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ao
 * JD-Core Version:    0.6.2
 */