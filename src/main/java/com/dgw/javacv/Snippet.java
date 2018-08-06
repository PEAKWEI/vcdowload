package com.dgw.javacv;

import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class Snippet {
	
	static {
		String path=System.getProperty("user.dir")+ "\\opencv\\x64\\opencv_java341.dll";
		System.load(path);
	}
	public static void main(String[] args) {
		// 读取原始图片
		Mat image = Imgcodecs.imread("z:\\001.jpg");
		if (image.empty()) {
			System.err.println("加载图片出错，请检查图片路径！");
			return;
		}
		// 显示图片
		HighGui.imshow("sss", image);
		// 无限等待按键按下
		HighGui.waitKey(0);
	}
}
