package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.hola.channel.sdk.game.manager.DownloadService;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class so
  implements oq
{
  private Context a;
  private pe b;
  private oo c;
  private int d = -1;
  private DownloadService e;
  private WeakReference<View> f;
  private int g;
  private sp h;
  private boolean i;

  public so(Context paramContext, pe parampe, View paramView, DownloadService paramDownloadService, sp paramsp)
  {
    this.a = paramContext;
    this.b = parampe;
    this.e = paramDownloadService;
    this.h = paramsp;
    a(paramView);
  }

  private void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 200, 0);
  }

  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("G", paramString);
    localHashMap.put("S", String.valueOf(paramInt1));
    localHashMap.put("H", String.valueOf(paramInt2));
    localHashMap.put("C", String.valueOf(paramInt3));
    qf.a(this.a, "GH0", localHashMap);
  }

  public View a()
  {
    if (this.f == null)
      return null;
    return (View)this.f.get();
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
    if (this.c != null)
      this.e.b(this.c);
  }

  public void a(View paramView)
  {
    this.f = new WeakReference(paramView);
  }

  public void a(String paramString)
  {
    paramString = rn.a(this.a).c(paramString);
    if ((paramString != null) && (paramString.a));
    for (boolean bool = true; ; bool = false)
    {
      this.i = bool;
      return;
    }
  }

  public void a(oo paramoo, String paramString, int paramInt1, int paramInt2)
  {
    String str = paramoo.a();
    rn localrn = rn.a(this.a);
    a(this.b.d);
    switch (paramInt1)
    {
    default:
      return;
    case 2:
      paramoo.c();
      return;
    case 4:
      localrn.a(this.b.d, 3, 0, -1, this.i);
      this.d = 6;
      a(this.b.d, this.d);
      return;
    case 3:
      localrn.a(this.b.d, 2, 0, -1, this.i);
      return;
    case 5:
      try
      {
        paramoo = qn.b(new File(str));
        localrn.a(this.b.d, 1, paramoo, -1, this.i);
        sn.a(this.a).a(this.b.d);
        a(this.b.d, 1);
        sn.a(this.a).b(this.a);
        return;
      }
      catch (Throwable paramoo)
      {
        while (true)
          Log.w(rn.a, "Could not get generate md5 for the game downloaded from " + paramString, paramoo);
      }
    case 6:
    }
    Log.w(rn.a, "Loading of game " + this.b.d + " failed!");
    localrn.a(this.b.d, 0, 0, -1, this.i);
    if (this.d == -1)
    {
      if (!qr.c(this.a))
        break label377;
      paramInt1 = 2;
    }
    while (true)
    {
      this.d = paramInt1;
      int j = 0;
      paramInt1 = j;
      if (this.d != 0);
      try
      {
        qo.a("http://s.holagames.com/_hola_blank.png");
        paramInt1 = j;
        sn.a(this.a).a(this.b.d);
        a(this.b.d, this.d, paramInt2, paramInt1);
        return;
        label377: paramInt1 = 0;
      }
      catch (pi paramoo)
      {
        while (true)
          paramInt1 = 1;
      }
    }
  }

  public void a(oo paramoo, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramInt != this.g)
    {
      this.g = paramInt;
      rn.a(this.a).a(this.b.d, 2, paramInt, -1, true);
      if ((this.f == null) || (this.f.get() == null) || (this.h == null) || (this.i));
    }
    try
    {
      paramoo = this.a.getString(tg.hola_common_percent, new Object[] { Integer.valueOf(paramInt) });
      if ((this.b.d.equals(((View)this.f.get()).getTag())) && ((this.f.get() instanceof TextView)))
        this.h.a((TextView)this.f.get(), paramoo);
      return;
    }
    catch (Throwable paramoo)
    {
    }
  }

  public void b()
  {
    String str = pe.b(this.b.d);
    if (this.c == null)
      this.c = new oo(this.a, this.b.e, str, 1, this.b.f, false, this);
    this.e.a(this.c);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     so
 * JD-Core Version:    0.6.2
 */