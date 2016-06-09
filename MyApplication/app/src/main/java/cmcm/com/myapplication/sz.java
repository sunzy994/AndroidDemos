package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import com.hola.channel.pub.RuntimeActivity;
import java.io.File;

public class sz
{
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    String str1 = oy.b(paramContext, "libcantkrt.so").getAbsolutePath();
    String str2 = oy.b(paramContext, "logo").getAbsolutePath();
    a(paramContext, paramString1, paramInt1, paramInt2, paramString2, str1, oy.b(paramContext, "js").getAbsolutePath(), str2, paramString3);
  }

  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    qq.a("acc", String.valueOf(paramInt1));
    qq.a("land", String.valueOf(paramInt2));
    qq.a("key", paramString1);
    qq.a("sopath", paramString3);
    qq.a("gamepath", paramString2);
    qq.a("index", paramString6);
    qq.a("assetspath", paramString4);
    qq.a("gameLogoPath", paramString5);
    Intent localIntent = new Intent(paramContext, RuntimeActivity.class);
    localIntent.putExtra("game_acc", paramInt1);
    localIntent.putExtra("game_land", paramInt2);
    localIntent.putExtra("game_key", paramString1);
    localIntent.putExtra("game_sopath", paramString3);
    localIntent.putExtra("game_path", paramString2);
    localIntent.putExtra("game_init", paramString6);
    localIntent.putExtra("game_assets", paramString4);
    localIntent.putExtra("_game_path", paramString5);
    paramContext.startActivity(localIntent);
  }

  public static void a(Context paramContext, pe parampe)
  {
    if (parampe != null)
      a(paramContext, parampe.d, parampe.g, parampe.h, parampe.n, parampe.i);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sz
 * JD-Core Version:    0.6.2
 */