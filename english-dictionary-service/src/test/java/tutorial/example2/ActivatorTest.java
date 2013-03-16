package tutorial.example2;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;

import java.util.Hashtable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.osgi.framework.BundleContext;

import com.example.service.DictionaryService;

@RunWith(MockitoJUnitRunner.class)
public class ActivatorTest {

	@Mock
	BundleContext mockBundleContext;

	@Test
	public void verifyStartRegistersEnglishDictionaryService() throws Exception {
		Activator activator = new Activator();
		activator.start(mockBundleContext);
		Hashtable<String, String> serviceProperties = new Hashtable<String, String>();
		serviceProperties.put("Language", "English");
		verify(mockBundleContext).registerService(
				eq(DictionaryService.class.getName()),
				isA(EnglishDictionaryService.class), eq(serviceProperties));
	}

}
