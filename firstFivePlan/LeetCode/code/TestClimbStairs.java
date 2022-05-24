package code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestClimbStairs {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要爬的楼梯数");
        int n = input.nextInt();
        Scanner in = new Scanner(System.in);
        System.out.println("请选择你要使用的计算方法");
        int method = in.nextInt();
        switch(method){
            case 1:  //递归
            int result = ClimbingStairsWithRecursive.climbStairsWithRecursive(n);
            System.out.println("共有" + result + "种可能的方法");
            break;
            case 2:  //hashmap
            ClimbingStairsWithHash demo = new ClimbingStairsWithHash();
            System.out.println("hashmap法输出的方式个数为：");           
            System.out.println(demo.climbStairs(n));
            case 3:  //循环
            int value = ClimbingStairsWithCirculate.climbStairsWithCirculate(n);
            System.out.println("循环法输出的方式个数为：");
            System.out.println(value);
        }
        input.close();
        in.close();//最后再关闭流，即用即关会产生java.util.nosuchelementexception
    }
}
class ClimbingStairsWithRecursive{
    public static int climbStairsWithRecursive(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairsWithRecursive(n-1) + climbStairsWithRecursive(n-2);
    }
}
class ClimbingStairsWithHash{
    private Map<Integer,Integer> storeMap = new HashMap<>();
    public int climbStairs(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(storeMap.get(n) != null)
        return storeMap.get(n);
        else{
            int result = climbStairs(n-1) + climbStairs(n-2);
            storeMap.put(n,result);
            return result;
        }
    }
}
class ClimbingStairsWithCirculate{
    public static int climbStairsWithCirculate(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        int result = 0;
        int pre = 2;
        int prepre = 1;
        for(int i = 3; i <= n; ++i){
            result = pre + prepre;
            prepre = pre;
            pre = result;
        }
        return result;
    }
}