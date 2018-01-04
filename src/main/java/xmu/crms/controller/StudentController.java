package xmu.crms.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * StudentController
 * @author yangkepiao
 * @date 2017/12/26
 */
@Controller
@RequestMapping
public class StudentController {
	/**
	 * 学生绑定
	 * @param response
	 * @throws IOException
	 */
    @RequestMapping(value="/StudentBindPage", method=RequestMethod.GET)
   String studentBindPage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentBindPage.html";
	}
    /**
	 * 学生选课
	 * @param response
	 * @throws IOException
	 */
    @RequestMapping(value="/StudentChooseCoursePage", method=RequestMethod.GET)
   String studentChooseCoursePage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentChooseCoursePage.html";
	}
    /**
	 * 学生课程首页
	 * @param response
	 * @throws IOException
	 */
    @RequestMapping(value="/StudentCourseHome", method=RequestMethod.GET)
   String studentCourseHome(HttpServletResponse response) throws IOException {
    	return "html/student/StudentCourseHome.html";
	}
  /**
   * 学生课程信息
   * @param response
   * @throws IOException
   */
    @RequestMapping(value="/StudentCourseInformation", method=RequestMethod.GET)
   String studentCourseInformation(HttpServletResponse response) throws IOException {
    	return "html/student/StudentCourseInformation.html";
	}
    /**
     * 学生固定分组讨论课
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/StudentSeminarPage(fixed)", method=RequestMethod.GET)
   String studentFixedSemunarPage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentSeminarPage(fixed).html";
	}
    /**
     * 学生个人信息首页
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/StudentHomePage", method=RequestMethod.GET)
   String studentHomePage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentHomePage.html";
	}
    /**
     * 学生个人信息修改
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/StudentInfoModifyPage", method=RequestMethod.GET)
   String studentInfoModifyPage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentInfoModifyPage.html";
	}
    /**
     * 学生管理分组
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/StudentManageGroupPage", method=RequestMethod.GET)
   String studentManageGroupPage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentManageGroupPage.html";
	}
    /**
     * 学生修改分组
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/StudentModifyGroupPage", method=RequestMethod.GET)
   String studentModifyGroupPage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentModifyGroupPage.html";
	}
    /**
     * 学生随机讨论课
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/StudentSeminarPage(random)", method=RequestMethod.GET)
   String studentRandomSeminarPage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentSeminarPage(random).html";
	}
    /**
     * 学生查看分数
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/StudentViewGradePage", method=RequestMethod.GET)
   String studentViewGradePage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentViewGradePage.html";
	}
    /**
     * 学生查看分组
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/StudentViewGroupPage", method=RequestMethod.GET)
   String studentViewGroupPage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentViewGroupPage.html";
	}
    /**
     * 学生查看话题（固定）
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/StudentViewTopicPage(fixed)", method=RequestMethod.GET)
   String studentViewFixedTopicPage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentViewTopicPage(fixed).html";
	}
    /**
     * 学生查看话题（随机）
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/StudentViewTopicPage(random)", method=RequestMethod.GET)
   String studentViewRandomTopicPage(HttpServletResponse response) throws IOException {
    	return "html/student/StudentViewTopicPage(random).html";
	}
}
