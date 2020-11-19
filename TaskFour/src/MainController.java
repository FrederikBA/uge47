import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    List<City> cities;
    Scanner sc;

    public MainController() {
        cities = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void runProgram() {
        int choice = 0;
        while (choice != 9) {
            showMenu();
            getMyConnection();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    printConnection();
                    System.out.println("\n");
                    break;
                case 2:
                    printCityCount();
                    System.out.println("\n");
                    break;
                case 3:
                    printBigCities();
                    System.out.println("\n");
                    break;
                case 4:
                    populateCityList();
                    printCitiesList();
                    System.out.println("\n");
                    break;
                case 9:
                    exit();
                    break;
                default:
                    exit();
                    break;
            }
        }
    }

    public void printCitiesList() {
        for (City c : cities) {
            System.out.println(c);
        }
    }


    public Connection getMyConnection() {
        Connection connection = null;
        String urlSettings = "?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "root123";

        try {
            connection = DriverManager.getConnection(
                    url + urlSettings,
                    user,
                    password
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void showMenu() {
        System.out.println("1) Check connection");
        System.out.println("2) Check City Count");
        System.out.println("3) Print Cities with more than 5 Million Population");
        System.out.println("4) Populate ArrayList with Cities");
        System.out.println("9) Exit");
    }

    public void exit() {
        System.out.println("Exiting ..");
    }

    public void printConnection() {
        if (getMyConnection() != null) {
            System.out.println("There is a connection");
        }
    }

    public void printCityCount() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;
        int total = 1;

        String sql = "";

        connection = getMyConnection();
        try {
            stmt = connection.createStatement();
            sql = "SELECT COUNT(*) from city";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                System.out.println(res.getInt(total));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printBigCities() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;

        String sql = "";

        connection = getMyConnection();
        try {
            stmt = connection.createStatement();
            sql = "SELECT * FROM city WHERE POPULATION >= 5000000";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                System.out.println(res.getString("Name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void populateCityList() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;

        String sql = "";
        City tmpCity = null;

        connection = getMyConnection();
        try {
            stmt = connection.createStatement();
            sql = "SELECT * FROM city";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int id = res.getInt("ID");
                String name = res.getString("Name");
                String cc = res.getString("CountryCode");
                int population = res.getInt("Population");
                tmpCity = new City(id, name, cc, population);
                cities.add(tmpCity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
