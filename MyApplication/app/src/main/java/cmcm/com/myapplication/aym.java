package cmcm.com.myapplication;

import java.util.List;

class aym
{
  final ayn a;

  public aym(ayn paramayn)
  {
    this.a = paramayn;
  }

  private void a(List<aya> paramList, int paramInt1, int paramInt2)
  {
    aya localaya1 = (aya)paramList.get(paramInt1);
    aya localaya2 = (aya)paramList.get(paramInt2);
    switch (localaya2.a)
    {
    default:
      return;
    case 1:
      a(paramList, paramInt1, localaya1, paramInt2, localaya2);
      return;
    case 0:
      c(paramList, paramInt1, localaya1, paramInt2, localaya2);
      return;
    case 2:
    }
    b(paramList, paramInt1, localaya1, paramInt2, localaya2);
  }

  private int b(List<aya> paramList)
  {
    int i = 0;
    int j = paramList.size() - 1;
    if (j >= 0)
    {
      if (((aya)paramList.get(j)).a == 3)
      {
        if (i == 0)
          break label49;
        return j;
      }
      i = 1;
    }
    label49: 
    while (true)
    {
      j -= 1;
      break;
      return -1;
    }
  }

  private void c(List<aya> paramList, int paramInt1, aya paramaya1, int paramInt2, aya paramaya2)
  {
    int i = 0;
    if (paramaya1.c < paramaya2.b)
      i = -1;
    int j = i;
    if (paramaya1.b < paramaya2.b)
      j = i + 1;
    if (paramaya2.b <= paramaya1.b)
      paramaya1.b += paramaya2.c;
    if (paramaya2.b <= paramaya1.c)
      paramaya1.c += paramaya2.c;
    paramaya2.b = (j + paramaya2.b);
    paramList.set(paramInt1, paramaya2);
    paramList.set(paramInt2, paramaya1);
  }

  void a(List<aya> paramList)
  {
    while (true)
    {
      int i = b(paramList);
      if (i == -1)
        break;
      a(paramList, i, i + 1);
    }
  }

  void a(List<aya> paramList, int paramInt1, aya paramaya1, int paramInt2, aya paramaya2)
  {
    int j = 0;
    int i;
    if (paramaya1.b < paramaya1.c)
    {
      if ((paramaya2.b != paramaya1.b) || (paramaya2.c != paramaya1.c - paramaya1.b))
        break label622;
      i = 1;
    }
    while (true)
    {
      label70: aya localaya;
      if (paramaya1.c < paramaya2.b)
      {
        paramaya2.b -= 1;
        if (paramaya1.b > paramaya2.b)
          break label241;
        paramaya2.b += 1;
        localaya = null;
      }
      while (true)
      {
        label97: if (i != 0)
        {
          paramList.set(paramInt1, paramaya2);
          paramList.remove(paramInt2);
          this.a.a(paramaya1);
        }
        label595: label605: 
        while (true)
        {
          return;
          if ((paramaya2.b != paramaya1.c + 1) || (paramaya2.c != paramaya1.b - paramaya1.c))
            break label613;
          j = 1;
          i = 1;
          break;
          if (paramaya1.c >= paramaya2.b + paramaya2.c)
            break label70;
          paramaya2.c -= 1;
          paramaya1.a = 1;
          paramaya1.c = 1;
          if (paramaya2.c == 0)
          {
            paramList.remove(paramInt2);
            this.a.a(paramaya2);
            return;
            label241: if (paramaya1.b >= paramaya2.b + paramaya2.c)
              break label607;
            int k = paramaya2.b;
            int m = paramaya2.c;
            int n = paramaya1.b;
            localaya = this.a.a(1, paramaya1.b + 1, k + m - n);
            paramaya2.c = (paramaya1.b - paramaya2.b);
            break label97;
            if (j != 0)
            {
              if (localaya != null)
              {
                if (paramaya1.b > localaya.b)
                  paramaya1.b -= localaya.c;
                if (paramaya1.c > localaya.b)
                  paramaya1.c -= localaya.c;
              }
              if (paramaya1.b > paramaya2.b)
                paramaya1.b -= paramaya2.c;
              if (paramaya1.c > paramaya2.b)
                paramaya1.c -= paramaya2.c;
              paramList.set(paramInt1, paramaya2);
              if (paramaya1.b == paramaya1.c)
                break label595;
              paramList.set(paramInt2, paramaya1);
            }
            while (true)
            {
              if (localaya == null)
                break label605;
              paramList.add(paramInt1, localaya);
              return;
              if (localaya != null)
              {
                if (paramaya1.b >= localaya.b)
                  paramaya1.b -= localaya.c;
                if (paramaya1.c >= localaya.b)
                  paramaya1.c -= localaya.c;
              }
              if (paramaya1.b >= paramaya2.b)
                paramaya1.b -= paramaya2.c;
              if (paramaya1.c < paramaya2.b)
                break;
              paramaya1.c -= paramaya2.c;
              break;
              paramList.remove(paramInt2);
            }
          }
        }
        label607: localaya = null;
      }
      label613: i = 0;
      j = 1;
      continue;
      label622: i = 0;
    }
  }

  void b(List<aya> paramList, int paramInt1, aya paramaya1, int paramInt2, aya paramaya2)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramaya1.c < paramaya2.b)
    {
      paramaya2.b -= 1;
      localObject1 = null;
    }
    while (true)
    {
      if (paramaya1.b <= paramaya2.b)
      {
        paramaya2.b += 1;
        label54: paramList.set(paramInt2, paramaya1);
        if (paramaya2.c <= 0)
          break label233;
        paramList.set(paramInt1, paramaya2);
      }
      while (true)
      {
        if (localObject1 != null)
          paramList.add(paramInt1, localObject1);
        if (localObject2 != null)
          paramList.add(paramInt1, localObject2);
        return;
        if (paramaya1.c >= paramaya2.b + paramaya2.c)
          break label255;
        paramaya2.c -= 1;
        localObject1 = this.a.a(2, paramaya1.b, 1);
        break;
        if (paramaya1.b >= paramaya2.b + paramaya2.c)
          break label54;
        int i = paramaya2.b + paramaya2.c - paramaya1.b;
        localObject2 = this.a.a(2, paramaya1.b + 1, i);
        paramaya2.c -= i;
        break label54;
        label233: paramList.remove(paramInt1);
        this.a.a(paramaya2);
      }
      label255: localObject1 = null;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aym
 * JD-Core Version:    0.6.2
 */