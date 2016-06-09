package cmcm.com.myapplication;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;

class ay extends au
{
  public Notification a(ao paramao, ap paramap)
  {
    bo localbo = new bo(paramao.a, paramao.B, paramao.b, paramao.c, paramao.h, paramao.f, paramao.i, paramao.d, paramao.e, paramao.g, paramao.o, paramao.p, paramao.q, paramao.l, paramao.j, paramao.n, paramao.v, paramao.x, paramao.r, paramao.s, paramao.t);
    aj.a(localbo, paramao.u);
    aj.a(localbo, paramao.m);
    return paramap.a(paramao, localbo);
  }

  public Bundle a(Notification paramNotification)
  {
    return bn.a(paramNotification);
  }

  public ak[] a(ArrayList<Parcelable> paramArrayList)
  {
    return (ak[]) bn.a(paramArrayList, ak.d, br.a);
  }

  public String b(Notification paramNotification)
  {
    return bn.b(paramNotification);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ay
 * JD-Core Version:    0.6.2
 */