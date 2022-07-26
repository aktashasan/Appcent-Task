
# To Do App

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
Ayrıca dockerize etmek için öncelikle projedeki dockerfile dosyasına sahip olduğunuzdan emin olun. Daha sonra yan tarafta bulunan maven sekmesinden proje klasörleri açılır. Orada bulunan lifecycle sekmesine tıklanır. Altında bulunan packages'a çift tıklanarak proje ".jar" a build edilir. Build işlemi bittikten sonra terminalden aşağıdaki komut çalıştırılır.

Proje dizininde iken

```bash
  docker build -t image-name .
```
ile build edilir.

```bash
  docker run --name spring-docker-cont -p 8080:8080 image-name -d
```
komutu ile docker üzerinde run edilir. 
## Container

Projeyi Docker ile pullayabilirsiniz

```bash
  docker pull hasanaktas/to_do_app_container
```
## API Kullanımı

#### Tüm öğeleri getir

```http
  Post /content/save
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `contentDTO` | `JSON` | **Body**. |

#### Öğeyi getir

```http
  GET /content/get/id/${id}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **id**. Çağrılacak öğenin anahtar değeri. |

```http
  GET /contents/get
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| contentDTO      | `List` | **contentDTO**. Çağrılacak öğelerin içerikleri |

```http
  DELETE /content/delete/${id}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **id**. Silinecek öğenin anahtar değeri. |

```http
  Post /content/update
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `contentDTO` | `JSON` | **Body**. |

  
