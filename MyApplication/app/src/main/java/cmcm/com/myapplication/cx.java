package cmcm.com.myapplication;

import java.util.Iterator;

final class cx<T>
  implements Iterator<T>
{
  final int a;
  int b;
  int c;
  boolean d = false;

  cx(cw paramcw, int paramInt)
  {
    this.a = paramInt;
    this.b = paramcw.a();
  }

  public boolean hasNext()
  {
    return this.c < this.b;
  }

  public T next()
  {
    Object localObject = this.e.a(this.c, this.a);
    this.c += 1;
    this.d = true;
    return localObject;
  }

  public void remove()
  {
    if (!this.d)
      throw new IllegalStateException();
    this.c -= 1;
    this.b -= 1;
    this.d = false;
    this.e.a(this.c);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     cx
 * JD-Core Version:    0.6.2
 */