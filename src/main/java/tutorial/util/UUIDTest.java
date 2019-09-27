/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tutorial.util;

import org.testng.annotations.Test;

import java.rmi.server.UID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * 用于生成唯一标识符(universally unique identifier).
 *
 * @author JiaweiMao
 * @date Dec 22, 2015 8:29:50 PM
 */
public class UUIDTest
{

    /**
     * The byte[] returned by MessageDigest does not have a nice
     * textual representation, so some form of encoding is usually
     * performed.
     * <p>
     * This implementation follows the example of David Flanagan's book
     * "Java In A Nutshell", and converts a byte array into a String
     * of hex characters.
     * <p>
     * Another popular alternative is to use a "Base64" encoding.
     *
     * @param input
     * @return
     */
    private static String hexEncode(byte[] input)
    {

        StringBuilder result = new StringBuilder();
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int idx = 0; idx < input.length; ++idx) {
            byte b = input[idx];
            result.append(digits[(b & 0xf0) >> 4]);
            result.append(digits[b & 0x0f]);
        }
        return result.toString();
    }

    @Test
    public void TestrandomUUID()
    {
        UUID id = UUID.randomUUID();
        System.out.println("UUID:" + id);
    }

    @Test
    public void testSecureRandom()
    {

        try {
            // Initialize SecureRandom
            // This is a lengthy operation, to be done only upon
            // initialization of the application
            SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");

            // generate a random number
            String randomNum = new Integer(prng.nextInt()).toString();

            // get its digest
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] result = sha.digest(randomNum.getBytes());

            System.out.println("Random number:" + randomNum);
            System.out.println("Message digest:" + hexEncode(result));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUID()
    {
        for (int i = 0; i < 10; i++) {
            UID userId = new UID();
            System.out.println("User ID:" + userId);
        }
    }
}
