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
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;

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

    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                    @IdRes int resId) {
        if (navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getId() == currentDestinationId) {
            navController.navigate(resId);
        }
    }

    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                    @IdRes int resId, @Nullable Bundle args) {
        if (navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getId() == currentDestinationId) {
            navController.navigate(resId, args);
        }
    }

    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                    @IdRes int resId, @Nullable Bundle args, @Nullable NavOptions navOptions) {
        if (navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getId() == currentDestinationId) {
            navController.navigate(resId, args, navOptions);
        }
    }

    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                    @IdRes int resId, @Nullable Bundle args, @Nullable NavOptions navOptions,
                                    @Nullable Navigator.Extras navigatorExtras) {
        if (navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getId() == currentDestinationId) {
            navController.navigate(resId, args, navOptions, navigatorExtras);
        }
    }

    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                    @NonNull NavDirections directions) {
        if (navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getId() == currentDestinationId) {
            navController.navigate(directions);
        }
    }

    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                @NonNull NavDirections directions, @Nullable NavOptions navOptions) {
        if (navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getId() == currentDestinationId) {
            navController.navigate(directions, navOptions);
        }
    }

    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                @NonNull NavDirections directions, @NonNull Navigator.Extras navigatorExtras) {
        if (navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getId() == currentDestinationId) {
            navController.navigate(directions, navigatorExtras);
        }
    }

    public static void navigateUp(@NonNull NavController navController,
                                      @IdRes int currentDestinationId) {
        if (navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getId() == currentDestinationId) {
            navController.navigateUp();
        }
    }
}
