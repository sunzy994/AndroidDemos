package com.oppo.launcher.effect;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.oppo.launcher.R.styleable;
import com.oppo.launcher.Utilities;
import com.oppo.launcher.settings.FeatureOption;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

public class LauncherEffect
{
  private static final boolean DEBUG = false;
  private static final String TAG = "LauncherEffect";
  private static final String TAG_EFFECT = "effect";
  private static final String TAG_EFFECTS = "effcets";
  private static LauncherEffect mLauncherEffect;
  private Context mContext;
  private List<EffectInfo> mWorkSpaceEffects = new ArrayList();

  private LauncherEffect(Context paramContext)
  {
    this.mContext = paramContext;
    if (FeatureOption.LAUNCHER_SPECIAL_EFFECT)
    {
      parserEffects(2131034122, this.mWorkSpaceEffects);
      return;
    }
    parserEffects(2131034121, this.mWorkSpaceEffects);
  }

  public static void clear()
  {
    mLauncherEffect = null;
  }

  public static LauncherEffect getLauncherEffect(Context paramContext)
  {
    if (mLauncherEffect == null)
      mLauncherEffect = new LauncherEffect(paramContext);
    return mLauncherEffect;
  }

  private void parserEffects(int paramInt, List<EffectInfo> paramList)
  {
    try
    {
      XmlResourceParser localXmlResourceParser = this.mContext.getResources().getXml(paramInt);
      AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
      Utilities.beginDocument(localXmlResourceParser, "effcets");
      while (true)
      {
        paramInt = localXmlResourceParser.next();
        if (paramInt == 1)
          break;
        String str = localXmlResourceParser.getName();
        if (paramInt != 2)
          break label157;
        TypedArray localTypedArray = this.mContext.obtainStyledAttributes(localAttributeSet, R.styleable.TogPreview);
        if ("effect".equals(str))
          paramList.add(new EffectInfo(localTypedArray.getResourceId(1, -1), localTypedArray.getResourceId(2, -1), localTypedArray.getResourceId(3, -1), localTypedArray.getResourceId(4, -1), localTypedArray.getResourceId(5, -1), localTypedArray.getResourceId(6, -1), localTypedArray.getResourceId(7, -1)));
        localTypedArray.recycle();
      }
    }
    catch (XmlPullParserException paramList)
    {
      while (true)
      {
        Log.w("LauncherEffect", "Got XmlPullParserException parsing default_allapps favorites.", paramList);
        return;
        if (paramInt != 3);
      }
    }
    catch (IOException paramList)
    {
      label157: Log.w("LauncherEffect", "Got IOException parsing  default_allapps favorites.", paramList);
    }
  }

  public List<EffectInfo> getWorkspaceEffects()
  {
    return this.mWorkSpaceEffects;
  }

  public boolean isEffectAvailable(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.mWorkSpaceEffects != null)
    {
      bool1 = bool2;
      if (paramString != null)
        i = 0;
    }
    while (true)
    {
      bool1 = bool2;
      if (i < this.mWorkSpaceEffects.size())
      {
        if (paramString.equals(((EffectInfo)this.mWorkSpaceEffects.get(i)).getClassName(this.mContext)))
          bool1 = true;
      }
      else
        return bool1;
      i += 1;
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.effect.LauncherEffect
 * JD-Core Version:    0.6.2
 */