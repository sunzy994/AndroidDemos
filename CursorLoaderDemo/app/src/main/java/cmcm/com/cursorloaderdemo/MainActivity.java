package cmcm.com.cursorloaderdemo;

import android.Manifest;
import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private ProgressDialog mProgressDialog;
    private ListView mListView;
    private CursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Querying sms, please wait!");
        mProgressDialog.show();
        mListView = (ListView)findViewById(R.id.list);
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        if(permissionCheck == PackageManager.PERMISSION_GRANTED){
            getLoaderManager().initLoader(0, null, this);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        if(permissionCheck == PackageManager.PERMISSION_GRANTED){
            getLoaderManager().initLoader(0, null, this);
        } else {
            Toast.makeText(this, "CANNOT READ SMS!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader loader = new CursorLoader(this);
        loader.setUri(Telephony.Sms.Inbox.CONTENT_URI);
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        for (int i = 0;i < data.getColumnCount();i++){
            MyLogger.log(data.getColumnName(i));

        }
        data.moveToFirst();
        while (data.moveToNext()){
            MyLogger.log(data.getString(data.getColumnIndex(Telephony.Sms.Inbox.BODY)));
        }

        mAdapter = new SimpleCursorAdapter(this, R.layout.sms_list_item, data,
                new String[]{Telephony.Sms.Inbox.ADDRESS, Telephony.Sms.Inbox.DATE, Telephony.Sms.Inbox.BODY}
                , new int[]{R.id.sms_sender, R.id.sms_time, R.id.sms_content}, 0);
        mListView.setAdapter(mAdapter);

        if(mProgressDialog != null){
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.changeCursor(null);
    }
}
