package cmcm.com.myapplication.com.lazyswipe.fan.friend;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqi;
import aso;
import avx;
import avz;
import awa;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.widget.SideBar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tj;
import tk;
import vs;
import zj;
import zl;
import zm;
import zn;

public class ContactChoosePanel extends FrameLayout
  implements OnScrollListener
{
  private static boolean k = false;
  private static int l = -1;
  private TextView a;
  private LinearLayout b;
  private ContactChoosePanel.ExtraScrollOffsetListView c;
  private zj d;
  private zn e;
  private SideBar f;
  private long g;
  private int h = -1;
  private List<zl> i;
  private aqi j;

  public ContactChoosePanel(Context paramContext)
  {
    super(paramContext);
  }

  public ContactChoosePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static void a(Context paramContext)
  {
    k = false;
    new AsyncTask()
    {
      List<zl> a;
      private tj c;

      public Void a(Void[] paramAnonymousArrayOfVoid)
      {
        long l = System.currentTimeMillis();
        this.a = ContactChoosePanel.b();
        if (ContactChoosePanel.c());
        label135: 
        do
        {
          return null;
          Collections.sort(this.a, new zm());
          Iterator localIterator = this.a.iterator();
          paramAnonymousArrayOfVoid = null;
          if (localIterator.hasNext())
          {
            zl localzl = (zl)localIterator.next();
            if (paramAnonymousArrayOfVoid == null)
            {
              zl.a(localzl, true);
              if (paramAnonymousArrayOfVoid != null)
                if (zl.b(paramAnonymousArrayOfVoid) == zl.b(localzl))
                  break label135;
            }
            for (boolean bool = true; ; bool = false)
            {
              zl.b(paramAnonymousArrayOfVoid, bool);
              paramAnonymousArrayOfVoid = localzl;
              break;
              if (zl.b(paramAnonymousArrayOfVoid) != zl.b(localzl));
              for (bool = true; ; bool = false)
              {
                zl.a(localzl, bool);
                break;
              }
            }
          }
          l = 1000L - (System.currentTimeMillis() - l);
        }
        while (l <= 0L);
        SystemClock.sleep(l);
        return null;
      }

      public void a(Void paramAnonymousVoid)
      {
        if (ContactChoosePanel.c())
          return;
        if (this.a.isEmpty())
        {
          this.c.dismiss();
          aso.a(ContactChoosePanel.this, 2131231214);
          return;
        }
        paramAnonymousVoid = (ContactChoosePanel)LayoutInflater.from(ContactChoosePanel.this).inflate(2130968719, null, false);
        ContactChoosePanel.a(paramAnonymousVoid, this.a);
        paramAnonymousVoid.a();
        this.c.dismiss();
        paramAnonymousVoid.setBaseActionListener(new aqi()
        {
          public void a()
          {
            if (this.a != null)
              this.a.dismiss();
          }
        });
      }

      public void onPreExecute()
      {
        this.c = new avz(ContactChoosePanel.this).g(2131230736).b(true).a(new OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            ContactChoosePanel.a(true);
          }
        }).b(vs.n(ContactChoosePanel.this)).b();
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  private String b(zl paramzl)
  {
    if (zl.b(paramzl) == '*')
      return getResources().getString(2131231071);
    return String.valueOf(zl.b(paramzl));
  }

  // ERROR //
  public static List<zl> b()
  {
    // Byte code:
    //   0: new 114	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 116	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: invokestatic 121	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   12: invokevirtual 127	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   15: astore 4
    //   17: new 129	java/util/HashSet
    //   20: dup
    //   21: invokespecial 130	java/util/HashSet:<init>	()V
    //   24: astore 7
    //   26: aload 4
    //   28: getstatic 135	xc:a	Landroid/net/Uri;
    //   31: iconst_1
    //   32: anewarray 105	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc 137
    //   39: aastore
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 143	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_2
    //   47: aload_2
    //   48: astore_1
    //   49: new 145	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   56: astore_3
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: invokeinterface 152 1 0
    //   65: ifeq +91 -> 156
    //   68: aload_2
    //   69: astore_1
    //   70: getstatic 46	com/lazyswipe/fan/friend/ContactChoosePanel:k	Z
    //   73: istore 10
    //   75: iload 10
    //   77: ifeq +10 -> 87
    //   80: aload_2
    //   81: invokestatic 157	arf:a	(Landroid/database/Cursor;)V
    //   84: aload 5
    //   86: areturn
    //   87: aload_2
    //   88: astore_1
    //   89: aload_2
    //   90: iconst_0
    //   91: invokeinterface 158 2 0
    //   96: invokestatic 164	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   99: invokevirtual 168	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   102: invokestatic 174	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   105: lstore 8
    //   107: aload_2
    //   108: astore_1
    //   109: aload 7
    //   111: lload 8
    //   113: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   116: invokeinterface 183 2 0
    //   121: pop
    //   122: aload_2
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 187	java/lang/StringBuilder:length	()I
    //   128: ifne +12 -> 140
    //   131: aload_2
    //   132: astore_1
    //   133: aload_3
    //   134: ldc 189
    //   136: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_2
    //   141: astore_1
    //   142: aload_3
    //   143: lload 8
    //   145: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: goto -92 -> 57
    //   152: astore_1
    //   153: goto -96 -> 57
    //   156: aload_2
    //   157: invokestatic 157	arf:a	(Landroid/database/Cursor;)V
    //   160: new 129	java/util/HashSet
    //   163: dup
    //   164: invokespecial 130	java/util/HashSet:<init>	()V
    //   167: astore 6
    //   169: bipush 7
    //   171: invokestatic 201	aqn:a	(I)Ljava/util/List;
    //   174: invokeinterface 207 1 0
    //   179: astore_1
    //   180: aload_1
    //   181: invokeinterface 212 1 0
    //   186: ifeq +101 -> 287
    //   189: aload_1
    //   190: invokeinterface 216 1 0
    //   195: checkcast 218	alw
    //   198: astore_2
    //   199: getstatic 46	com/lazyswipe/fan/friend/ContactChoosePanel:k	Z
    //   202: ifeq +45 -> 247
    //   205: aload 5
    //   207: areturn
    //   208: astore_3
    //   209: aconst_null
    //   210: astore_2
    //   211: aload_2
    //   212: astore_1
    //   213: ldc 220
    //   215: ldc 222
    //   217: aload_3
    //   218: invokestatic 227	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   221: pop
    //   222: aload_2
    //   223: astore_1
    //   224: aload 7
    //   226: invokeinterface 230 1 0
    //   231: aload_2
    //   232: invokestatic 157	arf:a	(Landroid/database/Cursor;)V
    //   235: goto -75 -> 160
    //   238: astore_2
    //   239: aconst_null
    //   240: astore_1
    //   241: aload_1
    //   242: invokestatic 157	arf:a	(Landroid/database/Cursor;)V
    //   245: aload_2
    //   246: athrow
    //   247: aload_2
    //   248: getfield 232	alw:c	Landroid/net/Uri;
    //   251: invokestatic 238	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   254: lstore 8
    //   256: aload 7
    //   258: lload 8
    //   260: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   263: invokeinterface 241 2 0
    //   268: ifne -88 -> 180
    //   271: aload 6
    //   273: lload 8
    //   275: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   278: invokeinterface 183 2 0
    //   283: pop
    //   284: goto -104 -> 180
    //   287: getstatic 246	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   290: astore_2
    //   291: new 145	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   298: ldc 248
    //   300: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: astore_3
    //   304: aload 7
    //   306: invokeinterface 251 1 0
    //   311: ifgt +81 -> 392
    //   314: ldc 253
    //   316: astore_1
    //   317: aload_3
    //   318: aload_1
    //   319: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: astore_1
    //   326: aload 4
    //   328: aload_2
    //   329: iconst_4
    //   330: anewarray 105	java/lang/String
    //   333: dup
    //   334: iconst_0
    //   335: ldc 248
    //   337: aastore
    //   338: dup
    //   339: iconst_1
    //   340: ldc_w 258
    //   343: aastore
    //   344: dup
    //   345: iconst_2
    //   346: ldc_w 260
    //   349: aastore
    //   350: dup
    //   351: iconst_3
    //   352: ldc_w 262
    //   355: aastore
    //   356: aload_1
    //   357: aconst_null
    //   358: aconst_null
    //   359: invokevirtual 143	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   362: astore 7
    //   364: aload 7
    //   366: invokeinterface 152 1 0
    //   371: ifeq +386 -> 757
    //   374: getstatic 46	com/lazyswipe/fan/friend/ContactChoosePanel:k	Z
    //   377: istore 10
    //   379: iload 10
    //   381: ifeq +47 -> 428
    //   384: aload 7
    //   386: invokestatic 157	arf:a	(Landroid/database/Cursor;)V
    //   389: aload 5
    //   391: areturn
    //   392: new 145	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 264
    //   402: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload 7
    //   407: bipush 44
    //   409: invokestatic 269	asi:a	(Ljava/util/Collection;C)Ljava/lang/String;
    //   412: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc_w 271
    //   418: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: astore_1
    //   425: goto -108 -> 317
    //   428: aload 7
    //   430: aload 7
    //   432: ldc 248
    //   434: invokeinterface 275 2 0
    //   439: invokeinterface 158 2 0
    //   444: astore_1
    //   445: aload_1
    //   446: invokestatic 174	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   449: lstore 8
    //   451: aload 7
    //   453: aload 7
    //   455: ldc_w 258
    //   458: invokeinterface 275 2 0
    //   463: invokeinterface 158 2 0
    //   468: astore 4
    //   470: aload 7
    //   472: aload 7
    //   474: ldc_w 260
    //   477: invokeinterface 275 2 0
    //   482: invokeinterface 279 2 0
    //   487: ifeq +205 -> 692
    //   490: aconst_null
    //   491: astore_2
    //   492: aload 7
    //   494: aload 7
    //   496: ldc_w 262
    //   499: invokeinterface 275 2 0
    //   504: invokeinterface 158 2 0
    //   509: invokestatic 284	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   512: ifle -148 -> 364
    //   515: aload 4
    //   517: astore_3
    //   518: aload 4
    //   520: ifnonnull +6 -> 526
    //   523: ldc 253
    //   525: astore_3
    //   526: new 89	zl
    //   529: dup
    //   530: invokespecial 285	zl:<init>	()V
    //   533: astore 4
    //   535: aload 4
    //   537: aload_1
    //   538: invokestatic 288	zl:a	(Lzl;Ljava/lang/String;)Ljava/lang/String;
    //   541: pop
    //   542: aload 4
    //   544: aload_3
    //   545: invokestatic 290	zl:b	(Lzl;Ljava/lang/String;)Ljava/lang/String;
    //   548: pop
    //   549: aload 4
    //   551: getstatic 246	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   554: aload_1
    //   555: invokestatic 292	asi:d	(Ljava/lang/String;)J
    //   558: invokestatic 296	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   561: invokestatic 299	zl:a	(Lzl;Landroid/net/Uri;)Landroid/net/Uri;
    //   564: pop
    //   565: aload 4
    //   567: aload_2
    //   568: invokestatic 301	zl:b	(Lzl;Landroid/net/Uri;)Landroid/net/Uri;
    //   571: pop
    //   572: invokestatic 306	aqk:a	()Laqk;
    //   575: aload_3
    //   576: invokevirtual 309	aqk:b	(Ljava/lang/String;)Ljava/lang/String;
    //   579: astore_2
    //   580: aload_2
    //   581: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   584: ifne +195 -> 779
    //   587: aload_2
    //   588: iconst_0
    //   589: invokevirtual 319	java/lang/String:charAt	(I)C
    //   592: invokestatic 325	java/lang/Character:toUpperCase	(C)C
    //   595: istore_0
    //   596: aload 6
    //   598: lload 8
    //   600: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   603: invokeinterface 241 2 0
    //   608: ifeq +108 -> 716
    //   611: aload 4
    //   613: bipush 42
    //   615: invokestatic 328	zl:a	(Lzl;C)C
    //   618: pop
    //   619: aload 5
    //   621: aload 4
    //   623: invokeinterface 329 2 0
    //   628: pop
    //   629: goto -265 -> 364
    //   632: astore_3
    //   633: aload_1
    //   634: astore_2
    //   635: aload_3
    //   636: astore_1
    //   637: ldc 220
    //   639: new 145	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   646: ldc_w 331
    //   649: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload_2
    //   653: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: ldc_w 333
    //   659: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: aload_1
    //   666: invokestatic 227	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   669: pop
    //   670: goto -306 -> 364
    //   673: astore_1
    //   674: ldc 220
    //   676: ldc_w 335
    //   679: aload_1
    //   680: invokestatic 227	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   683: pop
    //   684: aload 7
    //   686: invokestatic 157	arf:a	(Landroid/database/Cursor;)V
    //   689: aload 5
    //   691: areturn
    //   692: aload 7
    //   694: aload 7
    //   696: ldc_w 260
    //   699: invokeinterface 275 2 0
    //   704: invokeinterface 158 2 0
    //   709: invokestatic 164	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   712: astore_2
    //   713: goto -221 -> 492
    //   716: iload_0
    //   717: bipush 65
    //   719: if_icmplt +27 -> 746
    //   722: iload_0
    //   723: bipush 90
    //   725: if_icmpgt +21 -> 746
    //   728: aload 4
    //   730: iload_0
    //   731: invokestatic 328	zl:a	(Lzl;C)C
    //   734: pop
    //   735: goto -116 -> 619
    //   738: astore_1
    //   739: aload 7
    //   741: invokestatic 157	arf:a	(Landroid/database/Cursor;)V
    //   744: aload_1
    //   745: athrow
    //   746: aload 4
    //   748: bipush 35
    //   750: invokestatic 328	zl:a	(Lzl;C)C
    //   753: pop
    //   754: goto -135 -> 619
    //   757: aload 7
    //   759: invokestatic 157	arf:a	(Landroid/database/Cursor;)V
    //   762: goto -73 -> 689
    //   765: astore_1
    //   766: aconst_null
    //   767: astore_2
    //   768: goto -131 -> 637
    //   771: astore_2
    //   772: goto -531 -> 241
    //   775: astore_3
    //   776: goto -565 -> 211
    //   779: iconst_0
    //   780: istore_0
    //   781: goto -185 -> 596
    //
    // Exception table:
    //   from	to	target	type
    //   89	107	152	java/lang/Exception
    //   109	122	152	java/lang/Exception
    //   124	131	152	java/lang/Exception
    //   133	140	152	java/lang/Exception
    //   142	149	152	java/lang/Exception
    //   26	47	208	java/lang/Exception
    //   26	47	238	finally
    //   445	490	632	java/lang/Exception
    //   492	515	632	java/lang/Exception
    //   526	596	632	java/lang/Exception
    //   596	619	632	java/lang/Exception
    //   619	629	632	java/lang/Exception
    //   692	713	632	java/lang/Exception
    //   728	735	632	java/lang/Exception
    //   746	754	632	java/lang/Exception
    //   364	379	673	java/lang/Exception
    //   637	670	673	java/lang/Exception
    //   364	379	738	finally
    //   428	445	738	finally
    //   445	490	738	finally
    //   492	515	738	finally
    //   526	596	738	finally
    //   596	619	738	finally
    //   619	629	738	finally
    //   637	670	738	finally
    //   674	684	738	finally
    //   692	713	738	finally
    //   728	735	738	finally
    //   746	754	738	finally
    //   428	445	765	java/lang/Exception
    //   49	57	771	finally
    //   59	68	771	finally
    //   70	75	771	finally
    //   89	107	771	finally
    //   109	122	771	finally
    //   124	131	771	finally
    //   133	140	771	finally
    //   142	149	771	finally
    //   213	222	771	finally
    //   224	231	771	finally
    //   49	57	775	java/lang/Exception
    //   59	68	775	java/lang/Exception
    //   70	75	775	java/lang/Exception
  }

  public int a(int paramInt)
  {
    int m = 0;
    while (m < this.i.size())
    {
      if (zl.b((zl)this.i.get(m)) >= paramInt)
        return m;
      m += 1;
    }
    return -1;
  }

  public void a()
  {
    this.b = ((LinearLayout)findViewById(2131755401));
    this.a = ((TextView)findViewById(2131755402));
    this.c = ((ContactChoosePanel.ExtraScrollOffsetListView)findViewById(2131755400));
    this.f = ((SideBar)findViewById(2131755403));
    this.f.setOnTouchingLetterChangedListener(new awa()
    {
      public void a(String paramAnonymousString)
      {
        int i = ContactChoosePanel.this.a(paramAnonymousString.charAt(0));
        if (i != -1)
          ContactChoosePanel.a(ContactChoosePanel.this).setSelection(i);
      }
    });
    this.d = new zj();
    this.e = new zn(this, SwipeApplication.c(), this.i);
    this.c.setAdapter(this.e);
    this.c.setOnScrollListener(this);
    this.c.setOnItemClickListener(new OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        if (Math.abs(ContactChoosePanel.b(ContactChoosePanel.this) - System.currentTimeMillis()) < 200L)
          return;
        ContactChoosePanel.a(ContactChoosePanel.this, System.currentTimeMillis());
        if (ContactChoosePanel.c(ContactChoosePanel.this) != null)
          ContactChoosePanel.c(ContactChoosePanel.this).a();
        ContactChoosePanel.b(ContactChoosePanel.d(ContactChoosePanel.this));
        new AsyncTask()
        {
          private tj c;
          private zl d;

          public Void a(Void[] paramAnonymous2ArrayOfVoid)
          {
            ContactChoosePanel.this.a(this.d);
            return null;
          }

          public void a(Void paramAnonymous2Void)
          {
            this.c.dismiss();
          }

          public void onPreExecute()
          {
            this.c = new avz(ContactChoosePanel.this.getContext()).g(2131230736).b(false).b();
            this.d = ((zl)ContactChoosePanel.e(ContactChoosePanel.this).getItem(paramAnonymousInt));
          }
        }
        .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      }
    });
    if (l >= 0)
      this.c.setSelection(l);
  }

  // ERROR //
  void a(zl paramzl)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 410	zl:a	(Lzl;)Landroid/net/Uri;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +16 -> 22
    //   9: aload_1
    //   10: aload_0
    //   11: invokevirtual 414	com/lazyswipe/fan/friend/ContactChoosePanel:getContext	()Landroid/content/Context;
    //   14: aload_2
    //   15: invokestatic 417	aqn:d	(Landroid/content/Context;Landroid/net/Uri;)Landroid/graphics/Bitmap;
    //   18: invokestatic 420	zl:a	(Lzl;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   21: pop
    //   22: aconst_null
    //   23: invokestatic 423	arf:a	(Ljava/io/Closeable;)V
    //   26: aload_0
    //   27: invokevirtual 414	com/lazyswipe/fan/friend/ContactChoosePanel:getContext	()Landroid/content/Context;
    //   30: invokestatic 426	alw:b	(Landroid/content/Context;)I
    //   33: istore_3
    //   34: aload_1
    //   35: invokevirtual 429	zl:a	()Lalw;
    //   38: astore_1
    //   39: aload_1
    //   40: iload_3
    //   41: putfield 431	alw:f	I
    //   44: getstatic 433	alw:j	Ljava/util/List;
    //   47: aload_1
    //   48: invokeinterface 329 2 0
    //   53: pop
    //   54: aload_1
    //   55: aload_0
    //   56: invokevirtual 414	com/lazyswipe/fan/friend/ContactChoosePanel:getContext	()Landroid/content/Context;
    //   59: aload_1
    //   60: invokevirtual 436	alw:a	(Landroid/content/Context;Lalw;)V
    //   63: return
    //   64: astore_2
    //   65: aconst_null
    //   66: invokestatic 423	arf:a	(Ljava/io/Closeable;)V
    //   69: goto -43 -> 26
    //   72: astore_1
    //   73: aconst_null
    //   74: invokestatic 423	arf:a	(Ljava/io/Closeable;)V
    //   77: aload_1
    //   78: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	22	64	java/lang/Exception
    //   9	22	72	finally
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.d.a();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.i == null) || (this.i.size() == 0))
      return;
    paramInt2 = zl.b((zl)this.i.get(paramInt1));
    if (paramInt1 != this.h)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.b.getLayoutParams();
      localMarginLayoutParams.topMargin = 0;
      this.b.setLayoutParams(localMarginLayoutParams);
      this.a.setText(b((zl)this.i.get(paramInt1)));
    }
    if ((paramInt1 + 1 < this.i.size()) && (paramInt2 != zl.b((zl)this.i.get(paramInt1 + 1))))
    {
      paramAbsListView = paramAbsListView.getChildAt(0);
      if (paramAbsListView != null)
      {
        paramInt2 = this.b.getHeight();
        paramInt3 = paramAbsListView.getBottom();
        paramAbsListView = (ViewGroup.MarginLayoutParams)this.b.getLayoutParams();
        if (paramInt3 >= paramInt2)
          break label198;
        paramAbsListView.topMargin = ((int)(paramInt3 - paramInt2));
        this.b.setLayoutParams(paramAbsListView);
      }
    }
    while (true)
    {
      this.h = paramInt1;
      return;
      label198: if (paramAbsListView.topMargin != 0)
      {
        paramAbsListView.topMargin = 0;
        this.b.setLayoutParams(paramAbsListView);
      }
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default:
      zj.a = false;
    case 0:
      do
      {
        return;
        zj.a = true;
      }
      while (!zj.b);
      zj.b = false;
      this.e.notifyDataSetChanged();
      return;
    case 2:
      zj.a = false;
      return;
    case 1:
    }
    zj.a = false;
  }

  public void setBaseActionListener(aqi paramaqi)
  {
    this.j = paramaqi;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.friend.ContactChoosePanel
 * JD-Core Version:    0.6.2
 */