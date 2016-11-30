# java-testcase-example
如果你是Java开发者，这里有大部分的测试供你使用，包括junit、mock、http等测试。欢迎增加~~

## 作者介绍
源码地址：我的[Github地址](https://github.com/benjaminwhx)  
作者：[吴海旭](http://benjaminwhx.com)

## 项目结构
```
├── junit4            // junit4的一些新特性
  ├── asserts         // junit的基础操作，包括@BeforeClass、@Before、@AfterClass、@After、@Test以及assert 的相关语句
  ├── category        // junit4的新特性-Category
  ├── enclosed        // junit4的新特性-enclosed
  ├── flow            // junit4的整个执行流程分析
  ├── parameterized   // junit4的新特性-参数化parameterized
  ├── rule            // junit4的新特性-rule，定义了一些规则
  ├── suit            // junit4的新特性-suit，可以指定多个测试类一起运行
  ├── theories        // junit4的新特性-theories，可以对测试类需要的参数进行推测，从而提供随机性参数
  
├── powermock         // mock操作
  ├── mock            // powermock的一些特性
  ├── register        // 基于mock来理解一下在项目中的实际作用
  
├── spring            // spring项目中如何进行测试
  ├── http            // spring项目中使用http来测试结果
  ├── junit4          // spring项目中配合使用junit4来测试service方法以及dao方法
  ├── mock            // spring项目中配合使用mock来测试controller的方法
```

文章大部分代码都是参考的官方文档，可以自行查看。
推荐文章：[hotdog](http://hotdog.iteye.com/category/143340)
