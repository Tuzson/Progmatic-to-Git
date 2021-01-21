package SqlTrial;

import java.sql.Connection;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class SqlPractice {

    public static void main(String[] args) throws SQLException {

        SqlPractice sql = new SqlPractice();
        Connection connection = sql.getConnection();
        System.out.println("connection ready");
     //   sql.countryNameAndPopulation(connection);
     //   sql.continentAndRegion(connection);
        sql.continentAndPopulation(connection);


    }

    public Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/progmatic?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";   //database specific url.

        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "Tuzsi42424");

        Connection connection =
                DriverManager.getConnection(url, properties);
        return connection;
    }

    public void countryNameAndPopulation(Connection connection) throws SQLException {
        System.out.println("Írd be egy számot");
        Scanner sc = new Scanner(System.in);
        int nr = sc.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement("select NAME,Population from country where Population > ?");
        preparedStatement.setInt(1, nr);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int population = resultSet.getInt("population");
            System.out.println("Name: " + name + " Population " + population);
        }
    }

    public void continentAndRegion(Connection connection) throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("select distinct continent from country order by continent");
        ResultSet result = prepareStatement.executeQuery();
        int i = 1;
        System.out.println("Írj be egy kontinenst");
        while (result.next()) {
            System.out.println(i + ". " + result.getString("continent"));
            i++;
        }
        Scanner sc = new Scanner(System.in);
        String continent = sc.next();
        prepareStatement = connection.prepareStatement("select distinct region from country where continent = ? order by region");
        prepareStatement.setString(1, continent);
        result = prepareStatement.executeQuery();
        System.out.println("írj be egy régiót az alábbiak közül:");
        i = 1;
        while (result.next()) {

            System.out.println(i + ". " + result.getString("region"));
            i++;
        }
        sc = new Scanner(System.in);
        String region = sc.nextLine();
        prepareStatement = connection.prepareStatement("select city.name from city join country on city.CountryCode = country.Code where country.Continent = ? And country.region = ? order by city.name");
        prepareStatement.setString(1, continent);
        prepareStatement.setString(2, region);
        result = prepareStatement.executeQuery();
        System.out.println("Kontinens = " + continent + "\n régió: " + region + "\n " + "itt található városok nevei:");
        while (result.next()) {
            System.out.println(result.getString("name"));
        }
    }

    public void continentAndPopulation(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select distinct continent from country order by continent");
        ResultSet result = preparedStatement.executeQuery();
        System.out.println("Adj meg egy kontinenst");
        int i = 1;
        while (result.next()) {
            System.out.println(i + ". " + result.getString("continent"));
            i++;
        }
        Scanner sc = new Scanner(System.in);
        String continent = sc. next();
        System.out.println("Adj meg egy számot és az általad választott kontinensen levő országok közül kilistázom azokat amelyek a népessége a megadott számnál nagyobb");
        sc = new Scanner(System.in);
        int nr = sc.nextInt();
        preparedStatement = connection.prepareStatement("select name, Population from country where continent = ? and population > ? order by Population");
        preparedStatement.setString(1,continent);
        preparedStatement.setInt(2,nr);
        result = preparedStatement.executeQuery();
        i = 1;
        while (result.next()){


            System.out.println(i + ". " + result.getString("name") + " -->   " + result.getInt("population") );
            System.out.println("---------------------------------------------");
            i++;
        }
    }

}
