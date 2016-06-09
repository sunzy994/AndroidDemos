package cmcm.com.myapplication.com.lazyswipe.features.boostplus;

import acj;
import acl;
import acm;
import acn;
import amk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import aov;
import apd;
import aqs;
import aqt;
import asq;
import atw;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.notification.SwipeAccessibilityService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import vs;
import vy;

public class BoostActivity extends aov
  implements View.OnClickListener
{
  private static boolean j;
  private boolean A = false;
  private List<acl> B = new ArrayList();
  private final List<acl> C = new ArrayList();
  private acj D = null;
  final BroadcastReceiver i = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((-1 != paramAnonymousIntent.getIntExtra("com.lazyswipe.extra.RESULT", -1)) || ((BoostActivity.e(BoostActivity.this) != null) && (BoostActivity.e(BoostActivity.this).size() > 0)))
        paramAnonymousContext = (acl)BoostActivity.e(BoostActivity.this).remove(0);
      if (BoostActivity.f(BoostActivity.this));
      while (BoostActivity.g(BoostActivity.this) == null)
        return;
      BoostActivity.g(BoostActivity.this).a(BoostActivity.h(BoostActivity.this) - BoostActivity.e(BoostActivity.this).size(), new Runnable()
      {
        public void run()
        {
          if (BoostActivity.e(BoostActivity.this).size() > 0)
            BoostActivity.i(BoostActivity.this).post(new Runnable()
            {
              public void run()
              {
                if (!BoostActivity.f(BoostActivity.this))
                  BoostActivity.this.a(((acl)BoostActivity.e(BoostActivity.this).get(0)).a);
              }
            });
        }
      });
    }
  };
  private View k;
  private LinearLayout l;
  private TextView m;
  private TextView n;
  private TextView o;
  private BoostProgressEngine p;
  private PopupWindow q;
  private boolean r = false;
  private int s = 0;
  private Set<String> t = new HashSet();
  private ColorFilter u;
  private AsyncTask<Context, List<acl>, List<acl>> v;
  private View w;
  private final Handler x = new Handler();
  private WindowManager y;
  private BoostPlusCleaningPanel z;

  private int a(List<acl> paramList)
  {
    Iterator localIterator = paramList.iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      if (!((acl)localIterator.next()).f)
        break label150;
      i1 += 1;
    }
    label150: 
    while (true)
    {
      break;
      this.m.setText(Html.fromHtml(getString(2131231190, new Object[] { "<font color=\"#166DFD\">" + (paramList.size() - i1) + "</font>" })));
      this.n.setText(Html.fromHtml(getString(2131231191, new Object[] { "<font color=\"#444444\">" + i1 + "</font>" })));
      return paramList.size() - i1;
    }
  }

  private void a(acl paramacl, FanItem paramFanItem, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFanItem.setText(2131231192);
      paramFanItem.setColorFilter(this.u);
      paramFanItem.setTextColor(-1295924799);
      return;
    }
    paramFanItem.setText(paramacl.c);
    paramFanItem.setColorFilter(null);
    paramFanItem.setTextColor(-6447715);
  }

  static void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, BoostActivity.class);
    localIntent.putExtra("finish_me", true);
    asq.d(paramContext, localIntent);
  }

  private void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("finish_me", false))
    {
      finish();
      j = false;
      this.x.postDelayed(new Runnable()
      {
        public void run()
        {
          BoostActivity.a(BoostActivity.this, true);
        }
      }
      , 30L);
      return;
    }
    i();
    j();
    b(false);
  }

  private void a(ArrayList<acl> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i1 = 0;
    View localView;
    while (i1 < this.l.getChildCount())
    {
      localView = this.l.getChildAt(i1);
      localHashMap.put(localView.getTag(), localView);
      i1 += 1;
    }
    this.l.removeAllViews();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      acl localacl = (acl)localIterator.next();
      localView = (View)localHashMap.remove(localacl);
      paramArrayList = localView;
      if (localView == null)
      {
        paramArrayList = (FanItem)View.inflate(this, 2130968629, null);
        paramArrayList.setCompoundDrawablePadding(asq.a(6.0F));
        paramArrayList.a(2, 10.67F);
        paramArrayList.setIcon(localacl.b);
        paramArrayList.setTag(localacl);
        paramArrayList.setOnClickListener(this);
        paramArrayList.setBackgroundResource(2130837524);
        a(localacl, paramArrayList, localacl.f);
      }
      this.l.addView(paramArrayList, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(2131296336), -2));
    }
  }

  private void a(List<acl> paramList, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    this.A = false;
    acm localacm = acm.a(getApplicationContext());
    List localList = localacm.b(getApplicationContext(), paramList);
    this.z = ((BoostPlusCleaningPanel)LayoutInflater.from(this).inflate(2130968610, null));
    this.z.a(paramRunnable1, paramList, paramRunnable2, this.D, localList);
    this.p.setVisibility(8);
    localacm.a(getApplicationContext(), paramList);
  }

  private void b(boolean paramBoolean)
  {
    if (this.z != null)
    {
      this.z.a(paramBoolean);
      this.z = null;
    }
  }

  private boolean c(boolean paramBoolean)
  {
    int i2 = 2131230981;
    boolean bool2 = true;
    final int i1 = 1;
    boolean bool1;
    if (!aqs.Q())
    {
      bool1 = bool2;
      if (aqs.p())
      {
        bool1 = bool2;
        if (!aqs.G());
      }
    }
    else
    {
      bool1 = aqs.b(this);
      if ((!bool1) && (paramBoolean))
        if (!aqs.p())
          break label105;
    }
    while (true)
    {
      DialogInterface.OnClickListener local3 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (paramAnonymousInt == -1)
          {
            switch (i1)
            {
            default:
              aqs.j(jdField_this);
              return;
            case 2:
              aqs.h(jdField_this);
              return;
            case 3:
            }
            aqs.d(jdField_this);
            return;
          }
          paramAnonymousDialogInterface.dismiss();
        }
      };
      aqt.a(this, getString(2131230946), getString(i2), getString(17039370), local3, getString(17039360), local3);
      return bool1;
      label105: if ((aqs.K()) && (aqs.k(this)))
      {
        i2 = 2131230977;
        i1 = 2;
      }
      else if (aqs.E())
      {
        i2 = 2131230976;
        i1 = 3;
      }
      else
      {
        i1 = 4;
      }
    }
  }

  public static boolean g()
  {
    return (Build.VERSION.SDK_INT >= 16) && (!aqs.k());
  }

  static boolean h()
  {
    return j;
  }

  private void i()
  {
    setContentView(2130968611);
    ((ImageView)findViewById(2131755156)).setColorFilter(-12303292, PorterDuff.Mode.SRC_IN);
    this.k = findViewById(2131755062);
    this.l = ((LinearLayout)findViewById(2131755046));
    this.m = ((TextView)findViewById(2131755157));
    this.n = ((TextView)findViewById(2131755158));
    this.o = ((TextView)findViewById(2131755125));
    this.p = ((BoostProgressEngine)findViewById(2131755138));
    this.p.setOnClickListener(this);
    this.p.setNeedScale(true);
    this.u = new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F });
    a(new ArrayList());
    Object localObject = vs.a(this, "pref_fs_ignore", "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.t = new HashSet(vs.P(getApplicationContext()));
      k();
    }
    while (true)
    {
      this.k.setOnClickListener(this);
      this.o.setOnClickListener(this);
      this.o.setEnabled(false);
      this.D = new acj(getApplicationContext());
      this.D.a();
      return;
      localObject = ((String)localObject).split(";");
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        CharSequence localCharSequence = localObject[i1];
        if (!TextUtils.isEmpty(localCharSequence))
          this.t.add(localCharSequence);
        i1 += 1;
      }
    }
  }

  private void j()
  {
    if (this.v != null)
      this.v.cancel(true);
    this.v = new acn(this.t)
    {
      protected void a(ArrayList<acl> paramAnonymousArrayList)
      {
        BoostActivity.a(BoostActivity.this, paramAnonymousArrayList);
        BoostActivity.a(BoostActivity.this, paramAnonymousArrayList);
      }

      protected void a(List<acl> paramAnonymousList)
      {
        BoostActivity.b(BoostActivity.this, paramAnonymousList);
        TextView localTextView = BoostActivity.a(BoostActivity.this);
        if (BoostActivity.a(BoostActivity.this, paramAnonymousList) > 0);
        for (boolean bool = true; ; bool = false)
        {
          localTextView.setEnabled(bool);
          return;
        }
      }
    };
    this.v.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Context[] { getApplicationContext() });
  }

  private void k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(";");
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext())
      localStringBuilder.append((String)localIterator.next()).append(";");
    vs.b(this, "pref_fs_ignore", localStringBuilder.toString());
  }

  private void l()
  {
    final View localView = LayoutInflater.from(this).inflate(2130968608, null);
    this.q = new PopupWindow(localView, -1, -1, true);
    this.q.setAnimationStyle(2131427373);
    this.q.showAtLocation(getWindow().getDecorView(), 80, 0, 0);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      // ERROR //
      public void onClick(View paramAnonymousView)
      {
        // Byte code:
        //   0: aload_1
        //   1: invokevirtual 34	android/view/View:getId	()I
        //   4: ldc 35
        //   6: if_icmpne +73 -> 79
        //   9: aload_0
        //   10: getfield 19	com/lazyswipe/features/boostplus/BoostActivity$4:b	Lcom/lazyswipe/features/boostplus/BoostActivity;
        //   13: iconst_1
        //   14: invokestatic 38	com/lazyswipe/features/boostplus/BoostActivity:b	(Lcom/lazyswipe/features/boostplus/BoostActivity;Z)Z
        //   17: pop
        //   18: new 40	android/content/Intent
        //   21: dup
        //   22: ldc 42
        //   24: invokespecial 45	android/content/Intent:<init>	(Ljava/lang/String;)V
        //   27: astore_1
        //   28: aload_0
        //   29: getfield 19	com/lazyswipe/features/boostplus/BoostActivity$4:b	Lcom/lazyswipe/features/boostplus/BoostActivity;
        //   32: aload_1
        //   33: invokevirtual 49	com/lazyswipe/features/boostplus/BoostActivity:startActivity	(Landroid/content/Intent;)V
        //   36: aload_0
        //   37: getfield 19	com/lazyswipe/features/boostplus/BoostActivity$4:b	Lcom/lazyswipe/features/boostplus/BoostActivity;
        //   40: invokestatic 52	com/lazyswipe/features/boostplus/BoostActivity:b	(Lcom/lazyswipe/features/boostplus/BoostActivity;)Landroid/widget/PopupWindow;
        //   43: invokevirtual 57	android/widget/PopupWindow:dismiss	()V
        //   46: aload_0
        //   47: getfield 19	com/lazyswipe/features/boostplus/BoostActivity$4:b	Lcom/lazyswipe/features/boostplus/BoostActivity;
        //   50: invokestatic 61	com/lazyswipe/features/boostplus/BoostActivity:c	(Lcom/lazyswipe/features/boostplus/BoostActivity;)V
        //   53: return
        //   54: astore_1
        //   55: aload_0
        //   56: getfield 19	com/lazyswipe/features/boostplus/BoostActivity$4:b	Lcom/lazyswipe/features/boostplus/BoostActivity;
        //   59: invokestatic 52	com/lazyswipe/features/boostplus/BoostActivity:b	(Lcom/lazyswipe/features/boostplus/BoostActivity;)Landroid/widget/PopupWindow;
        //   62: invokevirtual 57	android/widget/PopupWindow:dismiss	()V
        //   65: return
        //   66: astore_1
        //   67: aload_0
        //   68: getfield 19	com/lazyswipe/features/boostplus/BoostActivity$4:b	Lcom/lazyswipe/features/boostplus/BoostActivity;
        //   71: invokestatic 52	com/lazyswipe/features/boostplus/BoostActivity:b	(Lcom/lazyswipe/features/boostplus/BoostActivity;)Landroid/widget/PopupWindow;
        //   74: invokevirtual 57	android/widget/PopupWindow:dismiss	()V
        //   77: aload_1
        //   78: athrow
        //   79: aload_1
        //   80: aload_0
        //   81: getfield 21	com/lazyswipe/features/boostplus/BoostActivity$4:a	Landroid/view/View;
        //   84: if_acmpne -31 -> 53
        //   87: aload_0
        //   88: getfield 19	com/lazyswipe/features/boostplus/BoostActivity$4:b	Lcom/lazyswipe/features/boostplus/BoostActivity;
        //   91: invokestatic 52	com/lazyswipe/features/boostplus/BoostActivity:b	(Lcom/lazyswipe/features/boostplus/BoostActivity;)Landroid/widget/PopupWindow;
        //   94: invokevirtual 57	android/widget/PopupWindow:dismiss	()V
        //   97: return
        //
        // Exception table:
        //   from	to	target	type
        //   18	36	54	java/lang/Exception
        //   18	36	66	finally
      }
    };
    localView.findViewById(2131755125).setOnClickListener(local4);
    localView.setOnClickListener(local4);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.setOnKeyListener(new OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (BoostActivity.b(BoostActivity.this) != null))
        {
          BoostActivity.b(BoostActivity.this).dismiss();
          return true;
        }
        return false;
      }
    });
  }

  private void m()
  {
    this.y = ((WindowManager)getApplicationContext().getSystemService("window"));
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.height = -1;
    localLayoutParams.width = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 2003;
    localLayoutParams.flags = 1032;
    this.w = getLayoutInflater().inflate(2130968607, null);
    ((TextView)this.w.findViewById(2131755123)).setText(getString(2131231183, new Object[] { getString(2131230782) }));
    this.y.addView(this.w, localLayoutParams);
    this.w.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        BoostActivity.d(BoostActivity.this);
      }
    });
  }

  private void n()
  {
    if ((this.y != null) && (this.w != null));
    try
    {
      this.y.removeView(this.w);
      this.w = null;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void o()
  {
    if (this.B == null);
    do
    {
      return;
      this.C.clear();
      Iterator localIterator = this.B.iterator();
      while (localIterator.hasNext())
      {
        acl localacl = (acl)localIterator.next();
        if (!localacl.f)
          this.C.add(localacl);
      }
      this.s = this.C.size();
    }
    while (this.s <= 0);
    a(this.C, new Runnable()
    {
      public void run()
      {
        BoostActivity.this.a(((acl)BoostActivity.e(BoostActivity.this).get(0)).a);
      }
    }
    , new Runnable()
    {
      public void run()
      {
        BoostActivity.i(BoostActivity.this).post(new Runnable()
        {
          public void run()
          {
            BoostActivity.c(BoostActivity.this, true);
            Intent localIntent = new Intent(BoostActivity.this, SwipeAccessibilityService.class).putExtra("com.lazyswipe.extra.CMD", 2);
            BoostActivity.this.startService(localIntent);
            BoostActivity.this.startActivity(new Intent(BoostActivity.this, BoostActivity.class));
          }
        });
      }
    });
  }

  void a(String paramString)
  {
    startService(new Intent(this, SwipeAccessibilityService.class).putExtra("com.lazyswipe.extra.APP", paramString).putExtra("com.lazyswipe.extra.CMD", 1));
  }

  public void onClick(View paramView)
  {
    boolean bool2 = true;
    if (paramView == this.k)
      finish();
    do
    {
      do
      {
        return;
        if ((paramView != this.o) && (paramView != this.p))
          break;
        vy.a(this, "CG");
        if (!amk.a(this))
        {
          l();
          return;
        }
      }
      while (!c(true));
      o();
      return;
    }
    while (!(paramView.getTag() instanceof acl));
    acl localacl = (acl)paramView.getTag();
    label119: TextView localTextView;
    if (!localacl.f)
    {
      bool1 = true;
      localacl.f = bool1;
      if (localacl.f)
        break label169;
      this.t.remove(localacl.a);
      k();
      localTextView = this.o;
      if (a(this.B) <= 0)
        break label202;
    }
    label169: label202: for (boolean bool1 = bool2; ; bool1 = false)
    {
      localTextView.setEnabled(bool1);
      a(localacl, (FanItem)paramView, localacl.f);
      return;
      bool1 = false;
      break;
      if (this.t.contains(localacl.a))
        break label119;
      this.t.add(localacl.a);
      break label119;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    j = true;
    a(getIntent());
    registerReceiver(this.i, new IntentFilter("com.lazyswipe.action.BOOST_RESULT"));
  }

  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.i);
    n();
    if ((this.z == null) && (this.B != null) && (this.B.size() > 0))
      this.C.clear();
    while (true)
    {
      acl localacl;
      try
      {
        Iterator localIterator = new ArrayList(this.B).iterator();
        if (localIterator.hasNext())
        {
          localacl = (acl)localIterator.next();
          if (!(localacl.b instanceof BitmapDrawable))
            break label128;
          atw.a(((BitmapDrawable)localacl.b).getBitmap());
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        this.B.clear();
      }
      j = false;
      return;
      label128: if ((localacl.b instanceof apd))
        atw.a(((apd)localacl.b).a());
    }
  }

  protected void onNewIntent(Intent paramIntent)
  {
    a(paramIntent);
  }

  protected void onResume()
  {
    super.onResume();
    n();
    if (this.r)
    {
      this.r = false;
      if ((amk.a(this)) && (c(false)))
        o();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.boostplus.BoostActivity
 * JD-Core Version:    0.6.2
 */