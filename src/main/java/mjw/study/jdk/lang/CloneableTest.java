package mjw.study.jdk.lang;

import org.junit.jupiter.api.Test;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 17 Oct 2019, 10:48 AM
 */
class CloneableTest
{
    @Test
    void testImmutable()
    {
        PhoneNumber number = new PhoneNumber(1, 2, 3);
        PhoneNumber clone = number.clone();
        System.out.println(clone);
    }
}
