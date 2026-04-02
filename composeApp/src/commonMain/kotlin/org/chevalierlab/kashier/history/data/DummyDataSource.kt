package org.chevalierlab.kashier.history.data

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.todayIn
import org.chevalierlab.kashier.history.domain.TransactionHistory
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

object DummyDataSource {
    @OptIn(ExperimentalTime::class)
    private val today = Clock.System.todayIn(TimeZone.currentSystemDefault())

    @OptIn(ExperimentalTime::class)
    val histories = listOf(
        TransactionHistory(250000000.0, 10, today.toString()),
        TransactionHistory(185000000.0, 7, today.minus(1, DateTimeUnit.DAY).toString()),
        TransactionHistory(95500000.0, 4, today.minus(3, DateTimeUnit.DAY).toString()),
        TransactionHistory(120000000.0, 6, today.minus(10, DateTimeUnit.DAY).toString()),
        TransactionHistory(300000000.0, 12, today.minus(18, DateTimeUnit.DAY).toString()),
        TransactionHistory(225000000.0, 8, today.minus(40, DateTimeUnit.DAY).toString()),
        TransactionHistory(175000000.0, 5, today.minus(75, DateTimeUnit.DAY).toString())
    )

    @OptIn(ExperimentalTime::class)
    fun getGroupedHistories(): Map<String, List<TransactionHistory>> {
        val startOfWeek = today.minus(today.daysFromStartOfWeek(), DateTimeUnit.DAY)
        val startOfMonth = today.minus(today.day - 1, DateTimeUnit.DAY)

        return histories
            .sortedByDescending { LocalDate.parse(it.date) }
            .groupBy { history ->
                val transactionDate = LocalDate.parse(history.date)
                when {
                    transactionDate == today -> "Hari ini"
                    transactionDate >= startOfWeek -> "Minggu ini"
                    transactionDate >= startOfMonth -> "Bulan ini"
                    else -> transactionDate.toMonthYearLabel()
                }
            }
    }

    private fun LocalDate.toMonthYearLabel(): String {
        val monthName = when (month) {
            kotlinx.datetime.Month.JANUARY -> "Januari"
            kotlinx.datetime.Month.FEBRUARY -> "Februari"
            kotlinx.datetime.Month.MARCH -> "Maret"
            kotlinx.datetime.Month.APRIL -> "April"
            kotlinx.datetime.Month.MAY -> "Mei"
            kotlinx.datetime.Month.JUNE -> "Juni"
            kotlinx.datetime.Month.JULY -> "Juli"
            kotlinx.datetime.Month.AUGUST -> "Agustus"
            kotlinx.datetime.Month.SEPTEMBER -> "September"
            kotlinx.datetime.Month.OCTOBER -> "Oktober"
            kotlinx.datetime.Month.NOVEMBER -> "November"
            kotlinx.datetime.Month.DECEMBER -> "Desember"
        }
        return "$monthName $year"
    }

    private fun LocalDate.daysFromStartOfWeek(): Int {
        return when (dayOfWeek) {
            DayOfWeek.MONDAY -> 0
            DayOfWeek.TUESDAY -> 1
            DayOfWeek.WEDNESDAY -> 2
            DayOfWeek.THURSDAY -> 3
            DayOfWeek.FRIDAY -> 4
            DayOfWeek.SATURDAY -> 5
            DayOfWeek.SUNDAY -> 6
        }
    }
}
