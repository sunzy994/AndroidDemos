package cmcm.com.myapplication;

import android.database.Observable;
import java.util.ArrayList;

public class ayq extends Observable<ayr>
{
  public void a()
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((ayr)this.mObservers.get(i)).a();
      i -= 1;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ayq
 * JD-Core Version:    0.6.2
 */