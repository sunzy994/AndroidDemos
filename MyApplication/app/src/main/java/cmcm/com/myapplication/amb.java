package cmcm.com.myapplication;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.util.List;

public class amb extends amj
{
  private static final String l = "Swipe." + amb.class.getSimpleName();

  amb(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }

  protected void a()
  {
    this.j = amh.c.buildUpon().appendPath(this.f).build();
    i();
  }

  void a(List<String> paramList, int paramInt)
  {
    ame localame = (ame)edit();
    if (2 == paramInt)
      localame.clear();
    if (3 == paramInt)
      localame.remove((String)paramList.get(2));
    while (true)
    {
      localame.a(true);
      return;
      if (4 == paramInt)
        localame.putString((String)paramList.get(2), (String)paramList.get(3));
      else
        asp.b(l, "Unrecognized url: " + TextUtils.join("/", paramList));
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amb
 * JD-Core Version:    0.6.2
 */