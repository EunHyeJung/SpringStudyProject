package hello.core.singleton;

public class SingletonService {
    private static final SingletonService singletonService = new SingletonService();

    // 외부에서 new로 생성할 수 없음. (한개의 인스턴스만 존재하므로)
    private SingletonService() {

    }

    // 인스턴스 참조를 꺼내는 유일한 방법
    public static SingletonService getInstance() {
        return singletonService;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args) {

    }
}
