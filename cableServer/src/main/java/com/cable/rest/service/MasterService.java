package com.cable.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.cable.rest.dto.AreaDto;
import com.cable.rest.dto.BaseDto;
import com.cable.rest.dto.MasterListDto;
import com.cable.rest.dto.OrganizationDto;
import com.cable.rest.dto.StreetDto;
import com.cable.rest.dto.ZipCodeDto;
import com.cable.rest.model.Area;
import com.cable.rest.model.Organization;
import com.cable.rest.model.Street;
import com.cable.rest.model.ZipCode;
import com.cable.rest.repository.AreaJPARepo;
import com.cable.rest.repository.StreetJPARepo;
import com.cable.rest.repository.ZipCodeJPARepo;
import com.cable.rest.search.MasterSearch;
import com.cable.rest.utils.ModelEntityMapper;






@Service
public class MasterService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	ZipCodeJPARepo zipCodeRepo;
	
	@Autowired
	AreaJPARepo areaRepo;
	
	@Autowired
	StreetJPARepo streetRepo;
	
	@Transactional
	public ZipCodeDto saveZipCode(ZipCodeDto Object) {
		try{
			
			ZipCode zipCodeEntity=(ZipCode) ModelEntityMapper.converObjectToPoJo(Object, ZipCode.class);
			zipCodeRepo.saveAndFlush(zipCodeEntity);
			Object.setZipCode(zipCodeEntity.getZipCode());
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return Object;
	}
	
	@Transactional
	@Rollback(false)
	public MasterListDto getZipCode(MasterSearch search) {
		try{
			MasterListDto result=new MasterListDto();
			List<ZipCodeDto> zipcodeList=new ArrayList<ZipCodeDto>();
			Session session = entityManager.unwrap(Session.class);
			
			Criteria criteria= session.createCriteria(ZipCode.class);
			
			if(search.getZipCode() !=null && search.getZipCode() >0l){
				criteria.add(Restrictions.eq("zipCode", search.getZipCode()));
			}
			
			List<ZipCode> list=criteria.list();
			
			zipcodeList = (List<ZipCodeDto>) ModelEntityMapper.convertListToCollection(list);
			
			/*for( ZipCode entityObject: list){
				ZipCodeDto zipcodeDto=(ZipCodeDto) ModelEntityMapper.converObjectToPoJo(entityObject, ZipCodeDto.class);
				zipcodeList.add(zipcodeDto);
			}*/
			result.setZipCodeList(zipcodeList);
			
			return result;
		}
		catch(Exception e){
			return null;
		}
	}

	@Transactional
	public BaseDto deleteZipCode(MasterSearch search) {
		try{
			BaseDto result=new BaseDto();
			zipCodeRepo.delete(search.getZipCode());
			return result;
		}
		catch(Exception e){
			return null;
		}
	}
	
	@Transactional
	public AreaDto saveArea(AreaDto Object) {
		try{
			Area areaEntity=(Area) ModelEntityMapper.converObjectToPoJo(Object, Area.class);
			areaRepo.save(areaEntity);
			Object.setAreaId(areaEntity.getAreaId());
			return Object;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Transactional
	@Rollback(false)
	public MasterListDto getArea(MasterSearch search) {
		try{
			MasterListDto result=new MasterListDto();
			List<AreaDto> areaList=new ArrayList<AreaDto>();
			Session session = entityManager.unwrap(Session.class);
			
			Criteria criteria= session.createCriteria(Area.class);
			
			if(search.getAreaId() !=null && search.getAreaId() >0l){
				criteria.add(Restrictions.eq("areaId", search.getAreaId()));
			}
			
			List<Area> list=criteria.list();
			
			for( Area entityObject: list){
				AreaDto areaDto=(AreaDto) ModelEntityMapper.converObjectToPoJo(entityObject, AreaDto.class);
				areaList.add(areaDto);
			}
			result.setAreaList(areaList);
			
			return result;
		}
		catch(Exception e){
			return null;
		}
	}

	@Transactional
	public BaseDto deleteArea(MasterSearch search) {
		try{
			BaseDto result=new BaseDto();
			areaRepo.delete(search.getAreaId());
			return result;
		}
		catch(Exception e){
			return null;
		}
	}

	
	@Transactional
	public StreetDto saveStreet(StreetDto Object) {
		try{
			Street streetEntity=(Street) ModelEntityMapper.converObjectToPoJo(Object, Street.class);
			streetRepo.save(streetEntity);
			Object.setStreetId(streetEntity.getStreetId());
			return Object;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Rollback(false)
	public MasterListDto getStreet(MasterSearch search) {
		try{
			MasterListDto result=new MasterListDto();
			List<StreetDto> streetList=new ArrayList<StreetDto>();
			Session session = entityManager.unwrap(Session.class);
			
			Criteria criteria= session.createCriteria(Street.class);
			
			if(search.getStreetId() !=null && search.getStreetId() >0l){
				criteria.add(Restrictions.eq("streetId", search.getStreetId()));
			}
			
			List<Street> list=criteria.list();
			
			for( Street entityObject: list){
				StreetDto streetDto=(StreetDto) ModelEntityMapper.converObjectToPoJo(entityObject, StreetDto.class);
				streetList.add(streetDto);
			}
			result.setStreetList(streetList);
			
			return result;
		}
		catch(Exception e){
			return null;
		}
	}

	
	@Transactional
	public BaseDto deleteStreet(MasterSearch search) {
		try{
			BaseDto result=new BaseDto();
			streetRepo.delete(search.getStreetId());
			return result;
		}
		catch(Exception e){
			return null;
		}
	}
	
}
