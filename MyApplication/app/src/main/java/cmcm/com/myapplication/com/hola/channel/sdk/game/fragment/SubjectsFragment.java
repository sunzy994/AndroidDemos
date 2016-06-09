package cmcm.com.myapplication.com.hola.channel.sdk.game.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.hola.channel.pub.GamesActivity;
import com.hola.channel.sdk.game.activity.GameListActivity;
import com.hola.channel.sdk.game.app.CursorLoaderFragment;
import com.hola.channel.sdk.game.widget.HorizontalGameItem;
import qs;
import qx;
import ra;
import rd;
import re;
import rs;
import ry;
import sa;
import tf;

public class SubjectsFragment extends CursorLoaderFragment
  implements OnClickListener, re
{
  public static final String[] s = { "_id", "code", "name", "banner" };
  private static final String u = "GameSDK." + SubjectsFragment.class.getSimpleName();
  protected rs t;
  private int v;
  private int w;
  private int x;

  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    if (c(paramCursor.getPosition()) == 0)
      return qx.a(paramContext, tf.hola_game_subject_games_group, paramViewGroup, false);
    return HorizontalGameItem.a(paramContext, paramViewGroup);
  }

  protected rd a(int paramInt, Bundle paramBundle)
  {
    return new rd(getActivity(), "game_list/subject", "SELECT B._id AS _id, B.name, B.icon, brief, B.key, players, status, C.md5, CASE WHEN (B.md5)=(C.md5) THEN 1 ELSE 0 END AS md5_match, F.name, F.banner, F.code FROM (SELECT * FROM game_list A WHERE A.list_type=3 AND (SELECT COUNT(*) FROM game_list D WHERE D.code=A.code AND D._id<=A._id AND D.list_type=3) <= 6) AS E  LEFT JOIN game B ON E.key=B.key LEFT JOIN game_status C ON B.key=C.key LEFT JOIN subject F ON F.code=E.code ORDER BY F.code, B._id", null, this);
  }

  public void a()
  {
  }

  public void a(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    int k = 0;
    super.a(paramLoader, paramCursor);
    int n;
    int i;
    if (paramCursor != null)
    {
      n = paramCursor.getCount();
      if (n > 0)
      {
        this.t.a(this);
        paramLoader = (ViewGroup)this.c.getView(0, null, this.d);
        i = paramLoader.getMeasuredHeight();
        if (i > 0)
          break label173;
        paramLoader.measure(0, 0);
        i = paramLoader.getChildAt(2).getMeasuredHeight();
      }
    }
    label173: 
    while (true)
    {
      int j = -1;
      while (paramCursor.moveToNext())
      {
        int m = paramCursor.getInt(11);
        if (m != j)
        {
          k += 1;
          j = m;
        }
      }
      this.d.getLayoutParams().height = (i * n + this.d.getPaddingTop() + this.d.getPaddingBottom() + k * (this.w + this.x) + qs.a(getActivity(), 20.0F));
      return;
    }
  }

  protected void a(Cursor paramCursor)
  {
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    this.d.setPadding(this.d.getPaddingLeft(), 0, this.d.getPaddingRight(), this.d.getPaddingBottom());
    paramView = getResources().getDisplayMetrics();
    this.v = paramView.widthPixels;
    this.w = ((int)(this.v * 0.5888889F));
    this.x = qs.a(paramView, 13.3F);
  }

  public void a(View paramView, Context paramContext, Cursor paramCursor)
  {
    if (1 == c(paramCursor.getPosition()))
    {
      ((HorizontalGameItem)paramView).a(paramCursor);
      return;
    }
    paramView = (ViewGroup)paramView;
    ((HorizontalGameItem)paramView.getChildAt(2)).a(paramCursor);
    paramView = (ImageView)paramView.getChildAt(0);
    paramView.getLayoutParams().width = this.v;
    paramView.getLayoutParams().height = this.w;
    paramView.setOnClickListener(this);
    paramView.setScaleType(ScaleType.CENTER_INSIDE);
    ry.a(this).a(paramCursor.getString(10)).a(this.v, this.w).a().a(paramView);
    paramView.setTag(paramCursor.getString(11) + "-" + paramCursor.getString(9));
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

  int c(int paramInt)
  {
    int i = 0;
    if (paramInt == 0)
      return 0;
    Cursor localCursor = (Cursor)this.c.getItem(paramInt);
    paramInt = localCursor.getInt(11);
    localCursor.moveToPrevious();
    if (localCursor.getInt(11) != paramInt);
    for (paramInt = i; ; paramInt = 1)
    {
      localCursor.moveToNext();
      return paramInt;
    }
  }

  protected int c(Cursor paramCursor)
  {
    return 0;
  }

  protected ListAdapter d()
  {
    // Byte code:
    //   0: new 10	com/hola/channel/sdk/game/fragment/SubjectsFragment$1
    //   3: dup
    //   4: aload_0
    //   5: aload_0
    //   6: invokevirtual 92	com/hola/channel/sdk/game/fragment/SubjectsFragment:getActivity	()Landroid/app/Activity;
    //   9: aconst_null
    //   10: invokespecial 282	com/hola/channel/sdk/game/fragment/SubjectsFragment$1:<init>	(Lcom/hola/channel/sdk/game/fragment/SubjectsFragment;Landroid/content/Context;Landroid/database/Cursor;)V
    //   13: astore_1
    //   14: aload_0
    //   15: aload_1
    //   16: putfield 115	com/hola/channel/sdk/game/fragment/SubjectsFragment:c	Landroid/widget/CursorAdapter;
    //   19: aload_1
    //   20: areturn
  }

  int n()
  {
    return 2;
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
    paramView = (String)paramView.getTag();
    if (TextUtils.isEmpty(paramView));
    int i;
    do
    {
      return;
      i = paramView.indexOf('-');
    }
    while (i <= 0);
    try
    {
      int j = Integer.parseInt(paramView.substring(0, i));
      paramView = paramView.substring(i + 1);
      startActivity(new Intent(getActivity(), GameListActivity.class).putExtra("extra.TYPE", 3).putExtra("extra.NAME", paramView).putExtra("extra.CODE", j));
      return;
    }
    catch (Throwable paramView)
    {
    }
  }

  public void onResume()
  {
    super.onResume();
    this.c.notifyDataSetChanged();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.fragment.SubjectsFragment
 * JD-Core Version:    0.6.2
 */