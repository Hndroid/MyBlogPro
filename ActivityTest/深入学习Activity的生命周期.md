### 前言

在 Android 四大组件中，Activity 在其中占有的位置也是非常重要的; 吃透 Activity 的生命周期的流程，无疑对在开发 Android 是非常有帮助的，那么，今天让我们一起来深入学习 Android 的生命周期吧！

<!--more-->

在学习 Actvity 的生命周期之前，首先聊聊笔者本人对 Activity 的了解吧。在笔者刚刚接触 Android 开发的时候，对 Activity 是什么还是挺疑惑的，而且挺多入门的课本也没有详细去介绍到底什么是 Activity，大多简单一句 Activity 是 Android 的四大组件之一，然后就没有它什么事了，就开始介绍它的生命周期的回调函数...
可能现在看这篇文章的你可能会想，Activity 不就是一个活动，我们平常在 Android 手机的一整屏幕里面看到的全部内容吗？例如下图手机屏幕吗？

![](http://ouit3bg5b.bkt.clouddn.com/Selection_040.png)

笔者认为这是对 Activity 的认识有偏颇的，在手机一个屏幕里面看到的那不是一个 Activity，是一个继承于 FrameLayout 的 DecorView 下面的子类 View，而 Activity 只是作为一个载体去承载这些视图 View。笔者认为可以把 Activity 看作一个载体，而不是在手机屏幕上面看到的视图吧。

> Activity 的层级结构

![](http://ouit3bg5b.bkt.clouddn.com/Selection_042.png)
因为我拿这张图出来主要是为了更好地说明 Activity 可以看作为一个载体，而不是在手机屏幕看到的视图（TitleView 和 ContentView），所以更往具体的源码实现，因为笔者的能力暂时有限，在这里就暂时不深究了：）; 
> Activity 生命周期流程图

![activity_lifecycle](http://ouit3bg5b.bkt.clouddn.com/activity_lifecycle.png)

Activity 在 Android 系统里面都是被 activity stack (activity 栈)管理着（栈管理元素的特点是先进后出），在当一个新的 Activity 被启动的时候，这个新的 Activity 就会被压进 activity stack 的里面，成为 activity stack 的栈顶的元素，并且这个 Activity 开始准备与用户进行交互，也就是成为活动的 Activity（需要注意的一点，当前与用户进行交互的 Activity 会一直保留着栈顶的位置，直到当前的与用户交互的 Activity 被退出，其后面的 Activity 会再次回到栈顶而成为活动的 Activity）。

新的 Activity 被压进任务栈，或者当前与用户进行交互的 Activity 被弹出任务栈，在压栈或者弹出栈的过程中，都会触发上面 Activity 生命周期流程图中的对应的回调函数。

#### 1.0  Activity中每个回调函数所代表的状态

- ```onCreate()``` 在 activity 第一次被创建的时候被回调，在这个回调函数里面，主要是用来设置要显示的布局视图、以及把数据绑定到布局视图上面去，还有初始化变量等操作;

    - ```onRestrart()``` 在 Activity 完全不可见，但 Activity 没有被销毁的情况下，在这个 Activity 重新回到栈顶的时候（当往全不可见的时候，这个 Activity 不在栈顶）被回调，紧接着会回调 ```onStart()```;

    - ```onStart()``` 在 Activity 对于用户来说全部可见，但是还没有获取到焦点，也就是用户还不可以在上面进行操作的时候被回调，但是这个回调的过程对于用户来说，是非常短暂的，用户察觉不出来;

        - ```onResume()``` 在当前的 Activity 获取到焦点的前被回调，也就是回调后，用户可以在上面进行操作，例如可以点击输入框进行输入等一系列的操作，这时候对于用户，内容是全部可见的;

        - ```onPause()``` 在但前内容对于用户只是部分可见的时候被回调（注意：界面弹出一个 dialog、或者点击输入框而弹出输入框是不会回调该函数，虽然这时候也是相对用户部分可见），例如有个对话框风格的 Activity 弹出的时候，会回调该函数;
        
    - ```onStop``` 当在 Activity 的视图完全不可见的时候，这个函数会被回调;

- ```onDestroy()``` 在这个 Activity 退出执行 finish() 方法,或者在系统内存紧张的时候会杀死这个 Activity 而回调这一个函数;

上面的回调函数，在用户打开一个 Activity、关闭一个 Activity、重新打开一个 Activity 的时候对应的回调函数。

#### 2.0 通过 Dubug 模式查看 Activity 的生命周期 

下面的代码是笔者进行 Dubug 的时候使用的源码：
```java
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "测试Activity的生命周期";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


}
```
##### 2.1 首次把一个 Activity 添加到栈顶：

![202017-10-04](http://ouit3bg5b.bkt.clouddn.com/Peek%202017-10-04%2000-29.gif)

##### 2.2 按下菜单键的时候 Activity 的状态：
![202017-10-04](http://ouit3bg5b.bkt.clouddn.com/Peek%202017-10-04%2000-35.gif)

##### 2.3 当一个对话式的 Activity 运行在任务栈顶的时候：
![2017-08](http://ouit3bg5b.bkt.clouddn.com/Peek%202017-10-04%2017-08.gif)

这个 Dubug 模式主要是为了检验，Activity 在弹出输入框、Fragment 类型的 Dialog、非 Fragment 类型的 Dialog 的时候，该 Activity 的生命周期的变化，从控制台的日志可以看出，上面三种情况都不会导致 Activity 的生命周期发生变化，而当笔者点击第三个按钮的时候（这个按钮监控的是个只是展示图片、dialog 形式的 Activity），控制台打印出了 onPause() 回调函数，也就是在 Activity 部分可见的时候，或者这样子说：当一个体积大 Activity 被 另一个体积小的 Activity 遮住的时候，体积大的 Activity 对于用户仍然部分可见，这时候会回调 onPause() 函数;
当体积小的 Activity 被隐藏起来，这时候体积大的 Activity 就会回到栈顶，这时候回到栈顶前，就会回调 onResume() 函数，再次准备与用户进行交互;

##### 2.4 关闭 Activity,即把该 Activity 从栈顶移除：
![2000-39](http://ouit3bg5b.bkt.clouddn.com/Peek%202017-10-04%2000-39.gif)

#### 3.0 横竖屏切换时 Activity 的生命周期的变化

##### 3.1 由竖屏切换到横屏时，Activity 的生命周期的变化
![2000-47](http://ouit3bg5b.bkt.clouddn.com/Peek%202017-10-04%2000-47.gif)

----

##### 3.2 由横屏屏切换到竖屏时，Activity 的生命周期的变化
![2000-48](http://ouit3bg5b.bkt.clouddn.com/Peek%202017-10-04%2000-48.gif)

----
由上面横竖屏切换调试的日志可以看出，当横竖屏进行切换的时候，Activity 的会回调 onDestroy() 函数，然后再次回调 onCreat() 函数，但是，有时候我们不允许应用在切换横竖屏的时候，发生回调 onDestroy() 函数，然后在回调 onCreat() 函数。这时候，如果不想让 Activity 重新调用 onCreat() 函数，可以有下面两个解决方法：

- 在 AndroidManifest.xml里面配置相关属性，直接不允许进行横竖屏的切换;
主要是在自己不允许进行横竖屏切换的 Activity 配置 ```android:screenOrientation="portrait"```这个属性，portrait 是指只能竖屏，不可以横屏;而 landscape 则反之。

application 节点下的代码如下：（如下面注释 1 ）
```xml
<application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".MainActivity"
            android:screenOrientation="portrait"> <!--1-->
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>

                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>
```

-  在 AndroidManifest.xml里面配置相关属性，直接声明该 Activity 不发生变化
主要是在自己不允许进行横竖屏切换的 Activity 配置 ```android:configChanges="orientation|keyboardHidden|screenSize"``` 这个属性。

application 节点下的代码如下：（如下面注释 2 ）
```xml
<application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".MainActivity"
            android:configChanges="orientation|keyboardHidden|screenSize"> <!--2-->
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>

                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>
```

### 小结
这次对于 Activity 的生命周期的流程分析，只是在其 API 接口的层面上面的分析。对于 Activity 的生命周期的分析，笔者认为，只要抓住 Activity 的变化、Activity 与 Activity 之间切换的关系以及他们在 Activity 栈中的位置，就会很好地分析出 Activity 的生命周期的变化的。



