
cmake_minimum_required(VERSION 3.4.1)


add_library(corona SHARED IMPORTED)
set_target_properties(
        corona
        PROPERTIES IMPORTED_LOCATION
        ../../../../build/intermediates/coronaJNI/jni/${ANDROID_ABI}/libcorona.so
)

add_library(lua SHARED IMPORTED)
set_target_properties(
        lua
        PROPERTIES IMPORTED_LOCATION
        ../../../../build/intermediates/coronaJNI/jni/${ANDROID_ABI}/liblua.so
)



include_directories( "/Users/vlad/Library/Application Support/Corona/Native/Corona/shared/include/Corona"
        "/Users/vlad/Library/Application Support/Corona/Native/Corona/shared/include/lua")


add_library( plugin.library SHARED src/main/cpp/plugin.cpp )

target_link_libraries(  plugin.library
        corona
        lua
        )
