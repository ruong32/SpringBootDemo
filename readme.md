# Hướng dẫn

## Cấu hình
SpringBootDemo/demo/src/main/resources/application.properties
```Java
server.port= /*server port*/
spring.datasource.url= /*database url*/
spring.datasource.username= /*database username*/
spring.datasource.password= /*database password*/
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver /*database driver*/
spring.jpa.hibernate.ddl-auto=update /*cách công vụ quản lý lược đồ chi phối lược đồ của database*/
```
## Danh sách API
|Api|Method|Data/parameter|
|:-|:-:|:-|
|/createUser|Post|Data: {"userName": string}| 
|/createPost|Post|Data: {"content": string, "poster": {"id": number}}|
|/like|Post|Data: {"user": {"id": number}, "postId": number}|
|/createComment|Post|Data: {"content": string, "user": {"id": number}, "postId": number}|
|/findUserByName|Get|Path parameter: string|
|/getUserById|Get|Path parameter: number|
|/getAllPostsOfUser|Get|Path parameter: number|
|/findPostByContent|Get|Path parameter: string|
|/findPostFromDate|Get|Query string parameters: date=string (format: yyyy-MM-dd)|
|/getAllLikesOfPost|Get|Path parameter: number|
|/getAllCommentOfPost|Get|Path parameter: number|
|/deleteUserById|Delete|Data: number|
|/deletePostById|Delete|Data: number|
|/unlike|Delete|Data: {"user": {"id": number}, "postId": number}|
|/deleteComment|Delete|Data: number|
