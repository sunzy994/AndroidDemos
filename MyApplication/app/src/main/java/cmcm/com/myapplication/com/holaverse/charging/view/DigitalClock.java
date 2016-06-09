package cmcm.com.myapplication.com.holaverse.charging.view;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Calendar;
import ty;
import tz;
import ux;

public class DigitalClock extends LinearLayout
{
  static String a = "DigitalClock";
  Calendar b;
  String c;
  private TextView d;
  private TextView e;
  private ux f;
  private Runnable g;
  private Handler h;
  private boolean i = false;

  public DigitalClock(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public DigitalClock(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    paramContext.getResources();
    if (this.b == null)
      this.b = Calendar.getInstance();
    this.f = new ux(this);
    c();
    this.h = new Handler();
    this.g = new Runnable()
    {
      public void run()
      {
        if (DigitalClock.a(DigitalClock.this))
          return;
        DigitalClock.this.b.setTimeInMillis(System.currentTimeMillis());
        String str1 = DateFormat.format(DigitalClock.this.c, DigitalClock.this.b).toString();
        String str2 = DateFormat.format(DigitalClock.this.getContext().getString(tz.date_format_month_day_year), DigitalClock.this.b).toString();
        if (DigitalClock.b(DigitalClock.this) != null)
          DigitalClock.b(DigitalClock.this).setText(str1);
        if (DigitalClock.c(DigitalClock.this) != null)
          DigitalClock.c(DigitalClock.this).setText(str2);
        DigitalClock.this.invalidate();
        long l = SystemClock.uptimeMillis();
        DigitalClock.e(DigitalClock.this).postAtTime(DigitalClock.d(DigitalClock.this), l + (1000L - l % 1000L));
      }
    };
  }

  private void c()
  {
    if (get24HourMode())
    {
      this.c = "k:mm";
      return;
    }
    this.c = "h:mm";
  }

  private boolean get24HourMode()
  {
    return DateFormat.is24HourFormat(getContext());
  }

  public void a()
  {
    this.i = false;
    this.g.run();
  }

  public void b()
  {
    this.i = true;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.f);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getContext().getContentResolver().unregisterContentObserver(this.f);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((TextView)findViewById(ty.time));
    this.e = ((TextView)findViewById(ty.date));
  }

  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(DigitalClock.class.getName());
  }

  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(DigitalClock.class.getName());
  }

  public void setTypeface(Typeface paramTypeface)
  {
    this.d.setTypeface(paramTypeface);
    this.e.setTypeface(paramTypeface);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.charging.view.DigitalClock
 * JD-Core Version:    0.6.2
 */