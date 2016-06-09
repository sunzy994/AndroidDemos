package cmcm.com.myapplication.com.lazyswipe.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseIntArray;

public class ParcelableSparseIntArray extends SparseIntArray
  implements Parcelable
{
  public static Creator<ParcelableSparseIntArray> a = new Creator()
  {
    public ParcelableSparseIntArray a(Parcel paramAnonymousParcel)
    {
      ParcelableSparseIntArray localParcelableSparseIntArray = new ParcelableSparseIntArray();
      int j = paramAnonymousParcel.readInt();
      int[] arrayOfInt1 = new int[j];
      int[] arrayOfInt2 = new int[j];
      paramAnonymousParcel.readIntArray(arrayOfInt1);
      paramAnonymousParcel.readIntArray(arrayOfInt2);
      int i = 0;
      while (i < j)
      {
        localParcelableSparseIntArray.put(arrayOfInt1[i], arrayOfInt2[i]);
        i += 1;
      }
      return localParcelableSparseIntArray;
    }

    public ParcelableSparseIntArray[] a(int paramAnonymousInt)
    {
      return new ParcelableSparseIntArray[paramAnonymousInt];
    }
  };

  public ParcelableSparseIntArray()
  {
  }

  public ParcelableSparseIntArray(int paramInt)
  {
    super(paramInt);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = size();
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = new int[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfInt1[paramInt] = keyAt(paramInt);
      arrayOfInt2[paramInt] = valueAt(paramInt);
      paramInt += 1;
    }
    paramParcel.writeInt(i);
    paramParcel.writeIntArray(arrayOfInt1);
    paramParcel.writeIntArray(arrayOfInt2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.util.ParcelableSparseIntArray
 * JD-Core Version:    0.6.2
 */