cmake_minimum_required(VERSION 3.22.0)

project(Code LANGUAGES CXX)

add_executable(${PROJECT_NAME} code.cpp)

target_precompile_headers(${PROJECT_NAME} PUBLIC bits/stdc++.h)
