package cmcm.com.myapplication;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aee
{
  private static final Pattern i = Pattern.compile("(^.*\\?imageMogr2.*/)(\\d+)(x)(\\d+)(!$)");
  private static final float j = adp.b;
  public CharSequence a;
  public String b;
  public String c;
  public int d = adp.b;
  public int e = adp.c;
  public long f;
  public String g;
  public boolean h;

  public static aee a(Cursor paramCursor)
  {
    boolean bool = true;
    aee localaee = new aee();
    localaee.g = paramCursor.getString(4);
    localaee.b = localaee.a(paramCursor.getString(2));
    localaee.c = paramCursor.getString(3);
    localaee.a = paramCursor.getString(1);
    localaee.f = paramCursor.getLong(0);
    if (paramCursor.getInt(5) == 1);
    while (true)
    {
      localaee.h = bool;
      return localaee;
      bool = false;
    }
  }

  private String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
      str = null;
    Matcher localMatcher;
    do
    {
      do
      {
        return str;
        localMatcher = i.matcher(paramString);
        str = paramString;
      }
      while (!localMatcher.find());
      k = asi.a(localMatcher.group(2), 0);
      m = asi.a(localMatcher.group(4), 0);
      str = paramString;
    }
    while (j >= k);
    int k = (int)(m * j / k);
    int m = (int)j;
    this.d = m;
    this.e = k;
    return localMatcher.replaceFirst("$1" + m + "$3" + k + "$5");
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      paramObject = (aee)paramObject;
    }
    while ((asq.a(this.c, paramObject.c)) && (asq.a(this.a, paramObject.a)));
    return false;
  }

  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.a, this.c });
  }

  public String toString()
  {
    return "News: " + this.a + " from " + this.g + "; read=" + this.h;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aee
 * JD-Core Version:    0.6.2
 */