/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Jerico Manapsal
 */
@XmlRootElement
public class ResponseLogin {
    @XmlElement String session;
    @XmlElement String username;
    @XmlElement String name;
    
    /*public ResponseLogin(final String session, final String username, final String name) {
        this.session = session;
        this.username = username;
        this.name = name;
    }*/
}
