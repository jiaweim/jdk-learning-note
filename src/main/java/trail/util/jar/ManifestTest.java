package trail.util.jar;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author JiaweiMao
 * @date Mar 12, 2016 4:33:56 PM
 */
class ManifestTest
{
    @Test
    void testManifest() throws Exception
    {
        JarInputStream jis = new JarInputStream(
                new FileInputStream(new File("E:/FileFormat/jackson-annotations-2.5.0.jar")));
        Manifest manifest = jis.getManifest();
        Attributes atts = manifest.getMainAttributes();
        assertEquals(26, atts.size());

        jis.close();
    }

}
