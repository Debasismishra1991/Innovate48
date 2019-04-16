package com.fisglobal.inovate48.dmt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the CLIENT database table.
 * @author Debasis.Mishra
 */
@Entity
@Table(name="CLIENT")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLIENT_ID")
	private long clientId;

	@Column(name="CLIENT_NAME")
	private String clientName;

	//bi-directional many-to-one association to LkClientProduct
	@OneToMany(mappedBy="client")
	@JsonIgnore
	private List<LkClientProduct> lkClientProducts;

	public Client() {
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(final long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(final String clientName) {
		this.clientName = clientName;
	}

	public List<LkClientProduct> getLkClientProducts() {
		return lkClientProducts;
	}

	public void setLkClientProducts(final List<LkClientProduct> lkClientProducts) {
		this.lkClientProducts = lkClientProducts;
	}

	public LkClientProduct addLkClientProduct(final LkClientProduct lkClientProduct) {
		getLkClientProducts().add(lkClientProduct);
		lkClientProduct.setClient(this);

		return lkClientProduct;
	}

	public LkClientProduct removeLkClientProduct(final LkClientProduct lkClientProduct) {
		getLkClientProducts().remove(lkClientProduct);
		lkClientProduct.setClient(null);

		return lkClientProduct;
	}

}