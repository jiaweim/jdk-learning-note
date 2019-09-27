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
package tutorial.io;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author JiaweiMao
 * @date Mar 12, 2016 4:30:45 PM
 */
public class Password {

	public static void main(String args[]) throws IOException {

		Console c = System.console();
		if (c == null) {
			System.err.println("No console.");
			System.exit(1);
		}

		// read the user's login name
		String login = c.readLine("Enter your login: ");
		char[] oldPassword = c.readPassword("Enter your old password: ");

		if (verify(login, oldPassword)) {
			boolean noMatch;
			do {
				char[] newPassword1 = c.readPassword("Enter your new password: ");
				char[] newPassword2 = c.readPassword("Enter new password again: ");
				noMatch = !Arrays.equals(newPassword1, newPassword2);
				if (noMatch) {
					c.format("Passwords don't match. Try again.%n");
				} else {
					change(login, newPassword1);
					c.format("Password for %s changed.%n", login);
				}
				Arrays.fill(newPassword1, ' ');
				Arrays.fill(newPassword2, ' ');
			} while (noMatch);
		}

		Arrays.fill(oldPassword, ' ');
	}

	// Dummy change method.
	static boolean verify(String login, char[] password) {
		// This method always returns true in this example.
		// Modify this method to verify password according to your rules.
		return true;
	}

	// Dummy change method.
	static void change(String login, char[] password) {
		// Modify this method to change
		// password according to your rules.
	}
}
