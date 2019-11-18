package trail.util;


import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ResourceBundle class is used to store texts and components that are locale sensitive.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 08 2016, 15:59
 */
public class ResourceBundleTest
{
    @Test
    public void testCtr()
    {
        Locale locale = new Locale("en", "US");
        ResourceBundle labels = ResourceBundle.getBundle("il8n.MyBundle", locale);


    }

}
