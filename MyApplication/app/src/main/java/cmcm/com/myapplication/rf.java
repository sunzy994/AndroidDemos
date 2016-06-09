package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class rf extends AsyncTask<Void, Void, Boolean>
{
  public static volatile boolean a;
  private static final String b = "GameSDK." + rf.class.getSimpleName();
  private final Context c;

  public rf(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    a = true;
  }

  // ERROR //
  private boolean a(rn paramrn)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 57	java/lang/System:currentTimeMillis	()J
    //   5: aload_0
    //   6: getfield 46	rf:c	Landroid/content/Context;
    //   9: invokestatic 62	qy:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   12: ldc 64
    //   14: lconst_0
    //   15: invokeinterface 70 4 0
    //   20: lsub
    //   21: ldc2_w 71
    //   24: lcmp
    //   25: ifle +5 -> 30
    //   28: iconst_1
    //   29: ireturn
    //   30: invokestatic 57	java/lang/System:currentTimeMillis	()J
    //   33: lstore 5
    //   35: aload_1
    //   36: ldc 74
    //   38: iconst_1
    //   39: anewarray 76	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc 78
    //   46: aastore
    //   47: ldc 80
    //   49: iconst_1
    //   50: anewarray 76	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: lload 5
    //   57: invokestatic 84	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   60: aastore
    //   61: aconst_null
    //   62: invokevirtual 89	rn:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore_1
    //   66: aload_1
    //   67: astore_2
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: invokeinterface 95 1 0
    //   76: ifeq +25 -> 101
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: iconst_0
    //   83: invokeinterface 99 2 0
    //   88: istore 4
    //   90: iload 4
    //   92: ifgt +9 -> 101
    //   95: aload_2
    //   96: invokestatic 104	qp:a	(Landroid/database/Cursor;)V
    //   99: iconst_1
    //   100: ireturn
    //   101: aload_2
    //   102: invokestatic 104	qp:a	(Landroid/database/Cursor;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: getstatic 35	rf:b	Ljava/lang/String;
    //   115: ldc 106
    //   117: aload_3
    //   118: invokestatic 112	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   121: pop
    //   122: aload_2
    //   123: invokestatic 104	qp:a	(Landroid/database/Cursor;)V
    //   126: goto -21 -> 105
    //   129: astore_1
    //   130: aload_2
    //   131: invokestatic 104	qp:a	(Landroid/database/Cursor;)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_3
    //   137: aload_1
    //   138: astore_2
    //   139: aload_3
    //   140: astore_1
    //   141: goto -11 -> 130
    //   144: astore_3
    //   145: goto -35 -> 110
    //
    // Exception table:
    //   from	to	target	type
    //   30	66	107	java/lang/Throwable
    //   30	66	129	finally
    //   70	79	136	finally
    //   81	90	136	finally
    //   112	122	136	finally
    //   70	79	144	java/lang/Throwable
    //   81	90	144	java/lang/Throwable
  }

  protected Boolean a(Void[] paramArrayOfVoid)
  {
    paramArrayOfVoid = rn.a(this.c);
    if (!a(paramArrayOfVoid))
      return Boolean.valueOf(false);
    try
    {
      JSONArray localJSONArray = new JSONObject(qz.a()).getJSONArray("subjects");
      int j = localJSONArray.length();
      ContentValues localContentValues = new ContentValues(6);
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        int k = localJSONObject.optInt("id");
        rc.a(this.c, 3, k, 1, 20, true);
        localContentValues.put("code", Integer.valueOf(k));
        localContentValues.put("name", localJSONObject.optString("subjectName"));
        localContentValues.put("intro", localJSONObject.optString("introduce"));
        localContentValues.put("icon", localJSONObject.optString("iconUrl"));
        localContentValues.put("banner", localJSONObject.optString("bannerUrl"));
        localContentValues.put("expire", Long.valueOf(localJSONObject.optLong("expired")));
        paramArrayOfVoid.a("subject", localContentValues);
        localContentValues.clear();
        i += 1;
      }
      qy.a(this.c).edit().putLong("key_subject_updated", System.currentTimeMillis()).apply();
      this.c.getContentResolver().notifyChange(rn.a("game_list/subject"), null);
      return Boolean.valueOf(true);
    }
    catch (Throwable paramArrayOfVoid)
    {
      Log.w(b, "Could not fetch subjects", paramArrayOfVoid);
    }
    return Boolean.valueOf(false);
  }

  protected void a(Boolean paramBoolean)
  {
    a = false;
  }

  protected void onCancelled()
  {
    a = false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rf
 * JD-Core Version:    0.6.2
 */