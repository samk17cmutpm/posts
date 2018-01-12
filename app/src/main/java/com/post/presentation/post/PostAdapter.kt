package com.post.presentation.post

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.post.R
import com.post.entity.Post

/**
 * Created by sam_nguyen on 1/12/18.
 */
class PostAdapter constructor(val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val context: Context = parent!!.context
        val inflater = LayoutInflater.from(context)
        val postItemView: View = inflater.inflate(R.layout.post_item, parent, false)
        val viewHolder: PostAdapter.ViewHolder = PostAdapter.ViewHolder(postItemView)
        return viewHolder
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val post = posts[position]
        holder.mPostTitle.text = post.title
        holder.mPostBody.text = post.body
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.post_title_text_view)
        lateinit var mPostTitle: TextView

        @BindView(R.id.post_body_text_view)
        lateinit var mPostBody: TextView

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}