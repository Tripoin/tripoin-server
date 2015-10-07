package com.tripoin.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tripoin.core.dao.base.ABaseReadDaoJpa;
import com.tripoin.core.dao.filter.FilterArgument;
import com.tripoin.core.dao.filter.PageArgument;
import com.tripoin.core.dao.filter.SortArgument;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Repository
public class GenericReadDaoJpaImpl extends ABaseReadDaoJpa {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> loadObjectsFilterArgument(Class<T> objectType, FilterArgument[] filterArguments, Object[] values, SortArgument sortArgument, PageArgument pageArgument) throws Exception {
		System.out.println(jqlStatement.getJQL(objectType, filterArguments, values, sortArgument));
		Query query = getEntityManager().createQuery(jqlStatement.getJQL(objectType, filterArguments, values, sortArgument));
		if (values != null && values.length > 0) {
			jqlStatement.setParameterStatement(query, values);
		}			
		if(pageArgument != null){
			query = jqlStatement.pageStatement(query, pageArgument);
		}		
		List<T> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> loadObjectsJQLStatement(String jql, Object[] values, PageArgument pageArgument) throws Exception {
		Query query = getEntityManager().createQuery(jql);
		if (values != null && values.length > 0) {
			jqlStatement.setParameterStatement(query, values);
		}			
		if(pageArgument != null){
			query = jqlStatement.pageStatement(query, pageArgument);
		}		
		List<T> result = query.getResultList();
		return result;
	}

}
