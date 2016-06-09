package cmcm.com.myapplication.android.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;

import java.util.List;

public class BluetoothPan
  implements BluetoothProfile
{
  public boolean connect(BluetoothDevice paramBluetoothDevice)
  {
    return false;
  }

  public List<BluetoothDevice> getConnectedDevices()
  {
    return null;
  }

  public int getConnectionState(BluetoothDevice paramBluetoothDevice)
  {
    return 0;
  }

  public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] paramArrayOfInt)
  {
    return null;
  }

  public boolean isTetheringOn()
  {
    return false;
  }

  public void setBluetoothTethering(boolean paramBoolean)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     android.bluetooth.BluetoothPan
 * JD-Core Version:    0.6.2
 */