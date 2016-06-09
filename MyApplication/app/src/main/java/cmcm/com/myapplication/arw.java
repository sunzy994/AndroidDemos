package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class arw
{
  private static final Comparator<arz> b = new Comparator()
  {
    private final Collator a = Collator.getInstance();

    public final int a(arz paramAnonymousarz1, arz paramAnonymousarz2)
    {
      if (paramAnonymousarz1.e != paramAnonymousarz2.e)
        return paramAnonymousarz1.e - paramAnonymousarz2.e;
      return this.a.compare(paramAnonymousarz1.c, paramAnonymousarz2.c);
    }
  };
  private final ArrayList<arz> a = new ArrayList();

  public arw(Context paramContext, String paramString1, String paramString2, String paramString3, asa[] paramArrayOfasa)
  {
    int j;
    int i;
    if (paramArrayOfasa != null)
    {
      j = paramArrayOfasa.length;
      i = 0;
      if (i < j)
      {
        final asa localasa = paramArrayOfasa[i];
        if (localasa == null);
        while (true)
        {
          i += 1;
          break;
          ary local1 = new ary()
          {
            public void a()
            {
              localasa.d();
            }
          };
          local1.c = localasa.a();
          local1.d = localasa.b();
          local1.e = localasa.c();
          this.a.add(local1);
        }
      }
    }
    paramString2 = new Intent(paramString2);
    paramString2.addCategory("android.intent.category.DEFAULT");
    paramString2.setType(paramString3);
    if (!TextUtils.isEmpty(paramString1))
      paramString2.setPackage(paramString1);
    paramString1 = paramContext.getPackageManager();
    paramString2 = paramString1.queryIntentActivities(paramString2, 1).iterator();
    if (paramString2.hasNext())
    {
      paramString3 = (ResolveInfo)paramString2.next();
      paramArrayOfasa = new arx();
      paramArrayOfasa.c = paramString3.loadLabel(paramString1);
      if (paramArrayOfasa.c == null)
        paramArrayOfasa.c = paramString3.activityInfo.name;
      if (paramArrayOfasa.c == null);
      for (paramContext = null; ; paramContext = paramArrayOfasa.c.toString())
      {
        paramArrayOfasa.c = asi.a(paramContext);
        paramArrayOfasa.d = paramString3.loadIcon(paramString1);
        j = arv.b().indexOf(paramString3.activityInfo.packageName + "/" + paramString3.activityInfo.name);
        i = j;
        if (j == -1)
          i = arv.b().indexOf(paramString3.activityInfo.packageName);
        j = i;
        if (i < 0)
          j = 2147483647;
        paramArrayOfasa.e = j;
        paramArrayOfasa.a = new ComponentName(paramString3.activityInfo.applicationInfo.packageName, paramString3.activityInfo.name);
        this.a.add(paramArrayOfasa);
        break;
      }
    }
    Collections.sort(this.a, b);
  }

  public Object a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size()))
      return (arz)this.a.get(paramInt);
    return null;
  }

  public List<arz> a()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     arw
 * JD-Core Version:    0.6.2
 */