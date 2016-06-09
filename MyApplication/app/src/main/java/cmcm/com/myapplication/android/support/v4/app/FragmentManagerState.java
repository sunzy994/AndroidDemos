package cmcm.com.myapplication.android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.*;
import android.support.v4.app.BackStackState;

public final class FragmentManagerState
  implements Parcelable
{
  public static final Creator<FragmentManagerState> CREATOR = new Creator()
  {
    public FragmentManagerState a(Parcel paramAnonymousParcel)
    {
      return new FragmentManagerState(paramAnonymousParcel);
    }

    public FragmentManagerState[] a(int paramAnonymousInt)
    {
      return new FragmentManagerState[paramAnonymousInt];
    }
  };
  public android.support.v4.app.FragmentState[] a;
  public int[] b;
  public android.support.v4.app.BackStackState[] c;

  public FragmentManagerState()
  {
  }

  public FragmentManagerState(Parcel paramParcel)
  {
    this.a = ((android.support.v4.app.FragmentState[])paramParcel.createTypedArray(android.support.v4.app.FragmentState.CREATOR));
    this.b = paramParcel.createIntArray();
    this.c = ((android.support.v4.app.BackStackState[])paramParcel.createTypedArray(android.support.v4.app.BackStackState.CREATOR));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.a, paramInt);
    paramParcel.writeIntArray(this.b);
    paramParcel.writeTypedArray(this.c, paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerState
 * JD-Core Version:    0.6.2
 */