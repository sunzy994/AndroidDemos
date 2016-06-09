package cmcm.com.myapplication.com.lazyswipe.features.weather.detail;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WeatherForecastView extends LinearLayout
{
  private TextView a;
  private TextView b;
  private TextView c;
  private ImageView d;

  public WeatherForecastView(Context paramContext)
  {
    super(paramContext);
  }

  public WeatherForecastView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public WeatherForecastView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public WeatherForecastView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TextView)findViewById(2131755535));
    this.b = ((TextView)findViewById(2131755537));
    this.c = ((TextView)findViewById(2131755538));
    this.d = ((ImageView)findViewById(2131755536));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.weather.detail.WeatherForecastView
 * JD-Core Version:    0.6.2
 */