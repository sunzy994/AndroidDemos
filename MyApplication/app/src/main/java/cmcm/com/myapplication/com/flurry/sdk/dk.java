package cmcm.com.myapplication.com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dk
{
  private static final String a = dk.class.getSimpleName();
  private boolean b;
  private List<dh> c;
  private long d = -1L;

  private static String a(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() > 4)
      {
        localObject = new StringBuilder();
        int i = 0;
        while (i < paramString.length() - 4)
        {
          ((StringBuilder)localObject).append('*');
          i += 1;
        }
        ((StringBuilder)localObject).append(paramString.substring(paramString.length() - 4));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }

  private boolean a(String paramString, DataInputStream paramDataInputStream)
  {
    int i = paramDataInputStream.readUnsignedShort();
    el.a(3, a, "File version: " + i);
    if (i > 2)
    {
      el.a(6, a, "Unknown agent file version: " + i);
      throw new IOException("Unknown agent file version: " + i);
    }
    if (i >= 2)
    {
      Object localObject = paramDataInputStream.readUTF();
      el.a(3, a, "Loading API key: " + a(paramString));
      if (((String)localObject).equals(paramString))
      {
        paramString = new ArrayList();
        paramDataInputStream.readUTF();
        boolean bool = paramDataInputStream.readBoolean();
        long l = paramDataInputStream.readLong();
        el.a(3, a, "Loading session reports");
        i = 0;
        while (true)
        {
          int j = paramDataInputStream.readUnsignedShort();
          if (j == 0)
          {
            el.a(3, a, "Persistent file loaded");
            a(bool);
            a(l);
            a(paramString);
            return true;
          }
          localObject = new byte[j];
          paramDataInputStream.readFully((byte[])localObject);
          paramString.add(0, new dh((byte[])localObject));
          localObject = a;
          StringBuilder localStringBuilder = new StringBuilder().append("Session report added: ");
          i += 1;
          el.a(3, (String)localObject, i);
        }
      }
      el.a(3, a, "Api keys do not match, old: " + a(paramString) + ", new: " + a((String)localObject));
      return false;
    }
    el.a(5, a, "Deleting old file version: " + i);
    return false;
  }

  public void a(long paramLong)
  {
    this.d = paramLong;
  }

  public void a(DataOutputStream paramDataOutputStream, String paramString1, String paramString2)
  {
    try
    {
      paramDataOutputStream.writeShort(46586);
      paramDataOutputStream.writeShort(2);
      paramDataOutputStream.writeUTF(paramString1);
      paramDataOutputStream.writeUTF(paramString2);
      paramDataOutputStream.writeBoolean(this.b);
      paramDataOutputStream.writeLong(this.d);
      int i = this.c.size() - 1;
      while (true)
      {
        int j;
        if (i >= 0)
        {
          paramString1 = ((dh)this.c.get(i)).a();
          j = paramString1.length;
          if (j + 2 + paramDataOutputStream.size() > 50000)
            el.a(6, a, "discarded sessions: " + i);
        }
        else
        {
          paramDataOutputStream.writeShort(0);
          return;
        }
        paramDataOutputStream.writeShort(j);
        paramDataOutputStream.write(paramString1);
        i -= 1;
      }
    }
    catch (Throwable paramString1)
    {
      el.a(6, a, "", paramString1);
      throw new IOException(paramString1.getMessage());
    }
    finally
    {
      fb.a(paramDataOutputStream);
    }
    throw paramString1;
  }

  public void a(List<dh> paramList)
  {
    this.c = paramList;
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public boolean a()
  {
    return this.b;
  }

  public boolean a(DataInputStream paramDataInputStream, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramDataInputStream.readUnsignedShort();
      el.a(4, a, "Magic: " + i);
      if (i == 46586)
        bool = a(paramString, paramDataInputStream);
      while (true)
      {
        return bool;
        el.a(3, a, "Unexpected file type");
      }
    }
    catch (Throwable paramString)
    {
      el.a(6, a, "Error when loading persistent file", paramString);
      throw new IOException(paramString.getMessage());
    }
    finally
    {
      fb.a(paramDataInputStream);
    }
    throw paramString;
  }

  public List<dh> b()
  {
    return this.c;
  }

  public long c()
  {
    return this.d;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dk
 * JD-Core Version:    0.6.2
 */