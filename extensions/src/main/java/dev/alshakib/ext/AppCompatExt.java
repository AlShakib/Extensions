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

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public final class AppCompatExt {
    public static void showInputMethod(@NonNull Activity activity) {
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    public static void hideInputMethod(@NonNull Activity activity) {
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager
                    .hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void setMaterialToolbar(@NonNull Activity activity, @NonNull MaterialToolbar materialToolbar) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
        appCompatActivity.setSupportActionBar(materialToolbar);
    }

    public static void setActionBarTitle(@NonNull Activity activity, @NonNull String title) {
        ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    public static void enableUpButton(@NonNull Activity activity) {
        ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static void disableUpButton(@NonNull Activity activity) {
        ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    public static void applyDim(@NonNull ViewGroup parent, @FloatRange(from = 0.0F, to = 1.0F) float dim){
        Drawable drawable = new ColorDrawable(Color.BLACK);
        drawable.setBounds(0, 0, parent.getWidth(), parent.getHeight());
        drawable.setAlpha((int) (255.0F * dim));

        ViewGroupOverlay overlay = parent.getOverlay();
        if (overlay != null) {
            overlay.clear();
            overlay.add(drawable);
        }
    }

    public static void clearDim(@NonNull ViewGroup parent) {
        ViewGroupOverlay overlay = parent.getOverlay();
        if (overlay != null) {
            overlay.clear();
        }
    }

    @SuppressWarnings("deprecation")
    public static void hideSystemUi(@NonNull Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                WindowManager.LayoutParams attr = window.getAttributes();
                attr.layoutInDisplayCutoutMode = WindowManager
                        .LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
                window.setAttributes(attr);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.setDecorFitsSystemWindows(false);
                WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController != null) {
                    insetsController.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
                    insetsController.hide(WindowInsets.Type.systemBars());
                    insetsController.hide(WindowInsets.Type.displayCutout());
                }
            } else {
                View decorView = window.getDecorView();
                if (decorView != null) {
                    int newUiOptions = decorView.getSystemUiVisibility();
                    newUiOptions |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                    newUiOptions |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    newUiOptions |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
                    newUiOptions |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                    newUiOptions |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                    newUiOptions |= View.SYSTEM_UI_FLAG_FULLSCREEN;
                    decorView.setSystemUiVisibility(newUiOptions);
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void showSystemUI(@NonNull Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                WindowManager.LayoutParams attr = window.getAttributes();
                attr.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT;
                window.setAttributes(attr);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.setDecorFitsSystemWindows(true);
                WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController != null) {
                    insetsController.show(WindowInsets.Type.systemBars());
                    insetsController.show(WindowInsets.Type.displayCutout());
                }
            } else {
                View decorView = window.getDecorView();
                if (decorView != null) {
                    int newUiOptions = decorView.getSystemUiVisibility();
                    newUiOptions &= ~View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                    newUiOptions &= ~View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    newUiOptions &= ~View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
                    newUiOptions &= ~View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                    newUiOptions &= ~View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                    newUiOptions &= ~View.SYSTEM_UI_FLAG_FULLSCREEN;
                    decorView.setSystemUiVisibility(newUiOptions);
                }
            }
        }
    }
}
