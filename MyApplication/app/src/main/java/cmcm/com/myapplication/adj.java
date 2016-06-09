package cmcm.com.myapplication;

import java.io.File;
import org.json.JSONObject;

public class adj
{
  public int a;
  public String b;

  private File a(String paramString)
  {
    paramString = arh.a(paramString) + ".png";
    return new File(aro.a("leap/"), paramString);
  }

  private boolean a()
  {
    return a(this.b).exists();
  }

  private static adj b(JSONObject paramJSONObject)
  {
    adj localadj = new adj();
    localadj.a = paramJSONObject.optInt("id");
    localadj.b = paramJSONObject.optString("iconUrl");
    return localadj;
  }

  public String toString()
  {
    return "[" + super.toString() + "]: index = " + this.a + ", url = " + this.b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adj
 * JD-Core Version:    0.6.2
 */