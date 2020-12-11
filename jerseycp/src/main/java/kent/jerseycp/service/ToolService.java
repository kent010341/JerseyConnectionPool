/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.jerseycp.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import kent.jerseycp.model.Tool;

/**
 *
 * @author kent_chen
 */
public class ToolService {
    
    private static final String JNDI = "java:/comp/env/jdbc/testdb";
    private static Context ctx;
    
    public List<Tool> getToolsByYear(int year) 
            throws NamingException, SQLException {
        return selectBySql("SELECT * FROM tools WHERE year(buydate)=" + year);
    }
    
    public List<Tool> getAllTools() throws NamingException, SQLException {
        return selectBySql("SELECT * FROM tools");
    }
    
    private Connection getConnection() throws NamingException, SQLException {
        ctx = new InitialContext();
        final DataSource ds = (DataSource) ctx.lookup(JNDI);
        
        return ds.getConnection();
    }
    
    private List<Tool> selectBySql(final String SQL_QUERY) 
            throws NamingException, SQLException {
        List<Tool> tools = new ArrayList<>();
        try (final Connection conn = getConnection();
             final Statement stmt = conn.createStatement();
             final ResultSet rs = stmt.executeQuery(SQL_QUERY)) {
            while (rs.next()) {
                tools.add(new Tool(rs.getInt("id"), 
                        rs.getString("name"), rs.getString("buydate")));
            }
        } finally {
            ctx.close();
        }
        
        return tools;
        
    }
    
}
