package com.example.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.example.client.internal.ApplicationController;
import com.example.service.DictionaryService;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		ServiceTracker m_tracker = new ServiceTracker(bundleContext,
				bundleContext.createFilter("(&(objectClass="
						+ DictionaryService.class.getName() + ")"
						+ "(Language=*))"), null);
		m_tracker.open();
		ApplicationController controller = new ApplicationController(m_tracker);
		controller.showUI();
	}

	/**
	 * Do nothing since the framework will automatically unget any used
	 * services.
	 * 
	 * @param context
	 *            the framework context for the bundle
	 */
	@Override
	public void stop(BundleContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
