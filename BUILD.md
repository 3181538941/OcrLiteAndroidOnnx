# 编译说明

1. AndroidStudio 2022.1.1或以上；
2. NDK下载，在SDK Tools中下载，版本选最新版；
3. cmake 3.22.1，在SDK Tools中下载；
4. 原始模型来自https://github.com/DayBreak-u/chineseocr_lite/tree/onnx/models。
5. 模型目录结构为

```
OcrLiteAndroidOnnx/OcrLibrary/src/main/assets
├── angle_net.onnx
├── crnn_lite_lstm.onnx
├── dbnet.onnx
└── keys.txt
```

5.下载opencv-mobile-3.4.15-android.7z，[下载地址](https://gitee.com/benjaminwan/ocr-lite-android-ncnn/attach_files/843219/download/opencv-mobile-3.4.15-android.7z)
解压后目录结构为

```
OcrLiteAndroidNcnn/OcrLibrary/src/sdk
    └── native
        ├── jni
        └── staticlibs
```

6. onnxruntime-1.14.0-android-shared.7z，[下载地址](https://github.com/RapidAI/OnnxruntimeBuilder/releases/tag/1.14.0)
7. setting-Build-Build Tools-Gradle-Gradle JDK: >= 11

* 解压后目录结构为

```
OcrLiteAndroidOnnx/OcrLibrary/src/main/onnxruntime-shared
├── OnnxRuntimeWrapper.cmake
├── arm64-v8a
├── armeabi-v7a
├── include
├── x86
└── x86_64
```

### 编译Release包

* mac/linux使用命令编译```./gradlew assembleRelease```
* win使用命令编译```gradlew.bat assembleRelease```
* 输出apk文件在app/build/outputs/apk

### 重新编译

删除项目根目录下的如下缓存文件夹

```
.idea
build
app/build
OcrLibrary/.cxx
OcrLibrary/build
```
