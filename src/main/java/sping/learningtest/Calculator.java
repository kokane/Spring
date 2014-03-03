package sping.learningtest;

import java.awt.BufferCapabilities.FlipContents;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import sping.learningtest.template.BufferReaderCallback;
import sping.learningtest.template.LineCallback;

public class Calculator {
	
	public Integer fileReadTemplate(String filePath, BufferReaderCallback callback) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			int ret = callback.doSomethingWithReader(br);
			return ret;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T initVal) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filepath));
			T res = initVal;
			String line = null;
			while((line = br.readLine()) != null) {
				res = callback.doSomethingWithLine(line, res);
			}
			return res;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}

	public Integer calcSum(String filePath) throws IOException {
		LineCallback<Integer> sumCallback = new LineCallback<Integer>() {
			
			public Integer doSomethingWithLine(String line, Integer value) {
				
				return value += Integer.valueOf(line);
			}
		};
		return lineReadTemplate(filePath, sumCallback, 0);
//		BufferReaderCallback sumCallback = new BufferReaderCallback() {
//			
//			public Integer doSomethingWithReader(BufferedReader br) throws IOException {
//				Integer sum = 0;
//				String line = null;
//				while ((line = br.readLine()) != null) {
//					sum += Integer.valueOf(line);
//				}
//				
//				return sum;
//			}
//		};
//		return fileReadTemplate(filePath, sumCallback);
		
	}
	
	public Integer calcMultiply(String filePath) throws IOException {
		LineCallback<Integer> multiplyCallback = new LineCallback<Integer>() {
			public Integer doSomethingWithLine(String line, Integer value) {
				return value *= Integer.valueOf(line);
			}
		};
		return lineReadTemplate(filePath, multiplyCallback, 1);
//		BufferReaderCallback multiplyCallback = new BufferReaderCallback() {
//			
//			public Integer doSomethingWithReader(BufferedReader br) throws IOException {
//				Integer multiply = 1;
//				String line = null;
//				while((line = br.readLine()) != null) {
//					multiply *= Integer.valueOf(line);
//				}
//				return multiply;
//			}
//		};
//		return fileReadTemplate(filePath, multiplyCallback);
	}
	
	public String concatenate(String filePath)  throws IOException {
		LineCallback<String> concatenateCallback = new LineCallback<String>() {
			public String doSomethingWithLine(String line, String value) {
				return value + line;
			}
		};
		return lineReadTemplate(filePath, concatenateCallback, "");
	}

}
