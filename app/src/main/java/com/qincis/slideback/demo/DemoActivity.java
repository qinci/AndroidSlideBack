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

package com.qincis.slideback.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qincis.slideback.DefaultSlideView;
import com.qincis.slideback.SlideBack;

/**
 * 滑动返回Demo
 * <p>
 * Created by 沈钦赐 on 2018/1/3.
 */
public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        findViewById(R.id.btn_new_activity).setOnClickListener(v -> {
            startActivity(new Intent(this, DemoActivity.class));
            overridePendingTransition(R.anim.fade_right_in, R.anim.fade_left_out);

        });

        //开启滑动关闭
        SlideBack.create()
                .slideView(new DefaultSlideView(this))
                .attachToActivity(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_left_in, R.anim.fade_right_out);
    }
}
