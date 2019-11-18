package trail.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 26 Oct 2019, 10:52 AM
 */
public class PrintFiles extends SimpleFileVisitor<Path>
{
    // 输出文件类型
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
    {
        if (attrs.isSymbolicLink()) {
            System.out.format("Symbolic link: %s ", file);
        } else if (attrs.isRegularFile()) {
            System.out.printf("Regular file: %s ", file);
        } else {
            System.out.printf("Other: %s ", file);
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
    {
        System.out.printf("Directory: %s%n", dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
    {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }
}
