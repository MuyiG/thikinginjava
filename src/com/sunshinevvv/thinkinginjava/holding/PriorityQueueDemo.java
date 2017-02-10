package com.sunshinevvv.thinkinginjava.holding;

import java.util.*;

/**
 * Created by 光 on 2017/2/10.
 *
 * 优先队列的简单示例，Integer，Character已经有天然的排序逻辑了，如果要使用自定义的数据类型，则也需要制定排序逻辑。
 */
public class PriorityQueueDemo {

    private static void printQueue(Queue queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            priorityQueue.add(random.nextInt(i + 10));
        }
        printQueue(priorityQueue);

        List<Integer> ints = Arrays.asList(25, 22, 20,
                18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<Integer>(ints);
        printQueue(priorityQueue);
        priorityQueue = new PriorityQueue<Integer>(
                ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        printQueue(priorityQueue);

        // Queue允许重复
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ =
                new PriorityQueue<String>(strings);
        printQueue(stringPQ);
        stringPQ = new PriorityQueue<String>(
                strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        printQueue(stringPQ);

        // 一种消除重复的手段是提前用Set处理
        Set<Character> charSet = new HashSet<Character>();
        for(char c : fact.toCharArray())
            charSet.add(c); // Autoboxing
        PriorityQueue<Character> characterPQ =
                new PriorityQueue<Character>(charSet);
        printQueue(characterPQ);
    }

}
