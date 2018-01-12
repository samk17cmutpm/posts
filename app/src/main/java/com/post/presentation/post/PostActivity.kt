package com.post.presentation.post

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.post.R
import com.post.di.DaggerRepositoryComponent
import com.post.entity.Post
import com.post.presentation.BaseActivity
import com.post.presentation.ui_helper.SpacesItemDecoration
import javax.inject.Inject

class PostActivity : BaseActivity(), PostContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var mPresenter: PostContract.Presenter

    @BindView(R.id.post_recycler_view)
    lateinit var mPostRecyclerView: RecyclerView

    @BindView(R.id.post_swipe_refresh_layout)
    lateinit var mPostSwipeRefreshLayout: SwipeRefreshLayout

    lateinit var mSpacesItemDecoration: SpacesItemDecoration

    lateinit var mLinearLayoutManager: LinearLayoutManager

    lateinit var mPostAdapter: PostAdapter

    val mPosts = ArrayList<Post>()

    override fun initDagger() {
        val mRepositoryComponent = DaggerRepositoryComponent.builder().build()
        DaggerPostComponent.builder().repositoryComponent(mRepositoryComponent).build().inject(this)
    }

    override fun initUI() {
        mPresenter.attachView(this)
        mPostSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        )
        mPostSwipeRefreshLayout.setOnRefreshListener(this)
        mSpacesItemDecoration = SpacesItemDecoration(10)
        mLinearLayoutManager = LinearLayoutManager(this)
        mPostAdapter = PostAdapter(mPosts)
        mPostRecyclerView.layoutManager = mLinearLayoutManager
        mPostRecyclerView.setHasFixedSize(true)
        mPostRecyclerView.addItemDecoration(mSpacesItemDecoration)
        mPostRecyclerView.adapter = mPostAdapter
    }

    override fun initData() {
        mPresenter.fetchPost()
    }

    override fun showPost(posts: List<Post>) {
        mPosts.clear()
        mPosts.addAll(posts)
        mPostAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        ButterKnife.bind(this)
        initDagger()
        initUI()
        initData()
    }

    override fun showIndicator(active: Boolean) {
        mPostSwipeRefreshLayout.isRefreshing = active
    }

    override fun onRefresh() {
        mPresenter.fetchPost()
    }
}
