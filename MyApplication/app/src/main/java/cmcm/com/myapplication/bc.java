package cmcm.com.myapplication;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.RemoteInput;
import android.os.Parcelable;
import java.util.ArrayList;

class bc
{
  private static bh a(Action paramAction, bi parambi, ca paramca)
  {
    paramca = bx.a(paramAction.getRemoteInputs(), paramca);
    return parambi.b(paramAction.icon, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), paramca);
  }

  public static String a(Notification paramNotification)
  {
    return paramNotification.getGroup();
  }

  public static void a(Notification.Builder paramBuilder, bh parambh)
  {
    Action.Builder localBuilder = new Action.Builder(parambh.a(), parambh.b(), parambh.c());
    if (parambh.f() != null)
    {
      RemoteInput[] arrayOfRemoteInput = bx.a(parambh.f());
      int j = arrayOfRemoteInput.length;
      int i = 0;
      while (i < j)
      {
        localBuilder.addRemoteInput(arrayOfRemoteInput[i]);
        i += 1;
      }
    }
    if (parambh.d() != null)
      localBuilder.addExtras(parambh.d());
    paramBuilder.addAction(localBuilder.build());
  }

  public static bh[] a(ArrayList<Parcelable> paramArrayList, bi parambi, ca paramca)
  {
    if (paramArrayList == null)
      return null;
    bh[] arrayOfbh = parambi.b(paramArrayList.size());
    int i = 0;
    while (i < arrayOfbh.length)
    {
      arrayOfbh[i] = a((Action)paramArrayList.get(i), parambi, paramca);
      i += 1;
    }
    return arrayOfbh;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     bc
 * JD-Core Version:    0.6.2
 */