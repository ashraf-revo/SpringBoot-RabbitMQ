package com.cable.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cable.rest.dto.AreaDto;
import com.cable.rest.dto.StreetDto;
import com.cable.rest.dto.ZipCodeDto;
import com.cable.rest.model.Area;
import com.cable.rest.model.Street;
import com.cable.rest.model.ZipCode;
import com.cable.rest.repository.AreaJPARepo;
import com.cable.rest.repository.StreetJPARepo;
import com.cable.rest.repository.ZipCodeJPARepo;
import com.cable.rest.search.MasterSearch;
import com.cable.rest.utils.ModelEntityMapper;






@Service
public class MasterService {
	
	@Autowired
	ZipCodeJPARepo zipCodeRepo;
	
	@Autowired
	AreaJPARepo areaRepo;
	
	@Autowired
	StreetJPARepo streetRepo;
	
	@Transactional
	public boolean saveZipCode(ZipCodeDto Object) {
		try{
			
			ZipCode zipCodeEntity=(ZipCode) ModelEntityMapper.converModelToEntity(Object, ZipCode.class);
			zipCodeRepo.saveAndFlush(zipCodeEntity);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public List<ZipCodeDto> getZipCode(MasterSearch search) {
		return null;
	}

	@Transactional
	public boolean deleteZipCode(MasterSearch search) {
		return false;
	}
	
	@Transactional
	public boolean saveArea(AreaDto Object) {
		try{
			Area areaEntity=(Area) ModelEntityMapper.converModelToEntity(Object, Area.class);
			areaRepo.save(areaEntity);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public List<AreaDto> getArea(MasterSearch search) {
		return null;
	}

	@Transactional
	public boolean deleteArea(MasterSearch search) {
		return false;
	}

	
	@Transactional
	public boolean saveStreet(StreetDto Object) {
		try{
			Street streetEntity=(Street) ModelEntityMapper.converModelToEntity(Object, Street.class);
			streetRepo.save(streetEntity);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public List<StreetDto> getStreet(MasterSearch search) {
		return null;
	}

	
	@Transactional
	public boolean deleteStreet(MasterSearch search) {
		return false;
	}
	
}
