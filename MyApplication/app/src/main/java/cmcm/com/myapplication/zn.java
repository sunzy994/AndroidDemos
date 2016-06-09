package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lazyswipe.fan.friend.ContactChoosePanel;
import com.lazyswipe.fan.friend.ContactChoosePanel.ExtraScrollOffsetListView;
import java.util.List;

public class zn extends ArrayAdapter<zl>
{
  public zn(Context paramContext, List<zl> paramList)
  {
    super(paramList, 0, localList);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    zl localzl;
    if (paramView == null)
    {
      paramViewGroup = new zo(this, null);
      paramView = LayoutInflater.from(getContext()).inflate(2130968578, null);
      paramViewGroup.b = ((TextView)paramView.findViewById(2131755050));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131755048));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131755049));
      paramViewGroup.d = paramView.findViewById(2131755051);
      paramView.setTag(paramViewGroup);
      localzl = (zl)getItem(paramInt);
      paramViewGroup.c.setTag(zl.c(localzl));
      Bitmap localBitmap = ContactChoosePanel.f(this.a).a(zl.c(localzl), new zk()
      {
        public void a(Bitmap paramAnonymousBitmap, String paramAnonymousString)
        {
          paramAnonymousString = (ImageView)ContactChoosePanel.a(zn.this.a).findViewWithTag(paramAnonymousString);
          if ((paramAnonymousString != null) && (atw.b(paramAnonymousBitmap)))
            paramAnonymousString.setImageBitmap(paramAnonymousBitmap);
        }
      });
      if (!atw.b(localBitmap))
        break label226;
      paramViewGroup.c.setImageBitmap(localBitmap);
      label146: if (!zl.d(localzl))
        break label245;
      ((ViewGroup)paramViewGroup.a.getParent()).setVisibility(0);
      paramViewGroup.a.setText(ContactChoosePanel.a(this.a, localzl));
      label184: if (!zl.e(localzl))
        break label263;
      paramViewGroup.d.setVisibility(8);
    }
    while (true)
    {
      paramViewGroup.b.setText(zl.f(localzl));
      return paramView;
      paramViewGroup = (zo)paramView.getTag();
      break;
      label226: paramViewGroup.c.setImageDrawable(localzl.a(getContext()));
      break label146;
      label245: ((ViewGroup)paramViewGroup.a.getParent()).setVisibility(8);
      break label184;
      label263: paramViewGroup.d.setVisibility(0);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zn
 * JD-Core Version:    0.6.2
 */