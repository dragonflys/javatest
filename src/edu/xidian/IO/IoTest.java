package edu.xidian.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 * IO流的关闭规则 1. 一般是：先打开的后关闭，后打开的先关闭 2.有依赖关系的情况：流a依赖流b，那么先关闭流a，在关闭流b
 * 例如处理流依赖节点流，一定要先关闭处理流，再关闭节点流 当然在关闭处理流时，会一起关闭节点流
 * try-with-resource语法糖，流必需实现AutoCloseable接口
 * 
 *
 */
public class IoTest {

	@Test // 处理字节流
	public void demo1() {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("summertrain.mp3"));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("s2.mp3"))
				){
			int b;
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 先打开的后关闭
	 */
	@Test
	public void demo2() {
		try (InputStream input = new FileInputStream("test.txt");
				OutputStream output = new FileOutputStream("t.txt")){
			int b;
			while ((b = input.read()) != -1) {
				output.write(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 先打开的后关闭， 关闭处理流的同时，会关闭节点流
	 */
	@Test // 处理流
	public void demo3() {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("summertrain_bak.mp3"));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("buffer.mp3"))){
			int b;
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test // 字符流处理流
	public void demo7() {
		try (Reader reader = new FileReader("t.txt");
				Writer writer = new FileWriter("buffer.txt");
				BufferedReader br = new BufferedReader(reader);
				BufferedWriter bw = new BufferedWriter(writer)){
			int c;
			while ((c = br.read()) != -1) {
				bw.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test // 字符流
	public void demo4() {
		try (Writer output = new FileWriter("li.txt");){
			output.write("锦瑟-李商隐\n");
			output.write("锦瑟无端五十弦，一弦一柱思华年\n");
			output.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃\n");
			output.write("沧海月明珠有泪，蓝田日暖玉生烟\n");
			output.write("此情可待成追忆，只是当时已惘然\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test // 对象序列化
	public void demo5() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))){
			Person p = new Person("王彦龙", 27);
			oos.writeObject(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test // 反序列化
	public void demo6() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))){
			Person p = (Person) ois.readObject();
			System.out.println(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
