package subtask1

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val weekDays = listOf("воскресенье","понедельник", "вторник", "среда", "четверг", "пятница", "суббота")
        val months = listOf(
            "января",
            "февраля",
            "марта",
            "апреля",
            "мая",
            "июня",
            "июля",
            "августа",
            "сентября",
            "октября",
            "ноября",
            "декабря"
        )
        val dayInt = day.toInt()
        val monthInt = month.toInt()
        val yearInt = year.toInt()
        return when {
            monthInt > 12 -> "Такого дня не существует"
            dayInt > 31 -> "Такого дня не существует"
            (monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11) && dayInt > 30 -> "Такого дня не существует"
            monthInt == 2 && dayInt > 29 ->"Такого дня не существует"
            monthInt == 2 && dayInt > 28 && !isHighYear(yearInt) -> "Такого дня не существует"

            else -> "$dayInt ${months[monthInt - 1]}, ${weekDays[weekday(dayInt, monthInt, yearInt)]}"
        }

    }


   private fun weekday(day: Int, month: Int, year: Int): Int {
        var fYear = year
        var fMonth = month

        if (month < 3) {
            fYear -= 1
            fMonth += 10
        } else fMonth -= 2
        return (day + 31 * fMonth / 12 + fYear + fYear / 4 - fYear / 100 + fYear / 400) % 7
    }

    private fun isHighYear(year: Int): Boolean {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)

    }
}
