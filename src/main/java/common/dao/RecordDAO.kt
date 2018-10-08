package common.dao

import common.model.entity.Record
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options

/**
 * @author myeligi@gmail.com
 * @date 2018/9/18
 */
@Mapper
interface RecordDAO {

    @InsertProvider(type = SQLProvider::class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(record: Record)

}