package cmcm.com.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.util.Log;
import android.view.KeyEvent;

public class aqt
{
  private static final String a = "Swipe." + aqt.class.getSimpleName();

  public static ProgressDialog a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, OnCancelListener paramOnCancelListener)
  {
    return a(paramContext, paramCharSequence, paramBoolean, true, paramOnCancelListener);
  }

  public static ProgressDialog a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramContext, paramCharSequence, paramBoolean1, paramBoolean2, null);
  }

  public static ProgressDialog a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, OnCancelListener paramOnCancelListener)
  {
    paramContext = new ProgressDialog(paramContext);
    paramContext.setMessage(paramCharSequence);
    paramContext.setCancelable(paramBoolean2);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.setIndeterminate(paramBoolean1);
    paramContext.setOnKeyListener(new OnKeyListener()
    {
      public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        switch (paramAnonymousInt)
        {
        default:
          return false;
        case 84:
        }
        return true;
      }
    });
    try
    {
      paramContext.show();
      return paramContext;
    }
    catch (Throwable paramCharSequence)
    {
    }
    return paramContext;
  }

  public static tj a(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return a(paramContext, paramCharSequence1, paramCharSequence2, null, null, null, null, null, null, null);
  }

  public static tj a(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, OnClickListener paramOnClickListener)
  {
    return a(paramContext, paramCharSequence1, paramCharSequence2, paramCharSequence3, paramOnClickListener, null, null, null, null, null);
  }

  public static tj a(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, OnClickListener paramOnClickListener1, CharSequence paramCharSequence4, OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramCharSequence1, paramCharSequence2, paramCharSequence3, paramOnClickListener1, paramCharSequence4, paramOnClickListener2, null, null, null);
  }

  public static tj a(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, OnClickListener paramOnClickListener1, CharSequence paramCharSequence4, OnClickListener paramOnClickListener2, CharSequence paramCharSequence5, OnClickListener paramOnClickListener3, OnCancelListener paramOnCancelListener)
  {
    return a(paramContext, paramCharSequence1, paramCharSequence2, paramCharSequence3, paramOnClickListener1, paramCharSequence4, paramOnClickListener2, paramCharSequence5, paramOnClickListener3, paramOnCancelListener, -1, -1);
  }

  public static tj a(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, OnClickListener paramOnClickListener1, CharSequence paramCharSequence4, OnClickListener paramOnClickListener2, CharSequence paramCharSequence5, OnClickListener paramOnClickListener3, OnCancelListener paramOnCancelListener, int paramInt1, int paramInt2)
  {
    if (a(paramContext))
      return null;
    paramContext = new tk(paramContext);
    if (paramCharSequence1 != null)
      paramContext.a(paramCharSequence1);
    if (paramCharSequence2 != null)
      paramContext.b(paramCharSequence2);
    if (paramCharSequence3 != null)
    {
      paramContext.a(paramCharSequence3, paramOnClickListener1);
      if (paramInt1 == -1)
        paramContext.f(paramInt1);
    }
    if (paramCharSequence4 != null)
    {
      paramContext.b(paramCharSequence4, paramOnClickListener2);
      if (paramInt1 == -2)
        paramContext.f(paramInt1);
    }
    if (paramCharSequence5 != null)
    {
      paramContext.c(paramCharSequence5, paramOnClickListener3);
      if (paramInt1 == -3)
        paramContext.f(paramInt1);
    }
    if (paramOnCancelListener != null)
      paramContext.a(paramOnCancelListener);
    if (paramInt2 >= 0)
      paramContext.b(paramInt2);
    try
    {
      paramContext = paramContext.b();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Log.e(a, "Show dialog failed and safely ignored.", paramContext);
    }
    return null;
  }

  public static void a(Dialog paramDialog)
  {
    if (paramDialog == null)
      return;
    try
    {
      paramDialog.dismiss();
      return;
    }
    catch (Exception paramDialog)
    {
    }
  }

  public static void a(ProgressDialog paramProgressDialog, Context paramContext)
  {
    if (a(paramContext))
      Log.e(a, "[Silent Exception] Activity [" + paramContext.getClass().getName() + "]finished. No need to Dismiss progress dialog ");
    while ((paramProgressDialog == null) || (!paramProgressDialog.isShowing()))
      return;
    try
    {
      paramProgressDialog.dismiss();
      return;
    }
    catch (RuntimeException paramProgressDialog)
    {
      Log.e(a, "[Silent Exception] Dismiss progress dialog failed. ", paramProgressDialog);
    }
  }

  private static boolean a(Context paramContext)
  {
    return ((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqt
 * JD-Core Version:    0.6.2
 */