package cmcm.com.myapplication;

import java.io.File;
import java.io.FileOutputStream;

class ata
{
  int a = 0;
  int b = 0;
  String c;
  String d;
  int e = -1;
  File f;
  long g;
  String h;
  FileOutputStream i;
  long j = 0L;
  final atb k = new atb();
  ati l;

  String a()
  {
    return this.c;
  }

  void a(ati paramati)
  {
    this.b += 1;
    this.e = 2;
    this.l = paramati;
  }

  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.i == null)
    {
      if (!this.f.exists())
        this.f.createNewFile();
      this.i = new FileOutputStream(this.f, true);
    }
    this.i.write(paramArrayOfByte, 0, paramInt2);
    this.i.flush();
  }

  void b(ati paramati)
  {
    this.a += 1;
    this.e = 1;
    this.l = paramati;
  }

  boolean b()
  {
    return this.a > 3;
  }

  boolean c()
  {
    return this.b > 5;
  }

  void d()
  {
    this.e = 0;
  }

  boolean e()
  {
    return this.e == 0;
  }

  void f()
  {
    this.i.flush();
    this.i.close();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ata
 * JD-Core Version:    0.6.2
 */