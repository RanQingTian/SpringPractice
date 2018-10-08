package markdown

import org.slf4j.Logger
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.*
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.stereotype.Component
import java.util.Arrays
import java.util.Arrays.asList
import org.springframework.scheduling.TaskScheduler
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.SchedulingConfigurer
import org.springframework.scheduling.config.ScheduledTaskRegistrar
import org.slf4j.LoggerFactory
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit


/**
 * @author RanQingTian
 * @date 2018/4/25
 */
@Component
//@EnableScheduling
class StartupApplicationListenerExample : SchedulingConfigurer {
    @Autowired
    lateinit var taskScheduler: TaskScheduler
    val logger = LoggerFactory.getLogger(this.javaClass)
    lateinit var test: ScheduledFuture<*>
//    override fun afterPropertiesSet() {
//        println("init bean counter")
//        counter++
//    }

    @EventListener
    fun onApplicationEvent(event: ContextRefreshedEvent) {
        println("ContextRefreshedEvent counter")
        counter++
//        test = taskScheduler.scheduleAtFixedRate({ hello() }, 5000)
//        taskScheduler.scheduleAtFixedRate({ hello2() }, 5000)
    }

    @EventListener
    fun onApplicationEvent(event: ContextStartedEvent) {
        println("ContextStartedEvent counter")
        counter++
    }

    @EventListener
    fun onApplicationEvent(event: ContextClosedEvent) {
        println("ContextClosedEvent counter")
        counter++
    }

    @EventListener
    fun onApplicationEvent(event: ContextStoppedEvent) {
        println("ContextStoppedEvent counter")
        counter++
    }

    fun init() {
        println("init counter")
        counter++
    }

    //    @Scheduled(fixedRate = 5000)
    fun hello() {
        logger.info("hello-{}", counter2++)
        if (counter2 > 16) {
            logger.info("hello-cancel")
            test.cancel(false)
            println("1 end")
        }
        Thread.sleep(10000)
    }

    fun hello2() {
        logger.info("hello2-{}", counter2++)
        Thread.sleep(10000)
//        println("2 end")

//        test.cancel(false)
    }

    override fun configureTasks(taskRegistrar: ScheduledTaskRegistrar) {
        println("halooooooooo")
        taskRegistrar.setTaskScheduler(taskScheduler())
    }

    @Bean
    fun taskScheduler(): TaskScheduler {
//        val taskScheduler = ThreadPoolTaskScheduler()
//        taskScheduler.isRemoveOnCancelPolicy = true
//        return taskScheduler
        return ConcurrentTaskScheduler(Executors.newFixedThreadPool(1), Executors.newScheduledThreadPool(2))  //single threaded by default
    }

    fun printlnInfo() {
        logger.info("scheduler:{}", taskScheduler)
    }


    companion object {

        var counter: Int = 0
        var counter2: Int = 0
    }
}