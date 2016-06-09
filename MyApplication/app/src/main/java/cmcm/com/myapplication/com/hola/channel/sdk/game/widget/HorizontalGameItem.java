package cmcm.com.myapplication.com.hola.channel.sdk.game.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import pe;
import pi;
import qh;
import qn;
import qr;
import qu;
import qx;
import rn;
import ro;
import ry;
import sa;
import sn;
import sz;
import tb;
import td;
import te;
import tf;
import tg;

public class HorizontalGameItem extends RelativeLayout
  implements OnClickListener
{
  private static final String f = "GameSDK." + HorizontalGameItem.class.getSimpleName();
  public ImageView a;
  public TextView b;
  public TextView c;
  public TextView d;
  public TextView e;

  public HorizontalGameItem(Context paramContext)
  {
    super(paramContext);
  }

  public HorizontalGameItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public HorizontalGameItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public HorizontalGameItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public static HorizontalGameItem a(Context paramContext, ViewGroup paramViewGroup)
  {
    return (HorizontalGameItem)qx.a(paramContext, tf.hola_game_list_item, paramViewGroup, false);
  }

  public static void a(final Context paramContext, View paramView)
  {
    rn localrn = rn.a(paramContext);
    String str = (String)paramView.getTag();
    if (!qu.a(paramContext))
    {
      qu.a(paramContext, true, new qh()
      {
        public void a(Object paramAnonymousObject)
        {
        }

        public void a(final pi paramAnonymouspi)
        {
          super.a(paramAnonymouspi);
          qn.a(new Runnable()
          {
            public void run()
            {
              Context localContext = HorizontalGameItem.this;
              if (paramAnonymouspi != null);
              for (String str = paramAnonymouspi.getMessage(); ; str = "Unknown error")
              {
                Toast.makeText(localContext, str, 0).show();
                return;
              }
            }
          });
        }
      });
      paramContext = new ro()
      {
        public void a()
        {
        }

        public boolean a(Cursor paramAnonymousCursor)
        {
          if ((paramAnonymousCursor != null) && (paramAnonymousCursor.moveToFirst()))
          {
            paramAnonymousCursor = paramAnonymousCursor.getString(0);
            if (!TextUtils.isEmpty(paramAnonymousCursor))
              paramAnonymousCursor = new Intent("android.intent.action.VIEW").setData(Uri.parse(paramAnonymousCursor)).addFlags(268435456);
          }
          try
          {
            paramContext.startActivity(paramAnonymousCursor);
            label58: return true;
          }
          catch (Throwable paramAnonymousCursor)
          {
            break label58;
          }
        }
      };
      localrn.a(str, new String[] { "webUrl" }, paramContext);
    }
    do
    {
      return;
      switch (((Integer)paramView.getTag(te.hola_game_list_button_tag_key)).intValue())
      {
      default:
        return;
      case 0:
      case 3:
      case 1:
      case 2:
      }
    }
    while (sn.a(paramContext).a(paramContext, str, paramView));
    a(paramContext, localrn, str);
    return;
    a(paramContext, localrn, str);
    return;
    sn.a(paramContext).a(paramContext, str, 6);
  }

  public static void a(Context paramContext, ImageView paramImageView, TextView paramTextView, Cursor paramCursor)
  {
    if ((paramCursor.isAfterLast()) || (paramCursor.isBeforeFirst()))
      return;
    String str = paramCursor.getString(4);
    paramTextView.setTag(str);
    int i;
    Resources localResources;
    label104: int j;
    if ((paramCursor.isNull(6)) || ((!paramCursor.isNull(9)) && (paramCursor.getInt(9) == 1)))
    {
      i = 0;
      localResources = paramContext.getResources();
      switch (i)
      {
      default:
        i = tg.hola_game_load;
        j = td.hola_game_hollow_button_background;
        paramTextView.setTextColor(localResources.getColorStateList(tb.hola_game_hollow_button_text_color));
        paramTextView.setTag(te.hola_game_list_button_tag_key, Integer.valueOf(0));
        paramTextView.setText(i);
        paramTextView.setBackgroundResource(j);
      case 3:
      case 2:
      case 1:
      }
    }
    while (true)
    {
      paramImageView.setScaleType(ScaleType.CENTER_INSIDE);
      ry.a(paramContext).a(paramCursor.getString(2)).a().a(paramImageView);
      return;
      i = paramCursor.getInt(6);
      break;
      i = tg.hola_game_loading_paused;
      j = td.hola_game_hollow_button_background;
      paramTextView.setTextColor(localResources.getColorStateList(tb.hola_game_hollow_button_text_color));
      paramTextView.setTag(te.hola_game_list_button_tag_key, Integer.valueOf(3));
      paramTextView.setText(i);
      paramTextView.setBackgroundResource(j);
      continue;
      i = tg.hola_common_percent;
      j = td.hola_game_solid_button_background;
      paramTextView.setTextColor(localResources.getColor(tb.hola_game_solid_button_text_color));
      paramTextView.setTag(te.hola_game_list_button_tag_key, Integer.valueOf(2));
      paramTextView.setText(localResources.getString(i, new Object[] { Integer.valueOf(paramCursor.getInt(7)) }));
      paramTextView.setBackgroundResource(j);
      sn.a(paramContext).a(str, paramTextView);
      continue;
      if ((qr.b(paramContext)) && (1 != paramCursor.getInt(8)))
        break label104;
      i = tg.hola_game_play;
      j = td.hola_game_solid_button_background;
      paramTextView.setTextColor(localResources.getColor(tb.hola_game_solid_button_text_color));
      paramTextView.setTag(te.hola_game_list_button_tag_key, Integer.valueOf(1));
      paramTextView.setText(i);
      paramTextView.setBackgroundResource(j);
    }
  }

  private static void a(Context paramContext, rn paramrn, String paramString)
  {
    paramrn.a(paramString, new ro()
    {
      public void a()
      {
      }

      public boolean a(Cursor paramAnonymousCursor)
      {
        if ((paramAnonymousCursor != null) && (paramAnonymousCursor.moveToFirst()))
          sz.a(HorizontalGameItem.this, pe.a(paramAnonymousCursor));
        return true;
      }
    });
  }

  public void a(Cursor paramCursor)
  {
    this.b.setText(paramCursor.getString(1));
    this.d.setText(paramCursor.getString(3));
    this.c.setText(getResources().getString(tg.hola_game_players, new Object[] { Integer.valueOf(paramCursor.getInt(5)) }));
    a(getContext(), this.a, this.e, paramCursor);
  }

  public void onClick(View paramView)
  {
    a(getContext(), paramView);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)qx.a(this, te.hg_icon));
    this.b = ((TextView)qx.a(this, te.hg_title));
    this.c = ((TextView)qx.a(this, te.hg_text1));
    this.e = ((TextView)qx.a(this, te.hg_action));
    this.d = ((TextView)qx.a(this, te.hg_text2));
    this.e.setOnClickListener(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.widget.HorizontalGameItem
 * JD-Core Version:    0.6.2
 */