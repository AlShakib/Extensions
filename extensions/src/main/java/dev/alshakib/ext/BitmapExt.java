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

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collections;
import java.util.List;

public final class BitmapExt {
    @Nullable
    public static Bitmap getBitmapCollage(@NonNull List<Bitmap> bitmapList, int width, int height) {
        try {
            bitmapList.removeAll(Collections.singletonList(null));
            if (bitmapList.isEmpty()) {
                return null;
            }
            if (bitmapList.size() == 1) {
                return bitmapList.get(0);
            }
            Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

            Canvas canvas = new Canvas(result);

            if (bitmapList.size() == 2) {
                Rect leftRect = new Rect(0, 0, width / 2, height);
                canvas.drawBitmap(scaleToCenterCrop(bitmapList.get(0), width / 2f, height),
                        null, leftRect, null);
                Rect rightRect = new Rect(width / 2, 0, width, height);
                canvas.drawBitmap(scaleToCenterCrop(bitmapList.get(1), width / 2f, height),
                        null, rightRect, null);
                return result;
            }
            if (bitmapList.size() == 3) {
                Rect leftRect = new Rect(0, 0, width / 2, height);
                canvas.drawBitmap(scaleToCenterCrop(bitmapList.get(0), width / 2F, height),
                        null, leftRect, null);

                Rect topRight = new Rect(width / 2, 0, width, height / 2);
                canvas.drawBitmap(scaleToCenterCrop(bitmapList.get(1), width / 2F, height / 2F),
                        null, topRight, null);

                Rect bottomRight = new Rect(width / 2, height / 2, width, height);
                canvas.drawBitmap(scaleToCenterCrop(bitmapList.get(2), width / 2F, height / 2F),
                        null, bottomRight, null);
                return result;
            }
            if (bitmapList.size() > 3) {
                Rect topLeft = new Rect(0, 0, width / 2, height / 2);
                canvas.drawBitmap(scaleToCenterCrop(bitmapList.get(0), width / 2F, height / 2F),
                        null, topLeft, null);

                Rect topRight = new Rect(width / 2, 0, width, height / 2);
                canvas.drawBitmap(scaleToCenterCrop(bitmapList.get(1), width / 2F, height / 2F),
                        null, topRight, null);

                Rect bottomLeft = new Rect(0, height / 2, width / 2, height);
                canvas.drawBitmap(scaleToCenterCrop(bitmapList.get(2), width / 2F, height / 2F),
                        null,bottomLeft, null);

                Rect bottomRight = new Rect(width / 2, height / 2, width, height);
                canvas.drawBitmap(scaleToCenterCrop(bitmapList.get(3), width / 2F, height / 2F),
                        null, bottomRight, null);
                return result;
            }
        } catch (Exception ignored) { }
        return null;
    }

    public static Bitmap scaleToCenterCrop(Bitmap source, float width, float height) {
        float sourceWidth = source.getWidth();
        float sourceHeight = source.getHeight();

        float xScale = width / sourceWidth;
        float yScale = height / sourceHeight;
        float scale = Math.max(xScale, yScale);

        float scaledWidth = scale * sourceWidth;
        float scaledHeight = scale * sourceHeight;

        float left = (width - scaledWidth) / 2f;
        float top = (height - scaledHeight) / 2f;

        RectF targetRect = new RectF(left, top, left + scaledWidth, top + scaledHeight);

        Bitmap dest = Bitmap.createBitmap((int) width, (int) height, source.getConfig());
        Canvas canvas = new Canvas(dest);
        canvas.drawBitmap(source, null, targetRect, null);

        return dest;
    }
}
