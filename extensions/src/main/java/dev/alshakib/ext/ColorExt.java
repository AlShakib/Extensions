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
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import java.util.concurrent.ThreadLocalRandom;

public final class ColorExt {
    private static final String[] COLOR_CODES = {
            "#DB4437",
            "#E91E63",
            "#9C27B0",
            "#673AB7",
            "#3F51B5",
            "#4285F4",
            "#039BE5",
            "#0097A7",
            "#009688",
            "#0F9D58",
            "#689F38",
            "#EF6C00",
            "#FF5722"
    };

    public static String getRandomColorCode() {
        return COLOR_CODES[ThreadLocalRandom.current().nextInt(0, COLOR_CODES.length)];
    }

    @ColorInt
    public static int getRandomColor() {
        return Color.parseColor(COLOR_CODES[ThreadLocalRandom.current().nextInt(0, COLOR_CODES.length)]);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int attr) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { attr });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getPrimaryColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorPrimary });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getPrimaryDarkColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorPrimaryDark });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getPrimaryVariantColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorPrimaryDark });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getOnPrimaryColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorOnPrimary });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getSecondaryColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorSecondary });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getSecondaryVariantColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorSecondaryVariant });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getOnSecondaryColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorOnSecondary });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getAccentColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorAccent });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getBackgroundColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { android.R.attr.colorBackground });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getOnBackgroundColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorOnBackground });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getSurfaceColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorSurface });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getOnSurfaceColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorOnSurface });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getErrorColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorError });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }

    @ColorInt
    public static int getOnErrorColor(@NonNull Context context) {
        TypedArray typedArray = null;
        int color;
        try {
            TypedValue typedValue = new TypedValue();
            typedArray = context
                    .obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorOnError });
            color = typedArray.getColor(0, 0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return color;
    }
}
