package cmcm.com.myapplication;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract.Contacts;
import com.lazyswipe.SwipeApplication;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zj
{
  public static boolean a = true;
  public static boolean b = false;
  final Handler c = new Handler(Looper.getMainLooper());
  private final Map<String, SoftReference<Bitmap>> d = new HashMap();
  private final Set<String> e = new HashSet();
  private final ExecutorService f = Executors.newFixedThreadPool(5);

  private Bitmap a(String paramString, Context paramContext)
  {
    paramString = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long.parseLong(paramString));
    paramContext = ContactsContract.Contacts.openContactPhotoInputStream(paramContext.getContentResolver(), paramString);
    paramString = null;
    if (paramContext != null)
      paramString = BitmapFactory.decodeStream(paramContext);
    try
    {
      paramContext.close();
      return paramString;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return paramString;
  }

  public Bitmap a(final String paramString, final zk paramzk)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.d.containsKey(paramString))
    {
      localObject1 = (SoftReference)this.d.get(paramString);
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!atw.b((Bitmap)localObject1))
          break label56;
      }
    }
    label56: 
    do
    {
      return localObject1;
      localObject1 = (Bitmap)((SoftReference)localObject1).get();
      break;
      localObject1 = localObject2;
    }
    while (this.e.contains(paramString));
    if (a)
    {
      this.f.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            final Bitmap localBitmap = zj.a(zj.this, paramString, SwipeApplication.c());
            if (atw.b(localBitmap))
            {
              zj.a(zj.this).put(paramString, new SoftReference(localBitmap));
              zj.this.c.post(new Runnable()
              {
                public void run()
                {
                  zj.1.this.b.a(localBitmap, zj.1.this.a);
                }
              });
              return;
            }
            zj.b(zj.this).add(paramString);
            return;
          }
          catch (Exception localException)
          {
            throw new RuntimeException(localException);
          }
        }
      });
      return null;
    }
    b = true;
    return null;
  }

  public void a()
  {
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext())
      atw.a((Bitmap)((SoftReference)localIterator.next()).get());
    this.d.clear();
    this.e.clear();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zj
 * JD-Core Version:    0.6.2
 */