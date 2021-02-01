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

import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;

public final class NavControllerExt {
    /**
     * Safely navigate to a destination from the current navigation graph.
     *
     * @param navController NavController to manage the navigation
     * @param currentDestinationId Current destination id to check whether navigate from here is valid or not
     * @param resId A destination id to navigate to
     */
    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                    @IdRes int resId) {
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination != null &&
                currentDestination.getId() == currentDestinationId) {
            navController.navigate(resId);
        }
    }

    /**
     * Safely navigate to a destination from the current navigation graph.
     *
     * @param navController NavController to manage the navigation
     * @param currentDestinationId Current destination id to check whether navigate from here is valid or not
     * @param resId A destination id to navigate to
     * @param args Arguments to pass to the destination
     */
    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                    @IdRes int resId, @Nullable Bundle args) {
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination != null &&
                currentDestination.getId() == currentDestinationId) {
            navController.navigate(resId, args);
        }
    }

    /**
     * Safely navigate to a destination from the current navigation graph.
     *
     * @param navController NavController to manage the navigation
     * @param currentDestinationId Current destination id to check whether navigate from here is valid or not
     * @param resId A destination id to navigate to
     * @param args Arguments to pass to the destination
     * @param navOptions Special options for this navigation operation
     */
    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                    @IdRes int resId, @Nullable Bundle args, @Nullable NavOptions navOptions) {
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination != null &&
                currentDestination.getId() == currentDestinationId) {
            navController.navigate(resId, args, navOptions);
        }
    }

    /**
     * Safely navigate to a destination from the current navigation graph.
     *
     * @param navController NavController to manage the navigation
     * @param currentDestinationId Current destination id to check whether navigate from here is valid or not
     * @param resId A destination id to navigate to
     * @param args Arguments to pass to the destination
     * @param navOptions Special options for this navigation operation
     * @param navigatorExtras Extras to pass to the Navigator
     */
    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                    @IdRes int resId, @Nullable Bundle args, @Nullable NavOptions navOptions,
                                    @Nullable Navigator.Extras navigatorExtras) {
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination != null &&
                currentDestination.getId() == currentDestinationId) {
            navController.navigate(resId, args, navOptions, navigatorExtras);
        }
    }

    /**
     * Safely navigate to a destination from the current navigation graph.
     *
     * @param navController NavController to manage the navigation
     * @param currentDestinationId Current destination id to check whether navigate from here is valid or not
     * @param directions Directions that describe this navigation operation
     */
    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                    @NonNull NavDirections directions) {
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination != null &&
                currentDestination.getId() == currentDestinationId) {
            navController.navigate(directions);
        }
    }

    /**
     * Safely navigate to a destination from the current navigation graph.
     *
     * @param navController NavController to manage the navigation
     * @param currentDestinationId Current destination id to check whether navigate from here is valid or not
     * @param directions Directions that describe this navigation operation
     * @param navOptions Special options for this navigation operation
     */
    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                @NonNull NavDirections directions, @Nullable NavOptions navOptions) {
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination != null &&
                currentDestination.getId() == currentDestinationId) {
            navController.navigate(directions, navOptions);
        }
    }

    /**
     * Safely navigate to a destination from the current navigation graph.
     *
     * @param navController NavController to manage the navigation
     * @param currentDestinationId Current destination id to check whether navigate from here is valid or not
     * @param directions Directions that describe this navigation operation
     * @param navigatorExtras Extras to pass to the Navigator
     */
    public static void navigate(@NonNull NavController navController, @IdRes int currentDestinationId,
                                @NonNull NavDirections directions, @NonNull Navigator.Extras navigatorExtras) {
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination != null &&
                currentDestination.getId() == currentDestinationId) {
            navController.navigate(directions, navigatorExtras);
        }
    }

    /**
     * Attempts to navigate up in the navigation hierarchy. Suitable for when the
     * user presses the "Up" button marked with a left (or start)-facing arrow in the upper left
     * (or starting) corner of the app UI.
     *
     * @param navController NavController to manage the navigation
     * @param currentDestinationId Current destination id to check whether navigate from here is valid or not
     */
    public static void navigateUp(@NonNull NavController navController,
                                      @IdRes int currentDestinationId) {
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination != null &&
                currentDestination.getId() == currentDestinationId) {
            navController.navigateUp();
        }
    }
}
