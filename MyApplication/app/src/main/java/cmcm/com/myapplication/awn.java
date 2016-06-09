package cmcm.com.myapplication;

import android.database.DataSetObserver;

class awn extends DataSetObserver
{
  private awn(awl paramawl)
  {
  }

  public void onChanged()
  {
    if (this.a.c())
      this.a.a();
  }

  public void onInvalidated()
  {
    this.a.b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     awn
 * JD-Core Version:    0.6.2
 */