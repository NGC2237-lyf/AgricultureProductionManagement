package com.management.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author TokisakiKurumi
 * @className PinYinUtils
 * @date 2024/3/12
 * @description
 **/
public class PinYinUtils {

    public static String toChinesePinYin(String chinese) {
        String result = "";
        char[] chars = chinese.trim().toCharArray();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String regex = "[\\u4E00-\\u9FA5]+";
        try {
            for (int i = 0; i < chars.length; i++) {
                if (String.valueOf(chars[i]).matches(regex)) {
                    result += PinyinHelper.toHanyuPinyinStringArray(chars[i], format)[0];
                } else {
                    result += chars[i];
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return result;
    }
}
