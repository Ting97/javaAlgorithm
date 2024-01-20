package cn.ting97.concurrent;

/**
 * @Classname LoopPrint
 * @Description 交替打印线程
 * @Date 2023/11/17 11:05
 * @Author by chenlt
 */
public class LoopPrint {

    public static void main(String[] args) {
        Number number = new Number();
        Thread oddPrint = new Thread(number, "odd print");
        Thread evenPrint = new Thread(number, "even print");
        oddPrint.start();
        evenPrint.start();
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    static class Number implements Runnable {
        private int number = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    notify();
                    if (number < 100) {
                        number++;
                        System.out.println(Thread.currentThread().getName() + "\t--\t" + number);
                    } else {
                        break;
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
