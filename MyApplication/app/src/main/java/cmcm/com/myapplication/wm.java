package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class wm extends BroadcastReceiver
{
  private static final Object e = new Object();
  public final wj a;
  public boolean b = false;
  public boolean c = false;
  private final Context d;
  private final ArrayList<wk> f = new ArrayList();
  private final ArrayList<wk> g = new ArrayList();
  private final HashMap<ComponentName, wk> h = new HashMap();

  public wm(Context paramContext)
  {
    this.d = paramContext;
    this.a = new wj(paramContext);
    c(paramContext);
  }

  private void a(String paramString1, SharedPreferences paramSharedPreferences, String paramString2, int paramInt, String paramString3)
  {
    int i = paramString2.indexOf(',', paramString1.length() + paramInt);
    if ((paramInt == 0) && (i < 0))
      paramString1 = null;
    while (true)
    {
      paramSharedPreferences.edit().putString(paramString3, paramString1).apply();
      return;
      if (paramInt == 0)
        paramString1 = paramString2.substring(i + 1);
      else if (i < 0)
        paramString1 = paramString2.substring(0, paramInt);
      else
        paramString1 = paramString2.substring(0, paramInt) + paramString2.substring(i + 1);
    }
  }

  private void b(String paramString)
  {
    this.a.b(paramString);
    Object localObject1 = this.d.getPackageManager();
    Object localObject2 = ((PackageManager)localObject1).queryIntentActivities(asq.a(paramString), 0);
    final ArrayList localArrayList = new ArrayList(((List)localObject2).size());
    Iterator localIterator = ((List)localObject2).iterator();
    while (localIterator.hasNext())
    {
      final wk localwk = new wk((PackageManager)localObject1, (ResolveInfo)localIterator.next());
      localwk.f = -1;
      localArrayList.add(localwk);
      a(localwk);
      arj.a(new Runnable()
      {
        public void run()
        {
          wn.a(wm.a(wm.this), localwk);
        }
      });
    }
    ((List)localObject2).clear();
    localObject1 = vs.a(this.d);
    localObject2 = ((SharedPreferences)localObject1).getString("key_notification_apps_selected", "");
    if (this.d.getString(2131231208).contains(paramString))
    {
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).contains(paramString)))
        ((SharedPreferences)localObject1).edit().putString("key_notification_apps_selected", paramString + "," + (String)localObject2).apply();
      if (vs.x(this.d))
      {
        vs.e(this.d, 104);
        amk.c(this.d, true);
        vs.c(this.d, paramString);
      }
    }
    aie.a(this.d, paramString);
    aho.b(this.d, paramString);
    arj.a(new Runnable()
    {
      public void run()
      {
        aft.c();
        if (!localArrayList.isEmpty())
        {
          ArrayList localArrayList = new ArrayList(1);
          localArrayList.add(localArrayList.get(0));
          aft.a(false, new ArrayList(localArrayList));
        }
      }
    });
    if ((vg.k) && ("com.lazyswipe.pro2".equals(paramString)))
      apz.a(this.d);
  }

  private void c(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addDataScheme("package");
    paramContext.registerReceiver(this, localIntentFilter);
    paramContext.registerReceiver(this, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
    localIntentFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
    paramContext.registerReceiver(this, localIntentFilter);
  }

  private void c(String arg1)
  {
    this.a.b(???);
    PackageManager localPackageManager1 = this.d.getPackageManager();
    List localList = localPackageManager1.queryIntentActivities(asq.a(???), 0);
    if ("com.lazyswipe".equals(???))
      ajl.b(this.d);
    if (localList.size() > 0)
    {
      while (true)
      {
        synchronized (e)
        {
          Iterator localIterator = localList.iterator();
          if (!localIterator.hasNext())
            break;
          localObject1 = (ResolveInfo)localIterator.next();
          Object localObject2 = asq.a((ResolveInfo)localObject1);
          localObject2 = (wk)this.h.get(localObject2);
          if (localObject2 != null)
          {
            ((wk)localObject2).a(localPackageManager1, (ResolveInfo)localObject1);
            ((wk)localObject2).j = asq.b((ResolveInfo)localObject1);
          }
        }
        Object localObject1 = new wk(localPackageManager2, (ResolveInfo)localObject1);
        a((wk)localObject1);
        arj.a(new Runnable()
        {
          public void run()
          {
            wn.a(wm.a(wm.this), this.a);
          }
        });
      }
      localList.clear();
      return;
    }
    d(???);
  }

  private void d(String paramString)
  {
    this.a.a(paramString);
    while (true)
    {
      int i;
      synchronized (e)
      {
        i = this.f.size() - 1;
        Object localObject2;
        if (i >= 0)
        {
          localObject2 = (wk)this.f.get(i);
          if (((wk)localObject2).i.getPackageName().equals(paramString))
          {
            this.f.remove(i);
            this.h.remove(((wk)localObject2).i);
            this.g.remove(localObject2);
            if (((wk)localObject2).k != 0)
              ((wk)localObject2).k = 0;
            arj.a(new Runnable()
            {
              public void run()
              {
                wn.b(wm.a(wm.this), this.a);
              }
            });
          }
        }
        else
        {
          ??? = vs.a(this.d);
          localObject2 = ((SharedPreferences)???).getString("key_notification_apps_selected", null);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            i = ((String)localObject2).indexOf(paramString);
            if (i >= 0)
              a(paramString, (SharedPreferences)???, (String)localObject2, i, "key_notification_apps_selected");
          }
          localObject2 = ((SharedPreferences)???).getString("key_white_list", null);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            i = ((String)localObject2).indexOf(paramString);
            if (i >= 0)
              a(paramString, (SharedPreferences)???, (String)localObject2, i, "key_white_list");
          }
          if ((amk.c(this.d)) && (vs.F(this.d) == 104) && (paramString.equals(vs.w(this.d))))
            amk.c(this.d, false);
          alo.d(this.d, paramString);
          aho.c(this.d, paramString);
          arj.a(new Runnable()
          {
            public void run()
            {
              aft.c();
            }
          });
          if ("com.lazyswipe.pro2".equals(paramString))
            apz.c(this.d);
          return;
        }
      }
      i -= 1;
    }
  }

  public ArrayList<wk> a()
  {
    synchronized (e)
    {
      ArrayList localArrayList = new ArrayList(this.f);
      return localArrayList;
    }
  }

  // ERROR //
  public List<wk> a(int paramInt)
  {
    // Byte code:
    //   0: new 110	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 371
    //   10: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: astore_3
    //   14: iload_1
    //   15: ifle +170 -> 185
    //   18: new 110	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 373
    //   28: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_1
    //   32: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_3
    //   40: aload_2
    //   41: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 66	wm:d	Landroid/content/Context;
    //   52: invokevirtual 380	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   55: getstatic 385	xg:a	Landroid/net/Uri;
    //   58: aconst_null
    //   59: ldc_w 387
    //   62: iconst_2
    //   63: anewarray 78	java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: getstatic 391	ash:b	Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: getstatic 391	ash:b	Ljava/lang/String;
    //   77: aastore
    //   78: aload_2
    //   79: invokevirtual 397	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore_2
    //   83: new 399	xh
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 402	xh:<init>	(Landroid/database/Cursor;)V
    //   91: astore 4
    //   93: new 50	java/util/ArrayList
    //   96: dup
    //   97: aload_2
    //   98: invokeinterface 407 1 0
    //   103: invokespecial 148	java/util/ArrayList:<init>	(I)V
    //   106: astore 5
    //   108: aload_2
    //   109: invokeinterface 410 1 0
    //   114: ifeq +110 -> 224
    //   117: aload_2
    //   118: aload 4
    //   120: getfield 412	xh:b	I
    //   123: invokeinterface 413 2 0
    //   128: invokestatic 417	android/content/ComponentName:unflattenFromString	(Ljava/lang/String;)Landroid/content/ComponentName;
    //   131: astore_3
    //   132: aload_0
    //   133: getfield 60	wm:h	Ljava/util/HashMap;
    //   136: aload_3
    //   137: invokevirtual 297	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: checkcast 160	wk
    //   143: astore_3
    //   144: aload_3
    //   145: ifnull +46 -> 191
    //   148: aload 5
    //   150: aload_3
    //   151: invokeinterface 176 2 0
    //   156: pop
    //   157: goto -49 -> 108
    //   160: astore_3
    //   161: ldc_w 419
    //   164: ldc_w 421
    //   167: aload_3
    //   168: invokestatic 426	asp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload_2
    //   172: ifnull +9 -> 181
    //   175: aload_2
    //   176: invokeinterface 429 1 0
    //   181: getstatic 435	java/util/Collections:EMPTY_LIST	Ljava/util/List;
    //   184: areturn
    //   185: ldc 199
    //   187: astore_2
    //   188: goto -149 -> 39
    //   191: new 160	wk
    //   194: dup
    //   195: aload_2
    //   196: aload 4
    //   198: invokespecial 438	wk:<init>	(Landroid/database/Cursor;Lxh;)V
    //   201: astore_3
    //   202: goto -54 -> 148
    //   205: astore 4
    //   207: aload_2
    //   208: astore_3
    //   209: aload 4
    //   211: astore_2
    //   212: aload_3
    //   213: ifnull +9 -> 222
    //   216: aload_3
    //   217: invokeinterface 429 1 0
    //   222: aload_2
    //   223: athrow
    //   224: aload_2
    //   225: ifnull +9 -> 234
    //   228: aload_2
    //   229: invokeinterface 429 1 0
    //   234: aload 5
    //   236: areturn
    //   237: astore_2
    //   238: aconst_null
    //   239: astore_3
    //   240: goto -28 -> 212
    //   243: astore 4
    //   245: aload_2
    //   246: astore_3
    //   247: aload 4
    //   249: astore_2
    //   250: goto -38 -> 212
    //   253: astore_3
    //   254: aconst_null
    //   255: astore_2
    //   256: goto -95 -> 161
    //
    // Exception table:
    //   from	to	target	type
    //   83	108	160	java/lang/Throwable
    //   108	144	160	java/lang/Throwable
    //   148	157	160	java/lang/Throwable
    //   191	202	160	java/lang/Throwable
    //   83	108	205	finally
    //   108	144	205	finally
    //   148	157	205	finally
    //   191	202	205	finally
    //   48	83	237	finally
    //   161	171	243	finally
    //   48	83	253	java/lang/Throwable
  }

  public wk a(ComponentName paramComponentName)
  {
    if (paramComponentName == null)
      return null;
    synchronized (e)
    {
      paramComponentName = (wk)this.h.get(paramComponentName);
      return paramComponentName;
    }
  }

  public wk a(String paramString)
  {
    wk localwk = null;
    while (true)
      synchronized (e)
      {
        Iterator localIterator = this.h.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((ComponentName)localEntry.getKey()).getPackageName().equals(paramString))
            localwk = (wk)localEntry.getValue();
        }
        else
        {
          return localwk;
        }
      }
  }

  public void a(Context paramContext)
  {
    paramContext.unregisterReceiver(this);
  }

  protected void a(Intent paramIntent, String paramString)
  {
    int k = 1;
    String str = paramIntent.getData().getSchemeSpecificPart();
    boolean bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
    int i;
    label63: int j;
    switch (paramString.hashCode())
    {
    default:
      i = -1;
      j = k;
      switch (i)
      {
      default:
        label96: j = -1;
      case 2:
      case 0:
      case 1:
      }
      break;
    case 1544582882:
    case 525384130:
    case -810471698:
    }
    while (true)
    {
      if (j != -1)
        break label188;
      return;
      if (!paramString.equals("android.intent.action.PACKAGE_ADDED"))
        break;
      i = 0;
      break label63;
      if (!paramString.equals("android.intent.action.PACKAGE_REMOVED"))
        break;
      i = 1;
      break label63;
      if (!paramString.equals("android.intent.action.PACKAGE_REPLACED"))
        break;
      i = 2;
      break label63;
      abd.a(this.d, paramIntent);
      j = k;
      if (!bool)
      {
        j = 0;
        continue;
        if (bool)
          break label96;
        j = 2;
      }
    }
    switch (j)
    {
    default:
      return;
    case 0:
      b(str);
      return;
    case 1:
      label188: c(str);
      return;
    case 2:
    }
    d(str);
  }

  public void a(wk paramwk)
  {
    a(paramwk, false);
  }

  public void a(wk paramwk, Runnable paramRunnable)
  {
    paramwk.f = -1;
    b(paramwk, paramRunnable);
  }

  public void a(wk paramwk, boolean paramBoolean)
  {
    synchronized (e)
    {
      wk localwk = (wk)this.h.get(paramwk.i);
      if ((localwk != null) && (!paramBoolean))
        return;
      if (localwk != null)
        this.f.remove(localwk);
      this.f.add(paramwk);
      this.h.put(paramwk.i, paramwk);
      if (this.a.a(paramwk.i, new String[0]))
      {
        if (localwk != null)
          this.g.remove(localwk);
        this.g.add(paramwk);
      }
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.b = false;
    if (paramBoolean)
      atx.a().b();
    new Thread(new wl(this.d, this, paramBoolean)).start();
  }

  // ERROR //
  public List<String> b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 50	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 51	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: invokestatic 533	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   13: invokevirtual 534	com/lazyswipe/SwipeApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   16: astore_2
    //   17: getstatic 385	xg:a	Landroid/net/Uri;
    //   20: astore 4
    //   22: getstatic 391	ash:b	Ljava/lang/String;
    //   25: astore 5
    //   27: aload_2
    //   28: aload 4
    //   30: iconst_1
    //   31: anewarray 78	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc_w 536
    //   39: aastore
    //   40: ldc_w 538
    //   43: iconst_1
    //   44: anewarray 78	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: aload 5
    //   51: aastore
    //   52: aconst_null
    //   53: invokevirtual 397	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 410 1 0
    //   65: ifeq +33 -> 98
    //   68: aload_3
    //   69: aload_1
    //   70: iconst_0
    //   71: invokeinterface 413 2 0
    //   76: invokeinterface 176 2 0
    //   81: pop
    //   82: goto -23 -> 59
    //   85: astore_2
    //   86: aload_1
    //   87: ifnull +9 -> 96
    //   90: aload_1
    //   91: invokeinterface 429 1 0
    //   96: aload_3
    //   97: areturn
    //   98: aload_1
    //   99: ifnull -3 -> 96
    //   102: aload_1
    //   103: invokeinterface 429 1 0
    //   108: aload_3
    //   109: areturn
    //   110: astore_2
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 429 1 0
    //   121: aload_2
    //   122: athrow
    //   123: astore_2
    //   124: goto -13 -> 111
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_1
    //   130: goto -44 -> 86
    //
    // Exception table:
    //   from	to	target	type
    //   59	82	85	java/lang/Exception
    //   10	57	110	finally
    //   59	82	123	finally
    //   10	57	127	java/lang/Exception
  }

  // ERROR //
  public List<wk> b(int paramInt)
  {
    // Byte code:
    //   0: new 110	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 541
    //   10: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: astore_3
    //   14: iload_1
    //   15: ifle +159 -> 174
    //   18: new 110	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 373
    //   28: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_1
    //   32: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_3
    //   40: aload_2
    //   41: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 66	wm:d	Landroid/content/Context;
    //   52: invokevirtual 380	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   55: getstatic 385	xg:a	Landroid/net/Uri;
    //   58: aconst_null
    //   59: ldc_w 543
    //   62: iconst_2
    //   63: anewarray 78	java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: getstatic 391	ash:b	Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: getstatic 391	ash:b	Ljava/lang/String;
    //   77: aastore
    //   78: aload_2
    //   79: invokevirtual 397	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore_2
    //   83: new 399	xh
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 402	xh:<init>	(Landroid/database/Cursor;)V
    //   91: astore 4
    //   93: new 50	java/util/ArrayList
    //   96: dup
    //   97: aload_2
    //   98: invokeinterface 407 1 0
    //   103: invokespecial 148	java/util/ArrayList:<init>	(I)V
    //   106: astore 5
    //   108: aload_2
    //   109: invokeinterface 410 1 0
    //   114: ifeq +93 -> 207
    //   117: aload_2
    //   118: aload 4
    //   120: getfield 412	xh:b	I
    //   123: invokeinterface 413 2 0
    //   128: invokestatic 417	android/content/ComponentName:unflattenFromString	(Ljava/lang/String;)Landroid/content/ComponentName;
    //   131: astore_3
    //   132: aload_0
    //   133: getfield 60	wm:h	Ljava/util/HashMap;
    //   136: aload_3
    //   137: invokevirtual 297	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: checkcast 160	wk
    //   143: astore_3
    //   144: aload_3
    //   145: ifnull +35 -> 180
    //   148: aload 5
    //   150: aload_3
    //   151: invokeinterface 176 2 0
    //   156: pop
    //   157: goto -49 -> 108
    //   160: astore_3
    //   161: aload_2
    //   162: invokestatic 547	arf:a	(Landroid/database/Cursor;)V
    //   165: new 50	java/util/ArrayList
    //   168: dup
    //   169: iconst_0
    //   170: invokespecial 148	java/util/ArrayList:<init>	(I)V
    //   173: areturn
    //   174: ldc 199
    //   176: astore_2
    //   177: goto -138 -> 39
    //   180: new 160	wk
    //   183: dup
    //   184: aload_2
    //   185: aload 4
    //   187: invokespecial 438	wk:<init>	(Landroid/database/Cursor;Lxh;)V
    //   190: astore_3
    //   191: goto -43 -> 148
    //   194: astore 4
    //   196: aload_2
    //   197: astore_3
    //   198: aload 4
    //   200: astore_2
    //   201: aload_3
    //   202: invokestatic 547	arf:a	(Landroid/database/Cursor;)V
    //   205: aload_2
    //   206: athrow
    //   207: aload_2
    //   208: invokestatic 547	arf:a	(Landroid/database/Cursor;)V
    //   211: aload 5
    //   213: areturn
    //   214: astore_2
    //   215: aconst_null
    //   216: astore_3
    //   217: goto -16 -> 201
    //   220: astore_2
    //   221: aconst_null
    //   222: astore_2
    //   223: goto -62 -> 161
    //
    // Exception table:
    //   from	to	target	type
    //   83	108	160	java/lang/Throwable
    //   108	144	160	java/lang/Throwable
    //   148	157	160	java/lang/Throwable
    //   180	191	160	java/lang/Throwable
    //   83	108	194	finally
    //   108	144	194	finally
    //   148	157	194	finally
    //   180	191	194	finally
    //   48	83	214	finally
    //   48	83	220	java/lang/Throwable
  }

  public void b(ComponentName paramComponentName)
  {
    if (!this.a.a(paramComponentName, new String[0]))
      return;
    wk localwk2 = a(paramComponentName);
    wk localwk1 = localwk2;
    if (localwk2 == null)
    {
      asp.b("Swipe.AppModel", "App info NOT found! Try looking up according to package name only: " + paramComponentName);
      localwk2 = a(paramComponentName.getPackageName());
      localwk1 = localwk2;
      if (localwk2 == null)
      {
        asp.b("Swipe.AppModel", "App info NOT found: " + paramComponentName);
        return;
      }
    }
    if (localwk1.a());
    while (true)
    {
      localwk1.e = System.currentTimeMillis();
      b(localwk1);
      return;
      localwk1.f += 1;
    }
  }

  protected void b(Context paramContext)
  {
    vg.b(paramContext);
    asp.a("Swipe.AppModel", "System locale changed");
    asq.a = Collator.getInstance();
    arj.a(new Runnable()
    {
      public void run()
      {
        asp.a("Swipe.AppModel", "Refreshing app labels...");
        alo.c();
        PackageManager localPackageManager = this.a.getPackageManager();
        while (true)
        {
          Object localObject3;
          int i;
          Object localObject4;
          synchronized (wm.e())
          {
            localObject3 = wm.b(wm.this).iterator();
            i = 0;
            if (((Iterator)localObject3).hasNext())
              localObject4 = (wk)((Iterator)localObject3).next();
          }
          try
          {
            ((wk)localObject4).a(localPackageManager, localPackageManager.getActivityInfo(((wk)localObject4).i, 0));
            wn.c(wm.a(wm.this), (wk)localObject4);
            label86: i += 1;
            continue;
            if (i == 0)
            {
              asp.a("Swipe.AppModel", "Locale changed but we don't have any applications loaded!");
              ??? = asq.x(wm.a(wm.this)).iterator();
              while (((Iterator)???).hasNext())
              {
                localObject3 = (ResolveInfo)((Iterator)???).next();
                localObject4 = asq.a((ResolveInfo)localObject3);
                wn.a(wm.a(wm.this), (ResolveInfo)localObject3, (ComponentName)localObject4);
                continue;
                localObject1 = finally;
                throw localObject1;
              }
              localObject3 = wm.this.a.a(wm.a(wm.this));
              ??? = new Intent();
              localObject3 = ((ArrayList)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (ComponentName)((Iterator)localObject3).next();
                ((Intent)???).setComponent((ComponentName)localObject4);
                ResolveInfo localResolveInfo = localObject1.resolveActivity((Intent)???, 0);
                if (localResolveInfo != null)
                  wn.a(wm.a(wm.this), localResolveInfo, (ComponentName)localObject4);
              }
            }
            return;
          }
          catch (Exception localException)
          {
            break label86;
          }
        }
      }
    });
  }

  protected void b(Intent paramIntent, final String paramString)
  {
    paramIntent = paramIntent.getStringArrayExtra("android.intent.extra.changed_package_list");
    if (paramString.equals("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE"));
    for (int i = 1; ; i = -1)
    {
      paramString = new ContentValues(1);
      paramString.put("on_sdcard", Integer.valueOf(i));
      int j = paramIntent.length;
      i = 0;
      while (i < j)
      {
        arj.a(new Runnable()
        {
          // ERROR //
          public void run()
          {
            // Byte code:
            //   0: aconst_null
            //   1: astore_1
            //   2: iconst_1
            //   3: anewarray 33	java/lang/String
            //   6: astore_2
            //   7: aload_2
            //   8: iconst_0
            //   9: aload_0
            //   10: getfield 22	wm$8:a	Ljava/lang/String;
            //   13: aastore
            //   14: aload_0
            //   15: getfield 20	wm$8:c	Lwm;
            //   18: invokestatic 36	wm:a	(Lwm;)Landroid/content/Context;
            //   21: invokevirtual 42	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
            //   24: getstatic 47	xg:a	Landroid/net/Uri;
            //   27: aload_0
            //   28: getfield 24	wm$8:b	Landroid/content/ContentValues;
            //   31: ldc 49
            //   33: aload_2
            //   34: invokevirtual 55	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
            //   37: pop
            //   38: aload_0
            //   39: getfield 20	wm$8:c	Lwm;
            //   42: invokestatic 36	wm:a	(Lwm;)Landroid/content/Context;
            //   45: invokevirtual 42	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
            //   48: getstatic 47	xg:a	Landroid/net/Uri;
            //   51: aconst_null
            //   52: ldc 49
            //   54: aload_2
            //   55: aconst_null
            //   56: invokevirtual 59	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
            //   59: astore_2
            //   60: aload_2
            //   61: astore_1
            //   62: new 61	xh
            //   65: dup
            //   66: aload_1
            //   67: invokespecial 64	xh:<init>	(Landroid/database/Cursor;)V
            //   70: astore_3
            //   71: aload_1
            //   72: invokeinterface 70 1 0
            //   77: ifeq +104 -> 181
            //   80: aload_0
            //   81: getfield 20	wm$8:c	Lwm;
            //   84: aload_1
            //   85: aload_3
            //   86: getfield 73	xh:b	I
            //   89: invokeinterface 77 2 0
            //   94: invokestatic 83	android/content/ComponentName:unflattenFromString	(Ljava/lang/String;)Landroid/content/ComponentName;
            //   97: invokevirtual 86	wm:a	(Landroid/content/ComponentName;)Lwk;
            //   100: astore_2
            //   101: aload_2
            //   102: ifnull +41 -> 143
            //   105: aload_2
            //   106: aload_1
            //   107: aload_3
            //   108: getfield 89	xh:f	I
            //   111: invokeinterface 93 2 0
            //   116: putfield 98	wk:k	I
            //   119: aload_0
            //   120: getfield 20	wm$8:c	Lwm;
            //   123: aload_2
            //   124: iconst_1
            //   125: invokevirtual 101	wm:a	(Lwk;Z)V
            //   128: goto -57 -> 71
            //   131: astore_2
            //   132: aload_1
            //   133: ifnull +9 -> 142
            //   136: aload_1
            //   137: invokeinterface 104 1 0
            //   142: return
            //   143: new 95	wk
            //   146: dup
            //   147: aload_1
            //   148: aload_3
            //   149: invokespecial 107	wk:<init>	(Landroid/database/Cursor;Lxh;)V
            //   152: astore_2
            //   153: aload_2
            //   154: aload_0
            //   155: getfield 20	wm$8:c	Lwm;
            //   158: invokestatic 36	wm:a	(Lwm;)Landroid/content/Context;
            //   161: iconst_0
            //   162: invokevirtual 110	wk:a	(Landroid/content/Context;Z)V
            //   165: goto -46 -> 119
            //   168: astore_2
            //   169: aload_1
            //   170: ifnull +9 -> 179
            //   173: aload_1
            //   174: invokeinterface 104 1 0
            //   179: aload_2
            //   180: athrow
            //   181: aload_1
            //   182: ifnull -40 -> 142
            //   185: aload_1
            //   186: invokeinterface 104 1 0
            //   191: return
            //   192: astore_2
            //   193: goto -24 -> 169
            //   196: astore_1
            //   197: aconst_null
            //   198: astore_1
            //   199: goto -67 -> 132
            //   202: astore_3
            //   203: goto -165 -> 38
            //
            // Exception table:
            //   from	to	target	type
            //   62	71	131	java/lang/Throwable
            //   71	101	131	java/lang/Throwable
            //   105	119	131	java/lang/Throwable
            //   119	128	131	java/lang/Throwable
            //   143	165	131	java/lang/Throwable
            //   62	71	168	finally
            //   71	101	168	finally
            //   105	119	168	finally
            //   119	128	168	finally
            //   143	165	168	finally
            //   38	60	192	finally
            //   38	60	196	java/lang/Throwable
            //   14	38	202	java/lang/Throwable
          }
        });
        i += 1;
      }
    }
  }

  public void b(wk paramwk)
  {
    b(paramwk, null);
  }

  public void b(final wk paramwk, final Runnable paramRunnable)
  {
    arj.a(new Runnable()
    {
      public void run()
      {
        wn.d(wm.a(wm.this), paramwk);
        if (paramRunnable != null)
          paramRunnable.run();
      }
    });
  }

  public ArrayList<wk> c()
  {
    synchronized (e)
    {
      ArrayList localArrayList = new ArrayList(this.g);
      return localArrayList;
    }
  }

  public void c(wk paramwk)
  {
    wn.d(this.d, paramwk);
  }

  public void d()
  {
    new Thread(new wl(this.d, this)).start();
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -19011148:
    case -1338021860:
    case -1403934493:
    case 1544582882:
    case 525384130:
    case -810471698:
    }
    while (true)
      switch (i)
      {
      default:
        return;
        if (str.equals("android.intent.action.LOCALE_CHANGED"))
        {
          i = 0;
          continue;
          if (str.equals("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE"))
          {
            i = 1;
            continue;
            if (str.equals("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE"))
            {
              i = 2;
              continue;
              if (str.equals("android.intent.action.PACKAGE_ADDED"))
              {
                i = 3;
                continue;
                if (str.equals("android.intent.action.PACKAGE_REMOVED"))
                {
                  i = 4;
                  continue;
                  if (str.equals("android.intent.action.PACKAGE_REPLACED"))
                    i = 5;
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    b(paramContext);
    return;
    b(paramIntent, str);
    return;
    a(paramIntent, str);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wm
 * JD-Core Version:    0.6.2
 */