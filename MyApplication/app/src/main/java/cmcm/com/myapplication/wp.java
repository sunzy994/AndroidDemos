package cmcm.com.myapplication;

import android.net.Uri;
import android.text.TextUtils;
import com.lazyswipe.app.LazyProvider;
import java.util.Arrays;
import java.util.List;

public class wp
{
  public String a;
  public String b;
  public String[] c;
  public boolean d;

  public wp(LazyProvider paramLazyProvider, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    List localList = paramUri.getPathSegments();
    this.a = ((String)localList.get(0));
    if ("public_pref".equals(this.a))
      this.b = paramString;
    int i;
    do
    {
      do
      {
        return;
        if ("notification".equals(this.a))
          this.a = ("memory_db." + this.a);
        switch (localList.size())
        {
        default:
          throw new IllegalArgumentException("Invalid uri: " + paramUri);
        case 1:
        case 2:
        }
      }
      while (TextUtils.isEmpty(paramString));
      i = paramString.indexOf("key_suppress_notify");
      if (i < 0)
        break;
      this.d = true;
    }
    while (i == 0);
    this.b = paramString.substring(0, i);
    this.c = paramArrayOfString;
    return;
    this.b = paramString;
    this.c = paramArrayOfString;
    return;
    if (paramString != null)
    {
      if (paramString.equals("key_suppress_notify"))
        this.d = true;
    }
    else
    {
      paramLazyProvider = paramLazyProvider.getType(paramUri);
      i = -1;
      switch (paramLazyProvider.hashCode())
      {
      default:
        switch (i)
        {
        default:
          paramLazyProvider = "_id";
        case 0:
        case 1:
        case 2:
        case 3:
        }
        break;
      case -940777946:
      case -555194656:
      case -640429077:
      case 1639604301:
      }
    }
    while (true)
    {
      this.b = (paramLazyProvider + "=?");
      this.c = new String[] { paramUri.getLastPathSegment() };
      return;
      throw new IllegalArgumentException("Ambiguous query. Uri: " + paramUri + ", where: " + paramString + ", args: " + Arrays.toString(paramArrayOfString));
      if (!paramLazyProvider.equals("vnd.android.cursor.item/com.lazyswipe.banner"))
        break;
      i = 0;
      break;
      if (!paramLazyProvider.equals("vnd.android.cursor.item/com.lazyswipe.op_log"))
        break;
      i = 1;
      break;
      if (!paramLazyProvider.equals("vnd.android.cursor.item/com.lazyswipe.contact_log"))
        break;
      i = 2;
      break;
      if (!paramLazyProvider.equals("vnd.android.cursor.item/com.lazyswipe.news"))
        break;
      i = 3;
      break;
      paramLazyProvider = "code";
      continue;
      paramLazyProvider = "code";
      continue;
      paramLazyProvider = "contact_id";
      continue;
      paramLazyProvider = "dateCreated";
    }
  }

  public static String a(Uri paramUri)
  {
    String str = (String)paramUri.getPathSegments().get(0);
    paramUri = str;
    if ("notification".equals(str))
      paramUri = "memory_db." + str;
    return paramUri;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wp
 * JD-Core Version:    0.6.2
 */