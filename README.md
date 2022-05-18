# Appcent-Task

Bu Backend projesi mongodb database'ini kullanmaktadır. Bu proje'de database'e veri yollamak için öncelikle IDE'den projeyi pullamalısınız. 

Proje açıldıktan sonra kök klasördeki docker-compose.yaml dosyasını bulmalısınız. Bu dosya docker üzerinden sanal database oluşturmaktadır.
Bu dosyayı services üzerinden run ettiğimiz zaman database'inizi oluşturacak. Artık uygulamayı ayağı kaldırabilirsiniz.

Eğer test fonksiyonlarını çalıştırmak istiyorsanız test klasöründeki user ve content klasörlerinin içindeki service ve resource sınıflarını içeren ayrı ayrı klasörler bulunmaktadır. Buradaki bütün fonksiyonları teker teker çalıştırabilirsiniz. 

Projeyi frontend'e bağlamak için controller sınıfı ile frontend'e bağlanabilir. ve uygulama ayağı kaldırılabilir.

Ayrıca aşağıdaki linkden projenin dockerize edilmiş halini bulabilirsiniz.

Ayrıca dockerize etmek için öncelikle projedeki dockerfile dosyasına sahip olduğunuzdan emin olun. Daha sonra yan tarafta bulunan maven sekmesinden proje klasörleri açılır. Orada bulunan lifecycle sekmesine tıklanır. Altında bulunan packages'a çift tıklanarak proje ".jar" a build edilir. 
Build işlemi bittikten sonra terminalden "docker build -t image-name ." komutunu çalıştırılır.
Bu komutu çalıştırdıktan sonra "docker run --name spring-docker-cont -p 8080:8080 image-name -d" komutu çalıştırılır ve konteyner'ınız docker da hazır olur.

(win 10)
Komut satırı açılır ve "docker login" komutu yazılarak docker'a login yapılır. images'lerimizi görmek için 'docker images' komutu ile bütün images'lerimiz görünür. Dockerhub'da yeni bir repository açıyoruz. "docker tag image-name dockerhub_username/repository-name" komutu çalışırarak yeni bir kopya image oluştururlur. 
"docker push dockerhub_username/repository-name" yazarak konteyner'ımızı pushluyoruz. Böylece dockerize işlemi tamamlanmış oluyor.
