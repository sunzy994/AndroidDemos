package cmcm.com.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.hola.channel.sdk.game.widget.OnlineLoadingView;

public class afx extends aph
  implements agb
{
  private OnlineLoadingView i;
  private LinearLayout j;
  private afy k;

  public void g()
  {
    this.i.a();
  }

  public void h()
  {
    this.i.f();
  }

  public void i()
  {
    this.i.b();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this).inflate(2130968673, null);
    setContentView(paramBundle);
    this.j = ((LinearLayout)findViewById(2131755303));
    this.j.setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        afx.this.finish();
      }
    });
    this.i = ((OnlineLoadingView)findViewById(2131755275));
    this.i.setActionClickListener(new sr()
    {
      public void b()
      {
        afx.a(afx.this).a();
      }
    });
    this.i.setVisibility(8);
    this.k = new afy(this, paramBundle);
    this.k.a(this);
    this.k.a();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.k.b();
  }

  protected void onResume()
  {
    super.onResume();
    this.k.c();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afx
 * JD-Core Version:    0.6.2
 */