package cmcm.com.myapplication.com.lazyswipe.preference;

import alz;
import ama;
import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import asp;

public class MyCheckboxPreference extends CheckBoxPreference
  implements alz
{
  private final ama a;
  private Object b;

  public MyCheckboxPreference(Context paramContext)
  {
    this(paramContext, null);
  }

  public MyCheckboxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MyCheckboxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(2130968724);
    setWidgetLayoutResource(2130968729);
    this.a = new ama(this, paramContext, paramAttributeSet, paramInt);
  }

  public Object a()
  {
    return this.b;
  }

  public void a(int paramInt)
  {
    this.a.b(paramInt);
    notifyChanged();
  }

  public void a(Object paramObject)
  {
    this.b = paramObject;
  }

  public void b()
  {
    this.a.b();
    notifyChanged();
  }

  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getView(paramView, paramViewGroup);
      return paramView;
    }
    catch (Throwable paramView)
    {
      asp.a("Swipe.MyCheckboxPreference", "Exception in Preference.getView()", paramView);
    }
    return null;
  }

  public boolean isChecked()
  {
    return super.isChecked();
  }

  protected void onBindView(View paramView)
  {
    if (paramView == null)
      return;
    super.onBindView(paramView);
    this.a.b(paramView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.preference.MyCheckboxPreference
 * JD-Core Version:    0.6.2
 */