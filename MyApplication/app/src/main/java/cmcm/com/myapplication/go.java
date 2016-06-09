package cmcm.com.myapplication;

import android.view.View;
import android.view.ViewParent;

abstract interface go
{
  public abstract void a(ViewParent paramViewParent, View paramView);

  public abstract void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt);

  public abstract boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2);

  public abstract boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean);

  public abstract boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt);

  public abstract void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     go
 * JD-Core Version:    0.6.2
 */