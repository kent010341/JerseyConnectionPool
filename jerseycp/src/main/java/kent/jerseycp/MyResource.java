package kent.jerseycp;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
    
    private static final String JNDI = "java:/comp/env/jdbc/testdb";
    private static Context ctx;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() throws NamingException, SQLException{
        StringBuilder optStr = new StringBuilder();
        optStr.append("**Info** ");
        
        try (Connection conn = getConnection()) {
            optStr.append("Get connection from JNDI: ");
            optStr.append(JNDI);
        } finally {
            ctx.close();
        }
        
        return optStr.toString();
    }
    
    private Connection getConnection() throws NamingException, SQLException {
        ctx = new InitialContext();
        final DataSource ds = (DataSource) ctx.lookup(JNDI);
        
        return ds.getConnection();
    }
    
}
