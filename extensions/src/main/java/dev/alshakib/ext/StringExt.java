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

    /**
     * Check whether the email address is valid or not.
     *
     * @param email Email address to check
     * @return true if the email address is valid
     */
    public static boolean isValidEmail(final String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Check whether the web URL is valid or not.
     *
     * @param url Web URL to check
     * @return true if the web URL is valid
     */
    public static boolean isValidWebUrl(final String url) {
        return !TextUtils.isEmpty(url) && Patterns.WEB_URL.matcher(url).matches();
    }

    /**
     * Check whether the web URL is valid or not.
     *
     * @param uri Web URL to check
     * @return true if the web URL is valid
     */
    public static boolean isValidWebUrl(final Uri uri) {
        if (uri == null) {
            return false;
        }
        return isValidWebUrl(uri.toString());
    }

    /**
     * Convert string to URI
     *
     * @param s String to convert to URI
     * @return A URI from string
     */
    @NonNull
    public static Uri toUri(final String s) {
        return TextUtils.isEmpty(s) ? Uri.EMPTY : Uri.parse(s);
    }

    /**
     * Convert URI to string
     * @param uri URI to convert to string
     * @return A string values
     */
    @NonNull
    public static String toString(final Uri uri) {
        return uri != null ? uri.toString() : EMPTY_STRING;
    }

    /**
     * Trim spaces on the left of a string.
     *
     * @param s String to trim
     * @return The final string
     */
    @NonNull
    public static String leftTrim(@NonNull String s) {
        return Pattern.compile("^\\s+").matcher(s).replaceAll(EMPTY_STRING);
    }

    /**
     * Trim spaces on the right of a string.
     *
     * @param s String to trim
     * @return The final string
     */
    @NonNull
    public static String rightTrim(@NonNull String s) {
        return Pattern.compile("\\s+$").matcher(s).replaceAll(EMPTY_STRING);
    }

    /**
     * Get a nullable string from a string resource id.
     *
     * @param context Context to get resource
     * @param res String resource id
     * @return A string value
     */
    public static String getString(@NonNull Context context, @StringRes int res) {
        return context.getResources().getString(res);
    }

    /**
     * Get a non nullable string from a string resource id.
     *
     * @param context Context to get resource
     * @param res String resource id
     * @return A non nullable string value
     */
    @NonNull
    public static String requireString(@NonNull Context context, @StringRes int res) {
        String s = getString(context, res);
        if (s != null) {
            return s;
        }
        return EMPTY_STRING;
    }

    /**
     * Get a nullable string from string resource id with arguments.
     *
     * @param context Context to get resources
     * @param res String resource id
     * @param args Arguments to pass
     * @return A string value
     */
    public static String getString(@NonNull Context context, @StringRes int res, @NonNull Object... args) {
        return context.getResources().getString(res, args);
    }

    /**
     * Get a non nullable string from a string resource id with arguments.
     *
     * @param context Context to get resources
     * @param res String resource id
     * @param args Arguments to pass
     * @return A string value
     */
    @NonNull
    public static String requireString(@NonNull Context context, @StringRes int res, @NonNull Object... args) {
        String s = getString(context, res, args);
        if (s != null) {
            return s;
        }
        return EMPTY_STRING;
    }

    /**
     * Remove non alphanumeric characters from a string.
     *
     * @param s String to process
     * @return An alphanumeric string value
     */
    @NonNull
    public static String getAlphaNumeric(@NonNull String s) {
        return s.replaceAll("[^\\p{L}\\p{Nl}\\p{Nd}]", EMPTY_STRING);
    }

    /**
     * Join two strings with a interpunct.
     *
     * @param first First string
     * @param second Second string
     * @return Final string
     */
    @NonNull
    public static String joinWithInterpunct(@NonNull String first, @NonNull String second) {
        return first + " • " + second;
    }

    /**
     * Join two or more strings with interpunct.
     *
     * @param first First string
     * @param second Second string
     * @param others A string array to join each value one after another
     * @return Final string
     */
    @NonNull
    public static String joinWithInterpunct(@NonNull String first, @NonNull String second, @NonNull String... others) {
        String s = joinWithInterpunct(first, second);
        for (String arg : others) {
            s += joinWithInterpunct(s, arg);
        }
        return s;
    }
}
