package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.lazyswipe.features.search.SearchPopupView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class agv extends agj<agw>
  implements OnClickListener
{
  private final atq g;
  private final List<agw> h = new ArrayList();
  private final Handler i = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage.obj instanceof atv))
      {
        paramAnonymousMessage = (atv)paramAnonymousMessage.obj;
        ((ImageView)paramAnonymousMessage.f()).setImageBitmap(paramAnonymousMessage.e);
      }
    }
  };

  public agv(Context paramContext, String paramString, atq paramatq)
  {
    super(paramContext, paramString);
    this.g = paramatq;
  }

  private View b(Context paramContext)
  {
    paramContext = LayoutInflater.from(getContext()).inflate(2130968734, this, false);
    int j = asq.a(0.0F);
    LayoutParams localLayoutParams = (LayoutParams)paramContext.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.setMargins(j, j, j, j);
    localLayoutParams.weight = 1.0F;
    return paramContext;
  }

  private List<agw> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.optInt("statusCode", -1) != 200)
        return localArrayList;
      paramString = (JSONArray)paramString.opt("results");
      int j = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = (JSONObject)paramString.get(j);
        agw localagw = new agw();
        agw.a(localagw, localJSONObject.optString("icon"));
        agw.b(localagw, localJSONObject.optString("name"));
        agw.c(localagw, localJSONObject.optString("url"));
        if (localArrayList.size() < getLineItemCount() * getInitPageSize())
          localArrayList.add(localagw);
        j += 1;
      }
    }
    catch (JSONException paramString)
    {
    }
    return localArrayList;
  }

  private void g()
  {
    if (!arl.i(getContext()));
    while (true)
    {
      return;
      boolean bool = arl.g(getContext());
      vs.h(getContext(), "pref_hotsite_timestamp");
      vs.h(getContext(), "pref_hotsite_data");
      long l2 = System.currentTimeMillis();
      long l3 = vs.a(getContext(), "pref_hotsite_timestamp2", 0L);
      if (l3 < l2)
        if (!bool)
          break label216;
      label216: for (long l1 = 86400000L; l2 - l3 > l1; l1 = 259200000L)
      {
        vs.b(getContext(), "pref_hotsite_timestamp2", l2);
        StringBuilder localStringBuilder = new StringBuilder("http://a.holaworld.cn/site/popular?");
        localStringBuilder.append("lang=").append(asq.j());
        localStringBuilder.append("&pid=").append("300105");
        localStringBuilder.append("&cid=").append("26100");
        localStringBuilder.append("&vid=").append("00");
        localStringBuilder.append("&vn=").append("2.25");
        localStringBuilder.append("&vc=").append(22500);
        localStringBuilder.append("&apiVer=").append(3);
        new arb(getContext()).a(localStringBuilder.toString(), null, new arc()
        {
          public void a(int paramAnonymousInt, String paramAnonymousString)
          {
            if (paramAnonymousInt == 200)
            {
              List localList = agv.a(agv.this, paramAnonymousString);
              if ((localList != null) && (localList.size() > 0))
                vs.b(agv.this.getContext(), "pref_hotsite_data2", paramAnonymousString);
            }
          }

          public void a(Throwable paramAnonymousThrowable)
          {
          }
        });
        return;
      }
    }
  }

  protected View a(int paramInt)
  {
    if (getTotalItemCount() <= paramInt)
      return null;
    int j = getLineItemCount() * paramInt;
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(17);
    paramInt = j;
    if ((paramInt < getLineItemCount() + j) && (paramInt < this.b.size()))
    {
      Object localObject = (agw)this.b.get(paramInt);
      View localView = b(getContext());
      localView.setTag(localObject);
      localView.setOnClickListener(this);
      localLinearLayout.addView(localView);
      ((TextView)localView.findViewById(2131755079)).setText(agw.a((agw) localObject));
      ImageView localImageView = (ImageView)localView.findViewById(2131755064);
      if (TextUtils.isEmpty(agw.b((agw) localObject)))
        localImageView.setImageResource(2130837788);
      while (true)
      {
        paramInt += 1;
        break;
        localObject = new atv(localView.findViewById(2131755064), agw.b((agw) localObject), this.i, 1, ahe.a);
        localObject = (atv)this.g.c((atr)localObject);
        if (localObject != null)
          localImageView.setImageBitmap(((atv)localObject).e);
        else
          localImageView.setImageResource(2130837788);
      }
    }
    paramInt = localLinearLayout.getChildCount();
    if (paramInt < getLineItemCount())
      while (paramInt < getLineItemCount())
      {
        localLinearLayout.addView(b(getContext()));
        paramInt += 1;
      }
    paramInt = this.f / 4;
    localLinearLayout.setLayoutParams(new LayoutParams(-1, asq.a(89.0F)));
    localLinearLayout.setPadding(paramInt, 0, paramInt, 0);
    return localLinearLayout;
  }

  protected List<agw> a(String paramString, agk paramagk)
  {
    paramString = new ArrayList();
    g();
    paramagk = vs.a(getContext(), "pref_hotsite_data2", "");
    if (TextUtils.isEmpty(paramagk))
      return paramString;
    paramString = b(paramagk);
    this.h.clear();
    this.h.addAll(paramString);
    return paramString;
  }

  protected boolean c()
  {
    return false;
  }

  protected boolean e()
  {
    return false;
  }

  protected View getContentBottomEdgeView()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setLayoutParams(new LayoutParams(-1, asq.a(10.0F)));
    return localLinearLayout;
  }

  protected int getInitPageSize()
  {
    return 2;
  }

  protected int getLineItemCount()
  {
    return 5;
  }

  protected int getNextPageSize()
  {
    return 2;
  }

  protected int getTotalItemCount()
  {
    int j = 0;
    if ((this.b == null) || (this.b.size() == 0))
      return 0;
    if (this.b.size() / getLineItemCount() >= 3)
      return 3;
    int k = this.b.size() / getLineItemCount();
    if (this.b.size() % getLineItemCount() == 0);
    while (true)
    {
      return j + k;
      j = 1;
    }
  }

  public void onClick(View paramView)
  {
    paramView = (agw)paramView.getTag();
    if (paramView == null);
    while (this.a == null)
      return;
    this.a.a(agw.c(paramView));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agv
 * JD-Core Version:    0.6.2
 */