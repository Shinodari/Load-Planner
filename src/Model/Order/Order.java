package Model.Order;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Model.Container;

public class Order {
	private int orderNo;
	private LocalDateTime orderDateTime;
	private Container container;
	public ArrayList<PalletLoading> palletLoadingList;
	
	public Order() {
		
	}
	
	public Order(int orderNo) {
		this.orderNo = orderNo;
	}
	
	public Order(int orderNo, LocalDateTime orderDateTime) {
		this(orderNo);
		this.orderDateTime = orderDateTime;
	}
	
	public int getOrderNo() {
		return this.orderNo;
	}
	
	public LocalDateTime getOrderDateTime() {
		return this.orderDateTime;
	}
	
	public Container getContainer() {
		return this.container;
	}
	
	public void setContainer(Container container) {
		this.container = container;
	}
	
	public void editOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	
	public boolean save() {
		String sql = "INSERT INTO Item(itemID, name, weight) VALUES(?, ?, ?)";
		
		return false;
	}
	
	private Connection connect() {
		String url = "jdbc:sqlite:lpdb.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
