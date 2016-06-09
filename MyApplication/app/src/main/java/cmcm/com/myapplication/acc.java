package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class acc
  implements acg
{
  private final ArrayList<ach> b;
  private final Context c;
  private final String[] d;
  private final List<ach>[] e;

  public acc(Context paramContext, ArrayList<ach> paramArrayList)
  {
    this.c = paramArrayList;
    Object localObject;
    this.b = localObject;
    this.d = d();
    this.e = new List[this.d.length];
    int i = 0;
    while (i < this.e.length)
    {
      this.e[i] = new ArrayList();
      i += 1;
    }
  }

  private int a(Context paramContext, CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
    {
      paramContext = "";
      if (paramContext.length() != 0)
        break label33;
    }
    label33: for (paramContext = ""; ; paramContext = aqk.a().b(paramContext.substring(0, 1)))
    {
      return a(paramContext);
      paramContext = paramCharSequence.toString();
      break;
    }
  }

  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    int i;
    do
    {
      do
      {
        return 1;
        i = paramString.charAt(0);
      }
      while ((i >= 48) && (i <= 57));
      if ((i >= 97) && (i <= 122))
        return i - 97 + 2;
    }
    while ((i < 65) || (i > 90));
    return i - 65 + 2;
  }

  private String[] d()
  {
    int i = 0;
    String[] arrayOfString = new String[28];
    arrayOfString[0] = "";
    arrayOfString[1] = "#";
    while (i < 26)
    {
      arrayOfString[(i + 2)] = String.valueOf((char)(i + 65));
      i += 1;
    }
    return arrayOfString;
  }

  public void a()
  {
    Object localObject = this.e;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].clear();
      i += 1;
    }
    localObject = this.b;
    int k = ((ArrayList)localObject).size();
    i = 0;
    if (i < k)
    {
      ach localach = (ach)((ArrayList)localObject).get(i);
      if (localach.c);
      for (j = 0; ; j = a(this.c, localach.a.b))
      {
        this.e[j].add(localach);
        i += 1;
        break;
      }
    }
  }

  public String[] b()
  {
    return this.d;
  }

  public List<ach>[] c()
  {
    return this.e;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acc
 * JD-Core Version:    0.6.2
 */