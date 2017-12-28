package xmu.crms.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.Topic;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.serviceimpl.SeminarGroupImpl;
import xmu.crms.serviceimpl.SeminarImpl;
import xmu.crms.serviceimpl.TopicServiceImpl;
import xmu.crms.serviceimpl.UserServiceImpl;
import xmu.crms.vo.ScoreVo;
import xmu.crms.vo.SeminarVo;
import xmu.crms.vo.StudentSeminarVo;

@RestController
@RequestMapping("/seminar")
/**
 * 
 * @author Zhuang Dandan
 *
 */
public class SeminarController {

    @Autowired
    private TopicServiceImpl topicServiceImpl;
    @Autowired
    private SeminarGroupImpl seminarGroupImpl;
    @Autowired
    private UserServiceImpl userServiceImpl ;
    @Autowired
    private SeminarImpl seminarServiceImpl;
	/**
	 * 按ID获取讨论课，传入讨论课id，返回讨论课对象
	 * @param seminarId
	 * @return
	 * @throws SeminarNotFoundException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/{seminarId}", method=RequestMethod.GET)
	public SeminarVo getSeminarById(@PathVariable("seminarId") int seminarId) throws IllegalArgumentException, SeminarNotFoundException{
		Seminar seminar=seminarServiceImpl.getSeminarBySeminarId(new BigInteger(((Integer)seminarId).toString()));
    	SeminarVo seminarVo= new SeminarVo();
    	seminarVo.setName(seminar.getName());
    	seminarVo.setDescription(seminar.getDescription());
    	seminarVo.setStartTime(seminar.getStartTime().toString());
    	seminarVo.setEndTime(seminar.getEndTime().toString());
    	if(seminar.getFixed())
    	{
    		seminarVo.setGroupingMethod("固定分组");
    	}
    	else
    	{
    		seminarVo.setGroupingMethod("随机分组");
    	}
    	List<Topic> topiclist = topicServiceImpl.listTopicBySeminarId(new BigInteger(((Integer)seminarId).toString()));
    	Topic[] topics = (Topic[])topiclist.toArray(new Topic[topiclist.size()]);
    	seminarVo.setTopics(topics);
        return seminarVo;
	}
	
	/**
	 * 按ID修改讨论课，传入讨论课id和json
	 * @param seminarId
	 * @param seminar
	 * @throws SeminarNotFoundException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/{seminarId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateSeminarById(@PathVariable("seminarId") int seminarId, @RequestBody Seminar seminar) throws IllegalArgumentException, SeminarNotFoundException{
		seminarServiceImpl.updateSeminarBySeminarId(new BigInteger(((Integer)seminarId).toString()), seminar);
	}
	
	/**
	 * 按ID删除讨论课，传入讨论课id
	 * @param seminarId
	 * @throws SeminarNotFoundException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/{seminarId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteSeminarById(@PathVariable("seminarId") int seminarId) throws IllegalArgumentException, SeminarNotFoundException{
		seminarServiceImpl.deleteSeminarBySeminarId(new BigInteger(((Integer)seminarId).toString()));
	}
	
	/**
	 * 按ID获取与学生有关的讨论课信息
	 * @param seminarId
	 * @return
	 */
	@RequestMapping(value="/{seminarId}/my", method=RequestMethod.GET)
    public StudentSeminarVo getStudentSeminarById(@PathVariable("seminarId") int seminarId){
	    StudentSeminarVo seminar=new StudentSeminarVo(32,"概要设计","random","OOAD","2017-10-11","2017-10-24",23,true,true);
        return seminar;
    }	
	
	 /**
	  * 按ID获取讨论课详情
	  * @param seminarId
	  * @return
	 * @throws SeminarNotFoundException 
	 * @throws IllegalArgumentException 
	  */
    @RequestMapping(value="/{seminarId}/detail", method=RequestMethod.GET)
    public SeminarVo getSeminarDetailById(@PathVariable("seminarId") int seminarId) throws IllegalArgumentException, SeminarNotFoundException{
    	Seminar seminar=seminarServiceImpl.getSeminarBySeminarId(new BigInteger(((Integer)seminarId).toString()));
    	SeminarVo seminarVo= new SeminarVo();
    	seminarVo.setName(seminar.getName());
    	seminarVo.setDescription(seminar.getDescription());
    	seminarVo.setStartTime(seminar.getStartTime().toString());
    	seminarVo.setEndTime(seminar.getEndTime().toString());
    	if(seminar.getFixed())
    	{
    		seminarVo.setGroupingMethod("固定分组");
    	}
    	else
    	{
    		seminarVo.setGroupingMethod("随机分组");
    	}
    	List<Topic> topiclist = topicServiceImpl.listTopicBySeminarId(new BigInteger(((Integer)seminarId).toString()));
    	Topic[] topics = (Topic[])topiclist.toArray(new Topic[topiclist.size()]);
    	seminarVo.setTopics(topics);
        return seminarVo;
    }   
    
	/**
	 * 按ID获取讨论课的话题
	 * @param seminarId
	 * @return
	 */
	@RequestMapping(value="/{seminarId}/topic", method=RequestMethod.GET)
	public List<Topic> getTopicList(@PathVariable("seminarId") int seminarId){
		return topicServiceImpl.listTopicBySeminarId(new BigInteger(((Integer)seminarId).toString()));
	}
	
	/**
	 * 在指定ID的讨论课创建话题
	 * @param seminarId
	 * @param topic
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/{seminarId}/topic", method=RequestMethod.POST)
	public int createTopic(@PathVariable("seminarId") int seminarId, @RequestBody Topic topic, HttpServletResponse response){	
	    System.out.println(seminarId);
	    System.out.println(topic);
		response.setStatus(201);
		return topicServiceImpl.insertTopicBySeminarId(new BigInteger(((Integer)seminarId).toString()), topic).intValue();
	}
	
	/**
	 * 按讨论课ID查找小组
	 * 可选参数Boolean gradeable可打分的、int classId此班级的
	 * @param seminarId
	 * @param gradeable
	 * @param classId
	 * @return
	 * @throws SeminarNotFoundException 
	 * @throws IllegalArgumentException 
	 * @throws UserNotFoundException 
	 */
	@RequestMapping(value="/{seminarId}/group", method=RequestMethod.GET)
	public List<ScoreVo> getGroupListBySeminarId(
	        @PathVariable("seminarId") int seminarId, boolean gradeable, int classId) throws IllegalArgumentException, SeminarNotFoundException, UserNotFoundException{	
		List<ScoreVo> scoreVoList= new  ArrayList<ScoreVo>();
		List<SeminarGroup> seminarGrouplist=seminarGroupImpl.listSeminarGroupBySeminarId(new BigInteger(((Integer)seminarId).toString()));
		for(int i=0;i<seminarGrouplist.size();i++)
		{
			
			if(topicServiceImpl.listSeminarGroupTopicByGroupId(seminarGrouplist.get(i).getId()).size()>1)
			{
				for(int j=0;j<topicServiceImpl.listSeminarGroupTopicByGroupId(seminarGrouplist.get(i).getId()).size();j++)
				{
					ScoreVo scoreVo= new ScoreVo();
					scoreVo.setTopic((topicServiceImpl.listSeminarGroupTopicByGroupId(seminarGrouplist.get(i).getId())).get(j).getTopic().getName());
					scoreVo.setGrade(seminarGrouplist.get(i).getFinalGrade());
					scoreVo.setGroupName(seminarGrouplist.get(i).getId().toString());
					scoreVo.setLeaderName(userServiceImpl.getUserByUserId(seminarGrouplist.get(i).getLeader().getId()).getName() );
					scoreVo.setPresentationGrade(seminarGrouplist.get(i).getPresentationGrade());
					scoreVo.setReport(seminarGrouplist.get(i).getReport());
					scoreVo.setReportGrade(seminarGrouplist.get(i).getReportGrade());
					scoreVoList.add(scoreVo);
				}
			}
			else
			{
			ScoreVo scoreVo= new ScoreVo();
			scoreVo.setTopic((topicServiceImpl.listSeminarGroupTopicByGroupId(seminarGrouplist.get(i).getId())).get(0).getTopic().getName());
			scoreVo.setGrade(seminarGrouplist.get(i).getFinalGrade());
			scoreVo.setGroupName(seminarGrouplist.get(i).getId().toString());
			scoreVo.setLeaderName(userServiceImpl.getUserByUserId(seminarGrouplist.get(i).getLeader().getId()).getName() );
			scoreVo.setPresentationGrade(seminarGrouplist.get(i).getPresentationGrade());
			scoreVo.setReport(seminarGrouplist.get(i).getReport());
			scoreVo.setReportGrade(seminarGrouplist.get(i).getReportGrade());
			scoreVoList.add(scoreVo);
			}
		}
		return scoreVoList;
	}
	

}
