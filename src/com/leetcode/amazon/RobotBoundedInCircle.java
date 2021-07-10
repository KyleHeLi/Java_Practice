package com.leetcode.amazon;

import java.util.Arrays;

// Top Amazon Questions
// tag: simulation
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        // Two situations of identifying the limit cycle trajectory:
        // 1. If the robot returns to the initial point after one cycle, that's the limit cycle trajectory.
        // 2. if the robot doesn't face north at the end of the first cycle, that's the limit cycle trajectory.
        //    Once again, that's the consequence of the plane symmetry for the repeated cycles, see proof below.

        // 0 -> north, 1 -> east, 2 -> south, 3 -> west
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] origin = new int[]{0, 0};

        // Destination includes the location and direction, go north by default
        int[][] destination = new int[][]{{0, 0}, directions[0]};
        int dir = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);

            switch (c) {
                case 'G':
                    destination[0][0] += destination[1][0];
                    destination[0][1] += destination[1][1];
                    break;
                case 'L':
                    dir = (4 + dir - 1) % 4;
                    destination[1] = directions[dir];
                    break;
                case 'R':
                    dir = (dir + 1) % 4;
                    destination[1] = directions[dir];
                    break;
                default:
                    break;
            }

        }

        return Arrays.equals(destination[0], origin) || dir != 0;
    }

    public static void main(String[] args) {
        RobotBoundedInCircle test = new RobotBoundedInCircle();

        // Example 1
        String instructions = "GGLLGG";
        boolean result = test.isRobotBounded(instructions);
        System.out.println(result == true);

        // Example 2
        instructions = "GG";
        result = test.isRobotBounded(instructions);
        System.out.println(result == false);

        // Example 3
        instructions = "GL";
        result = test.isRobotBounded(instructions);
        System.out.println(result == true);

        // Example 4
        instructions = "RLLGGLRGLGLLLGRLRLRLRRRRLRLGRLLLGGL";
        result = test.isRobotBounded(instructions);
        System.out.println(result == true);
    }
}


// solution
//    public boolean isRobotBounded(String instructions) {
//        // north = 0, east = 1, south = 2, west = 3
//        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//        // Initial position is in the center
//        int x = 0, y = 0;
//        // facing north
//        int idx = 0;
//
//        for (char i : instructions.toCharArray()) {
//            if (i == 'L')
//                idx = (idx + 3) % 4;
//            else if (i == 'R')
//                idx = (idx + 1) % 4;
//            else {
//                x += directions[idx][0];
//                y += directions[idx][1];
//            }
//        }
//
//        // after one cycle:
//        // robot returns into initial position
//        // or robot doesn't face north
//        return (x == 0 && y == 0) || (idx != 0);
//    }

/*
        * Appendix: Mathematical Proof
Let's provide a strict mathematical proof.

If the robot doesn't face north at the end of the first cycle, then that's the limit cycle trajectory.

First, let's check which direction the robot faces after 4 cycles.

Let's use numbers from 0 to 3 to mark the directions: north = 0, east = 1, south = 2, west = 3. After one cycle the robot is facing direction k != 0.

After 4 cycles, the robot faces direction (k * 4) % 4 = 0, i.e. after 4 cycles, the robot is always facing north.

Second, let's find the robot coordinates after 4 cycles.

The robot initial coordinates are x = y = 0. After one cycle, the new coordinates are x_1 = x + \Delta xx
1
​
 =x+Δx, y_1 = y + \Delta yy
1
​
 =y+Δy, where both \Delta xΔx and \Delta yΔy could be positive or negative.

Let's consider four situations.

After one cycle, the robot faces north.
Then here is what we have after 4 cycles:

x_4 = x + \Delta x + \Delta x - \Delta x + \Delta x = x + 4 \Delta xx
4
​
 =x+Δx+Δx−Δx+Δx=x+4Δx

y_4 = y + \Delta y + \Delta y + \Delta y + \Delta y = y + 4 \Delta yy
4
​
 =y+Δy+Δy+Δy+Δy=y+4Δy

After one cycle, the robot faces east.
Then here is what we have after 4 cycles:

x_4 = x + \Delta x + \Delta y - \Delta x - \Delta y = xx
4
​
 =x+Δx+Δy−Δx−Δy=x

y_4 = y + \Delta y - \Delta x - \Delta y + \Delta x = yy
4
​
 =y+Δy−Δx−Δy+Δx=y

After one cycle, the robot faces south.
Then here is what we have after 4 cycles:

x_4 = x + \Delta x - \Delta x + \Delta x - \Delta x = xx
4
​
 =x+Δx−Δx+Δx−Δx=x

y_4 = y + \Delta y - \Delta y + \Delta y - \Delta y = yy
4
​
 =y+Δy−Δy+Δy−Δy=y

After one cycle, the robot faces west.
Then here is what we have after 4 cycles:

x_4 = x + \Delta x - \Delta y - \Delta x + \Delta y = xx
4
​
 =x+Δx−Δy−Δx+Δy=x

y_4 = y + \Delta y + \Delta x - \Delta y - \Delta x = yy
4
​
 =y+Δy+Δx−Δy−Δx=y

Hence, if the robot doesn't face north at the end of the first cycle, then after 4 cycles, the robot is back to the initial coordinates and faces north.

The following statement is a straight consequence.

After at most 4 cycles, the limit cycle trajectory returns to the initial point.
        * */
