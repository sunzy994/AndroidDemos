package cmcm.com.fileproviderdemo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private int[] drawables = new int[]{R.drawable.boost_tag_onetap_shortcut, R.drawable.cm_splashpage_logo, R.drawable.cm_splashpage_logo_cn
            , R.drawable.file_manager_tag_icon_my_file_shortcut, R.drawable.main_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File dir = new File(getFilesDir(), "images");
        if(!dir.exists()){
            dir.mkdir();
        }
        for (int i = 0;i<drawables.length;i++){
            try {
                FileOutputStream fos = new FileOutputStream(new File(dir, i + ".png"));
                ((BitmapDrawable) getResources().getDrawable(drawables[i])).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.close();
            } catch (Exception e){
                Log.wtf("sunzy", e);
            }
        }
    }
}
