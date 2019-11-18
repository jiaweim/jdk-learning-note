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

package trail.io;

public class Manager extends Employee {
	
	private Employee secretary;

	/**
	 * Constructs a Manager without a secretary
	 * 
	 * @param n the employee's name
	 * @param s the salary
	 * @param year the hire year
	 * @param month the hire month
	 * @param day the hire day
	 */
	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		secretary = null;
	}

	/**
	 * Assigns a secretary to the manager.
	 * 
	 * @param s the secretary
	 */
	public void setSecretary(Employee s) {
		secretary = s;
	}

	public String toString() {
		return super.toString() + "[secretary=" + secretary + "]";
	}
}
