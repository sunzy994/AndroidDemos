package cmcm.com.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class tk
{
  private static ColorStateList W;
  private int A;
  private int B;
  private ListAdapter C;
  private CharSequence[] D;
  private Cursor E;
  private String F;
  private DialogInterface.OnClickListener G;
  private int H;
  private OnItemSelectedListener I;
  private boolean J;
  private boolean[] K;
  private String L;
  private boolean M;
  private DialogInterface.OnMultiChoiceClickListener N;
  private Drawable O;
  private boolean P = true;
  private boolean Q;
  private String R;
  private DialogInterface.OnClickListener S;
  private int T;
  private int U;
  private ColorStateList V;
  private int X;
  private int Y;
  private int Z;
  protected final Context a;
  private int aa;
  private int ab = -1;
  private int ac;
  private int ad;
  private DialogInterface.OnShowListener ae;
  private boolean af = true;
  private Drawable ag;
  private int ah;
  private int ai;
  protected tj b;
  protected final LayoutInflater c;
  protected CharSequence d = null;
  public DialogInterface.OnCancelListener e;
  public DialogInterface.OnDismissListener f;
  protected CharSequence g;
  Drawable[] h;
  protected int i;
  protected int j;
  protected int k = 0;
  View l;
  View m;
  protected final int n;
  private CharSequence o;
  private DialogInterface.OnClickListener p;
  private CharSequence q;
  private DialogInterface.OnClickListener r;
  private CharSequence s;
  private DialogInterface.OnClickListener t;
  private int u;
  private DialogInterface.OnKeyListener v;
  private View w;
  private boolean x;
  private int y;
  private int z;

  public tk(Context paramContext)
  {
    this(paramContext, tv.HolaCustomDialog);
  }

  public tk(Context paramContext, int paramInt)
  {
    this.n = paramInt;
    this.a = paramContext;
    this.a.getTheme().applyStyle(paramInt, true);
    this.c = LayoutInflater.from(paramContext);
  }

  private tk a(Drawable[] paramArrayOfDrawable, CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.h = paramArrayOfDrawable;
    this.D = paramArrayOfCharSequence;
    this.H = paramInt;
    this.G = paramOnClickListener;
    this.M = true;
    return this;
  }

  private void a(ViewGroup paramViewGroup)
  {
    final ListView localListView = (ListView)this.c.inflate(tu.hola_custom_dialog_list, paramViewGroup, false);
    if (Build.VERSION.SDK_INT >= 11)
      localListView.setSelector(f());
    Object localObject;
    if (this.J)
      if (this.E == null)
      {
        localObject = new ArrayAdapter(this.a, tu.hola_custom_dialog_select_multi_choices, 16908308, this.D)
        {
          public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
          {
            paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
            if (tk.a(tk.this) != null)
            {
              int j = tk.a(tk.this)[paramAnonymousInt];
              int i = paramAnonymousInt;
              if (tk.this.l != null)
                i = paramAnonymousInt + 1;
              localListView.setItemChecked(i, j);
            }
            if (Build.VERSION.SDK_INT < 11)
              paramAnonymousView.setBackgroundDrawable(tk.this.f());
            return paramAnonymousView;
          }
        };
        if (this.G == null)
          break label391;
        localListView.setOnItemClickListener(new OnItemClickListener()
        {
          public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            tk.f(tk.this).onClick(tk.this.b, paramAnonymousInt);
            if (!tk.d(tk.this))
              tk.this.b.dismiss();
            while (tk.this.h == null)
              return;
            ListView localListView = (ListView)paramAnonymousAdapterView;
            paramAnonymousInt = localListView.getFirstVisiblePosition();
            long l1 = localListView.getItemIdAtPosition(paramAnonymousInt);
            long l2 = localListView.getItemIdAtPosition(localListView.getLastVisiblePosition());
            if ((tk.e(tk.this) >= l1) && (tk.e(tk.this) <= l2))
              ((CheckedTextView)((ViewGroup)paramAnonymousAdapterView.getChildAt((int)(tk.e(tk.this) - l1) + paramAnonymousInt)).getChildAt(1)).setChecked(false);
            tk.a(tk.this, (int)paramAnonymousLong);
            ((CheckedTextView)((ViewGroup)paramAnonymousView).getChildAt(1)).setChecked(true);
          }
        });
        label88: if (this.I != null)
          localListView.setOnItemSelectedListener(this.I);
        if (!this.M)
          break label414;
        localListView.setChoiceMode(1);
        label115: if (this.l != null)
          localListView.addHeaderView(this.l);
        if (this.m != null)
          localListView.addFooterView(this.m);
        localListView.setAdapter((ListAdapter)localObject);
        if (-1 != this.H)
          localListView.setItemChecked(this.H, true);
        if (!j())
          if (this.ab < 0)
            break label429;
      }
    label391: label414: label429: for (int i1 = this.ab; ; i1 = (int)this.a.getResources().getDimension(tr.hola_custom_dialog_window_padding))
    {
      localListView.setPadding(localListView.getPaddingLeft(), localListView.getPaddingTop(), localListView.getPaddingRight(), i1);
      paramViewGroup.addView(localListView);
      return;
      localObject = new CursorAdapter(this.a, this.E, false)
      {
        private final int c;
        private final int d;

        public void bindView(View paramAnonymousView, Context paramAnonymousContext, Cursor paramAnonymousCursor)
        {
          ((CheckedTextView)paramAnonymousView.findViewById(16908308)).setText(paramAnonymousCursor.getString(this.c));
          paramAnonymousView = localListView;
          int i = paramAnonymousCursor.getPosition();
          if (paramAnonymousCursor.getInt(this.d) == 1);
          for (boolean bool = true; ; bool = false)
          {
            paramAnonymousView.setItemChecked(i, bool);
            return;
          }
        }

        public View newView(Context paramAnonymousContext, Cursor paramAnonymousCursor, ViewGroup paramAnonymousViewGroup)
        {
          paramAnonymousContext = tk.this.c.inflate(tu.hola_custom_dialog_select_multi_choices, paramAnonymousViewGroup, false);
          if (Build.VERSION.SDK_INT < 11)
            paramAnonymousContext.setBackgroundDrawable(tk.this.f());
          return paramAnonymousContext;
        }
      };
      break;
      if (this.h == null)
      {
        if (this.M)
          i1 = tu.hola_custom_dialog_select_single_choice;
        while (true)
          if (this.E == null)
          {
            if (this.C != null)
            {
              localObject = this.C;
              break;
              i1 = tu.hola_custom_dialog_select_item;
              continue;
            }
            localObject = new ArrayAdapter(this.a, i1, 16908308, this.D)
            {
              public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
              {
                paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
                if (Build.VERSION.SDK_INT < 11)
                  paramAnonymousView.setBackgroundDrawable(tk.this.f());
                return paramAnonymousView;
              }
            };
            break;
          }
        localObject = new SimpleCursorAdapter(this.a, i1, this.E, new String[] { this.F }, new int[] { 16908308 })
        {
          public View newView(Context paramAnonymousContext, Cursor paramAnonymousCursor, ViewGroup paramAnonymousViewGroup)
          {
            paramAnonymousContext = super.newView(paramAnonymousContext, paramAnonymousCursor, paramAnonymousViewGroup);
            if (Build.VERSION.SDK_INT < 11)
              paramAnonymousContext.setBackgroundDrawable(tk.this.f());
            return paramAnonymousContext;
          }
        };
        break;
      }
      if (this.M);
      for (i1 = tu.hola_custom_dialog_select_single_choice_with_icon; ; i1 = tu.hola_custom_dialog_select_item_width_icon)
      {
        localObject = new ArrayAdapter(this.a, i1, 16908308, this.D)
        {
          public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
          {
            boolean bool = true;
            paramAnonymousView = (ViewGroup)super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
            if (Build.VERSION.SDK_INT < 11)
              paramAnonymousView.setBackgroundDrawable(tk.this.f());
            paramAnonymousInt = (int)getItemId(paramAnonymousInt);
            ((ImageView)paramAnonymousView.getChildAt(0)).setImageDrawable(tk.this.h[paramAnonymousInt]);
            if (tk.d(tk.this))
            {
              paramAnonymousViewGroup = (CheckedTextView)paramAnonymousView.getChildAt(1);
              if (paramAnonymousInt != tk.e(tk.this))
                break label98;
            }
            while (true)
            {
              paramAnonymousViewGroup.setChecked(bool);
              return paramAnonymousView;
              label98: bool = false;
            }
          }
        };
        break;
      }
      if (this.N == null)
        break label88;
      localListView.setOnItemClickListener(new OnItemClickListener()
      {
        public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if ((paramAnonymousLong >= 0L) && (tk.a(tk.this) != null) && (paramAnonymousLong < tk.a(tk.this).length))
          {
            int i = (int)paramAnonymousLong;
            boolean bool = localListView.isItemChecked(paramAnonymousInt);
            tk.a(tk.this)[i] = bool;
            tk.g(tk.this).onClick(null, i, bool);
          }
        }
      });
      break label88;
      if (!this.J)
        break label115;
      localListView.setChoiceMode(2);
      break label115;
    }
  }

  private void a(LinearLayout paramLinearLayout)
  {
    View localView;
    LinearLayout localLinearLayout;
    boolean bool;
    if (j())
    {
      localView = this.c.inflate(tu.hola_custom_dialog_button_panel, paramLinearLayout, false);
      localLinearLayout = (LinearLayout)localView.findViewById(ts.custom_dialog_button_container);
      localView.findViewById(ts.custom_dialog_horizontal_separator).setBackgroundColor(this.X);
      if (Build.VERSION.SDK_INT >= 14)
        break label92;
      bool = b(localLinearLayout, false);
      bool = c(localLinearLayout, bool);
      if (Build.VERSION.SDK_INT >= 14)
        break label103;
      a(localLinearLayout, bool);
    }
    while (true)
    {
      paramLinearLayout.addView(localView);
      return;
      label92: bool = a(localLinearLayout, false);
      break;
      label103: b(localLinearLayout, bool);
    }
  }

  private boolean a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.q == null)
      return paramBoolean;
    if (paramBoolean)
      b(paramViewGroup);
    Button localButton = (Button)this.c.inflate(tu.hola_custom_dialog_button, paramViewGroup, false);
    localButton.setId(ts.hola_custom_dialog_negative_button);
    localButton.setText(this.q);
    if (this.u == -2);
    for (ColorStateList localColorStateList = W; ; localColorStateList = this.V)
    {
      localButton.setTextColor(localColorStateList);
      localButton.setBackgroundDrawable(f());
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (tk.i(tk.this) != null)
          {
            tk.i(tk.this).onClick(tk.this.b, -2);
            return;
          }
          tj.b.onClick(tk.this.b, -2);
        }
      });
      paramViewGroup.addView(localButton);
      return true;
    }
  }

  private void b(ViewGroup paramViewGroup)
  {
    View localView = this.c.inflate(tu.hola_custom_dialog_button_separator, paramViewGroup, false);
    localView.findViewById(ts.custom_dialog_button_separator).setBackgroundColor(this.X);
    paramViewGroup.addView(localView);
  }

  private boolean b(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.o == null)
      return paramBoolean;
    if (paramBoolean)
      b(paramViewGroup);
    Button localButton = (Button)this.c.inflate(tu.hola_custom_dialog_button, paramViewGroup, false);
    localButton.setId(ts.hola_custom_dialog_positive_button);
    localButton.setText(this.o);
    if (this.u == -1);
    for (ColorStateList localColorStateList = W; ; localColorStateList = this.V)
    {
      localButton.setTextColor(localColorStateList);
      localButton.setBackgroundDrawable(f());
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (tk.j(tk.this) != null)
          {
            tk.j(tk.this).onClick(tk.this.b, -1);
            return;
          }
          tj.b.onClick(tk.this.b, -1);
        }
      });
      paramViewGroup.addView(localButton);
      return true;
    }
  }

  private boolean c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.s == null)
      return paramBoolean;
    if (paramBoolean)
      b(paramViewGroup);
    Button localButton = (Button)this.c.inflate(tu.hola_custom_dialog_button, paramViewGroup, false);
    localButton.setId(ts.hola_custom_dialog_neutral_button);
    localButton.setText(this.s);
    if (this.u == -3);
    for (ColorStateList localColorStateList = W; ; localColorStateList = this.V)
    {
      localButton.setTextColor(localColorStateList);
      localButton.setBackgroundDrawable(f());
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (tk.k(tk.this) != null)
          {
            tk.k(tk.this).onClick(tk.this.b, -3);
            return;
          }
          tj.b.onClick(tk.this.b, -3);
        }
      });
      paramViewGroup.addView(localButton);
      return true;
    }
  }

  private void h()
  {
    Object localObject = this.a.getResources();
    int i1 = ((Resources)localObject).getColor(tq.hola_custom_dialog_title_text_color_default);
    ((Resources)localObject).getColor(tq.hola_custom_dialog_title_separator_color_default);
    ColorStateList localColorStateList1 = ((Resources)localObject).getColorStateList(tq.hola_custom_dialog_button_text_color_default);
    ColorStateList localColorStateList2 = ((Resources)localObject).getColorStateList(tq.hola_custom_dialog_button_text_color_highlighted_default);
    int i2 = ((Resources)localObject).getColor(tq.hola_custom_dialog_button_separator_color_default);
    int i3 = ((Resources)localObject).getColor(tq.hola_custom_dialog_button_background_color_normal_default);
    int i4 = ((Resources)localObject).getColor(tq.hola_custom_dialog_button_background_color_pressed_default);
    int i5 = ((Resources)localObject).getColor(tq.hola_custom_dialog_button_background_color_focused_default);
    int i6 = ((Resources)localObject).getColor(tq.hola_custom_dialog_message_text_color_default);
    int i7 = ((Resources)localObject).getInteger(tt.hola_custom_dialog_message_text_min_lines_default);
    localObject = this.a.getTheme().obtainStyledAttributes(null, tw.HolaCustomDialog, tp.customDialogStyle, 0);
    this.T = ((TypedArray)localObject).getColor(tw.HolaCustomDialog_holaDialogTitleTextColor, i1);
    this.i = ((TypedArray)localObject).getColor(tw.HolaCustomDialog_holaDialogMessageTextColor, i6);
    this.U = ((TypedArray)localObject).getInt(tw.HolaCustomDialog_holaDialogMessageTextMinLines, i7);
    this.V = ((TypedArray)localObject).getColorStateList(tw.HolaCustomDialog_holaDialogButtonTextColor);
    if (this.V == null)
      this.V = localColorStateList1;
    W = ((TypedArray)localObject).getColorStateList(tw.HolaCustomDialog_holaDialogButtonTextColorHighlighted);
    if (W == null)
      W = localColorStateList2;
    this.X = ((TypedArray)localObject).getColor(tw.HolaCustomDialog_holaDialogButtonSeparatorColor, i2);
    this.Y = ((TypedArray)localObject).getColor(tw.HolaCustomDialog_holaDialogButtonBackgroundColorNormal, i3);
    this.Z = ((TypedArray)localObject).getColor(tw.HolaCustomDialog_holaDialogButtonBackgroundColorPressed, i4);
    this.aa = ((TypedArray)localObject).getColor(tw.HolaCustomDialog_holaDialogButtonBackgroundColorFocused, i5);
    ((TypedArray)localObject).recycle();
  }

  private View i()
  {
    View localView1 = this.c.inflate(tu.hola_custom_dialog, null, false);
    View localView3 = localView1.findViewById(ts.custom_dialog_title_panel);
    Object localObject = (TextView)localView1.findViewById(ts.custom_dialog_title);
    TextView localTextView = (TextView)localView1.findViewById(ts.custom_dialog_title_btn);
    View localView2 = localView1.findViewById(ts.custom_dialog_title_divider);
    if (this.d != null);
    try
    {
      ((TextView)localObject).setText(this.d);
      label69: ((TextView)localObject).setTextColor(this.T);
      if (this.O != null)
      {
        localObject = (ImageView)localView1.findViewById(ts.custom_dialog_icon);
        ((ImageView)localObject).setImageDrawable(this.O);
        ((ImageView)localObject).setVisibility(0);
      }
      localView2.setVisibility(0);
      if ((!TextUtils.isEmpty(this.R)) && (this.S != null))
      {
        localTextView.setText(this.R);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            tk.h(tk.this).onClick(tk.this.b, -1);
          }
        });
        localTextView.setVisibility(0);
      }
      while (true)
      {
        if ((this.ag != null) && (this.b != null) && (this.b.getWindow() != null))
        {
          this.b.getWindow().setBackgroundDrawable(this.ag);
          localView1.setBackgroundColor(0);
        }
        return localView1;
        localTextView.setVisibility(8);
        continue;
        localView3.setVisibility(8);
        localView2.setVisibility(8);
      }
    }
    catch (Throwable localThrowable)
    {
      break label69;
    }
  }

  private boolean j()
  {
    return (this.q != null) || (this.s != null) || (this.o != null);
  }

  public tj a()
  {
    this.b = d();
    a(this.b);
    return this.b;
  }

  public tk a(int paramInt)
  {
    return a(paramInt, 0, 0);
  }

  public tk a(int paramInt1, int paramInt2)
  {
    this.ac = paramInt1;
    this.ad = paramInt2;
    return this;
  }

  public tk a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.k = paramInt1;
    this.ah = paramInt2;
    this.ai = paramInt3;
    return this;
  }

  public tk a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.D = this.a.getResources().getTextArray(paramInt1);
    this.G = paramOnClickListener;
    this.H = paramInt2;
    this.M = true;
    return this;
  }

  public tk a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.o = this.a.getText(paramInt);
    this.p = paramOnClickListener;
    return this;
  }

  public tk a(int paramInt, String paramString)
  {
    if ((this.D == null) || (paramInt < 0) || (paramInt >= this.D.length));
    do
    {
      return this;
      localObject = this.D[paramInt];
    }
    while (((CharSequence)localObject).charAt(0) == '<');
    String str = "<font color='#9e32c9'>" + localObject;
    Object localObject = str;
    if (!TextUtils.isEmpty(paramString))
      localObject = str + paramString;
    paramString = (String)localObject + "</font>";
    this.D[paramInt] = Html.fromHtml(paramString);
    return this;
  }

  public tk a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.e = paramOnCancelListener;
    return this;
  }

  public tk a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.f = paramOnDismissListener;
    return this;
  }

  public tk a(Drawable paramDrawable)
  {
    this.ag = paramDrawable;
    return this;
  }

  public tk a(View paramView)
  {
    this.w = paramView;
    this.x = false;
    return this;
  }

  public tk a(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    return this;
  }

  public tk a(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.o = paramCharSequence;
    this.p = paramOnClickListener;
    return this;
  }

  public tk a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.R = paramString;
    this.S = paramOnClickListener;
    return this;
  }

  public tk a(boolean paramBoolean)
  {
    this.af = paramBoolean;
    return this;
  }

  public tk a(Drawable[] paramArrayOfDrawable, CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.h = paramArrayOfDrawable;
    this.D = paramArrayOfCharSequence;
    this.G = paramOnClickListener;
    return this;
  }

  public tk a(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    return a(null, paramArrayOfCharSequence, paramInt, paramOnClickListener);
  }

  public tk a(CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    return a(null, paramArrayOfCharSequence, paramOnClickListener);
  }

  public tk a(CharSequence[] paramArrayOfCharSequence1, CharSequence[] paramArrayOfCharSequence2, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    CharSequence[] arrayOfCharSequence = new CharSequence[paramArrayOfCharSequence1.length];
    int i1 = 0;
    while (i1 < arrayOfCharSequence.length)
    {
      arrayOfCharSequence[i1] = Html.fromHtml("<font color='#000000'>" + paramArrayOfCharSequence1[i1] + "</font>" + "<br/>" + "<small><font color='#696969'>" + paramArrayOfCharSequence2[i1] + "</font></small>");
      i1 += 1;
    }
    return a(null, arrayOfCharSequence, paramInt, paramOnClickListener);
  }

  public void a(Dialog paramDialog)
  {
    int i2 = 1;
    int i3 = 0;
    h();
    View localView = e();
    if (this.Q)
      paramDialog.setCanceledOnTouchOutside(this.Q);
    while (true)
    {
      if (this.e != null)
        paramDialog.setOnCancelListener(this.e);
      if (this.f != null)
        paramDialog.setOnDismissListener(this.f);
      if (this.ae != null)
        paramDialog.setOnShowListener(this.ae);
      if (this.v != null)
        paramDialog.setOnKeyListener(this.v);
      Window localWindow = paramDialog.getWindow();
      if (!this.af)
        localWindow.clearFlags(2);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      if ((this.j >= 1) && (this.j <= 2999))
        localLayoutParams.type = this.j;
      if (this.k != 0)
        localLayoutParams.gravity = this.k;
      int i1;
      if (this.ai > 0)
      {
        if ((this.k & 0x30) == 0)
          break label362;
        i1 = 1;
        label174: if ((this.k & 0x50) == 0)
          break label368;
        label184: if (i1 != 0)
          localView.setPadding(0, this.ai, 0, 0);
        if (i2 != 0)
          localView.setPadding(0, 0, 0, this.ai);
      }
      try
      {
        localWindow.setContentView(localView);
        label224: i1 = i3;
        if (Build.VERSION.SDK_INT > 15)
        {
          i1 = this.a.getResources().getDisplayMetrics().widthPixels;
          if (i1 > 480);
        }
        else
        {
          if (this.w == null)
            break label374;
        }
        label362: label368: label374: for (paramDialog = this.w.getLayoutParams(); ; paramDialog = null)
        {
          if ((paramDialog == null) || (paramDialog.width <= 0) || (paramDialog.height <= 0))
          {
            i2 = i1;
            if (i1 == 0)
              i2 = this.a.getResources().getDisplayMetrics().widthPixels;
            localLayoutParams.width = (i2 - (this.a.getResources().getDimensionPixelSize(tr.hola_custom_dialog_window_padding) << 1));
          }
          localWindow.setAttributes(localLayoutParams);
          return;
          if (this.P)
            break;
          paramDialog.setCancelable(this.P);
          break;
          i1 = 0;
          break label174;
          i2 = 0;
          break label184;
        }
      }
      catch (Throwable paramDialog)
      {
        break label224;
      }
    }
  }

  public tj b()
  {
    a();
    try
    {
      this.b.show();
      if (this.ad >= 3)
        c();
      tj localtj = this.b;
      return localtj;
    }
    catch (Throwable localThrowable)
    {
      Log.w("CustomDialog", "Failed to show the dialog", localThrowable);
    }
    return null;
  }

  public tk b(int paramInt)
  {
    this.j = paramInt;
    return this;
  }

  public tk b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.q = this.a.getText(paramInt);
    this.r = paramOnClickListener;
    return this;
  }

  public tk b(Drawable paramDrawable)
  {
    this.O = paramDrawable;
    return this;
  }

  public tk b(View paramView)
  {
    this.m = paramView;
    return this;
  }

  public tk b(CharSequence paramCharSequence)
  {
    this.g = paramCharSequence;
    return this;
  }

  public tk b(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.q = paramCharSequence;
    this.r = paramOnClickListener;
    return this;
  }

  public tk b(boolean paramBoolean)
  {
    this.P = paramBoolean;
    return this;
  }

  public tk c(int paramInt)
  {
    this.d = this.a.getText(paramInt);
    return this;
  }

  public tk c(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.s = paramCharSequence;
    this.t = paramOnClickListener;
    return this;
  }

  public tk c(boolean paramBoolean)
  {
    this.Q = paramBoolean;
    return this;
  }

  protected void c()
  {
    switch (this.ac)
    {
    default:
      this.ac = 0;
    case -2:
    case -3:
    case -1:
    }
    while (true)
    {
      this.b.a = new Handler(this.b);
      tj.a(this.b, this.ad, this.ac, this.ad);
      return;
      if (this.q == null)
      {
        this.ac = 0;
        continue;
        if (this.s == null)
        {
          this.ac = 0;
          continue;
          if (this.o == null)
            this.ac = 0;
        }
      }
    }
  }

  protected tj d()
  {
    return new tj(this.a, this.n);
  }

  public tk d(int paramInt)
  {
    return a(paramInt, null);
  }

  protected View e()
  {
    View localView = i();
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(ts.custom_dialog_content);
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(this.g))
    {
      localObject1 = this.c.inflate(tu.hola_custom_dialog_message, localLinearLayout, false);
      localObject2 = (TextView)((View)localObject1).findViewById(ts.custom_dialog_message);
      ((TextView)localObject2).setTextColor(this.i);
      ((TextView)localObject2).setText(this.g);
      ((TextView)localObject2).setMinLines(this.U);
      localLinearLayout.addView((View)localObject1);
    }
    if (this.w != null)
    {
      localObject1 = new LinearLayout(this.a);
      ((LinearLayout)localObject1).setGravity(17);
      if (this.w.getLayoutParams() == null)
        break label212;
      ((LinearLayout)localObject1).addView(this.w);
      if (this.x)
        ((LinearLayout)localObject1).setPadding(this.y, this.z, this.A, this.B);
      if (!(this.w instanceof ListView))
        break label258;
      localLinearLayout.addView((View)localObject1, new LinearLayout.LayoutParams(-1, -2, 1.0F));
    }
    while (true)
    {
      if ((this.D != null) || (this.C != null) || (this.E != null))
        a(localLinearLayout);
      a(localLinearLayout);
      return localView;
      label212: localObject2 = this.w;
      if ((this.w instanceof ListView));
      for (int i1 = -1; ; i1 = -2)
      {
        ((LinearLayout)localObject1).addView((View)localObject2, new LinearLayout.LayoutParams(i1, -2));
        break;
      }
      label258: localLinearLayout.addView((View)localObject1);
    }
  }

  public tk e(int paramInt)
  {
    return b(paramInt, null);
  }

  protected StateListDrawable f()
  {
    ColorDrawable localColorDrawable1 = new ColorDrawable(this.Y);
    ColorDrawable localColorDrawable2 = new ColorDrawable(this.Z);
    ColorDrawable localColorDrawable3 = new ColorDrawable(this.aa);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localColorDrawable2);
    localStateListDrawable.addState(new int[] { 16842908 }, localColorDrawable3);
    localStateListDrawable.addState(new int[] { 16842910 }, localColorDrawable1);
    return localStateListDrawable;
  }

  public tk f(int paramInt)
  {
    this.u = paramInt;
    return this;
  }

  public tk g(int paramInt)
  {
    this.g = this.a.getText(paramInt);
    return this;
  }

  public tk h(int paramInt)
  {
    this.i = paramInt;
    return this;
  }

  public tk i(int paramInt)
  {
    this.ab = paramInt;
    return this;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     tk
 * JD-Core Version:    0.6.2
 */