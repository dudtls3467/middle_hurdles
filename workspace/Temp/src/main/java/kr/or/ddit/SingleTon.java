package kr.or.ddit;

public class SingleTon {
	
	private static SingleTon instance;

	private SingleTon() {

	}

	public SingleTon getInstance() {
		if (instance == null) {
			instance = new SingleTon();
		}
		return instance;
	}
}
