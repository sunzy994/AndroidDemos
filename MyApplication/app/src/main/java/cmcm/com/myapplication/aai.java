package cmcm.com.myapplication;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aai extends aag
{
  private void b(SwipeApplication paramSwipeApplication)
  {
    Iterator localIterator = alw.a(paramSwipeApplication).iterator();
    List localList;
    if (localIterator.hasNext())
    {
      localObject = (alw)localIterator.next();
      localList = this.b;
      if (!((alw)localObject).a())
        break label78;
    }
    label78: for (Object localObject = new yz(paramSwipeApplication, (alw)localObject); ; localObject = new yv(paramSwipeApplication, (alw)localObject))
    {
      localList.add(localObject);
      if (this.b.size() < b(paramSwipeApplication))
        break;
      return;
    }
  }

  public String a(Context paramContext)
  {
    return paramContext.getString(2131231069);
  }

  protected void a(SwipeApplication paramSwipeApplication, String paramString)
  {
    b(paramSwipeApplication);
  }

  public void a(List<yw> paramList, int paramInt1, int paramInt2, xy paramxy)
  {
    if (!d());
    do
    {
      do
      {
        return;
        super.a(paramList, paramInt1, paramInt2, paramxy);
      }
      while (asq.a(paramList));
      final ContentResolver localContentResolver = SwipeApplication.c().getContentResolver();
      final ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      paramInt1 = 0;
      while (paramList.hasNext())
      {
        Object localObject = (yw)paramList.next();
        if ((localObject instanceof yv))
        {
          localObject = (yv)localObject;
          ContentValues localContentValues = new ContentValues(1);
          long l = ((yv)localObject).g().b;
          localContentValues.put("_order", Integer.valueOf(paramInt1));
          localArrayList.add(ContentProviderOperation.newUpdate(xc.a).withSelection("_id=?", new String[] { String.valueOf(l) }).withValues(localContentValues).withYieldAllowed(true).build());
          paramInt1 += 1;
        }
      }
      arj.a(new Runnable() {
        public void run() {
          try {
            localContentResolver.applyBatch("com.lazyswipe", localArrayList);
            alw.a(SwipeApplication.c(), true);
            return;
          } catch (Throwable localThrowable) {
            while (true)
              Log.w("Swipe.RecentsTab", "Failed to update contact orders", localThrowable);
          }
        }
      });
    }
    while (paramxy == null);
    paramxy.a(this.b);
  }

  public String b()
  {
    return "contact";
  }

  public int c()
  {
    return 6;
  }

  public boolean d()
  {
    return super.d();
  }

  public boolean e()
  {
    return super.e();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aai
 * JD-Core Version:    0.6.2
 */