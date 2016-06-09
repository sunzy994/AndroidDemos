package cmcm.com.myapplication;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.lazyswipe.fan.notification.NotificationView;
import com.lazyswipe.notification.NotificationData;
import com.lazyswipe.notification.NotificationData.Action;

public class aaa
{
  private InputMethodManager a;
  private EditText b;
  private boolean c;
  private tj d;

  public void a()
  {
    if ((this.d != null) && (this.d.isShowing()))
      this.d.cancel();
  }

  void a(NotificationData paramNotificationData, NotificationView paramNotificationView)
  {
    String str = this.b.getText().toString();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(str.trim())))
      return;
    this.c = true;
    NotificationData.Action localAction = alo.b(paramNotificationData.e);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    paramNotificationView.b(paramNotificationData);
    try
    {
      localBundle.putCharSequence(localAction.d[0].a(), str);
      br.a(localAction.d, localIntent, localBundle);
      localAction.c.send(paramNotificationView.getContext(), 0, localIntent);
      vv.a().a("回复成功");
      this.b.clearFocus();
      this.a.hideSoftInputFromWindow(this.b.getWindowToken(), 0);
      this.d.dismiss();
      paramNotificationView.c(paramNotificationData);
      return;
    }
    catch (CanceledException localCanceledException)
    {
      while (true)
        asp.b("Swipe.NotificationView", "Failed to reply.", localCanceledException);
    }
  }

  public void a(NotificationData paramNotificationData, CharSequence paramCharSequence, Drawable paramDrawable, final NotificationView paramNotificationView)
  {
    vv.a().a("点击回复");
    if (this.d == null)
    {
      Context localContext = paramNotificationView.getContext();
      this.b = ((EditText)LayoutInflater.from(localContext).inflate(2130968710, null, false));
      this.b.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          Button localButton;
          if (aaa.a(aaa.this) != null)
          {
            paramAnonymousEditable = aaa.b(aaa.this).getText().toString();
            localButton = aaa.a(aaa.this).a();
            if (TextUtils.isEmpty(paramAnonymousEditable))
              break label50;
          }
          label50: for (boolean bool = true; ; bool = false)
          {
            localButton.setEnabled(bool);
            return;
          }
        }

        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
        }

        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
        }
      });
      this.a = ((InputMethodManager)localContext.getSystemService("input_method"));
      this.d = new avx(localContext.getApplicationContext()).a(paramCharSequence).b(paramDrawable).a(48).b(17039360, null).a(17039370, new OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          try
          {
            aaa.this.a((NotificationData)aaa.b(aaa.this).getTag(), paramNotificationView);
            return;
          }
          catch (Throwable paramAnonymousDialogInterface)
          {
          }
        }
      }).f(-1).a(this.b).b(vs.n(localContext)).a(new OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          if (aaa.c(aaa.this))
            return;
          aaa.d(aaa.this).toggleSoftInput(2, 2);
        }
      }).a();
      this.d.a().setEnabled(false);
      this.d.getWindow().setSoftInputMode(4);
    }
    while (true)
    {
      this.c = false;
      this.b.setTag(paramNotificationData);
      this.d.show();
      return;
      this.b.getText().clear();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aaa
 * JD-Core Version:    0.6.2
 */