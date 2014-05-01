package com.palestra.wf.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAttribute;

public class EntidadDominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private long id;

	@Version
	@XmlAttribute
	protected Integer version;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
}
