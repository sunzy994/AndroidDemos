package cmcm.com.filerequestdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setType("image/jpg");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data != null){
            Log.v("sunzy", data.toString());
            Uri returnUri = data.getData();
            try {
                AssetFileDescriptor afd =  getContentResolver().openAssetFileDescriptor(returnUri, "r");
                InputStream is = afd.createInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                findViewById(R.id.layout).setBackgroundDrawable(new BitmapDrawable(bitmap));
            } catch (Exception e){
                Log.wtf("sunzy", e);
            }
        }
    }
}
