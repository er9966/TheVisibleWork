// Unsucessful Web Crawler Attempt

// followed tutorial https://www.programcreek.com/2012/12/how-to-make-a-web-crawler-using-java/
// Goal: have it working with washington.edu and "diversity"

// Algorithm
    // get all links from "washington.edu"
    // parse these links with key word "diversity"
    // keep track of which links were parsed to prevent duplicates

// Issue: how to do this without a data base? how about using a file? a set?

// All code from the tutorial
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DB { // database
 
	public Connection conn = null;
 
	public DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost:3306/Crawler";
			conn = DriverManager.getConnection(url, "root", "admin213"); // specific to user maybe
			System.out.println("conn built");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
 
	public ResultSet runSql(String sql) throws SQLException {
		Statement sta = conn.createStatement();
		return sta.executeQuery(sql);
	}
 
	public boolean runSql2(String sql) throws SQLException {
		Statement sta = conn.createStatement();
		return sta.execute(sql);
	}
 
	@Override
	protected void finalize() throws Throwable {
		if (conn != null || !conn.isClosed()) {
			conn.close();
		}
	}
}

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
 
public class Main { // our crawler
	public static DB db = new DB();
 
	public static void main(String[] args) throws SQLException, IOException {
		db.runSql2("TRUNCATE Record;");
		processPage("http://www.mit.edu");
	}
 
	public static void processPage(String URL) throws SQLException, IOException{
		//check if the given URL is already in database
		String sql = "select * from Record where URL = '"+URL+"'";
		ResultSet rs = db.runSql(sql);
		if(rs.next()){
 
		}else{
			//store the URL to database to avoid parsing again
			sql = "INSERT INTO  `Crawler`.`Record` " + "(`URL`) VALUES " + "(?);";
			PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, URL);
			stmt.execute();
 
			//get useful information
			Document doc = Jsoup.connect("http://www.mit.edu/").get();
 
			if(doc.text().contains("research")){
				System.out.println(URL);
			}
 
			//get all links and recursively call the processPage method
			Elements questions = doc.select("a[href]");
			for(Element link: questions){
				if(link.attr("href").contains("mit.edu"))
					processPage(link.attr("abs:href"));
			}
		}
	}
}

