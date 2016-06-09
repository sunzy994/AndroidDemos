package cmcm.com.myapplication;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class qa
{
  public static void a(String paramString1, String paramString2, String paramString3, qb paramqb)
  {
    a(paramString1, paramString2, paramString3, new qc()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        qa.this.a(paramAnonymousInt, paramAnonymousString);
        try
        {
          JSONObject localJSONObject = new JSONObject(paramAnonymousString);
          qa.this.a(paramAnonymousInt, localJSONObject);
          return;
        }
        catch (Exception localException)
        {
          qa.this.a(paramAnonymousInt, paramAnonymousString, localException);
        }
      }

      public void a(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        qa.this.a(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
      }
    });
  }

  public static void a(String paramString1, final String paramString2, final String paramString3, final qc paramqc)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        Object localObject1;
        int i;
        try
        {
          HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(qa.this).openConnection();
          localHttpURLConnection.setDoInput(true);
          localHttpURLConnection.setConnectTimeout(2000);
          localHttpURLConnection.setReadTimeout(3000);
          localHttpURLConnection.setRequestMethod(paramString2);
          if ((paramString3 != null) && (!paramString3.isEmpty()))
          {
            localHttpURLConnection.setDoOutput(true);
            localObject1 = localHttpURLConnection.getOutputStream();
            ((OutputStream)localObject1).write(paramString3.getBytes());
            ((OutputStream)localObject1).close();
          }
          i = localHttpURLConnection.getResponseCode();
          localObject2 = localHttpURLConnection.getInputStream();
          localObject1 = new ByteArrayOutputStream();
          byte[] arrayOfByte = new byte[1024];
          while (true)
          {
            int j = ((InputStream)localObject2).read(arrayOfByte);
            if (j < 1)
              break;
            ((ByteArrayOutputStream)localObject1).write(arrayOfByte, 0, j);
          }
        }
        catch (Throwable localThrowable)
        {
          paramqc.a(0, null, localThrowable);
          return;
        }
        ((InputStream)localObject2).close();
        Object localObject2 = ((ByteArrayOutputStream)localObject1).toString();
        ((ByteArrayOutputStream)localObject1).close();
        localThrowable.disconnect();
        if (i == 200)
        {
          paramqc.a(i, (String)localObject2);
          return;
        }
        paramqc.a(i, (String)localObject2, new Exception("Error statusCode"));
      }
    }).start();
  }

  public static void a(String paramString, qb paramqb)
  {
    a(paramString, "GET", null, paramqb);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qa
 * JD-Core Version:    0.6.2
 */