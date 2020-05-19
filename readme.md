api:
- "/createUser", data: {"userName": "name"}
- "/createPost", data: {"content": "post's content", "poster": {"id": number}}
- "/like", data: {"user": {"id": number}, "postId": number}
- "/createComment", data:{"content": "comment's content", "user": {"id": number}, "postId": number}
- "/findUserByName/{searchData}"
- "/getUserById/{id}"
- "/getAllPostsOfUser/{userId}"
- "/findPostByContent/{findContent}"
- "/findPostFromDate?date={yyyy-MM-dd}"
- "/getAllLikesOfPost/{postId}"
- "/getAllCommentOfPost/{postId}"
- "/deleteUserById" , data: number
- "/deletePostById" , data: number
- "/unlike", data: {"user": {"id": number}, "postId": number}
- "/deleteComment", data: number