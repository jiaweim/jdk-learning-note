package trail.lang;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 14 2016, 21:56
 */
 class SystemTest
{
    @Test
     void testGetProperty()
    {
        // jre 版本
        String javaVersion = System.getProperty("java.version");
        assertTrue(javaVersion.contains("1.8."));
        // jre 供应商
        String javaVendor = System.getProperty("java.vendor");
        assertEquals("Oracle Corporation", javaVendor);
        // jre 供应商的链接
        String javaVendorUrl = System.getProperty("java.vendor.url");
        assertEquals("http://java.oracle.com/", javaVendorUrl);
        // jre 安装目录
        String javaHome = System.getProperty("java.home");
        assertEquals("C:\\Program Files\\Java\\jdk1.8.0_91\\jre", javaHome);
        // 操作系统名称
        String osName = System.getProperty("os.name");
        assertEquals("Windows 10", osName);
        System.out.println(osName);

        Properties allProper = System.getProperties();
//        for (String key : allProper.stringPropertyNames()) {
//            System.out.println(key + "=" + allProper.getProperty(key));
//        }
    }

    @Test
    public void testGettmpdir()
    {
        String tmpDir = System.getProperty("java.io.tmpdir");
        assertTrue(tmpDir.contains("Temp"));
    }


    @Test
    public void testArraycopy1()
    {
        String[] s1 = {"中国", "山西", "太原", "TYUT", "zyy", "加拿大", "不知道哪个州", "不知道哪个市", "不知道哪个学校", "yxf"};
        String[] s2 = new String[10];
        System.arraycopy(s1, 0, s2, 0, 10);

        s2[6] = "假设蒙大拿州";
        s2[7] = "假设蒙特利尔市";
        s2[8] = "假设Montreal商学院";
        assertArrayEquals(new String[]{"中国", "山西", "太原", "TYUT", "zyy", "加拿大", "假设蒙大拿州",
                "假设蒙特利尔市", "假设Montreal商学院", "yxf"}, s2);
    }

    @Test
    public void testArraycopy2()
    {

        String[][] s3 = {{"中国", "山西", "太原", "TYUT", "zyy"}, {"加拿大", "不知道哪个州", "不知道哪个市", "不知道哪个学校", "yxf"}};
        String[][] s4 = new String[s3.length][s3[0].length];
        System.arraycopy(s3, 0, s4, 0, s3.length);

        s4[1][1] = "假设蒙大拿州";
        s4[1][2] = "假设蒙特利尔市";
        s4[1][3] = "假设Montreal商学院";

        assertArrayEquals(new String[]{"中国", "山西", "太原", "TYUT", "zyy"}, s3[0]);
        assertArrayEquals(new String[]{"加拿大", "假设蒙大拿州", "假设蒙特利尔市", "假设Montreal商学院", "yxf"}, s3[1]);
        System.out.println(Arrays.toString(s4));
        assertEquals("{{中国,山西,太原,TYUT,zyy},{加拿大,假设蒙大拿州,假设蒙特利尔市,假设Montreal商学院,yxf}}", Arrays.toString(s4));
    }
}
