package com.blog.core.entity;

import lombok.Builder;

/**
 * @program: RocketmqTransactionLog
 * @description:
 * @author: 950103
 * @create: 2020-05-30 17:22
 * @Version: 1.0
 */
@Builder
public class RocketmqTransactionLog {

	private String transactionId;

	private String log;
}
