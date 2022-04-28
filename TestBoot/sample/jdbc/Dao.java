// package com.hjk.testboot.sample.jdbc;

// import java.security.InvalidAlgorithmParameterException;
// import java.security.InvalidKeyException;
// import java.security.NoSuchAlgorithmException;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;

// import javax.crypto.BadPaddingException;
// import javax.crypto.IllegalBlockSizeException;
// import javax.crypto.NoSuchPaddingException;

// import com.hjk.testboot.sample.encrypt.Encrypt;


// public class Dao implements DaoInterface {

//     static {
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//         } catch (ClassNotFoundException ex) {

//         }
//     }

//     private Connection getConnection() throws SQLException {
//         return DriverManager.getConnection(
//                 "jdbc:mysql://localhost:3306/shop?serverTimezone=Asia/Seoul&characterEncoding=UTF-8", "root",
//                 "star8903");
//     }

//     private void closeConnection(Connection connection) {
//         if (connection == null) {
//             return;
//         }
//         try {
//             System.out.println("데이터베이스가 정상적으로 종료 되었습니다");
//             connection.close();
//         } catch (SQLException ex) {
//             System.out.println("데이터베이스가 실행중 오류발생 되었습니다");
//         }
//     }

//     @Override
//     public void getTest() throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
//         Connection connection=null;
//         try{
//             connection=getConnection();
//               String sql=String.format("SELECT FROM  onair_users");
//             PreparedStatement state=connection.prepareStatement(sql);
//             ResultSet result=state.executeQuery();
//              while(result.next()){
//                   result.getString("user_login");
//                   System.out.println(result.getString("user_login"));
//                   System.out.println(result.getInt("ID"));
//               }
//         }catch (SQLException ex) {
//             System.out.println("SELECT문 실행중 오류 발생");
//             System.out.println(ex.getSQLState());
//             System.out.println(ex.getMessage());
//             System.out.println(ex.getErrorCode());
//         } finally {
//             closeConnection(connection);
//         }
//     }

//     @Override
//     public User getUser(String user_login, String user_pass)
//             throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
//             InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
//         Connection connection = null;
//         User user = new User();
//         Encrypt encrypt = new Encrypt();

//         user_pass = user_pass.replaceAll(" ", "+");
//         System.out.println(user_pass);
//         String pass = encrypt.decrypt(user_pass);

//         System.out.println(user_login);
//         System.out.println(pass);
//         try {
//             connection = getConnection();
//             String sql = String.format("SELECT name,fn FROM edu_user WHERE pa = '%s' ", pass);
//             PreparedStatement statement = connection.prepareStatement(sql);

//             ResultSet resultSet = statement.executeQuery();
//             while (resultSet.next()) {
//                 user.setUserlogin(resultSet.getString("name"));
//                 user.setDisplayName(resultSet.getString("fn"));
//                 user.setStatus("true");
//             }

//             statement.close();
//         } catch (SQLException ex) {
//             System.out.println("SELECT문 실행중 오류 발생");
//             System.out.println(ex.getSQLState());
//             System.out.println(ex.getMessage());
//             System.out.println(ex.getErrorCode());
//         } finally {
//             closeConnection(connection);
//         }

//         return user;
//     }

//     @Override
//     public List<User> findAll() {
//         List<User> result = new ArrayList<User>();
//         Connection connection = null;

//         try {
//             connection = getConnection();
//             PreparedStatement statement = connection
//                     .prepareStatement("select user_login,display_name from Q03gSE3_users");

//             ResultSet resultSet = statement.executeQuery();
//             while (resultSet.next()) {
//                 User user = new User();
//                 user.setUserlogin(resultSet.getString("user_login"));
//                 user.setDisplayName(resultSet.getString("display_name"));
//                 result.add(user);
//             }
//             statement.close();
//         } catch (SQLException ex) {
//             System.out.println("SELECT문 실행중 오류 발생");
//             System.out.println(ex.getSQLState());
//             System.out.println(ex.getMessage());
//             System.out.println(ex.getErrorCode());
//         } finally {
//             closeConnection(connection);
//         }

//         return result;
//     }

//     @Override
//     public void delete(Long id) {
//         Connection connection = null;
//         try {
//             connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement("delete from user where id=?");
//             statement.setLong(1, id);
//             statement.execute();
//         } catch (SQLException ex) {

//         } finally {
//             closeConnection(connection);
//         }
//     }

// }
