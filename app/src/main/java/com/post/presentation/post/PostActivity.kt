package com.post.presentation.post

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.post.R
import com.post.di.repositories.DaggerRepositoryComponent
import com.post.data.responses.Post
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

    private lateinit var mSpacesItemDecoration: SpacesItemDecoration

    private lateinit var mLinearLayoutManager: LinearLayoutManager

    private lateinit var mPostAdapter: PostAdapter

    private val mPosts = ArrayList<Post>()

    override fun initComponent() {
        val mRepositoryComponent = DaggerRepositoryComponent.builder().build()
        DaggerPostComponent.builder()
                .repositoryComponent(mRepositoryComponent)
                .postModule(PostModule(this))
                .build().inject(this)
    }

    override fun initUI() {
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
        initComponent()
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
