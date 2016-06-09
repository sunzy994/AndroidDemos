package cmcm.com.myapplication.com.lazyswipe.preference;

import alz;
import ama;
import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import asp;

public class MyPreference extends Preference
  implements alz
{
  private static final OnPreferenceClickListener c = new OnPreferenceClickListener()
  {
    public boolean onPreferenceClick(Preference paramAnonymousPreference)
    {
      boolean bool = true;
      if ((paramAnonymousPreference == null) || (!(paramAnonymousPreference instanceof alz)))
      {
        bool = false;
        return bool;
      }
      Object localObject = paramAnonymousPreference.getOnPreferenceClickListener();
      if ((localObject != null) && (((OnPreferenceClickListener)localObject).onPreferenceClick(paramAnonymousPreference)));
      for (int i = 1; ; i = 0)
      {
        localObject = ((MyPreference)paramAnonymousPreference).a();
        if ((localObject != null) && (!((ama)localObject).a()))
          ((ama)localObject).a(true, true);
        if (i != 0)
          break;
        localObject = paramAnonymousPreference.getIntent();
        if (localObject == null)
          break label130;
        try
        {
          paramAnonymousPreference.getContext().startActivity((Intent)localObject);
          return true;
        }
        catch (Throwable localThrowable)
        {
          Toast.makeText(paramAnonymousPreference.getContext(), "No activity found to handle intent: " + localObject, 0).show();
          return true;
        }
      }
      label130: return false;
    }
  };
  private final ama a;
  private OnPreferenceClickListener b;

  public MyPreference(Context paramContext)
  {
    this(paramContext, null);
  }

  public MyPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MyPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(2130968724);
    setWidgetLayoutResource(2130968728);
    this.a = new ama(this, paramContext, paramAttributeSet, paramInt);
  }

  public ama a()
  {
    return this.a;
  }

  public void a(int paramInt)
  {
    this.a.b(paramInt);
    notifyChanged();
  }

  public OnPreferenceClickListener getOnPreferenceClickListener()
  {
    return this.b;
  }

  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    super.setOnPreferenceClickListener(c);
    try
    {
      paramView = super.getView(paramView, paramViewGroup);
      return paramView;
    }
    catch (Throwable paramView)
    {
      asp.a("Swipe.MyPreference", "Exception in Preference.getView()", paramView);
    }
    return null;
  }

  protected void onBindView(View paramView)
  {
    if (paramView == null)
      return;
    super.onBindView(paramView);
    this.a.b(paramView);
  }

  public void setOnPreferenceClickListener(OnPreferenceClickListener paramOnPreferenceClickListener)
  {
    this.b = paramOnPreferenceClickListener;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.preference.MyPreference
 * JD-Core Version:    0.6.2
 */