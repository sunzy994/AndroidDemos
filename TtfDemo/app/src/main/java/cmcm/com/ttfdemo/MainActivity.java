package cmcm.com.ttfdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.layout).setBackgroundDrawable(new BitmapDrawable(createBitmapByTypeFace(this)));
    }

    private static Bitmap createBitmapByTypeFace(Context context) {
        Bitmap out = null;
        Typeface cacheTypeface = getTypefaceFromAsset(context, "cm-icons-notification.ttf");
        SwitchTextView bitmapTextView = new SwitchTextView(context);
        bitmapTextView.setTypeface(cacheTypeface);
        bitmapTextView.setText(unicode2String("e901"));
//		bitmapTextView.setBackgroundColor(Color.RED);
        bitmapTextView.setTextColor(Color.BLACK);
        bitmapTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        //bitmapTextView.setBackgroundDrawable(new SwitchBackgroundView(context,DimenUtils.dp2px(context, bitmapW), DimenUtils.dp2px(context, bitmapW), bgColor,strokeColor));
        bitmapTextView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        bitmapTextView.measure(View.MeasureSpec.makeMeasureSpec(DimenUtils.dp2px(context, 100), View.MeasureSpec.AT_MOST),
                View.MeasureSpec.makeMeasureSpec(DimenUtils.dp2px(context, 100), View.MeasureSpec.AT_MOST));
        bitmapTextView.layout(0, 0, DimenUtils.dp2px(context, 100), DimenUtils.dp2px(context, 100));
        bitmapTextView.setDrawingCacheEnabled(true);
        Bitmap src = bitmapTextView.getDrawingCache();
        out = Bitmap.createBitmap(src);
        bitmapTextView.setDrawingCacheEnabled(false);
        bitmapTextView.destroyDrawingCache();
        bitmapTextView = null;
        return out;
    }

    private static Typeface getTypefaceFromAsset(Context context, String typefaceName) {
        try {
            return Typeface.createFromAsset(context.getAssets(), typefaceName);
        } catch (Exception e) {
            Log.wtf("sunzy", e);
//            MyCrashHandler.getInstance().throwOne(e, true);
            return null;
//			throw new  NullPointerException("create typeface fail name:" +typefaceName );
        }
    }

    public static String unicode2String(String unicodeStr) {
        try {
            StringBuffer sb = new StringBuffer();
            String str[] = unicodeStr.toUpperCase().split("U");
            for (int i = 0; i < str.length; i++) {
                if (str[i].equals(""))
                    continue;
                char c = (char) Integer.parseInt(str[i].trim(), 16);
                sb.append(c);
            }
            return sb.toString();
        } catch (NumberFormatException e) {
            Log.wtf("sunzy", e);
            return "";
        }
    }
}
