package cmcm.com.myapplication;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class hu extends hw
{
  public Object a(final hs paramhs)
  {
    return hx.a(new hy() {
      public Object a(int paramAnonymousInt) {
        hg localhg = paramhs.a(paramAnonymousInt);
        if (localhg == null)
          return null;
        return localhg.a();
      }

      public List<Object> a(String paramAnonymousString, int paramAnonymousInt) {
        paramAnonymousString = paramhs.a(paramAnonymousString, paramAnonymousInt);
        ArrayList localArrayList = new ArrayList();
        int i = paramAnonymousString.size();
        paramAnonymousInt = 0;
        while (paramAnonymousInt < i) {
          localArrayList.add(((hg) paramAnonymousString.get(paramAnonymousInt)).a());
          paramAnonymousInt += 1;
        }
        return localArrayList;
      }

      public boolean a(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle) {
        return paramhs.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
      }
    });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     hu
 * JD-Core Version:    0.6.2
 */