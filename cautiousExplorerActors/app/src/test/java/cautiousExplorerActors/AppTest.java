package cautiousExplorerActors;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    @Test public void testAppHasAGreeting() {

        try {
            App.main(new String[0]);
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }
}
