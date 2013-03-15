package tutorial.example1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.osgi.framework.BundleContext;

@RunWith(MockitoJUnitRunner.class)
public class ActivatorTest {

	@Mock
	BundleContext mockBundleContext;

	@Test
	public void verifyStartAddsActivatorAsServiceListener()
			throws Exception {
		Activator activator = new Activator();
		activator.start(mockBundleContext);
		Mockito.verify(mockBundleContext).addServiceListener(activator);
	}

	@Test
	public void verifyStopRemovesActivatorAsServiceLister() throws Exception {
		Activator activator = new Activator();
		activator.stop(mockBundleContext);
		Mockito.verify(mockBundleContext).removeServiceListener(activator);
	}

}
