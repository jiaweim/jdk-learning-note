package mjw.study.jdk.nio.file;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 02 Oct 2019, 10:33 AM
 */
class PathsTest
{
    @Test
    void testGet()
    {
        Path path = Paths.get("test/javafx/test.xml");
    }
}
