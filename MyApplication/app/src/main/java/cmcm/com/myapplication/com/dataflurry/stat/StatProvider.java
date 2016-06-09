package cmcm.com.myapplication.com.dataflurry.stat;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
import kg;
import kl;
import kn;
import kr;
import kv;
import kx;
import ky;
import kz;

public class StatProvider extends ContentProvider
{
  private static final UriMatcher f;
  private static final Uri g = Uri.parse("content://com.dataflurry.stat/persons");
  private static final String[] h = { "TabAgent2", "FileData", "qiigameAgent@v2" };
  private static final Long[] k = { Long.valueOf(10000L), Long.valueOf(30000L), Long.valueOf(30000L), Long.valueOf(120000L), Long.valueOf(300000L), Long.valueOf(1200000L), Long.valueOf(3600000L), Long.valueOf(21600000L), Long.valueOf(86400000L) };
  String a = "key";
  String b = "value";
  String[] c = { this.a, this.b };
  private kg d;
  private Handler e = null;
  private boolean i = false;
  private int j = 0;
  private BroadcastReceiver l = null;
  private boolean m = false;

  static
  {
    f = new UriMatcher(-1);
    f.addURI("com.dataflurry.stat", "TabAgent2", 0);
    f.addURI("com.dataflurry.stat", "FileData", 1);
    f.addURI("com.dataflurry.stat", "qiigameAgent@v2", 2);
  }

  private int a(Uri paramUri)
  {
    try
    {
      int n = f.match(paramUri);
      if (n >= 0)
      {
        int i1 = h.length;
        if (n < i1 * 2)
          return n;
      }
    }
    catch (Throwable paramUri)
    {
      paramUri.printStackTrace();
    }
    return -1;
  }

  private int a(Uri paramUri, String[] paramArrayOfString)
  {
    List localList = paramUri.getPathSegments();
    if (localList.size() != 2)
      throw new IllegalArgumentException("Invalid uri: " + paramUri);
    paramUri = (String)localList.get(0);
    Log.d("DF_Provider", "Clearing shared preferences " + paramUri);
    try
    {
      getContext().getSharedPreferences(paramUri, 0).edit().remove(paramArrayOfString[0]).commit();
      return 1;
    }
    catch (Throwable paramUri)
    {
    }
    return 0;
  }

  private Cursor a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    paramUri = paramUri.getPathSegments();
    int n = paramUri.size();
    if (3 < n)
      Log.d("DF_Provider", "Path segments since index 2 are ignored");
    paramUri = (String)paramUri.get(0);
    if (2 < n)
      Log.d("DF_Provider", "Getting single preference is not supported at this time");
    Object localObject;
    while (true)
    {
      return new MatrixCursor(this.c, 0);
      if ((paramArrayOfString != null) && (paramArrayOfString.length == 2))
        try
        {
          localObject = getContext().getSharedPreferences(paramUri, 0);
          n = Integer.valueOf(paramString).intValue();
          paramString = new MatrixCursor(this.c, 1);
          switch (n)
          {
          case 0:
            localObject = ((SharedPreferences)localObject).getString(paramArrayOfString[0], paramArrayOfString[1]);
            paramString.addRow(new Object[] { paramArrayOfString[0], localObject });
          case 1:
          case 2:
          case 3:
          case 4:
          }
        }
        catch (Throwable paramString)
        {
          Log.w("DF_Provider", "Could not load shared preferences " + paramUri, paramString);
        }
    }
    boolean bool = ((SharedPreferences)localObject).getBoolean(paramArrayOfString[0], Boolean.valueOf(paramArrayOfString[1]).booleanValue());
    paramString.addRow(new Object[] { paramArrayOfString[0], String.valueOf(bool) });
    break label395;
    long l1 = ((SharedPreferences)localObject).getLong(paramArrayOfString[0], Long.valueOf(paramArrayOfString[1]).longValue());
    paramString.addRow(new Object[] { paramArrayOfString[0], Long.valueOf(l1) });
    break label395;
    n = ((SharedPreferences)localObject).getInt(paramArrayOfString[0], Integer.valueOf(paramArrayOfString[1]).intValue());
    paramString.addRow(new Object[] { paramArrayOfString[0], Integer.valueOf(n) });
    break label395;
    float f1 = ((SharedPreferences)localObject).getFloat(paramArrayOfString[0], Float.valueOf(paramArrayOfString[1]).floatValue());
    paramString.addRow(new Object[] { paramArrayOfString[0], Float.valueOf(f1) });
    label395: return paramString;
  }

  private void a(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject1 = paramUri.getPathSegments();
    if (((List)localObject1).size() != 1)
      throw new IllegalArgumentException("Invalid uri: " + paramUri);
    String str = (String)((List)localObject1).get(0);
    Object localObject2 = null;
    localObject1 = null;
    while (true)
    {
      Editor localEditor;
      try
      {
        localEditor = getContext().getSharedPreferences(str, 0).edit();
        localObject1 = localEditor;
        localObject2 = localEditor;
        switch (paramContentValues.getAsInteger("prefs_type").intValue())
        {
        case 0:
          localObject1 = localEditor;
          localObject2 = localEditor;
          throw new IllegalArgumentException("Unsupported type " + paramUri);
        case 1:
        case 2:
        case 3:
        case 4:
        }
      }
      catch (Throwable paramUri)
      {
        localObject2 = localObject1;
        Log.w("DF_Provider", "Could not save shared preferences " + str, paramUri);
        return;
        localObject1 = localEditor;
        localObject2 = localEditor;
        localEditor.putString(paramContentValues.getAsString("prefs_key"), paramContentValues.getAsString("prefs_valuse"));
        return;
        localObject1 = localEditor;
        localObject2 = localEditor;
        localEditor.putBoolean(paramContentValues.getAsString("prefs_key"), paramContentValues.getAsBoolean("prefs_valuse").booleanValue());
        continue;
      }
      finally
      {
        if (localObject2 != null)
          localObject2.commit();
      }
      localObject1 = localEditor;
      localObject2 = localEditor;
      localEditor.putLong(paramContentValues.getAsString("prefs_key"), paramContentValues.getAsLong("prefs_valuse").longValue());
      continue;
      localObject1 = localEditor;
      localObject2 = localEditor;
      localEditor.putInt(paramContentValues.getAsString("prefs_key"), paramContentValues.getAsInteger("prefs_valuse").intValue());
      continue;
      localObject1 = localEditor;
      localObject2 = localEditor;
      localEditor.putFloat(paramContentValues.getAsString("prefs_key"), paramContentValues.getAsFloat("prefs_valuse").floatValue());
    }
  }

  private void e()
  {
    try
    {
      this.l = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (kv.a().v())
            return;
          if (kn.a)
            Log.i("DF_Provider", "mReceiver: " + paramAnonymousIntent.getAction());
          if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramAnonymousIntent.getAction()));
          while (true)
          {
            try
            {
              l1 = System.currentTimeMillis();
              paramAnonymousIntent = new kz(StatProvider.this.getContext());
              long l2 = paramAnonymousIntent.d();
              paramAnonymousIntent.a();
              if (l1 - l2 > 0L)
              {
                l1 -= l2;
                if ((kv.a().b) && (21600000L - l1 < 0L))
                  kv.a().b = false;
                paramAnonymousIntent = (ConnectivityManager)paramAnonymousContext.getSystemService("connectivity");
                if (paramAnonymousIntent.getNetworkInfo(1) == null)
                  break label352;
                paramAnonymousContext = paramAnonymousIntent.getNetworkInfo(1).getState();
                if (paramAnonymousIntent.getNetworkInfo(0) == null)
                  break label347;
                paramAnonymousIntent = paramAnonymousIntent.getNetworkInfo(0).getState();
                if ((paramAnonymousContext == null) || (State.CONNECTED != paramAnonymousContext))
                  break label214;
                if (kn.a)
                  Log.i("DF_Provider", "无线网络连接成功");
                StatProvider.this.a(true);
                return;
              }
            }
            catch (Exception paramAnonymousContext)
            {
              paramAnonymousContext.printStackTrace();
              return;
            }
            long l1 = 0L;
            continue;
            label214: if (((paramAnonymousContext != null) && (State.CONNECTED != paramAnonymousContext)) || ((paramAnonymousIntent != null) && (State.CONNECTED == paramAnonymousIntent)))
            {
              if (kn.a)
                Log.i("DF_Provider", "手机网络连接成功");
              StatProvider.this.a(false);
              return;
            }
            if (((paramAnonymousContext == null) || (State.CONNECTED == paramAnonymousContext)) && ((paramAnonymousIntent == null) || (State.CONNECTED == paramAnonymousIntent)))
              break;
            if (kn.a)
              Log.i("DF_Provider", "手机没有任何的网络");
            StatProvider.this.c();
            return;
            if (!"android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction()))
              break;
            if (kn.a)
              Log.i("DF_Provider", "屏幕暗屏");
            StatProvider.this.a(ky.f(StatProvider.this.getContext()));
            return;
            label347: paramAnonymousIntent = null;
            continue;
            label352: paramAnonymousContext = null;
          }
        }
      };
      return;
    }
    catch (Throwable localThrowable)
    {
      if (kn.a)
        Log.w("system.err", localThrowable);
      localThrowable.printStackTrace();
    }
  }

  private void f()
  {
    kv.a().a(getContext());
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      getContext().registerReceiver(this.l, localIntentFilter);
      a(ky.f(getContext()));
      a();
      if (kv.a().r())
        b();
      kl.a().a(getContext());
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private void g()
  {
    HandlerThread localHandlerThread = new HandlerThread("analytics");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        long l1 = 60000L;
        try
        {
          if (kn.a)
            kx.d("DF_Provider", "msg.what:" + paramAnonymousMessage.what);
          switch (paramAnonymousMessage.what)
          {
          case 600:
            StatProvider.a(StatProvider.this);
            return;
          case 100:
          case 200:
          case 300:
          case 400:
          case 500:
          }
        }
        catch (Throwable paramAnonymousMessage)
        {
          if (kn.a)
            Log.w("system.err", paramAnonymousMessage);
          paramAnonymousMessage.printStackTrace();
          return;
        }
        Handler localHandler;
        try
        {
          kv.a().k(null);
          StatProvider.b(StatProvider.this).removeMessages(100);
          paramAnonymousMessage = StatProvider.b(StatProvider.this);
          if (kv.a().j());
          while (true)
          {
            paramAnonymousMessage.sendEmptyMessageDelayed(100, l1);
            return;
            l1 = 86400000L;
          }
        }
        catch (Throwable paramAnonymousMessage)
        {
          if (kn.a)
            Log.w("system.err", paramAnonymousMessage);
          paramAnonymousMessage.printStackTrace();
          StatProvider.b(StatProvider.this).removeMessages(100);
          paramAnonymousMessage = StatProvider.b(StatProvider.this);
          if (kv.a().j())
          {
            paramAnonymousMessage.sendEmptyMessageDelayed(100, l1);
            return;
          }
        }
        finally
        {
          StatProvider.b(StatProvider.this).removeMessages(100);
          localHandler = StatProvider.b(StatProvider.this);
          if (kv.a().j());
          while (true)
          {
            localHandler.sendEmptyMessageDelayed(100, l1);
            throw paramAnonymousMessage;
            l1 = 86400000L;
          }
        }
        while (true)
        {
          try
          {
            l2 = System.currentTimeMillis();
            paramAnonymousMessage = new kz(StatProvider.this.getContext());
            l3 = paramAnonymousMessage.d();
            if (l2 - l3 <= 0L)
              break label933;
            l2 -= l3;
            if ((kv.a().l()) || (kv.a().b))
            {
              if (!kv.a().j())
                break label939;
              l3 = 60000L;
              if (l3 - l2 < 0L)
              {
                kl.a().a(StatProvider.this.getContext());
                kv.a().c(false);
                kv.a().b = false;
              }
            }
            if (!kv.a().l())
            {
              paramAnonymousMessage.c(System.currentTimeMillis());
              paramAnonymousMessage.a();
              kv.a().n();
            }
            StatProvider.b(StatProvider.this).removeMessages(200);
            paramAnonymousMessage = StatProvider.b(StatProvider.this);
            if (ky.f(StatProvider.this.getContext()))
            {
              if (kv.a().j())
              {
                paramAnonymousMessage.sendEmptyMessageDelayed(200, l1);
                return;
              }
              kv.a();
              l1 = 3600000L;
              continue;
            }
            kv.a();
            l1 = 21600000L;
            continue;
          }
          catch (Throwable paramAnonymousMessage)
          {
            if (kn.a)
              Log.w("system.err", paramAnonymousMessage);
            paramAnonymousMessage.printStackTrace();
            StatProvider.b(StatProvider.this).removeMessages(200);
            paramAnonymousMessage = StatProvider.b(StatProvider.this);
            if (ky.f(StatProvider.this.getContext()))
            {
              if (kv.a().j())
              {
                paramAnonymousMessage.sendEmptyMessageDelayed(200, l1);
                return;
              }
              kv.a();
              l1 = 3600000L;
              continue;
            }
            kv.a();
            l1 = 21600000L;
            continue;
          }
          finally
          {
            StatProvider.b(StatProvider.this).removeMessages(200);
            localHandler = StatProvider.b(StatProvider.this);
            if (ky.f(StatProvider.this.getContext()))
            {
              if (kv.a().j())
              {
                localHandler.sendEmptyMessageDelayed(200, l1);
                throw paramAnonymousMessage;
              }
              kv.a();
              l1 = 3600000L;
              continue;
            }
            kv.a();
            l1 = 21600000L;
            continue;
          }
          if (kn.a)
            Log.w("DF_QA", "发送real");
          StatProvider.this.a();
          return;
          try
          {
            l2 = System.currentTimeMillis();
            paramAnonymousMessage = new kz(StatProvider.this.getContext());
            paramAnonymousMessage.b(l2);
            paramAnonymousMessage.a();
            kv.a().m();
            kv.a().d = false;
            StatProvider.b(StatProvider.this).removeMessages(400);
            paramAnonymousMessage = StatProvider.b(StatProvider.this);
            if (kv.a().j());
            while (true)
            {
              paramAnonymousMessage.sendEmptyMessageDelayed(400, l1);
              return;
              kv.a();
              l1 = 86400000L;
            }
          }
          catch (Exception paramAnonymousMessage)
          {
            paramAnonymousMessage.printStackTrace();
            kv.a().d = false;
            StatProvider.b(StatProvider.this).removeMessages(400);
            paramAnonymousMessage = StatProvider.b(StatProvider.this);
            if (kv.a().j());
            while (true)
            {
              paramAnonymousMessage.sendEmptyMessageDelayed(400, l1);
              return;
              kv.a();
              l1 = 86400000L;
            }
          }
          finally
          {
            kv.a().d = false;
            StatProvider.b(StatProvider.this).removeMessages(400);
            localHandler = StatProvider.b(StatProvider.this);
            if (kv.a().j());
            while (true)
            {
              localHandler.sendEmptyMessageDelayed(400, l1);
              throw paramAnonymousMessage;
              kv.a();
              l1 = 86400000L;
            }
          }
          try
          {
            new Thread(new Runnable()
            {
              public void run()
              {
                try
                {
                  kz localkz = new kz(StatProvider.this.getContext());
                  Object localObject2 = kr.a(StatProvider.this.getContext());
                  if (kn.a)
                    Log.i("DF_Provider", "sendAppsflyer result:" + (String)localObject2);
                  if ("ok".equals(localObject2))
                    localkz.b(true);
                  while (true)
                  {
                    localkz.a();
                    return;
                    if (StatProvider.c(StatProvider.this) <= StatProvider.d().length)
                    {
                      localObject2 = StatProvider.b(StatProvider.this);
                      if (!kv.a().j())
                        break;
                      l = 5000L;
                      ((Handler)localObject2).sendEmptyMessageDelayed(500, l);
                    }
                  }
                }
                catch (Throwable localThrowable)
                {
                  while (true)
                  {
                    localThrowable.printStackTrace();
                    return;
                    long l = StatProvider.d()[StatProvider.d(StatProvider.this)].longValue();
                  }
                }
                finally
                {
                  kv.a().c = false;
                }
              }
            }).start();
            return;
          }
          catch (Throwable paramAnonymousMessage)
          {
            return;
          }
          return;
          l1 = 86400000L;
          break;
          label933: long l2 = 0L;
          continue;
          label939: long l3 = 3600000L;
        }
      }
    };
  }

  public void a()
  {
    if (kn.a)
      Log.v("DF_Provider", "sendReal ................." + kv.a().q());
    if ((this.m) || (!kv.a().q()));
    boolean bool;
    do
    {
      return;
      kz localkz = new kz(getContext());
      bool = localkz.g();
      localkz.a();
    }
    while (bool);
    this.m = true;
    try
    {
      new AsyncTask()
      {
        protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
        {
          try
          {
            paramAnonymousArrayOfObject = kr.a(kv.a().b());
            if (kn.a)
              Log.v("DF_Provider", "sendReal result:" + paramAnonymousArrayOfObject);
            if ("ok".toString().trim().equals(paramAnonymousArrayOfObject.toString().trim()))
            {
              paramAnonymousArrayOfObject = new kz(StatProvider.this.getContext());
              paramAnonymousArrayOfObject.f();
              paramAnonymousArrayOfObject.a();
            }
            while (true)
            {
              return null;
              StatProvider.this.a(300, 1800000L);
            }
          }
          catch (Throwable paramAnonymousArrayOfObject)
          {
            while (true)
            {
              paramAnonymousArrayOfObject.printStackTrace();
              StatProvider.a(StatProvider.this, false);
            }
          }
          finally
          {
            StatProvider.a(StatProvider.this, false);
          }
          throw paramAnonymousArrayOfObject;
        }
      }
      .execute(new Object[0]);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void a(int paramInt, long paramLong)
  {
    this.e.sendEmptyMessageDelayed(paramInt, paramLong);
  }

  public void a(boolean paramBoolean)
  {
    label516: label530: label537: label548: 
    while (true)
    {
      long l1;
      long l4;
      long l5;
      long l3;
      long l6;
      boolean bool;
      int n;
      try
      {
        long l2;
        if (kv.a().j())
        {
          l2 = 60000L;
          if (kv.a().j())
          {
            l1 = 60000L;
            l4 = System.currentTimeMillis();
            kz localkz = new kz(getContext());
            l5 = localkz.b();
            l3 = localkz.d();
            l6 = localkz.c();
            if (l4 - l5 <= 0L)
              continue;
            l5 = l4 - l5;
            break label468;
            bool = getContext().getPackageName().equals(ky.k(getContext()));
            Handler localHandler;
            if (!this.e.hasMessages(100))
            {
              localHandler = this.e;
              if (l2 - l5 <= 0L)
                continue;
              l5 = l2 - l5;
              break label505;
              localHandler.sendEmptyMessageDelayed(100, n + l5);
            }
            if ((!this.e.hasMessages(200)) && (!kv.a().b))
            {
              kv.a().b = true;
              localHandler = this.e;
              if (!paramBoolean)
                continue;
              l5 = l1;
              break label516;
              localHandler.sendEmptyMessageDelayed(200, n + l1);
            }
            if (!kv.a().d)
            {
              kv.a().d = true;
              localHandler = this.e;
              if (l2 - l4 <= 0L)
                continue;
              l1 = l2 - l4;
              break label548;
              localHandler.sendEmptyMessageDelayed(400, n + l1);
            }
            if (paramBoolean)
            {
              paramBoolean = localkz.g();
              if (kn.a)
                Log.i("DF_Provider", "sendMessage 发送real" + paramBoolean);
              if ((!paramBoolean) && (!this.e.hasMessages(300)))
              {
                localHandler = this.e;
                if (!bool)
                  continue;
                n = 0;
                localHandler.sendEmptyMessageDelayed(300, n + 50);
              }
              localkz.a();
            }
          }
        }
        else
        {
          l2 = 86400000L;
          continue;
        }
        l1 = 3600000L;
        continue;
        l5 = 0L;
        break label468;
        l3 = 0L;
        break label485;
        l4 = 0L;
        continue;
        l5 = 50L;
        break label505;
        n = 10000;
        continue;
        l5 = 21600000L;
        break label516;
        l1 = 21600000L;
        break label530;
        l1 = 50L;
        break label537;
        n = 10000;
        continue;
        l1 = 50L;
        break label548;
        n = 10000;
        continue;
        n = 10000;
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label468: if (l4 - l3 > 0L)
      {
        l3 = l4 - l3;
        label485: if (l4 - l6 > 0L)
        {
          l4 -= l6;
          continue;
          label505: if (bool)
          {
            n = 0;
            continue;
            if (l5 - l3 > 0L)
              if (paramBoolean)
              {
                l1 -= l3;
                if (bool)
                {
                  n = 0;
                  continue;
                  if (bool)
                    n = 0;
                }
              }
          }
        }
      }
    }
  }

  public void b()
  {
    kz localkz = new kz(getContext());
    boolean bool = localkz.k();
    localkz.a();
    if (kn.a)
      kx.b("DF_Provider", "isSend:" + bool);
    if ((!this.i) && (!bool))
    {
      this.i = true;
      this.e.removeMessages(500);
      this.e.sendEmptyMessageDelayed(500, 10000L);
    }
  }

  public void c()
  {
    if (this.e != null)
      this.e.removeCallbacksAndMessages(null);
  }

  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (String.valueOf(500).equals(paramString1))
      b();
    return super.call(paramString1, paramString2, paramBundle);
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int n = a(paramUri);
    if (n < 0);
    do
    {
      return 0;
      if (n == 2)
      {
        a(paramUri, paramArrayOfString);
        return 0;
      }
      paramUri = this.d.getWritableDatabase();
    }
    while ((paramUri == null) || (n >= h.length));
    try
    {
      n = paramUri.delete(h[n], paramString, paramArrayOfString);
      return n;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
    return 0;
  }

  public String getType(Uri paramUri)
  {
    return null;
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    int n = 0;
    int i1 = a(paramUri);
    if ((i1 < 0) || (i1 >= h.length));
    while (true)
    {
      return null;
      if (i1 == 2)
      {
        a(paramUri, paramContentValues);
        return null;
      }
      SQLiteDatabase localSQLiteDatabase = this.d.getWritableDatabase();
      if (localSQLiteDatabase != null)
      {
        if (paramContentValues.containsKey("DELETE"))
        {
          localSQLiteDatabase.execSQL(String.format("DELETE FROM (SELECT ID FROM TabAgent2 WHERE eventType='3' or eventType='4' or eventType='5' ORDER BY date ASC limit 0,4000) as B", new Object[0]));
          return null;
        }
        try
        {
          long l1 = localSQLiteDatabase.insert(h[i1], "_id", paramContentValues);
          if (l1 > 0L)
          {
            Uri localUri = paramUri.buildUpon().appendPath(String.valueOf(l1)).build();
            return localUri;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          n = 1;
        }
        if ((n != 0) && (!TextUtils.isEmpty(null)) && (!TextUtils.isEmpty(null)))
          try
          {
            if (localSQLiteDatabase.update(h[i1], paramContentValues, null + "=?", new String[] { null }) > 0L)
            {
              paramUri = paramUri.buildUpon().appendPath(null).build();
              return paramUri;
            }
          }
          catch (Exception paramUri)
          {
            paramUri.printStackTrace();
          }
      }
    }
    return null;
  }

  public boolean onCreate()
  {
    this.d = new kg(this, getContext());
    g();
    e();
    this.e.sendEmptyMessageDelayed(600, 50L);
    return true;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int n = a(paramUri);
    SQLiteDatabase localSQLiteDatabase = this.d.getReadableDatabase();
    if ((localSQLiteDatabase == null) || (n < 0))
    {
      paramUri = paramArrayOfString1;
      if (paramArrayOfString1 == null)
      {
        paramUri = new String[1];
        paramUri[0] = "_id";
      }
      paramString1 = new MatrixCursor(paramUri, 1);
      return paramString1;
    }
    if (n == 2)
      return a(paramUri, paramString1, paramArrayOfString2);
    if (n < h.length);
    while (true)
    {
      try
      {
        paramArrayOfString1 = localSQLiteDatabase.query(h[n], paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        paramString1 = paramArrayOfString1;
        if (paramArrayOfString1 == null)
          break;
        paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
        return paramArrayOfString1;
      }
      catch (Exception paramArrayOfString1)
      {
        paramArrayOfString1.printStackTrace();
      }
      paramArrayOfString1 = null;
    }
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int n = a(paramUri);
    if (n < 0);
    do
    {
      return 0;
      paramUri = this.d.getWritableDatabase();
    }
    while ((paramUri == null) || (n >= h.length));
    try
    {
      n = paramUri.update(h[n], paramContentValues, paramString, paramArrayOfString);
      return n;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
    return 0;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.dataflurry.stat.StatProvider
 * JD-Core Version:    0.6.2
 */