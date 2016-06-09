package cmcm.com.myapplication;

import android.view.accessibility.AccessibilityRecord;

class ih
{
  public static Object a()
  {
    return AccessibilityRecord.obtain();
  }

  public static void a(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setFromIndex(paramInt);
  }

  public static void a(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityRecord)paramObject).setScrollable(paramBoolean);
  }

  public static void b(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setItemCount(paramInt);
  }

  public static void c(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setToIndex(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ih
 * JD-Core Version:    0.6.2
 */