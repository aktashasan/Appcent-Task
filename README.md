# Appcent-Task

Bu Backend projesi mongodb database'ini kullanmaktadır. Bu projesyi database'e veri yollamak için öncelikle IDE'den projeyi açmalısınız. 

Proje açıldıktan sonra kök klasördeki docker-compose.yaml dosyasını bulmalısınız. Bu dosya docker üzerinden sanal database oluşturmaktadır.
Bu dosyadaki SERVİCES'in yanındaki çift başlatma butonuna basmalısınız. Bu işlem database'inizi oluşturacak. Artık uygulamadan
veri gönderip çekebilirsiniz.

Eğer test fonksiyonlarını çalıştırmak istiyorsanız test klasöründeki user ve content klasörlerinin service ve resource sınıflarını içeren ayrı ayrı klasörler bulunmaktadır. bunları teker teker çalıştırabilirsiniz. 

Projeyi frontend'e bağlamak için controller sınıfı ile frontend'e bağlanabilir. ve uygulama ayağı kaldırılabilir.