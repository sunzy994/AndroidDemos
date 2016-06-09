package cmcm.com.multiprocessdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.v("sunzy", "string test = " + MultiProcessConfig.getsInstance().getString("string_test", "unkown"));
        MultiProcessConfig.getsInstance().putString("string_test", "activity2");
    }
}
