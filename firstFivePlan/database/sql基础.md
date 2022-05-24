# sql基础(structure query language)

## schema（模式）

描述表的信息就是模式，模式可以描述数据库中特定的表，也可以用来描述整个数据库（和其中标的关系）

## 主键

一列或一组值，能够唯一标识表中每一行

主键不允许为空，不允许修改或更新

主键值不能重用，如某行从表中删除，它的主键不能赋给以后的新行

## distinct

过滤重复的值

用作所以的列，如果select distinct 两列，除非指定的两列完全相同，否则所以的行都会被检索出来

```sql
select distinct prod_name
from Products
```

## limit

```sql
select name
from stu
limit 5；
```

## limit offset

```sql
select name
from stu
limit 5 offset 5；
```

第一个数字是指从哪开始，第二个数字是检索的行数

mysql支持简化版，即 **limit5,5**

## 注释

```
-- 这是一条注释
# 这是一条注释
```

## 排序

**order by**

1. 
```sql
select distinct prod_name
from Products
order by prod_name
```

可以取一列或多列的名字，必须是select语句中的最后一条子句

2. 对多个列排序

```sql
select prod_id,prod_name,prod_price
from Products
order by prod_price,pro_name;
```

先按价格排序，仅当多个商品价格相同时，才会按姓名排序

有时需要多个列排序的，比如先按姓进行排序，当姓相同时，在按名字进行排序

3. 按列位置排序

位置指的是select清单中的相对位置，不是表中的物理位置

```sql
select prod_id,prod_name,prod_price
from Products
order by 3, 2;
```

与之前查询结果相同

4. 指定排序方向

排序默认是升序，要想安照降序排列，使用 **desc(descending)** 关键字

升序(asc):默认是升序，可以不指定

desc关键字只作用于指定的列上

```sql
select prod_id,prod_name,prod_price
from Products
order by prod_price desc;
```

多个列排序，想要降序，例如，以降序排列产品，最贵的放在前面，再加上产品名

```sql
select prod_id,prod_name,prod_price
from Products
order by prod_price desc，prod_name;
```

注意：先按价格降序排列，在相同的价格内，按名字升序排列

在字典排列顺序中，A 与 a相同，这是大多数数据库管理系统的默认行为，但许多DBMS允许数据库管理员在需要的时候改变这种行为

## 过滤数据

1. where子句

where子句在from子句之后

where支持的操作符

![avatar](./image/where%E5%AD%90%E5%8F%A5.jpg)