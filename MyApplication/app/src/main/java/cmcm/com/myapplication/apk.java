package cmcm.com.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class apk
{
  public static Dialog a(Context paramContext)
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(paramContext).inflate(2130968626, null);
    if (aqs.h())
      localViewGroup.findViewById(2131755072).setBackgroundColor(-16777216);
    final tj localtj = new tk(paramContext).a(localViewGroup).b();
    localViewGroup.findViewById(2131755072).setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        asq.g(apk.this, "com.lazyswipe.pro2");
        vy.b(apk.this, "B53");
        aqt.a(localtj);
      }
    });
    localViewGroup.findViewById(2131755122).setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        aqt.a(apk.this);
      }
    });
    return localtj;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apk
 * JD-Core Version:    0.6.2
 */