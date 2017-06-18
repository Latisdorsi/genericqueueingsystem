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
public class ParamsFindBranches {
    @XmlElement String brandcategory;
    @XmlElement float latitude;
    @XmlElement float longitude;
    @XmlElement String session;
}
