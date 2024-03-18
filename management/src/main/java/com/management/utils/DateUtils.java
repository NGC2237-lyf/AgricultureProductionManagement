package com.management.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author TokisakiKurumi
 * @className DateUtils
 * @date 2024/3/8
 * @description
 **/
public class DateUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date toFormatDate(Date date) {
        return DateUtil.parseDate(DateUtil.format(date,DATE_FORMAT));
    }
}
