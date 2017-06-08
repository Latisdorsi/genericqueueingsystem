/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Jerico Manapsal
 */
@XmlType
public class Branch {
    @XmlAttribute int id;
    @XmlAttribute String brand;
    @XmlAttribute String name;
    @XmlAttribute String category;
    @XmlAttribute String type;
    @XmlAttribute float latitude;
    @XmlAttribute float longitude;
}
