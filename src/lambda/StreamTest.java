package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
//		-----------创建------------
		// 1. 可变参数创建
		Stream stream = Stream.of("a", "b", "c");

		// 2. 从数组创建
		String[] strArray = new String[] { "a", "b", "c" };
		stream = Stream.of(strArray);
		stream = Arrays.stream(strArray);

		// 3. Collection的stream方法
		List<String> list = Arrays.asList(strArray);
		stream = list.stream();

		Iterator<Object> iterator = stream.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
//		------------转换------------
		// 1. 去重
		Stream.of(1, 2, 2, 3, 1, 4).distinct();
		// 1, 2, 3, 4

		// 2. 过滤
		Stream.of(1, 2, 2, 3, 1, 4).filter(x -> x < 3);
		// 1, 2, 2, 1

		// 3. 映射
		Stream.of(1, 2, 2, 3, 1, 4).map(x -> x + 1);
		// 2, 3, 3, 4, 2, 5

		// 4. flatMap
		Stream.of(Arrays.asList(1, 2, 2), Arrays.asList(3, 1, 4)).flatMap(
				Collection::stream);
		// 1, 2, 3, 3, 1, 4

		// 5. 跳过
		Stream.of(1, 2, 2, 3, 1, 4).skip(2);
		// 2, 3, 1, 4

		// 6. 限制
		Stream.of(1, 2, 2, 3, 1, 4).limit(4);
		// 1, 2, 2, 3
		
		// 7. 排序
		Stream.of(1, 2, 2, 3, 1, 4).sorted();
		// 1，1, 2, 2， 3, 4

		// 8. 自定义排序
		Stream.of(1, 2, 2, 3, 1, 4).sorted((o1, o2) -> o2 - o1);
		// 4, 3, 2, 2, 1, 1

		// 9. 窥视
		Stream.of(1, 2, 2, 3, 1, 4).peek(System.out::println);
		// 输出到控制台
		// 1
		// 2
		// 2
		// 3
		// 1
		// 4
		// 同时stream的内容依旧与原来相同
		
		
//		------------收集------------
		// 1. 列表
		Stream.of(1, 2, 2, 3, 1, 4).collect(Collectors.toList());
		// 1，1, 2, 2， 3, 4

		// 2. 集合
		Stream.of(1, 2, 2, 3, 1, 4).collect(Collectors.toSet());
		// 1, 2, 3, 4

		// 3. 映射
		Stream.of(1, 2, 2, 3, 1, 4).collect(
		        Collectors.toMap(i -> Math.random(), i -> i));
		// {
//		    0.11842786208469525=4,
//		    0.16734811020971374=2,
//		    0.3600306198303368=2,
//		    0.3980964659883778=1,
//		    0.17769328559841546=3,
//		    0.8534437517889751=1
//		   }
		
		// 4. 分组
		Stream.of(1, 2, 2, 3, 1, 4).collect(Collectors.groupingBy(x -> x % 2));
		// {0=[2, 2, 4], 1=[1, 3, 1]}

		// 5. 分组映射
		Stream.of(1, 2, 2, 3, 1, 4).collect(
		        Collectors.groupingBy(
		            x -> x % 2,
		            Collectors.mapping(x -> x * 10, Collectors.toSet())));
		// {0=[20, 40], 1=[10, 30]}

		// 6. 划分
		Stream.of(1, 2, 2, 3, 1, 4).collect(
		        Collectors.partitioningBy(x -> x % 2 == 0));
		// {false=[1, 3, 1], true=[2, 2, 4]}
		
		
//		------------消费------------
		// 直接消费
		Stream.of(1, 2, 2, 3, 1, 4).forEach(i -> System.out.println(i * 10));
		// 输出到控制台
		// 10
		// 20
		// 20
		// 30
		// 10
		// 40

		// 顺序消费
		Stream.of(1, 2, 2, 3, 1, 4).parallel().forEachOrdered(System.out::println);
		// 输出到控制台
		// 1
		// 2
		// 2
		// 3
		// 1
		// 4	
		
//		------------合并------------
		// 1. 计数
		Stream.of(1, 2, 2, 3, 1, 4).count();
		// 6

		// 2. 最大最小
		Stream.of(1, 2, 2, 3, 1, 4).max(((o1, o2) -> o1 - o2));
		// Optional[4]
		Stream.of(1, 2, 2, 3, 1, 4).min(((o1, o2) -> o1 - o2));
		// Optional[1]
		new ArrayList<Integer>().stream().max(((o1, o2) -> o1 - o2));
		// Optional.empty

		// 3. 匹配
		Stream.of(1, 2, 2, 3, 1, 4).allMatch(x -> x < 5);
		// true
		Stream.of(1, 2, 2, 3, 1, 4).anyMatch(x -> x == 3);
		// true
		Stream.of(1, 2, 2, 3, 1, 4).noneMatch(x -> x == 3);
		// false
		
		// 4. 折叠
		Stream.of(1, 2, 2, 3, 1, 4).reduce((sum, x) -> sum += x);
		// Optional[13]

		// 5. 提供初始值的折叠
		Stream.of(1, 2, 2, 3, 1, 4).reduce(-5, (sum, x) -> sum += x);
	}

}
