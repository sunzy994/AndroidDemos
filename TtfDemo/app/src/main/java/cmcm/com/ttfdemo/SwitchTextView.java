package cmcm.com.ttfdemo;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;


public class SwitchTextView extends TextView {

    private Paint mRedDotPaint = new Paint();
    private Paint mTextPaint = new Paint();
    private Paint mRectPaint = new Paint();
    private int mOriTextViewHeight;
    private Drawable mTopDrawable;
    private Context mContext;

    public SwitchTextView(Context context) {
        super(context);
        mContext = context;
        initParams();
    }

    public SwitchTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initParams();
    }

    public SwitchTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        initParams();
    }

    private void initParams() {
        mRedDotPaint.setAntiAlias(true);
        mRectPaint.setAntiAlias(true);
        mRectPaint.setColor(Color.parseColor("#eb5347"));
        mTextPaint.setTextSize(DimenUtils.sp2px(mContext, 11));
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setAntiAlias(true);
    }

    public void setPadding() {
        int height = getHeight();
        Drawable topDrawable = getCompoundDrawables()[1];
        if (mOriTextViewHeight == height
                &&  mTopDrawable == topDrawable ) {
            return;
        }
        mOriTextViewHeight = height;
        mTopDrawable = topDrawable;
        int topDrawableHeight = topDrawable == null ? 0 :topDrawable.getBounds().height();
        FontMetrics fm = getPaint().getFontMetrics();
        int divideHeight = getCompoundDrawablePadding();
        float fontHeight = (float) Math.ceil(fm.descent - fm.ascent);
        int topPadding = (int) ((mOriTextViewHeight - topDrawableHeight - divideHeight - fontHeight)/2+0.5f);
        setPadding(getPaddingLeft(), topPadding + DimenUtils.dp2pxScaleH(mContext,3.5f), getPaddingRight(), getPaddingBottom());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setPadding();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
