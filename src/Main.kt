import enums.Status
import model.Task
import model.User
import java.util.*

fun main() {

    val user = User(name = "javax")

    val firstTask = Task(
        title = "Learning Kotlin",
        description = "Study kotlin once in a while",
        status = Status.IN_PROGRESS,
        createdAt = Calendar.getInstance(),
        updatedAt = Calendar.getInstance()
    )

    val secondTask = Task(
        title = "Learning english",
        description = "why am i studying kotlin here?",
        status = Status.IN_PROGRESS,
        createdAt = Calendar.getInstance(),
        updatedAt = Calendar.getInstance()
    )

    val thirdTask = Task(
        title = "Learning design patterns",
        description = "i need to immerse in it",
        status = Status.IN_PROGRESS,
        createdAt = Calendar.getInstance(),
        updatedAt = Calendar.getInstance()
    )

    val fourthTask = Task(
        title = "Trying something here",
        description = "who's miletus?",
        status = Status.CANCELLED,
        createdAt = Calendar.getInstance(),
        updatedAt = Calendar.getInstance()
    )

    val fifthTask = Task(
        title = "Learning Kotlin",
        description = "Study kotlin once in a while to improve my knowledge",
        status = Status.IN_PROGRESS,
        createdAt = Calendar.getInstance(),
        updatedAt = Calendar.getInstance()
    )

    user.addTasks(listOf(firstTask, secondTask, thirdTask))
    user.addTask(fourthTask)

    println(user.getTaskByTitle("Trying something here"))
    user.deleteTaskByTitle("Trying something here")

    user.updateTaskByTitle("Learning Kotlin", fifthTask)
    println(user.getTaskByTitle("Learning Kotlin"))
}