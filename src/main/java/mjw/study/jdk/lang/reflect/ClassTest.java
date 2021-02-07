package mjw.study.jdk.lang.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiM
 * @date Oct 24, 2015 9:53:25 AM
 */
class ClassTest
{

    @Test
    void classGetClass()
    {
        Class c = "foo".getClass();
//		Class c2 = System.console().getClass();
        Class c3 = E.A.getClass();

        byte[] bytes = new byte[1024];
        Class c4 = bytes.getClass();
        Set<String> s = new HashSet<>();
        Class c5 = s.getClass();
    }

    @Test
    void classdotClass()
    {
        Class c2 = boolean.class;    // correct

        Class c3 = java.io.PrintStream.class;
        Class c4 = int[][][].class;
    }

    @Test
    void classforName() throws ClassNotFoundException
    {
//		Class c = Class.forName("com.duke.MyLocaleServiceProvider");

        Class cDoubleArray = Class.forName("[D");
        Class cStringArray = Class.forName("[[Ljava.lang.String;");
    }

    @Test
    public void classtype()
    {
        Class c = Double.TYPE;
        Class c2 = Void.TYPE;
    }

    @Test
    public void classSuperClass()
    {
        // 返回指定类的超类
        Class c = javax.swing.JButton.class.getSuperclass();
        assertEquals("javax.swing.AbstractButton", c.getName());

        // 返回所有类中包含的所有public classes, interface, enums定义。
        // Character包含3个public成员类和一个private类Character.CharacterCache
        Class<?>[] classes = Character.class.getClasses();
        assertEquals(3, classes.length);
        assertEquals("java.lang.Character$Subset", classes[0].getName());
        assertEquals("java.lang.Character$UnicodeBlock", classes[1].getName());
        assertEquals("java.lang.Character$UnicodeScript", classes[2].getName());

        // 返回该类中显式声明的classes, interfaces和enums。
        Class<?>[] classes2 = Character.class.getDeclaredClasses();
        assertEquals(4, classes2.length);
        assertEquals("java.lang.Character$CharacterCache", classes[0].getName());
        assertEquals("java.lang.Character$Subset", classes[1].getName());
        assertEquals("java.lang.Character$UnicodeBlock", classes[2].getName());
        assertEquals("java.lang.Character$UnicodeScript", classes[3].getName());
    }

    @Test
    public void declaringClass() throws NoSuchFieldException, SecurityException
    {
        Field f = System.class.getField("out");
        Class c = f.getDeclaringClass();
        assertEquals("java.lang.System", c.getName());
    }

    @Test
    public void enclodingClass()
    {
        Class c = Thread.State.class.getEnclosingClass();
        assertEquals("java.lang.Thread", c.getName());
    }

    enum E
    {
        A, B
    }


}
