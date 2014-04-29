import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;


public class StringExercise {
    public static void main(String[] args){
        StringBuilder s = null;
        
        System.out.println("Input a String:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = new StringBuilder(reader.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if(s.toString().matches("^[A-Za-z0-9]+$")){
            HashMap map = new HashMap();
            
            char tempChar[] = s.toString().toCharArray();
            //构造hashmap
            for(char c:tempChar){
                if(map.containsKey(c)){
                    map.put(c,(int)map.get(c) + 1);
                }
                else{
                    map.put(c,1);
                }
            }
            
            //对hashMap进行排序
            Object[] key = map.keySet().toArray();
            Arrays.sort(key);
            
            //找出最大值
            int max = 0;
            for(Object token:key){
                if(max < (int) map.get(token)){
                    max = (int) map.get(token);
                }
            }
            
            //输出
            for(int i = max;i > 0;i --){
                for(Object token:key){
                    if(i == (int) map.get(token)){
                        System.out.print((char) token);
                        map.put((char) token,(int) map.get(token) - 1);
                    }
                }
            }
            
        }
        else{
            System.out.println("输入字符串非法");
        }
        
    }
}
