package cmcm.com.myapplication.com.lazyswipe.features.leap;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.lazyswipe.features.weather.detail.WeatherForecastView;

public class WeatherForecastContainer extends LinearLayout
{
  private WeatherForecastView[] a;

  public WeatherForecastContainer(Context paramContext)
  {
    super(paramContext);
  }

  public WeatherForecastContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public WeatherForecastContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public WeatherForecastContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = new WeatherForecastView[4];
    this.a[0] = ((WeatherForecastView)findViewById(2131755109));
    this.a[1] = ((WeatherForecastView)findViewById(2131755110));
    this.a[2] = ((WeatherForecastView)findViewById(2131755111));
    this.a[3] = ((WeatherForecastView)findViewById(2131755112));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.leap.WeatherForecastContainer
 * JD-Core Version:    0.6.2
 */