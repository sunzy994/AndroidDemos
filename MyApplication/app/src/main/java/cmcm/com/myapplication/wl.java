package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class wl
  implements Runnable
{
  private static final String[] e = { "com.android.contacts", "com.android.mms", "com.android.gallery3d", "com.android.gallery", "com.android.music", "com.google.android.music", "com.android.deskclock", "com.google.android.deskclock", "com.android.calculator2" };
  private final Context a;
  private final wm b;
  private final boolean c;
  private boolean d;

  public wl(Context paramContext, wm paramwm)
  {
    this(paramContext, paramwm, false);
  }

  public wl(Context paramContext, wm paramwm, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramwm;
    this.c = paramBoolean;
  }

  private int a(Set<String> paramSet)
  {
    System.currentTimeMillis();
    Object localObject1 = a(0, paramSet);
    Object localObject2 = a(1, paramSet);
    Object localObject3 = a(2, paramSet);
    String str1 = a(3, paramSet);
    String str2 = a(4, paramSet);
    List localList1 = b(0, paramSet);
    List localList2 = b(1, paramSet);
    List localList3 = b(2, paramSet);
    List localList4 = b(3, paramSet);
    List localList5 = b(4, paramSet);
    paramSet = new HashSet(8);
    a((String)localObject1, paramSet);
    a((String)localObject2, paramSet);
    a((String)localObject3, paramSet);
    a(str1, paramSet);
    a(str2, paramSet);
    a(localList1, paramSet, 4);
    a(localList2, paramSet, 1);
    a(localList3, paramSet, 1);
    a(localList4, paramSet, 1);
    a(localList5, paramSet, 1);
    localObject1 = new ContentValues(1);
    try
    {
      localObject2 = new StringBuilder();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        localObject3 = (String)paramSet.next();
        if (((StringBuilder)localObject2).length() > 0)
          ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("'").append((String)localObject3).append("'");
        localObject3 = this.b.a((String)localObject3);
        if (localObject3 != null)
          ((wk)localObject3).f = 20;
      }
    }
    catch (Throwable paramSet)
    {
      int i = 0;
      while (true)
      {
        int j = i;
        try
        {
          if (adc.a())
          {
            ((ContentValues)localObject1).put("called_num", Integer.valueOf(21));
            j = i;
            if (this.a.getContentResolver().update(xg.a, (ContentValues)localObject1, "intent=?", new String[] { adc.b().flattenToString() }) > 0)
            {
              paramSet = this.b.a(adc.b());
              if (paramSet != null)
                paramSet.f = 21;
              j = i + 1;
            }
          }
          return j;
          ((ContentValues)localObject1).put("called_num", Integer.valueOf(20));
          i = this.a.getContentResolver().update(xg.a, (ContentValues)localObject1, "package IN  (" + ((StringBuilder)localObject2).toString() + ")", null);
        }
        catch (Throwable paramSet)
        {
        }
      }
      return i;
    }
  }

  // ERROR //
  private String a(int paramInt, Set<String> paramSet)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 186	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   5: iload_1
    //   6: invokestatic 191	xf:a	(Ljava/util/Locale;I)Ljava/lang/String;
    //   9: astore 4
    //   11: aload_0
    //   12: getfield 49	wl:a	Landroid/content/Context;
    //   15: invokevirtual 146	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: getstatic 194	xb:a	Landroid/net/Uri;
    //   21: iconst_1
    //   22: anewarray 19	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 196
    //   29: aastore
    //   30: aload 4
    //   32: aconst_null
    //   33: ldc 198
    //   35: invokevirtual 202	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore 4
    //   40: aload 4
    //   42: astore_3
    //   43: aload_3
    //   44: ifnonnull +9 -> 53
    //   47: aload_3
    //   48: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   51: aconst_null
    //   52: areturn
    //   53: aload_3
    //   54: astore 4
    //   56: aload_3
    //   57: ldc 196
    //   59: invokeinterface 213 2 0
    //   64: istore_1
    //   65: aload_3
    //   66: astore 4
    //   68: aload_3
    //   69: invokeinterface 216 1 0
    //   74: ifeq +47 -> 121
    //   77: aload_3
    //   78: astore 4
    //   80: aload_3
    //   81: iload_1
    //   82: invokeinterface 220 2 0
    //   87: astore 5
    //   89: aload_3
    //   90: astore 4
    //   92: aload_2
    //   93: aload 5
    //   95: invokeinterface 224 2 0
    //   100: istore 6
    //   102: iload 6
    //   104: ifeq +12 -> 116
    //   107: aload 5
    //   109: astore_2
    //   110: aload_3
    //   111: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   114: aload_2
    //   115: areturn
    //   116: aconst_null
    //   117: astore_2
    //   118: goto -8 -> 110
    //   121: aload_3
    //   122: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_2
    //   128: aconst_null
    //   129: astore_3
    //   130: aload_3
    //   131: astore 4
    //   133: ldc 226
    //   135: ldc 228
    //   137: aload_2
    //   138: invokestatic 233	asp:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload_3
    //   142: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_2
    //   148: aload_3
    //   149: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   152: aload_2
    //   153: athrow
    //   154: astore_2
    //   155: aload 4
    //   157: astore_3
    //   158: goto -10 -> 148
    //   161: astore_2
    //   162: goto -32 -> 130
    //
    // Exception table:
    //   from	to	target	type
    //   2	40	127	java/lang/Throwable
    //   2	40	147	finally
    //   56	65	154	finally
    //   68	77	154	finally
    //   80	89	154	finally
    //   92	102	154	finally
    //   133	141	154	finally
    //   56	65	161	java/lang/Throwable
    //   68	77	161	java/lang/Throwable
    //   80	89	161	java/lang/Throwable
    //   92	102	161	java/lang/Throwable
  }

  private void a()
  {
    int i = 0;
    if (i < e.length)
    {
      wk localwk = this.b.a(e[i]);
      if ((localwk == null) || (localwk.f > 0));
      while (true)
      {
        i += 1;
        break;
        localwk.f = (10 - i);
        this.b.b(localwk);
      }
    }
  }

  private void a(String paramString, Set<String> paramSet)
  {
    if (paramString != null)
      paramSet.add(paramString);
  }

  private void a(List<String> paramList, Set<String> paramSet, int paramInt)
  {
    if ((paramList == null) || (paramSet == null));
    int i;
    label19: 
    do
    {
      return;
      paramList = paramList.iterator();
      i = 0;
      if (!paramList.hasNext())
        break;
      String str = (String)paramList.next();
      if (paramSet.contains(str))
        break label74;
      paramSet.add(str);
      i += 1;
    }
    while (i >= paramInt);
    label74: 
    while (true)
    {
      break label19;
      break;
    }
  }

  // ERROR //
  private List<String> b(int paramInt, Set<String> paramSet)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 4
    //   8: astore_3
    //   9: invokestatic 186	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   12: iload_1
    //   13: invokestatic 191	xf:a	(Ljava/util/Locale;I)Ljava/lang/String;
    //   16: astore 6
    //   18: aload 4
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 49	wl:a	Landroid/content/Context;
    //   25: invokevirtual 146	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: getstatic 246	xf:a	Landroid/net/Uri;
    //   31: iconst_1
    //   32: anewarray 19	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc 196
    //   39: aastore
    //   40: aload 6
    //   42: aconst_null
    //   43: aconst_null
    //   44: invokevirtual 202	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore 4
    //   49: aload 4
    //   51: ifnonnull +10 -> 61
    //   54: aload 4
    //   56: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   59: aconst_null
    //   60: areturn
    //   61: new 248	java/util/ArrayList
    //   64: dup
    //   65: aload 4
    //   67: invokeinterface 251 1 0
    //   72: invokespecial 252	java/util/ArrayList:<init>	(I)V
    //   75: astore_3
    //   76: aload 4
    //   78: ldc 196
    //   80: invokeinterface 213 2 0
    //   85: istore_1
    //   86: aload 4
    //   88: invokeinterface 216 1 0
    //   93: ifeq +73 -> 166
    //   96: aload 4
    //   98: iload_1
    //   99: invokeinterface 220 2 0
    //   104: astore 5
    //   106: aload_2
    //   107: aload 5
    //   109: invokeinterface 224 2 0
    //   114: ifeq -28 -> 86
    //   117: aload_3
    //   118: aload 5
    //   120: invokeinterface 253 2 0
    //   125: pop
    //   126: goto -40 -> 86
    //   129: astore_3
    //   130: aload 4
    //   132: astore_2
    //   133: aload_3
    //   134: astore 4
    //   136: aload_2
    //   137: astore_3
    //   138: ldc 226
    //   140: ldc 255
    //   142: aload 4
    //   144: invokestatic 233	asp:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   147: aload_2
    //   148: astore_3
    //   149: new 248	java/util/ArrayList
    //   152: dup
    //   153: iconst_0
    //   154: invokespecial 252	java/util/ArrayList:<init>	(I)V
    //   157: astore 4
    //   159: aload_2
    //   160: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   163: aload 4
    //   165: areturn
    //   166: aload 4
    //   168: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   171: aload_3
    //   172: areturn
    //   173: astore_2
    //   174: aload_3
    //   175: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   178: aload_2
    //   179: athrow
    //   180: astore_2
    //   181: aload 4
    //   183: astore_3
    //   184: goto -10 -> 174
    //   187: astore 4
    //   189: aload 5
    //   191: astore_2
    //   192: goto -56 -> 136
    //
    // Exception table:
    //   from	to	target	type
    //   61	86	129	java/lang/Throwable
    //   86	126	129	java/lang/Throwable
    //   9	18	173	finally
    //   21	49	173	finally
    //   138	147	173	finally
    //   149	159	173	finally
    //   61	86	180	finally
    //   86	126	180	finally
    //   9	18	187	java/lang/Throwable
    //   21	49	187	java/lang/Throwable
  }

  private void b()
  {
    Bundle localBundle = new Bundle(2);
    Set localSet = asq.b(this.a);
    localSet.remove("com.lazyswipe");
    int i = localSet.size();
    if (i > 0)
    {
      localBundle.putStringArray("extra_param_1", (String[])localSet.toArray(new String[i]));
      localBundle.putInt("extra_param_2", 1);
    }
    try
    {
      this.a.getContentResolver().call(xg.a, "initFavorites", null, localBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
      asp.b("Swipe.AppLoader", "Exception in method call of Provider", localThrowable);
    }
  }

  // ERROR //
  private Map<ComponentName, wk> c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 302	java/util/HashMap
    //   5: dup
    //   6: invokespecial 303	java/util/HashMap:<init>	()V
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 49	wl:a	Landroid/content/Context;
    //   14: invokevirtual 146	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: getstatic 151	xg:a	Landroid/net/Uri;
    //   20: aconst_null
    //   21: ldc_w 305
    //   24: iconst_1
    //   25: anewarray 19	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: getstatic 310	ash:b	Ljava/lang/String;
    //   33: aastore
    //   34: aconst_null
    //   35: invokevirtual 202	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: new 312	xh
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 314	xh:<init>	(Landroid/database/Cursor;)V
    //   49: astore_2
    //   50: aload_1
    //   51: invokeinterface 216 1 0
    //   56: ifeq +66 -> 122
    //   59: new 120	wk
    //   62: dup
    //   63: aload_1
    //   64: aload_2
    //   65: invokespecial 317	wk:<init>	(Landroid/database/Cursor;Lxh;)V
    //   68: astore 4
    //   70: aload_3
    //   71: aload 4
    //   73: getfield 321	wk:i	Landroid/content/ComponentName;
    //   76: aload 4
    //   78: invokeinterface 326 3 0
    //   83: pop
    //   84: getstatic 331	android/os/Build$VERSION:SDK_INT	I
    //   87: bipush 21
    //   89: if_icmplt -39 -> 50
    //   92: aload_0
    //   93: getfield 333	wl:d	Z
    //   96: ifne -46 -> 50
    //   99: aload 4
    //   101: getfield 124	wk:f	I
    //   104: ifle -54 -> 50
    //   107: aload_0
    //   108: iconst_1
    //   109: putfield 333	wl:d	Z
    //   112: goto -62 -> 50
    //   115: astore_2
    //   116: aload_1
    //   117: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   120: aload_3
    //   121: areturn
    //   122: aload_1
    //   123: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   126: aload_3
    //   127: areturn
    //   128: astore_2
    //   129: aload_1
    //   130: invokestatic 207	arf:a	(Landroid/database/Cursor;)V
    //   133: aload_2
    //   134: athrow
    //   135: astore_2
    //   136: goto -7 -> 129
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_1
    //   142: goto -26 -> 116
    //
    // Exception table:
    //   from	to	target	type
    //   41	50	115	java/lang/Exception
    //   50	112	115	java/lang/Exception
    //   10	39	128	finally
    //   41	50	135	finally
    //   50	112	135	finally
    //   10	39	139	java/lang/Exception
  }

  public void run()
  {
    this.b.c = true;
    Map localMap = c();
    if (localMap.size() <= 0);
    PackageManager localPackageManager;
    List localList;
    HashSet localHashSet;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ComponentName localComponentName;
    wk localwk;
    for (boolean bool = true; ; bool = false)
    {
      localPackageManager = this.a.getPackageManager();
      localList = asq.x(this.a);
      localHashSet = new HashSet(localList.size());
      localArrayList1 = new ArrayList(localList.size());
      localArrayList2 = new ArrayList(localList.size());
      localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ResolveInfo)((Iterator)localObject2).next();
        localComponentName = asq.a((ResolveInfo)localObject3);
        localHashSet.add(localComponentName.getPackageName());
        localwk = (wk)localMap.remove(localComponentName);
        localObject1 = localwk;
        if (localwk == null)
        {
          localObject1 = new wk();
          localArrayList1.add(localObject1);
          ((wk)localObject1).i = localComponentName;
        }
        ((wk)localObject1).j = asq.b((ResolveInfo)localObject3);
        ((wk)localObject1).a(localPackageManager, (ResolveInfo)localObject3, this.c);
        this.b.a((wk)localObject1);
      }
    }
    Object localObject2 = this.b.a.a(this.a);
    Object localObject3 = new Intent();
    int j = ((ArrayList)localObject2).size();
    int i = 0;
    while (i < j)
    {
      localComponentName = (ComponentName)((ArrayList)localObject2).get(i);
      ((Intent)localObject3).setComponent(localComponentName);
      ResolveInfo localResolveInfo = localPackageManager.resolveActivity((Intent)localObject3, 0);
      if (localResolveInfo != null)
      {
        localHashSet.add(localComponentName.getPackageName());
        localwk = (wk)localMap.remove(localComponentName);
        localObject1 = localwk;
        if (localwk == null)
        {
          localObject1 = new wk();
          localArrayList1.add(localObject1);
          ((wk)localObject1).i = localComponentName;
        }
        ((wk)localObject1).j = asq.b(localResolveInfo);
        ((wk)localObject1).a(localPackageManager, localResolveInfo, this.c);
        ((wk)localObject1).l = true;
        ((wk)localObject1).m = i;
        this.b.a((wk)localObject1);
      }
      i += 1;
    }
    this.b.b = true;
    this.b.c = false;
    aft.c();
    aft.a(bool, new ArrayList(localArrayList1));
    localArrayList2.addAll(localMap.values());
    Object localObject1 = localArrayList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localwk = (wk)((Iterator)localObject1).next();
      wn.b(this.a, localwk);
      if ((localwk.k == 0) && (localwk.i != null) && ("com.lazyswipe.pro2".equals(localwk.i.getPackageName())))
        apz.c(this.a);
    }
    localObject1 = localArrayList1.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localwk = (wk)((Iterator)localObject1).next();
      wn.a(this.a, localwk);
    }
    localMap.clear();
    localList.clear();
    localArrayList1.clear();
    localArrayList2.clear();
    if (bool)
    {
      a(localHashSet);
      b();
      a();
      wt.a();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wl
 * JD-Core Version:    0.6.2
 */