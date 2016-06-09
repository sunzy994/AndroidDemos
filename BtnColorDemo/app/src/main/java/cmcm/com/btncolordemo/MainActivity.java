package cmcm.com.btncolordemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)findViewById(R.id.btn);
        //mButton.setOnTouchListener(this);
        mButton.setOnClickListener(this);

//        StateListDrawable d = (StateListDrawable)getResources().getDrawable(R.drawable.swipe_camera_button_share_selector);
//        d.getState();d.addState();

        //button 带形状的selector
        int strokeWidth = 5; // 3px not dp
        int roundRadius = 15; // 8px not dp
        int strokeColor = Color.parseColor("#2E3135");
        int fillColor = Color.parseColor("#DFDFE0");
        GradientDrawable gd1 = new GradientDrawable();
        gd1.setColor(fillColor);
        gd1.setCornerRadius(roundRadius);
        GradientDrawable gd2 = new GradientDrawable();
        gd2.setColor(strokeColor);
        gd2.setCornerRadius(roundRadius);
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed}, gd1);
        states.addState(new int[]{android.R.attr.}, gd2);
        states.addState(new);
        mButton.setBackgroundDrawable(states);


        //上下渐变的颜色背景
        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.RED, Color.GREEN});
        findViewById(R.id.bg).setBackgroundDrawable(gd);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "click", Toast.LENGTH_LONG).show();
    }
}
