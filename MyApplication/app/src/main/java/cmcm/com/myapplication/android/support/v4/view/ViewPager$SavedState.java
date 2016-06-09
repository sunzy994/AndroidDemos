package cmcm.com.myapplication.android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.*;
import android.view.View.BaseSavedState;
import cl;
import cn;

public class ViewPager$SavedState extends View.BaseSavedState
{
  public static final Creator<SavedState> CREATOR = cl.a(new cn()
  {
    public android.support.v4.view.ViewPager.SavedState b(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
    {
      return new android.support.v4.view.ViewPager.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
    }

    public android.support.v4.view.ViewPager.SavedState[] b(int paramAnonymousInt)
    {
      return new android.support.v4.view.ViewPager.SavedState[paramAnonymousInt];
    }
  });
  int a;
  Parcelable b;
  ClassLoader c;

  ViewPager$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel);
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null)
      localClassLoader = getClass().getClassLoader();
    this.a = paramParcel.readInt();
    this.b = paramParcel.readParcelable(localClassLoader);
    this.c = localClassLoader;
  }

  public ViewPager$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }

  public String toString()
  {
    return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPager.SavedState
 * JD-Core Version:    0.6.2
 */