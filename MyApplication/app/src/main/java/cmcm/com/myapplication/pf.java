package cmcm.com.myapplication;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.util.Log;
import com.hola.channel.pub.GamesActivity;
import com.hola.channel.sdk.game.fragment.GameListFragment;
import com.hola.channel.sdk.game.fragment.RecommendedFragment;
import com.hola.channel.sdk.game.widget.OnlineLoadingView;
import com.hola.channel.sdk.game.widget.TabLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class pf extends rb
  implements ph<List<pc>>, ro
{
  private final List<pc> b = new ArrayList(4);
  private boolean c;

  public pf(GamesActivity paramGamesActivity)
  {
    super(paramGamesActivity.getFragmentManager());
    rn.a(paramGamesActivity).a("category", new String[] { "code", "name" }, null, null, "code", this);
  }

  private void a(final List<pc> paramList, final boolean paramBoolean)
  {
    this.a.runOnUiThread(new Runnable()
    {
      public void run()
      {
        pf.this.a(paramList, paramBoolean, false);
      }
    });
  }

  public Fragment a(int paramInt)
  {
    Object localObject = (pc)this.b.get(paramInt);
    if (pc.c.equals(localObject))
    {
      localObject = RecommendedFragment.a();
      this.a.b = new WeakReference(localObject);
      return localObject;
    }
    return GameListFragment.a(0, ((pc)localObject).a);
  }

  public void a()
  {
  }

  public void a(List<pc> paramList)
  {
    qy.a(this.a).edit().putString("key_category_locale", Locale.getDefault().toString()).putLong("key_category_updated", System.currentTimeMillis()).apply();
    a(paramList, true, this.c);
  }

  void a(final List<pc> paramList, boolean paramBoolean1, final boolean paramBoolean2)
  {
    this.b.clear();
    this.b.addAll(paramList);
    if (paramBoolean1)
    {
      final rn localrn = rn.a(this.a);
      localrn.b(new Runnable()
      {
        public void run()
        {
          if (paramBoolean2)
            localrn.b("category");
          localrn.a(paramList);
        }
      });
    }
    if (!this.b.contains(pc.c))
    {
      pc.c.b = this.a.getString(tg.hola_game_recommended_title);
      this.b.add(0, pc.c);
    }
    notifyDataSetChanged();
    GamesActivity.a(this.a).setTabsFromPagerAdapter(this);
    if (this.b.size() <= 0)
    {
      this.a.a.c();
      return;
    }
    this.a.a.f();
  }

  public void a(pi parampi)
  {
    Log.w(GamesActivity.c(), "Could not fetch category list", parampi);
    if (this.b.size() <= 0)
      this.a.a.b();
  }

  public boolean a(Cursor paramCursor)
  {
    if ((paramCursor != null) && (paramCursor.moveToFirst()))
    {
      ArrayList localArrayList = new ArrayList(paramCursor.getCount());
      do
      {
        pc localpc = new pc();
        localpc.a = paramCursor.getInt(0);
        localpc.b = paramCursor.getString(1);
        localArrayList.add(localpc);
      }
      while (paramCursor.moveToNext());
      a(localArrayList, false);
      paramCursor = qy.a(this.a);
      long l = paramCursor.getLong("key_category_updated", 0L);
      if (l > 0L)
      {
        paramCursor = paramCursor.getString("key_category_locale", null);
        if (System.currentTimeMillis() - l <= 86400000L)
          break label147;
      }
      for (this.c = true; ; this.c = true)
        label147: 
        do
        {
          if (this.c)
            qz.a(this);
          return true;
        }
        while ((paramCursor == null) || (paramCursor.equals(Locale.getDefault().toString())));
    }
    this.a.runOnUiThread(new Runnable()
    {
      public void run()
      {
        pf.this.a.a.a();
      }
    });
    this.c = false;
    qz.a(this);
    return true;
  }

  public int getCount()
  {
    return this.b.size();
  }

  public CharSequence getPageTitle(int paramInt)
  {
    return ((pc)this.b.get(paramInt)).b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     pf
 * JD-Core Version:    0.6.2
 */