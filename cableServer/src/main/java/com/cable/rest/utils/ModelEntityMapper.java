package com.cable.rest.utils;


import lombok.extern.log4j.Log4j;

import org.modelmapper.ModelMapper;

@Log4j
public class ModelEntityMapper {
	
	
	
	public static Object converModelToEntity(Object modelObject,Class entityName){
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
	
	public static Object converEntityToModel(Object entityObject,Class modelName){
		try{
			
			if(entityObject==null)return null;
			
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(entityObject, modelName);
			
		}
		catch(Exception e){
			log.error("Error while Conver EntityToModel "+modelName.getName(), e);
			return null;
		}
	
	}

}
