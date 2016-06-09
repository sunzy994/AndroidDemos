package cmcm.com.myapplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public abstract class pk
{
  private List<Exception> a = new ArrayList();
  private List<JSONObject> b = new ArrayList();
  private List<JSONObject> c = new ArrayList();
  private List<JSONObject> d = new ArrayList();
  private List<JSONObject> e = new ArrayList();
  private List<pk> f = new ArrayList();

  public void a(Exception paramException)
  {
    this.a.add(paramException);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((pk)localIterator.next()).a(paramException);
  }

  public void a(JSONObject paramJSONObject)
  {
    this.b.add(paramJSONObject);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((pk)localIterator.next()).a(paramJSONObject);
  }

  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("adInfo", paramJSONObject);
      ((JSONObject)localObject).put("userClose", paramBoolean);
      this.e.add(localObject);
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext())
        ((pk)((Iterator)localObject).next()).a(paramJSONObject, paramBoolean);
    }
    catch (Exception paramJSONObject)
    {
      po.c("AdEvent.onClose", paramJSONObject.getMessage());
    }
  }

  public void a(pk parampk)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      parampk.a((Exception)localIterator.next());
    localIterator = this.b.iterator();
    while (localIterator.hasNext())
      parampk.a((JSONObject)localIterator.next());
    localIterator = this.c.iterator();
    while (localIterator.hasNext())
      parampk.b((JSONObject)localIterator.next());
    localIterator = this.d.iterator();
    while (localIterator.hasNext())
      parampk.c((JSONObject)localIterator.next());
    localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      JSONObject localJSONObject = (JSONObject)localIterator.next();
      try
      {
        parampk.a(localJSONObject.getJSONObject("adInfo"), localJSONObject.getBoolean("userClose"));
      }
      catch (Exception localException)
      {
        po.c("AdEvent.addChild", localException.getMessage());
      }
    }
    this.f.add(parampk);
  }

  public void b(JSONObject paramJSONObject)
  {
    this.c.add(paramJSONObject);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((pk)localIterator.next()).b(paramJSONObject);
  }

  public void c(JSONObject paramJSONObject)
  {
    this.d.add(paramJSONObject);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((pk)localIterator.next()).c(paramJSONObject);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     pk
 * JD-Core Version:    0.6.2
 */