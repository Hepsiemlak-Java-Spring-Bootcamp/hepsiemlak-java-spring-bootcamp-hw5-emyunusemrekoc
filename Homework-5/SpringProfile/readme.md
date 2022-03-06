# Spring Profile
Spring, yapılandırma özelliklerini profiller halinde gruplandırmak için güçlü bir araç sağlar ve tek bir profil parametresiyle bir dizi yapılandırmayı etkinleştirmemizi sağlar. Bahar Önyüklemesi, profilleri harici olarak yapılandırmamıza ve etkinleştirmemize izin vererek bunun üzerine inşa eder.

Profiller, uygulamamızı farklı ortamlar için ayarlamak için mükemmeldir, ancak diğer kullanım durumlarında da caziptir.

## Profiller Neyi Kontrol Eder?
Belirli bir profilin etkinleştirilmesi bir Spring Boot uygulaması üzerinde büyük bir etkiye sahip olabilir, ancak arka planda altında bir profil yalnızca iki şeyi kontrol edebilir:
- Bir profil uygulama özelliklerini etkileyebilir.
- Profil, uygulama bağlamına hangi beanlerin yüklendiğini etkileyebilir.

## Profile' e Özgü Özellikler
Profilleri kullanarak, özellikleri yalnızca foo profili etkin olduğunda yüklenecek ek bir dosya application-foo.yml oluşturabiliriz.

Bir örneğe bakalım. İki YAML dosyamız var:


    // application.yml
    helloMessage: "Hello!"


    // application-foo.yml
    helloMessage: "Hello Foo!"
Ve helloMessage özelliğini yapıcı argümanı olarak alan bir beanimiz var:


    @Component
    class HelloBean {
    
      private static final Logger logger = ...;
    
      HelloBean(@Value("${helloMessage}") String helloMessage) {
        logger.info(helloMessage);
      }
    
    }

foo profilinin etkin olup olmadığına bağlı olarak, HelloBean logger a farklı bir mesaj yazdırır.
Ayrıca, çok belgeli sözdizimini kullanarak application.yml adlı tek bir YAML dosyasındaki tüm profilleri belirtebiliriz:



    helloMessage: "Hello!"
    ---
    spring:
        profiles: foo
    helloMessage: "Hello Foo!"

--- ile ayrılmış her bölümde spring.profiles özelliğini belirterek, bu bölümdeki özellikler için hedef profili tanımlarız. Eksikse, özellikler varsayılan profile aittir.

## Profile'e Özel Beanler
Özelliklerle, veritabanlarına bağlantı dizeleri veya farklı profillerde farklı değerlere sahip olması gereken harici sistemlere URL'ler gibi birçok şeyi zaten kontrol edebiliriz.
Ancak profillerle, Spring'in uygulama bağlamına hangi beanlerin yüklendiğini de kontrol edebiliriz.


    @Component
    @Profile("foo")
    class FooBean {
    
      private static final Logger logger = ...;
    
      @PostConstruct
      void postConstruct(){
        logger.info("loaded FooBean!");
      }
    
    }
FooBean, @Component ek açıklamayı kullandığımız için Spring Boot'un sınıf yolu taraması tarafından otomatik olarak alınır.@Component Ancak günlük çıktısını yalnızca foo profili etkinse postConstruct() yönteminde göreceğiz. Aksi takdirde, beanin örneği oluşturulmayacak ve uygulama bağlamı eklenmeyecektir.

@Configuration, @Bean aracılığıyla tanımlanan beanlerle benzer şekilde çalışır:



    @Configuration
    class BaseConfiguration {
    
      private static final Logger logger = ...;
    
      @Bean
      @Profile("bar")
      BarBean barBean() {
        return new BarBean();
      }
    
    }
## Testler için Profil Kullanma
Profiller için başka bir mantıklı kullanım örneği, Spring Boot entegrasyon testlerinde kullanılacak bir test profili oluşturmaktır. Bu profili bir testte etkinleştirmek için tek yapmamız gereken, test sınıfına @ActiveProfiles("test") ile ek açıklama eklemektir ve her şey test için ayarlanır.
Yukarıdaki özellikleri kullanarakapplication-test.yml aşağıdaki gibi görünebilir:



    # application-test.yml
    database-url: "jdbc:h2:mem:testDB"

Veritabanı URL'sini, testler sırasında kullanılan bir bellek içi veritabanına işaret etmek için ayarladık.

Temel olarak, test adı verilen ek bir ortam oluşturduk.

Bir test veritabanıyla etkileşimde olan bir dizi tümleştirme testimiz varsa, farklı bir veritabanına işaret eden ayrı bir integrationTest profili de oluşturmak isteyebiliriz:

    # application-integrationTest.yml
    database-url: "the-integration-db:1234"

