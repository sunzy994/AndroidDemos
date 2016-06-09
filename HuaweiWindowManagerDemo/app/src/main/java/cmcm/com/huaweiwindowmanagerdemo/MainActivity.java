package cmcm.com.huaweiwindowmanagerdemo;

import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRightCorner();
            }
        });
    }

    private void initRightCorner() {
        WindowManager.LayoutParams mRightReddotParams = new WindowManager.LayoutParams();
        mRightReddotParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        mRightReddotParams.flags =WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        mRightReddotParams.gravity = Gravity.CENTER;
        mRightReddotParams.format = PixelFormat.RGBA_8888;
        mRightReddotParams.width = 200;
        mRightReddotParams.height = 300;
        WindowManager wm = getWindowManager();
        tv = new TextView(this);
        tv.setText("Hello, world1");
        tv.setTextColor(Color.WHITE);
        wm.addView(tv, mRightReddotParams);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getWindowManager().removeView(tv);
    }
}
