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

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import static java.util.Objects.requireNonNull;

public final class JavaExt {
    public static boolean isNull(@Nullable Object object) {
        return object == null;
    }

    public static boolean isNonNull(@Nullable Object object) {
        return !isNull(object);
    }

    public static <T> T requireNonNullElse(T obj, T defaultObj) {
        return (obj != null) ? obj : requireNonNull(defaultObj, "defaultObj");
    }

    public static boolean isValidFromIndexSize(int fromIndex, int size, int length) {
        return (length | fromIndex | size) >= 0 && size <= length - fromIndex;
    }

    public static boolean isValidIndex(int index, int length) {
        return index >= 0 && index < length;
    }

    public static boolean isValidFromToIndex(int fromIndex, int toIndex, int length) {
        return fromIndex >= 0 && fromIndex <= toIndex && toIndex <= length;
    }

    public static <T extends Parcelable> T deepClone(T p) {
        Parcel parcel = null;
        try {
            parcel = Parcel.obtain();
            parcel.writeParcelable(p, 0);
            parcel.setDataPosition(0);
            return parcel.readParcelable(p.getClass().getClassLoader());
        } finally {
            if (JavaExt.isNonNull(parcel)) {
                parcel.recycle();
            }
        }
    }
}
