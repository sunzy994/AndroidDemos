package cmcm.com.myapplication.com.lazyswipe.preference.content;

import amg;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsProvider extends ContentProvider
{
  static final String a = "Swipe." + SettingsProvider.class.getSimpleName();
  private static final UriMatcher b = new UriMatcher(-1);
  private Map<String, HashMap<String, String>> c;

  static
  {
    b.addURI("com.lazyswipe_settings", "preferences/*", 1);
    b.addURI("com.lazyswipe_settings", "variables/*", 2);
  }

  private Cursor a(Uri paramUri)
  {
    paramUri = paramUri.getPathSegments();
    int i = paramUri.size();
    String str1 = (String)paramUri.get(1);
    if (2 < i)
    {
      Log.d(a, "Getting single preference is not supported at this time");
      return new MatrixCursor(amg.b, 0);
    }
    MatrixCursor localMatrixCursor;
    while (true)
    {
      try
      {
        paramUri = getContext().getSharedPreferences(str1, 0).getAll();
        localMatrixCursor = new MatrixCursor(amg.b, paramUri.size());
        Iterator localIterator = paramUri.entrySet().iterator();
        if (!localIterator.hasNext())
          break label215;
        paramUri = (Entry)localIterator.next();
        String str2 = (String)paramUri.getKey();
        paramUri = paramUri.getValue();
        if (paramUri == null)
          continue;
        if (!(paramUri instanceof Set))
          break label207;
        paramUri = TextUtils.join(",", (Set)paramUri);
        localMatrixCursor.addRow(new Object[] { str2, paramUri });
        continue;
      }
      catch (Throwable paramUri)
      {
        Log.w(a, "Could not load shared preferences " + str1, paramUri);
      }
      break;
      label207: paramUri = paramUri.toString();
    }
    label215: return localMatrixCursor;
  }

  private void a(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject1 = paramUri.getPathSegments();
    if (((List)localObject1).size() != 2)
      throw new IllegalArgumentException("Invalid uri: " + paramUri);
    String str1 = (String)((List)localObject1).get(1);
    HashSet localHashSet = new HashSet();
    try
    {
      localObject1 = getContext().getSharedPreferences(str1, 0).edit();
      try
      {
        Iterator localIterator = paramContentValues.keySet().iterator();
        while (true)
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext())
            break;
          localObject2 = (String)localIterator.next();
          str2 = paramContentValues.getAsString((String)localObject2);
          if (str2 != null)
            break label246;
          ((Editor)localObject1).remove((String)localObject2);
          localHashSet.add(paramUri.buildUpon().appendPath((String)localObject2).build());
        }
      }
      catch (Throwable paramUri)
      {
        String str2;
        Log.w(a, "Could not save shared preferences " + str1, paramUri);
        Object localObject2 = localObject1;
        if (localObject2 != null)
          ((Editor)localObject2).apply();
        paramUri = localHashSet.iterator();
        while (paramUri.hasNext())
        {
          paramContentValues = (Uri)paramUri.next();
          getContext().getContentResolver().notifyChange(paramContentValues, null);
          continue;
          label246: int i = str2.length() - 1;
          String str3 = str2.substring(0, i);
          switch (Character.digit(str2.charAt(i), 10))
          {
          case 0:
            ((Editor)localObject1).putString((String)localObject2, str3);
          case 1:
          case 3:
          case 2:
          case 4:
          case 5:
            while (true)
            {
              localHashSet.add(paramUri.buildUpon().appendPath((String)localObject2).appendPath(str3).build());
              break;
              ((Editor)localObject1).putBoolean((String)localObject2, Boolean.parseBoolean(str3));
              continue;
              ((Editor)localObject1).putLong((String)localObject2, Long.parseLong(str3));
              continue;
              ((Editor)localObject1).putInt((String)localObject2, Integer.parseInt(str3));
              continue;
              ((Editor)localObject1).putFloat((String)localObject2, Float.parseFloat(str3));
              continue;
              ((Editor)localObject1).putStringSet((String)localObject2, new HashSet(Arrays.asList(TextUtils.split(str3, ","))));
            }
          }
        }
        return;
      }
    }
    catch (Throwable paramUri)
    {
      while (true)
        localObject1 = null;
    }
  }

  private Cursor b(Uri paramUri)
  {
    if (this.c == null)
      return new MatrixCursor(amg.b, 0);
    paramUri = paramUri.getPathSegments();
    int i = paramUri.size();
    paramUri = (String)paramUri.get(1);
    if (2 < i)
      Log.d(a, "Getting single variable is not supported at this time");
    do
    {
      return new MatrixCursor(amg.b, 0);
      localObject1 = (Map)this.c.get(paramUri);
    }
    while ((localObject1 == null) || (((Map)localObject1).size() <= 0));
    paramUri = new MatrixCursor(amg.b, ((Map)localObject1).size());
    Object localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Entry)((Iterator)localObject1).next();
      String str = (String)((Entry)localObject2).getKey();
      localObject2 = (String)((Entry)localObject2).getValue();
      if (localObject2 != null)
        paramUri.addRow(new Object[] { str, localObject2 });
    }
    return paramUri;
  }

  private void b(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject1 = paramUri.getPathSegments();
    if (((List)localObject1).size() != 2)
      throw new IllegalArgumentException("Invalid uri: " + paramUri);
    String str1 = (String)((List)localObject1).get(1);
    if (this.c == null)
      this.c = new HashMap(1);
    Object localObject2 = (HashMap)this.c.get(str1);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap(paramContentValues.size());
      this.c.put(str1, localObject1);
    }
    localObject2 = paramContentValues.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str1 = (String)((Iterator)localObject2).next();
      String str2 = paramContentValues.getAsString(str1);
      ((HashMap)localObject1).put(str1, str2);
      try
      {
        getContext().getContentResolver().notifyChange(paramUri.buildUpon().appendPath(str1).appendPath(str2).build(), null);
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  private int c(Uri paramUri)
  {
    Object localObject = paramUri.getPathSegments();
    if (((List)localObject).size() != 2)
      throw new IllegalArgumentException("Invalid uri: " + paramUri);
    localObject = (String)((List)localObject).get(1);
    try
    {
      getContext().getSharedPreferences((String)localObject, 0).edit().clear().apply();
      getContext().getContentResolver().notifyChange(paramUri, null);
      return 1;
    }
    catch (Throwable paramUri)
    {
    }
    return 0;
  }

  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
  {
    throw new UnsupportedOperationException();
  }

  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    throw new UnsupportedOperationException();
  }

  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int j = 1;
    paramString = getType(paramUri);
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -362979476:
    case 312838891:
    }
    while (true)
      switch (i)
      {
      default:
        j = 0;
      case 1:
        return j;
        if (paramString.equals("vnd.android.cursor.dir/com.lazyswipe_settings.preferences"))
        {
          i = 0;
          continue;
          if (paramString.equals("vnd.android.cursor.dir/com.lazyswipe_settings.variables"))
            i = 1;
        }
        break;
      case 0:
      }
    return c(paramUri);
  }

  public String getType(Uri paramUri)
  {
    switch (b.match(paramUri))
    {
    default:
      return "";
    case 1:
      return "vnd.android.cursor.dir/com.lazyswipe_settings.preferences";
    case 2:
    }
    return "vnd.android.cursor.dir/com.lazyswipe_settings.variables";
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    String str = getType(paramUri);
    int i = -1;
    switch (str.hashCode())
    {
    default:
      switch (i)
      {
      default:
      case 0:
      case 1:
      }
      break;
    case -362979476:
    case 312838891:
    }
    while (true)
    {
      return null;
      if (!str.equals("vnd.android.cursor.dir/com.lazyswipe_settings.preferences"))
        break;
      i = 0;
      break;
      if (!str.equals("vnd.android.cursor.dir/com.lazyswipe_settings.variables"))
        break;
      i = 1;
      break;
      a(paramUri, paramContentValues);
      continue;
      b(paramUri, paramContentValues);
    }
  }

  public boolean onCreate()
  {
    return true;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramArrayOfString1 = getType(paramUri);
    int i = -1;
    switch (paramArrayOfString1.hashCode())
    {
    default:
    case -362979476:
    case 312838891:
    }
    while (true)
      switch (i)
      {
      default:
        return new MatrixCursor(amg.b, 0);
        if (paramArrayOfString1.equals("vnd.android.cursor.dir/com.lazyswipe_settings.preferences"))
        {
          i = 0;
          continue;
          if (paramArrayOfString1.equals("vnd.android.cursor.dir/com.lazyswipe_settings.variables"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    return a(paramUri);
    return b(paramUri);
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.preference.content.SettingsProvider
 * JD-Core Version:    0.6.2
 */