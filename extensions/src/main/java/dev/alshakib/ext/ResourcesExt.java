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
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public final class ResourcesExt {
    /**
     * Check whether the RTL is enabled or not.
     *
     * @param context Context to get resource configurations
     * @return true if RTL is enabled
     */
    public static boolean isRtl(@NonNull Context context) {
        return context.getResources().getConfiguration()
                .getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
    }

    /**
     * Convert Density-independent pixels (DP) to pixels (PX)
     *
     * @param context Context to get resources
     * @param dp DP to convert to pixels
     * @return Converted value
     */
    public static int dpToPx(@NonNull Context context, float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    /**
     * Convert Scale-independent Pixels (SP) to pixels (PX)
     *
     * @param context Context to get resources
     * @param sp SP to convert to pixels
     * @return Converted value
     */
    public static int spToPx(@NonNull Context context, float sp) {
        return (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                        context.getResources().getDisplayMetrics());
    }

    /**
     * Create a bitmap from a drawable.
     *
     * @param drawable Drawable to convert to a bitmap
     * @return A bitmap from the drawable
     */
    public static Bitmap getBitmap(@NonNull Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * Create a bitmap from a drawable.
     *
     * @param context Context to get resources
     * @param drawableId Drawable resource id to get the drawable
     * @return A bitmap from the drawable
     */
    @Nullable
    public static Bitmap getBitmap(@NonNull Context context, @DrawableRes int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (drawable != null) {
            return getBitmap(drawable);
        }
        return null;
    }
}
