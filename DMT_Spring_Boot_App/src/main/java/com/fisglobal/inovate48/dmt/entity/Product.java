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
 * The persistent class for the PRODUCT database table.
 * @author Debasis.Mishra
 */
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	private long productId;

	@Column(name="PRODUCT_NAME")
	private String productName;

	//bi-directional many-to-one association to LkClientProduct
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<LkClientProduct> lkClientProducts;

	//bi-directional many-to-one association to Module
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<ProductModule> modules;

	public Product() {
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(final long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(final String productName) {
		this.productName = productName;
	}

	public List<LkClientProduct> getLkClientProducts() {
		return lkClientProducts;
	}

	public void setLkClientProducts(final List<LkClientProduct> lkClientProducts) {
		this.lkClientProducts = lkClientProducts;
	}

	public LkClientProduct addLkClientProduct(final LkClientProduct lkClientProduct) {
		getLkClientProducts().add(lkClientProduct);
		lkClientProduct.setProduct(this);

		return lkClientProduct;
	}

	public LkClientProduct removeLkClientProduct(final LkClientProduct lkClientProduct) {
		getLkClientProducts().remove(lkClientProduct);
		lkClientProduct.setProduct(null);

		return lkClientProduct;
	}

	public List<ProductModule> getModules() {
		return modules;
	}

	public void setModules(final List<ProductModule> modules) {
		this.modules = modules;
	}

	public ProductModule addModule(final ProductModule module) {
		getModules().add(module);
		module.setProduct(this);

		return module;
	}

	public ProductModule removeModule(final ProductModule module) {
		getModules().remove(module);
		module.setProduct(null);

		return module;
	}

}