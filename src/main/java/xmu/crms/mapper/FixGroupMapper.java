package xmu.crms.mapper;

import java.math.BigInteger;

import org.apache.ibatis.annotations.Param;

import xmu.crms.entity.FixGroup;

public interface FixGroupMapper {
	/**
     * @param groupId 要获取的group的groupId
     * @return 该group
     * @author zhangzhaoyang
     * @date 2017/12/20
     */
    FixGroup getFixGroupByGroupId(@Param("groupId") BigInteger groupId);
}
