package cmcm.com.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lazyswipe.view.PreviewImageView;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class aiy<T extends ahv> extends BaseAdapter
  implements Callback, att, atu
{
  protected atq a;
  protected Activity b;
  private int c = 0;
  private Map<String, SoftReference<Bitmap>> d;
  private List<T> e;
  private final Handler f = new Handler(this);

  public aiy(Activity paramActivity)
  {
    this.b = paramActivity;
    this.a = atq.a(this.b, b(), this);
    this.a.a(this);
  }

  private void a(int paramInt, aja paramaja)
  {
    ahv localahv = a(paramInt);
    paramaja.a.setTag(localahv);
    a(paramInt, paramaja, localahv);
    b(paramInt, paramaja, localahv);
    paramaja.b.setText(localahv.K());
  }

  private String b()
  {
    return new File(aro.c(), "themes").getAbsolutePath();
  }

  private void c()
  {
    if (this.d != null)
    {
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext())
        atw.a((Bitmap) ((SoftReference) localIterator.next()).get());
      this.d.clear();
    }
  }

  private void d()
  {
    if (this.a != null)
      this.a.a();
  }

  public T a(int paramInt)
  {
    return (ahv)this.e.get(paramInt);
  }

  public Bitmap a(String paramString)
  {
    if (this.d == null);
    for (paramString = null; paramString == null; paramString = (SoftReference)this.d.get(paramString))
      return null;
    return (Bitmap)paramString.get();
  }

  public void a()
  {
    c();
    atq.a(this.a);
  }

  protected void a(int paramInt, aja paramaja, T paramT)
  {
    paramaja.a(paramT.L());
  }

  protected void a(aiz paramaiz)
  {
    if ((paramaiz.c == paramaiz.b.a.getTag()) && (atw.b(paramaiz.e)))
      paramaiz.b.a(paramaiz.e);
  }

  public void a(atr paramatr)
  {
    this.f.obtainMessage(1, paramatr).sendToTarget();
  }

  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (this.d == null)
      this.d = new HashMap();
    this.d.put(paramString, new SoftReference(paramBitmap));
  }

  public void a(List<T> paramList)
  {
    this.e = paramList;
  }

  public void b(int paramInt)
  {
    this.c = paramInt;
    if (this.c == 2)
      d();
  }

  protected void b(int paramInt, aja paramaja, T paramT)
  {
    paramT = this.a.a(new aiz(paramInt, paramaja, paramT));
    if (paramT != null)
    {
      paramaja.a(paramT.e);
      return;
    }
    paramaja.a();
  }

  public void b(atr paramatr)
  {
    this.f.obtainMessage(2, paramatr).sendToTarget();
  }

  public void c(atr paramatr)
  {
    a(paramatr.a(), paramatr.e);
  }

  public int getCount()
  {
    if (this.e != null)
      return this.e.size();
    return 0;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130968752, null);
      paramViewGroup = new aja(paramView);
      paramView.setTag(paramViewGroup);
    }
    while (true)
    {
      a(paramInt, paramViewGroup);
      return paramView;
      paramViewGroup = (aja)paramView.getTag();
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    if (this.b.isFinishing());
    do
    {
      do
      {
        do
        {
          return true;
          switch (paramMessage.what)
          {
          default:
            return true;
          case 1:
          case 2:
          }
        }
        while (!(paramMessage.obj instanceof aiz));
        a((aiz)paramMessage.obj);
        return true;
      }
      while (!(paramMessage.obj instanceof aiz));
      paramMessage = (aiz)paramMessage.obj;
    }
    while (paramMessage.c != paramMessage.b.a.getTag());
    paramMessage.b.a();
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aiy
 * JD-Core Version:    0.6.2
 */