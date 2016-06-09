package cmcm.com.myapplication.com.lazyswipe.notification;

import android.annotation.TargetApi;
import android.app.Notification.Action;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import br;

public class NotificationData$Action
  implements Parcelable
{
  public static final Creator<Action> CREATOR = new Creator()
  {
    public NotificationData.Action a(Parcel paramAnonymousParcel)
    {
      return new NotificationData.Action(paramAnonymousParcel);
    }

    public NotificationData.Action[] a(int paramAnonymousInt)
    {
      return new NotificationData.Action[paramAnonymousInt];
    }
  };
  public int a;
  public CharSequence b;
  public PendingIntent c;
  public br[] d = null;

  public NotificationData$Action()
  {
  }

  @TargetApi(19)
  public NotificationData$Action(Notification.Action paramAction)
  {
    this.b = paramAction.title;
    this.a = paramAction.icon;
    this.c = paramAction.actionIntent;
  }

  public NotificationData$Action(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
      this.b = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    if (paramParcel.readInt() != 0)
      this.c = PendingIntent.readPendingIntentOrNullFromParcel(paramParcel);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    if (this.b != null)
    {
      paramParcel.writeInt(1);
      TextUtils.writeToParcel(this.b, paramParcel, paramInt);
    }
    while (this.c != null)
    {
      paramParcel.writeInt(1);
      PendingIntent.writePendingIntentOrNullToParcel(this.c, paramParcel);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.notification.NotificationData.Action
 * JD-Core Version:    0.6.2
 */