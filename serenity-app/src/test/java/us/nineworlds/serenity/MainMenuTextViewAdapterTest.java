package us.nineworlds.serenity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import toothpick.config.Module;
import us.nineworlds.serenity.test.InjectingTest;
import us.nineworlds.serenity.ui.home.MainMenuDelegatingAdapter;
import us.nineworlds.serenity.ui.home.MainMenuTextViewAdapter;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
public class MainMenuTextViewAdapterTest extends InjectingTest {

    private MainMenuTextViewAdapter adapter;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        adapter = new MainMenuTextViewAdapter();
    }

    @Test
    public void defaultDelegateAdapterIsSetToExpectedInstance() {
        assertThat(adapter.getDelegateManaer().getFallbackDelegate()).isNotNull().isInstanceOf(MainMenuDelegatingAdapter.class);
    }

    @Override
    public void installTestModules() {
        scope.installTestModules(new TestingModule(), new TestModule());
    }

    public class TestModule extends Module {

        public TestModule() {
            bind(SharedPreferences.class).toInstance(PreferenceManager.getDefaultSharedPreferences(ApplicationProvider.getApplicationContext()));
        }
    }
}