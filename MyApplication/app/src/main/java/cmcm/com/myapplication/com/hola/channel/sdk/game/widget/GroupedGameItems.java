package cmcm.com.myapplication.com.hola.channel.sdk.game.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import qx;
import te;
import tf;

public class GroupedGameItems extends LinearLayout
  implements OnClickListener
{
  public ImageView[] a;
  public TextView[] b;
  private View[] c;

  public GroupedGameItems(Context paramContext)
  {
    super(paramContext);
  }

  public GroupedGameItems(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public GroupedGameItems(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public GroupedGameItems(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public static View a(Context paramContext)
  {
    paramContext = new Space(paramContext);
    paramContext.setLayoutParams(new AbsListView.LayoutParams(1, 0));
    return paramContext;
  }

  public static GroupedGameItems a(Context paramContext, ViewGroup paramViewGroup)
  {
    return (GroupedGameItems)qx.a(paramContext, tf.hola_game_list_item_grouped, paramViewGroup, false);
  }

  private void a()
  {
    View[] arrayOfView = this.c;
    int k = arrayOfView.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      View localView = arrayOfView[i];
      this.a[j] = ((ImageView)qx.a(localView, te.hg_icon));
      this.b[j] = ((TextView)qx.a(localView, te.hg_action));
      this.b[j].setOnClickListener(this);
      j += 1;
      i += 1;
    }
  }

  public static void a(View paramView)
  {
    paramView.getLayoutParams().height = 0;
  }

  public void a(Cursor paramCursor)
  {
    int k = Math.min(2, paramCursor.getCount() - 1);
    int i = 0;
    int j;
    while (true)
    {
      j = i;
      if (i > k)
        break;
      if (this.c[i].getVisibility() != 0)
        this.c[i].setVisibility(0);
      HorizontalGameItem.a(getContext(), this.a[i], this.b[i], paramCursor);
      paramCursor.moveToNext();
      i += 1;
    }
    while (j <= 2)
    {
      this.c[j].setVisibility(4);
      j += 1;
    }
  }

  public void onClick(View paramView)
  {
    HorizontalGameItem.a(getContext(), paramView);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = new View[3];
    this.a = new ImageView[3];
    this.b = new TextView[3];
    this.c[0] = qx.a(this, te.hg_item_0);
    this.c[1] = qx.a(this, te.hg_item_1);
    this.c[2] = qx.a(this, te.hg_item_2);
    a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.widget.GroupedGameItems
 * JD-Core Version:    0.6.2
 */