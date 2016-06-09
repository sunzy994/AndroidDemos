package com.oppo.launcher.animation;

public class OppoUnitBezier
{
  private double ax;
  private double ay;
  private double bx;
  private double by;
  private double cx;
  private double cy;

  public OppoUnitBezier(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.cx = (3.0D * paramDouble1);
    this.bx = (3.0D * (paramDouble3 - paramDouble1) - this.cx);
    this.ax = (1.0D - this.cx - this.bx);
    this.cy = (3.0D * paramDouble2);
    this.by = (3.0D * (paramDouble4 - paramDouble2) - this.cy);
    this.ay = (1.0D - this.cy - this.by);
  }

  public double sampleCurveDerivativeX(double paramDouble)
  {
    return (3.0D * this.ax * paramDouble + 2.0D * this.bx) * paramDouble + this.cx;
  }

  public double sampleCurveX(double paramDouble)
  {
    return ((this.ax * paramDouble + this.bx) * paramDouble + this.cx) * paramDouble;
  }

  public double sampleCurveY(double paramDouble)
  {
    return ((this.ay * paramDouble + this.by) * paramDouble + this.cy) * paramDouble;
  }

  double solve(double paramDouble1, double paramDouble2)
  {
    return sampleCurveY(solveCurveX(paramDouble1, paramDouble2));
  }

  public double solveCurveX(double paramDouble1, double paramDouble2)
  {
    double d1 = paramDouble1;
    int i = 0;
    double d2;
    double d3;
    double d4;
    while (true)
    {
      if (i < 8)
      {
        d2 = sampleCurveX(d1) - paramDouble1;
        if (Math.abs(d2) >= paramDouble2);
      }
      do
      {
        return d1;
        d3 = sampleCurveDerivativeX(d1);
        if (Math.abs(d3) >= 1.0E-06D)
          break;
        d3 = 0.0D;
        d4 = 1.0D;
        d2 = paramDouble1;
        d1 = d3;
      }
      while (d2 < 0.0D);
      d1 = d2;
      if (d2 <= 1.0D)
        break;
      return 1.0D;
      d1 -= d2 / d3;
      i += 1;
    }
    if (paramDouble1 > d2)
      d3 = d1;
    while (true)
    {
      d1 = (d4 - d3) * 0.5D + d3;
      if (d3 >= d4)
        break label171;
      d2 = sampleCurveX(d1);
      if (Math.abs(d2 - paramDouble1) >= paramDouble2)
        break;
      return d1;
      d4 = d1;
    }
    label171: return d1;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.animation.OppoUnitBezier
 * JD-Core Version:    0.6.2
 */