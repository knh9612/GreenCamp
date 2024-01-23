package dev.teabar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.teabar.model.Tea;
import dev.teabar.util.DBUtil;

public class TeaDAO {

//	static Connection connection; // 이거 왜 안되지
	private int result;

	// Create // add
	public void add(Tea tea) {
		String query = "insert into tea (name, size, price) values(?, ?, ?)";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, tea.getName());
			ps.setString(2, tea.getSize());
			ps.setInt(3, tea.getPrice());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Read
	public List<Tea> findAll() {
		final String selectQuery = "SELECT * FROM tea";
		List<Tea> teas = new ArrayList<>();

		try (Connection con = DBUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(selectQuery);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				final int id = rs.getInt("id");
				final String name = rs.getString("name");
				final String size = rs.getString("size");
				final int price = rs.getInt("price");

				teas.add(new Tea(id, name, size, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return teas;
	}

	// Update
	public void update(Tea tea) {
		String query = "update tea set name = ?, size =?, price=? WHERE id = ?";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, tea.getName());
			ps.setString(2, tea.getSize());
			ps.setInt(3, tea.getPrice());
			
			ps.setInt(4, tea.getId());

			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete
	public void deleteAll(int tea_id) {
		String query = "delete from tea where id = ?";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, tea_id);
			ps.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
