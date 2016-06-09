package com.oppo.launcher.effect;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EffectInfo
  implements Parcelable
{
  public static final Creator<EffectInfo> CREATOR = new Creator()
  {
    public EffectInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EffectInfo(paramAnonymousParcel);
    }

    public EffectInfo[] newArray(int paramAnonymousInt)
    {
      return new EffectInfo[paramAnonymousInt];
    }
  };
  private int mAuthorId = -1;
  private int mClassNameId = -1;
  private int mIconId = -1;
  private int mLeftPreId = -1;
  private int mNameId = -1;
  private int mPreviewId = -1;
  private int mRightPreId = -1;

  public EffectInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.mNameId = paramInt1;
    this.mAuthorId = paramInt2;
    this.mIconId = paramInt3;
    this.mClassNameId = paramInt4;
    this.mLeftPreId = paramInt5;
    this.mRightPreId = paramInt6;
    this.mPreviewId = paramInt7;
  }

  public EffectInfo(Parcel paramParcel)
  {
    this.mNameId = paramParcel.readInt();
    this.mAuthorId = paramParcel.readInt();
    this.mIconId = paramParcel.readInt();
    this.mClassNameId = paramParcel.readInt();
    this.mLeftPreId = paramParcel.readInt();
    this.mRightPreId = paramParcel.readInt();
    this.mPreviewId = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAuthor(Context paramContext)
  {
    return paramContext.getResources().getString(this.mAuthorId);
  }

  public String getClassName(Context paramContext)
  {
    return paramContext.getResources().getString(this.mClassNameId);
  }

  public Drawable getIcon(Context paramContext)
  {
    return paramContext.getResources().getDrawable(this.mIconId);
  }

  public Drawable getLeftPreView(Context paramContext)
  {
    return paramContext.getResources().getDrawable(this.mLeftPreId);
  }

  public String getName(Context paramContext)
  {
    return paramContext.getResources().getString(this.mNameId);
  }

  public Drawable getPreview(Context paramContext)
  {
    return paramContext.getResources().getDrawable(this.mPreviewId);
  }

  public Drawable getRightPreView(Context paramContext)
  {
    return paramContext.getResources().getDrawable(this.mRightPreId);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mNameId);
    paramParcel.writeInt(this.mAuthorId);
    paramParcel.writeInt(this.mIconId);
    paramParcel.writeInt(this.mClassNameId);
    paramParcel.writeInt(this.mLeftPreId);
    paramParcel.writeInt(this.mRightPreId);
    paramParcel.writeInt(this.mPreviewId);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.effect.EffectInfo
 * JD-Core Version:    0.6.2
 */