
# To Do App API

Bu proje bir to do app API'dir. projeyi clone'layıp ayağa kaldırarak kullanabilirsiniz.

Proje açıldıktan sonra kök klasördeki docker-compose.yaml dosyasını bulmalısınız. Bu dosya docker üzerinden sanal database oluşturmaktadır. Bu dosyayı services üzerinden run ettiğimiz zaman database'inizi oluşturacak. Artık uygulamayı ayağı kaldırabilirsiniz.
## Bilgisayarınızda Çalıştırın

Projeyi klonlayın

```bash
  git clone https://github.com/aktashasan/to_do_app_backend
```

Proje dizinine gidin

```bash
  cd to_do_app_backend
```

  
## Dockerize etmek
Dockerize etmek için öncelikle projedeki dockerfile dosyasına sahip olduğunuzdan emin olun. Daha sonra yan tarafta bulunan maven sekmesinden proje klasörleri açılır. Orada bulunan lifecycle sekmesine tıklanır. Altında bulunan packages'a çift tıklanarak proje ".jar" a build edilir. Bu işlem bittikten sonra terminalden aşağıdaki komut çalıştırılır.

Mongo database'i docker üzerinde run etmek için

```bash
  docker run --name mongo-server -p 27017:27017 -d mongo
```
çalıştırılır.

Proje dizininde iken

```bash
  docker build . -t to_do_app_api
```
ile build edilir.

```bash
  docker run --name to-do-app-api --link mongo-server:mongo-server -p 8080:8080 to_do_app_api
```
komutu ile docker üzerinde run edilir. 
## Container

Sadece projeyi alıp çalıştırmak istiyorsanız, Dockerhub hesabımdan pullayıp çalıştırmak için

Mongo kurulumu için
```bash
  docker run --name mongo-server -p 27017:27017 -d mongo
```

imajı pullamak için

```bash
  docker pull hasanaktas/to_do_app_container
```
Docker'da çalıştırmak için

```bash
  docker run --name to-do-app-api --link mongo-server:mongo-server -p 8080:8080 hasanaktas/to_do_app_container
```
komutları terminalde yazılır.

## API Kullanımı

#### Tüm öğeleri getir

```http
  Post /app/content/save
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `explanation` | `string` | **explanation**. |
| `title` | `string` | **title**. |
| `priority` | `string` | **priority**. |
| `ticket` | `string` | **ticket**. |

#### Öğeyi getir

```http
  GET /app/content/get/id/${id}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **id**. Çağrılacak öğenin anahtar değeri. |

```http
  GET /app/contents/get
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| contentDTO      | `List` | **contentDTO**. Çağrılacak öğelerin içerikleri |

```http
  DELETE /app/content/delete/${id}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **id**. Silinecek öğenin anahtar değeri. |

```http
  Post /app/content/update
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **content**. |
| `explanation` | `string` | **explanation**. |
| `title` | `string` | **title**. |
| `priority` | `string` | **priority**. |
| `ticket` | `string` | **ticket**. |
  
