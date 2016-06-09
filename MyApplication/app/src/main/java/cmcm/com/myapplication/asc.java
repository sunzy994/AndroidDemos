package cmcm.com.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.widget.HorizontalGridList;
import java.util.List;

class asc
{
  private Dialog a;
  private final View b;

  public asc(final Activity paramActivity, final arw paramarw, final asd paramasd, final String paramString, final asb paramasb, final boolean paramBoolean, asa[] paramArrayOfasa)
  {
    paramasd = new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof ary))
          ((ary)paramAnonymousView).a();
        do
        {
          do
            return;
          while (!(paramAnonymousView instanceof arx));
          paramAnonymousView = (arx)paramAnonymousView;
          asc.this.a(paramActivity, paramString, paramAnonymousView.a, paramasd, paramasb, paramBoolean);
        }
        while (asc.b(asc.this) == null);
        aqt.a(asc.b(asc.this));
      }
    };
    paramarw = paramarw.a();
    paramActivity = (HorizontalGridList)LayoutInflater.from(paramActivity).inflate(2130968742, null);
    paramActivity.setOnItemClickListener(paramasd);
    paramActivity.setAdapter(new avp(paramActivity)
    {
      protected int a()
      {
        return paramarw.size();
      }

      protected void a(FanItem paramAnonymousFanItem, int paramAnonymousInt)
      {
        if (paramAnonymousInt >= paramarw.size())
          return;
        arz localarz = (arz)paramarw.get(paramAnonymousInt);
        paramAnonymousFanItem.setPressedEffect(FanItem.b);
        paramAnonymousFanItem.setIcon(localarz.d);
        paramAnonymousFanItem.setText(localarz.c);
        paramAnonymousFanItem.setTag(localarz);
      }
    });
    this.b = paramActivity;
    this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
  }

  public void a(Activity paramActivity, String paramString, ComponentName paramComponentName, asd paramasd, asb paramasb, boolean paramBoolean)
  {
    if (paramString != null);
    while (true)
    {
      arv.a(paramActivity, paramComponentName, paramasd, paramString, paramasb);
      return;
      if (paramBoolean)
      {
        String str = "&referrer=aq_tranid%3d0KwjpxdKZOO86Ncx3pTYVfLDSoQ1aylzY%26pid%3dha_lazy_int%26c%3dlazy_sc_others";
        paramString = str;
        if (paramComponentName != null)
        {
          if (!"com.facebook.katana".equals(paramComponentName.getPackageName()))
            break label70;
          paramString = "&referrer=aq_tranid%3d0KwjpxdKZOO86Ncx3pTYVfLDSoQ1aylzY%26pid%3dha_lazy_int%26c%3dlazy_sc_fb";
        }
        while (true)
        {
          paramString = arv.a() + paramString;
          break;
          label70: if ("com.google.android.apps.plus".equals(paramComponentName.getPackageName()))
          {
            paramString = "&referrer=aq_tranid%3d0KwjpxdKZOO86Ncx3pTYVfLDSoQ1aylzY%26pid%3dha_lazy_int%26c%3dlazy_sc_gp";
          }
          else if ("com.vkontakte.android".equals(paramComponentName.getPackageName()))
          {
            paramString = "&referrer=aq_tranid%3d0KwjpxdKZOO86Ncx3pTYVfLDSoQ1aylzY%26pid%3dha_lazy_int%26c%3dlazy_sc_vk";
          }
          else if ("jp.naver.line.android".equals(paramComponentName.getPackageName()))
          {
            paramString = "&referrer=aq_tranid%3d0KwjpxdKZOO86Ncx3pTYVfLDSoQ1aylzY%26pid%3dha_lazy_int%26c%3dlazy_sc_line";
          }
          else
          {
            paramString = str;
            if ("com.whatsapp".equals(paramComponentName.getPackageName()))
              paramString = "&referrer=aq_tranid%3d0KwjpxdKZOO86Ncx3pTYVfLDSoQ1aylzY%26pid%3dha_lazy_int%26c%3dlazy_sc_wa";
          }
        }
      }
      paramString = "http://a.lazyswipe.cn//clients/latest?pid=300105&channel=90003";
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asc
 * JD-Core Version:    0.6.2
 */