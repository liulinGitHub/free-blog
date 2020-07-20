package com.blog.core.common.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ClassName: JobFactory
 * @description:
 * @author: 950103
 * @create: 2020-07-20 17:13
 * @Version: 1.0
 */
public class JobFactory implements Job {

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		jobExecutionContext.getMergedJobDataMap();
	}
}
