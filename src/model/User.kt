package model

class User(
    private var name: String
) {
    private val taskList = mutableListOf<Task>()

    fun getName(): String = name
    fun getTaskList(): List<Task> = taskList

    fun addTask(task: Task): Boolean {
        if (taskList.any { it.getTitle() == task.getTitle() }) {
            println("Task '${task.getTitle()}' already exists and cannot be added again.")
            return false
        }
        taskList.add(task)
        println("Task '${task.getTitle()}' added successfully.")
        return true
    }

    fun addTasks(tasks: List<Task>) {
        val addedTasks = mutableListOf<String>()
        val skippedTasks = mutableListOf<String>()

        for (task in tasks) {
            if (addTask(task)) {
                addedTasks.add(task.getTitle())
            } else {
                skippedTasks.add(task.getTitle())
            }
        }

        if (addedTasks.isNotEmpty()) {
            println("Tasks added: ${addedTasks.joinToString(", ")}")
        }
        if (skippedTasks.isNotEmpty()) {
            println("Tasks skipped (already exist): ${skippedTasks.joinToString(", ")}")
        }
    }

    fun getTaskByTitle(title: String): Task? {
        return taskList.find { it.getTitle() == title }
    }

    fun deleteTaskByTitle(title: String): Boolean {
        val task = getTaskByTitle(title)
        return if (task != null) {
            taskList.remove(task)
            println("Task '$title' deleted.")
            true
        } else {
            println("Task '$title' not found.")
            false
        }
    }

    fun updateTaskByTitle(title: String, newTask: Task): Boolean {
        val task = getTaskByTitle(title)
        return if (task != null) {
            taskList[taskList.indexOf(task)] = newTask
            println("Task '$title' updated.")
            true
        } else {
            println("Task '$title' not found.")
            false
        }
    }
}