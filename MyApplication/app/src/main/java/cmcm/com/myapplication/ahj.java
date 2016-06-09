package cmcm.com.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ahj
{
  private final View b;
  private final View c;
  private final ImageView d;
  private final ImageView e;
  private final TextView f;

  public ahj(ahi paramahi, View paramView)
  {
    this.b = paramView.findViewById(2131755469);
    this.c = paramView.findViewById(2131755470);
    this.d = ((ImageView)paramView.findViewById(2131755064));
    this.e = ((ImageView)paramView.findViewById(2131755471));
    this.f = ((TextView)paramView.findViewById(2131755248));
  }

  public void a(ahk paramahk)
  {
    if (paramahk.f)
    {
      this.d.setImageResource(2130837781);
      this.e.setImageResource(2130837783);
    }
    while (true)
    {
      this.c.setTag(paramahk);
      this.c.setOnClickListener(this.a);
      this.f.setText(paramahk.d());
      return;
      this.d.setImageResource(2130837785);
      this.e.setImageResource(2130837784);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahj
 * JD-Core Version:    0.6.2
 */