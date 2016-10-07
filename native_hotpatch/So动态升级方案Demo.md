# So动态升级方案Demo

## 使用方法

* 运行程序显示"Hello, world"此处为调用的原链接库的方法
* 运行adb push ./patch.jar  /sdcard/命令，将补丁包推送到sdcard目录里，然后点击click按钮，将补丁包路径注入到nativeLibraryDirectory的首部，并加载补丁包的链接库



