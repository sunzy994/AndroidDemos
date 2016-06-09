package cmcm.com.myapplication;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class hv extends hw
{
  public Object a(final hs paramhs)
  {
    return hz.a(new ia() {
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

      public Object b(int paramAnonymousInt) {
        hg localhg = paramhs.b(paramAnonymousInt);
        if (localhg == null)
          return null;
        return localhg.a();
      }
    });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     hv
 * JD-Core Version:    0.6.2
 */