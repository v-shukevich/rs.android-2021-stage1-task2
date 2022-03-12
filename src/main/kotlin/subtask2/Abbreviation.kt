package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var result = ""
        a.forEach {
            if (b.contains(it,true)){
                result+=it.toUpperCase()
            }
        }
        return if (result.contains(b)) "YES"
        else "NO"
    }
}
