package cmcm.com.myapplication.com.qq.e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.IOException;

public class SM
{
  private a a;
  private String b;
  private a c;
  private a d;
  private String e;
  private c f;
  private c g;
  private String h;
  private String i = "";
  private Context j;

  public SM(Context paramContext)
  {
    this.j = paramContext;
    this.a = new a();
    this.d = new a();
    this.g = new b();
    try
    {
      this.h = StringUtil.readAll(new File(this.j.getDir("e_qq_com_setting", 0), "gdt_suid"));
      a();
      b();
      return;
    }
    catch (Throwable paramContext)
    {
      while (true)
      {
        this.h = null;
        GDTLogger.e("IO Exception while loading suid");
      }
    }
  }

  private void a()
  {
    d locald = a.b(this.j);
    if (locald != null)
    {
      this.e = locald.a();
      this.f = locald.b();
      return;
    }
    GDTLogger.d("Load Local SDK Cloud setting fail");
  }

  private void b()
  {
    com.qq.e.comm.a locala = a.a(this.j);
    if (locala != null)
    {
      this.c = locala.b();
      this.b = locala.a();
      return;
    }
    GDTLogger.d("Load Local DEV Cloud setting fail");
  }

  public Object get(String paramString)
  {
    if (StringUtil.isEmpty(paramString));
    while (true)
    {
      return null;
      try
      {
        Object localObject;
        if (this.a.a(paramString) != null)
        {
          localObject = this.a.a(paramString);
          if (localObject != null)
            return localObject;
        }
        if (this.c != null)
        {
          localObject = this.c.a(paramString);
          if (localObject != null)
            return localObject;
        }
        if (this.d != null)
        {
          localObject = this.d.a(paramString);
          if (localObject != null)
            return localObject;
        }
        if (this.f != null)
        {
          localObject = this.f.a(paramString);
          if (localObject != null)
            return localObject;
        }
        if (this.g != null)
        {
          localObject = this.g.a(paramString);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        GDTLogger.report("Exception in settingManager.get Setting for key:" + paramString, localThrowable);
      }
    }
    return null;
  }

  public String getDevCloudSettingSig()
  {
    return this.b;
  }

  public Object getForPlacement(String paramString1, String paramString2)
  {
    Object localObject1;
    if ((StringUtil.isEmpty(paramString1)) || (StringUtil.isEmpty(paramString2)))
      localObject1 = null;
    while (true)
    {
      return localObject1;
      try
      {
        Object localObject2;
        if (this.a != null)
        {
          localObject2 = this.a.a(paramString1, paramString2);
          localObject1 = localObject2;
          if (localObject2 != null);
        }
        else if (this.c != null)
        {
          localObject2 = this.c.a(paramString1, paramString2);
          localObject1 = localObject2;
          if (localObject2 != null);
        }
        else if (this.d != null)
        {
          paramString2 = this.d.a(paramString1, paramString2);
          localObject1 = paramString2;
          if (paramString2 != null);
        }
        else
        {
          paramString1 = get(paramString1);
          return paramString1;
        }
      }
      catch (Throwable paramString1)
      {
        GDTLogger.report("Exception in settingManager.getForPlacement", paramString1);
      }
    }
    return null;
  }

  public int getInteger(String paramString, int paramInt)
  {
    paramString = get(paramString);
    int k = paramInt;
    if (paramString != null)
    {
      k = paramInt;
      if ((paramString instanceof Integer))
        k = ((Integer)paramString).intValue();
    }
    return k;
  }

  public int getIntegerForPlacement(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = getForPlacement(paramString1, paramString2);
    int k = paramInt;
    if (paramString1 != null)
    {
      k = paramInt;
      if ((paramString1 instanceof Integer))
        k = ((Integer)paramString1).intValue();
    }
    return k;
  }

  public String getSdkCloudSettingSig()
  {
    return this.e;
  }

  public String getSid()
  {
    return this.i;
  }

  public String getString(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null)
      return null;
    return paramString.toString();
  }

  public String getStringForPlacement(String paramString1, String paramString2)
  {
    paramString1 = getForPlacement(paramString1, paramString2);
    if (paramString1 == null)
      return null;
    return paramString1.toString();
  }

  public String getSuid()
  {
    return this.h;
  }

  public void setDEVCodeSetting(String paramString, Object paramObject)
  {
    this.d.a(paramString, paramObject);
  }

  public void setDEVCodeSetting(String paramString1, Object paramObject, String paramString2)
  {
    this.d.a(paramString1, paramObject, paramString2);
  }

  public void updateContextSetting(String paramString)
  {
    try
    {
      a locala = new a();
      if (!StringUtil.isEmpty(paramString))
        locala = new a(new String(Base64.decode(paramString, 0), "UTF-8"));
      this.a = locala;
      return;
    }
    catch (Throwable paramString)
    {
      GDTLogger.report("Exception while update Context Setting", paramString);
    }
  }

  public void updateDEVCloudSetting(String paramString1, String paramString2)
  {
    if (a.b(this.j, paramString1, paramString2))
      b();
  }

  public void updateSDKCloudSetting(String paramString1, String paramString2)
  {
    if (a.a(this.j, paramString1, paramString2))
      a();
  }

  public void updateSID(String paramString)
  {
    this.i = paramString;
  }

  public void updateSUID(String paramString)
  {
    if ((!StringUtil.isEmpty(paramString)) && (!paramString.equals(this.h)))
      this.h = paramString;
    try
    {
      StringUtil.writeTo(paramString, new File(this.j.getDir("e_qq_com_setting", 0), "gdt_suid"));
      return;
    }
    catch (IOException paramString)
    {
      GDTLogger.report("Exception while persit suid", paramString);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.managers.setting.SM
 * JD-Core Version:    0.6.2
 */