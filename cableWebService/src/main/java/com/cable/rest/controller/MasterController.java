package com.cable.rest.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cable.rest.dto.AreaDto;
import com.cable.rest.dto.BaseDto;
import com.cable.rest.dto.MasterListDto;
import com.cable.rest.dto.StreetDto;
import com.cable.rest.dto.ZipCodeDto;
import com.cable.rest.search.MasterSearch;
import com.cable.rest.search.ProjectSearch;

@RestController
@RequestMapping("/master")
@Log4j
public class MasterController extends BaseController {
	
	@RequestMapping(value="/savezipcode",method=RequestMethod.POST)
	public ZipCodeDto  saveZipCode(@RequestBody ZipCodeDto reqObject){
		return (ZipCodeDto) sendtoMQ(reqObject, "saveZipCode", "masterService");
	}
	
	
	@RequestMapping(value="/zipcodelist",method=RequestMethod.POST)
	public MasterListDto getZipCode(@RequestBody MasterSearch searchObject){
		return (MasterListDto) sendtoMQ(searchObject, "getZipCode", "masterService");
	}
	
	@RequestMapping(value="/deletezipcode",method=RequestMethod.POST)
	public BaseDto deleteZipCode(@RequestBody MasterSearch searchObject){
		return (BaseDto) sendtoMQ(searchObject, "deleteZipCode", "masterService");
	}
	
	
	
	
	@RequestMapping(value="/savearea",method=RequestMethod.POST)
	public AreaDto  saveArea(@RequestBody AreaDto reqObject){
		return (AreaDto) sendtoMQ(reqObject, "saveArea", "masterService");
	}
	
	@RequestMapping(value="/arealist",method=RequestMethod.POST)
	public MasterListDto getArea(@RequestBody MasterSearch searchObject){
		return (MasterListDto) sendtoMQ(searchObject, "getArea", "masterService");
	}
	
	@RequestMapping(value="/deletearea",method=RequestMethod.POST)
	public BaseDto deleteArea(@RequestBody MasterSearch searchObject){
		return (BaseDto) sendtoMQ(searchObject, "deleteArea", "masterService");
	}
	
	
	
	
	@RequestMapping(value="/savestreet",method=RequestMethod.POST)
	public StreetDto  saveStreet(@RequestBody StreetDto reqObject){
		return (StreetDto) sendtoMQ(reqObject, "saveStreet", "masterService");
	}
	
	@RequestMapping(value="/streetlist",method=RequestMethod.POST)
	public MasterListDto getStreet(@RequestBody MasterSearch searchObject){
		return (MasterListDto) sendtoMQ(searchObject, "getStreet", "masterService");
	}
	
	@RequestMapping(value="/deletestreet",method=RequestMethod.POST)
	public BaseDto deleteStreet(@RequestBody MasterSearch searchObject){
		return (BaseDto) sendtoMQ(searchObject, "deleteStreet", "masterService");
	}
	
}
