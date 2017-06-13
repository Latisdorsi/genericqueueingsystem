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
 * @author CS183P-AC1-08
 */
@XmlRootElement
public class ResponseCurrentQueue {
    @XmlElement String branch;
    @XmlElement int number;
    @XmlElement int serving;
    @XmlElement int linesahead;
}
