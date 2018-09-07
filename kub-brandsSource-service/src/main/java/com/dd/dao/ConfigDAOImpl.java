package com.dd.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import com.dd.data.Brand;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Component
public class ConfigDAOImpl implements ConfigDAO{
	
	@Autowired
	private MongoDbFactory mongo;
	
		
	@Override
	public List<Brand> getVehBrands() throws DAOException, RuntimeException {
		DBCollection topBrandsColl=null;
		DBCursor cursor =null;
		DBObject eachDbObject=null;
		List<Brand> brands = new LinkedList<Brand>();
		try {
			topBrandsColl = mongo.getDb().getCollection("VehMakes");
			BasicDBObject query = new BasicDBObject();
			cursor = topBrandsColl.find(query).sort(new BasicDBObject("make",1));
			Brand eachBrnd =null;
			while (cursor.hasNext()) {
				try {
					eachDbObject = cursor.next();
					eachBrnd = new Brand();
					eachBrnd.setBrand((String)eachDbObject.get("make"));
					eachBrnd.setSelected(false);
					brands.add(eachBrnd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return brands;
							
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new DAOException(e1.getMessage());
		}
	}

}
