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

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

public final class ViewExt {
    /**
     * Clear overlay from a ViewGroup
     *
     * @param viewGroup ViewGroup to clear overlay from
     */
    public static void clearOverlay(@NonNull ViewGroup viewGroup) {
        ViewGroupOverlay overlay = viewGroup.getOverlay();
        if (overlay != null) {
            overlay.clear();
        }
    }

    /**
     * Apply black dim overlay to a ViewGroup
     *
     * @param viewGroup ViewGroup to apply black dim overlay
     * @param dim Dim value. (0.0 - 1.0)
     */
    public static void applyDim(@NonNull ViewGroup viewGroup,
                                @FloatRange(from = 0.0F, to = 1.0F) float dim) {
        Drawable drawable = new ColorDrawable(Color.BLACK);
        drawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        drawable.setAlpha((int) (255.0F * dim));

        ViewGroupOverlay overlay = viewGroup.getOverlay();
        if (overlay != null) {
            overlay.clear();
            overlay.add(drawable);
        }
    }

    /**
     * Clear black dim overlay from a ViewGroup
     *
     * @param viewGroup ViewGroup to clear black dim overlay from
     */
    public static void clearDim(@NonNull ViewGroup viewGroup) {
        clearOverlay(viewGroup);
    }
}
