package xmu.crms.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;
/**
 * Topic Mapper
 * @author zhangzhaoyang
 * @date 2017/12/20
 */
@Mapper
@Component
public interface TopicMapper {
	/**
     * @param topicId 要获取的topic的topicId
     * @return 该topic
     * @author zhangzhaoyang
     * @date 2017/12/20
     */
    Topic getTopicByTopicId(@Param("topicId") BigInteger topicId);
    
    /**
     * @param topicId 讨论课的ID
     * @param topic   修改后的讨论课
     * @date 2017/12/20
     * @author zhangzhaoyang
     */
    void updateTopicByTopicId ( @Param("topicId") BigInteger topicId,@Param("topic") Topic topic) ;
    
    /**
     * @param topicId 要删除的topic的topicId
     * @date 2017/12/20
     * @author zhangzhaoyang
     */
    void deleteTopicByTopicId(@Param("topicId") BigInteger topicId);

    /**
     * @param seminarId 课程Id
     * @return List<Topic>
     * @date 2017/12/20
     * @author zhangzhaoyang
     */
    List<Topic> listTopicBySeminarId(@Param("seminarId") BigInteger seminarId);
    
    /**
     * @param seminarId 话题所属讨论课的Id
     * @param topic     话题
     * @return 新建话题后给topic分配的Id
     * @date 2017/12/20
     * @author zhangzhaoyang
     */
    BigInteger insertTopicBySeminarId(@Param("seminarId") BigInteger seminarId, @Param("topic") Topic topic) ;

    /**
     * @param groupId 小组Id
     * @param topicId 话题Id
     * @date 2017/12/20
     * @author zhangzhaoyang
     */
    void deleteTopicById(@Param("groupId") BigInteger groupId, @Param("topicId") BigInteger topicId) ;

    /**
     * @param topicId 讨论课Id
     * @date 2017/12/20
     * @author zhangzhaoyang
     */
    void deleteSeminarGroupTopicByTopicId(@Param("topicId") BigInteger topicId) ;

    /**
     * @param topicId 话题id
     * @param groupId 组id
     * @date 2017/12/20
     * @author zhangzhaoyang
     */
    SeminarGroupTopic getSeminarGroupTopicById(@Param("topicId") BigInteger topicId,@Param("groupId") BigInteger groupId) ;


    /**
     * @param seminarId 讨论课Id
     * @date 2017/12/20
     * @author zhangzhaoyang  
     */
    void deleteTopicBySeminarId(@Param("seminarId") BigInteger seminarId);
}
