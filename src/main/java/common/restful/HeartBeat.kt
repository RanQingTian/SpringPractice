package common.restful

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author myeligi@gmail.com
 * @date 2018/9/17
 */
@RestController()
@RequestMapping("/api")
class HeartBeat {
    private var beatCount = 0

    @GetMapping("/heartbeat")
    fun beat(): Int {
        return beatCount
    }

    @Scheduled(cron = "0 * * * * ?")
    private fun increaseByMinute() {
        beatCount++
    }
}