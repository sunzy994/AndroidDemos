package cmcm.com.myapplication;

class kh
{
  // ERROR //
  public static ki a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 16	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   3: invokestatic 19	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   6: if_acmpne +13 -> 19
    //   9: new 21	java/lang/IllegalStateException
    //   12: dup
    //   13: ldc 23
    //   15: invokespecial 27	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   18: athrow
    //   19: aload_0
    //   20: invokevirtual 33	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   23: ldc 35
    //   25: iconst_0
    //   26: invokevirtual 41	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   29: pop
    //   30: new 43	kj
    //   33: dup
    //   34: aconst_null
    //   35: invokespecial 46	kj:<init>	(Lkh$1;)V
    //   38: astore_1
    //   39: new 48	android/content/Intent
    //   42: dup
    //   43: ldc 50
    //   45: invokespecial 51	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   48: astore_2
    //   49: aload_2
    //   50: ldc 53
    //   52: invokevirtual 57	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   55: pop
    //   56: aload_0
    //   57: aload_2
    //   58: aload_1
    //   59: iconst_1
    //   60: invokevirtual 61	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   63: ifeq +53 -> 116
    //   66: new 63	kk
    //   69: dup
    //   70: aload_1
    //   71: invokevirtual 66	kj:a	()Landroid/os/IBinder;
    //   74: invokespecial 69	kk:<init>	(Landroid/os/IBinder;)V
    //   77: astore_2
    //   78: new 71	ki
    //   81: dup
    //   82: aload_2
    //   83: invokevirtual 74	kk:a	()Ljava/lang/String;
    //   86: aload_2
    //   87: iconst_1
    //   88: invokevirtual 77	kk:a	(Z)Z
    //   91: invokespecial 80	ki:<init>	(Ljava/lang/String;Z)V
    //   94: astore_2
    //   95: aload_0
    //   96: aload_1
    //   97: invokevirtual 84	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   100: aload_2
    //   101: areturn
    //   102: astore_0
    //   103: aload_0
    //   104: athrow
    //   105: astore_2
    //   106: aload_2
    //   107: athrow
    //   108: astore_2
    //   109: aload_0
    //   110: aload_1
    //   111: invokevirtual 84	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   114: aload_2
    //   115: athrow
    //   116: new 86	java/io/IOException
    //   119: dup
    //   120: ldc 88
    //   122: invokespecial 89	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   125: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   19	30	102	java/lang/Exception
    //   66	95	105	java/lang/Exception
    //   66	95	108	finally
    //   106	108	108	finally
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     kh
 * JD-Core Version:    0.6.2
 */