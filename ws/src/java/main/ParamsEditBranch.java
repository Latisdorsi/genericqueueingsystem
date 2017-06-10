/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jerico Manapsal
 */
@XmlRootElement
public class ParamsEditBranch {
    @XmlElement int id;
    @XmlElement String brand;
    @XmlElement String branch;
    @XmlElement String category;
    @XmlElement int manager;
    @XmlElement float latitude;
    @XmlElement float longitude;
    @XmlElement String session;
}
