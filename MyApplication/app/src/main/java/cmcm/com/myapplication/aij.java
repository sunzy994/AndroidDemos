package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class aij
{
  protected static final String a = "Swipe." + aij.class.getSimpleName();
  protected final Context b;
  protected ain c = null;
  protected boolean d = true;
  private ais e;

  public aij(Context paramContext)
  {
    this.b = paramContext;
  }

  private String a(Element paramElement)
  {
    try
    {
      String str = paramElement.getTextContent();
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return paramElement.getFirstChild().getNodeValue();
  }

  private List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.split(",");
    if ((paramString != null) && (paramString.length > 0))
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = paramString[i];
        if (!TextUtils.isEmpty(localCharSequence))
          localArrayList.add(localCharSequence.toLowerCase());
        i += 1;
      }
    }
    return localArrayList;
  }

  private void a(aip paramaip, Element paramElement)
  {
    NodeList localNodeList = paramElement.getElementsByTagName("font");
    int i = 0;
    Object localObject1;
    int j;
    while (i < localNodeList.getLength())
    {
      localObject1 = ((Element)localNodeList.item(i)).getChildNodes();
      j = 0;
      if (j < ((NodeList)localObject1).getLength())
      {
        Object localObject2 = ((NodeList)localObject1).item(j);
        if (((Node)localObject2).getNodeType() == 1)
        {
          localObject2 = (Element)localObject2;
          if (!"color".equals(((Element)localObject2).getNodeName()))
            break label125;
          paramaip.a = ((int)Long.parseLong(a((Element)localObject2), 16));
        }
        while (true)
        {
          j += 1;
          break;
          label125: if ("size".equals(((Element)localObject2).getNodeName()))
            paramaip.b = Integer.parseInt(a((Element)localObject2));
          else if ("file".equals(((Element)localObject2).getNodeName()))
            paramaip.c = a((Element)localObject2);
        }
      }
      i += 1;
    }
    paramElement = paramElement.getElementsByTagName("icon");
    i = 0;
    while (i < paramElement.getLength())
    {
      localNodeList = ((Element)paramElement.item(i)).getChildNodes();
      j = 0;
      while (j < localNodeList.getLength())
      {
        localObject1 = localNodeList.item(j);
        if (((Node)localObject1).getNodeType() == 1)
        {
          localObject1 = (Element)localObject1;
          if ("size".equals(((Element)localObject1).getNodeName()))
            paramaip.d = Integer.parseInt(a((Element)localObject1));
        }
        j += 1;
      }
      i += 1;
    }
  }

  protected aim a(InputStream paramInputStream)
  {
    ain localain = new ain();
    while (true)
    {
      int i;
      Object localObject;
      try
      {
        NodeList localNodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(paramInputStream).getDocumentElement().getChildNodes();
        i = 0;
        if (i >= localNodeList.getLength())
          break label435;
        localObject = localNodeList.item(i);
        if (((Node)localObject).getNodeType() != 1)
          break label470;
        localObject = (Element)localObject;
        if ("packageName".equals(((Element)localObject).getNodeName()))
          localain.a = a((Element)localObject);
        else if ("versionName".equals(((Element)localObject).getNodeName()))
          localain.b = a((Element)localObject);
      }
      catch (Exception localException)
      {
        Log.e(a, "parse config error", localException);
        return null;
        if ("versionCode".equals(((Element)localObject).getNodeName()))
          localException.c = Integer.valueOf(Integer.parseInt(a((Element)localObject)));
      }
      finally
      {
        arf.a(paramInputStream);
      }
      if ("specification".equals(((Element)localObject).getNodeName()))
      {
        localaim.d = a((Element)localObject);
      }
      else if ("features".equals(((Element)localObject).getNodeName()))
      {
        localaim.g = a(a((Element)localObject));
      }
      else if ("requiredFeatures".equals(((Element)localObject).getNodeName()))
      {
        localaim.h = a(a((Element)localObject));
      }
      else if ("encrypt".equals(((Element)localObject).getNodeName()))
      {
        localaim.i = aio.values()[Integer.parseInt(a(localObject))];
      }
      else if ("requireValidation".equals(((Element)localObject).getNodeName()))
      {
        localaim.j = Boolean.parseBoolean(a((Element)localObject));
      }
      else if ("defaultDensity".equals(((Element)localObject).getNodeName()))
      {
        localaim.f = Integer.parseInt(a((Element)localObject));
      }
      else if ("launcher".equals(((Element)localObject).getNodeName()))
      {
        a(localaim.k, (Element)localObject);
      }
      else if ("requiredVersion".equals(((Element)localObject).getNodeName()))
      {
        localaim.e = Integer.parseInt(a((Element)localObject));
        break label470;
        label435: arf.a(paramInputStream);
        if ((TextUtils.isEmpty(localaim.a())) || (localaim.b() == null) || (TextUtils.isEmpty(localaim.c())))
          return null;
        return localaim;
      }
      label470: i += 1;
    }
  }

  protected void a(ais paramais, String paramString)
  {
    boolean bool = true;
    paramString = new JSONObject(paramString);
    paramais.a = paramString.getString("name");
    paramais.b = paramString.getString("author");
    paramais.c = paramString.getString("size");
    if (paramString.optInt("isDefault", 0) == 1);
    while (true)
    {
      paramais.f = bool;
      return;
      bool = false;
    }
  }

  protected aio b(String paramString)
  {
    if (this.c.e() == aio.a)
      return aio.a;
    if (this.c.e() == aio.b)
    {
      if ((paramString.endsWith(".png")) || (paramString.endsWith(".jpg")))
        return aio.b;
      return aio.a;
    }
    return this.c.e();
  }

  protected abstract aim c();

  protected abstract ais d();

  public aim e()
  {
    if (this.c == null)
      this.c = ((ain)c());
    return this.c;
  }

  public ais f()
  {
    if (this.e != null)
      return this.e;
    this.e = d();
    if (this.e == null)
      this.e = new ais();
    return this.e;
  }

  protected boolean g()
  {
    boolean bool = true;
    if (this.c != null)
      return true;
    if (!this.d)
      return false;
    e();
    if (this.c != null);
    while (true)
    {
      this.d = bool;
      return this.d;
      bool = false;
    }
  }

  public boolean h()
  {
    e();
    List localList = this.c.f();
    if (localList == null)
      return false;
    return localList.contains("omniswipe");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aij
 * JD-Core Version:    0.6.2
 */