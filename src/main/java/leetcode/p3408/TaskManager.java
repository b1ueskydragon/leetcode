package leetcode.p3408;

import java.util.List;
import java.util.PriorityQueue;

class TaskManager {

    // A user may be assigned multiple tasks.
    // Adds a task to the specified user with the given priority.
    // -> A task won't be assigned to multiple user

    private final PriorityQueue<Task> pq = new PriorityQueue<>(
            (a, b) -> (b.priority != a.priority) ? b.priority - a.priority : b.taskId - a.taskId);

    // Constraints: 0 <= userId <= 10^5
    // Constraints: 0 <= taskId <= 10^5
    // Constraints: At most 2 * 10^5 calls
    private final int[] taskToUser = new int[100_001];
    private final boolean[] isRemovedTask = new boolean[100_001];
    // A sort of revision
    private final int[] taskToVersion = new int[100_001];

    private static class Task {
        int taskId;
        int priority;
        int version; // max < Integer.MAX_VALUE

        Task(int taskId, int priority, int version) {
            this.taskId = taskId;
            this.priority = priority;
            this.version = version;
        }
    }

    // task := [user, task, priority]
    public TaskManager(List<List<Integer>> tasks) {
        tasks.forEach(task -> {
            pq.offer(new Task(task.get(1), task.get(2), 0));
            taskToUser[task.get(1)] = task.get(0);
        });
    }

    // It is guaranteed that taskId does not exist in the system.
    public void add(int userId, int taskId, int priority) {
        // For cases have been removed/polled in the past
        final int version = isRemovedTask[taskId] ? ++taskToVersion[taskId] : 0;
        pq.offer(new Task(taskId, priority, version));
        taskToUser[taskId] = userId;
        isRemovedTask[taskId] = false;
    }

    // It is guaranteed that taskId exists in the system.
    public void edit(int taskId, int newPriority) {
        // We don't need to update "task -> user"
        pq.offer(new Task(taskId, newPriority, ++taskToVersion[taskId]));
    }

    public void rmv(int taskId) {
        taskToUser[taskId] = -1;
        isRemovedTask[taskId] = true;
    }

    // If there are multiple tasks with the same highest priority, execute the one with the highest taskId.
    // After executing, the taskId is removed from the system.
    // Return the userId. If no tasks are available, return -1.
    public int execTop() {
        while (!pq.isEmpty()) {
            final var highest = pq.poll();
            final int taskId = highest.taskId;
            if (!isRemovedTask[taskId] && taskToVersion[taskId] == highest.version) {
                isRemovedTask[taskId] = true;
                return taskToUser[taskId];
            }
        }
        return -1;
    }
}
