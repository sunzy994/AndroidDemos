package cmcm.com.multiprocessdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sunzy on 16-3-28.
 */
public abstract class OnConfigChangeListener implements Parcelable {

        public static class CREATOR extends Parcelable.Creator{

        }

        void onConfigChange(String key){};

        @Override
        public int describeContents() {
                return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }
}
