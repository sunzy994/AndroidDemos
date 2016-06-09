package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.AvoidXfermode;
import android.graphics.AvoidXfermode.Mode;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class ahr extends ahw
{
  protected final Context a;
  protected boolean b;
  protected boolean c;
  protected Runnable d;
  protected int e;
  private final Map<String, Bitmap> n = new HashMap();
  private boolean o;
  private Map<String, Integer> p = new HashMap();

  public ahr(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, paramString2);
    this.a = paramContext.getApplicationContext();
  }

  private boolean P()
  {
    return vs.c(this.a, "theme_is_loading_" + this.g, false);
  }

  private void Q()
  {
    R();
    if ((this.e >= 2) && (!this.o))
    {
      T();
      this.o = true;
    }
  }

  private void R()
  {
    if (this.e <= 0)
      S();
  }

  private void S()
  {
    try
    {
      File localFile = new File(E(), "info.json");
      if (!localFile.exists())
      {
        this.e = 3;
        return;
      }
      this.e = new JSONObject(arf.a(new FileInputStream(localFile))).optInt("version", 3);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void T()
  {
    try
    {
      Object localObject = new File(E(), "color.json");
      if (!((File)localObject).exists())
        return;
      localObject = new JSONObject(arf.a(new FileInputStream((File) localObject)));
      Iterator localIterator = ((JSONObject)localObject).keys();
      while (true)
      {
        boolean bool = localIterator.hasNext();
        if (!bool)
          break;
        try
        {
          String str1 = (String)localIterator.next();
          String str2 = ((JSONObject)localObject).optString(str1);
          if (!TextUtils.isEmpty(str2))
          {
            int i = Color.parseColor(str2);
            this.p.put(str1, Integer.valueOf(i));
          }
        }
        catch (Exception localException2)
        {
        }
      }
    }
    catch (Exception localException1)
    {
    }
  }

  private Bitmap a(String paramString)
  {
    if (atw.b((Bitmap) this.n.get(paramString)))
      return (Bitmap)this.n.get(paramString);
    try
    {
      if (!new File(E(), paramString + ".png").exists())
        return null;
      Bitmap localBitmap = atk.a(E(), paramString);
      this.n.put(paramString, localBitmap);
      return localBitmap;
    }
    catch (Exception paramString)
    {
    }
    return null;
  }

  private Bitmap a(String paramString, boolean paramBoolean)
  {
    Object localObject2 = new StringBuilder().append(paramString).append("_");
    if (paramBoolean);
    for (Object localObject1 = "left"; ; localObject1 = "right")
    {
      localObject2 = (String)localObject1;
      if (!atw.b((Bitmap) this.n.get(localObject2)))
        break;
      return (Bitmap)this.n.get(localObject2);
    }
    try
    {
      localObject1 = atk.a(E(), paramString);
      paramString = (String)localObject1;
      if (!paramBoolean)
        paramString = atw.c((Bitmap) localObject1);
      this.n.put(localObject2, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
    }
    return null;
  }

  public static String a(JSONObject paramJSONObject)
  {
    Object localObject;
    try
    {
      localObject = paramJSONObject.optJSONObject("locale");
      if (localObject != null)
      {
        String str = ((JSONObject)localObject).optString(asq.k());
        if (!TextUtils.isEmpty(str))
          return str;
        str = ((JSONObject)localObject).optString(asq.j());
        localObject = str;
        if (!TextUtils.isEmpty(str));
      }
      else
      {
        paramJSONObject = paramJSONObject.optString("name");
        return paramJSONObject;
      }
    }
    catch (Exception paramJSONObject)
    {
      localObject = "";
    }
    return localObject;
  }

  private float b(yb paramyb)
  {
    R();
    float f2 = ari.b(paramyb.getItemSectorOuterSize() + paramyb.getCenterOffset(), aqs.ae());
    if (this.e >= 3);
    for (float f1 = 335.29999F; ; f1 = 336.0F)
    {
      f2 /= asq.a(f1);
      f1 = f2;
      if (vj.d <= 240)
        f1 = (float)(f2 * 0.98D);
      return f1;
    }
  }

  private File b(String paramString)
  {
    return new File(E(), paramString + ".png");
  }

  public void A()
  {
    arj.a(new Runnable() {
      public void run() {
        if (!ahr.this.b)
          ahr.this.a(ahr.this.d);
        ahr.this.b(false);
      }
    });
  }

  public void B()
  {
    b(false);
  }

  protected void C()
  {
    super.C();
    if ("".equals(this.g))
      aiu.k(this.a);
    S();
    T();
    if ((this.c) && (g()))
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public void run()
        {
          aib.b(ahr.this.a, ahr.this.g);
        }
      }
      , 1200L);
  }

  public void D()
  {
    if (P())
      return;
    b(true);
    this.b = true;
    j_();
  }

  protected String E()
  {
    return aro.d() + "/files/themes/" + x();
  }

  public Drawable F()
  {
    R();
    Bitmap localBitmap = a("icon_bg");
    if (atw.b(localBitmap))
      return new BitmapDrawable(this.a.getResources(), localBitmap);
    return super.F();
  }

  public Drawable G()
  {
    R();
    Bitmap localBitmap = a("icon_fg");
    if (atw.b(localBitmap))
      return new BitmapDrawable(this.a.getResources(), localBitmap);
    return super.G();
  }

  public Drawable H()
  {
    R();
    Bitmap localBitmap = a("icon_mask");
    if (atw.b(localBitmap))
      return new BitmapDrawable(this.a.getResources(), localBitmap);
    return super.H();
  }

  public List<Drawable> I()
  {
    Q();
    Object localObject = new File(E(), "eggs");
    if (!((File)localObject).exists())
    {
      localObject = super.I();
      return localObject;
    }
    File[] arrayOfFile = ((File)localObject).listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
      return super.I();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfFile.length;
    int i = 0;
    while (true)
    {
      localObject = localArrayList;
      if (i >= j)
        break;
      localObject = arrayOfFile[i];
      try
      {
        localObject = atk.a((File) localObject);
        localArrayList.add(new BitmapDrawable(this.a.getResources(), (Bitmap)localObject));
        label108: i += 1;
      }
      catch (Exception localException)
      {
        break label108;
      }
    }
  }

  public int a(yb paramyb)
  {
    if (vj.d <= 240)
      return asq.a(5.0F);
    return 0;
  }

  public Drawable a(Context paramContext, ans paramans)
  {
    R();
    if (paramans.x_())
    {
      paramContext = a(paramans.i(paramContext));
      if (atw.b(paramContext))
        paramContext = new BitmapDrawable(this.a.getResources(), paramContext);
    }
    Drawable localDrawable;
    while (true)
    {
      return paramContext;
      int i = paramans.e(this.a);
      localDrawable = this.a.getResources().getDrawable(i);
      int j = r();
      paramContext = localDrawable;
      if ((localDrawable instanceof BitmapDrawable))
      {
        paramContext = localDrawable;
        if (j != 0)
        {
          paramContext = localDrawable;
          if (!paramans.x_())
          {
            String str = "color_tile_" + i;
            if (atw.b((Bitmap) this.n.get(str)))
            {
              paramContext = (Bitmap)this.n.get(str);
              return new BitmapDrawable(this.a.getResources(), paramContext);
            }
            try
            {
              paramContext = ((BitmapDrawable)localDrawable).getBitmap();
              Bitmap localBitmap = Bitmap.createBitmap(paramContext.getWidth(), paramContext.getHeight(), Config.ARGB_8888);
              Canvas localCanvas = new Canvas(localBitmap);
              Paint localPaint = new Paint(atw.b);
              if ((paramans instanceof anp))
              {
                localCanvas.drawBitmap(paramContext, 0.0F, 0.0F, null);
                localPaint.setXfermode(new AvoidXfermode(-1, 10, AvoidXfermode.Mode.TARGET));
                localPaint.setColor(j);
                localCanvas.drawPaint(localPaint);
              }
              while (true)
              {
                paramContext = localDrawable;
                if (!atw.b(localBitmap))
                  break;
                this.n.put(str, localBitmap);
                return new BitmapDrawable(this.a.getResources(), localBitmap);
                localPaint.setColorFilter(new PorterDuffColorFilter(j, PorterDuff.Mode.SRC_IN));
                localCanvas.drawBitmap(paramContext, 0.0F, 0.0F, localPaint);
              }
            }
            catch (Exception paramContext)
            {
            }
          }
        }
      }
    }
    return localDrawable;
  }

  public Drawable a(Context paramContext, yb paramyb)
  {
    R();
    Bitmap localBitmap = a("icon_sector_bg_outer", paramyb.n());
    if (atw.b(localBitmap))
      return new ahs(localBitmap, (int)(localBitmap.getWidth() * b(paramyb)), paramyb.n());
    return super.a(paramContext, paramyb);
  }

  public Drawable a(Context paramContext, yb paramyb, Drawable paramDrawable)
  {
    R();
    Bitmap localBitmap = a("tab_sector_bg", paramyb.n());
    boolean bool = paramyb.n();
    if (!atw.b(localBitmap))
      return ahx.c(paramContext).a(paramContext, paramyb, paramDrawable);
    paramContext = new ahs(localBitmap, (int)(localBitmap.getWidth() * b(paramyb)), paramyb.n());
    if (paramDrawable == null)
      return paramContext;
    paramyb = new LayerDrawable(new Drawable[] { paramContext, paramDrawable });
    if (bool)
    {
      paramyb.setLayerInset(1, 0, paramContext.getIntrinsicHeight() - paramDrawable.getIntrinsicHeight(), paramContext.getIntrinsicWidth() - paramDrawable.getIntrinsicWidth(), 0);
      return paramyb;
    }
    paramyb.setLayerInset(1, paramContext.getIntrinsicWidth() - paramDrawable.getIntrinsicWidth(), paramContext.getIntrinsicHeight() - paramDrawable.getIntrinsicHeight(), 0, 0);
    return paramyb;
  }

  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.n.keySet().iterator();
    label114: 
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Bitmap localBitmap = (Bitmap)this.n.get(str);
      if ((paramBoolean) || (!"icon_bg".equals(str)) || (!"icon_fg".equals(str)) || (!"icon_mask".equals(str)));
      for (int i = 1; ; i = 0)
      {
        if (i == 0)
          break label114;
        atw.a(localBitmap);
        localIterator.remove();
        break;
      }
    }
  }

  public void a(boolean paramBoolean, Runnable paramRunnable)
  {
    this.d = paramRunnable;
    if (P())
    {
      aso.a(this.a, 2131230923);
      return;
    }
    this.c = paramBoolean;
    if (z())
    {
      Log.i(f, "start(). isResourceDone(), super.start()");
      A();
      return;
    }
    b(true);
    this.b = false;
    j_();
  }

  public Drawable b(Context paramContext)
  {
    R();
    paramContext = a("title_bg_normal");
    if (atw.b(paramContext))
      return new BitmapDrawable(this.a.getResources(), paramContext);
    return new ColorDrawable(0);
  }

  public Drawable b(Context paramContext, yb paramyb)
  {
    R();
    Bitmap localBitmap = a("icon_sector_bg_inner", paramyb.n());
    if (atw.b(localBitmap))
      return new ahs(localBitmap, (int)(localBitmap.getWidth() * b(paramyb)), paramyb.n());
    return super.b(paramContext, paramyb);
  }

  public void b(boolean paramBoolean)
  {
    vs.b(this.a, "theme_is_loading_" + this.g, paramBoolean);
  }

  public boolean b()
  {
    return false;
  }

  public Bitmap c()
  {
    File localFile = new File(E(), "preview.jpg");
    if (localFile.exists())
      return atw.a(localFile.getAbsolutePath(), j, k, false);
    return null;
  }

  public Drawable c(Context paramContext)
  {
    R();
    paramContext = a("title_bg_highlighten");
    if (atw.b(paramContext))
      return new BitmapDrawable(this.a.getResources(), paramContext);
    return new ColorDrawable(0);
  }

  public Drawable c(Context paramContext, yb paramyb)
  {
    R();
    boolean bool = paramyb.n();
    Object localObject = new StringBuilder().append("tab_indicator_bg").append("_");
    if (bool);
    String str;
    for (paramyb = "left"; ; paramyb = "right")
    {
      str = paramyb;
      if (!atw.b((Bitmap) this.n.get(str)))
        break;
      return new BitmapDrawable(paramContext.getResources(), (Bitmap)this.n.get(str));
    }
    label273: label284: 
    while (true)
    {
      try
      {
        paramyb = atk.a(E(), "tab_indicator_bg");
        if (this.e >= 2)
        {
          int i = asq.a(126.6F);
          int j = asq.a(63.0F);
          localObject = Bitmap.createBitmap(i, j, Config.ARGB_8888);
          Canvas localCanvas = new Canvas((Bitmap)localObject);
          localCanvas.setDrawFilter(atw.a);
          Paint localPaint = new Paint(atw.b);
          localCanvas.rotate(-5.5F, 0.0F, j);
          localCanvas.drawBitmap(paramyb, asq.a(43.299999F), asq.a(25.0F), localPaint);
          atw.a(paramyb);
          paramyb = (yb)localObject;
          if (bool)
            break label284;
          paramyb = atw.c(paramyb);
          if (!atw.b(paramyb))
            break label273;
          this.n.put(str, paramyb);
          paramContext = new BitmapDrawable(paramContext.getResources(), paramyb);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        return new ColorDrawable(0);
      }
      continue;
      paramContext = new ColorDrawable(0);
      return paramContext;
    }
  }

  public Drawable d(Context paramContext, yb paramyb)
  {
    R();
    Bitmap localBitmap = a("close_area", paramyb.n());
    if (atw.b(localBitmap))
      return new ahs(localBitmap, (int)(localBitmap.getWidth() * b(paramyb)), paramyb.n());
    return super.d(paramContext, paramyb);
  }

  public int i()
  {
    Q();
    if (this.p.containsKey("masterColor"))
      return ((Integer)this.p.get("masterColor")).intValue();
    return ahx.c(this.a).i();
  }

  public int j()
  {
    Q();
    if (this.p.containsKey("itemSectorBackgroundColor"))
      return ((Integer)this.p.get("itemSectorBackgroundColor")).intValue();
    return i();
  }

  protected abstract void j_();

  public int k()
  {
    Q();
    if (this.p.containsKey("itemSectorTextColor"))
      return ((Integer)this.p.get("itemSectorTextColor")).intValue();
    return ahx.c(this.a).k();
  }

  protected abstract boolean k_();

  public int l()
  {
    Q();
    if (this.p.containsKey("tabIndicatorColor"))
      return ((Integer)this.p.get("tabIndicatorColor")).intValue();
    return i();
  }

  public boolean l_()
  {
    return false;
  }

  public int m()
  {
    Q();
    if (this.p.containsKey("tabIndicatorTextColor"))
      return ((Integer)this.p.get("tabIndicatorTextColor")).intValue();
    return ahx.c(this.a).m();
  }

  public int n()
  {
    Q();
    if (this.p.containsKey("tabIndicatorTextColorFocused"))
      return ((Integer)this.p.get("tabIndicatorTextColorFocused")).intValue();
    return ahx.c(this.a).n();
  }

  public int o()
  {
    Q();
    if (this.p.containsKey("tabSectorBackgroundColor"))
      return ((Integer)this.p.get("tabSectorBackgroundColor")).intValue();
    return ahx.c(this.a).o();
  }

  public int p()
  {
    Q();
    if (this.p.containsKey("tileBgColor"))
      return ((Integer)this.p.get("tileBgColor")).intValue();
    return ahx.c(this.a).p();
  }

  public int q()
  {
    Q();
    if (this.p.containsKey("tileBgColorHighlighted"))
      return ((Integer)this.p.get("tileBgColorHighlighted")).intValue();
    return i();
  }

  public int r()
  {
    Q();
    if (this.p.containsKey("tileIconColor"))
      return ((Integer)this.p.get("tileIconColor")).intValue();
    return ahx.c(this.a).r();
  }

  public int s()
  {
    Q();
    if (this.p.containsKey("backgroundColor"))
      return ((Integer)this.p.get("backgroundColor")).intValue();
    return ahx.c(this.a).s();
  }

  public int t()
  {
    Q();
    if (this.p.containsKey("itemSectorBackgroundOuterShadowColor"))
      return ((Integer)this.p.get("itemSectorBackgroundOuterShadowColor")).intValue();
    return ahx.c(this.a).t();
  }

  public int u()
  {
    Q();
    if (this.p.containsKey("tabIndicatorTextShadowColor"))
      return ((Integer)this.p.get("tabIndicatorTextShadowColor")).intValue();
    return ahx.c(this.a).u();
  }

  public int v()
  {
    Q();
    if (this.p.containsKey("tileBgShadowColor"))
      return ((Integer)this.p.get("tileBgShadowColor")).intValue();
    return ahx.c(this.a).v();
  }

  public int w()
  {
    Q();
    if (this.p.containsKey("boostingLightWaveColor"))
      return ((Integer)this.p.get("boostingLightWaveColor")).intValue();
    return i();
  }

  protected String x()
  {
    return aic.a(this.g);
  }

  public void y()
  {
    if (!e())
      return;
    if (z())
    {
      a(null);
      return;
    }
    try
    {
      if (k_())
      {
        a(null);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e(f, "prepareAsync() failed.", localException);
      B();
      return;
    }
    B();
  }

  public boolean z()
  {
    return (b("icon_sector_bg_inner").exists()) && (b("icon_sector_bg_outer").exists());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahr
 * JD-Core Version:    0.6.2
 */