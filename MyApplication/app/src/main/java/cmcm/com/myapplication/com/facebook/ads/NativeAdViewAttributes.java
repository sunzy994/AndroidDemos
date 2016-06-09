package cmcm.com.myapplication.com.facebook.ads;

import android.graphics.Color;
import android.graphics.Typeface;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.c;
import org.json.JSONObject;

public class NativeAdViewAttributes
{
  private Typeface a = Typeface.DEFAULT;
  private int b = -1;
  private int c = -16777216;
  private int d = -11643291;
  private int e = 0;
  private int f = -12420889;
  private int g = -12420889;
  private boolean h = true;

  public NativeAdViewAttributes()
  {
  }

  public NativeAdViewAttributes(JSONObject paramJSONObject)
  {
    try
    {
      int i;
      int m;
      int n;
      int j;
      if (paramJSONObject.getBoolean("background_transparent"))
      {
        i = 0;
        m = Color.parseColor(paramJSONObject.getString("title_text_color"));
        n = Color.parseColor(paramJSONObject.getString("description_text_color"));
        if (!paramJSONObject.getBoolean("button_transparent"))
          break label181;
        j = 0;
        label97: if (!paramJSONObject.getBoolean("button_border_transparent"))
          break label194;
      }
      while (true)
      {
        int i1 = Color.parseColor(paramJSONObject.getString("button_text_color"));
        paramJSONObject = Typeface.create(paramJSONObject.getString("android_typeface"), 0);
        this.b = i;
        this.c = m;
        this.d = n;
        this.e = j;
        this.g = k;
        this.f = i1;
        this.a = paramJSONObject;
        return;
        i = Color.parseColor(paramJSONObject.getString("background_color"));
        break;
        label181: j = Color.parseColor(paramJSONObject.getString("button_color"));
        break label97;
        label194: k = Color.parseColor(paramJSONObject.getString("button_border_color"));
      }
    }
    catch (Exception paramJSONObject)
    {
      c.a(b.a(paramJSONObject, "Error retrieving native ui configuration data"));
    }
  }

  public boolean getAutoplay()
  {
    return this.h;
  }

  public int getBackgroundColor()
  {
    return this.b;
  }

  public int getButtonBorderColor()
  {
    return this.g;
  }

  public int getButtonColor()
  {
    return this.e;
  }

  public int getButtonTextColor()
  {
    return this.f;
  }

  public int getDescriptionTextColor()
  {
    return this.d;
  }

  public int getDescriptionTextSize()
  {
    return 10;
  }

  public int getTitleTextColor()
  {
    return this.c;
  }

  public int getTitleTextSize()
  {
    return 16;
  }

  public Typeface getTypeface()
  {
    return this.a;
  }

  public NativeAdViewAttributes setAutoplay(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }

  public NativeAdViewAttributes setBackgroundColor(int paramInt)
  {
    this.b = paramInt;
    return this;
  }

  public NativeAdViewAttributes setButtonBorderColor(int paramInt)
  {
    this.g = paramInt;
    return this;
  }

  public NativeAdViewAttributes setButtonColor(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public NativeAdViewAttributes setButtonTextColor(int paramInt)
  {
    this.f = paramInt;
    return this;
  }

  public NativeAdViewAttributes setDescriptionTextColor(int paramInt)
  {
    this.d = paramInt;
    return this;
  }

  public NativeAdViewAttributes setTitleTextColor(int paramInt)
  {
    this.c = paramInt;
    return this;
  }

  public NativeAdViewAttributes setTypeface(Typeface paramTypeface)
  {
    this.a = paramTypeface;
    return this;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.NativeAdViewAttributes
 * JD-Core Version:    0.6.2
 */