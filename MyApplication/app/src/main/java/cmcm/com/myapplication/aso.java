package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;

public class aso
{
  private static Toast a;

  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, 0);
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, -1);
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramContext, paramInt1, paramInt2, paramInt3, false);
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i = 1;
    if ((aqs.P()) && (paramContext.getApplicationContext() == null))
      return;
    if ((a != null) && (!aqs.B()))
      a.cancel();
    Object localObject = paramContext.getApplicationContext();
    if (paramInt2 == 1)
    {
      paramInt2 = i;
      a = Toast.makeText((Context)localObject, paramInt1, paramInt2);
      b(paramContext, paramInt1);
      if (paramInt3 >= 0)
      {
        localObject = a;
        paramInt1 = a.getXOffset();
        if (paramInt4 <= 0)
          break label167;
      }
    }
    while (true)
    {
      ((Toast)localObject).setGravity(paramInt3, paramInt1, paramInt4);
      if ((!paramBoolean) || (!aqs.a()))
        break label178;
      paramInt1 = a.getYOffset();
      new tk(paramContext, 2131427336).a(a.getView()).a(0, 3).a(a.getGravity(), 0, paramInt1).b(2010).a(false).b();
      return;
      paramInt2 = 0;
      break;
      label167: paramInt4 = a.getYOffset();
    }
    label178: a.show();
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    a(paramContext, paramInt1, paramInt2, paramInt3, 0, paramBoolean);
  }

  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    a(paramContext, paramInt, 0, -1, paramBoolean);
  }

  // ERROR //
  private static void a(Context paramContext, CharSequence paramCharSequence)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 37
    //   4: ldc 105
    //   6: invokestatic 111	arp:c	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   9: astore_3
    //   10: aload_3
    //   11: iconst_1
    //   12: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   15: aload_3
    //   16: getstatic 32	aso:a	Landroid/widget/Toast;
    //   19: invokevirtual 121	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: astore 4
    //   24: aload_3
    //   25: iconst_0
    //   26: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   29: aload 4
    //   31: ifnull +39 -> 70
    //   34: aload 4
    //   36: invokevirtual 125	java/lang/Object:getClass	()Ljava/lang/Class;
    //   39: ldc 127
    //   41: invokestatic 111	arp:c	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   44: astore_3
    //   45: aload_3
    //   46: iconst_1
    //   47: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   50: aload_3
    //   51: aload 4
    //   53: invokevirtual 121	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: checkcast 129	android/view/WindowManager$LayoutParams
    //   59: sipush 2010
    //   62: putfield 133	android/view/WindowManager$LayoutParams:type	I
    //   65: aload_3
    //   66: iconst_0
    //   67: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   70: ldc 135
    //   72: invokestatic 141	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   75: ldc 143
    //   77: invokevirtual 147	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   80: aconst_null
    //   81: invokevirtual 121	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: invokevirtual 151	java/lang/Object:toString	()Ljava/lang/String;
    //   87: invokestatic 157	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   90: istore 5
    //   92: getstatic 32	aso:a	Landroid/widget/Toast;
    //   95: invokevirtual 71	android/widget/Toast:getView	()Landroid/view/View;
    //   98: iload 5
    //   100: invokevirtual 163	android/view/View:findViewById	(I)Landroid/view/View;
    //   103: checkcast 165	android/widget/TextView
    //   106: astore_3
    //   107: aload_3
    //   108: astore_2
    //   109: aload_2
    //   110: ifnull +89 -> 199
    //   113: aload_2
    //   114: invokevirtual 169	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   117: astore_3
    //   118: aload_2
    //   119: invokevirtual 173	android/widget/TextView:getTextColors	()Landroid/content/res/ColorStateList;
    //   122: astore 4
    //   124: getstatic 32	aso:a	Landroid/widget/Toast;
    //   127: invokevirtual 71	android/widget/Toast:getView	()Landroid/view/View;
    //   130: checkcast 175	android/view/ViewGroup
    //   133: aload_2
    //   134: invokevirtual 179	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   137: new 165	android/widget/TextView
    //   140: dup
    //   141: aload_0
    //   142: invokespecial 182	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   145: astore_0
    //   146: aload_0
    //   147: aload_2
    //   148: invokevirtual 183	android/widget/TextView:getGravity	()I
    //   151: invokevirtual 186	android/widget/TextView:setGravity	(I)V
    //   154: aload_0
    //   155: aload_2
    //   156: invokevirtual 189	android/widget/TextView:getPaddingLeft	()I
    //   159: aload_2
    //   160: invokevirtual 192	android/widget/TextView:getPaddingTop	()I
    //   163: aload_2
    //   164: invokevirtual 195	android/widget/TextView:getPaddingRight	()I
    //   167: aload_2
    //   168: invokevirtual 198	android/widget/TextView:getPaddingBottom	()I
    //   171: invokevirtual 202	android/widget/TextView:setPadding	(IIII)V
    //   174: getstatic 32	aso:a	Landroid/widget/Toast;
    //   177: invokevirtual 71	android/widget/Toast:getView	()Landroid/view/View;
    //   180: checkcast 175	android/view/ViewGroup
    //   183: aload_0
    //   184: aload_3
    //   185: invokevirtual 206	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   188: aload_0
    //   189: aload 4
    //   191: invokevirtual 210	android/widget/TextView:setTextColor	(Landroid/content/res/ColorStateList;)V
    //   194: aload_0
    //   195: aload_1
    //   196: invokevirtual 214	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   199: return
    //   200: astore 4
    //   202: aload_3
    //   203: iconst_0
    //   204: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   207: aload 4
    //   209: athrow
    //   210: astore 4
    //   212: aload_3
    //   213: iconst_0
    //   214: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   217: aload 4
    //   219: athrow
    //   220: astore_3
    //   221: goto -112 -> 109
    //   224: astore_3
    //   225: goto -155 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   10	24	200	finally
    //   45	65	210	finally
    //   70	107	220	java/lang/Exception
    //   2	10	224	java/lang/Throwable
    //   24	29	224	java/lang/Throwable
    //   34	45	224	java/lang/Throwable
    //   65	70	224	java/lang/Throwable
    //   202	210	224	java/lang/Throwable
    //   212	220	224	java/lang/Throwable
  }

  public static void a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    a(paramContext, paramCharSequence, paramInt, -1);
  }

  public static void a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    a(paramContext, paramCharSequence, paramInt1, paramInt2, 0, 0);
  }

  public static void a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    if ((aqs.P()) && (paramContext.getApplicationContext() == null))
      return;
    if ((a != null) && (!aqs.B()))
      a.cancel();
    Context localContext = paramContext.getApplicationContext();
    if (paramInt1 == 1);
    for (paramInt1 = i; ; paramInt1 = 0)
    {
      a = Toast.makeText(localContext, paramCharSequence, paramInt1);
      a(paramContext, paramCharSequence);
      if (paramInt2 >= 0)
        a.setGravity(paramInt2, paramInt3, paramInt4);
      a.show();
      return;
    }
  }

  public static void a(Context paramContext, String paramString)
  {
    if ((aqs.P()) && (paramContext.getApplicationContext() == null))
      return;
    if ((a != null) && (!aqs.B()))
      a.cancel();
    a = Toast.makeText(paramContext.getApplicationContext(), paramString, 0);
    a(paramContext, paramString);
    a.show();
  }

  private static void b(Context paramContext, int paramInt)
  {
    a(paramContext, paramContext.getResources().getText(paramInt));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aso
 * JD-Core Version:    0.6.2
 */