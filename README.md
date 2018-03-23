# ImgCoverflow
参考 [ImageCoverFlow-master](https://github.com/dolphinwang/ImageCoverFlow) 修改的，使用 ImageView 来实现，可加载本地图片和网络图片等，使用方法与 LIST 一样，设置相应的控件、修改 imageCoverFlow 布局的参数即可。

## 效果预览

#### 效果图

<image src="https://github.com/lishide/ImgCoverFlow/raw/master/art/ImgCoverFlow_screen1.jpg" width="280px"/>

#### 效果预览 GIF

<image src="https://github.com/lishide/ImgCoverFlow/raw/master/art/ImgCoverFlow_art.gif?raw=true" width="280px"/>

## 依赖
[![](https://jitpack.io/v/lishide/ImgCoverFlow.svg)](https://jitpack.io/#lishide/ImgCoverFlow)
#### JitPack 引入方法
##### 1. 在 Project 下的 build.gradle 添加
```java
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

##### 2. 在 Module 下的 build.gradle 添加

```java
dependencies {
    compile 'com.github.lishide:ImgCoverFlow:v1.0.1'
}
```

## 使用

* **在 xml 中引用 CoverFlowView**

```xml
<com.img.coverflow.widget.CoverFlowView
    android:id="@+id/coverflow"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:layout_weight="1"
    android:paddingLeft="10dp"
    android:paddingRight="10dp"
    imageCoverFlow:coverflowGravity="center_vertical"
    imageCoverFlow:coverflowLayoutMode="wrap_content"
    imageCoverFlow:reflectionGap="10dp"
    imageCoverFlow:reflectionHeight="30%"
    imageCoverFlow:visibleImage="3"/>
```

> **属性说明**
> CoverFlow 的 Gravity：imageCoverFlow:coverflowGravity="center_vertical"

> CoverFlow 的模式：imageCoverFlow:coverflowLayoutMode="wrap_content"

> 倒影间隙：imageCoverFlow:reflectionGap="10dp"

> 倒影高度：imageCoverFlow:reflectionHeight="30%"

> 设置可见个数：imageCoverFlow:visibleImage="3"

> ...

* **初始化 CoverFlowView，设置适配器、数据、监听器等**

```java
coverFlowView = (CoverFlowView) findViewById(R.id.coverflow);

coverFlowView.setAdapter(coverFlowAdapter);

//给coverFlowView的TOPView添加点击事件监听
coverFlowView.setOnTopViewClickListener(mOnTopViewClickListener);
```

* **创建 Adapter，实现（implements）ICoverFlowAdapter，和正常的 Adapter 一样使用**

在 `getData` 方法中设置 item 的数据即可。

* **更多**
	* 向前一页
	```java
	coverFlowView.gotoPrevious();
    ```
	* 向后一页
	```java
	coverFlowView.gotoForward();
    ```
	* 获取最上面 Item 的 position
	```java
	int position = coverFlowView.getTopViewPosition();
    ```
	* 获取最上面 Item 的 View
	```java
	CoverFlowAdapter.Holder holder = (CoverFlowAdapter.Holder) coverFlowView.getTopView().getTag();
    ```
......


---

**就到这里，更多的细节，请参考 demo 和源码，[传送门](https://github.com/lishide/ImgCoverFlow) 。**
