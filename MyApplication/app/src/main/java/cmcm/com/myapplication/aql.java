package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;

public class aql
{
  private static final String a = "Swipe." + aql.class.getSimpleName();
  private static aql b;
  private final HashMap<String, Class<?>> c = new HashMap();
  private final HashMap<String, HashSet<String>> d = new HashMap();
  private final HashSet<String> e = new HashSet();
  private final aqj f = new aqj()
  {
    protected void a(String paramAnonymousString)
    {
      aql.a(aql.this, paramAnonymousString);
    }

    protected void b(String paramAnonymousString)
    {
      aql.b(aql.this, paramAnonymousString);
    }

    protected void c(String paramAnonymousString)
    {
    }
  };

  public static aql a()
  {
    if (b == null)
      b = new aql();
    return b;
  }

  private void a(String paramString)
  {
    synchronized (this.e)
    {
      this.e.add(paramString);
      this.d.remove(paramString);
      return;
    }
  }

  private void b(String paramString)
  {
    synchronized (this.e)
    {
      this.e.remove(paramString);
      return;
    }
  }

  public Class<?> a(Context paramContext, CharSequence arg2, CharSequence paramCharSequence2)
  {
    if (TextUtils.isEmpty(???))
      ??? = null;
    String str1;
    String str2;
    while (true)
    {
      return ???;
      Object localObject = paramCharSequence2;
      if (TextUtils.isEmpty(paramCharSequence2))
      {
        int i = TextUtils.lastIndexOf(???, '.');
        if (i < 0)
          return null;
        localObject = TextUtils.substring(???, 0, i);
      }
      str1 = ???.toString();
      str2 = ((CharSequence)localObject).toString();
      synchronized (this.e)
      {
        paramCharSequence2 = (HashSet)this.d.get(str2);
        if ((paramCharSequence2 != null) && (paramCharSequence2.contains(str1)))
          return null;
        localObject = (Class)this.c.get(str1);
        ??? = (CharSequence)localObject;
        if (localObject == null)
        {
          try
          {
            ??? = getClass().getClassLoader().loadClass(str1);
            if (??? != null)
            {
              this.c.put(str1, ???);
              return ???;
            }
          }
          catch (ClassNotFoundException )
          {
          }
          if (paramContext == null)
            return null;
        }
      }
    }
    try
    {
      paramContext = paramContext.createPackageContext(str2, 3).getClassLoader().loadClass(str1);
      if (paramContext != null)
      {
        this.c.put(str1, paramContext);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Log.e(a, "Error encountered. Failed to load outside class: " + str1);
      paramContext = paramCharSequence2;
      if (paramCharSequence2 == null)
      {
        paramContext = new HashSet();
        this.d.put(str2, paramContext);
      }
      paramContext.add(str1);
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aql
 * JD-Core Version:    0.6.2
 */