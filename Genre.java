package My_Classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Genre {
	
	private int id;
	private String name;
	
	public Genre() {}
	
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
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	//insert a new genre fonction
	public boolean addGenre(String name) {
		
		String insertQuery = "INSERT INTO book_genres (name) VALUES (?)";
		
		
		try {
			PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
			ps.setString(1, name);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
