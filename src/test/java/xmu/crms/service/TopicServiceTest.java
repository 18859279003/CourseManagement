package xmu.crms.service;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.serviceimpl.TopicServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TopicServiceTest {
	@Autowired
	private TopicServiceImpl topicServiceImpl;
	@Test
	public void getTopicByTopicIdTest() throws IllegalArgumentException, TopicNotFoundException
	{
		
		System.out.println(topicServiceImpl.getTopicByTopicId(new BigInteger("1")));
	}
}
