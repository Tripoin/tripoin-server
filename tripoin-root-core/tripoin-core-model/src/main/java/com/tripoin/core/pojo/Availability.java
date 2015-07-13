package com.tripoin.core.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Entity
@Table(name="trx_availability")
public class Availability implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7126502418704249998L;
	private int id;
	private String name;
	private List<Product> products;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="availability_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="availability_name", length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "availability", cascade=CascadeType.ALL)
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Availability [id=" + id + ", name=" + name + "]";
	}
	
}
