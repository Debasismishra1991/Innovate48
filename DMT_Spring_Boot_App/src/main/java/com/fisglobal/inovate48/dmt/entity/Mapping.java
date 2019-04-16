package com.fisglobal.inovate48.dmt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the MAPPING database table.
 *
 * @author Debasis.Mishra
 */
@Entity
@Table(name = "MAPPING")
public class Mapping implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MappingCompositePrimaryKey id;

	@Column(name = "FIELD_VALUE")
	private String fieldValue;

	// bi-directional many-to-one association to Field
	@ManyToOne
	@JoinColumn(name = "FIELD_ID", insertable = false, updatable = false)
	private Fields field;

	// bi-directional many-to-one association to LkClientProduct
	@ManyToOne
	@JoinColumn(name = "CLI_PRO_ID", insertable = false, updatable = false)
	@JsonIgnore
	private LkClientProduct lkClientProduct;

	// bi-directional many-to-one association to Module
	@ManyToOne
	@JoinColumn(name = "MODULE_ID", insertable = false, updatable = false)
	@JsonIgnore
	private ProductModule module;

	public Mapping() {
	}

	public Mapping(final MappingCompositePrimaryKey id, final String fieldValue, final LkClientProduct lkClientProduct,
			final ProductModule module) {
		super();
		this.id = id;
		this.fieldValue = fieldValue;
		this.lkClientProduct = lkClientProduct;
		this.module = module;
	}

	public MappingCompositePrimaryKey getId() {
		return id;
	}

	public void setId(final MappingCompositePrimaryKey id) {
		this.id = id;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(final String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public Fields getField() {
		return field;
	}

	public void setField(final Fields field) {
		this.field = field;
	}

	public LkClientProduct getLkClientProduct() {
		return lkClientProduct;
	}

	public void setLkClientProduct(final LkClientProduct lkClientProduct) {
		this.lkClientProduct = lkClientProduct;
	}

	public ProductModule getModule() {
		return module;
	}

	public void setModule(final ProductModule module) {
		this.module = module;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (fieldValue == null ? 0 : fieldValue.hashCode());
		result = prime * result + (id == null ? 0 : id.hashCode());
		result = prime * result + (lkClientProduct == null ? 0 : lkClientProduct.hashCode());
		result = prime * result + (module == null ? 0 : module.hashCode());
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
		final Mapping other = (Mapping) obj;
		if (fieldValue == null) {
			if (other.fieldValue != null) {
				return false;
			}
		} else if (!fieldValue.equals(other.fieldValue)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lkClientProduct == null) {
			if (other.lkClientProduct != null) {
				return false;
			}
		} else if (!lkClientProduct.equals(other.lkClientProduct)) {
			return false;
		}
		if (module == null) {
			if (other.module != null) {
				return false;
			}
		} else if (!module.equals(other.module)) {
			return false;
		}
		return true;
	}



}

