package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lazyswipe.view.PreviewImageView;

public class aja
{
  PreviewImageView a;
  TextView b;
  ImageView c;

  aja(View paramView)
  {
    this.a = ((PreviewImageView)paramView.findViewById(2131755064));
    this.b = ((TextView)paramView.findViewById(2131755079));
    this.c = ((ImageView)paramView.findViewById(2131755502));
  }

  void a()
  {
    this.a.a();
  }

  void a(Bitmap paramBitmap)
  {
    this.a.setImageBitmap(paramBitmap);
  }

  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aja
 * JD-Core Version:    0.6.2
 */