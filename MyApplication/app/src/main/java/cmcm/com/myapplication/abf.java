package cmcm.com.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.lazyswipe.features.leap.card.ThemeCard;
import com.lazyswipe.features.leap.slot.SlotMachine;
import com.lazyswipe.preference.MyPreference;
import java.util.Calendar;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class abf
{
  private static final String a = "Swipe." + abf.class.getSimpleName();

  private static int a(String paramString, int paramInt)
  {
    try
    {
      paramInt = Integer.parseInt(paramString.substring(0, paramInt));
      return paramInt;
    }
    catch (Throwable paramString)
    {
    }
    return 0;
  }

  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "key_ad_can_show_for_" + paramInt;
    case 5:
      return "key_lucky_app_click";
    case 2:
      return "key_notify_app_click";
    case 3:
      return "key_boost_ad_click";
    case 6:
      return "key_boost_plus_ad_click";
    case 4:
    }
    return "key_float_cleaner_ad_click";
  }

  public static String a(Context paramContext, String paramString, int paramInt)
  {
    String str1 = paramString;
    if (paramString.indexOf("[random_uuid]") > 0)
      str1 = paramString.replace("[random_uuid]", UUID.randomUUID().toString());
    String str2 = str1;
    if (str1.indexOf("[androidid_md5]") > 0)
    {
      paramString = aqs.l(paramContext);
      if (TextUtils.isEmpty(paramString))
      {
        paramString = "";
        str2 = str1.replace("[androidid_md5]", paramString);
      }
    }
    else
    {
      paramString = str2;
      if (str2.indexOf("[androidid]") > 0)
      {
        str1 = aqs.l(paramContext);
        paramString = str1;
        if (TextUtils.isEmpty(str1))
          paramString = "";
        paramString = str2.replace("[androidid]", paramString);
      }
      str1 = paramString;
      if (paramString.indexOf("[gaid_md5]") > 0)
      {
        str1 = kv.a().t();
        if (!TextUtils.isEmpty(str1))
          break label303;
        str1 = "";
        label127: str1 = paramString.replace("[gaid_md5]", str1);
      }
      paramString = str1;
      if (str1.indexOf("[gaid]") > 0)
      {
        str2 = kv.a().t();
        paramString = str2;
        if (TextUtils.isEmpty(str2))
          paramString = "";
        paramString = str1.replace("[gaid]", paramString);
      }
      str1 = paramString;
      if (paramString.indexOf("[imei_md5]") > 0)
      {
        str1 = asl.b(paramContext);
        if (!TextUtils.isEmpty(str1))
          break label311;
        str1 = "";
        label202: str1 = paramString.replace("[imei_md5]", str1);
      }
      paramString = str1;
      if (str1.indexOf("[imei]") > 0)
      {
        paramString = asl.b(paramContext);
        paramContext = paramString;
        if (TextUtils.isEmpty(paramString))
          paramContext = "";
        paramString = str1.replace("[imei]", paramContext);
      }
      if (paramString.indexOf("[app]") <= 0)
        break label319;
    }
    label303: label311: label319: for (paramContext = paramString.replace("[app]", "300105"); ; paramContext = paramString)
    {
      paramString = paramContext;
      if (paramInt >= 0)
      {
        paramString = paramContext;
        if (paramContext.indexOf("[placement]") > 0)
          paramString = paramContext.replace("[placement]", abd.d[paramInt]);
      }
      return paramString;
      paramString = arh.a(paramString);
      break;
      str1 = arh.a(str1);
      break label127;
      str1 = arh.a(str1);
      break label202;
    }
  }

  public static void a(Context paramContext)
  {
    adv.a().a(paramContext);
    adi.a(paramContext).a();
  }

  public static void a(Context paramContext, int paramInt)
  {
    paramContext = vs.a(paramContext);
    String str1 = a(paramInt);
    String str2 = paramContext.getString(str1, null);
    int i;
    if (TextUtils.isEmpty(str2))
      i = 0;
    while (true)
    {
      long l = System.currentTimeMillis();
      paramContext.edit().putString(str1, String.valueOf(i + 1) + "-" + String.valueOf(l)).putInt("key_accumulated_count_" + paramInt, 0).apply();
      return;
      i = str2.indexOf('-');
      if (i < 1)
        i = 0;
      else
        i = a(str2, i);
    }
  }

  public static void a(Context paramContext, MyPreference paramMyPreference)
  {
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    while (true)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        int k = paramString.length();
        if (k > 0)
        {
          long l = System.currentTimeMillis();
          ContentValues localContentValues = new ContentValues(aed.a.length);
          i = 0;
          if (i < k)
          {
            JSONObject localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null)
              break label146;
            String[] arrayOfString = aed.a;
            int m = arrayOfString.length;
            int j = 0;
            if (j < m)
            {
              String str = arrayOfString[j];
              localContentValues.put(str, localJSONObject.optString(str));
              j += 1;
              continue;
            }
            if (localContentValues.getAsLong("dateCreated").longValue() - l > 86400000L)
              break label146;
            paramSQLiteDatabase.insert("news", null, localContentValues);
            localContentValues.clear();
          }
        }
      }
      catch (Throwable paramSQLiteDatabase)
      {
      }
      return;
      label146: i += 1;
    }
  }

  public static boolean a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (!arl.i(paramContext));
    label297: 
    while (true)
    {
      return false;
      if ((abd.l) && (abd.a()) && ((!paramBoolean) || (abd.a(paramInt))))
      {
        paramContext = vs.a(paramContext);
        long l;
        if (2 == paramInt)
          l = aay.b();
        while (true)
        {
          if ((l > 0L) && (!a(paramContext, l)))
            break label297;
          String str = a(paramInt);
          Object localObject = paramContext.getString(str, null);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            return true;
            if (13 == paramInt)
              l = aax.a();
          }
          else
          {
            int i = ((String)localObject).indexOf('-');
            if (i < 1)
              return true;
            int j = a((String)localObject, i);
            l = b((String)localObject, i + 1);
            if (!abd.b(paramInt, j))
            {
              localObject = Calendar.getInstance();
              paramInt = ((Calendar)localObject).get(6);
              ((Calendar)localObject).setTimeInMillis(l);
              if (paramInt == ((Calendar)localObject).get(6))
                break;
              paramContext.edit().remove(str).apply();
              return true;
            }
            if ((14 == paramInt) || (!abd.a(paramInt, l)))
            {
              i = paramContext.getInt("key_accumulated_count_" + paramInt, 0) + 1;
              if (!abd.c(paramInt, i))
              {
                paramContext.edit().putInt("key_accumulated_count_" + paramInt, i).apply();
                return false;
              }
            }
            return true;
            l = 0L;
          }
        }
      }
    }
  }

  public static boolean a(Context paramContext, long paramLong)
  {
    return a(vs.a(paramContext), paramLong);
  }

  public static boolean a(SharedPreferences paramSharedPreferences, long paramLong)
  {
    return System.currentTimeMillis() - paramSharedPreferences.getLong("key_first_install_time", 0L) > paramLong;
  }

  private static long b(String paramString, int paramInt)
  {
    try
    {
      long l = Long.parseLong(paramString.substring(paramInt));
      return l;
    }
    catch (Throwable paramString)
    {
    }
    return 0L;
  }

  public static void b(Context paramContext)
  {
    adi.a(paramContext).b();
    ThemeCard.i();
  }

  public static int c(Context paramContext)
  {
    return SlotMachine.a(paramContext);
  }

  public static void d(Context paramContext)
  {
    afd.a(paramContext, 120000L);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abf
 * JD-Core Version:    0.6.2
 */