# Android Slide Back
一行代码实现滑动返回

* 简单实用
```java
//开启滑动关闭
SlideBack.create()
        .attachToActivity(this);
```

* 可通过继承ISlideView 实现自定义样式，默认样式模仿即刻App的滑动返回
```java
SlideBack.create()
        .slideView(new DefaultSlideView(this))
        .attachToActivity(this);
```

* 其他说明
  1. SlideBack.canSlideWidth 设置左边沿触发开始的距离
  2. SlideBack.onSlide 设置触发返回的回调，不设置默认会调用当前Activity的onBackPressed