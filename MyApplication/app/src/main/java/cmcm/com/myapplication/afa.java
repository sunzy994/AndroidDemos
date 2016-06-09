package cmcm.com.myapplication;

import java.io.File;
import org.json.JSONObject;

public final class afa extends ael
  implements Comparable
{
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;

  public afa(int paramInt)
  {
    this.a = paramInt;
  }

  public afa(JSONObject paramJSONObject, File paramFile, int paramInt)
  {
    this.a = paramInt;
    this.b = paramJSONObject.optInt("id");
    this.e = paramJSONObject.optString("cover");
    this.f = paramJSONObject.optString("file");
    this.c = (paramFile.getAbsolutePath() + "/" + this.b + "_preview.png");
    this.d = (paramFile.getAbsolutePath() + "/" + this.b + ".png");
  }

  public int compareTo(Object paramObject)
  {
    if ((paramObject instanceof afa))
    {
      paramObject = (afa)paramObject;
      return this.b - paramObject.b;
    }
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
    {
      do
        return false;
      while (!(paramObject instanceof afa));
      paramObject = (afa)paramObject;
    }
    while ((this.b != paramObject.b) || (!asq.a(this.c, paramObject.c)) || (!asq.a(this.d, paramObject.d)));
    return true;
  }

  public int hashCode()
  {
    int j = 0;
    int k = this.b;
    if (this.c != null);
    for (int i = this.c.hashCode(); ; i = 0)
    {
      if (this.d != null)
        j = this.d.hashCode();
      return (i + (k + 527) * 31) * 31 + j;
    }
  }

  public String toString()
  {
    return "Wallpaper{id=" + this.b + ",cover=" + aqx.a(this.c) + ",file=" + aqx.a(this.d) + ";sequence=" + this.a + "}";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afa
 * JD-Core Version:    0.6.2
 */