package cmcm.com.myapplication.com.facebook.ads.internal.view.video.support;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class a extends FrameLayout
{
  private e a;
  private f b;
  private View c;
  private Uri d;
  private Context e;

  public a(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
    this.c = b(paramContext);
    this.a = a(paramContext);
    addView(this.c);
  }

  private e a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      this.b = f.a;
      paramContext = new d(paramContext);
      paramContext.a(this.c, this.d);
      addView(paramContext);
      return paramContext;
    }
    this.b = f.b;
    paramContext = new g(paramContext);
    addView(paramContext);
    return paramContext;
  }

  private View b(Context paramContext)
  {
    paramContext = new View(paramContext);
    paramContext.setBackgroundColor(-16777216);
    paramContext.setLayoutParams(new LayoutParams(-1, -1));
    return paramContext;
  }

  public void a()
  {
    this.a.start();
  }

  public void b()
  {
    this.a.pause();
  }

  public int getCurrentPosition()
  {
    return this.a.getCurrentPosition();
  }

  public View getPlaceholderView()
  {
    return this.c;
  }

  public f getVideoImplType()
  {
    return this.b;
  }

  public void setFrameVideoViewListener(b paramb)
  {
    this.a.setFrameVideoViewListener(paramb);
  }

  public void setVideoImpl(f paramf)
  {
    removeAllViews();
    f localf = paramf;
    if (paramf == f.a)
    {
      localf = paramf;
      if (Build.VERSION.SDK_INT < 14)
        localf = f.b;
    }
    this.b = localf;
    switch (1.a[localf.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      addView(this.c);
      a();
      return;
      paramf = new d(this.e);
      paramf.a(this.c, this.d);
      addView(paramf);
      this.a = paramf;
      continue;
      paramf = new g(this.e);
      paramf.a(this.c, this.d);
      addView(paramf);
      this.a = paramf;
    }
  }

  public void setup(Uri paramUri)
  {
    this.d = paramUri;
    this.a.a(this.c, paramUri);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.video.support.a
 * JD-Core Version:    0.6.2
 */