# TDD(Test Driven Development)
## Test Driven Development Nedir?
Test Driven Development (TDD), kodun ne yapacağını belirlemek ve doğrulamak için test senaryolarının geliştirildiği bir yazılım geliştirme yaklaşımıdır.
TDD yaklaşımının avantajları arasında daha hızlı geri bildirim, yüksek kabul oranı, daha düşük proje kapsamı ve gereğinden fazla mühendislik, müşteri odaklı ve yinelenen süreçler, modüler, esnek ve sürdürülebilir kodlar yer alır.

Test odaklı geliştirme, kodlama, test ve tasarımın birlikte çalıştığı bir programlama tarzını ifade eder.
Basit bir ifadeyle, önce her işlev için test senaryoları oluşturulur ve test edilir. Bu aşamada test başarısız olursa, testi geçmek ve kodu basit ve hatasız hale getirmek için yeniden kod yazılır.


## TDD vs Geleneksel Test
Test driven development yaklaşımı, kaynak kodunuzun doğrulayıcı düzeyde test edilmesini sağlar. Geleneksel testlerde ise başarılı bir test, bir veya daha fazla kusur bulur.

Test driven development, sisteminizin kendisi için tanımlanan gereksinimleri karşılamasını sağlayarak sisteminiz hakkında güveninizi geliştirmenize yardımcı olur.

Geleneksel testler, test senaryosu tasarımına daha fazla odaklanılır.

TDD’de geleneksel testlerden farklı olarak her kod satırı test edilme sürecinden geçer.

Hem geleneksel test hem de TDD, sistemin test edilmesinin önemine yol açar.

## Neden TDD(Test Driven Development-Test Güdümlü Geliştirme)?
1.  Geliştirici testleri hazırlarken, sistemin nasıl çalışması gerektiğini hayal etmek zorundadır. TDD ile sadece gerekli sınıflar ve metotlar oluşturulur. TDD, programcının “belki ilerde kullanılır, bu metodu eklemekte fayda var” tarzı düşünmesini engeller. Böylece TDD proje maliyetini düşürür, çünkü sadece gerekli sınıf ve metotlar için zaman harcanır.
2.  TDD ile test kapsama alanı (test coverage) geniş olur. Hemen hemen her satır kod test metotları tarafından çalıştırılır.
3.  Testler ile hatalar localize edilmiş olur.Böylece koda olan güven artar.(yan etkiler)
4.  Testler sistemin nasıl çalıştığını gösteren dokümantasyon olarak düşünülebilir. Programcılar testleri inceleyerek, sistemin nasıl çalıştığını çok kısa bir zaman içinde öğrenebilirler.
5.  TDD tarzı programlama programcının debugger ile hata arama zamanını kısaltır yada tamamen ortadan kaldırır.
6.  Design first mentalitesi kazandırır.
7.  Over-engineeringten(Aşırı mühendislik)kaçınmamızı sağlar.

## Test Driven Development Nasıl Gerçekleşir?
- **1. Oluşturulacak uygulamanın tasarımı yapılır.**
Tasarımla oluşturulacak tüm senaryolar belirlenir.Böylece teste fazla iş yükü bindirmeden yazmamız sağlanır.
- **2. Tasarıma göre testler yazılır.**
Test yazıldıktan sonra denenir.Burada testin doğal olarak başarısız olması beklenir.
- **3 .Testleri çalıştıracağımız kod blokları yazılır.**
Kod, testten fazlasını içermemesi gerekir. Burada asıl amaç testi geçmek değil, ihtiyacı karşılamaktır.
- **4. Kodlar test edilir.**
Test edilen kodun süreçleri bulunur.
