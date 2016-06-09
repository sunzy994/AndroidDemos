package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

class arn
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public int l = 0;
  public int m = 0;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public int q = 0;
  public int r = 0;
  public int s = 0;
  public int t = 0;
  public int u = 0;
  private int v = 0;
  private int w = 0;

  public arn(Context paramContext)
  {
    try
    {
      a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
    }
  }

  private void a(Context paramContext)
  {
    Object localObject1 = new ao(paramContext).a(2130903040).a("1").b("2").d("3").c("4");
    Object localObject2 = ((ao)localObject1).a();
    Object localObject3 = (ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(((Notification)localObject2).contentView.getLayoutId(), null);
    ((Notification)localObject2).contentView.reapply(paramContext, (View)localObject3);
    a((ViewGroup)localObject3);
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject2 = new an();
      ((an)localObject2).b("5");
      ((an)localObject2).a("6");
      ((an)localObject2).c("7");
      ((ao)localObject1).a("8");
      ((ao)localObject1).a((ba)localObject2);
      localObject2 = ((ao)localObject1).a();
      this.w = ((Notification)localObject2).bigContentView.getLayoutId();
      a(paramContext, (Notification)localObject2);
      localObject2 = new aq();
      localObject3 = new String[10];
      localObject3[0] = "10";
      localObject3[1] = "11";
      localObject3[2] = "12";
      localObject3[3] = "13";
      localObject3[4] = "14";
      localObject3[5] = "15";
      localObject3[6] = "16";
      localObject3[7] = "17";
      localObject3[8] = "18";
      localObject3[9] = "19";
      ((aq)localObject2).a("6");
      ((ao)localObject1).a("9");
      ((aq)localObject2).b("5");
      int i1 = 0;
      while (i1 < localObject3.length)
      {
        ((aq)localObject2).c(localObject3[i1]);
        i1 += 1;
      }
      ((ao)localObject1).a((ba)localObject2);
      localObject1 = ((ao)localObject1).a();
      this.v = ((Notification)localObject1).bigContentView.getLayoutId();
      a(paramContext, (Notification)localObject1);
    }
  }

  @TargetApi(16)
  private void a(Context paramContext, Notification paramNotification)
  {
    ViewGroup localViewGroup = (ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramNotification.bigContentView.getLayoutId(), null);
    paramNotification.bigContentView.reapply(paramContext, localViewGroup);
    a(localViewGroup);
  }

  private void a(ViewGroup paramViewGroup)
  {
    int i2 = 0;
    if (i2 < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i2);
      if ((localView instanceof ViewGroup))
        a((ViewGroup)localView);
      while (true)
      {
        i2 += 1;
        break;
        if ((localView instanceof TextView))
        {
          String str = ((TextView)localView).getText().toString();
          int i3 = localView.getId();
          int i1 = -1;
          switch (str.hashCode())
          {
          default:
          case 49:
          case 50:
          case 51:
          case 52:
          case 53:
          case 54:
          case 55:
          case 56:
          case 57:
          case 1567:
          case 1568:
          case 1569:
          case 1570:
          case 1571:
          case 1572:
          case 1573:
          case 1574:
          case 1575:
          case 1576:
          }
          while (true)
            switch (i1)
            {
            default:
              break;
            case 0:
              this.b = i3;
              break;
              if (str.equals("1"))
              {
                i1 = 0;
                continue;
                if (str.equals("2"))
                {
                  i1 = 1;
                  continue;
                  if (str.equals("3"))
                  {
                    i1 = 2;
                    continue;
                    if (str.equals("4"))
                    {
                      i1 = 3;
                      continue;
                      if (str.equals("5"))
                      {
                        i1 = 4;
                        continue;
                        if (str.equals("6"))
                        {
                          i1 = 5;
                          continue;
                          if (str.equals("7"))
                          {
                            i1 = 6;
                            continue;
                            if (str.equals("8"))
                            {
                              i1 = 7;
                              continue;
                              if (str.equals("9"))
                              {
                                i1 = 8;
                                continue;
                                if (str.equals("10"))
                                {
                                  i1 = 9;
                                  continue;
                                  if (str.equals("11"))
                                  {
                                    i1 = 10;
                                    continue;
                                    if (str.equals("12"))
                                    {
                                      i1 = 11;
                                      continue;
                                      if (str.equals("13"))
                                      {
                                        i1 = 12;
                                        continue;
                                        if (str.equals("14"))
                                        {
                                          i1 = 13;
                                          continue;
                                          if (str.equals("15"))
                                          {
                                            i1 = 14;
                                            continue;
                                            if (str.equals("16"))
                                            {
                                              i1 = 15;
                                              continue;
                                              if (str.equals("17"))
                                              {
                                                i1 = 16;
                                                continue;
                                                if (str.equals("18"))
                                                {
                                                  i1 = 17;
                                                  continue;
                                                  if (str.equals("19"))
                                                    i1 = 18;
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
              break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            }
          this.c = i3;
          continue;
          this.d = i3;
          continue;
          this.e = i3;
          continue;
          this.f = i3;
          continue;
          this.h = i3;
          continue;
          this.i = i3;
          continue;
          this.g = i3;
          continue;
          this.j = i3;
          continue;
          this.k = i3;
          continue;
          this.l = i3;
          continue;
          this.m = i3;
          continue;
          this.n = i3;
          continue;
          this.o = i3;
          continue;
          this.p = i3;
          continue;
          this.q = i3;
          continue;
          this.r = i3;
          continue;
          this.s = i3;
          continue;
          this.t = i3;
        }
        else if (((localView instanceof ImageView)) && (((ImageView)localView).getDrawable() != null))
        {
          this.a = localView.getId();
        }
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     arn
 * JD-Core Version:    0.6.2
 */