package com.blog.core.dao;

import com.blog.core.entity.RocketmqTransactionLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @description:
 * @author: 950103
 * @create: 2020-05-30 17:21
 * @Version: 1.0
 */
public interface RocketmqTransactionLogMapper {

	@Insert("insert into TransactionLog (transactionId,log) values (#{transactionId}, #{log})")
	void insertSelective(RocketmqTransactionLog rocketmqTransactionLog);

	@Select("select transactionId,log from TransactionLog where transactionId = #{transactionId}")
	RocketmqTransactionLog selectOne(String transactionId);
}
