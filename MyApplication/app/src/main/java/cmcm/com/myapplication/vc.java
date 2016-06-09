package cmcm.com.myapplication;

import android.graphics.Path;
import android.util.Log;
import com.holaverse.charging.view.WaveView;
import java.util.ArrayList;
import java.util.List;

public final class vc
{
  private int a;
  private int b;
  private float c;
  private float d = 80.0F;
  private float e = 200.0F;
  private int f = 1;
  private List<vb> g;
  private Path h;

  public vc()
  {
    b();
  }

  private void b()
  {
    this.g = new ArrayList();
    this.h = new Path();
  }

  private void b(int paramInt)
  {
    this.h.reset();
    int i = this.g.size();
    if (i > 2)
    {
      vb localvb2 = (vb)this.g.get(0);
      vb localvb1 = null;
      this.h.moveTo(localvb2.a, localvb2.b);
      paramInt = 1;
      while (paramInt < i - 1)
      {
        vb localvb3 = (vb)this.g.get(paramInt);
        localvb1 = (vb)this.g.get(paramInt + 1);
        this.h.quadTo(localvb3.a, localvb3.b, localvb1.a, localvb1.b);
        paramInt += 2;
      }
      this.h.lineTo(localvb1.a, this.d / 2.0F);
      this.h.lineTo(localvb2.a, this.d / 2.0F);
      this.h.close();
    }
  }

  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wave size(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append("), mLevelLine=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mWaveWidth=" + this.e);
    localStringBuilder.append(", mWaveHeight=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", direct=");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }

  public void a(int paramInt)
  {
    if (this.d != paramInt)
      this.d = paramInt;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = 0.0F;
    this.e = this.a;
    paramInt2 = Math.round(this.a / this.e);
    float f2 = this.e / 4.0F;
    this.g.clear();
    paramInt1 = 0;
    if (paramInt1 < paramInt2 * 4 + 5)
    {
      float f3 = paramInt1;
      float f1;
      switch (paramInt1 % 4)
      {
      default:
        f1 = 0.0F;
      case 0:
      case 2:
      case 1:
      case 3:
      }
      while (true)
      {
        this.g.add(new vb(f3 * f2, f1));
        paramInt1 += 1;
        break;
        f1 = this.c;
        continue;
        f1 = this.c + this.d;
        continue;
        f1 = this.c - this.d;
      }
    }
    b(this.b);
    if (WaveView.c())
      Log.d("WaveView", a());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vc
 * JD-Core Version:    0.6.2
 */