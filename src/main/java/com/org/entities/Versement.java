package com.org.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("V")
@XmlType(name="V")
public class Versement extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1123248159262829580L;
	

}
