package MayChallenges;

/*
May 11

Question: Flood Fill
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
At the end, return the modified image.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/
*/

class May11 {
    public int[][] floodFill(int[][] image, int row, int col, int newColor) {
        if (image[row][col] == newColor)
            return image;
        return color(image, row, col, image[row][col], newColor);
    }

    public int[][] color(int[][] image, int row, int col, int color, int newColor) {
        if (image[row][col] != color)
            return image;

        image[row][col] = newColor;

        if (row - 1 >= 0)
            color(image, row - 1, col, color, newColor);
        if (row + 1 < image.length)
            color(image, row + 1, col, color, newColor);
        if (col - 1 >= 0)
            color(image, row, col - 1, color, newColor);
        if (col + 1 < image[row].length)
            color(image, row, col + 1, color, newColor);

        return image;
    }
}
