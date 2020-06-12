package com.tainzhi.android.common.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by muqing on 2019/6/12.
 * Email: qfq61@qq.com
 *
 * Description: 格式转换
 */
object FormatUtil {
    private const val hour = 1000 * 60 * 60
    private const val minute = 1000 * 60
    private const val second = 1000
    private const val kbyte = 1024
    private const val mbyte = 1024 * 1024
    private const val gbyte = 1024 * 1024 * 1024

    /**
     * 把毫秒转换成60进制时间, 比如hh:mm:ss, mm:ss
     *
     * @param millisecond 毫秒
     */
    fun formatMediaTime(millisecond: Long): String {
        val h = millisecond.toInt() / hour
        val m = millisecond.toInt() % hour / minute
        val sec = millisecond.toInt() % minute / second
        return if (h > 0) {
            //"hh:mm:ss" "1:36:2"
            String.format("%02d:%02d:%02d", h, m, sec)
        } else {
            String.format("%02d:%02d", m, sec)
        }
    }

    /**
     * 把字节转换成人可读的 5B, 5KB, 5MB, 5GB
     *
     * @param size 字节大小
     * @return 可读字节大小, 单位为B, KB, MB, GB
     */
    fun formatMediaSize(size: Long): String {
        // 5B
        // 5KB
        // 5MB
        // 5GB
        val k = size.toInt() % kbyte
        val m = size.toInt() / mbyte
        val g = size.toInt() / gbyte
        return if (g > 0) {
            g.toString() + "GB"
        } else if (m > 0) {
            m.toString() + "MB"
        } else if (k > 0) {
            k.toString() + "KB"
        } else {
            size.toString() + "B"
        }
    }

    fun formatDate(date: String?): String? {
        if (date == null) {
            return null
        }
        val year = date.substring(0, 4)
        val month = date.substring(4, 6)
        val day = date.substring(6, 8)
        return "$year/$month/$day"
    }

    /**
     * 获取当前系统时间 返回格式"HH:mm:ss"
     *
     * @return
     */
    fun formatSystemTime(): String {
        val format = SimpleDateFormat("HH:mm:ss")
        return format.format(Date())
    }
}