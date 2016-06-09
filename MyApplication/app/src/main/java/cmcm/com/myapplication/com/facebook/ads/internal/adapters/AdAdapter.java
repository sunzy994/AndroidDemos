package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.server.AdPlacementType;

public abstract interface AdAdapter
{
  public abstract AdPlacementType getPlacementType();

  public abstract void onDestroy();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.AdAdapter
 * JD-Core Version:    0.6.2
 */