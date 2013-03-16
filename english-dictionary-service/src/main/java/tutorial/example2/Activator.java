package tutorial.example2;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.example.service.DictionaryService;

public class Activator implements BundleActivator {

	/**
	 * Registers an instance of a dictionary service using the bundle context;
	 * attaches properties to the service that can be queried when performing a
	 * service look-up.
	 * 
	 * @param context
	 *            the framework context for the bundle
	 **/
	public void start(BundleContext context) {
		Hashtable<String, String> serviceProperties = new Hashtable<String, String>();
		serviceProperties.put("Language", "English");
		context.registerService(DictionaryService.class.getName(),
				new EnglishDictionaryService(), serviceProperties);
	}

	/**
	 * Do nothing since the framework will automatically unregister any
	 * registered services.
	 * 
	 * @param context
	 *            the framework context for the bundle
	 **/
	public void stop(BundleContext context) {
		// NOTE: The service is automatically unregistered.
	}

}
