package trail.nio;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author JiaweiMao
 * @date Mar 7, 2016 9:30:04 PM
 */
class PathTest
{
    private static Path path;

    @BeforeAll
    static void setUp()
    {
        path = Paths.get("E:\\FileFormat\\C#\\compressedFile.txt");
    }

    @Test
    void testGet()
    {
        Path path = Paths.get("/tmp/foo");
        assertEquals(path.toString(), "\\tmp\\foo");

        Path p2 = Paths.get("D:/", "test", "p.xml");
        assertEquals(p2.toString(), "D:\\test\\p.xml");

        Path path1 = Paths.get("D:/test", ".xml");
        System.out.println(path1);
    }

    @Test
    void test()
    {
        Path path = Paths.get("/Program Files");
        assertEquals(path.toAbsolutePath().toString(), "D:\\Program Files");
        System.out.println(path.toAbsolutePath());
        System.out.println(Paths.get("Program Files").toAbsolutePath());
    }

    @Test
    void testGetAbs()
    {
        assertEquals(Paths.get("C:\\Program Files\\Git\\etc\\hello.txt").toString(), "C:\\Program Files\\Git\\etc\\hello.txt");
        assertEquals(Paths.get("C:\\Program Files\\Git\\etc\\", "hello.txt").toString(), "C:\\Program Files\\Git\\etc\\hello.txt");
        assertEquals(Paths.get("C:\\Program Files", "Git/etc", "hello.txt").toString(), "C:\\Program Files\\Git\\etc\\hello.txt");
        assertEquals(Paths.get("C:\\Program Files", "Git", "etc", "hello.txt").toString(), "C:\\Program Files\\Git\\etc\\hello.txt");
    }

    @Test
    void testUri2Path()
    {
        URI uri = URI.create("file:///C:/test/hello.txt");
        Path path = Paths.get(uri);
        assertEquals(path.toString(), "C:\\test\\hello.txt");
    }

    @Test
    void testGetInfo()
    {
        Path path = Paths.get("C:\\home\\joe\\foo");
        assertEquals(path.toString(), "C:\\home\\joe\\foo");
        assertEquals(path.getFileName().toString(), "foo");
        assertEquals(path.getName(0).toString(), "home");
        assertEquals(path.getNameCount(), 3);
        assertEquals(path.subpath(0, 2).toString(), "home\\joe");
        assertEquals(path.getParent().toString(), "C:\\home\\joe");
        assertEquals(path.getRoot().toString(), "C:\\");
    }

    @Test
    void testGetInfoRelative()
    {
        Path path = Paths.get("sally/bar");
        assertEquals(path.toString(), "sally\\bar");
        assertEquals(path.getFileName().toString(), "bar");
        assertEquals(path.getName(0).toString(), "sally");
        assertEquals(path.getNameCount(), 2);
        assertEquals(path.subpath(0, 2).toString(), "sally\\bar");
        assertEquals(path.subpath(0, 1).toString(), "sally");
        assertEquals(path.getParent().toString(), "sally");
        assertNull(path.getRoot());
    }

    @Test
    void testToURI()
    {
        Path path = Paths.get("/home/logfile");
        URI uri = path.toUri();
        assertEquals(uri.toString(), "file:///D:/home/logfile");
    }

    @Test
    void testtoAbsolutePath()
    {
        Path path = Paths.get("");
        Path path1 = path.toAbsolutePath();
        assertEquals(path1.toString(), "D:\\code\\tutorials\\jdk-tutorial");
    }

    @Test
    void testGetFileName()
    {
        Path namePath = path.getFileName();
        assertEquals("compressedFile.txt", namePath.toString());
    }

    @Test
    void testGetName()
    {
        Path name = path.getName(0);
        assertEquals("FileFormat", name.toString());
    }

    @Test
    void testCtr1()
    {
        Path path = Paths.get("E:", "FileFormat", "C#", "compressedFile.txt");
        assertEquals("E:\\FileFormat\\C#\\compressedFile.txt", path.toString());
        System.out.println(path.getFileName());
    }

    @Test
    void testResolve()
    {
        // define the fixed path
        Path base = Paths.get("E:/FileFormat");
        // resolve 20131216-hela.mzML file
        Path path_1 = base.resolve("20131216-hela.mzML");
        assertEquals("E:\\FileFormat\\20131216-hela.mzML", path_1.toString());
        // resolve 20131216-hela.log.txt file
        Path path_2 = base.resolve("20131216-hela.log.txt");
        assertEquals("E:\\FileFormat\\20131216-hela.log.txt", path_2.toString());
    }

    @Test
    void testResolve2()
    {
        Path path = Paths.get("C:\\home\\joe\\foo");
        assertEquals(path.resolve("bar").toString(), "C:\\home\\joe\\foo\\bar");
        assertEquals(Paths.get("foo").resolve("/home/joe").toString(), "\\home\\joe");
    }

    @Test
    void testResolveSibling()
    {
        // define the fixed path
        Path base = Paths.get("E:\\FileFormat\\20131216-hela.mzML");
        // resolve sibling 20131216-hela.PSMs.tsv file
        Path path = base.resolveSibling("20131216-hela.PSMs.tsv");
        assertEquals("E:\\FileFormat\\20131216-hela.PSMs.tsv", path.toString());
    }

    @Test
    void testRelative()
    {
        Path path01 = Paths.get("BNP.txt");
        Path path02 = Paths.get("AEGON.txt");

        Path path01_to_path02 = path01.relativize(path02);
        assertEquals("..\\AEGON.txt", path01_to_path02.toString());
        Path path02_to_path01 = path02.relativize(path01);
        assertEquals("..\\BNP.txt", path02_to_path01.toString());
    }

    @Test
    void testRelativize2()
    {
        Path p1 = Paths.get("zhao");
        Path p2 = Paths.get("qian");

        Path p1_2 = p1.relativize(p2);
        assertEquals(p1_2.toString(), "..\\qian");

        Path p2_1 = p2.relativize(p1);
        assertEquals(p2_1.toString(), "..\\zhao");

        Path p3 = Paths.get("home");
        Path p4 = Paths.get("home/zhao/er");
        assertEquals(p3.relativize(p4).toString(), "zhao\\er");
        assertEquals(p4.relativize(p3).toString(), "..\\..");
    }

    @Test
    void testRelativize()
    {
        Path path01 = Paths.get("/tournaments/2009/BNP.txt");
        Path path02 = Paths.get("/tournaments/2011");

        Path path01_to_path02 = path01.relativize(path02);
        assertEquals("..\\..\\2011", path01_to_path02.toString());
        Path path02_to_path01 = path02.relativize(path01);
        assertEquals("..\\2009\\BNP.txt", path02_to_path01.toString());
    }

    @Test
    void testEquals()
    {
        Path begin = Paths.get("/home");
        Path end = Paths.get("foo");
        Path path = Paths.get("/home/zhao/foo");
        assertTrue(path.startsWith(begin));
        assertTrue(path.endsWith(end));
    }
}
