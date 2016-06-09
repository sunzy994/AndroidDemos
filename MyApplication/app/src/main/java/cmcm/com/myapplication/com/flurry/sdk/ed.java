package cmcm.com.myapplication.com.flurry.sdk;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

public class ed extends MessageDigest
{
  private CRC32 a = new CRC32();

  public ed()
  {
    super("CRC");
  }

  public byte[] a()
  {
    return engineDigest();
  }

  public int b()
  {
    return ByteBuffer.wrap(engineDigest()).getInt();
  }

  protected byte[] engineDigest()
  {
    long l = this.a.getValue();
    return new byte[] { (byte)(int)((0xFF000000 & l) >> 24), (byte)(int)((0xFF0000 & l) >> 16), (byte)(int)((0xFF00 & l) >> 8), (byte)(int)((l & 0xFF) >> 0) };
  }

  protected void engineReset()
  {
    this.a.reset();
  }

  protected void engineUpdate(byte paramByte)
  {
    this.a.update(paramByte);
  }

  protected void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.ed
 * JD-Core Version:    0.6.2
 */