package model

import enums.Status
import java.text.SimpleDateFormat
import java.util.Calendar

class Task(
    private var title: String,
    private var description: String,
    private var status: Status,
    private var createdAt: Calendar,
    private var updatedAt: Calendar
) {
    fun getTitle(): String = title
    fun getDescription(): String = description
    fun getStatus(): Status = status
    fun getCreatedAt(): String = formatDate(createdAt)
    fun getUpdatedAt(): String = formatDate(updatedAt)

    private fun formatDate(calendar: Calendar): String {
        val sdf = SimpleDateFormat("MM/dd/yyyy")
        return sdf.format(calendar.time)
    }

    override fun toString(): String {
        return "Task(title='$title', description='$description', status=$status, createdAt=${getCreatedAt()}, updatedAt=${getUpdatedAt()})"
    }


}