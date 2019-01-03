/*
 * Copyright 2019. SHENQINCI(沈钦赐)<946736079@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qincis.slideback;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

class Utils {
    @ColorInt
    static int setColorAlpha(int color, float alpha) {
        color = Color.argb((int) (alpha * 255), Color.red(color), Color.green(color), Color.blue(color));
        return color;
    }

    static int d2p(Context var0, float var1) {
        DisplayMetrics var2 = var0.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(1, var1, var2);
    }

    /**
     * 屏幕宽度(像素)
     */
    private static int screentwidth;

    static int getScreenWidth(Context context) {
        if (screentwidth > 0)
            return screentwidth;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return screentwidth = outMetrics.widthPixels;
    }

    static Activity getActivityContext(Context context) {
        if (context == null)
            return null;
        else if (context instanceof Activity)
            return (Activity) context;
        else if (context instanceof ContextWrapper)
            return getActivityContext(((ContextWrapper) context).getBaseContext());

        return null;
    }
}