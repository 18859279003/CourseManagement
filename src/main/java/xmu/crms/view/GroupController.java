package xmu.crms.view;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.model.Group;
import xmu.crms.model.PresentationGrade;
import xmu.crms.model.SeminarGrade;
import xmu.crms.model.Student;
import xmu.crms.model.Topic;

@RestController
@RequestMapping("/group")
public class GroupController {
	
	//按ID获取小组详情，传入小组id，返回小组对象
    //是否包含小组选择的话题、是否包含小组的成绩
	@RequestMapping(value="/{groupId}", method=RequestMethod.GET)
	public Group getTopicrById(@PathParam("groupId") Integer groupId, boolean embedTopics, boolean embedGrade){
		 Student members[]=new Student[2];
		 members[0]=new Student(  5324, "李四", null);
		 members[0]=new Student(  5678, "王五", null);
		 Topic topic[]=new Topic[1];
		topic[0]=new Topic(  257, null,"领域模型与模块", null, groupId, groupId, groupId);
		Group group=new Group(28,null, new Student(8888, "张三", null),members,topic , null, null);//假的
		return group;
	}

	 //组长辞职
    @RequestMapping(value="/{groupId}/resign", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void resign(@PathParam("classId") Integer classId, int studentId){
    }
    
     //成为组长
    @RequestMapping(value="/{groupId}/assign", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void assign(@PathParam("classId") Integer classId, int studentId){
    }
    
    //添加成员
    @RequestMapping(value="/{groupId}/add", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void add(@PathParam("classId") Integer classId, int studentId){
    }
    
    //移除成员
    @RequestMapping(value="/{groupId}/remove", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void remvoe(@PathParam("classId") Integer classId, int studentId){
    }
    
    //小组按ID选择话题,TODO
    @RequestMapping(value="/{groupId}/topic", method=RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.CREATED)
    public String chooseTopic(@PathParam("groupId") Integer groupId, int topicId){
        String url = "/group/27/topic/23";
        return url;
    }
    
    //小组按ID取消选择话题
    @RequestMapping(value="/{groupId}/topic/{topicId}", method=RequestMethod.DELETE)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void cancelTopic(@PathParam("groupId") Integer groupId, @PathParam("topicId") Integer  topicId){
    }

	//按ID获取小组的讨论课成绩
	@RequestMapping(value="/{groupId}/grade", method=RequestMethod.GET)
	public SeminarGrade getGradeByGroupId(@PathParam("groupId") Integer groupId){
		PresentationGrade presentationGrades[]=new PresentationGrade[1];
		presentationGrades[0]=new PresentationGrade(257,4);
		return new SeminarGrade( presentationGrades, 3, 4);		
	}
	
	//按ID设置小组的报告分
	@RequestMapping(value="/{groupId}/grade", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.OK)
	public void gradeByGroupId(@PathParam("groupId") Integer groupId, int reportGrade){
	}
	
	//提交对其他小组的打分是小程序端的
}
