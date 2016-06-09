package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdView.Type;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m extends a
{
  private final n b;
  private NativeAdView.Type c;
  private boolean d;
  private boolean e;
  private boolean f;
  private View g;
  private List<View> h;

  public m(Context paramContext, b paramb, n paramn)
  {
    super(paramContext, paramb);
    this.b = paramn;
  }

  private String b(View paramView)
  {
    try
    {
      paramView = c(paramView).toString();
      return paramView;
    }
    catch (JSONException paramView)
    {
    }
    return "Json exception";
  }

  private JSONObject c(View paramView)
  {
    boolean bool = true;
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("id", Integer.valueOf(paramView.getId()));
    localJSONObject.putOpt("class", paramView.getClass());
    localJSONObject.putOpt("origin", String.format("{x:%d, y:%d}", new Object[] { Integer.valueOf(paramView.getTop()), Integer.valueOf(paramView.getLeft()) }));
    localJSONObject.putOpt("size", String.format("{h:%d, w:%d}", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getWidth()) }));
    Object localObject;
    if ((this.h != null) && (this.h.contains(paramView)))
    {
      localJSONObject.putOpt("clickable", Boolean.valueOf(bool));
      localObject = "unknown";
      if (!(paramView instanceof TextView))
        break label223;
      localObject = "text";
    }
    while (true)
    {
      localJSONObject.putOpt("type", localObject);
      if (!(paramView instanceof ViewGroup))
        break label283;
      paramView = (ViewGroup)paramView;
      localObject = new JSONArray();
      while (i < paramView.getChildCount())
      {
        ((JSONArray)localObject).put(c(paramView.getChildAt(i)));
        i += 1;
      }
      bool = false;
      break;
      label223: if ((paramView instanceof Button))
        localObject = "button";
      else if ((paramView instanceof ImageView))
        localObject = "image";
      else if ((paramView instanceof MediaView))
        localObject = "mediaview";
      else if ((paramView instanceof ViewGroup))
        localObject = "viewgroup";
    }
    localJSONObject.putOpt("list", localObject);
    label283: return localJSONObject;
  }

  private String d(View paramView)
  {
    if ((paramView.getWidth() <= 0) || (paramView.getHeight() <= 0))
      return "";
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Config.ARGB_8888);
      localBitmap.setDensity(paramView.getResources().getDisplayMetrics().densityDpi);
      paramView.draw(new Canvas(localBitmap));
      paramView = new ByteArrayOutputStream();
      localBitmap.compress(CompressFormat.JPEG, this.b.h(), paramView);
      paramView = Base64.encodeToString(paramView.toByteArray(), 0);
      return paramView;
    }
    catch (Exception paramView)
    {
    }
    return "";
  }

  public void a(View paramView)
  {
    this.g = paramView;
  }

  public void a(NativeAdView.Type paramType)
  {
    this.c = paramType;
  }

  public void a(List<View> paramList)
  {
    this.h = paramList;
  }

  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  protected void b()
  {
    if (this.b == null)
      return;
    HashMap localHashMap = new HashMap();
    if (this.a != null)
    {
      localHashMap.put("mil", Boolean.valueOf(this.a.a()));
      localHashMap.put("eil", Boolean.valueOf(this.a.b()));
      localHashMap.put("eil_source", this.a.c());
    }
    if (this.c != null)
      localHashMap.put("nti", String.valueOf(this.c.getValue()));
    if (this.d)
      localHashMap.put("nhs", String.valueOf(this.d));
    if (this.e)
      localHashMap.put("nmv", String.valueOf(this.e));
    if (this.f)
      localHashMap.put("nmvap", String.valueOf(this.f));
    if ((this.g != null) && (this.b.e()))
      localHashMap.put("view", b(this.g));
    if ((this.g != null) && (this.b.g()))
      localHashMap.put("snapshot", d(this.g));
    this.b.a(localHashMap);
  }

  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.m
 * JD-Core Version:    0.6.2
 */