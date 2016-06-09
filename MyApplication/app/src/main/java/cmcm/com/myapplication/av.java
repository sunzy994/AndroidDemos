package cmcm.com.myapplication;

import android.app.Notification;

class av extends au
{
  public Notification a(ao paramao, ap paramap)
  {
    paramap = paramao.B;
    paramap.setLatestEventInfo(paramao.a, paramao.b, paramao.c, paramao.d);
    paramap = bj.a(paramap, paramao.a, paramao.b, paramao.c, paramao.d, paramao.e);
    if (paramao.j > 0)
      paramap.flags |= 128;
    return paramap;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     av
 * JD-Core Version:    0.6.2
 */