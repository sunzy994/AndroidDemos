package cmcm.com.bitmaprecycledemo;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BitmapDrawable)getResources().getDrawable(R.drawable.aaaa)).getBitmap().recycle();
        ((ImageView)findViewById(R.id.iv)).setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.aaaa));
    }
}
