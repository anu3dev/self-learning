package j006priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class J001PriorityQueue {
	public static void main(String[] args) {
		Queue<Integer> priorityQueue = new PriorityQueue<Integer>();
		priorityQueue.offer(10);
		priorityQueue.offer(20);
		priorityQueue.offer(30);
		System.out.println(priorityQueue); // [10, 20, 30]
		priorityQueue.poll();
		System.out.println(priorityQueue); // [20, 30]
	}
}
