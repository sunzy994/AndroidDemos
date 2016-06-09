package cmcm.com.myapplication.com.lazyswipe.preference;

import alz;
import ama;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.preference.PreferenceManager.OnActivityDestroyListener;
import android.util.AttributeSet;
import android.view.View;
import aso;
import asp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import tk;

public class MyListPreference extends ListPreference
  implements alz
{
  private final ama a;
  private final Field b;
  private final Field c;
  private final Field d;
  private final Field e;
  private final Field f;
  private final Field g;
  private final Field h;
  private Method i;

  public MyListPreference(Context paramContext)
  {
    this(paramContext, null);
  }

  public MyListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setLayoutResource(2130968724);
    setWidgetLayoutResource(2130968728);
    Class localClass1 = getClass().getSuperclass();
    Class localClass2 = localClass1.getSuperclass();
    this.b = a(localClass2, "mWhichButtonClicked");
    this.d = a(localClass2, "mDialogTitle");
    this.e = a(localClass2, "mDialogIcon");
    this.c = a(localClass2, "mDialogMessage");
    this.f = a(localClass2, "mNegativeButtonText");
    this.g = a(localClass2, "mDialog");
    this.h = a(localClass1, "mClickedDialogEntryIndex");
    try
    {
      this.i = PreferenceManager.class.getDeclaredMethod("registerOnActivityDestroyListener", new Class[] { OnActivityDestroyListener.class });
      this.i.setAccessible(true);
      this.a = new ama(this, paramContext, paramAttributeSet, 0);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
        asp.b("Swipe.MyListPreference", "Method registerOnActivityDestroyListener does not exist");
    }
  }

  public MyListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet);
  }

  private Field a(Class paramClass, String paramString)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      localField.setAccessible(true);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      asp.b("Swipe.MyListPreference", "Field " + paramString + " not found in class " + paramClass.getSimpleName());
    }
    return null;
  }

  public int a()
  {
    return findIndexOfValue(getValue());
  }

  protected Dialog b()
  {
    if ((getEntries() == null) || (getEntryValues() == null))
      throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
    Object localObject = getContext();
    try
    {
      this.b.set(this, Integer.valueOf(-2));
      localObject = new tk((Context)localObject).a((String)this.d.get(this)).b((Drawable)this.e.get(this));
      int j = a();
      this.h.set(this, Integer.valueOf(j));
      ((tk)localObject).a(getEntries(), j, new OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          try
          {
            MyListPreference.a(MyListPreference.this).set(MyListPreference.this, Integer.valueOf(paramAnonymousInt));
            label18: MyListPreference.this.onClick(paramAnonymousDialogInterface, -1);
            aso.a(MyListPreference.this.getContext(), 2131231061);
            paramAnonymousDialogInterface.dismiss();
            return;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            break label18;
          }
        }
      });
      ((tk)localObject).a(null, null);
      View localView = onCreateDialogView();
      if (localView != null)
      {
        onBindDialogView(localView);
        ((tk)localObject).a(localView);
      }
      while (true)
      {
        this.i.invoke(getPreferenceManager(), new Object[] { this });
        return ((tk)localObject).a();
        ((tk)localObject).b((String)this.c.get(this));
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.a.b(paramView);
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    super.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }

  protected void showDialog(Bundle paramBundle)
  {
    Dialog localDialog = b();
    try
    {
      this.g.set(this, localDialog);
      label14: if (paramBundle != null)
        localDialog.onRestoreInstanceState(paramBundle);
      localDialog.setOnDismissListener(this);
      localDialog.show();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label14;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.preference.MyListPreference
 * JD-Core Version:    0.6.2
 */