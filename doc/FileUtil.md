# FastJsonUtil & json处理
Json&对象转换
#### 类名：FastJsonUtil

| name        | void name           | direction  |
| ------------- | ------------- | :-----:|
| 读取Assets文件内容      | String getFromAssets(Context context, String fileName) | |
| 把Assets里的文件拷贝到sd卡上      |  boolean copyAssetToSDCard(AssetManager assetManager, String fileName, String destinationPath) |  |
| 相对路径转绝对路径 | String uriToPath(Context context, Uri uri) |    |
| 删除文件夹 | boolean deleteDir(File dir)  |     |
| 获取文件大小 | long getSize(File file) |   |
| 获取目录名 | String getFolderName(String filePath)  |    |
| 检查文件是否不大于指定大小 | boolean checkFileSize(String filepath, int maxSize) |    |
| 格式化文件大小的显示 |  String formatSize(double size)   |     |
| 读取文件 | static StringBuilder readFile(File file) |    |
| 写入文件 | boolean writeFile(File file, String content, boolean append)  |     |
| 写入文件 | boolean writeFile(File file, InputStream stream, boolean append)|    |
| 移动文件 | moveFile(File srcFile, File destFile) |
| 复制文件 | boolean copyFile(String sourceFilePath, String destFilePath) |    |
| 删除文件 | boolean deleteFile(File file) |
|  创建目录 | makeDir(String filePath) |
|  创建文件 | boolean makeFile(String filePath) |    |
|  关闭流 | close(Closeable closeable) |


#Contact me

E-mail:wenld2014@163.com

github: [https://github.com/LidongWen](https://github.com/LidongWen)

blog: [wenld's blog](http://blog.csdn.net/sinat_15877283)
