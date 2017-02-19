# ScreenUtils & 屏幕相关
状态栏标题栏高度，屏幕宽高，像素转换
### 类名：ScreenUtils

| name        | void name           | direction  |
| ------------- | ------------- | :-----:|
| 获取状态栏高度      | getStatusBarHeight(mContext)  | |
| 获取状态栏高度。 使用Resource对象获取      |  int getStatusBarHeight(Context context)    |  |
| 获取标题栏高度 | int getTitleBarHeight(Activity activity)  |    |
| 在Activity中获取屏幕的高度和宽度 | int[] getScreenSize(Activity activity) |     |
| 获取屏幕宽度和高度，单位为px |  Point getScreenMetrics(Context context) |    |
| 获取屏幕宽度和高度 | int[] getScreenSize(Context context)  |    |
| 获取屏幕长宽比 |  float getScreenRate(Context context) |    |

### 像素转换

| name        | void name           | direction  |
| ------------- | ------------- | :-----:|
| 像素转化dip      | int px2dip(Context context, float pxValue)  | |
| dip转化像素 |  int dip2px(float dipValue) |  |
| sp转px | int sp2px(Context context, float spVal)  |    |
| px转sp | float px2sp(Context context, float pxVal) |     |

#Contact me

E-mail:wenld2014@163.com

blog: [wenld's blog](http://blog.csdn.net/sinat_15877283)
