package cmcm.com.shortcutdemo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by sunzy on 16-4-27.
 */
public class KitkatShortcutUtils {

    private static final String TAG = KitkatShortcutUtils.class.getSimpleName();
    public static final String KITKAT_LAUNCHER_PKG = "com.nick.kitkatlauncher";
    public static final Uri KITKAT_SHORT_CUT_URI = Uri.parse("content://com.nick.kitkatlauncher.settings/favorites?notify=true");
    public static final Uri KITKAT_SCREENS_URI = Uri.parse("content://com.nick.kitkatlauncher.settings/workspaceScreens?notify=true");
    private static final boolean DEBUG = BuildConfig.DEBUG;

    public static void createOnetapShortcut(Context context, String label, int resId, Intent intent){
        Cursor cursor = null;
        HashSet<Integer> screenIds = new HashSet();
        screenIds.add(3); //default screen id is 9
        try {
            cursor = context.getContentResolver().query(KITKAT_SCREENS_URI, new String[]{"_id"}, null, null, null);
            if(cursor!=null){
                while (cursor.moveToNext()){
                    screenIds.add(cursor.getInt(cursor.getColumnIndex("_id")));
                }
            }
        } catch (Exception e){
            Log.wtf(TAG, e);
        }
        if(cursor != null){
            cursor.close();
            cursor = null;
        }
        if(DEBUG){
            Log.v(TAG, "screens = " + screenIds.toString());
        }
        ArrayList<Integer> pos = new ArrayList<>();
        int id = 0;
        try{
            cursor = context.getContentResolver().query(KITKAT_SHORT_CUT_URI, new String[]{"_id", "screen", "cellX", "cellY"}, null, null, null);
            while (cursor.moveToNext()){
                int screen = cursor.getInt(cursor.getColumnIndex("screen"));
                if(screenIds.contains(screen)){
                    pos.add(screen * 16 + cursor.getInt(cursor.getColumnIndex("cellY")) * 4 + cursor.getInt(cursor.getColumnIndex("cellX")));
                }
                if(cursor.getInt(cursor.getColumnIndex("_id")) > id){
                    id = cursor.getInt(cursor.getColumnIndex("_id"));
                }
            }
        } catch (Exception e){
            Log.wtf(TAG, e);
        } finally {
            if(cursor != null){
                cursor.close();
            }
        }
        id++;
        Collections.sort(pos);
        int start = pos.get(0)/16*16, end = pos.get(pos.size() - 1)/16*16+16;
        if(DEBUG){
            Log.v(TAG, "positions = " + pos.toString() + ", will check from " + start + " to " + end);
        }
        int screen = 0, cellX = 0, cellY = 0;
        for (int i = start;i<end;i++){
            if(!pos.contains(i)){
                screen = i / 16;
                int posInScreen = i % 16;
                cellX = posInScreen % 4;
                cellY = posInScreen / 4;
                break;
            }
        }

        if(DEBUG){
            Log.v(TAG, "id = " + id + ", screen = " + screen + ", x = " + cellX + ", y = " + cellY);
        }
//        cursor = context.getContentResolver().query(KITKAT_SHORT_CUT_URI, null, null, null, null);
//        cursor.moveToFirst();
//        Log.v(TAG, "intent = " + cursor.getString(cursor.getColumnIndex("intent")));

        ContentValues values = new ContentValues();
        values.put("_id", id);
        values.put("title", label);
        //#Intent;action=android.intent.action.VIEW;component=com.example.vibratordemo/.MainActivity;end
        values.put("intent", String.format("#Intent;action=android.intent.action.VIEW;component=%1$s/%2$s;end", intent.getComponent().getPackageName(), intent.getComponent().getClassName()));
        if(DEBUG){
            Log.v(TAG, "inserting intent = " + String.format("#Intent;action=android.intent.action.VIEW;component=%1$s/%2$s;end", intent.getComponent().getPackageName(), intent.getComponent().getClassName()));
        }
        values.put("container", -100);
        values.put("itemType", 1);
        values.put("appWidgetId", -1);
        values.put("iconType", 0);
        values.put("iconPackage", context.getPackageName());
        //FIXME boost_tag_onetap_shortcut cannot be renamed
        values.put("iconResource", String.format("%1$s:drawable/%2$s%1$s", context.getPackageName(), getResourceNameById(resId)));
        values.put("screen", screen);
        values.put("cellX", cellX);
        values.put("cellY", cellY);
        values.put("spanX", 1);
        values.put("spanY", 1);
        try {
            Uri uri = context.getContentResolver().insert(KITKAT_SHORT_CUT_URI, values);
            Log.v(TAG, "uri = " + uri.toString());
        } catch (Exception e){
            Log.wtf(TAG, e);
        }


    }

    private static String getResourceNameById(int id){
        Field[] fields = R.drawable.class.getDeclaredFields();
        try {
            for (Field f : fields){
                if(f.getInt(null) == id){
                    return f.getName();
                }
            }
        }catch (Exception e){
            Log.wtf(TAG, e);
        }
        return "";
    }
}
