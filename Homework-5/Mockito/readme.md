# Mocking Nedir?
Mockito tamamen bir ihtiyaçtan doğmuş, bu ihtiyaç objelerimizi mocklamak. Obje mocklamak nedir? Örneğin,

Mesela elimizde UserDao şeklinde üyelerimiz hakkında database’de çeşitli işlemler yaptığımız bir Dao sınıfımız var.

Aynı zamanda LoginService diye’de bir Servis sınıfı var. Biz LoginService’in testini yazmak istiyoruz. LoginServiceTest diye bir sınıf oluştururuz. Fakat burada bizim UserDao’ya bir bağlılığımuz olacak yani LoginService için bir test yazmak istediğimizde UserDao’yu kullanacağız. Fakat biz UserDao sınıfını yoksayıp, UserDao sınıfını mocklayarak sadece LoginService için testler yazabiliriz. Mocklamaya aynı zamanda davranışları belirlemede giriyor. Yani biz UserDao’nun ne yapacağını belirleyebiliriz.
Kısa bir örnek ile göstermek istersek.
```java
public class User {

    private Long userId;
    private String userName;
    private String userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}```
```java
public class UserDao {

    public User findUserByName(String userName){
        return null;
    }
}
```

```java
public class LoginService {

    @Autowired
    private UserDao userDao;

    public boolean login(String userName, String userPassword) {
        User user = userDao.findUserByName(userName);
        if(user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword) ) return true;
        return false;

    }
}
```

```java
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    //Testimizde UserDao'yu mocklayarak onun davranışlarını biz belirleyeceğiz böylece servis sınıfımızı test ederken
    //Database ile işimiz olmayacak
    @Mock
    private UserDao userDao;

    //Mockladığımız objeleri login service sınıfına inject ediyoruz.
    @InjectMocks
    private LoginService loginService;

    @Test
    public void shouldTrueIfUserNameAndPasswordIsTrue(){
        String userName = "yunus";
        String userPassword = "1234";

        //Basit bir User sınıfı oluşturduk kullanıcı adı şifre belirledik.
        User user = new User(userName,userPassword);

        //Ve asıl nokta. Dao servisine diyoruz ki eğer sana findUserByName methoduyla ilgili bir talep gelirse
        //Benim oluşturduğum user'i döndür.
        when(userDao.findUserByName(userName)).thenReturn(user);

        //Burdada kullanıcı adı ve şifremizin doğru olduktan sonra döndürülen sonucun true olup olmadığını kontrol ediyoruz.
        assertTrue(loginService.login(userName,userPassword));


    }
}
```
