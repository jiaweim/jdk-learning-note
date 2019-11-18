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

/**
 * 
 * @version 1.00
 */

package trail.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author JiaweiM
 * @date Nov 12, 2015 10:26:33 PM
 */
public class ObjectStreamTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		carl.setSecretary(harry);
		Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
		tony.setSecretary(harry);

		Employee[] staff = new Employee[3];

		staff[0] = carl;
		staff[1] = harry;
		staff[2] = tony;

		// save all employee records to the file employee.dat
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
			out.writeObject(staff);
		}

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"))) {
			// retrieve all records into a new array

			Employee[] newStaff = (Employee[]) in.readObject();

			// raise secretary's salary
			newStaff[1].raiseSalary(10);

			// print the newly read employee records
			for (Employee e : newStaff)
				System.out.println(e);
		}
	}

}
