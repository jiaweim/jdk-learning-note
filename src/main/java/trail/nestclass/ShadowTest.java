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

package trail.nestclass;

public class ShadowTest {

	public int x = 0;

	class FirstLevel {

		public int x = 1;

		void methodInFirstLevel(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
			System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
		}
	}

	public static void main(String... args) {
		ShadowTest st = new ShadowTest();
		FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);
	}
}
