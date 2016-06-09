package cmcm.com.myapplication.com.lazyswipe.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import aph;
import aqs;
import com.lazyswipe.SwipeService;

public class FullscreenTipActivity extends aph
  implements OnClickListener
{
  int i;
  Paint j;
  Path k;
  String l;

  public static void a(Context paramContext)
  {
    aqs.e(paramContext);
    a(paramContext, 2131230986);
  }

  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, null);
  }

  public static void a(Context paramContext, final int paramInt, final String paramString)
  {
    Handler localHandler2 = SwipeService.a();
    Handler localHandler1 = localHandler2;
    if (localHandler2 == null)
      localHandler1 = new Handler();
    localHandler1.postDelayed(new Runnable()
    {
      public void run()
      {
        Intent localIntent = new Intent(FullscreenTipActivity.this, FullscreenTipActivity.class).putExtra("extra.MESSAGE_RES_ID", paramInt).addFlags(268435456);
        if (!TextUtils.isEmpty(paramString))
          localIntent.putExtra("extra.MESSAGE", paramString);
        FullscreenTipActivity.this.startActivity(localIntent);
      }
    }
    , 400L);
  }

  public static void b(Context paramContext)
  {
    aqs.g(paramContext);
    a(paramContext, 2131230979);
  }

  public static void c(Context paramContext)
  {
    aqs.f(paramContext);
    a(paramContext, 2131230979);
  }

  public static void d(Context paramContext)
  {
    if (aqs.i(paramContext));
    for (int m = 2131231149; ; m = 2131230984)
    {
      a(paramContext, m);
      return;
    }
  }

  public static void e(Context paramContext)
  {
    a(paramContext, 2131230979);
  }

  public static void f(Context paramContext)
  {
    a(paramContext, 2131231235);
  }

  Paint a(DisplayMetrics paramDisplayMetrics)
  {
    if (this.j == null)
    {
      this.j = new Paint(7);
      this.j.setAntiAlias(true);
      this.j.setStyle(Style.STROKE);
      this.j.setColor(-1);
      float f1 = 4.0F * paramDisplayMetrics.density;
      float f2 = f1 / 2.0F;
      this.j.setPathEffect(new DashPathEffect(new float[] { f1, f2, f1, f2 }, 0.0F));
    }
    return this.j;
  }

  Path a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramInt1, paramInt2);
    localPath.lineTo(paramInt3, paramInt2);
    localPath.lineTo(paramInt3, paramInt4);
    localPath.lineTo(paramInt1, paramInt4);
    localPath.close();
    return localPath;
  }

  public void onClick(View paramView)
  {
    finish();
    if ((2131230981 == this.i) && (aqs.G()))
      System.exit(0);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int n = getResources().getDimensionPixelSize(2131296298);
    paramBundle = getIntent();
    this.l = paramBundle.getStringExtra("extra.MESSAGE");
    this.i = paramBundle.getIntExtra("extra.MESSAGE_RES_ID", 0);
    if (2131231235 == this.i)
    {
      this.l = getString(2131231235);
      this.i = 0;
    }
    try
    {
      for (paramBundle = getResources().getDrawable(2130837851); ; paramBundle = null)
      {
        int m;
        Object localObject;
        if ((2131230977 == this.i) && (!aqs.L()))
        {
          this.l = getString(this.i);
          this.i = 0;
          m = this.l.indexOf('\n');
          if (m > 0)
            this.l = this.l.substring(0, m);
          localObject = getResources().getDisplayMetrics();
          this.j = a((DisplayMetrics)localObject);
          m = ((DisplayMetrics)localObject).widthPixels;
          this.k = a((int)(((DisplayMetrics)localObject).density * 180.0F + 0.5D), 0, m - (int)(((DisplayMetrics)localObject).density * 30.0F + 0.5D), (int)(((DisplayMetrics)localObject).density * 45.0F + 0.5D));
        }
        while (true)
        {
          try
          {
            localObject = new TextView(this)
            {
              protected void onDraw(Canvas paramAnonymousCanvas)
              {
                super.onDraw(paramAnonymousCanvas);
                if (FullscreenTipActivity.this.k != null)
                  paramAnonymousCanvas.drawPath(FullscreenTipActivity.this.k, FullscreenTipActivity.this.j);
              }
            };
            ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            ((TextView)localObject).setGravity(17);
            ((TextView)localObject).setTextColor(getResources().getColor(2131689559));
            ((TextView)localObject).setTextSize(0, getResources().getDimension(2131296292));
            ((TextView)localObject).setPadding(n, 0, n, 0);
            ((TextView)localObject).setOnClickListener(this);
            if (this.i > 0)
            {
              ((TextView)localObject).setText(this.i);
              this.l = ((TextView)localObject).getText().toString();
              if (paramBundle != null)
              {
                ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, paramBundle, null, null);
                m = paramBundle.getIntrinsicHeight() + 0;
                if (0 != 0)
                {
                  ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                  throw new NullPointerException();
                }
                if (m > 0)
                {
                  paramBundle = new Rect();
                  ((TextView)localObject).getPaint().getTextBounds(this.l, 0, 1, paramBundle);
                  int i1 = paramBundle.height() << 1;
                  m = (getResources().getDisplayMetrics().heightPixels - m - i1 >> 1) - i1;
                  ((TextView)localObject).setPadding(n, m, n, m - n - n);
                }
                setContentView((View)localObject);
              }
            }
            else
            {
              ((TextView)localObject).setText(this.l);
              continue;
            }
          }
          catch (Exception paramBundle)
          {
            finish();
            return;
          }
          m = 0;
        }
      }
    }
    catch (Throwable paramBundle)
    {
      while (true)
        paramBundle = null;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.FullscreenTipActivity
 * JD-Core Version:    0.6.2
 */