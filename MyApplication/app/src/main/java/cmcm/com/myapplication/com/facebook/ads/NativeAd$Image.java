package cmcm.com.myapplication.com.facebook.ads;

import org.json.JSONObject;

public class NativeAd$Image
{
  private final String a;
  private final int b;
  private final int c;

  private NativeAd$Image(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
  }

  public static Image fromJSONObject(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null);
    String str;
    do
    {
      return null;
      str = paramJSONObject.optString("url");
    }
    while (str == null);
    return new Image(str, paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }

  public int getHeight()
  {
    return this.c;
  }

  public String getUrl()
  {
    return this.a;
  }

  public int getWidth()
  {
    return this.b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.NativeAd.Image
 * JD-Core Version:    0.6.2
 */