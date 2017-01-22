cmake_minimum_required(VERSION 3.1.0)
project(pixy)
set(CMAKE_BUILD_TYPE Release)

set(CMAKE_MODULE_PATH ${CMAKE_MODULE_PATH} "${CMAKE_SOURCE_DIR}/cmake/Modules/")

add_definitions(-D__LINUX__)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fno-strict-aliasing -Wno-error")

include_directories(
    #jni.h
    /Library/Java/JavaVirtualMachines/jdk1.8.0_101.jdk/Contents/Home/include

    #jni_md.h
    /Library/Java/JavaVirtualMachines/jdk1.8.0_101.jdk/Contents/Home/include/darwin

    src/common/inc
    src/host/libpixyusb/src/utils
    src/host/libpixyusb/include
)

set(SOURCES
    src/host/libpixyusb_swig/pixy_wrap.cxx
    src/common/src/chirp.cpp
    src/host/libpixyusb/src/pixy.cpp
    src/host/libpixyusb/src/chirpreceiver.cpp
    src/host/libpixyusb/src/pixyinterpreter.cpp
    src/host/libpixyusb/src/usblink.cpp
    src/host/libpixyusb/src/utils/timer.cpp
)

add_library(pixy_java SHARED ${SOURCES})
install(TARGETS pixy_java
    LIBRARY DESTINATION lib
    ARCHIVE DESTINATION lib
    RUNTIME DESTINATION bin
)

find_package(Boost REQUIRED COMPONENTS thread system chrono)
if(Boost_FOUND)
    include_directories(${Boost_INCLUDE_DIRS})
    target_link_libraries(pixy_java ${Boost_LIBRARIES})
endif()

set(THREADS_PREFER_PTHREAD_FLAG ON)
find_package(Threads REQUIRED)
include_directories(${Threads_INClUDE_DIRS})
target_link_libraries(pixy_java Threads::Threads)


find_package(Libusb1)

if(NOT LIBUSB1_FOUND)
    message(FATAL_ERROR "missing Libusb1")
endif()
include_directories(${LIBUSB1_INCLUDE_DIR})
target_link_libraries(pixy_java ${LIBUSB1_LIBRARIES})
