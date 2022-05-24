# Integer 和 int

![avatar](./image/Integer%E5%9B%BE%E7%89%87.jpg)

1. 非new生成的Integer变量是存储在常量池中（参见valueOf和IntegerCache源码）

2. int类型的值存储在栈中

3. 和1相同，去常量池中找59

4. new的integer对象，存在堆中

A. 当integer类型和int类型==时，包装类integer会自动拆包，比较的还是存储的值而不是地址，所以true

B. 都是指向常量池中的同一地址，所以true

C. new的对象存在堆中，地址和常量池中不同，返回false

D. 拆包后相同，比较的是value的值，true

ps： 非new的integer包装类超过-128-127的值会new一个新的值，放在堆中

```java
Integer i0 = 128;
Integer i1 = 128;
Systen.out.println(i0 == i1)  //false
```