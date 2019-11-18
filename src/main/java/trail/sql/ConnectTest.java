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
package trail.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author JiaweiMao
 * @date Mar 7, 2016 9:16:54 PM
 */
public class ConnectTest {

	public void connectToAndQueryDatabase(String username, String password) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:myDriver:myDatabase", username, password);

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");

		while (rs.next()) {
			int x = rs.getInt("a");
			String s = rs.getString("b");
			float f = rs.getFloat("c");
		}
	}
}
