package cmcm.com.myapplication;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.lazyswipe.view.FloatTip;
import java.lang.ref.WeakReference;

public class auz
{
  private final Context a;
  private CharSequence b;
  private CharSequence c;
  private SpannableString d;
  private SpannableString e;
  private MovementMethod f;
  private MovementMethod g;
  private boolean h = true;
  private int i;
  private DialogInterface.OnClickListener j;
  private View k;
  private View l;
  private int m = 1;
  private DialogInterface.OnDismissListener n;

  public auz(Context paramContext)
  {
    this.a = paramContext;
  }

  private boolean a(TextView paramTextView, SpannableString paramSpannableString, MovementMethod paramMovementMethod)
  {
    if (paramSpannableString != null)
    {
      paramTextView.setText(paramSpannableString);
      if (paramMovementMethod != null)
        paramTextView.setMovementMethod(paramMovementMethod);
      return true;
    }
    return false;
  }

  public auz a(int paramInt)
  {
    this.b = this.a.getString(paramInt);
    return this;
  }

  public auz a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.n = paramOnDismissListener;
    return this;
  }

  public auz a(View paramView)
  {
    this.l = paramView;
    return this;
  }

  public auz a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    return this;
  }

  public FloatTip a()
  {
    Object localObject = LayoutInflater.from(this.a);
    int i1;
    if (this.i > 0)
    {
      i1 = this.i;
      localObject = (FloatTip)((LayoutInflater)localObject).inflate(i1, null);
      if (this.k == null)
        break label141;
      ((FloatTip)localObject).removeAllViewsInLayout();
      ((FloatTip)localObject).addView(this.k);
    }
    while (true)
    {
      if (this.l != null)
      {
        ViewGroup localViewGroup = (ViewGroup)((FloatTip)localObject).findViewById(2131755253);
        localViewGroup.setVisibility(0);
        localViewGroup.removeAllViews();
        localViewGroup.addView(this.l);
      }
      if (this.j != null)
        ((FloatTip)localObject).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            auz.a(auz.this).onClick(this.a, -1);
          }
        });
      if (this.n != null)
        ((FloatTip)localObject).i = new WeakReference(this.n);
      ((FloatTip)localObject).a(this.m);
      return localObject;
      i1 = 2130968637;
      break;
      label141: if (!a(((FloatTip)localObject).b, this.d, this.f))
      {
        if (!TextUtils.isEmpty(this.b))
          break label220;
        ((FloatTip)localObject).b.setVisibility(8);
      }
      while (true)
      {
        if (a(((FloatTip)localObject).c, this.e, this.g))
          break label232;
        if (!TextUtils.isEmpty(this.c))
          break label234;
        ((FloatTip)localObject).c.setVisibility(8);
        break;
        label220: ((FloatTip)localObject).b.setText(this.b);
      }
      label232: continue;
      label234: ((FloatTip)localObject).c.setText(this.c);
    }
  }

  public FloatTip a(long paramLong)
  {
    FloatTip localFloatTip = a();
    localFloatTip.e = paramLong;
    localFloatTip.a();
    return localFloatTip;
  }

  public auz b(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
    return this;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     auz
 * JD-Core Version:    0.6.2
 */