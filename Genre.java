package My_Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Genre {

	private int id;
	private String name;

	public Genre() {
	}

	public Genre(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	// insert a new genre fonction
	public void addGenre(String name) {

		String insertQuery = "INSERT INTO book_genres (name) VALUES (?)";

		try {
			PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
			ps.setString(1, name);

			if (ps.executeUpdate() == 1) {

				JOptionPane.showMessageDialog(null, "Genre Added", "add genre", 1);

			} else {
				JOptionPane.showMessageDialog(null, "Genre Not Added", "add genre", 1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void editGenre(int id, String name) {

		String editQuery = "UPDATE book_genres SET name = ? WHERE id = ?";

		try {
			PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
			ps.setString(1, name);
			ps.setInt(2, id);

			if (ps.executeUpdate() == 1) {

				JOptionPane.showMessageDialog(null, "Genre Edited", "edit genre", 1);

			} else {
				JOptionPane.showMessageDialog(null, "Genre Not Edited", "edit genre", 1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	//remove genre by id
	public void removeGenre(int id) {


		String removeQuery = "DELETE FROM book_genres WHERE id = ?";

		try {
			PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
			ps.setInt(1, id);

			if (ps.executeUpdate() == 1) {

				JOptionPane.showMessageDialog(null, "Genre Deleted", "delete genre", 1);

			} else {
				JOptionPane.showMessageDialog(null, "Genre Not Deleted", "deleted genre", 1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// function to populate an Arrylist with genres
		public ArrayList<Genre>	genreList(){
			
			ArrayList<Genre> gList = new ArrayList<>();
			
			String selectQuery = "SELECT * FROM book_genres";
			
			PreparedStatement ps;
			ResultSet rs;
			
			try {
				
				ps= DB.getConnection().prepareStatement(selectQuery);
				rs = ps.executeQuery();
				
				Genre genre;
				
				while(rs.next()) {
					
					genre = new Genre(rs.getInt("id"),rs.getString("name"));
					gList.add(genre);
				}
				
			}catch(SQLException ex) {
				
			}
			
			return gList;
		}
}
