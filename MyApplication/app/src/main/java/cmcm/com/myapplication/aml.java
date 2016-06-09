package cmcm.com.myapplication;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.util.List;

public class aml extends amj
{
  private static final String l = "Swipe." + aml.class.getSimpleName();

  aml(Context paramContext)
  {
    this(paramContext, "global");
  }

  aml(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }

  protected void a()
  {
    this.j = ami.c.buildUpon().appendPath(this.f).build();
    i();
  }

  void a(List<String> paramList, int paramInt)
  {
    if (paramInt <= 3)
      return;
    if (paramInt == 4)
    {
      ame localame = (ame)edit();
      localame.putString((String)paramList.get(2), (String)paramList.get(3));
      localame.a(true);
      return;
    }
    asp.b(l, "Unrecognized url: " + TextUtils.join("/", paramList));
  }

  boolean b()
  {
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aml
 * JD-Core Version:    0.6.2
 */