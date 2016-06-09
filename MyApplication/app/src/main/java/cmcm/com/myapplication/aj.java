package cmcm.com.myapplication;

import android.app.Notification;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

public class aj
{
  private static final ar a = new au();

  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new at();
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      a = new as();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new az();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new ay();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new ax();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new aw();
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      a = new av();
      return;
    }
  }

  public static Bundle a(Notification paramNotification)
  {
    return a.a(paramNotification);
  }

  public static String b(Notification paramNotification)
  {
    return a.b(paramNotification);
  }

  private static void b(ah paramah, ArrayList<ak> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
      paramah.a((ak)paramArrayList.next());
  }

  private static void b(ai paramai, ba paramba)
  {
    if (paramba != null)
    {
      if (!(paramba instanceof an))
        break label37;
      paramba = (an)paramba;
      bn.a(paramai, paramba.e, paramba.g, paramba.f, paramba.a);
    }
    label37: 
    do
    {
      return;
      if ((paramba instanceof aq))
      {
        paramba = (aq)paramba;
        bn.a(paramai, paramba.e, paramba.g, paramba.f, paramba.a);
        return;
      }
    }
    while (!(paramba instanceof am));
    paramba = (am)paramba;
    bn.a(paramai, paramba.e, paramba.g, paramba.f, paramba.a, paramba.b, paramba.c);
  }

  private static Notification[] b(Bundle paramBundle, String paramString)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (((arrayOfParcelable instanceof Notification[])) || (arrayOfParcelable == null))
      return (Notification[])arrayOfParcelable;
    Notification[] arrayOfNotification = new Notification[arrayOfParcelable.length];
    int i = 0;
    while (i < arrayOfParcelable.length)
    {
      arrayOfNotification[i] = ((Notification)arrayOfParcelable[i]);
      i += 1;
    }
    paramBundle.putParcelableArray(paramString, arrayOfNotification);
    return arrayOfNotification;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aj
 * JD-Core Version:    0.6.2
 */