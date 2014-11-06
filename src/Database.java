import simplemysql.SimpleMySQL;
import simplemysql.SimpleMySQLResult;

public class Database {

	public static void main(String... args) {
		
		/*
		 * Make sure that you add the "SimpleMySQL.jar" and "mysql-connector-java.jar"
		 * and the "miglayout15-swing.jar" to the eclipse/java build path before trying
		 * to run this program. Else you will get errors. 
		 * 
		 * In Eclipse, right click those files > build path > add to build path. 
		 */
		try {
			String url = "jdbc:mysql://71.15.195.219:3306/moviedb";
			
			SimpleMySQL mysql = new SimpleMySQL();
			mysql.connect("71.15.195.219:3306", "root","","moviedb");
			SimpleMySQLResult result;
			
			/*
			 * The following query gets all movies Adam Sandler played in
			 * and sorts them from oldest to newest made.
			 */
			result = mysql.Query("SELECT * FROM title WHERE id IN "
					+ "(SELECT movie_id FROM cast_info WHERE person_id IN "
					+ "(SELECT id FROM name WHERE name='Ferrell, Will')) AND "
					+ "kind_id=(SELECT id FROM kind_type WHERE kind='movie')"
					+ "ORDER BY production_year ASC");
			
			while(result.next())
			{
				String year = result.getString("production_year");
				
				if(year == null)
					year = "unlisted";
				System.out.println("\n__________"+ year + "__________\n" 
						+  result.getString("title"));
			}
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
