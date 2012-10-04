package org.wiztools.restclient.ui.history;

import java.net.URL;
import org.junit.*;
import static org.junit.Assert.*;
import org.wiztools.restclient.bean.Request;
import org.wiztools.restclient.bean.RequestBean;

/**
 *
 * @author subwiz
 */
public class HistoryManagerImplTest {
    
    public HistoryManagerImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class HistoryManagerImpl.
     */
    @Test
    public void testAll() throws Exception {
        System.out.println("all");
        HistoryManagerImpl instance = new HistoryManagerImpl();
        for(int i=0; i<10; i++) {
            RequestBean request = new RequestBean();
            request.setUrl(new URL("http://localhost/" + i));
            instance.add(request);
        }
        assertTrue(instance.isMostRecent());
        System.out.println("Current after 10 additions: " + instance.current());
        
        for(int i=0; i<10; i++) {
            instance.back();
        }
        assertTrue(instance.isOldest());
        System.out.println("Current after 10 backs: " + instance.current());
        
        for(int i=0; i<5; i++) {
            instance.forward();
        }
        System.out.println("Current after 5 forwards: " + instance.current());
        System.out.println("Cursor position: " + instance.cursor());
        
        RequestBean request = new RequestBean();
        request.setUrl(new URL("http://localhost/NEW"));
        instance.add(request);
        assertEquals(7, instance.size());
        
        System.out.println(instance);
    }
    
    @Test
    public void testSetHistorySize() throws Exception {
        System.out.println("setHistorySize");
        HistoryManagerImpl instance = new HistoryManagerImpl();
        for(int i=0; i<10; i++) {
            RequestBean request = new RequestBean();
            request.setUrl(new URL("http://localhost/" + i));
            instance.add(request);
        }
        instance.setHistorySize(5);
        assertEquals(5, instance.size());
    }
}
