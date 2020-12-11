/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.jerseycp.resource;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import kent.jerseycp.model.Tool;
import kent.jerseycp.service.ToolService;

/**
 *
 * @author kent_chen
 */
@Path("/tools")
@Produces(MediaType.APPLICATION_JSON)
public class ToolResource {
    
    ToolService toolService = new ToolService();
    
    @GET
    public List<Tool> getAllTools() throws NamingException, SQLException {
        return toolService.getAllTools();
    }
    
    @GET
    @Path("/{year}")
    public List<Tool> getToolsByYear(@PathParam("year") int year) 
            throws NamingException, SQLException {
        return toolService.getToolsByYear(year);
    }
    
}
