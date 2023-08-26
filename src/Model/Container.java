package Model;

import java.sql.*;
import java.util.ArrayList;


public class Container extends Cargo {
    public static ArrayList<Container> getAllContainer()
    {
        Connection conn = null;
        String url = "jdbc:sqlite:lpdb.db";
        String query = "SELECT id, name, length, width, height FROM Container";
        ArrayList<Container> containers = new ArrayList<>();

        try{
            conn = DriverManager.getConnection(url);
            if (conn != null){
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double length = resultSet.getDouble("length");
                    double width = resultSet.getDouble("width");
                    double height = resultSet.getDouble("height");

                    Size size = new Size(length,width,height);
                    Container container = new Container(id, name, size);
                    containers.add(container);
                }
                resultSet.close();
                preparedStatement.close();
            }
        } catch (SQLException e) {
            return null;
        }
        return  containers;
    }

    public Container(){

    }
    public Container(int id){
        super(id);
    }
    public Container(int id, String name, Size size){
        super(id, name, size);
    }

    private void fetchData(int id){
        super(id);
    }
}

