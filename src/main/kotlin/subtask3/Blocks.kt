package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when (blockB) {
            Int::class -> intSum(blockA)
            String::class -> stringConcatenation(blockA)
            LocalDate::class ->latestDate(blockA).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            else -> "Unknow"
        }

    }

    fun stringConcatenation(blockA: Array<*>): String {
        var result = ""
        blockA.forEach { if (it is String) result += it }
        return result
    }

    fun intSum(blockA: Array<*>): Int {
        var result = 0
        blockA.forEach { if (it is Int) result += it }
        return result
    }

    fun latestDate(blockA: Array<*>): LocalDate {
        var result: LocalDate = LocalDate.parse("0001-01-01")
        blockA.forEach {
            if (it is LocalDate) {
                if(result < it) result = it
            }
        }
        return result
    }
}
