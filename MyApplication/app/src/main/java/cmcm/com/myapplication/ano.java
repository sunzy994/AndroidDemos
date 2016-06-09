package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;

public abstract class ano extends ans
{
  public ano(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  public Intent b(Context paramContext)
  {
    Intent localIntent = new Intent("android.settings.SOUND_SETTINGS");
    if (asq.a(paramContext, localIntent));
    do
    {
      do
      {
        return localIntent;
        localIntent.setClassName("com.android.settings", "com.android.settings.audioprofile.AudioProfileSettings");
      }
      while (asq.a(paramContext, localIntent));
      localIntent.setClassName("com.android.settings", "com.android.settings.profile.ProfileSettings");
    }
    while (asq.a(paramContext, localIntent));
    localIntent.setClassName("com.android.settings", "com.android.settings.audioprofile.SoundSettings");
    return localIntent;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ano
 * JD-Core Version:    0.6.2
 */