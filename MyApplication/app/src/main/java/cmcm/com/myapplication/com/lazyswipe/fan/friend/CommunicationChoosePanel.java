package cmcm.com.myapplication.com.lazyswipe.fan.friend;

import alw;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListView;
import avx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import tk;
import vv;
import xd;
import yu;
import zh;

public class CommunicationChoosePanel extends FrameLayout
{
  private ListView a;
  private zh b;
  private List<yu> c;
  private List<Boolean> d;
  private long e;

  public CommunicationChoosePanel(Context paramContext)
  {
    super(paramContext);
  }

  public CommunicationChoosePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static void a(Context paramContext, final alw paramalw, final WeakReference<FriendSector> paramWeakReference)
  {
    CommunicationChoosePanel localCommunicationChoosePanel = (CommunicationChoosePanel)LayoutInflater.from(paramContext).inflate(2130968720, null, false);
    localCommunicationChoosePanel.setData(paramalw);
    new avx(paramContext).c(2131230926).a(localCommunicationChoosePanel).a(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (Math.abs(CommunicationChoosePanel.b(CommunicationChoosePanel.this) - System.currentTimeMillis()) < 200L)
          return;
        CommunicationChoosePanel.a(CommunicationChoosePanel.this, System.currentTimeMillis());
        CommunicationChoosePanel.this.a(paramalw);
        if ((paramWeakReference != null) && (paramWeakReference.get() != null))
          ((FriendSector)paramWeakReference.get()).d();
        paramAnonymousDialogInterface.dismiss();
      }
    }).e(17039360).f(-1).b();
  }

  // ERROR //
  private List<yu> b(alw paramalw)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 87	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 90	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: invokevirtual 94	com/lazyswipe/fan/friend/CommunicationChoosePanel:getContext	()Landroid/content/Context;
    //   15: invokevirtual 100	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: astore_3
    //   19: aload_1
    //   20: aload_3
    //   21: invokevirtual 105	alw:a	(Landroid/content/ContentResolver;)V
    //   24: getstatic 110	xd:a	Landroid/net/Uri;
    //   27: astore 5
    //   29: new 112	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   36: ldc 115
    //   38: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: getfield 121	alw:b	J
    //   45: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 6
    //   53: aload_3
    //   54: aload 5
    //   56: bipush 6
    //   58: anewarray 130	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: ldc 132
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: ldc 134
    //   70: aastore
    //   71: dup
    //   72: iconst_2
    //   73: ldc 136
    //   75: aastore
    //   76: dup
    //   77: iconst_3
    //   78: ldc 138
    //   80: aastore
    //   81: dup
    //   82: iconst_4
    //   83: ldc 140
    //   85: aastore
    //   86: dup
    //   87: iconst_5
    //   88: ldc 142
    //   90: aastore
    //   91: aload 6
    //   93: aconst_null
    //   94: aconst_null
    //   95: invokevirtual 148	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   98: astore_3
    //   99: aload_3
    //   100: astore_2
    //   101: aload_2
    //   102: invokeinterface 154 1 0
    //   107: ifeq +171 -> 278
    //   110: new 156	yu
    //   113: dup
    //   114: invokespecial 157	yu:<init>	()V
    //   117: astore_3
    //   118: aload_2
    //   119: iconst_0
    //   120: invokeinterface 161 2 0
    //   125: astore 6
    //   127: aload_2
    //   128: iconst_1
    //   129: invokeinterface 161 2 0
    //   134: astore 7
    //   136: aload_2
    //   137: iconst_2
    //   138: invokeinterface 161 2 0
    //   143: astore 5
    //   145: aload_3
    //   146: aload 7
    //   148: ldc 163
    //   150: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: invokevirtual 170	yu:a	(Z)V
    //   156: aload_3
    //   157: aload_1
    //   158: getfield 121	alw:b	J
    //   161: invokevirtual 173	yu:a	(J)V
    //   164: aload_3
    //   165: aload 6
    //   167: invokevirtual 176	yu:b	(Ljava/lang/String;)V
    //   170: aload_3
    //   171: aload_2
    //   172: iconst_3
    //   173: invokeinterface 161 2 0
    //   178: putfield 179	yu:a	Ljava/lang/String;
    //   181: aload_3
    //   182: aload_2
    //   183: iconst_4
    //   184: invokeinterface 161 2 0
    //   189: putfield 181	yu:b	Ljava/lang/String;
    //   192: aload_3
    //   193: aload_2
    //   194: iconst_5
    //   195: invokeinterface 161 2 0
    //   200: putfield 183	yu:c	Ljava/lang/String;
    //   203: aload 6
    //   205: invokestatic 188	zg:d	(Ljava/lang/String;)Lzg;
    //   208: astore 6
    //   210: aload 6
    //   212: ifnull -111 -> 101
    //   215: aload_3
    //   216: aload 6
    //   218: invokevirtual 191	zg:f	()Landroid/graphics/drawable/Drawable;
    //   221: invokevirtual 194	yu:a	(Landroid/graphics/drawable/Drawable;)V
    //   224: aload_3
    //   225: aload 6
    //   227: invokevirtual 196	zg:b	()Ljava/lang/String;
    //   230: invokevirtual 198	yu:c	(Ljava/lang/String;)V
    //   233: aload_3
    //   234: aload 6
    //   236: invokevirtual 201	zg:c	()I
    //   239: iconst_1
    //   240: iadd
    //   241: invokevirtual 204	yu:a	(I)V
    //   244: aload_3
    //   245: aload 5
    //   247: invokevirtual 206	yu:a	(Ljava/lang/String;)V
    //   250: aload 5
    //   252: invokevirtual 209	java/lang/String:isEmpty	()Z
    //   255: ifne -154 -> 101
    //   258: aload 4
    //   260: aload_3
    //   261: invokeinterface 214 2 0
    //   266: pop
    //   267: goto -166 -> 101
    //   270: astore_1
    //   271: aload_2
    //   272: invokestatic 219	arf:a	(Landroid/database/Cursor;)V
    //   275: aload 4
    //   277: areturn
    //   278: aload 4
    //   280: new 8	com/lazyswipe/fan/friend/CommunicationChoosePanel$2
    //   283: dup
    //   284: aload_0
    //   285: invokespecial 222	com/lazyswipe/fan/friend/CommunicationChoosePanel$2:<init>	(Lcom/lazyswipe/fan/friend/CommunicationChoosePanel;)V
    //   288: invokestatic 228	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   291: aload_2
    //   292: invokestatic 219	arf:a	(Landroid/database/Cursor;)V
    //   295: aload 4
    //   297: areturn
    //   298: astore_1
    //   299: aload_2
    //   300: invokestatic 219	arf:a	(Landroid/database/Cursor;)V
    //   303: aload_1
    //   304: athrow
    //   305: astore_1
    //   306: goto -7 -> 299
    //   309: astore_1
    //   310: aconst_null
    //   311: astore_2
    //   312: goto -41 -> 271
    //
    // Exception table:
    //   from	to	target	type
    //   101	210	270	java/lang/Exception
    //   215	267	270	java/lang/Exception
    //   278	291	270	java/lang/Exception
    //   11	99	298	finally
    //   101	210	305	finally
    //   215	267	305	finally
    //   278	291	305	finally
    //   11	99	309	java/lang/Exception
  }

  public void a(alw paramalw)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.c.iterator();
    int j = 0;
    yu localyu;
    long l;
    String str1;
    String str2;
    boolean bool;
    int i;
    if (localIterator.hasNext())
    {
      localyu = (yu)localIterator.next();
      l = localyu.d();
      str1 = localyu.c();
      str2 = localyu.a();
      bool = localyu.b();
      if (bool)
      {
        if (((Boolean)this.d.get(j)).booleanValue())
          break label291;
        localStringBuilder.append(str1).append(' ');
        i = 1;
      }
    }
    while (true)
    {
      label109: if (i != 0)
      {
        ContentValues localContentValues = new ContentValues();
        if (!bool)
          break label242;
        i = 1;
        localContentValues.put("is_enable", Integer.valueOf(i));
        getContext().getContentResolver().update(xd.a, localContentValues, "contact_id=? AND app=?", new String[] { String.valueOf(l), str1 });
        if (bool)
          break label248;
        paramalw.a(str1);
      }
      while (true)
      {
        label131: j += 1;
        break;
        if (!((Boolean)this.d.get(j)).booleanValue())
          break label291;
        localStringBuilder.append('-').append(str1).append(' ');
        i = 1;
        break label109;
        label242: i = 0;
        break label131;
        label248: paramalw.a(str1, str2, localyu.a, localyu.b, localyu.c);
      }
      if (localStringBuilder.length() > 0)
        vv.a().a("联系方式变更");
      return;
      label291: i = 0;
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }

  public void setData(alw paramalw)
  {
    this.a = ((ListView)findViewById(2131755404));
    this.c = b(paramalw);
    int j = this.c.size();
    this.d = new ArrayList(this.c.size());
    int i = 0;
    while (i < j)
    {
      this.d.add(Boolean.valueOf(((yu)this.c.get(i)).b()));
      i += 1;
    }
    this.b = new zh(this, getContext(), this.c);
    this.a.setAdapter(this.b);
    this.a.setOnItemClickListener(new OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = (yu)CommunicationChoosePanel.a(CommunicationChoosePanel.this).get(paramAnonymousInt);
        paramAnonymousView = (CheckBox)paramAnonymousView.findViewById(2131755406);
        if (!paramAnonymousView.isChecked());
        for (boolean bool = true; ; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          paramAnonymousAdapterView.a(paramAnonymousView.isChecked());
          return;
        }
      }
    });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.friend.CommunicationChoosePanel
 * JD-Core Version:    0.6.2
 */