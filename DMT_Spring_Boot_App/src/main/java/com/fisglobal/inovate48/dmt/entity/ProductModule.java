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
 * The persistent class for the "MODULE" database table.
 * @author Debasis.Mishra
 */
@Entity
@Table(name="MODULE")
public class ProductModule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MODULE_ID")
	private long moduleId;

	@Column(name="MODULE_NAME")
	private String moduleName;

	//bi-directional many-to-one association to Field
	@OneToMany(mappedBy="module")
	@JsonIgnore
	private List<Fields> fields;

	//bi-directional many-to-one association to Mapping
	@OneToMany(mappedBy="module")
	@JsonIgnore
	private List<Mapping> mappings;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	public ProductModule() {
	}

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(final long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(final String moduleName) {
		this.moduleName = moduleName;
	}

	public List<Fields> getFields() {
		return fields;
	}

	public void setFields(final List<Fields> fields) {
		this.fields = fields;
	}

	public Fields addField(final Fields field) {
		getFields().add(field);
		field.setModule(this);

		return field;
	}

	public Fields removeField(final Fields field) {
		getFields().remove(field);
		field.setModule(null);

		return field;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(final List<Mapping> mappings) {
		this.mappings = mappings;
	}

	public Mapping addMapping(final Mapping mapping) {
		getMappings().add(mapping);
		mapping.setModule(this);

		return mapping;
	}

	public Mapping removeMapping(final Mapping mapping) {
		getMappings().remove(mapping);
		mapping.setModule(null);

		return mapping;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (moduleId ^ moduleId >>> 32);
		result = prime * result + (product == null ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ProductModule other = (ProductModule) obj;
		if (moduleId != other.moduleId) {
			return false;
		}
		if (product == null) {
			if (other.product != null) {
				return false;
			}
		} else if (!product.equals(other.product)) {
			return false;
		}
		return true;
	}


}