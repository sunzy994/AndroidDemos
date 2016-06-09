package cmcm.com.outofmemerror;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //内存到底限制在应用上还是限制在进程上
    //oom后整个应用所有进程崩溃，还是个别进程崩溃
    //只能读到自己的进程信息，连子进程的都读不到
    //内存是按照进程进行分配的
    //子进程的崩溃不会导致父进程的崩溃
    //父进程的崩溃也不会导致子进程的崩溃

    //不要用枚举
    //不要用hashset hashmap
    //不要用抽象 不要用继承
    //不要新建类，不要新建对象

    //尽量使用静态方法
    //尽量使用static final
    //使用增强for循环，内部不要使用getter setter
    //不要每次都去取字符串的长度，缓存起来
    private byte[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new byte[1024 * 1024 * 130];
        for (int i = 0;i < data.length;i++){
            data[i] = (byte)i;
        }
        //怎样获取当前进程内存状态
        //有没有一种预防oom的方法

//        startService(new Intent(this, MyService.class));
//        //1.获取当前进程可以占用的最大heap space
//        ActivityManager am = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
//        Log.v("sunzy", "available heap in megabytes = " + am.getMemoryClass() + ", max heap in megabytes = " + am.getLargeMemoryClass());
//
//        //Log.v("sunzy", "process id = " + android.os.Process.myPid() + ", process name = " + getProcessName2(this, android.os.Process.myPid()));
//        getProcessName(this);
//
//        //制造一个
//        if(true){
//            int a = 8/0;
//        }
    }

    //获取进程名称的一种方法,只能读取到自己的进程
    public static String getProcessName(Context cxt) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();

        for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
            Log.v("sunzy", "process id = " + procInfo.pid + ", process name = " + procInfo.processName);
        }
        return null;
    }

    //获取进程名称的另一种方法,直接读取文件 Permission denied
    //android.system.ErrnoException: open failed: EACCES (Permission denied)
    public static String getProcessName2(){
        //%d/cmdline
        File forder = new File("proc/");
        for(File file : forder.listFiles()){
            if(TextUtils.isDigitsOnly(file.getName())){
                try {
                    FileInputStream fis = new FileInputStream(new File(file.getAbsolutePath(), "cmdline"));
                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);
                    Log.v("sunzy", new String(bytes));
                    fis.close();
                } catch (Exception e){
                    //Log.wtf("sunzy", e);
                }
            }
        }
        return null;
    }
}
