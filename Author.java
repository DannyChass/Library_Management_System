package My_Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Author {

	private int id;
	private String firstName;
	private String lastName;
	private String fieldOfExpertise;
	private String about;

	public Author() {

	}

	public Author(int id, String fname, String lname, String expertise, String about) {
		this.id = id;
		this.firstName = fname;
		this.lastName = lname;
		this.fieldOfExpertise = expertise;
		this.about = about;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFieldOfExpertise() {
		return fieldOfExpertise;
	}

	public void setFieldOfExpertise(String fieldOfExpertise) {
		this.fieldOfExpertise = fieldOfExpertise;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	// insert a new author function
	public void addAuthor(String fname, String lname, String expertise, String about) {

		String insertQuery = "INSERT INTO authors (firstName, lastName, expertise, about) VALUES (?,?,?,?)";

		try {
			PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, expertise);
			ps.setString(4, about);

			if (ps.executeUpdate() == 1) {

				JOptionPane.showMessageDialog(null, "Author Added", "add author", 1);

			} else {
				JOptionPane.showMessageDialog(null, "Author Not Added", "add author", 1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// eit author by id function
	public void editAuthor(int id, String fname, String lname, String expertise, String about) {

		String editQuery = "UPDATE authors SET firstName = ?, lastName = ?, expertise = ?, about = ? WHERE id = ?";

		try {
			PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, expertise);
			ps.setString(4, about);
			ps.setInt(5, id);

			if (ps.executeUpdate() == 1) {

				JOptionPane.showMessageDialog(null, "Author Edited", "edit author", 1);

			} else {
				JOptionPane.showMessageDialog(null, "Author Not Edited", "edit author", 1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// remove author by id function
	public void removeAuthor(int id) {

		String removeQuery = "DELETE FROM authors WHERE id = ?";

		try {
			PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
			ps.setInt(1, id);

			if (ps.executeUpdate() == 1) {

				JOptionPane.showMessageDialog(null, "Author Deleted", "delete author", 1);

			} else {
				JOptionPane.showMessageDialog(null, "Author Not Deleted", "deleted author", 1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// function to populate an Arrylist with genres
	public ArrayList<Author> authorsList() {

		ArrayList<Author> aList = new ArrayList<>();

		String selectQuery = "SELECT * FROM authors";

		PreparedStatement ps;
		ResultSet rs;

		try {

			ps = DB.getConnection().prepareStatement(selectQuery);
			rs = ps.executeQuery();

			Author author;

			while (rs.next()) {

				author = new Author(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("expertise"), rs.getString("about"));
				aList.add(author);
			}

		} catch (SQLException ex) {

		}

		return aList;
	}
}
