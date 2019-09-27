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

import java.util.IdentityHashMap;

public class IdentityHashMapDemo {

	private static final String A_STR = "First";
	private static final String B_STR = "Second";

	@Test
	public void testSize() {
		IdentityHashMap<String, String> iMap = new IdentityHashMap<>();
		
	}

	@Test
	public void testEquals() {
		// Create a hash map
		IdentityHashMap<String, Double> ihm = new IdentityHashMap<>();

		// Put elements to the map
		ihm.put(new String("Zara"), new Double(3434.34));
		ihm.put("Mahnaz", new Double(123.22));
		ihm.put("Ayan", new Double(1378.00));
		ihm.put("Daisy", new Double(99.22));
		ihm.put("Qadir", new Double(-19.08));
		ihm.put(new String("Zara"), 25.2);

		for (String key : ihm.keySet()) {
			System.out.println(key + "\t" + ihm.get(key));
		}
	}
}
