package cmcm.com.myapplication.com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class dt<T>
{
  private final List<WeakReference<T>> a = new LinkedList();

  public List<T> a()
  {
    ArrayList localArrayList = new ArrayList(this.a.size());
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((WeakReference)localIterator.next()).get();
      if (localObject == null)
        localIterator.remove();
      else
        localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public void a(T paramT)
  {
    if (paramT == null)
      return;
    this.a.add(new WeakReference(paramT));
  }

  public int b()
  {
    return this.a.size();
  }

  public boolean b(T paramT)
  {
    if (paramT == null)
      return false;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((WeakReference)localIterator.next()).get();
      if (localObject == null)
      {
        localIterator.remove();
      }
      else if ((paramT == localObject) || (paramT.equals(localObject)))
      {
        localIterator.remove();
        return true;
      }
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dt
 * JD-Core Version:    0.6.2
 */