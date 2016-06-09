package cmcm.com.myapplication.com.hola.channel.pub;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import qj;
import qq;
import qu;
import rn;
import sy;
import te;
import tf;

public class RuntimeActivity extends Activity
{
  private String a;
  private long b;
  private EditText c;
  private FrameLayout d;
  private View e;

  private void a(Throwable paramThrowable)
  {
    if (((paramThrowable instanceof InvocationTargetException)) && ((((InvocationTargetException)paramThrowable).getTargetException() instanceof IllegalArgumentException)))
      rn.a(this).a(getIntent().getStringExtra("game_key"), 0, "", -1);
    qq.a(this, "GR.onCreate", paramThrowable);
    StringBuilder localStringBuilder = new StringBuilder().append("Start game failed!\n");
    if ((paramThrowable instanceof InvocationTargetException));
    for (paramThrowable = ((InvocationTargetException)paramThrowable).getTargetException().getMessage(); ; paramThrowable = paramThrowable.getMessage())
    {
      Toast.makeText(this, paramThrowable, 1).show();
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          RuntimeActivity.this.finish();
        }
      }
      , 2000L);
      return;
    }
  }

  private void a(boolean paramBoolean)
  {
    try
    {
      this.e.getClass().getMethod("setEditViewShow", new Class[] { Boolean.TYPE }).invoke(this.e, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Throwable localThrowable)
    {
      qq.a(localThrowable);
    }
  }

  public void a()
  {
    if (this.c == null)
      return;
    this.c.post(new Runnable()
    {
      public void run()
      {
        ((InputMethodManager)RuntimeActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(RuntimeActivity.a(RuntimeActivity.this).getWindowToken(), 0);
        RuntimeActivity.a(RuntimeActivity.this).setVisibility(8);
        RuntimeActivity.a(RuntimeActivity.this, RuntimeActivity.a(RuntimeActivity.this).isShown());
        String str = RuntimeActivity.a(RuntimeActivity.this).getText().toString();
        sy.a(RuntimeActivity.this, 1, str);
      }
    });
  }

  public void a(final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final int paramInt, final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4, final float paramFloat5)
  {
    if (this.c == null)
      return;
    this.c.post(new Runnable()
    {
      public void run()
      {
        Object localObject = (FrameLayout.LayoutParams)RuntimeActivity.a(RuntimeActivity.this).getLayoutParams();
        if ((localObject instanceof FrameLayout.LayoutParams))
        {
          if (qj.a)
          {
            qq.a("showTextEdit text:" + paramString1);
            qq.a("showTextEdit hint:" + paramString2);
            qq.a("showTextEdit inputtype:" + paramString3);
            qq.a("showTextEdit singleline:" + paramBoolean);
            qq.a("showTextEdit fontcolor:" + paramInt);
            qq.a("showTextEdit fontsize:" + paramFloat1);
            qq.a("showTextEdit at :" + paramFloat2 + "," + paramFloat3);
            qq.a("showTextEdit size:" + paramFloat4 + "," + paramFloat5);
          }
          RuntimeActivity.a(RuntimeActivity.this).setVisibility(0);
          ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)paramFloat2);
          ((FrameLayout.LayoutParams)localObject).topMargin = ((int)paramFloat3);
          int m = (int)paramFloat4;
          int n = (int)paramFloat5;
          if ((m > 0) && (n > 0))
          {
            ((FrameLayout.LayoutParams)localObject).width = m;
            ((FrameLayout.LayoutParams)localObject).height = n;
          }
          RuntimeActivity.a(RuntimeActivity.this).setSingleLine(paramBoolean);
          RuntimeActivity.a(RuntimeActivity.this).setTextColor(paramInt);
          if (paramFloat1 > 0.0F)
            RuntimeActivity.a(RuntimeActivity.this).setTextSize(0, paramFloat1);
          RuntimeActivity.a(RuntimeActivity.this).setHint(paramString2);
          RuntimeActivity.a(RuntimeActivity.this).setText(paramString1);
          RuntimeActivity.a(RuntimeActivity.this).setGravity(19);
          RuntimeActivity.c(RuntimeActivity.this).updateViewLayout(RuntimeActivity.a(RuntimeActivity.this), (ViewGroup.LayoutParams)localObject);
          RuntimeActivity.a(RuntimeActivity.this).requestFocus();
          localObject = (InputMethodManager)RuntimeActivity.this.getSystemService("input_method");
          if (TextUtils.isEmpty(paramString3))
            break label616;
          if (!"number".equals(paramString3))
            break label508;
          RuntimeActivity.a(RuntimeActivity.this).setInputType(2);
        }
        label616: 
        while (true)
        {
          ((InputMethodManager)localObject).showSoftInput(RuntimeActivity.a(RuntimeActivity.this), 0);
          RuntimeActivity.a(RuntimeActivity.this, RuntimeActivity.a(RuntimeActivity.this).isShown());
          return;
          label508: if ("email".equals(paramString3))
          {
            RuntimeActivity.a(RuntimeActivity.this).setInputType(208);
          }
          else if ("password".equals(paramString3))
          {
            RuntimeActivity.a(RuntimeActivity.this).setInputType(128);
          }
          else if (("phone".equals(paramString3)) || ("tel".equals(paramString3)))
          {
            RuntimeActivity.a(RuntimeActivity.this).setInputType(3);
          }
          else
          {
            RuntimeActivity.a(RuntimeActivity.this).setInputType(1);
            continue;
            RuntimeActivity.a(RuntimeActivity.this).setInputType(1);
          }
        }
      }
    });
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      sy.a(this, paramConfiguration);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      qq.a(this, "GR.oCC", paramConfiguration);
    }
  }

  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!qu.a());
    while (true)
    {
      return;
      try
      {
        setContentView(tf.hola_game_activity_runtime);
        this.c = ((EditText)findViewById(te.editview));
        this.d = ((FrameLayout)findViewById(te.gameLayout));
        paramBundle = (RelativeLayout)findViewById(te.adInterstitialLayout);
        final RelativeLayout localRelativeLayout1 = (RelativeLayout)findViewById(te.adBottomLayout);
        final RelativeLayout localRelativeLayout2 = (RelativeLayout)findViewById(te.adTopLayout);
        this.d.setOnTouchListener(new OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            if (paramAnonymousView != RuntimeActivity.a(RuntimeActivity.this))
              RuntimeActivity.this.a();
            return false;
          }
        });
        runOnUiThread(new Runnable()
        {
          public void run()
          {
            try
            {
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
              RuntimeActivity.a(RuntimeActivity.this, (View)sy.a(RuntimeActivity.this, RuntimeActivity.this.getIntent(), qj.a, RuntimeActivity.this.getIntent().getStringExtra("_game_path"), paramBundle, localRelativeLayout1, localRelativeLayout2));
              RuntimeActivity.c(RuntimeActivity.this).addView(RuntimeActivity.b(RuntimeActivity.this), 0, localLayoutParams);
              RuntimeActivity.b(RuntimeActivity.this).setVisibility(0);
              return;
            }
            catch (Throwable localThrowable)
            {
              RuntimeActivity.a(RuntimeActivity.this, localThrowable);
            }
          }
        });
        this.a = getIntent().getStringExtra("game_key");
        if (TextUtils.isEmpty(this.a))
          continue;
        this.b = System.currentTimeMillis();
        rn.a(this).a(this.a, this.b);
        return;
      }
      catch (Throwable paramBundle)
      {
        while (true)
          a(paramBundle);
      }
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      sy.a(this, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      qq.a(this, "GR.onDestroy", localThrowable);
    }
  }

  protected void onPause()
  {
    super.onPause();
    try
    {
      sy.c(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      qq.a(this, "GR.onPause", localThrowable);
    }
  }

  protected void onResume()
  {
    super.onResume();
    try
    {
      sy.b(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      qq.a(this, "GR.onResume", localThrowable);
    }
  }

  protected void onStop()
  {
    super.onStop();
    if (!TextUtils.isEmpty(this.a))
      rn.a(this).b(this.a, this.b);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.pub.RuntimeActivity
 * JD-Core Version:    0.6.2
 */