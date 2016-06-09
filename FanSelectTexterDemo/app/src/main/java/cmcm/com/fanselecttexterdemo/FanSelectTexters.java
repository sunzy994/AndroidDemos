package cmcm.com.fanselecttexterdemo;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by blue on 15-9-14.
 */
public class FanSelectTexters extends ViewGroup {

    float mWidth = 0f;
    float mOriginWidth = 0f;
    private boolean mIsLeft = false;

    private Paint mFan;
    private Paint mPoint;
    private Rect mBackRect = new Rect();
    private Rect mIceRect = new Rect();


    private static final int COLOR_START = 0xFF0C5497;
    private static final int COLOR_END = 0xFFFFFFFF;
    public static float TOTAL_DEGREE = 79;
    private float OFFSET_DEGREE = 100 - TOTAL_DEGREE;
    private static final float WIDTH_OFFSET = 180;
    private float mNewDegree = 0f;
    private static final long COLOR_DURING = 5000;
    private ArgbEvaluator mEvaluator = new ArgbEvaluator();

    public FanSelectTexters(Context context) {
        this(context, null);
    }

    public FanSelectTexters(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setLayerType(View.LAYER_TYPE_HARDWARE, null);

        mFan = new Paint(Paint.ANTI_ALIAS_FLAG);
        mFan.setStyle(Paint.Style.FILL);
        mFan.setColor(Color.GREEN);

        mPoint = new Paint();
        mPoint.setStyle(Paint.Style.STROKE);
        mPoint.setStrokeWidth(5);
        mPoint.setColor(Color.RED);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        float px = 0f;
        float py = 0f;
        if (mIsLeft) {
            px = mWidth / 100 * 38;
            py = mWidth - px;
        } else {
            px = mWidth - mWidth / 100 * 38;
            py = px;
        }
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            float childWidth = view.getMeasuredWidth();
            float childHeight = view.getMeasuredHeight();
            view.layout((int) (px - childWidth / 2f), (int) (py - childHeight / 2f),
                    (int) (px + childWidth / 2f), (int) (py + childHeight / 2f));
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(0 == oldw || 0 == oldh){
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(null != mOnTypeGetter){
                        setRotated(0, mOnTypeGetter.getCurrentType());
                    }
                }
            },50);
        }
    }

//    @Override
//    public void draw(Canvas canvas) {
//        if (null != mBack && !mBack.isRecycled()) {
//            if (!mIsLeft) {
//                canvas.save();
//                canvas.scale(-1f, 1f, mBackRect.centerX(), mBackRect.centerY());
//            }
//            canvas.drawBitmap(mBack, null, mBackRect, null);
//            if (!mIsLeft) {
//                canvas.restore();
//            }
//        }
//        if (null != mIce && !mIce.isRecycled()) {
//            canvas.save();
//            if (mIsLeft) {
//                canvas.rotate(mNewDegree, mWidth - mWidth * 128f / 144, mWidth * 128f / 144);
//            } else {
//                canvas.rotate(-mNewDegree, mWidth * 128f / 144, mWidth * 128f / 144);
//            }
//            if (!mIsLeft) {
//                canvas.save();
//                canvas.scale(-1f, 1f, mIceRect.centerX(), mIceRect.centerY());
//            }
//            canvas.drawBitmap(mIce, null, mIceRect, null);
//            if (!mIsLeft) {
//                canvas.restore();
//            }
//            canvas.restore();
//        }
//        super.draw(canvas);
//
//        super.draw(canvas);
        //Log.v("sunzy", "draw");
//        super.draw(canvas);
//    }

    protected void onDraw(Canvas canvas) {
        Log.v("sunzy", "ondraw, left = " + getLeft() + ", right = " + getRight() + ", top = " + getTop() + ", bottom = " + getBottom() + ", mWidth = " + mWidth);
        if(mIsLeft){
            canvas.drawCircle(getLeft(), getBottom(), 450, mFan);
        } else {
            canvas.drawCircle(getRight(), getBottom(), 450, mFan);
        }
    }


    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Log.v("sunzy", "draw child");
        boolean resutl = false;
        if (mIsLeft) {
            if (getChildAt(0) == child) {
                canvas.save();
                canvas.rotate(-TOTAL_DEGREE / 2f, mWidth - mWidth * 128f / 144, mWidth * 128f / 144);
                canvas.save();
                canvas.rotate(TOTAL_DEGREE / 2f - 75, child.getLeft() + (child.getRight() - child.getLeft()) / 2f, child.getTop() + (child.getBottom() - child.getTop()) / 2f);
                resutl = super.drawChild(canvas, child, drawingTime);
                canvas.restore();
                canvas.restore();
            } else if (getChildAt(2) == child) {
                canvas.save();
                canvas.rotate(TOTAL_DEGREE / 2f, mWidth - mWidth * 128f / 144, mWidth * 128f / 144);
                canvas.save();
                canvas.rotate(-TOTAL_DEGREE / 2f, child.getLeft() + (child.getRight() - child.getLeft()) / 2f, child.getTop() + (child.getBottom() - child.getTop()) / 2f);
                resutl = super.drawChild(canvas, child, drawingTime);
                canvas.restore();
                canvas.restore();
            } else {
                canvas.save();
                canvas.rotate(-45, child.getLeft() + (child.getRight() - child.getLeft()) / 2f, child.getTop() + (child.getBottom() - child.getTop()) / 2f);
                resutl = super.drawChild(canvas, child, drawingTime);
                canvas.restore();
            }
        } else {
            if (getChildAt(0) == child) {
                canvas.save();
                canvas.rotate(TOTAL_DEGREE / 2f, mWidth * 128f / 144, mWidth * 128f / 144);
                canvas.save();
                canvas.rotate(-TOTAL_DEGREE / 2f + 75, child.getLeft() + (child.getRight() - child.getLeft()) / 2f, child.getTop() + (child.getBottom() - child.getTop()) / 2f);
                resutl = super.drawChild(canvas, child, drawingTime);
                canvas.restore();
                canvas.restore();
            } else if (getChildAt(2) == child) {
                canvas.save();
                canvas.rotate(-TOTAL_DEGREE / 2f, mWidth * 128f / 144, mWidth * 128f / 144);
                canvas.save();
                canvas.rotate(TOTAL_DEGREE / 2f, child.getLeft() + (child.getRight() - child.getLeft()) / 2f, child.getTop() + (child.getBottom() - child.getTop()) / 2f);
                resutl = super.drawChild(canvas, child, drawingTime);
                canvas.restore();
                canvas.restore();
            } else {
                canvas.save();
                canvas.rotate(45, child.getLeft() + (child.getRight() - child.getLeft()) / 2f, child.getTop() + (child.getBottom() - child.getTop()) / 2f);
                resutl = super.drawChild(canvas, child, drawingTime);
                canvas.restore();
            }
        }
        return resutl;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float width = MeasureSpec.getSize(widthMeasureSpec);
        if (mOriginWidth == 0) {
            mOriginWidth = width;
        }
        if (mWidth == 0f) {
            mWidth = width * WIDTH_OFFSET / 360;
            mBackRect.set(0, 0, (int) mWidth, (int) mWidth);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            view.measure(heightMeasureSpec, heightMeasureSpec);
        }
        setMeasuredDimension((int) mWidth, (int) mWidth);
    }

    private static final float MIN_ALPHA = .8F;

    public void setRotated(float degree, int type) {
//        float offset = -degree / FanMum.TOTAL_DEGREE * (1 - MIN_ALPHA);
//        if (offset > 0) {
//            offset = Math.min(offset, (1 - MIN_ALPHA));
//        } else if (offset < 0) {
//            offset = Math.max(offset, -(1 - MIN_ALPHA));
//        }
//
//        degree = degree / FanMum.TOTAL_DEGREE * TOTAL_DEGREE / 2;
//
//        mNewDegree = -degree + getStartOffsetDegree(type);
//
//        if (mNewDegree > getStartOffsetDegree(ItemController.QUENE_APPLICATION_FOR_NEW_THEME) + OFFSET_DEGREE) {
//            mNewDegree = mNewDegree - (getStartOffsetDegree(ItemController.QUENE_APPLICATION_FOR_NEW_THEME) + OFFSET_DEGREE) +
//                    getStartOffsetDegree(ItemController.QUENE_RECENT_FOR_NEW_THEME) - OFFSET_DEGREE;
//        } else if (mNewDegree < getStartOffsetDegree(ItemController.QUENE_RECENT_FOR_NEW_THEME) - OFFSET_DEGREE) {
//            mNewDegree = mNewDegree - (getStartOffsetDegree(ItemController.QUENE_RECENT_FOR_NEW_THEME) - OFFSET_DEGREE) +
//                    getStartOffsetDegree(ItemController.QUENE_APPLICATION_FOR_NEW_THEME) + OFFSET_DEGREE;
//        }
//        if (null != mInvalidateHelper) {
//            mInvalidateHelper.add(degree == 0);
//        }
//
//        initViewPivot(getChildAt(type));
//        initViewPivot(getChildAt(FanMum.getNextChild(type)));
//        initViewPivot(getChildAt(FanMum.getNextChild(FanMum.getNextChild(type))));
//        if (degree == 0) {
//            getChildAt(type).setScaleX(1f);
//            getChildAt(FanMum.getNextChild(type)).setScaleX(MIN_ALPHA);
//            getChildAt(FanMum.getNextChild(FanMum.getNextChild(type))).setScaleX(MIN_ALPHA);
//
//            getChildAt(type).setScaleY(1f);
//            getChildAt(FanMum.getNextChild(type)).setScaleY(MIN_ALPHA);
//            getChildAt(FanMum.getNextChild(FanMum.getNextChild(type))).setScaleY(MIN_ALPHA);
//
//            ((TextView) getChildAt(type)).setTextColor((Integer) mEvaluator.evaluate(1F, COLOR_START, COLOR_END));
//            ((TextView) getChildAt(FanMum.getNextChild(type))).setTextColor((Integer) mEvaluator.evaluate(0F, COLOR_START, COLOR_END));
//            ((TextView) getChildAt(FanMum.getNextChild(FanMum.getNextChild(type)))).setTextColor((Integer) mEvaluator.evaluate(0F, COLOR_START, COLOR_END));
//        } else if (degree > 0) {
//            getChildAt(type).setScaleX(1f + offset);
//            getChildAt(type).setScaleY(1f + offset);
//            ((TextView) getChildAt(type)).setTextColor((Integer) mEvaluator.evaluate((1f + offset - MIN_ALPHA) / (1 - MIN_ALPHA), COLOR_START, COLOR_END));
//
//            getChildAt(FanMum.getNextChild(type)).setScaleX(MIN_ALPHA - offset);
//            getChildAt(FanMum.getNextChild(type)).setScaleY(MIN_ALPHA - offset);
//            ((TextView) getChildAt(FanMum.getNextChild(type))).setTextColor((Integer) mEvaluator.evaluate((MIN_ALPHA - offset - MIN_ALPHA) / (1 - MIN_ALPHA), COLOR_START, COLOR_END));
//        } else if (degree < 0) {
//            getChildAt(type).setScaleX(1f - offset);
//            getChildAt(type).setScaleY(1f - offset);
//            ((TextView) getChildAt(type)).setTextColor((Integer) mEvaluator.evaluate((1f - offset - MIN_ALPHA) / (1 - MIN_ALPHA), COLOR_START, COLOR_END));
//
//            getChildAt(FanMum.getPreviousChild(type)).setScaleX(MIN_ALPHA + offset);
//            getChildAt(FanMum.getPreviousChild(type)).setScaleY(MIN_ALPHA + offset);
//            ((TextView) getChildAt(FanMum.getPreviousChild(type))).setTextColor((Integer) mEvaluator.evaluate((MIN_ALPHA + offset - MIN_ALPHA) / (1 - MIN_ALPHA), COLOR_START, COLOR_END));
//        }
    }

    private void initViewPivot(View childAt) {
        childAt.setPivotX((childAt.getRight() - childAt.getLeft()) / 2f);
        childAt.setPivotY((childAt.getBottom() - childAt.getTop()) / 2f);
    }

    private static final int COLOR_SELCETED = 0xFFFFFFFF;
    private static final int COLOR_NORMAL = 0xFF0C5497;

    private static final int SIZE_SELECTED = 14;
    private static final int SIZE_NORMAL = 12;

    public void onViewSwitched(int type) {
//        TextView recent = (TextView) findViewById(R.id.recent);
//        TextView tools = (TextView) findViewById(R.id.tools);
//        TextView favorites = (TextView) findViewById(R.id.app);
//        if(null == recent){
//            return;
//        }
//        switch (type) {
//            case ItemController.TYPE_RECENT:
//                recent.setTextSize(TypedValue.COMPLEX_UNIT_SP, SIZE_SELECTED);
//                tools.setTextSize(TypedValue.COMPLEX_UNIT_SP, SIZE_NORMAL);
//                favorites.setTextSize(TypedValue.COMPLEX_UNIT_SP, SIZE_NORMAL);
//
//                recent.setTextColor(COLOR_SELCETED);
//                tools.setTextColor(COLOR_NORMAL);
//                favorites.setTextColor(COLOR_NORMAL);
//                break;
//            case ItemController.TYPE_SWITCHER:
//                recent.setTextSize(TypedValue.COMPLEX_UNIT_SP, SIZE_NORMAL);
//                tools.setTextSize(TypedValue.COMPLEX_UNIT_SP, SIZE_SELECTED);
//                favorites.setTextSize(TypedValue.COMPLEX_UNIT_SP, SIZE_NORMAL);
//
//                recent.setTextColor(COLOR_NORMAL);
//                tools.setTextColor(COLOR_SELCETED);
//                favorites.setTextColor(COLOR_NORMAL);
//                break;
//            case ItemController.TYPE_APPLICATION:
//                recent.setTextSize(TypedValue.COMPLEX_UNIT_SP, SIZE_NORMAL);
//                tools.setTextSize(TypedValue.COMPLEX_UNIT_SP, SIZE_NORMAL);
//                favorites.setTextSize(TypedValue.COMPLEX_UNIT_SP, SIZE_SELECTED);
//
//                recent.setTextColor(COLOR_NORMAL);
//                tools.setTextColor(COLOR_NORMAL);
//                favorites.setTextColor(COLOR_SELCETED);
//                break;
//            default:
//                break;
//        }
    }

    private float getStartOffsetDegree(int quene) {
//        if (ItemController.QUENE_RECENT_FOR_NEW_THEME == quene) {
//            return -TOTAL_DEGREE / 2f;
//        } else if (ItemController.QUENE_SWITCHER_FOR_NEW_THEME == quene) {
//            return 0;
//        } else if (ItemController.QUENE_APPLICATION_FOR_NEW_THEME == quene) {
//            return TOTAL_DEGREE / 2f;
//        } else {
//            return 0;
//        }
        return 0;
    }

    public void setIsLeft(boolean b) {
        mIsLeft = b;
        mBackRect.set(0, 0, (int) mWidth, (int) mWidth);
        if (mIsLeft) {
            int offset = (int) (mWidth * 15 / 100f);
            mIceRect.set(offset, (int) mWidth - (int) (mWidth * 170 / 370) - offset, (int) (mWidth * 170 / 370) + offset, (int) mWidth - offset);
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
            if (null != params) {
                params.gravity = Gravity.LEFT | Gravity.BOTTOM;
                requestLayout();
            }
        } else {
            int offset = (int) (mWidth * 15 / 100f);
            mIceRect.set((int) (mWidth - offset) - (int) (mWidth * 170 / 370), (int) mWidth - (int) (mWidth * 170 / 370) - offset,
                    (int) (mWidth - offset), (int) mWidth - offset);
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
            if (null != params) {
                params.gravity = Gravity.RIGHT | Gravity.BOTTOM;
                requestLayout();
            }
        }
    }

    public void createAnimView() {
    }

    public void recycleAnimView() {
    }

    public interface OnTypeGetter{
        int getCurrentType();
    }

    private OnTypeGetter mOnTypeGetter;

    public void setOnTypeGetter(OnTypeGetter l) {
        mOnTypeGetter = l;
    }
}
