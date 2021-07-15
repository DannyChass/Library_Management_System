package My_Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Member {

	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String gender;
	private byte[] picture;

	public Member() {

	}

	public Member(int id, String fname, String lname, String phone, String email, String gender, byte[] picture) {
		this.id = id;
		this.firstName = fname;
		this.lastName = lname;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.picture = picture;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	// insert a new member fonction
	public void addMember(String fname, String lname, String phone, String email, String gender, byte[] pic) {

		String insertQuery = "INSERT INTO members (firstName, lastName, phone, email, gender, picture) VALUES (?,?,?,?,?,?)";

		try {

			PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.setString(5, gender);
			ps.setBytes(6, pic);

			if (ps.executeUpdate() != 0) {
				JOptionPane.showMessageDialog(null, "Member Added", "add member", 1);

			} else {
				JOptionPane.showMessageDialog(null, "Member Not Added", "add member", 2);
			}

		} catch (SQLException ex) {
			System.out.println("ca marche pas");
		}
	}

	public void editMember(Integer id, String fname, String lname, String phone, String email, String gender,
			byte[] pic) {

		String editQuery = "UPDATE members SET firstname = ?, lastname = ?, phone = ?, email = ?, gender = ?, picture = ? WHERE id = ? ";

		try {
			PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);

			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.setString(5, gender);
			ps.setBytes(6, pic);
			ps.setInt(7, id);

			if (ps.executeUpdate() != 0) {
				JOptionPane.showMessageDialog(null, "MemberEdited", "edit member", 1);

			} else {
				JOptionPane.showMessageDialog(null, "Member Not Edited", "edit member", 2);

			}

		} catch (SQLException ex) {

		}

	}

	public void removeMember(int id) {

		String removeQuery = "DELETE FROM members WHERE id = ?";

		try {

			PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);

			ps.setInt(1, id);

			if (ps.executeUpdate() != 0) {
				JOptionPane.showMessageDialog(null, "Member Deleted", "remove", 1);

			} else {
				JOptionPane.showMessageDialog(null, "Member Not Deleted", "remove", 2);
			}

		} catch (SQLException ex) {

		}

	}

	// get member by id
	public Member getMemberById(Integer id) {
		Func_Class func = new Func_Class();

		String query = "SELECT * FROM members WHERE id = " + id;

		ResultSet rs = func.getData(query);

		try {
			if (rs.next()) {
				return new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBytes(7));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// function to populate an Arrylist with genres
	public ArrayList<Member> membersList() {

		ArrayList<Member> mList = new ArrayList<>();

		String selectQuery = "SELECT * FROM members";

		PreparedStatement ps;
		ResultSet rs;

		try {

			ps = DB.getConnection().prepareStatement(selectQuery);
			rs = ps.executeQuery();

			Member member;

			while (rs.next()) {

				member = new Member(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("phone"),rs.getString("email"), rs.getString("gender"), rs.getBytes("picture"));
				mList.add(member);
			}

		} catch (SQLException ex) {

		}

		return mList;
	}
}
