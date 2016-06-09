package cmcm.com.myapplication.com.lazyswipe.preference;

import ajl;
import ajm;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import ase;
import asr;
import awe;
import com.lazyswipe.ui.MainActivity;
import tk;
import vs;

public class MyLogoPreference extends Preference
  implements View.OnClickListener
{
  private static final String c = "Swipe." + MyLogoPreference.class.getSimpleName();
  ViewSwitcher a;
  final GestureDetector b = new GestureDetector(getContext(), new OnGestureListener()
  {
    public boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      return false;
    }

    public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      Context localContext = MyLogoPreference.this.getContext();
      switch (asr.a(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2))
      {
      default:
        return false;
      case 1:
        MyLogoPreference.this.a.setInAnimation(localContext, 2131034112);
        MyLogoPreference.this.a.setOutAnimation(localContext, 2131034113);
        MyLogoPreference.this.a.showNext();
        return true;
      case 2:
      }
      MyLogoPreference.this.a.setInAnimation(localContext, 17432578);
      MyLogoPreference.this.a.setOutAnimation(localContext, 17432579);
      MyLogoPreference.this.a.showNext();
      return true;
    }

    public void onLongPress(MotionEvent paramAnonymousMotionEvent)
    {
    }

    public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      return false;
    }

    public void onShowPress(MotionEvent paramAnonymousMotionEvent)
    {
    }

    public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
    {
      return false;
    }
  });
  private Activity d;
  private int e;
  private boolean f = true;
  private ajl g;
  private Drawable h;

  public MyLogoPreference(Context paramContext)
  {
    this(paramContext, null);
  }

  public MyLogoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MyLogoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(2130968727);
  }

  private void a()
  {
    Intent localIntent = ajm.a(getContext(), MainActivity.class);
    ajm.a(getContext(), this.g, localIntent, null, null);
  }

  private void b()
  {
    if (this.e > 0)
    {
      this.e -= 1;
      if (this.e == 0)
        new tk(this.d).c(2131231258).g(2131231236).b(17039369, null).a(2131231254, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.dismiss();
            vs.c(MyLogoPreference.a(MyLogoPreference.this), ase.a());
          }
        }).f(-1).c(false).b(false).b();
    }
  }

  public void a(Activity paramActivity)
  {
    this.d = paramActivity;
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (ajl localajl = ajl.a(getContext()); ; localajl = null)
    {
      this.g = localajl;
      return;
    }
  }

  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    this.e = 5;
    return super.getView(paramView, paramViewGroup);
  }

  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    asr.a(paramView, 2131755415).setOnClickListener(this);
    View localView = asr.a(paramView, 2131755416);
    localView.setOnClickListener(this);
    ((TextView)asr.a(paramView, 2131755415)).setText(String.format("v %s", new Object[] { "2.25" }));
    if (this.g != null)
    {
      String str = getContext().getString(2131230965);
      ((TextView)asr.a(paramView, 2131755417)).setText(String.format("%1$s v%2$s", new Object[] { str, this.g.c }));
      if (this.f)
      {
        this.f = false;
        this.h = new awe(getContext().getResources().getDrawable(2130837519));
        this.a = ((ViewSwitcher)paramView);
        this.a.setOnTouchListener(new OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return MyLogoPreference.this.b.onTouchEvent(paramAnonymousMotionEvent);
          }
        });
        this.a.postDelayed(new Runnable()
        {
          public void run()
          {
            MyLogoPreference.this.a.setInAnimation(MyLogoPreference.this.getContext(), 17432578);
            MyLogoPreference.this.a.setOutAnimation(MyLogoPreference.this.getContext(), 17432579);
            MyLogoPreference.this.a.showNext();
          }
        }
        , 2000L);
      }
    }
    localView.setBackgroundDrawable(this.h);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131755414:
    case 2131755415:
      b();
      return;
    case 2131755416:
    }
    a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.preference.MyLogoPreference
 * JD-Core Version:    0.6.2
 */