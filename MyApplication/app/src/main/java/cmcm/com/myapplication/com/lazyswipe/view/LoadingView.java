package cmcm.com.myapplication.com.lazyswipe.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import ava;

public class LoadingView extends ImageView
{
  private ava a;

  public LoadingView(Context paramContext)
  {
    this(paramContext, null);
  }

  public LoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131427391);
  }

  public LoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = a(paramContext, paramAttributeSet, paramInt);
    setImageDrawable(this.a);
  }

  // ERROR //
  private ava a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: getstatic 34	vl:LoadingView	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 40	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore 4
    //   12: aload 4
    //   14: astore_2
    //   15: aload 4
    //   17: iconst_0
    //   18: invokevirtual 46	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   21: astore 5
    //   23: aload 4
    //   25: astore_2
    //   26: aload 4
    //   28: iconst_1
    //   29: iconst_0
    //   30: invokevirtual 50	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   33: istore_3
    //   34: aload 5
    //   36: ifnull +41 -> 77
    //   39: iload_3
    //   40: ifle +37 -> 77
    //   43: aload 4
    //   45: astore_2
    //   46: new 52	ava
    //   49: dup
    //   50: aload_1
    //   51: aload 5
    //   53: iload_3
    //   54: invokespecial 55	ava:<init>	(Landroid/content/Context;Landroid/graphics/drawable/Drawable;I)V
    //   57: astore 5
    //   59: aload 5
    //   61: astore_1
    //   62: aload 4
    //   64: ifnull +11 -> 75
    //   67: aload 4
    //   69: invokevirtual 59	android/content/res/TypedArray:recycle	()V
    //   72: aload 5
    //   74: astore_1
    //   75: aload_1
    //   76: areturn
    //   77: aload 4
    //   79: astore_2
    //   80: new 52	ava
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 61	ava:<init>	(Landroid/content/Context;)V
    //   88: astore 5
    //   90: aload 5
    //   92: astore_1
    //   93: aload 4
    //   95: ifnull -20 -> 75
    //   98: aload 4
    //   100: invokevirtual 59	android/content/res/TypedArray:recycle	()V
    //   103: aload 5
    //   105: areturn
    //   106: astore_2
    //   107: aconst_null
    //   108: astore 4
    //   110: aload 4
    //   112: astore_2
    //   113: new 52	ava
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 61	ava:<init>	(Landroid/content/Context;)V
    //   121: astore 5
    //   123: aload 5
    //   125: astore_1
    //   126: aload 4
    //   128: ifnull -53 -> 75
    //   131: aload 4
    //   133: invokevirtual 59	android/content/res/TypedArray:recycle	()V
    //   136: aload 5
    //   138: areturn
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 59	android/content/res/TypedArray:recycle	()V
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: goto -11 -> 142
    //   156: astore_2
    //   157: goto -47 -> 110
    //
    // Exception table:
    //   from	to	target	type
    //   0	12	106	java/lang/Exception
    //   0	12	139	finally
    //   15	23	152	finally
    //   26	34	152	finally
    //   46	59	152	finally
    //   80	90	152	finally
    //   113	123	152	finally
    //   15	23	156	java/lang/Exception
    //   26	34	156	java/lang/Exception
    //   46	59	156	java/lang/Exception
    //   80	90	156	java/lang/Exception
  }

  public void a()
  {
    if (this.a != null)
      this.a.start();
  }

  public void b()
  {
    if (this.a != null)
      this.a.stop();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (getVisibility() == 0)
      a();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }

  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0)
    {
      a();
      return;
    }
    b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.view.LoadingView
 * JD-Core Version:    0.6.2
 */