package xmu.crms.mapper;

import java.math.BigInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClassMapperTest {
	@Autowired
	private ClassMapper classMapper;
	private static Log log = LogFactory.getLog(TopicMapperTest.class);
	@Test
	public void getClassByClassIdTest()
	{
		log.info(classMapper.getClassByClassId(new BigInteger("1")));
	}
}
