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
@RequestMapping
public class TeacherController {

	 /**
     * 微信登陆
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/WechatLoginPage", method=RequestMethod.GET)
    void wechat(HttpServletResponse response) throws IOException {
        response.sendRedirect("html/common/WechatLoginPage.html");
    }
    /**
     * 账号密码登录
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/AccountLoginPage", method=RequestMethod.GET)
    void account(HttpServletResponse response) throws IOException {
        response.sendRedirect("html/common/AccountLoginPage.html");
    }
    /**
     * 注册
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/RegisterPage", method=RequestMethod.GET)
    void register(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/common/RegisterPage.html");
	}
    /**
     * 老师绑定
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherBindPage", method=RequestMethod.GET)
    void teacherBind(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherBindPage.html");
	}
    /**
     * 老师班级信息
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherClassInfo", method=RequestMethod.GET)
    void teacherClassInfo(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherClassInfo.html");
	}
    /**
     * 老师课程首页
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCourseHomePage", method=RequestMethod.GET)
    void teacherCourseHome(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherCourseHomePage.html");
	}
    /**
     * 老师课程信息
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCourseInformation", method=RequestMethod.GET)
    void teacherCourseInformation(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherCourseInformation.html");
	}
    /**
     * 老师创建班级
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCreateClass", method=RequestMethod.GET)
    void teacherCreateClass(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherCreateClass.html");
	}
    /**
     * 老师创建课程
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCreateCoursePage", method=RequestMethod.GET)
    void teacherCreateCourse(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherCreateCoursePage.html");
	}
    /**
     * 老师创建学校
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCreateSchool", method=RequestMethod.GET)
    void teacherCreateSchool(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherCreateSchool.html");
	}
    /**
     * 老师创建讨论课
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCreateSeminar", method=RequestMethod.GET)
    void teacherCreateSeminar(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherCreateSeminar.html");
	}
    /**
     * 老师创建课题
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherCreateTopic", method=RequestMethod.GET)
    void teacherCreateTopic(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherCreateTopic.html");
	}
    /**
     * 老师个人信息主页
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherHomePage", method=RequestMethod.GET)
    void teacherHomePage(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherHomePage.html");
	}
    /**
     * 老师个人信息修改
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherInfoModifyPage", method=RequestMethod.GET)
    void teacherInfoModifyPage(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherInfoModifyPage.html");
	}
    /**
     * 老师打分首页
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherScoreHome", method=RequestMethod.GET)
    void teacherScoreHome(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherScoreHome.html");
	}
    /**
     * 老师审阅打分首页
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherScoreReportPage", method=RequestMethod.GET)
    void teacherScoreReportPage(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherScoreReportPage.html");
	}
    /**
     * 老师讨论课信息
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherSeminarInfo", method=RequestMethod.GET)
    void teacherSeminarInfo(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherSeminarInfo.html");
	}
    /**
     * 老师讨论课课后查询话题
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherTopicCheckAfter", method=RequestMethod.GET)
    void teacherTopicCheckAfter(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherTopicCheckAfter.html");
	}
    /**
     * 老师讨论课课前查询话题
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherTopicCheckBefore", method=RequestMethod.GET)
    void teacherTopicCheckBefore(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherTopicCheckBefore.html");
	}
    /**
     * 老师修改班级
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherUpdateClass", method=RequestMethod.GET)
    void teacherUpdateClass(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherUpdateClass.html");
	}
    /**
     * 老师修改讨论课
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherUpdateSeminar", method=RequestMethod.GET)
    void teacherUpdateSeminar(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherUpdateSeminar.html");
	}
    /**
     * 老师修改课题
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherUpdateTopic", method=RequestMethod.GET)
    void teacherUpdateTopic(HttpServletResponse response) throws IOException {
    	response.sendRedirect("html/teacher/TeacherUpdateTopic.html");
	}
    /**
     * 老师修改课程
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/TeacherUpdateCourse", method=RequestMethod.GET)
    void teacherUpdateCourse(HttpServletResponse response) throws IOException {
        response.sendRedirect("html/teacher/TeacherUpdateCourse.html");
    }
}