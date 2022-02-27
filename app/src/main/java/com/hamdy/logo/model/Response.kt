package com.hamdy.logo.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("user_posts")
	val userPosts: List<UserPostsItem?>? = null
)

data class PostDetails(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("badge")
	val badge: String? = null,

	@field:SerializedName("post_title")
	val postTitle: String? = null,

	@field:SerializedName("sub_title")
	val subTitle: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("image_post")
	val imagePost: String? = null,

	@field:SerializedName("title_post")
	val titlePost: String? = null,

	@field:SerializedName("image_user")
	val imageUser: String? = null,

	@field:SerializedName("image_content")
	val imageContent: String? = null
)

data class UserPostsItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("like")
	val like: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("post_details")
	val postDetails: PostDetails? = null,

	@field:SerializedName("comment")
	val comment: String? = null,

	@field:SerializedName("share")
	val share: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: Int? = null,

	@field:SerializedName("share_from")
	val shareFrom: String? = null,

	@field:SerializedName("image_list_content")
	val imageListContent: List<String?>? = null,

	@field:SerializedName("badge")
	val badge: String? = null,

	@field:SerializedName("job")
	val job: String? = null,

	@field:SerializedName("comment_details")
	val commentDetails: CommentDetails? = null,

	@field:SerializedName("image_content")
	val imageContent: String? = null
)

data class CommentDetails(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("like")
	val like: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("comment")
	val comment: String? = null
)
