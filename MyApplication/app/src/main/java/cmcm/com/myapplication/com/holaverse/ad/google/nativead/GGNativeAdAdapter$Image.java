package cmcm.com.myapplication.com.holaverse.ad.google.nativead;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public class GGNativeAdAdapter$Image
{
  private Drawable a;
  private Uri b;

  public GGNativeAdAdapter$Image(Drawable paramDrawable, Uri paramUri)
  {
    this.a = paramDrawable;
    this.b = paramUri;
  }

  public Drawable getDrawable()
  {
    return this.a;
  }

  public Uri getUri()
  {
    return this.b;
  }

  public void setDrawable(Drawable paramDrawable)
  {
    this.a = paramDrawable;
  }

  public void setUri(Uri paramUri)
  {
    this.b = paramUri;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.ad.google.nativead.GGNativeAdAdapter.Image
 * JD-Core Version:    0.6.2
 */