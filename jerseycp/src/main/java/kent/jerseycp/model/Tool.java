/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.jerseycp.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kent_chen
 */
@XmlRootElement
public class Tool {
    
    private int id;
    private String name;
    private String buydate;

    public Tool() {
    }

    public Tool(int id, String name, String buydate) {
        this.id = id;
        this.name = name;
        this.buydate = buydate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

//    @Override
//    public String toString() {
//        return "id=" + id + ", name=" + name + ", buydate=" + buydate;
//    }
//    
}
