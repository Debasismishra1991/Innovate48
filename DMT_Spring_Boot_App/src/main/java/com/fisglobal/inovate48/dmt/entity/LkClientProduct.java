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
 * The persistent class for the LK_CLIENT_PRODUCT database table.
 * @author Debasis.Mishra
 */
@Entity
@Table(name="LK_CLIENT_PRODUCT")
public class LkClientProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLI_PRO_ID")
	private long cliProId;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private Client client;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	//bi-directional many-to-one association to Mapping
	@OneToMany(mappedBy="lkClientProduct")
	@JsonIgnore
	private List<Mapping> mappings;

	public LkClientProduct() {
	}

	public long getCliProId() {
		return cliProId;
	}

	public void setCliProId(final long cliProId) {
		this.cliProId = cliProId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(final Client client) {
		this.client = client;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(final List<Mapping> mappings) {
		this.mappings = mappings;
	}

	public Mapping addMapping(final Mapping mapping) {
		getMappings().add(mapping);
		mapping.setLkClientProduct(this);

		return mapping;
	}

	public Mapping removeMapping(final Mapping mapping) {
		getMappings().remove(mapping);
		mapping.setLkClientProduct(null);

		return mapping;
	}

}