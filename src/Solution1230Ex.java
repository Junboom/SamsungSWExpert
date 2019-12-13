package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution1230Ex {
	
	class Node {
		int data;
		Node next;
	}
	
	Node header = new Node();
	
	public void addFirst(int data) {
		Node n = new Node();
		n.data = data;
		n.next = header.next;
		header.next = n;
	}
	
	public void append(int data) {
		if (header.next == null)
			addFirst(data);
		else {
			Node end = new Node();
			end.data = data;
			Node n = header.next;
			while (n.next != null)
				n = n.next;
			n.next = end;
		}
	}
	
	public void print() {
		if (header.next == null)
			return;
		Node n = header.next;
		while (n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	public void delete(int data) {
		if (header == null)
			return;
		
		Node n = header;
		while (n.next != null) {
			if (n.next.data == data) {
				n.next = n.next.next;
				return;
			}
			else
				n = n.next;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split(" ");
			List<String> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(line[i]);
			}
			br.readLine();
			String[] pass = br.readLine().split(" ");

			for (int i = 0; i < pass.length; i++) {
				switch (pass[i]) {
				case "I":
					for (int j = 0; j < Integer.parseInt(pass[i+2]); j++)
						list.add(Integer.parseInt(pass[i+1]) + j, pass[i+3+j]);
					break;
				case "D":
					for (int j = 0; j < Integer.parseInt(pass[i+2]); j++)
						list.remove(Integer.parseInt(pass[i+1]));
					break;
				case "A":
					for (int j = 0; j < Integer.parseInt(pass[i+1]); j++)
						list.add(pass[i+2+j]);
					break;
				}
			}

			System.out.print("#" + test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
	}
	
}
