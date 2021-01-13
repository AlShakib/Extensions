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
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import java.util.regex.Pattern;

public final class StringExt {
    public final static String EMPTY_STRING = "";

    public static boolean isValidEmail(final String email) {
        if (email == null) {
            return false;
        }
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public static boolean isValidUrl(final String url) {
        if (url == null) {
            return false;
        }
        return (!TextUtils.isEmpty(url) && Patterns.WEB_URL.matcher(url).matches());
    }

    public static boolean isValidUrl(final Uri uri) {
        if (uri == null) {
            return false;
        }
        return isValidUrl(uri.toString());
    }

    public static Uri toUri(String path) {
        if (path == null) {
            return Uri.EMPTY;
        }
        return Uri.parse(path);
    }

    public static String leftTrim(String s) {
        return Pattern.compile("^\\s+").matcher(s).replaceAll(EMPTY_STRING);
    }

    public static String rightTrim(String s) {
        return Pattern.compile("\\s+$").matcher(s).replaceAll(EMPTY_STRING);
    }

    public static String getString(@NonNull Context context, @StringRes int res) {
        return context.getResources().getString(res);
    }

    @NonNull
    public static String requireString(@NonNull Context context, @StringRes int res) {
        String s = getString(context, res);
        if (s != null) {
            return s;
        }
        return EMPTY_STRING;
    }

    public static String getString(@NonNull Context context, @StringRes int res, @NonNull Object... args) {
        return context.getResources().getString(res, args);
    }

    @NonNull
    public static String requireString(@NonNull Context context, @StringRes int res, @NonNull Object... args) {
        String s = getString(context, res, args);
        if (s != null) {
            return s;
        }
        return EMPTY_STRING;
    }

    @NonNull
    public static String toAlphaNumeric(@NonNull String s) {
        return s.replaceAll("[^\\p{L}\\p{Nl}\\p{Nd}]", EMPTY_STRING);
    }

    @NonNull
    public static String joinWithSeparator(@NonNull String first, @NonNull String second) {
        return first + "•" + second;
    }

    @NonNull
    public static String joinWithSeparator(@NonNull String first, @NonNull String second, @NonNull String... others) {
        String s = joinWithSeparator(first, second);
        for (String arg : others) {
            s += joinWithSeparator(s, arg);
        }
        return s;
    }
}
