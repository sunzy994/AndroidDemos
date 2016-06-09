package com.oppo.launcher.toggleBar;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.oppo.launcher.Launcher;
import com.oppo.launcher.R.styleable;
import com.oppo.launcher.Utilities;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

public class ToggleBarContentAdapter extends ToggleBarPreviewAdapter
{
  public ToggleBarContentAdapter(Launcher paramLauncher)
  {
    super(paramLauncher);
    this.mToggleBarPreviewList = loadToggleBarContentPreviews();
  }

  private ArrayList<ToggleBarPreviewItem> loadToggleBarContentPreviews()
  {
    ArrayList localArrayList = new ArrayList();
    parserToggleBarContent(this.mLauncher, localArrayList);
    return localArrayList;
  }

  private void parserToggleBarContent(Launcher paramLauncher, ArrayList<ToggleBarPreviewItem> paramArrayList)
  {
    Resources localResources = paramLauncher.getResources();
    try
    {
      XmlResourceParser localXmlResourceParser = localResources.getXml(2131034120);
      AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
      Utilities.beginDocument(localXmlResourceParser, "items");
      if (this.DEBUG)
        Log.d(this.TAG, "parserToggleBarContent --- depth = " + localXmlResourceParser.getDepth());
      while (true)
      {
        i = localXmlResourceParser.next();
        if (i == 1)
          break;
        if (this.DEBUG)
        {
          Log.d(this.TAG, "parserToggleBarContent ------- parser.getDepth() = " + localXmlResourceParser.getDepth());
          Log.d(this.TAG, "parserToggleBarContent ------- type = " + i);
        }
        Object localObject = localXmlResourceParser.getName();
        if (this.DEBUG)
          Log.d(this.TAG, "parserToggleBarContent ------- name = " + (String)localObject);
        if (i != 2)
          break label298;
        TypedArray localTypedArray = paramLauncher.obtainStyledAttributes(localAttributeSet, R.styleable.TogPreview);
        if ("item".equals(localObject))
        {
          i = localTypedArray.getResourceId(1, -1);
          int j = localTypedArray.getResourceId(7, -1);
          localObject = new ToggleBarContentItem(localResources.getString(i), localResources.getDrawable(j));
          ((ToggleBarContentItem)localObject).setLauncher(this.mLauncher);
          paramArrayList.add(localObject);
        }
        localTypedArray.recycle();
      }
    }
    catch (XmlPullParserException paramLauncher)
    {
      while (true)
      {
        int i;
        Log.w(this.TAG, "Got XmlPullParserException parsing default_allapps favorites.", paramLauncher);
        return;
        if (i != 3);
      }
    }
    catch (IOException paramLauncher)
    {
      label298: Log.w(this.TAG, "Got IOException parsing  default_allapps favorites.", paramLauncher);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.ToggleBarContentAdapter
 * JD-Core Version:    0.6.2
 */