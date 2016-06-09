package cmcm.com.myapplication;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.lazyswipe.view.FixedTip;
import java.lang.ref.WeakReference;

public class auy
{
  private final Context a;
  private CharSequence b;
  private Drawable c;
  private CharSequence d;
  private MovementMethod e;
  private DialogInterface.OnClickListener f;
  private DialogInterface.OnClickListener g;
  private DialogInterface.OnCancelListener h;
  private CharSequence i;
  private CharSequence j;
  private View k;

  public auy(Context paramContext)
  {
    this.a = paramContext;
  }

  private boolean a(TextView paramTextView, CharSequence paramCharSequence, MovementMethod paramMovementMethod)
  {
    if (paramCharSequence != null)
    {
      paramTextView.setText(paramCharSequence);
      if (paramMovementMethod != null)
        paramTextView.setMovementMethod(paramMovementMethod);
      return true;
    }
    return false;
  }

  private SpannableString b(int paramInt1, String paramString, Object paramObject, int paramInt2)
  {
    String str = this.a.getResources().getString(paramInt1, new Object[] { paramString });
    SpannableString localSpannableString = new SpannableString(str);
    if (paramObject != null)
    {
      paramInt1 = str.indexOf(paramString);
      localSpannableString.setSpan(paramObject, paramInt1, paramString.length() + paramInt1, paramInt2);
    }
    return localSpannableString;
  }

  public auy a(int paramInt1, String paramString, Object paramObject, int paramInt2)
  {
    this.d = b(paramInt1, paramString, paramObject, paramInt2);
    return this;
  }

  public auy a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.h = paramOnCancelListener;
    return this;
  }

  public auy a(Drawable paramDrawable)
  {
    this.c = paramDrawable;
    return this;
  }

  public auy a(View paramView)
  {
    this.k = paramView;
    return this;
  }

  public auy a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    return this;
  }

  public auy a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.i = paramString;
    this.f = paramOnClickListener;
    return this;
  }

  public FixedTip a()
  {
    final FixedTip localFixedTip = (FixedTip)LayoutInflater.from(this.a).inflate(2130968633, null);
    if (!a(FixedTip.a(localFixedTip), this.d, this.e))
    {
      if (TextUtils.isEmpty(this.b))
        FixedTip.a(localFixedTip).setVisibility(8);
    }
    else
    {
      if (!TextUtils.isEmpty(this.i))
        FixedTip.b(localFixedTip).setText(this.i);
      if (!TextUtils.isEmpty(this.j))
        FixedTip.c(localFixedTip).setText(this.j);
      if (this.c == null)
        break label305;
      FixedTip.d(localFixedTip).setVisibility(0);
      FixedTip.d(localFixedTip).setImageDrawable(this.c);
    }
    while (true)
    {
      float f1 = asq.a(2.0F);
      FixedTip.b(localFixedTip).setBackgroundDrawable(auh.a(-11358745, f1));
      FixedTip.c(localFixedTip).setBackgroundDrawable(auh.b(-6710887, f1));
      FixedTip.b(localFixedTip).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (auy.a(auy.this) != null)
            auy.a(auy.this).onClick(localFixedTip, -1);
          localFixedTip.a(false);
        }
      });
      FixedTip.c(localFixedTip).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (auy.b(auy.this) != null)
            auy.b(auy.this).onClick(localFixedTip, -1);
          localFixedTip.a(false);
        }
      });
      if (this.h != null)
        localFixedTip.b = new WeakReference(this.h);
      if (this.k != null)
      {
        LayoutParams localLayoutParams = new LayoutParams(-2, -2);
        localLayoutParams.gravity = 17;
        int m = MeasureSpec.makeMeasureSpec(aqs.ac(), 0);
        int n = MeasureSpec.makeMeasureSpec(0, 0);
        this.k.measure(m, n);
        FixedTip.a(localFixedTip, this.k.getMeasuredHeight());
        FixedTip.e(localFixedTip).addView(this.k, localLayoutParams);
      }
      localFixedTip.c();
      return localFixedTip;
      FixedTip.a(localFixedTip).setText(this.b);
      break;
      label305: FixedTip.d(localFixedTip).setVisibility(8);
    }
  }

  public auy b(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    return this;
  }

  public auy b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.j = paramString;
    this.g = paramOnClickListener;
    return this;
  }

  public FixedTip b()
  {
    FixedTip localFixedTip = a();
    localFixedTip.a();
    return localFixedTip;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     auy
 * JD-Core Version:    0.6.2
 */