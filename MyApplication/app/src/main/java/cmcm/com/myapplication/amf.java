package cmcm.com.myapplication;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

class amf
{
  public boolean a;
  public List<String> b;
  public Set<SharedPreferences.OnSharedPreferenceChangeListener> c;
  public Map<String, String> d;
  public final CountDownLatch e = new CountDownLatch(1);
  public volatile boolean f = false;

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.e.countDown();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amf
 * JD-Core Version:    0.6.2
 */