package cmcm.com.myapplication;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bn
{
  private static final Object a = new Object();
  private static Field b;
  private static boolean c;
  private static final Object d = new Object();

  public static Bundle a(Builder paramBuilder, bh parambh)
  {
    paramBuilder.addAction(parambh.a(), parambh.b(), parambh.c());
    paramBuilder = new Bundle(parambh.d());
    if (parambh.f() != null)
      paramBuilder.putParcelableArray("android.support.remoteInputs", cb.a(parambh.f()));
    return paramBuilder;
  }

  public static Bundle a(Notification paramNotification)
  {
    synchronized (a)
    {
      if (c)
        return null;
    }
    try
    {
      if (b == null)
      {
        localObject1 = Notification.class.getDeclaredField("extras");
        if (!Bundle.class.isAssignableFrom(((Field)localObject1).getType()))
        {
          Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
          c = true;
          return null;
        }
        ((Field)localObject1).setAccessible(true);
        b = (Field)localObject1;
      }
      Bundle localBundle = (Bundle)b.get(paramNotification);
      Object localObject1 = localBundle;
      if (localBundle == null)
      {
        localObject1 = new Bundle();
        b.set(paramNotification, localObject1);
      }
      return localObject1;
      paramNotification = finally;
      throw paramNotification;
    }
    catch (IllegalAccessException paramNotification)
    {
      Log.e("NotificationCompat", "Unable to access notification extras", paramNotification);
      c = true;
      return null;
    }
    catch (NoSuchFieldException paramNotification)
    {
      while (true)
        Log.e("NotificationCompat", "Unable to access notification extras", paramNotification);
    }
  }

  public static SparseArray<Bundle> a(List<Bundle> paramList)
  {
    Object localObject1 = null;
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Bundle localBundle = (Bundle)paramList.get(i);
      Object localObject2 = localObject1;
      if (localBundle != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
          localObject2 = new SparseArray();
        ((SparseArray)localObject2).put(i, localBundle);
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }

  private static bh a(Bundle paramBundle, bi parambi, ca paramca)
  {
    return parambi.b(paramBundle.getInt("icon"), paramBundle.getCharSequence("title"), (PendingIntent)paramBundle.getParcelable("actionIntent"), paramBundle.getBundle("extras"), cb.a(j.a(paramBundle, "remoteInputs"), paramca));
  }

  public static void a(ai paramai, CharSequence paramCharSequence1, boolean paramBoolean1, CharSequence paramCharSequence2, Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean2)
  {
    paramai = new BigPictureStyle(paramai.a()).setBigContentTitle(paramCharSequence1).bigPicture(paramBitmap1);
    if (paramBoolean2)
      paramai.bigLargeIcon(paramBitmap2);
    if (paramBoolean1)
      paramai.setSummaryText(paramCharSequence2);
  }

  public static void a(ai paramai, CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    paramai = new BigTextStyle(paramai.a()).setBigContentTitle(paramCharSequence1).bigText(paramCharSequence3);
    if (paramBoolean)
      paramai.setSummaryText(paramCharSequence2);
  }

  public static void a(ai paramai, CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, ArrayList<CharSequence> paramArrayList)
  {
    paramai = new InboxStyle(paramai.a()).setBigContentTitle(paramCharSequence1);
    if (paramBoolean)
      paramai.setSummaryText(paramCharSequence2);
    paramCharSequence1 = paramArrayList.iterator();
    while (paramCharSequence1.hasNext())
      paramai.addLine((CharSequence)paramCharSequence1.next());
  }

  public static bh[] a(ArrayList<Parcelable> paramArrayList, bi parambi, ca paramca)
  {
    if (paramArrayList == null)
      return null;
    bh[] arrayOfbh = parambi.b(paramArrayList.size());
    int i = 0;
    while (i < arrayOfbh.length)
    {
      arrayOfbh[i] = a((Bundle)paramArrayList.get(i), parambi, paramca);
      i += 1;
    }
    return arrayOfbh;
  }

  public static String b(Notification paramNotification)
  {
    return a(paramNotification).getString("android.support.groupKey");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     bn
 * JD-Core Version:    0.6.2
 */