import org.junit.jupiter.api.*;

public class JUnitTest {

    @BeforeAll // 전체 테스트 케이스 시작하기 전에 1회 실행됨, 메서드는 static으로 선언
    static void beforeAll() {
        System.out.println("@BeforeAll - 전체 테스트 케이스 시작하기 전에 1회 실행됨");
    }

    @BeforeEach // 테스트 케이스를 시작하기 전마다 실행됨
    public void beforeEach() {
        System.out.println("@BeforeEach - 테스트 케이스 시작 전마다 실행");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    @AfterAll // 전체 테스트가 끝난 뒤, 종료하기 전에 1회 실행됨, 메서드는 static으로 선언
    static void afterAll() {
        System.out.println("@AfterAll - 전체 테스트 케이스 종료되기 전에 1회 실행");
    }

    @AfterEach // 테스트 케이스 종료하기 전마다 실행
    public void afterEach(){
        System.out.println("@AfterEach - 테스트 케이스 종료되기 전마다 실행");
    }

}
