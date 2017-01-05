package lambda;

@FunctionalInterface// 只起到一个文档的作用，说明这个接口是函数式接口，编译器并不会使用这个注解来决定一个接口是不是函数式接口。
// 还可以加上泛型<T>,<T,f,y>
public interface Calculator<T> {

	// 有且仅有一个才能称之为函数式接口
    int calc(int num);
    
    // 拓展的方法(必须加default)	实现类默认都能使用
    default void log(String msg){
    	System.out.println(msg);
    }
    
}
