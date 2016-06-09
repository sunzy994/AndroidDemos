package cmcm.com.myapplication;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;

public class axw extends LinearLayout
  implements OnClickListener
{
  private axv a;
  private axs b;
  private axx c;
  private int d;

  public axw(axs paramaxs)
  {
    super(paramaxs.a());
    this.b = paramaxs;
    paramaxs = paramaxs.b().iterator();
    int i = 0;
    while (paramaxs.hasNext())
    {
      a((axu)paramaxs.next(), i);
      i += 1;
    }
  }

  private ImageView a(axu paramaxu)
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageDrawable(paramaxu.d());
    return localImageView;
  }

  private void a(axu paramaxu, int paramInt)
  {
    LayoutParams localLayoutParams = new LayoutParams(paramaxu.f(), -1);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setId(paramInt);
    localLinearLayout.setGravity(17);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setBackgroundDrawable(paramaxu.e());
    localLinearLayout.setOnClickListener(this);
    addView(localLinearLayout);
    if (paramaxu.d() != null)
      localLinearLayout.addView(a(paramaxu));
    if (!TextUtils.isEmpty(paramaxu.c()))
      localLinearLayout.addView(b(paramaxu));
  }

  private TextView b(axu paramaxu)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(paramaxu.c());
    localTextView.setGravity(17);
    localTextView.setTextSize(paramaxu.b());
    localTextView.setTextColor(paramaxu.a());
    return localTextView;
  }

  public axx getOnSwipeItemClickListener()
  {
    return this.c;
  }

  public int getPosition()
  {
    return this.d;
  }

  public void onClick(View paramView)
  {
    if ((this.c != null) && (this.a.a()))
      this.c.a(this, this.b, paramView.getId());
  }

  public void setLayout(axv paramaxv)
  {
    this.a = paramaxv;
  }

  public void setOnSwipeItemClickListener(axx paramaxx)
  {
    this.c = paramaxx;
  }

  public void setPosition(int paramInt)
  {
    this.d = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axw
 * JD-Core Version:    0.6.2
 */