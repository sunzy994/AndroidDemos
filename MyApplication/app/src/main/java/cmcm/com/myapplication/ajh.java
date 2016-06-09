package cmcm.com.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.lazyswipe.features.theme.preview.OnlineThemeDetailActivity;
import com.lazyswipe.features.theme.preview.OnlineThemeEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajh extends aoy
{
  private GridView ai;
  private List<OnlineThemeEntity> aj = new ArrayList();
  private aji ak = new aji()
  {
    protected void a(Context paramAnonymousContext)
    {
      ajh.b(ajh.this).notifyDataSetChanged();
    }
  };

  protected int J()
  {
    return 2130968645;
  }

  protected boolean K()
  {
    return false;
  }

  protected Map<String, String> N()
  {
    Map localMap = super.N();
    localMap.put("cw", aqs.ae() * 0.5F + "");
    return localMap;
  }

  protected String O()
  {
    return "themes";
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    this.ai = ((GridView)a(paramView, 2131755046));
    this.ac = new ajg(d());
    this.ac.a(this.aj);
    this.ai.setOnScrollListener(T());
    this.ai.setAdapter(this.ac);
    this.ai.setOnItemClickListener(new OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = (OnlineThemeEntity)ajh.a(ajh.this).a(paramAnonymousInt);
        OnlineThemeDetailActivity.a(ajh.this.d(), paramAnonymousAdapterView);
      }
    });
  }

  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("results");
    if (localJSONArray != null)
    {
      int j = localJSONArray.length();
      int i = 0;
      while (i < j)
      {
        OnlineThemeEntity localOnlineThemeEntity = new OnlineThemeEntity(localJSONArray.optJSONObject(i));
        this.aj.add(localOnlineThemeEntity);
        i += 1;
      }
    }
    Log.i(this.ae, "parseData " + paramJSONObject);
  }

  public void c(Bundle paramBundle)
  {
    super.c(paramBundle);
    this.ak.c(d());
  }

  public void o()
  {
    super.o();
    this.ak.d(d());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajh
 * JD-Core Version:    0.6.2
 */