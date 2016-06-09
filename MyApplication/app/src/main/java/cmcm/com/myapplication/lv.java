package cmcm.com.myapplication;

public enum lv
{
  static
  {
    a = new lv("Impression", 1);
    b = new lv("Click", 2);
    lv locallv = c;
    locallv = a;
    locallv = b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     lv
 * JD-Core Version:    0.6.2
 */