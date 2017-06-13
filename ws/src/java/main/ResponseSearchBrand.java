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
 * @author CS183P-AC1-08
 */
@XmlType
public class ResponseSearchBrand {
    @XmlAttribute int id;
    @XmlAttribute String counter;
    @XmlAttribute String brand;
    @XmlAttribute String branch;
    @XmlAttribute String category;
}
