package cmcm.com.myapplication.android.net;

import android.os.Parcelable;
import java.net.InetAddress;
import java.util.Collection;

public abstract class LinkProperties
  implements Parcelable
{
  public abstract Collection<InetAddress> getAllAddresses();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     android.net.LinkProperties
 * JD-Core Version:    0.6.2
 */