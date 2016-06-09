package cmcm.com.myapplication.com.facebook.ads;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.ads.internal.adapters.n;
import java.util.HashMap;
import java.util.Map;

class NativeAd$a
  implements OnClickListener, OnTouchListener
{
  private int b;
  private int c;
  private int d;
  private int e;
  private float f;
  private float g;
  private int h;
  private int i;
  private boolean j;

  private NativeAd$a(NativeAd paramNativeAd)
  {
  }

  public Map<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("clickX", Integer.valueOf(this.b));
    localHashMap.put("clickY", Integer.valueOf(this.c));
    localHashMap.put("width", Integer.valueOf(this.d));
    localHashMap.put("height", Integer.valueOf(this.e));
    localHashMap.put("adPositionX", Float.valueOf(this.f));
    localHashMap.put("adPositionY", Float.valueOf(this.g));
    localHashMap.put("visibleWidth", Integer.valueOf(this.i));
    localHashMap.put("visibleHeight", Integer.valueOf(this.h));
    return localHashMap;
  }

  public void onClick(View paramView)
  {
    if (NativeAd.a(this.a) != null)
      NativeAd.a(this.a).onAdClicked(this.a);
    if (!this.j)
      Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
    paramView = a();
    if (NativeAd.i(this.a) != null)
      paramView.put("nti", String.valueOf(NativeAd.i(this.a).getValue()));
    if (NativeAd.j(this.a))
      paramView.put("nhs", String.valueOf(NativeAd.j(this.a)));
    NativeAd.f(this.a).b(paramView);
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (NativeAd.g(this.a) != null))
    {
      this.d = NativeAd.g(this.a).getWidth();
      this.e = NativeAd.g(this.a).getHeight();
      int[] arrayOfInt = new int[2];
      NativeAd.g(this.a).getLocationInWindow(arrayOfInt);
      this.f = arrayOfInt[0];
      this.g = arrayOfInt[1];
      Object localObject = new Rect();
      NativeAd.g(this.a).getGlobalVisibleRect((Rect)localObject);
      this.i = ((Rect)localObject).width();
      this.h = ((Rect)localObject).height();
      localObject = new int[2];
      paramView.getLocationInWindow((int[])localObject);
      this.b = ((int)paramMotionEvent.getX() + localObject[0] - arrayOfInt[0]);
      int k = (int)paramMotionEvent.getY();
      this.c = (localObject[1] + k - arrayOfInt[1]);
      this.j = true;
    }
    return (NativeAd.n(this.a) != null) && (NativeAd.n(this.a).onTouch(paramView, paramMotionEvent));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.NativeAd.a
 * JD-Core Version:    0.6.2
 */