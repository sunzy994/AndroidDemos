package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class aty extends Handler
{
  private static WeakReference<Bitmap> a;
  private static final Map<String, List<aud>> b = new ConcurrentHashMap();

  private Handler a(aud paramaud)
  {
    if ((TextUtils.isEmpty(paramaud.i)) || (paramaud.i.equalsIgnoreCase("null")))
      return null;
    return wd.a;
  }

  private static aud a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof aub))
        return ((aub)paramImageView).a();
    }
    return null;
  }

  private static aud a(TextView paramTextView)
  {
    if (paramTextView != null)
    {
      int i = ((Integer)paramTextView.getTag(2131755014)).intValue();
      paramTextView = paramTextView.getCompoundDrawables()[i];
      if ((paramTextView instanceof aub))
        return ((aub)paramTextView).a();
    }
    return null;
  }

  private static aud a(FanItem paramFanItem)
  {
    if (paramFanItem != null)
    {
      paramFanItem = paramFanItem.getIcon();
      if ((paramFanItem instanceof aub))
        return ((aub)paramFanItem).a();
    }
    return null;
  }

  public static void a()
  {
    if (a != null)
    {
      atw.a((Bitmap)a.get());
      a.clear();
    }
    a = null;
  }

  public static void a(Context paramContext)
  {
    a = new WeakReference(ahx.b(paramContext).a());
  }

  private void a(View paramView, Drawable paramDrawable)
  {
    if ((paramView instanceof ImageView))
      ((ImageView)paramView).setImageDrawable(paramDrawable);
    do
    {
      return;
      if ((paramView instanceof FanItem))
      {
        ((FanItem)paramView).setIcon(paramDrawable);
        return;
      }
    }
    while (!(paramView instanceof TextView));
    Drawable[] arrayOfDrawable = ((TextView)paramView).getCompoundDrawables();
    ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], paramDrawable, arrayOfDrawable[2], arrayOfDrawable[3]);
  }

  private Bitmap b()
  {
    if ((a == null) || (!atw.b((Bitmap)a.get())))
      a(SwipeApplication.c());
    if (atw.b((Bitmap)a.get()))
      return (Bitmap)a.get();
    return BitmapFactory.decodeResource(SwipeApplication.c().getResources(), 2130903040);
  }

  private View b(aud paramaud)
  {
    View localView = (View)paramaud.b.get();
    aud localaud;
    if ((localView instanceof ImageView))
      localaud = a((ImageView)localView);
    while (paramaud == localaud)
    {
      return localView;
      if ((localView instanceof FanItem))
        localaud = a((FanItem)localView);
      else
        localaud = a((TextView)localView);
    }
    return null;
  }

  protected Drawable a(Context paramContext, aud paramaud)
  {
    return new aua(paramContext, paramaud);
  }

  protected atz a(Resources paramResources, int paramInt, aud paramaud)
  {
    if (paramInt > 0);
    for (Bitmap localBitmap = BitmapFactory.decodeResource(paramResources, paramInt); ; localBitmap = null)
      return new atz(paramResources, localBitmap, paramaud);
  }

  protected atz a(Resources paramResources, Bitmap paramBitmap, aud paramaud)
  {
    return new atz(paramResources, paramBitmap, paramaud);
  }

  public void a(final Context paramContext, View paramView, String paramString1, String paramString2, int paramInt1, int paramInt2, auc paramauc)
  {
    paramString1 = new aud(this, paramView, paramString1, paramString2, paramInt1, paramInt2, paramauc);
    paramContext = a(paramContext, paramString1);
    a(paramView, paramContext);
    if ((paramContext instanceof Animatable))
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public void run()
        {
          ((Animatable)paramContext).start();
        }
      }
      , 50L);
    arj.a(a(paramString1), paramString1);
  }

  public void a(Resources paramResources, View paramView, String paramString)
  {
    a(paramResources, paramView, paramString, null);
  }

  public void a(Resources paramResources, View paramView, String paramString, auc paramauc)
  {
    paramString = new aud(this, paramView, paramString, paramauc);
    paramResources = a(paramResources, b(), paramString);
    if ((paramView instanceof ImageView))
      ((ImageView)paramView).setImageDrawable(paramResources);
    while (true)
    {
      arj.a(paramString);
      return;
      if ((paramView instanceof FanItem))
        ((FanItem)paramView).setIcon(paramResources);
    }
  }

  public void a(Resources paramResources, View paramView, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, auc paramauc)
  {
    paramString1 = new aud(this, paramView, paramString1, paramString2, paramInt2, paramInt3, paramauc);
    a(paramView, a(paramResources, paramInt1, paramString1));
    arj.a(a(paramString1), paramString1);
  }

  public void a(Resources paramResources, View paramView, wk paramwk)
  {
    a(paramResources, paramView, paramwk, null);
  }

  public void a(Resources paramResources, View paramView, wk paramwk, auc paramauc)
  {
    if ((paramwk.h == null) || (!atw.b(paramwk.h.a())))
    {
      paramwk = new aud(this, paramView, paramwk, paramauc);
      a(paramView, a(paramResources, b(), paramwk));
      arj.a(paramwk);
    }
    do
    {
      return;
      a(paramView, paramwk.h);
    }
    while (paramauc == null);
    paramauc.a(paramwk.h);
  }

  public void handleMessage(Message paramMessage)
  {
    aud localaud1;
    if (1 == paramMessage.what)
      localaud1 = (aud)paramMessage.obj;
    try
    {
      localObject = b(localaud1);
      if (localObject != null)
      {
        paramMessage = localaud1.g;
        if ((localaud1.a != null) && (localaud1.a.get() != null))
          ((auc)localaud1.a.get()).a(paramMessage);
        if (paramMessage == null)
        {
          localObject = new StringBuilder().append("App icon is null! ");
          if (localaud1.c != null)
            paramMessage = localaud1.c.b + "; " + localaud1.c.i;
          while (true)
          {
            Log.w("Swipe.IconLoader", paramMessage);
            b.remove(localaud1.i);
            return;
            if (localaud1.h != null)
              paramMessage = localaud1.h;
            else
              paramMessage = localaud1.i;
          }
        }
        if ((localaud1.k != null) && (localaud1.k != ScaleType.CENTER_INSIDE))
          ((ImageView)localObject).setScaleType(localaud1.k);
        if (localaud1.l)
          ((ImageView)localObject).setAdjustViewBounds(true);
        a((View)localObject, paramMessage);
        localObject = (List)b.get(localaud1.i);
        if (localObject != null)
        {
          Iterator localIterator = ((List)localObject).iterator();
          while (localIterator.hasNext())
          {
            aud localaud2 = (aud)localIterator.next();
            View localView = b(localaud2);
            if (localView != null)
            {
              if ((localaud2.k != null) && (localaud2.k != ScaleType.CENTER_INSIDE))
                ((ImageView)localView).setScaleType(localaud1.k);
              if (localaud1.l)
                ((ImageView)localView).setAdjustViewBounds(true);
              a(localView, paramMessage);
            }
          }
        }
      }
    }
    catch (Exception paramMessage)
    {
      Object localObject;
      Log.w("Swipe.IconLoader", "Exception when handling message: " + paramMessage.getMessage());
      return;
      ((List)localObject).clear();
      b.remove(localaud1.i);
      return;
    }
    finally
    {
      localaud1.g = null;
    }
    throw paramMessage;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aty
 * JD-Core Version:    0.6.2
 */