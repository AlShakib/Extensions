/*
 * MIT License
 *
 * Copyright (c) 2021 Al Shakib (shakib@alshakib.dev)
 *
 * This file is part of Extensions
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.alshakib.ext;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Locale;

public final class TimeExt {
    public final static int PLURAL_RES_SECONDS = 1;
    public final static int PLURAL_RES_MINUTES = 2;
    public final static int PLURAL_RES_HOURS = 3;
    public final static int PLURAL_RES_DAYS = 4;
    public final static int PLURAL_RES_WEEKS = 5;

    @NonNull
    public static String getTime(long milliseconds) {
        long minutes = (milliseconds / 1000) / 60;
        long seconds = (milliseconds / 1000) % 60;
        if (minutes < 60) {
            return String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        } else {
            long hours = minutes / 60;
            minutes = minutes % 60;
            return String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
        }
    }

    @NonNull
    public static String getReadableTime(@NonNull Context context, long milliseconds) {
        int seconds = (int) milliseconds / 1000;
        if (seconds < 60) {
            return context.getResources()
                    .getQuantityString(R.plurals.time_in_seconds, seconds, seconds, seconds, seconds, seconds, seconds);
        }
        int minutes = (int) (milliseconds / 1000) / 60;
        if (minutes < 60) {
            return context.getResources()
                    .getQuantityString(R.plurals.time_in_minutes, minutes, minutes, minutes, minutes, minutes, minutes);
        }
        int hours = minutes / 60;
        if (hours < 24){
            return context.getResources()
                    .getQuantityString(R.plurals.time_in_hours, hours, hours, hours, hours, hours, hours);
        }
        int days = hours / 24;
        if (days < 7) {
            return context.getResources()
                    .getQuantityString(R.plurals.time_in_days, days, days, days, days, days, days);
        }
        int weeks = days / 7;
        return context.getResources()
                .getQuantityString(R.plurals.time_in_weeks, weeks, weeks, weeks, weeks, weeks, weeks);
    }

    @NonNull
    public static String getReadableTime(@NonNull Context context, @NonNull HashMap<Integer, Integer> stringResMap, long milliseconds) {
        int seconds = (int) milliseconds / 1000;
        if (seconds < 60) {
            Integer res = stringResMap.get(PLURAL_RES_SECONDS);
            if (res == null) {
                res = R.plurals.time_in_seconds;
            }
            return context.getResources()
                    .getQuantityString(res, seconds, seconds, seconds, seconds, seconds, seconds);
        }
        int minutes = (int) (milliseconds / 1000) / 60;
        if (minutes < 60) {
            Integer res = stringResMap.get(PLURAL_RES_MINUTES);
            if (res == null) {
                res = R.plurals.time_in_minutes;
            }
            return context.getResources()
                    .getQuantityString(res, minutes, minutes, minutes, minutes, minutes, minutes);
        }
        int hours = minutes / 60;
        if (hours < 24){
            Integer res = stringResMap.get(PLURAL_RES_HOURS);
            if (res == null) {
                res = R.plurals.time_in_hours;
            }
            return context.getResources()
                    .getQuantityString(res, hours, hours, hours, hours, hours, hours);
        }
        int days = hours / 24;
        if (days < 7) {
            Integer res = stringResMap.get(PLURAL_RES_DAYS);
            if (res == null) {
                res = R.plurals.time_in_days;
            }
            return context.getResources()
                    .getQuantityString(res, days, days, days, days, days, days);
        }
        int weeks = days / 7;
        Integer res = stringResMap.get(PLURAL_RES_WEEKS);
        if (res == null) {
            res = R.plurals.time_in_weeks;
        }
        return context.getResources()
                .getQuantityString(res, weeks, weeks, weeks, weeks, weeks, weeks);
    }
}
