# AppUtils_  &ensp;&ensp;&ensp;  App相关辅助类
## AppUtils 包名
### 版本相关
| name        | void name           | direction  |
| ------------- | ------------- | :-----:|
| 获取版本号      | getVerCode(mContext) | |
| 版本信息      | getVerName(mContext)      |  |
| 获取程序应用名 | getAppName(mContext)      |    |
| 获取应用签名 | getSign(Context context, String pkgName)      |     |
| 获取手机系统SDK版本 | int getSDKVersion()      |    |
| 是否Dalvik模式 | boolean isDalvik()      |   |
| 检测当前应用是否是Debug模式 | boolean isDebuggable(Context ctx)    |      |

### APK操作

| name        | void name           | direction  |
| ------------- | ------------- | :-----:|
| 安装APK      | installApk(Context context, File file) | |
| 卸载APK      | uninstallApk(Context context, String packageName)      |  |
| 获取系统中所有的应用 | List<PackageInfo> getAllApps(Context context)     |    |

### 进程 & 服务


| name        | void name           | direction  |
| ------------- | ------------- | :-----:|
| 检测服务是否运行      | boolean isServiceRunning(Context context, String className) | |
| 停止运行服务      | boolean stopRunningService(Context context, String className)      |  |
| 得到CPU核心数 |int getNumCores()     |    |
| 判断进程是否在运行 | boolean isRunningbyNamedProcess(Context context, String processName)   |     |
| 获取设备的可用内存大小 | int getDeviceUsableMemory(Context context)      |    |



#Contact me

E-mail:wenld2014@163.com

blog: [wenld's blog](http://blog.csdn.net/sinat_15877283)
