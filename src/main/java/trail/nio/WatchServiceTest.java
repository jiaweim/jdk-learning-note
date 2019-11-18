package trail.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Oct 2019, 2:20 PM
 */
public class WatchServiceTest
{

    @Test
    public void test() throws IOException
    {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path dir = Paths.get("");
        dir.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

    }
}
