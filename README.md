# FluoriteTest

## 简介

[Fluorite 功能的测试项目](https://gitee.com/azurite_y/Fluorite)。但是再运行本项目时有以下两点要求：
1. 因为 Fluorite 是在 Eclipse 2019 中开发的，未在 IDEA 中运行测试，所以这就导致了当前只能在 Eclipse 中正常运行且功能完善。 但在 IDEA 2023 中就会因为无法正确加载 fluorite-boot 下的 fluorite.factories 文件而导致项目启动失败。目前这个问题还未解决。
2. 运行项目之前需要先导入  Fluorite 项目到 Eclipse 工作空间，这样项目才能识别到 Fluorite。否则若不导入而直接编译 Fluorite 则会导致 jar 包内文字乱码。对于这两个问题我会在之后抽空将代码导入 IDEA 对整个项目代码进行更符合编码约束的重构。