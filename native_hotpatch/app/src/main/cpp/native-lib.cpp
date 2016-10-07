#include <jni.h>
#include <string>

extern "C"
jstring
Java_example_wangnan_1xy_com_nativehotpatch_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Bug Code !";
    return env->NewStringUTF(hello.c_str());
}
