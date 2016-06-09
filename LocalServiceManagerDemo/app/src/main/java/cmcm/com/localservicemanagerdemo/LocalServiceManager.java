package cmcm.com.localservicemanagerdemo;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class LocalServiceManager {

	private static LocalServiceManager _instance;

	public synchronized static LocalServiceManager getInstance() {
		if (_instance == null) {
			_instance = new LocalServiceManager();
		}

		return _instance;
	}

	public static IBinder getService(String serviceName) {
		return getInstance().getServiceInternal(serviceName);
	}

	public static void addService(String serviceName, IBinder service) {
		getInstance().addServiceInternal(serviceName, service);
	}

	public static HashMap<String, IBinderWrapper> getServices() {
		return getInstance().getServicesInternal();
	}

	static void registerServiceObserver(Observer observer) {
		getInstance().registerServiceObserverInternal(observer);
	}

	private class ServiceMap extends Observable {

		private HashMap<String, IBinderWrapper> mServiceMap;

		public ServiceMap() {
			mServiceMap = new HashMap<String, IBinderWrapper>();
		}

		void addService(String serviceName, IBinder binder) {
			synchronized (mServiceMap) {
				IBinderWrapper wrapper = mServiceMap.get(serviceName);
				if (wrapper != null && wrapper.getService() == binder) {
					return;
				}

				mServiceMap.put(serviceName, new IBinderWrapper(binder));
			}

			notifyObservers();
		}

		HashMap<String, IBinderWrapper> getServices() {
			synchronized (mServiceMap) {
				return new HashMap<String, IBinderWrapper>(mServiceMap);
			}
		}

		void setServices(HashMap<String, IBinderWrapper> services) {
			synchronized (mServiceMap) {
				mServiceMap.clear();
				mServiceMap.putAll(services);
			}
		}

		IBinder getService(String serviceName) {
			synchronized (mServiceMap) {
				IBinderWrapper wrapper = mServiceMap.get(serviceName);
				if (wrapper != null) {
					return wrapper.getService();
				} else {
					return null;
				}
			}
		}
	}

	private ContentObserver mObserver = new ContentObserver(null) {

		@Override
		public void onChange(boolean selfChange, Uri uri) {
			handleServiceChanged();
		}

		@Override
		public void onChange(boolean selfChange) {
			handleServiceChanged();
		}
	};

	private ServiceMap serviceMap;
	private boolean stableProcess;
	private Context context;

	private LocalServiceManager() {
		serviceMap = new ServiceMap();
		stableProcess = LBEApplication.isServiceProcess();
		context = LBEApplication.getApplication();

		if (!stableProcess) {
			handleServiceChanged();
			context.getContentResolver().registerContentObserver(ServiceProvider.getContentURI(context), true, mObserver);
		}
	}

	private void addServiceInternal(String serviceName, IBinder binder) {
		if (stableProcess) {
			addServiceLocal(serviceName, binder);
		} else {
			// TODO implement this interface when needed
		}
	}

	private IBinder getServiceInternal(String serviceName) {
		return serviceMap.getService(serviceName);
	}

	private HashMap<String, IBinderWrapper> getServicesInternal() {
		return serviceMap.getServices();
	}

	private void registerServiceObserverInternal(Observer observer) {
		serviceMap.addObserver(observer);
	}

	private void addServiceLocal(String serviceName, IBinder binder) {
		serviceMap.addService(serviceName, binder);
	}

	private void handleServiceChanged() {
		Log.v("sunzy", "service changed!");
		Cursor cursor = null;
		try {
			cursor = context.getContentResolver().query(ServiceProvider.getContentURI(context), null, null, null, null);
			Bundle bundle = cursor.getExtras();
			bundle.setClassLoader(context.getClassLoader());
			HashMap<String, IBinderWrapper> services = new HashMap<String, IBinderWrapper>();
			for (String key : bundle.keySet()) {
				services.put(key, (IBinderWrapper) bundle.getParcelable(key));
			}
			serviceMap.setServices(services);
		} catch (Exception e) {
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
	}
}
