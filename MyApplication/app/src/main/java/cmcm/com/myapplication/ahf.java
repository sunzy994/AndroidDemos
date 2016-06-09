package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONObject;

public class ahf
{
  public String a;
  public Bitmap b;
  public int c;

  public static ahf a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      paramString = new JSONObject(paramString);
      ahf localahf = new ahf();
      localahf.c = paramString.getInt("bgColor");
      localahf.a = paramString.getString("bgImgUrl");
      return localahf;
    }
    catch (Throwable paramString)
    {
    }
    return null;
  }

  public static String a(ahf paramahf)
  {
    if (paramahf == null)
      return null;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("bgColor", paramahf.c);
      localJSONObject.put("bgImgUrl", paramahf.a);
      paramahf = localJSONObject.toString();
      return paramahf;
    }
    catch (Throwable paramahf)
    {
    }
    return null;
  }

  public File a()
  {
    return new File(ahe.a, arh.a(this.a));
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        paramObject = (ahf)paramObject;
        if (this.a != null)
          break;
      }
      while (paramObject.a == null);
      return false;
    }
    while (this.a.equals(paramObject.a));
    return false;
  }

  public int hashCode()
  {
    if (this.a == null);
    for (int i = 0; ; i = this.a.hashCode())
      return i + 31;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahf
 * JD-Core Version:    0.6.2
 */