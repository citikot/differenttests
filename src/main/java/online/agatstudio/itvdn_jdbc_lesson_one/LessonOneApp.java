package online.agatstudio.itvdn_jdbc_lesson_one;

/*
Приложение, которое считывает имя пользователя и пароль для подключения к БД по
запросу с консоли. Необходимо реализовать проверку введённых данных. Если данные введены
верно – осуществить подключение к базе данных с сообщением «Connected to DB», иначе –
выбросить в консоль сообщение о неудаче с просьбой ввести имя пользователя и пароль ещё
раз.
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;

public class LessonOneApp {

    private static final String DB_NAME = "jdbc:mysql://localhost:3306/books_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        boolean connectionEstablished = false;

        while (!connectionEstablished) {
            // Get username
            do {
                System.out.print("Enter username: ");
                username = scanner.nextLine();
                if (!username.equals(DB_USER)) {
                    System.out.println("Invalid username. Please try again.");
                }
            } while (!username.equals(DB_USER));

            // Get password
            do {
                System.out.print("Enter password: ");
                password = scanner.nextLine();
                if (!password.equals(DB_PASS)) {
                    System.out.println("Invalid password. Please try again.");
                }
            } while (!password.equals(DB_PASS));

            // Attempt database connection
            Connection conn = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = getConnection(DB_NAME, username, password);
                System.out.println("Connected to DB");
                connectionEstablished = true;
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found. Error: " + e.getMessage());
                System.out.println("Please ensure MySQL JDBC driver is in the classpath.");
                break; // Exit if driver is missing
            } catch (SQLException e) {
                System.err.println("Failed to connect to database.");
                System.err.println("SQL Error Code: " + e.getErrorCode());
                System.err.println("SQL State: " + e.getSQLState());
                System.err.println("Error Message: " + e.getMessage());
                System.out.println("Please check if:");
                System.out.println("- MySQL server is running");
                System.out.println("- Database 'books_db' exists");
                System.out.println("- Connection parameters are correct");
                System.out.println();
                System.out.println("Would you like to try again? (y/n)");
                String retry = scanner.nextLine();
                if (!retry.toLowerCase().startsWith("y")) {
                    break;
                }
            } finally {
                // Clean up resources
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        System.err.println("Error closing connection: " + e.getMessage());
                    }
                }
            }
        }
        
        scanner.close();
    }
}