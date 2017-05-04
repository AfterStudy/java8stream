package kr.niee.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionStreamStudy {

	public static void main(String[] args) {
		List<Integer> nonStreamList = new ArrayList<>();
		List<Integer> streamList = new ArrayList<>();

		createNonStreamList(nonStreamList);
		streamList = createStreamList();

		System.out.println(sumNonStreamList(nonStreamList));
		System.out.println(sumStreamList(streamList));
	}

	private static int sumStreamList(List<Integer> streamList) {
		// TODO Auto-generated method stub
		int sum = 0;
		sum = streamList.stream().mapToInt(i -> i).sum();
		return sum;
	}

	private static int sumNonStreamList(List<Integer> nonStreamList) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < nonStreamList.size(); i++) {
			sum += nonStreamList.get(i);
		}
		return sum;
	}

	private static List<Integer> createStreamList() {
		// TODO Auto-generated method stub
		return IntStream.range(0, 10).filter(i -> i%2 == 0).map(i -> i +10).boxed().collect(Collectors.toList());
	}

	private static void createNonStreamList(List<Integer> nonStreamList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				nonStreamList.add(i + 10);
		}
	}

}
