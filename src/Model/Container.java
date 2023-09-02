package Model;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;

public class Container extends Cargo {

    public Container(){}
    public Container(int id){
       this.id = id;
       fetchData(id);
    }
    public Container(int id, String name, Size size, Color color){
        this.id = id;
        this.name = name;
        this.size = size;
        this.color = color;
    }
    private void fetchData(int id){
        String url = "jdbc:sqlite:lpdb.db";
        String query = "SELECT name, length, width, height, alpha, red, green, blue FROM Container WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    this.name = resultSet.getString("name");
                    double length = resultSet.getDouble("length");
                    double width = resultSet.getDouble("width");
                    double height = resultSet.getDouble("height");
                    int alpha = resultSet.getInt("alpha");
                    int red = resultSet.getInt("red");
                    int green = resultSet.getInt("green");
                    int blue = resultSet.getInt("blue");

                    this.size = new Size(length, width, height);
                    this.color = new Color(red,green,blue,alpha);
                }
            }
        } catch (SQLException e) {

        }
    }
    @Override
    public boolean add(String name, Size size, Color color) {
        String url = "jdbc:sqlite:lpdb.db";
        String query = "INSERT INTO Container(name, length, width, height, alpha, red, green, blue) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, size.getLength());
            preparedStatement.setDouble(3, size.getWidth());
            preparedStatement.setDouble(4, size.getHeight());
            preparedStatement.setInt(5,color.getAlpha());
            preparedStatement.setInt(6,color.getRed());
            preparedStatement.setInt(7,color.getGreen());
            preparedStatement.setInt(8,color.getBlue());


            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected > 0){
                try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        this.id = generatedKeys.getInt(1);
                        this.name = name;
                        this.size = size;
                        this.color = color;
                        return true;
                    }
                }
            }
        } catch (SQLException e) {

        }
        return false;
    }
    @Override
    public boolean edit(String name, Size size, Color color) {
        String url = "jdbc:sqlite:lpdb.db";
        String query = "UPDATE Container SET name = ?, length = ?, width = ?, height = ?, alpha = ?, red = ?, green = ?, blue = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = conn.prepareStatement(query)){

            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, size.getLength());
            preparedStatement.setDouble(3, size.getWidth());
            preparedStatement.setDouble(4, size.getHeight());
            preparedStatement.setInt(5, color.getAlpha());
            preparedStatement.setInt(6, color.getRed());
            preparedStatement.setInt(7, color.getGreen());
            preparedStatement.setInt(8, color.getBlue());
            preparedStatement.setInt(9, this.id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0){
                this.name = name;
                this.size = size;
                this.color = color;
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e){
            return false;
        }
    }
    @Override
    public boolean remove() {
        return false;
    }

    public static ArrayList<Container> getAllContainer() {
        String url = "jdbc:sqlite:lpdb.db";
        String query = "SELECT id, name, length, width, height, alpha, red, green, blue FROM Container";
        ArrayList<Container> containers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double length = resultSet.getDouble("length");
                double width = resultSet.getDouble("width");
                double height = resultSet.getDouble("height");
                int alpha = resultSet.getInt("alpha");
                int red = resultSet.getInt("red");
                int green = resultSet.getInt("green");
                int blue = resultSet.getInt("blue");

                Size size = new Size(length, width, height);
                Color color = new Color(red, green, blue, alpha);
                Container container = new Container(id, name, size, color);
                containers.add(container);
            }
        }
        catch (SQLException e)
        {
            return null;
        }
        return containers;
    }
}
