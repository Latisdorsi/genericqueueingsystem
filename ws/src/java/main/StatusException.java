/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author openlab-mkt-12
 */
@XmlRootElement
public class StatusException extends Exception {
    @XmlElement int status;
    @XmlElement int status_id;
    @XmlElement String status_msg;
    
    public StatusException(ResultSet result) throws SQLException {
        status = result.getInt(1);
        status_id = result.getInt(2);
        status_msg = result.getString(3);
    }
}
