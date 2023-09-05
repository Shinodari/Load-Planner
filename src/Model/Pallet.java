package Model;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;

public class Pallet extends Cargo {
	
	public static ArrayList<Pallet> getAllPallet(){
		String url = "jdbc:sqlite:lpdb.db";
		String query = "SELECT id, name, length, width, height, color FROM Pallet";
		ArrayList<Pallet> pallets = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery())
		{
			while(resultSet.next()) 
			{
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double length = resultSet.getDouble("length");
				double width = resultSet.getDouble("width");
				double height = resultSet.getDouble("height");
				Color color = new Color(resultSet.getInt("color"));
				
				Size size = new Size(length, width, height);
				Pallet pallet = new Pallet(id, name, size, color);
				pallets.add(pallet);
			}
		}
		catch(SQLException e) 
		{
			return null;
		}
		return pallets;
	}
	
	public Pallet() {}
	public Pallet(int id) {
		this.id = id;
		fetchData(id);
	}
	public Pallet(int id, String name, Size size, Color color) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.color = color;
	}
	private void fetchData(int id) {
		String url = "jdbc:sqlite:lpdb.db";
		String query = "SELECT name, length, width, height, color FROM Pallet WHERE id = ?";
		try(Connection conn = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = conn.prepareStatement(query)){
			
			preparedStatement.setInt(1, id);
			
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				if(resultSet.next()) {
					this.name = resultSet.getString("name");
					double length = resultSet.getDouble("length");
					double width = resultSet.getDouble("width");
					double height = resultSet.getDouble("height");
					this.color = new Color(resultSet.getInt("color"));
					
					this.size = new Size(length, width, height);
				}
			}
			
		} catch (SQLException e) {
			
		}
	}

	@Override
	public boolean add(String name, Size size, Color color) {
		String url = "jdbc:sqlite:lpdb.db";
		String query = "INSERT INTO Pallet(name, length, width, height, color) VALUES(?, ?, ?, ?, ?)";
		
		try(Connection conn = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = conn.prepareStatement(query)){
			
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, size.getLength());
			preparedStatement.setDouble(3, size.getWidth());
			preparedStatement.setDouble(4, size.getHeight());
			preparedStatement.setInt(5, color.getRGB());
			
			int rowEffected = preparedStatement.executeUpdate();
			
			if(rowEffected > 0) {
				try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()){
					if(generatedKeys.next()) {
						this.id = generatedKeys.getInt(1);
						this.name = name;
						this.size = size;
						this.color = color;
						return true;
					}
				}
			}
		} catch(SQLException e) {
		
		}
		return false;
	}

	@Override
	public boolean edit(String name, Size size, Color color) {
		String url = "jdbc:sqlite:lpdb.db";
		String query = "UPDATE Pallet SET name = ?, length = ?, width = ?, height = ?, color = ? WHERE id = ?";
		
		try(Connection conn = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = conn.prepareStatement(query)){
			
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, size.getLength());
			preparedStatement.setDouble(3, size.getWidth());
			preparedStatement.setDouble(4, size.getHeight());
			preparedStatement.setInt(5, color.getRGB());
			preparedStatement.setInt(6, this.id);
			
			int rowEffected = preparedStatement.executeUpdate();
			if(rowEffected > 0) {
				this.name = name;
				this.size = size;
				this.color = color;
				return true;
			}
			else{
				return false;
			}
		} catch(SQLException e) {
		return false;
		}
	}

	@Override
	public boolean remove() {
		String url = "jdbc:sqlite:lpdb.db";
		String query = "DELETE FROM Pallet WHERE id = ?";
		
		try(Connection conn = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = conn.prepareStatement(query)){
			
			preparedStatement.setInt(1, id);
			
			int rowEffected = preparedStatement.executeUpdate();
			
			if(rowEffected > 0) {
				return true;
			}
			else {
				return false;
			}
			
		}catch (SQLException e) {
			return false;
		}
	}

}
