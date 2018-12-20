package com.org.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("R")
@XmlType(name="R")
public class Retrait extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2549195903575723162L;

}
