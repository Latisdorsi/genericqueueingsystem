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
public class EditBranch {
    @XmlElement int id;
    @XmlElement String brand;
    @XmlElement String name;
    @XmlElement String category;
    @XmlElement String type;
    @XmlElement float latitude;
    @XmlElement float longitude;
    @XmlElement String session;
}
