package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.facebook.ads.internal.util.o;
import java.util.HashMap;

public class g extends LinearLayout
{
  private VideoView a;
  private String b;
  private String c;
  private boolean d;
  private int e;
  private Handler f;
  private Handler g;

  public g(Context paramContext)
  {
    super(paramContext);
    c();
  }

  private void c()
  {
    Object localObject = new MediaController(getContext());
    this.a = new VideoView(getContext());
    ((MediaController)localObject).setAnchorView(this);
    this.a.setMediaController((MediaController)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.a);
    this.g = new Handler();
    localObject = new g.b(this);
    this.g.postDelayed((Runnable)localObject, 250L);
    this.f = new Handler();
    localObject = new g.a(this);
    this.f.postDelayed((Runnable)localObject, 250L);
  }

  private void d()
  {
    if ((!this.d) && (getVideoTimeReportURI() != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("time", Integer.toString(this.e / 1000));
      localHashMap.put("inline", "0");
      new o(localHashMap).execute(new String[] { getVideoTimeReportURI() });
      this.d = true;
      this.e = 0;
    }
  }

  public void a()
  {
    this.a.start();
  }

  public void b()
  {
    if (this.a != null)
      this.a.stopPlayback();
  }

  public String getVideoPlayReportURI()
  {
    return this.b;
  }

  public String getVideoTimeReportURI()
  {
    return this.c;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
  }

  public void setVideoPlayReportURI(String paramString)
  {
    this.b = paramString;
  }

  public void setVideoTimeReportURI(String paramString)
  {
    this.c = paramString;
  }

  public void setVideoURI(Uri paramUri)
  {
    if (paramUri != null)
      this.a.setVideoURI(paramUri);
  }

  public void setVideoURI(String paramString)
  {
    if (paramString != null)
      setVideoURI(Uri.parse(paramString));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.g
 * JD-Core Version:    0.6.2
 */