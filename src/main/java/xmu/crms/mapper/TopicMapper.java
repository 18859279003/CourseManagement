package xmu.crms.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;
/**
 * 
 * @author Zhang Zhaoyang
 *
 */
@Mapper
@Component
public interface TopicMapper {
	/**
	 * 根据话题Id获得topic对象
	 * @param topicId
	 * @return
	 */
    Topic getTopicByTopicId(@Param("topicId") BigInteger topicId);
    
    /**
     * 根据话题Id和话题对象topic更改话题信息
     * @param topicId
     * @param topic
     * @return
     */
    Integer updateTopicByTopicId ( @Param("topicId") BigInteger topicId,@Param("topic") Topic topic) ;
    
    /**
     * 根据话题Id删除话题
     * @param topicId
     * @return
     */
    Integer deleteTopicByTopicId(@Param("topicId") BigInteger topicId);

    /**
     * 根据讨论课Id列出所有的话题
     * @param seminarId
     * @return
     */
    List<Topic> listTopicBySeminarId(@Param("seminarId") BigInteger seminarId);
    
    /**
     * 根据讨论课id插入话题
     * @param seminarId
     * @param topic
     * @return
     */
    Integer insertTopicBySeminarId(@Param("seminarId") BigInteger seminarId, @Param("topic") Topic topic) ;

    /**
     * 根据小组Id和话题Id删除SeminarGroupTopic中的记录
     * @param groupId
     * @param topicId
     * @return
     */
    
    Integer deleteSeminarGroupTopicById(@Param("groupId") BigInteger groupId, @Param("topicId") BigInteger topicId);

    /**
     * 根据话题Id删除SeminarGroupTopic中的记录
     * @param topicId
     * @return
     */
     
    Integer deleteSeminarGroupTopicByTopicId(@Param("topicId") BigInteger topicId) ;

    /**
     * 传入空SeminarGroupTopic，从数据库装填返回
     * @param seminarGroupTopic
     * @return
     */
    SeminarGroupTopic getSeminarGroupTopicById(@Param("seminarGroupTopic") SeminarGroupTopic seminarGroupTopic);

    /**
     * 根据小组id返回一组SeminarGroupTopic
     * @param groupId
     * @return
     */
     
    List<SeminarGroupTopic> getSeminarGroupTopiclistByGroupId(@Param("groupId") BigInteger groupId);
  
}
