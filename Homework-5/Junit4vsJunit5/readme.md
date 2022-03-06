# JUnit 5 vs JUnit 4
JUnit 5, Java 8 kodlama stilini uyarlamayı ve JUnit 4'ten daha sağlam ve esnek olmayı amaçlamaktadır.

## 1. Anotasyon Farkları
Her iki sürümdeki ek açıklamaların çoğu aynıdır, ancak birkaçı farklıdır.

| Özellik  | JUnit 4  |  Junit 5 |
| ------------ | ------------ | ------------ |
| Test methodu olduğunu belirtir  | @Test  | @Test  |
| Geçerli sınıftaki tüm test methodlarından önce yürütür  | @BeforeClass  | @BeforeAll  |
|  Geçerli sınıftaki tüm test methodlarından sonra yürütür |  @AfterClass |  @AfterAll |
| Her test methodundan önce yürütür  | @Before   | @BeforeEach  |
|  Her test methodundan sonra yürütür | @After  | @AfterEach  |
| Test methodunu devre dışı bırakır  | @Ignore  | @Disabled  |
|  Dinamik testler için test factory | NA  |  @TestFactory |
| İç içe testler  | NA  |  @Nested  |
|  Etiketleme ve filtreleme | @Category  | @Tag  |
| Özel uzantıları kaydeder  |  NA |  @ExtendWith  |

## 2. JUnit 5 ve JUnit 4 Arasındaki Farklar
### 2.1. Mimari
JUnit 4, tek bir jar dosyasında paketlenmiş her şeye sahiptir.
JUnit 5, JUnit Platform, JUnit Jupiter ve JUnit Vintage olmak üzere 3 alt projeden oluşmaktadır.
- JUnit Platformu: Platform üzerinde çalışan yeni test çerçeveleri geliştirmek için TestEngine API'sini tanımlar.
- JUnit Jupiter: Bu açıklamalarla yazılmış testleri çalıştırmak için tüm yeni JUnit açıklamalarına ve TestEngine uygulamasına sahiptir.
- JUnit Vintage: JUnit 5 platformunda JUnit 3 ve JUnit 4 yazılı testlerinin çalıştırılmasını destekler.
### 2.2. Gereken JDK Versiyonu
- Junit 4 için Java 5 ve üstü gerekir.
- Junit 5 için  Java 8  ve üstü gerekir.

### 2.3. Assertionlar
Junit 4'te, org.junit.Assert, beklenen ve ortaya çıkan sonuçları doğrulamak için tüm onaylama yöntemlerine sahiptir. Yöntem imzasında İLK argüman olarak hata mesajları için ekstra parametreleri kabul ederler. Örneğin:
```java
public static void assertEquals(long expected, long actual)
public static void assertEquals(String message, long expected, long actual)
```
JUnit 5'te, org.junit.jupiter.Assertions, ek assertThrows() ve assertAll() yöntemleri dahil, çoğu assert() yöntemini içerir. JUnit 5 onaylama yöntemleri ayrıca, testin başarısız olması durumunda yazdırılacak hata mesajlarının ayrıştırılmasını desteklemek için aşırı yüklenmiş yöntemlere sahiptir;

```java
public static void assertEquals(long expected, long actual)
public static void assertEquals(long expected, long actual, String message)
public static void assertEquals(long expected, long actual, Supplier messageSupplier)
```
### 2.4. Varsayımlar
Junit 4'te, org.junit.Assume, bir testin anlamlı olduğu koşullar hakkında varsayımları belirtmek için yöntemler içerir. Aşağıdaki beş yönteme sahiptir:
1. assumeFalse()
2. assumeNoException()
3. assumeNotNull()
4. assumeThat()
5. assumeTrue()

Junit 5' te, org.junit.jupiter.api.Assumptions, bir testin anlamlı olduğu koşullar hakkında varsayımları belirtmek için yöntemler içerir. Aşağıdaki üç yönteme sahiptir:
1. assumeFalse()
2. assumingThat()
3. assumeTrue()

### 2.5. Etiketleme ve Filtreleme

Junit 4'te @category ek açıklaması kullanılır.
Junit 5'te @tag ek açıklaması kullanılır.