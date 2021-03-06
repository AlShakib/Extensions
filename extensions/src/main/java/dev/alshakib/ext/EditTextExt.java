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

import android.text.Editable;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class EditTextExt {
    public final static String EMPTY_STRING = "";

    /**
     * Get the text as nullable string from an EditText.
     *
     * @param editText Get the text from this EditText
     * @return The text displaying on the EditText
     */
    @Nullable
    public static String getString(@NonNull EditText editText) {
        Editable editable = editText.getText();
        if (editable != null) {
            return editable.toString();
        }
        return null;
    }

    /**
     * Get the text as non nullable string from an EditText.
     *
     * @param editText Get the text from this EditText
     * @return The text displaying on the EditText
     */
    @NonNull
    public static String requireString(@NonNull EditText editText) {
        Editable editable = editText.getText();
        if (editable != null) {
            return editable.toString();
        }
        return EMPTY_STRING;
    }

    /**
     * Check whether an EditText is empty or not.
     *
     * @param editText Check this EditText is empty or not
     * @return true if the EditText is empty
     */
    public static boolean isEmpty(@NonNull EditText editText) {
        Editable editable = editText.getText();
        return editable == null || editable.toString().isEmpty();
    }
}
