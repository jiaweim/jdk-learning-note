package mjw.study.jdk.lang;

import org.junit.jupiter.api.Test;

/**
 * Package 对象包含有关Java包的实现和规范的版本信息。
 *
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 14 2016, 20:54
 */
class PackageTest
{
    /**
     * 当前类加载器所有的类.
     */
    @Test
    void testGetPackages()
    {

        Package[] packages = Package.getPackages();
        for (Package p : packages) {
            System.out.println(p.getName());
        }
    }

    @Test
    void testGetImplementationVersion()
    {
        Package aPackage = Package.getPackage("cn.ac.dicp.jdk");
        System.out.println(aPackage.getName());
        System.out.println(aPackage.getImplementationTitle());
        System.out.println(aPackage.getImplementationVendor());
//        System.out.println(aPackage.getImplementationVersion());
    }

}
