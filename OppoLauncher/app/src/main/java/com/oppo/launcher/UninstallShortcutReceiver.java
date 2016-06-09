package com.oppo.launcher;

import android.content.BroadcastReceiver;

public class UninstallShortcutReceiver extends BroadcastReceiver
{
  private static final String ACTION_UNINSTALL_SHORTCUT = "com.oppo.launcher.action.UNINSTALL_SHORTCUT";
  private static final String TAG = "UninstallShortcutReceiver";

  // ERROR //
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 8
    //   2: aload_2
    //   3: invokevirtual 28	android/content/Intent:getAction	()Ljava/lang/String;
    //   6: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_2
    //   14: ldc 36
    //   16: invokevirtual 40	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   19: checkcast 24	android/content/Intent
    //   22: astore 6
    //   24: aload_2
    //   25: ldc 42
    //   27: invokevirtual 46	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 5
    //   32: aload_2
    //   33: ldc 48
    //   35: iconst_1
    //   36: invokevirtual 52	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   39: istore 12
    //   41: aload 6
    //   43: ifnull -31 -> 12
    //   46: aload 5
    //   48: ifnull -36 -> 12
    //   51: aload_1
    //   52: invokevirtual 58	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   55: astore 7
    //   57: aconst_null
    //   58: astore_3
    //   59: aconst_null
    //   60: astore_2
    //   61: iconst_0
    //   62: istore 10
    //   64: iconst_0
    //   65: istore 8
    //   67: iload 10
    //   69: istore 9
    //   71: aload 7
    //   73: getstatic 64	com/oppo/launcher/LauncherSettings$SingleDeskTopItems:CONTENT_URI	Landroid/net/Uri;
    //   76: iconst_2
    //   77: anewarray 30	java/lang/String
    //   80: dup
    //   81: iconst_0
    //   82: ldc 66
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: ldc 68
    //   89: aastore
    //   90: ldc 70
    //   92: iconst_1
    //   93: anewarray 30	java/lang/String
    //   96: dup
    //   97: iconst_0
    //   98: aload 5
    //   100: aastore
    //   101: aconst_null
    //   102: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   105: astore 4
    //   107: aload 4
    //   109: astore_2
    //   110: iload 10
    //   112: istore 9
    //   114: aload 4
    //   116: astore_3
    //   117: aload 4
    //   119: ldc 68
    //   121: invokeinterface 82 2 0
    //   126: istore 11
    //   128: aload 4
    //   130: astore_2
    //   131: iload 10
    //   133: istore 9
    //   135: aload 4
    //   137: astore_3
    //   138: aload 4
    //   140: ldc 66
    //   142: invokeinterface 82 2 0
    //   147: istore 10
    //   149: aload 4
    //   151: astore_2
    //   152: iload 8
    //   154: istore 9
    //   156: aload 4
    //   158: astore_3
    //   159: aload 4
    //   161: invokeinterface 86 1 0
    //   166: istore 13
    //   168: iload 8
    //   170: istore 9
    //   172: iload 13
    //   174: ifeq +76 -> 250
    //   177: aload 4
    //   179: astore_2
    //   180: iload 8
    //   182: istore 9
    //   184: aload 4
    //   186: astore_3
    //   187: aload 6
    //   189: aload 4
    //   191: iload 11
    //   193: invokeinterface 90 2 0
    //   198: iconst_0
    //   199: invokestatic 94	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   202: invokevirtual 98	android/content/Intent:filterEquals	(Landroid/content/Intent;)Z
    //   205: ifeq -56 -> 149
    //   208: aload 4
    //   210: astore_2
    //   211: iload 8
    //   213: istore 9
    //   215: aload 4
    //   217: astore_3
    //   218: aload 7
    //   220: aload 4
    //   222: iload 10
    //   224: invokeinterface 102 2 0
    //   229: iconst_0
    //   230: invokestatic 106	com/oppo/launcher/LauncherSettings$SingleDeskTopItems:getContentUri	(JZ)Landroid/net/Uri;
    //   233: aconst_null
    //   234: aconst_null
    //   235: invokevirtual 110	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   238: pop
    //   239: iconst_1
    //   240: istore 9
    //   242: iconst_1
    //   243: istore 8
    //   245: iload 12
    //   247: ifne -98 -> 149
    //   250: iload 9
    //   252: istore 8
    //   254: aload 4
    //   256: ifnull +14 -> 270
    //   259: aload 4
    //   261: invokeinterface 113 1 0
    //   266: iload 9
    //   268: istore 8
    //   270: iload 8
    //   272: ifeq -260 -> 12
    //   275: aload 7
    //   277: getstatic 64	com/oppo/launcher/LauncherSettings$SingleDeskTopItems:CONTENT_URI	Landroid/net/Uri;
    //   280: aconst_null
    //   281: invokevirtual 117	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   284: aload_1
    //   285: aload_1
    //   286: ldc 118
    //   288: iconst_1
    //   289: anewarray 120	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: aload 5
    //   296: aastore
    //   297: invokevirtual 123	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   300: iconst_0
    //   301: invokestatic 129	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   304: invokevirtual 132	android/widget/Toast:show	()V
    //   307: return
    //   308: astore 4
    //   310: aload_2
    //   311: astore_3
    //   312: ldc 11
    //   314: new 134	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   321: ldc 137
    //   323: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 4
    //   328: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 153	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   337: pop
    //   338: iload 9
    //   340: istore 8
    //   342: aload_2
    //   343: ifnull -73 -> 270
    //   346: aload_2
    //   347: invokeinterface 113 1 0
    //   352: iload 9
    //   354: istore 8
    //   356: goto -86 -> 270
    //   359: astore_1
    //   360: aload_3
    //   361: ifnull +9 -> 370
    //   364: aload_3
    //   365: invokeinterface 113 1 0
    //   370: aload_1
    //   371: athrow
    //   372: astore_2
    //   373: goto -224 -> 149
    //
    // Exception table:
    //   from	to	target	type
    //   71	107	308	java/lang/Exception
    //   117	128	308	java/lang/Exception
    //   138	149	308	java/lang/Exception
    //   159	168	308	java/lang/Exception
    //   187	208	308	java/lang/Exception
    //   218	239	308	java/lang/Exception
    //   71	107	359	finally
    //   117	128	359	finally
    //   138	149	359	finally
    //   159	168	359	finally
    //   187	208	359	finally
    //   218	239	359	finally
    //   312	338	359	finally
    //   187	208	372	java/net/URISyntaxException
    //   218	239	372	java/net/URISyntaxException
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.UninstallShortcutReceiver
 * JD-Core Version:    0.6.2
 */