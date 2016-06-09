package cmcm.com.screenshotdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by sunzy on 16-1-20.
 */
public class WindowScreenShoter implements ScreenShoter{

    private Activity context;

    public WindowScreenShoter(Activity activity){
        this.context = activity;
    }

    @Override
    public Bitmap takeScreenShot() {
        try {
            // image naming and path  to include sd card  appending name you choose for file

            // create bitmap screen capture
            View v1 = context.getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);
        } catch (Throwable e) {
            // Several error may come out with file handling or OOM
            e.printStackTrace();
        }
        return null;
    }

}
