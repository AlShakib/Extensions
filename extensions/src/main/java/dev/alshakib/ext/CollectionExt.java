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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class CollectionExt {
    public static <T> boolean isValidIndex(@NonNull Collection<? super T> collection, int index) {
        return JavaExt.isValidIndex(index, collection.size());
    }

    public static <T> boolean isValidIndexInsert(@NonNull Collection<? super T> collection, int index) {
        return index >= 0 && index <= collection.size();
    }

    public static <T> boolean isValidFromIndexSize(@NonNull Collection<? super T> collection, int fromIndex, int size) {
        return JavaExt.isValidFromIndexSize(fromIndex, size, collection.size());
    }

    public static <T> boolean isValidFromToIndex(@NonNull Collection<? super T> collection, int fromIndex, int toIndex) {
        return JavaExt.isValidFromToIndex(fromIndex, toIndex, collection.size());
    }

    public static <T> boolean isEmpty(@Nullable Collection<? super T> collection) {
        if (JavaExt.isNonNull(collection)) {
            collection.removeAll(Collections.singletonList(null));
            return collection.isEmpty();
        }
        return true;
    }

    public static <T> boolean isNonEmpty(@Nullable Collection<? super T> collection) {
        return !isEmpty(collection);
    }

    public static <T> void removeNulls(@NonNull List<? super T> list) {
        list.removeAll(Collections.singletonList(null));
    }
}
