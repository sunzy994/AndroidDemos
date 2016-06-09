package cmcm.com.myapplication;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

@Deprecated
public class aef extends adp
  implements OnClickListener
{
  public TextView h;

  public aef(Context paramContext)
  {
    super(paramContext);
    this.h = new TextView(paramContext);
    this.h.setTextColor(-16777216);
    addView(this.h);
    setBackgroundColor(-1);
    setOnClickListener(this);
  }

  public void a(Object paramObject)
  {
    super.a(paramObject);
    this.h.setText(paramObject.toString());
  }

  public void b()
  {
  }

  public adt getCardHolder()
  {
    return new aeg(this);
  }

  public void onClick(View paramView)
  {
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString());
    if (this.h == null);
    for (Object localObject = ""; ; localObject = this.h.getText())
      return localObject;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aef
 * JD-Core Version:    0.6.2
 */