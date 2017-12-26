package xmu.crms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import xmu.crms.entity.School;

@RestController
@RequestMapping("/school")
/**
 * 
 * @author Zhuang Dandan
 *
 */
public class SchoolController {
	
	/**
	 * TODO
	 * 获取学校列表（按照城市查找学校
	 * @param city
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<School> getSchoolList(String city){
		List<School> schoollist=new ArrayList<School>();
		return schoollist;
	}
	
	/**
	 * 添加学校
	 * TODO
	 * @param school
	 * @param response
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	public int createSchool(@RequestBody School school, HttpServletResponse response){
		response.setStatus(201);
		return school.getId().intValue();
	}
	
	/**
	 * 获取省份列表
	 * @return
	 */
    @RequestMapping(value="/province", method=RequestMethod.GET)
    public List<String> getProvinceList(){
        List<String> provincelist=new ArrayList<String>();
        provincelist.add("北京");
        provincelist.add("天津");
        provincelist.add("河北省");
        provincelist.add("……");
        provincelist.add("澳门特别行政区");
        return provincelist;
    }
    
	/**
	 * 获取城市列表
	 * @param province
	 * @return
	 */
    @RequestMapping(value="/city", method=RequestMethod.GET)
    public List<String> getCityList(String province){
        List<String> citylist=new ArrayList<String>();
        citylist.add("北京");
        citylist.add("天津");
        citylist.add("河北省");
        citylist.add("……");
        citylist.add("澳门特别行政区");
        return citylist;
    }
}
