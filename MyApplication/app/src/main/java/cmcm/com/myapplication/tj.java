package cmcm.com.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.widget.Button;

public class tj extends Dialog
  implements Callback
{
  public static final OnClickListener b = new OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      if (-2 == paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
        return;
      }
      paramAnonymousDialogInterface.dismiss();
    }
  };
  Handler a;
  private final Context c;
  private final Window d;
  private int e;
  private int f;
  private CharSequence g;

  public tj(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.c = paramContext;
    this.d = getWindow();
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt2;
    this.f = paramInt3;
    c(paramInt1);
    Button localButton = b(this.e);
    if (localButton != null)
      this.g = localButton.getText();
  }

  private void c(int paramInt)
  {
    Handler localHandler = this.a;
    Message localMessage = Message.obtain(this.a, 1, this.e, paramInt);
    if (paramInt == this.f);
    for (long l = 0L; ; l = 1000L)
    {
      localHandler.sendMessageDelayed(localMessage, l);
      return;
    }
  }

  public Button a()
  {
    if (this.d != null)
      return (Button)this.d.findViewById(ts.hola_custom_dialog_positive_button);
    return null;
  }

  public void a(int paramInt)
  {
    Button localButton = b(paramInt);
    if (localButton != null)
      localButton.setTextColor(tk.g());
  }

  public Button b()
  {
    if (this.d != null)
      return (Button)this.d.findViewById(ts.hola_custom_dialog_negative_button);
    return null;
  }

  public Button b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case -1:
      return a();
    case -2:
      return b();
    case -3:
    }
    return c();
  }

  public Button c()
  {
    if (this.d != null)
      return (Button)this.d.findViewById(ts.hola_custom_dialog_neutral_button);
    return null;
  }

  public void dismiss()
  {
    try
    {
      super.dismiss();
      if (this.a != null)
        this.a.removeMessages(1);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        Log.w("CustomDialog", "Could not dismiss this dialog", localThrowable);
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      int i = paramMessage.arg2;
      if (i <= 0)
        break label75;
      if (this.g != null)
        b(paramMessage.arg1).setText(this.g + " (" + i + "...)");
      c(i - 1);
    }
    while (true)
    {
      return false;
      label75: if (this.g != null)
        b(paramMessage.arg1).performClick();
      else
        dismiss();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     tj
 * JD-Core Version:    0.6.2
 */