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

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;

import com.google.android.material.appbar.MaterialToolbar;

public final class NavigationExt {
    public static void setupActionBar(@NonNull Activity activity, @NonNull NavController navController,
                                      @NonNull MaterialToolbar materialToolbar) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
        appCompatActivity.setSupportActionBar(materialToolbar);
        if (appCompatActivity.getSupportActionBar() != null &&
                navController.getCurrentDestination() != null) {
            appCompatActivity.getSupportActionBar()
                    .setTitle(navController.getCurrentDestination().getLabel());
        }
    }

    public static void safeNavigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                    @NonNull NavDirections navDirections) {
        if (navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getId() == currentDestinationId) {
            navController.navigate(navDirections);
        }
    }

    public static void safeNavigateUp(@NonNull NavController navController,
                                      @IdRes int currentDestinationId) {
        if (navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getId() == currentDestinationId) {
            navController.navigateUp();
        }
    }
}
