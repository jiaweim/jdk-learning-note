package mjw.study.jdk.util.jar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @date Mar 12, 2016 4:32:59 PM
 */
class JarFileTest
{
    private static JarFile jarFile;

    @BeforeAll
    static void setUp() throws IOException
    {
        jarFile = new JarFile("E:/JavaApp/GeneMapper.jar");
    }

    @AfterAll
    static void tearDown() throws IOException
    {
        jarFile.close();
    }

    @Test
    void testManifest()
    {
        String manifestName = JarFile.MANIFEST_NAME;
        assertEquals("META-INF/MANIFEST.MF", manifestName);
    }

    @Test
    void testCtr() throws IOException
    {
        jarFile = new JarFile("E:/FileFormat/jackson-annotations-2.5.0.jar");
        Properties prop = new Properties();
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry aEntry = entries.nextElement();
            if (aEntry.getName().contains("pom.properties")) {
                prop.load(jarFile.getInputStream(aEntry));
            }
        }
        String version = prop.getProperty("version");
        System.out.println(version);
    }
}
