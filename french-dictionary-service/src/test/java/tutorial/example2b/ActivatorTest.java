package tutorial.example2b;

import java.util.Hashtable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.osgi.framework.BundleContext;

import com.example.service.DictionaryService;

@RunWith(MockitoJUnitRunner.class)
public class ActivatorTest {

	@Mock
	BundleContext mockBundleContext;

	@Test
	public void verifyStartRegistersFrenchDictionaryService() throws Exception {
		Activator activator = new Activator();
		activator.start(mockBundleContext);
		Hashtable<String, String> serviceProperties = new Hashtable<String, String>();
		serviceProperties.put("Language", "French");
		Mockito.verify(mockBundleContext).registerService(
				Mockito.eq(DictionaryService.class.getName()),
				Mockito.isA(FrenchDictionaryService.class),
				Mockito.eq(serviceProperties));
	}

}
