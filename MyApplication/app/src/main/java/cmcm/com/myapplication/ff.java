package cmcm.com.myapplication;

import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class ff extends fd
{
  static Field b;
  static boolean c = false;

  public void a(View paramView, dh paramdh)
  {
    if (paramdh == null);
    for (paramdh = null; ; paramdh = paramdh.a())
    {
      fr.a(paramView, paramdh);
      return;
    }
  }

  public boolean a(View paramView, int paramInt)
  {
    return fr.a(paramView, paramInt);
  }

  // ERROR //
  public boolean b(View paramView)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: getstatic 12	ff:c	Z
    //   5: ifeq +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: getstatic 36	ff:b	Ljava/lang/reflect/Field;
    //   13: ifnonnull +20 -> 33
    //   16: ldc 38
    //   18: ldc 40
    //   20: invokevirtual 46	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   23: putstatic 36	ff:b	Ljava/lang/reflect/Field;
    //   26: getstatic 36	ff:b	Ljava/lang/reflect/Field;
    //   29: iconst_1
    //   30: invokevirtual 52	java/lang/reflect/Field:setAccessible	(Z)V
    //   33: getstatic 36	ff:b	Ljava/lang/reflect/Field;
    //   36: aload_1
    //   37: invokevirtual 56	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +12 -> 54
    //   45: iload_2
    //   46: ireturn
    //   47: astore_1
    //   48: iconst_1
    //   49: putstatic 12	ff:c	Z
    //   52: iconst_0
    //   53: ireturn
    //   54: iconst_0
    //   55: istore_2
    //   56: goto -11 -> 45
    //   59: astore_1
    //   60: iconst_1
    //   61: putstatic 12	ff:c	Z
    //   64: iconst_0
    //   65: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   16	33	47	java/lang/Throwable
    //   33	41	59	java/lang/Throwable
  }

  public boolean b(View paramView, int paramInt)
  {
    return fr.b(paramView, paramInt);
  }

  public gt o(View paramView)
  {
    if (this.a == null)
      this.a = new WeakHashMap();
    gt localgt2 = (gt)this.a.get(paramView);
    gt localgt1 = localgt2;
    if (localgt2 == null)
    {
      localgt1 = new gt(paramView);
      this.a.put(paramView, localgt1);
    }
    return localgt1;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ff
 * JD-Core Version:    0.6.2
 */