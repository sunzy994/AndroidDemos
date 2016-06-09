package cmcm.com.myapplication.com.lazyswipe.notification;

import ack;
import aln;
import alo;
import amk;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.text.TextUtils;
import android.text.TextUtils.SimpleStringSplitter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.TextView;
import aqb;
import arm;
import asi;
import asp;
import asq;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import com.lazyswipe.ui.FullscreenTipActivity;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import vs;

@TargetApi(16)
public class SwipeAccessibilityService extends AccessibilityService
  implements Callback
{
  public static final boolean a;
  private static final String c = "com.lazyswipe/" + SwipeAccessibilityService.class.getName();
  private static final String d = "com.lazyswipe/" + SwipeAccessibilityServicePreJellyBean.class.getName();
  private static final boolean e;
  private static final HashSet<CharSequence> f;
  private static HashMap<AccessibilityNodeInfo, Rect> g;
  private static LinkedHashMap<AccessibilityNodeInfo, Rect> h;
  private static HashMap<AccessibilityNodeInfo, Rect> i;
  private static LinkedHashMap<AccessibilityNodeInfo, Rect> j;
  private static Rect[] k;
  private static SwipeAccessibilityService n;
  private static boolean o;
  private static int p;
  private static String q;
  private static int r;
  private static int s;
  private static final String[] t;
  private static int u;
  final Map<String, SparseArray<SparseIntArray>> b = new HashMap(0);
  private long l = 0L;
  private Handler m;

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      bool = true;
      a = bool;
      if (Build.VERSION.SDK_INT >= 18)
        break label109;
    }
    label109: for (boolean bool = true; ; bool = false)
    {
      e = bool;
      f = new HashSet(0);
      t = new String[] { "com.android.settings" };
      return;
      bool = false;
      break;
    }
  }

  public static SwipeAccessibilityService a()
  {
    return n;
  }

  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject = SwipeApplication.c();
    if (!c((Context)localObject));
    while (true)
    {
      return;
      try
      {
        if (!b(paramInt1, paramInt2))
        {
          int i1 = (ViewConfiguration.get((Context)localObject).getScaledTouchSlop() >> 3) * 3;
          localObject = new Rect(paramInt1 - i1, paramInt2 - i1, paramInt1 + i1, i1 + paramInt2);
          Log.i("Swipe.Accessibility", "No clickable found at point (" + paramInt1 + "," + paramInt2 + "); try again using " + ((Rect)localObject).toString());
          a((Rect)localObject);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  public static void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!c(SwipeApplication.c()))
      return;
    while (true)
    {
      try
      {
        Iterator localIterator = j.entrySet().iterator();
        if (!localIterator.hasNext())
          break;
        Entry localEntry = (Entry)localIterator.next();
        AccessibilityNodeInfo localAccessibilityNodeInfo = (AccessibilityNodeInfo)localEntry.getKey();
        if (!((Rect)localEntry.getValue()).contains(paramInt1, paramInt2))
          continue;
        if ((!paramBoolean1) || (!aqb.a(localAccessibilityNodeInfo)))
        {
          if ((paramBoolean1) || (!aqb.b(localAccessibilityNodeInfo)))
            continue;
          break label120;
          localAccessibilityNodeInfo.performAction(paramInt1);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      label120: 
      do
      {
        paramInt1 = 8192;
        break;
      }
      while (!paramBoolean2);
      paramInt1 = 4096;
    }
  }

  private void a(AccessibilityEvent paramAccessibilityEvent, int paramInt, CharSequence paramCharSequence)
  {
    u = 0;
    if (o)
      if (asq.a(t[p], paramCharSequence));
    do
    {
      do
      {
        do
        {
          return;
          try
          {
            paramAccessibilityEvent = paramAccessibilityEvent.getSource();
            if ((paramAccessibilityEvent != null) && ((4096 != paramInt) || (paramAccessibilityEvent.isVisibleToUser())))
            {
              getRootInActiveWindow();
              a(paramAccessibilityEvent);
              return;
            }
          }
          catch (Throwable paramAccessibilityEvent)
          {
            asp.a("Swipe.Accessibility", "Failed to process the view event", paramAccessibilityEvent);
            return;
          }
        }
        while (paramAccessibilityEvent == null);
        aqb.c(paramAccessibilityEvent);
        return;
      }
      while (k == null);
      try
      {
        paramAccessibilityEvent = paramAccessibilityEvent.getSource();
        if ((paramAccessibilityEvent != null) && ((4096 != paramInt) || (paramAccessibilityEvent.isVisibleToUser())))
        {
          b();
          b(getRootInActiveWindow());
          a(g, h);
          a(i, j);
          return;
        }
      }
      catch (Throwable paramAccessibilityEvent)
      {
        asp.a("Swipe.Accessibility", "Failed to process the view event", paramAccessibilityEvent);
        return;
      }
    }
    while (paramAccessibilityEvent == null);
    aqb.c(paramAccessibilityEvent);
  }

  private void a(AccessibilityEvent paramAccessibilityEvent, CharSequence paramCharSequence)
  {
    if (("com.lazyswipe".equals(paramCharSequence)) || (!alo.a(this, paramCharSequence)));
    CharSequence localCharSequence;
    do
    {
      return;
      localCharSequence = paramAccessibilityEvent.getClassName();
    }
    while ((localCharSequence == null) || (localCharSequence.toString().indexOf("Toast$TN") > 0));
    paramAccessibilityEvent = (Notification)paramAccessibilityEvent.getParcelableData();
    alo.a(this, paramCharSequence.toString(), paramAccessibilityEvent);
  }

  private void a(Map<AccessibilityNodeInfo, Rect> paramMap1, Map<AccessibilityNodeInfo, Rect> paramMap2)
  {
    Object localObject = new LinkedList(paramMap1.entrySet());
    Collections.sort((List)localObject, new Comparator()
    {
      public int a(Entry<AccessibilityNodeInfo, Rect> paramAnonymousEntry1, Entry<AccessibilityNodeInfo, Rect> paramAnonymousEntry2)
      {
        paramAnonymousEntry1 = (Rect)paramAnonymousEntry1.getValue();
        paramAnonymousEntry2 = (Rect)paramAnonymousEntry2.getValue();
        int i = paramAnonymousEntry1.width();
        int j = paramAnonymousEntry1.height();
        int k = paramAnonymousEntry2.width();
        return j * i - paramAnonymousEntry2.height() * k;
      }
    });
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Entry localEntry = (Entry)((Iterator)localObject).next();
      paramMap2.put(localEntry.getKey(), localEntry.getValue());
    }
    paramMap1.clear();
  }

  public static void a(Rect[] paramArrayOfRect)
  {
    k = paramArrayOfRect;
  }

  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      paramContext = paramContext.getContentResolver();
      try
      {
        i1 = Settings.Secure.getInt(paramContext, "accessibility_enabled");
        if (i1 != 1)
          break label162;
        paramContext = Settings.Secure.getString(paramContext, "enabled_accessibility_services");
        if (TextUtils.isEmpty(paramContext))
          break label162;
        SimpleStringSplitter localSimpleStringSplitter = new SimpleStringSplitter(':');
        localSimpleStringSplitter.setString(paramContext);
        do
          if (!localSimpleStringSplitter.hasNext())
            break;
        while (!localSimpleStringSplitter.next().equalsIgnoreCase(d));
        return true;
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        while (true)
        {
          asp.b("Swipe.Accessibility", "Settings.Secure.ACCESSIBILITY_ENABLED not found?!");
          int i1 = 0;
        }
      }
    }
    else
    {
      try
      {
        Object localObject = b(paramContext);
        if (Build.VERSION.SDK_INT < 16);
        for (paramContext = d; ; paramContext = c)
        {
          paramContext = ComponentName.unflattenFromString(paramContext);
          localObject = ((List)localObject).iterator();
          do
            if (!((Iterator)localObject).hasNext())
              break;
          while (!paramContext.equals(ComponentName.unflattenFromString(((AccessibilityServiceInfo)((Iterator)localObject).next()).getId())));
          return true;
        }
      }
      catch (Throwable paramContext)
      {
      }
    }
    label162: return false;
  }

  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = asq.k(paramContext, "android.settings.ACCESSIBILITY_SETTINGS");
    if (paramBoolean)
      FullscreenTipActivity.f(paramContext);
    return bool;
  }

  private static boolean a(Rect paramRect)
  {
    Iterator localIterator = h.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      AccessibilityNodeInfo localAccessibilityNodeInfo = (AccessibilityNodeInfo)localEntry.getKey();
      if (Rect.intersects((Rect)localEntry.getValue(), paramRect))
      {
        localAccessibilityNodeInfo.performAction(16);
        return true;
      }
    }
    return false;
  }

  private boolean a(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent == null);
    AccessibilityServiceInfo localAccessibilityServiceInfo;
    do
    {
      return true;
      localAccessibilityServiceInfo = getServiceInfo();
    }
    while ((localAccessibilityServiceInfo == null) || (((localAccessibilityServiceInfo.flags & 0x4) != 0) && ((paramAccessibilityEvent.getEventType() & 0x100C) != 0) && (paramAccessibilityEvent.getEventTime() - this.l < 100L) && (!b(paramAccessibilityEvent))));
    return false;
  }

  private boolean a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (paramAccessibilityNodeInfo == null)
      return false;
    while (true)
      try
      {
        int i1 = u + 1;
        u = i1;
        if (i1 >= 20)
          return false;
        boolean bool = paramAccessibilityNodeInfo.isVisibleToUser();
        if (!bool)
          return false;
        switch (p)
        {
        case 0:
          int i2 = paramAccessibilityNodeInfo.getChildCount();
          if (i2 > 0)
          {
            i1 = 0;
            if (i1 < i2)
            {
              bool = a(paramAccessibilityNodeInfo.getChild(i1));
              if (bool)
              {
                return true;
                if (r == 0)
                {
                  if ((!TextView.class.getName().equals(paramAccessibilityNodeInfo.getClassName())) || (q == null) || (!asi.a(q, paramAccessibilityNodeInfo.getText())))
                    continue;
                  paramAccessibilityNodeInfo.getParent().performAction(16);
                  c();
                  return true;
                }
                if (!asi.a(paramAccessibilityNodeInfo.getText(), getText(17039370)))
                  continue;
                paramAccessibilityNodeInfo.performAction(16);
                c();
                return true;
              }
              i1 += 1;
              continue;
            }
          }
          else
          {
            return false;
          }
          break;
        }
      }
      finally
      {
        aqb.c(paramAccessibilityNodeInfo);
      }
  }

  private static List<AccessibilityServiceInfo> b(Context paramContext)
  {
    try
    {
      paramContext = ((AccessibilityManager)paramContext.getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1);
      return paramContext;
    }
    catch (Exception paramContext)
    {
    }
    return Collections.emptyList();
  }

  private void b()
  {
    try
    {
      i.clear();
      g.clear();
      HashMap localHashMap = new HashMap(h);
      localHashMap.putAll(j);
      aqb.a(localHashMap.keySet(), false);
      localHashMap.clear();
      j.clear();
      h.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void b(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    int i1;
    if (paramAccessibilityNodeInfo != null)
    {
      i1 = u + 1;
      u = i1;
      if (i1 < 20)
        break label24;
    }
    label24: Rect localRect;
    Object localObject;
    do
    {
      return;
      localRect = new Rect();
      paramAccessibilityNodeInfo.getBoundsInScreen(localRect);
      localObject = getResources().getDisplayMetrics();
    }
    while ((!paramAccessibilityNodeInfo.isVisibleToUser()) || (localRect.bottom <= 0) || (localRect.right <= 0) || (localRect.left >= ((DisplayMetrics)localObject).widthPixels) || (localRect.top >= ((DisplayMetrics)localObject).heightPixels));
    int i4 = paramAccessibilityNodeInfo.getChildCount();
    boolean bool = paramAccessibilityNodeInfo.isClickable();
    int i3;
    int i2;
    if ((i4 > 0) || (bool))
    {
      localObject = k;
      int i5 = localObject.length;
      i3 = 0;
      i1 = 0;
      i2 = i1;
      if (i3 < i5)
      {
        if (!Rect.intersects(localRect, localObject[i3]))
          break label216;
        i1 = 1;
        i2 = 1;
        if (!bool)
          break label216;
        g.put(paramAccessibilityNodeInfo, localRect);
      }
    }
    while (true)
    {
      if (i2 != 0)
      {
        if (paramAccessibilityNodeInfo.isScrollable())
          i.put(paramAccessibilityNodeInfo, localRect);
        i1 = 0;
        while (true)
          if (i1 < i4)
          {
            b(paramAccessibilityNodeInfo.getChild(i1));
            i1 += 1;
            continue;
            label216: i3 += 1;
            break;
          }
      }
      if ((!localRect.isEmpty()) && ((g.containsKey(paramAccessibilityNodeInfo)) || (i.containsKey(paramAccessibilityNodeInfo))))
        break;
      aqb.c(paramAccessibilityNodeInfo);
      return;
      i2 = 0;
    }
  }

  private static boolean b(int paramInt1, int paramInt2)
  {
    Iterator localIterator = h.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      AccessibilityNodeInfo localAccessibilityNodeInfo = (AccessibilityNodeInfo)localEntry.getKey();
      if (((Rect)localEntry.getValue()).contains(paramInt1, paramInt2))
      {
        localAccessibilityNodeInfo.performAction(16);
        return true;
      }
    }
    return false;
  }

  private boolean b(AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityEvent localAccessibilityEvent;
    if (paramAccessibilityEvent.getEventType() == 8)
      localAccessibilityEvent = null;
    try
    {
      paramAccessibilityEvent = paramAccessibilityEvent.getSource();
      localAccessibilityEvent = paramAccessibilityEvent;
      boolean bool = aqb.a(this, paramAccessibilityEvent, EditText.class);
      return bool;
    }
    finally
    {
      if (localAccessibilityEvent != null)
        aqb.a(new AccessibilityNodeInfo[] { localAccessibilityEvent });
    }
    throw paramAccessibilityEvent;
  }

  private void c()
  {
    r += 1;
    if (r >= s)
    {
      o = false;
      this.m.removeMessages(2);
      this.m.postDelayed(new Runnable()
      {
        public void run()
        {
          SwipeAccessibilityService.this.performGlobalAction(1);
        }
      }
      , 200L);
    }
  }

  private static boolean c(Context paramContext)
  {
    return h != null;
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return false;
    case 2:
      o = false;
      return true;
    case 1:
    }
    paramMessage = (aln)paramMessage.obj;
    a(paramMessage.a, paramMessage.b, paramMessage.c);
    try
    {
      paramMessage.a.recycle();
      label67: return true;
    }
    catch (Throwable paramMessage)
    {
      break label67;
    }
  }

  public void onAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    int i1 = 1;
    while (true)
    {
      Object localObject;
      int i2;
      try
      {
        localObject = ack.a();
        if (localObject != null)
          ((ack)localObject).a(paramAccessibilityEvent);
        if (!SwipeService.b())
          return;
        i2 = paramAccessibilityEvent.getEventType();
        localObject = paramAccessibilityEvent.getPackageName();
        if ((a) && (a(paramAccessibilityEvent)))
          break;
        if (i2 == 32)
          this.l = System.currentTimeMillis();
        if (vs.d(this) == 0)
        {
          if ((a) && ((i1 != 0) || (o)))
          {
            if (32 != i2)
              break label144;
            this.m.removeMessages(1);
            a(paramAccessibilityEvent, i2, (CharSequence)localObject);
          }
          if ((!e) || (i2 != 64))
            break;
          a(paramAccessibilityEvent, (CharSequence)localObject);
          return;
        }
      }
      catch (Exception paramAccessibilityEvent)
      {
        asq.b(paramAccessibilityEvent, 5, "Swipe.Accessibility", "onAccessibilityEvent");
        return;
      }
      i1 = 0;
      continue;
      label144: if (4096 == i2)
      {
        this.m.removeMessages(1);
        this.m.sendMessageDelayed(this.m.obtainMessage(1, new aln(paramAccessibilityEvent, i2, (CharSequence)localObject)), 300L);
      }
    }
  }

  public void onCreate()
  {
    super.onCreate();
    n = this;
    if (e)
    {
      arm.a(this);
      SwipeService.a(this);
    }
    if (a)
    {
      g = new HashMap();
      h = new LinkedHashMap();
      i = new HashMap();
      j = new LinkedHashMap();
      this.m = new Handler(this);
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (e)
      alo.b(this);
    if (a)
    {
      b();
      g = null;
      h = null;
      i = null;
      j = null;
    }
    n = null;
  }

  public void onInterrupt()
  {
  }

  protected void onServiceConnected()
  {
    super.onServiceConnected();
    ack.a(this);
    if (e)
      alo.a(this);
    while (true)
    {
      if (a)
        b();
      return;
      if (amk.b(this))
        SwipeService.a(this, SwipeService.d(this).getExtras());
    }
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    try
    {
      ack.a().a(this, paramIntent);
      label8: return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    catch (Throwable localThrowable)
    {
      break label8;
    }
  }

  public boolean onUnbind(Intent paramIntent)
  {
    ack.b();
    return super.onUnbind(paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.notification.SwipeAccessibilityService
 * JD-Core Version:    0.6.2
 */