/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Jerico Manapsal
 */
@XmlType
public class Account {
    @XmlAttribute int id;
    @XmlAttribute String username;
    @XmlAttribute String password;
    @XmlAttribute String name;
    @XmlAttribute String type;
    @XmlAttribute String role;
}
