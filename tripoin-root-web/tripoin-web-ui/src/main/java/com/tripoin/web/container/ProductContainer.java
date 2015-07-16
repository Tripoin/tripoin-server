package com.tripoin.web.container;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tripoin.core.dto.ProductData;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItemContainer;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component
@Scope("prototype")
public class ProductContainer extends BeanItemContainer<ProductData> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4026680551881904891L;

    public static final String BEAN_ID = "id";

    public static final String[] PROPERTIES = {BEAN_ID, "productName", "price", "stockCount"};

    public static final String[] HEADERS = {"ID", "Product Name", "Price", "Stock"};
    
	public ProductContainer() {
		super(ProductData.class);
		
	}

}
