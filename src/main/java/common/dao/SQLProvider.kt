package common.dao

import org.apache.ibatis.jdbc.SQL

/**
 * @author myeligi@gmail.com
 * @date 2018/9/18
 */
class SQLProvider {

    fun insert(): String {
        return SQL()
                .INSERT_INTO("record")
                .INTO_COLUMNS("content")
                .INTO_VALUES("hello").toString()
    }
}