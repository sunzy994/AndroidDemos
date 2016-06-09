package cmcm.com.shortcutdemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sunzy on 16-4-21.
 */
public class Baidu {

    private Context context;

    public Baidu(Context context){
        this.context = context;
    }

    public void createOnetapShortcut2(){
        HashSet<Integer> screen2 = new HashSet();
        HashSet<Integer> screen3 = new HashSet();
        Uri uri = Uri.parse("content://com.baidu.home2/favorites?notify=true");
        Cursor cursor = context.getContentResolver().query(uri, new String[]{"_id", "screen", "cellX", "cellY"}, null, null, null);
        int id = 0;
        while (cursor.moveToNext()){
            if(cursor.getInt(cursor.getColumnIndex("screen")) == 2){
                screen2.add(cursor.getInt(cursor.getColumnIndex("cellY")) * 4 + cursor.getInt(cursor.getColumnIndex("cellX")));
            } else if(cursor.getInt(cursor.getColumnIndex("screen")) == 3) {
                screen3.add(cursor.getInt(cursor.getColumnIndex("cellY")) * 4 + cursor.getInt(cursor.getColumnIndex("cellX")));
            }
            if(cursor.getInt(cursor.getColumnIndex("_id")) > id){
                id = cursor.getInt(cursor.getColumnIndex("_id"));
            }
        }
        cursor.close();
        id++;
        int screen = 0, cellX = 0, cellY = 0;
        for (int i = 8;i<19;i++){
            if(!screen2.contains(i)){
                screen = 2;
                cellX = i % 4;
                cellY = i / 4;
                break;
            }
        }
        if(screen == 0){
            for (int i = 0;i<20;i++){
                if(!screen3.contains(i)){
                    screen = 3;
                    cellX = i % 4;
                    cellY = i / 4;
                    break;
                }
            }
        }
        if(screen == 0){
            for (int i = 0;i<20;i++){
                if(!screen3.contains(i)){
                    screen = 4;
                    cellX = i % 4;
                    cellY = i / 4;
                    break;
                }
            }
        }

        Logger.v("id = " + id + ", screen = " + screen + ", x = " + cellX + ", y = " + cellY);

        ContentValues values = new ContentValues();
        values.put("_id", id);
        values.put("title", "nimei");
        values.put("intent", "ok");
        values.put("container", -100);
        values.put("itemType", 1);
        values.put("appWidgetId", -1);
        values.put("iconType", 0);
        values.put("iconPackage", context.getPackageName());
        values.put("iconResource", "cmcm.com.shortcutdemo:drawable/boost_tag_onetap_shortcut");
        values.put("screen", 4);
        values.put("cellX", cellX);
        values.put("cellY", cellY);
        values.put("spanX", 1);
        values.put("spanY", 1);
        uri = context.getContentResolver().insert(uri, values);
        Logger.v("uri = " + uri);
    }
}
