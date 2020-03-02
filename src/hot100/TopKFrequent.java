package hot100;

import java.util.*;

/**
 * @ClassName TopKFrequent
 * @Description 前k个高频元素
 * @Author JH
 * @Date 2019/11/11 19:05
 */
public class TopKFrequent {

    //基于优先级队列实现最小堆
    public List<Integer> topKFrequent1(int[] nums,int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) +1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for(int key : map.keySet()) {
            if(queue.size() < k) {
                queue.add(map.get(key));
            } else {
                if(map.get(key) > queue.peek()) {
                    queue.add(map.get(key));
                    queue.remove();
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }
    //基于桶排序
    public List<Integer> topKFrequent(int[] nums,int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //桶排序，将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下表
        List<Integer>[] arr = new List[nums.length+1];
        for (int num :map.keySet()) {
            int i = map.get(num);
            if(arr[i] == null) {
                arr[i] = new ArrayList<>();
            }
            arr[i].add(num);
        }
        for(int i = arr.length-1;i>0 && res.size()<k;i--) {
            if(arr[i] != null) {
                res.addAll(arr[i]);
            }
        }


        return res;
    }
}
