package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;

public class sq extends LinearLayout
{
  private static final String a = "GameSDK." + sq.class.getSimpleName();
  private boolean b;
  private View c;

  public sq(Context paramContext)
  {
    this(paramContext, null);
  }

  public sq(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public sq(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    setOrientation(0);
    setGravity(17);
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    int i = getLayoutResId();
    if (i > 0)
    {
      this.c = qx.a(paramContext, i, this, true);
      e();
      return;
    }
    d();
  }

  private void f()
  {
    this.b = true;
    addView(this.c);
  }

  private void g()
  {
    this.b = false;
    removeView(this.c);
  }

  public void a()
  {
    if (!this.b)
      f();
  }

  public void b()
  {
    if (this.b)
      g();
  }

  public boolean c()
  {
    return this.b;
  }

  protected void d()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(17);
    ProgressBar localProgressBar = new ProgressBar(getContext());
    Object localObject = getContext().getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    localObject = new sk(qs.a(localDisplayMetrics, 4.0F), qs.a(localDisplayMetrics, 8.0F), 0, qs.a(localDisplayMetrics, 8.0F), new int[] { ((Resources)localObject).getColor(tb.hola_game_loading_progress_color_0), ((Resources)localObject).getColor(tb.hola_game_loading_progress_color_1), ((Resources)localObject).getColor(tb.hola_game_loading_progress_color_2), ((Resources)localObject).getColor(tb.hola_game_loading_progress_color_3) });
    localProgressBar.setIndeterminate(true);
    localProgressBar.setIndeterminateDrawable((Drawable)localObject);
    localLinearLayout.addView(localProgressBar, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight() + qs.a(localDisplayMetrics, 12.0F));
    this.c = localLinearLayout;
    this.c.setLayoutParams(new LayoutParams(-1, -2));
  }

  protected void e()
  {
  }

  protected int getLayoutResId()
  {
    return 0;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sq
 * JD-Core Version:    0.6.2
 */