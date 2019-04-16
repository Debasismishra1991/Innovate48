package com.fisglobal.inovate48.dmt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the FIELDS database table.
 * @author Debasis.Mishra
 */
@Entity
@Table(name="FIELDS")
public class Fields implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FIELD_ID")
	private long fieldId;

	@Column(name="FIELD_DESC")
	private String fieldDesc;

	@Column(name="FIELD_NAME")
	private String fieldName;

	//bi-directional many-to-one association to Module
	@ManyToOne
	@JoinColumn(name="MODULE_ID")
	private ProductModule module;

	//bi-directional many-to-one association to Mapping
	@OneToMany(mappedBy="field")
	@JsonIgnore
	private List<Mapping> mappings;

	public Fields() {
	}

	public long getFieldId() {
		return fieldId;
	}

	public void setFieldId(final long fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldDesc() {
		return fieldDesc;
	}

	public void setFieldDesc(final String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(final String fieldName) {
		this.fieldName = fieldName;
	}

	public ProductModule getModule() {
		return module;
	}

	public void setModule(final ProductModule module) {
		this.module = module;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(final List<Mapping> mappings) {
		this.mappings = mappings;
	}

	public Mapping addMapping(final Mapping mapping) {
		getMappings().add(mapping);
		mapping.setField(this);

		return mapping;
	}

	public Mapping removeMapping(final Mapping mapping) {
		getMappings().remove(mapping);
		mapping.setField(null);

		return mapping;
	}

}