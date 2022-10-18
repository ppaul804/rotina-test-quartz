package br.com.ppaul804.rotinatestquartz.config;

import br.com.ppaul804.rotinatestquartz.job.LoadBookJob;
import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

@Configuration
public class QuartzConfig {

    /**
     * Creates a SpringBeanJobFactory with the capability on the Scheduler to weave
     * the beans in the spring context.
     * 
     * @param applicationContext
     * @return SpringBeanJobFactory
     */
    @Bean
    public SpringBeanJobFactory createSpringBeanJobFactory(ApplicationContext applicationContext) {
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    /**
     * Creates a SchedulerFactoryBean with auto-wiring support to quartz jobs.
     * 
     * @param applicationContext
     * @return SchedulerFactoryBean
     */
    public SchedulerFactoryBean createSchedulerFactory(ApplicationContext applicationContext) {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setJobFactory(createSpringBeanJobFactory(applicationContext));
        return schedulerFactory;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Bean
    public Trigger createTriggerBean(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .withRepeatCount(10))
                .build();
    }

    @Bean
    public JobDetail createJobDetailBean() {
        return JobBuilder.newJob()
                .storeDurably()
                .ofType(LoadBookJob.class)
                .build();
    }
}
