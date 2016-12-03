# JUnit用户指南

## 1、概述
本文章的目的旨在为编写测试用例的开发人员、扩展人员和各种IDE编写插件的引擎人员们提供更加全面的参考。

### 1.1、什么是JUnit5？
不同于之前的JUnit版本，JUnit5由三个不同的子模块所组成。

*JUnit5 = JUnit Platform + JUnit Jupiter + JUnit Vintage*

`JUnit Platform`提供了在JVM上运行测试框架的基础。它也为在platform运行的测试框架开发者提供了测试引擎API，platform为了从命令行运行platform提供了`Console Launcher`

### 1.2、所支持的Java版本
JUnit5要求使用Java 8，然而你仍然可以用之前版本的jdk来执行编译通过的测试代码。

## 2、安装

### 2.1、元数据依赖

#### 2.1.1、JUnit Platform
#### 2.1.2、JUnit Jupiter
#### 2.1.3、JUnit Vintage

### 2.2、JUnit Jupiter简单项目

### 2.3、依赖关系图

## 3、编写测试用例

### 3.1、注解

#### 3.1.1、元注解和组合注解

### 3.2、标准的测试类

### 3.3、Display Names

### 3.4、Assertions

### 3.5、Assumptions

### 3.6、禁用测试

### 3.7、标注和过滤

### 3.8、嵌套测试

### 3.9、构造器和方法的依赖注入

### 3.10、接口默认方法

### 3.11、动态测试

#### 3.11.1、动态测试用例

## 4、运行测试用例

### 4.1、IDE支持

#### 4.1.1、Intellij IDEA

#### 4.1.2、其他IDE

### 4.2、构建支持

#### 4.2.1、Gradle

#### 4.2.2、Maven

### 4.3、控制台加载器

#### 4.3.1、选项

### 4.4、使用JUnit4运行JUnit Platform

#### 4.4.1、设置
