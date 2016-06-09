
package cmcm.com.ttfdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Field;


public class DimenUtils {

    public static final int DENSITY_LOW = 120;
    public static final int DENSITY_MEDIUM = 160;
    public static final int DENSITY_HIGH = 240;
    public static final int DENSITY_XHIGH = 320;

    private static final int DP_TO_PX = TypedValue.COMPLEX_UNIT_DIP;
    private static final int SP_TO_PX = TypedValue.COMPLEX_UNIT_SP;
    private static final int PX_TO_DP = TypedValue.COMPLEX_UNIT_MM + 1;
    private static final int PX_TO_SP = TypedValue.COMPLEX_UNIT_MM + 2;
    private static final int DP_TO_PX_SCALE_H = TypedValue.COMPLEX_UNIT_MM + 3;
    private static final int DP_SCALE_H = TypedValue.COMPLEX_UNIT_MM + 4;
    private static final int DP_TO_PX_SCALE_W = TypedValue.COMPLEX_UNIT_MM + 5;

    // -- dimens convert

    private static float applyDimension(Context context, int unit, float value, DisplayMetrics metrics) {
        switch (unit) {
            case DP_TO_PX:
            case SP_TO_PX:
                return TypedValue.applyDimension(unit, value, metrics);
            case PX_TO_DP:
                return value / metrics.density;
            case PX_TO_SP:
                return value / metrics.scaledDensity;
            case DP_TO_PX_SCALE_H:
                return TypedValue.applyDimension(DP_TO_PX, value * getScaleFactorH(context), metrics);
            case DP_SCALE_H:
                return value * getScaleFactorH(context);
            case DP_TO_PX_SCALE_W:
                return TypedValue.applyDimension(DP_TO_PX, value * getScaleFactorW(context), metrics);
        }
        return 0;
    }

    public static int dp2px(Context context, float value) {
        return (int) applyDimension(context, DP_TO_PX, value, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float value) {
        return (int) applyDimension(context, SP_TO_PX, value, context.getResources().getDisplayMetrics());
    }

    public static int px2dp(Context context, float value) {
        return (int) applyDimension(context, PX_TO_DP, value, context.getResources().getDisplayMetrics());
    }

    public static int px2sp(Context context, float value) {
        return (int) applyDimension(context, PX_TO_SP, value, context.getResources().getDisplayMetrics());
    }

    public static int dp2pxScaleW(Context context, float value) {
        return (int) applyDimension(context, DP_TO_PX_SCALE_W, value, context.getResources().getDisplayMetrics());
    }

    public static int dp2pxScaleH(Context context, float value) {
        return (int) applyDimension(context, DP_TO_PX_SCALE_H, value, context.getResources().getDisplayMetrics());
    }

    public static int dpScaleH(Context context, float value) {
        return (int) applyDimension(context, DP_SCALE_H, value, context.getResources().getDisplayMetrics());
    }

    public final static float BASE_SCREEN_WIDH = 720f;
    public final static float BASE_SCREEN_HEIGHT = 1280f;
    public final static float BASE_SCREEN_DENSITY = 2f;
    public static Float sScaleW, sScaleH;

//    public static float getScaleFactorWithoutDip() {
//        return getScaleFactorW() * DimenUtils.getDensity();
//    }

    /**
     * 如果要计算的值已经经过dip计算，则使用此结果，如果没有请使用getScaleFactorWithoutDip
     */
    public static float getScaleFactorW(Context context) {
        if (sScaleW == null) {
            sScaleW = (getScreenWidth(context) * BASE_SCREEN_DENSITY) / (getDensity(context) * BASE_SCREEN_WIDH);
        }
        return sScaleW;
    }

    public static float getScaleFactorH(Context context) {
        if (sScaleH == null) {
            sScaleH = (getScreenHeight(context) * BASE_SCREEN_DENSITY)
                    / (getDensity(context) * BASE_SCREEN_HEIGHT);
        }
        return sScaleH;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static void updateLayout(View view, int w, int h) {
        if (view == null)
            return;
        LayoutParams params = view.getLayoutParams();
        if (params == null)
            return;
        if (w != -3)
            params.width = w;
        if (h != -3)
            params.height = h;
        view.setLayoutParams(params);
    }

    public static void updateLayoutMargin(View view, int l, int t, int r, int b) {
        if (view == null)
            return;
        LayoutParams params = view.getLayoutParams();
        if (params == null)
            return;
        if (params instanceof RelativeLayout.LayoutParams) {
            updateMargin(view, (RelativeLayout.LayoutParams) params, l, t, r, b);
        } else if (params instanceof LinearLayout.LayoutParams) {
            updateMargin(view, (LinearLayout.LayoutParams) params, l, t, r, b);
        } else if (params instanceof FrameLayout.LayoutParams) {
            updateMargin(view, (FrameLayout.LayoutParams) params, l, t, r, b);
        }
    }

    private static void updateMargin(View view, ViewGroup.MarginLayoutParams params, int l, int t,
            int r, int b) {
        if (view == null)
            return;
        if (l != -3)
            params.leftMargin = l;
        if (t != -3)
            params.topMargin = t;
        if (r != -3)
            params.rightMargin = r;
        if (b != -3)
            params.bottomMargin = b;
        view.setLayoutParams(params);
    }

    public static void createListviewLayout(View view, int w, int h) {
        if (view == null)
            return;
        ListView.LayoutParams lp = (ListView.LayoutParams) view.getLayoutParams();
        if (lp == null) {
            if (w == -3)
                w = ListView.LayoutParams.MATCH_PARENT;
            if (h == -3)
                h = ListView.LayoutParams.MATCH_PARENT;
            lp = new ListView.LayoutParams(w, h);
            view.setLayoutParams(lp);
        }
    }

//    public static void updateRelativeLeftToRight(View leftview, int leftMargin, View rightview,
//            int rightMargin, int between) {
//        if (leftview == null || rightview == null)
//            return;
//        RelativeLayout.LayoutParams lpLeft = (RelativeLayout.LayoutParams) leftview
//                .getLayoutParams();
//        lpLeft.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//        lpLeft.leftMargin = leftMargin;
//        lpLeft.rightMargin = between;
//        // clear before
//        lpLeft.addRule(RelativeLayout.RIGHT_OF, -1);
//        leftview.setLayoutParams(lpLeft);
//
//        RelativeLayout.LayoutParams lpRight = (RelativeLayout.LayoutParams) rightview
//                .getLayoutParams();
//        lpRight.addRule(RelativeLayout.RIGHT_OF, leftview.getId());
//        lpRight.rightMargin = rightMargin;
//        // clear before
//        lpRight.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
//        lpRight.leftMargin = 0;
//        rightview.setLayoutParams(lpRight);
//    }

    public static void disappearLayout(View view) {
        updateLayoutMargin(view, 0, 0, 0, 0);
        updateLayout(view, 0, 0);
    }

    // -- window dimens

    public static boolean isLowDensity(Context context) {
        float densityDpi = context.getResources().getDisplayMetrics().densityDpi;
        if (densityDpi == DENSITY_LOW || densityDpi == DENSITY_MEDIUM) {
            // Log.d("show", "low density");
            return true;
        }
        return false;
    }

//    public static boolean isDensity120() {
//        float densityDpi = context.getResources().getDisplayMetrics().densityDpi;
//        if (densityDpi == DENSITY_LOW) {
//            return true;
//        }
//        return false;
//    }

    public static int getStatusBarHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

//    public static int getStatusBarHeight(View view) {
//        Rect rect = new Rect();
//        view.getWindowVisibleDisplayFrame(rect);
//        return rect.top;
//    }
    /**
     * 获取屏幕英寸数
     * @return 屏幕英寸数
     */
    public static double getDiagonalInch(Context context)
    {
        int width = context.getResources().getDisplayMetrics().widthPixels;  // 屏幕宽度（像素） 
        int height = context.getResources().getDisplayMetrics().heightPixels;  // 屏幕高度（像素） 
        int densityDpi = context.getResources().getDisplayMetrics().densityDpi;  // 屏幕密度DPI（120 / 160 / 240） 
        double screenSize = Math.sqrt(Math.pow(width, 2)+Math.pow(height, 2))/densityDpi; 
        return screenSize;
    }
    public static int getWindowWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getWindowHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

//    public static int getContentHeight(Activity activity) {
//        int height = context.getResources().getDisplayMetrics().heightPixels - getStatusBarHeight(activity);
//        return height;
//    }

    public static String getRatio(Context context) {
        String ratio = String.format("%s*%s", context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels);
        return ratio;
    }
    
    /**
     * @return 小尺寸
     */
    public static boolean isSmallSize(Context context)
    {
        int width = context.getResources().getDisplayMetrics().widthPixels;  // 屏幕宽度（像素） 
        int height = context.getResources().getDisplayMetrics().heightPixels;  // 屏幕高度（像素）
        if (width * height <= 480 * 800) {
            return true;
        }
        return false;
    }

	public static void setTextAutoFitWidth(TextView textView, String text, int textWidth, int maxTextSizeSp, int minTextSizeSp) {
		if (textView == null) {
			return;
		}
		if (!TextUtils.isEmpty(text) && textWidth > 0 && maxTextSizeSp >= minTextSizeSp) {
			int availableWidth = px2sp(textView.getContext(), textWidth - textView.getCompoundPaddingLeft() - textView.getCompoundPaddingRight());
			float trySize = maxTextSizeSp;
			textView.getPaint().setTextSize(trySize);
			while ((trySize > minTextSizeSp) && (textView.getPaint().measureText(text) >= availableWidth)) {
				trySize--;
				if (trySize <= minTextSizeSp) {
					trySize = minTextSizeSp;
					textView.setEllipsize(TextUtils.TruncateAt.END);
					break;
				}
				textView.getPaint().setTextSize(trySize);
			}
			textView.setTextSize(trySize);
			textView.setText(text);
		} else {
			textView.setText(text);
		}
	}
}
