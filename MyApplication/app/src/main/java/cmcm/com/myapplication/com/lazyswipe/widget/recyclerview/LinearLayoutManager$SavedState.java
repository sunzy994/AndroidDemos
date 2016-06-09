package cmcm.com.myapplication.com.lazyswipe.widget.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class LinearLayoutManager$SavedState
  implements Parcelable
{
  public static final Creator<SavedState> CREATOR = new Creator()
  {
    public LinearLayoutManager.SavedState a(Parcel paramAnonymousParcel)
    {
      return new LinearLayoutManager.SavedState(paramAnonymousParcel);
    }

    public LinearLayoutManager.SavedState[] a(int paramAnonymousInt)
    {
      return new LinearLayoutManager.SavedState[paramAnonymousInt];
    }
  };
  int a;
  int b;
  boolean c;

  public LinearLayoutManager$SavedState()
  {
  }

  LinearLayoutManager$SavedState(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    if (paramParcel.readInt() == 1);
    while (true)
    {
      this.c = bool;
      return;
      bool = false;
    }
  }

  public LinearLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.a = paramSavedState.a;
    this.b = paramSavedState.b;
    this.c = paramSavedState.c;
  }

  boolean a()
  {
    return this.a >= 0;
  }

  void b()
  {
    this.a = -1;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    if (this.c);
    for (paramInt = 1; ; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.recyclerview.LinearLayoutManager.SavedState
 * JD-Core Version:    0.6.2
 */