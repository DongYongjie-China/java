package trainning.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ALG1 {

    static final int AMOUNT = 10;
    static final int FETCH = 3;
    static int counter = 0;

    public static void main(String[] args) {
        //用lambda表达式写一下
        test1(AMOUNT, FETCH,getList(AMOUNT,()->false));
    }

    //主要算法
    public static void test1(int amount, int fetch, List<Boolean> list) {
        while (0 != (list = list.stream().filter(x -> x == false).collect(Collectors.toList())).size()) {
            for (int i = 0; i < list.size(); i++) {
                if (fetch <= ++counter) {
                    list.set(i, true);
                    counter = 0;
                }
            }
            System.out.println(list);
        }
    }

    //Supplier:返回一个List<Boolean>对象
    public static List<Boolean> getList(int size, Supplier<Boolean> supplier) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(supplier.get());
        }
        return list;
    }
}
