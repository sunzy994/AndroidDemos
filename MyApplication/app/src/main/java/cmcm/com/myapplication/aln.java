package cmcm.com.myapplication;

import android.view.accessibility.AccessibilityEvent;

public final class aln
{
  public AccessibilityEvent a;
  public int b;
  public CharSequence c;
  boolean d;

  public aln(AccessibilityEvent paramAccessibilityEvent, int paramInt, CharSequence paramCharSequence)
  {
    this(paramAccessibilityEvent, paramInt, paramCharSequence, false);
  }

  aln(AccessibilityEvent paramAccessibilityEvent, int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramAccessibilityEvent, paramInt, paramCharSequence, paramBoolean);
  }

  void a(AccessibilityEvent paramAccessibilityEvent, int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.a = AccessibilityEvent.obtain(paramAccessibilityEvent);
    this.b = paramInt;
    this.c = paramCharSequence;
    this.d = paramBoolean;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aln
 * JD-Core Version:    0.6.2
 */