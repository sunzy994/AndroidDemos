package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.hola.channel.pub.GamesActivity;
import com.hola.channel.sdk.game.activity.GameListActivity;
import com.hola.channel.sdk.game.app.CursorLoaderFragment;
import com.hola.channel.sdk.game.fragment.HotGamesFragment;
import com.hola.channel.sdk.game.fragment.NewGamesFragment;
import com.hola.channel.sdk.game.fragment.RecentGamesFragment;
import com.hola.channel.sdk.game.widget.GroupedGameItems;
import com.hola.channel.sdk.game.widget.HorizontalGameItem;

public abstract class rq extends CursorLoaderFragment
  implements OnClickListener, re
{
  protected static final String s = "GameSDK." + rq.class.getSimpleName();
  protected rs t;
  protected TextView u;
  protected View v;

  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    if (1 == n())
      return HorizontalGameItem.a(getActivity(), paramViewGroup);
    if (c(paramCursor.getPosition()) != 0)
      return GroupedGameItems.a(getActivity(), paramViewGroup);
    return GroupedGameItems.a(getActivity());
  }

  protected rd a(int paramInt, Bundle paramBundle)
  {
    return new rd(getActivity(), s(), t(), u(), this);
  }

  public void a()
  {
  }

  public void a(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    int i = 3;
    super.a(paramLoader, paramCursor);
    int j;
    if (paramCursor != null)
    {
      j = paramCursor.getCount();
      if (j > 0)
      {
        if (this.v == null)
        {
          p();
          if (Build.VERSION.SDK_INT <= 18)
            this.d.setAdapter(null);
          this.d.addHeaderView(this.v);
          if (Build.VERSION.SDK_INT <= 18)
            this.d.setAdapter(this.c);
        }
        this.t.a(this);
        if (o())
          if (j > 3)
          {
            this.u.setVisibility(0);
            k = this.v.getMeasuredHeight();
            j = k;
            if (k <= 0)
            {
              this.v.measure(0, 0);
              j = this.v.getMeasuredHeight();
            }
            paramLoader = this.c.getView(0, null, this.d);
            m = paramLoader.getMeasuredHeight();
            k = m;
            if (m <= 0)
            {
              paramLoader.measure(0, 0);
              k = paramLoader.getMeasuredHeight();
            }
            if (1 != n())
              i = 1;
            this.d.getLayoutParams().height = (i * k + j + this.d.getPaddingTop() + this.d.getPaddingBottom());
          }
      }
    }
    while (this.d.getHeaderViewsCount() <= 0)
      while (true)
      {
        int k;
        int m;
        return;
        this.u.setVisibility(4);
        i = j;
      }
    this.d.removeHeaderView(this.v);
  }

  protected void a(Cursor paramCursor)
  {
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    int j = this.d.getPaddingBottom();
    if ((this instanceof RecentGamesFragment));
    for (int i = qs.a(getActivity(), 10.0F); ; i = 0)
    {
      this.d.setPadding(this.d.getPaddingLeft(), 0, this.d.getPaddingRight(), j - i);
      return;
    }
  }

  public void a(View paramView, Context paramContext, Cursor paramCursor)
  {
    if (1 == n())
    {
      ((HorizontalGameItem)paramView).a(paramCursor);
      return;
    }
    if (1 == c(paramCursor.getPosition()))
    {
      ((GroupedGameItems)paramView).a(paramCursor);
      return;
    }
    GroupedGameItems.a(paramView);
  }

  public void a_()
  {
  }

  protected int b()
  {
    return tf.hola_game_list;
  }

  protected int b(Cursor paramCursor)
  {
    return 0;
  }

  public int c(int paramInt)
  {
    if (paramInt == 0)
      return 1;
    return 0;
  }

  protected int c(Cursor paramCursor)
  {
    return 0;
  }

  protected ListAdapter d()
  {
    // Byte code:
    //   0: new 10	rq$1
    //   3: dup
    //   4: aload_0
    //   5: aload_0
    //   6: invokevirtual 54	rq:getActivity	()Landroid/app/Activity;
    //   9: aconst_null
    //   10: aload_0
    //   11: invokevirtual 135	rq:o	()Z
    //   14: iconst_3
    //   15: invokespecial 220	rq$1:<init>	(Lrq;Landroid/content/Context;Landroid/database/Cursor;ZI)V
    //   18: astore_1
    //   19: aload_0
    //   20: aload_1
    //   21: putfield 124	rq:c	Landroid/widget/CursorAdapter;
    //   24: aload_1
    //   25: areturn
  }

  public int n()
  {
    return 2;
  }

  protected boolean o()
  {
    return true;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (!GamesActivity.class.isInstance(getActivity()))
      throw new RuntimeException("This fragment must be attached to GamesActivity!");
    this.t = ((rs)getActivity());
  }

  public void onClick(View paramView)
  {
    r();
  }

  public void onResume()
  {
    super.onResume();
    this.c.notifyDataSetChanged();
  }

  protected View p()
  {
    this.v = qx.a(getActivity(), tf.hola_game_child_fragment_header);
    ((TextView)qx.a(this.v, te.hg_recommended_child_header_title)).setText(v());
    if (o())
    {
      this.u = ((TextView)qx.a(this.v, te.hg_recommended_child_header_action));
      this.u.setOnClickListener(this);
    }
    return this.v;
  }

  public String q()
  {
    if (o());
    for (int i = 4; ; i = 3)
      return String.valueOf(i);
  }

  protected void r()
  {
    if (((this instanceof HotGamesFragment)) || ((this instanceof NewGamesFragment)))
    {
      startActivity(new Intent(getActivity(), GameListActivity.class).putExtra("extra.TYPE", h() - 1000));
      return;
    }
    startActivity(new Intent(getActivity(), GameListActivity.class).putExtra("extra.TYPE", 4));
  }

  public abstract String s();

  public abstract String t();

  public abstract String[] u();

  public abstract int v();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rq
 * JD-Core Version:    0.6.2
 */