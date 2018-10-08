import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * @author myeligi@gmail.com
 * @date 2018/9/17
 */

@SpringBootApplication(scanBasePackages = ["common"])
@EnableScheduling
@EnableAsync
@EnableTransactionManagement
open class Application() {

}

fun main(vararg args: String) {
    val app = SpringApplication(Application::class.java)
    app.run(*args)
}
