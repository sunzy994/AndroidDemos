package cmcm.com.screenshotdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class ScreenShotActivity extends Activity {

    private static final String TAG = ScreenShotActivity.class.getSimpleName();

    public static void startDefault(Context context){
        Intent intent = new Intent(context, ScreenShotActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v(TAG, "activity on create!");
        ScreenShoter screenShoter = new WindowScreenShoter(this);
        Bitmap bitmap = screenShoter.takeScreenShot();
//        String path = Utils.saveScreenshot2File(bitmap);
//        Utils.openScreenshot(this, path);
    }

}
