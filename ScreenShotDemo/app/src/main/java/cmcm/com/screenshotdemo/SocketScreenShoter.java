package cmcm.com.screenshotdemo;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.UUID;

/**
 * Created by sunzy on 16-1-20.
 */
public class SocketScreenShoter implements ScreenShoter {

    private static final String TAG = SocketScreenShoter.class.getSimpleName();

    private Context mContext;

    public SocketScreenShoter(Context context){
        this.mContext = context;
    }

    @Override
    public Bitmap takeScreenShot() {
        // make sure the path to save screens exists
        File screensPath = new File(Environment.getExternalStorageDirectory(), "SCREENSHOT_FOLDER");
        screensPath.mkdirs();
        Log.v(TAG, "screenshot save folder = " + screensPath);
        String file = new File(screensPath.getAbsolutePath(), Integer.toHexString(UUID.randomUUID().hashCode()) + ".png").getAbsolutePath();
        // fetch the screen and save it
        Screenshot ss = null;
        try {
            ss = retreiveRawScreenshot();
        } catch (Exception e) {
            Log.wtf(TAG, e);
        }
        writeImageFile(ss, file);
        return null;
    }

    static final class Screenshot {
        public Buffer pixels;
        public int width;
        public int height;
        public int bpp;

        public boolean isValid() {
            if (pixels == null || pixels.capacity() == 0 || pixels.limit() == 0) return false;
            if (width <= 0 || height <= 0)	return false;
            return true;
        }


    }

    private Screenshot retreiveRawScreenshot() throws Exception {
        try {
            // connect to native application
            Socket s = new Socket();
            s.connect(new InetSocketAddress("localhost", 42380), 10000);

            // send command to take screenshot
            OutputStream os = s.getOutputStream();
            os.write("SCREEN".getBytes("ASCII"));

            // retrieve response -- first the size and BPP of the screenshot
            InputStream is = s.getInputStream();
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = is.read()) != -1) {
                if (c == 0) break;
                sb.append((char)c);
            }

            // parse it
            String[] screenData = sb.toString().split(" ");
            if (screenData.length >= 3) {
                Screenshot ss = new Screenshot();
                ss.width = Integer.parseInt(screenData[0]);
                ss.height = Integer.parseInt(screenData[1]);
                ss.bpp = Integer.parseInt(screenData[2]);

                // retreive the screenshot
                // (this method - via ByteBuffer - seems to be the fastest)
                ByteBuffer bytes = ByteBuffer.allocate (ss.width * ss.height * ss.bpp / 8);
                is = new BufferedInputStream(is);	// buffering is very important apparently
                is.read(bytes.array());				// reading all at once for speed
                bytes.position(0);					// reset position to the beginning of ByteBuffer
                ss.pixels = bytes;

                return ss;
            }
        }
        catch (Exception e) {
            Log.wtf(TAG, e);
        }

        return null;
    }

    private void writeImageFile(Screenshot ss, String file) {
        Log.v(TAG, "ss = " + ss);

        // resolve screenshot's BPP to actual bitmap pixel format
        Bitmap.Config pf;
        switch (ss.bpp) {
            case 16:	pf = Bitmap.Config.RGB_565; break;
            case 32:	pf = Bitmap.Config.ARGB_8888; break;
            default:	pf = Bitmap.Config.ARGB_8888; break;
        }

        // create appropriate bitmap and fill it wit data
        Bitmap bmp = Bitmap.createBitmap(ss.width, ss.height, pf);
        bmp.copyPixelsFromBuffer(ss.pixels);

        // handle the screen rotation
        int rot = getScreenRotation();
        if (rot != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(-rot);
            bmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
        }

        // save it in PNG format
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new InvalidParameterException();
        }
        bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
    }

    private int getScreenRotation()  {
        WindowManager wm = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();

        // check whether we operate under Android 2.2 or later
        try {
            Class<?> displayClass = disp.getClass();
            Method getRotation = displayClass.getMethod("getRotation");
            int rot = ((Integer)getRotation.invoke(disp)).intValue();

            switch (rot) {
                case Surface.ROTATION_0:	return 0;
                case Surface.ROTATION_90:	return 90;
                case Surface.ROTATION_180:	return 180;
                case Surface.ROTATION_270:	return 270;
                default:					return 0;
            }
        } catch (NoSuchMethodException e) {
            // no getRotation() method -- fall back to getOrientation()
            int orientation = disp.getOrientation();

            // Sometimes you may get undefined orientation Value is 0
            // simple logic solves the problem compare the screen
            // X,Y Co-ordinates and determine the Orientation in such cases
            if(orientation== Configuration.ORIENTATION_UNDEFINED){

                Configuration config = mContext.getResources().getConfiguration();
                orientation = config.orientation;

                if(orientation==Configuration.ORIENTATION_UNDEFINED){
                    //if height and widht of screen are equal then
                    // it is square orientation
                    if(disp.getWidth()==disp.getHeight()){
                        orientation = Configuration.ORIENTATION_SQUARE;
                    }else{ //if widht is less than height than it is portrait
                        if(disp.getWidth() < disp.getHeight()){
                            orientation = Configuration.ORIENTATION_PORTRAIT;
                        }else{ // if it is not any of the above it will defineitly be landscape
                            orientation = Configuration.ORIENTATION_LANDSCAPE;
                        }
                    }
                }
            }

            return orientation == 1 ? 0 : 90; // 1 for portrait, 2 for landscape
        } catch (Exception e) {
            return 0; // bad, I know ;P
        }
    }

}
