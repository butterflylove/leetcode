package practice;

class a{
	public void play(){
		System.out.println("aaaaaaaaaaaaa");
	}
}

class b extends a{
	public void play(){
		System.out.println("bbbbbbbbbbbbbbbbb");
	}
}

public class Holder<T> {
	private T a;
	public Holder(T a){ this.a = a;}
	public void set(T a) { this.a = a ;}
	public T get(){ return a;}
	public static void main(String[] args){
		Holder x = new Holder(new b());
		((b)x.get()).play();
	}
}
