package xmu.crms.mapper;

import java.math.BigInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xmu.crms.entity.Topic;

/**
 * Created by zhangzhaoyang on 2017/12/19.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TopicMapperTest {
	@Autowired
    private TopicMapper topicMapper;
	private static Log log = LogFactory.getLog(TopicMapperTest.class);
	@Test
public	void testGetTopicByTopicId()throws  Exception
	{
		Topic topic= topicMapper.getTopicByTopicId(new BigInteger("1"));
		log.info(topic);
	}

}
