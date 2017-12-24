package xmu.crms.mapper;

import java.math.BigInteger;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xmu.crms.entity.FixGroup;
/**
 * Created by zhangzhaoyang on 2017/12/19.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class FixGroupMapperTest {
	
	
		@Autowired
	    private FixGroupMapper fixGroupMapper;
		private static Log log = LogFactory.getLog(TopicMapperTest.class);
		@Test
		public void getFixGroupByGroupIdTest()
		{	
			FixGroup fixGroup=fixGroupMapper.getFixGroupByGroupId(new BigInteger("1"));
			log.info(fixGroup);
		}
	

}
