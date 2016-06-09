package cmcm.com.myapplication;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class anv
{
  private final String a;
  private final CharSequence b;
  private final Drawable c;

  public anv(String paramString, int paramInt1, int paramInt2, Resources paramResources)
  {
    this(paramString, paramResources.getText(paramInt1), paramResources.getDrawable(paramInt2));
  }

  public anv(String paramString, CharSequence paramCharSequence, int paramInt, Resources paramResources)
  {
    this(paramString, paramCharSequence, paramResources.getDrawable(paramInt));
  }

  public anv(String paramString, CharSequence paramCharSequence, Drawable paramDrawable)
  {
    this.a = paramString;
    this.c = paramDrawable;
    this.b = paramCharSequence;
  }

  public String a()
  {
    return this.a;
  }

  public CharSequence b()
  {
    return this.b;
  }

  public Drawable c()
  {
    return this.c;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anv
 * JD-Core Version:    0.6.2
 */