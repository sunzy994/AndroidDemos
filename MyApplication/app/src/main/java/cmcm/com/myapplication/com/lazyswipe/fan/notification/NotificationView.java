package cmcm.com.myapplication.com.lazyswipe.fan.notification;

import aaa;
import aab;
import aad;
import aae;
import ahy;
import ajo;
import ajp;
import alh;
import ali;
import alo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import asl;
import asp;
import asq;
import asw;
import avt;
import awb;
import awc;
import awe;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.notification.NotificationData;
import com.lazyswipe.notification.NotificationData.Action;
import java.lang.ref.WeakReference;
import tn;
import vj;
import vv;
import wq;
import wr;
import yb;
import yw;
import yx;
import za;
import zb;
import zx;
import zy;
import zz;

public class NotificationView extends RelativeLayout
  implements OnClickListener, OnItemClickListener, avt, wr
{
  public View a;
  PopupWindow b;
  public boolean c;
  private ListView d;
  private View e;
  private TextView f;
  private TextView g;
  private NotificationAvatarList h;
  private yw i;
  private View j;
  private String k;
  private aab l;
  private boolean m;
  private WeakReference<FanItem> n;
  private aaa o;

  public NotificationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private Drawable a(String paramString)
  {
    String str = paramString;
    if (b(paramString))
      str = asl.g(getContext());
    return ahy.a(getContext(), asq.f(getContext(), str));
  }

  private ListAdapter a(yx paramyx, String paramString)
  {
    boolean bool2 = true;
    if (b(paramString))
      paramString = asl.g(getContext());
    for (int i1 = 1; i1 != 0; i1 = 0)
      return new zx(this, paramyx, 10);
    i1 = -1;
    switch (paramString.hashCode())
    {
    default:
    case -973170826:
    case -1521143749:
    case -1547699361:
    case -1897170512:
    case -1651733025:
    case 1242258729:
    }
    while (true)
      switch (i1)
      {
      default:
        return new aae(this, paramyx, paramString);
        if (paramString.equals("com.tencent.mm"))
        {
          i1 = 0;
          continue;
          if (paramString.equals("jp.naver.line.android"))
          {
            i1 = 1;
            continue;
            if (paramString.equals("com.whatsapp"))
            {
              i1 = 2;
              continue;
              if (paramString.equals("org.telegram.messenger"))
              {
                i1 = 3;
                continue;
                if (paramString.equals("com.viber.voip"))
                {
                  i1 = 4;
                  continue;
                  if (paramString.equals("com.textra"))
                    i1 = 5;
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    if (Build.VERSION.SDK_INT >= 18);
    for (i1 = 6; ; i1 = 0)
    {
      bool2 = false;
      bool1 = false;
      return new zx(this, paramyx, i1, bool1, bool2);
    }
    for (boolean bool1 = true; ; bool1 = false)
    {
      i1 = 0;
      break;
      bool2 = false;
    }
  }

  private void a(final Runnable paramRunnable)
  {
    if (b())
    {
      this.l.a(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramRunnable.run();
        }
      });
      return;
    }
    if ((this.n == null) || (this.n.get() == null))
    {
      paramRunnable.run();
      return;
    }
    this.a.animate().alpha(0.0F).setDuration(190L).setListener(null);
    this.h.a(paramRunnable);
    this.e.animate().scaleX(0.0F).scaleY(0.0F).setDuration(190L).setInterpolator(new AccelerateInterpolator(2.0F)).setListener(null);
  }

  private void b(FanItem paramFanItem, yw paramyw)
  {
    this.n = new WeakReference(paramFanItem);
    this.i = paramyw;
    if ((paramyw instanceof za))
    {
      this.f.setText(2131231259);
      this.d.setAdapter(new zb(getContext(), (za)paramyw, this));
      this.h.setVisibility(8);
      this.j.setVisibility(0);
      this.e.setBackgroundColor(0);
      findViewById(2131755264).setVisibility(4);
      this.l.a(0, getHeight());
      ((TextView)findViewById(2131755084)).setTextColor(-1);
      ((ImageView)findViewById(2131755217)).setImageResource(2130837652);
      findViewById(2131755217).setVisibility(0);
      this.g.setVisibility(8);
    }
    while (true)
    {
      paramFanItem = new awb(this.d, new awc()
      {
        public void a(ListView paramAnonymousListView, int[] paramAnonymousArrayOfInt)
        {
          paramAnonymousListView = paramAnonymousListView.getAdapter();
          if ((paramAnonymousListView instanceof zz))
            ((zz)paramAnonymousListView).a_(paramAnonymousArrayOfInt[0]);
        }

        public boolean a(int paramAnonymousInt)
        {
          return ((NotificationView.b(NotificationView.this).getAdapter() instanceof aae)) || ((NotificationView.b(NotificationView.this).getAdapter() instanceof zx));
        }

        public boolean a(ListView paramAnonymousListView)
        {
          NotificationView.this.a();
          return true;
        }
      });
      this.d.setOnTouchListener(paramFanItem);
      this.d.setOnScrollListener(paramFanItem.a());
      requestLayout();
      d();
      return;
      if ((paramyw instanceof ajo))
      {
        this.d.setAdapter(new ajp((ajo)paramyw, this));
        this.h.setVisibility(8);
        this.j.setVisibility(0);
        this.l.a(0, getHeight());
        this.e.setBackgroundColor(0);
        findViewById(2131755264).setVisibility(4);
        this.f.setTextColor(-1);
        this.f.setText("");
        ((ImageView)findViewById(2131755217)).setImageResource(2130837652);
        findViewById(2131755217).setVisibility(4);
        this.g.setVisibility(8);
      }
      else if ((paramyw instanceof yx))
      {
        this.h.setVisibility(0);
        this.j.setVisibility(8);
        this.e.setBackgroundResource(2130837740);
        String str = paramyw.f();
        CharSequence localCharSequence = alo.c(str);
        findViewById(2131755217).setVisibility(0);
        paramFanItem = localCharSequence;
        if (TextUtils.isEmpty(localCharSequence))
          paramFanItem = paramyw.a();
        this.g.setText(getContext().getString(2131230994, new Object[] { paramFanItem }));
        this.g.setVisibility(0);
        this.g.setOnClickListener(this);
        findViewById(2131755264).setVisibility(0);
        this.d.setAdapter(a((yx)paramyw, str));
        this.h.setAvatar(a(str));
        this.f.setText(paramFanItem);
        this.a.setBackgroundColor(-16777216);
        this.f.setTextColor(-14540254);
        ((ImageView)findViewById(2131755217)).setImageResource(2130837653);
      }
    }
  }

  private boolean b(String paramString)
  {
    return paramString.length() <= 1;
  }

  private void d(NotificationData paramNotificationData)
  {
    if (paramNotificationData != null)
      ((ali)this.i).a(paramNotificationData);
    while (true)
    {
      a();
      return;
      ((alh)this.i).g();
    }
  }

  private void f()
  {
    a(new Runnable()
    {
      public void run()
      {
        try
        {
          ((alh)NotificationView.a(NotificationView.this)).g();
          NotificationView.this.a(true);
          if (NotificationView.this.c)
            yb.p();
          return;
        }
        catch (Exception localException)
        {
          Log.i("Swipe.NotificationView", "", localException);
        }
      }
    });
    if ((this.d.getAdapter() instanceof zb))
      ((zb)this.d.getAdapter()).d();
  }

  public void a()
  {
    a(false);
  }

  public void a(aad paramaad, NotificationData paramNotificationData, int paramInt, OnClickListener paramOnClickListener)
  {
    paramaad.a();
    Object localObject1 = alo.b(paramNotificationData.e);
    if ("com.textra".equals(this.i.f()))
    {
      paramaad.g.setVisibility(8);
      return;
    }
    if (localObject1 != null)
    {
      paramaad.g.setVisibility(0);
      paramaad.f.setTag(paramNotificationData);
    }
    while (true)
    {
      localObject1 = alo.c(paramNotificationData.e);
      if (localObject1 == null)
        break;
      int i1 = localObject1.length;
      if (i1 <= 0)
        break;
      if (paramaad.g.getVisibility() != 0)
      {
        paramaad.g.removeAllViews();
        paramaad.g.setVisibility(0);
      }
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(2131296376));
      localLayoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(2131296377), 0);
      i1 -= 1;
      label153: if (i1 < 0)
        break;
      Object localObject2 = localObject1[i1];
      try
      {
        if ("com.skype.raider".equals(localObject2.c.getTargetPackage()))
        {
          boolean bool = "com.skype.action.REPLY_WITH_EMOTICON".equals(asq.a(localObject2.c).getAction());
          if (bool)
          {
            i1 -= 1;
            break label153;
            paramaad.g.setVisibility(8);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        while (true)
        {
          TextView localTextView = new TextView(getContext());
          localTextView.setGravity(17);
          localTextView.setTextSize(2, 14.0F);
          localTextView.setTextColor(-14540254);
          localTextView.setBackgroundDrawable(new awe(getContext(), 2130837736));
          localTextView.setText(localObject1[i1].b);
          localTextView.setTag(String.valueOf(paramNotificationData.e) + "," + String.valueOf(i1) + "," + String.valueOf(paramInt));
          localTextView.setMaxWidth(asq.a(150.0F));
          localTextView.setMinimumWidth(asq.a(82.0F));
          localTextView.setOnClickListener(paramOnClickListener);
          paramaad.g.addView(localTextView, 0, localLayoutParams);
          localTextView.setEllipsize(TruncateAt.END);
          localTextView.setSingleLine();
        }
      }
    }
  }

  public void a(ComponentName paramComponentName)
  {
    if (asq.a(this.k, paramComponentName.getPackageName()))
    {
      wq.b().b(this);
      yb.p();
    }
  }

  public void a(View paramView)
  {
    try
    {
      paramView = paramView.getTag();
      if ((paramView instanceof String))
      {
        paramView = ((String)paramView).split(",");
        alo.c(Long.parseLong(paramView[0]))[Integer.parseInt(paramView[1])].c.send();
        int i1 = Integer.parseInt(paramView[2]);
        if (i1 >= 0)
          ((zy)this.d.getAdapter()).a_(i1);
      }
      return;
    }
    catch (Throwable paramView)
    {
    }
  }

  public void a(FanItem paramFanItem, yw paramyw)
  {
    if ((yb.getInstance() != null) && (yb.getInstance().getLeapView() != null))
      yb.getInstance().getLeapView().animate().alpha(0.0F).setDuration(200L).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if ((yb.getInstance() != null) && (yb.getInstance().getLeapView() != null))
            yb.getInstance().getLeapView().setVisibility(8);
        }
      });
    for (this.m = true; ; this.m = false)
    {
      a(paramFanItem, paramyw, null);
      return;
    }
  }

  public void a(FanItem paramFanItem, yw paramyw, PopupWindow paramPopupWindow)
  {
    setVisibility(0);
    this.c = false;
    this.b = paramPopupWindow;
    this.h.b();
    this.d.setSelection(0);
    this.e.setScaleX(0.0F);
    this.e.setScaleY(0.0F);
    b(paramFanItem, paramyw);
    if (b())
    {
      this.l.a(paramFanItem);
      this.l.b();
    }
    while (true)
    {
      requestFocus();
      return;
      setAlpha(1.0F);
    }
  }

  public void a(NotificationData paramNotificationData)
  {
    if (this.o == null)
      this.o = new aaa();
    this.o.a(paramNotificationData, this.f.getText(), this.h.getAvatar(), this);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setLayerType(0, null);
      setVisibility(8);
      if (this.b != null)
        this.b.dismiss();
      this.a.setAlpha(0.0F);
      this.a.setVisibility(8);
      if ((yb.getInstance() != null) && (yb.getInstance().getLeapView() != null) && (this.m))
      {
        yb.getInstance().getLeapView().setAlpha(0.0F);
        yb.getInstance().getLeapView().setVisibility(0);
        yb.getInstance().getLeapView().animate().alpha(1.0F).setDuration(200L).setListener(null);
        this.m = false;
      }
    }
    do
    {
      return;
      a(new Runnable()
      {
        public void run()
        {
          try
          {
            NotificationView.this.a(true);
            if (NotificationView.this.c)
              yb.p();
            return;
          }
          catch (Exception localException)
          {
            Log.i("Swipe.NotificationView", "", localException);
          }
        }
      });
    }
    while (!(this.d.getAdapter() instanceof zb));
    ((zb)this.d.getAdapter()).d();
  }

  public void b(ComponentName paramComponentName)
  {
  }

  public void b(NotificationData paramNotificationData)
  {
    this.k = paramNotificationData.l;
    try
    {
      wq.b().a(this);
      return;
    }
    catch (Exception paramNotificationData)
    {
      asp.b("Swipe.NotificationView", "Failed to reply.", paramNotificationData);
    }
  }

  public boolean b()
  {
    return ((this.i instanceof za)) || ((this.i instanceof ajo));
  }

  public void c()
  {
    d(null);
  }

  public void c(NotificationData paramNotificationData)
  {
    setShrinkToIconPoint(false);
    d(paramNotificationData);
  }

  public void d()
  {
    if (b())
    {
      this.a.setVisibility(0);
      this.a.animate().alpha(1.0F).setDuration(200L).setListener(null);
      this.e.setAlpha(0.0F);
      this.e.setScaleX(1.0F);
      this.e.setScaleY(1.0F);
      this.e.animate().alpha(1.0F).setDuration(200L).setListener(null);
    }
    while ((this.n == null) || (this.n.get() == null))
      return;
    final FanItem localFanItem = (FanItem)this.n.get();
    Object localObject = new int[2];
    localFanItem.getLocationInWindow((int[])localObject);
    if (vj.g);
    for (localObject = new TranslateAnimation(0.0F, vj.e - asq.a(37.0F) - localObject[0], 0.0F, -localObject[1]); ; localObject = new TranslateAnimation(0.0F, vj.e - localObject[0], 0.0F, asq.a(37.0F) - localObject[1]))
    {
      ((TranslateAnimation)localObject).setDuration(180L);
      ((ViewGroup)localFanItem.getParent()).setClipChildren(false);
      ((TranslateAnimation)localObject).setInterpolator(new AccelerateInterpolator());
      ((TranslateAnimation)localObject).setFillAfter(true);
      ((TranslateAnimation)localObject).setAnimationListener(new asw()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          NotificationView.this.a.setVisibility(0);
          NotificationView.this.a.setAlpha(0.0F);
          NotificationView.this.a.animate().alpha(1.0F).setDuration(200L).setListener(null);
          ((ViewGroup)localFanItem.getParent()).setClipChildren(true);
          NotificationView.c(NotificationView.this).a();
          NotificationView.d(NotificationView.this).animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter()
          {
            public void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              NotificationView.5.this.a.clearAnimation();
            }
          });
        }
      });
      localFanItem.startAnimation((Animation)localObject);
      return;
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (b())
      this.l.a(paramCanvas);
    super.dispatchDraw(paramCanvas);
    if (b())
      this.l.b(paramCanvas);
  }

  public void e()
  {
    if (this.d.getAdapter().getCount() > 0)
      this.d.setSelection(this.d.getAdapter().getCount() - 1);
  }

  public boolean j()
  {
    yb.p();
    return true;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      if (b())
        this.l.a(true);
      a();
      return;
    case 2131755217:
      vv.a().a("通知详情点击清理");
      if (b())
        this.l.a(true);
      f();
      return;
    case 2131755072:
    }
    paramView = asq.h(getContext(), this.i.f());
    if (paramView != null)
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(paramView.getPackageName(), paramView.getClassName());
      asq.d(getContext(), localIntent);
    }
    c();
    asq.t(getContext());
    yb.p();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (wq.b() != null)
      wq.b().b(this);
    if (this.o != null)
      this.o.a();
    setLayerType(0, null);
    ListAdapter localListAdapter = this.d.getAdapter();
    if ((localListAdapter instanceof CursorAdapter))
      ((CursorAdapter)localListAdapter).changeCursor(null);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(2131755395);
    this.l = new aab(this);
    this.d = ((ListView)findViewById(2131755046));
    this.j = findViewById(2131755398);
    this.f = ((TextView)findViewById(2131755084));
    this.g = ((TextView)findViewById(2131755072));
    this.e = findViewById(2131755399);
    findViewById(2131755217).setOnClickListener(this);
    this.h = ((NotificationAvatarList)findViewById(2131755397));
    this.d.setOnItemClickListener(this);
    setOnClickListener(this);
    ProgressBar localProgressBar = (ProgressBar)findViewById(16908292);
    tn localtn = new tn(getContext());
    localProgressBar.setProgressDrawable(localtn);
    localProgressBar.setIndeterminateDrawable(localtn);
    this.d.setEmptyView(localProgressBar);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (b())
      this.l.a(paramMotionEvent);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    zz localzz = (zz)this.d.getAdapter();
    if (((localzz instanceof zb)) && (((zb)localzz).b()))
      return;
    yb.p();
    localzz.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    asq.t(getContext());
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt)
    {
      if (b())
        this.l.a();
      a();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      label11: if ((paramBoolean) && (b()))
        this.l.a(paramInt2, paramInt4);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label11;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (vj.g)
    {
      this.e.setPivotX(this.e.getMeasuredWidth());
      this.e.setPivotY(asq.a(15.0F));
      return;
    }
    this.e.setPivotX(this.e.getMeasuredWidth() - asq.a(15.0F));
    this.e.setPivotY(0.0F);
  }

  public void setShrinkToIconPoint(boolean paramBoolean)
  {
    if (b())
      this.l.b(paramBoolean);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.notification.NotificationView
 * JD-Core Version:    0.6.2
 */