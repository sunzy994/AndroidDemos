package cmcm.com.viewcongfigdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewConfiguration configuration = ViewConfiguration.get(this);
        configuration.getScaledDoubleTapSlop();
        configuration.getScaledEdgeSlop();
        configuration.getScaledFadingEdgeLength();
        configuration.getScaledTouchSlop();

    }
}
