package cmcm.com.myapplication;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class azc
{
  private SparseArray<ArrayList<azl>> a = new SparseArray();
  private SparseIntArray b = new SparseIntArray();
  private int c = 0;

  private ArrayList<azl> b(int paramInt)
  {
    ArrayList localArrayList2 = (ArrayList)this.a.get(paramInt);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList2 = new ArrayList();
      this.a.put(paramInt, localArrayList2);
      localArrayList1 = localArrayList2;
      if (this.b.indexOfKey(paramInt) < 0)
      {
        this.b.put(paramInt, 5);
        localArrayList1 = localArrayList2;
      }
    }
    return localArrayList1;
  }

  public azl a(int paramInt)
  {
    ArrayList localArrayList = (ArrayList)this.a.get(paramInt);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      paramInt = localArrayList.size() - 1;
      azl localazl = (azl)localArrayList.get(paramInt);
      localArrayList.remove(paramInt);
      return localazl;
    }
    return null;
  }

  public void a()
  {
    this.a.clear();
  }

  void a(ayp paramayp)
  {
    this.c += 1;
  }

  void a(ayp paramayp1, ayp paramayp2, boolean paramBoolean)
  {
    if (paramayp1 != null)
      b();
    if ((!paramBoolean) && (this.c == 0))
      a();
    if (paramayp2 != null)
      a(paramayp2);
  }

  public void a(azl paramazl)
  {
    int i = paramazl.f();
    ArrayList localArrayList = b(i);
    if (this.b.get(i) <= localArrayList.size())
      return;
    paramazl.p();
    localArrayList.add(paramazl);
  }

  void b()
  {
    this.c -= 1;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azc
 * JD-Core Version:    0.6.2
 */