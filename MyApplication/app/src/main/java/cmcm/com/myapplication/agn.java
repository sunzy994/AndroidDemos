package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class agn extends LinearLayout
{
  private final int b;

  public agn(agm paramagm, Context paramContext)
  {
    super(paramContext);
    int i = paramagm.f / 4;
    setOrientation(0);
    setGravity(48);
    setPadding(i, 0, i, 0);
    this.b = 0;
  }

  private View a(Context paramContext)
  {
    paramContext = LayoutInflater.from(getContext()).inflate(2130968734, this, false);
    int i = asq.a(0.0F);
    LayoutParams localLayoutParams = (LayoutParams)paramContext.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.setMargins(i, i, i, i);
    localLayoutParams.weight = 1.0F;
    return paramContext;
  }

  public int a(List<agr> paramList, int paramInt)
  {
    int i = paramInt;
    while ((i < this.a.getLineItemCount() + paramInt) && (i < paramList.size()))
    {
      agr localagr = (agr)paramList.get(i);
      View localView = a(getContext());
      a(localView, localagr);
      addView(localView);
      i += 1;
    }
    i = getChildCount();
    if (i < this.a.getLineItemCount())
    {
      paramInt = i;
      while (paramInt < this.a.getLineItemCount())
      {
        addView(a(getContext()));
        paramInt += 1;
      }
    }
    return i;
  }

  protected void a(final View paramView, final agr paramagr)
  {
    paramView.setTag(paramagr);
    paramView.setOnClickListener(this.a);
    ((TextView)paramView.findViewById(2131755079)).setText(paramagr.a());
    paramView = (ImageView)paramView.findViewById(2131755064);
    if (paramagr.c() != null)
      paramView.setImageDrawable(paramagr.c());
    xo localxo;
    do
    {
      do
        return;
      while (agm.a(this.a) == null);
      localxo = agm.a(this.a).a(new xo()
      {
        public void a()
        {
          if (this.a != null)
            agm.b(agn.this.a).post(new Runnable()
            {
              public void run()
              {
                agn.1.this.b.setImageDrawable(agn.1.this.a);
                agn.1.this.c.a(agn.1.this.a);
              }
            });
        }

        public ComponentName b()
        {
          return paramagr.a.i;
        }
      });
    }
    while (localxo == null);
    paramView.setImageDrawable(localxo.a);
    paramagr.a(localxo.a);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agn
 * JD-Core Version:    0.6.2
 */