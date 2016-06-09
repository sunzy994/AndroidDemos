package cmcm.com.localservicemanagerdemo;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public class IBinderWrapper implements Parcelable {
	
	private IBinder binder;
	
	IBinderWrapper(IBinder binder) {
		this.binder = binder;
	}
	
	IBinder getService() {
		return binder;
	}
	
	private IBinderWrapper() {
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStrongBinder(binder);
	}
	
	public static final Creator<IBinderWrapper> CREATOR = new Creator<IBinderWrapper>() {

		public IBinderWrapper createFromParcel(Parcel pl) {
			IBinderWrapper ret = new IBinderWrapper();
			ret.binder = pl.readStrongBinder();
			return ret;
		}

		public IBinderWrapper[] newArray(int size) {
			return new IBinderWrapper[size];
		}
	};
}
