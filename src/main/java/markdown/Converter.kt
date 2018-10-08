package markdown

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import java.util.regex.Pattern
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.*


/**
 * @author RanQingTian
 * @date 2018/4/24
 */
@RestController
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = arrayOf("markdown"))
open class Converter {

    @RequestMapping("/deal")
    fun deal(@RequestBody input: String): String {
        println(input)
        println(input)
        var toDeal = input.replace("\\n", "<n>") // replace all \n with <n>
        var patternStr = "<br/?>" //replace <br> and <br/> with \n </*>
        var pattern = Pattern.compile(patternStr)
        var m = pattern.matcher(toDeal)
        toDeal = m.replaceAll("\n")
        toDeal = toDeal.replace("\\n", "<n>")
        patternStr = "(<[^>/]+>)" //remove all like <*>
        pattern = Pattern.compile(patternStr)
        m = pattern.matcher(toDeal)
        toDeal = m.replaceAll("")
        patternStr = "</(p|dd|div|dl|li|ol|pre|ul|h[1-6])>" //replace all defined </*> with \n
        pattern = Pattern.compile(patternStr)
        m = pattern.matcher(toDeal)
        toDeal = m.replaceAll("\n")
        patternStr = "&nbsp;[ ]?" //replace &nbsp; \n with single \n
        pattern = Pattern.compile(patternStr)
        m = pattern.matcher(toDeal)
        toDeal = m.replaceAll("")
        patternStr = "</[^>]+>" //remove all undefined </*>
        pattern = Pattern.compile(patternStr)
        m = pattern.matcher(toDeal)
        toDeal = m.replaceAll("")
        patternStr = "\n\\s*+" //replace continuous \n with single \n
        pattern = Pattern.compile(patternStr)
        m = pattern.matcher(toDeal)
        toDeal = m.replaceAll("\n\n")
        println(toDeal)
        return toDeal
    }

    @RequestMapping("/")
    fun home(): String {
        return "Hello World!"
    }

    @RequestMapping("/test")
    fun test(v1: String?, test: Test): String {
        println(test)
        return "Hello test!"
    }

    class Test(
            val v1: String?,
            val v2: String?,
            val test2: Test2?
    )

    class Test2(
            val v1: String?,
            val v2: String?
    )

}

fun main(vararg args: String) {
    var input = "<p>项目：</p>\n<p style=\"margin-left: 40px;\">1.系统可用性达到99.9%以上</p><p style=\"margin-left: 40px;\">2.故障指标（P1 &lt;= 0, P2 &lt;= 1, P3 &lt;= 4, P4 &lt;= 6）</p><p style=\"margin-left: 40px;\">3.所有功能/bug进行冒烟测试</p><p style=\"margin-left: 40px;\">4.客户提出的90%以上的问题在30min内响应</p><p style=\"margin-left: 40px;\">5.学习实践Mysql分库分表中间件，在合适的时机应用于项目中</p>"
    var input2 = "<p><span style=\"font-size: 1px;\">项目金额 1350万（年度）</span><br></p>"
    var input3 = "a\\nb\n\nc"
    var input4 = "<p><span style=\"color: rgb(122, 122, 122); font-size: 14px;\">提供常用中台能力</span><br></p><p>  <span style=\"color: rgb(103, 150, 230);\">&nbsp; *</span> 期内提供稳定版本</p><p>  <span style=\"color: rgb(103, 150, 230);\">&nbsp; *</span> 拥有完善的使用手册与文档</p><p>  <span style=\"color: rgb(103, 150, 230);\">&nbsp; *</span> 接入公司所有需求对应能力的产品和项目, 且得到好评</p><p>  <span style=\"color: rgb(103, 150, 230);\">&nbsp; *</span> 集成平台</p><p>    <span style=\"color: rgb(103, 150, 230);\">&nbsp; &nbsp; *</span> 减少相同对接的重复开发工作量至少 <span style=\"color: rgb(206, 145, 120);\">`50%`</span> (工时计算)</p><p>    <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; &nbsp;&nbsp;</span>*</span>&nbsp;提供对接库的管理功能, 可以沉淀对外对接库</p><p>    <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; &nbsp;&nbsp;</span>*</span> 至少沉淀 <span style=\"color: rgb(206, 145, 120);\">`2`</span> 个对外对接库</p><p>  <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; </span>*</span> 权限中心</p><p>    <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; &nbsp;&nbsp;</span>*</span> 覆盖主要权限场景, 减少权限部分的开发工作量至少 <span style=\"color: rgb(206, 145, 120);\">`50%`</span> (工时计算)</p><p>    <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; &nbsp;&nbsp;</span>*</span> 加入 Dice addon, 便捷实用</p><p>  <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; </span>*</span> 统一工作台</p><p>    <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; &nbsp;&nbsp;</span>*</span> 提供组合产品, 输出解决方案的能力, 至少 cover 解决方案输出 <span style=\"color: rgb(206, 145, 120);\">`50%`</span> 的功能</p><p>  <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; </span>*</span> 通知中心</p><p>    <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; &nbsp;&nbsp;</span>*</span> 覆盖主要通知相关场景, 减少此部分的后端开发工作量至少 <span style=\"color: rgb(206, 145, 120);\">`80%`</span> (工时计算)</p><p>  <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; </span>*</span> 账号&amp;组织中心</p><p>    <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; &nbsp;&nbsp;</span>*</span> 将账号中心和会员中心剥离, 完全 cover 注册登录认证等功能</p><p>    <span style=\"color: rgb(103, 150, 230);\"><span style=\"color: rgb(103, 150, 230); font-size: 14px;\">&nbsp; &nbsp;&nbsp;</span>*</span> 组织中心覆盖主要场景, 减少此部分工作量至少 <span style=\"color: rgb(206, 145, 120);\">`30%`</span> (工时计算)</p><p>提供常用中台能力</p>"
    var input5 = "<p>产品设计：</p><p>1、BI系统功能迭代，零售、供采场景方案沉淀，推动产品达到L2级别，补充完成相应的文档，如投标文档、官网介绍、案例集、官网案例包装、能力中心沉淀等&nbsp;<br/></p><p>  2、推荐引擎、指标工厂的方案输出（MVP+迭代），推动产品达到L1级别，并完成相应的文档，如方案介绍、功能清单、报价单、投标文档、demo、官网介绍页面等 <br>  3、规划完成推荐引擎、指标工厂等2个产品从2018年4月起半年以上周期的roadmap，并通过产品迭代专项评估 <br></p>"
    val toDeal = input5
//    deal(toDeal)
    val converter = Converter()
//    converter.deal(toDeal)
    println(null as? String)
    listOf(1, 2, 3, 4, 3).forEach {
        if (it > 3) {
            return@forEach
        }
        println(it)
    }
    var test: Long? = 1
    println(listOf(1, 2, 3).minus(2))
    println("12".replaceFirst(",", ""))
//    println(listOf(1,2,3).subtract(listOf(1,2)))
    SpringApplication.run(Converter::class.java, *args)
}