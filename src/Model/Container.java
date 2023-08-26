package Model;

import java.sql.*;
import java.util.ArrayList;

public class Container extends Cargo {

    public Container(){

    }
    public Container(int id){
       this.id = id;
    }
    public Container(int id, String name, Size size){
        this.id = id;
        this.name = name;
        this.size = size;
    }
    private void fetchData(int id){

    }
    @Override
    public boolean add(String name, Size size) {
        String url = "jdbc:sqlite:lpdb.db";
        String query = "INSERT INTO Container(name, length, width, height) VALUES(?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, size.getLength());
            preparedStatement.setDouble(3, size.getWidth());
            preparedStatement.setDouble(4, size.getHeight());

            int rowAffected = preparedStatement.executeUpdate();

            return rowAffected > 0;
        } catch (SQLException e) {
            return false;
        }
    }
    @Override
    public boolean edit(String name, Size size) {
        String url = "jdbc:sqlite:lpdb.db";
        String query = "UPDATE Container SET name = ?, length = ?, width = ?, height = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = conn.prepareStatement(query)){

            preparedStatement.setString(1,name);
            preparedStatement.setDouble(2,size.getLength());
            preparedStatement.setDouble(3,size.getWidth());
            preparedStatement.setDouble(4,size.getHeight());
            preparedStatement.setInt(5,this.id);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

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
        String query = "SELECT id, name, length, width, height FROM Container";
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

                Size size = new Size(length, width, height);
                Container container = new Container(id, name, size);
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
