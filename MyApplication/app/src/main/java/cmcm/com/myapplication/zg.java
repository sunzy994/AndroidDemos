package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract.Data;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.friend.CommunicationChoosePanel;
import com.lazyswipe.fan.friend.FriendSector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public enum zg
{
  private static final String j = "Swipe." + zg.class.getSimpleName();
  private static final List<zg> n = Arrays.asList(new zg[] { a, b, e, c, d, f, g });
  private static final List<zg> o = Arrays.asList(new zg[] { a, b, c, d, f, e, g });
  private static final Comparator<zg> p = new Comparator()
  {
    public int a(zg paramAnonymouszg1, zg paramAnonymouszg2)
    {
      return paramAnonymouszg1.c() - paramAnonymouszg2.c();
    }
  };
  public final int i;
  private final String k;
  private final int l;
  private WeakReference<Drawable> m;

  private zg(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0);
  }

  private zg(String paramString, int paramInt1, int paramInt2)
  {
    this.i = paramInt2;
    this.k = paramString;
    this.l = paramInt1;
  }

  public static List<zg> a(alw paramalw, int paramInt)
  {
    paramalw = e(paramalw);
    Collections.sort(paramalw, p);
    ArrayList localArrayList = new ArrayList(paramalw.size());
    int i1 = 0;
    while ((i1 < paramalw.size()) && (i1 < paramInt))
    {
      localArrayList.add(paramalw.get(i1));
      i1 += 1;
    }
    if (!localArrayList.contains(h))
      localArrayList.add(h);
    return localArrayList;
  }

  public static zg a(String paramString, zg paramzg)
  {
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return paramzg;
      zg[] arrayOfzg = values();
      int i2 = arrayOfzg.length;
      int i1 = 0;
      while (i1 < i2)
      {
        zg localzg = arrayOfzg[i1];
        if (paramString.equals(localzg.a()))
          return localzg;
        i1 += 1;
      }
    }
  }

  private void a(final alw paramalw, final String[] paramArrayOfString, CharSequence[] paramArrayOfCharSequence, int paramInt)
  {
    paramArrayOfString = new avx(l()).a(paramalw.d).a(paramArrayOfCharSequence, new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if ((paramAnonymousInt >= 0) && (paramAnonymousInt < paramArrayOfString.length) && (zg.this.b(paramArrayOfString[paramAnonymousInt])))
          yb.p();
      }
    }).a(paramInt, "  (" + b(2131231071) + ")");
    if (e())
      paramArrayOfString.a(b(2131230937), new OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
          zg.this.d(paramalw);
        }
      });
    paramArrayOfString.b();
  }

  private int b(String[] paramArrayOfString)
  {
    return asq.a(paramArrayOfString, a(paramArrayOfString));
  }

  private static String b(int paramInt)
  {
    return SwipeApplication.c().getString(paramInt);
  }

  public static zg d(String paramString)
  {
    return a(paramString, null);
  }

  public static List<zg> e(alw paramalw)
  {
    ArrayList localArrayList = new ArrayList();
    zg[] arrayOfzg = values();
    int i2 = arrayOfzg.length;
    int i1 = 0;
    while (i1 < i2)
    {
      zg localzg = arrayOfzg[i1];
      if (localzg.a(paramalw))
        localArrayList.add(localzg);
      i1 += 1;
    }
    return localArrayList;
  }

  private static Context l()
  {
    return SwipeApplication.c();
  }

  public String a()
  {
    return this.k;
  }

  public String a(String paramString)
  {
    return paramString;
  }

  protected String a(String[] paramArrayOfString)
  {
    return null;
  }

  protected void a(alw paramalw, String paramString)
  {
  }

  public boolean a(alw paramalw)
  {
    paramalw = b(paramalw);
    if ((paramalw == null) || (paramalw.length == 0));
    do
    {
      return false;
      paramalw = c(paramalw[0]);
    }
    while ((paramalw != null) && (!asq.c(SwipeApplication.c(), paramalw)));
    return true;
  }

  public boolean a(final alw paramalw, final WeakReference<FriendSector> paramWeakReference)
  {
    paramWeakReference = b(paramalw);
    if ((paramWeakReference == null) || (paramWeakReference.length == 0))
      return true;
    if (paramWeakReference.length == 1)
      return b(paramWeakReference[0]);
    final CharSequence[] arrayOfCharSequence = new CharSequence[paramWeakReference.length];
    int i1 = 0;
    while (true)
      if (i1 < paramWeakReference.length)
        try
        {
          arrayOfCharSequence[i1] = a(paramWeakReference[i1]);
          i1 += 1;
        }
        catch (Exception localException)
        {
          while (true)
            arrayOfCharSequence[i1] = paramWeakReference[i1];
        }
    if (!d())
    {
      a(paramalw, paramWeakReference, arrayOfCharSequence, b(paramWeakReference));
      return false;
    }
    new AsyncTask()
    {
      private tj e;

      protected Integer a(Void[] paramAnonymousArrayOfVoid)
      {
        return Integer.valueOf(zg.a(zg.this, paramWeakReference));
      }

      protected void a(Integer paramAnonymousInteger)
      {
        this.e.dismiss();
        this.e = null;
        zg.a(zg.this, paramalw, paramWeakReference, arrayOfCharSequence, paramAnonymousInteger.intValue());
      }

      protected void onPreExecute()
      {
        this.e = new avz(zg.k()).b();
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    return false;
  }

  protected String[] a(alv paramalv)
  {
    paramalv = paramalv.a();
    return (String[])paramalv.toArray(new String[paramalv.size()]);
  }

  public String b()
  {
    try
    {
      String str2 = asq.e(l(), a());
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = "";
      return str1;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public boolean b(String paramString)
  {
    Log.i(j, "handleIntent " + paramString);
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    paramString = c(paramString);
    if (paramString != null)
    {
      asq.d(l(), paramString);
      asq.t(localSwipeApplication);
      return true;
    }
    return false;
  }

  public String[] b(alw paramalw)
  {
    Object localObject = (alv)paramalw.i.get(this.k);
    if (localObject == null)
      paramalw = null;
    String str;
    do
    {
      do
      {
        return paramalw;
        str = c(paramalw);
        localObject = a((alv)localObject);
        paramalw = (alw)localObject;
      }
      while (TextUtils.isEmpty(str));
      paramalw = (alw)localObject;
    }
    while (asq.a((String[])localObject, str) == -1);
    return new String[] { str };
  }

  public int c()
  {
    int i2 = n.indexOf(this);
    int i1 = i2;
    if (i2 == -1)
      i1 = 100;
    return i1;
  }

  public Intent c(String paramString)
  {
    return null;
  }

  protected String c(alw paramalw)
  {
    return null;
  }

  public void d(final alw paramalw)
  {
    final String[] arrayOfString1 = b(paramalw);
    if ((arrayOfString1 == null) || (arrayOfString1.length < 2))
      return;
    CharSequence[] arrayOfCharSequence = new CharSequence[arrayOfString1.length];
    int i1 = 0;
    while (true)
      if (i1 < arrayOfString1.length)
        try
        {
          arrayOfCharSequence[i1] = a(arrayOfString1[i1]);
          i1 += 1;
        }
        catch (Exception localException)
        {
          while (true)
            arrayOfCharSequence[i1] = arrayOfString1[i1];
        }
    i1 = b(arrayOfString1);
    final String[] arrayOfString2 = new String[1];
    new avx(l()).a(paramalw.d).a(arrayOfCharSequence, -1, new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if ((paramAnonymousDialogInterface instanceof tj))
          ((tj)paramAnonymousDialogInterface).a(-1);
        if ((paramAnonymousInt >= 0) && (paramAnonymousInt < arrayOfString1.length))
          arrayOfString2[0] = arrayOfString1[paramAnonymousInt];
      }
    }).a(i1, "  (" + b(2131231071) + ")").a(17039370, new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        if (!TextUtils.isEmpty(arrayOfString2[0]))
          zg.this.a(paramalw, arrayOfString2[0]);
        if (zg.this.b(arrayOfString2[0]))
          yb.p();
      }
    }).b(17039360, new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    }).b();
  }

  protected boolean d()
  {
    return false;
  }

  protected boolean e()
  {
    return false;
  }

  public Drawable f()
  {
    if ((this.m != null) && (this.m.get() != null))
      return (Drawable)this.m.get();
    this.m = new WeakReference(h());
    return (Drawable)this.m.get();
  }

  public boolean g()
  {
    return true;
  }

  protected BitmapDrawable h()
  {
    int i2 = asq.a(40.0F);
    Object localObject2 = new Paint(7);
    Object localObject1;
    Canvas localCanvas;
    if (g())
    {
      localObject1 = Style.FILL;
      ((Paint)localObject2).setStyle((Style)localObject1);
      ((Paint)localObject2).setStrokeWidth(2.0F);
      ((Paint)localObject2).setColor(i());
      localObject1 = Bitmap.createBitmap(i2, i2, Config.ARGB_8888);
      localCanvas = new Canvas((Bitmap)localObject1);
      if (!g())
        break label200;
    }
    label200: for (int i1 = i2 / 2; ; i1 = (i2 - 2) / 2)
    {
      localCanvas.drawCircle(i2 / 2, i2 / 2, i1, (Paint)localObject2);
      localObject2 = atw.a(l().getResources(), this.l);
      i1 = (int)(((Bitmap)localObject2).getWidth() * 0.8F);
      int i3 = (int)(((Bitmap)localObject2).getHeight() * 0.8F);
      localCanvas.drawBitmap((Bitmap)localObject2, null, new Rect((i2 - i1) / 2, (i2 - i3) / 2, (i1 + i2) / 2, (i2 + i3) / 2), null);
      return new BitmapDrawable(l().getResources(), (Bitmap)localObject1);
      localObject1 = Style.STROKE;
      break;
    }
  }

  protected int i()
  {
    return 0;
  }

  public TextView j()
  {
    TextView localTextView = new TextView(l());
    localTextView.setTextColor(ahx.b(l()).m());
    localTextView.setGravity(17);
    localTextView.setTextSize(10.0F);
    localTextView.setTag(this);
    localTextView.setCompoundDrawablePadding(asq.a(3.0F));
    localTextView.setCompoundDrawablesWithIntrinsicBounds(null, f(), null, null);
    localTextView.setText(b());
    return localTextView;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zg
 * JD-Core Version:    0.6.2
 */