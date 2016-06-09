package cmcm.com.animationdemo;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ValueAnimator animation = ValueAnimator.ofFloat(0f, 1f);
//        animation.setDuration(1000);
//        animation.start();

//        ValueAnimator animation1 = ValueAnimator.ofObject(new TypeEvaluator() {
//            @Override
//            public Object evaluate(float fraction, Object startValue, Object endValue) {
//                Log.v("sunzy", "fraction = " + fraction);
//                return null;
//            }
//        }, 0f, 1f);
//        animation1.setDuration(1000);
//        animation1.start();

        //Good, this works!
        TypeEvaluator<Integer> evaluator = new TypeEvaluator<Integer>() {
            @Override
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                //Log.v("sunzy", "here, here! fraction = " + fraction);
                return (int)((endValue - startValue)*fraction);
            }
        };
        ObjectAnimator animator = ObjectAnimator.ofObject(findViewById(R.id.tv), "TranslationX", evaluator, 0, 1000);
        animator.setDuration(3000);
        animator.start();
    }
}
