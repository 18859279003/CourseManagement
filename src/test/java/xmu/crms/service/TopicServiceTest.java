package xmu.crms.service;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xmu.crms.entity.Topic;
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
		
		//System.out.println(topicServiceImpl.getTopicByTopicId(new BigInteger("1")));
	}
	@Test
	public void insertTopicBySeminarIdTest()
	{
		Topic topic = new Topic();
		topic.setName("123456");
		topic.setDescription("123");
		topic.setGroupNumberLimit(new Integer("1"));
		topic.setGroupStudentLimit(new Integer("1"));
		topic.setSerial("A");
		topicServiceImpl.insertTopicBySeminarId(new BigInteger("1"), topic);
		System.out.println("******************************"+topic.getId()+"******************************");
	}
}
