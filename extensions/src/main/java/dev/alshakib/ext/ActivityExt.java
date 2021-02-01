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
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;

public final class ActivityExt {
    /**
     * Show soft input area to the user.
     *
     * @param activity The currently focused activity, which would like to receive
     * soft keyboard input.
     */
    public static void showSoftInput(@NonNull Activity activity) {
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

    /**
     * Hide soft input area from the window.
     *
     * @param activity The currently focused activity.
     */
    public static void hideSoftInput(@NonNull Activity activity) {
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

    /**
     * Set a {@link android.widget.Toolbar Toolbar} to act as the
     * {@link androidx.appcompat.app.ActionBar} for this Activity window.
     *
     * @param activity Activity to set a action bar
     * @param toolbar Toolbar to set as the Activity's action bar, or {@code null} to clear it
     */
    public static void setActionBar(@NonNull Activity activity, @Nullable Toolbar toolbar) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
        appCompatActivity.setSupportActionBar(toolbar);
    }

    /**
     * Set a {@link android.widget.Toolbar Toolbar} to act as the
     * {@link androidx.appcompat.app.ActionBar} for this Activity window and
     * set action bar title from current destination label.
     *
     * @param activity Activity to set a action bar
     * @param toolbar Toolbar to set as the Activity's action bar
     * @param navController NavController to get the label from current destination
     */
    public static void setActionBar(@NonNull Activity activity, @NonNull Toolbar toolbar,
                                    @NonNull NavController navController) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
        appCompatActivity.setSupportActionBar(toolbar);
        ActionBar actionBar = appCompatActivity.getSupportActionBar();
        NavDestination currentDestination = navController.getCurrentDestination();
        if (actionBar != null && currentDestination != null) {
            actionBar.setTitle(currentDestination.getLabel());
        }
    }

    /**
     * Set the action bar's title.
     *
     * @param activity Activity where the action bar is set
     * @param title Title to set
     */
    public static void setActionBarTitle(@NonNull Activity activity, String title) {
        ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    /**
     * Set whether home should be displayed as an "up" affordance.
     * Set this to true if selecting "home" returns up by a single level in your UI
     * rather than back to the top level or front page.
     *
     * @param activity Activity where the action bar is set
     * @param enable true to show the user that selecting home will return one
     *                level up rather than to the top level of the app.
     */
    public static void setHomeAsUpButton(@NonNull Activity activity, boolean enable) {
        if (enable) {
            enableUpButton(activity);
        } else {
            disableUpButton(activity);
        }
    }

    /**
     * Show the up button on the action bar
     *
     * @param activity Activity where the action bar is set
     */
    public static void enableUpButton(@NonNull Activity activity) {
        ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Hide the up button from the action bar
     *
     * @param activity Activity where the action bar is set
     */
    public static void disableUpButton(@NonNull Activity activity) {
        ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    /**
     * Hide navigation bar and status bar from the window and
     * show the activity as full screen.
     *
     * @param activity This activity will show as full screen
     */
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

    /**
     * Show navigation bar and status bar on the window and
     * restore the activity from full screen.
     *
     * @param activity This activity will restore from full screen
     */
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
