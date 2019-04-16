package com.fisglobal.inovate48.dmt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Debasis.Mishra
 *
 */
@Embeddable
public class MappingCompositePrimaryKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CLI_PRO_ID", insertable = false, updatable = false)
	private long cliProId;

	@Column(name = "MODULE_ID", insertable = false, updatable = false)
	private long moduleId;

	@Column(name = "FIELD_ID", insertable = false, updatable = false)
	private long fieldId;

	public MappingCompositePrimaryKey() {
	}

	public MappingCompositePrimaryKey(final long cliProId, final long moduleId, final long fieldId) {
		super();
		this.cliProId = cliProId;
		this.moduleId = moduleId;
		this.fieldId = fieldId;
	}

	public MappingCompositePrimaryKey(final long cliProId, final long moduleId) {
		super();
		this.cliProId = cliProId;
		this.moduleId = moduleId;
	}

	public long getCliProId() {
		return cliProId;
	}

	public void setCliProId(final long cliProId) {
		this.cliProId = cliProId;
	}

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(final long moduleId) {
		this.moduleId = moduleId;
	}

	public long getFieldId() {
		return fieldId;
	}

	public void setFieldId(final long fieldId) {
		this.fieldId = fieldId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cliProId ^ cliProId >>> 32);
		result = prime * result + (int) (moduleId ^ moduleId >>> 32);
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
		final MappingCompositePrimaryKey other = (MappingCompositePrimaryKey) obj;
		if (cliProId != other.cliProId) {
			return false;
		}
		if (moduleId != other.moduleId) {
			return false;
		}
		return true;
	}

}