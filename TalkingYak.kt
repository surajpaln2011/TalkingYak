data class Position(
    val x: Int,
    val y: Int,
    val d: Char
)

fun getPosition(p: Position, mov: Char): Position {
    var x = p.x
    var y = p.y
    var d = p.d
    when (d) {
        'N' ->
            when (mov) {
                'L' -> d = 'W'
                'R' -> d = 'E'
                'M' -> y += 1
            }
        'E' ->
            when (mov) {
                'L' -> d = 'N'
                'R' -> d = 'S'
                'M' -> x += 1
            }
        'W' ->
            when (mov) {
                'L' -> d = 'S'
                'R' -> d = 'N'
                'M' -> x -= 1
            }
        'S' ->
            when (mov) {
                'L' -> d = 'E'
                'R' -> d = 'W'
                'M' -> y -= 1
            }
    }
    return Position(x, y, d)
}

fun main() {
    val (xmax, ymax) = readLine()!!.split(' ').map { it.toInt() }
    val (x, y, d) = readLine()!!.split(' ')
    val movement = readLine()!!

    var finalPosition = Position(x.toInt(), y.toInt(), d[0])

    movement.forEach { it ->
        finalPosition = getPosition(finalPosition, it)
        if (finalPosition.x < 0 || finalPosition.x > xmax || finalPosition.y < 0 || finalPosition.y > ymax) {
            println("No Space, Wrong input at ${finalPosition.x}, ${finalPosition.y}")
            return
        }
    }
    println("${finalPosition.x} ${finalPosition.y} ${finalPosition.d}")
}
