package xmu.crms.controller;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xmu.crms.entity.FixGroup;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.FixGroupNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.vo.ClassGroupVo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClassControllerTest {
	@Autowired
private ClassController classController;
	@Test
	public void getClassListTest() throws CourseNotFoundException, UserNotFoundException
	{
		// System.out.println(classController.getClassList(null,"邱明"));
	}
	@Test
	public void getGroupByClassIdTest() throws IllegalArgumentException, ClassesNotFoundException, UserNotFoundException, FixGroupNotFoundException
	{
		//System.out.println(classController.getGroupByClassId(1, 3));
	}
	@Test
	public void getClassByClassIdTest() throws IllegalArgumentException, ClassesNotFoundException, UserNotFoundException, FixGroupNotFoundException
	{
		System.out.println(classController.getClassById(1));
	}
}
