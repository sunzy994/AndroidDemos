package cmcm.com.myapplication.com.lazyswipe.widget.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import ayy;

class RecyclerView$SavedState extends View.BaseSavedState
{
  public static final Creator<SavedState> CREATOR = new Creator()
  {
    public RecyclerView.SavedState a(Parcel paramAnonymousParcel)
    {
      return new RecyclerView.SavedState(paramAnonymousParcel);
    }

    public RecyclerView.SavedState[] a(int paramAnonymousInt)
    {
      return new RecyclerView.SavedState[paramAnonymousInt];
    }
  };
  Parcelable a;

  RecyclerView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readParcelable(ayy.class.getClassLoader());
  }

  RecyclerView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }

  private void a(SavedState paramSavedState)
  {
    this.a = paramSavedState.a;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.a, 0);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.recyclerview.RecyclerView.SavedState
 * JD-Core Version:    0.6.2
 */