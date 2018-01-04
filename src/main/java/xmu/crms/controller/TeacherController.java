package xmu.crms.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * TeacherController
 * @author yangkepiao
 * @date 2017/12/26
 */
@Controller
public class TeacherController {

	 /**
     * 微信登陆
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/WechatLoginPage", method=RequestMethod.GET)
    String wechat(HttpServletResponse response) {
        return "/common/WechatLoginPage";
    }
    /**
     * 账号密码登录
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/AccountLoginPage", method=RequestMethod.GET)
    String account(){
    	return "/common/AccountLoginPage";
    }
    /**
     * 注册
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/RegisterPage", method=RequestMethod.GET)
    String register(HttpServletResponse response) throws IOException {
    	return "/common/RegisterPage.html";
	}
    /**
     * 老师绑定
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherBindPage", method=RequestMethod.GET)
    String teacherBind(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherBindPage.html";
	}
    /**
     * 老师班级信息
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherClassInfo", method=RequestMethod.GET)
    String teacherClassInfo(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherClassInfo.html";
	}
    /**
     * 老师课程首页
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCourseHomePage", method=RequestMethod.GET)
    String teacherCourseHome(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherCourseHomePage.html";
	}
    /**
     * 老师课程信息
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCourseInformation", method=RequestMethod.GET)
    String teacherCourseInformation(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherCourseInformation.html";
	}
    /**
     * 老师创建班级
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCreateClass", method=RequestMethod.GET)
    String teacherCreateClass(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherCreateClass.html";
	}
    /**
     * 老师创建课程
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCreateCoursePage", method=RequestMethod.GET)
    String teacherCreateCourse(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherCreateCoursePage.html";
	}
    /**
     * 老师创建学校
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCreateSchool", method=RequestMethod.GET)
    String teacherCreateSchool(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherCreateSchool.html";
	}
    /**
     * 老师创建讨论课
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCreateSeminar", method=RequestMethod.GET)
    String teacherCreateSeminar(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherCreateSeminar.html";
	}
    /**
     * 老师创建课题
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCreateTopic", method=RequestMethod.GET)
    String teacherCreateTopic(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherCreateTopic.html";
	}
    /**
     * 老师个人信息主页
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherHomePage", method=RequestMethod.GET)
    String teacherHomePage(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherHomePage.html";
	}
    /**
     * 老师个人信息修改
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherInfoModifyPage", method=RequestMethod.GET)
    String teacherInfoModifyPage(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherInfoModifyPage.html";
	}
    /**
     * 老师打分首页
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherScoreHome", method=RequestMethod.GET)
    String teacherScoreHome(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherScoreHome.html";
	}
    /**
     * 老师审阅打分首页
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherScoreReportPage", method=RequestMethod.GET)
    String teacherScoreReportPage(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherScoreReportPage.html";
	}
    /**
     * 老师讨论课信息
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherSeminarInfo", method=RequestMethod.GET)
    String teacherSeminarInfo(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherSeminarInfo.html";
	}
    /**
     * 老师讨论课课后查询话题
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherTopicCheckAfter", method=RequestMethod.GET)
    String teacherTopicCheckAfter(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherTopicCheckAfter.html";
	}
    /**
     * 老师讨论课课前查询话题
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherTopicCheckBefore", method=RequestMethod.GET)
    String teacherTopicCheckBefore(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherTopicCheckBefore.html";
	}
    /**
     * 老师修改班级
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherUpdateClass", method=RequestMethod.GET)
    String teacherUpdateClass(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherUpdateClass.html";
	}
    /**
     * 老师修改讨论课
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherUpdateSeminar", method=RequestMethod.GET)
    String teacherUpdateSeminar(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherUpdateSeminar.html";
	}
    /**
     * 老师修改课题
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherUpdateTopic", method=RequestMethod.GET)
    String teacherUpdateTopic(HttpServletResponse response) throws IOException {
    	return "html/teacher/TeacherUpdateTopic.html";
	}
    /**
     * 老师修改课程
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherUpdateCourse", method=RequestMethod.GET)
    String teacherUpdateCourse(HttpServletResponse response) throws IOException {
        return "html/teacher/TeacherUpdateCourse.html";
    }
}