package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAd.Image;
import java.util.ArrayList;
import java.util.List;

class ahd
{
  private NativeAd b;
  private final View c;
  private final TextView d;
  private final TextView e;
  private final TextView f;
  private final ImageView g;
  private final ImageView h;
  private final ImageView i;
  private NativeAd j;

  public ahd(ahc paramahc, Context paramContext)
  {
    paramahc = LayoutInflater.from(paramContext).inflate(2130968735, null);
    paramahc.setTag(this);
    this.c = paramahc;
    this.d = ((TextView)paramahc.findViewById(2131755079));
    this.e = ((TextView)paramahc.findViewById(2131755080));
    this.f = ((TextView)paramahc.findViewById(2131755081));
    this.g = ((ImageView)paramahc.findViewById(2131755064));
    this.h = ((ImageView)paramahc.findViewById(2131755075));
    this.i = ((ImageView)paramahc.findViewById(2131755076));
    if (this.h.getLayoutParams() != null)
      this.h.getLayoutParams().height = asq.a(149.0F);
    this.f.setTextColor(-1);
  }

  private void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    if (paramTextView != null)
      paramTextView.setText(paramCharSequence);
  }

  public void a()
  {
    if (this.j == this.b)
      return;
    ArrayList localArrayList = new ArrayList();
    if (this.h != null)
      localArrayList.add(this.h);
    if (this.f != null)
      localArrayList.add(this.f);
    if (this.g != null)
      localArrayList.add(this.g);
    if (this.d != null)
      localArrayList.add(this.d);
    localArrayList.add(this.c);
    this.j = this.b;
    this.b.registerViewForInteraction(this.c, localArrayList);
  }

  public void a(NativeAd paramNativeAd)
  {
    this.b = paramNativeAd;
    a(this.d, this.b.getAdTitle());
    a(this.e, this.b.getAdBody());
    ahc.a(this.a).post(new Runnable()
    {
      public void run()
      {
        try
        {
          ahc.a(ahd.this.a, ahd.b(ahd.this), ahd.c(ahd.this).getAdCoverImage().getUrl());
          try
          {
            label30: ahc.a(ahd.this.a, ahd.d(ahd.this), ahd.c(ahd.this).getAdIcon().getUrl());
            return;
          }
          catch (Throwable localThrowable1)
          {
          }
        }
        catch (Throwable localThrowable2)
        {
          break label30;
        }
      }
    });
    a(this.f, this.b.getAdCallToAction());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahd
 * JD-Core Version:    0.6.2
 */