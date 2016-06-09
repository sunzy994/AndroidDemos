package cmcm.com.fileproviderdemo;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.AbstractCollection;
import java.util.IllegalFormatException;

/**
 * Created by sunzy on 16-3-29.
 */
public class FileSelectActivity extends Activity {

    // Array of files in the images subdirectory
    File[] mImageFiles;
    // Array of filenames corresponding to mImageFiles
    String[] mImageFilenames;
    private File mPrivateRootDir;
    // The path to the "images" subdirectory
    private File mImagesDir;
    private Intent mResultIntent;
    private ListView mListView;
    private ListAdapter mListAdapter;

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("sunzy", "on resume!");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(true){
//            throw new IllegalStateException();
//        }
        setContentView(R.layout.activity_file_select);
        Log.v("sunzy", "on create! ");
        mResultIntent =
                new Intent("com.example.myapp.ACTION_RETURN_FILE");
        mPrivateRootDir = getFilesDir();
        mImagesDir = new File(mPrivateRootDir, "images");
        mImageFiles = mImagesDir.listFiles();
        setResult(Activity.RESULT_CANCELED, null);

        mListView = (ListView) findViewById(R.id.lv);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                File requestFile = new File(mImageFiles[position].getAbsolutePath());
                Uri fileUri = null;
                try {
                    fileUri = FileProvider.getUriForFile(FileSelectActivity.this, "cmcm.com.fileproviderdemo.fileprovider", requestFile);
                } catch (IllegalArgumentException e) {
                }
                if (fileUri != null) {
                    mResultIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    mResultIntent.setDataAndType(fileUri, getContentResolver().getType(fileUri));
                    FileSelectActivity.this.setResult(Activity.RESULT_OK, mResultIntent);
                } else {
                    mResultIntent.setDataAndType(null, "");
                    FileSelectActivity.this.setResult(RESULT_CANCELED, mResultIntent);
                }
                finish();
            }
        });

        Log.v("sunzy", "find image count = " + mImageFiles.length);

        mListAdapter = new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return true;
            }

            @Override
            public boolean isEnabled(int position) {
                return true;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return mImageFiles.length;
            }

            @Override
            public Object getItem(int position) {
                return mImageFiles[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView;
                if (convertView == null) {
                    textView = new TextView(FileSelectActivity.this);
                } else {
                    textView = (TextView) convertView;
                }
                textView.setText(mImageFiles[position].getName());
                return textView;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public boolean isEmpty() {
                return mImageFiles.length == 0;
            }
        };
        mListView.setAdapter(mListAdapter);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.v("sunzy", "on new intent!");
    }
}
