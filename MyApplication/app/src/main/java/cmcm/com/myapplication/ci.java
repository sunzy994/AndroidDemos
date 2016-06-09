package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ci
{
  private static final Object f = new Object();
  private static ci g;
  private final Context a;
  private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> b = new HashMap();
  private final HashMap<String, ArrayList<ck>> c = new HashMap();
  private final ArrayList<cj> d = new ArrayList();
  private final Handler e;

  private ci(Context paramContext)
  {
    this.a = paramContext;
    this.e = new Handler(paramContext.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default:
          super.handleMessage(paramAnonymousMessage);
          return;
        case 1:
        }
        ci.a(ci.this);
      }
    };
  }

  public static ci a(Context paramContext)
  {
    synchronized (f)
    {
      if (g == null)
        g = new ci(paramContext.getApplicationContext());
      paramContext = g;
      return paramContext;
    }
  }

  private void a()
  {
    while (true)
    {
      int i;
      synchronized (this.b)
      {
        i = this.d.size();
        if (i <= 0)
          return;
        cj[] arrayOfcj = new cj[i];
        this.d.toArray(arrayOfcj);
        this.d.clear();
        i = 0;
        if (i >= arrayOfcj.length)
          continue;
        ??? = arrayOfcj[i];
        int j = 0;
        if (j < ???.b.size())
        {
          ((ck)???.b.get(j)).b.onReceive(this.a, ???.a);
          j += 1;
        }
      }
      i += 1;
    }
  }

  public void a(BroadcastReceiver paramBroadcastReceiver)
  {
    while (true)
    {
      int k;
      int i;
      synchronized (this.b)
      {
        ArrayList localArrayList1 = (ArrayList)this.b.remove(paramBroadcastReceiver);
        if (localArrayList1 != null)
          break label166;
        return;
        if (j < localArrayList1.size())
        {
          IntentFilter localIntentFilter = (IntentFilter)localArrayList1.get(j);
          k = 0;
          if (k >= localIntentFilter.countActions())
            break label190;
          String str = localIntentFilter.getAction(k);
          ArrayList localArrayList2 = (ArrayList)this.c.get(str);
          if (localArrayList2 == null)
            break label181;
          i = 0;
          if (i < localArrayList2.size())
          {
            if (((ck)localArrayList2.get(i)).b == paramBroadcastReceiver)
            {
              localArrayList2.remove(i);
              i -= 1;
              break label172;
            }
          }
          else
          {
            if (localArrayList2.size() > 0)
              break label181;
            this.c.remove(str);
            break label181;
          }
        }
        else
        {
          return;
        }
      }
      break label172;
      label166: int j = 0;
      continue;
      label172: i += 1;
      continue;
      label181: k += 1;
      continue;
      label190: j += 1;
    }
  }

  public void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    synchronized (this.b)
    {
      ck localck = new ck(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.b.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList(1);
        this.b.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(paramIntentFilter);
      int i = 0;
      while (i < paramIntentFilter.countActions())
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.c.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new ArrayList(1);
          this.c.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localck);
        i += 1;
      }
      return;
    }
  }

  public boolean a(Intent paramIntent)
  {
    int i;
    label164: int j;
    Object localObject;
    int k;
    ArrayList localArrayList1;
    synchronized (this.b)
    {
      String str1 = paramIntent.getAction();
      String str2 = paramIntent.resolveTypeIfNeeded(this.a.getContentResolver());
      Uri localUri = paramIntent.getData();
      String str3 = paramIntent.getScheme();
      Set localSet = paramIntent.getCategories();
      if ((paramIntent.getFlags() & 0x8) == 0)
        break label501;
      i = 1;
      if (i != 0)
        Log.v("LocalBroadcastManager", "Resolving type " + str2 + " scheme " + str3 + " of intent " + paramIntent);
      ArrayList localArrayList2 = (ArrayList)this.c.get(paramIntent.getAction());
      if (localArrayList2 == null)
        break label476;
      if (i == 0)
        break label484;
      Log.v("LocalBroadcastManager", "Action list: " + localArrayList2);
      break label484;
      if (j >= localArrayList2.size())
        break label534;
      localObject = (ck)localArrayList2.get(j);
      if (i != 0)
        Log.v("LocalBroadcastManager", "Matching against filter " + ((ck)localObject).a);
      if (((ck)localObject).c)
      {
        if (i == 0)
          break label507;
        Log.v("LocalBroadcastManager", "  Filter's target already added");
      }
      else
      {
        k = ((ck)localObject).a.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
        if (k >= 0)
        {
          if (i != 0)
            Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(k));
          if (localArrayList1 != null)
            break label481;
          localArrayList1 = new ArrayList();
          label313: localArrayList1.add(localObject);
          ((ck)localObject).c = true;
        }
      }
    }
    if (i != 0)
      switch (k)
      {
      default:
        localObject = "unknown reason";
        label375: Log.v("LocalBroadcastManager", "  Filter did not match: " + (String)localObject);
        break;
      case -3:
      case -4:
      case -2:
      case -1:
      }
    while (true)
      if (i < localArrayList1.size())
      {
        ((ck)localArrayList1.get(i)).c = false;
        i += 1;
      }
      else
      {
        this.d.add(new cj(paramIntent, localArrayList1));
        if (!this.e.hasMessages(1))
          this.e.sendEmptyMessage(1);
        return true;
        label476: label481: label484: label501: label507: 
        do
        {
          return false;
          break label313;
          localArrayList1 = null;
          j = 0;
          break label164;
          while (true)
          {
            j += 1;
            break label164;
            i = 0;
            break;
          }
          localObject = "action";
          break label375;
          localObject = "category";
          break label375;
          localObject = "data";
          break label375;
          localObject = "type";
          break label375;
        }
        while (localArrayList1 == null);
        label534: i = 0;
      }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ci
 * JD-Core Version:    0.6.2
 */