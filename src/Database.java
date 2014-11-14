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
			//String url = "jdbc:mysql://71.15.195.219:3306/moviedb";
			
			SimpleMySQL mysql = new SimpleMySQL();
			mysql.connect("71.15.195.219:3306", "root","","moviedb");
			SimpleMySQLResult result;
			SimpleMySQLResult result2 = null;
			
			/*
			 * Try a producer such as Michael Bay.
			 * Try an Actor such as Will Ferrell
			 */
			String somePerson = "Bay, Michael"; //in form "Last, First"
			
			/*
			 * The following query gets all movies somePerson played in
			 * and sorts them from oldest to newest made.
			 */
			result = mysql.Query("SELECT * FROM title WHERE id IN "
					+ "(SELECT movie_id FROM cast_info WHERE person_id IN "
					+ "(SELECT id FROM name WHERE name='"+somePerson+"')) AND "
					+ "kind_id=(SELECT id FROM kind_type WHERE kind='movie')"
					+ "ORDER BY production_year ASC");
			
			while(result.next())
			{
				String year = result.getString("production_year");
				
				if(year == null)
					year = "unknown";
				System.out.println("Movie: "+result.getString("title")+"\n"+"Production Year: "+year);
				
				/* This query will now get every role somePerson had for each movie */
				result2 = mysql.Query("SELECT * FROM role_type WHERE id IN "
						+ "(SELECT role_id FROM cast_info WHERE movie_id="
						+ ""+result.getString("id")+" && person_id IN"
						+ "(SELECT id FROM name WHERE name='"+somePerson+"'))"
						+ "ORDER BY id ASC");
				
				System.out.print("Roles: ");
				while(result2.next())
				{
					System.out.print(result2.getString("role") +"/");
				}
				
				System.out.println("\n");
			}
			result.close();
			result2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
