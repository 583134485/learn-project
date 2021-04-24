import com.example.Solution;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest(classes = Solution.class)
public class TestDemp {

    @Test
    public void test() {
        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{2, 5, 6};
        new Solution().merge(a, 3, b, 3);

        for (int k : a) {
            System.out.println(k);
        }
        assert (true);
    }

    @Test
    public void test2() {
//        int[] b = new int[]{2, 5, 6};

        int[] b = new int[]{5, 2, 3, 1, 4};
        new Solution().MySort2(b);

        for (int k : b) {
            System.out.println(k);
        }
        assert (true);
    }

    @Test
    public void testFIndTh() {
//        int[] b = new int[]{5,2,3,1,4,7};
//        int k= new Solution().findKth(b,6,6);
//        for(int jk:b){
//            System.out.println(jk);
//        }

        int[] a = new int[]{1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
//
        int k = new Solution().findKth(a, 49, 24);

        for (int jk : a) {
            System.out.println(jk);
        }
        System.out.println(k);

//               int []sa =a;
//                Arrays.sort(sa);
//        System.out.println("check sort"+Arrays.equals(a,sa));
//        int k= new Solution().findKth(b,6,6);


    }

    @Test
    public void JumpFloor() {
        System.out.println(new Solution().JumpFloor(6));

    }

    @Test
    public void maxLength() {
        int[] b = new int[]{5, 2, 4, 3, 3, 11, 23, 14, 2, 54, 1, 3, 2, 7};
        System.out.println(new Solution().maxLength(b));

    }

    @Test
    public void reConstructBinaryTree() {
        int[] pre = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] in = new int[]{3, 2, 4, 1, 6, 5, 7};

        Solution.TreeNode treeNod= new Solution().reConstructBinaryTree(pre, in);
        System.out.println(1);

    }

    @Test
    public void sqrt(){
        int value=9999;
        Assert.isTrue((int)Math.sqrt(value)==new Solution().sqrt(value));
    }

    @Test
    public void testIn(){
        int max=(Integer.MAX_VALUE>>1)+Integer.MAX_VALUE;
        System.out.println(max);

    }

    @Test
    public void testListForiMiss() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.remove(i);
        }

        list.iterator();

        Vector<String> vector=new Vector<>();
        vector.add("a");
    }

    @Test
    public void testHashMap() {
        HashMap<String,String> hashMa=new HashMap<>();
        hashMa.keySet();
        hashMa.put("a","a");
        hashMa.get("a");

        Hashtable<String,String> table=new Hashtable<>();
        table.put("a","a");
        table.get("a");


        ConcurrentHashMap<String,String> con=new ConcurrentHashMap();
        con.put("a","a");
        con.get("a");
    }


}