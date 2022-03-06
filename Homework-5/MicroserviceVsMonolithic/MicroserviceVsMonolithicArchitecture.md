# Monolithic Mimari ve Microservice Mimari
##  Monolithic Mimari
Monolithic, geliştirilen uygulamanın tüm katmanlarını ve modüllerini tek bir proje içerisinde barındıran mimari şeklidir. Monolithic mimari içerisinde, authorization, presentation, business logic, data gibi katmanlar yer alabilir. Bir e-commerce uygulaması geliştirdiğinizi düşünün, en azından kullanıcı bilgilerini tuttuğunuz, login ettiğiniz, ürünleri listelettiğiniz ve ödeme aldığınız business ve data katmanınız vardır. Tüm bu modülleri, parçalamadan, aynı proje içerisinde sunan mimaridir.
### Monolotik Mimarinin Avantajları
- Daha kolay hata ayıklama ve uçtan uca test etme: Microservice mimarisinin aksine, monolitik uygulamaların hata ayıklaması ve test edilmesi çok daha kolaydır. Monolitik bir uygulama tek bir bölünmez proje olduğundan, uçtan uca testleri çok daha hızlı şekilde gerçekleştirebilirsiniz.
- Kolay deployment: Monolitik uygulamaların tek bir parça oluşu ile bağlantılı bir avantajı ise kolay dağıtımdır. Tek bir parçayı deploy etmek onlarca servisi deploy etmekten çok daha kolaydır.
- Görece geliştirmesi basittir. Monolitik bir uygulamayı genel prensiplere uyarak modüler bir biçimde yazmak, her bir modülü servis olarak yazmaktan çok daha kolaydır.

### Monolitik Mimarinin Dezavantajları

- - Karmaşıklık: Bir monolitik uygulama büyüdüğünde, anlaşılamayacak kadar karmaşık hale gelir. Ayrıca, bir uygulama içindeki karmaşık kod yapısını yönetmek zordur, ne kadar prensiplere uyuyor olsanız da kodun büyümesi karmaşıklığı her zaman artıracaktır.
- - Değişiklik yapma zorluğu: Bu kadar büyük ve karmaşık bir uygulamada değişiklik yapmak oldukça zahmetlidir. Herhangi bir kod değişikliği tüm sistemi etkiler, bu nedenle tamamen bütün parçaların kontrol edilmesi gerekir. Bu, genel geliştirme sürecini çok daha uzun hale getirebilir.
- - Ölçeklenebilirliği(Scaleable) düşük: Bileşenleri bağımsız olarak scale edemezsiniz. Tüm uygulamayı ölçeklemeniz gerekir.
- - Yeni teknoloji uygulayamamak: Monolitik bir uygulamada yeni bir teknolojinin uygulanması son derece problemlidir, uygulamayı yeni bir teknolojiye entegre etmek demek, tüm uygulama yeniden geliştirmek anlamına gelir. Yeniliklere adapte olamamak da birçok alandan kayba yol açabilir.

- ##  Microservice Mimari
- Microservice’ler, yalnızca tek bir işi gerçekleştirmekten sorumlu servislerdir. Birden fazla microservice’in birleşmesi ile oluşan yapıya Microservice Mimari adını veriyoruz. Az önce anlattığım Monolithic SOA’larda yaşanan çeşitli sorunları çözmek adına geliştirilmişlerdir. Buradaki amaç, uygulamayı parçalarına ayırıp, birbirleriyle fiziksel bağı olmayan minik uygulamacıklar oluşturmaktır. Oluşturulan bu uygulamacıkların derleme, test, deployment adımları da, DevOps yöntemleri uygulanarak otomatize edilir.

- ### Microservice Mimarinin Avantajları
- Bağımsız bileşenler:
  Her bir servis bağımsız bir şekilde dağıtılabilir ve güncellenebilir, bu da daha fazla esneklik sağlar.
  Bir microservice deki bir hatanın yalnızca belirli bir hizmet üzerinde etkisi vardır ve tüm uygulamayı etkilemez. Ayrıca, bir microservice uygulamasına yeni özellikler eklemek, monolitik olandan daha kolaydır.
- Anlaşılabilirlik. Daha küçük ve daha basit bileşenlere ayrılan bir microservice uygulamasının anlaşılması ve yönetilmesi daha kolaydır. Sadece sahip olduğu bir sorumluluk ile ilgili olan belirli bir hizmete odaklıdır.
- Daha iyi ölçeklenebilirlik: Her bir servis bağımsız olarak ölçeklendirilebilir. Bu nedenle tüm uygulamanın scale edilmesi gerekmez. Bu da zaman ve maliyet açısından büyük bir kazanç sağlar. Ek olarak, her monolitik uygulamanın ölçeklenebilirlik açısından sınırları vardır. Ancak microservice üzerinde trafik oluşan bir servisi çoklamak daha az zahmetli ve bütün yükü kaldırabilecek düzeydedir. Sırf bu yüzden büyük bir kullanıcı kitlesine hitap eden çoğu proje microservice mimarisini benimsemeye başlamıştır.
- Teknoloji Çeşitliliği: Ekipler servislerin geliştirileceği teknolojileri tamamen seçmek zorunda değildir, yani zamanla geliştirecekleri servislere uygun teknoloji seçebilirler. Örneğin Java üzerinde geliştirilen microservicelerin yanına “machine learning” özelliklerini kullanabilmek için python programlama dili ile bir servis geliştirilebilir. Her microservice için istenilen teknoloji ya da database kullanılabilir.
- Daha yüksek çeviklik seviyesi. Bir microservice uygulamasındaki herhangi bir hata, tüm uygulamayı değil yalnızca belirli bir servisi etkiler. Bu nedenle tüm değişiklikler ve testler daha düşük riskler ve daha az hata ile gerçekleştirilir.
- Yeniden kullanılabilirlik: Bağımsız olarak geliştirdiğiniz bir servisi ihtiyacınıza göre ufak değişiklikler ile başka bir projede de kullanılabilir. Örneğin “User Management” servisi neredeyse tüm uygulamalarda benzer sorumlulukları ve işlevi barındırır ve benzer görevleri gerçekleştirir. Bu servisi başka bir projenizde direkt olarak konumlandırabilir ve kullanılabilir. Böylece bir servis geliştirme zaman ve maliyetinden tasarruf edililebilir.

### Microservice Mimarinin Dezavantajları
- Ekstra ekstra karmaşıklık. Bir microservice mimarisi dağıtık bir sistem olduğundan, tüm modüller ve veritabanları için ayrı ayrı yapılandırma yapmanız gerekir. Ayrıca, böyle bir uygulama bağımsız hizmetler içerdiği sürece hepsinin bağımsız olarak dağıtılması gerekir.
- Sistem dağıtımı Bir microservice mimarisi, birden fazla servis ve veri tabanından oluşan karmaşık bir sistemdir, bu nedenle tüm bağlantıların dikkatle ele alınması gerekir. Deployment her servis için ayrı bir süreci gerektirir.
- Yönetim ve izlenebilirliğin zorluğu: Bir microservice uygulaması oluştururken birden fazla durumla ile ilgilenmeniz gerekecektir. Harici yapılandırmayı, metrikleri takip edebilme, health-check mekanizmaları ve microservicelerin yönetilebildiği ortamlar gerekir.
- Test etmenin zorluğu: Birbirinden bağımsız olarak konuşlandırılan çok sayıda servis test sürecini oldukça zorlaştırır.
