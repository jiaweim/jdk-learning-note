package cn.mjw.hello.nio;

import org.junit.jupiter.api.Test;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Oct 2019, 1:24 PM
 */
class PathMatcherTest
{
    @Test
    void testMatch()
    {
        PathMatcher pm = FileSystems.getDefault().getPathMatcher("glob:*.java");
        assertTrue(pm.matches(Paths.get("PathMatcherDemo.java")));
        assertFalse(pm.matches(Paths.get("PathMatcherDemo.txt")));

        pm = FileSystems.getDefault().getPathMatcher("regex:([^\\s]+(\\.(?i)(png|jpg))$)");
        assertTrue(pm.matches(Paths.get("figure.jpg")));
        assertTrue(pm.matches(Paths.get("figure.png")));
        assertFalse(pm.matches(Paths.get("figure.gif")));
    }
}
