package com.cable.rest.utils;


import java.util.List;

import lombok.extern.log4j.Log4j;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.util.CollectionUtils;



@Log4j
public class ModelEntityMapper {
	
	public static Object converObjectToPoJo(Object modelObject,Class entityName){
		try{
			
			if(modelObject==null)return null;
			
			ModelMapper modelMapper = new ModelMapper();
			 modelMapper.getConfiguration().setFieldMatchingEnabled(true);
			return modelMapper.map(modelObject, entityName);
			
		}
		catch(Exception e){
			log.error("Error while Conver ModelToEntity "+entityName.getName(), e);
			return null;
		}
	
	}
	
	
	public static <T> List<?> convertListToCollection(List<T> list){
		try{
			if(CollectionUtils.isEmpty(list))
				return null;
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setFieldMatchingEnabled(true);
			return modelMapper.map(list, new TypeToken<List<?>>() {}.getType());

		}
		catch(Exception e){
			log.error("Error while Conver ListToCollection ", e);
			return null;
		}
		
	}

	
	
	
	
	
	

}
