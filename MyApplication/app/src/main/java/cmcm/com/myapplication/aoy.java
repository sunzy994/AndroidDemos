package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ProgressBar;
import com.lazyswipe.widget.OnlineLoadingView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class aoy extends aox
{
  protected Handler ab = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if ((aoy.this.d() == null) || (aoy.this.d().isFinishing()))
        return;
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 0:
        aoy.this.R();
        return;
      case 1:
      }
      aoy.this.S();
    }
  };
  protected aiy ac;
  protected View ad;
  private int ai = 1;
  private int aj = 8;
  private int ak = 1;
  private boolean al = false;
  private boolean am = false;

  private void Z()
  {
    this.aa.e();
    if (this.ad != null)
      this.ad.setVisibility(0);
  }

  protected Map<String, String> N()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("w", String.valueOf(aqs.ae()));
    localHashMap.put("h", String.valueOf(aqs.af()));
    localHashMap.put("psize", String.valueOf(this.aj));
    localHashMap.put("page", String.valueOf(this.ak));
    return localHashMap;
  }

  protected abstract String O();

  protected void Q()
  {
    if (this.ak > this.ai);
    while (this.al)
      return;
    this.al = true;
    if (this.am)
      Z();
    while (true)
    {
      arj.a(wd.a, new we(d()) {
        public void a() {
          try {
            Object localObject = asq.b(aoy.this.N());
            localObject = "http://a.lazyswipe.cn/" + aoy.this.O() + "?" + (String) localObject;
            localObject = ard.a(aoy.this.d(), (String) localObject);
            if (((arq) localObject).a != arr.a) {
              aoy.this.ab.sendEmptyMessage(1);
              return;
            }
            localObject = new JSONObject(((arq) localObject).c);
            if (localObject == null) {
              aoy.this.ab.sendEmptyMessage(1);
              return;
            }
          } catch (Exception localException) {
            Log.e(aoy.this.ae, "failed in fetchCloudBlackList.", localException);
            return;
          }
          if (localException.optInt("statusCode") != 200) {
            aoy.this.ab.sendEmptyMessage(1);
            return;
          }
          aoy.this.a(localException);
          aoy.this.ab.sendEmptyMessage(0);
        }
      });
      return;
      P();
    }
  }

  protected void R()
  {
    this.aa.e();
    if (this.ad != null)
      this.ad.setVisibility(8);
    this.ac.notifyDataSetChanged();
    this.ak += 1;
    this.al = false;
    this.am = true;
  }

  protected void S()
  {
    if (!this.am)
      this.aa.d();
    while (true)
    {
      if (this.ad != null)
        this.ad.setVisibility(8);
      this.al = false;
      return;
      this.aa.e();
      aso.a(d(), 2131230940);
    }
  }

  protected AbsListView.OnScrollListener T()
  {
    return new aoz(this, this.ac);
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    this.ad = a(paramView, 2131755265);
    ((ProgressBar)a(paramView, 2131755503)).setIndeterminateDrawable(new avr(d()));
  }

  protected void a(JSONObject paramJSONObject)
  {
    this.ai = paramJSONObject.optInt("totalPage");
    this.aj = paramJSONObject.optInt("psize");
    this.ak = paramJSONObject.optInt("page");
  }

  public void o()
  {
    super.o();
    if (this.ac != null)
      this.ac.a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aoy
 * JD-Core Version:    0.6.2
 */