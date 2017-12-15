/**
 * File - ClientDao.java
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 * **/

package com.cc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
/**Import helper packages**/
import com.cc.helpers.*;

import java.sql.Connection;


public class ClientDao {
	
	/*
	 * Method to Register into application. 
	 * Checks if username or email already exists
	 * Stores username, password, first name, last name email, gender and age in database
	 * 
	 */
	public static Client register(String username, String password, String firstName, String lastName, String email,
			String gender, String age) {
		Connection conn = Dao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Client client = null;

		try {

			pst = conn.prepareStatement("SELECT client_id FROM clients WHERE username=? OR email=?");

			pst.setString(1, username);
			pst.setString(2, email);
			rs = pst.executeQuery();
			if (!rs.next()) {
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (pst != null) {
					try {
						pst.close();
						pst = null;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				pst = conn.prepareStatement(
						"INSERT into clients (first_name, last_name, username, password, email, gender, age,date) VALUES (?, ?, ?, ?, ?, ?, ?, CURDATE())");
				pst.setString(1, firstName);
				pst.setString(2, lastName);
				pst.setString(3, username);
				pst.setString(4, password);
				pst.setString(5, email);
				pst.setString(6, gender);
				pst.setString(7, age);
				
				pst.executeUpdate();
				if (pst != null) {
					try {
						pst.close();
						pst = null;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				pst = conn.prepareStatement("SELECT client_id FROM clients WHERE username=?");
				pst.setString(1, username);
				rs = pst.executeQuery();
				rs.next();
				client = new Client();
				client.setClientId(rs.getString("client_id"));
				client.setUserName(username);
				client.setFirstName(firstName);
				client.setLastName(lastName);

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return client;
	}

	/*Method to login into the Application
	 * Checks if password entered matches password in Database 
	 * */
	public static Client login(String username, String password) {
		Connection conn = Dao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Client client = null;

		try {
			pst = conn.prepareStatement(
					"select client_id, username, first_name, last_name from clients where username=? and password=? and verified=?");

			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, "1");
			rs = pst.executeQuery();
			if (rs.next()) {
				client = new Client();
				client.setClientId(rs.getString("client_id"));
				client.setUserName(rs.getString("username"));
				client.setFirstName(rs.getString("first_name"));
				client.setLastName(rs.getString("last_name"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return client;
	}

/*
 * Stores the temporary password created in database
 */

	public static void temPwd(String username, int randomTemp) throws ClassNotFoundException, SQLException {

		Connection conn = Dao.getConnection();
		Class.forName("com.mysql.jdbc.Driver");
		
		Statement dt = conn.createStatement();
	
		try {
		int	i = dt.executeUpdate(
					"UPDATE clients SET verification_code = '" + randomTemp + "' where username = '" + username + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
/*
 * Gets the verification code and email and checks it with the database
 */
	public static Client verifyEmail(String verification_code, String email) {
		Connection conn = Dao.getConnection();
		PreparedStatement pst = null;
		Client client = new Client();
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT verification_code FROM clients where email='" + email + "'");

			rs = pst.executeQuery();
			while (rs.next()) {
				client.setverification_code(rs.getString("verification_code"));
			}

		} catch (SQLTimeoutException SQLte) {
			System.out.println(SQLte);

		} catch (SQLException SQLe) {
			System.out.println(SQLe);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return client;
	}
/*
 * Flips the boolean in database from 0 to 1 presenting the user has
 * been verified.
 */
	public static void flipVerify(String email) {

		Connection conn = Dao.getConnection();
		PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement("UPDATE clients SET verified='" + 1 + "' WHERE email='" + email + "';");

			pst.executeUpdate();
		} catch (SQLTimeoutException SQLte) {
			System.out.println(SQLte);

		} catch (SQLException SQLe) {
			System.out.println(SQLe);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * Inserts all the food items selected by user along with their
	 * id.
	 * */
	public static void meal(String[] foodItems, String userID) {
		if (foodItems[0] != "" || !foodItems[0].equals("")) {
			Connection conn = Dao.getConnection();
			PreparedStatement pst = null;

			try {

				for (int i = 0; i < foodItems.length; i++) {
					pst = conn.prepareStatement("INSERT into client_food (client_id, food_bank_id) VALUES (?, ?)");

					pst.setString(1, userID);
					pst.setString(2, foodItems[i]);
					pst.executeUpdate();
				}

			} catch (SQLTimeoutException SQLte) {
				System.out.println(SQLte);

			} catch (SQLException SQLe) {
				System.out.println(SQLe);

			} catch (Exception e) {
				System.out.println(e);

			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (pst != null) {
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
		/*
		 * Gets all food from database and displays it 
		 * on the screen. 
		 */
	public static FoodItems getFoods() {
		FoodItems food = new FoodItems();

		Connection conn = Dao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT food_items FROM food_bank");

			rs = pst.executeQuery();
			rs.next();
			String foods = rs.getString("food_items");

			while (rs.next()) {

				foods = foods + "x01" + rs.getString("food_items");
			}

			food.setFood(foods);

		} catch (SQLTimeoutException SQLte) {
			System.out.println(SQLte);

		} catch (SQLException SQLe) {
			System.out.println(SQLe);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return food;

	}
			/*
			 * Gets all the calories from database and add them all
			 * to get the total calories.
			 */
	public static FoodItems getCalories(String[] foodItems, String userId) {
		FoodItems food = new FoodItems();
		Connection conn = Dao.getConnection();
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		int calories = 0;
		int totalCalories = 0;
		int totalOftotalCal = 0;

		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			for (int i = 0; i < foodItems.length; i++) {
				pst = conn
						.prepareStatement("SELECT calories FROM food_bank where food_items_id='" + foodItems[i] + "'");
				rs = pst.executeQuery();
				rs.next();
				calories = Integer.parseInt(rs.getString("calories"));
				totalCalories = calories + totalCalories;

			}
			pst2 = conn.prepareStatement("SELECT total_calories FROM client_calories where client_id='" + userId + "'");
			rs2 = pst2.executeQuery();
			while (rs2.next()) {
				totalOftotalCal = Integer.parseInt(rs2.getString("total_calories")) + totalOftotalCal;
			}

			totalOftotalCal = totalOftotalCal + totalCalories;

			food.setTotalCalories(Integer.toString(totalOftotalCal));
			pst = conn.prepareStatement("INSERT into client_calories (client_id, total_calories, dateCurrent) VALUES (?, ?, CURDATE())");
			pst.setString(1, userId);
			pst.setString(2, Integer.toString(totalCalories));
			pst.executeUpdate(); 
		} catch (SQLTimeoutException SQLte) {
			System.out.println(SQLte);

		} catch (SQLException SQLe) {
			System.out.println(SQLe);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return food;

	}
/*
 * Gets all calories of the user since beginning of time in 
 * database.
 */
	public static FoodItems getOldCalories(String userId) {
		FoodItems food = new FoodItems();

		Connection conn = Dao.getConnection();
		PreparedStatement pst = null;

		int totalCalories = 0;
		int totalOftotalCal = 0;
		ResultSet rs = null;

		try {

			pst = conn.prepareStatement("SELECT total_calories FROM client_calories where client_id='" + userId + "'");
			rs = pst.executeQuery();
			while (rs.next()) {
				totalOftotalCal = Integer.parseInt(rs.getString("total_calories")) + totalOftotalCal;
			}

			rs = pst.executeQuery();

			totalOftotalCal = totalOftotalCal + totalCalories;
			food.setTotalCalories(Integer.toString(totalOftotalCal));

		} catch (SQLTimeoutException SQLte) {
			System.out.println(SQLte);

		} catch (SQLException SQLe) {
			System.out.println(SQLe);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return food;

	}
	/*
	 * The method searches if the username exists in the database.
	 */
	public static Client searchFriend(String username) {

		Connection conn = Dao.getConnection();
		PreparedStatement pst = null;
		Client client = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT username FROM clients where username='" + username + "'");

			rs = pst.executeQuery();
			rs.next();
			client = new Client();
			String usernameFriend = rs.getString("username");

			client.setFriend(usernameFriend);
		} catch (SQLTimeoutException SQLte) {
			System.out.println(SQLte);

		} catch (SQLException SQLe) {
			System.out.println(SQLe);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return client;
	}
	/*
	 * Adding friend logic of the application where when user clicks add friend
	 * the user is added in database.
	 */
	public static Client addFriend(String usernameFriend, String userId) {
		String friendId = "";

		Connection conn = Dao.getConnection();
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;

		Client client = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT client_id FROM clients where username='" + usernameFriend + "'");

			rs = pst.executeQuery();
			rs.next();
			client = new Client();
			friendId = rs.getString("client_id");
			pst2 = conn.prepareStatement("INSERT into client_friend  (client_id, friend_id) VALUES (?, ?)");

			pst2.setString(1, userId);
			pst2.setString(2, friendId);
			pst2.executeUpdate(); ;

		} catch (SQLTimeoutException SQLte) {
			System.out.println(SQLte);

		} catch (SQLException SQLe) {
			System.out.println(SQLe);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null || pst2 != null) {
				try {
					pst.close();
					pst2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return client;
	}
	/*
	 * Display all the friends a client have along with the calorie intake 
	 * and food they ate in database
	 * The core logic of our project
	 */
	public static friendDetails displayAllFriends(String userId) {

		Connection conn = Dao.getConnection();
		PreparedStatement pst = null;
		friendDetails fd = null;
		ResultSet rs = null;
		String friendsFirstName = "";
		String friendsLastName = "";
		String friendsEntryDate = "";
		String friendsTotalCalories = "";
		String friendsFoodItems = "";
		try {

			pst = conn.prepareStatement("select c.first_name, c.last_name, fb.food_items, fb.calories\r\n"
					+ "from clients as c\r\n" + "left join client_friend cf on cf.client_id = c.client_id\r\n"
					+ "left join clients ce on ce.client_id = cf.friend_id\r\n" +

					"left join client_food cff on cff.client_id = c.client_id\r\n"
					+ "left join food_bank fb on cff.food_bank_id = fb.food_items_id\r\n" + "where cf.friend_id = '"
					+ userId + "'");
			rs = pst.executeQuery();
			
			while (rs.next()) {
				friendsFirstName = rs.getString("first_name") + "x02" + friendsFirstName;
				friendsLastName = rs.getString("last_name") + "x02" + friendsLastName;
				friendsTotalCalories = rs.getString("calories") + "x02" + friendsTotalCalories;
				friendsFoodItems = rs.getString("food_items") + "x02" + friendsFoodItems;

			}
			fd = new friendDetails();
			fd.setfriendsFirstName(friendsFirstName);
			fd.setfriendsLastName(friendsLastName);
			fd.setfriendsEntryDate(friendsEntryDate);
			fd.setfriendsFoodItems(friendsFoodItems);
			fd.setfriendsTotalCalories(friendsTotalCalories);

		} catch (SQLTimeoutException SQLte) {
			System.out.println(SQLte);

		} catch (SQLException SQLe) {
			System.out.println(SQLe);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return fd;
	}

} 