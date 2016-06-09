package cmcm.com.screenshotdemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by sunzy on 16-1-20.
 */
public class Utils {

    private static final String TAG = Utils.class.getSimpleName();

    public static void openScreenshot(Context context, String path) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(path));
        intent.setDataAndType(uri, "image/*");
        context.startActivity(intent);
    }

    public static String saveScreenshot2File(Bitmap bitmap) {
        String path = null;
        try {
            Date now = new Date();
            android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
            path = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";
            File imageFile = new File(path);
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e){
            Log.wtf(TAG, e);
        }
        return path;
    }
}
