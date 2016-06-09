package cmcm.com.myapplication.com.hola.channel.sdk.game.fragment;

import android.content.Context;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Space;
import com.hola.channel.pub.GamesActivity;
import com.hola.channel.sdk.game.app.CursorLoaderFragment;
import com.hola.channel.sdk.game.widget.AdView;
import com.hola.channel.sdk.game.widget.GroupedGameItems;
import com.hola.channel.sdk.game.widget.HorizontalGameItem;
import com.hola.channel.sdk.game.widget.OnlineLoadingView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import qs;
import qx;
import qy;
import rc;
import rd;
import re;
import rr;
import sq;
import tb;
import te;
import tf;

public class GameListFragment extends CursorLoaderFragment
  implements OnClickListener, re
{
  private static final String t = "GameSDK." + GameListFragment.class.getSimpleName();
  public int s;
  private int u;
  private List<WeakReference<rc>> v = new ArrayList(4);

  public static GameListFragment a(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 0)
      i = paramInt2 + 1000;
    while (true)
    {
      GameListFragment localGameListFragment = new GameListFragment();
      Bundle localBundle = new Bundle(1);
      localBundle.putInt("categoryId", i);
      localGameListFragment.setArguments(localBundle);
      return localGameListFragment;
      i = paramInt1;
      if (paramInt1 == 3)
        i = paramInt2 + 100;
    }
  }

  private int n()
  {
    int j = this.u;
    int i;
    if (j >= 1000)
      i = 0;
    do
    {
      return i;
      i = j;
    }
    while (j < 100);
    return 3;
  }

  private int o()
  {
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
    {
      rc localrc = (rc)((WeakReference)localIterator.next()).get();
      if ((localrc == null) || (localrc.isCancelled()) || (AsyncTask.Status.FINISHED == localrc.getStatus()))
        localIterator.remove();
    }
    return this.v.size();
  }

  private void p()
  {
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
    {
      rc localrc = (rc)((WeakReference)localIterator.next()).get();
      if ((localrc != null) && (!localrc.isCancelled()))
        localrc.cancel(true);
    }
    this.v.clear();
  }

  protected View a(int paramInt)
  {
    return new sq(getActivity());
  }

  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    switch (this.c.getItemViewType(paramCursor.getPosition()))
    {
    default:
      return GroupedGameItems.a(getActivity());
    case 0:
      return HorizontalGameItem.a(getActivity(), paramViewGroup);
    case 1:
    }
    paramCursor = GroupedGameItems.a(getActivity(), paramViewGroup);
    paramCursor.setPadding(paramCursor.getPaddingLeft(), paramCursor.getPaddingTop(), paramCursor.getPaddingRight(), paramCursor.getPaddingBottom() + qs.a(paramContext, 10.0F));
    return paramCursor;
  }

  protected rd a(int paramInt, Bundle paramBundle)
  {
    switch (n())
    {
    default:
      return new rd(getActivity(), "game_list/subject", "SELECT B._id, name, icon, brief, B.key, players, status, C.md5, CASE WHEN (B.md5)=(C.md5) THEN 1 ELSE 0 END AS md5_match , game_hide_down FROM game_list A LEFT JOIN game B ON A.key=B.key LEFT JOIN game_status C ON B.key=C.key WHERE A.list_type=? AND A.code=?", new String[] { String.valueOf(3), String.valueOf(this.u - 100) }, this);
    case 1:
      return new rd(getActivity(), "game_list/hot", "SELECT B._id, name, icon, brief, B.key, players, status, C.md5, CASE WHEN (B.md5)=(C.md5) THEN 1 ELSE 0 END AS md5_match , game_hide_down FROM game_list A LEFT JOIN game B ON A.key=B.key LEFT JOIN game_status C ON B.key=C.key WHERE A.list_type=?", new String[] { String.valueOf(1) }, this);
    case 2:
      return new rd(getActivity(), "game_list/new", "SELECT B._id, name, icon, brief, B.key, players, status, C.md5, CASE WHEN (B.md5)=(C.md5) THEN 1 ELSE 0 END AS md5_match , game_hide_down FROM game_list A LEFT JOIN game B ON A.key=B.key LEFT JOIN game_status C ON B.key=C.key WHERE A.list_type=?", new String[] { String.valueOf(2) }, this);
    case 0:
    }
    return new rd(getActivity(), "game_list/category", "SELECT B._id, name, icon, brief, B.key, players, status, C.md5, CASE WHEN (B.md5)=(C.md5) THEN 1 ELSE 0 END AS md5_match , game_hide_down FROM game_list A LEFT JOIN game B ON A.key=B.key LEFT JOIN game_status C ON B.key=C.key WHERE A.list_type=? AND A.code=?", new String[] { String.valueOf(0), String.valueOf(this.u - 1000) }, this);
  }

  public void a()
  {
    p();
    switch (n())
    {
    default:
      return;
    case 1:
      rc.b(getActivity());
      return;
    case 2:
      rc.a(getActivity());
      return;
    case 0:
    }
    this.v.add(new WeakReference(rc.d(getActivity(), this.u - 1000)));
  }

  public void a(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    super.a(paramLoader, paramCursor);
    int j = o();
    if (paramCursor == null);
    for (int i = 0; ; i = paramCursor.getCount())
    {
      if (this.u >= 1000)
      {
        this.s = (i / 10);
        if (i % 10 > 2)
          this.s += 1;
      }
      if ((getActivity() instanceof GamesActivity))
      {
        if (i > 0)
          break label99;
        if (j > 0)
          break;
        this.l.c();
      }
      return;
    }
    this.l.a();
    return;
    label99: this.l.f();
  }

  protected void a(Cursor paramCursor)
  {
  }

  protected void a(Bundle paramBundle, int paramInt)
  {
    super.a(paramBundle, paramInt);
    if (paramBundle != null)
    {
      this.u = paramBundle.getInt("categoryId", this.u);
      if (1 == paramInt)
        break label30;
    }
    label30: long l;
    do
    {
      return;
      l = qy.a(getActivity()).getLong(String.format(Locale.US, "key_list_updated_%1$d", new Object[] { Integer.valueOf(this.u) }), 0L);
    }
    while (System.currentTimeMillis() - l <= 86400000L);
    switch (n())
    {
    default:
      rc.a(getActivity(), this.u - 100);
      return;
    case 1:
      rc.b(getActivity());
      return;
    case 2:
      rc.a(getActivity());
      return;
    case 0:
    }
    this.v.add(new WeakReference(rc.d(getActivity(), this.u - 1000)));
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = new FrameLayout(getActivity());
    paramView.addView(new Space(getActivity()), 1, qs.a(getActivity(), 13.3F));
    this.d.addHeaderView(paramView);
    this.r = new FrameLayout(getActivity());
    this.d.addHeaderView(this.r);
    if ((this.p > 0) && (this.o) && (this.q != null))
    {
      if (this.q.getParent() != null)
        ((ViewGroup)this.q.getParent()).removeView(this.q);
      this.r.addView(this.q);
    }
  }

  public void a(View paramView, Context paramContext, Cursor paramCursor)
  {
    if ((paramView instanceof HorizontalGameItem))
    {
      ((HorizontalGameItem)paramView).a(paramCursor);
      return;
    }
    if ((paramView instanceof GroupedGameItems))
    {
      ((GroupedGameItems)paramView).a(paramCursor);
      return;
    }
    GroupedGameItems.a(paramView);
  }

  protected void a(boolean paramBoolean)
  {
    if (this.n)
    {
      if (this.q == null)
      {
        this.q = ((AdView)qx.a(getActivity(), tf.hola_game_list_item_ad, this.d, false));
        this.p = this.q.getAdHeight();
      }
      if (paramBoolean)
      {
        if (this.q.getParent() != null)
          ((ViewGroup)this.q.getParent()).removeView(this.q);
        this.r.addView(this.q);
        if (!this.o)
        {
          this.q.a(this.m);
          this.q.a();
          this.o = true;
        }
      }
    }
  }

  public void a_()
  {
  }

  protected int b()
  {
    return tf.hola_game_fragment_game_list;
  }

  protected int b(Cursor paramCursor)
  {
    return qy.a(getActivity()).getInt(String.format(Locale.US, "key_list_page_count_%1$d", new Object[] { Integer.valueOf(this.u) }), 0);
  }

  protected int c(Cursor paramCursor)
  {
    int j = qy.a(getActivity()).getInt(String.format(Locale.US, "key_list_page_no_%1$d", new Object[] { Integer.valueOf(this.u) }), 0);
    int i = j;
    if (j == 0)
      i = (int)Math.ceil(paramCursor.getCount() * 1.0F / this.g);
    return i;
  }

  protected ListAdapter d()
  {
    rr localrr = new rr(this, getActivity(), null);
    this.c = localrr;
    return localrr;
  }

  protected boolean f()
  {
    return true;
  }

  protected void g()
  {
    super.g();
    int i = this.h + 1;
    switch (n())
    {
    default:
      rc.a(getActivity(), this.u - 100, i);
      return;
    case 1:
      rc.c(getActivity(), i);
      return;
    case 2:
      rc.b(getActivity(), i);
      return;
    case 0:
    }
    this.v.add(new WeakReference(rc.b(getActivity(), this.u - 1000, i)));
  }

  protected int h()
  {
    return this.u + 5000;
  }

  protected int i()
  {
    return 1;
  }

  protected void k()
  {
    this.e.setColorSchemeResources(new int[] { tb.hola_game_loading_progress_color_0, tb.hola_game_loading_progress_color_1, tb.hola_game_loading_progress_color_2, tb.hola_game_loading_progress_color_3 });
  }

  protected boolean l()
  {
    return this.u >= 1000;
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (te.hg_action == i)
      HorizontalGameItem.a(getActivity(), paramView);
  }

  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
    {
      rc localrc = (rc)((WeakReference)localIterator.next()).get();
      if ((localrc != null) && (AsyncTask.Status.FINISHED != localrc.getStatus()))
        localrc.cancel(true);
    }
    this.v.clear();
  }

  public void onResume()
  {
    super.onResume();
    this.c.notifyDataSetChanged();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("categoryId", this.u);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.fragment.GameListFragment
 * JD-Core Version:    0.6.2
 */