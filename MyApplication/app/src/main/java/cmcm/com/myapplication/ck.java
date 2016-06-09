package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

class ck
{
  final IntentFilter a;
  final BroadcastReceiver b;
  boolean c;

  ck(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
  {
    this.a = paramIntentFilter;
    this.b = paramBroadcastReceiver;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("Receiver{");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" filter=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ck
 * JD-Core Version:    0.6.2
 */